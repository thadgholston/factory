/**
 * File:Object.java Provides the interface to create objects used by various programs
 * wishing to use events and tracks and such, I don't know this is still in dev and will
 * most likely change a lot.  
 *   
 * @author Dustin Kempton
 * @version 05/14/2015 
 * @Owner Data Mining Lab, Georgia State University
 */
package edu.gsu.dmlab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sql.DataSource;

import edu.gsu.dmlab.databases.ImageDBConnection;
import edu.gsu.dmlab.databases.TrackingResultFileReader;
import edu.gsu.dmlab.databases.interfaces.IImageDBConnection;
import edu.gsu.dmlab.datatypes.interfaces.ITrack;
import edu.gsu.dmlab.exceptions.UnknownEventTypeException;
import edu.gsu.dmlab.imageproc.HistogramProducer;
import edu.gsu.dmlab.imageproc.interfaces.IHistogramProducer;
import edu.gsu.dmlab.util.TrapezoidPositionPredictor;
import edu.gsu.dmlab.util.interfaces.IPositionPredictor;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;

public class ObjectFactory {

	private static Configuration configuration = null;
	public static IImageDBConnection getImageDBConnection(DataSource dsourc,
														  int maxCacheSize) {
		IImageDBConnection dbConn = new ImageDBConnection(dsourc, maxCacheSize);
		return dbConn;
	}

	public static IHistogramProducer getHistoProducer(
			IImageDBConnection imageDB, int[] wavelengths) {
		return new HistogramProducer(imageDB, wavelengths);
	}

	public static ITrack[] getTrackedResults(String type, String fileLocation,
											 int span) throws FileNotFoundException, UnknownEventTypeException{
		TrackingResultFileReader reader = new TrackingResultFileReader(new BufferedReader(new FileReader(fileLocation))
				, span);

		try {
			return reader.getTracks(type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static IPositionPredictor getPositionPredictor(int typeId) {
		return new TrapezoidPositionPredictor();
	}

	public static Configuration getConfiguration() throws ConfigurationException{
		if (configuration == null)
			throw new ConfigurationException("Configuration not set");
		return configuration;
	}

	public static Configuration getConfiguration(String configFile){
		configuration = new BaseConfiguration();
		return configuration;
	}
}

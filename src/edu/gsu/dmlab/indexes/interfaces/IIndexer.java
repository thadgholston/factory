package edu.gsu.dmlab.indexes.interfaces;

import edu.gsu.dmlab.datatypes.EventType;
import edu.gsu.dmlab.datatypes.interfaces.IBaseDataType;
import edu.gsu.dmlab.geometry.Rectangle2D;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.ArrayList;

/**
 * Created by thad on 10/11/15.
 */
public interface IIndexer<T extends IBaseDataType> {
	    
    public DateTime getFirstTime();
    public DateTime getLastTime();
    public ArrayList<T> filterOnInterval(Interval timePeriod);
    public ArrayList<T> filterOnIntervalAndLocation(Interval timePeriod, Rectangle2D boundingBox);
    public ArrayList<T> getAll();
}

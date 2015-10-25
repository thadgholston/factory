package edu.gsu.dmlab.geometry;

import edu.gsu.dmlab.datatypes.interfaces.ITrack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by thad on 10/25/15.
 */
public class GeometryUtilities {

    public static edu.gsu.dmlab.geometry.Rectangle2D createBoundingBox(edu.gsu.dmlab.geometry.Point2D[] shape) {
        double xMin = Double.MIN_VALUE, xMax = Double.MIN_VALUE, yMin = Double.MIN_VALUE, yMax = Double.MIN_VALUE;
        edu.gsu.dmlab.geometry.Rectangle2D rectangle = new edu.gsu.dmlab.geometry.Rectangle2D();
        for (edu.gsu.dmlab.geometry.Point2D point: shape){
            rectangle.add(point);
        }
        return (edu.gsu.dmlab.geometry.Rectangle2D) rectangle.getBounds2D();
    }


    public static boolean isInsideSearchArea(edu.gsu.dmlab.geometry.Point2D queryPoint, edu.gsu.dmlab.geometry.Point2D[] searchArea){
        edu.gsu.dmlab.geometry.Rectangle2D rectangle = createBoundingBox(searchArea);
        return rectangle.contains(queryPoint);
    }

    public static edu.gsu.dmlab.geometry.Point2D[] getScaledSearchArea(Point2D[] area, int divisor){
        edu.gsu.dmlab.geometry.Point2D[] scaledSearchArea = new edu.gsu.dmlab.geometry.Point2D[area.size()];
        for(int index = 0; index < area.size(); index++){
            edu.gsu.dmlab.geometry.Point2D point = area.get(index);
            edu.gsu.dmlab.geometry.Point2D p = new edu.gsu.dmlab.geometry.Point2D(point.getX() / divisor, point.getY() / divisor);
            scaledSearchArea[index] = p;
        }
        return scaledSearchArea;
    }

    public static edu.gsu.dmlab.geometry.Point2D[] getScaledSearchArea(ITrack track, double divisor){
        edu.gsu.dmlab.geometry.Point2D[] startShape = track.getFirst().getShape();
        edu.gsu.dmlab.geometry.Point2D[] searchArea = new edu.gsu.dmlab.geometry.Point2D[startShape.length];
        for (int index = 0; index < startShape.length; index++){
            edu.gsu.dmlab.geometry.Point2D point = startShape[index];
            searchArea[index] = new edu.gsu.dmlab.geometry.Point2D(point.x / divisor, point.y / divisor);
        }
        return searchArea;
    }


    public static Circle2D getMiniumEnclosingCircle(edu.gsu.dmlab.geometry.Point2D[] area){
        //TODO: Implement getMiniumEnclosingCircle
        return null;
    }

    public static Rectangle2D getScaledBoundingBox(Rectangle2D boundingBox, double divisor) {
        double x, y, width, height;
        x = boundingBox.getMinX() / divisor;
        y = boundingBox.getMinY() / divisor;
        width = boundingBox.getWidth() / divisor;
        height = boundingBox.getHeight() / divisor;
        Rectangle2D scaledBoundBox = new Rectangle2D();
        scaledBoundBox.setFrame(x, y, width, height);
        return scaledBoundBox;
    }

    public static Rectangle2D getScaledBoundingBox(Point2D[] searchArea, double divisor) {
        Rectangle2D scaledBoundBox = new Rectangle2D();
        Arrays.asList(searchArea).parallelStream().forEach(point2D -> {
            scaledBoundBox.add(point2D.getX() / divisor, point2D.getY() / divisor);
        });
        return scaledBoundBox;
    }
}

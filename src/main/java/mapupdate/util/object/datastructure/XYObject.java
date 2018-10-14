package mapupdate.util.object.datastructure;

import mapupdate.util.object.SpatialInterface;
import mapupdate.util.object.spatialobject.Point;
import mapupdate.util.object.spatialobject.SpatialObject;

import java.util.Comparator;

/**
 * An immutable container for a simpler representation of
 * any spatial object as a 2D (x,y) coordinate point.
 * This object is mainly useful for indexing and query purposes.
 *
 * @param <T> Type of spatial object in this container.
 * @author uqdalves
 */
@SuppressWarnings("serial")
public final class XYObject<T extends SpatialObject> implements SpatialInterface {
    /**
     * Object (x,y) coordinates
     */
    private final double x, y;
    /**
     * The spatial object in this container
     */
    private final T spatialObject;

    /**
     * Creates a immutable container for a simpler representation of
     * a spatial object as a 2D (x,y) coordinate point.
     *
     * @param x          The X coordinate representing this object.
     * @param y          The Y coordinate representing this object.
     * @param spatialObj The spatial object to wrap up in this container.
     */
    public XYObject(double x, double y, T spatialObj) {
        this.x = x;
        this.y = y;
        this.spatialObject = spatialObj;
    }

    /**
     * Creates a immutable container for a simpler representation of
     * a spatial object as a 2D (x,y) coordinate point.
     *
     * @param x The X coordinate representing this object.
     * @param y The Y coordinate representing this object.
     */
    public XYObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.spatialObject = null;
    }

    /**
     * @return The X coordinate representing this object.
     */
    public double x() {
        return x;
    }

    /**
     * @return The Y coordinate representing this object.
     */
    public double y() {
        return y;
    }

    /**
     * @return The spatial object in this container.
     */
    public T getSpatialObject() {
        return spatialObject;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Check whether these two spatial objects have the same
     * (x,y) spatial coordinates.
     *
     * @param obj The spatial object to compare.
     * @return True if these two spatial objects have the
     * same spatial coordinates.
     */
    public boolean equals2D(XYObject<T> obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return (x == obj.x && y == obj.y);
    }

    @Override
    public String toString() {
        String s = String.format("%.5f %.5f", x, y);
        return s;
    }

    /**
     * Print this XYObject to the system output.
     */
    public void print() {
        System.out.println("XYOBJECT ( " + toString() + " )");
    }

    /**
     * @return The 2D point representation of the spatial object
     * in this container.
     */
    public Point toPoint() {
        return new Point(x, y);
    }

    /**
     * Comparator to compare XYObjects by their X value.
     */
    @SuppressWarnings("rawtypes")
    public static final Comparator<XYObject> X_COMPARATOR =
            new Comparator<XYObject>() {
                @Override
                public int compare(XYObject o1, XYObject o2) {
                    if (o1.x < o2.x)
                        return -1;
                    if (o1.x > o2.x)
                        return 1;
                    return 0;
                }
            };

    /**
     * Comparator to compare XYObjects by their Y value.
     */
    @SuppressWarnings("rawtypes")
    public static final Comparator<XYObject> Y_COMPARATOR =
            new Comparator<XYObject>() {
                @Override
                public int compare(XYObject o1, XYObject o2) {
                    if (o1.y < o2.y)
                        return -1;
                    if (o1.y > o2.y)
                        return 1;
                    return 0;
                }
            };
}
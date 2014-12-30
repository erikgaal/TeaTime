package me.erikgaal.teatime.geometry;
// TODO: Add more documentation

/**
 * The class Vector3d holds a 3-tuple double and implements common algebraic operations.
 */
public class Vector3d {
    public double x, y, z;

    public Vector3d() {
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Vector3d v) {
        set(v.x, v.y, v.z);
    }

    public void translate(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void translate(Vector3d v) {
        translate(v.x, v.y, v.z);
    }

    /**
     * Returns the addition of two three-dimensional vectors.
     * @param a the first component
     * @param b the second component
     * @return the vector A + B
     */
    public static Vector3d add(Vector3d a, Vector3d b) {
        return new Vector3d(
                a.x + b.x,
                a.y + b.y,
                a.z + b.z);
    }

    /**
     * Returns the subtraction of two three-dimensional vectors.
     * @param a the first component
     * @param b the second component
     * @return the vector A - B
     */
    public static Vector3d subtract(Vector3d a, Vector3d b) {
        return new Vector3d(
                a.x - b.x,
                a.y - b.y,
                a.z - b.z);
    }

    /**
     * Returns the dot product of two three-dimensional vectors.
     * @param a the first component
     * @param b the second component
     * @return the vector A . B
     */
    public static Vector3d dot(Vector3d a, Vector3d b) {
        return new Vector3d(
                a.x * b.x,
                a.y * b.y,
                a.z * b.z);
    }

    /**
     * Returns the cross product of two three-dimensional vectors.
     * @param a the first component
     * @param b the second component
     * @return the vector A * B
     */
    public static Vector3d cross(Vector3d a, Vector3d b) {
        return new Vector3d(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    /**
     * Returns a text representation of the <code>Vector3d</code>.
     */
    public String toString() {
        return "Vector3d[" + x + ", " + y + ", " + z + "]";
    }
}

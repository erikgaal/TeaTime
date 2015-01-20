package me.erikgaal.teatime.geometry;
// TODO: Add more documentation

/**
 * The class Vector3d holds a 3-tuple double and implements common algebraic operations.
 */
public class Vector3f {
    public float x, y, z;

    public Vector3f() {
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Vector3f v) {
        set(v.x, v.y, v.z);
    }

    public void translate(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void translate(Vector3f v) {
        translate(v.x, v.y, v.z);
    }

    /**
     * Returns the addition of two three-dimensional vectors.
     * @param a the first component
     * @param b the second component
     * @return the vector A + B
     */
    public static Vector3f add(Vector3f a, Vector3f b) {
        return new Vector3f(
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
    public static Vector3f subtract(Vector3f a, Vector3f b) {
        return new Vector3f(
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
    public static Vector3f dot(Vector3f a, Vector3f b) {
        return new Vector3f(
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
    public static Vector3f cross(Vector3f a, Vector3f b) {
        return new Vector3f(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    /**
     * Returns a text representation of the <code>Vector3f</code>.
     */
    public String toString() {
        return "Vector3f[" + x + ", " + y + ", " + z + "]";
    }
}

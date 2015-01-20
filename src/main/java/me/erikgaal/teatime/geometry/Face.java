package me.erikgaal.teatime.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Face {
    // Either store the index of the vertices
    private Vector3f[] vertices = {
            new Vector3f(),
            new Vector3f(),
            new Vector3f()
    };

    public Face(Vector3f[] vertices) {
        this.vertices = vertices;
    }

    public Vector3f[] getVertices() {
        return vertices;
    }

    public String toString() {
        return Arrays.toString(vertices);
    }
}

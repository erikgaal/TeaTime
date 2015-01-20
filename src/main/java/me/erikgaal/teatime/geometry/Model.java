package me.erikgaal.teatime.geometry;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

// TODO: Needs a lot of fixing
public class Model {
    private final FloatBuffer vertices;

    public Model() {
        this.vertices = BufferUtils.createFloatBuffer(9);
    }

    public FloatBuffer getVertices() {
        return vertices;
    }
}

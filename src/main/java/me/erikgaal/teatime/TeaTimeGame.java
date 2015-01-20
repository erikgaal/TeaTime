package me.erikgaal.teatime;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

// TODO: Might need abstraction?
public class TeaTimeGame {

    private long window;

    private void init() {
        if (glfwInit() != GL_TRUE) throw new IllegalStateException("");

        glfwDefaultWindowHints();

        window = glfwCreateWindow(640, 480, "Hello World", GL_NONE, GL_NONE);

        glfwShowWindow(window);
    }

    public void start() {
        init();
    }
}
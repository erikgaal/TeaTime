package me.erikgaal.teatime.geometry;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Needs completion and fixing
public class ModelLoader {

    public static Model loadModel(String resource) throws IOException {
        URL file = ModelLoader.class.getClassLoader().getResource(resource);
        if (file == null) throw new FileNotFoundException();
        BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));

        List<Float> vertices = new ArrayList<>();
        List<Integer> faces = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            switch (line.split(" ")[0]) {
                case "#":
                    // do nothing
                    break;
                case "v":
                    vertices.addAll(Arrays.asList(parseVertex(line)));
                    break;
                case "f":
                    // model.getFaces().add(parseFace(line));
                    break;
                case "o":
                    // process object
                    break;
                case "s":
                    // process shader
                    break;
                default:
                    throw new RuntimeException("Cannot parse line: " + line);
            }
        }
        Model model = new Model();
        return model;
    }

    private static Float[] parseVertex(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 4) {
            return new Float[]{
                    Float.parseFloat(parts[1]),
                    Float.parseFloat(parts[2]),
                    Float.parseFloat(parts[3])
            };
        }
        throw new RuntimeException();
    }

    private static Integer[] parseFace(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 4) {
            return null;
        }
        throw new RuntimeException();
    }
}

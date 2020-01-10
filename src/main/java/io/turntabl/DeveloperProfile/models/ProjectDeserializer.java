package io.turntabl.DeveloperProfile.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ProjectDeserializer extends JsonDeserializer<Project> {
    @Override
    public Project deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        System.out.println("ok");
        return p.readValueAs(Project.class);
    }
}

package com.example.ellin.webdemo;

import io.micrometer.core.instrument.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.actuate.metrics.web.servlet.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;
import java.util.*;
@Component
public class DemoMVCTagProvider implements WebMvcTagsProvider {

    @Value("${service.color:plain}")
    String color;

    @Override
    public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response, Object handler, Throwable exception) {

        return Collections.singletonList(new ImmutableTag("color",color));
    }

    @Override
    public Iterable<Tag> getLongRequestTags(HttpServletRequest request, Object handler) {
        return null;
    }
}

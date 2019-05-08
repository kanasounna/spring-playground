package com.example.springplayground.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class VolumeController {
    @PostMapping("/math/volume/{length}/{width}/{height}")
    public String volume(@PathVariable int length, @PathVariable int width, @PathVariable int height){
        return "The volume of a "+length+"x"+width+"x"+height+" rectangle is "+(length*width*height);
    }
    @PatchMapping("/math/volume/{length}/{width}/{height}")
    public String volumePatch(@PathVariable int length, @PathVariable int width, @PathVariable int height){
        return "The volume of a "+length+"x"+width+"x"+height+" rectangle is "+(length*width*height);
    }
}

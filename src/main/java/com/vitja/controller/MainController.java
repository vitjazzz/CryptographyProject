package com.vitja.controller;

import com.vitja.method.CaesarMethod;
import com.vitja.method.TrithemiusMethod;
import com.vitja.method.VigenereMethod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Viktor on 02.10.2016.
 */
@Controller
public class MainController {
    private final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("methods/index");

        return modelAndView;
    }

    @RequestMapping(value = "/caesarEncode", method = RequestMethod.GET)
    public ModelAndView caesarEncode(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("methods/caesarEncode");
        modelAndView.addObject("encodeForm", new CaesarMethod());

        return modelAndView;
    }

    @RequestMapping(value = "/caesarDecode", method = RequestMethod.GET)
    public ModelAndView caesarDecode(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("methods/caesarDecode");
        modelAndView.addObject("decodeForm", new CaesarMethod());

        return modelAndView;
    }

    @RequestMapping(value = "/caesarEncode", method = RequestMethod.POST)
    public ModelAndView caesarEncodePost(@ModelAttribute("encodeForm")CaesarMethod caesarMethod,
                                            ModelAndView modelAndView){


        modelAndView.addObject("encodeResult", caesarMethod.getDecodeMessage());
        modelAndView.setViewName("methods/caesarEncode");

        return modelAndView;
    }

    @RequestMapping(value = "/caesarDecode", method = RequestMethod.POST)
    public ModelAndView caesarDecodePost(@ModelAttribute("decodeForm")CaesarMethod caesarMethod,
                                            ModelAndView modelAndView){


        modelAndView.addObject("decodeResult", caesarMethod.getEncodeMessage());
        modelAndView.setViewName("methods/caesarDecode");

        return modelAndView;
    }

    @RequestMapping(value = "/trithemiusEncode", method = RequestMethod.GET)
    public  ModelAndView trithemiusEncode(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("methods/trithemiusEncode");
        modelAndView.addObject("encodeForm", new TrithemiusMethod());

        return modelAndView;
    }

    @RequestMapping(value = "/trithemiusDecode", method = RequestMethod.GET)
    public ModelAndView trithemiusDecode(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("methods/trithemiusDecode");
        modelAndView.addObject("decodeForm", new TrithemiusMethod());

        return modelAndView;
    }

    @RequestMapping(value = "/trithemiusEncode", method = RequestMethod.POST)
    public ModelAndView trithemiusEncodePost(@ModelAttribute("encodeForm") TrithemiusMethod trithemiusMethod,
                                             ModelAndView modelAndView){
        modelAndView.setViewName("methods/trithemiusEncode");
        modelAndView.addObject("encodeResult", trithemiusMethod.getEncodedMessage());

        return modelAndView;
    }

    @RequestMapping(value = "/trithemiusDecode", method = RequestMethod.POST)
    public ModelAndView trithemiusDecode(@ModelAttribute("decodeForm") TrithemiusMethod trithemiusMethod,
                                         ModelAndView modelAndView){
        modelAndView.addObject("decodeResult", trithemiusMethod.getDecodedMessage());
        modelAndView.setViewName("methods/trithemiusDecode");

        return modelAndView;
    }

    @RequestMapping(value = "/vigenereEncode", method = RequestMethod.GET)
    public ModelAndView vigenereEncode(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("encodeForm", new VigenereMethod());
        modelAndView.setViewName("methods/vigenereEncode");

        return modelAndView;
    }

    @RequestMapping(value = "/vigenereDecode", method = RequestMethod.GET)
    public ModelAndView vigenereDecode(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("decodeForm", new VigenereMethod());
        modelAndView.setViewName("methods/vigenereDecode");

        return modelAndView;
    }

    @RequestMapping(value = "/vigenereEncode", method = RequestMethod.POST)
    public ModelAndView vigenereEncodePost(@ModelAttribute("encodeForm") VigenereMethod vigenereMethod,
                                           ModelAndView modelAndView){
        modelAndView.setViewName("methods/vigenereEncode");
        modelAndView.addObject("encodeResult", vigenereMethod.getEncodedMessage());

        return modelAndView;
    }

    @RequestMapping(value = "/vigenereDecode", method = RequestMethod.POST)
    public ModelAndView vigenereDecodePost(@ModelAttribute("decodeForm") VigenereMethod vigenereMethod,
                                           ModelAndView modelAndView){
        modelAndView.setViewName("methods/vigenereDecode");
        modelAndView.addObject("decodeResult", vigenereMethod.getDecodedMessage());

        return modelAndView;
    }
}

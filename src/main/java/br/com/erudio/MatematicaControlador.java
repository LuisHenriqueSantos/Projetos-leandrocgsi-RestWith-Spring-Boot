package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MatematicaControlador {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber){
        // TODO Auto-generated method stub
        if (strNumber == null) return 0D;
        // BR = 10,25 EUA = US 10.25
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(strNumber)) return Double.parseDouble(strNumber);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        // TODO Auto-generated method stub
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}


//	@RequestMapping("/greeting")
//	public Greeting greeting(
//			@RequestParam(value = "name", defaultValue = "World")
//			String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}


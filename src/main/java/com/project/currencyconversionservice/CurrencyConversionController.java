package com.project.currencyconversionservice;

import com.project.currencyconversionservice.feignClient.CurrencyExchangeFeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class CurrencyConversionController {

    Logger logger = Logger.getLogger(CurrencyConversionController.class.getName());
    @Autowired
    CurrencyExchangeFeignProxy exchangeFeignProxy;
    @GetMapping("/currency/convert/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionBean getConversion(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("amount") int amount){
        Map uriVariables= new HashMap();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> template= new RestTemplate().getForEntity("http://localhost:8000/currency/rate/from/{from}/to/{to}",CurrencyConversionBean.class,uriVariables);
        CurrencyConversionBean bean =template.getBody();
        bean.setAmount(amount);
        bean.setConversionValue(bean.getConversionRate().multiply(BigDecimal.valueOf(bean.getAmount())));
        return bean;
    }

    @GetMapping("/currency/convert-feign/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionBean getConversionWithFeign(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("amount") int amount) {
        CurrencyConversionBean bean = exchangeFeignProxy.getRate(from,to);
        bean.setAmount(amount);
        logger.info("check sleuth conversion service");
        bean.setConversionValue(bean.getConversionRate().multiply(BigDecimal.valueOf(bean.getAmount())));
        return bean;
    }
}

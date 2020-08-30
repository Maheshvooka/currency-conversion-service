package com.project.currencyconversionservice.feignClient;

import com.project.currencyconversionservice.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
// or
@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeFeignProxy {
    @GetMapping("/currency-exchange-service/currency/rate/from/{from}/to/{to}")
    public CurrencyConversionBean getRate(@PathVariable("from") String from, @PathVariable("to") String to);
}
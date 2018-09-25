package com.shekhargulati.app.hyperon.demo.motor.api;

import com.shekhargulati.app.hyperon.demo.motor.api.dto.DictionaryEntryDto;
import com.shekhargulati.app.hyperon.demo.motor.converter.DictionaryEntryConverter;
import com.shekhargulati.app.hyperon.demo.motor.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionaries")
public class DictionaryApi {

    private final DictionaryService dictionaryService;

    private final DictionaryEntryConverter dictionaryEntryConverter;

    @Autowired
    public DictionaryApi(DictionaryService dictionaryService, DictionaryEntryConverter dictionaryEntryConverter) {
        this.dictionaryService = dictionaryService;
        this.dictionaryEntryConverter = dictionaryEntryConverter;
    }

    @GetMapping(path = "/make")
    public List<DictionaryEntryDto> getMakeDictionary(@RequestParam("productionYear") Integer productionYear) {
        return dictionaryEntryConverter.convertList(dictionaryService.getMakeDictionary(productionYear));
    }

    @GetMapping(path = "/model")
    public List<DictionaryEntryDto> getModelDictionary(@RequestParam("typeId") Integer typeId) {
        return dictionaryEntryConverter.convertList(dictionaryService.getModelDictionary(typeId));
    }

    @GetMapping(path = "/productionYear")
    public List<DictionaryEntryDto> getProductionYearDictionary() {
        return dictionaryEntryConverter.convertList(dictionaryService.getProductionYearDictionary());
    }

    @GetMapping(path = "/type")
    public List<DictionaryEntryDto> getTypeDictionary(@RequestParam("makeId") Integer makeId) {
        return dictionaryEntryConverter.convertList(dictionaryService.getTypeDictionary(makeId));
    }
}
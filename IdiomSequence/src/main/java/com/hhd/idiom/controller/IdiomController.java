package com.hhd.idiom.controller;

import com.hhd.idiom.bean.Idiom;
import com.hhd.idiom.service.IdiomExcelService;
import com.hhd.idiom.service.IdiomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huhengda on 2021/3/3.
 */
@RestController
@RequestMapping("idiom")
public class IdiomController {

    @Resource
    private IdiomService idiomService;
    @Resource
    private IdiomExcelService idiomExcelService;

    @GetMapping("getList")
    public List<Idiom> getList(@Param("pinyin") String pinyin) {
        Idiom idiom = new Idiom();
        idiom.setPinyinFirstWord(pinyin);
        return idiomService.getList(idiom);
    }

    @GetMapping("getExcelList")
    public List<Idiom> getExcelList(@Param("pinyin") String pinyin) {
        Idiom idiom = new Idiom();
        idiom.setPinyinFirstWord(pinyin);
        return idiomExcelService.getList(idiom);
    }

    // TODO 实时语音识别

}

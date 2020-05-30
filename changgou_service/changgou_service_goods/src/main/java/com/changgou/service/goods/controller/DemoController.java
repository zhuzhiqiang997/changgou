package com.changgou.service.goods.controller;

import com.changgou.common.pojo.PageResult;
import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 演示类
 *
 * @Author zhuzhiqiang
 * @Date 2020/5/30 11:24 下午
 */
@RequestMapping("/demo")
@RestController  //@controller,@responseBody
public class DemoController {


    @Autowired
    private BrandService brandService;

    /**
     * 所有品牌列表
     *
     * @return
     */
    @GetMapping
    public Result<List<Brand>> findList() {
        List<Brand> brandList = brandService.findList();
        return new Result<>(true, StatusCode.OK, "查询成功", brandList);
    }

    /**
     * 获取指定品牌
     *
     * @param id 品牌id
     * @return
     */
    @GetMapping
    public Result<Brand> findById(@RequestParam(value = "id", required = true, defaultValue = "123") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", brand);
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改指定品牌
     *
     * @param brand 品牌信息
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Brand brand) {
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除指定品牌
     *
     * @param id 品牌id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delById(@RequestHeader(value = "Authorization", defaultValue = "")
                          @PathVariable(value = "id") Integer id) {
        brandService.delById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 分页查询品牌列表
     *
     * @param page 页数
     * @param size 条数
     * @return
     * @undone
     */
    @GetMapping("/search")
    public Result findPage(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Page<Brand> pageInfo = brandService.findPage(page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(), pageInfo.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

}

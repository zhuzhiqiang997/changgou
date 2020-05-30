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
import java.util.Map;

/**
 * 商品品牌
 *
 * @Author zhuzhiqiang
 * @Date 2020/5/30 10:31 下午
 */
@RequestMapping("/brand")
@RestController
public class BrandController {

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
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", brand);
    }

    /**
     * 新增品牌
     *
     * @param brand 品牌信息
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
     * @param brand 品牌id
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
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
    public Result delById(@PathVariable("id") Integer id) {
        brandService.delById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询特定品牌列表
     *
     * @param searchMap 搜索条件
     * @return
     */
    @GetMapping("/search")
    public Result<List<Brand>> search(@RequestParam Map searchMap) {
        List<Brand> list = brandService.list(searchMap);
        return new Result<>(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 分页查询品牌列表
     *
     * @param page 页数
     * @param size 条数
     * @return
     */
    @GetMapping("/search/{page}/{size}")
    public Result findPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Brand> pageInfo = brandService.findPage(page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(), pageInfo.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 分页查询品牌列表
     *
     * @param searchMap
     * @param page      页数
     * @param size      条数
     * @return
     */
    @GetMapping("/searchPage/{page}/{size}")
    public Result findPage(@RequestParam Map searchMap, @PathVariable("page") int page, @PathVariable("size") int size) {
        int i = 1 / 0;
        Page pageInfo = brandService.findPage(searchMap, page, size);
        PageResult pageResult = new PageResult(pageInfo.getTotal(), pageInfo.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }
}

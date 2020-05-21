package com.changgou.common.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

    //当前默认为第一页
    public static final Integer pageNum = 1;
    //默认每页显示条件
    public static final Integer pageSize = 20;

    //判断当前页是否为空或是小于1
    public static Integer cpn(Integer pageNum) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        return pageNum;
    }

    // 页数（第几页）
    private long currentpage;

    // 查询数据库里面对应的数据有多少条
    private long total;// 从数据库查处的总记录数

    // 每页查5条
    private int size;

    // 下页
    private int next;

    private List<T> list;

    // 最后一页
    private int last;

    private int lpage;

    private int rpage;

    //从哪条开始查
    private long start;

    //全局偏移量
    public int offsize = 2;

    public Page() {
        super();
    }

    public void setCurrentpage(long currentpage, long total, long pagesize) {
        //可以整除的情况下
        long pagecount = total / pagesize;

        //如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = (int) (total % pagesize == 0 ? total / pagesize : (total / pagesize) + 1);

        //总页数
        this.last = totalPages;

        //判断当前页是否越界,如果越界，我们就查最后一页
        if (currentpage > totalPages) {
            this.currentpage = totalPages;
        } else {
            this.currentpage = currentpage;
        }

        //计算start
        this.start = (this.currentpage) * pagesize;
    }

    //上一页
    public long getUpper() {
        return currentpage > 1 ? currentpage - 1 : currentpage;
    }
}

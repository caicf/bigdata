package com.bigdata.caicf.utils;

/**
 * XPath路径包
 * Created by caicf on 2016/6/16.
 */
public class TencentXPathUtil {

    /**
     * 面包屑导航XPath
     */
    public static String breadcrumbXPath="/html/body/div[2]/div[1]/div[1]";

    /**
     * 电影名XPath
     */
    public static String movieNameXPath="//*[@id=\"h1_title\"]";

    /**
     * 评论数量XPath
     */
    public static String commentXPath="//*[@id=\"commentnum\"]";

    /**
     *   播放次数XPath
     */
    public static String playtimesXPath="//*[@id=\"act_playnum\"]";

    /**
     * 标签XPath
     */
    public static String tagsXPath="//*[@id=\"mod_descContent\"]/ul/li[1]/div";

    /**
     * 导演XPath
     */
    public static String directorXPath="//*[@id=\"mod_descContent\"]/ul/li[2]/div";

    /**
     * 主演XPath
     */
    public static String starringXPath="//*[@id=\"mod_descContent\"]/ul/li[3]/div";

    /**
     * 详细XPath
     */
    public static String detailXPath="//*[@id=\"btn_desc_expand\"]/span";

    /**
     * /简介XPath
     */
    public static String summaryfullXPath="//*[@id=\"mod_desc\"]/p[2]";
}

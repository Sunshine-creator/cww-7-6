package com.bit.java_image_server.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ImageDaoTest {
    @Before
    public void before(){
        System.out.println("-------before-------");
    }

    @After
    public void after(){
        System.out.println("-------after-------");
    }

    @Ignore
    @Test
    public void insert() {
        ImageDao  imageDao = new ImageDao();
        //准备数据
        Image image =new Image();
        image.setImageName("test.png");
        image.setUploadTime("20-06-20 08:36:16");
        image.setPath("C:\\Users\\18591\\image1\\photo\\9534b5588b8720c250c63b4c55d6fe87");
        image.setContentType("image/png");
        image.setMd5("9534b5588b8720c250c63b4c55d6fe87");
        image.setSize(1024);
        boolean flag = imageDao.insert(image);
        System.out.println("result="+flag);
    }

    @Test
    public void selectAll() {
        ImageDao  imageDao = new ImageDao();
        ArrayList<Image> lists = imageDao.selectAll();
        System.out.println("size = "+lists.size());
        System.out.println();
        for (Image image: lists) {
            System.out.println("name = "+image.getImageName());
        }

    }

    @Test
    public void selectOne() {
        ImageDao imageDao = new ImageDao();
        Image  image = imageDao.selectOne(2100);

        System.out.println(image.getImageName());
        System.out.println(image.getImageId());
        System.out.println(image.getMd5());
        System.out.println(image.getPath());
    }

    @Test
    public void delete() {
        ImageDao imageDao=new ImageDao();
        boolean flag=imageDao.delete(2092);
        System.out.println("flag = "+flag);

    }

    @Test
    public void selectByMD5() {
        ImageDao imageDao=new ImageDao();
        String md5="9534b5588b8720c250c63b4c55d6fe87";
        Image image = imageDao.selectByMD5(md5);
        System.out.println("name = "+image.getImageName());

    }
}
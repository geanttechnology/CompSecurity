// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;

import java.util.ArrayList;

public class FunModel
{

    private String cat;
    private String create_time;
    public ArrayList funlist;
    private int has_next_page;
    private int img_count;
    private String img_src;
    private String like_count;
    private boolean likenum;
    private String save;
    private String serial;
    private String share_count;
    private String thu_path;
    private String title;
    private String video_src;

    public FunModel()
    {
        likenum = false;
    }

    public String getCat()
    {
        return cat;
    }

    public String getCreate_time()
    {
        return create_time;
    }

    public ArrayList getFunlist()
    {
        return funlist;
    }

    public int getHas_next_page()
    {
        return has_next_page;
    }

    public int getImg_count()
    {
        return img_count;
    }

    public String getImg_src()
    {
        return img_src;
    }

    public String getLike_count()
    {
        return like_count;
    }

    public String getSave()
    {
        return save;
    }

    public String getSerial()
    {
        return serial;
    }

    public String getShare_count()
    {
        return share_count;
    }

    public String getThu_path()
    {
        return thu_path;
    }

    public String getTitle()
    {
        return title;
    }

    public String getVideo_src()
    {
        return video_src;
    }

    public boolean isLikenum()
    {
        return likenum;
    }

    public void setCat(String s)
    {
        cat = s;
    }

    public void setCreate_time(String s)
    {
        create_time = s;
    }

    public void setFunlist(ArrayList arraylist)
    {
        funlist = arraylist;
    }

    public void setHas_next_page(int i)
    {
        has_next_page = i;
    }

    public void setImg_count(int i)
    {
        img_count = i;
    }

    public void setImg_src(String s)
    {
        img_src = s;
    }

    public void setLike_count(String s)
    {
        like_count = s;
    }

    public void setLikenum(boolean flag)
    {
        likenum = flag;
    }

    public void setSave(String s)
    {
        save = s;
    }

    public void setSerial(String s)
    {
        serial = s;
    }

    public void setShare_count(String s)
    {
        share_count = s;
    }

    public void setThu_path(String s)
    {
        thu_path = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setVideo_src(String s)
    {
        video_src = s;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;

import java.io.Serializable;

public class MiniGameModel
    implements Serializable
{

    private String create_time;
    private String detail;
    private String hits;
    private String icon;
    private String is_safe;
    private String last_play_time;
    private int next;
    private String play_url;
    private String proc;
    private String serial;
    private String short_desc;
    private String sound;
    private String title;

    public MiniGameModel()
    {
    }

    public String getCreate_time()
    {
        return create_time;
    }

    public String getDetail()
    {
        return detail;
    }

    public String getHits()
    {
        return hits;
    }

    public String getIcon()
    {
        return icon;
    }

    public String getIs_safe()
    {
        return is_safe;
    }

    public String getLast_play_time()
    {
        return last_play_time;
    }

    public int getNext()
    {
        return next;
    }

    public String getPlay_url()
    {
        return play_url;
    }

    public String getProc()
    {
        return proc;
    }

    public String getSerial()
    {
        return serial;
    }

    public String getShort_desc()
    {
        return short_desc;
    }

    public String getSound()
    {
        return sound;
    }

    public String getTitle()
    {
        return title;
    }

    public void setCreate_time(String s)
    {
        create_time = s;
    }

    public void setDetail(String s)
    {
        detail = s;
    }

    public void setHits(String s)
    {
        hits = s;
    }

    public void setIcon(String s)
    {
        icon = s;
    }

    public void setIs_safe(String s)
    {
        is_safe = s;
    }

    public void setLast_play_time(String s)
    {
        last_play_time = s;
    }

    public void setNext(int i)
    {
        next = i;
    }

    public void setPlay_url(String s)
    {
        play_url = s;
    }

    public void setProc(String s)
    {
        proc = s;
    }

    public void setSerial(String s)
    {
        serial = s;
    }

    public void setShort_desc(String s)
    {
        short_desc = s;
    }

    public void setSound(String s)
    {
        sound = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}

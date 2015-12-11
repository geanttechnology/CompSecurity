// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;


public class Model
{

    private String appurl;
    private String mp3searchurl;
    private String mp3url;
    private String ringtoneurl;

    public Model()
    {
    }

    public String getAppurl()
    {
        return appurl;
    }

    public String getMp3searchurl()
    {
        return mp3searchurl;
    }

    public String getMp3url()
    {
        return mp3url;
    }

    public String getRingtoneurl()
    {
        return ringtoneurl;
    }

    public void setAppurl(String s)
    {
        appurl = s;
    }

    public void setMp3searchurl(String s)
    {
        mp3searchurl = s;
    }

    public void setMp3url(String s)
    {
        mp3url = s;
    }

    public void setRingtoneurl(String s)
    {
        ringtoneurl = s;
    }
}

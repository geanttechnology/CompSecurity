// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;


public class BackupModel
{

    private String Img;
    private String Size;
    private String Version;
    private String app_name;
    private String package_name;

    public BackupModel()
    {
    }

    public String getApp_name()
    {
        return app_name;
    }

    public String getImg()
    {
        return Img;
    }

    public String getPackage_name()
    {
        return package_name;
    }

    public String getSize()
    {
        return Size;
    }

    public String getVersion()
    {
        return Version;
    }

    public void setApp_name(String s)
    {
        app_name = s;
    }

    public void setImg(String s)
    {
        Img = s;
    }

    public void setPackage_name(String s)
    {
        package_name = s;
    }

    public void setSize(String s)
    {
        Size = s;
    }

    public void setVersion(String s)
    {
        Version = s;
    }
}

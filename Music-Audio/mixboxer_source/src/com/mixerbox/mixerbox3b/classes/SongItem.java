// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;


public class SongItem
{

    String id;
    String name;
    int order;
    int source;
    String thumbnail;
    String time;
    int tm;
    String ytId;

    public SongItem(String s, String s1, String s2, String s3, int i, int j, String s4)
    {
        id = s;
        name = s1;
        time = s2;
        ytId = s3;
        order = i;
        source = j;
        thumbnail = s4;
    }

    public String getSongId()
    {
        return id;
    }

    public String getSongName()
    {
        return name;
    }

    public int getSongOrder()
    {
        return order;
    }

    public int getSongSource()
    {
        return source;
    }

    public String getSongThumbnail()
    {
        return thumbnail;
    }

    public String getSongTime()
    {
        return time;
    }

    public String getSongYtId()
    {
        return ytId;
    }
}

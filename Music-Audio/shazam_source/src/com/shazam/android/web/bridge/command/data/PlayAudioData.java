// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;


public class PlayAudioData
{

    private String id;
    private String url;

    private PlayAudioData()
    {
    }

    public PlayAudioData(String s, String s1)
    {
        id = s;
        url = s1;
    }

    public String getId()
    {
        return id;
    }

    public String getUrl()
    {
        return url;
    }
}

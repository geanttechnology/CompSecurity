// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


public class XuaSessionInfo
{

    private String playbackId;
    private String pluginId;

    public XuaSessionInfo()
    {
    }

    public XuaSessionInfo(String s)
    {
        pluginId = s;
    }

    public String getPlaybackId()
    {
        return playbackId;
    }

    public String getPluginId()
    {
        return pluginId;
    }

    public void setPlaybackId(String s)
    {
        playbackId = s;
    }

    public void setPluginId(String s)
    {
        pluginId = s;
    }
}

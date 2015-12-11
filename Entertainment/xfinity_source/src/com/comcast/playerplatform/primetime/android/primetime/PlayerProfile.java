// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;


public class PlayerProfile
{

    private int bitrate;
    private int height;
    private int width;

    public PlayerProfile(int i, int j, int k)
    {
        bitrate = i;
        width = j;
        height = k;
    }

    public int getBitrate()
    {
        return bitrate;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }
}

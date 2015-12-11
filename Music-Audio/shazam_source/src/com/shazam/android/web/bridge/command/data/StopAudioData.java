// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;


public class StopAudioData
{

    private String id;

    private StopAudioData()
    {
    }

    public StopAudioData(String s)
    {
        id = s;
    }

    public String getId()
    {
        return id;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.ads;


public class AdPlayerStateChanged
{

    private final boolean isPlaying;

    public AdPlayerStateChanged(boolean flag)
    {
        isPlaying = flag;
    }

    public boolean isPlaying()
    {
        return isPlaying;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class ColdBootProgressEvent
{

    private final long duration;
    private final int progress;

    public ColdBootProgressEvent(int i, long l)
    {
        progress = i;
        duration = l;
    }

    public long getDuration()
    {
        return duration;
    }

    public int getProgress()
    {
        return progress;
    }
}

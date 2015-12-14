// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class DownloadStatusEvent
{

    private final boolean complete;

    public DownloadStatusEvent(boolean flag)
    {
        complete = flag;
    }

    public boolean isActive()
    {
        return !complete;
    }
}

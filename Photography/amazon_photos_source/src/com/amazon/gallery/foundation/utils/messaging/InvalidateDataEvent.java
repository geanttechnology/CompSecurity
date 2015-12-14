// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class InvalidateDataEvent
{

    private final boolean hardReset;

    public InvalidateDataEvent()
    {
        this(false);
    }

    public InvalidateDataEvent(boolean flag)
    {
        hardReset = flag;
    }

    public boolean isHardReset()
    {
        return hardReset;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class ItemChangeEvent
{

    private int position;

    public ItemChangeEvent()
    {
        position = -1;
    }

    public ItemChangeEvent(int i)
    {
        position = -1;
        position = i;
    }

    public int getPosition()
    {
        return position;
    }

    public boolean isSingleItemChange()
    {
        return position != -1;
    }
}

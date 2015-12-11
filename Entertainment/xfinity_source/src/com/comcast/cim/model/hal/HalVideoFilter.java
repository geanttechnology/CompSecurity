// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.xfinity.playerlib.model.consumable.hal.HalVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HalVideoFilter
{

    public HalVideoFilter()
    {
    }

    public List filter(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            HalVideo halvideo = (HalVideo)list.next();
            if (matches(halvideo))
            {
                arraylist.add(halvideo);
            }
        } while (true);
        return arraylist;
    }

    protected abstract boolean matches(HalVideo halvideo);
}

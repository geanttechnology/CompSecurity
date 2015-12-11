// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;

import commonlib.loader.event.UpdateEvent;

public class MyGrouponsUpdateEvent extends UpdateEvent
{

    private String category;
    private int grouponSize;

    public MyGrouponsUpdateEvent(String s, int i)
    {
        category = s;
        grouponSize = i;
    }

    public String getCategory()
    {
        return category;
    }

    public int getGrouponSize()
    {
        return grouponSize;
    }
}

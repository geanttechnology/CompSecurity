// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.ArrayList;
import java.util.List;

public final class RemindersList
{

    public int count;
    public boolean hasMore;
    public List list;
    public String nextPageLocator;

    public RemindersList()
    {
        list = new ArrayList();
        hasMore = false;
        nextPageLocator = null;
    }
}

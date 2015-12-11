// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.List;

public class ListResult
{

    public final List list;
    public final int totalItemsCount;

    public ListResult(int i, List list1)
    {
        totalItemsCount = i;
        list = list1;
    }
}

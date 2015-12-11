// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.util.List;

public class AmazonWebBackForwardList
{

    private final int currentItemIndex;
    private final List historyItems;

    public AmazonWebBackForwardList(List list, int i)
    {
        historyItems = list;
        currentItemIndex = i;
    }
}

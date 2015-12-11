// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.util.List;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebHistoryItem

public class AmazonWebBackForwardList
{

    private final int currentItemIndex;
    private final List historyItems;

    public AmazonWebBackForwardList(List list, int i)
    {
        historyItems = list;
        currentItemIndex = i;
    }

    public int getCurrentIndex()
    {
        this;
        JVM INSTR monitorenter ;
        int i = currentItemIndex;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonWebHistoryItem getCurrentItem()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonWebHistoryItem amazonwebhistoryitem = getItemAtIndex(getCurrentIndex());
        this;
        JVM INSTR monitorexit ;
        return amazonwebhistoryitem;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonWebHistoryItem getItemAtIndex(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i < 0) goto _L2; else goto _L1
_L1:
        int j = getSize();
        if (i < j) goto _L3; else goto _L2
_L2:
        AmazonWebHistoryItem amazonwebhistoryitem = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return amazonwebhistoryitem;
_L3:
        amazonwebhistoryitem = (AmazonWebHistoryItem)historyItems.get(i);
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public int getSize()
    {
        this;
        JVM INSTR monitorenter ;
        int i = historyItems.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }
}

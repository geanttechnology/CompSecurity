// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;


// Referenced classes of package com.ebay.android.widget:
//            ExtensibleItemAnimator

private static class <init>
{

    public int fromX;
    public int fromY;
    public android.support.v7.widget.Y newHolder;
    public android.support.v7.widget.Y oldHolder;
    public int toX;
    public int toY;

    public String toString()
    {
        return (new StringBuilder()).append("ChangeInfo{oldHolder=").append(oldHolder).append(", newHolder=").append(newHolder).append(", fromX=").append(fromX).append(", fromY=").append(fromY).append(", toX=").append(toX).append(", toY=").append(toY).append('}').toString();
    }

    private (android.support.v7.widget.A a, android.support.v7.widget.A a1)
    {
        oldHolder = a;
        newHolder = a1;
    }

    private newHolder(android.support.v7.widget.wHolder wholder, android.support.v7.widget.wHolder wholder1, int i, int j, int k, int l)
    {
        this(wholder, wholder1);
        fromX = i;
        fromY = j;
        toX = k;
        toY = l;
    }

    toY(android.support.v7.widget.Y y, android.support.v7.widget.Y y1, int i, int j, int k, int l, toY toy)
    {
        this(y, y1, i, j, k, l);
    }
}

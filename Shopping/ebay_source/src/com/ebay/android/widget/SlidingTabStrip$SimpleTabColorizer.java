// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;


// Referenced classes of package com.ebay.android.widget:
//            SlidingTabStrip

private static class <init>
    implements <init>
{

    private int dividerColors[];
    private int indicatorColors[];

    public int getDividerColor(int i)
    {
        return dividerColors[i % dividerColors.length];
    }

    public final int getIndicatorColor(int i)
    {
        return indicatorColors[i % indicatorColors.length];
    }

    transient void setDividerColors(int ai[])
    {
        dividerColors = ai;
    }

    transient void setIndicatorColors(int ai[])
    {
        indicatorColors = ai;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

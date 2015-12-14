// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;


public final class value extends Enum
{

    private static final Line $VALUES[];
    public static final Line Line;
    public static final Line None;
    public static final Line Triangle;
    public static final Line Underline;
    public final int value;

    public static value fromValue(int i)
    {
        value avalue[] = values();
        int k = avalue.length;
        for (int j = 0; j < k; j++)
        {
            value value1 = avalue[j];
            if (value1.value == i)
            {
                return value1;
            }
        }

        return null;
    }

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/picsart/studio/view/viewpagerindicator/TitlePageIndicator$IndicatorStyle, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0, 0);
        Triangle = new <init>("Triangle", 1, 1);
        Underline = new <init>("Underline", 2, 2);
        Line = new <init>("Line", 3, 3);
        $VALUES = (new .VALUES[] {
            None, Triangle, Underline, Line
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;


// Referenced classes of package com.squareup.timessquare:
//            MonthCellDescriptor

public static final class  extends Enum
{

    private static final LAST $VALUES[];
    public static final LAST FIRST;
    public static final LAST LAST;
    public static final LAST MIDDLE;
    public static final LAST NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/squareup/timessquare/MonthCellDescriptor$RangeState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        FIRST = new <init>("FIRST", 1);
        MIDDLE = new <init>("MIDDLE", 2);
        LAST = new <init>("LAST", 3);
        $VALUES = (new .VALUES[] {
            NONE, FIRST, MIDDLE, LAST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;


// Referenced classes of package com.squareup.timessquare:
//            CalendarPickerView

public static final class  extends Enum
{

    private static final RANGE $VALUES[];
    public static final RANGE MULTIPLE;
    public static final RANGE RANGE;
    public static final RANGE SINGLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/squareup/timessquare/CalendarPickerView$SelectionMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SINGLE = new <init>("SINGLE", 0);
        MULTIPLE = new <init>("MULTIPLE", 1);
        RANGE = new <init>("RANGE", 2);
        $VALUES = (new .VALUES[] {
            SINGLE, MULTIPLE, RANGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

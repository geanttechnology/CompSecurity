// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.info;


// Referenced classes of package com.inmobi.commons.core.utilities.info:
//            DisplayInfo

public static final class a extends Enum
{

    private static final REVERSE_LANDSCAPE $VALUES[];
    public static final REVERSE_LANDSCAPE LANDSCAPE;
    public static final REVERSE_LANDSCAPE PORTRAIT;
    public static final REVERSE_LANDSCAPE REVERSE_LANDSCAPE;
    public static final REVERSE_LANDSCAPE REVERSE_PORTRAIT;
    private int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/core/utilities/info/DisplayInfo$ORIENTATION_VALUES, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        PORTRAIT = new <init>("PORTRAIT", 0, 1);
        REVERSE_PORTRAIT = new <init>("REVERSE_PORTRAIT", 1, 2);
        LANDSCAPE = new <init>("LANDSCAPE", 2, 3);
        REVERSE_LANDSCAPE = new <init>("REVERSE_LANDSCAPE", 3, 4);
        $VALUES = (new .VALUES[] {
            PORTRAIT, REVERSE_PORTRAIT, LANDSCAPE, REVERSE_LANDSCAPE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}

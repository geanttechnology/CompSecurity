// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;


// Referenced classes of package com.aviary.android.feather.library.filters:
//            EnhanceFilter

public static final class  extends Enum
{

    private static final ColorFix $VALUES[];
    public static final ColorFix ColorFix;
    public static final ColorFix HiDef;
    public static final ColorFix Illuminate;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/library/filters/EnhanceFilter$Types, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HiDef = new <init>("HiDef", 0);
        Illuminate = new <init>("Illuminate", 1);
        ColorFix = new <init>("ColorFix", 2);
        $VALUES = (new .VALUES[] {
            HiDef, Illuminate, ColorFix
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

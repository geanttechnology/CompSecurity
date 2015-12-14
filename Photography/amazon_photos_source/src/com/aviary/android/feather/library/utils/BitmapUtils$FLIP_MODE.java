// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;


// Referenced classes of package com.aviary.android.feather.library.utils:
//            BitmapUtils

public static final class  extends Enum
{

    private static final HorizontalVertical $VALUES[];
    public static final HorizontalVertical Horizontal;
    public static final HorizontalVertical HorizontalVertical;
    public static final HorizontalVertical None;
    public static final HorizontalVertical Vertical;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/library/utils/BitmapUtils$FLIP_MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Horizontal = new <init>("Horizontal", 1);
        Vertical = new <init>("Vertical", 2);
        HorizontalVertical = new <init>("HorizontalVertical", 3);
        $VALUES = (new .VALUES[] {
            None, Horizontal, Vertical, HorizontalVertical
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

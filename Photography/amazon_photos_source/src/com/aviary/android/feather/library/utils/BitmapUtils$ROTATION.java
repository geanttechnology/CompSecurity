// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;


// Referenced classes of package com.aviary.android.feather.library.utils:
//            BitmapUtils

public static final class  extends Enum
{

    private static final ROTATE_NULL $VALUES[];
    public static final ROTATE_NULL ROTATE_180;
    public static final ROTATE_NULL ROTATE_270;
    public static final ROTATE_NULL ROTATE_90;
    public static final ROTATE_NULL ROTATE_NULL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/library/utils/BitmapUtils$ROTATION, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ROTATE_90 = new <init>("ROTATE_90", 0);
        ROTATE_180 = new <init>("ROTATE_180", 1);
        ROTATE_270 = new <init>("ROTATE_270", 2);
        ROTATE_NULL = new <init>("ROTATE_NULL", 3);
        $VALUES = (new .VALUES[] {
            ROTATE_90, ROTATE_180, ROTATE_270, ROTATE_NULL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

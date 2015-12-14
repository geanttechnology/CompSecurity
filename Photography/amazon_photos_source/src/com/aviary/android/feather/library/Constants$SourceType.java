// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library;


// Referenced classes of package com.aviary.android.feather.library:
//            Constants

public static final class  extends Enum
{

    private static final Grid $VALUES[];
    public static final Grid Camera;
    public static final Grid Gallery;
    public static final Grid Grid;
    public static final Grid None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/library/Constants$SourceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Camera = new <init>("Camera", 1);
        Gallery = new <init>("Gallery", 2);
        Grid = new <init>("Grid", 3);
        $VALUES = (new .VALUES[] {
            None, Camera, Gallery, Grid
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

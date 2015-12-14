// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.animation;


// Referenced classes of package com.aviary.android.feather.library.graphics.animation:
//            EasingType

public static final class  extends Enum
{

    private static final INOUT $VALUES[];
    public static final INOUT IN;
    public static final INOUT INOUT;
    public static final INOUT OUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/library/graphics/animation/EasingType$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IN = new <init>("IN", 0);
        OUT = new <init>("OUT", 1);
        INOUT = new <init>("INOUT", 2);
        $VALUES = (new .VALUES[] {
            IN, OUT, INOUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

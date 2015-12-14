// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;


// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawableFrameInfo

public static final class  extends Enum
{

    private static final DISPOSE_TO_PREVIOUS $VALUES[];
    public static final DISPOSE_TO_PREVIOUS DISPOSE_DO_NOT;
    public static final DISPOSE_TO_PREVIOUS DISPOSE_TO_BACKGROUND;
    public static final DISPOSE_TO_PREVIOUS DISPOSE_TO_PREVIOUS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DISPOSE_DO_NOT = new <init>("DISPOSE_DO_NOT", 0);
        DISPOSE_TO_BACKGROUND = new <init>("DISPOSE_TO_BACKGROUND", 1);
        DISPOSE_TO_PREVIOUS = new <init>("DISPOSE_TO_PREVIOUS", 2);
        $VALUES = (new .VALUES[] {
            DISPOSE_DO_NOT, DISPOSE_TO_BACKGROUND, DISPOSE_TO_PREVIOUS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

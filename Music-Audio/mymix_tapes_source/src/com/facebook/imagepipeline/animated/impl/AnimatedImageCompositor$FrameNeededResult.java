// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;


// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedImageCompositor

private static final class  extends Enum
{

    private static final ABORT $VALUES[];
    public static final ABORT ABORT;
    public static final ABORT NOT_REQUIRED;
    public static final ABORT REQUIRED;
    public static final ABORT SKIP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$FrameNeededResult, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REQUIRED = new <init>("REQUIRED", 0);
        NOT_REQUIRED = new <init>("NOT_REQUIRED", 1);
        SKIP = new <init>("SKIP", 2);
        ABORT = new <init>("ABORT", 3);
        $VALUES = (new .VALUES[] {
            REQUIRED, NOT_REQUIRED, SKIP, ABORT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

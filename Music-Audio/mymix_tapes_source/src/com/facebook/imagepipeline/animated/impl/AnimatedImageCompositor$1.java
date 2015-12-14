// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;


// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedImageCompositor

static class ameNeededResult
{

    static final int $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[];

    static 
    {
        $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult = new int[ameNeededResult.values().length];
        try
        {
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[ameNeededResult.REQUIRED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[ameNeededResult.NOT_REQUIRED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[ameNeededResult.ABORT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[ameNeededResult.SKIP.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;


public class AnimatedDrawableFrameInfo
{
    public static final class DisposalMethod extends Enum
    {

        private static final DisposalMethod $VALUES[];
        public static final DisposalMethod DISPOSE_DO_NOT;
        public static final DisposalMethod DISPOSE_TO_BACKGROUND;
        public static final DisposalMethod DISPOSE_TO_PREVIOUS;

        public static DisposalMethod valueOf(String s)
        {
            return (DisposalMethod)Enum.valueOf(com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod, s);
        }

        public static DisposalMethod[] values()
        {
            return (DisposalMethod[])$VALUES.clone();
        }

        static 
        {
            DISPOSE_DO_NOT = new DisposalMethod("DISPOSE_DO_NOT", 0);
            DISPOSE_TO_BACKGROUND = new DisposalMethod("DISPOSE_TO_BACKGROUND", 1);
            DISPOSE_TO_PREVIOUS = new DisposalMethod("DISPOSE_TO_PREVIOUS", 2);
            $VALUES = (new DisposalMethod[] {
                DISPOSE_DO_NOT, DISPOSE_TO_BACKGROUND, DISPOSE_TO_PREVIOUS
            });
        }

        private DisposalMethod(String s, int i)
        {
            super(s, i);
        }
    }


    public final DisposalMethod disposalMethod;
    public final int frameNumber;
    public final int height;
    public final boolean shouldBlendWithPreviousFrame;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    public AnimatedDrawableFrameInfo(int i, int j, int k, int l, int i1, boolean flag, DisposalMethod disposalmethod)
    {
        frameNumber = i;
        xOffset = j;
        yOffset = k;
        width = l;
        height = i1;
        shouldBlendWithPreviousFrame = flag;
        disposalMethod = disposalmethod;
    }
}

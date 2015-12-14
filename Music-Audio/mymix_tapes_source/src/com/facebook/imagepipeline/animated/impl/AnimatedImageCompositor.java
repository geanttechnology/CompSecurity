// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;

public class AnimatedImageCompositor
{
    public static interface Callback
    {

        public abstract CloseableReference getCachedBitmap(int i);

        public abstract void onIntermediateResult(int i, Bitmap bitmap);
    }

    private static final class FrameNeededResult extends Enum
    {

        private static final FrameNeededResult $VALUES[];
        public static final FrameNeededResult ABORT;
        public static final FrameNeededResult NOT_REQUIRED;
        public static final FrameNeededResult REQUIRED;
        public static final FrameNeededResult SKIP;

        public static FrameNeededResult valueOf(String s)
        {
            return (FrameNeededResult)Enum.valueOf(com/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$FrameNeededResult, s);
        }

        public static FrameNeededResult[] values()
        {
            return (FrameNeededResult[])$VALUES.clone();
        }

        static 
        {
            REQUIRED = new FrameNeededResult("REQUIRED", 0);
            NOT_REQUIRED = new FrameNeededResult("NOT_REQUIRED", 1);
            SKIP = new FrameNeededResult("SKIP", 2);
            ABORT = new FrameNeededResult("ABORT", 3);
            $VALUES = (new FrameNeededResult[] {
                REQUIRED, NOT_REQUIRED, SKIP, ABORT
            });
        }

        private FrameNeededResult(String s, int i)
        {
            super(s, i);
        }
    }


    private final AnimatedDrawableBackend mAnimatedDrawableBackend;
    private final Callback mCallback;
    private final Paint mTransparentFillPaint = new Paint();

    public AnimatedImageCompositor(AnimatedDrawableBackend animateddrawablebackend, Callback callback)
    {
        mAnimatedDrawableBackend = animateddrawablebackend;
        mCallback = callback;
        mTransparentFillPaint.setColor(0);
        mTransparentFillPaint.setStyle(android.graphics.Paint.Style.FILL);
        mTransparentFillPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
    }

    private void disposeToBackground(Canvas canvas, AnimatedDrawableFrameInfo animateddrawableframeinfo)
    {
        canvas.drawRect(animateddrawableframeinfo.xOffset, animateddrawableframeinfo.yOffset, animateddrawableframeinfo.xOffset + animateddrawableframeinfo.width, animateddrawableframeinfo.yOffset + animateddrawableframeinfo.height, mTransparentFillPaint);
    }

    private FrameNeededResult isFrameNeededForRendering(int i)
    {
        AnimatedDrawableFrameInfo animateddrawableframeinfo = mAnimatedDrawableBackend.getFrameInfo(i);
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalmethod = animateddrawableframeinfo.disposalMethod;
        if (disposalmethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT)
        {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalmethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND)
        {
            if (animateddrawableframeinfo.xOffset == 0 && animateddrawableframeinfo.yOffset == 0 && animateddrawableframeinfo.width == mAnimatedDrawableBackend.getRenderedWidth() && animateddrawableframeinfo.height == mAnimatedDrawableBackend.getRenderedHeight())
            {
                return FrameNeededResult.NOT_REQUIRED;
            } else
            {
                return FrameNeededResult.REQUIRED;
            }
        }
        if (disposalmethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS)
        {
            return FrameNeededResult.SKIP;
        } else
        {
            return FrameNeededResult.ABORT;
        }
    }

    private int prepareCanvasWithClosestCachedFrame(int i, Canvas canvas)
    {
_L7:
        if (i < 0) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        obj = isFrameNeededForRendering(i);
        j = i;
        static class _cls1
        {

            static final int $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[];

            static 
            {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult = new int[FrameNeededResult.values().length];
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.REQUIRED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.NOT_REQUIRED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.ABORT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.SKIP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult[((FrameNeededResult) (obj)).ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 55
    //                   2 143
    //                   3 123;
           goto _L3 _L4 _L5 _L6
_L3:
        i--;
          goto _L7
_L4:
        AnimatedDrawableFrameInfo animateddrawableframeinfo;
        animateddrawableframeinfo = mAnimatedDrawableBackend.getFrameInfo(i);
        obj = mCallback.getCachedBitmap(i);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        canvas.drawBitmap((Bitmap)((CloseableReference) (obj)).get(), 0.0F, 0.0F, null);
        if (animateddrawableframeinfo.disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND)
        {
            disposeToBackground(canvas, animateddrawableframeinfo);
        }
        j = i + 1;
        ((CloseableReference) (obj)).close();
_L6:
        return j;
        canvas;
        ((CloseableReference) (obj)).close();
        throw canvas;
        if (animateddrawableframeinfo.shouldBlendWithPreviousFrame) goto _L3; else goto _L8
_L8:
        return i;
_L5:
        return i + 1;
_L2:
        return 0;
    }

    public void renderFrame(int i, Bitmap bitmap)
    {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.SRC);
        int j;
        if (mAnimatedDrawableBackend.getFrameInfo(i).shouldBlendWithPreviousFrame && i > 0)
        {
            j = prepareCanvasWithClosestCachedFrame(i - 1, canvas);
        } else
        {
            j = i;
        }
        while (j < i) 
        {
            AnimatedDrawableFrameInfo animateddrawableframeinfo = mAnimatedDrawableBackend.getFrameInfo(j);
            com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalmethod = animateddrawableframeinfo.disposalMethod;
            if (disposalmethod != com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS)
            {
                mAnimatedDrawableBackend.renderFrame(j, canvas);
                mCallback.onIntermediateResult(j, bitmap);
                if (disposalmethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND)
                {
                    disposeToBackground(canvas, animateddrawableframeinfo);
                }
            }
            j++;
        }
        mAnimatedDrawableBackend.renderFrame(i, canvas);
    }
}

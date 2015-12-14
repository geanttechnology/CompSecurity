// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;

public class AnimatedDrawableDiagnosticsNoop
    implements AnimatedDrawableDiagnostics
{

    private static AnimatedDrawableDiagnosticsNoop sInstance = new AnimatedDrawableDiagnosticsNoop();

    public AnimatedDrawableDiagnosticsNoop()
    {
    }

    public static AnimatedDrawableDiagnosticsNoop getInstance()
    {
        return sInstance;
    }

    public void drawDebugOverlay(Canvas canvas, Rect rect)
    {
    }

    public void incrementDrawnFrames(int i)
    {
    }

    public void incrementDroppedFrames(int i)
    {
    }

    public void onDrawMethodBegin()
    {
    }

    public void onDrawMethodEnd()
    {
    }

    public void onNextFrameMethodBegin()
    {
    }

    public void onNextFrameMethodEnd()
    {
    }

    public void onStartMethodBegin()
    {
    }

    public void onStartMethodEnd()
    {
    }

    public void setBackend(AnimatedDrawableCachingBackend animateddrawablecachingbackend)
    {
    }

}

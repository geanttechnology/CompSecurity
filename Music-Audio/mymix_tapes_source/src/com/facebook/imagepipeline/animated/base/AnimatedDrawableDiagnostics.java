// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;

// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawableCachingBackend

public interface AnimatedDrawableDiagnostics
{

    public abstract void drawDebugOverlay(Canvas canvas, Rect rect);

    public abstract void incrementDrawnFrames(int i);

    public abstract void incrementDroppedFrames(int i);

    public abstract void onDrawMethodBegin();

    public abstract void onDrawMethodEnd();

    public abstract void onNextFrameMethodBegin();

    public abstract void onNextFrameMethodEnd();

    public abstract void onStartMethodBegin();

    public abstract void onStartMethodEnd();

    public abstract void setBackend(AnimatedDrawableCachingBackend animateddrawablecachingbackend);
}

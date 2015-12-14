// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;

public interface AnimatedImageFrame
{

    public abstract void dispose();

    public abstract int getDurationMs();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract int getXOffset();

    public abstract int getYOffset();

    public abstract void renderFrame(int i, int j, Bitmap bitmap);
}

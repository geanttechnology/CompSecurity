// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;

public interface ControllerListener
{

    public abstract void onFailure(String s, Throwable throwable);

    public abstract void onFinalImageSet(String s, Object obj, Animatable animatable);

    public abstract void onIntermediateImageFailed(String s, Throwable throwable);

    public abstract void onIntermediateImageSet(String s, Object obj);

    public abstract void onRelease(String s);

    public abstract void onSubmit(String s, Object obj);
}

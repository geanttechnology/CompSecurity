// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;

public interface TImageProcessingDelegate
{

    public abstract void imageDidProcessed(Bitmap bitmap, String s);

    public abstract void imageProcessFailed(int i);

    public abstract void imageStartProcessing();
}

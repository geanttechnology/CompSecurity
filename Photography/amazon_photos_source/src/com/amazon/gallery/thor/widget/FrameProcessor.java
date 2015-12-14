// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.graphics.Bitmap;

public abstract class FrameProcessor
{

    public FrameProcessor()
    {
    }

    public abstract Bitmap process(Bitmap bitmap);
}

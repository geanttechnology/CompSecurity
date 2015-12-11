// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.graphics.Bitmap;

public class GifFrame
{

    public int delay;
    public Bitmap image;

    public GifFrame(Bitmap bitmap, int i)
    {
        image = bitmap;
        delay = i;
    }
}

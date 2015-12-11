// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import android.graphics.Bitmap;

public class BitmapUtil
{

    public BitmapUtil()
    {
    }

    public static int getBitmapByteCount(Bitmap bitmap)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return bitmap.getAllocationByteCount();
        }
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            return bitmap.getByteCount();
        } else
        {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }
}

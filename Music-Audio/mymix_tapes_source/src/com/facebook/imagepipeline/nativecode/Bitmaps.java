// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;

public class Bitmaps
{

    public static final android.graphics.Bitmap.Config BITMAP_CONFIG;
    public static final int BYTES_PER_PIXEL = 4;

    public Bitmaps()
    {
    }

    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap1)
    {
        boolean flag1 = true;
        boolean flag;
        if (bitmap1.getConfig() == android.graphics.Bitmap.Config.ARGB_8888)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (bitmap.getConfig() == android.graphics.Bitmap.Config.ARGB_8888)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        Preconditions.checkArgument(bitmap.isMutable());
        if (bitmap.getWidth() == bitmap1.getWidth())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (bitmap.getHeight() == bitmap1.getHeight())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap1, bitmap1.getRowBytes(), bitmap.getHeight());
    }

    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap1, int j, int k);

    private static native void nativePinBitmap(Bitmap bitmap);

    public static void pinBitmap(Bitmap bitmap)
    {
        Preconditions.checkNotNull(bitmap);
        nativePinBitmap(bitmap);
    }

    public static void reconfigureBitmap(Bitmap bitmap, int i, int j)
    {
        boolean flag;
        if (bitmap.getAllocationByteCount() >= i * j * 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        bitmap.reconfigure(i, j, BITMAP_CONFIG);
    }

    static 
    {
        BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
        SoLoaderShim.loadLibrary("bitmaps");
    }
}

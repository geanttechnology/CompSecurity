// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class JpegUtils
{

    public JpegUtils()
    {
    }

    public static int[] computeWidthAndHeightForMyRawJpegImage()
    {
        return (new int[] {
            480, 360
        });
    }

    public static Bitmap jpegToBitmap(byte abyte0[])
    {
        int ai[] = computeWidthAndHeightForMyRawJpegImage();
        int i = ai[0];
        int j = ai[1];
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        int k = Math.max(options.outHeight, options.outWidth);
        options.inJustDecodeBounds = false;
        int l = Math.max(i, j);
        if (k > l)
        {
            options.inSampleSize = k / l;
        }
        return Bitmap.createScaledBitmap(BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options), i, j, false);
    }
}

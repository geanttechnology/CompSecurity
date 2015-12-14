// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imageutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class BitmapUtil
{

    public BitmapUtil()
    {
    }

    public static Pair decodeDimensions(InputStream inputstream)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1)
        {
            return null;
        } else
        {
            return new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
    }

    public static Pair decodeDimensions(byte abyte0[])
    {
        return decodeDimensions(((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    public static int getSizeInBytes(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return 0;
        }
        if (android.os.Build.VERSION.SDK_INT <= 19)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        int i = bitmap.getAllocationByteCount();
        return i;
        NullPointerException nullpointerexception;
        nullpointerexception;
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            return bitmap.getByteCount();
        } else
        {
            return bitmap.getWidth() * bitmap.getRowBytes();
        }
    }
}

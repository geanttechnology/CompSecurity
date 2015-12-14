// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.Queue;

public final class Util
{

    private static final char HEX_CHAR_ARRAY[] = "0123456789abcdef".toCharArray();
    private static final char SHA_1_CHARS[] = new char[40];
    private static final char SHA_256_CHARS[] = new char[64];

    public static void assertBackgroundThread()
    {
        if (!isOnBackgroundThread())
        {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        } else
        {
            return;
        }
    }

    public static void assertMainThread()
    {
        if (!isOnMainThread())
        {
            throw new IllegalArgumentException("You must call this method on the main thread");
        } else
        {
            return;
        }
    }

    private static String bytesToHex(byte abyte0[], char ac[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = HEX_CHAR_ARRAY[j >>> 4];
            ac[i * 2 + 1] = HEX_CHAR_ARRAY[j & 0xf];
        }

        return new String(ac);
    }

    public static Queue createQueue(int i)
    {
        return new ArrayDeque(i);
    }

    public static int getBitmapByteSize(int i, int j, android.graphics.Bitmap.Config config)
    {
        return i * j * getBytesPerPixel(config);
    }

    public static int getBitmapByteSize(Bitmap bitmap)
    {
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        int i = bitmap.getAllocationByteCount();
        return i;
        NullPointerException nullpointerexception;
        nullpointerexception;
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    private static int getBytesPerPixel(android.graphics.Bitmap.Config config)
    {
        android.graphics.Bitmap.Config config1 = config;
        if (config == null)
        {
            config1 = android.graphics.Bitmap.Config.ARGB_8888;
        }
        static class _cls1
        {

            static final int $SwitchMap$android$graphics$Bitmap$Config[];

            static 
            {
                $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Bitmap.Config.values().length];
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.android.graphics.Bitmap.Config[config1.ordinal()])
        {
        default:
            return 4;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
        case 3: // '\003'
            return 2;
        }
    }

    public static boolean isOnBackgroundThread()
    {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean isValidDimension(int i)
    {
        return i > 0 || i == 0x80000000;
    }

    public static boolean isValidDimensions(int i, int j)
    {
        return isValidDimension(i) && isValidDimension(j);
    }

    public static String sha256BytesToHex(byte abyte0[])
    {
        return bytesToHex(abyte0, SHA_256_CHARS);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.exif;

import android.util.Log;

public class ExifTool
{

    public static boolean a;

    public ExifTool()
    {
    }

    public static int a(String s, String s1, String s2)
    {
        if (a)
        {
            return nativeSetTag(s, s1, s2);
        } else
        {
            return 1;
        }
    }

    public static String a(String s)
    {
        if (a)
        {
            return nativeListTags(s);
        } else
        {
            return null;
        }
    }

    public static String a(String s, String s1)
    {
        if (a)
        {
            return nativeGetTag(s, s1);
        } else
        {
            return null;
        }
    }

    public static void a(String s, byte abyte0[])
    {
        if (a)
        {
            nativeWriteRawEXIF(s, abyte0);
        }
    }

    public static byte[] b(String s)
    {
        if (a)
        {
            return nativeReadRawEXIF(s);
        } else
        {
            return new byte[0];
        }
    }

    private static native void nativeDelTag(String s, String s1);

    private static native String nativeGetTag(String s, String s1);

    private static native String nativeGetTagPretty(String s, String s1);

    private static native String nativeListTags(String s);

    private static native byte[] nativeReadRawEXIF(String s);

    private static native int nativeSetTag(String s, String s1, String s2);

    private static native void nativeWriteRawEXIF(String s, byte abyte0[]);

    static 
    {
        a = false;
        System.loadLibrary("exif_tool");
        a = true;
_L2:
        Log.e("ex1", (new StringBuilder("exif tools isLibraryLoaded = ")).append(a).toString());
        return;
        Object obj;
        obj;
        Log.e(com/socialin/android/photo/exif/ExifTool.getSimpleName(), (new StringBuilder("Can't load native library: ")).append(((UnsatisfiedLinkError) (obj)).getMessage()).toString());
        a = false;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        a = false;
        throw obj;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.utils;

import android.content.Context;
import java.io.File;

public class BspatchUtil
{

    public BspatchUtil()
    {
    }

    public static String a(Context context)
    {
        String s;
        try
        {
            s = context.getCacheDir().getCanonicalPath().replace("cache", "lib");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return (new StringBuilder()).append("/data/data/").append(context.getPackageName()).append("/lib").toString();
        }
        return s;
    }

    public static boolean a(Context context, String s, String s1, String s2)
    {
        return patch(a(context), s, s1, s2);
    }

    private static native boolean patch(String s, String s1, String s2, String s3);

    static 
    {
        System.loadLibrary("bspatch");
    }
}

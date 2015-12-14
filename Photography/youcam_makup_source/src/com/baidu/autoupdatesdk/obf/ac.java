// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public final class ac
{

    public ac()
    {
    }

    public static final int a(Context context, String s)
    {
        return a(context, s, "id");
    }

    private static int a(Context context, String s, String s1)
    {
        return a(s, s1, context.getResources().getIdentifier(s, s1, context.getPackageName()));
    }

    private static int a(String s, String s1, int k)
    {
        if (k == 0)
        {
            Log.e("BDAutoUpdateSDK", (new StringBuilder()).append("resource ").append(s).append(", type ").append(s1).append(", undefined.").toString());
        }
        return k;
    }

    public static int b(Context context, String s)
    {
        return a(context, s, "string");
    }

    public static int c(Context context, String s)
    {
        return a(context, s, "color");
    }

    public static int d(Context context, String s)
    {
        return a(context, s, "drawable");
    }

    public static int e(Context context, String s)
    {
        return a(context, s, "layout");
    }

    public static int f(Context context, String s)
    {
        return a(context, s, "dimen");
    }

    public static int g(Context context, String s)
    {
        return a(context, s, "style");
    }

    public static int h(Context context, String s)
    {
        return a(context, s, "raw");
    }

    public static int i(Context context, String s)
    {
        return a(context, s, "anim");
    }

    public static int j(Context context, String s)
    {
        return a(context, s, "xml");
    }
}

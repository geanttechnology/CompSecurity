// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;

public class ContextUtils
{

    private ContextUtils()
    {
    }

    public static int getIdentifier(Context context, String s, String s1)
    {
        return context.getResources().getIdentifier(s, s1, getResourcePackageName(context));
    }

    public static String getResourcePackageName(Context context)
    {
        return context.getResources().getResourcePackageName(0x7f10002e);
    }
}

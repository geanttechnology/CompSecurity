// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.content.Context;
import android.widget.Toast;

public final class NotifyUtil
{

    private NotifyUtil()
    {
    }

    public static void toast(Context context, int i)
    {
        toast(context, context.getString(i));
    }

    public static void toast(Context context, String s)
    {
        Toast.makeText(context, s, 0).show();
    }
}

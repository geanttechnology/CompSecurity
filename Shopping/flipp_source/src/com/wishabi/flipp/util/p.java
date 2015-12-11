// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.wishabi.flipp.app.FlippApplication;

public class p
{

    private static SharedPreferences a;

    public p()
    {
    }

    public static SharedPreferences a()
    {
        com/wishabi/flipp/util/p;
        JVM INSTR monitorenter ;
        Context context;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        context = FlippApplication.b();
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        com/wishabi/flipp/util/p;
        JVM INSTR monitorexit ;
        return null;
        a = context.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        com/wishabi/flipp/util/p;
        JVM INSTR monitorexit ;
        return a;
        Exception exception;
        exception;
        com/wishabi/flipp/util/p;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

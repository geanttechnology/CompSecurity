// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent;

import java.util.UUID;

public final class Session
{

    private static String mId = null;
    private static long mTime = 0L;
    private static long mTimeout = 0L;

    public static void createNew()
    {
        com/paypal/android/lib/riskcomponent/Session;
        JVM INSTR monitorenter ;
        mId = UUID.randomUUID().toString();
        mTime = System.currentTimeMillis();
        com/paypal/android/lib/riskcomponent/Session;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getId()
    {
        com/paypal/android/lib/riskcomponent/Session;
        JVM INSTR monitorenter ;
        String s;
        if (mId == null)
        {
            createNew();
        }
        s = mId;
        com/paypal/android/lib/riskcomponent/Session;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

}

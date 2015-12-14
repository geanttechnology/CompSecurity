// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Locale;
import java.util.TimeZone;

public class ji
{

    private static ji a;

    private ji()
    {
    }

    public static ji a()
    {
        com/flurry/sdk/ji;
        JVM INSTR monitorenter ;
        ji ji1;
        if (a == null)
        {
            a = new ji();
        }
        ji1 = a;
        com/flurry/sdk/ji;
        JVM INSTR monitorexit ;
        return ji1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        a = null;
    }

    public String c()
    {
        return (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("_").append(Locale.getDefault().getCountry()).toString();
    }

    public String d()
    {
        return TimeZone.getDefault().getID();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.telephony.TelephonyManager;

// Referenced classes of package com.flurry.sdk:
//            js

public class jm
{

    private static jm a;
    private static final String b = com/flurry/sdk/jm.getSimpleName();

    private jm()
    {
    }

    public static jm a()
    {
        com/flurry/sdk/jm;
        JVM INSTR monitorenter ;
        jm jm1;
        if (a == null)
        {
            a = new jm();
        }
        jm1 = a;
        com/flurry/sdk/jm;
        JVM INSTR monitorexit ;
        return jm1;
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
        TelephonyManager telephonymanager = (TelephonyManager)js.a().c().getSystemService("phone");
        if (telephonymanager == null)
        {
            return null;
        } else
        {
            return telephonymanager.getNetworkOperatorName();
        }
    }

    public String d()
    {
        TelephonyManager telephonymanager = (TelephonyManager)js.a().c().getSystemService("phone");
        if (telephonymanager == null)
        {
            return null;
        } else
        {
            return telephonymanager.getNetworkOperator();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

// Referenced classes of package com.google.analytics.tracking.android:
//            o, an

final class i
    implements o
{

    private static i e;
    private static Object f = new Object();
    protected String a;
    protected String b;
    protected String c;
    protected String d;

    protected i()
    {
    }

    private i(Context context)
    {
        Object obj;
        String s;
        Object obj1;
        PackageManager packagemanager;
        packagemanager = context.getPackageManager();
        c = context.getPackageName();
        d = packagemanager.getInstallerPackageName(c);
        s = c;
        obj1 = null;
        obj = s;
        PackageInfo packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 0);
        context = obj1;
        obj = s;
        if (packageinfo == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        obj = s;
        context = packagemanager.getApplicationLabel(packageinfo.applicationInfo).toString();
        obj = context;
        s = packageinfo.versionName;
        obj = context;
        context = s;
_L2:
        a = ((String) (obj));
        b = context;
        return;
        context;
        an.a((new StringBuilder("Error retrieving package info: appName set to ")).append(((String) (obj))).toString());
        context = obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static i a()
    {
        return e;
    }

    public static void a(Context context)
    {
        synchronized (f)
        {
            if (e == null)
            {
                e = new i(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final String a(String s)
    {
        if (s.equals("&an"))
        {
            return a;
        }
        if (s.equals("&av"))
        {
            return b;
        }
        if (s.equals("&aid"))
        {
            return c;
        }
        if (s.equals("&aiid"))
        {
            return d;
        } else
        {
            return null;
        }
    }

}

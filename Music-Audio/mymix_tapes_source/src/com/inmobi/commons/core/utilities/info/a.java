// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.core.utilities.Logger;
import java.util.HashMap;
import java.util.Map;

public class a
{

    private static final String a = com/inmobi/commons/core/utilities/info/a.getSimpleName();
    private static a b;
    private static Object c = new Object();
    private String d;
    private String e;
    private String f;
    private String g;
    private Map h;

    private a()
    {
        h = new HashMap();
        a(com.inmobi.commons.a.a.b());
        d();
    }

    public static a a()
    {
        Object obj;
        obj = b;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        a a1 = b;
        obj = a1;
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        b = new a();
        obj = b;
        obj1;
        JVM INSTR monitorexit ;
        return ((a) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((a) (obj));
    }

    private void a(Context context)
    {
        Object obj;
        Object obj1;
        try
        {
            obj = context.getPackageManager();
            obj1 = ((PackageManager) (obj)).getApplicationInfo(context.getPackageName(), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to fetch app info completely", context);
            return;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        d = ((ApplicationInfo) (obj1)).packageName;
        e = ((ApplicationInfo) (obj1)).loadLabel(((PackageManager) (obj))).toString();
        g = ((PackageManager) (obj)).getInstallerPackageName(d);
        obj1 = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 128);
        context = null;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = ((PackageInfo) (obj1)).versionName;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        context = ((Context) (obj));
        if (!((String) (obj)).equals(""))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        context = (new StringBuilder()).append(((PackageInfo) (obj1)).versionCode).append("").toString();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (!context.equals(""))
        {
            f = context;
        }
    }

    private void d()
    {
        h.put("u-appbid", d);
        h.put("u-appdnm", e);
        h.put("u-appver", f);
    }

    public String b()
    {
        return g;
    }

    public Map c()
    {
        return h;
    }

}

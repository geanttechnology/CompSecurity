// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

// Referenced classes of package com.flurry.sdk:
//            lk, ll, kg, js

public class jo
    implements ll.a
{

    private static jo a;
    private static final String b = com/flurry/sdk/jo.getSimpleName();
    private String c;
    private String d;

    private jo()
    {
        lk lk1 = lk.a();
        c = (String)lk1.a("VersionName");
        lk1.a("VersionName", this);
        kg.a(4, b, (new StringBuilder()).append("initSettings, VersionName = ").append(c).toString());
    }

    public static jo a()
    {
        com/flurry/sdk/jo;
        JVM INSTR monitorenter ;
        jo jo1;
        if (a == null)
        {
            a = new jo();
        }
        jo1 = a;
        com/flurry/sdk/jo;
        JVM INSTR monitorexit ;
        return jo1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        if (a != null)
        {
            lk.a().b("VersionName", a);
        }
        a = null;
    }

    private String f()
    {
        Object obj;
        obj = js.a().c();
        obj = ((Context) (obj)).getPackageManager().getPackageInfo(((Context) (obj)).getPackageName(), 0);
        if (((PackageInfo) (obj)).versionName != null)
        {
            return ((PackageInfo) (obj)).versionName;
        }
        if (((PackageInfo) (obj)).versionCode == 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        obj = Integer.toString(((PackageInfo) (obj)).versionCode);
        return ((String) (obj));
        Throwable throwable;
        throwable;
        kg.a(6, b, "", throwable);
        return "Unknown";
    }

    public void a(String s, Object obj)
    {
        if (s.equals("VersionName"))
        {
            c = (String)obj;
            kg.a(4, b, (new StringBuilder()).append("onSettingUpdate, VersionName = ").append(c).toString());
            return;
        } else
        {
            kg.a(6, b, "onSettingUpdate internal error!");
            return;
        }
    }

    public String c()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public String d()
    {
        return Build.DEVICE;
    }

    public String e()
    {
        this;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(c)) goto _L2; else goto _L1
_L1:
        String s = c;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (!TextUtils.isEmpty(d))
        {
            s = d;
            continue; /* Loop/switch isn't completed */
        }
        d = f();
        s = d;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}

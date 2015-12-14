// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.a;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.pf.common.utility.m;
import java.io.File;

public class a
{

    private static final boolean a;

    public a()
    {
    }

    private static boolean f()
    {
        String s;
        Object obj;
        obj = Globals.d();
        s = "1.0";
        obj = ((Application) (obj)).getPackageManager().getPackageInfo(((Application) (obj)).getPackageName(), 0).versionName;
        s = ((String) (obj));
_L2:
        int i = s.indexOf(" ");
        String s1 = s;
        if (i >= 0)
        {
            s1 = s.substring(0, i);
        }
        return (new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/cyberlink/ads/").append(s1).toString())).exists();
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        m.e("AdMobUtils", (new StringBuilder()).append("NameNotFoundException: e").append(namenotfoundexception).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a()
    {
    }

    public void a(Activity activity, com.cyberlink.youcammakeup.flurry.ClickAdsEvent.SourceName sourcename)
    {
    }

    public void a(View view)
    {
    }

    public void a(ViewGroup viewgroup, View view, Activity activity)
    {
    }

    public void b()
    {
    }

    public void b(View view)
    {
    }

    public void c()
    {
    }

    public void c(View view)
    {
    }

    public void d()
    {
    }

    public void d(View view)
    {
    }

    public void e()
    {
    }

    static 
    {
        boolean flag = Boolean.parseBoolean(Globals.d().getString(0x7f070738));
        if (f() || flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        m.b("AdMobUtils", (new StringBuilder()).append("isAdMobInTestMode=").append(a).toString());
    }
}

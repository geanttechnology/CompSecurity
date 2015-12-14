// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cyberlink.youcammakeup.Globals;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.a:
//            c

public class b
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public b()
    {
        a = "";
        b = "";
        c = "";
        e = "";
        d = "";
        d();
    }

    public static b a()
    {
        return com.cyberlink.youcammakeup.widgetpool.a.c.a();
    }

    private void d()
    {
        Object obj = Globals.d().getApplicationContext().getPackageManager();
        String s = Globals.d().getApplicationContext().getPackageName();
        e = s;
        try
        {
            obj = ((PackageManager) (obj)).getPackageInfo(s, 0);
            a = String.valueOf(((PackageInfo) (obj)).versionCode);
            b = String.valueOf(((PackageInfo) (obj)).versionName);
            obj = Globals.d().getApplicationContext();
            c = (new StringBuilder()).append(((Context) (obj)).getString(0x7f07073e)).append(" (").append(((Context) (obj)).getString(0x7f07073f)).append(")").toString();
            d = ((Context) (obj)).getString(0x7f070733);
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            m.e("ProductInfo", namenotfoundexception.toString());
        }
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return d;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

public class al
{

    public a a;
    private String b;
    private Context c;

    public al(Context context, String s)
    {
        a = new a();
        c = context;
        b = s;
    }

    public al a()
    {
        boolean flag = true;
        Object obj;
        obj = c.getPackageManager().getPackageInfo(b, 0);
        a.a = b;
        a.b = ((PackageInfo) (obj)).versionName;
        a.c = ((PackageInfo) (obj)).versionCode;
        a.e = ((PackageInfo) (obj)).applicationInfo.sourceDir;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (!((PackageInfo) (obj)).applicationInfo.sourceDir.startsWith(Environment.getExternalStorageState()))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        a.d = false;
        return this;
        try
        {
            a.d = true;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
            return this;
        }
        return this;
        a a1 = a;
        if ((((PackageInfo) (obj)).applicationInfo.flags & 0x40000) != 0)
        {
            flag = false;
        }
        a1.d = flag;
        return this;
    }

    private class a
    {

        public String a;
        public String b;
        public int c;
        public boolean d;
        public String e;

        public boolean a()
        {
            return a.equals("unknown");
        }

        public a()
        {
            a = "unknown";
            b = "unknown";
            c = 0;
            d = true;
            e = "";
        }
    }

}

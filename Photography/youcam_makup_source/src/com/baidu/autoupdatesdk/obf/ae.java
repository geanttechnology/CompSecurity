// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ae
{

    public ae()
    {
    }

    public static void a(Context context)
    {
        Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
        intent.putExtra("backop", "0");
        intent.putExtra("id", context.getPackageName());
        intent.putExtra("func", "10");
        intent.putExtra("pkg", context.getPackageName());
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            intent.addFlags(32);
        }
        intent.addFlags(0x10000000);
        context.startActivity(intent);
    }

    public static boolean b(Context context)
    {
        int i = context.getPackageManager().getPackageInfo("com.baidu.appsearch", 64).versionCode;
        if (i > 0x100143a)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_28;
        context;
        context.printStackTrace();
        return false;
    }
}

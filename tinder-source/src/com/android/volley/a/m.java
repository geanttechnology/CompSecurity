// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import com.android.volley.h;
import java.io.File;

// Referenced classes of package com.android.volley.a:
//            g, a, c, d, 
//            f

public final class m
{

    public static h a(Context context, f f)
    {
        Object obj;
        File file;
        file = new File(context.getCacheDir(), "volley");
        obj = "volley/0";
        String s = context.getPackageName();
        context = context.getPackageManager().getPackageInfo(s, 0);
        context = (new StringBuilder()).append(s).append("/").append(((PackageInfo) (context)).versionCode).toString();
        obj = context;
_L2:
        context = f;
        if (f == null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                context = new g();
            } else
            {
                context = new d(AndroidHttpClient.newInstance(((String) (obj))));
            }
        }
        context = new a(context);
        context = new h(new c(file), context, (byte)0);
        context.a();
        return context;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import com.a.a.n;
import java.io.File;

// Referenced classes of package com.a.a.a:
//            g, a, c, d, 
//            f

public class m
{

    public static n a(Context context)
    {
        return a(context, null);
    }

    public static n a(Context context, f f)
    {
        return a(context, f, -1);
    }

    public static n a(Context context, f f, int i)
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
        if (i <= -1)
        {
            context = new n(new c(file), context);
        } else
        {
            context = new n(new c(file, i), context);
        }
        context.a();
        return context;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

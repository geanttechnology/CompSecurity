// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import java.io.File;

// Referenced classes of package android.support.v7:
//            yl, yf, vg, yh, 
//            yi, yk

public class lr
{

    public static vg a(Context context)
    {
        return a(context, null);
    }

    public static vg a(Context context, yk yk)
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
        context = yk;
        if (yk == null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                context = new yl();
            } else
            {
                context = new yi(AndroidHttpClient.newInstance(((String) (obj))));
            }
        }
        context = new yf(context);
        context = new vg(new yh(file), context);
        context.a();
        return context;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

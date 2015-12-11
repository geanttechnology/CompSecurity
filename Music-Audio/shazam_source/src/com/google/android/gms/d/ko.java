// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.e.aj;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            km, ki, kn, kj, 
//            kd, kl, il, kk, 
//            jy

public final class ko
    implements Runnable
{

    private final Context a;
    private final kn b;
    private final km c;
    private final kd d;
    private final ki e;

    public ko(Context context, kd kd1, kn kn1)
    {
        this(context, kd1, kn1, new km(), new ki());
    }

    private ko(Context context, kd kd1, kn kn1, km km1, ki ki1)
    {
        w.a(context);
        w.a(kn1);
        a = context;
        d = kd1;
        b = kn1;
        c = km1;
        e = ki1;
    }

    public ko(Context context, kd kd1, kn kn1, String s)
    {
        this(context, kd1, kn1, new km(), new ki());
        e.a = s;
        aj.c();
    }

    private boolean a(String s)
    {
        return a.getPackageManager().checkPermission(s, a.getPackageName()) == 0;
    }

    public final void run()
    {
        Object obj;
        Object obj1;
        boolean flag1;
        boolean flag;
        if (!a("android.permission.INTERNET"))
        {
            aj.a("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
            flag = false;
        } else
        if (!a("android.permission.ACCESS_NETWORK_STATE"))
        {
            aj.a("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
            flag = false;
        } else
        {
            NetworkInfo networkinfo = ((ConnectivityManager)a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo == null || !networkinfo.isConnected())
            {
                aj.a();
                flag = false;
            } else
            {
                flag = true;
            }
        }
        if (!flag)
        {
            b.a(kn.a.a);
            return;
        }
        aj.d();
        Object obj2;
        ByteArrayOutputStream bytearrayoutputstream;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            obj = new kj();
        } else
        {
            obj = new kk();
        }
        obj2 = e;
        obj1 = d.a;
        obj2 = (new StringBuilder()).append(((ki) (obj2)).a).append("/gtm/android?");
        if (((List) (obj1)).size() <= 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        w.b(flag1);
        if (!((List) (obj1)).isEmpty()) goto _L2; else goto _L1
_L1:
        obj1 = "";
_L5:
        obj1 = ((StringBuilder) (obj2)).append(((String) (obj1))).toString();
        obj2 = ((kl) (obj)).a(((String) (obj1)));
        bytearrayoutputstream = new ByteArrayOutputStream();
        il.a(((java.io.InputStream) (obj2)), bytearrayoutputstream, false);
        b.a(bytearrayoutputstream.toByteArray());
        ((kl) (obj)).a();
        aj.d();
        return;
_L2:
        jy jy1;
        jy1 = (jy)((List) (obj1)).get(0);
        if (jy1.e.trim().equals(""))
        {
            break MISSING_BLOCK_LABEL_528;
        }
        obj1 = jy1.e.trim();
_L7:
        StringBuilder stringbuilder = new StringBuilder();
        if (jy1.c == null) goto _L4; else goto _L3
_L3:
        stringbuilder.append(jy1.c);
_L6:
        stringbuilder.append("=").append(ki.a(jy1.a)).append("&pv=").append(ki.a(((String) (obj1))));
        if (jy1.d)
        {
            stringbuilder.append("&gtm_debug=x");
        }
        obj1 = stringbuilder.toString();
          goto _L5
_L4:
        stringbuilder.append("id");
          goto _L6
        obj1;
        ((kl) (obj)).a();
        throw obj1;
        Object obj3;
        obj3;
        aj.a((new StringBuilder("NetworkLoader: No data is retrieved from the given url: ")).append(((String) (obj1))).toString());
        b.a(kn.a.c);
        ((kl) (obj)).a();
        return;
        obj3;
        aj.a((new StringBuilder("NetworkLoader: Error when loading resource from url: ")).append(((String) (obj1))).append(" ").append(((IOException) (obj3)).getMessage()).toString(), ((Throwable) (obj3)));
        b.a(kn.a.b);
        ((kl) (obj)).a();
        return;
        obj3;
        aj.a((new StringBuilder("NetworkLoader: Error when parsing downloaded resources from url: ")).append(((String) (obj1))).append(" ").append(((IOException) (obj3)).getMessage()).toString(), ((Throwable) (obj3)));
        b.a(kn.a.c);
        ((kl) (obj)).a();
        return;
        obj1 = "-1";
          goto _L7
    }
}

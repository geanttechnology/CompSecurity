// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.ads.internal.p;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ay, ax, gm, ft, 
//            fs

public final class az
{

    boolean a;
    String b;
    Map c;
    Context d;
    String e;

    public az(Context context, String s)
    {
        d = null;
        e = null;
        d = context;
        e = s;
        Object obj = ay.G;
        a = ((Boolean)p.n().a(((au) (obj)))).booleanValue();
        obj = ay.H;
        b = (String)p.n().a(((au) (obj)));
        c = new LinkedHashMap();
        c.put("s", "gmob_sdk");
        c.put("v", "3");
        c.put("os", android.os.Build.VERSION.RELEASE);
        c.put("sdk", android.os.Build.VERSION.SDK);
        obj = c;
        p.e();
        ((Map) (obj)).put("device", gm.b());
        c.put("ua", p.e().a(context, s));
        obj = c;
        if (context.getApplicationContext() != null)
        {
            s = context.getApplicationContext().getPackageName();
        } else
        {
            s = context.getPackageName();
        }
        ((Map) (obj)).put("app", s);
        p.e();
        if (gm.a(context.getPackageManager(), context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
        {
            context = p.k().a(d);
            c.put("network_coarse", Integer.toString(((fs) (context)).m));
            c.put("network_fine", Integer.toString(((fs) (context)).n));
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            nn, nj, tp, sm, 
//            sl

public class no
{

    private boolean a;
    private String b;
    private Map c;
    private Context d;
    private String e;

    public no(Context context, String s)
    {
        d = null;
        e = null;
        d = context;
        e = s;
        a = ((Boolean)nn.G.c()).booleanValue();
        b = (String)nn.H.c();
        c = new LinkedHashMap();
        c.put("s", "gmob_sdk");
        c.put("v", "3");
        c.put("os", android.os.Build.VERSION.RELEASE);
        c.put("sdk", android.os.Build.VERSION.SDK);
        c.put("device", zzp.zzbx().d());
        c.put("ua", zzp.zzbx().a(context, s));
        Map map = c;
        if (context.getApplicationContext() != null)
        {
            s = context.getApplicationContext().getPackageName();
        } else
        {
            s = context.getPackageName();
        }
        map.put("app", s);
        if (zzp.zzbx().a(context.getPackageManager(), context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
        {
            context = zzp.zzbD().a(d);
            c.put("network_coarse", Integer.toString(((sl) (context)).m));
            c.put("network_fine", Integer.toString(((sl) (context)).n));
        }
    }

    boolean a()
    {
        return a;
    }

    String b()
    {
        return b;
    }

    Context c()
    {
        return d;
    }

    String d()
    {
        return e;
    }

    Map e()
    {
        return c;
    }
}

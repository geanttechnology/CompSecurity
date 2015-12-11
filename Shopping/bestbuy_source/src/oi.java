// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdView;
import java.util.Iterator;
import java.util.Set;

public final class oi
    implements pa, pc
{

    private AdView a;
    private op b;

    public oi()
    {
    }

    static om a(Context context, oy oy1, Bundle bundle, Bundle bundle1)
    {
        on on1 = new on();
        Object obj = oy1.a();
        if (obj != null)
        {
            on1.a(((java.util.Date) (obj)));
        }
        int i = oy1.b();
        if (i != 0)
        {
            on1.a(i);
        }
        obj = oy1.c();
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); on1.a((String)((Iterator) (obj)).next())) { }
        }
        obj = oy1.d();
        if (obj != null)
        {
            on1.a(((android.location.Location) (obj)));
        }
        if (oy1.e())
        {
            on1.b(aca.a(context));
        }
        if (bundle1.getInt("tagForChildDirectedTreatment") != -1)
        {
            boolean flag;
            if (bundle1.getInt("tagForChildDirectedTreatment") == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            on1.a(flag);
        }
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle1.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle1.getString("adJson")))
        {
            bundle.putString("_ad", bundle1.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        on1.a(oi, bundle);
        return on1.a();
    }

    public void a()
    {
        if (a != null)
        {
            a.a();
            a = null;
        }
        if (b != null)
        {
            b = null;
        }
    }

    public void a(Context context, pb pb, Bundle bundle, oo oo1, oy oy1, Bundle bundle1)
    {
        a = new AdView(context);
        a.setAdSize(new oo(oo1.b(), oo1.a()));
        a.setAdUnitId(bundle.getString("pubid"));
        a.setAdListener(new oj(this, pb));
        a.a(a(context, oy1, bundle1, bundle));
    }

    public void a(Context context, pd pd, Bundle bundle, oy oy1, Bundle bundle1)
    {
        b = new op(context);
        b.a(bundle.getString("pubid"));
        b.a(new ok(this, pd));
        b.a(a(context, oy1, bundle1, bundle));
    }

    public void b()
    {
        if (a != null)
        {
            a.c();
        }
    }

    public void c()
    {
        if (a != null)
        {
            a.d();
        }
    }

    public View d()
    {
        return a;
    }

    public void e()
    {
        b.a();
    }
}

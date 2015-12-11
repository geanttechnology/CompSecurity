// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.g;

import android.app.Activity;
import com.shazam.model.advert.AdvertSiteIdKey;
import java.util.concurrent.Executor;

// Referenced classes of package com.shazam.android.advert.g:
//            b, c, g, e

public final class f
    implements b
{

    private final Activity a;
    private final Executor b;
    private final e c[];
    private g d;

    public transient f(Activity activity, Executor executor, e ae[])
    {
        a = activity;
        b = executor;
        c = ae;
    }

    public final void a()
    {
        if (d != null)
        {
            d.a = c.b;
            d = null;
        }
        e ae[] = c;
        int j = ae.length;
        for (int i = 0; i < j; i++)
        {
            ae[i].a();
        }

    }

    public final void a(AdvertSiteIdKey advertsiteidkey, int i, c c1)
    {
        d = new g(a, c, advertsiteidkey, i, c1);
        b.execute(d);
    }
}

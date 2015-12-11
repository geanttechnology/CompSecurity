// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            AdViewManager, ad, aw, ay, 
//            au, a, n

class b
    implements b
{

    final AdViewManager a;
    private Context b;

    public int a(aw aw1)
    {
        return a(aw1, -1);
    }

    public int a(aw aw1, int k)
    {
        return a(aw1, k, null);
    }

    public int a(aw aw1, int k, List list)
    {
        int l = -1;
        if (aw1 != null)
        {
            ad.d((new StringBuilder()).append("Starting Event: ").append(ad.D()).append("ms ").append(aw1.a().a()).append(" ").append(aw1.h()).append(" ").append(aw1.c()).toString());
            k = AdViewManager.b(a).a(aw1, k, null, null);
            l = k;
            if (aw1.g())
            {
                AdViewManager.a(a, k);
                l = k;
            }
        }
        return l;
    }

    public void a(int k)
    {
        if (k != -1)
        {
            AdViewManager.b(a).a(k);
            a a1 = AdViewManager.b(a).b(k);
            aw aw1 = a1.a;
            ad.d((new StringBuilder()).append("Ending Event: ").append(a1.a).append("ms ").append(aw1.a().a()).append(" ").append(aw1.h()).append(" ").append(aw1.c()).toString());
            if (!aw1.g())
            {
                AdViewManager.a(a, k);
            }
        }
    }

    public void a(a a1)
    {
        ad.d(" ");
        ad.d("<<< Ad End");
        ad.d(" ");
        ad.A().h();
        AdViewManager.a(a);
    }

    public void b(int k)
    {
    }

    public n g()
    {
        return a.c;
    }

    public Context h()
    {
        return b;
    }

    public int i()
    {
        return 0;
    }

    public int j()
    {
        return -1;
    }

    public _cls9(AdViewManager adviewmanager, Context context, ay ay1)
    {
        a = adviewmanager;
        super();
        b = context;
        AdViewManager.a(adviewmanager, ay1);
    }
}

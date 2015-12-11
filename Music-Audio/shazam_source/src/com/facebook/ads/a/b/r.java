// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;
import com.facebook.ads.a.f.o;
import com.facebook.ads.a.f.s;
import com.facebook.ads.a.g.b;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.facebook.ads.a.b:
//            g, q, h

public class r extends g
{

    private static final String c = com/facebook/ads/a/b/r.getSimpleName();
    public q b;
    private final b d;

    public r(Context context, b b1, h h)
    {
        super(context, h);
        d = b1;
    }

    public final void a(Map map)
    {
        String s1;
        if (b != null)
        {
            if (!s.a(s1 = b.c))
            {
                (new o(map)).execute(new String[] {
                    s1
                });
                return;
            }
        }
    }

    protected final void b()
    {
        if (b == null)
        {
            return;
        }
        if (d != null && !s.a("facebookAd.sendImpression();") && !d.a)
        {
            d.loadUrl("javascript:facebookAd.sendImpression();");
        }
        a(Collections.singletonMap("evt", "native_imp"));
    }

}

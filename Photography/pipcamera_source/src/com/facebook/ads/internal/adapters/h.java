// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dto.d;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.view.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            BannerAdapter, k, BannerAdapterListener, l, 
//            j, b

public class h extends BannerAdapter
{

    private static final String a = com/facebook/ads/internal/adapters/h.getSimpleName();
    private a b;
    private l c;
    private BannerAdapterListener d;
    private Map e;
    private j f;
    private Context g;
    private long h;
    private com.facebook.ads.internal.util.b.a i;

    public h()
    {
    }

    static long a(h h1, long l1)
    {
        h1.h = l1;
        return l1;
    }

    static BannerAdapterListener a(h h1)
    {
        return h1.d;
    }

    static com.facebook.ads.internal.util.b.a a(h h1, com.facebook.ads.internal.util.b.a a1)
    {
        h1.i = a1;
        return a1;
    }

    static String a()
    {
        return a;
    }

    private void a(d d1)
    {
        h = 0L;
        i = null;
        k k1 = com.facebook.ads.internal.adapters.k.a((JSONObject)e.get("data"));
        if (com.facebook.ads.internal.util.f.a(g, k1))
        {
            d.onBannerError(this, AdError.NO_FILL);
        } else
        {
            b = new a(g, new com.facebook.ads.internal.view.a.a(k1) {

                final k a;
                final h b;

                public void a()
                {
                    com.facebook.ads.internal.adapters.h.c(b).c();
                }

                public void a(int i1)
                {
                    if (i1 == 0 && com.facebook.ads.internal.adapters.h.d(b) > 0L && h.e(b) != null)
                    {
                        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(com.facebook.ads.internal.adapters.h.d(b), h.e(b), a.i()));
                        com.facebook.ads.internal.adapters.h.a(b, 0L);
                        com.facebook.ads.internal.adapters.h.a(b, null);
                    }
                }

                public void a(String s)
                {
                    if (com.facebook.ads.internal.adapters.h.a(b) != null)
                    {
                        com.facebook.ads.internal.adapters.h.a(b).onBannerAdClicked(b);
                    }
                    s = Uri.parse(s);
                    s = com.facebook.ads.internal.action.b.a(com.facebook.ads.internal.adapters.h.b(b), s);
                    if (s == null)
                    {
                        break MISSING_BLOCK_LABEL_74;
                    }
                    com.facebook.ads.internal.adapters.h.a(b, s.a());
                    com.facebook.ads.internal.adapters.h.a(b, System.currentTimeMillis());
                    s.b();
                    return;
                    s;
                    Log.e(com.facebook.ads.internal.adapters.h.a(), "Error executing action", s);
                    return;
                }

                public void b()
                {
                    b.onViewableImpression();
                }

            
            {
                b = h.this;
                a = k1;
                super();
            }
            }, d1.e());
            b.a(d1.f(), d1.g());
            c = new l(g, b, new com.facebook.ads.internal.adapters.b() {

                final h a;

                public void d()
                {
                    if (com.facebook.ads.internal.adapters.h.a(a) != null)
                    {
                        com.facebook.ads.internal.adapters.h.a(a).onBannerLoggingImpression(a);
                    }
                }

            
            {
                a = h.this;
                super();
            }
            });
            c.a(k1);
            b.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), k1.d(), "text/html", "utf-8", null);
            if (d != null)
            {
                d.onBannerAdLoaded(this, b);
                return;
            }
        }
    }

    static Context b(h h1)
    {
        return h1.g;
    }

    static l c(h h1)
    {
        return h1.c;
    }

    static long d(h h1)
    {
        return h1.h;
    }

    static com.facebook.ads.internal.util.b.a e(h h1)
    {
        return h1.i;
    }

    public void loadBannerAd(Context context, AdSize adsize, BannerAdapterListener banneradapterlistener, Map map)
    {
        g = context;
        d = banneradapterlistener;
        e = map;
        a((d)map.get("definition"));
    }

    public void onDestroy()
    {
        if (b != null)
        {
            com.facebook.ads.internal.util.h.a(b);
            b.destroy();
            b = null;
        }
        if (f != null)
        {
            f.onDestroy();
            f = null;
        }
    }

    public void onViewableImpression()
    {
        if (c != null)
        {
            c.a();
        } else
        if (f != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("mil", Boolean.valueOf(false));
            f.a(hashmap);
            return;
        }
    }

}

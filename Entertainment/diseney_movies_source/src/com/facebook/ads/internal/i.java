// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.e;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.adapters.o;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.a;
import com.facebook.ads.internal.server.d;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.t;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal:
//            AdErrorType, e, c, b

public class i
    implements com.facebook.ads.internal.server.a.a
{
    public static interface a
    {

        public abstract void a(com.facebook.ads.internal.b b1);

        public abstract void a(List list);
    }

    private static final class b extends t
    {

        public void run()
        {
            i i1 = (i)a();
            if (i1 == null)
            {
                return;
            }
            if (com.facebook.ads.internal.util.g.a(com.facebook.ads.internal.i.a(i1)))
            {
                i1.a();
                return;
            } else
            {
                com.facebook.ads.internal.i.c(i1).postDelayed(i.b(i1), 5000L);
                return;
            }
        }

        public b(i i1)
        {
            super(i1);
        }
    }


    private final Context a;
    private final String b;
    private final com.facebook.ads.internal.server.a c = new com.facebook.ads.internal.server.a();
    private final com.facebook.ads.internal.e d;
    private final com.facebook.ads.internal.c e;
    private final AdSize f;
    private final int g;
    private boolean h;
    private final Handler i = new Handler();
    private final Runnable j = new b(this);
    private a k;
    private c l;

    public i(Context context, String s, com.facebook.ads.internal.e e1, AdSize adsize, com.facebook.ads.internal.c c1, int i1, EnumSet enumset)
    {
        a = context;
        b = s;
        d = e1;
        f = adsize;
        e = c1;
        g = i1;
        c.a(this);
        h = true;
    }

    static Context a(i i1)
    {
        return i1.a;
    }

    static Runnable b(i i1)
    {
        return i1.j;
    }

    static Handler c(i i1)
    {
        return i1.i;
    }

    private List d()
    {
        c c1 = l;
        com.facebook.ads.internal.dto.a a1 = c1.c();
        ArrayList arraylist = new ArrayList(c1.b());
        for (; a1 != null; a1 = c1.c())
        {
            AdAdapter adadapter = com.facebook.ads.internal.adapters.e.a(a1.b, AdPlacementType.NATIVE);
            if (adadapter != null && adadapter.getPlacementType() == AdPlacementType.NATIVE)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("data", a1.c);
                hashmap.put("definition", c1.a());
                ((n)adadapter).a(a, new o(arraylist) {

                    final List a;
                    final i b;

                    public void a(n n1)
                    {
                        a.add(n1);
                    }

                    public void a(n n1, AdError aderror)
                    {
                    }

            
            {
                b = i.this;
                a = list;
                super();
            }
                }, hashmap);
            }
        }

        return arraylist;
    }

    public void a()
    {
        com.facebook.ads.internal.dto.e e1 = new com.facebook.ads.internal.dto.e(a, b, f, d, e, g, AdSettings.isTestMode(a));
        c.a(a, e1);
    }

    public void a(com.facebook.ads.internal.b b1)
    {
        if (h)
        {
            i.postDelayed(j, 0x1b7740L);
        }
        if (k != null)
        {
            k.a(b1);
        }
    }

    public void a(a a1)
    {
        k = a1;
    }

    public void a(d d1)
    {
label0:
        {
            d1 = d1.b();
            if (d1 == null)
            {
                throw new IllegalStateException("no placement in response");
            }
            if (h)
            {
                long l2 = d1.a().b();
                long l1 = l2;
                if (l2 == 0L)
                {
                    l1 = 0x1b7740L;
                }
                i.postDelayed(j, l1);
            }
            l = d1;
            d1 = d();
            if (k != null)
            {
                if (!d1.isEmpty())
                {
                    break label0;
                }
                k.a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
            }
            return;
        }
        k.a(d1);
    }

    public void b()
    {
    }

    public void c()
    {
        h = false;
        i.removeCallbacks(j);
    }
}

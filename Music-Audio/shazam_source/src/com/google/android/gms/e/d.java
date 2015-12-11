// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.google.android.gms.e:
//            c, cd, dc, aj, 
//            dg, bx, cy, bw, 
//            cz

public class d
{
    public static interface a
    {

        public abstract cz a(Context context, d d1, String s, dc dc1);
    }


    private static d g;
    public final a a;
    public final Context b;
    final c c;
    final bw d;
    final ConcurrentMap e = new ConcurrentHashMap();
    public final dc f = new dc();

    private d(Context context, a a1, c c1, bw bw)
    {
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        }
        b = context.getApplicationContext();
        d = bw;
        a = a1;
        c = c1;
        c.a(new c.b() {

            final d a;

            public final void a(Map map)
            {
                map = ((Map) (map.get("event")));
                if (map != null)
                {
                    d.a(a, map.toString());
                }
            }

            
            {
                a = d.this;
                super();
            }
        });
        c.a(new cd(b));
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b.registerComponentCallbacks(new ComponentCallbacks2() {

                final d a;

                public final void onConfigurationChanged(Configuration configuration)
                {
                }

                public final void onLowMemory()
                {
                }

                public final void onTrimMemory(int i)
                {
                    if (i == 20)
                    {
                        a.d.a();
                    }
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    public static d a(Context context)
    {
        com/google/android/gms/e/d;
        JVM INSTR monitorenter ;
        if (g != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        aj.a("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
        context;
        com/google/android/gms/e/d;
        JVM INSTR monitorexit ;
        throw context;
        g = new d(context, new a() {

            public final cz a(Context context1, d d1, String s, dc dc1)
            {
                return new cz(context1, d1, s, dc1);
            }

        }, new c(new dg(context)), bx.c());
        context = g;
        com/google/android/gms/e/d;
        JVM INSTR monitorexit ;
        return context;
    }

    static void a(d d1, String s)
    {
        for (d1 = d1.e.keySet().iterator(); d1.hasNext(); ((cy)d1.next()).a(s)) { }
    }
}

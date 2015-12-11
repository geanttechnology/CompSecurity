// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.c.k;
import com.google.android.gms.ads.internal.util.client.a;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            m

public final class z
{
    public static final class a
    {

        public final HashSet a = new HashSet();
        final Bundle b = new Bundle();
        final HashMap c = new HashMap();
        public final HashSet d = new HashSet();
        final Bundle e = new Bundle();
        final HashSet f = new HashSet();
        public Date g;
        String h;
        public int i;
        public Location j;
        boolean k;
        String l;
        String m;
        public int n;

        public final void a(k k1)
        {
            if (k1 instanceof com.google.android.gms.ads.c.a.a)
            {
                a(com/google/ads/mediation/admob/AdMobAdapter, ((com.google.android.gms.ads.c.a.a)k1).a);
                return;
            } else
            {
                c.put(k1.getClass(), k1);
                return;
            }
        }

        public final void a(Class class1, Bundle bundle)
        {
            b.putBundle(class1.getName(), bundle);
        }

        public final void a(String s)
        {
            d.add(s);
        }

        public a()
        {
            i = -1;
            k = false;
            n = -1;
        }
    }


    public static final String a = com.google.android.gms.ads.internal.util.client.a.a("emulator");
    final Date b;
    final String c;
    final int d;
    final Set e;
    final Location f;
    final boolean g;
    final Bundle h;
    final Map i;
    final String j;
    final String k;
    final com.google.android.gms.ads.e.a l;
    final int m;
    final Set n;
    final Bundle o;
    final Set p;

    public z(a a1)
    {
        this(a1, (byte)0);
    }

    private z(a a1, byte byte0)
    {
        b = a1.g;
        c = a1.h;
        d = a1.i;
        e = Collections.unmodifiableSet(a1.a);
        f = a1.j;
        g = a1.k;
        h = a1.b;
        i = Collections.unmodifiableMap(a1.c);
        j = a1.l;
        k = a1.m;
        l = null;
        m = a1.n;
        n = Collections.unmodifiableSet(a1.d);
        o = a1.e;
        p = Collections.unmodifiableSet(a1.f);
    }

    static 
    {
        com.google.android.gms.ads.internal.client.m.a();
    }
}

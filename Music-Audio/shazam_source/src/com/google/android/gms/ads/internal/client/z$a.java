// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.c.a.a;
import com.google.android.gms.ads.c.k;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            z

public static final class n
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
        if (k1 instanceof a)
        {
            a(com/google/ads/mediation/admob/AdMobAdapter, ((a)k1).a);
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

    public ()
    {
        i = -1;
        k = false;
        n = -1;
    }
}

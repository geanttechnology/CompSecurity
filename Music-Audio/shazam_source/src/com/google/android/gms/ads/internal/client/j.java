// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.d.gm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            z, m, SearchAdRequestParcel, AdRequestParcel

public final class j
{

    public static final j a = new j();

    protected j()
    {
    }

    public static AdRequestParcel a(Context context, z z1)
    {
        Object obj = z1.b;
        Object obj1;
        Object obj2;
        String s;
        android.location.Location location;
        Bundle bundle;
        String s1;
        Context context1;
        int i;
        int k;
        long l;
        boolean flag;
        boolean flag1;
        if (obj != null)
        {
            l = ((Date) (obj)).getTime();
        } else
        {
            l = -1L;
        }
        s = z1.c;
        i = z1.d;
        obj = z1.e;
        if (!((Set) (obj)).isEmpty())
        {
            obj = Collections.unmodifiableList(new ArrayList(((java.util.Collection) (obj))));
        } else
        {
            obj = null;
        }
        obj1 = z1.n;
        com.google.android.gms.ads.internal.client.m.a();
        flag = ((Set) (obj1)).contains(com.google.android.gms.ads.internal.util.client.a.a(context));
        k = z1.m;
        location = z1.f;
        bundle = z1.h.getBundle(com/google/ads/mediation/admob/AdMobAdapter.getName());
        flag1 = z1.g;
        s1 = z1.j;
        obj1 = z1.l;
        if (obj1 != null)
        {
            obj1 = new SearchAdRequestParcel(((com.google.android.gms.ads.e.a) (obj1)));
        } else
        {
            obj1 = null;
        }
        obj2 = null;
        context1 = context.getApplicationContext();
        context = obj2;
        if (context1 != null)
        {
            context = context1.getPackageName();
            p.e();
            context = gm.a(Thread.currentThread().getStackTrace(), context);
        }
        return new AdRequestParcel(6, l, bundle, i, ((java.util.List) (obj)), flag, k, flag1, s1, ((SearchAdRequestParcel) (obj1)), location, s, z1.h, z1.o, Collections.unmodifiableList(new ArrayList(z1.p)), z1.k, context);
    }

    public static j a()
    {
        return a;
    }

}

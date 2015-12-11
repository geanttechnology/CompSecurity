// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            kx, o, ai

public final class v
    implements SafeParcelable
{

    public static final kx CREATOR = new kx();
    public final int a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final ai j;
    public final Location k;

    v(int l, long l1, Bundle bundle, int i1, List list, boolean flag, 
            int j1, boolean flag1, String s, ai ai1, Location location)
    {
        a = l;
        b = l1;
        c = bundle;
        d = i1;
        e = list;
        f = flag;
        g = j1;
        h = flag1;
        i = s;
        j = ai1;
        k = location;
    }

    public v(Context context, o o1)
    {
        Object obj1 = null;
        super();
        a = 2;
        Object obj = o1.b;
        long l;
        if (obj != null)
        {
            l = ((Date) (obj)).getTime();
        } else
        {
            l = -1L;
        }
        b = l;
        d = o1.c;
        obj = o1.d;
        if (!((Set) (obj)).isEmpty())
        {
            obj = Collections.unmodifiableList(new ArrayList(((java.util.Collection) (obj))));
        } else
        {
            obj = null;
        }
        e = ((List) (obj));
        f = o1.a(context);
        g = o1.j;
        k = o1.e;
        context = (AdMobExtras)o1.a(com/google/android/gms/ads/mediation/admob/AdMobExtras);
        if (context != null)
        {
            context = context.getExtras();
        } else
        {
            context = null;
        }
        c = context;
        h = o1.f;
        i = o1.h;
        o1 = o1.i;
        context = obj1;
        if (o1 != null)
        {
            context = new ai(o1);
        }
        j = context;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int l)
    {
        kx.a(this, parcel, l);
    }

}

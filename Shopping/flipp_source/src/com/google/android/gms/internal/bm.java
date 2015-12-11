// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            ch, kq, ci, ew, 
//            u, cn, bj, cu

public final class bm
    implements SafeParcelable
{

    public static final ch CREATOR = new ch();
    public final int a;
    public final bj b;
    public final kq c;
    public final ci d;
    public final ew e;
    public final u f;
    public final String g;
    public final boolean h;
    public final String i;
    public final cn j;
    public final int k;
    public final int l;
    public final String m;
    public final cu n;

    bm(int i1, bj bj, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3, String s, 
            boolean flag, String s1, IBinder ibinder4, int j1, int k1, String s2, cu cu)
    {
        a = i1;
        b = bj;
        c = (kq)com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(ibinder));
        d = (ci)com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(ibinder1));
        e = (ew)com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(ibinder2));
        f = (u)com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(ibinder3));
        g = s;
        h = flag;
        i = s1;
        j = (cn)com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(ibinder4));
        k = j1;
        l = k1;
        m = s2;
        n = cu;
    }

    public bm(bj bj, kq kq1, ci ci1, cn cn1, cu cu)
    {
        a = 1;
        b = bj;
        c = kq1;
        d = ci1;
        e = null;
        f = null;
        g = null;
        h = false;
        i = null;
        j = cn1;
        k = -1;
        l = 4;
        m = null;
        n = cu;
    }

    public bm(kq kq1, ci ci1, cn cn1, ew ew1, int i1, cu cu)
    {
        a = 1;
        b = null;
        c = kq1;
        d = ci1;
        e = ew1;
        f = null;
        g = null;
        h = false;
        i = null;
        j = cn1;
        k = i1;
        l = 1;
        m = null;
        n = cu;
    }

    public bm(kq kq1, ci ci1, cn cn1, ew ew1, boolean flag, int i1, cu cu)
    {
        a = 1;
        b = null;
        c = kq1;
        d = ci1;
        e = ew1;
        f = null;
        g = null;
        h = flag;
        i = null;
        j = cn1;
        k = i1;
        l = 2;
        m = null;
        n = cu;
    }

    public bm(kq kq1, ci ci1, u u1, cn cn1, ew ew1, boolean flag, int i1, 
            String s, cu cu)
    {
        a = 1;
        b = null;
        c = kq1;
        d = ci1;
        e = ew1;
        f = u1;
        g = null;
        h = flag;
        i = null;
        j = cn1;
        k = i1;
        l = 3;
        m = s;
        n = cu;
    }

    public bm(kq kq1, ci ci1, u u1, cn cn1, ew ew1, boolean flag, int i1, 
            String s, String s1, cu cu)
    {
        a = 1;
        b = null;
        c = kq1;
        d = ci1;
        e = ew1;
        f = u1;
        g = s1;
        h = flag;
        i = s;
        j = cn1;
        k = i1;
        l = 3;
        m = null;
        n = cu;
    }

    public static bm a(Intent intent)
    {
        try
        {
            intent = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            intent.setClassLoader(com/google/android/gms/internal/bm.getClassLoader());
            intent = (bm)intent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public static void a(Intent intent, bm bm1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bm1);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        ch.a(this, parcel, i1);
    }

}

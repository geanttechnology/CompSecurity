// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import ahh;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ry;
import rz;
import sb;
import vb;
import ve;
import xg;
import xh;
import xj;

// Referenced classes of package com.google.android.gms.internal:
//            gu, do, gs, y

public final class dr
    implements SafeParcelable
{

    public static final xg CREATOR = new xg();
    public final int a;
    public final do b;
    public final ahh c;
    public final xh d;
    public final gu e;
    public final vb f;
    public final String g;
    public final boolean h;
    public final String i;
    public final xj j;
    public final int k;
    public final int l;
    public final String m;
    public final gs n;
    public final ve o;
    public final String p;
    public final y q;

    public dr(int i1, do do1, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3, String s, 
            boolean flag, String s1, IBinder ibinder4, int j1, int k1, String s2, gs gs, 
            IBinder ibinder5, String s3, y y)
    {
        a = i1;
        b = do1;
        c = (ahh)sb.a(rz.a(ibinder));
        d = (xh)sb.a(rz.a(ibinder1));
        e = (gu)sb.a(rz.a(ibinder2));
        f = (vb)sb.a(rz.a(ibinder3));
        g = s;
        h = flag;
        i = s1;
        j = (xj)sb.a(rz.a(ibinder4));
        k = j1;
        l = k1;
        m = s2;
        n = gs;
        o = (ve)sb.a(rz.a(ibinder5));
        p = s3;
        q = y;
    }

    public dr(ahh ahh1, xh xh1, vb vb1, xj xj1, gu gu1, boolean flag, int i1, 
            String s, gs gs, ve ve1)
    {
        a = 4;
        b = null;
        c = ahh1;
        d = xh1;
        e = gu1;
        f = vb1;
        g = null;
        h = flag;
        i = null;
        j = xj1;
        k = i1;
        l = 3;
        m = s;
        n = gs;
        o = ve1;
        p = null;
        q = null;
    }

    public dr(ahh ahh1, xh xh1, vb vb1, xj xj1, gu gu1, boolean flag, int i1, 
            String s, String s1, gs gs, ve ve1)
    {
        a = 4;
        b = null;
        c = ahh1;
        d = xh1;
        e = gu1;
        f = vb1;
        g = s1;
        h = flag;
        i = s;
        j = xj1;
        k = i1;
        l = 3;
        m = null;
        n = gs;
        o = ve1;
        p = null;
        q = null;
    }

    public dr(ahh ahh1, xh xh1, xj xj1, gu gu1, int i1, gs gs, String s, 
            y y)
    {
        a = 4;
        b = null;
        c = ahh1;
        d = xh1;
        e = gu1;
        f = null;
        g = null;
        h = false;
        i = null;
        j = xj1;
        k = i1;
        l = 1;
        m = null;
        n = gs;
        o = null;
        p = s;
        q = y;
    }

    public dr(ahh ahh1, xh xh1, xj xj1, gu gu1, boolean flag, int i1, gs gs)
    {
        a = 4;
        b = null;
        c = ahh1;
        d = xh1;
        e = gu1;
        f = null;
        g = null;
        h = flag;
        i = null;
        j = xj1;
        k = i1;
        l = 2;
        m = null;
        n = gs;
        o = null;
        p = null;
        q = null;
    }

    public dr(do do1, ahh ahh1, xh xh1, xj xj1, gs gs)
    {
        a = 4;
        b = do1;
        c = ahh1;
        d = xh1;
        e = null;
        f = null;
        g = null;
        h = false;
        i = null;
        j = xj1;
        k = -1;
        l = 4;
        m = null;
        n = gs;
        o = null;
        p = null;
        q = null;
    }

    public static dr a(Intent intent)
    {
        try
        {
            intent = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            intent.setClassLoader(com/google/android/gms/internal/dr.getClassLoader());
            intent = (dr)intent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public static void a(Intent intent, dr dr1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", dr1);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public IBinder a()
    {
        return sb.a(c).asBinder();
    }

    public IBinder b()
    {
        return sb.a(d).asBinder();
    }

    public IBinder c()
    {
        return sb.a(e).asBinder();
    }

    public IBinder d()
    {
        return sb.a(f).asBinder();
    }

    public int describeContents()
    {
        return 0;
    }

    public IBinder e()
    {
        return sb.a(o).asBinder();
    }

    public IBinder f()
    {
        return sb.a(j).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        xg.a(this, parcel, i1);
    }

}

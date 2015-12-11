// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ul, um, pq, qa, 
//            ps, pu

public class te
{
    public static final class a
    {

        public final AdRequestInfoParcel a;
        public final AdResponseParcel b;
        public final ps c;
        public final AdSizeParcel d;
        public final int e;
        public final long f;
        public final long g;
        public final JSONObject h;

        public a(AdRequestInfoParcel adrequestinfoparcel, AdResponseParcel adresponseparcel, ps ps, AdSizeParcel adsizeparcel, int i1, long l1, 
                long l2, JSONObject jsonobject)
        {
            a = adrequestinfoparcel;
            b = adresponseparcel;
            c = ps;
            d = adsizeparcel;
            e = i1;
            f = l1;
            g = l2;
            h = jsonobject;
        }
    }


    public final AdRequestParcel a;
    public final ul b;
    public final List c;
    public final int d;
    public final List e;
    public final List f;
    public final int g;
    public final long h;
    public final String i;
    public final JSONObject j;
    public final boolean k;
    public final pq l;
    public final qa m;
    public final String n;
    public final ps o;
    public final pu p;
    public final long q;
    public final AdSizeParcel r;
    public final long s;
    public final long t;
    public final long u;
    public final String v;
    public final com.google.android.gms.ads.internal.formats.zzh.zza w;
    public final String x;

    public te(a a1, ul ul1, pq pq, qa qa, String s1, pu pu, com.google.android.gms.ads.internal.formats.zzh.zza zza)
    {
        this(a1.a.zzDy, ul1, a1.b.zzyw, a1.e, a1.b.zzyx, a1.b.zzDZ, a1.b.orientation, a1.b.zzyA, a1.a.zzDB, a1.b.zzDX, pq, qa, s1, a1.c, pu, a1.b.zzDY, a1.d, a1.b.zzDW, a1.f, a1.g, a1.b.zzEc, a1.h, zza, a1.a.zzDO);
    }

    public te(AdRequestParcel adrequestparcel, ul ul1, List list, int i1, List list1, List list2, int j1, 
            long l1, String s1, boolean flag, pq pq, qa qa, String s2, 
            ps ps, pu pu, long l2, AdSizeParcel adsizeparcel, long l3, 
            long l4, long l5, String s3, JSONObject jsonobject, com.google.android.gms.ads.internal.formats.zzh.zza zza, 
            String s4)
    {
        a = adrequestparcel;
        b = ul1;
        if (list != null)
        {
            adrequestparcel = Collections.unmodifiableList(list);
        } else
        {
            adrequestparcel = null;
        }
        c = adrequestparcel;
        d = i1;
        if (list1 != null)
        {
            adrequestparcel = Collections.unmodifiableList(list1);
        } else
        {
            adrequestparcel = null;
        }
        e = adrequestparcel;
        if (list2 != null)
        {
            adrequestparcel = Collections.unmodifiableList(list2);
        } else
        {
            adrequestparcel = null;
        }
        f = adrequestparcel;
        g = j1;
        h = l1;
        i = s1;
        k = flag;
        l = pq;
        m = qa;
        n = s2;
        o = ps;
        p = pu;
        q = l2;
        r = adsizeparcel;
        s = l3;
        t = l4;
        u = l5;
        v = s3;
        j = jsonobject;
        w = zza;
        x = s4;
    }

    public boolean a()
    {
        if (b == null || b.i() == null)
        {
            return false;
        } else
        {
            return b.i().b();
        }
    }
}

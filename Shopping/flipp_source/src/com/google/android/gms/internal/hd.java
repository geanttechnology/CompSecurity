// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.google.android.gms.internal:
//            iy, jk, gx, jj, 
//            jm, gw, gy, hf

public final class hd extends iy
    implements SafeParcelable
{

    public static final jk CREATOR = new jk();
    final int a;
    final String b;
    final Bundle c;
    final hf d;
    final LatLng e;
    final float f;
    final LatLngBounds g;
    final String h;
    final Uri i;
    final boolean j;
    final float k;
    final int l;
    final long m;
    final List n;
    private final Map o;
    private final TimeZone p;
    private Locale q;
    private jm r;

    hd(int i1, String s, List list, Bundle bundle, hf hf, LatLng latlng, float f1, 
            LatLngBounds latlngbounds, String s1, Uri uri, boolean flag, float f2, int j1, long l1)
    {
        a = i1;
        b = s;
        n = Collections.unmodifiableList(list);
        c = bundle;
        d = hf;
        e = latlng;
        f = f1;
        g = latlngbounds;
        h = s1;
        i = uri;
        j = flag;
        k = f2;
        l = j1;
        m = l1;
        s = new HashMap();
        for (list = bundle.keySet().iterator(); list.hasNext(); s.put(gx.a(hf), bundle.getString(hf)))
        {
            hf = (String)list.next();
        }

        o = Collections.unmodifiableMap(s);
        p = TimeZone.getTimeZone(h);
        q = null;
        r = null;
    }

    final void a(String s)
    {
        if (r != null)
        {
            jm jm1 = r;
            s = new jj(b, s);
            s.c = jm1.a;
            s.d = jm1.b;
            jm1.c.offer(new a(0, ((jj) (s)).a, ((jj) (s)).b, ((jj) (s)).c, ((jj) (s)).d));
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hd))
            {
                return false;
            }
            obj = (hd)obj;
            if (!b.equals(((hd) (obj)).b) || !gw.a(q, ((hd) (obj)).q) || m != ((hd) (obj)).m)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, q, Long.valueOf(m)
        });
    }

    public final String toString()
    {
        return gw.a(this).a("id", b).a("localization", d).a("locale", q).a("latlng", e).a("levelNumber", Float.valueOf(f)).a("viewport", g).a("timeZone", h).a("websiteUri", i).a("isPermanentlyClosed", Boolean.valueOf(j)).a("priceLevel", Integer.valueOf(l)).a("timestampSecs", Long.valueOf(m)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        jk.a(this, parcel, i1);
    }


    private class a
        implements SafeParcelable
    {

        public static final jh CREATOR = new jh();
        final int a;
        final String b;
        final String c;
        final String d;
        final int e;

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof a))
                {
                    return false;
                }
                obj = (a)obj;
                if (!b.equals(((a) (obj)).b) || !gw.a(c, ((a) (obj)).c))
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            return Arrays.hashCode(new Object[] {
                b, c, d, Integer.valueOf(e)
            });
        }

        public final String toString()
        {
            return gw.a(this).a("placeId", b).a("tag", c).a("callingAppPackageName", d).a("callingAppVersionCode", Integer.valueOf(e)).toString();
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            jh.a(this, parcel);
        }


        a(int i1, String s, String s1, String s2, int j1)
        {
            a = i1;
            b = s;
            c = s1;
            d = s2;
            e = j1;
        }
    }

}

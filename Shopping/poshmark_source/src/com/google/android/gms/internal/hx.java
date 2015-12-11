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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package com.google.android.gms.internal:
//            hm, hy, ht, ic, 
//            ep, hz, hw

public final class hx extends hm
    implements SafeParcelable
{
    public static final class a
        implements SafeParcelable
    {

        public static final hw CREATOR = new hw();
        private final String LE;
        private final String Ot;
        private final int Ou;
        private final String mTag;
        final int wj;

        public int describeContents()
        {
            hw hw1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof a))
                {
                    return false;
                }
                obj = (a)obj;
                if (!LE.equals(((a) (obj)).LE) || !ep.equal(mTag, ((a) (obj)).mTag))
                {
                    return false;
                }
            }
            return true;
        }

        public String gH()
        {
            return Ot;
        }

        public int gI()
        {
            return Ou;
        }

        public String getTag()
        {
            return mTag;
        }

        public String gt()
        {
            return LE;
        }

        public int hashCode()
        {
            return ep.hashCode(new Object[] {
                LE, mTag, Ot, Integer.valueOf(Ou)
            });
        }

        public String toString()
        {
            return ep.e(this).a("placeId", LE).a("tag", mTag).a("callingAppPackageName", Ot).a("callingAppVersionCode", Integer.valueOf(Ou)).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            hw hw1 = CREATOR;
            hw.a(this, parcel, i);
        }


        a(int i, String s, String s1, String s2, int j)
        {
            wj = i;
            LE = s;
            mTag = s1;
            Ot = s2;
            Ou = j;
        }
    }

    public static class a.a
    {

        private final String LE;
        private String Ot;
        private int Ou;
        private final String mTag;

        public a.a aK(String s)
        {
            Ot = s;
            return this;
        }

        public a.a bv(int i)
        {
            Ou = i;
            return this;
        }

        public a gJ()
        {
            return new a(0, LE, mTag, Ot, Ou);
        }

        public a.a(String s, String s1)
        {
            LE = s;
            mTag = s1;
        }
    }


    public static final hy CREATOR = new hy();
    private final Bundle Od;
    private final hz Oe;
    private final LatLng Of;
    private final float Og;
    private final LatLngBounds Oh;
    private final String Oi;
    private final Uri Oj;
    private final boolean Ok;
    private final float Ol;
    private final int Om;
    private final long On;
    private final List Oo;
    private final Map Op;
    private final TimeZone Oq;
    private Locale Or;
    private ic Os;
    private final String uS;
    final int wj;

    hx(int i, String s, List list, Bundle bundle, hz hz, LatLng latlng, float f, 
            LatLngBounds latlngbounds, String s1, Uri uri, boolean flag, float f1, int j, long l)
    {
        wj = i;
        uS = s;
        Oo = Collections.unmodifiableList(list);
        Od = bundle;
        Oe = hz;
        Of = latlng;
        Og = f;
        Oh = latlngbounds;
        Oi = s1;
        Oj = uri;
        Ok = flag;
        Ol = f1;
        Om = j;
        On = l;
        s = new HashMap();
        for (list = bundle.keySet().iterator(); list.hasNext(); s.put(ht.aI(hz), bundle.getString(hz)))
        {
            hz = (String)list.next();
        }

        Op = Collections.unmodifiableMap(s);
        Oq = TimeZone.getTimeZone(Oi);
        Or = null;
        Os = null;
    }

    private void aJ(String s)
    {
        if (Os != null)
        {
            Os.a(new a.a(uS, s));
        }
    }

    public int describeContents()
    {
        hy hy1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hx))
            {
                return false;
            }
            obj = (hx)obj;
            if (!uS.equals(((hx) (obj)).uS) || !ep.equal(Or, ((hx) (obj)).Or) || On != ((hx) (obj)).On)
            {
                return false;
            }
        }
        return true;
    }

    public Uri gA()
    {
        aJ("getWebsiteUri");
        return Oj;
    }

    public boolean gB()
    {
        aJ("isPermanentlyClosed");
        return Ok;
    }

    public int gC()
    {
        aJ("getPriceLevel");
        return Om;
    }

    public long gD()
    {
        return On;
    }

    public Bundle gE()
    {
        return Od;
    }

    public hz gF()
    {
        return Oe;
    }

    public String gG()
    {
        return Oi;
    }

    public String getId()
    {
        aJ("getId");
        return uS;
    }

    public float getRating()
    {
        aJ("getRating");
        return Ol;
    }

    public List gw()
    {
        aJ("getTypes");
        return Oo;
    }

    public LatLng gx()
    {
        aJ("getLatLng");
        return Of;
    }

    public float gy()
    {
        aJ("getLevelNumber");
        return Og;
    }

    public LatLngBounds gz()
    {
        aJ("getViewport");
        return Oh;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            uS, Or, Long.valueOf(On)
        });
    }

    public String toString()
    {
        return ep.e(this).a("id", uS).a("localization", Oe).a("locale", Or).a("latlng", Of).a("levelNumber", Float.valueOf(Og)).a("viewport", Oh).a("timeZone", Oi).a("websiteUri", Oj).a("isPermanentlyClosed", Boolean.valueOf(Ok)).a("priceLevel", Integer.valueOf(Om)).a("timestampSecs", Long.valueOf(On)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hy hy1 = CREATOR;
        hy.a(this, parcel, i);
    }

}

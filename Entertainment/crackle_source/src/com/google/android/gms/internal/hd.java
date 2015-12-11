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
//            gr, he, gx, hh, 
//            ee, hf, ha

public final class hd extends gr
    implements SafeParcelable
{
    public static final class a
        implements SafeParcelable
    {

        public static final ha CREATOR = new ha();
        private final String Bc;
        private final String Bd;
        private final int Be;
        final int kg;
        private final String mTag;

        public int describeContents()
        {
            ha ha1 = CREATOR;
            return 0;
        }

        public String eh()
        {
            return Bc;
        }

        public String ei()
        {
            return Bd;
        }

        public int ej()
        {
            return Be;
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
                if (!Bc.equals(((a) (obj)).Bc) || !com.google.android.gms.internal.ee.equal(mTag, ((a) (obj)).mTag))
                {
                    return false;
                }
            }
            return true;
        }

        public String getTag()
        {
            return mTag;
        }

        public int hashCode()
        {
            return com.google.android.gms.internal.ee.hashCode(new Object[] {
                Bc, mTag, Bd, Integer.valueOf(Be)
            });
        }

        public String toString()
        {
            return com.google.android.gms.internal.ee.e(this).a("placeId", Bc).a("tag", mTag).a("callingAppPackageName", Bd).a("callingAppVersionCode", Integer.valueOf(Be)).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            ha ha1 = CREATOR;
            ha.a(this, parcel, i);
        }


        a(int i, String s, String s1, String s2, int j)
        {
            kg = i;
            Bc = s;
            mTag = s1;
            Bd = s2;
            Be = j;
        }
    }

    public static class a.a
    {

        private final String Bc;
        private String Bd;
        private int Be;
        private final String mTag;

        public a.a as(String s)
        {
            Bd = s;
            return this;
        }

        public a.a bd(int i)
        {
            Be = i;
            return this;
        }

        public a ek()
        {
            return new a(0, Bc, mTag, Bd, Be);
        }

        public a.a(String s, String s1)
        {
            Bc = s;
            mTag = s1;
        }
    }


    public static final he CREATOR = new he();
    private final Bundle AM;
    private final hf AN;
    private final LatLng AO;
    private final float AP;
    private final LatLngBounds AQ;
    private final String AR;
    private final Uri AS;
    private final boolean AT;
    private final float AU;
    private final int AV;
    private final long AW;
    private final List AX;
    private final Map AY;
    private final TimeZone AZ;
    private Locale Ba;
    private hh Bb;
    final int kg;
    private final String uS;

    hd(int i, String s, List list, Bundle bundle, hf hf, LatLng latlng, float f, 
            LatLngBounds latlngbounds, String s1, Uri uri, boolean flag, float f1, int j, long l)
    {
        kg = i;
        uS = s;
        AX = Collections.unmodifiableList(list);
        AM = bundle;
        AN = hf;
        AO = latlng;
        AP = f;
        AQ = latlngbounds;
        AR = s1;
        AS = uri;
        AT = flag;
        AU = f1;
        AV = j;
        AW = l;
        s = new HashMap();
        for (list = bundle.keySet().iterator(); list.hasNext(); s.put(gx.aq(hf), bundle.getString(hf)))
        {
            hf = (String)list.next();
        }

        AY = Collections.unmodifiableMap(s);
        AZ = TimeZone.getTimeZone(AR);
        Ba = null;
        Bb = null;
    }

    private void ar(String s)
    {
        if (Bb != null)
        {
            Bb.a(new a.a(uS, s));
        }
    }

    public List dW()
    {
        ar("getTypes");
        return AX;
    }

    public LatLng dX()
    {
        ar("getLatLng");
        return AO;
    }

    public float dY()
    {
        ar("getLevelNumber");
        return AP;
    }

    public LatLngBounds dZ()
    {
        ar("getViewport");
        return AQ;
    }

    public int describeContents()
    {
        he he1 = CREATOR;
        return 0;
    }

    public Uri ea()
    {
        ar("getWebsiteUri");
        return AS;
    }

    public boolean eb()
    {
        ar("isPermanentlyClosed");
        return AT;
    }

    public int ec()
    {
        ar("getPriceLevel");
        return AV;
    }

    public long ed()
    {
        return AW;
    }

    public Bundle ee()
    {
        return AM;
    }

    public hf ef()
    {
        return AN;
    }

    public String eg()
    {
        return AR;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hd))
            {
                return false;
            }
            obj = (hd)obj;
            if (!uS.equals(((hd) (obj)).uS) || !com.google.android.gms.internal.ee.equal(Ba, ((hd) (obj)).Ba) || AW != ((hd) (obj)).AW)
            {
                return false;
            }
        }
        return true;
    }

    public String getId()
    {
        ar("getId");
        return uS;
    }

    public float getRating()
    {
        ar("getRating");
        return AU;
    }

    public int hashCode()
    {
        return com.google.android.gms.internal.ee.hashCode(new Object[] {
            uS, Ba, Long.valueOf(AW)
        });
    }

    public String toString()
    {
        return com.google.android.gms.internal.ee.e(this).a("id", uS).a("localization", AN).a("locale", Ba).a("latlng", AO).a("levelNumber", Float.valueOf(AP)).a("viewport", AQ).a("timeZone", AR).a("websiteUri", AS).a("isPermanentlyClosed", Boolean.valueOf(AT)).a("priceLevel", Integer.valueOf(AV)).a("timestampSecs", Long.valueOf(AW)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        he he1 = CREATOR;
        he.a(this, parcel, i);
    }

}

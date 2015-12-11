// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzl, zzp, PlaceLocalization

public final class PlaceImpl
    implements SafeParcelable, Place
{
    public static class zza
    {

        private String mName;
        private int mVersionCode;
        private LatLng zzaFS;
        private String zzaFU;
        private Uri zzaFV;
        private float zzaHk;
        private LatLngBounds zzaHl;
        private String zzaHm;
        private boolean zzaHn;
        private float zzaHo;
        private int zzaHp;
        private long zzaHq;
        private String zzaHs;
        private List zzaHt;
        private boolean zzaHu;
        private Bundle zzaHy;
        private List zzaHz;
        private String zzapU;
        private String zzwN;

        public zza zza(LatLng latlng)
        {
            zzaFS = latlng;
            return this;
        }

        public zza zza(LatLngBounds latlngbounds)
        {
            zzaHl = latlngbounds;
            return this;
        }

        public zza zzai(boolean flag)
        {
            zzaHn = flag;
            return this;
        }

        public zza zzaj(boolean flag)
        {
            zzaHu = flag;
            return this;
        }

        public zza zzdA(String s)
        {
            zzwN = s;
            return this;
        }

        public zza zzdB(String s)
        {
            mName = s;
            return this;
        }

        public zza zzdC(String s)
        {
            zzapU = s;
            return this;
        }

        public zza zzdD(String s)
        {
            zzaFU = s;
            return this;
        }

        public zza zzf(float f)
        {
            zzaHk = f;
            return this;
        }

        public zza zzg(float f)
        {
            zzaHo = f;
            return this;
        }

        public zza zzhs(int i)
        {
            zzaHp = i;
            return this;
        }

        public zza zzl(Uri uri)
        {
            zzaFV = uri;
            return this;
        }

        public zza zzt(List list)
        {
            zzaHz = list;
            return this;
        }

        public zza zzu(List list)
        {
            zzaHt = list;
            return this;
        }

        public PlaceImpl zzxn()
        {
            return new PlaceImpl(mVersionCode, zzwN, zzaHz, Collections.emptyList(), zzaHy, mName, zzapU, zzaFU, zzaHs, zzaHt, zzaFS, zzaHk, zzaHl, zzaHm, zzaFV, zzaHn, zzaHo, zzaHp, zzaHq, zzaHu, PlaceLocalization.zza(mName, zzapU, zzaFU, zzaHs, zzaHt));
        }

        public zza()
        {
            mVersionCode = 0;
        }
    }


    public static final zzl CREATOR = new zzl();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaFS;
    private final List zzaFT;
    private final String zzaFU;
    private final Uri zzaFV;
    private Locale zzaHc;
    private final Bundle zzaHi;
    private final PlaceLocalization zzaHj;
    private final float zzaHk;
    private final LatLngBounds zzaHl;
    private final String zzaHm;
    private final boolean zzaHn;
    private final float zzaHo;
    private final int zzaHp;
    private final long zzaHq;
    private final List zzaHr;
    private final String zzaHs;
    private final List zzaHt;
    final boolean zzaHu;
    private final Map zzaHv = Collections.unmodifiableMap(new HashMap());
    private final TimeZone zzaHw = null;
    private zzp zzaHx;
    private final String zzapU;
    private final String zzwN;

    PlaceImpl(int i, String s, List list, List list1, Bundle bundle, String s1, String s2, 
            String s3, String s4, List list2, LatLng latlng, float f, LatLngBounds latlngbounds, String s5, 
            Uri uri, boolean flag, float f1, int j, long l, boolean flag1, 
            PlaceLocalization placelocalization)
    {
        mVersionCode = i;
        zzwN = s;
        zzaFT = Collections.unmodifiableList(list);
        zzaHr = list1;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        zzaHi = bundle;
        mName = s1;
        zzapU = s2;
        zzaFU = s3;
        zzaHs = s4;
        if (list2 == null)
        {
            list2 = Collections.emptyList();
        }
        zzaHt = list2;
        zzaFS = latlng;
        zzaHk = f;
        zzaHl = latlngbounds;
        if (s5 == null)
        {
            s5 = "UTC";
        }
        zzaHm = s5;
        zzaFV = uri;
        zzaHn = flag;
        zzaHo = f1;
        zzaHp = j;
        zzaHq = l;
        zzaHc = null;
        zzaHu = flag1;
        zzaHj = placelocalization;
    }

    private void zzdz(String s)
    {
        if (zzaHu && zzaHx != null)
        {
            zzaHx.zzE(zzwN, s);
        }
    }

    public int describeContents()
    {
        zzl zzl1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceImpl))
            {
                return false;
            }
            obj = (PlaceImpl)obj;
            if (!zzwN.equals(((PlaceImpl) (obj)).zzwN) || !zzw.equal(zzaHc, ((PlaceImpl) (obj)).zzaHc) || zzaHq != ((PlaceImpl) (obj)).zzaHq)
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzxm();
    }

    public volatile CharSequence getAddress()
    {
        return getAddress();
    }

    public String getAddress()
    {
        zzdz("getAddress");
        return zzapU;
    }

    public String getId()
    {
        zzdz("getId");
        return zzwN;
    }

    public LatLng getLatLng()
    {
        zzdz("getLatLng");
        return zzaFS;
    }

    public Locale getLocale()
    {
        zzdz("getLocale");
        return zzaHc;
    }

    public volatile CharSequence getName()
    {
        return getName();
    }

    public String getName()
    {
        zzdz("getName");
        return mName;
    }

    public volatile CharSequence getPhoneNumber()
    {
        return getPhoneNumber();
    }

    public String getPhoneNumber()
    {
        zzdz("getPhoneNumber");
        return zzaFU;
    }

    public List getPlaceTypes()
    {
        zzdz("getPlaceTypes");
        return zzaFT;
    }

    public int getPriceLevel()
    {
        zzdz("getPriceLevel");
        return zzaHp;
    }

    public float getRating()
    {
        zzdz("getRating");
        return zzaHo;
    }

    public LatLngBounds getViewport()
    {
        zzdz("getViewport");
        return zzaHl;
    }

    public Uri getWebsiteUri()
    {
        zzdz("getWebsiteUri");
        return zzaFV;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzwN, zzaHc, Long.valueOf(zzaHq)
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void setLocale(Locale locale)
    {
        zzaHc = locale;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("id", zzwN).zzg("placeTypes", zzaFT).zzg("locale", zzaHc).zzg("name", mName).zzg("address", zzapU).zzg("phoneNumber", zzaFU).zzg("latlng", zzaFS).zzg("viewport", zzaHl).zzg("websiteUri", zzaFV).zzg("isPermanentlyClosed", Boolean.valueOf(zzaHn)).zzg("priceLevel", Integer.valueOf(zzaHp)).zzg("timestampSecs", Long.valueOf(zzaHq)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl zzl1 = CREATOR;
        zzl.zza(this, parcel, i);
    }

    public void zza(zzp zzp1)
    {
        zzaHx = zzp1;
    }

    public List zzxd()
    {
        zzdz("getTypesDeprecated");
        return zzaHr;
    }

    public float zzxe()
    {
        zzdz("getLevelNumber");
        return zzaHk;
    }

    public String zzxf()
    {
        zzdz("getRegularOpenHours");
        return zzaHs;
    }

    public List zzxg()
    {
        zzdz("getAttributions");
        return zzaHt;
    }

    public boolean zzxh()
    {
        zzdz("isPermanentlyClosed");
        return zzaHn;
    }

    public long zzxi()
    {
        return zzaHq;
    }

    public Bundle zzxj()
    {
        return zzaHi;
    }

    public String zzxk()
    {
        return zzaHm;
    }

    public PlaceLocalization zzxl()
    {
        zzdz("getLocalization");
        return zzaHj;
    }

    public Place zzxm()
    {
        return this;
    }

}

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

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
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

    public final Object freeze()
    {
        return zzxm();
    }

    public final volatile CharSequence getAddress()
    {
        return getAddress();
    }

    public final String getAddress()
    {
        zzdz("getAddress");
        return zzapU;
    }

    public final String getId()
    {
        zzdz("getId");
        return zzwN;
    }

    public final LatLng getLatLng()
    {
        zzdz("getLatLng");
        return zzaFS;
    }

    public final Locale getLocale()
    {
        zzdz("getLocale");
        return zzaHc;
    }

    public final volatile CharSequence getName()
    {
        return getName();
    }

    public final String getName()
    {
        zzdz("getName");
        return mName;
    }

    public final volatile CharSequence getPhoneNumber()
    {
        return getPhoneNumber();
    }

    public final String getPhoneNumber()
    {
        zzdz("getPhoneNumber");
        return zzaFU;
    }

    public final List getPlaceTypes()
    {
        zzdz("getPlaceTypes");
        return zzaFT;
    }

    public final int getPriceLevel()
    {
        zzdz("getPriceLevel");
        return zzaHp;
    }

    public final float getRating()
    {
        zzdz("getRating");
        return zzaHo;
    }

    public final LatLngBounds getViewport()
    {
        zzdz("getViewport");
        return zzaHl;
    }

    public final Uri getWebsiteUri()
    {
        zzdz("getWebsiteUri");
        return zzaFV;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzwN, zzaHc, Long.valueOf(zzaHq)
        });
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final void setLocale(Locale locale)
    {
        zzaHc = locale;
    }

    public final String toString()
    {
        return zzw.zzv(this).zzg("id", zzwN).zzg("placeTypes", zzaFT).zzg("locale", zzaHc).zzg("name", mName).zzg("address", zzapU).zzg("phoneNumber", zzaFU).zzg("latlng", zzaFS).zzg("viewport", zzaHl).zzg("websiteUri", zzaFV).zzg("isPermanentlyClosed", Boolean.valueOf(zzaHn)).zzg("priceLevel", Integer.valueOf(zzaHp)).zzg("timestampSecs", Long.valueOf(zzaHq)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

    public final void zza(zzp zzp1)
    {
        zzaHx = zzp1;
    }

    public final List zzxd()
    {
        zzdz("getTypesDeprecated");
        return zzaHr;
    }

    public final float zzxe()
    {
        zzdz("getLevelNumber");
        return zzaHk;
    }

    public final String zzxf()
    {
        zzdz("getRegularOpenHours");
        return zzaHs;
    }

    public final List zzxg()
    {
        zzdz("getAttributions");
        return zzaHt;
    }

    public final boolean zzxh()
    {
        zzdz("isPermanentlyClosed");
        return zzaHn;
    }

    public final long zzxi()
    {
        return zzaHq;
    }

    public final Bundle zzxj()
    {
        return zzaHi;
    }

    public final String zzxk()
    {
        return zzaHm;
    }

    public final PlaceLocalization zzxl()
    {
        zzdz("getLocalization");
        return zzaHj;
    }

    public final Place zzxm()
    {
        return this;
    }

}

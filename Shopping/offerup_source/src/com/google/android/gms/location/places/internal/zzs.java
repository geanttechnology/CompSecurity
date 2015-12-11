// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzu, zzp, PlaceImpl

public class zzs extends zzu
    implements Place
{

    private final String zzaGt = zzF("place_id", "");
    private boolean zzaHu;
    private final zzp zzaHx;

    public zzs(DataHolder dataholder, int i, Context context)
    {
        super(dataholder, i);
        if (context != null)
        {
            dataholder = zzp.zzaF(context);
        } else
        {
            dataholder = null;
        }
        zzaHx = dataholder;
        zzaHu = zzh("place_is_logging_enabled", false);
    }

    private void zzdz(String s)
    {
        if (zzaHu && zzaHx != null)
        {
            zzaHx.zzE(zzaGt, s);
        }
    }

    public Object freeze()
    {
        return zzxm();
    }

    public CharSequence getAddress()
    {
        zzdz("getAddress");
        return zzF("place_address", "");
    }

    public String getId()
    {
        zzdz("getId");
        return zzaGt;
    }

    public LatLng getLatLng()
    {
        zzdz("getLatLng");
        return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
    }

    public Locale getLocale()
    {
        zzdz("getLocale");
        String s = zzF("place_locale", "");
        if (!TextUtils.isEmpty(s))
        {
            return new Locale(s);
        } else
        {
            return Locale.getDefault();
        }
    }

    public CharSequence getName()
    {
        zzdz("getName");
        return zzF("place_name", "");
    }

    public CharSequence getPhoneNumber()
    {
        zzdz("getPhoneNumber");
        return zzF("place_phone_number", "");
    }

    public List getPlaceTypes()
    {
        zzdz("getPlaceTypes");
        return zza("place_types", Collections.emptyList());
    }

    public int getPriceLevel()
    {
        zzdz("getPriceLevel");
        return zzz("place_price_level", -1);
    }

    public float getRating()
    {
        zzdz("getRating");
        return zzb("place_rating", -1F);
    }

    public LatLngBounds getViewport()
    {
        zzdz("getViewport");
        return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
    }

    public Uri getWebsiteUri()
    {
        zzdz("getWebsiteUri");
        String s = zzF("place_website_uri", null);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public float zzxe()
    {
        zzdz("getLevelNumber");
        return zzb("place_level_number", 0.0F);
    }

    public boolean zzxh()
    {
        zzdz("isPermanentlyClosed");
        return zzh("place_is_permanently_closed", false);
    }

    public Place zzxm()
    {
        Object obj = (new PlaceImpl.zza()).zzaj(zzaHu);
        zzaHu = false;
        obj = ((PlaceImpl.zza) (obj)).zzdC(getAddress().toString()).zzu(zzb("place_attributions", Collections.emptyList())).zzdA(getId()).zzai(zzxh()).zza(getLatLng()).zzf(zzxe()).zzdB(getName().toString()).zzdD(getPhoneNumber().toString()).zzhs(getPriceLevel()).zzg(getRating()).zzt(getPlaceTypes()).zza(getViewport()).zzl(getWebsiteUri()).zzxn();
        ((PlaceImpl) (obj)).setLocale(getLocale());
        ((PlaceImpl) (obj)).zza(zzaHx);
        return ((Place) (obj));
    }
}

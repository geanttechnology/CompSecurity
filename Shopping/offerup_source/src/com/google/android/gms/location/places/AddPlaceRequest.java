// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places:
//            zzb

public class AddPlaceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaFS;
    private final List zzaFT;
    private final String zzaFU;
    private final Uri zzaFV;
    private final String zzapU;

    AddPlaceRequest(int i, String s, LatLng latlng, String s1, List list, String s2, Uri uri)
    {
label0:
        {
            boolean flag1 = false;
            super();
            mVersionCode = i;
            mName = zzx.zzcr(s);
            zzaFS = (LatLng)zzx.zzw(latlng);
            zzapU = zzx.zzcr(s1);
            zzaFT = new ArrayList((Collection)zzx.zzw(list));
            boolean flag;
            if (!zzaFT.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "At least one place type should be provided.");
            if (TextUtils.isEmpty(s2))
            {
                flag = flag1;
                if (uri == null)
                {
                    break label0;
                }
            }
            flag = true;
        }
        zzx.zzb(flag, "One of phone number or URI should be provided.");
        zzaFU = s2;
        zzaFV = uri;
    }

    public AddPlaceRequest(String s, LatLng latlng, String s1, List list, Uri uri)
    {
        this(s, latlng, s1, list, null, (Uri)zzx.zzw(uri));
    }

    public AddPlaceRequest(String s, LatLng latlng, String s1, List list, String s2)
    {
        this(s, latlng, s1, list, zzx.zzcr(s2), null);
    }

    public AddPlaceRequest(String s, LatLng latlng, String s1, List list, String s2, Uri uri)
    {
        this(0, s, latlng, s1, list, s2, uri);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress()
    {
        return zzapU;
    }

    public LatLng getLatLng()
    {
        return zzaFS;
    }

    public String getName()
    {
        return mName;
    }

    public String getPhoneNumber()
    {
        return zzaFU;
    }

    public List getPlaceTypes()
    {
        return zzaFT;
    }

    public Uri getWebsiteUri()
    {
        return zzaFV;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("name", mName).zzg("latLng", zzaFS).zzg("address", zzapU).zzg("placeTypes", zzaFT).zzg("phoneNumer", zzaFU).zzg("websiteUri", zzaFV).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}

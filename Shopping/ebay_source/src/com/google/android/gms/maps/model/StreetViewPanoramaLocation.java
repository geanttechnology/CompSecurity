// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzk, LatLng, StreetViewPanoramaLink

public class StreetViewPanoramaLocation
    implements SafeParcelable
{

    public static final zzk CREATOR = new zzk();
    public final StreetViewPanoramaLink links[];
    public final String panoId;
    public final LatLng position;
    private final int zzCY;

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink astreetviewpanoramalink[], LatLng latlng, String s)
    {
        zzCY = i;
        links = astreetviewpanoramalink;
        position = latlng;
        panoId = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof StreetViewPanoramaLocation))
            {
                return false;
            }
            obj = (StreetViewPanoramaLocation)obj;
            if (!panoId.equals(((StreetViewPanoramaLocation) (obj)).panoId) || !position.equals(((StreetViewPanoramaLocation) (obj)).position))
            {
                return false;
            }
        }
        return true;
    }

    int getVersionCode()
    {
        return zzCY;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            position, panoId
        });
    }

    public String toString()
    {
        return zzt.zzt(this).zzg("panoId", panoId).zzg("position", position.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}

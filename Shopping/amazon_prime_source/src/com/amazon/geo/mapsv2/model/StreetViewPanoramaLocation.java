// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaLocationCreator, StreetViewPanoramaLink, LatLng

public class StreetViewPanoramaLocation
    implements SafeParcelable
{

    public static final StreetViewPanoramaLocationCreator CREATOR = new StreetViewPanoramaLocationCreator();
    public final StreetViewPanoramaLink links[];
    public final String panoId;
    public final LatLng position;

    StreetViewPanoramaLocation(Parcel parcel)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        links = (StreetViewPanoramaLink[])parcel.createTypedArray(StreetViewPanoramaLink.CREATOR);
        panoId = parcel.readString();
        position = (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink astreetviewpanoramalink[], LatLng latlng, String s)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        links = astreetviewpanoramalink;
        panoId = s;
        position = latlng;
    }

    public int describeContents()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return 0;
    }

    public boolean equals(Object obj)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof StreetViewPanoramaLocation))
        {
            return false;
        }
        obj = (StreetViewPanoramaLocation)obj;
        if (panoId == null)
        {
            if (((StreetViewPanoramaLocation) (obj)).panoId != null)
            {
                return false;
            }
        } else
        if (!panoId.equals(((StreetViewPanoramaLocation) (obj)).panoId))
        {
            return false;
        }
        if (position != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((StreetViewPanoramaLocation) (obj)).position == null) goto _L1; else goto _L3
_L3:
        return false;
        if (position.equals(((StreetViewPanoramaLocation) (obj)).position)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        int i;
        if (panoId == null)
        {
            i = 0;
        } else
        {
            i = panoId.hashCode();
        }
        if (position != null)
        {
            j = position.hashCode();
        }
        return (i + 527) * 31 + j;
    }

    public String toString()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return (new StringBuilder()).append(getClass().getSimpleName()).append("{panoId=").append(panoId).append(", position=").append(position).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        parcel.writeTypedArray(links, i);
        parcel.writeString(panoId);
        parcel.writeParcelable(position, i);
    }

}

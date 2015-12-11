// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            VisibleRegionCreator, LatLng, LatLngBounds

public final class VisibleRegion
    implements Parcelable
{

    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(LatLng latlng, LatLng latlng1, LatLng latlng2, LatLng latlng3, LatLngBounds latlngbounds)
    {
        if (latlng == null || latlng1 == null || latlng3 == null || latlng2 == null || latlngbounds == null)
        {
            throw new NullPointerException();
        } else
        {
            nearLeft = latlng;
            nearRight = latlng1;
            farLeft = latlng2;
            farRight = latlng3;
            latLngBounds = latlngbounds;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (VisibleRegion)obj;
        if (farLeft == null)
        {
            if (((VisibleRegion) (obj)).farLeft != null)
            {
                return false;
            }
        } else
        if (!farLeft.equals(((VisibleRegion) (obj)).farLeft))
        {
            return false;
        }
        if (farRight == null)
        {
            if (((VisibleRegion) (obj)).farRight != null)
            {
                return false;
            }
        } else
        if (!farRight.equals(((VisibleRegion) (obj)).farRight))
        {
            return false;
        }
        if (latLngBounds == null)
        {
            if (((VisibleRegion) (obj)).latLngBounds != null)
            {
                return false;
            }
        } else
        if (!latLngBounds.equals(((VisibleRegion) (obj)).latLngBounds))
        {
            return false;
        }
        if (nearLeft == null)
        {
            if (((VisibleRegion) (obj)).nearLeft != null)
            {
                return false;
            }
        } else
        if (!nearLeft.equals(((VisibleRegion) (obj)).nearLeft))
        {
            return false;
        }
        if (nearRight != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((VisibleRegion) (obj)).nearRight == null) goto _L1; else goto _L3
_L3:
        return false;
        if (nearRight.equals(((VisibleRegion) (obj)).nearRight)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (farLeft == null)
        {
            i = 0;
        } else
        {
            i = farLeft.hashCode();
        }
        if (farRight == null)
        {
            j = 0;
        } else
        {
            j = farRight.hashCode();
        }
        if (latLngBounds == null)
        {
            k = 0;
        } else
        {
            k = latLngBounds.hashCode();
        }
        if (nearLeft == null)
        {
            l = 0;
        } else
        {
            l = nearLeft.hashCode();
        }
        if (nearRight != null)
        {
            i1 = nearRight.hashCode();
        }
        return ((((i + 31) * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public String toString()
    {
        return (new StringBuilder("VisibleRegion{nearLeft=")).append(nearLeft).append(", nearRight=").append(nearRight).append(", farLeft=").append(farLeft).append(", farRight=").append(farRight).append(", latLngBounds=").append(latLngBounds).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        VisibleRegionCreator.write(this, parcel, i);
    }

}

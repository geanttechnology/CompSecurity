// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaLinkCreator

public class StreetViewPanoramaLink
    implements SafeParcelable
{

    public static final StreetViewPanoramaLinkCreator CREATOR = new StreetViewPanoramaLinkCreator();
    public final float bearing;
    public final String panoId;

    StreetViewPanoramaLink(float f, String s)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = f;
        panoId = s;
    }

    StreetViewPanoramaLink(Parcel parcel)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = parcel.readFloat();
        panoId = parcel.readString();
    }

    public int describeContents()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (!(obj instanceof StreetViewPanoramaLink)) goto _L4; else goto _L3
_L3:
        obj = (StreetViewPanoramaLink)obj;
        if (panoId != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        flag = flag3;
        if (((StreetViewPanoramaLink) (obj)).panoId != null) goto _L4; else goto _L5
_L5:
        boolean flag1;
        if (bearing == ((StreetViewPanoramaLink) (obj)).bearing)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
        if (!panoId.equals(((StreetViewPanoramaLink) (obj)).panoId))
        {
            return false;
        }
          goto _L5
    }

    public int hashCode()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        int j = Float.floatToIntBits(bearing);
        int i;
        if (panoId == null)
        {
            i = 0;
        } else
        {
            i = panoId.hashCode();
        }
        return (j + 527) * 31 + i;
    }

    public String toString()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return (new StringBuilder()).append(getClass().getSimpleName()).append("{panoId=").append(panoId).append(", bearing=").append(bearing).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        parcel.writeFloat(bearing);
        parcel.writeString(panoId);
    }

}

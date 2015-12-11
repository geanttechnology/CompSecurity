// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            GroundOverlayOptions, BitmapDescriptorFactory, LatLngBounds, LatLng

public class GroundOverlayOptionsCreator
    implements android.os.Parcelable.Creator
{

    private static final byte FALSE = 0;
    private static final byte TRUE = 1;

    public GroundOverlayOptionsCreator()
    {
    }

    static void write(GroundOverlayOptions groundoverlayoptions, Parcel parcel, int i)
    {
        parcel.writeFloat(groundoverlayoptions.getAnchorU());
        parcel.writeFloat(groundoverlayoptions.getAnchorV());
        parcel.writeFloat(groundoverlayoptions.getBearing());
        parcel.writeParcelable(groundoverlayoptions.getBounds(), i);
        parcel.writeFloat(groundoverlayoptions.getHeight());
        parcel.writeParcelable(groundoverlayoptions.getLocation(), i);
        parcel.writeFloat(groundoverlayoptions.getTransparency());
        parcel.writeFloat(groundoverlayoptions.getWidth());
        parcel.writeFloat(groundoverlayoptions.getZIndex());
        byte byte0;
        if (groundoverlayoptions.isVisible())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        BitmapDescriptorFactory.write(groundoverlayoptions.getImage(), parcel, i);
    }

    public GroundOverlayOptions createFromParcel(Parcel parcel)
    {
        float f = parcel.readFloat();
        float f1 = parcel.readFloat();
        float f2 = parcel.readFloat();
        LatLngBounds latlngbounds = (LatLngBounds)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLngBounds.getClassLoader());
        float f3 = parcel.readFloat();
        LatLng latlng = (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        float f4 = parcel.readFloat();
        float f5 = parcel.readFloat();
        float f6 = parcel.readFloat();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new GroundOverlayOptions(f, f1, f2, latlngbounds, f3, latlng, f4, f5, f6, flag, BitmapDescriptorFactory.fromParcel(parcel));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public GroundOverlayOptions[] newArray(int i)
    {
        return new GroundOverlayOptions[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}

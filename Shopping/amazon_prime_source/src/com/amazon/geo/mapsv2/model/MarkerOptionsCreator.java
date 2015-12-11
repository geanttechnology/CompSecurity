// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            MarkerOptions, BitmapDescriptorFactory, LatLng

public class MarkerOptionsCreator
    implements android.os.Parcelable.Creator
{

    private static final byte FALSE = 0;
    private static final byte TRUE = 1;

    public MarkerOptionsCreator()
    {
    }

    static void write(MarkerOptions markeroptions, Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeFloat(markeroptions.getAlpha());
        parcel.writeFloat(markeroptions.getAnchorU());
        parcel.writeFloat(markeroptions.getAnchorV());
        byte byte0;
        if (markeroptions.isDraggable())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (markeroptions.isFlat())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeFloat(markeroptions.getInfoWindowAnchorU());
        parcel.writeFloat(markeroptions.getInfoWindowAnchorV());
        parcel.writeParcelable(markeroptions.getPosition(), i);
        parcel.writeFloat(markeroptions.getRotation());
        if (markeroptions.getSnippet() == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeString(markeroptions.getSnippet());
        }
        if (markeroptions.getTitle() == null)
        {
            parcel.writeByte((byte)0);
        } else
        {
            parcel.writeByte((byte)1);
            parcel.writeString(markeroptions.getTitle());
        }
        if (markeroptions.isVisible())
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        BitmapDescriptorFactory.write(markeroptions.getIcon(), parcel, i);
    }

    public MarkerOptions createFromParcel(Parcel parcel)
    {
        float f = parcel.readFloat();
        float f1 = parcel.readFloat();
        float f2 = parcel.readFloat();
        float f3;
        float f4;
        float f5;
        String s;
        String s1;
        LatLng latlng;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (parcel.readByte() != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (parcel.readByte() != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        f3 = parcel.readFloat();
        f4 = parcel.readFloat();
        latlng = (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader());
        f5 = parcel.readFloat();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = null;
        if (flag)
        {
            s = parcel.readString();
        }
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = null;
        if (flag)
        {
            s1 = parcel.readString();
        }
        if (parcel.readByte() != 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        return new MarkerOptions(f, f1, f2, flag1, flag2, BitmapDescriptorFactory.fromParcel(parcel), f3, f4, latlng, f5, s, s1, flag3);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public MarkerOptions[] newArray(int i)
    {
        return new MarkerOptions[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}

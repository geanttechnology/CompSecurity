// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.models;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.bitstrips.outfitbuilder.OBCatalogDisplayable;

public class OBBrand
    implements Parcelable, OBCatalogDisplayable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OBBrand createFromParcel(Parcel parcel)
        {
            return new OBBrand(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OBBrand[] newArray(int i)
        {
            return new OBBrand[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String bgColorString;
    int brandId;
    String fgColorString;
    String headerBackground;
    String logo;
    String name;
    String storeBackground;

    public OBBrand(int i, String s, String s1, String s2, String s3, String s4, String s5)
    {
        brandId = i;
        name = s;
        logo = s1;
        headerBackground = s2;
        storeBackground = s3;
        bgColorString = s4;
        fgColorString = s5;
    }

    protected OBBrand(Parcel parcel)
    {
        brandId = parcel.readInt();
        name = parcel.readString();
        logo = parcel.readString();
        headerBackground = parcel.readString();
        storeBackground = parcel.readString();
        bgColorString = parcel.readString();
        fgColorString = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getHeaderBackground()
    {
        return headerBackground;
    }

    public int getHeaderBackgroundColor()
    {
        return Color.parseColor(bgColorString);
    }

    public int getHeaderForegroundColor()
    {
        return Color.parseColor(fgColorString);
    }

    public String getHeaderLogo()
    {
        return logo;
    }

    public int getId()
    {
        return brandId;
    }

    public String getName()
    {
        return name;
    }

    public String getStoreBackground()
    {
        return storeBackground;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(brandId);
        parcel.writeString(name);
        parcel.writeString(logo);
        parcel.writeString(headerBackground);
        parcel.writeString(storeBackground);
        parcel.writeString(bgColorString);
        parcel.writeString(fgColorString);
    }

}

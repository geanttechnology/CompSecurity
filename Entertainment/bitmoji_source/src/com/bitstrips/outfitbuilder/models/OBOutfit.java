// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.bitstrips.outfitbuilder.OBCatalogDisplayable;

// Referenced classes of package com.bitstrips.outfitbuilder.models:
//            OBBrand

public class OBOutfit
    implements Parcelable, OBCatalogDisplayable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OBOutfit createFromParcel(Parcel parcel)
        {
            return new OBOutfit(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OBOutfit[] newArray(int i)
        {
            return new OBOutfit[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    OBBrand brand;
    String description;
    int id;
    String imageURL;
    String sublogoURL;

    public OBOutfit(int i, String s, String s1, String s2)
    {
        id = i;
        imageURL = s;
        sublogoURL = s1;
        description = s2;
    }

    public OBOutfit(Parcel parcel)
    {
        id = parcel.readInt();
        imageURL = parcel.readString();
        sublogoURL = parcel.readString();
        description = parcel.readString();
        brand = (OBBrand)parcel.readParcelable(com/bitstrips/outfitbuilder/models/OBBrand.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public OBBrand getBrand()
    {
        return brand;
    }

    public String getDescription()
    {
        return description;
    }

    public int getId()
    {
        return id;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public String getSublogoURL()
    {
        if (sublogoURL == null || sublogoURL.equals("0") || sublogoURL.equals(""))
        {
            return null;
        } else
        {
            return sublogoURL;
        }
    }

    public void setBrand(OBBrand obbrand)
    {
        brand = obbrand;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(id);
        parcel.writeString(imageURL);
        parcel.writeString(sublogoURL);
        parcel.writeString(description);
        parcel.writeParcelable(brand, i);
    }

}

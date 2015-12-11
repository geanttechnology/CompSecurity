// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package com.bitstrips.outfitbuilder.models:
//            OBBrand, OBOutfit

public class OBCatalogItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OBCatalogItem createFromParcel(Parcel parcel)
        {
            return new OBCatalogItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OBCatalogItem[] newArray(int i)
        {
            return new OBCatalogItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    OBBrand brand;
    ArrayList outfits;

    public OBCatalogItem(Parcel parcel)
    {
        brand = (OBBrand)parcel.readParcelable(com/bitstrips/outfitbuilder/models/OBBrand.getClassLoader());
        outfits = new ArrayList();
        parcel.readTypedList(outfits, OBOutfit.CREATOR);
    }

    public OBCatalogItem(OBBrand obbrand, ArrayList arraylist)
    {
        brand = obbrand;
        outfits = arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public OBBrand getBrand()
    {
        return brand;
    }

    public ArrayList getOutfits()
    {
        return outfits;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(brand, i);
        parcel.writeTypedList(outfits);
    }

}

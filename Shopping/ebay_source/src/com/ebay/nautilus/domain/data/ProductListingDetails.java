// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

public class ProductListingDetails extends BaseDataMapped
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductListingDetails createFromParcel(Parcel parcel)
        {
            return (ProductListingDetails)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ProductListingDetails);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ProductListingDetails[] newArray(int i)
        {
            return new ProductListingDetails[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String brand;
    public String copyright;
    public String ean;
    public boolean includePrefilledItemInformation;
    public boolean includeStockPhotoUrl;
    public String mpn;
    public String productId;
    public String productReferenceId;
    public String stockPhotoUrl;
    public String upc;
    public boolean useStockPhotoUrlAsGallery;

    public ProductListingDetails()
    {
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof ProductListingDetails))
        {
            if (TextUtils.equals(productId, ((ProductListingDetails) (obj = (ProductListingDetails)obj)).productId) && includePrefilledItemInformation == ((ProductListingDetails) (obj)).includePrefilledItemInformation && includeStockPhotoUrl == ((ProductListingDetails) (obj)).includeStockPhotoUrl && useStockPhotoUrlAsGallery == ((ProductListingDetails) (obj)).useStockPhotoUrlAsGallery && TextUtils.equals(stockPhotoUrl, ((ProductListingDetails) (obj)).stockPhotoUrl) && TextUtils.equals(productReferenceId, ((ProductListingDetails) (obj)).productReferenceId) && TextUtils.equals(upc, ((ProductListingDetails) (obj)).upc) && TextUtils.equals(ean, ((ProductListingDetails) (obj)).ean) && TextUtils.equals(brand, ((ProductListingDetails) (obj)).brand) && TextUtils.equals(mpn, ((ProductListingDetails) (obj)).mpn) && TextUtils.equals(copyright, ((ProductListingDetails) (obj)).copyright))
            {
                return true;
            }
        }
        return false;
    }

}

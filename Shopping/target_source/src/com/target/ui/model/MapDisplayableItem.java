// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.pointinside.maps.Location;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.util.v;

// Referenced classes of package com.target.ui.model:
//            BlackFridayDealDetails

public class MapDisplayableItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MapDisplayableItem a(Parcel parcel)
        {
            return new MapDisplayableItem(parcel);
        }

        public MapDisplayableItem[] a(int i)
        {
            return new MapDisplayableItem[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private BlackFridayDealDetails mBlackFridayDealDetails;
    private ListDetailItem mListDetailItem;
    private Location mLocation;
    private ProductDetails mProductDetails;
    private String mTitle;

    public MapDisplayableItem()
    {
    }

    private MapDisplayableItem(Parcel parcel)
    {
        mTitle = parcel.readString();
        mLocation = (Location)parcel.readParcelable(com/pointinside/maps/Location.getClassLoader());
        mProductDetails = (ProductDetails)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
        mListDetailItem = (ListDetailItem)parcel.readParcelable(com/target/ui/model/list/ListDetailItem.getClassLoader());
        mBlackFridayDealDetails = (BlackFridayDealDetails)parcel.readParcelable(com/target/ui/model/BlackFridayDealDetails.getClassLoader());
    }


    public String a()
    {
        return mTitle;
    }

    public void a(Location location)
    {
        mLocation = location;
    }

    public void a(ProductDetails productdetails)
    {
        mProductDetails = productdetails;
    }

    public void a(BlackFridayDealDetails blackfridaydealdetails)
    {
        mBlackFridayDealDetails = blackfridaydealdetails;
    }

    public void a(ListDetailItem listdetailitem)
    {
        mListDetailItem = listdetailitem;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public Location b()
    {
        return mLocation;
    }

    public e c()
    {
        return v.a(mProductDetails);
    }

    public e d()
    {
        return v.a(mListDetailItem);
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return v.a(mBlackFridayDealDetails);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeParcelable(mLocation, i);
        parcel.writeParcelable(mProductDetails, i);
        parcel.writeParcelable(mListDetailItem, i);
        parcel.writeParcelable(mBlackFridayDealDetails, i);
    }

}

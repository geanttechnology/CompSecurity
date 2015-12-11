// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.model.checkout:
//            DeliveryTypedProducts

public class TGTDeliveryTypedProducts
    implements DeliveryTypedProducts
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDeliveryTypedProducts a(Parcel parcel)
        {
            return new TGTDeliveryTypedProducts(parcel);
        }

        public TGTDeliveryTypedProducts[] a(int i)
        {
            return new TGTDeliveryTypedProducts[i];
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
    private List mEmailDeliveryProductList;
    private List mPickUpProductList;
    private List mShipHomeProductList;
    private List mSmsDeliveryProductList;

    public TGTDeliveryTypedProducts()
    {
    }

    private TGTDeliveryTypedProducts(Parcel parcel)
    {
        mShipHomeProductList = new ArrayList();
        parcel.readList(mShipHomeProductList, com/target/ui/model/checkout/TGTDeliveryTypedProducts.getClassLoader());
        mPickUpProductList = new ArrayList();
        parcel.readList(mPickUpProductList, com/target/ui/model/checkout/TGTDeliveryTypedProducts.getClassLoader());
        mEmailDeliveryProductList = new ArrayList();
        parcel.readList(mEmailDeliveryProductList, com/target/ui/model/checkout/TGTDeliveryTypedProducts.getClassLoader());
        mSmsDeliveryProductList = new ArrayList();
        parcel.readList(mSmsDeliveryProductList, com/target/ui/model/checkout/TGTDeliveryTypedProducts.getClassLoader());
    }


    public List a()
    {
        return mShipHomeProductList;
    }

    public void a(List list)
    {
        mShipHomeProductList = list;
    }

    public List b()
    {
        return mPickUpProductList;
    }

    public void b(List list)
    {
        mPickUpProductList = list;
    }

    public List c()
    {
        return mEmailDeliveryProductList;
    }

    public void c(List list)
    {
        mEmailDeliveryProductList = list;
    }

    public List d()
    {
        return mSmsDeliveryProductList;
    }

    public void d(List list)
    {
        mSmsDeliveryProductList = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mShipHomeProductList);
        parcel.writeList(mPickUpProductList);
        parcel.writeList(mEmailDeliveryProductList);
        parcel.writeList(mSmsDeliveryProductList);
    }

}

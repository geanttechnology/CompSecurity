// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.util.k;

// Referenced classes of package com.target.ui.model.product:
//            CompositeProduct, a

public class TGTCompositeProduct
    implements CompositeProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCompositeProduct a(Parcel parcel)
        {
            return new TGTCompositeProduct(parcel);
        }

        public TGTCompositeProduct[] a(int i)
        {
            return new TGTCompositeProduct[i];
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
    private DvmDataResponse mDvmDataResponse;
    private ProductDetails mProductDetails;
    private a mProductType;

    public TGTCompositeProduct()
    {
    }

    private TGTCompositeProduct(Parcel parcel)
    {
        int i = parcel.readInt();
        a a1;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.ui.model.product.a.values()[i];
        }
        mProductType = a1;
        mProductDetails = (ProductDetails)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
        mDvmDataResponse = (DvmDataResponse)parcel.readParcelable(com/target/mothership/model/dvm/interfaces/DvmDataResponse.getClassLoader());
    }


    public a a()
    {
        return mProductType;
    }

    public void a(DvmDataResponse dvmdataresponse)
    {
        mDvmDataResponse = dvmdataresponse;
    }

    public void a(ProductDetails productdetails)
    {
        mProductDetails = productdetails;
    }

    public void a(a a1)
    {
        mProductType = a1;
    }

    public e b()
    {
        return k.a(mProductDetails);
    }

    public e c()
    {
        return k.a(mDvmDataResponse);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mProductType == null)
        {
            i = -1;
        } else
        {
            i = mProductType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeParcelable(mProductDetails, 0);
        parcel.writeParcelable(mDvmDataResponse, 0);
    }

}

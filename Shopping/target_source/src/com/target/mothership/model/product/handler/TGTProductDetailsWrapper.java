// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.services.z;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails

public class TGTProductDetailsWrapper
    implements ProductDetailsWrapper
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductDetailsWrapper a(Parcel parcel)
        {
            return new TGTProductDetailsWrapper(parcel);
        }

        public TGTProductDetailsWrapper[] a(int i)
        {
            return new TGTProductDetailsWrapper[i];
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
    private List mProductDetails;
    private z mResponseCode;

    TGTProductDetailsWrapper()
    {
    }

    TGTProductDetailsWrapper(Parcel parcel)
    {
        int i = parcel.readInt();
        z z1;
        if (i == -1)
        {
            z1 = null;
        } else
        {
            z1 = z.values()[i];
        }
        mResponseCode = z1;
        mProductDetails = new ArrayList();
        parcel.readList(mProductDetails, com/target/mothership/model/product/handler/TGTProductDetails.getClassLoader());
    }

    public z a()
    {
        return mResponseCode;
    }

    public void a(z z1)
    {
        mResponseCode = z1;
    }

    public void a(List list)
    {
        mProductDetails = list;
    }

    public List b()
    {
        return k.a(mProductDetails);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mResponseCode == null)
        {
            i = -1;
        } else
        {
            i = mResponseCode.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mProductDetails);
    }

}

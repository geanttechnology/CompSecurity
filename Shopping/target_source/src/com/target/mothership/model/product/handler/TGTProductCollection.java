// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.product.interfaces.ProductCollection;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails

public class TGTProductCollection extends TGTProductDetails
    implements Parcelable, ProductCollection
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductCollection a(Parcel parcel)
        {
            return new TGTProductCollection(parcel);
        }

        public TGTProductCollection[] a(int i)
        {
            return new TGTProductCollection[i];
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

    TGTProductCollection()
    {
    }

    TGTProductCollection(Parcel parcel)
    {
        super(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
    }

}

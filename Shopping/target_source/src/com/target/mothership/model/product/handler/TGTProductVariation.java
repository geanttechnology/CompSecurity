// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductVariation;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails

public class TGTProductVariation extends TGTProductDetails
    implements ProductVariation
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductVariation a(Parcel parcel)
        {
            return new TGTProductVariation(parcel);
        }

        public TGTProductVariation[] a(int i)
        {
            return new TGTProductVariation[i];
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

    TGTProductVariation()
    {
    }

    TGTProductVariation(Parcel parcel)
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

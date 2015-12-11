// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductAvailability;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductAvailabilityStore

public class TGTProductAvailability
    implements ProductAvailability
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductAvailability a(Parcel parcel)
        {
            return new TGTProductAvailability(parcel);
        }

        public TGTProductAvailability[] a(int i)
        {
            return new TGTProductAvailability[i];
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
    private List mStores;

    TGTProductAvailability()
    {
        mStores = new ArrayList();
    }

    private TGTProductAvailability(Parcel parcel)
    {
        mStores = new ArrayList();
        parcel.readList(mStores, com/target/mothership/model/product/handler/TGTProductAvailabilityStore.getClassLoader());
    }


    public List a()
    {
        return mStores;
    }

    public void a(List list)
    {
        mStores = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mStores);
    }

}

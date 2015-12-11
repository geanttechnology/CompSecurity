// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.interfaces.UsableShippingModeDetails;
import java.util.ArrayList;
import java.util.List;

public class TGTUsableShippingModeDetails
    implements UsableShippingModeDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTUsableShippingModeDetails a(Parcel parcel)
        {
            return new TGTUsableShippingModeDetails(parcel);
        }

        public TGTUsableShippingModeDetails[] a(int i)
        {
            return new TGTUsableShippingModeDetails[i];
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
    private f mFulfillmentType;
    private List mUsableShipModes;

    TGTUsableShippingModeDetails()
    {
    }

    private TGTUsableShippingModeDetails(Parcel parcel)
    {
        int i = parcel.readInt();
        f f1;
        if (i == -1)
        {
            f1 = null;
        } else
        {
            f1 = f.values()[i];
        }
        mFulfillmentType = f1;
        mUsableShipModes = new ArrayList();
        parcel.readList(mUsableShipModes, com/target/mothership/model/cart/handler/TGTUsableShippingModeDetails.getClassLoader());
    }


    public f a()
    {
        return mFulfillmentType;
    }

    public void a(f f1)
    {
        mFulfillmentType = f1;
    }

    public void a(List list)
    {
        mUsableShipModes = list;
    }

    public List b()
    {
        return mUsableShipModes;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mFulfillmentType == null)
        {
            i = -1;
        } else
        {
            i = mFulfillmentType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mUsableShipModes);
    }

}

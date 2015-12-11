// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.b;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.interfaces.CartProductShippingModeDetails;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTUsableShippingModeDetails

public class TGTCartProductShippingModeDetails
    implements CartProductShippingModeDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartProductShippingModeDetails a(Parcel parcel)
        {
            return new TGTCartProductShippingModeDetails(parcel);
        }

        public TGTCartProductShippingModeDetails[] a(int i)
        {
            return new TGTCartProductShippingModeDetails[i];
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
    private String mDefaultAddressId;
    private b mSelectedDeliveryMethod;
    private f mSelectedFulfillmentType;
    private List mUsableShippingModeDetails;

    TGTCartProductShippingModeDetails()
    {
    }

    private TGTCartProductShippingModeDetails(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mDefaultAddressId = parcel.readString();
        int i = parcel.readInt();
        Object obj;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = f.values()[i];
        }
        mSelectedFulfillmentType = ((f) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = b.values()[i];
        }
        mSelectedDeliveryMethod = ((b) (obj));
        mUsableShippingModeDetails = new ArrayList();
        parcel.readList(mUsableShippingModeDetails, com/target/mothership/model/cart/handler/TGTUsableShippingModeDetails.getClassLoader());
    }


    public List a()
    {
        return mUsableShippingModeDetails;
    }

    public void a(b b1)
    {
        mSelectedDeliveryMethod = b1;
    }

    public void a(f f1)
    {
        mSelectedFulfillmentType = f1;
    }

    public void a(String s)
    {
        mDefaultAddressId = s;
    }

    public void a(List list)
    {
        mUsableShippingModeDetails = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = -1;
        parcel.writeString(mDefaultAddressId);
        if (mSelectedFulfillmentType == null)
        {
            i = -1;
        } else
        {
            i = mSelectedFulfillmentType.ordinal();
        }
        parcel.writeInt(i);
        if (mSelectedDeliveryMethod == null)
        {
            i = byte0;
        } else
        {
            i = mSelectedDeliveryMethod.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mUsableShippingModeDetails);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTOrderSummary

public class TGTOrderCompletionDetails extends TGTOrderSummary
    implements OrderCompletionDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderCompletionDetails a(Parcel parcel)
        {
            return new TGTOrderCompletionDetails(parcel);
        }

        public TGTOrderCompletionDetails[] a(int i)
        {
            return new TGTOrderCompletionDetails[i];
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
    private Date mOrderPlacedDate;
    private List mPaymentList;
    private List mShipmentList;

    TGTOrderCompletionDetails()
    {
    }

    private TGTOrderCompletionDetails(Parcel parcel)
    {
        super(parcel);
        long l1 = parcel.readLong();
        Date date;
        if (l1 == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l1);
        }
        mOrderPlacedDate = date;
        mPaymentList = new ArrayList();
        parcel.readList(mPaymentList, com/target/mothership/model/cart/handler/TGTOrderCompletionDetails.getClassLoader());
        mShipmentList = new ArrayList();
        parcel.readList(mShipmentList, com/target/mothership/model/cart/handler/TGTOrderCompletionDetails.getClassLoader());
    }


    public void a(Date date)
    {
        mOrderPlacedDate = date;
    }

    public void c(List list)
    {
        mPaymentList = list;
    }

    public void d(List list)
    {
        mShipmentList = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public List k()
    {
        return mPaymentList;
    }

    public List l()
    {
        return mShipmentList;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        long l1;
        if (mOrderPlacedDate != null)
        {
            l1 = mOrderPlacedDate.getTime();
        } else
        {
            l1 = -1L;
        }
        parcel.writeLong(l1);
        parcel.writeList(mPaymentList);
        parcel.writeList(mShipmentList);
    }

}

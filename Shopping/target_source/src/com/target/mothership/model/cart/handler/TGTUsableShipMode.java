// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.a.b;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class TGTUsableShipMode
    implements UsableShipMode
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTUsableShipMode a(Parcel parcel)
        {
            return new TGTUsableShipMode(parcel);
        }

        public TGTUsableShipMode[] a(int i)
        {
            return new TGTUsableShipMode[i];
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
    private b mDeliveryMethod;
    private BigDecimal mDeliveryMethodCharge;
    private Currency mDeliveryMethodChargeCurrency;
    private int mDeliveryMethodId;
    private Date mExpectedDeliveryEndDate;
    private Date mExpectedDeliveryStartDate;

    TGTUsableShipMode()
    {
    }

    private TGTUsableShipMode(Parcel parcel)
    {
        Object obj1 = null;
        super();
        int i = parcel.readInt();
        Object obj;
        long l;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.a.b.values()[i];
        }
        mDeliveryMethod = ((b) (obj));
        mDeliveryMethodId = parcel.readInt();
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mExpectedDeliveryEndDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = obj1;
        } else
        {
            obj = new Date(l);
        }
        mExpectedDeliveryStartDate = ((Date) (obj));
        mDeliveryMethodCharge = (BigDecimal)parcel.readSerializable();
        mDeliveryMethodChargeCurrency = (Currency)parcel.readSerializable();
    }


    public b a()
    {
        return mDeliveryMethod;
    }

    public void a(int i)
    {
        mDeliveryMethodId = i;
    }

    public void a(b b1)
    {
        mDeliveryMethod = b1;
    }

    public void a(BigDecimal bigdecimal)
    {
        mDeliveryMethodCharge = bigdecimal;
    }

    public void a(Currency currency)
    {
        mDeliveryMethodChargeCurrency = currency;
    }

    public void a(Date date)
    {
        mExpectedDeliveryEndDate = date;
    }

    public int b()
    {
        return mDeliveryMethodId;
    }

    public void b(Date date)
    {
        mExpectedDeliveryStartDate = date;
    }

    public e c()
    {
        return k.a(mExpectedDeliveryEndDate);
    }

    public e d()
    {
        return k.a(mExpectedDeliveryStartDate);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        long l;
        if (mDeliveryMethod == null)
        {
            i = -1;
        } else
        {
            i = mDeliveryMethod.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeInt(mDeliveryMethodId);
        if (mExpectedDeliveryEndDate != null)
        {
            l = mExpectedDeliveryEndDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mExpectedDeliveryStartDate != null)
        {
            l = mExpectedDeliveryStartDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeSerializable(mDeliveryMethodCharge);
        parcel.writeSerializable(mDeliveryMethodChargeCurrency);
    }

}

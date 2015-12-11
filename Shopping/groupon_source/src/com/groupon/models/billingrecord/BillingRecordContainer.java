// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.billingrecord;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;

// Referenced classes of package com.groupon.models.billingrecord:
//            BillingRecord

public class BillingRecordContainer
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/billingrecord/BillingRecordContainer);
    public BillingRecord billingRecord;

    public BillingRecordContainer()
    {
    }

    public BillingRecordContainer(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        billingRecord = new BillingRecord();
        billingRecord.id = parcel.readString();
        billingRecord.uuid = parcel.readString();
        billingRecord.firstName = parcel.readString();
        billingRecord.lastName = parcel.readString();
        billingRecord.streetAddress1 = parcel.readString();
        billingRecord.streetAddress2 = parcel.readString();
        billingRecord.city = parcel.readString();
        billingRecord.state = parcel.readString();
        billingRecord.country = parcel.readString();
        billingRecord.postalCode = parcel.readString();
        billingRecord.paymentType = parcel.readString();
        billingRecord.cardType = parcel.readString();
        billingRecord.cardNumber = parcel.readString();
        billingRecord.expirationMonth = Integer.valueOf(parcel.readInt());
        billingRecord.expirationYear = Integer.valueOf(parcel.readInt());
        BillingRecord billingrecord = billingRecord;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        billingrecord.isDefault = Boolean.valueOf(flag);
        billingRecord.billingRecordId = parcel.readString();
        billingRecord.name = parcel.readString();
        billingrecord = billingRecord;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        billingrecord.requireCVV = Boolean.valueOf(flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(billingRecord.id);
        parcel.writeString(billingRecord.uuid);
        parcel.writeString(billingRecord.firstName);
        parcel.writeString(billingRecord.lastName);
        parcel.writeString(billingRecord.streetAddress1);
        parcel.writeString(billingRecord.streetAddress2);
        parcel.writeString(billingRecord.city);
        parcel.writeString(billingRecord.state);
        parcel.writeString(billingRecord.country);
        parcel.writeString(billingRecord.postalCode);
        parcel.writeString(billingRecord.paymentType);
        parcel.writeString(billingRecord.cardType);
        parcel.writeString(billingRecord.cardNumber);
        parcel.writeInt(billingRecord.expirationMonth.intValue());
        parcel.writeInt(billingRecord.expirationYear.intValue());
        byte byte0;
        if (billingRecord.isDefault.booleanValue())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(billingRecord.billingRecordId);
        parcel.writeString(billingRecord.name);
        if (billingRecord.requireCVV.booleanValue())
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gift;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import roboguice.util.Strings;

public class GiftingRecord
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/gift/GiftingRecord);
    public String dealUrl;
    public String deliveryMethod;
    public String emailDeliveryTime;
    public String fromName;
    public String giftWrapChargeAmount;
    public boolean isGiftWrappable;
    public boolean isGiftWrapped;
    public boolean isGoods;
    public String message;
    public String recipientEmail;
    public String recipientName;
    public int themeCategoryIndex;
    public String themeId;
    public int themeSubIndex;

    public GiftingRecord()
    {
        fromName = "";
        message = "";
        recipientName = "";
        recipientEmail = "";
        deliveryMethod = "";
        giftWrapChargeAmount = "";
        emailDeliveryTime = "";
        dealUrl = "";
        themeId = "";
        themeCategoryIndex = 0;
        themeSubIndex = 0;
    }

    public GiftingRecord(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        fromName = "";
        message = "";
        recipientName = "";
        recipientEmail = "";
        deliveryMethod = "";
        giftWrapChargeAmount = "";
        emailDeliveryTime = "";
        dealUrl = "";
        themeId = "";
        themeCategoryIndex = 0;
        themeSubIndex = 0;
        fromName = parcel.readString();
        message = parcel.readString();
        recipientName = parcel.readString();
        recipientEmail = parcel.readString();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isGiftWrappable = flag;
        deliveryMethod = parcel.readString();
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isGiftWrapped = flag;
        giftWrapChargeAmount = parcel.readString();
        emailDeliveryTime = parcel.readString();
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isGoods = flag;
        dealUrl = parcel.readString();
        themeId = parcel.readString();
        themeCategoryIndex = parcel.readInt();
        themeSubIndex = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(Strings.toString(fromName));
        parcel.writeString(Strings.toString(message));
        parcel.writeString(Strings.toString(recipientName));
        parcel.writeString(Strings.toString(recipientEmail));
        if (isGiftWrappable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(Strings.toString(deliveryMethod));
        if (isGiftWrapped)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(Strings.toString(giftWrapChargeAmount));
        parcel.writeString(Strings.toString(emailDeliveryTime));
        if (isGoods)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(Strings.toString(dealUrl));
        parcel.writeString(Strings.toString(themeId));
        parcel.writeInt(themeCategoryIndex);
        parcel.writeInt(themeSubIndex);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.a.b;
import com.target.mothership.model.cart.interfaces.DigitalDownloadDeliveryProfile;
import com.target.mothership.model.cart.interfaces.GiftCardDeliveryProfile;
import com.target.mothership.model.cart.interfaces.Shipment;
import com.target.mothership.model.common.GuestAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TGTShipment
    implements Shipment
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTShipment a(Parcel parcel)
        {
            return new TGTShipment(parcel);
        }

        public TGTShipment[] a(int i)
        {
            return new TGTShipment[i];
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
    private DigitalDownloadDeliveryProfile mDigitalDownloadDeliveryProfile;
    private Date mExpectedDeliveryEndDate;
    private Date mExpectedDeliveryStartDate;
    private GiftCardDeliveryProfile mGiftCardDeliveryProfile;
    private boolean mIsSignatureRequired;
    private String mPickUpPersonName;
    private List mProducts;
    private int mQuantity;
    private String mShipModeDescription;
    private String mShipModeId;
    private int mShipmentNumber;
    private GuestAddress mShippingAddress;

    TGTShipment()
    {
    }

    TGTShipment(Parcel parcel)
    {
        Object obj1 = null;
        super();
        long l = parcel.readLong();
        Object obj;
        int i;
        boolean flag;
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mExpectedDeliveryStartDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mExpectedDeliveryEndDate = ((Date) (obj));
        mProducts = new ArrayList();
        parcel.readList(mProducts, com/target/mothership/model/cart/handler/TGTShipment.getClassLoader());
        mPickUpPersonName = parcel.readString();
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.a.b.values()[i];
        }
        mDeliveryMethod = ((b) (obj));
        mShipModeDescription = parcel.readString();
        mShipModeId = parcel.readString();
        mShipmentNumber = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsSignatureRequired = flag;
        mQuantity = parcel.readInt();
        mShippingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
        mGiftCardDeliveryProfile = (GiftCardDeliveryProfile)parcel.readParcelable(com/target/mothership/model/cart/interfaces/GiftCardDeliveryProfile.getClassLoader());
        mDigitalDownloadDeliveryProfile = (DigitalDownloadDeliveryProfile)parcel.readParcelable(com/target/mothership/model/cart/interfaces/DigitalDownloadDeliveryProfile.getClassLoader());
    }

    public List a()
    {
        return mProducts;
    }

    public void a(b b1)
    {
        mDeliveryMethod = b1;
    }

    public void a(DigitalDownloadDeliveryProfile digitaldownloaddeliveryprofile)
    {
        mDigitalDownloadDeliveryProfile = digitaldownloaddeliveryprofile;
    }

    public void a(GiftCardDeliveryProfile giftcarddeliveryprofile)
    {
        mGiftCardDeliveryProfile = giftcarddeliveryprofile;
    }

    public void a(GuestAddress guestaddress)
    {
        mShippingAddress = guestaddress;
    }

    public void a(String s)
    {
        mPickUpPersonName = s;
    }

    public void a(List list)
    {
        mProducts = list;
    }

    public void a(boolean flag)
    {
        mIsSignatureRequired = flag;
    }

    public b b()
    {
        return mDeliveryMethod;
    }

    public void b(String s)
    {
        mShipModeDescription = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mShippingAddress);
    }

    public void c(String s)
    {
        mShipModeId = s;
    }

    public e d()
    {
        if (mGiftCardDeliveryProfile == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mGiftCardDeliveryProfile);
        }
    }

    public void d(String s)
    {
        int i;
        if (s != null)
        {
            i = Integer.parseInt(s);
        } else
        {
            i = 0;
        }
        mShipmentNumber = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        if (mDigitalDownloadDeliveryProfile == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mDigitalDownloadDeliveryProfile);
        }
    }

    public void e(String s)
    {
        int i;
        if (s != null)
        {
            i = Double.valueOf(s).intValue();
        } else
        {
            i = 0;
        }
        mQuantity = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        byte byte0;
        int j;
        long l;
        if (mExpectedDeliveryStartDate != null)
        {
            l = mExpectedDeliveryStartDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mExpectedDeliveryEndDate != null)
        {
            l = mExpectedDeliveryEndDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeList(mProducts);
        parcel.writeString(mPickUpPersonName);
        if (mDeliveryMethod == null)
        {
            j = -1;
        } else
        {
            j = mDeliveryMethod.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeString(mShipModeDescription);
        parcel.writeString(mShipModeId);
        parcel.writeInt(mShipmentNumber);
        if (mIsSignatureRequired)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mQuantity);
        parcel.writeParcelable(mShippingAddress, i);
        parcel.writeParcelable(mGiftCardDeliveryProfile, i);
        parcel.writeParcelable(mDigitalDownloadDeliveryProfile, i);
    }

}

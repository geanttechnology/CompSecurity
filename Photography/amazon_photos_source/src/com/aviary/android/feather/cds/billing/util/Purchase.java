// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.billing.util;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Purchase createFromParcel(Parcel parcel)
        {
            return new Purchase(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Purchase[] newArray(int i)
        {
            return new Purchase[0];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String mDeveloperPayload;
    String mItemType;
    String mOrderId;
    String mOriginalJson;
    String mPackageName;
    int mPurchaseState;
    long mPurchaseTime;
    String mSignature;
    String mSku;
    String mToken;

    public Purchase(Parcel parcel)
    {
        mItemType = parcel.readString();
        mOrderId = parcel.readString();
        mPackageName = parcel.readString();
        mSku = parcel.readString();
        mPurchaseTime = parcel.readLong();
        mPurchaseState = parcel.readInt();
        mDeveloperPayload = parcel.readString();
        mToken = parcel.readString();
        mSignature = parcel.readString();
    }

    public Purchase(String s, String s1, String s2)
        throws JSONException
    {
        mItemType = s;
        mOriginalJson = s1;
        s = new JSONObject(mOriginalJson);
        mOrderId = s.optString("orderId");
        mPackageName = s.optString("packageName");
        mSku = s.optString("productId");
        mPurchaseTime = s.optLong("purchaseTime");
        mPurchaseState = s.optInt("purchaseState");
        mDeveloperPayload = s.optString("developerPayload");
        mToken = s.optString("token", s.optString("purchaseToken"));
        mSignature = s2;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDeveloperPayload()
    {
        return mDeveloperPayload;
    }

    public String getItemType()
    {
        return mItemType;
    }

    public String getOrderId()
    {
        return mOrderId;
    }

    public String getOriginalJson()
    {
        return mOriginalJson;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public int getPurchaseState()
    {
        return mPurchaseState;
    }

    public long getPurchaseTime()
    {
        return mPurchaseTime;
    }

    public String getSignature()
    {
        return mSignature;
    }

    public String getSku()
    {
        return mSku;
    }

    public String getToken()
    {
        return mToken;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PurchaseInfo(type:").append(mItemType).append("):").append(mOriginalJson).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mItemType);
        parcel.writeString(mOrderId);
        parcel.writeString(mPackageName);
        parcel.writeString(mSku);
        parcel.writeLong(mPurchaseTime);
        parcel.writeInt(mPurchaseState);
        parcel.writeString(mDeveloperPayload);
        parcel.writeString(mToken);
        parcel.writeString(mSignature);
    }

}

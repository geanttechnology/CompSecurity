// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.dvm.handler;

import android.os.Parcel;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;

public class TGTDvmDataResponse
    implements DvmDataResponse
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDvmDataResponse a(Parcel parcel)
        {
            return new TGTDvmDataResponse(parcel);
        }

        public TGTDvmDataResponse[] a(int i)
        {
            return new TGTDvmDataResponse[i];
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
    private String mClickMacro;
    private String mDeepLink;
    private String mImageUrl;

    TGTDvmDataResponse()
    {
    }

    private TGTDvmDataResponse(Parcel parcel)
    {
        mClickMacro = parcel.readString();
        mImageUrl = parcel.readString();
        mDeepLink = parcel.readString();
    }


    public String a()
    {
        return mImageUrl;
    }

    public void a(String s)
    {
        mImageUrl = s;
    }

    public String b()
    {
        return mClickMacro;
    }

    public void b(String s)
    {
        mClickMacro = s;
    }

    public String c()
    {
        return mDeepLink;
    }

    public void c(String s)
    {
        mDeepLink = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mClickMacro);
        parcel.writeString(mImageUrl);
        parcel.writeString(mDeepLink);
    }

}

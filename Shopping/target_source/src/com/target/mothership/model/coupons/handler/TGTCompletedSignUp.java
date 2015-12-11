// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import android.os.Parcel;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;

class TGTCompletedSignUp
    implements CompletedSignUp
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCompletedSignUp a(Parcel parcel)
        {
            return new TGTCompletedSignUp(parcel);
        }

        public TGTCompletedSignUp[] a(int i)
        {
            return new TGTCompletedSignUp[i];
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

    TGTCompletedSignUp()
    {
    }

    public TGTCompletedSignUp(Parcel parcel)
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

}

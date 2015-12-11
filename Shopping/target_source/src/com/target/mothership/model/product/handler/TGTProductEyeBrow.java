// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.f;
import com.target.mothership.model.product.interfaces.ProductEyeBrow;

public class TGTProductEyeBrow
    implements ProductEyeBrow
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductEyeBrow a(Parcel parcel)
        {
            return new TGTProductEyeBrow(parcel);
        }

        public TGTProductEyeBrow[] a(int i)
        {
            return new TGTProductEyeBrow[i];
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
    private f mCode;
    private String mMessage;

    TGTProductEyeBrow()
    {
        mCode = f.UNKNOWN;
    }

    private TGTProductEyeBrow(Parcel parcel)
    {
        mCode = f.UNKNOWN;
        int i = parcel.readInt();
        f f1;
        if (i == -1)
        {
            f1 = null;
        } else
        {
            f1 = f.values()[i];
        }
        mCode = f1;
        mMessage = parcel.readString();
    }


    public f a()
    {
        return mCode;
    }

    public void a(f f1)
    {
        mCode = f1;
    }

    public void a(String s)
    {
        mMessage = s;
    }

    public String b()
    {
        return mMessage;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mCode == null)
        {
            i = -1;
        } else
        {
            i = mCode.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mMessage);
    }

}

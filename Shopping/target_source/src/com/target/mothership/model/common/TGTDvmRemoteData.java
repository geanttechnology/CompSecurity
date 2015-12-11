// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import java.net.URL;

public class TGTDvmRemoteData
    implements DvmRemoteData
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDvmRemoteData a(Parcel parcel)
        {
            return new TGTDvmRemoteData(parcel);
        }

        public TGTDvmRemoteData[] a(int i)
        {
            return new TGTDvmRemoteData[i];
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
    private URL mDvmUrl;

    public TGTDvmRemoteData()
    {
    }

    private TGTDvmRemoteData(Parcel parcel)
    {
        mDvmUrl = (URL)parcel.readSerializable();
    }


    public URL a()
    {
        return mDvmUrl;
    }

    public void a(URL url)
    {
        mDvmUrl = url;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mDvmUrl);
    }

}

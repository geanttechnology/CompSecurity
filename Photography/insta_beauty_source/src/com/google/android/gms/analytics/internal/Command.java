// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

public class Command
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private String mValue;
    private String zzKI;
    private String zzKJ;

    public Command()
    {
    }

    Command(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel)
    {
        zzKI = parcel.readString();
        zzKJ = parcel.readString();
        mValue = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getId()
    {
        return zzKI;
    }

    public String getValue()
    {
        return mValue;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(zzKI);
        parcel.writeString(zzKJ);
        parcel.writeString(mValue);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzq(parcel);
        }

        public Object[] newArray(int i)
        {
            return zzaa(i);
        }

        public Command[] zzaa(int i)
        {
            return new Command[i];
        }

        public Command zzq(Parcel parcel)
        {
            return new Command(parcel);
        }

        _cls1()
        {
        }
    }

}

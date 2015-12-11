// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon

public class Turn
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Turn a(Parcel parcel)
        {
            return new Turn(parcel);
        }

        public Turn[] a(int i)
        {
            return new Turn[i];
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
    public AccountIcon accountIcon;
    public String trackApp;
    public String trackInstrumentId;
    public String trackOptions;
    public int trackPartId;
    public String trackUrl;
    public int turn;

    public Turn()
    {
    }

    public Turn(Parcel parcel)
    {
        turn = parcel.readInt();
        accountIcon = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        trackUrl = parcel.readString();
        trackOptions = parcel.readString();
        trackPartId = parcel.readInt();
        trackInstrumentId = parcel.readString();
        trackApp = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(turn);
        parcel.writeParcelable(accountIcon, 0);
        parcel.writeString(trackUrl);
        parcel.writeString(trackOptions);
        parcel.writeInt(trackPartId);
        parcel.writeString(trackInstrumentId);
        parcel.writeString(trackApp);
    }

}

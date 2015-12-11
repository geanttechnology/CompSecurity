// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            Turn

public class Round
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Round a(Parcel parcel)
        {
            return new Round(parcel);
        }

        public Round[] a(int i)
        {
            return new Round[i];
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
    public int round;
    public List turns;

    public Round()
    {
        turns = new ArrayList();
    }

    public Round(Parcel parcel)
    {
        turns = new ArrayList();
        round = parcel.readInt();
        turns = parcel.readArrayList(com/smule/android/network/models/Turn.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(round);
        parcel.writeList(turns);
    }

}

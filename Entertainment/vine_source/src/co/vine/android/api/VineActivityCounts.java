// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VineActivityCounts
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineActivityCounts createFromParcel(Parcel parcel)
        {
            return new VineActivityCounts(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineActivityCounts[] newArray(int i)
        {
            return new VineActivityCounts[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int messages;
    public int notifications;

    public VineActivityCounts(int i, int j)
    {
        messages = i;
        notifications = j;
    }

    public VineActivityCounts(Parcel parcel)
    {
        messages = parcel.readInt();
        notifications = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(messages);
        parcel.writeInt(notifications);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VineRTCParticipant
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineRTCParticipant createFromParcel(Parcel parcel)
        {
            return new VineRTCParticipant(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineRTCParticipant[] newArray(int i)
        {
            return new VineRTCParticipant[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean isConnected;
    public boolean isTyping;
    public long lastMessageId;
    public long userId;

    public VineRTCParticipant(long l, boolean flag, boolean flag1, long l1)
    {
        userId = l;
        lastMessageId = l1;
        isConnected = flag;
        isTyping = flag1;
    }

    public VineRTCParticipant(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        userId = parcel.readLong();
        lastMessageId = parcel.readLong();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isConnected = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isTyping = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeLong(userId);
        parcel.writeLong(lastMessageId);
        if (isConnected)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isTyping)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}

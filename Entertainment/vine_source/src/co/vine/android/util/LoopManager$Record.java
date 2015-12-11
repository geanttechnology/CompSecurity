// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package co.vine.android.util:
//            LoopManager, LongSparseArray

public static class <init>
    implements Parcelable
{

    public static final android.os.er.Record.timeStamp CREATOR = new android.os.Parcelable.Creator() {

        public LoopManager.Record createFromParcel(Parcel parcel)
        {
            return new LoopManager.Record(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LoopManager.Record[] newArray(int i)
        {
            return new LoopManager.Record[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int loopCount;
    public long postId;
    public long timeStamp;
    public long userId;

    public static <init> fromSerializedString(String s)
    {
        s = s.split(":");
        if (s.length != 4)
        {
            return null;
        } else
        {
            <init> <init>1 = new <init>();
            <init>1.userId = Long.parseLong(s[0]);
            <init>1.postId = Long.parseLong(s[1]);
            <init>1.loopCount = Integer.parseInt(s[2]);
            <init>1.timeStamp = Long.parseLong(s[3]);
            return <init>1;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void increment()
    {
        loopCount = loopCount + 1;
        timeStamp = System.currentTimeMillis();
        int i = ((Integer)LoopManager.access$000().get(postId, Integer.valueOf(-1))).intValue();
        if (i == -1)
        {
            LoopManager.access$000().put(postId, Integer.valueOf(1));
            return;
        } else
        {
            LoopManager.access$000().put(postId, Integer.valueOf(i + 1));
            return;
        }
    }

    public String toSerializedString()
    {
        return (new StringBuilder()).append(String.valueOf(userId)).append(':').append(postId).append(':').append(loopCount).append(':').append(timeStamp).toString();
    }

    public String toString()
    {
        return toSerializedString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(userId);
        parcel.writeLong(postId);
        parcel.writeInt(loopCount);
        parcel.writeLong(timeStamp);
    }


    private _cls1()
    {
    }

    public _cls1(long l, long l1)
    {
        userId = l;
        postId = l1;
        loopCount = 0;
    }

    private loopCount(Parcel parcel)
    {
        userId = parcel.readLong();
        postId = parcel.readLong();
        loopCount = parcel.readInt();
        timeStamp = parcel.readLong();
    }

    timeStamp(Parcel parcel, timeStamp timestamp)
    {
        this(parcel);
    }
}

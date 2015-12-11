// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VinePostResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VinePostResponse createFromParcel(Parcel parcel)
        {
            return new VinePostResponse(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VinePostResponse[] newArray(int i)
        {
            return new VinePostResponse[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final long createdAt;
    public final long postId;

    public VinePostResponse(long l, long l1)
    {
        postId = l;
        createdAt = l1;
    }

    public VinePostResponse(Parcel parcel)
    {
        postId = parcel.readLong();
        createdAt = parcel.readLong();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(postId);
        parcel.writeLong(createdAt);
    }

}

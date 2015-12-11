// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon, FeedListItemObject

public class FeedListItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FeedListItem a(Parcel parcel)
        {
            return new FeedListItem(parcel);
        }

        public FeedListItem[] a(int i)
        {
            return new FeedListItem[i];
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
    private static final String a = com/smule/android/network/models/FeedListItem.getSimpleName();
    public String action;
    public long actionTime;
    public String content;
    public int count;
    public FeedListItemObject object;
    public String recId;
    public String source;
    public AccountIcon subject;

    public FeedListItem()
    {
    }

    private FeedListItem(Parcel parcel)
    {
        recId = parcel.readString();
        subject = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        action = parcel.readString();
        content = parcel.readString();
        count = parcel.readInt();
        actionTime = parcel.readLong();
        source = parcel.readString();
        object = (FeedListItemObject)parcel.readParcelable(com/smule/android/network/models/FeedListItemObject.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("FeedListItem{recId='").append(recId).append('\'').append(", subject=").append(subject).append(", action='").append(action).append('\'').append(", content='").append(content).append('\'').append(", count=").append(count).append(", actionTime=").append(actionTime).append(", source='").append(source).append('\'').append(", object=").append(object).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(recId);
        parcel.writeParcelable(subject, 0);
        parcel.writeString(action);
        parcel.writeString(content);
        parcel.writeInt(count);
        parcel.writeLong(actionTime);
        parcel.writeString(source);
        parcel.writeParcelable(object, 0);
    }

}

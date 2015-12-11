// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon, NotificationItemObject, NotificationItemAggObject

public class NotificationListItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NotificationListItem a(Parcel parcel)
        {
            return new NotificationListItem(parcel);
        }

        public NotificationListItem[] a(int i)
        {
            return new NotificationListItem[i];
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
    private static final String a = com/smule/android/network/models/NotificationListItem.getSimpleName();
    public NotificationItemAggObject aggObject;
    public String content;
    public int count;
    public String entity;
    public NotificationItemObject object;
    public List subjects;
    public long time;
    public String type;

    public NotificationListItem()
    {
        subjects = new ArrayList();
    }

    private NotificationListItem(Parcel parcel)
    {
        subjects = new ArrayList();
        parcel.readTypedList(subjects, AccountIcon.CREATOR);
        type = parcel.readString();
        entity = parcel.readString();
        content = parcel.readString();
        count = parcel.readInt();
        time = parcel.readLong();
        object = (NotificationItemObject)parcel.readParcelable(com/smule/android/network/models/NotificationItemObject.getClassLoader());
        aggObject = (NotificationItemAggObject)parcel.readParcelable(com/smule/android/network/models/NotificationItemAggObject.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("NotificationListItem{subjects=").append(subjects).append(", type='").append(type).append('\'').append(", entity='").append(entity).append('\'').append(", content='").append(content).append('\'').append(", count=").append(count).append(", time=").append(time).append(", object=").append(object).append(", aggObject=").append(aggObject).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedList(subjects);
        parcel.writeString(type);
        parcel.writeString(entity);
        parcel.writeString(content);
        parcel.writeInt(count);
        parcel.writeLong(time);
        parcel.writeParcelable(object, 0);
        parcel.writeParcelable(aggObject, 0);
    }

}

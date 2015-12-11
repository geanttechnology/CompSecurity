// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon, NotificationItemObject

public class Notification
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Notification a(Parcel parcel)
        {
            return new Notification(parcel);
        }

        public Notification[] a(int i)
        {
            return new Notification[i];
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
    public String content;
    public String entity;
    public String notificationKey;
    public NotificationItemObject object;
    public AccountIcon subject;
    public long time;
    public String type;

    public Notification()
    {
    }

    private Notification(Parcel parcel)
    {
        notificationKey = parcel.readString();
        subject = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        type = parcel.readString();
        entity = parcel.readString();
        content = parcel.readString();
        time = parcel.readLong();
        object = (NotificationItemObject)parcel.readParcelable(com/smule/android/network/models/NotificationItemObject.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Notification{notificationKey='").append(notificationKey).append('\'').append(", subject=").append(subject).append(", type='").append(type).append('\'').append(", entity=").append(entity).append(", content=").append(content).append(", time=").append(time).append(", object=").append(object).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(notificationKey);
        parcel.writeParcelable(subject, 0);
        parcel.writeString(type);
        parcel.writeString(entity);
        parcel.writeString(content);
        parcel.writeLong(time);
        parcel.writeParcelable(object, 0);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class NotificationItemAggObject
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NotificationItemAggObject a(Parcel parcel)
        {
            return new NotificationItemAggObject(parcel);
        }

        public NotificationItemAggObject[] a(int i)
        {
            return new NotificationItemAggObject[i];
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
    public List notificationKeys;

    public NotificationItemAggObject()
    {
        notificationKeys = new ArrayList();
    }

    private NotificationItemAggObject(Parcel parcel)
    {
        notificationKeys = new ArrayList();
        notificationKeys = new ArrayList();
        parcel.readList(notificationKeys, java/util/List.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("NotificationItemAggObject{notificationKeys=").append(notificationKeys).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(notificationKeys);
    }

}

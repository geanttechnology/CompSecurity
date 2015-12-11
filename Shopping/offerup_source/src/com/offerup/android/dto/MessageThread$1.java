// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            MessageThread, Person, Item, BuyRequest

final class 
    implements android.os.or
{

    public final MessageThread createFromParcel(Parcel parcel)
    {
        MessageThread messagethread = new MessageThread();
        messagethread.seller = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
        messagethread.messageCount = parcel.readInt();
        messagethread.item = (Item)parcel.readParcelable(com/offerup/android/dto/Item.getClassLoader());
        messagethread.lastPostDate = parcel.readString();
        messagethread.currentBuyRequest = (BuyRequest)parcel.readParcelable(com/offerup/android/dto/BuyRequest.getClassLoader());
        messagethread.buyer = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
        messagethread.dateCreated = parcel.readString();
        messagethread.id = parcel.readLong();
        return messagethread;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final MessageThread[] newArray(int i)
    {
        return new MessageThread[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

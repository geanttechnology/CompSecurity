// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            Person, BuyRequest, Item

public class MessageThread
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    Person buyer;
    BuyRequest currentBuyRequest;
    String dateCreated;
    long id;
    Item item;
    String lastPostDate;
    int messageCount;
    Person seller;

    public MessageThread()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public Person getBuyer()
    {
        return buyer;
    }

    public BuyRequest getCurrentBuyRequest()
    {
        return currentBuyRequest;
    }

    public String getDateCreated()
    {
        return dateCreated;
    }

    public long getId()
    {
        return id;
    }

    public Item getItem()
    {
        return item;
    }

    public String getLastPostDate()
    {
        return lastPostDate;
    }

    public int getMessageCount()
    {
        return messageCount;
    }

    public Person getSeller()
    {
        return seller;
    }

    public void setBuyer(Person person)
    {
        buyer = person;
    }

    public void setCurrentBuyRequest(BuyRequest buyrequest)
    {
        currentBuyRequest = buyrequest;
    }

    public void setDateCreated(String s)
    {
        dateCreated = s;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setItem(Item item1)
    {
        item = item1;
    }

    public void setLastPostDate(String s)
    {
        lastPostDate = s;
    }

    public void setMessageCount(int i)
    {
        messageCount = i;
    }

    public void setSeller(Person person)
    {
        seller = person;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(seller, i);
        parcel.writeInt(messageCount);
        parcel.writeParcelable(item, i);
        parcel.writeString(lastPostDate);
        parcel.writeParcelable(currentBuyRequest, i);
        parcel.writeParcelable(buyer, i);
        parcel.writeString(dateCreated);
        parcel.writeLong(id);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
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

        _cls1()
        {
        }
    }

}

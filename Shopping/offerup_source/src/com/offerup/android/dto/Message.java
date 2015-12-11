// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            BuyRequest, Person, MessageThread

public class Message
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    BuyRequest buyRequest;
    Person buyer;
    long id;
    String message;
    String messageButtonText;
    String messageTitle;
    int messageType;
    String messageUrl;
    String readDate;
    a sendDate;
    String sendDateAgo;
    Person sender;
    MessageThread thread;

    public Message()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public BuyRequest getBuyRequest()
    {
        return buyRequest;
    }

    public Person getBuyer()
    {
        return buyer;
    }

    public long getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }

    public String getMessageButtonText()
    {
        return messageButtonText;
    }

    public String getMessageTitle()
    {
        return messageTitle;
    }

    public int getMessageType()
    {
        return messageType;
    }

    public String getMessageUrl()
    {
        return messageUrl;
    }

    public String getReadDate()
    {
        return readDate;
    }

    public a getSendDate()
    {
        return sendDate;
    }

    public String getSendDateAgo()
    {
        return sendDateAgo;
    }

    public Person getSender()
    {
        return sender;
    }

    public MessageThread getThread()
    {
        return thread;
    }

    public void setBuyRequest(BuyRequest buyrequest)
    {
        buyRequest = buyrequest;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setReadDate(String s)
    {
        readDate = s;
    }

    public void setSendDate(a a)
    {
        sendDate = a;
    }

    public void setSendDateAgo(String s)
    {
        sendDateAgo = s;
    }

    public void setSender(Person person)
    {
        sender = person;
    }

    public void setThread(MessageThread messagethread)
    {
        thread = messagethread;
    }

    public String toString()
    {
        return (new StringBuilder("Message [thread=")).append(thread).append(", sendDateAgo=").append(sendDateAgo).append(", message=").append(message).append(", id=").append(id).append(", buyRequest=").append(buyRequest).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(sender, i);
        parcel.writeString(readDate);
        parcel.writeParcelable(thread, i);
        parcel.writeString(sendDateAgo);
        parcel.writeSerializable(sendDate);
        parcel.writeString(message);
        parcel.writeParcelable(buyer, i);
        parcel.writeInt(messageType);
        parcel.writeString(messageUrl);
        parcel.writeString(messageTitle);
        parcel.writeString(messageButtonText);
        parcel.writeLong(id);
        parcel.writeParcelable(buyRequest, i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Message createFromParcel(Parcel parcel)
        {
            Message message1 = new Message();
            message1.sender = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            message1.readDate = parcel.readString();
            message1.thread = (MessageThread)parcel.readParcelable(com/offerup/android/dto/MessageThread.getClassLoader());
            message1.sendDateAgo = parcel.readString();
            message1.sendDate = (a)parcel.readSerializable();
            message1.message = parcel.readString();
            message1.buyer = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            message1.messageType = parcel.readInt();
            message1.messageUrl = parcel.readString();
            message1.messageTitle = parcel.readString();
            message1.messageButtonText = parcel.readString();
            message1.id = parcel.readLong();
            message1.buyRequest = (BuyRequest)parcel.readParcelable(com/offerup/android/dto/BuyRequest.getClassLoader());
            return message1;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Message[] newArray(int i)
        {
            return new Message[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.api:
//            VinePrivateMessage

public class VineConversation
    implements Externalizable, Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineConversation createFromParcel(Parcel parcel)
        {
            return new VineConversation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineConversation[] newArray(int i)
        {
            return new VineConversation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public long conversationId;
    public long conversationObjectId;
    public long createdBy;
    public long lastMessage;
    public ArrayList messages;
    public int networkType;
    public long unreadMessageCount;
    public ArrayList users;

    public VineConversation()
    {
    }

    public VineConversation(long l, long l1, long l2, ArrayList arraylist, 
            ArrayList arraylist1, int i, long l3)
    {
        conversationId = l;
        lastMessage = l1;
        createdBy = l2;
        unreadMessageCount = l3;
        messages = arraylist;
        users = arraylist1;
        networkType = i;
    }

    public VineConversation(long l, long l1, ArrayList arraylist, long l2)
    {
        conversationId = l;
        lastMessage = l1;
        messages = arraylist;
        unreadMessageCount = l2;
    }

    public VineConversation(Parcel parcel)
    {
        conversationId = parcel.readLong();
        lastMessage = parcel.readLong();
        createdBy = parcel.readLong();
        unreadMessageCount = parcel.readLong();
        messages = (ArrayList)parcel.readSerializable();
        users = (ArrayList)parcel.readSerializable();
        networkType = parcel.readInt();
        conversationObjectId = parcel.readLong();
    }

    public int describeContents()
    {
        return 0;
    }

    public VinePrivateMessage lastMessage()
    {
        if (messages.isEmpty())
        {
            return null;
        }
        for (Iterator iterator = messages.iterator(); iterator.hasNext();)
        {
            VinePrivateMessage vineprivatemessage = (VinePrivateMessage)iterator.next();
            if (vineprivatemessage.messageId == lastMessage)
            {
                return vineprivatemessage;
            }
        }

        return (VinePrivateMessage)messages.get(0);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        conversationId = objectinput.readLong();
        lastMessage = objectinput.readLong();
        createdBy = objectinput.readLong();
        unreadMessageCount = objectinput.readLong();
        messages = (ArrayList)objectinput.readObject();
        users = (ArrayList)objectinput.readObject();
        networkType = objectinput.readInt();
        conversationObjectId = objectinput.readLong();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeLong(conversationId);
        objectoutput.writeLong(lastMessage);
        objectoutput.writeLong(createdBy);
        objectoutput.writeLong(unreadMessageCount);
        objectoutput.writeObject(messages);
        objectoutput.writeObject(users);
        objectoutput.writeInt(networkType);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(conversationId);
        parcel.writeLong(lastMessage);
        parcel.writeLong(createdBy);
        parcel.writeLong(unreadMessageCount);
        parcel.writeSerializable(messages);
        parcel.writeSerializable(users);
        parcel.writeInt(networkType);
        parcel.writeLong(conversationObjectId);
    }

}

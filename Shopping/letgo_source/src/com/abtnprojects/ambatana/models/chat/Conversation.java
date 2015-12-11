// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.chat:
//            Message

public class Conversation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Conversation createFromParcel(Parcel parcel)
        {
            return new Conversation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Conversation[] newArray(int i)
        {
            return new Conversation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final User buyer;
    private final String id;
    private final List messages;
    private final Product product;
    private int unreadCount;
    private final Date updatedAt;
    private final User userFrom;
    private final User userTo;
    private final User userToDisplay;

    protected Conversation(Parcel parcel)
    {
        id = parcel.readString();
        product = (Product)parcel.readParcelable(com/abtnprojects/ambatana/models/product/Product.getClassLoader());
        unreadCount = parcel.readInt();
        messages = parcel.createTypedArrayList(Message.CREATOR);
        userFrom = (User)parcel.readParcelable(com/abtnprojects/ambatana/models/user/User.getClassLoader());
        userTo = (User)parcel.readParcelable(com/abtnprojects/ambatana/models/user/User.getClassLoader());
        userToDisplay = (User)parcel.readParcelable(com/abtnprojects/ambatana/models/user/User.getClassLoader());
        updatedAt = (Date)parcel.readSerializable();
        buyer = (User)parcel.readParcelable(com/abtnprojects/ambatana/models/user/User.getClassLoader());
    }

    public Conversation(String s, Product product1, int i, Date date, List list, User user, User user1, 
            User user2, User user3)
    {
        id = s;
        product = product1;
        unreadCount = i;
        updatedAt = date;
        messages = list;
        userFrom = user;
        userTo = user1;
        userToDisplay = user2;
        buyer = user3;
    }

    public int describeContents()
    {
        return 0;
    }

    public User getBuyer()
    {
        return buyer;
    }

    public String getId()
    {
        return id;
    }

    public List getMessages()
    {
        return messages;
    }

    public Product getProduct()
    {
        return product;
    }

    public int getUnreadCount()
    {
        return unreadCount;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public User getUserFrom()
    {
        return userFrom;
    }

    public User getUserTo()
    {
        return userTo;
    }

    public User getUserToDisplay()
    {
        return userToDisplay;
    }

    public void setUnreadCount(int i)
    {
        unreadCount = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeParcelable(product, i);
        parcel.writeInt(unreadCount);
        parcel.writeTypedList(messages);
        parcel.writeParcelable(userFrom, i);
        parcel.writeParcelable(userTo, i);
        parcel.writeParcelable(userToDisplay, i);
        parcel.writeSerializable(updatedAt);
        parcel.writeParcelable(buyer, i);
    }

}

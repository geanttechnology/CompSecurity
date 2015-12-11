// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Annotation;
import java.util.Date;

public class Message
    implements Parcelable
{
    public static interface Type
        extends Annotation
    {
    }


    public static final int ANSWER = 0;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Message createFromParcel(Parcel parcel)
        {
            return new Message(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Message[] newArray(int i)
        {
            return new Message[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int OFFER = 1;
    private final Date createdAt;
    private final int id;
    private final String text;
    private final int type;
    private String userAvatarUrl;
    private String userId;
    private String userName;

    public Message(int i, String s, int j, Date date, String s1, String s2, String s3)
    {
        id = i;
        text = s;
        type = j;
        createdAt = date;
        userId = s1;
        userAvatarUrl = s2;
        userName = s3;
    }

    protected Message(Parcel parcel)
    {
        id = parcel.readInt();
        text = parcel.readString();
        type = parcel.readInt();
        userId = parcel.readString();
        createdAt = (Date)parcel.readSerializable();
        userAvatarUrl = parcel.readString();
        userName = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public int getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    public int getType()
    {
        return type;
    }

    public String getUserAvatarUrl()
    {
        return userAvatarUrl;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserAvatarUrl(String s)
    {
        userAvatarUrl = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    public void setUserName(String s)
    {
        userName = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Message{id=").append(id).append(", text='").append(text).append('\'').append(", type=").append(type).append(", createdAt=").append(createdAt).append(", userId='").append(userId).append('\'').append(", userAvatarUrl='").append(userAvatarUrl).append('\'').append(", userName='").append(userName).append('\'').append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(id);
        parcel.writeString(text);
        parcel.writeInt(type);
        parcel.writeString(userId);
        parcel.writeSerializable(createdAt);
        parcel.writeString(userAvatarUrl);
        parcel.writeString(userName);
    }

}

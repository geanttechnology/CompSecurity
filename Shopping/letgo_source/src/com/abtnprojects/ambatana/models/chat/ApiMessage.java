// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import android.os.Parcel;
import android.os.Parcelable;

public class ApiMessage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ApiMessage createFromParcel(Parcel parcel)
        {
            return new ApiMessage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ApiMessage[] newArray(int i)
        {
            return new ApiMessage[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String createdAt;
    private final int id;
    private final String text;
    private final int type;
    private final String userId;

    public ApiMessage(int i, String s, int j, String s1, String s2)
    {
        id = i;
        text = s;
        type = j;
        createdAt = s1;
        userId = s2;
    }

    protected ApiMessage(Parcel parcel)
    {
        id = parcel.readInt();
        text = parcel.readString();
        type = parcel.readInt();
        createdAt = parcel.readString();
        userId = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCreatedAt()
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

    public String getUserId()
    {
        return userId;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(id);
        parcel.writeString(text);
        parcel.writeInt(type);
        parcel.writeString(createdAt);
        parcel.writeString(userId);
    }

}

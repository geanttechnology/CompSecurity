// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.c;
import com.socialin.gson.Gson;
import java.util.Date;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, ViewerUser

public class Comment extends Response
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Comment createFromParcel(Parcel parcel)
        {
            return new Comment(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Comment[] newArray(int i)
        {
            return new Comment[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Date createdAt;
    public String id;
    public String text;
    public ViewerUser user;

    public Comment(Parcel parcel)
    {
        createdAt = null;
        readFromParcel(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void readFromParcel(Parcel parcel)
    {
        id = parcel.readString();
        text = parcel.readString();
        String s = parcel.readString();
        if (!s.equals(""))
        {
            createdAt = (Date)c.a().fromJson(s, java/util/Date);
        }
        if (Boolean.parseBoolean(parcel.readString()))
        {
            user = new ViewerUser();
            user.id = parcel.readLong();
            user.name = parcel.readString();
            user.setPhoto(parcel.readString());
            user.username = parcel.readString();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(text);
        String s;
        if (createdAt == null)
        {
            s = "";
        } else
        {
            s = c.a().toJson(createdAt);
        }
        parcel.writeString(s);
        if (user != null)
        {
            parcel.writeString("true");
            parcel.writeLong(user.id);
            parcel.writeString(user.name);
            parcel.writeString(user.getPhoto());
            parcel.writeString(user.username);
            return;
        } else
        {
            parcel.writeString("false");
            return;
        }
    }

}

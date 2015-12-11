// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public final class AppInviteContent
    implements ShareModel
{
    public static final class a
    {

        public String a;
        String b;

        public a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new AppInviteContent(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new AppInviteContent[i];
        }

    };
    public final String a;
    public final String b;

    AppInviteContent(Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.readString();
    }

    private AppInviteContent(a a1)
    {
        a = a1.a;
        b = a1.b;
    }

    public AppInviteContent(a a1, byte byte0)
    {
        this(a1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
    }

}

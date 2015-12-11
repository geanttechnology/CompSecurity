// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareContent

public final class ShareLinkContent extends ShareContent
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareLinkContent a(Parcel parcel)
        {
            return new ShareLinkContent(parcel);
        }

        public ShareLinkContent[] a(int i)
        {
            return new ShareLinkContent[i];
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
    private final String a;
    private final String b;
    private final Uri c;

    ShareLinkContent(Parcel parcel)
    {
        super(parcel);
        a = parcel.readString();
        b = parcel.readString();
        c = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeParcelable(c, 0);
    }

}

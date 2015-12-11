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
    public static final class a extends ShareContent.a
    {

        private String a;
        private String b;
        private Uri c;

        static String a(a a1)
        {
            return a1.a;
        }

        static String b(a a1)
        {
            return a1.b;
        }

        static Uri c(a a1)
        {
            return a1.c;
        }

        public a a(String s)
        {
            a = s;
            return this;
        }

        public ShareLinkContent a()
        {
            return new ShareLinkContent(this);
        }

        public a b(Uri uri)
        {
            c = uri;
            return this;
        }

        public a b(String s)
        {
            b = s;
            return this;
        }

        public a()
        {
        }
    }


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

    private ShareLinkContent(a a1)
    {
        super(a1);
        a = a.a(a1);
        b = a.b(a1);
        c = a.c(a1);
    }


    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public Uri c()
    {
        return c;
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

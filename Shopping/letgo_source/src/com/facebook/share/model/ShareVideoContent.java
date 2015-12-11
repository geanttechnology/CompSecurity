// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareContent, ShareModel, SharePhoto, ShareVideo

public final class ShareVideoContent extends ShareContent
    implements ShareModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareVideoContent a(Parcel parcel)
        {
            return new ShareVideoContent(parcel);
        }

        public ShareVideoContent[] a(int i)
        {
            return new ShareVideoContent[i];
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
    private final SharePhoto c;
    private final ShareVideo d;

    ShareVideoContent(Parcel parcel)
    {
        super(parcel);
        a = parcel.readString();
        b = parcel.readString();
        SharePhoto.a a1 = (new SharePhoto.a()).a(parcel);
        if (a1.a() != null || a1.b() != null)
        {
            c = a1.c();
        } else
        {
            c = null;
        }
        d = (new ShareVideo.a()).a(parcel).a();
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public SharePhoto c()
    {
        return c;
    }

    public ShareVideo d()
    {
        return d;
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
        parcel.writeParcelable(d, 0);
    }

}

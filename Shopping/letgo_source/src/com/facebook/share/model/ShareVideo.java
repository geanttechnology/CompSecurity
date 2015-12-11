// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareMedia

public final class ShareVideo extends ShareMedia
{
    public static final class a extends ShareMedia.a
    {

        private Uri a;

        static Uri a(a a1)
        {
            return a1.a;
        }

        public volatile ShareMedia.a a(ShareMedia sharemedia)
        {
            return a((ShareVideo)sharemedia);
        }

        public a a(Uri uri)
        {
            a = uri;
            return this;
        }

        public a a(Parcel parcel)
        {
            return a((ShareVideo)parcel.readParcelable(com/facebook/share/model/ShareVideo.getClassLoader()));
        }

        public a a(ShareVideo sharevideo)
        {
            if (sharevideo == null)
            {
                return this;
            } else
            {
                return ((a)super.a(sharevideo)).a(sharevideo.b());
            }
        }

        public ShareVideo a()
        {
            return new ShareVideo(this);
        }

        public a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareVideo a(Parcel parcel)
        {
            return new ShareVideo(parcel);
        }

        public ShareVideo[] a(int i)
        {
            return new ShareVideo[i];
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
    private final Uri a;

    ShareVideo(Parcel parcel)
    {
        super(parcel);
        a = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
    }

    private ShareVideo(a a1)
    {
        super(a1);
        a = a.a(a1);
    }


    public Uri b()
    {
        return a;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(a, 0);
    }

}

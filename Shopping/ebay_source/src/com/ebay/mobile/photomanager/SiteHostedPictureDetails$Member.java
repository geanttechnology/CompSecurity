// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.photomanager:
//            SiteHostedPictureDetails

public static final class width
    implements Parcelable
{

    public static final android.os.ureDetails.Member.width CREATOR = new android.os.Parcelable.Creator() {

        public SiteHostedPictureDetails.Member createFromParcel(Parcel parcel)
        {
            SiteHostedPictureDetails.Member member = new SiteHostedPictureDetails.Member();
            member.url = SiteHostedPictureDetails.readUrl(parcel);
            member.height = parcel.readInt();
            member.width = parcel.readInt();
            return member;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SiteHostedPictureDetails.Member[] newArray(int i)
        {
            return new SiteHostedPictureDetails.Member[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int height;
    public URL url;
    public int width;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        SiteHostedPictureDetails.write(parcel, url);
        parcel.writeInt(height);
        parcel.writeInt(width);
    }


    public _cls1()
    {
        url = null;
        height = 0;
        width = 0;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.os.Parcel;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.photomanager:
//            SiteHostedPictureDetails

static final class mber
    implements android.os.dPictureDetails._cls1
{

    public SiteHostedPictureDetails createFromParcel(Parcel parcel)
    {
        SiteHostedPictureDetails sitehostedpicturedetails = new SiteHostedPictureDetails();
        sitehostedpicturedetails.baseUrl = SiteHostedPictureDetails.readUrl(parcel);
        sitehostedpicturedetails.fullUrl = SiteHostedPictureDetails.readUrl(parcel);
        sitehostedpicturedetails.pictureFormat = parcel.readString();
        sitehostedpicturedetails.pictureSet = parcel.readString();
        sitehostedpicturedetails.useBy = SiteHostedPictureDetails.readDate(parcel);
        int j = parcel.readInt();
        sitehostedpicturedetails.members.ensureCapacity(j);
        for (int i = 0; i < j; i++)
        {
            sitehostedpicturedetails.members.add(mber.CREATOR.omParcel(parcel));
        }

        return sitehostedpicturedetails;
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public SiteHostedPictureDetails[] newArray(int i)
    {
        return new SiteHostedPictureDetails[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    mber()
    {
    }
}

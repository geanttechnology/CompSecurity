// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.os.Parcel;

// Referenced classes of package com.ebay.mobile.photomanager:
//            SiteHostedPictureDetails

static final class 
    implements android.os.eDetails.Member._cls1
{

    public  createFromParcel(Parcel parcel)
    {
          = new nit>();
        .l = SiteHostedPictureDetails.readUrl(parcel);
        .ight = parcel.readInt();
        .dth = parcel.readInt();
        return ;
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

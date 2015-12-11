// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.mobile.activities:
//            ComposeNewMessageActivity

static final class 
    implements android.os.RequestParams._cls1
{

    public  createFromParcel(Parcel parcel)
    {
        return ()DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/activities/ComposeNewMessageActivity$MemberMessageRequestParams);
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

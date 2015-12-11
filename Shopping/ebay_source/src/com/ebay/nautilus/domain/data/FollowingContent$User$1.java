// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            FollowingContent

static final class dUser
    implements android.os.wingContent.User._cls1
{

    public dUser createFromParcel(Parcel parcel)
    {
        return (dUser)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedUser);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public dUser[] newArray(int i)
    {
        return new dUser[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    dUser()
    {
    }
}

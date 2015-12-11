// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.cache.guest:
//            CacheAccountDetails

static final class 
    implements android.os..CacheAccountDetails._cls1
{

    public CacheAccountDetails createFromParcel(Parcel parcel)
    {
        return new CacheAccountDetails(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CacheAccountDetails[] newArray(int i)
    {
        return new CacheAccountDetails[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

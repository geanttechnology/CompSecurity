// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.cache.list:
//            CacheListItem

static final class 
    implements android.os.or
{

    public CacheListItem createFromParcel(Parcel parcel)
    {
        return new CacheListItem(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CacheListItem[] newArray(int i)
    {
        return new CacheListItem[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

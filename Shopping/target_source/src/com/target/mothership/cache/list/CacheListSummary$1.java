// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.cache.list:
//            CacheListSummary

static final class _cls9
    implements android.os.st.CacheListSummary._cls1
{

    public CacheListSummary createFromParcel(Parcel parcel)
    {
        return new CacheListSummary(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CacheListSummary[] newArray(int i)
    {
        return new CacheListSummary[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    _cls9()
    {
    }
}

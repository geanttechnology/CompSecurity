// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.list:
//            CacheListMostRecent

static final class 
    implements android.os.CacheListMostRecent._cls1
{

    public CacheListMostRecent a(Parcel parcel)
    {
        return new CacheListMostRecent(parcel, null);
    }

    public CacheListMostRecent[] a(int i)
    {
        return new CacheListMostRecent[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}

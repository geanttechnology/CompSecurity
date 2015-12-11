// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStoreDetail

static final class 
    implements android.os.r
{

    public TGTStoreDetail a(Parcel parcel)
    {
        return new TGTStoreDetail(parcel, null);
    }

    public TGTStoreDetail[] a(int i)
    {
        return new TGTStoreDetail[i];
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

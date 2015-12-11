// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.store;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.store:
//            StoreIdentifier

static final class 
    implements android.os.
{

    public StoreIdentifier a(Parcel parcel)
    {
        return new StoreIdentifier(parcel, null);
    }

    public StoreIdentifier[] a(int i)
    {
        return new StoreIdentifier[i];
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

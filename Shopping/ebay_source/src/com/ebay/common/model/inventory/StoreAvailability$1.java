// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model.inventory:
//            StoreAvailability

static final class _cls9
    implements android.os..StoreAvailability._cls1
{

    public StoreAvailability createFromParcel(Parcel parcel)
    {
        return new StoreAvailability(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public StoreAvailability[] newArray(int i)
    {
        return new StoreAvailability[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    _cls9()
    {
    }
}

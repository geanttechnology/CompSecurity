// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model.inventory:
//            InventoryInfo

static final class 
    implements android.os.or
{

    public InventoryInfo createFromParcel(Parcel parcel)
    {
        return new InventoryInfo(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public InventoryInfo[] newArray(int i)
    {
        return new InventoryInfo[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

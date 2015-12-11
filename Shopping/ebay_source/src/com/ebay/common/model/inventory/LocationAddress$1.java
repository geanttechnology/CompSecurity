// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model.inventory:
//            LocationAddress

static final class 
    implements android.os.
{

    public LocationAddress createFromParcel(Parcel parcel)
    {
        return new LocationAddress(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public LocationAddress[] newArray(int i)
    {
        return new LocationAddress[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

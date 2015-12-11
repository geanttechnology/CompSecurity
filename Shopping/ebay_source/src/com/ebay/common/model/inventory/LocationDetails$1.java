// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model.inventory:
//            LocationDetails

static final class 
    implements android.os.
{

    public LocationDetails createFromParcel(Parcel parcel)
    {
        return new LocationDetails(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public LocationDetails[] newArray(int i)
    {
        return new LocationDetails[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

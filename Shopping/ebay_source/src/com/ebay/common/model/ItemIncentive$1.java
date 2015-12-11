// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model:
//            ItemIncentive

static final class 
    implements android.os.or
{

    public ItemIncentive createFromParcel(Parcel parcel)
    {
        return new ItemIncentive(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ItemIncentive[] newArray(int i)
    {
        return new ItemIncentive[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

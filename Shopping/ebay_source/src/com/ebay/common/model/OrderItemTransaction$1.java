// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model:
//            OrderItemTransaction

static final class 
    implements android.os.nsaction._cls1
{

    public OrderItemTransaction createFromParcel(Parcel parcel)
    {
        return new OrderItemTransaction(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public OrderItemTransaction[] newArray(int i)
    {
        return new OrderItemTransaction[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

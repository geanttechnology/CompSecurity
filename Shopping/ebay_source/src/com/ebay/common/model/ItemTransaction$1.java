// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model:
//            ItemTransaction

static final class 
    implements android.os.
{

    public ItemTransaction createFromParcel(Parcel parcel)
    {
        return new ItemTransaction(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ItemTransaction[] newArray(int i)
    {
        return new ItemTransaction[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

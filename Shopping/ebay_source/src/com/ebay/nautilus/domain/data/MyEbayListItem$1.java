// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            MyEbayListItem

static final class 
    implements android.os.r
{

    public MyEbayListItem createFromParcel(Parcel parcel)
    {
        return new MyEbayListItem(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public MyEbayListItem[] newArray(int i)
    {
        return new MyEbayListItem[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

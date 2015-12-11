// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.os.Parcel;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            ListingDraftListItem

static final class 
    implements android.os.DraftListItem._cls1
{

    public ListingDraftListItem createFromParcel(Parcel parcel)
    {
        return new ListingDraftListItem(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ListingDraftListItem[] newArray(int i)
    {
        return new ListingDraftListItem[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

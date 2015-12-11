// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;

// Referenced classes of package com.groupon.models.gdt:
//            GdtUserOrdersItemDetails

private static class <init>
    implements android.os.ItemCreator
{

    public GdtUserOrdersItemDetails createFromParcel(Parcel parcel)
    {
        return new GdtUserOrdersItemDetails(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public GdtUserOrdersItemDetails[] newArray(int i)
    {
        return new GdtUserOrdersItemDetails[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

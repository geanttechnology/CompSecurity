// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;

// Referenced classes of package com.groupon.models.gdt:
//            GdtUserOrdersData

private static class <init>
    implements android.os.DataCreator
{

    public GdtUserOrdersData createFromParcel(Parcel parcel)
    {
        return new GdtUserOrdersData(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public GdtUserOrdersData[] newArray(int i)
    {
        return new GdtUserOrdersData[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;

// Referenced classes of package com.groupon.models.gdt:
//            GdtMerchantData

private static class <init>
    implements android.os.DataCreator
{

    public GdtMerchantData createFromParcel(Parcel parcel)
    {
        return new GdtMerchantData(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public GdtMerchantData[] newArray(int i)
    {
        return new GdtMerchantData[i];
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

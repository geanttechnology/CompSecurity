// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.params:
//            ProductSummaryParam

static final class 
    implements android.os.ms.ProductSummaryParam._cls1
{

    public ProductSummaryParam a(Parcel parcel)
    {
        return new ProductSummaryParam(parcel, null);
    }

    public ProductSummaryParam[] a(int i)
    {
        return new ProductSummaryParam[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.shop;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.shop:
//            ShopOverrides

static final class 
    implements android.os.or
{

    public ShopOverrides a(Parcel parcel)
    {
        return new ShopOverrides(parcel, null);
    }

    public ShopOverrides[] a(int i)
    {
        return new ShopOverrides[i];
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

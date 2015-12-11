// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.product:
//            ProductVariationModel

static final class _cls9
    implements android.os.VariationModel._cls1
{

    public ProductVariationModel a(Parcel parcel)
    {
        return new ProductVariationModel(parcel, null);
    }

    public ProductVariationModel[] a(int i)
    {
        return new ProductVariationModel[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    _cls9()
    {
    }
}

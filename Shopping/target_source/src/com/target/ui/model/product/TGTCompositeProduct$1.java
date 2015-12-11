// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.product:
//            TGTCompositeProduct

static final class 
    implements android.os.mpositeProduct._cls1
{

    public TGTCompositeProduct a(Parcel parcel)
    {
        return new TGTCompositeProduct(parcel, null);
    }

    public TGTCompositeProduct[] a(int i)
    {
        return new TGTCompositeProduct[i];
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

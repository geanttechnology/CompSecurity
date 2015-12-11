// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductRgbValue

static final class 
    implements android.os.uct.handler.TGTProductRgbValue._cls1
{

    public TGTProductRgbValue a(Parcel parcel)
    {
        return new TGTProductRgbValue(parcel, null);
    }

    public TGTProductRgbValue[] a(int i)
    {
        return new TGTProductRgbValue[i];
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

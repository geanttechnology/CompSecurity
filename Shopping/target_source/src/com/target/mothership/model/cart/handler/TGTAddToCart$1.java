// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAddToCart

static final class 
    implements android.os.tor
{

    public TGTAddToCart a(Parcel parcel)
    {
        return new TGTAddToCart(parcel, null);
    }

    public TGTAddToCart[] a(int i)
    {
        return new TGTAddToCart[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTSaveForLaterProduct

static final class 
    implements android.os.dler.TGTSaveForLaterProduct._cls1
{

    public TGTSaveForLaterProduct a(Parcel parcel)
    {
        return new TGTSaveForLaterProduct(parcel);
    }

    public TGTSaveForLaterProduct[] a(int i)
    {
        return new TGTSaveForLaterProduct[i];
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

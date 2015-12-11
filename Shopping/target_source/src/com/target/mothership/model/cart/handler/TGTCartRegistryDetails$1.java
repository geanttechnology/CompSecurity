// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartRegistryDetails

static final class 
    implements android.os.dler.TGTCartRegistryDetails._cls1
{

    public TGTCartRegistryDetails a(Parcel parcel)
    {
        return new TGTCartRegistryDetails(parcel, null);
    }

    public TGTCartRegistryDetails[] a(int i)
    {
        return new TGTCartRegistryDetails[i];
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

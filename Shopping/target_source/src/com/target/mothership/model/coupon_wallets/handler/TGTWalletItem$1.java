// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.coupon_wallets.handler:
//            TGTWalletItem

static final class 
    implements android.os.or
{

    public TGTWalletItem a(Parcel parcel)
    {
        return new TGTWalletItem(parcel);
    }

    public TGTWalletItem[] a(int i)
    {
        return new TGTWalletItem[i];
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

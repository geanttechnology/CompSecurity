// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAppliedPromoCodes

static final class 
    implements android.os.andler.TGTAppliedPromoCodes._cls1
{

    public TGTAppliedPromoCodes a(Parcel parcel)
    {
        return new TGTAppliedPromoCodes(parcel, null);
    }

    public TGTAppliedPromoCodes[] a(int i)
    {
        return new TGTAppliedPromoCodes[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            TGTPaymentCardDisplayDetails

static final class A
    implements android.os.dDisplayDetails._cls1
{

    public TGTPaymentCardDisplayDetails a(Parcel parcel)
    {
        return new TGTPaymentCardDisplayDetails(parcel, null);
    }

    public TGTPaymentCardDisplayDetails[] a(int i)
    {
        return new TGTPaymentCardDisplayDetails[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    A()
    {
    }
}

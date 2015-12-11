// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            TGTPayPalDisplayDetails

static final class 
    implements android.os.lDisplayDetails._cls1
{

    public TGTPayPalDisplayDetails a(Parcel parcel)
    {
        return new TGTPayPalDisplayDetails(parcel, null);
    }

    public TGTPayPalDisplayDetails[] a(int i)
    {
        return new TGTPayPalDisplayDetails[i];
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

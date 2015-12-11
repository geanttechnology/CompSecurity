// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            TGTBillingCardDetailsModel

static final class 
    implements android.os.ardDetailsModel._cls1
{

    public TGTBillingCardDetailsModel a(Parcel parcel)
    {
        return new TGTBillingCardDetailsModel(parcel, null);
    }

    public TGTBillingCardDetailsModel[] a(int i)
    {
        return new TGTBillingCardDetailsModel[i];
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

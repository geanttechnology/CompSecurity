// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.account;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.account:
//            TGTOrderPaymentCardDetailsModel

static final class 
    implements android.os.rdDetailsModel._cls1
{

    public TGTOrderPaymentCardDetailsModel a(Parcel parcel)
    {
        return new TGTOrderPaymentCardDetailsModel(parcel, null);
    }

    public TGTOrderPaymentCardDetailsModel[] a(int i)
    {
        return new TGTOrderPaymentCardDetailsModel[i];
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

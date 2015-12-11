// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            TGTPaymentCardInformationModel

static final class 
    implements android.os.nformationModel._cls1
{

    public TGTPaymentCardInformationModel a(Parcel parcel)
    {
        return new TGTPaymentCardInformationModel(parcel, null);
    }

    public TGTPaymentCardInformationModel[] a(int i)
    {
        return new TGTPaymentCardInformationModel[i];
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

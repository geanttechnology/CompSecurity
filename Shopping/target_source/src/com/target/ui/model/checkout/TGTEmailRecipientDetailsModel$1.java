// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            TGTEmailRecipientDetailsModel

static final class 
    implements android.os.entDetailsModel._cls1
{

    public TGTEmailRecipientDetailsModel a(Parcel parcel)
    {
        return new TGTEmailRecipientDetailsModel(parcel, null);
    }

    public TGTEmailRecipientDetailsModel[] a(int i)
    {
        return new TGTEmailRecipientDetailsModel[i];
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

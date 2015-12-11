// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTAppliedPaymentCard

static final class 
    implements android.os.andler.TGTAppliedPaymentCard._cls1
{

    public TGTAppliedPaymentCard a(Parcel parcel)
    {
        return new TGTAppliedPaymentCard(parcel, null);
    }

    public TGTAppliedPaymentCard[] a(int i)
    {
        return new TGTAppliedPaymentCard[i];
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

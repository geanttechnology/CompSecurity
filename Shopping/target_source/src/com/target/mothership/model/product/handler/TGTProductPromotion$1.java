// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductPromotion

static final class 
    implements android.os.ct.handler.TGTProductPromotion._cls1
{

    public TGTProductPromotion a(Parcel parcel)
    {
        return new TGTProductPromotion(parcel, null);
    }

    public TGTProductPromotion[] a(int i)
    {
        return new TGTProductPromotion[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStorePhoneNumber

static final class 
    implements android.os..handler.TGTStorePhoneNumber._cls1
{

    public TGTStorePhoneNumber a(Parcel parcel)
    {
        return new TGTStorePhoneNumber(parcel, null);
    }

    public TGTStorePhoneNumber[] a(int i)
    {
        return new TGTStorePhoneNumber[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStoreCapability

static final class 
    implements android.os.e.handler.TGTStoreCapability._cls1
{

    public TGTStoreCapability a(Parcel parcel)
    {
        return new TGTStoreCapability(parcel, null);
    }

    public TGTStoreCapability[] a(int i)
    {
        return new TGTStoreCapability[i];
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

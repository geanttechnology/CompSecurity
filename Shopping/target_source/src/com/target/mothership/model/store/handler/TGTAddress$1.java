// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTAddress

static final class 
    implements android.os.eator
{

    public TGTAddress a(Parcel parcel)
    {
        return new TGTAddress(parcel, null);
    }

    public TGTAddress[] a(int i)
    {
        return new TGTAddress[i];
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

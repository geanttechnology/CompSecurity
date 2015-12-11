// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStoreSummary

static final class A
    implements android.os.
{

    public TGTStoreSummary a(Parcel parcel)
    {
        return new TGTStoreSummary(parcel, null);
    }

    public TGTStoreSummary[] a(int i)
    {
        return new TGTStoreSummary[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    A()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            TGTCardSize

static final class A
    implements android.os.ator
{

    public TGTCardSize a(Parcel parcel)
    {
        return new TGTCardSize(parcel, null);
    }

    public TGTCardSize[] a(int i)
    {
        return new TGTCardSize[i];
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

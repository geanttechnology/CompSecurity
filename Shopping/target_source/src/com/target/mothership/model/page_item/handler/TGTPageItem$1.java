// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            TGTPageItem

static final class A
    implements android.os.ator
{

    public TGTPageItem a(Parcel parcel)
    {
        return new TGTPageItem(parcel, null);
    }

    public TGTPageItem[] a(int i)
    {
        return new TGTPageItem[i];
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

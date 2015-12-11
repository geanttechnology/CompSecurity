// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            TGTProductInfo

static final class 
    implements android.os.r
{

    public TGTProductInfo a(Parcel parcel)
    {
        return new TGTProductInfo(parcel, null);
    }

    public TGTProductInfo[] a(int i)
    {
        return new TGTProductInfo[i];
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

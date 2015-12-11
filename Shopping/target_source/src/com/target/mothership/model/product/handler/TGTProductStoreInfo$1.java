// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductStoreInfo

static final class 
    implements android.os.ct.handler.TGTProductStoreInfo._cls1
{

    public TGTProductStoreInfo a(Parcel parcel)
    {
        return new TGTProductStoreInfo(parcel, null);
    }

    public TGTProductStoreInfo[] a(int i)
    {
        return new TGTProductStoreInfo[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails

static final class 
    implements android.os.duct.handler.TGTProductDetails._cls1
{

    public TGTProductDetails a(Parcel parcel)
    {
        return new TGTProductDetails(parcel);
    }

    public TGTProductDetails[] a(int i)
    {
        return new TGTProductDetails[i];
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

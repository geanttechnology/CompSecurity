// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductSummary

static final class 
    implements android.os.duct.handler.TGTProductSummary._cls1
{

    public TGTProductSummary a(Parcel parcel)
    {
        return new TGTProductSummary(parcel, null);
    }

    public TGTProductSummary[] a(int i)
    {
        return new TGTProductSummary[i];
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

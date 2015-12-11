// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductCallout

static final class 
    implements android.os.duct.handler.TGTProductCallout._cls1
{

    public TGTProductCallout a(Parcel parcel)
    {
        return new TGTProductCallout(parcel, null);
    }

    public TGTProductCallout[] a(int i)
    {
        return new TGTProductCallout[i];
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

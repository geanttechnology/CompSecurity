// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.product:
//            Dpci

static final class 
    implements android.os.ble.Creator
{

    public Dpci a(Parcel parcel)
    {
        return new Dpci(parcel);
    }

    public Dpci[] a(int i)
    {
        return new Dpci[i];
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

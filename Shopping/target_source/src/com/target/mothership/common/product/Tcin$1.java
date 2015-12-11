// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.product:
//            Tcin

static final class 
    implements android.os.ble.Creator
{

    public Tcin a(Parcel parcel)
    {
        return new Tcin(parcel);
    }

    public Tcin[] a(int i)
    {
        return new Tcin[i];
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

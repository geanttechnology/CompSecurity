// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTPersonName

static final class 
    implements android.os.or
{

    public TGTPersonName a(Parcel parcel)
    {
        return new TGTPersonName(parcel, null);
    }

    public TGTPersonName[] a(int i)
    {
        return new TGTPersonName[i];
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

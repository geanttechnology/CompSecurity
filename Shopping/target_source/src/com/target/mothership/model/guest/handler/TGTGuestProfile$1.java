// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTGuestProfile

static final class A
    implements android.os.
{

    public TGTGuestProfile a(Parcel parcel)
    {
        return new TGTGuestProfile(parcel, null);
    }

    public TGTGuestProfile[] a(int i)
    {
        return new TGTGuestProfile[i];
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

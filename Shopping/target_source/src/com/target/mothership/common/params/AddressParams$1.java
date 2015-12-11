// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.params:
//            AddressParams

static final class _cls9
    implements android.os.or
{

    public AddressParams a(Parcel parcel)
    {
        return new AddressParams(parcel, null);
    }

    public AddressParams[] a(int i)
    {
        return new AddressParams[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    _cls9()
    {
    }
}

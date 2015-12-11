// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;

// Referenced classes of package com.amazon.dcp.ota:
//            NetworkType

static final class 
    implements android.os.ator
{

    public NetworkType createFromParcel(Parcel parcel)
    {
        return NetworkType.fromValue(parcel.readInt());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public NetworkType[] newArray(int i)
    {
        return new NetworkType[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

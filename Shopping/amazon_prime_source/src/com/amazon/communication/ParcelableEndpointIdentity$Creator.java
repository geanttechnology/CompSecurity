// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.identity.EndpointIdentityFactory;
import android.os.Parcel;

// Referenced classes of package com.amazon.communication:
//            ParcelableEndpointIdentity

static class A
    implements android.os.ntity.Creator
{

    public ParcelableEndpointIdentity createFromParcel(Parcel parcel)
    {
        return new ParcelableEndpointIdentity(EndpointIdentityFactory.createFromUrn(parcel.readString()));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ParcelableEndpointIdentity[] newArray(int i)
    {
        return new ParcelableEndpointIdentity[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    A()
    {
    }
}

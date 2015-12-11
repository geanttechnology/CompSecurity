// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;

import android.os.Parcel;

// Referenced classes of package com.amazon.communication.ir:
//            ParcelableIRServiceEndpoint, IRServiceEndpointImpl

static class ion
    implements android.os.Endpoint.Creator
{

    public ParcelableIRServiceEndpoint createFromParcel(Parcel parcel)
    {
        Integer integer = null;
        String s = parcel.readString();
        String s1 = parcel.readString();
        amazon.communication.identity.n n = amazon.communication.identity.arse(parcel.readString());
        amazon.communication.identity.n n1 = amazon.communication.identity.rse(parcel.readString());
        amazon.communication.identity.n n2 = amazon.communication.identity.n.parse(parcel.readString());
        int i = parcel.readInt();
        int j = parcel.readInt();
        int k = parcel.readInt();
        String s2 = parcel.readString();
        if (j == -1)
        {
            parcel = null;
        } else
        {
            parcel = Integer.valueOf(j);
        }
        if (k != -1)
        {
            integer = Integer.valueOf(k);
        }
        return new ParcelableIRServiceEndpoint(new IRServiceEndpointImpl(s, s1, s2, n, n1, n2, i, parcel, integer));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ParcelableIRServiceEndpoint[] newArray(int i)
    {
        return new ParcelableIRServiceEndpoint[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ion()
    {
    }
}

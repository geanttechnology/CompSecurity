// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.messaging;

import android.os.Parcel;

// Referenced classes of package com.amazon.dcp.messaging:
//            OdotTransport

static final class 
    implements android.os.or
{

    public OdotTransport createFromParcel(Parcel parcel)
    {
        return OdotTransport.fromValue(parcel.readInt());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public OdotTransport[] newArray(int i)
    {
        return new OdotTransport[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

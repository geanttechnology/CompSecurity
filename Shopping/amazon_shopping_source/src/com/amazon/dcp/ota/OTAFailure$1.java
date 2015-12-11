// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;

// Referenced classes of package com.amazon.dcp.ota:
//            OTAFailure

static final class 
    implements android.os.eator
{

    public OTAFailure createFromParcel(Parcel parcel)
    {
        return OTAFailure.fromValue(parcel.readInt());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public OTAFailure[] newArray(int i)
    {
        return new OTAFailure[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

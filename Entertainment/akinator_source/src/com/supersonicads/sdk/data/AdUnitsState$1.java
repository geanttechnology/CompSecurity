// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;

import android.os.Parcel;

// Referenced classes of package com.supersonicads.sdk.data:
//            AdUnitsState

static final class 
    implements android.os.tor
{

    public AdUnitsState createFromParcel(Parcel parcel)
    {
        return new AdUnitsState(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public AdUnitsState[] newArray(int i)
    {
        return new AdUnitsState[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

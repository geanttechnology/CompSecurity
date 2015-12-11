// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Parcel;

// Referenced classes of package com.amazon.communication:
//            ParcelableStatus

static class 
    implements android.os.tatus.Creator
{

    public ParcelableStatus createFromParcel(Parcel parcel)
    {
        return new ParcelableStatus(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ParcelableStatus[] newArray(int i)
    {
        return new ParcelableStatus[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

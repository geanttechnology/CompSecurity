// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Parcel;

// Referenced classes of package com.amazon.dcp.sso:
//            ParcelableAccount

static final class 
    implements android.os.count._cls1
{

    public ParcelableAccount createFromParcel(Parcel parcel)
    {
        return new ParcelableAccount(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ParcelableAccount[] newArray(int i)
    {
        return new ParcelableAccount[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

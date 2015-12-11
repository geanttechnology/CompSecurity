// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain:
//            EbayCurrency

static final class 
    implements android.os.tor
{

    public EbayCurrency createFromParcel(Parcel parcel)
    {
        return EbayCurrency.getInstance(parcel.readString());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public EbayCurrency[] newArray(int i)
    {
        return new EbayCurrency[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

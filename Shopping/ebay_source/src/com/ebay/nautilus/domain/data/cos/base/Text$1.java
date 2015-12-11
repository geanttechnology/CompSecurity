// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data.cos.base:
//            Text

static final class 
    implements android.os.ble.Creator
{

    public Text createFromParcel(Parcel parcel)
    {
        return new Text(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public Text[] newArray(int i)
    {
        return new Text[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

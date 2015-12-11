// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Parcel;

// Referenced classes of package com.ebay.common:
//            ParcelableStringPair

static final class 
    implements android.os.ir._cls1
{

    public ParcelableStringPair createFromParcel(Parcel parcel)
    {
        return new ParcelableStringPair(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ParcelableStringPair[] newArray(int i)
    {
        return new ParcelableStringPair[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

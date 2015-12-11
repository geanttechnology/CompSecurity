// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemWeight

static final class 
    implements android.os.eator
{

    public ItemWeight createFromParcel(Parcel parcel)
    {
        return new ItemWeight(parcel.readString(), parcel.readFloat());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ItemWeight[] newArray(int i)
    {
        return new ItemWeight[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            OutputSelector

static final class 
    implements android.os.r
{

    public OutputSelector createFromParcel(Parcel parcel)
    {
        return new OutputSelector(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public OutputSelector[] newArray(int i)
    {
        return new OutputSelector[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.os.Parcel;

// Referenced classes of package com.digimarc.dms.resolver:
//            StandardPayoff, Payoff

static final class 
    implements android.os.r
{

    public final StandardPayoff createFromParcel(Parcel parcel)
    {
        return new StandardPayoff(new Payoff(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final StandardPayoff[] newArray(int i)
    {
        return null;
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

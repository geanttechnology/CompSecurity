// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            OfferUpBoolean

final class 
    implements android.os.r
{

    public final OfferUpBoolean createFromParcel(Parcel parcel)
    {
        boolean flag = true;
        OfferUpBoolean offerupboolean = new OfferUpBoolean();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        offerupboolean.value = flag;
        return offerupboolean;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final OfferUpBoolean[] newArray(int i)
    {
        return new OfferUpBoolean[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

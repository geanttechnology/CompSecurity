// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import android.os.Parcel;
import com.offerup.android.dto.OfferUpBoolean;

// Referenced classes of package com.offerup.android.dto.response:
//            ItemActions

final class 
    implements android.os.ator
{

    public final ItemActions createFromParcel(Parcel parcel)
    {
        ItemActions.access$002(new ItemActions(), (new OfferUpBoolean(parcel.readInt())).value);
        return null;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final ItemActions[] newArray(int i)
    {
        return new ItemActions[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

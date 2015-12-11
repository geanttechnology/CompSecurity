// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.OfferResponse;

// Referenced classes of package com.offerup.android.activities:
//            ai, BuyActivity

final class aj
{

    private OfferResponse a;
    private ai b;

    private aj(BuyActivity buyactivity, OfferResponse offerresponse, ai ai)
    {
        a = offerresponse;
        b = ai;
    }

    aj(BuyActivity buyactivity, OfferResponse offerresponse, ai ai, byte byte0)
    {
        this(buyactivity, offerresponse, ai);
    }

    static OfferResponse a(aj aj1)
    {
        return aj1.a;
    }

    static ai b(aj aj1)
    {
        return aj1.b;
    }
}

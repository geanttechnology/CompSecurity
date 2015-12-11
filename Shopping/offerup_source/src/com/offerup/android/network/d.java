// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.b.a.a.g;
import com.offerup.android.dto.OfferResponse;
import java.util.concurrent.Executors;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.network:
//            o, OfferService

public class d
{

    public d()
    {
    }

    public static OfferResponse a(long l, double d1)
    {
        Object obj = com.offerup.android.network.o.g(o.a(Executors.newSingleThreadExecutor()));
        obj = ((OfferService) (obj)).makeOffer(l, d1);
        return ((OfferResponse) (obj));
        RetrofitError retrofiterror;
        retrofiterror;
        g.a(com/offerup/android/network/d, retrofiterror);
        if (retrofiterror.getResponse() == null) goto _L2; else goto _L1
_L1:
        retrofiterror.getResponse().getStatus();
        JVM INSTR lookupswitch 5: default 100
    //                   402: 102
    //                   409: 102
    //                   418: 102
    //                   422: 102
    //                   423: 102;
           goto _L2 _L3 _L3 _L3 _L3 _L3
_L2:
        return null;
_L3:
        OfferResponse offerresponse = new OfferResponse();
        offerresponse.setAuthenticationError(true);
        return offerresponse;
    }
}

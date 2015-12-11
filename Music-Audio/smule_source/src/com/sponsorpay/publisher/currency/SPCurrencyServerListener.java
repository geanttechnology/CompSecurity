// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.currency;


// Referenced classes of package com.sponsorpay.publisher.currency:
//            SPCurrencyServerSuccesfulResponse, SPCurrencyServerErrorResponse

public interface SPCurrencyServerListener
{

    public abstract void onSPCurrencyDeltaReceived(SPCurrencyServerSuccesfulResponse spcurrencyserversuccesfulresponse);

    public abstract void onSPCurrencyServerError(SPCurrencyServerErrorResponse spcurrencyservererrorresponse);
}

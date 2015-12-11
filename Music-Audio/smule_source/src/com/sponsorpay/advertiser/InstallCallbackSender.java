// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.advertiser;

import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import java.util.Map;

// Referenced classes of package com.sponsorpay.advertiser:
//            AbstractCallbackSender, SponsorPayAdvertiserState

public class InstallCallbackSender extends AbstractCallbackSender
{

    private static final String INSTALLS_URL_KEY = "installs";

    public InstallCallbackSender(SPCredentials spcredentials, SponsorPayAdvertiserState sponsorpayadvertiserstate)
    {
        super(spcredentials, sponsorpayadvertiserstate);
    }

    protected String getAnswerReceived()
    {
        return mState.getCallbackReceivedSuccessfulResponse(null);
    }

    protected String getBaseUrl()
    {
        return SponsorPayBaseUrlProvider.getBaseUrl("installs");
    }

    protected Map getParams()
    {
        return null;
    }

    protected void processRequest(Boolean boolean1)
    {
        mState.setCallbackReceivedSuccessfulResponse(null, true);
    }
}

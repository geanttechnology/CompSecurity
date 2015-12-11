// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.advertiser;

import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.advertiser:
//            AbstractCallbackSender, SponsorPayAdvertiserState

public class ActionCallbackSender extends AbstractCallbackSender
{

    private static final String ACTIONS_URL_KEY = "actions";
    private static final String ACTION_ID_KEY = "action_id";
    protected String mActionId;

    public ActionCallbackSender(String s, SPCredentials spcredentials, SponsorPayAdvertiserState sponsorpayadvertiserstate)
    {
        super(spcredentials, sponsorpayadvertiserstate);
        mActionId = s;
    }

    protected String getAnswerReceived()
    {
        return mState.getCallbackReceivedSuccessfulResponse(mActionId);
    }

    protected String getBaseUrl()
    {
        return SponsorPayBaseUrlProvider.getBaseUrl("actions");
    }

    protected Map getParams()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("action_id", mActionId);
        return hashmap;
    }

    protected void processRequest(Boolean boolean1)
    {
        mState.setCallbackReceivedSuccessfulResponse(mActionId, true);
    }
}

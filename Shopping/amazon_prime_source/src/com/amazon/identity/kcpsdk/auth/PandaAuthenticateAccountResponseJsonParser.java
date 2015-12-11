// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaResponseJsonParser, AuthenticationChallenge, PandaAuthenticateAccountResponse, AuthenticateAccountError, 
//            PandaError

public class PandaAuthenticateAccountResponseJsonParser extends PandaResponseJsonParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseJsonParser.getName();

    public PandaAuthenticateAccountResponseJsonParser()
    {
    }

    protected PandaAuthenticateAccountResponse handlePandaChallengeResponse(AuthenticationChallenge authenticationchallenge)
        throws JSONException
    {
        MAPLog.i(TAG, " handling panda challenge response.");
        String s = authenticationchallenge.getReason();
        if ("AuthenticationFailed".equals(s) || "InvalidAuthenticationData".equals(s))
        {
            return new PandaAuthenticateAccountResponse(AuthenticateAccountError.AuthenticateAccountErrorCredentialError, authenticationchallenge);
        } else
        {
            return new PandaAuthenticateAccountResponse(authenticationchallenge);
        }
    }

    protected volatile Object handlePandaChallengeResponse(AuthenticationChallenge authenticationchallenge)
        throws JSONException
    {
        return handlePandaChallengeResponse(authenticationchallenge);
    }

    protected PandaAuthenticateAccountResponse handlePandaErrorCode(PandaError pandaerror)
    {
        return new PandaAuthenticateAccountResponse(pandaerror);
    }

    protected volatile Object handlePandaErrorCode(PandaError pandaerror)
    {
        return handlePandaErrorCode(pandaerror);
    }

    protected PandaAuthenticateAccountResponse parsePandaSuccessResponse(JSONObject jsonobject)
        throws JSONException
    {
        String s = jsonobject.getJSONObject("tokens").getJSONObject("bearer").getString("access_token");
        return new PandaAuthenticateAccountResponse(jsonobject.getString("customer_id"), s);
    }

    protected volatile Object parsePandaSuccessResponse(JSONObject jsonobject)
        throws JSONException
    {
        return parsePandaSuccessResponse(jsonobject);
    }

    protected PandaAuthenticateAccountResponse parseSpecificPandaErrorResponse(JSONObject jsonobject)
    {
        MAPLog.formattedInfo(TAG, " PandaAuthenticateResponseParser: response received an unknown error: %s", new Object[] {
            jsonobject.toString()
        });
        return new PandaAuthenticateAccountResponse(AuthenticateAccountError.AuthenticateAccountErrorUnknown);
    }

    protected volatile Object parseSpecificPandaErrorResponse(JSONObject jsonobject)
        throws JSONException
    {
        return parseSpecificPandaErrorResponse(jsonobject);
    }

}

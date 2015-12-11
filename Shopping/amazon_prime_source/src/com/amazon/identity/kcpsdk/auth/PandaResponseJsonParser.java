// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaError, AuthenticationChallenge

public abstract class PandaResponseJsonParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/PandaResponseJsonParser.getName();

    public PandaResponseJsonParser()
    {
    }

    protected abstract Object handlePandaChallengeResponse(AuthenticationChallenge authenticationchallenge)
        throws JSONException;

    protected abstract Object handlePandaErrorCode(PandaError pandaerror);

    public Object parse(JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        jsonobject1 = jsonobject.getJSONObject("response");
        if (jsonobject1.has("success"))
        {
            return parsePandaSuccessResponse(jsonobject1.getJSONObject("success"));
        }
        if (!jsonobject1.has("error")) goto _L2; else goto _L1
_L1:
        String s;
        jsonobject1 = jsonobject1.getJSONObject("error");
        s = jsonobject.getString("request_id");
        jsonobject = jsonobject1.getString("code");
        if (!jsonobject.equals("MissingValue")) goto _L4; else goto _L3
_L3:
        jsonobject = PandaError.PandaErrorMissingValue;
_L8:
        if (jsonobject != null) goto _L6; else goto _L5
_L5:
        return parseSpecificPandaErrorResponse(jsonobject1);
_L4:
        if (jsonobject.equals("InvalidValue"))
        {
            jsonobject = PandaError.PandaErrorInvalidValue;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (jsonobject.equals("CredentialError"))
            {
                jsonobject = PandaError.PandaErrorCredentialError;
                continue; /* Loop/switch isn't completed */
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            MAPLog.e(TAG, " Panda Response is not correctly formatted.");
            return null;
        }
        if (jsonobject.equals("ServerError"))
        {
            jsonobject = PandaError.PandaErrorServerError;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("ServiceUnavailable"))
        {
            jsonobject = PandaError.PandaErrorServiceUnavailable;
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = null;
        continue; /* Loop/switch isn't completed */
_L6:
        MAPLog.w(TAG, String.format("Panda Error:  %s. Request ID: %s", new Object[] {
            jsonobject1.toString(), s
        }));
        return handlePandaErrorCode(jsonobject);
_L2:
        if (jsonobject1.has("challenge"))
        {
            return handlePandaChallengeResponse(AuthenticationChallenge.fromPandaChallengeBody(jsonobject1.getJSONObject("challenge")));
        }
        MAPLog.e(TAG, " Panda Response is not correctly formatted.");
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected abstract Object parsePandaSuccessResponse(JSONObject jsonobject)
        throws JSONException;

    protected abstract Object parseSpecificPandaErrorResponse(JSONObject jsonobject)
        throws JSONException;

}

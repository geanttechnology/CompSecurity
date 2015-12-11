// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.currency;

import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SignedResponseRequester;
import com.sponsorpay.utils.SignedServerResponse;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.UrlBuilder;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.sponsorpay.publisher.currency:
//            SPCurrencyServerRequestErrorType, SPCurrencyServerErrorResponse, SPCurrencyServerSuccesfulResponse

public class SPCurrencyServerRequester extends SignedResponseRequester
{

    private static final String DELTA_OF_COINS_KEY = "delta_of_coins";
    private static final String ERROR_CODE_KEY = "code";
    private static final String ERROR_MESSAGE_KEY = "message";
    private static final String LATEST_TRANSACTION_ID_KEY = "latest_transaction_id";
    public static String TAG = "SPCurrencyServerRequester";
    private static final String URL_PARAM_KEY_LAST_TRANSACTION_ID = "ltid";
    private static final String VCS_URL_KEY = "vcs";
    private SPVCSResultListener mResultListener;
    private String mSecurityToken;

    private SPCurrencyServerRequester(SPVCSResultListener spvcsresultlistener, String s)
    {
        mResultListener = spvcsresultlistener;
        mSecurityToken = s;
    }

    private SPCurrencyServerReponse parseErrorResponse(String s)
    {
        Object obj;
        obj = new JSONObject(s);
        s = ((JSONObject) (obj)).getString("code");
        Object obj1;
        obj1 = ((JSONObject) (obj)).getString("message");
        obj = SPCurrencyServerRequestErrorType.SERVER_RETURNED_ERROR;
_L2:
        return new SPCurrencyServerErrorResponse(((SPCurrencyServerRequestErrorType) (obj)), s, ((String) (obj1)));
        Exception exception;
        exception;
        s = null;
_L3:
        SponsorPayLogger.w(TAG, "An exception was triggered while parsing error response", exception);
        obj1 = SPCurrencyServerRequestErrorType.ERROR_OTHER;
        String s1 = exception.getMessage();
        exception = ((Exception) (obj1));
        obj1 = s1;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
          goto _L3
    }

    private SPCurrencyServerReponse parseResponse(int i, String s, String s1)
    {
        s1 = new SignedServerResponse(i, s, s1);
        if (hasErrorStatusCode(i))
        {
            return parseErrorResponse(s);
        }
        if (!verifySignature(s1, mSecurityToken))
        {
            return new SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType.ERROR_INVALID_RESPONSE_SIGNATURE, null, "The signature received in the request did not match the expected one");
        } else
        {
            return parseSuccessfulResponse(s);
        }
    }

    private SPCurrencyServerReponse parseSuccessfulResponse(String s)
    {
        try
        {
            s = new JSONObject(s);
            s = new SPCurrencyServerSuccesfulResponse(s.getDouble("delta_of_coins"), s.getString("latest_transaction_id"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType.ERROR_INVALID_RESPONSE, null, s.getMessage());
        }
        return s;
    }

    public static void requestCurrency(SPVCSResultListener spvcsresultlistener, SPCredentials spcredentials, String s, Map map)
    {
        s = UrlBuilder.newBuilder(SponsorPayBaseUrlProvider.getBaseUrl("vcs"), spcredentials).addKeyValue("ltid", s).addExtraKeysValues(map).addScreenMetrics().addSignature();
        (new SPCurrencyServerRequester(spvcsresultlistener, spcredentials.getSecurityToken())).execute(new UrlBuilder[] {
            s
        });
    }

    protected String getTag()
    {
        return TAG;
    }

    protected SPCurrencyServerReponse noConnectionResponse(Throwable throwable)
    {
        return new SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType.ERROR_NO_INTERNET_CONNECTION, null, throwable.getMessage());
    }

    protected volatile Object noConnectionResponse(Throwable throwable)
    {
        return noConnectionResponse(throwable);
    }

    protected void onPostExecute(SPCurrencyServerReponse spcurrencyserverreponse)
    {
        mResultListener.onSPCurrencyServerResponseReceived(spcurrencyserverreponse);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((SPCurrencyServerReponse)obj);
    }

    protected SPCurrencyServerReponse parsedSignedResponse(SignedServerResponse signedserverresponse)
    {
        SPCurrencyServerReponse spcurrencyserverreponse = null;
        if (signedserverresponse != null)
        {
            spcurrencyserverreponse = parseResponse(signedserverresponse.getStatusCode(), signedserverresponse.getResponseBody(), signedserverresponse.getResponseSignature());
        }
        signedserverresponse = spcurrencyserverreponse;
        if (spcurrencyserverreponse == null)
        {
            signedserverresponse = new SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType.ERROR_OTHER, "", "Unknow error");
        }
        return signedserverresponse;
    }

    protected volatile Object parsedSignedResponse(SignedServerResponse signedserverresponse)
    {
        return parsedSignedResponse(signedserverresponse);
    }


    private class SPVCSResultListener
    {

        public abstract void onSPCurrencyServerResponseReceived(SPCurrencyServerReponse spcurrencyserverreponse);
    }


    private class SPCurrencyServerReponse
    {
    }

}

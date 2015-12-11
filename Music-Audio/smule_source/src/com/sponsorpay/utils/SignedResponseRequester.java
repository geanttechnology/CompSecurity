// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.os.AsyncTask;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.sponsorpay.utils:
//            UrlBuilder, SponsorPayLogger, SPHttpConnection, SignedServerResponse, 
//            StringUtils, SignatureTools

public abstract class SignedResponseRequester extends AsyncTask
{

    private static String ACCEPT_LANGUAGE_HEADER_NAME = "Accept-Language";
    private static final String SIGNATURE_HEADER = "X-Sponsorpay-Response-Signature";
    public static String TAG = "SignedResponseRequester";
    private static String USER_AGENT_HEADER_NAME = "User-Agent";
    private static String USER_AGENT_HEADER_VALUE = "Android";

    public SignedResponseRequester()
    {
    }

    protected transient Object doInBackground(UrlBuilder aurlbuilder[])
    {
        Thread.currentThread().setName(getTag());
        aurlbuilder = aurlbuilder[0].buildUrl();
        SponsorPayLogger.d(TAG, (new StringBuilder("Request will be sent to URL + params: ")).append(aurlbuilder).toString());
        String s;
        int i;
        try
        {
            aurlbuilder = SPHttpConnection.getConnection(aurlbuilder).addHeader(USER_AGENT_HEADER_NAME, USER_AGENT_HEADER_VALUE).addHeader(ACCEPT_LANGUAGE_HEADER_NAME, makeAcceptLanguageHeaderValue()).open();
            i = aurlbuilder.getResponseCode();
            s = aurlbuilder.getBodyContent();
            aurlbuilder = aurlbuilder.getHeader("X-Sponsorpay-Response-Signature");
        }
        // Misplaced declaration of an exception variable
        catch (UrlBuilder aurlbuilder[])
        {
            SponsorPayLogger.e(TAG, (new StringBuilder("Exception triggered when executing request: ")).append(aurlbuilder).toString());
            return noConnectionResponse(aurlbuilder);
        }
        if (aurlbuilder == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        if (aurlbuilder.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        aurlbuilder = (String)aurlbuilder.get(0);
_L1:
        SponsorPayLogger.d(TAG, String.format("Server Response, status code: %d, response body: %s, signature: %s", new Object[] {
            Integer.valueOf(i), s, aurlbuilder
        }));
        aurlbuilder = new SignedServerResponse(i, s, aurlbuilder);
        return parsedSignedResponse(aurlbuilder);
        aurlbuilder = "";
          goto _L1
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((UrlBuilder[])aobj);
    }

    protected abstract String getTag();

    protected boolean hasErrorStatusCode(int i)
    {
        return i < 200 || i > 299;
    }

    protected String makeAcceptLanguageHeaderValue()
    {
        String s = Locale.getDefault().getLanguage();
        String s1 = Locale.ENGLISH.getLanguage();
        if (StringUtils.nullOrEmpty(s))
        {
            return s1;
        }
        if (!s1.equals(s))
        {
            return (new StringBuilder(String.valueOf(s))).append(String.format(", %s;q=0.8", new Object[] {
                s1
            })).toString();
        } else
        {
            return s;
        }
    }

    protected abstract Object noConnectionResponse(Throwable throwable);

    protected abstract Object parsedSignedResponse(SignedServerResponse signedserverresponse);

    protected boolean verifySignature(SignedServerResponse signedserverresponse, String s)
    {
        return SignatureTools.generateSignatureForString(signedserverresponse.getResponseBody(), s).equals(signedserverresponse.getResponseSignature());
    }

}

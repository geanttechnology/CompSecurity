// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.AuthPortalExchangeTokenHelper;
import com.amazon.identity.auth.device.utils.AuthPortalHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            ExchangeTokenRequestHelperDefinition

public class AuthPortalOAuthExchangeRequestHelper
    implements ExchangeTokenRequestHelperDefinition
{

    private static final String TAG = com/amazon/identity/auth/device/token/AuthPortalOAuthExchangeRequestHelper.getName();
    private final AuthPortalExchangeTokenHelper mAuthPortalExchangeTokenHelper = new AuthPortalExchangeTokenHelper();
    private final AuthPortalHelper mAuthPortalHelper;
    private final ServiceWrappingContext mContext;

    public AuthPortalOAuthExchangeRequestHelper(ServiceWrappingContext servicewrappingcontext, AuthPortalHelper authportalhelper)
    {
        mContext = servicewrappingcontext;
        mAuthPortalHelper = authportalhelper;
    }

    public boolean isFailure(int i)
    {
        return mAuthPortalHelper.isFailure(i);
    }

    public com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError parseExchangeTokenFailure(JSONObject jsonobject)
    {
        return (new AuthEndpointErrorParser()).parse(jsonobject);
    }

    public OAuthTokenManager.ExchangeTokenResponse parseExchangeTokenSuccess(JSONObject jsonobject)
        throws JSONException, ParseException
    {
        return mAuthPortalExchangeTokenHelper.handleExchangeTokenSuccess(jsonobject);
    }

    public HttpURLConnection startExchangeTokenRequest(String s, String s1, String s2, Tracer tracer)
        throws IOException, JSONException
    {
        URL url = mAuthPortalExchangeTokenHelper.getExchangeTokenURL(mContext, s1);
        MAPLog.i(TAG, (new StringBuilder("Refreshing Normal OAuth token with exchange token endpoint ")).append(url.toString()).append(" due to ").append(tracer.getPackageToBlame(mContext)).toString());
        ArrayList arraylist = new ArrayList();
        mAuthPortalExchangeTokenHelper.addAppParams(mContext, arraylist);
        arraylist.add(new BasicNameValuePair("source_token_type", "refresh_token"));
        arraylist.add(new BasicNameValuePair("source_token", s));
        arraylist.add(new BasicNameValuePair("requested_token_type", "access_token"));
        s = new UrlEncodedFormEntity(arraylist, "UTF-8");
        return mAuthPortalHelper.startIdentityRequestURLEncoded(mContext, url, s, false, null, s1, s2, tracer);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.AuthPortalHelper;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            ExchangeTokenRequestHelperDefinition

public class PandaOAuthExchangeRequestHelper
    implements ExchangeTokenRequestHelperDefinition
{

    private static final String TAG = com/amazon/identity/auth/device/token/PandaOAuthExchangeRequestHelper.getName();
    private final AuthPortalHelper mAuthPortalHelper;
    private final ServiceWrappingContext mContext;
    private final SSODeviceInfo mDeviceInfo;

    public PandaOAuthExchangeRequestHelper(ServiceWrappingContext servicewrappingcontext, AuthPortalHelper authportalhelper)
    {
        mContext = servicewrappingcontext;
        mAuthPortalHelper = authportalhelper;
        mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
    }

    private URL getExchangeTokenURL(String s)
    {
        s = AmazonDomainHelper.getAuthDomainForDirectedId(mContext, s);
        try
        {
            s = new URL("https", EnvironmentUtils.getInstance().getPandaHost(s), 443, "/auth/token");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Should never occur, hardcoded constant.", s);
        }
        return s;
    }

    public boolean isFailure(int i)
    {
        return mAuthPortalHelper.isFailure(i);
    }

    public com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError parseExchangeTokenFailure(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            jsonobject = TAG;
            return null;
        }
        try
        {
            String s = jsonobject.getString("error_description");
            jsonobject = new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.getAuthErrorTypeFromCode(jsonobject.getString("error")), s, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject = TAG;
            return new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, "Unable to parse response JSON.", null, null);
        }
        return jsonobject;
    }

    public OAuthTokenManager.ExchangeTokenResponse parseExchangeTokenSuccess(JSONObject jsonobject)
        throws JSONException, ParseException
    {
        if (jsonobject == null)
        {
            throw new ParseException("Null response", 0);
        }
        int i = jsonobject.getInt("expires_in");
        String s = jsonobject.getString("token_type");
        jsonobject = jsonobject.getString("access_token");
        if (!"bearer".equals(s))
        {
            throw new ParseException("Unexpected token type.", 0);
        }
        if (jsonobject == null)
        {
            throw new ParseException("Incomplete response.", 0);
        } else
        {
            return new OAuthTokenManager.ExchangeTokenResponse(jsonobject, i);
        }
    }

    public HttpURLConnection startExchangeTokenRequest(String s, String s1, String s2, Tracer tracer)
        throws IOException, JSONException
    {
        URL url = getExchangeTokenURL(s1);
        MAPLog.i(TAG, (new StringBuilder("Refreshing Normal OAuth token with exchange token endpoint ")).append(url.toString()).append(" due to ").append(tracer.getPackageToBlame(mContext)).toString());
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("app_name", mContext.getPackageName());
        jsonobject.put("app_version", BuildInfo.getMAPSWVersion());
        jsonobject.put("source_token_type", "refresh_token");
        jsonobject.put("source_token", s);
        jsonobject.put("requested_token_type", "access_token");
        jsonobject.put("device_metadata", DeviceMetadataCollector.getDeviceMetadataJSON(mContext, DeviceTypeHelpers.getDeviceTypeOfPackage(mContext, mContext.getPackageName()), mDeviceInfo.getAppDSN(), tracer));
        return mAuthPortalHelper.startIdentityRequestJSON$2cf2a247(mContext, url, jsonobject, s1, s2, tracer);
    }

}

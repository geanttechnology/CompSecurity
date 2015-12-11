// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.framework.security.EnhancedURLConnectionFactory;
import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.auth.AmazonJwtSigner;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;
import com.amazon.identity.kcpsdk.auth.PandaAuthenticateAccountRequest;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthenticateAccountAction
{
    public static class AuthenticatedAccountInfo
    {

        public final String accessToken;
        public final AuthenticationChallenge challenge;
        public final String directedId;
        public final com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError error;

        public boolean isError()
        {
            return error != null;
        }

        public AuthenticatedAccountInfo(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror)
        {
            this(null, null, null, authendpointerror);
        }

        public AuthenticatedAccountInfo(AuthenticationChallenge authenticationchallenge, com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror)
        {
            this(null, null, authenticationchallenge, authendpointerror);
        }

        public AuthenticatedAccountInfo(String s, String s1)
        {
            this(s, s1, null, null);
        }

        private AuthenticatedAccountInfo(String s, String s1, AuthenticationChallenge authenticationchallenge, com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror)
        {
            accessToken = s;
            directedId = s1;
            challenge = authenticationchallenge;
            error = authendpointerror;
        }
    }


    private static final AuthenticatedAccountInfo GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO;
    private static final String TAG = com/amazon/identity/auth/accounts/AuthenticateAccountAction.getName();
    private final AuthEndpointErrorParser mAuthEndpointErrorParser;
    private final Context mContext;
    private final SSODeviceInfo mDeviceInfo;

    AuthenticateAccountAction(Context context)
    {
        this(((Context) (ServiceWrappingContext.create(context))), new AuthEndpointErrorParser());
    }

    private AuthenticateAccountAction(Context context, AuthEndpointErrorParser authendpointerrorparser)
    {
        this(context, authendpointerrorparser, (SSODeviceInfo)context.getSystemService("dcp_device_info"));
    }

    AuthenticateAccountAction(Context context, AuthEndpointErrorParser authendpointerrorparser, SSODeviceInfo ssodeviceinfo)
    {
        mContext = context;
        mAuthEndpointErrorParser = authendpointerrorparser;
        mDeviceInfo = ssodeviceinfo;
    }

    public AuthenticatedAccountInfo authenticateAccount(String s, String s1, String s2, Bundle bundle, Tracer tracer)
    {
        HttpsURLConnection httpsurlconnection;
        HttpsURLConnection httpsurlconnection1;
        HttpsURLConnection httpsurlconnection2;
        HttpsURLConnection httpsurlconnection3;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        httpsurlconnection3 = null;
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = obj;
        httpsurlconnection = obj1;
        URL url = getSignInUrl(s2);
        if (url == null)
        {
            return null;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = obj;
        httpsurlconnection = obj1;
        MAPLog.i(TAG, (new StringBuilder("Starting request to authenticate account. URL : ")).append(url.toString()).toString());
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = obj;
        httpsurlconnection = obj1;
        httpsurlconnection3 = createURLConnection(url);
        if (httpsurlconnection3 != null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        MAPLog.e(TAG, "Could not create request to authenticate account");
        if (httpsurlconnection3 != null)
        {
            httpsurlconnection3.disconnect();
        }
        return null;
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (!EnvironmentUtils.isCurrentEnvironmentDevo())
        {
            break MISSING_BLOCK_LABEL_174;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        httpsurlconnection3.setRequestProperty("x-forwarded-server", EnvironmentUtils.getInstance().getPandaHost(s2));
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        httpsurlconnection3.setDoOutput(true);
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        httpsurlconnection3.setRequestMethod("POST");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        httpsurlconnection3.setRequestProperty("Accept", "application/json");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        httpsurlconnection3.setRequestProperty("Content-Type", "application/json");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2 = new PandaAuthenticateAccountRequest();
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2.setUserID(s);
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2.setPassword(s1);
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2.setDeviceInfo(mDeviceInfo);
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2.setJwtSigner(AmazonJwtSigner.getSigner(PlatformSettings.getInstance(mContext), mDeviceInfo, tracer));
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = bundle.getString("calling_package");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2.setMetadataAppName(s);
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = PackageUtils.getPackageVersion(mContext, s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2.setMetadataAppVersion(Integer.toString(s.intValue()));
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = s2.getRequestJSON();
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        StreamUtils.writeToStreamAndClose(httpsurlconnection3.getOutputStream(), s.toString().getBytes());
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        int i = httpsurlconnection3.getResponseCode();
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        MAPLog.i(TAG, (new StringBuilder("Panda SignIn Response code: ")).append(i).toString());
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = JSONHelpers.toJson(httpsurlconnection3);
        if (s != null) goto _L2; else goto _L1
_L1:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        MAPLog.e(TAG, "Error parsing JSON in Panda response");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, "Error parsing JSON in Panda response", null, null));
_L16:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (!s.isError()) goto _L4; else goto _L3
_L3:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        tracer.incrementCounter(MetricUtils.getUrlPathAndDomain(httpsurlconnection3.getURL(), i, ((AuthenticatedAccountInfo) (s)).error.getAuthTypeError().getCode()));
_L14:
        s1 = s;
        if (httpsurlconnection3 != null)
        {
            httpsurlconnection3.disconnect();
            return s;
        }
          goto _L5
_L2:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (!mAuthEndpointErrorParser.isFailure(i)) goto _L7; else goto _L6
_L6:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (mAuthEndpointErrorParser.hasAuthenticationChallenge(s)) goto _L7; else goto _L8
_L8:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = mAuthEndpointErrorParser.parse(s);
        if (s == null) goto _L10; else goto _L9
_L9:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        MAPLog.e(TAG, "Error making request. Code: %s \n Message: %s \n Detail: %s", new Object[] {
            s.getAuthTypeError().getCode(), s.getMessage(), s.getDetail()
        });
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = new AuthenticatedAccountInfo(s);
        continue; /* Loop/switch isn't completed */
        s;
        httpsurlconnection = httpsurlconnection2;
        s = String.format(Locale.US, "Error parsing response. Not of an expected format. Error: %s", new Object[] {
            s.getMessage()
        });
        httpsurlconnection = httpsurlconnection2;
        MAPLog.e(TAG, s);
        httpsurlconnection = httpsurlconnection2;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, s, null, null));
        s1 = s;
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
            return s;
        }
        break; /* Loop/switch isn't completed */
_L10:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = AuthEndpointErrorParser.GENERIC_ERROR;
        if (true) goto _L9; else goto _L5
_L7:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s.getString("request_id");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s1 = TAG;
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        httpsurlconnection3.getURL().toString();
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s1 = s.getJSONObject("response");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (!s1.has("success")) goto _L12; else goto _L11
_L11:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = s1.getJSONObject("success");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s1 = s.getString("customer_id");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = new AuthenticatedAccountInfo(s.getJSONObject("tokens").getJSONObject("bearer").getString("access_token"), s1);
        continue; /* Loop/switch isn't completed */
        s;
        httpsurlconnection = httpsurlconnection1;
        tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(httpsurlconnection1.getURL()));
        httpsurlconnection = httpsurlconnection1;
        tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(httpsurlconnection1.getURL(), s, mContext));
        httpsurlconnection = httpsurlconnection1;
        s = s.getMessage();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        httpsurlconnection = httpsurlconnection1;
        if (!s.contains("Received authentication challenge is"))
        {
            break; /* Loop/switch isn't completed */
        }
        httpsurlconnection = httpsurlconnection1;
        MAPLog.e(TAG, "Encountered Panda bug around 401 returned from the server. Assuming this means invalid credentials");
        httpsurlconnection = httpsurlconnection1;
        s = GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO;
        s1 = s;
        if (httpsurlconnection1 != null)
        {
            httpsurlconnection1.disconnect();
            return s;
        }
          goto _L5
_L12:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (!s1.has("challenge"))
        {
            break MISSING_BLOCK_LABEL_1433;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = AuthenticationChallenge.fromPandaChallengeBody(s1.getJSONObject("challenge"));
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s1 = JSONHelpers.getStringOrDefault(s1, "request_id", null);
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s2 = s.getReason();
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if ("AuthenticationFailed".equals(s2))
        {
            break MISSING_BLOCK_LABEL_1347;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        if (!"InvalidAuthenticationData".equals(s2))
        {
            break MISSING_BLOCK_LABEL_1396;
        }
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.CredentialError, null, null, s1));
        continue; /* Loop/switch isn't completed */
        s;
        if (httpsurlconnection != null)
        {
            httpsurlconnection.disconnect();
        }
        throw s;
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = new AuthenticatedAccountInfo(s, new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.AuthenticationChallenged, null, null, s1));
        continue; /* Loop/switch isn't completed */
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        MAPLog.e(TAG, "Error parsing response. Empty response body.");
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, "Error parsing response. Empty response body.", null, null));
        continue; /* Loop/switch isn't completed */
_L4:
        httpsurlconnection2 = httpsurlconnection3;
        httpsurlconnection1 = httpsurlconnection3;
        httpsurlconnection = httpsurlconnection3;
        tracer.incrementCounter(MetricUtils.getUrlPathAndDomain(httpsurlconnection3.getURL(), i));
        if (true) goto _L14; else goto _L13
_L13:
        httpsurlconnection = httpsurlconnection1;
        s = String.format(Locale.US, "Error getting response from server. Error: %s", new Object[] {
            s
        });
        httpsurlconnection = httpsurlconnection1;
        MAPLog.e(TAG, s);
        httpsurlconnection = httpsurlconnection1;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.NetworkFailure, s, null, null));
        s1 = s;
        if (httpsurlconnection1 != null)
        {
            httpsurlconnection1.disconnect();
            s1 = s;
        }
_L5:
        return s1;
        if (true) goto _L16; else goto _L15
_L15:
    }

    HttpsURLConnection createURLConnection(URL url)
        throws IOException
    {
        return (HttpsURLConnection)AmazonWebserviceCall.setAmazonWebRequestSettings((HttpsURLConnection)EnhancedURLConnectionFactory.createURLConnection(url));
    }

    URL getSignInUrl(String s)
    {
        Object obj = EnvironmentUtils.getInstance().getPandaHost(s);
        try
        {
            obj = new URL("https", ((String) (obj)), 443, "/auth/signin");
        }
        catch (MalformedURLException malformedurlexception)
        {
            MAPLog.e(TAG, "Could not request URL to hit panda. Domain %s was invalid. Error: %s", new Object[] {
                s, malformedurlexception.getMessage()
            });
            return null;
        }
        return ((URL) (obj));
    }

    static 
    {
        GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.CredentialError, "Credential Error", "Credential Error", "No Request Id"));
    }
}

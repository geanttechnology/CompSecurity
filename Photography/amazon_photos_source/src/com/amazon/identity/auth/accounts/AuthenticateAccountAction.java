// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.RetryLogic;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.framework.security.EnhancedURLConnectionFactory;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;
import com.amazon.identity.kcpsdk.auth.JwtSigner;
import com.amazon.identity.kcpsdk.auth.PandaAuthenticateAccountRequest;
import com.amazon.identity.kcpsdk.common.LocaleUtil;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
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
    private final ServiceWrappingContext mContext;
    private final SSODeviceInfo mDeviceInfo;
    private final FeatureSet mFeatureSet;

    AuthenticateAccountAction(Context context)
    {
        this(ServiceWrappingContext.create(context), new AuthEndpointErrorParser());
    }

    private AuthenticateAccountAction(ServiceWrappingContext servicewrappingcontext, AuthEndpointErrorParser authendpointerrorparser)
    {
        this(servicewrappingcontext, authendpointerrorparser, (SSODeviceInfo)servicewrappingcontext.getSystemService("dcp_device_info"));
    }

    AuthenticateAccountAction(ServiceWrappingContext servicewrappingcontext, AuthEndpointErrorParser authendpointerrorparser, SSODeviceInfo ssodeviceinfo)
    {
        mContext = servicewrappingcontext;
        mAuthEndpointErrorParser = authendpointerrorparser;
        mDeviceInfo = ssodeviceinfo;
        mFeatureSet = servicewrappingcontext.getFeatureSet();
    }

    public AuthenticatedAccountInfo authenticateAccount(String s, String s1, String s2, Bundle bundle, Tracer tracer)
    {
        String s3;
        String s4;
        URL url;
        Object obj;
        String s5;
        s5 = null;
        obj = null;
        url = null;
        s3 = ((String) (obj));
        s4 = s5;
        URL url1 = getSignInUrl(s2);
        if (url1 == null)
        {
            return null;
        }
        s3 = ((String) (obj));
        url = url1;
        s4 = s5;
        MAPLog.i(TAG, (new StringBuilder("Starting request to authenticate account. URL : ")).append(url1.toString()).toString());
        s3 = ((String) (obj));
        url = url1;
        s4 = s5;
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url1));
        s3 = ((String) (obj));
        url = url1;
        s4 = s5;
        s2 = createURLConnection(url1);
        if (s2 != null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.e(TAG, "Could not create request to authenticate account");
        if (s2 != null)
        {
            s2.disconnect();
        }
        return null;
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.setDoOutput(true);
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.setRequestMethod("POST");
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.setRequestProperty("Accept", "application/json");
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.setRequestProperty("Content-Type", "application/json");
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!mFeatureSet.hasFeature(Feature.UseDeviceLocaleAsLanguagePreference))
        {
            break MISSING_BLOCK_LABEL_313;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        obj = LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault());
        s3 = s2;
        url = url1;
        s4 = s2;
        s5 = TAG;
        s3 = s2;
        url = url1;
        s4 = s2;
        (new StringBuilder("Setting Language to: ")).append(((String) (obj))).toString();
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.setRequestProperty("Accept-Language", ((String) (obj)));
        s3 = s2;
        url = url1;
        s4 = s2;
        obj = new PandaAuthenticateAccountRequest();
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setUserID(s);
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setPassword(s1);
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setDeviceInfo(mDeviceInfo);
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setJwtSigner(JwtSigner.getSigner(PlatformSettings.getInstance(mContext), mDeviceInfo, tracer));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = mDeviceInfo.getDeviceSerialNumber();
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setFraudMetadata(DeviceMetadataCollector.getFraudMetadata(mContext, s, tracer));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = bundle.getString("calling_package");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setMetadataAppName(s);
        s3 = s2;
        url = url1;
        s4 = s2;
        s = PackageUtils.getPackageVersion(mContext, s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        ((PandaAuthenticateAccountRequest) (obj)).setMetadataAppVersion(Integer.toString(s.intValue()));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = ((PandaAuthenticateAccountRequest) (obj)).getRequestJSON();
        s3 = s2;
        url = url1;
        s4 = s2;
        StreamUtils.writeToStreamAndClose(s2.getOutputStream(), s.toString().getBytes());
        s3 = s2;
        url = url1;
        s4 = s2;
        int i = s2.getResponseCode();
        s3 = s2;
        url = url1;
        s4 = s2;
        platformmetricstimer.stopClock();
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.i(TAG, (new StringBuilder("Panda SignIn Response code: ")).append(i).toString());
        s3 = s2;
        url = url1;
        s4 = s2;
        s = JSONHelpers.toJson(s2);
        if (s != null) goto _L2; else goto _L1
_L1:
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.e(TAG, "Error parsing JSON in Panda response");
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, "Error parsing JSON in Panda response", null, null));
_L27:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!s.isError()) goto _L4; else goto _L3
_L3:
        s3 = s2;
        url = url1;
        s4 = s2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url1, i, ((AuthenticatedAccountInfo) (s)).error.getAuthTypeError().getCode()));
_L24:
        s3 = s2;
        url = url1;
        s4 = s2;
        platformmetricstimer.stop();
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!RetryLogic.isHTTP500ErrorCodeSeries(i)) goto _L6; else goto _L5
_L5:
        s3 = s2;
        url = url1;
        s4 = s2;
        tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url1), 0.0D);
_L25:
        s1 = s;
        if (s2 != null)
        {
            s2.disconnect();
            return s;
        }
          goto _L7
        s;
        s3 = s2;
        url = url1;
        s4 = s2;
        s = String.format(Locale.US, "JSONException while bulding Panda sign-in request. Error: %s", new Object[] {
            s.getMessage()
        });
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.e(TAG, s);
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.BuildRequestFailure, s, null, null));
        s1 = s;
        if (s2 != null)
        {
            s2.disconnect();
            return s;
        }
          goto _L7
_L2:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!mAuthEndpointErrorParser.isFailure(i)) goto _L9; else goto _L8
_L8:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (mAuthEndpointErrorParser.hasAuthenticationChallenge(s)) goto _L9; else goto _L10
_L10:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = mAuthEndpointErrorParser.parse(s);
        if (s == null) goto _L12; else goto _L11
_L11:
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.formattedError(TAG, "Error making request. Code: %s \n Message: %s \n Detail: %s", new Object[] {
            s.getAuthTypeError().getCode(), s.getMessage(), s.getDetail()
        });
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(s);
        continue; /* Loop/switch isn't completed */
        s;
        s3 = s2;
        url = url1;
        s4 = s2;
        tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url1), 0.0D);
        s3 = s2;
        url = url1;
        s4 = s2;
        s = String.format(Locale.US, "Error parsing Panda sign-in response. Not of an expected format. Error: %s", new Object[] {
            s.getMessage()
        });
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.e(TAG, s);
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, s, null, null));
        s1 = s;
        if (s2 != null)
        {
            s2.disconnect();
            return s;
        }
        break; /* Loop/switch isn't completed */
_L12:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = AuthEndpointErrorParser.GENERIC_ERROR;
        if (true) goto _L11; else goto _L7
_L9:
        s3 = s2;
        url = url1;
        s4 = s2;
        s.getString("request_id");
        s3 = s2;
        url = url1;
        s4 = s2;
        s1 = TAG;
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.getURL().toString();
        s3 = s2;
        url = url1;
        s4 = s2;
        s = s.getJSONObject("response");
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!s.has("success")) goto _L14; else goto _L13
_L13:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = s.getJSONObject("success");
        s3 = s2;
        url = url1;
        s4 = s2;
        s1 = s.getString("customer_id");
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(s.getJSONObject("tokens").getJSONObject("bearer").getString("access_token"), s1);
        continue; /* Loop/switch isn't completed */
        s;
        s4 = s3;
        s1 = s.getMessage();
        if (s1 == null) goto _L16; else goto _L15
_L15:
        s4 = s3;
        if (!s1.contains("Received authentication challenge is")) goto _L16; else goto _L17
_L17:
        s4 = s3;
        MAPLog.e(TAG, "Encountered Panda bug around 401 returned from the server. Assuming this means invalid credentials");
        s4 = s3;
        tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url), 1.0D);
        s4 = s3;
        tracer.incrementCounter(MetricUtils.getUrlPathAndDomain(url, 401, com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.CredentialError.getCode()));
        s4 = s3;
        s = GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO;
        s1 = s;
        if (s3 != null)
        {
            s3.disconnect();
            return s;
        }
          goto _L7
_L14:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!s.has("challenge")) goto _L19; else goto _L18
_L18:
        s3 = s2;
        url = url1;
        s4 = s2;
        s1 = AuthenticationChallenge.fromPandaChallengeBody(s.getJSONObject("challenge"));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = JSONHelpers.getStringOrDefault(s, "request_id", null);
        s3 = s2;
        url = url1;
        s4 = s2;
        bundle = s1.getReason();
        s3 = s2;
        url = url1;
        s4 = s2;
        if ("AuthenticationFailed".equals(bundle)) goto _L21; else goto _L20
_L20:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!"InvalidAuthenticationData".equals(bundle)) goto _L22; else goto _L21
_L21:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.CredentialError, null, null, s);
_L23:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(s1, s);
        continue; /* Loop/switch isn't completed */
        s;
        if (s4 != null)
        {
            s4.disconnect();
        }
        throw s;
_L22:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.AuthenticationChallenged, null, null, s);
        if (true) goto _L23; else goto _L19
_L19:
        s3 = s2;
        url = url1;
        s4 = s2;
        MAPLog.e(TAG, "Error parsing response. Empty response body.");
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.ParseError, "Error parsing response. Empty response body.", null, null));
        continue; /* Loop/switch isn't completed */
_L4:
        s3 = s2;
        url = url1;
        s4 = s2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url1, i));
          goto _L24
_L6:
        s3 = s2;
        url = url1;
        s4 = s2;
        tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url1), 1.0D);
          goto _L25
_L16:
        s4 = s3;
        if (!MetricUtils.isDeviceConnected(mContext))
        {
            break MISSING_BLOCK_LABEL_1794;
        }
        s4 = s3;
        tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url), 0.0D);
        s4 = s3;
        tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
        s4 = s3;
        tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, s, mContext));
        s4 = s3;
        s = String.format(Locale.US, "Error getting response from server. Error: %s", new Object[] {
            s1
        });
        s4 = s3;
        MAPLog.e(TAG, s);
        s4 = s3;
        s = new AuthenticatedAccountInfo(new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.NetworkFailure, s, null, null));
        s1 = s;
        if (s3 != null)
        {
            s3.disconnect();
            s1 = s;
        }
_L7:
        return s1;
        if (true) goto _L27; else goto _L26
_L26:
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
            MAPLog.formattedError(TAG, "Could not request URL to hit panda. Domain %s was invalid. Error: %s", new Object[] {
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

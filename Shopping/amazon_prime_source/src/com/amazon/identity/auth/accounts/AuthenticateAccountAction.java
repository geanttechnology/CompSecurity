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
        PandaAuthenticateAccountRequest pandaauthenticateaccountrequest;
        Object obj;
        obj = null;
        pandaauthenticateaccountrequest = null;
        url = null;
        s3 = pandaauthenticateaccountrequest;
        s4 = obj;
        URL url1 = getSignInUrl(s2);
        s3 = pandaauthenticateaccountrequest;
        url = url1;
        s4 = obj;
        MAPLog.i(TAG, (new StringBuilder("Starting request to authenticate account. URL : ")).append(url1.toString()).toString());
        s3 = pandaauthenticateaccountrequest;
        url = url1;
        s4 = obj;
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url1));
        s3 = pandaauthenticateaccountrequest;
        url = url1;
        s4 = obj;
        s2 = createURLConnection(url1);
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
            break MISSING_BLOCK_LABEL_217;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        s2.setRequestProperty("Accept-Language", LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault()));
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest = new PandaAuthenticateAccountRequest();
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setUserID(s);
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setPassword(s1);
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setDeviceInfo(mDeviceInfo);
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setJwtSigner(JwtSigner.getSigner(PlatformSettings.getInstance(mContext), mDeviceInfo, tracer));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = mDeviceInfo.getDeviceSerialNumber();
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setFraudMetadata(DeviceMetadataCollector.getFraudMetadata(mContext, s, tracer));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = bundle.getString("calling_package");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setMetadataAppName(s);
        s3 = s2;
        url = url1;
        s4 = s2;
        s = PackageUtils.getPackageVersion(mContext, s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        pandaauthenticateaccountrequest.setMetadataAppVersion(Integer.toString(s.intValue()));
        s3 = s2;
        url = url1;
        s4 = s2;
        s = pandaauthenticateaccountrequest.getRequestJSON();
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
_L26:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!s.isError()) goto _L4; else goto _L3
_L3:
        s3 = s2;
        url = url1;
        s4 = s2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url1, i, ((AuthenticatedAccountInfo) (s)).error.getAuthTypeError().getCode()));
_L22:
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
_L23:
        s1 = s;
        if (s2 != null)
        {
            s2.disconnect();
            s1 = s;
        }
_L8:
        return s1;
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
        if (s2 == null) goto _L8; else goto _L7
_L7:
        s2.disconnect();
        return s;
_L2:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!mAuthEndpointErrorParser.isFailure(i))
        {
            break MISSING_BLOCK_LABEL_1096;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        if (mAuthEndpointErrorParser.hasAuthenticationChallenge(s))
        {
            break MISSING_BLOCK_LABEL_1096;
        }
        s3 = s2;
        url = url1;
        s4 = s2;
        s = mAuthEndpointErrorParser.parse(s);
        if (s == null) goto _L10; else goto _L9
_L9:
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
          goto _L8
_L10:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = AuthEndpointErrorParser.GENERIC_ERROR;
          goto _L9
        s3 = s2;
        url = url1;
        s4 = s2;
        s.getString("request_id");
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
        if (!s.has("success")) goto _L12; else goto _L11
_L11:
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
        if (s1 == null) goto _L14; else goto _L13
_L13:
        s4 = s3;
        if (!s1.contains("Received authentication challenge is")) goto _L14; else goto _L15
_L15:
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
          goto _L8
_L12:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!s.has("challenge")) goto _L17; else goto _L16
_L16:
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
        if ("AuthenticationFailed".equals(bundle)) goto _L19; else goto _L18
_L18:
        s3 = s2;
        url = url1;
        s4 = s2;
        if (!"InvalidAuthenticationData".equals(bundle)) goto _L20; else goto _L19
_L19:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.CredentialError, null, null, s);
_L21:
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
_L20:
        s3 = s2;
        url = url1;
        s4 = s2;
        s = new com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.AuthenticationChallenged, null, null, s);
        if (true) goto _L21; else goto _L17
_L17:
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
          goto _L22
_L6:
        s3 = s2;
        url = url1;
        s4 = s2;
        tracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url1), 1.0D);
          goto _L23
_L14:
        s4 = s3;
        if (!MetricUtils.isDeviceConnected(mContext))
        {
            break MISSING_BLOCK_LABEL_1686;
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
        if (s3 == null) goto _L8; else goto _L24
_L24:
        s3.disconnect();
        return s;
        if (true) goto _L26; else goto _L25
_L25:
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

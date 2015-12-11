// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AccountAuthenticatorQueue;
import com.amazon.identity.auth.accounts.AccountManagerDefinition;
import com.amazon.identity.auth.accounts.AccountManagerImplementationFactory;
import com.amazon.identity.auth.accounts.AccountManagerLogic;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.DefaultCallback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.LocalKeyValueStore;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.auth.PandaRequest;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            PandaCreateCodePairEndpointUtils, PandaEndpointUtils, PandaGeneratePreAuthorizedCodeEndpointUtils

public class CBLLogic
{
    public static class CBLData
    {

        public final String mPrivateCode;
        public final String mPublicCode;
        public final long mTimeLeft;

        CBLData(String s, String s1, long l)
        {
            mPublicCode = s;
            mPrivateCode = s1;
            mTimeLeft = l - System.currentTimeMillis();
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/cbl/CBLLogic.getSimpleName();
    private final AccountManagerDefinition mAccountManagerInternal;
    private final Context mContext;
    private final MAPAccountManager mMAPAccountManager;
    private final TokenManagement mTokenManagement;

    public CBLLogic(Context context)
    {
        mContext = context;
        mTokenManagement = new TokenManagement(mContext);
        mMAPAccountManager = new MAPAccountManager(mContext);
        mAccountManagerInternal = AccountManagerImplementationFactory.getAccountManagerImplementation(mContext);
    }

    public static CBLData getCBLDataFromStorage(Context context)
    {
        context = new LocalKeyValueStore(context, "cbl_storage");
        String s = context.getStringValue("public_code");
        String s1 = context.getStringValue("private_code");
        long l;
        for (l = context.getLongValue("expires_at"); TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || l == 0L || l <= 0L;)
        {
            return null;
        }

        if (l > 60000L + System.currentTimeMillis())
        {
            MAPLog.i(TAG, "Returning already existing public code");
            return new CBLData(s, s1, l);
        } else
        {
            context.clearStore();
            return null;
        }
    }

    private String getRefreshToken(String s)
    {
        s = mTokenManagement.getToken(s, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token", new Bundle(), new DefaultCallback());
        try
        {
            s = ((Bundle)s.get()).getString("value_key");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Exception while trying to get the refresh token in the authorizeLinkCode API", s);
            return null;
        }
        return s;
    }

    public static void onError(int i, String s, Callback callback)
    {
        MAPLog.e(TAG, s);
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.dcp.sso.ErrorCode", i);
        bundle.putString("com.amazon.dcp.sso.ErrorMessage", s);
        callback.onError(bundle);
    }

    public static void onSuccessOfGenerateLinkCode(String s, String s1, long l, Callback callback)
    {
        Bundle bundle = new Bundle();
        bundle.putString(s1, s);
        bundle.putLong("link_code_expiry", l);
        callback.onSuccess(bundle);
    }

    public static CallbackFuture wrapCallbackToClearCBLStore(Context context, CallbackFuture callbackfuture)
    {
        return new CallbackFuture(context, callbackfuture) {

            final CallbackFuture val$callback;
            final Context val$context;

            public void onError(Bundle bundle)
            {
                super.onError(bundle);
                MAPLog.i(CBLLogic.TAG, "Register with link code was not successful.");
                callback.onError(bundle);
            }

            public void onSuccess(Bundle bundle)
            {
                super.onSuccess(bundle);
                MAPLog.i(CBLLogic.TAG, "Register with link code was successful. Clearing the cbl data in MAP");
                (new LocalKeyValueStore(context, "cbl_storage")).clearStore();
                callback.onSuccess(bundle);
            }

            
            {
                context = context1;
                callback = callbackfuture;
                super();
            }
        };
    }

    public void authorizeLinkCode(final Bundle directedId, Callback callback, final Tracer tracer)
    {
        final String domain = directedId.getString("link_code_domain");
        TextUtils.isEmpty(domain);
        final String publicCode = directedId.getString("link_code");
        if (TextUtils.isEmpty(publicCode))
        {
            onError(2, "Required value MAPAccountManager.KEY_LINK_CODE is missing for the API authorizeLinkCode", callback);
            return;
        }
        directedId = directedId.getString("com.amazon.dcp.sso.property.account.acctId");
        if (TextUtils.isEmpty(directedId))
        {
            onError(2, "Required value DirectedID(MAPAccountManager.KEY_AUTHORIZE_LINK_CODE_DIRECTED_ID) is missing for the API authorizeLinkCode", callback);
            return;
        } else
        {
            AccountManagerLogic.ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new com.amazon.identity.auth.accounts.AccountAuthenticatorQueue.AccountAuthenticatorTask() {

                final CBLLogic this$0;
                final String val$directedId;
                final String val$domain;
                final String val$publicCode;
                final Tracer val$tracer;

                public Bundle run(Callback callback1)
                {
                    if (!mAccountManagerInternal.isAccountRegistered(directedId))
                    {
                        CBLLogic.onError(3, "The directedID passed in the authorizeLinkCode API is not registered on this device", callback1);
                        return null;
                    }
                    String s = getRefreshToken(directedId);
                    if (TextUtils.isEmpty(s))
                    {
                        CBLLogic.onError(1, "Could not get the auth token for the customer to authorize the link code", callback1);
                        return null;
                    } else
                    {
                        CBLLogic.access$600(CBLLogic.this, directedId, domain, publicCode, s, callback1, tracer);
                        return null;
                    }
                }

            
            {
                this$0 = CBLLogic.this;
                directedId = s;
                domain = s1;
                publicCode = s2;
                tracer = tracer1;
                super();
            }
            }, callback, "authorizeLinkCode");
            return;
        }
    }

    public void deregisterAccount(String s, final String apiName)
    {
        mMAPAccountManager.deregisterAccount(s, new DefaultCallback() {

            final CBLLogic this$0;
            final String val$apiName;

            public void onError(Bundle bundle)
            {
                int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode");
                bundle = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
                MAPLog.i(CBLLogic.TAG, (new StringBuilder("Error while deregistering account in ")).append(apiName).append(" flow. ErrorCode:").append(i).append(" ErrorMessage:").append(bundle).toString());
            }

            public void onSuccess(Bundle bundle)
            {
                MAPLog.i(CBLLogic.TAG, (new StringBuilder("Successfully completed deregistering account in ")).append(apiName).append(" flow").toString());
            }

            
            {
                this$0 = CBLLogic.this;
                apiName = s;
                super();
            }
        });
    }

    public void generateLinkCode(final Bundle input, Callback callback, final Tracer tracer)
    {
        final String domain = input.getString("link_code_domain");
        TextUtils.isEmpty(domain);
        AccountManagerLogic.ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new com.amazon.identity.auth.accounts.AccountAuthenticatorQueue.AccountAuthenticatorTask() {

            final CBLLogic this$0;
            final String val$domain;
            final Bundle val$input;
            final Tracer val$tracer;

            public Bundle run(Callback callback1)
            {
                Object obj = CBLLogic.getCBLDataFromStorage(mContext);
                if (obj == null)
                {
                    obj = new LocalKeyValueStore(mContext, "cbl_storage");
                    CBLLogic.access$100(CBLLogic.this, domain, input, ((LocalKeyValueStore) (obj)), callback1, tracer);
                    return null;
                } else
                {
                    CBLLogic.onSuccessOfGenerateLinkCode(((CBLData) (obj)).mPublicCode, "link_code", ((CBLData) (obj)).mTimeLeft, callback1);
                    return null;
                }
            }

            
            {
                this$0 = CBLLogic.this;
                domain = s;
                input = bundle;
                tracer = tracer1;
                super();
            }
        }, callback, "generateLinkCode");
    }

    public void generatePreAuthorizedLinkCode(Bundle bundle, Callback callback, final Tracer tracer)
    {
        final String domain = bundle.getString("link_code_domain");
        TextUtils.isEmpty(domain);
        final String directedId = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        if (TextUtils.isEmpty(directedId))
        {
            onError(2, "Required value DirectedID(MAPAccountManager.KEY_DIRECTED_ID) is missing for the API generatePreAuthorizedLinkCode", callback);
            return;
        } else
        {
            final long getCodeWithExpiry = bundle.getLong("link_code_expiry", 0L);
            AccountManagerLogic.ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new com.amazon.identity.auth.accounts.AccountAuthenticatorQueue.AccountAuthenticatorTask() {

                final CBLLogic this$0;
                final String val$directedId;
                final String val$domain;
                final long val$getCodeWithExpiry;
                final Tracer val$tracer;

                public Bundle run(Callback callback1)
                {
                    if (!mAccountManagerInternal.isAccountRegistered(directedId))
                    {
                        CBLLogic.onError(3, "The directedID passed in the generatePreAuthorizedLinkCode API is not registered on this device", callback1);
                        return null;
                    }
                    String s = getRefreshToken(directedId);
                    if (TextUtils.isEmpty(s))
                    {
                        CBLLogic.onError(1, "Could not get the auth token for the customer to authorize the link code", callback1);
                        return null;
                    } else
                    {
                        CBLLogic.access$400(CBLLogic.this, directedId, domain, s, getCodeWithExpiry, callback1, tracer);
                        return null;
                    }
                }

            
            {
                this$0 = CBLLogic.this;
                directedId = s;
                domain = s1;
                getCodeWithExpiry = l;
                tracer = tracer1;
                super();
            }
            }, callback, "generatePreAuthorizedLinkCode");
            return;
        }
    }




/*
    static void access$100(CBLLogic cbllogic, String s, Bundle bundle, LocalKeyValueStore localkeyvaluestore, Callback callback, Tracer tracer)
    {
        HttpsURLConnection httpsurlconnection;
        HttpsURLConnection httpsurlconnection1;
        Object obj;
        URL url;
        PlatformMetricsTimer platformmetricstimer;
        int i;
        i = bundle.getInt("get_link_code_with_length", 0);
        long l = bundle.getLong("link_code_expiry", 0L);
        s = (new StringBuilder("https://")).append(EnvironmentUtils.getInstance().getPandaHost(s)).append("/auth/create/codepair").toString();
        Object obj1;
        PandaCreateCodePairEndpointUtils pandacreatecodepairendpointutils;
        String s1;
        try
        {
            url = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (CBLLogic cbllogic)
        {
            MAPLog.e(TAG, "MalformedURLException while constructing url to generate link code", cbllogic);
            onError(1, "Could not construct the url to get the link code. Check the domain you pass in this api.", callback);
            return;
        }
        pandacreatecodepairendpointutils = new PandaCreateCodePairEndpointUtils(ServiceWrappingContext.create(cbllogic.mContext), tracer);
        try
        {
            s1 = pandacreatecodepairendpointutils.getRequestJSON(i, l);
        }
        // Misplaced declaration of an exception variable
        catch (CBLLogic cbllogic)
        {
            onError(1, "Could not construct the request body to call Panda createCode API", callback);
            return;
        }
        obj = null;
        obj1 = null;
        httpsurlconnection1 = null;
        bundle = httpsurlconnection1;
        httpsurlconnection = ((HttpsURLConnection) (obj));
        s = obj1;
        platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url));
        bundle = httpsurlconnection1;
        httpsurlconnection = ((HttpsURLConnection) (obj));
        s = obj1;
        httpsurlconnection1 = PandaRequest.createPostURLConnection(url);
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        StreamUtils.writeToStreamAndClose(httpsurlconnection1.getOutputStream(), s1.getBytes());
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        i = httpsurlconnection1.getResponseCode();
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        MAPLog.i(TAG, (new StringBuilder("The createCodePair call response code is ")).append(i).toString());
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        platformmetricstimer.stopClock();
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        obj = JSONHelpers.toJson(httpsurlconnection1);
        if (i != 200) goto _L2; else goto _L1
_L1:
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        obj = pandacreatecodepairendpointutils.parseSuccessResponse(((JSONObject) (obj)));
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i));
        if (obj != null) goto _L4; else goto _L3
_L3:
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        onError(4, "Received a successful response from server but it was missing required values", callback);
        if (httpsurlconnection1 != null)
        {
            httpsurlconnection1.disconnect();
        }
_L6:
        return;
_L4:
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        localkeyvaluestore.setValue("public_code", ((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (obj)).mPublicCode);
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        localkeyvaluestore.setValue("private_code", ((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (obj)).mPrivateCode);
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        localkeyvaluestore.setValue("expires_at", ((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (obj)).mExpiresAt);
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        onSuccessOfGenerateLinkCode(((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (obj)).mPublicCode, "link_code", ((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (obj)).mExpiresIn, callback);
_L7:
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        platformmetricstimer.stop();
        if (httpsurlconnection1 == null) goto _L6; else goto _L5
_L5:
        httpsurlconnection1.disconnect();
        return;
_L2:
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        localkeyvaluestore = PandaEndpointUtils.parseErrorAndLogMetrics(((JSONObject) (obj)));
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        obj = (new StringBuilder("Response code : ")).append(i).append(" Error Code : ").append(((PandaEndpointUtils.PandaErrorResponse) (localkeyvaluestore)).mErrorCode).append(" Description : ").append(((PandaEndpointUtils.PandaErrorResponse) (localkeyvaluestore)).mErrorMessage).toString();
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i, ((PandaEndpointUtils.PandaErrorResponse) (localkeyvaluestore)).mErrorCode));
        bundle = httpsurlconnection1;
        httpsurlconnection = httpsurlconnection1;
        s = httpsurlconnection1;
        onError(5, ((String) (obj)), callback);
          goto _L7
        localkeyvaluestore;
        s = bundle;
        MAPLog.e(TAG, "IOException while making request to Panda createCodePair:", localkeyvaluestore);
        s = bundle;
        tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
        s = bundle;
        tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, localkeyvaluestore, cbllogic.mContext));
        s = bundle;
        onError(5, (new StringBuilder("Got an IOException while talking to the server : ")).append(localkeyvaluestore.getMessage()).toString(), callback);
        if (bundle != null)
        {
            bundle.disconnect();
            return;
        }
          goto _L6
        cbllogic;
        s = httpsurlconnection;
        onError(4, "Could not parse the response from our service to generate the link code", callback);
        if (httpsurlconnection == null) goto _L6; else goto _L8
_L8:
        httpsurlconnection.disconnect();
        return;
        cbllogic;
        if (s != null)
        {
            s.disconnect();
        }
        throw cbllogic;
    }

*/




/*
    static void access$400(CBLLogic cbllogic, String s, String s1, String s2, long l, Callback callback, Tracer tracer)
    {
        HttpsURLConnection httpsurlconnection;
        HttpsURLConnection httpsurlconnection1;
        HttpsURLConnection httpsurlconnection2;
        URL url;
        PlatformMetricsTimer platformmetricstimer;
        int i;
        s1 = (new StringBuilder("https://")).append(EnvironmentUtils.getInstance().getPandaHost(s1)).append("/auth/create/code").toString();
        PandaGeneratePreAuthorizedCodeEndpointUtils pandageneratepreauthorizedcodeendpointutils;
        Object obj;
        try
        {
            url = new URL(s1);
        }
        // Misplaced declaration of an exception variable
        catch (CBLLogic cbllogic)
        {
            MAPLog.e(TAG, "MalformedURLException while trying to generate url to call generate pre-authorized link code", cbllogic);
            onError(1, "Could not construct the url to authorize the link code.", callback);
            return;
        }
        pandageneratepreauthorizedcodeendpointutils = null;
        obj = null;
        httpsurlconnection2 = null;
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = pandageneratepreauthorizedcodeendpointutils;
        s1 = obj;
        platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url));
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = pandageneratepreauthorizedcodeendpointutils;
        s1 = obj;
        httpsurlconnection2 = PandaRequest.createPostURLConnection(url);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        pandageneratepreauthorizedcodeendpointutils = new PandaGeneratePreAuthorizedCodeEndpointUtils(ServiceWrappingContext.create(cbllogic.mContext), tracer);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = pandageneratepreauthorizedcodeendpointutils.getRequestJSON(l, s2);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        StreamUtils.writeToStreamAndClose(httpsurlconnection2.getOutputStream(), s2.getBytes());
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        i = httpsurlconnection2.getResponseCode();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        MAPLog.i(TAG, (new StringBuilder("The generate pre-authorized code web service call http response code is ")).append(i).toString());
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.stopClock();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = JSONHelpers.toJson(httpsurlconnection2);
        if (i != 200) goto _L2; else goto _L1
_L1:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i));
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s = pandageneratepreauthorizedcodeendpointutils.parseSuccessResponse(s2);
        if (s != null) goto _L4; else goto _L3
_L3:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        onError(4, "Received a successful response from server but it was missing required values", callback);
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
        }
_L6:
        return;
_L4:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        onSuccessOfGenerateLinkCode(((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (s)).mPrivateCode, "pre_authorized_link_code", ((PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult) (s)).mExpiresIn, callback);
_L7:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.stop();
        if (httpsurlconnection2 == null) goto _L6; else goto _L5
_L5:
        httpsurlconnection2.disconnect();
        return;
_L2:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = PandaEndpointUtils.parseErrorAndLogMetrics(s2);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        String s3 = (new StringBuilder("Response code : ")).append(i).append(" Error Code : ").append(((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode).append(" Description : ").append(((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorMessage).toString();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i, ((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode));
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        if (!((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode.equals("CredentialError"))
        {
            break MISSING_BLOCK_LABEL_599;
        }
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        MAPLog.i(TAG, "Deregistering account because while generating pre-authoried public code, Panda told us the refresh token is invalid");
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        cbllogic.deregisterAccount(s, "generatePreAuthorizedLinkCode");
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        onError(3, "Could not authorize the link code because the account credentials that MAP had was invalid. This happens if the account was deregistered from the server side.", callback);
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
            return;
        }
          goto _L6
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        onError(5, s3, callback);
          goto _L7
        s;
        s1 = httpsurlconnection;
        MAPLog.e(TAG, "IOException while making request to Panda to generate pre-authorized code:", s);
        s1 = httpsurlconnection;
        tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
        s1 = httpsurlconnection;
        tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, s, cbllogic.mContext));
        s1 = httpsurlconnection;
        onError(5, (new StringBuilder("Got an IOException while talking to the server : ")).append(s.getMessage()).toString(), callback);
        if (httpsurlconnection != null)
        {
            httpsurlconnection.disconnect();
            return;
        }
          goto _L6
        cbllogic;
        s1 = httpsurlconnection1;
        onError(4, "Could not parse the response from our service to generate the link code", callback);
        if (httpsurlconnection1 == null) goto _L6; else goto _L8
_L8:
        httpsurlconnection1.disconnect();
        return;
        cbllogic;
        if (s1 != null)
        {
            s1.disconnect();
        }
        throw cbllogic;
    }

*/



/*
    static void access$600(CBLLogic cbllogic, String s, String s1, String s2, String s3, Callback callback, Tracer tracer)
    {
        HttpsURLConnection httpsurlconnection;
        HttpsURLConnection httpsurlconnection1;
        HttpsURLConnection httpsurlconnection2;
        URL url;
        PlatformMetricsTimer platformmetricstimer;
        int i;
        s1 = (new StringBuilder("https://")).append(EnvironmentUtils.getInstance().getPandaHost(s1)).append("/auth/authorize").toString();
        JSONObject jsonobject;
        Object obj;
        try
        {
            url = new URL(s1);
        }
        // Misplaced declaration of an exception variable
        catch (CBLLogic cbllogic)
        {
            MAPLog.e(TAG, "MalformedURLException while trying to generate url to call authorize link code", cbllogic);
            onError(1, "Could not construct the url to authorize the link code.", callback);
            return;
        }
        jsonobject = null;
        obj = null;
        httpsurlconnection2 = null;
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = jsonobject;
        s1 = obj;
        platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url));
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = jsonobject;
        s1 = obj;
        httpsurlconnection2 = PandaRequest.createPostURLConnection(url);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        jsonobject = new JSONObject();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        jsonobject.put("public_code", s2);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = new JSONObject();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2.put("code_pair", jsonobject);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2.put("access_token", s3);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s3 = new JSONObject();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s3.put("auth_data", s2);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = s3.toString();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        StreamUtils.writeToStreamAndClose(httpsurlconnection2.getOutputStream(), s2.getBytes());
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        i = httpsurlconnection2.getResponseCode();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        MAPLog.i(TAG, (new StringBuilder("The authorize public code call http response code is ")).append(i).toString());
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.stopClock();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = JSONHelpers.toJson(httpsurlconnection2);
        if (i != 200) goto _L2; else goto _L1
_L1:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i));
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        callback.onSuccess(new Bundle());
_L8:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.stop();
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
        }
_L4:
        return;
_L2:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s2 = PandaEndpointUtils.parseErrorAndLogMetrics(s2);
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        s3 = (new StringBuilder("Response code : ")).append(i).append(" Error Code : ").append(((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode).append(" Description : ").append(((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorMessage).toString();
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i, ((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode));
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        if (!((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode.equals("AuthorizationInPlace"))
        {
            break; /* Loop/switch isn't completed */
        }
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        MAPLog.i(TAG, "The public code is already authorized.");
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        callback.onSuccess(new Bundle());
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        if (!((PandaEndpointUtils.PandaErrorResponse) (s2)).mErrorCode.equals("CredentialError"))
        {
            break; /* Loop/switch isn't completed */
        }
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        MAPLog.i(TAG, "Deregistering account because while authorizing public code, Panda told us the refresh token is invalid");
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        cbllogic.deregisterAccount(s, "authorizeLinkCode");
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        onError(3, "Could not authorize the link code because the account credentials that MAP had were invalid. This happens if the account was deregistered from the server side.", callback);
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        httpsurlconnection = httpsurlconnection2;
        httpsurlconnection1 = httpsurlconnection2;
        s1 = httpsurlconnection2;
        onError(5, s3, callback);
        continue; /* Loop/switch isn't completed */
        s;
        s1 = httpsurlconnection;
        MAPLog.e(TAG, "IOException while making request to Panda to authorize public code:", s);
        s1 = httpsurlconnection;
        tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
        s1 = httpsurlconnection;
        tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, s, cbllogic.mContext));
        s1 = httpsurlconnection;
        onError(5, (new StringBuilder("Got an IOException while talking to the server : ")).append(s.getMessage()).toString(), callback);
        if (httpsurlconnection != null)
        {
            httpsurlconnection.disconnect();
            return;
        }
          goto _L4
        cbllogic;
        s1 = httpsurlconnection1;
        onError(4, "Could not parse the response from our service to generate the link code", callback);
        if (httpsurlconnection1 == null) goto _L4; else goto _L6
_L6:
        httpsurlconnection1.disconnect();
        return;
        cbllogic;
        if (s1 != null)
        {
            s1.disconnect();
        }
        throw cbllogic;
        if (true) goto _L8; else goto _L7
_L7:
        return;
    }

*/
}

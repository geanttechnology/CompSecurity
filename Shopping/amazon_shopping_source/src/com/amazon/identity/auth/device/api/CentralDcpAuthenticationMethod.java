// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.amazon.dcp.sso.IRequestAuthenticationMethod;
import com.amazon.dcp.sso.ReturnValueOrError;
import com.amazon.identity.auth.accounts.AuthenticatedRequestServiceIntentFactory;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSetCache;
import com.amazon.identity.auth.device.framework.BoundServiceCaller;
import com.amazon.identity.auth.device.framework.SyncBoundServiceCaller;
import com.amazon.identity.auth.device.utils.ADPCorpusSigningCallbackHelpers;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.request.AuthenticatedRequestHelpers;
import com.amazon.identity.auth.request.NoCredentialsException;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationMethod, ADPCorpusSigningAuthenticationMethod, MAPAccountManager, AuthenticationType, 
//            Callback, MAPFuture

class CentralDcpAuthenticationMethod extends AuthenticationMethod
    implements ADPCorpusSigningAuthenticationMethod
{
    private class _cls3
        implements Callback
    {

        final CentralDcpAuthenticationMethod this$0;
        final CallbackFuture val$callbackFuture;

        public void onError(Bundle bundle)
        {
            callbackFuture.onError(bundle);
        }

        public void onSuccess(Bundle bundle)
        {
            callbackFuture.onSuccess(bundle);
        }

        _cls3()
        {
            this$0 = CentralDcpAuthenticationMethod.this;
            callbackFuture = callbackfuture;
            super();
        }
    }


    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod.getSimpleName();
    private static final String TAG = com/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod.getName();
    private final Context mContext;

    CentralDcpAuthenticationMethod(Context context, String s, AuthenticationType authenticationtype)
    {
        super(context, s, authenticationtype);
        mContext = context;
    }

    CentralDcpAuthenticationMethod(Context context, String s, String s1)
    {
        super(context, s, s1);
        mContext = context;
    }

    private MAPFuture signCorpusWithDirectedId(byte abyte0[], String s, Bundle bundle, Callback callback)
    {
        throwIfOnMainThread("You cannot authenticate this corpus on the main thread!");
        CallbackFuture callbackfuture = new CallbackFuture(callback);
        if (abyte0 == null)
        {
            ADPCorpusSigningCallbackHelpers.nullCorpusCallbackError(callbackfuture, TAG);
        } else
        {
            Object obj = getAuthenticationType();
            if (!AuthenticationType.ADPAuthenticator.getValue().equals(obj))
            {
                abyte0 = String.format("Only supprot authentication type: %s. Cannot sign the corpus with invalid authentication type: %s", new Object[] {
                    AuthenticationType.ADPAuthenticator.getValue(), obj
                });
                MAPLog.e(TAG, abyte0);
                ADPCorpusSigningCallbackHelpers.callbackError(callbackfuture, 3, abyte0);
                return callbackfuture;
            }
            obj = AuthenticatedRequestServiceIntentFactory.findAuthRequestService(mContext);
            if (obj == null)
            {
                MAPLog.e(TAG, "A Central device credential location cannot be found.");
                ADPCorpusSigningCallbackHelpers.callbackError(callbackfuture, 1, "A Central device credential location cannot be found.");
                return callbackfuture;
            }
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "bind");
            if (!(new BoundServiceCaller(bundle, callback, s) {

        final CentralDcpAuthenticationMethod this$0;
        final PlatformMetricsTimer val$bindTimer;
        final Callback val$callback;
        final CallbackFuture val$callbackFuture;
        final byte val$corpus[];
        final String val$directedId;
        final Bundle val$signCorpusOption;

        protected void serviceDisconnected()
        {
            MAPLog.e(CentralDcpAuthenticationMethod.TAG, "AuthenticatedRequestService is disconnected. It's probably crashed.");
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 1, "AuthenticatedRequestService is disconnected. It's probably crashed.");
        }

        protected void useService(IBinder ibinder)
        {
            String s1;
            PlatformMetricsTimer platformmetricstimer1;
            s1 = null;
            bindTimer.stop();
            platformmetricstimer1 = MetricsHelper.startVerboseTimer(CentralDcpAuthenticationMethod.METRICS_COMPONENT_NAME, "signCorpusByDirectedIdWrapper");
            byte abyte1[];
            IRequestAuthenticationMethod irequestauthenticationmethod;
            abyte1 = corpus;
            irequestauthenticationmethod = com.amazon.dcp.sso.IRequestAuthenticationMethod.Stub.asInterface(ibinder);
            if (!getFeatureSet().hasFeature(Feature.DirectedIdSupported)) goto _L2; else goto _L1
_L1:
            ibinder = irequestauthenticationmethod.signCorpusByDirectedId("SHA256WithRSA", directedId, abyte1);
_L3:
            CentralDcpAuthenticationMethod.TAG;
            CentralDcpAuthenticationMethod.access$300(CentralDcpAuthenticationMethod.this, ibinder, callbackFuture, corpus, signCorpusOption, callback);
            platformmetricstimer1.stop();
            unbind();
            return;
_L2:
            Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, directedId);
            if (account == null)
            {
                break MISSING_BLOCK_LABEL_154;
            }
            ibinder = account.type;
_L4:
            if (account == null)
            {
                break MISSING_BLOCK_LABEL_137;
            }
            s1 = account.name;
            ibinder = irequestauthenticationmethod.signCorpus("SHA256WithRSA", ibinder, s1, abyte1);
              goto _L3
            ibinder = null;
              goto _L4
            ibinder;
            MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Cannot receive corpus authentication from dcp! Connection to DCP has been lost.", ibinder);
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 1, "Cannot receive corpus authentication from dcp! Connection to DCP has been lost.");
            platformmetricstimer1.stop();
            unbind();
            return;
            ibinder;
            MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Unknown error during signCorpus execution.", ibinder);
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 5, ibinder.toString());
            platformmetricstimer1.stop();
            unbind();
            return;
            ibinder;
            platformmetricstimer1.stop();
            unbind();
            throw ibinder;
              goto _L3
        }

            
            {
                this$0 = CentralDcpAuthenticationMethod.this;
                bindTimer = platformmetricstimer;
                corpus = abyte0;
                callbackFuture = callbackfuture;
                signCorpusOption = bundle;
                callback = callback1;
                directedId = s;
                super(final_context, final_intent, final_i);
            }
    }).call())
            {
                MAPLog.e(TAG, "Failed to bind to AuthenticatedRequestService.");
                ADPCorpusSigningCallbackHelpers.callbackError(callbackfuture, 1, "Failed to bind to AuthenticatedRequestService.");
                return callbackfuture;
            }
        }
        return callbackfuture;
    }

    private void throwIfOnMainThread(String s)
    {
        long l = Looper.getMainLooper().getThread().getId();
        if (Thread.currentThread().getId() == l)
        {
            throw new IllegalStateException(s);
        } else
        {
            return;
        }
    }

    protected MAPFuture getAuthenticationBundle(Uri uri, String s, Map map, byte abyte0[], CallbackFuture callbackfuture)
        throws IOException
    {
        throwIfOnMainThread("You cannot authenticate this request on the main thread!");
        AuthenticatedRequestServiceIntentFactory authenticatedrequestserviceintentfactory = AuthenticatedRequestServiceIntentFactory.findAuthRequestService(mContext);
        if (authenticatedrequestserviceintentfactory == null)
        {
            AuthenticationMethod.callbackError(callbackfuture, 1, "A Central device credential location cannot be found");
            throw new IOException("A Central device credential location cannot be found");
        }
        AtomicReference atomicreference = new AtomicReference();
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "bind");
        (new SyncBoundServiceCaller(map, abyte0, atomicreference) {

            final CentralDcpAuthenticationMethod this$0;
            final PlatformMetricsTimer val$bindTimer;
            final byte val$body[];
            final Map val$headers;
            final AtomicReference val$requestAuthVal;
            final Uri val$serviceUri;
            final String val$verb;

            protected void useService(IBinder ibinder)
            {
                PlatformMetricsTimer platformmetricstimer1;
                bindTimer.stop();
                platformmetricstimer1 = MetricsHelper.startVerboseTimer(CentralDcpAuthenticationMethod.METRICS_COMPONENT_NAME, "getAuthenticationParams");
                byte abyte1[];
                Object obj;
                Object obj1;
                Uri uri1;
                String s1;
                IRequestAuthenticationMethod irequestauthenticationmethod;
                String s2;
                uri1 = serviceUri;
                s1 = verb;
                obj = headers;
                abyte1 = body;
                irequestauthenticationmethod = com.amazon.dcp.sso.IRequestAuthenticationMethod.Stub.asInterface(ibinder);
                s2 = getAuthenticationType();
                obj1 = getAccount();
                ibinder = Collections.EMPTY_MAP;
                if (!AuthenticationType.OAuth.getValue().equals(s2))
                {
                    ibinder = ((IBinder) (obj));
                } else
                {
                    abyte1 = new byte[0];
                }
                if (!getFeatureSet().hasFeature(Feature.DirectedIdSupported)) goto _L2; else goto _L1
_L1:
                ibinder = irequestauthenticationmethod.getAuthenticationParametersForRequestByDirectedId(s2, ((String) (obj1)), uri1, s1, ibinder, abyte1);
_L5:
                CentralDcpAuthenticationMethod.TAG;
                requestAuthVal.set(ibinder);
                platformmetricstimer1.stop();
                doneUsingService();
                return;
_L2:
                obj1 = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, ((String) (obj1)));
                if (obj1 == null) goto _L4; else goto _L3
_L3:
                obj = ((Account) (obj1)).type;
_L6:
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_203;
                }
                obj1 = ((Account) (obj1)).name;
_L7:
                ibinder = irequestauthenticationmethod.getAuthenticationParametersForRequest(s2, ((String) (obj)), ((String) (obj1)), uri1, s1, ibinder, abyte1);
                  goto _L5
_L4:
                obj = null;
                  goto _L6
                obj1 = null;
                  goto _L7
                ibinder;
                MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Could not receive request authentication from dcp!", ibinder);
                ibinder = new ReturnValueOrError(6, "Connection to DCP has been lost");
                requestAuthVal.set(ibinder);
                platformmetricstimer1.stop();
                doneUsingService();
                return;
                ibinder;
                MAPLog.e(CentralDcpAuthenticationMethod.TAG, "Unknown error during getAuthenticationBundle execution.", ibinder);
                ibinder = new ReturnValueOrError(5, ibinder.toString());
                requestAuthVal.set(ibinder);
                platformmetricstimer1.stop();
                doneUsingService();
                return;
                ibinder;
                requestAuthVal.set(null);
                platformmetricstimer1.stop();
                doneUsingService();
                throw ibinder;
                  goto _L5
            }

            
            {
                this$0 = CentralDcpAuthenticationMethod.this;
                bindTimer = platformmetricstimer;
                serviceUri = uri;
                verb = s;
                headers = map;
                body = abyte0;
                requestAuthVal = atomicreference;
                super(final_context, final_intent, final_i);
            }
        }).run(Long.valueOf(AuthenticatedRequestHelpers.DEFAULT_CONNECT_TO_SSO_TIMEOUT), TimeUnit.MILLISECONDS, "GetAuthenticationParameters");
        uri = (ReturnValueOrError)atomicreference.get();
        if (uri == null)
        {
            AuthenticationMethod.callbackError(callbackfuture, 1, "Connection to SSO timeout");
            throw new IOException("Connection to SSO timeout");
        }
        if (!uri.isError())
        {
            uri = uri.getResponse();
            if (callbackfuture != null && uri != null)
            {
                callbackfuture.onSuccess(uri);
            }
            return callbackfuture;
        }
        s = uri.getResponseMessage();
        switch (uri.getResponseCode())
        {
        case 4: // '\004'
        default:
            AuthenticationMethod.callbackError(callbackfuture, 6, s);
            throw new IllegalArgumentException(s);

        case 2: // '\002'
            KeyFactoryUtils.recordDMSCredentialErrorAndCallDeregisterIfNecessary(mContext, s);
            AuthenticationMethod.callbackError(callbackfuture, 2, s);
            throw new NoCredentialsException(s);

        case 6: // '\006'
            AuthenticationMethod.callbackError(callbackfuture, 1, s);
            throw new IOException(s);

        case 5: // '\005'
            AuthenticationMethod.callbackError(callbackfuture, 6, s);
            throw new RuntimeException(s);

        case 3: // '\003'
            AuthenticationMethod.callbackError(callbackfuture, 4, s);
            throw new IllegalArgumentException(s);
        }
    }

    public MAPFuture signCorpus(byte abyte0[], Bundle bundle, Callback callback)
    {
        return signCorpusWithDirectedId(abyte0, getAccount(), bundle, callback);
    }






/*
    static void access$300(CentralDcpAuthenticationMethod centraldcpauthenticationmethod, ReturnValueOrError returnvalueorerror, final CallbackFuture callbackFuture, byte abyte0[], Bundle bundle, Callback callback)
    {
        if (returnvalueorerror == null)
        {
            MAPLog.e(TAG, "Connection to SSO timedout.");
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 1, "Connection to SSO timedout.");
            return;
        }
        if (!returnvalueorerror.isError())
        {
            returnvalueorerror = returnvalueorerror.getResponse();
            centraldcpauthenticationmethod = returnvalueorerror.getString("token");
            returnvalueorerror = returnvalueorerror.getString("digest");
            abyte0 = new Bundle();
            abyte0.putString("adp_token", centraldcpauthenticationmethod);
            abyte0.putString("adp_signature", returnvalueorerror);
            callbackFuture.onSuccess(abyte0);
            return;
        }
        callback = returnvalueorerror.getResponseMessage();
        switch (returnvalueorerror.getResponseCode())
        {
        case 5: // '\005'
        default:
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 5, callback);
            return;

        case 2: // '\002'
            if (bundle != null && bundle.getBoolean("UseFallBackCredentials", false))
            {
                centraldcpauthenticationmethod.signCorpusWithDirectedId(abyte0, centraldcpauthenticationmethod.mMapAccountManager.getAccount(), null, centraldcpauthenticationmethod. new _cls3());
                return;
            } else
            {
                ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 2, callback);
                return;
            }

        case 6: // '\006'
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 1, callback);
            return;

        case 3: // '\003'
        case 4: // '\004'
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 3, callback);
            return;
        }
    }

*/
}

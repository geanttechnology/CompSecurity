// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.AuthenticatedURLConnection;
import com.amazon.identity.auth.device.api.AuthenticationAwareHttpClient;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.callback.PendingRequestCallbackHolder;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementDefinition, OAuthTokenManager, MAPCookieManager, ServerRegistrationSyncHelper, 
//            TokenCallbackHelpers

public class TokenManagementLogic
    implements TokenManagementDefinition
{
    private class _cls4
        implements Callback
    {

        final TokenManagementLogic this$0;

        public void onError(Bundle bundle)
        {
            MAPLog.e(TokenManagementLogic.TAG, "Registration check failed. This does not mean the device deregistered, this can happen if the network call failed.  Also this will not ever be raised to an application calling one of our apis as this is a background task to check the serverside registration state.");
        }

        public void onSuccess(Bundle bundle)
        {
            MAPLog.i(TokenManagementLogic.TAG, "Registration check succeeded.");
        }

        _cls4()
        {
            this$0 = TokenManagementLogic.this;
            super();
        }
    }

    private class _cls3
        implements Runnable
    {

        final TokenManagementLogic this$0;
        final String val$directedId;
        final KeyInfo val$keyInfo;
        final Tracer val$tracer;

        public void run()
        {
            getToken(directedId, TokenKeys.getAccessTokenKeyForPackage(keyInfo.getPackageName()), new Bundle(), new _cls4(), tracer);
        }

        _cls3()
        {
            this$0 = TokenManagementLogic.this;
            directedId = s;
            keyInfo = keyinfo;
            tracer = tracer1;
            super();
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/token/TokenManagementLogic.getName();
    private static TokenManagementLogic sTheOneAndTheOnly;
    private final Context mContext;
    private final Executor mExecutor;
    private final LocalAppDataAwareDataStorage mLocalAppDataAwareDataStorage;
    private final MAPCookieManager mMAPCookieManager;
    private final OAuthTokenManager mOAuthTokenManager;
    private final PendingRequestCallbackHolder mPendingRequestCallbackHolder;
    private final ServerRegistrationSyncHelper mServerRegSync;

    TokenManagementLogic(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        BackwardsCompatiableDataStorage backwardscompatiabledatastorage = new BackwardsCompatiableDataStorage(mContext);
        mLocalAppDataAwareDataStorage = new LocalAppDataAwareDataStorage(mContext, backwardscompatiabledatastorage);
        mOAuthTokenManager = new OAuthTokenManager(context);
        mMAPCookieManager = new MAPCookieManager(context);
        mPendingRequestCallbackHolder = new PendingRequestCallbackHolder();
        mServerRegSync = new ServerRegistrationSyncHelper(mContext, mLocalAppDataAwareDataStorage);
        mExecutor = ThreadUtils.MAP_COMMON_THREAD_POOL;
    }

    TokenManagementLogic(Context context, LocalAppDataAwareDataStorage localappdataawaredatastorage, OAuthTokenManager oauthtokenmanager, MAPCookieManager mapcookiemanager, Executor executor)
    {
        mContext = ServiceWrappingContext.create(context);
        mLocalAppDataAwareDataStorage = localappdataawaredatastorage;
        mOAuthTokenManager = oauthtokenmanager;
        mMAPCookieManager = mapcookiemanager;
        mPendingRequestCallbackHolder = new PendingRequestCallbackHolder();
        mServerRegSync = new ServerRegistrationSyncHelper(mContext, mLocalAppDataAwareDataStorage);
        mExecutor = executor;
    }

    public static TokenManagementLogic getInstance(Context context)
    {
        com/amazon/identity/auth/device/token/TokenManagementLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new TokenManagementLogic(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/token/TokenManagementLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public MAPFuture getCookies(final String directedId, final String domain, final Bundle options, final Callback callbackFuture, final Tracer tracer)
    {
        String s = TAG;
        callbackFuture = new CallbackFuture(callbackFuture);
        mExecutor.execute(new Runnable() {

            final TokenManagementLogic this$0;
            final CallbackFuture val$callbackFuture;
            final String val$directedId;
            final String val$domain;
            final Bundle val$options;
            final Tracer val$tracer;

            public void run()
            {
                if (options == null)
                {
                    getAuthCookies(directedId, domain, new Bundle(), callbackFuture, tracer);
                    return;
                } else
                {
                    getAuthCookies(directedId, domain, options, callbackFuture, tracer);
                    return;
                }
            }

            
            {
                this$0 = TokenManagementLogic.this;
                options = bundle;
                directedId = s;
                domain = s1;
                callbackFuture = callbackfuture;
                tracer = tracer1;
                super();
            }
        });
        return callbackFuture;
    }

    public MAPFuture getToken(final String directedId, final String token, final Bundle options, final Callback callbackFuture, final Tracer tracer)
    {
        Object obj = TAG;
        (new StringBuilder("Getting token ")).append(token).toString();
        callbackFuture = new CallbackFuture(callbackFuture);
        if (TextUtils.isEmpty(directedId))
        {
            MAPLog.e(TAG, "Directed Id given was null. Cannot get tokens for a deregistered device");
            TokenCallbackHelpers.onAccountManagerError(callbackFuture, 8, "Directed Id given was null. Cannot get tokens for a deregistered device");
            return callbackFuture;
        }
        if (TextUtils.isEmpty(token))
        {
            MAPLog.e(TAG, "Token key was empty.");
            TokenCallbackHelpers.onAccountManagerError(callbackFuture, 8, "Token key was empty.");
            return callbackFuture;
        }
        obj = mPendingRequestCallbackHolder.waitForInflightRequestOrMakeRequest(String.format("%s#%s", new Object[] {
            directedId, token
        }), callbackFuture);
        if (obj == null)
        {
            directedId = TAG;
            String.format("Get token for type %s is already in flight.", new Object[] {
                token
            });
            return callbackFuture;
        } else
        {
            callbackFuture = new CallbackFuture(((Callback) (obj)));
            mExecutor.execute(new Runnable() {

                final TokenManagementLogic this$0;
                final CallbackFuture val$callbackFuture;
                final String val$directedId;
                final Bundle val$options;
                final String val$token;
                final Tracer val$tracer;

                public void run()
                {
                    KeyInfo keyinfo = KeyInfo.parseKey(token);
                    if (this = <no variable>.getKey())
                    {
                        if (TokenManagementLogic.access$100(TokenManagementLogic.this, keyinfo, options))
                        {
                            TokenCallbackHelpers.onAccountManagerError(callbackFuture, 7, String.format("Cannot get central DMS Credentials. Please use %s or %s .", new Object[] {
                                com/amazon/identity/auth/device/api/AuthenticatedURLConnection.getName(), com/amazon/identity/auth/device/api/AuthenticationAwareHttpClient.getName()
                            }));
                            return;
                        } else
                        {
                            TokenManagementLogic.access$200(TokenManagementLogic.this, directedId, keyinfo, tracer);
                            TokenCallbackHelpers.callbackSuccess(TokenManagementLogic.this, directedId, keyinfo, callbackFuture);
                            return;
                        }
                    }
                    if (equals(keyinfo))
                    {
                        TokenManagementLogic.access$500(TokenManagementLogic.this, directedId, keyinfo, options, callbackFuture, tracer);
                        return;
                    }
                    if (equals(keyinfo))
                    {
                        TokenCallbackHelpers.callbackSuccess(TokenManagementLogic.this, directedId, keyinfo, callbackFuture);
                        return;
                    } else
                    {
                        String s2 = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = TokenManagementLogic.this;
                token = s;
                options = bundle;
                callbackFuture = callbackfuture;
                directedId = s1;
                tracer = tracer1;
                super();
            }
            });
            return callbackFuture;
        }
    }



/*
    static boolean access$000(TokenManagementLogic tokenmanagementlogic, KeyInfo keyinfo)
    {
        tokenmanagementlogic = keyinfo.getKey();
        return "com.amazon.dcp.sso.token.device.adptoken".equals(tokenmanagementlogic) || "com.amazon.dcp.sso.token.device.privatekey".equals(tokenmanagementlogic);
    }

*/


/*
    static boolean access$100(TokenManagementLogic tokenmanagementlogic, KeyInfo keyinfo, Bundle bundle)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            if (bundle != null)
            {
                flag = flag1;
                if (bundle.getBoolean("ignore.platform.restrictions", false))
                {
                    break label0;
                }
            }
            if (keyinfo.getPackageName() != null)
            {
                flag = flag1;
                if (!DeviceTypeHelpers.isPackageUsingCentralDeviceType(tokenmanagementlogic.mContext, keyinfo.getPackageName()))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

*/




/*
    static void access$200(TokenManagementLogic tokenmanagementlogic, final String directedId, final KeyInfo keyInfo, final Tracer tracer)
    {
        if (tokenmanagementlogic.mServerRegSync.shouldDoRegistrationCheck(directedId))
        {
            MAPLog.i(TAG, "Start to do registration check.");
            ThreadUtils.submitToBackgroundThread(tokenmanagementlogic. new _cls3());
        }
        return;
    }

*/




/*
    static void access$500(TokenManagementLogic tokenmanagementlogic, String s, KeyInfo keyinfo, Bundle bundle, Callback callback, Tracer tracer)
    {
        try
        {
            TokenCallbackHelpers.callbackSuccess(callback, tokenmanagementlogic.mOAuthTokenManager.getAccessToken(s, keyinfo, bundle, tracer));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TokenManagementLogic tokenmanagementlogic)
        {
            MAPLog.e(TAG, "Received an error when calling getOAuthAccessToken. ErrorCode: %d ErrorMessage: %s ", new Object[] {
                Integer.valueOf(tokenmanagementlogic.getErrorCode()), tokenmanagementlogic.getErrorMsg()
            });
        }
        TokenCallbackHelpers.callbackError(callback, tokenmanagementlogic.getErrorCode(), tokenmanagementlogic.getMessage());
        return;
    }

*/




/*
    static void access$800(TokenManagementLogic tokenmanagementlogic, String s, String s1, CallbackFuture callbackfuture, KeyInfo keyinfo)
    {
        String s2 = TAG;
        tokenmanagementlogic = tokenmanagementlogic.mLocalAppDataAwareDataStorage.getToken(s, keyinfo.getRawKey());
        if (TextUtils.isEmpty(tokenmanagementlogic))
        {
            TokenCallbackHelpers.onAccountManagerError(callbackfuture, 7, String.format("Token key %s is not recognized", new Object[] {
                s1
            }));
            return;
        } else
        {
            TokenCallbackHelpers.callbackSuccess(callbackfuture, tokenmanagementlogic);
            return;
        }
    }

*/

}

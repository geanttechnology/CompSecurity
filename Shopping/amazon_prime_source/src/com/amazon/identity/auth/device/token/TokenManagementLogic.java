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
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
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
    private final ServiceWrappingContext mContext;
    private final Executor mExecutor;
    private final LocalAppDataAwareDataStorage mLocalAppDataAwareDataStorage;
    private final MAPCookieManager mMAPCookieManager;
    private final OAuthTokenManager mOAuthTokenManager;
    private final PendingRequestCallbackHolder mPendingRequestCallbackHolder = new PendingRequestCallbackHolder();
    private final ServerRegistrationSyncHelper mServerRegSync;

    TokenManagementLogic(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        BackwardsCompatiableDataStorage backwardscompatiabledatastorage = new BackwardsCompatiableDataStorage(mContext);
        mLocalAppDataAwareDataStorage = new LocalAppDataAwareDataStorage(mContext, backwardscompatiabledatastorage);
        mOAuthTokenManager = new OAuthTokenManager(context);
        mMAPCookieManager = new MAPCookieManager(context);
        mServerRegSync = new ServerRegistrationSyncHelper(mContext, mLocalAppDataAwareDataStorage);
        mExecutor = ThreadUtils.MAP_COMMON_THREAD_POOL;
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

    public MAPFuture getCookies(final String directedId, final String domain, final Bundle nonNullOptions, final Callback callbackFuture, final Tracer tracer)
    {
        callbackFuture = new CallbackFuture(callbackFuture);
        if (nonNullOptions == null)
        {
            nonNullOptions = new Bundle();
        }
        mExecutor.execute(new Runnable() {

            final TokenManagementLogic this$0;
            final CallbackFuture val$callbackFuture;
            final String val$directedId;
            final String val$domain;
            final Bundle val$nonNullOptions;
            final Tracer val$tracer;

            public void run()
            {
                TokenManagementLogic.access$900(TokenManagementLogic.this, directedId, domain, nonNullOptions, callbackFuture, tracer);
            }

            
            {
                this$0 = TokenManagementLogic.this;
                directedId = s;
                domain = s1;
                nonNullOptions = bundle;
                callbackFuture = callbackfuture;
                tracer = tracer1;
                super();
            }
        });
        return callbackFuture;
    }

    public MAPFuture getToken(final String directedId, final String token, final Bundle options, Callback callback1, final Tracer tracer)
    {
        callback1 = new CallbackFuture(callback1);
        if (TextUtils.isEmpty(directedId))
        {
            MAPLog.e(TAG, "Directed Id used in getToken is null or empty");
            TokenCallbackHelpers.onAccountManagerError(callback1, 8, "Directed Id used in getToken is null or empty");
            return callback1;
        }
        if (TextUtils.isEmpty(token))
        {
            MAPLog.e(TAG, "Token key used in getToken is null or empty.");
            TokenCallbackHelpers.onAccountManagerError(callback1, 8, "Token key used in getToken is null or empty.");
            return callback1;
        }
        final Callback callback = mPendingRequestCallbackHolder.waitForInflightRequestOrMakeRequest(String.format("%s#%s", new Object[] {
            directedId, token
        }), callback1);
        if (callback == null)
        {
            String.format("Get token for type %s is already in flight.", new Object[] {
                token
            });
            return callback1;
        } else
        {
            mExecutor.execute(new Runnable() {

                final TokenManagementLogic this$0;
                final Callback val$callback;
                final String val$directedId;
                final Bundle val$options;
                final String val$token;
                final Tracer val$tracer;

                public void run()
                {
                    KeyInfo keyinfo = KeyInfo.parseKey(token);
                    if (this = this.getKey())
                    {
                        if (TokenManagementLogic.access$100(TokenManagementLogic.this, keyinfo, options))
                        {
                            TokenCallbackHelpers.onAccountManagerError(callback, 7, String.format("Apps using the central device type are not permitted to retrieve the central ADP token. Please use %s or %s instead to authenticate a request with ADP.", new Object[] {
                                com/amazon/identity/auth/device/api/AuthenticatedURLConnection.getName(), com/amazon/identity/auth/device/api/AuthenticationAwareHttpClient.getName()
                            }));
                            return;
                        } else
                        {
                            TokenManagementLogic.access$200(TokenManagementLogic.this, directedId, keyinfo, tracer);
                            TokenCallbackHelpers.callbackSuccess(TokenManagementLogic.this, directedId, keyinfo, callback);
                            return;
                        }
                    }
                    if (keyinfo.equals())
                    {
                        TokenManagementLogic.access$500(TokenManagementLogic.this, directedId, keyinfo, options, callback, tracer);
                        return;
                    }
                    if (keyinfo.equals())
                    {
                        TokenCallbackHelpers.callbackSuccess(TokenManagementLogic.this, directedId, keyinfo, callback);
                        return;
                    } else
                    {
                        this = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = TokenManagementLogic.this;
                token = s;
                options = bundle;
                callback = callback1;
                directedId = s1;
                tracer = tracer1;
                super();
            }
            });
            return callback1;
        }
    }



/*
    static boolean access$000$21e8abb6(KeyInfo keyinfo)
    {
        keyinfo = keyinfo.getKey();
        return "com.amazon.dcp.sso.token.device.adptoken".equals(keyinfo) || "com.amazon.dcp.sso.token.device.privatekey".equals(keyinfo);
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
            flag = flag1;
            if (DeviceTypeHelpers.isIsolatedAppOverridingDeviceType(tokenmanagementlogic.mContext))
            {
                break label0;
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
            MAPLog.formattedError(TAG, "Received an error when calling getOAuthAccessToken. ErrorCode: %d ErrorMessage: %s ", new Object[] {
                Integer.valueOf(tokenmanagementlogic.getErrorCode()), tokenmanagementlogic.getErrorMsg()
            });
        }
        TokenCallbackHelpers.callbackError(callback, tokenmanagementlogic.getErrorCode(), tokenmanagementlogic.getMessage());
        return;
    }

*/




/*
    static void access$800(TokenManagementLogic tokenmanagementlogic, String s, String s1, Callback callback, KeyInfo keyinfo)
    {
        tokenmanagementlogic = tokenmanagementlogic.mLocalAppDataAwareDataStorage.getToken(s, keyinfo.getRawKey());
        if (TextUtils.isEmpty(tokenmanagementlogic))
        {
            TokenCallbackHelpers.onAccountManagerError(callback, 7, String.format("Token key %s is not recognized", new Object[] {
                s1
            }));
            return;
        } else
        {
            TokenCallbackHelpers.callbackSuccess(callback, tokenmanagementlogic);
            return;
        }
    }

*/


/*
    static void access$900(TokenManagementLogic tokenmanagementlogic, String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        try
        {
            callback.onSuccess(tokenmanagementlogic.mMAPCookieManager.getAuthCookies(s, s1, bundle, tracer));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TokenManagementLogic tokenmanagementlogic)
        {
            callback.onError(tokenmanagementlogic.getErrorBundle());
        }
        return;
    }

*/
}

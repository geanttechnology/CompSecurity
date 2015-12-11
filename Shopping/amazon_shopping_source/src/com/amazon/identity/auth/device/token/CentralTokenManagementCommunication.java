// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.GenericIPCSender;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.storage.StorageKeyUtils;
import com.amazon.identity.auth.device.storage.TokenCacheHolder;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementDefinition, TokenCache, OAuthTokenManager, TokenManagementLogic, 
//            TokenCallbackHelpers

public class CentralTokenManagementCommunication
    implements TokenManagementDefinition
{
    private class _cls2
        implements TokenCache.Listener
    {

        final CentralTokenManagementCommunication this$0;
        final String val$baseTokenKey;
        final CallbackFuture val$callbackFuture;
        final String val$directedId;
        final boolean val$firstTimeFixCentralToken;
        final KeyInfo val$keyInfo;
        final TokenCache val$tokenCache;

        public void failure(String s, int i, String s1)
        {
            TokenCallbackHelpers.onAccountManagerError(callbackFuture, i, s1);
        }

        public void failure(String s, Bundle bundle)
        {
            callbackFuture.onError(bundle);
        }

        public void success()
        {
            String s = tokenCache.getToken(baseTokenKey);
            LocalAppDataAwareDataStorage localappdataawaredatastorage = new LocalAppDataAwareDataStorage(mContext);
            String s1 = StorageKeyUtils.getKeyWithPackageNamespace(keyInfo.getPackageName(), "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at");
            HashMap hashmap = new HashMap();
            hashmap.put(s1, Long.toString(System.currentTimeMillis()));
            localappdataawaredatastorage.setTokens(directedId, hashmap);
            TokenCallbackHelpers.callbackSuccess(callbackFuture, s);
            if (firstTimeFixCentralToken)
            {
                localappdataawaredatastorage.setUserData(directedId, "force_refresh_dms_to_oauth_done_once", "true");
                MetricsHelper.increasePeriodicCounter("fixCentralTokenOnGrover/Canary", new String[0]);
            }
        }

        _cls2()
        {
            this$0 = CentralTokenManagementCommunication.this;
            tokenCache = tokencache;
            baseTokenKey = s;
            keyInfo = keyinfo;
            directedId = s1;
            callbackFuture = callbackfuture;
            firstTimeFixCentralToken = flag;
            super();
        }
    }

    public static class GetCookiesCommand
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directed_id";
        public static final String KEY_DOMAIN = "domain";
        public static final String KEY_OPTIONS = "options_key";

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directed_id", s);
            bundle1.putString("domain", s1);
            bundle1.putBundle("options_key", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            String s;
            String s1;
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            s = bundle.getString("directed_id");
            s1 = bundle.getString("domain");
            bundle1 = bundle.getBundle("options_key");
            bundle = Tracer.createFromBundle(bundle, "TokenManagement:GetCookies");
            callback = MetricsHelper.wrapCallback(bundle, callback);
            TokenManagementLogic.getInstance(context).getCookies(s, s1, bundle1, callback, bundle);
            return null;
        }

        public GetCookiesCommand()
        {
        }
    }

    public static class GetTokenCommand
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directed_id";
        public static final String KEY_OPTIONS = "options_key";
        public static final String KEY_TOKEN = "token_key";

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directed_id", s);
            bundle1.putString("token_key", s1);
            bundle1.putBundle("options_key", bundle);
            return bundle1;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            String s;
            String s1;
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            s = bundle.getString("directed_id");
            s1 = bundle.getString("token_key");
            bundle1 = bundle.getBundle("options_key");
            bundle = Tracer.createFromBundle(bundle, "TokenManagement:GetToken");
            callback = MetricsHelper.wrapCallback(bundle, callback);
            TokenManagementLogic.getInstance(context).getToken(s, s1, bundle1, callback, bundle);
            return null;
        }

        public GetTokenCommand()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/token/CentralTokenManagementCommunication.getName();
    private final ServiceWrappingContext mContext;
    private final GenericIPCSender mGenericIpcSender;
    private OAuthTokenManager mOAuthTokenManager;

    public CentralTokenManagementCommunication(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mGenericIpcSender = new GenericIPCSender(mContext, "com.amazon.dcp.sso.ErrorCode", "com.amazon.dcp.sso.ErrorMessage", Integer.valueOf(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value()));
    }

    private void invalidateAccessToken(String s, TokenCache tokencache)
    {
        tokencache = tokencache.getToken("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        BackwardsCompatiabilityHelper.expireTokenValue(mContext, s, tokencache);
    }

    public MAPFuture getCookies(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        if (PlatformUtils.isPostMergeDevice(mContext))
        {
            callback = new CallbackFuture(callback);
            mGenericIpcSender.call(com/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetCookiesCommand, GetCookiesCommand.parametersToBundle(s, s1, bundle, tracer), callback);
            return callback;
        } else
        {
            return TokenManagementLogic.getInstance(mContext).getCookies(s, s1, bundle, callback, tracer);
        }
    }

    public MAPFuture getToken(final String directedId, final String token, final Bundle options, final Callback callbackFuture, final Tracer account)
    {
        boolean flag1 = false;
        if (PlatformUtils.isPostMergeDevice(mContext))
        {
            callbackFuture = new CallbackFuture(callbackFuture);
            mGenericIpcSender.call(com/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetTokenCommand, GetTokenCommand.parametersToBundle(directedId, token, options), callbackFuture);
            return callbackFuture;
        }
        boolean flag;
        if (PlatformUtils.isOtter(mContext))
        {
            flag = flag1;
        } else
        {
            KeyInfo keyinfo = KeyInfo.parseKey(token);
            flag = flag1;
            if ("com.amazon.dcp.sso.token.oauth.amazon.access_token".equals(keyinfo.getKey()))
            {
                flag = flag1;
                if (DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, keyinfo.getPackageName()))
                {
                    flag = PlatformUtils.isPreMergeDevice(mContext);
                }
            }
        }
        if (flag)
        {
            callbackFuture = new CallbackFuture(callbackFuture);
            account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, directedId);
            if (account == null)
            {
                callbackFuture.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NO_ACCOUNT.value(), "Given Customer Does not exist"));
                return callbackFuture;
            }
            if (TextUtils.isEmpty(token))
            {
                callbackFuture.onError(TokenCallbackHelpers.getErrorBundle(8, "Token key was empty."));
                return callbackFuture;
            } else
            {
                ThreadUtils.submitToBackgroundThread(new Runnable() {

                    final CentralTokenManagementCommunication this$0;
                    final Account val$account;
                    final CallbackFuture val$callbackFuture;
                    final String val$directedId;
                    final Bundle val$options;
                    final String val$token;

                    public void run()
                    {
                        CentralTokenManagementCommunication.access$000(CentralTokenManagementCommunication.this, token, account, directedId, options, callbackFuture);
                    }

            
            {
                this$0 = CentralTokenManagementCommunication.this;
                token = s;
                account = account1;
                directedId = s1;
                options = bundle;
                callbackFuture = callbackfuture;
                super();
            }
                });
                return callbackFuture;
            }
        } else
        {
            return TokenManagementLogic.getInstance(mContext).getToken(directedId, token, options, callbackFuture, account);
        }
    }



/*
    static void access$000(CentralTokenManagementCommunication centraltokenmanagementcommunication, final String keyInfo, final Account tokenCache, final String directedId, final Bundle baseTokenKey, final CallbackFuture callbackFuture)
    {
        keyInfo = KeyInfo.parseKey(keyInfo);
        tokenCache = TokenCacheHolder.getInstance(centraltokenmanagementcommunication.mContext).getTokenCache(tokenCache);
        final boolean firstTimeFixCentralToken;
        if (!TextUtils.equals("true", centraltokenmanagementcommunication.mContext.getDataStorage().getUserData(directedId, "force_refresh_dms_to_oauth_done_once")))
        {
            firstTimeFixCentralToken = true;
        } else
        {
            firstTimeFixCentralToken = false;
        }
        if (!TextUtils.equals(keyInfo.getKey(), "com.amazon.dcp.sso.token.oauth.amazon.access_token")) goto _L2; else goto _L1
_L1:
        if (!firstTimeFixCentralToken && (baseTokenKey == null || !baseTokenKey.getBoolean("com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshDMSTokenForOAuthToken"))) goto _L4; else goto _L3
_L3:
        centraltokenmanagementcommunication.invalidateAccessToken(directedId, tokenCache);
        baseTokenKey = tokenCache.getToken("com.amazon.dcp.sso.token.oauth.amazon.refresh_token");
        BackwardsCompatiabilityHelper.expireTokenValue(centraltokenmanagementcommunication.mContext, directedId, baseTokenKey);
_L2:
        baseTokenKey = keyInfo.getKey();
        centraltokenmanagementcommunication = centraltokenmanagementcommunication. new _cls2();
        tokenCache.fetchTokens(new String[] {
            baseTokenKey
        }, centraltokenmanagementcommunication);
        return;
_L4:
        if (centraltokenmanagementcommunication.mOAuthTokenManager == null)
        {
            centraltokenmanagementcommunication.mOAuthTokenManager = new OAuthTokenManager(centraltokenmanagementcommunication.mContext);
        }
        if (centraltokenmanagementcommunication.mOAuthTokenManager.shouldRefreshExistingAccessToken(directedId, keyInfo, baseTokenKey))
        {
            centraltokenmanagementcommunication.invalidateAccessToken(directedId, tokenCache);
        }
        if (true) goto _L2; else goto _L5
_L5:
        return;
    }

*/

}

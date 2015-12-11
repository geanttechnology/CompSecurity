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
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementDefinition, OAuthTokenManager, TokenCache, TokenManagementLogic, 
//            TokenCallbackHelpers

public class AMTokenManagementCommunication
    implements TokenManagementDefinition
{
    private class _cls2
        implements TokenCache.Listener
    {

        final AMTokenManagementCommunication this$0;
        final String val$baseTokenKey;
        final CallbackFuture val$callbackFuture;
        final String val$directedId;
        final boolean val$firstTimeFixCentralToken;
        final KeyInfo val$keyInfo;
        final TokenCache val$tokenCache;

        public void failure$2498c652(int i, String s)
        {
            TokenCallbackHelpers.onAccountManagerError(callbackFuture, i, s);
        }

        public void failure$5dc9c75(Bundle bundle)
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
                MetricsHelper.incrementCounter("fixCentralTokenOnGrover/Canary", new String[0]);
            }
        }

        _cls2()
        {
            this$0 = AMTokenManagementCommunication.this;
            tokenCache = tokencache;
            baseTokenKey = s;
            keyInfo = keyinfo;
            directedId = s1;
            callbackFuture = callbackfuture;
            firstTimeFixCentralToken = flag;
            super();
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/token/AMTokenManagementCommunication.getName();
    private final ServiceWrappingContext mContext;
    private OAuthTokenManager mOAuthTokenManager;

    public AMTokenManagementCommunication(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mOAuthTokenManager = new OAuthTokenManager(mContext);
    }

    private void invalidateAccessToken(String s, TokenCache tokencache)
    {
        tokencache = tokencache.getToken("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        BackwardsCompatiabilityHelper.expireTokenValue(mContext, s, tokencache);
    }

    public MAPFuture getCookies(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        return TokenManagementLogic.getInstance(mContext).getCookies(s, s1, bundle, callback, tracer);
    }

    public MAPFuture getToken(final String directedId, final String token, final Bundle options, final Callback callbackFuture, final Tracer account)
    {
        KeyInfo keyinfo = KeyInfo.parseKey(token);
        boolean flag;
        if ("com.amazon.dcp.sso.token.oauth.amazon.access_token".equals(keyinfo.getKey()) && DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, keyinfo.getPackageName()))
        {
            flag = true;
        } else
        {
            flag = false;
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

                    final AMTokenManagementCommunication this$0;
                    final Account val$account;
                    final CallbackFuture val$callbackFuture;
                    final String val$directedId;
                    final Bundle val$options;
                    final String val$token;

                    public void run()
                    {
                        AMTokenManagementCommunication.access$000(AMTokenManagementCommunication.this, token, account, directedId, options, callbackFuture);
                    }

            
            {
                this$0 = AMTokenManagementCommunication.this;
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
    static void access$000(AMTokenManagementCommunication amtokenmanagementcommunication, final String keyInfo, final Account tokenCache, final String directedId, final Bundle baseTokenKey, final CallbackFuture callbackFuture)
    {
        keyInfo = KeyInfo.parseKey(keyInfo);
        tokenCache = TokenCacheHolder.getInstance(amtokenmanagementcommunication.mContext).getTokenCache(tokenCache);
        final boolean firstTimeFixCentralToken;
        if (!TextUtils.equals("true", amtokenmanagementcommunication.mContext.getDataStorage().getUserData(directedId, "force_refresh_dms_to_oauth_done_once")))
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
        amtokenmanagementcommunication.invalidateAccessToken(directedId, tokenCache);
        baseTokenKey = tokenCache.getToken("com.amazon.dcp.sso.token.oauth.amazon.refresh_token");
        BackwardsCompatiabilityHelper.expireTokenValue(amtokenmanagementcommunication.mContext, directedId, baseTokenKey);
_L2:
        baseTokenKey = keyInfo.getKey();
        amtokenmanagementcommunication = amtokenmanagementcommunication. new _cls2();
        tokenCache.fetchTokens(new String[] {
            baseTokenKey
        }, amtokenmanagementcommunication);
        return;
_L4:
        if (amtokenmanagementcommunication.mOAuthTokenManager.shouldRefreshExistingAccessToken(directedId, keyInfo, baseTokenKey))
        {
            amtokenmanagementcommunication.invalidateAccessToken(directedId, tokenCache);
        }
        if (true) goto _L2; else goto _L5
_L5:
        return;
    }

*/

}

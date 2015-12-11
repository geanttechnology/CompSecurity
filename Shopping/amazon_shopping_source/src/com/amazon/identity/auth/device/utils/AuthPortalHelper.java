// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.os.Build;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.AmazonUrlConnectionHelpers;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.AuthErrorRetryLogic;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.storage.StorageKeyUtils;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.cookie.Cookie;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            BuildInfo, MAPLog, StreamUtils

public class AuthPortalHelper
{
    public static final class AuthTokenExchangeType extends Enum
    {

        private static final AuthTokenExchangeType $VALUES[];
        public static final AuthTokenExchangeType DMSTokenToOauthTokenExchange;
        public static final AuthTokenExchangeType OauthRefreshToAccessExchange;
        public static final AuthTokenExchangeType OauthRefreshToCookieExchange;
        public static final AuthTokenExchangeType OauthRefreshToDelegationAccessExchange;

        public static AuthTokenExchangeType valueOf(String s)
        {
            return (AuthTokenExchangeType)Enum.valueOf(com/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType, s);
        }

        public static AuthTokenExchangeType[] values()
        {
            return (AuthTokenExchangeType[])$VALUES.clone();
        }

        static 
        {
            DMSTokenToOauthTokenExchange = new AuthTokenExchangeType("DMSTokenToOauthTokenExchange", 0);
            OauthRefreshToAccessExchange = new AuthTokenExchangeType("OauthRefreshToAccessExchange", 1);
            OauthRefreshToCookieExchange = new AuthTokenExchangeType("OauthRefreshToCookieExchange", 2);
            OauthRefreshToDelegationAccessExchange = new AuthTokenExchangeType("OauthRefreshToDelegationAccessExchange", 3);
            $VALUES = (new AuthTokenExchangeType[] {
                DMSTokenToOauthTokenExchange, OauthRefreshToAccessExchange, OauthRefreshToCookieExchange, OauthRefreshToDelegationAccessExchange
            });
        }

        private AuthTokenExchangeType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String CUSTOM_USER_AGENT;
    private static final Set EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN = EnumSet.allOf(com/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType);
    private static final String TAG = com/amazon/identity/auth/device/utils/AuthPortalHelper.getName();
    private final AuthEndpointErrorParser mAuthEndpointErrorParser = new AuthEndpointErrorParser();
    private final LocalAppDataAwareDataStorage mLocalAppDataAwareDataStorage;

    public AuthPortalHelper(Context context)
    {
        mLocalAppDataAwareDataStorage = new LocalAppDataAwareDataStorage(context);
    }

    private void cleanRefreshToken(String s, String s1)
    {
        mLocalAppDataAwareDataStorage.expireToken(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
    }

    private boolean requireDeregisterAccount(AuthTokenExchangeType authtokenexchangetype, com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror)
    {
        return EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN.contains(authtokenexchangetype) && authendpointerror.getAuthTypeError() == com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.InvalidToken;
    }

    public com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError handleTokenExchangeError(String s, String s1, Callback callback, JSONObject jsonobject, int i, AuthTokenExchangeType authtokenexchangetype, MAPAccountManager mapaccountmanager)
    {
        String s2 = TAG;
        if (jsonobject != null)
        {
            s2 = jsonobject.toString();
        } else
        {
            s2 = "Null Json Response";
        }
        jsonobject = mAuthEndpointErrorParser.parse(jsonobject);
        if (jsonobject == null)
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), String.format("Received unrecongized error from the server with status code %d", new Object[] {
                Integer.valueOf(i)
            })));
            return null;
        }
        cleanRefreshToken(s, s1);
        if (requireDeregisterAccount(authtokenexchangetype, jsonobject) && mapaccountmanager != null)
        {
            mapaccountmanager.deregisterAccount(s, new CallbackFuture());
        }
        MAPLog.e(TAG, String.format("Received error code: %s \n Message: %s \n Detail: %s", new Object[] {
            jsonobject.getAuthTypeError().getCode(), jsonobject.getMessage(), jsonobject.getDetail()
        }));
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), String.format("Received Error code %s from the server. Message: %s .Detail: %s", new Object[] {
            jsonobject.getAuthTypeError().getCode(), jsonobject.getMessage(), jsonobject.getDetail()
        })));
        return jsonobject;
    }

    public com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError handleTokenExchangeError(String s, String s1, JSONObject jsonobject, int i, AuthTokenExchangeType authtokenexchangetype, MAPAccountManager mapaccountmanager)
    {
        String s2 = TAG;
        if (jsonobject != null)
        {
            s2 = jsonobject.toString();
        } else
        {
            s2 = "Null Json Response";
        }
        jsonobject = mAuthEndpointErrorParser.parse(jsonobject);
        if (jsonobject == null)
        {
            MAPLog.e(TAG, String.format("Received unrecongized error from the server with status code %d", new Object[] {
                Integer.valueOf(i)
            }));
            return null;
        }
        cleanRefreshToken(s, s1);
        if (requireDeregisterAccount(authtokenexchangetype, jsonobject) && mapaccountmanager != null)
        {
            mapaccountmanager.deregisterAccount(s, new CallbackFuture());
        }
        MAPLog.e(TAG, String.format("Received error code: %s \n Message: %s \n Detail: %s", new Object[] {
            jsonobject.getAuthTypeError().getCode(), jsonobject.getMessage(), jsonobject.getDetail()
        }));
        return jsonobject;
    }

    public boolean isFailure(int i)
    {
        return mAuthEndpointErrorParser.isFailure(i);
    }

    public HttpURLConnection startIdentityRequest(Context context, URL url, UrlEncodedFormEntity urlencodedformentity, boolean flag, List list, String s, String s1, 
            Tracer tracer)
        throws IOException
    {
        tracer = AmazonUrlConnectionHelpers.openConnection(url, new AuthErrorRetryLogic(), tracer, context);
        url = tracer;
        if (flag)
        {
            context = new AuthenticationMethodFactory(context, s);
            context.setPackageName(s1);
            url = AmazonUrlConnectionHelpers.openConnection(tracer, context.newAuthenticationMethod("BustedIdentityADPAuthenticator"));
        }
        url.setDoOutput(true);
        url.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        if (list != null && list.size() > 0)
        {
            for (context = list.iterator(); context.hasNext(); url.addRequestProperty("Cookie", String.format("%s=%s", new Object[] {
    list.getName(), list.getValue()
})))
            {
                list = (Cookie)context.next();
            }

        }
        url.setRequestMethod("POST");
        url.setRequestProperty("User-Agent", CUSTOM_USER_AGENT);
        MAPLog.i(TAG, "Starting request to exchange token endpoint");
        context = url.getOutputStream();
        urlencodedformentity.writeTo(context);
        StreamUtils.closeStream(context);
        return url;
        url;
        StreamUtils.closeStream(context);
        throw url;
    }

    static 
    {
        CUSTOM_USER_AGENT = (new StringBuilder("AmazonWebView/MAPClientLib/")).append(BuildInfo.getBuildInfo().mMapSWVersion).append("/Android/").append(android.os.Build.VERSION.RELEASE).append("/").append(Build.MODEL).toString();
    }
}

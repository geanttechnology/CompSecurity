// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.InternationalizationUtil;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.LocaleUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class OpenIdRequest
{
    public static final class REQUEST_TYPE extends Enum
    {

        private static final REQUEST_TYPE $VALUES[];
        public static final REQUEST_TYPE AUTHENTICATE;
        public static final REQUEST_TYPE CONFIRM_CREDENTIAL;
        public static final REQUEST_TYPE REGISTER;
        public static final REQUEST_TYPE SIGN_IN;

        public static REQUEST_TYPE valueOf(String s)
        {
            return (REQUEST_TYPE)Enum.valueOf(com/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE, s);
        }

        public static REQUEST_TYPE[] values()
        {
            return (REQUEST_TYPE[])$VALUES.clone();
        }

        static 
        {
            SIGN_IN = new REQUEST_TYPE("SIGN_IN", 0);
            REGISTER = new REQUEST_TYPE("REGISTER", 1);
            CONFIRM_CREDENTIAL = new REQUEST_TYPE("CONFIRM_CREDENTIAL", 2);
            AUTHENTICATE = new REQUEST_TYPE("AUTHENTICATE", 3);
            $VALUES = (new REQUEST_TYPE[] {
                SIGN_IN, REGISTER, CONFIRM_CREDENTIAL, AUTHENTICATE
            });
        }

        private REQUEST_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class TOKEN_SCOPE extends Enum
    {

        private static final TOKEN_SCOPE $VALUES[];
        public static final TOKEN_SCOPE ACCESS;
        public static final TOKEN_SCOPE REFRESH;

        public static TOKEN_SCOPE valueOf(String s)
        {
            return (TOKEN_SCOPE)Enum.valueOf(com/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE, s);
        }

        public static TOKEN_SCOPE[] values()
        {
            return (TOKEN_SCOPE[])$VALUES.clone();
        }

        static 
        {
            ACCESS = new TOKEN_SCOPE("ACCESS", 0);
            REFRESH = new TOKEN_SCOPE("REFRESH", 1);
            $VALUES = (new TOKEN_SCOPE[] {
                ACCESS, REFRESH
            });
        }

        private TOKEN_SCOPE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Tags
    {

        public static final String ACCT_STATUS_POLICY = "accountStatusPolicy";
        public static final String ASSOCIATION_HANDLE = "openid.assoc_handle";
        public static final String AUTHCOOKIES = "authCookies";
        public static final String CLAIMED_ID = "openid.claimed_id";
        public static final String CLIENT_CONTEXT = "clientContext";
        public static final String CLIENT_ID = "openid.oa2.client_id";
        public static final String CLIENT_INFO = "clientInfo";
        public static final String DISABLE_LOGIN_PREPOPULATE = "disableLoginPrepopulate";
        public static final String IDENTITY = "openid.identity";
        public static final String LANGUAGE_PARAMETER = "language";
        public static final String MAX_AUTH_AGE = "openid.pape.max_auth_age";
        public static final String MODE = "openid.mode";
        public static final String NAMESPACE = "openid.ns";
        public static final String OA2 = "openid.ns.oa2";
        public static final String PAGEID = "pageId";
        public static final String PAPE_NAMESPACE = "openid.ns.pape";
        public static final String RESPONSE_TYPE = "openid.oa2.response_type";
        public static final String RETURN_TO = "openid.return_to";
        public static final String SCOPE = "openid.oa2.scope";
        public static final String SITE_STATE = "siteState";

        private Tags()
        {
        }
    }

    public static final class Values
    {

        public static final String ACCESS_TOKEN_SCOPE = "device_auth_access";
        public static final String ACCT_STATUS_POLICY_P1 = "P1";
        public static final String ASSOCIATION_HANDLE_CN = "amzn_device_cn";
        public static final String ASSOCIATION_HANDLE_JP = "amzn_device_jp";
        public static final String ASSOCIATION_HANDLE_NA = "amzn_device_na";
        public static final String DEFAULT_ASSOCIATION_HANDLE = "amzn_device_na";
        public static final String ID_CONFIRM_CREDENTIALS = "http://www.amazon.com/ap/specs/auth/confirm_credentials";
        public static final String ID_IDENTIFIER_SELECT = "http://specs.openid.net/auth/2.0/identifier_select";
        public static final String MODE_CHECKID_SETUP = "checkid_setup";
        public static final String OA2_NAMESPACE = "http://www.amazon.com/ap/ext/oauth/2";
        public static final String OPENID_NAMESPACE = "http://specs.openid.net/auth/2.0";
        public static final String PAPE_NAMESPACE = "http://specs.openid.net/extensions/pape/1.0";
        public static final String REFRESH_TOKEN_SCOPE = "device_auth_refresh";
        public static final String REQUEST_TYPE_PARAM_KEY = "requestType";
        public static final String TOKEN_RESPONSE_TYPE = "token";

        private Values()
        {
        }
    }


    public static final String CLAIMED_ID_VALUE_SUBSTRING = "/ap/id/";
    public static final String DEFAULT_AUTH_PORTAL_REGISTER_ENDPOINT = "/ap/register";
    public static final String DEFAULT_AUTH_PORTAL_RETURN_TO_END_POINT = "/gp/yourstore/home";
    public static final String DEFAULT_AUTH_PORTAL_SIGNIN_ENDPOINT = "/ap/signin";
    private static final String LOG_TAG = com/amazon/identity/auth/device/endpoint/OpenIdRequest.getName();
    private Map mDebugParams;
    private final Bundle mOptions;
    private final Map mParams;
    private String mReturnToUrl;
    private final REQUEST_TYPE mType;
    private final android.net.Uri.Builder mUriBuilder;

    public OpenIdRequest(String s, REQUEST_TYPE request_type, Bundle bundle)
        throws IllegalArgumentException, NullPointerException
    {
label0:
        {
            super();
            mParams = new HashMap();
            mType = request_type;
            mOptions = bundle;
            Uri uri = getRequestUriFromOptions(mOptions);
            String s1;
            String s2;
            android.net.Uri.Builder builder;
            if (uri == null)
            {
                mUriBuilder = new android.net.Uri.Builder();
            } else
            {
                mUriBuilder = uri.buildUpon();
            }
            builder = mUriBuilder;
            s2 = null;
            s1 = s2;
            if (uri != null)
            {
                s1 = s2;
                if (!TextUtils.isEmpty(uri.getHost()))
                {
                    s1 = uri.getHost();
                }
            }
            if (!TextUtils.isEmpty(s1))
            {
                s2 = s1;
                if (!TextUtils.isEmpty(s1.trim()))
                {
                    break label0;
                }
            }
            s2 = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(mOptions));
        }
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s2.trim()))
        {
            builder.authority(s2.trim());
            mUriBuilder.scheme("https");
            if (TextUtils.isEmpty(mUriBuilder.build().getPath()))
            {
                if (mType == REQUEST_TYPE.REGISTER)
                {
                    mUriBuilder.path("/ap/register");
                } else
                {
                    mUriBuilder.path("/ap/signin");
                }
            }
            setAssociationHandle("amzn_device_na");
            setClientOptions(bundle);
            mParams.put("openid.ns", "http://specs.openid.net/auth/2.0");
            mParams.put("openid.mode", "checkid_setup");
            mParams.put("openid.claimed_id", "http://specs.openid.net/auth/2.0/identifier_select");
            mParams.put("openid.identity", "http://specs.openid.net/auth/2.0/identifier_select");
            mParams.put("openid.ns.pape", "http://specs.openid.net/extensions/pape/1.0");
            mParams.put("openid.oa2.response_type", "token");
            mParams.put("openid.ns.oa2", "http://www.amazon.com/ap/ext/oauth/2");
            mParams.put("accountStatusPolicy", "P1");
            mParams.put("openid.oa2.scope", "device_auth_access");
            setMaxAuthAge("0");
            setReturnToUrl(getDefaultReturnToURL());
            setClientId(s);
            s = LOG_TAG;
            (new StringBuilder("OpenIdRequest created with reqType=")).append(request_type).append(" host=").append(getHost()).toString();
            return;
        } else
        {
            MAPLog.e(LOG_TAG, "An unexpected error has occurred! Received null for URI host. This should not happen");
            throw new NullPointerException("An unexpected error has occurred! Received null for URI host. This should not happen");
        }
    }

    private void appendParameterList(android.net.Uri.Builder builder)
    {
        if (mDebugParams != null && mDebugParams.size() > 0)
        {
            mParams.putAll(mDebugParams);
            mDebugParams.clear();
        }
        java.util.Map.Entry entry;
        for (Iterator iterator = mParams.entrySet().iterator(); iterator.hasNext(); builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public static Uri getRequestUriFromOptions(Bundle bundle)
    {
        if (bundle != null)
        {
            if ((bundle = bundle.getBundle("com.amazon.identity.auth.ChallengeException")) != null && (bundle = bundle.getString("com.amazon.identity.auth.ChallengeException.oAuthURI")) != null)
            {
                if (!URLUtil.isValidUrl(bundle) || !URLUtil.isHttpsUrl(bundle))
                {
                    MAPLog.w(LOG_TAG, "Unusable OpenID URL received");
                    String s = LOG_TAG;
                    (new StringBuilder("Unusable OpenID URL received: ")).append(bundle).toString();
                    return null;
                }
                Object obj = Uri.parse(bundle);
                if (!((Uri) (obj)).isAbsolute() || !((Uri) (obj)).isHierarchical() || TextUtils.isEmpty(((Uri) (obj)).getAuthority()))
                {
                    MAPLog.w(LOG_TAG, "Unusable OpenID URL received");
                    obj = LOG_TAG;
                    (new StringBuilder("Unusable OpenID URL received: ")).append(bundle).toString();
                    return null;
                }
                if (TextUtils.isEmpty(((Uri) (obj)).getHost()) || TextUtils.isEmpty(((Uri) (obj)).getPath()))
                {
                    MAPLog.w(LOG_TAG, "Unusable OpenID URL received");
                    obj = LOG_TAG;
                    (new StringBuilder("Unusable OpenID URL received: ")).append(bundle).toString();
                    return null;
                } else
                {
                    bundle = LocaleUtil.getLocaleAsJavaLocaleFormat();
                    return ((Uri) (obj)).buildUpon().appendQueryParameter("language", bundle).build();
                }
            }
        }
        return null;
    }

    private void setClientOptions(Bundle bundle)
        throws IllegalArgumentException
    {
        if (bundle != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = bundle.getString("com.amazon.identity.ap.pageid");
        if (obj != null)
        {
            setPageID(((String) (obj)));
        }
        if (bundle.getString("com.amazon.identity.ap.assoc_handle") == null)
        {
            obj = InternationalizationUtil.getAuthPortalAssociationHandleForSpecificAmazonDomain(getHost());
        } else
        {
            obj = bundle.getString("com.amazon.identity.ap.assoc_handle");
        }
        if (obj != null)
        {
            setAssociationHandle(((String) (obj)));
        }
        obj = bundle.getString("com.amazon.identity.ap.clientContext");
        if (obj != null)
        {
            setClientContext(((String) (obj)));
        }
        bundle = bundle.getBundle("com.amazon.identity.ap.request.parameters");
        if (bundle != null)
        {
            obj = bundle.keySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = (String)((Iterator) (obj)).next();
                Object obj1 = bundle.get(s);
                if (obj1 instanceof String)
                {
                    mParams.put(s, (String)obj1);
                } else
                {
                    bundle = String.format("Invalid value type passed in for AuthPortalOptions.KEY_REQUEST_PARAMETERS, only strings are allowed, please us Bundle.putString. Object in violation key: %s object type: %s", new Object[] {
                        s, obj1.getClass().getName()
                    });
                    MAPLog.e(LOG_TAG, bundle);
                    throw new IllegalArgumentException(String.format(bundle, new Object[0]));
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String buildParameterList()
    {
        android.net.Uri.Builder builder = mUriBuilder.build().buildUpon();
        appendParameterList(builder);
        return builder.build().getEncodedQuery();
    }

    public String getCookieUrl()
    {
        Object obj = mUriBuilder.build();
        String s = ((Uri) (obj)).getScheme();
        obj = ((Uri) (obj)).getAuthority();
        return String.format(Locale.US, "%s://%s", new Object[] {
            s, obj
        });
    }

    public String getDefaultReturnToURL()
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("https");
        builder.authority(getHost());
        builder.path("/gp/yourstore/home");
        return builder.build().toString();
    }

    public String getHost()
    {
        return mUriBuilder.build().getAuthority();
    }

    public REQUEST_TYPE getRequestType()
    {
        return mType;
    }

    public String getRequestUrl()
    {
        android.net.Uri.Builder builder = mUriBuilder.build().buildUpon();
        appendParameterList(builder);
        return builder.build().toString();
    }

    public String getReturnToUrl()
    {
        return mReturnToUrl;
    }

    public void setAssociationHandle(String s)
    {
        mParams.put("openid.assoc_handle", s);
    }

    public void setClaimedId(String s)
    {
        mParams.put("openid.claimed_id", s);
        mParams.put("openid.identity", s);
    }

    public void setClientContext(String s)
    {
        mParams.put("clientContext", s);
    }

    public void setClientId(String s)
    {
        mParams.put("openid.oa2.client_id", (new StringBuilder("device:")).append(s).toString());
    }

    public void setClientInfo(String s)
    {
        mParams.put("clientInfo", s);
    }

    public void setDebugParams(Map map)
    {
        mDebugParams = map;
    }

    public void setDisableLoginPrepopulate(String s)
    {
        mParams.put("disableLoginPrepopulate", s);
    }

    public void setIgnoreAuthCookiesOnResponse(boolean flag)
    {
        if (flag)
        {
            mParams.put("authCookies", "0");
            return;
        } else
        {
            mParams.put("authCookies", "1");
            return;
        }
    }

    public void setMaxAuthAge(String s)
    {
        mParams.put("openid.pape.max_auth_age", s);
    }

    public void setPageID(String s)
    {
        mParams.put("pageId", s);
    }

    public void setPath(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("AuthPortal end point cannot be null");
        } else
        {
            mUriBuilder.path(s);
            return;
        }
    }

    public void setReturnToUrl(String s)
    {
        mReturnToUrl = s;
        mParams.put("openid.return_to", s);
    }

}

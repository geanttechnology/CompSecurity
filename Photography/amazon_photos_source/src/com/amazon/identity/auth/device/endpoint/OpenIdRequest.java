// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.math.BigInteger;
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
            Object obj;
            String s1;
            Object obj2;
            if (bundle != null)
            {
                obj = bundle;
            } else
            {
                obj = new Bundle();
            }
            mOptions = ((Bundle) (obj));
            obj2 = mOptions;
            if (obj2 == null)
            {
                obj = null;
            } else
            {
                obj = ((Bundle) (obj2)).getBundle("com.amazon.identity.auth.ChallengeException");
                Object obj1;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((Bundle) (obj)).getString("com.amazon.identity.auth.ChallengeException.oAuthURI");
                }
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = ((Bundle) (obj2)).getString("resume_authentication_url");
                }
                if (obj1 == null)
                {
                    obj = null;
                } else
                if (!URLUtil.isValidUrl(((String) (obj1))) || !URLUtil.isHttpsUrl(((String) (obj1))))
                {
                    MAPLog.w(LOG_TAG, "Unusable OpenID URL received");
                    obj = LOG_TAG;
                    (new StringBuilder("Unusable OpenID URL received: ")).append(((String) (obj1))).toString();
                    obj = null;
                } else
                {
                    obj = Uri.parse(((String) (obj1)));
                    if (!((Uri) (obj)).isAbsolute() || !((Uri) (obj)).isHierarchical() || TextUtils.isEmpty(((Uri) (obj)).getAuthority()))
                    {
                        MAPLog.w(LOG_TAG, "Unusable OpenID URL received");
                        obj = LOG_TAG;
                        (new StringBuilder("Unusable OpenID URL received: ")).append(((String) (obj1))).toString();
                        obj = null;
                    } else
                    if (TextUtils.isEmpty(((Uri) (obj)).getHost()) || TextUtils.isEmpty(((Uri) (obj)).getPath()))
                    {
                        MAPLog.w(LOG_TAG, "Unusable OpenID URL received");
                        obj = LOG_TAG;
                        (new StringBuilder("Unusable OpenID URL received: ")).append(((String) (obj1))).toString();
                        obj = null;
                    } else
                    {
                        String s2 = Locale.getDefault().toString();
                        obj = ((Uri) (obj)).buildUpon().appendQueryParameter("language", s2).build();
                    }
                }
            }
            if (obj == null)
            {
                mUriBuilder = new android.net.Uri.Builder();
            } else
            {
                mUriBuilder = ((Uri) (obj)).buildUpon();
            }
            obj2 = mUriBuilder;
            if (obj != null && !TextUtils.isEmpty(((Uri) (obj)).getHost()))
            {
                obj = ((Uri) (obj)).getHost();
            } else
            {
                obj = null;
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                s1 = ((String) (obj));
                if (!TextUtils.isEmpty(((String) (obj)).trim()))
                {
                    break label0;
                }
            }
            s1 = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(mOptions));
        }
        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s1.trim()))
        {
            ((android.net.Uri.Builder) (obj2)).authority(s1.trim());
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
            if (!mOptions.getBoolean("isAccountStateFixUpFlow"))
            {
                setMaxAuthAge("0");
            }
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

    public static String constructClientIdWithDsnAndDeviceType(String s, String s1)
    {
        return String.format("%x", new Object[] {
            new BigInteger(String.format("%s#%s", new Object[] {
                s, s1
            }).getBytes())
        });
    }

    private void setClientOptions(Bundle bundle)
        throws IllegalArgumentException
    {
        if (bundle != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = bundle.getString("com.amazon.identity.ap.pageid");
        if (obj != null)
        {
            setPageID(((String) (obj)));
        }
        if (bundle.getString("com.amazon.identity.ap.assoc_handle") != null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = getHost();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (!((String) (obj)).endsWith("amazon.co.jp")) goto _L6; else goto _L5
_L5:
        obj = "amzn_device_jp";
_L8:
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
          goto _L1
_L6:
        if (!((String) (obj)).endsWith("amazon.cn")) goto _L4; else goto _L7
_L7:
        obj = "amzn_device_cn";
          goto _L8
_L4:
        obj = null;
          goto _L8
        obj = bundle.getString("com.amazon.identity.ap.assoc_handle");
          goto _L8
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
        String s = mOptions.getString("return_to_domain");
        android.net.Uri.Builder builder;
        if (!TextUtils.isEmpty(s))
        {
            s = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(s);
        } else
        {
            s = getHost();
        }
        builder = new android.net.Uri.Builder();
        builder.scheme("https");
        builder.authority(s);
        builder.path("/ap/maplanding");
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

    public void setDebugParams(Map map)
    {
        mDebugParams = map;
    }

    public void setDisableLoginPrepopulate(String s)
    {
        mParams.put("disableLoginPrepopulate", s);
    }

    public void setIgnoreAuthCookiesOnResponse$1385ff()
    {
        mParams.put("authCookies", "0");
    }

    public void setMaxAuthAge(String s)
    {
        mParams.put("openid.pape.max_auth_age", s);
    }

    public void setPageID(String s)
    {
        mParams.put("pageId", s);
    }

    public void setReturnToUrl(String s)
    {
        mReturnToUrl = s;
        mParams.put("openid.return_to", s);
    }

}

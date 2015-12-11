// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.DelegatedAccountHelper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AmazonDomainHelper, BuildInfo

public class AuthPortalExchangeTokenHelper
{

    final DelegatedAccountHelper mDelegatedAccountHelper = new DelegatedAccountHelper();

    public AuthPortalExchangeTokenHelper()
    {
    }

    private URL getExchangeTokenURLCommon(String s)
        throws AssertionError
    {
        try
        {
            s = new URL("https", AmazonDomainHelper.getCompleteAuthPortalDomain(s), 443, "/ap/exchangetoken");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError("Should never happen; hardcoded constant.");
        }
        return s;
    }

    public void addAppParams(ServiceWrappingContext servicewrappingcontext, List list)
    {
        list.add(new BasicNameValuePair("app_name", servicewrappingcontext.getPackageName()));
        list.add(new BasicNameValuePair("app_version", BuildInfo.getMAPSWVersion()));
    }

    public UrlEncodedFormEntity getDMSExchangeTokenBody(ServiceWrappingContext servicewrappingcontext)
        throws UnsupportedEncodingException
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("source_token_type", "dms_token"));
        arraylist.add(new BasicNameValuePair("source_token", "source_token"));
        arraylist.add(new BasicNameValuePair("requested_token_type", "refresh_token"));
        addAppParams(servicewrappingcontext, arraylist);
        return new UrlEncodedFormEntity(arraylist, "UTF-8");
    }

    public URL getDelegationExchangeTokenURL(ServiceWrappingContext servicewrappingcontext, String s, Bundle bundle)
    {
        Object obj = null;
        if (bundle != null)
        {
            obj = mDelegatedAccountHelper.getDelegationDomainFromAPIBundle(bundle);
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            bundle = mDelegatedAccountHelper.getDelegationDomainForDirectedId(s, new LocalAppDataAwareDataStorage(servicewrappingcontext));
        } else
        {
            bundle = ((Bundle) (obj));
        }
        obj = bundle;
        if (TextUtils.isEmpty(bundle))
        {
            obj = AmazonDomainHelper.getAuthDomainForDirectedId(servicewrappingcontext, s);
        }
        return getExchangeTokenURLCommon(((String) (obj)));
    }

    public URL getExchangeTokenURL(ServiceWrappingContext servicewrappingcontext, String s)
    {
        return getExchangeTokenURLCommon(AmazonDomainHelper.getAuthDomainForDirectedId(servicewrappingcontext, s));
    }

    public UrlEncodedFormEntity getRefreshDelegatedOAuthTokenBody(ServiceWrappingContext servicewrappingcontext, String s, String s1)
        throws UnsupportedEncodingException
    {
        ArrayList arraylist = new ArrayList();
        addAppParams(servicewrappingcontext, arraylist);
        arraylist.add(new BasicNameValuePair("source_token_type", "refresh_token"));
        arraylist.add(new BasicNameValuePair("source_token", s));
        arraylist.add(new BasicNameValuePair("requested_token_type", "delegated_access_token"));
        arraylist.add(new BasicNameValuePair("directed_id", s1));
        return new UrlEncodedFormEntity(arraylist, "UTF-8");
    }

    public com.amazon.identity.auth.device.token.OAuthTokenManager.ExchangeTokenResponse handleDMSExchangeTokenSuccess(JSONObject jsonobject)
        throws JSONException, ParseException
    {
        if (jsonobject == null)
        {
            throw new ParseException("Null response", 0);
        }
        Object obj = jsonobject.getJSONObject("response");
        int i = ((JSONObject) (obj)).getInt("expires_in");
        jsonobject = ((JSONObject) (obj)).getString("token_type");
        String s = ((JSONObject) (obj)).getString("refresh_token");
        obj = ((JSONObject) (obj)).getString("access_token");
        if (!"bearer_token".equals(jsonobject))
        {
            throw new ParseException("Unexpected token type.", 0);
        }
        if (obj == null || s == null)
        {
            throw new ParseException("Incomplete response.", 0);
        } else
        {
            return new com.amazon.identity.auth.device.token.OAuthTokenManager.ExchangeTokenResponse(((String) (obj)), i, s);
        }
    }

    public com.amazon.identity.auth.device.token.OAuthTokenManager.ExchangeTokenResponse handleExchangeTokenSuccess(JSONObject jsonobject)
        throws JSONException, ParseException
    {
        if (jsonobject == null)
        {
            throw new ParseException("Null response", 0);
        }
        Object obj = jsonobject.getJSONObject("response");
        int i = ((JSONObject) (obj)).getInt("token_expires_in");
        jsonobject = ((JSONObject) (obj)).getString("token_type");
        obj = ((JSONObject) (obj)).getString("token");
        if (!"bearer_token".equals(jsonobject))
        {
            throw new ParseException("Unexpected token type.", 0);
        }
        if (obj == null)
        {
            throw new ParseException("Incomplete response.", 0);
        } else
        {
            return new com.amazon.identity.auth.device.token.OAuthTokenManager.ExchangeTokenResponse(((String) (obj)), i);
        }
    }
}

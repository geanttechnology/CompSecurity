// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.braintreepayments.api.exceptions.CoinbaseException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.models.CoinbaseConfiguration;
import com.braintreepayments.api.models.Configuration;
import java.net.URLEncoder;

// Referenced classes of package com.braintreepayments.api:
//            BraintreeBrowserSwitchActivity

public class Coinbase
{

    private static final String REDIRECT_URI_HOST = "coinbase";
    private static final String REDIRECT_URI_SCHEME_SUFFIX = "braintree";
    private static final String UTF_8 = "UTF-8";
    private Configuration mConfiguration;
    private Context mContext;

    protected Coinbase(Context context, Configuration configuration)
    {
        mContext = context;
        mConfiguration = configuration;
    }

    public static boolean canParseResponse(Context context, Intent intent)
    {
        return canParseResponse(context, (Uri)intent.getParcelableExtra("com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REDIRECT_URL"));
    }

    protected static boolean canParseResponse(Context context, Uri uri)
    {
        return uri != null && uri.getScheme().equals((new StringBuilder()).append(context.getPackageName()).append(".braintree").toString()) && uri.getHost().equals("coinbase");
    }

    protected Intent getLaunchIntent()
    {
        Object obj = mConfiguration.getCoinbase();
        obj = (new StringBuilder()).append(((CoinbaseConfiguration) (obj)).getBaseURLForEnvironment()).append("oauth/authorize?response_type=code&client_id=").append(URLEncoder.encode(((CoinbaseConfiguration) (obj)).getClientId(), "UTF-8")).append("&scope=").append(URLEncoder.encode(((CoinbaseConfiguration) (obj)).getScopes(), "UTF-8")).append("&redirect_uri=").append(URLEncoder.encode(getRedirectUri(), "UTF-8")).append("&meta%5Bauthorizations_merchant_account%5D=").append(URLEncoder.encode(((CoinbaseConfiguration) (obj)).getMerchantAccount(), "UTF-8")).toString();
        return (new Intent(mContext, com/braintreepayments/api/BraintreeBrowserSwitchActivity)).setFlags(0x10000).putExtra("com.braintreepayments.api.BraintreeBrowserSwitchActivity.EXTRA_REQUEST_URL", ((String) (obj)));
    }

    public String getRedirectUri()
    {
        return (new android.net.Uri.Builder()).scheme((new StringBuilder()).append(mContext.getPackageName()).append(".braintree").toString()).authority("coinbase").build().toString();
    }

    protected boolean isAvailable()
    {
        return mConfiguration.isCoinbaseEnabled();
    }

    protected String parseResponse(Uri uri)
    {
        if (canParseResponse(mContext, uri))
        {
            String s = uri.getQueryParameter("code");
            if (!TextUtils.isEmpty(s))
            {
                return s;
            } else
            {
                throw new CoinbaseException(uri.getQueryParameter("error_description"));
            }
        } else
        {
            throw new ConfigurationException("Intent did not contain a well-formed OAuth response from Coinbase");
        }
    }
}

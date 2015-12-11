// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import android.app.Activity;
import android.content.SharedPreferences;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.SignedResponseRequester;
import com.sponsorpay.utils.SignedServerResponse;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import com.sponsorpay.utils.UrlBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.sponsorpay.mediation:
//            SPMediationConfigurator, SPMediationCoordinator

public class SPMediationConfigurationRequester extends SignedResponseRequester
{

    private static final String SERVER_SIDE_CONFIG_URL_KEY = "config";
    public static final String TAG = "ConfigurationRequester";
    private Activity mActivity;
    private String mSecurityToken;

    private SPMediationConfigurationRequester(Activity activity, String s)
    {
        mActivity = activity;
        mSecurityToken = s;
    }

    private static String getBaseUrl()
    {
        return SponsorPayBaseUrlProvider.getBaseUrl("config");
    }

    private void overrideConfig(String s)
    {
        if (StringUtils.notNullNorEmpty(s))
        {
            s = SPMediationConfigurator.parseConfiguration(s).entrySet().iterator();
            do
            {
                if (!s.hasNext())
                {
                    return;
                }
                Object obj = (java.util.Map.Entry)s.next();
                String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (Map)((java.util.Map.Entry) (obj)).getValue();
                Map map = SPMediationConfigurator.INSTANCE.getConfigurationForAdapter(s1);
                if (map != null)
                {
                    ((Map) (obj)).putAll(map);
                }
                SPMediationConfigurator.INSTANCE.setConfigurationForAdapter(s1, ((Map) (obj)));
            } while (true);
        } else
        {
            SponsorPayLogger.d("ConfigurationRequester", "There were no credentials to override");
            return;
        }
    }

    public static void requestConfig(SPCredentials spcredentials, Activity activity)
    {
        UrlBuilder urlbuilder = UrlBuilder.newBuilder(getBaseUrl(), spcredentials).addSignature();
        (new SPMediationConfigurationRequester(activity, spcredentials.getSecurityToken())).execute(new UrlBuilder[] {
            urlbuilder
        });
    }

    protected String getTag()
    {
        return "ConfigurationRequester";
    }

    protected SignedServerResponse noConnectionResponse(Throwable throwable)
    {
        return null;
    }

    protected volatile Object noConnectionResponse(Throwable throwable)
    {
        return noConnectionResponse(throwable);
    }

    protected void onPostExecute(SignedServerResponse signedserverresponse)
    {
        SPMediationCoordinator.INSTANCE.startMediationAdapters(mActivity);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((SignedServerResponse)obj);
    }

    protected SignedServerResponse parsedSignedResponse(SignedServerResponse signedserverresponse)
    {
        SharedPreferences sharedpreferences;
        sharedpreferences = mActivity.getSharedPreferences("ConfigurationRequester", 0);
        if (signedserverresponse == null || hasErrorStatusCode(signedserverresponse.getStatusCode()))
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (!verifySignature(signedserverresponse, mSecurityToken)) goto _L2; else goto _L1
_L1:
        String s;
        SponsorPayLogger.d("ConfigurationRequester", "The signature is valid, proceeding...");
        s = signedserverresponse.getResponseBody();
        if (!StringUtils.notNullNorEmpty(s))
        {
            break MISSING_BLOCK_LABEL_158;
        }
        Object obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("ConfigurationRequester", s);
        if (((android.content.SharedPreferences.Editor) (obj)).commit())
        {
            SponsorPayLogger.d("ConfigurationRequester", "Server Side Configuration has been saved successfully.");
        } else
        {
            SponsorPayLogger.d("ConfigurationRequester", "Failed to save Server Side Configuration.");
        }
_L3:
        obj = s;
        if (StringUtils.nullOrEmpty(s))
        {
            SponsorPayLogger.d("ConfigurationRequester", "No configs from the server, fallback to cached version.");
            obj = sharedpreferences.getString("ConfigurationRequester", "");
            if (StringUtils.nullOrEmpty(((String) (obj))))
            {
                SponsorPayLogger.d("ConfigurationRequester", "There were no cached version to use.");
            } else
            {
                SponsorPayLogger.d("ConfigurationRequester", "Using cached json file");
            }
        }
        overrideConfig(((String) (obj)));
        return signedserverresponse;
_L2:
        SponsorPayLogger.d("ConfigurationRequester", "Invalid signature, those configs will not be used.");
        s = "";
          goto _L3
    }

    protected volatile Object parsedSignedResponse(SignedServerResponse signedserverresponse)
    {
        return parsedSignedResponse(signedserverresponse);
    }
}

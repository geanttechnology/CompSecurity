// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common:
//            Preferences, SsoRequest, SsoResponse

public class SsoScopeLoader extends FwNetLoader
{
    private static final class SsoScopeRequest extends SsoRequest
    {

        public static SsoScopeRequest create(EbayContext ebaycontext, String s, String s1, String s2)
        {
            String s3 = s1;
            if (TextUtils.isEmpty(s1))
            {
                s3 = "//EBAYSSO/EBAYCLASSIC";
            }
            ebaycontext = EbayAppCredentials.get(ebaycontext);
            return new SsoScopeRequest(Uri.parse((new StringBuilder()).append(ApiSettings.get(EbaySettings.ssoApiBase)).append("?OAuthAuthorize2").toString()).buildUpon().appendQueryParameter("grant_type", "client_credentials").appendQueryParameter("client_id", ((EbayAppCredentials) (ebaycontext)).appId).appendQueryParameter("client_secret", s).appendQueryParameter("scope", (new StringBuilder()).append("scope:").append(s3).append(":").append(s2).toString()).toString());
        }

        public SsoScopeResponse getResponse()
        {
            return new SsoScopeResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        private SsoScopeRequest(String s)
        {
            super(s, "ssoScope");
            if (SsoScopeLoader.log.isLoggable)
            {
                SsoScopeLoader.log.log((new StringBuilder()).append("SSO request: ").append(s).toString());
            }
        }
    }

    private static final class SsoScopeResponse extends SsoResponse
    {

        public String errorCode;
        public String errorDescription;
        public String idToken;

        public void parse(JSONObject jsonobject)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            if (SsoScopeLoader.log.isLoggable)
            {
                SsoScopeLoader.log.log((new StringBuilder()).append("SSO response: ").append(jsonobject).toString());
            }
            idToken = jsonobject.optString("id_token", null);
            errorDescription = jsonobject.optString("error_description", null);
            errorCode = jsonobject.optString("error_code", null);
        }

        private SsoScopeResponse()
        {
        }

    }


    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("SsoScopeLoader", 3, "SSO Scope Loader");
    public String errorCode;
    public String errorDescription;
    private final String iafToken;
    private final String scope;
    private boolean ssoRequestSucceeded;
    private String ssoUrl;
    private final String url;

    public SsoScopeLoader(EbayContext ebaycontext, Authentication authentication, String s)
        throws AssertionFailedError
    {
        this(ebaycontext, authentication, null, s);
    }

    public SsoScopeLoader(EbayContext ebaycontext, Authentication authentication, String s, String s1)
        throws AssertionFailedError
    {
        super(ebaycontext);
        ssoRequestSucceeded = false;
        Assert.assertNotNull("authentication", authentication);
        iafToken = authentication.iafToken;
        scope = s;
        url = s1;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        if (log.isLoggable)
        {
            log.log(String.format("Requesting SSO token with scope: %s, url: %s", new Object[] {
                scope, url
            }));
        }
        SsoScopeResponse ssoscoperesponse = (SsoScopeResponse)sendRequest(SsoScopeRequest.create(getEbayContext(), iafToken, scope, url));
        if (TextUtils.isEmpty(ssoscoperesponse.idToken))
        {
            errorDescription = ssoscoperesponse.errorDescription;
            errorCode = ssoscoperesponse.errorCode;
            ssoUrl = url;
            return;
        }
        ssoRequestSucceeded = true;
        Object obj;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.connection_SiteSpecificSso))
        {
            obj = MyApp.getPrefs().getCurrentSite().getDomain();
            obj = String.format(ApiSettings.get(EbaySettings.ssoSiteSpecificApiBase), new Object[] {
                obj
            });
        } else
        {
            obj = ApiSettings.get(EbaySettings.ssoApiBase);
        }
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("SSO Endpoint used: ").append(((String) (obj))).toString());
        }
        obj = Uri.parse((new StringBuilder()).append(((String) (obj))).append("?SSO").toString()).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("id_token", ssoscoperesponse.idToken);
        ssoUrl = ((android.net.Uri.Builder) (obj)).build().toString();
    }

    public String getSsoUrl()
    {
        return ssoUrl;
    }

    public boolean isServiceError()
    {
        return !ssoRequestSucceeded;
    }

}

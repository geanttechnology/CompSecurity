// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.util.ExceptionUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            XmlSerializerHelper

public abstract class EbayRequest extends Request
{

    public static final String API_4PP_FINGERPRINT = "x-ebay-4pp";
    public static final String API_CALL_NAME = "x-ebay-api-call-name";
    public static final String API_DEVICE_GUID = "x-ebay3pp-device-id";
    public static final String API_MOBILE_APP_INFO = "x-ebay-mobile-app-info";
    public static final String API_MOBILE_PROFILE_SESSION = "x-ebay-mobile-profile-session";
    protected static final Gson defaultRequestMapper = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).create();
    public String errorLanguage;
    protected transient String tmxSessionId;

    protected EbayRequest()
    {
        contructCommon();
    }

    protected EbayRequest(String s, String s1)
    {
        super(s, s1);
        contructCommon();
    }

    protected static void addSiteInfo(LogTrackError logtrackerror, EbaySite ebaysite)
    {
        if (ebaysite != null)
        {
            logtrackerror.setGlobalId(ebaysite.idString);
        }
    }

    private void contructCommon()
    {
        errorLanguage = XmlSerializerHelper.getDefaultErrorLocale();
    }

    public static String generateTmxProfileSessionValue(String s)
    {
        return String.format("sessionType=TMX,sessionId=%s", new Object[] {
            s
        });
    }

    protected static boolean isRetriableException(IOException ioexception)
    {
        while (ioexception == null || ExceptionUtil.isInterruptedException(ioexception) || (ioexception instanceof NoHttpResponseException) || (ioexception instanceof SSLException) || (ioexception instanceof com.ebay.nautilus.kernel.net.Connector.ClientErrorException)) 
        {
            return false;
        }
        return true;
    }

    protected final void addEbayMobileAppHeaders(IHeaders iheaders)
    {
        float f = (float)(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60000) / 60F;
        String s = (new StringBuilder()).append("tz=").append(String.format(Locale.US, "%.2f", new Object[] {
            Float.valueOf(f)
        })).append(";ver=").append(NautilusKernel.getAppVersionName(getContext())).toString();
        iheaders.setHeader("x-ebay-4pp", EbayIdentity.get4ppFingerprint(getContext()));
        iheaders.setHeader("x-ebay-mobile-app-info", s);
        if (!TextUtils.isEmpty(tmxSessionId))
        {
            iheaders.setHeader("x-ebay-mobile-profile-session", generateTmxProfileSessionValue(tmxSessionId));
        }
    }

    protected String getErrorLanguage()
    {
        return errorLanguage;
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        addEbayMobileAppHeaders(iheaders);
    }

}

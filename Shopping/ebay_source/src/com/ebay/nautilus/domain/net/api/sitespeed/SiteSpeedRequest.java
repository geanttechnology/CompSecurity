// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.sitespeed;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.sitespeed:
//            SiteSpeedResponse

public final class SiteSpeedRequest extends Request
{

    public static final String OPERATION_NAME = "sendReport";
    public static final String SERVICE_NAME = "SiteSpeed";
    private final SiteSpeedData data;
    private final com.ebay.nautilus.domain.content.dm.SiteSpeedDataManager.DeviceMeta deviceMeta;
    private final com.ebay.nautilus.domain.content.dm.SiteSpeedDataManager.SiteSpeedMeta meta;

    public SiteSpeedRequest(SiteSpeedData sitespeeddata, com.ebay.nautilus.domain.content.dm.SiteSpeedDataManager.DeviceMeta devicemeta, com.ebay.nautilus.domain.content.dm.SiteSpeedDataManager.SiteSpeedMeta sitespeedmeta)
    {
        super("SiteSpeed", "sendReport");
        data = sitespeeddata;
        meta = sitespeedmeta;
        deviceMeta = devicemeta;
    }

    private String truncate(String s, int i)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.length() > i)
            {
                s1 = s.substring(0, i);
            }
        }
        return s1;
    }

    public URL getRequestUrl()
    {
        EbayCountry ebaycountry = data.country;
        android.net.Uri.Builder builder = ApiSettings.getSiteSpeedUri(ebaycountry).buildUpon();
        builder.appendQueryParameter("cmdname", (new StringBuilder()).append("m_").append(data.eventName).toString());
        builder.appendQueryParameter("s_m_apptype", DeviceInfoUtil.getOsType());
        if (data.subEventName != null)
        {
            builder.appendQueryParameter("s_m_imp", data.subEventName);
        }
        builder.appendQueryParameter("s_m_app_id", deviceMeta.trackingId);
        builder.appendQueryParameter("s_m_dn", truncate(deviceMeta.deviceModel, 32));
        builder.appendQueryParameter("s_m_os", deviceMeta.osType);
        builder.appendQueryParameter("s_m_av", deviceMeta.appVersion);
        builder.appendQueryParameter("s_m_osv", deviceMeta.osVersion);
        builder.appendQueryParameter("s_m_res", meta.screenRes);
        Object obj;
        if (meta.portrait)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        builder.appendQueryParameter("s_1s", ((String) (obj)));
        builder.appendQueryParameter("s_m_carrier", meta.carrier);
        builder.appendQueryParameter("s_m_nt", meta.networkType);
        builder.appendQueryParameter("s_m_mnt", meta.mobileNetworkType);
        builder.appendQueryParameter("s_m_prefl", meta.preferredLanguage);
        builder.appendQueryParameter("s_m_uuid", meta.deviceId);
        builder.appendQueryParameter("s_0s", String.valueOf(EbayResponse.getHostTime(data.startClockTime)));
        builder.appendQueryParameter("st1a", String.valueOf(data.getViewAppearedDelta()));
        builder.appendQueryParameter("ctb", String.valueOf(data.getPrimaryLoadedDelta()));
        builder.appendQueryParameter("i_ctnb", String.valueOf(data.getAllLoadedDelta()));
        if (data.signedIn)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        builder.appendQueryParameter("s_m_si", ((String) (obj)));
        builder.appendQueryParameter("s_m_mrollp", String.format(Locale.US, "%.2f", new Object[] {
            Float.valueOf(meta.rolloutThreshold)
        }));
        builder.appendQueryParameter("s_m_memsz", deviceMeta.memorySize);
        if (ebaycountry != null)
        {
            builder.appendQueryParameter("s_m_uc", ebaycountry.getCountryCode());
            builder.appendQueryParameter("s_m_siteid", ebaycountry.site.id);
        }
        obj = data.getExtendedDataMap();
        if (obj != null)
        {
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

        }
        try
        {
            obj = new URL(builder.toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj));
    }

    public SiteSpeedResponse getResponse()
    {
        return new SiteSpeedResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }
}

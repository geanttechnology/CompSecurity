// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.SerializablePair;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            GetTreatmentsResponse

public class GetTreatmentsRequest extends EbayCosRequest
{
    private static class RequestBody
    {

        public String channel;
        public List context;
        public String optedInto;

        private RequestBody()
        {
        }

    }


    public static final String KEY_APP_ID = "aid";
    public static final String KEY_CARRIER = "carrier";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_CLIENT_ID = "aid";
    public static final String KEY_COUNTRY_ID = "country";
    public static final String KEY_DEVICE_NAME = "dn";
    public static final String KEY_MOBILE_APP_VERSION = "mav";
    public static final String KEY_SITE_ID = "site";
    public static final String KEY_USER_NAME = "un";
    private static final String SERVICE_VERSION = "2.2.3";
    public String channelId;
    private String clientId;
    private Map contextKeys;
    public List optIn;
    private String siteId;

    public GetTreatmentsRequest()
    {
        super("MobileExperimentationService", "treatments");
        siteId = null;
        clientId = null;
        optIn = null;
        channelId = "MobileApp";
        responseBodyContentType = "application/json";
        requestBodyContentType = "application/json";
    }

    public GetTreatmentsRequest(String s, Map map)
    {
        this();
        iafToken = s;
        contextKeys = map;
        serviceVersion = "2.2.3";
        if (contextKeys != null)
        {
            if (contextKeys.containsKey("site"))
            {
                siteId = (String)contextKeys.get("site");
                contextKeys.remove("site");
            }
            if (contextKeys.containsKey("aid"))
            {
                clientId = (String)contextKeys.get("aid");
            }
            if (contextKeys.containsKey("channelId"))
            {
                channelId = (String)contextKeys.get("channelId");
            }
        }
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        RequestBody requestbody = new RequestBody();
        requestbody.channel = channelId;
        requestbody.context = new ArrayList();
        if (contextKeys != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = contextKeys.entrySet().iterator(); iterator.hasNext(); requestbody.context.add(new SerializablePair(entry.getKey(), entry.getValue())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            if (optIn != null && optIn.size() > 0)
            {
                requestbody.optedInto = TextUtils.join(",", optIn.toArray());
            }
        }
        return defaultRequestMapper.toJson(requestbody).getBytes();
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.experimentationApiUrl);
    }

    public GetTreatmentsResponse getResponse()
    {
        return new GetTreatmentsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        String s = NautilusKernel.getAppVersionName(getContext());
        super.onAddHeaders(iheaders);
        if (!TextUtils.isEmpty(siteId))
        {
            iheaders.setHeader("x-ebay-soa-global-id", siteId);
        }
        if (clientId != null)
        {
            iheaders.setHeader("x-ebay-mobile-app-name", clientId);
        }
        iheaders.setHeader("x-ebay-mobile-app-version", s);
    }
}

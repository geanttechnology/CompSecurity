// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.debug.SearchDebugDataStore;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.CookieUtil;
import com.amazon.searchapp.retailsearch.client.web.HttpHeader;
import com.amazon.searchapp.retailsearch.client.web.ServiceCall;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallInterceptor;
import com.amazon.searchapp.retailsearch.client.web.UrlMaker;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.client:
//            AndroidRetailSearchClient

public class SearchCallInterceptor
    implements ServiceCallInterceptor
{

    private static final String DYNAMIC_DISPLAY_SETTINGS_PARAM = "ma_dds";
    private static final String IMG_HEIGHT_PARAM = "imgHeight";
    private static final String IMG_WIDTH_PARAM = "imgWidth";
    private static final String INBAND_IMAGE_PARAM = "inbandImage";
    private static final String UA_APP_NAME_PARAM = "uaAppName";
    private static final String UA_APP_TYPE_PARAM = "uaAppType";
    private static final String UA_APP_VERSION_PARAM = "uaAppVersion";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/client/AndroidRetailSearchClient);
    Context context;
    SearchDebugDataStore debugDataStore;
    FeatureConfiguration featureConfig;
    private RetailSearchLogger retailSearchLogger;
    UserPreferenceManager userPreferenceManager;

    public SearchCallInterceptor()
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
    }

    private void addClickstreamParameters(CollectionMap collectionmap)
    {
        if (context != null && context.getResources() != null && collectionmap != null)
        {
            Object obj = context.getResources();
            String s = ((Resources) (obj)).getString(com.amazon.retailsearch.R.string.config_rs_ua_app_name);
            if (!TextUtils.isEmpty(s))
            {
                collectionmap.add("uaAppName", s);
            }
            obj = ((Resources) (obj)).getString(com.amazon.retailsearch.R.string.config_rs_ua_app_type);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                collectionmap.add("uaAppType", obj);
            }
            obj = AndroidRetailSearchClient.getAppVersion();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                collectionmap.add("uaAppVersion", obj);
                return;
            }
        }
    }

    private void addInbandImageParameters(CollectionMap collectionmap)
    {
        if ("T1".equals(FeatureStateUtil.getInbandImageWeblab(featureConfig)) && context != null && userPreferenceManager != null && collectionmap != null && userPreferenceManager.getResultLayoutType() != null)
        {
            Point point = userPreferenceManager.getResultLayoutType().getImageDimensions(context);
            if (point != null)
            {
                collectionmap.add("imgWidth", String.valueOf(point.x));
                collectionmap.add("imgHeight", String.valueOf(point.y));
                collectionmap.add("inbandImage", "1");
                return;
            }
        }
    }

    public void process(ServiceCall servicecall)
        throws IOException
    {
        Object obj;
        Object obj1;
        obj = new URI(servicecall.getScheme(), servicecall.getUserInfo(), servicecall.getHost(), servicecall.getPort(), servicecall.getPath(), null, null);
        obj1 = CookieHandler.getDefault();
        if (obj1 == null)
        {
            Object obj2;
            Iterator iterator;
            String s;
            try
            {
                log.warn("No default CookieHandler found");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ServiceCall servicecall)
            {
                retailSearchLogger.error("SearchCallInterceptor encountered an error while processing the service call", servicecall);
            }
            break MISSING_BLOCK_LABEL_366;
        }
        obj1 = ((CookieHandler) (obj1)).get(((URI) (obj)), new HashMap(0));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_423;
        }
        obj1 = (List)((Map) (obj1)).get(HttpHeader.COOKIE.getName());
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_423;
        }
        if (((List) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_423;
        }
        obj2 = new StringBuilder();
        if (DebugMode.enabled() && debugDataStore.getCookies() != null)
        {
            servicecall.setCookies(CollectionMap.merge(debugDataStore.getCookies(), servicecall.getCookies()));
            ((StringBuilder) (obj2)).append(CookieUtil.createRequestHeader(servicecall.getCookies()));
            if (((StringBuilder) (obj2)).length() > 0)
            {
                ((StringBuilder) (obj2)).append(";");
            }
        }
        ((StringBuilder) (obj2)).append((String)((List) (obj1)).get(0));
        servicecall.getHeaders().set(HttpHeader.COOKIE.getName(), ((StringBuilder) (obj2)).toString());
        obj1 = new CollectionMap();
        addClickstreamParameters(((CollectionMap) (obj1)));
        addInbandImageParameters(((CollectionMap) (obj1)));
        if (featureConfig != null)
        {
            obj2 = featureConfig.getFeatureState("SX_mShop_Android_Dynamic_Display_Settings");
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                ((CollectionMap) (obj1)).add("ma_dds", obj2);
            }
        }
        servicecall = servicecall.getParameters();
        if (servicecall == null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        for (obj1 = ((CollectionMap) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext();)
        {
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
            iterator = ((List)((java.util.Map.Entry) (obj2)).getValue()).iterator();
            while (iterator.hasNext()) 
            {
                s = (String)iterator.next();
                servicecall.add(((java.util.Map.Entry) (obj2)).getKey(), s);
            }
        }

        break MISSING_BLOCK_LABEL_367;
        return;
        if (!DebugMode.enabled())
        {
            break MISSING_BLOCK_LABEL_423;
        }
        obj = new UrlMaker(((URI) (obj)));
        if (servicecall == null)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        ((UrlMaker) (obj)).setQuery(servicecall);
        log.debug((new StringBuilder()).append("URL: ").append(((UrlMaker) (obj)).build()).toString());
    }

}

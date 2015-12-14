// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;

import android.content.Context;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.auth.AmazonHttpClientFactory;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.NoCredentialsException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.foundation.metrics.customer:
//            MetricsPublisher, CustomerMetric

public class ForesterPublisher
    implements MetricsPublisher
{

    private static final DateFormat FORESTER_LOGGER_DATE_FORMATTER;
    private static Map MARKETPLACE_TO_FORESTER_ENDPOINT;
    private static final String TAG = com/amazon/gallery/foundation/metrics/customer/ForesterPublisher.getName();
    private final Context appContext;
    private final NetworkConnectivity connectivityMgr;
    private final EndpointManager endpointMgr;

    public ForesterPublisher(EndpointManager endpointmanager, NetworkConnectivity networkconnectivity, Context context)
    {
        endpointMgr = endpointmanager;
        connectivityMgr = networkconnectivity;
        appContext = context;
    }

    private boolean sendChunk(List list, HttpPost httppost, HttpClient httpclient)
    {
        List list1;
        List list2;
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = new StringBuilder();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((StringBuilder) (obj2)).append("\n"))
        {
            ((StringBuilder) (obj2)).append(((CustomerMetric)iterator.next()).getMetricAsJson().toString());
        }

        obj1 = null;
        obj = null;
        list2 = obj;
        list1 = obj1;
        obj2 = ((StringBuilder) (obj2)).toString();
        list2 = obj;
        list1 = obj1;
        StringEntity stringentity = new StringEntity(((String) (obj2)), "UTF-8");
        list2 = obj;
        list1 = obj1;
        stringentity.setContentType(new BasicHeader("Content-Type", "application/json"));
        list2 = obj;
        list1 = obj1;
        httppost.setEntity(stringentity);
        list2 = obj;
        list1 = obj1;
        GLogger.v(TAG, ((String) (obj2)), new Object[0]);
        list2 = obj;
        list1 = obj1;
        GLogger.d(TAG, (new StringBuilder()).append("POSTing ").append(list.size()).append(" metrics to Forester").toString(), new Object[0]);
        list2 = obj;
        list1 = obj1;
        list = httpclient.execute(httppost);
        list2 = list;
        list1 = list;
        httpclient = list.getStatusLine();
        list2 = list;
        list1 = list;
        if (httpclient.getStatusCode() != 204)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        list2 = list;
        list1 = list;
        GLogger.d(TAG, "POST metric successful: %s", new Object[] {
            httpclient
        });
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        try
        {
            list = list.getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            return true;
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        list = list.getContent();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        list.close();
        return true;
        list2 = list;
        list1 = list;
        GLogger.w(TAG, "POST metric unsuccessful, expected 204, got %s", new Object[] {
            httpclient
        });
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        list = list.getEntity();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        list = list.getContent();
        if (list != null)
        {
            try
            {
                list.close();
            }
            // Misplaced declaration of an exception variable
            catch (List list) { }
        }
        return false;
        list;
        list1 = list2;
        GLogger.e(TAG, "POST metric unsuccessful", new Object[0]);
        list1 = list2;
        GLogger.dx(TAG, "POST metric unsuccessful", list);
        list1 = list2;
        httppost.abort();
        if (list2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        list = list2.getEntity();
        if (list == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        list = list.getContent();
        if (list != null)
        {
            try
            {
                list.close();
            }
            // Misplaced declaration of an exception variable
            catch (List list) { }
        }
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_438;
_L2:
        break MISSING_BLOCK_LABEL_360;
        list;
        if (list1 == null)
        {
            break MISSING_BLOCK_LABEL_472;
        }
        httppost = list1.getEntity();
        if (httppost == null)
        {
            break MISSING_BLOCK_LABEL_472;
        }
        httppost = httppost.getContent();
        if (httppost != null)
        {
            try
            {
                httppost.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpPost httppost) { }
        }
        throw list;
    }

    public boolean send(List list)
    {
        Object obj1;
        Object obj2;
        if (GLogger.isLoggable(TAG, 2))
        {
            CustomerMetric customermetric;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); GLogger.v(TAG, customermetric.getMetricAsJson().toString(), new Object[0]))
            {
                customermetric = (CustomerMetric)iterator.next();
            }

        }
        if (list == null || list.isEmpty())
        {
            GLogger.i(TAG, "No metrics are gathered for uploaded", new Object[0]);
        }
        if (!connectivityMgr.isNetworkAccessAllowed(com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType.METRICS_UPLOAD))
        {
            GLogger.i(TAG, "Network is not available for customer metrics upload", new Object[0]);
        }
        long l = System.currentTimeMillis();
        String s = FORESTER_LOGGER_DATE_FORMATTER.format(Long.valueOf((l - l % 0x36ee80L) + 60000L));
        Object obj;
        boolean flag;
        try
        {
            obj1 = endpointMgr.getEndpoint().getHttpHostString();
        }
        catch (NoCredentialsException nocredentialsexception)
        {
            GLogger.v(TAG, "No account found. Use default endpoint.", new Object[0]);
            obj1 = "www.amazon.com";
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            GLogger.e(TAG, "Failed to extract endpoint", new Object[] {
                list
            });
            return false;
        }
        obj2 = (String)MARKETPLACE_TO_FORESTER_ENDPOINT.get(obj1);
        obj = obj2;
        if (obj2 == null)
        {
            GLogger.e(TAG, "Can't match forester endpoint for %s", new Object[] {
                obj1
            });
            obj = "https://fls-na.amazon.com";
        }
        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(((String) (obj)));
        ((StringBuilder) (obj1)).append("/");
        ((StringBuilder) (obj1)).append("1");
        ((StringBuilder) (obj1)).append("/");
        ((StringBuilder) (obj1)).append("clouddrive-photos");
        ((StringBuilder) (obj1)).append("/");
        ((StringBuilder) (obj1)).append("1");
        ((StringBuilder) (obj1)).append("/");
        ((StringBuilder) (obj1)).append("OE");
        ((StringBuilder) (obj1)).append("/");
        ((StringBuilder) (obj1)).append(s);
        GLogger.d(TAG, "Metric request: %s", new Object[] {
            ((StringBuilder) (obj1)).toString()
        });
        obj = new HttpPost();
        ((HttpPost) (obj)).setURI(URI.create(((StringBuilder) (obj1)).toString()));
        obj1 = AmazonHttpClientFactory.getHttpClient();
        obj2 = new ArrayList(30);
        list = list.iterator();
_L1:
        do
        {
            if (!list.hasNext())
            {
                break MISSING_BLOCK_LABEL_490;
            }
            ((List) (obj2)).add(list.next());
        } while (((List) (obj2)).size() != 30 && list.hasNext());
        flag = sendChunk(((List) (obj2)), ((HttpPost) (obj)), ((HttpClient) (obj1)));
        if (!flag)
        {
            IOException ioexception;
            if (obj1 instanceof Closeable)
            {
                try
                {
                    ((Closeable)obj1).close();
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    return false;
                }
            }
            return false;
        }
        ((List) (obj2)).clear();
          goto _L1
        list;
        if (obj1 instanceof Closeable)
        {
            try
            {
                ((Closeable)obj1).close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
        }
        throw list;
        if (obj1 instanceof Closeable)
        {
            try
            {
                ((Closeable)obj1).close();
            }
            // Misplaced declaration of an exception variable
            catch (List list) { }
        }
        return true;
    }

    static 
    {
        FORESTER_LOGGER_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        FORESTER_LOGGER_DATE_FORMATTER.setTimeZone(TimeZone.getTimeZone("gmt"));
        HashMap hashmap = new HashMap();
        hashmap.put("www.amazon.com", "https://fls-na.amazon.com");
        hashmap.put("www.amazon.ca", "https://fls-na.amazon.com");
        hashmap.put("www.amazon.co.uk", "https://fls-eu.amazon.com");
        hashmap.put("www.amazon.de", "https://fls-eu.amazon.com");
        hashmap.put("www.amazon.fr", "https://fls-eu.amazon.com");
        hashmap.put("www.amazon.it", "https://fls-eu.amazon.com");
        hashmap.put("www.amazon.es", "https://fls-eu.amazon.com");
        hashmap.put("www.amazon.co.jp", "https://fls-fe.amazon.com");
        hashmap.put("www.amazon.cn", "https://fls-cn.amazon.com");
        MARKETPLACE_TO_FORESTER_ENDPOINT = Collections.unmodifiableMap(hashmap);
    }
}

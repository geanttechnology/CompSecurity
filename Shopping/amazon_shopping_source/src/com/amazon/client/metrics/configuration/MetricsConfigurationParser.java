// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.amazon.client.metrics.Priority;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException, TransportType, BatchQueueConfiguration, BatchQueueType, 
//            NetworkType, MetricsNetworkConfiguration, CodecConfiguration, CodecType, 
//            HttpConfiguration, HttpRequestSignerType, MetricsBatchPipelineConfiguration, BatchTransmitterType, 
//            MetricsConfiguration

public class MetricsConfigurationParser
{

    private static final String TAG = "MetricsConfigurationParser";
    private static final DPLogger log = new DPLogger("MetricsConfigurationParser");
    private final InputStream mConfigurationInputStream;
    private boolean mIsDebuggable;

    public MetricsConfigurationParser(InputStream inputstream, ApplicationInfo applicationinfo)
    {
        boolean flag = false;
        super();
        mIsDebuggable = false;
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Configuration InputStream is null");
        }
        if (applicationinfo == null)
        {
            throw new IllegalArgumentException("ApplicationInfo is null");
        }
        mConfigurationInputStream = inputstream;
        if ((applicationinfo.flags & 2) != 0)
        {
            flag = true;
        }
        mIsDebuggable = flag;
    }

    private String readConfigurationInputStream()
        throws IOException
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(mConfigurationInputStream));
        Object obj = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        ((StringBuilder) (obj)).append(s);
          goto _L1
        obj;
        bufferedreader.close();
        throw obj;
        obj = ((StringBuilder) (obj)).toString();
        bufferedreader.close();
        return ((String) (obj));
    }

    public MetricsConfiguration parseConfiguration()
        throws MetricsConfigurationException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj = new JSONObject(readConfigurationInputStream());
        obj1 = MetricsConfiguration.Domain.DEVO.getName();
        obj2 = MetricsConfiguration.Domain.MASTER.getName();
        obj3 = MetricsConfiguration.Domain.PROD.getName();
        if (!((JSONObject) (obj)).has(((String) (obj1))) || !Build.TYPE.equals("eng") && !mIsDebuggable) goto _L2; else goto _L1
_L1:
        obj = ((JSONObject) (obj)).getJSONObject(((String) (obj1)));
        log.info("MetricsConfigurationParser", "Picking configuration", new Object[] {
            "Domain", "devo", "Build", Build.TYPE, "isDebuggable", Boolean.valueOf(mIsDebuggable)
        });
_L3:
        JSONObject jsonobject;
        obj2 = TransportType.fromString(((JSONObject) (obj)).getString("TransportType"));
        jsonobject = ((JSONObject) (obj)).optJSONObject("BatchQueueConfiguration");
        obj1 = null;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        obj1 = new BatchQueueConfiguration(BatchQueueType.fromString(jsonobject.getString("Type")), jsonobject.getString("DirectoryPrefix"));
        Object obj4;
        obj3 = new HashSet();
        obj4 = ((JSONObject) (obj)).getJSONArray("NetworkTypes");
        int i = 0;
        do
        {
            try
            {
                if (i >= ((JSONArray) (obj4)).length())
                {
                    break;
                }
                ((Set) (obj3)).add(NetworkType.fromString(((JSONArray) (obj4)).getString(i)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new MetricsConfigurationException("An IOException was throw was parsing the metrics configuration file", ((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new MetricsConfigurationException("An JSONException was throw was parsing the metrics configuration file", ((Throwable) (obj)));
            }
            i++;
        } while (true);
        break MISSING_BLOCK_LABEL_388;
_L2:
label0:
        {
            if (!((JSONObject) (obj)).has(((String) (obj2))) || !Build.TYPE.equals("userdebug"))
            {
                break label0;
            }
            obj = ((JSONObject) (obj)).getJSONObject(((String) (obj2)));
            log.info("MetricsConfigurationParser", "Picking configuration", new Object[] {
                "Domain", "master", "Build", Build.TYPE, "isDebuggable", Boolean.valueOf(mIsDebuggable)
            });
        }
          goto _L3
        obj = ((JSONObject) (obj)).getJSONObject(((String) (obj3)));
        log.info("MetricsConfigurationParser", "Picking configuration", new Object[] {
            "Domain", "prod", "Build", Build.TYPE, "isDebuggable", Boolean.valueOf(mIsDebuggable)
        });
          goto _L3
        MetricsNetworkConfiguration metricsnetworkconfiguration;
        CodecConfiguration codecconfiguration;
        metricsnetworkconfiguration = new MetricsNetworkConfiguration(((TransportType) (obj2)), ((Set) (obj3)));
        obj2 = ((JSONObject) (obj)).getJSONObject("CodecConfiguration");
        codecconfiguration = new CodecConfiguration(CodecType.fromString(((JSONObject) (obj2)).getString("Type")), ((JSONObject) (obj2)).getString("Version"));
        obj2 = ((JSONObject) (obj)).optJSONObject("HttpConfiguration");
        if (obj2 == null) goto _L5; else goto _L4
_L4:
        obj2 = new HttpConfiguration(HttpRequestSignerType.fromString(((JSONObject) (obj2)).getString("RequestSignerType")), ((JSONObject) (obj2)).getString("UrlEndpoint"), ((JSONObject) (obj2)).getString("StaticCredentialUrlEndpoint"));
_L15:
        JSONObject jsonobject1;
        HashMap hashmap;
        Iterator iterator;
        obj3 = new HashMap();
        ((Map) (obj3)).put("NormalPriority", Priority.NORMAL);
        ((Map) (obj3)).put("HighPriority", Priority.HIGH);
        ((Map) (obj3)).put("ReservedForLocationServicePriority", Priority.RESERVED_FOR_LOCATION_SERVICE);
        ((Map) (obj3)).put("ReservedForNonAnonymousMetricsPriority", Priority.RESERVED_FOR_NON_ANONYMOUS_METRICS);
        jsonobject1 = ((JSONObject) (obj)).getJSONObject("PipelineConfiguration");
        hashmap = new HashMap();
        iterator = ((Map) (obj3)).entrySet().iterator();
_L9:
        if (!iterator.hasNext()) goto _L7; else goto _L6
_L6:
        java.util.Map.Entry entry;
        JSONObject jsonobject2;
        entry = (java.util.Map.Entry)iterator.next();
        jsonobject2 = jsonobject1.optJSONObject((String)entry.getKey());
        if (jsonobject2 == null) goto _L9; else goto _L8
_L8:
        obj4 = jsonobject2.optString("BatchQueueType");
        obj3 = jsonobject2.optString("BatchQueueDirectoryPrefix");
        obj = obj4;
        if (obj4 != "") goto _L11; else goto _L10
_L10:
        if (jsonobject != null) goto _L13; else goto _L12
_L12:
        throw new JSONException((new StringBuilder()).append("Missing Batch Queue type for priority: ").append(entry.getValue()).toString());
_L5:
        obj3 = HttpRequestSignerType.OAUTH;
        if (Build.TYPE.equals("eng"))
        {
            obj2 = "https://dp-mont.integ.amazon.com:443";
        } else
        {
            obj2 = "https://device-metrics-us.amazon.com:443";
        }
        obj2 = new HttpConfiguration(((HttpRequestSignerType) (obj3)), ((String) (obj2)), "https://device-metrics-us-2.amazon.com:443");
        continue; /* Loop/switch isn't completed */
_L13:
        obj = jsonobject.getString("Type");
        obj3 = jsonobject.getString("DirectoryPrefix");
_L11:
        obj = new MetricsBatchPipelineConfiguration(BatchQueueType.fromString(((String) (obj))), ((String) (obj3)), jsonobject2.getLong("MaxBatchOpenTimeMillis"), jsonobject2.getLong("CheckBatchOpenTimeMillis"), jsonobject2.getInt("MaxBatchEntries"), jsonobject2.getInt("MaxBatchSizeBytes"), jsonobject2.getInt("MaxBatchQueueCapacityBytes"), jsonobject2.getInt("MaxBatchQueueEntries"), jsonobject2.getLong("ExpiryTimeMillis"), jsonobject2.getLong("PurgePeriodMillis"), jsonobject2.getLong("TransmissionPeriodMillis"), BatchTransmitterType.fromString(jsonobject2.getString("BatchTransmitterType")));
        hashmap.put(entry.getValue(), obj);
          goto _L9
_L7:
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_873;
        }
        return new MetricsConfiguration(metricsnetworkconfiguration, ((BatchQueueConfiguration) (obj1)), codecconfiguration, ((HttpConfiguration) (obj2)), hashmap);
        obj = new MetricsConfiguration(metricsnetworkconfiguration, codecconfiguration, ((HttpConfiguration) (obj2)), hashmap);
        return ((MetricsConfiguration) (obj));
        if (true) goto _L15; else goto _L14
_L14:
    }

}

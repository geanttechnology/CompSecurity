// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.configuration;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.Connectivity;
import com.amazon.insights.core.system.Preferences;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.core.configuration:
//            Configuration

public class HttpCachingConfiguration
    implements Configuration
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/core/configuration/HttpCachingConfiguration);
    private final ExecutorService backgroundExecutor;
    private final InsightsContext context;
    private AtomicBoolean isUpdateInProgress;
    private AtomicLong lastSync;
    private final Map overrideProperties;
    private Map properties;

    HttpCachingConfiguration(InsightsContext insightscontext, ExecutorService executorservice, Map map)
    {
        lastSync = new AtomicLong(0L);
        isUpdateInProgress = new AtomicBoolean(false);
        properties = new ConcurrentHashMap();
        Preconditions.checkNotNull(insightscontext);
        Preconditions.checkNotNull(executorservice);
        Preconditions.checkNotNull(map);
        context = insightscontext;
        overrideProperties = map;
        backgroundExecutor = executorservice;
        executorservice = null;
        map = getContext().getSystem().getPreferences();
        insightscontext = executorservice;
        if (map != null)
        {
            try
            {
                lastSync.set(map.getLong("configuration.lastSyncDate", 0L));
            }
            // Misplaced declaration of an exception variable
            catch (InsightsContext insightscontext)
            {
                lastSync.set(0L);
            }
            map = map.getString("configuration", null);
            insightscontext = executorservice;
            if (map != null)
            {
                try
                {
                    insightscontext = new JSONObject(map);
                }
                // Misplaced declaration of an exception variable
                catch (InsightsContext insightscontext)
                {
                    logger.e("could not create Json object of Config", insightscontext);
                    lastSync.set(0L);
                    insightscontext = executorservice;
                }
            }
        }
        updateMappings(insightscontext);
    }

    private void evaluateLastSync()
    {
        long l1 = 0x36ee80L;
        String s = (String)properties.get("syncInterval");
        long l = l1;
        if (s != null)
        {
            try
            {
                l = Long.decode(s).longValue();
            }
            catch (Exception exception)
            {
                logger.e(String.format("Could not get Long for propertyName: %s", new Object[] {
                    "syncInterval"
                }), exception);
                l = l1;
            }
        }
        if (System.currentTimeMillis() - getLastSync() > l)
        {
            syncConfiguration();
        }
    }

    private ExecutorService getBackgroundExecutor()
    {
        return backgroundExecutor;
    }

    private InsightsContext getContext()
    {
        return context;
    }

    private AtomicBoolean getIsUpdateInProgress()
    {
        return isUpdateInProgress;
    }

    private long getLastSync()
    {
        return lastSync.get();
    }

    public static HttpCachingConfiguration newInstance(InsightsContext insightscontext, Map map)
    {
        return new HttpCachingConfiguration(insightscontext, Executors.newSingleThreadExecutor(), map);
    }

    private String optStringInternal(String s, String s1)
    {
        s = (String)properties.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    private void updateMappings(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        if (jsonobject != null)
        {
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                try
                {
                    hashmap.put(s, jsonobject.getString(s));
                }
                catch (JSONException jsonexception)
                {
                    logger.e("could not update property mappings", jsonexception);
                }
            }

        }
        java.util.Map.Entry entry;
        for (jsonobject = overrideProperties.entrySet().iterator(); jsonobject.hasNext(); hashmap.put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)jsonobject.next();
        }

        properties.putAll(hashmap);
    }

    com.amazon.insights.core.http.HttpClient.Request createHttpRequest()
    {
        String s;
        com.amazon.insights.core.http.HttpClient.Request request;
        Id id;
        boolean flag;
        if (getContext().getHttpClient() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "An httpClient must be created in order to resolve configuration via http");
        s = String.format("%s/applications/%s/configuration", new Object[] {
            optStringInternal("configEndpoint", "https://applab-sdk.amazon.com/1.0"), getContext().getCredentials().getApplicationKey()
        });
        id = getContext().getUniqueId();
        request = createHttpRequestInstance();
        request.setUrl(s);
        request.setMethod(com.amazon.insights.core.http.HttpClient.HttpMethod.GET);
        if (id != null)
        {
            s = id.getValue();
        } else
        {
            s = "";
        }
        request.addHeader("x-amzn-UniqueId", s);
        return request;
    }

    com.amazon.insights.core.http.HttpClient.Request createHttpRequestInstance()
    {
        return context.getHttpClient().newRequest();
    }

    public Boolean getBoolean(String s)
    {
        Boolean boolean1;
        Object obj;
        String s1;
        obj = null;
        s1 = (String)properties.get(s);
        boolean1 = obj;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        boolean flag = Boolean.parseBoolean(s1);
        boolean1 = Boolean.valueOf(flag);
_L2:
        evaluateLastSync();
        return boolean1;
        Exception exception;
        exception;
        logger.e(String.format("Could not get Boolean for propertyName: %s", new Object[] {
            s
        }), exception);
        exception = obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Integer getInt(String s)
    {
        Object obj = null;
        String s1 = (String)properties.get(s);
        Integer integer = obj;
        if (s1 != null)
        {
            try
            {
                integer = Integer.decode(s1);
            }
            catch (Exception exception)
            {
                logger.e(String.format("Could not get Integer for propertyName: %s", new Object[] {
                    s
                }), exception);
                exception = obj;
            }
        }
        evaluateLastSync();
        return integer;
    }

    public Long getLong(String s)
    {
        Object obj = null;
        String s1 = (String)properties.get(s);
        Long long1 = obj;
        if (s1 != null)
        {
            try
            {
                long1 = Long.decode(s1);
            }
            catch (Exception exception)
            {
                logger.e(String.format("Could not get Long for propertyName: %s", new Object[] {
                    s
                }), exception);
                exception = obj;
            }
        }
        evaluateLastSync();
        return long1;
    }

    public String getString(String s)
    {
        s = (String)properties.get(s);
        evaluateLastSync();
        return s;
    }

    public Boolean optBoolean(String s, Boolean boolean1)
    {
        s = getBoolean(s);
        if (s != null)
        {
            return s;
        } else
        {
            return boolean1;
        }
    }

    public Integer optInt(String s, Integer integer)
    {
        s = getInt(s);
        if (s != null)
        {
            return s;
        } else
        {
            return integer;
        }
    }

    public Long optLong(String s, Long long1)
    {
        s = getLong(s);
        if (s != null)
        {
            return s;
        } else
        {
            return long1;
        }
    }

    public String optString(String s, String s1)
    {
        s = getString(s);
        if (s != null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    public void refresh()
    {
        evaluateLastSync();
    }

    void setLastSync(long l)
    {
        lastSync.set(l);
        getContext().getSystem().getPreferences().putLong("configuration.lastSyncDate", lastSync.get());
    }

    void syncConfiguration()
    {
        if (getIsUpdateInProgress().compareAndSet(false, true))
        {
            getBackgroundExecutor().submit(new Runnable() {

                final HttpCachingConfiguration this$0;

                public void run()
                {
                    String s = null;
                    com.amazon.insights.core.http.HttpClient.Request request;
                    if (!context.getSystem().getConnectivity().isConnected())
                    {
                        break MISSING_BLOCK_LABEL_382;
                    }
                    request = createHttpRequest();
                    Object obj = s;
                    if (request == null) goto _L2; else goto _L1
_L1:
                    Integer integer = Integer.valueOf(1);
                    obj = integer;
                    String s1;
                    if (!properties.containsKey("configRequestRetries"))
                    {
                        break MISSING_BLOCK_LABEL_99;
                    }
                    s1 = (String)properties.get("configRequestRetries");
                    obj = integer;
                    if (s1 == null)
                    {
                        break MISSING_BLOCK_LABEL_99;
                    }
                    obj = Integer.decode(s1);
_L5:
                    int i;
                    obj = getContext().getHttpClient().execute(request, ((Integer) (obj)));
                    i = ((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode();
                    if (i != 200) goto _L4; else goto _L3
_L3:
                    obj = new JSONObject(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getResponse());
_L2:
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_229;
                    }
                    s = ((JSONObject) (obj)).toString();
                    if (HttpCachingConfiguration.logger.isLoggingEnabled(com.amazon.insights.core.log.Logger.LogLevel.VERBOSE))
                    {
                        HttpCachingConfiguration.logger.v((new StringBuilder()).append("AppIntelligence config: ").append(s).toString());
                    }
                    getContext().getSystem().getPreferences().putString("configuration", s);
                    updateMappings(((JSONObject) (obj)));
_L6:
                    long l = System.currentTimeMillis();
                    setLastSync(l);
                    getIsUpdateInProgress().set(false);
                    return;
                    obj;
                    HttpCachingConfiguration.logger.e(String.format("Could not get the http request retry value", new Object[0]), ((Throwable) (obj)));
                    obj = integer;
                      goto _L5
                    obj;
                    HttpCachingConfiguration.logger.e("There was an error while attempting to sync the configuration", ((Throwable) (obj)));
                    getIsUpdateInProgress().set(false);
                    return;
                    obj;
                    HttpCachingConfiguration.logger.e("error parsing service response", ((Throwable) (obj)));
                    obj = s;
                      goto _L2
                    obj;
                    getIsUpdateInProgress().set(false);
                    throw obj;
_L4:
                    HttpCachingConfiguration.logger.e((new StringBuilder()).append("service error: ").append(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getMessage()).append("(").append(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode()).append(")").toString());
                    obj = s;
                      goto _L2
                    HttpCachingConfiguration.logger.v("Device not connected to sync config");
                      goto _L6
                }

            
            {
                this$0 = HttpCachingConfiguration.this;
                super();
            }
            });
        }
    }







}

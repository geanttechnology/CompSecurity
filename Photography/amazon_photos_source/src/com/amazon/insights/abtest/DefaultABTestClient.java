// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest;

import com.amazon.insights.ABTestClient;
import com.amazon.insights.Event;
import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.InsightsHandler;
import com.amazon.insights.UserProfile;
import com.amazon.insights.Variation;
import com.amazon.insights.VariationSet;
import com.amazon.insights.abtest.cache.VariationCache;
import com.amazon.insights.abtest.cache.VariationCaches;
import com.amazon.insights.core.DefaultInsightsHandler;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.http.HttpUtil;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.Connectivity;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.Preconditions;
import com.amazon.insights.core.util.StringUtil;
import com.amazon.insights.error.InvalidArgumentError;
import com.amazon.insights.error.NullArgumentError;
import com.amazon.insights.error.UnexpectedError;
import com.amazon.insights.event.InternalEventClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.abtest:
//            DefaultVariation

public class DefaultABTestClient
    implements ABTestClient
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/abtest/DefaultABTestClient);
    private final Map appliedVariationIds = new ConcurrentHashMap();
    private final InsightsContext context;
    private final InternalEventClient eventClient;
    private final ExecutorService executor;
    private final VariationCache variationCache;

    DefaultABTestClient(InsightsContext insightscontext, ExecutorService executorservice, InternalEventClient internaleventclient, VariationCache variationcache)
    {
        Preconditions.checkNotNull(insightscontext, "A valid context wrapper must be provided");
        Preconditions.checkNotNull(executorservice, "A valid ExecutorService must be provided");
        executor = executorservice;
        context = insightscontext;
        eventClient = internaleventclient;
        variationCache = variationcache;
        setAppliedVariationIdsAsGlobalAttribute(variationcache.getAll());
    }

    private DefaultInsightsHandler allocateVariations(final Set projectNames, final DefaultInsightsHandler getVariationHandler)
    {
        final AtomicReference dimensions = new AtomicReference(null);
        if (context.getUserProfile() != null && context.getUserProfile().getDimensions() != null)
        {
            dimensions.set(new HashMap(context.getUserProfile().getDimensions()));
        }
        executor.submit(new Runnable() {

            final DefaultABTestClient this$0;
            final AtomicReference val$dimensions;
            final DefaultInsightsHandler val$getVariationHandler;
            final Set val$projectNames;

            public void run()
            {
                Object obj;
                ArrayList arraylist;
                Object obj1;
                int i;
                int j;
                int k;
                try
                {
                    arraylist = new ArrayList(projectNames);
                    k = getMaxAllocations();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    getVariationHandler.onError(new UnexpectedError("An unexpected error occurred. Retrieval of variations could not be completed", ((Exception) (obj))));
                    DefaultABTestClient.logger.e("An unexpected error occurred attempting to get variations", ((Throwable) (obj)));
                    return;
                }
                i = 0;
                obj = new ConcurrentHashMap();
_L3:
                if (i >= arraylist.size())
                {
                    break MISSING_BLOCK_LABEL_173;
                }
                obj1 = new HashSet();
                j = 0;
_L2:
                if (j >= k)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (i >= arraylist.size())
                {
                    break; /* Loop/switch isn't completed */
                }
                ((Set) (obj1)).add(arraylist.get(i));
                j++;
                i++;
                if (true) goto _L2; else goto _L1
_L1:
                obj1 = allocateDefaultVariations(((Set) (obj1)), ((Map) (obj)));
                obj1 = allocateCachedVariations(((Set) (obj1)), ((Map) (obj)));
                allocateServerVariations(((Set) (obj1)), ((Map) (obj)), (Map)dimensions.get());
                  goto _L3
                Iterator iterator = ((Map) (obj)).entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if (((DefaultVariation)entry.getValue()).isDefault())
                    {
                        DefaultABTestClient.logger.devw((new StringBuilder()).append("Resolved default variation: '").append(((DefaultVariation)entry.getValue()).getName()).append("' for project: '").append((String)entry.getKey()).append("'").toString());
                    }
                } while (true);
                getVariationHandler.onComplete(((_cls1) (obj)). new VariationSet() {

                    final _cls1 this$1;
                    final Map val$variations;

                    public boolean contains(String s)
                    {
                        return variations.containsKey(s);
                    }

                    public Variation getVariation(String s)
                    {
                        if (contains(s))
                        {
                            s = (Variation)variations.get(s);
                            setVariationIdsFromAllocatedVariation((DefaultVariation)s);
                            return s;
                        }
                        DefaultVariation.Builder builder = new DefaultVariation.Builder();
                        String s1 = s;
                        if (s == null)
                        {
                            s1 = "UNKNOWN";
                        }
                        return builder.setProjectName(s1).setApplicationKey(context.getCredentials().getApplicationKey()).setUniqueId(context.getUniqueId()).build();
                    }

                    public Iterator iterator()
                    {
                        return variations.values().iterator(). new Iterator() {

                            final _cls1 this$2;
                            final Iterator val$iter;

                            public boolean hasNext()
                            {
                                return iter.hasNext();
                            }

                            public Variation next()
                            {
                                Variation variation = (Variation)iter.next();
                                setVariationIdsFromAllocatedVariation((DefaultVariation)variation);
                                return variation;
                            }

                            public volatile Object next()
                            {
                                return next();
                            }

                            public void remove()
                            {
                                throw new UnsupportedOperationException("This iterator does not support removal of variations");
                            }

            
            {
                this$2 = final__pcls1;
                iter = Iterator.this;
                super();
            }
                        };
                    }

            
            {
                this$1 = final__pcls1;
                variations = Map.this;
                super();
            }
                });
                return;
            }

            
            {
                this$0 = DefaultABTestClient.this;
                projectNames = set;
                dimensions = atomicreference;
                getVariationHandler = defaultinsightshandler;
                super();
            }
        });
        return getVariationHandler;
    }

    private String getEndpointUrl()
    {
        return context.getConfiguration().optString("projectEndpoint", "https://applab-sdk.amazon.com/1.0");
    }

    private int getMaxAllocations()
    {
        return context.getConfiguration().optInt("maxAllocations", Integer.valueOf(10)).intValue();
    }

    public static DefaultABTestClient newInstance(InsightsContext insightscontext, InternalEventClient internaleventclient)
    {
        VariationCache variationcache = VariationCaches.tryGetFileVariationCache(insightscontext);
        return new DefaultABTestClient(insightscontext, Executors.newFixedThreadPool(2), internaleventclient, variationcache);
    }

    private void setAppliedVariationIdsAsGlobalAttribute(Map map)
    {
        boolean flag1 = true;
        Preconditions.checkNotNull(map);
        boolean flag;
        if (appliedVariationIds != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        if (eventClient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); appliedVariationIds.put(entry.getKey(), Long.valueOf(((DefaultVariation)entry.getValue()).getVariationId())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        eventClient.removeGlobalAttribute("_treatment_ids");
        eventClient.addGlobalAttribute("_treatment_ids", (new JSONArray(appliedVariationIds.values())).toString());
    }

    static JSONObject variationToHttpRequest(DefaultVariation defaultvariation)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("experimentName", defaultvariation.getProjectName());
            if (!defaultvariation.isDefault())
            {
                jsonobject.put("experimentId", defaultvariation.getExperimentId());
                jsonobject.put("treatmentId", defaultvariation.getVariationId());
                jsonobject.put("treatmentGroup", defaultvariation.getName());
                jsonobject.put("uniqueId", defaultvariation.getUniqueId().getValue());
            }
        }
        // Misplaced declaration of an exception variable
        catch (DefaultVariation defaultvariation)
        {
            return null;
        }
        return jsonobject;
    }

    Set allocateCachedVariations(Set set, Map map)
    {
        Preconditions.checkNotNull(set, "The set of project names must not be null");
        Preconditions.checkNotNull(map, "The map of variations must not be null");
        if (set.size() != 0)
        {
            Iterator iterator = variationCache.get(set).values().iterator();
            while (iterator.hasNext()) 
            {
                DefaultVariation defaultvariation = (DefaultVariation)iterator.next();
                if (!defaultvariation.isExpired())
                {
                    set.remove(defaultvariation.getProjectName());
                }
                map.put(defaultvariation.getProjectName(), defaultvariation);
                Logger logger1 = logger;
                StringBuilder stringbuilder = (new StringBuilder()).append("Resolved ");
                String s;
                if (defaultvariation.isExpired())
                {
                    s = "expired";
                } else
                {
                    s = "unexpired";
                }
                logger1.devi(stringbuilder.append(s).append(" variation: '").append(defaultvariation.getName()).append("' for project: '").append(defaultvariation.getProjectName()).append("' from cache").toString());
            }
        }
        return set;
    }

    Set allocateDefaultVariations(Set set, Map map)
    {
        Preconditions.checkNotNull(set, "The set of project names must not be null");
        Preconditions.checkNotNull(map, "The map of variations must not be null");
        if (set.size() != 0)
        {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                map.put(s, (new DefaultVariation.Builder()).setProjectName(s).setApplicationKey(context.getCredentials().getApplicationKey()).setUniqueId(context.getUniqueId()).build());
            }
        }
        return set;
    }

    Set allocateServerVariations(Set set, Map map, Map map1)
    {
        Preconditions.checkNotNull(set, "The set of project names must not be null");
        Preconditions.checkNotNull(map, "The map of variations must not be null");
        while (set.size() == 0 || !context.getConfiguration().optBoolean("isABTestEnabled", Boolean.valueOf(true)).booleanValue() || !canHandleRequest()) 
        {
            return set;
        }
        map1 = createHttpRequest(set, map, map1);
        if (map1 == null)
        {
            logger.e("There was an error when building the http request");
            return set;
        }
        map1 = context.getHttpClient().execute(map1, context.getConfiguration().optInt("allocationRequestRetries", Integer.valueOf(1)));
        if (map1 == null)
        {
            logger.deve("No variations were retrieved from the server");
            logger.e("The http request returned a null http response");
            return set;
        }
        if (map1.getCode() == 200)
        {
            map1 = parseVariationResponse(map1.getResponse());
            java.util.Map.Entry entry;
            for (Iterator iterator = map1.entrySet().iterator(); iterator.hasNext(); map.put(entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
                if (set.contains(entry.getKey()))
                {
                    set.remove(entry.getKey());
                }
            }

            cacheVariations(map1);
            return set;
        } else
        {
            logger.devw((new StringBuilder()).append("Unable to successfully retrieve variations from server. Response code (").append(map1.getCode()).append(") ").append(HttpUtil.getMessageForResponse(map1)).toString());
            logger.w((new StringBuilder()).append("Recieved a bad response: ").append(map1).toString());
            return set;
        }
    }

    JSONObject buildAllocationRequest(Set set, Map map)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("uniqueId", context.getUniqueId().getValue());
        JSONArray jsonarray = new JSONArray();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            JSONObject jsonobject1 = variationToHttpRequest((DefaultVariation)map.get((String)set.next()));
            if (jsonobject1 != null)
            {
                jsonarray.put(jsonobject1);
            }
        } while (true);
        if (jsonarray.length() > 0)
        {
            jsonobject.put("treatmentRequests", jsonarray);
        }
        return jsonobject;
    }

    String buildRequestBody(Set set, Map map, Map map1)
    {
        JSONObject jsonobject;
        if (set == null || set.size() == 0)
        {
            return null;
        }
        jsonobject = new JSONObject();
        map1 = buildUserProfile(map1);
        set = buildAllocationRequest(set, map);
        if (set == null) goto _L2; else goto _L1
_L1:
        jsonobject.put("treatmentAllocationRequest", set);
        set = jsonobject;
        if (map1 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        jsonobject.put("userProfile", map1);
        set = jsonobject;
_L3:
        if (set != null)
        {
            set = set.toString();
            logger.i((new StringBuilder()).append("Request: ").append(set).toString());
            return set;
        } else
        {
            logger.e("Request body is null");
            return null;
        }
_L2:
        logger.deve("Request for variations was empty");
        logger.e("Allocation request is null");
        return null;
        map;
        set = null;
        logger.e("Error building the server request", map);
          goto _L3
    }

    JSONObject buildUserProfile(Map map)
        throws JSONException
    {
        if (map != null && map.size() != 0) goto _L2; else goto _L1
_L1:
        map = null;
_L4:
        return map;
_L2:
        JSONObject jsonobject = new JSONObject();
        Iterator iterator = map.entrySet().iterator();
        do
        {
            map = jsonobject;
            if (!iterator.hasNext())
            {
                continue;
            }
            map = (java.util.Map.Entry)iterator.next();
            if (java/lang/Number.isAssignableFrom(map.getValue().getClass()))
            {
                jsonobject.put((String)map.getKey(), map.getValue());
            } else
            if (java/lang/Boolean.isAssignableFrom(map.getValue().getClass()))
            {
                jsonobject.put((String)map.getKey(), map.getValue());
            } else
            if (map.getValue().getClass().equals(java/lang/String))
            {
                jsonobject.put((String)map.getKey(), map.getValue());
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    void cacheVariations(Map map)
    {
        map = map.values().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            DefaultVariation defaultvariation = (DefaultVariation)map.next();
            if (!defaultvariation.isDefault())
            {
                variationCache.put(defaultvariation);
            }
        } while (true);
    }

    protected boolean canHandleRequest()
    {
        boolean flag = context.getSystem().getConnectivity().isConnected();
        if (!flag)
        {
            logger.devw("Cannot retrieve variations from server due to the device not being connected");
        }
        return flag;
    }

    com.amazon.insights.core.http.HttpClient.Request createHttpRequest(Set set, Map map, Map map1)
    {
        Preconditions.checkNotNull(set, "An allocation request must be provided");
        com.amazon.insights.core.http.HttpClient.Request request;
        boolean flag;
        if (set.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "At least one project must be specified");
        request = context.getHttpClient().newRequest().setUrl(String.format("%s/applications/%s/treatments", new Object[] {
            getEndpointUrl(), context.getCredentials().getApplicationKey()
        })).setMethod(com.amazon.insights.core.http.HttpClient.HttpMethod.POST);
        set = buildRequestBody(set, map, map1);
        if (set == null)
        {
            return null;
        } else
        {
            request.setPostBody(set);
            return request;
        }
    }

    public transient InsightsHandler getVariations(String as[])
    {
        DefaultInsightsHandler defaultinsightshandler = new DefaultInsightsHandler();
        if (as == null || as.length <= 0) goto _L2; else goto _L1
_L1:
        HashSet hashset;
        hashset = new HashSet();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (s != null && !hashset.contains(s))
            {
                hashset.add(s);
            }
        }

        if (hashset.size() <= 0) goto _L4; else goto _L3
_L3:
        logger.devi((new StringBuilder()).append("Attempting to retrieve variation(s) for project(s):").append(StringUtil.convertSetToString(hashset)).toString());
        allocateVariations(hashset, defaultinsightshandler);
_L6:
        return defaultinsightshandler;
_L4:
        defaultinsightshandler.onError(new InvalidArgumentError("projectNames", "getVariation", "No project names were provided."));
        return defaultinsightshandler;
_L2:
        if (as == null)
        {
            defaultinsightshandler.onError(new NullArgumentError("projectNames", "getVariation"));
            return defaultinsightshandler;
        }
        if (as.length == 0)
        {
            defaultinsightshandler.onError(new InvalidArgumentError("projectNames", "getVariation", "No project names were provided."));
            return defaultinsightshandler;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    Map parseVariationResponse(String s)
    {
        ConcurrentHashMap concurrenthashmap = new ConcurrentHashMap();
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        return concurrenthashmap;
_L2:
        Id id;
        Object obj;
        obj = new JSONObject(s);
        s = ((JSONObject) (obj)).getString("applicationKey");
        id = Id.valueOf(((JSONObject) (obj)).getString("uniqueId"));
        if (((JSONObject) (obj)).isNull("treatments")) goto _L1; else goto _L3
_L3:
        obj = ((JSONObject) (obj)).getJSONArray("treatments");
        int i = 0;
_L9:
        if (i >= ((JSONArray) (obj)).length()) goto _L1; else goto _L4
_L4:
        DefaultVariation.Builder builder;
        Object obj1;
        builder = new DefaultVariation.Builder();
        builder.setApplicationKey(s);
        builder.setUniqueId(id);
        obj1 = ((JSONArray) (obj)).getJSONObject(i);
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        builder.setExperimentId(((JSONObject) (obj1)).getLong("experimentId"));
        builder.setVariationId(((JSONObject) (obj1)).getLong("treatmentId"));
        builder.setProjectName(((JSONObject) (obj1)).getString("experimentName"));
        builder.setVariationName(((JSONObject) (obj1)).getString("treatmentGroup"));
        builder.setExpirationDate(new Date(((JSONObject) (obj1)).getLong("expirationDate")));
        builder.setAllocationSource(DefaultVariation.AllocationSource.SERVER);
        if (((JSONObject) (obj1)).isNull("factors")) goto _L6; else goto _L7
_L7:
        obj1 = ((JSONObject) (obj1)).getJSONArray("factors");
        if (obj1 == null) goto _L6; else goto _L8
_L8:
        int j;
        HashMap hashmap;
        JSONObject jsonobject;
        try
        {
            hashmap = new HashMap();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                logger.deve("There was an issue parsing the variation(s) received from the server");
                logger.e("Error parsing the variation response.", s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                logger.deve("There was an issue parsing the variation(s) received from the server");
                logger.e("Error parsing the server response body.", s);
                return concurrenthashmap;
            }
            return concurrenthashmap;
        }
        j = 0;
_L10:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break MISSING_BLOCK_LABEL_296;
        }
        jsonobject = ((JSONArray) (obj1)).getJSONObject(j);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        hashmap.put(jsonobject.getString("name"), jsonobject.getString("value"));
        break MISSING_BLOCK_LABEL_424;
        builder.setVariables(hashmap);
_L6:
        concurrenthashmap.put(builder.getProjectName(), builder.build());
        logger.devi((new StringBuilder()).append("Resolved variation: '").append(builder.getVariationName()).append("' for project: '").append(builder.getProjectName()).append("' from server").toString());
        i++;
          goto _L9
        j++;
          goto _L10
    }

    public void setVariationIdsFromAllocatedVariation(DefaultVariation defaultvariation)
    {
        Long long1;
        boolean flag;
        if (eventClient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "An event client must be provided");
        this;
        JVM INSTR monitorenter ;
        if (!appliedVariationIds.containsKey(defaultvariation.getProjectName()))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        long1 = (Long)appliedVariationIds.get(defaultvariation.getProjectName());
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (!long1.equals(Long.valueOf(defaultvariation.getVariationId())))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!defaultvariation.isDefault())
        {
            break MISSING_BLOCK_LABEL_251;
        }
        appliedVariationIds.remove(defaultvariation.getProjectName());
_L1:
        eventClient.removeGlobalAttribute("_treatment_ids");
        eventClient.addGlobalAttribute("_treatment_ids", (new JSONArray(appliedVariationIds.values())).toString());
        this;
        JVM INSTR monitorexit ;
        if (!defaultvariation.isDefault())
        {
            defaultvariation = eventClient.createEvent("_TreatmentsAllocated").withAttribute("_treatment_group", defaultvariation.getName()).withAttribute("_treatment_id", Long.toString(defaultvariation.getVariationId())).withAttribute("_experiment_id", Long.toString(defaultvariation.getExperimentId())).withAttribute("_application_key", defaultvariation.getApplicationKey()).withAttribute("_source", defaultvariation.getAllocationSource().name()).withMetric("_applied_date", Long.valueOf(System.currentTimeMillis()));
            eventClient.recordEvent(defaultvariation, false);
            return;
        } else
        {
            return;
        }
        appliedVariationIds.put(defaultvariation.getProjectName(), Long.valueOf(defaultvariation.getVariationId()));
          goto _L1
        defaultvariation;
        this;
        JVM INSTR monitorexit ;
        throw defaultvariation;
    }




}

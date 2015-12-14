// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.CloudDriveSubscription;
import com.amazon.clouddrive.extended.model.GetServicePlansRequest;
import com.amazon.clouddrive.extended.model.GetServicePlansResponse;
import com.amazon.clouddrive.extended.model.GetSplashRequest;
import com.amazon.clouddrive.extended.model.GetSplashResponse;
import com.amazon.clouddrive.extended.model.GetSubscriptionsRequest;
import com.amazon.clouddrive.extended.model.GetSubscriptionsResponse;
import com.amazon.clouddrive.extended.model.ServicePlan;
import com.amazon.clouddrive.extended.model.deserializer.CloudDriveSubscriptionDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.ServicePlanDeserializer;
import com.amazon.clouddrive.extended.model.serializer.CloudDriveSubscriptionSerializer;
import com.amazon.clouddrive.extended.model.serializer.ServicePlanSerializer;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.kindle.AutoUploadNotification;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.upload.UploadPreferences;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.json.JSONException;

public class SubscriptionInfoCache
    implements AccountChangeListener
{
    private static interface KeyFetcher
    {

        public abstract String getKey(Object obj);
    }

    public static class Promotion
    {

        private final String id;
        private final String title;
        private final String url;

        public String getId()
        {
            return id;
        }

        public String getTitle()
        {
            return title;
        }

        public String getUrl()
        {
            return url;
        }

        public Promotion(String s, String s1, String s2)
        {
            title = s;
            url = s1;
            id = s2;
        }
    }

    private static class PromotionFetcher extends Thread
    {

        private final CloudDriveServiceClientManager cloudDriveServiceClientManager;
        private final CountDownLatch latch;
        private final GetSplashRequest request;
        private GetSplashResponse response;

        public GetSplashResponse getResponse()
        {
            return response;
        }

        public void run()
        {
            response = cloudDriveServiceClientManager.getForegroundCdsClient().getSplash(request);
            latch.countDown();
            return;
            Object obj;
            obj;
_L2:
            GLogger.i(SubscriptionInfoCache.TAG, "problem fetching splash URL: %s", new Object[] {
                obj
            });
            latch.countDown();
            return;
            obj;
            latch.countDown();
            throw obj;
            obj;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public PromotionFetcher(CloudDriveServiceClientManager clouddriveserviceclientmanager, CountDownLatch countdownlatch, GetSplashRequest getsplashrequest)
        {
            cloudDriveServiceClientManager = clouddriveserviceclientmanager;
            latch = countdownlatch;
            request = getsplashrequest;
        }
    }


    private static final Promotion DEBUG_PROMOTION = new Promotion("test promotion", "http://www.amazon.com/gp/drive/subscription.html?deviceClass=firetablets&language=en_US", "999");
    private static final String TAG = com/amazon/gallery/framework/network/http/rest/account/SubscriptionInfoCache.getName();
    private Map availableSubscriptions;
    private CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private final BeanAwareApplication context;
    private ExecutorService executor;
    private AsyncTask fetchingTask;
    private boolean hasNewData;
    private JsonFactory jsonFactory;
    private long lastSubscriptionCheckTime;
    private boolean promotionCheckOccurredInThisSession;
    private SharedPreferences sharedPreferences;
    private Map subscriptions;
    private boolean useRealSplashScreenCall;

    public SubscriptionInfoCache(BeanAwareApplication beanawareapplication)
    {
        executor = Executors.newSingleThreadExecutor(new NamedThreadFactory(com/amazon/gallery/framework/network/http/rest/account/SubscriptionInfoCache.getSimpleName()));
        jsonFactory = new JsonFactory();
        promotionCheckOccurredInThisSession = false;
        context = beanawareapplication;
        executor.execute(new Runnable() {

            final SubscriptionInfoCache this$0;

            public void run()
            {
                init();
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                super();
            }
        });
    }

    private void clearCaches()
    {
        subscriptions.clear();
        availableSubscriptions.clear();
        lastSubscriptionCheckTime = 0L;
        hasNewData = true;
        fetchingTask = null;
        promotionCheckOccurredInThisSession = false;
        flush();
    }

    private void deserialize(String s)
        throws JSONException
    {
        if (!s.equals("") && !s.equals(null)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            s = jsonFactory.createJsonParser(s);
            JsonToken jsontoken = s.nextToken();
            if (jsontoken != JsonToken.START_OBJECT)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), s.getTokenLocation());
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.ex(TAG, "Error parsing SubscriptionInfoCache", s);
            return;
        }
          goto _L3
_L5:
        Object obj;
        if (!"lastSubscriptionCheckTime".equals(obj))
        {
            break MISSING_BLOCK_LABEL_350;
        }
        lastSubscriptionCheckTime = s.nextLongValue(0L);
_L3:
        while (s.nextToken() != JsonToken.END_OBJECT) 
        {
            if (s.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected field name, got ").append(s.getCurrentToken()).toString(), s.getTokenLocation());
            }
            obj = s.getCurrentName();
            if (!"subscriptions".equals(obj))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (s.nextToken() != JsonToken.START_ARRAY)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected start of array, got ").append(s.getCurrentToken()).toString(), s.getTokenLocation());
            }
            while (s.nextToken() != JsonToken.END_ARRAY) 
            {
                obj = (CloudDriveSubscription)CloudDriveSubscriptionDeserializer.INSTANCE.deserialize(s);
                subscriptions.put(((CloudDriveSubscription) (obj)).getPlanId(), obj);
            }
        }
          goto _L1
        if (!"availableSubscriptions".equals(obj)) goto _L5; else goto _L4
_L4:
        if (s.nextToken() != JsonToken.START_ARRAY)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of array, got ").append(s.getCurrentToken()).toString(), s.getTokenLocation());
        }
        while (s.nextToken() != JsonToken.END_ARRAY) 
        {
            obj = (ServicePlan)ServicePlanDeserializer.INSTANCE.deserialize(s);
            availableSubscriptions.put(((ServicePlan) (obj)).getPlanId(), obj);
        }
          goto _L3
        GLogger.i(TAG, (new StringBuilder()).append("Unexpected token when parsing SubscriptionInfoCache").append(((String) (obj))).toString(), new Object[0]);
        s.skipChildren();
          goto _L3
    }

    private Promotion doPromotionNetworkCall(long l)
    {
        GetSplashResponse getsplashresponse;
        Object obj;
        Object obj1;
        obj = new CountDownLatch(1);
        getsplashresponse = null;
        obj1 = new GetSplashRequest();
        ((GetSplashRequest) (obj1)).setLanguage(Locale.getDefault().toString());
        ((GetSplashRequest) (obj1)).setDeviceType(((DeviceAttributeStore)context.getBeanFactory().getBean(Keys.DEVICE_ATTRIBUTE_STORE)).getDeviceTypeId());
        obj1 = new PromotionFetcher(cloudDriveServiceClientManager, ((CountDownLatch) (obj)), ((GetSplashRequest) (obj1)));
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        ((PromotionFetcher) (obj1)).start();
        ((CountDownLatch) (obj)).await(l, TimeUnit.MILLISECONDS);
_L3:
        obj = ((PromotionFetcher) (obj1)).getResponse();
        getsplashresponse = ((GetSplashResponse) (obj));
_L4:
        InterruptedException interruptedexception;
        if (getsplashresponse != null && !StringUtils.isEmpty(getsplashresponse.getUrl()))
        {
            return new Promotion(getsplashresponse.getSplashText(), getsplashresponse.getUrl(), getsplashresponse.getSplashId());
        } else
        {
            return null;
        }
_L2:
        ((PromotionFetcher) (obj1)).run();
          goto _L3
        interruptedexception;
        GLogger.wx(TAG, "get promotion call interrupted", interruptedexception);
        Thread.currentThread().interrupt();
          goto _L4
    }

    private void fetchAvailableSubscriptions()
    {
        Object obj = new GetServicePlansRequest();
        obj = cloudDriveServiceClientManager.getForegroundCdsClient().getServicePlans(((GetServicePlansRequest) (obj)));
        obj = ((GetServicePlansResponse) (obj)).getServicePlansList();
        HashMap hashmap = new HashMap();
        hasNewData = getAndCheckForChange(((List) (obj)), hashmap, availableSubscriptions, new KeyFetcher() {

            final SubscriptionInfoCache this$0;

            public String getKey(ServicePlan serviceplan)
            {
                return serviceplan.getPlanId();
            }

            public volatile String getKey(Object obj2)
            {
                return getKey((ServicePlan)obj2);
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                super();
            }
        });
        availableSubscriptions = hashmap;
        flush();
        return;
        Object obj1;
        obj1;
_L2:
        GLogger.i(TAG, "error getting service plans: %s", new Object[] {
            ((Exception) (obj1)).getMessage()
        });
        return;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void fetchSubscriptions()
    {
        Object obj = new GetSubscriptionsRequest();
        try
        {
            obj = cloudDriveServiceClientManager.getForegroundCdsClient().getSubscriptions(((GetSubscriptionsRequest) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            GLogger.ex(TAG, "Error getting subscriptions", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            GLogger.d(TAG, "Error getting subscriptions - interrupted", new Object[0]);
            return;
        }
        if (obj == null)
        {
            GLogger.errorStackTrace(TAG, "Error getting subscriptions: Response null", new Object[0]);
            return;
        }
        Object obj1 = ((GetSubscriptionsResponse) (obj)).getSubscriptionsList();
        obj = new HashMap();
        hasNewData = getAndCheckForChange(((List) (obj1)), ((Map) (obj)), subscriptions, new KeyFetcher() {

            final SubscriptionInfoCache this$0;

            public String getKey(CloudDriveSubscription clouddrivesubscription2)
            {
                return clouddrivesubscription2.getPlanId();
            }

            public volatile String getKey(Object obj2)
            {
                return getKey((CloudDriveSubscription)obj2);
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                super();
            }
        });
        if (hasNewData)
        {
            obj1 = ((List) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                CloudDriveSubscription clouddrivesubscription = (CloudDriveSubscription)((Iterator) (obj1)).next();
                CloudDriveSubscription clouddrivesubscription1 = (CloudDriveSubscription)subscriptions.get(clouddrivesubscription.getPlanId());
                if (clouddrivesubscription1 == null || !clouddrivesubscription1.equals(clouddrivesubscription))
                {
                    onSubscriptionAdded(clouddrivesubscription);
                }
            } while (true);
        }
        subscriptions = ((Map) (obj));
        flush();
    }

    private void flush()
    {
        if (!hasNewData)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        sharedPreferences.edit().putString("SERIALIZED_ACCOUNT_INFO", serialize()).apply();
        return;
        JSONException jsonexception;
        jsonexception;
        GLogger.ex(TAG, "error in serializing out account info", jsonexception);
        return;
    }

    private boolean getAndCheckForChange(List list, Map map, Map map1, KeyFetcher keyfetcher)
    {
        boolean flag = false;
        Object obj;
        for (list = list.iterator(); list.hasNext(); map.put(keyfetcher.getKey(obj), obj))
        {
            obj = list.next();
            Object obj1 = map1.get(keyfetcher.getKey(obj));
            if (obj1 == null || !obj1.equals(obj))
            {
                flag = true;
            }
        }

        if (map1.size() != map.size())
        {
            flag = true;
        }
        return flag;
    }

    private void init()
    {
        hasNewData = false;
        availableSubscriptions = new HashMap();
        subscriptions = new HashMap();
        lastSubscriptionCheckTime = 0L;
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)context.getBeanFactory().getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        sharedPreferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        useRealSplashScreenCall = sharedPreferences.getBoolean("USE_REAL_SPLASH_CALL", true);
        if (!sharedPreferences.contains("SERIALIZED_ACCOUNT_INFO"))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        deserialize(sharedPreferences.getString("SERIALIZED_ACCOUNT_INFO", ""));
        return;
        JSONException jsonexception;
        jsonexception;
        GLogger.ex(TAG, "error deserializing subs", jsonexception);
        return;
    }

    private void onSubscriptionAdded(CloudDriveSubscription clouddrivesubscription)
    {
        if (!(new UploadPreferences(context)).isAutoUploadEnabled() && !AutoUploadNotification.isDialogShowing())
        {
            AutoUploadNotification.shouldNotShowNotification(context, false);
        }
    }

    private String serialize()
        throws JSONException
    {
        Object obj;
        JsonGenerator jsongenerator;
        obj = new StringWriter();
        try
        {
            jsongenerator = jsonFactory.createJsonGenerator(((java.io.Writer) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            GLogger.ex(TAG, "Error creating json factory", ((Throwable) (obj)));
            return "";
        }
        try
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("subscriptions");
            jsongenerator.writeStartArray();
            CloudDriveSubscription clouddrivesubscription;
            for (Iterator iterator = subscriptions.values().iterator(); iterator.hasNext(); CloudDriveSubscriptionSerializer.INSTANCE.serialize(clouddrivesubscription, jsongenerator))
            {
                clouddrivesubscription = (CloudDriveSubscription)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            GLogger.ex(TAG, "Error serializing SubscriptionInfoCache", ((Throwable) (obj)));
            return "";
        }
        jsongenerator.writeEndArray();
        jsongenerator.writeFieldName("availableSubscriptions");
        jsongenerator.writeStartArray();
        ServicePlan serviceplan;
        for (Iterator iterator1 = availableSubscriptions.values().iterator(); iterator1.hasNext(); ServicePlanSerializer.INSTANCE.serialize(serviceplan, jsongenerator))
        {
            serviceplan = (ServicePlan)iterator1.next();
        }

        jsongenerator.writeEndArray();
        jsongenerator.writeNumberField("lastSubscriptionCheckTime", lastSubscriptionCheckTime);
        jsongenerator.writeEndObject();
        jsongenerator.flush();
        obj = ((StringWriter) (obj)).toString();
        return ((String) (obj));
    }

    public AsyncTask fetchAllAsync(final Runnable postFetch)
    {
        this;
        JVM INSTR monitorenter ;
        fetchingTask = new AsyncTask() {

            final SubscriptionInfoCache this$0;
            final Runnable val$postFetch;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                try
                {
                    fetchAvailableSubscriptions();
                    fetchSubscriptions();
                    if (postFetch != null)
                    {
                        postFetch.run();
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    GLogger.i(SubscriptionInfoCache.TAG, "User not registered while fetching subscription info", new Object[0]);
                }
                return null;
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                postFetch = runnable;
                super();
            }
        };
        postFetch = fetchingTask.executeOnExecutor(executor, new Void[0]);
        this;
        JVM INSTR monitorexit ;
        return postFetch;
        postFetch;
        throw postFetch;
    }

    public Promotion getPromotion()
    {
        return getPromotion(-1L);
    }

    public Promotion getPromotion(final long timeout)
    {
        Object obj = executor.submit(new Callable() {

            final SubscriptionInfoCache this$0;
            final long val$timeout;

            public Promotion call()
            {
                if (BuildFlavors.isDebug() && sharedPreferences.getBoolean("FORCE_DEBUG_PROMOTION", false))
                {
                    sharedPreferences.edit().putBoolean("FORCE_DEBUG_PROMOTION", false).apply();
                    return SubscriptionInfoCache.DEBUG_PROMOTION;
                }
                if (useRealSplashScreenCall && cloudDriveServiceClientManager != null)
                {
                    return doPromotionNetworkCall(timeout);
                } else
                {
                    return null;
                }
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                timeout = l;
                super();
            }
        });
        obj = (Promotion)((Future) (obj)).get();
        return ((Promotion) (obj));
        Object obj1;
        obj1;
_L2:
        if (((Exception) (obj1)).getCause() instanceof IllegalStateException)
        {
            GLogger.i(TAG, "User not registered while fetching subscription info", new Object[0]);
        } else
        {
            GLogger.ex(TAG, "Exception getting promotion", ((Throwable) (obj1)));
        }
        return null;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean getPromotionCheckOccurredInThisSession()
    {
        return promotionCheckOccurredInThisSession;
    }

    public void onAccountDeregistered()
    {
        executor.execute(new Runnable() {

            final SubscriptionInfoCache this$0;

            public void run()
            {
                clearCaches();
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                super();
            }
        });
    }

    public void onAccountRegistered()
    {
        executor.execute(new Runnable() {

            final SubscriptionInfoCache this$0;

            public void run()
            {
                clearCaches();
                fetchAllAsync(null);
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                super();
            }
        });
    }

    public void onCreate()
    {
        executor.execute(new Runnable() {

            final SubscriptionInfoCache this$0;

            public void run()
            {
                if (availableSubscriptions.isEmpty())
                {
                    fetchAllAsync(null);
                }
            }

            
            {
                this$0 = SubscriptionInfoCache.this;
                super();
            }
        });
    }

    public void setPromotionCheckOccurredInThisSession(boolean flag)
    {
        promotionCheckOccurredInThisSession = flag;
    }












}

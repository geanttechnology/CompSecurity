// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.http.HttpUtil;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.StringUtil;
import com.amazon.insights.delivery.policy.DefaultDeliveryPolicyFactory;
import com.amazon.insights.delivery.policy.DeliveryPolicy;
import com.amazon.insights.delivery.policy.DeliveryPolicyFactory;
import com.amazon.insights.event.InternalEvent;
import com.amazon.insights.event.adapter.EventAdapter;
import com.amazon.insights.event.adapter.JSONEventAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.delivery:
//            DeliveryClient, ERSRequestBuilder, FileEventStore, EventStore, 
//            EventStoreException

public class DefaultDeliveryClient
    implements DeliveryClient
{

    static final Set RETRY_REQUEST_CODES;
    private static final Logger logger = Logger.getLogger(com/amazon/insights/delivery/DefaultDeliveryClient);
    private final AtomicLong avgWriteEventTimeMillis = new AtomicLong(25L);
    private final InsightsContext context;
    private final EventAdapter eventAdapter;
    private final EventStore eventStore;
    private final AtomicLong eventsProcessed = new AtomicLong(0L);
    private final ExecutorService eventsRunnableQueue;
    private final DeliveryPolicyFactory policyFactory;
    private final ERSRequestBuilder requestBuilder;
    private final ExecutorService submissionRunnableQueue;

    public DefaultDeliveryClient(InsightsContext insightscontext, DeliveryPolicyFactory deliverypolicyfactory, ExecutorService executorservice, ExecutorService executorservice1, ERSRequestBuilder ersrequestbuilder, EventStore eventstore, EventAdapter eventadapter)
    {
        policyFactory = deliverypolicyfactory;
        eventsRunnableQueue = executorservice;
        submissionRunnableQueue = executorservice1;
        context = insightscontext;
        requestBuilder = ersrequestbuilder;
        eventStore = eventstore;
        eventAdapter = eventadapter;
    }

    private void calculateAndSetAverageWriteEventTime(long l, long l1)
    {
        long l2 = eventsProcessed.addAndGet(1L);
        l = (long)Math.ceil((double)(System.currentTimeMillis() - l1) / (double)(l2 - l));
        avgWriteEventTimeMillis.set(l);
    }

    private long getSubmissionLatchWaitTime()
    {
        return (long)((double)(avgWriteEventTimeMillis.get() * 1000L) * 1.5D);
    }

    public static DefaultDeliveryClient newInstance(InsightsContext insightscontext, boolean flag)
    {
        ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1000), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        ThreadPoolExecutor threadpoolexecutor1 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        ERSRequestBuilder ersrequestbuilder = ERSRequestBuilder.newBuilder(insightscontext);
        return new DefaultDeliveryClient(insightscontext, new DefaultDeliveryPolicyFactory(insightscontext, flag), threadpoolexecutor, threadpoolexecutor1, ersrequestbuilder, FileEventStore.newInstance(insightscontext), new JSONEventAdapter());
    }

    private boolean submitEvents(JSONArray jsonarray, List list)
    {
        boolean flag = false;
        Object obj = requestBuilder.createHttpRequest(jsonarray);
        if (obj == null)
        {
            logger.e("There was an error when building the http request");
            return false;
        }
        int i = context.getConfiguration().optInt("eventRecorderRequestRetries", Integer.valueOf(2)).intValue();
        obj = context.getHttpClient().execute(((com.amazon.insights.core.http.HttpClient.Request) (obj)), Integer.valueOf(i));
        if (obj == null)
        {
            logger.e("The http request returned a null http response");
            return false;
        }
        if (((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode() / 100 == 2)
        {
            logger.i(String.format("Success from EventService: %d", new Object[] {
                Integer.valueOf(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode())
            }));
            logger.devi(String.format("Successful submission of %d events", new Object[] {
                Integer.valueOf(jsonarray.length())
            }));
            flag = true;
        } else
        if (((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode() / 100 == 4 && !RETRY_REQUEST_CODES.contains(Integer.valueOf(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode())))
        {
            logger.i(String.format("Failed to submit events to EventService: %d", new Object[] {
                Integer.valueOf(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode())
            }));
            logger.devi(String.format("Failed submission of %d events", new Object[] {
                Integer.valueOf(jsonarray.length())
            }));
            flag = true;
        } else
        {
            logger.devw((new StringBuilder()).append("Unable to successfully deliver events to server. Response code (").append(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode()).append(") ").append(HttpUtil.getMessageForResponse(((com.amazon.insights.core.http.HttpClient.Response) (obj)))).toString());
            logger.w((new StringBuilder()).append("Recieved a bad response: ").append(obj).toString());
        }
        for (jsonarray = list.iterator(); jsonarray.hasNext(); ((DeliveryPolicy)jsonarray.next()).handleDeliveryAttempt(flag)) { }
        return flag;
    }

    public void attemptDelivery()
    {
        ArrayList arraylist = new ArrayList();
        DeliveryPolicy deliverypolicy = policyFactory.newForceSubmissionTimePolicy();
        DeliveryPolicy deliverypolicy1 = policyFactory.newConnectivityPolicy();
        if (deliverypolicy1 != null)
        {
            arraylist.add(deliverypolicy1);
        }
        if (deliverypolicy != null)
        {
            arraylist.add(deliverypolicy);
        }
        attemptDelivery(((List) (arraylist)));
    }

    public void attemptDelivery(final List policies)
    {
        final CountDownLatch submitWaitLatch = new CountDownLatch(1);
        eventsRunnableQueue.execute(new Runnable() {

            final DefaultDeliveryClient this$0;
            final CountDownLatch val$submitWaitLatch;

            public void run()
            {
                submitWaitLatch.countDown();
            }

            
            {
                this$0 = DefaultDeliveryClient.this;
                submitWaitLatch = countdownlatch;
                super();
            }
        });
        submissionRunnableQueue.execute(new Runnable() {

            final DefaultDeliveryClient this$0;
            final List val$policies;
            final CountDownLatch val$submitWaitLatch;

            public void run()
            {
                long l3 = System.currentTimeMillis();
                for (Iterator iterator = policies.iterator(); iterator.hasNext();)
                {
                    if (!((DeliveryPolicy)iterator.next()).isAllowed())
                    {
                        return;
                    }
                }

                JSONArray jsonarray;
                JSONException jsonexception;
                JSONArray jsonarray1;
                EventStore.EventIterator eventiterator;
                int i;
                int j;
                int k;
                long l;
                long l1;
                long l2;
                long l4;
                boolean flag;
                boolean flag1;
                try
                {
                    submitWaitLatch.await(getSubmissionLatchWaitTime(), TimeUnit.MILLISECONDS);
                }
                catch (InterruptedException interruptedexception) { }
                flag = true;
                l4 = context.getConfiguration().optLong("maxSubmissionSize", Long.valueOf(0x19000L)).longValue();
                jsonarray = new JSONArray();
                eventiterator = eventStore.iterator();
                l = 0L;
                i = 0;
                k = context.getConfiguration().optInt("maxSubmissionAllowed", Integer.valueOf(3)).intValue();
                flag1 = flag;
                if (!eventiterator.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                flag1 = flag;
                if (i >= k)
                {
                    break; /* Loop/switch isn't completed */
                }
                l1 = l;
                j = i;
                flag1 = flag;
                if (eventiterator.peek() == null) goto _L2; else goto _L1
_L1:
                l1 = l;
                j = i;
                flag1 = flag;
                l2 = eventiterator.peek().length();
                l1 = l2;
_L4:
                if (l + l1 > l4)
                {
                    break; /* Loop/switch isn't completed */
                }
                l += l1;
                l1 = l;
                j = i;
                flag1 = flag;
                try
                {
                    jsonarray.put(new JSONObject((String)eventiterator.next()));
                }
                // Misplaced declaration of an exception variable
                catch (JSONException jsonexception)
                {
                    DefaultDeliveryClient.logger.e("Could not convert stored event into json", jsonexception);
                    l = l1;
                    i = j;
                    flag = flag1;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                l1 = 0L;
                if (true) goto _L4; else goto _L3
_L3:
                l1 = l;
                j = i;
                flag1 = flag;
                flag = submitEvents(jsonarray, policies);
                flag1 = flag;
                if (!flag)
                {
                    break; /* Loop/switch isn't completed */
                }
                i++;
                l1 = l;
                j = i;
                flag1 = flag;
                eventiterator.removeReadEvents();
                l1 = l;
                j = i;
                flag1 = flag;
                jsonarray1 = new JSONArray();
                l = 0L;
                jsonarray = jsonarray1;
                if (true) goto _L6; else goto _L5
_L6:
                break MISSING_BLOCK_LABEL_148;
_L5:
                if (flag1 && jsonarray.length() > 0 && submitEvents(jsonarray, policies))
                {
                    eventiterator.removeReadEvents();
                }
                DefaultDeliveryClient.logger.v(String.format("Time of attemptDelivery: %d", new Object[] {
                    Long.valueOf(System.currentTimeMillis() - l3)
                }));
                return;
            }

            
            {
                this$0 = DefaultDeliveryClient.this;
                policies = list;
                submitWaitLatch = countdownlatch;
                super();
            }
        });
    }

    public void enqueueEventForDelivery(final InternalEvent event)
    {
        final long startEnqueueTimeMillis = System.currentTimeMillis();
        final long origEventsProcessed = eventsProcessed.get();
        eventsRunnableQueue.execute(new Runnable() {

            final DefaultDeliveryClient this$0;
            final InternalEvent val$event;
            final long val$origEventsProcessed;
            final long val$startEnqueueTimeMillis;

            public void run()
            {
                long l = System.currentTimeMillis();
                if (!eventStore.put(((JSONObject)eventAdapter.translateFromEvent(event)).toString())) goto _L2; else goto _L1
_L1:
                DefaultDeliveryClient.logger.devi(String.format("Event: '%s' recorded to local filestore", new Object[] {
                    StringUtil.clipString(event.getEventType(), 5, true)
                }));
                DefaultDeliveryClient.logger.v(String.format("Time of enqueueEventForDelivery: %d", new Object[] {
                    Long.valueOf(System.currentTimeMillis() - l)
                }));
_L4:
                calculateAndSetAverageWriteEventTime(origEventsProcessed, startEnqueueTimeMillis);
                return;
_L2:
                DefaultDeliveryClient.logger.devw(String.format("Event: '%s' failed to record to local filestore", new Object[] {
                    StringUtil.clipString(event.getEventType(), 5, true)
                }));
                if (true) goto _L4; else goto _L3
_L3:
                Object obj;
                obj;
                DefaultDeliveryClient.logger.devw(String.format("Event: '%s' failed to record to local filestore", new Object[] {
                    StringUtil.clipString(event.getEventType(), 5, true)
                }));
                calculateAndSetAverageWriteEventTime(origEventsProcessed, startEnqueueTimeMillis);
                return;
                obj;
                calculateAndSetAverageWriteEventTime(origEventsProcessed, startEnqueueTimeMillis);
                throw obj;
            }

            
            {
                this$0 = DefaultDeliveryClient.this;
                event = internalevent;
                origEventsProcessed = l;
                startEnqueueTimeMillis = l1;
                super();
            }
        });
    }

    public void notify(InternalEvent internalevent)
    {
        enqueueEventForDelivery(internalevent);
    }

    static 
    {
        RETRY_REQUEST_CODES = new HashSet();
        RETRY_REQUEST_CODES.add(Integer.valueOf(401));
        RETRY_REQUEST_CODES.add(Integer.valueOf(404));
        RETRY_REQUEST_CODES.add(Integer.valueOf(407));
        RETRY_REQUEST_CODES.add(Integer.valueOf(408));
    }







}

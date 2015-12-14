// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.crash.ers;

import com.amazon.insights.InsightsHandler;
import com.amazon.insights.core.DefaultInsightsHandler;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.delivery.ERSRequestBuilder;
import com.amazon.insights.error.InsightsError;
import com.amazon.insights.error.UnexpectedError;
import com.amazon.insights.event.DefaultEvent;
import com.amazon.insights.event.adapter.EventAdapter;
import com.amazon.insights.event.adapter.JSONEventAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class ERSClient
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/core/crash/ers/ERSClient);
    private final ERSRequestBuilder ersRequestBuilder;
    private final EventAdapter eventAdapter;
    private final HttpClient httpClient;
    private final ExecutorService submissionExecutor;

    public ERSClient(ExecutorService executorservice, ERSRequestBuilder ersrequestbuilder, HttpClient httpclient, EventAdapter eventadapter)
    {
        submissionExecutor = executorservice;
        ersRequestBuilder = ersrequestbuilder;
        httpClient = httpclient;
        eventAdapter = eventadapter;
    }

    public static ERSClient newInstance(InsightsContext insightscontext)
    {
        ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        ERSRequestBuilder ersrequestbuilder = ERSRequestBuilder.newBuilder(insightscontext);
        JSONEventAdapter jsoneventadapter = new JSONEventAdapter();
        return new ERSClient(threadpoolexecutor, ersrequestbuilder, insightscontext.getHttpClient(), jsoneventadapter);
    }

    public InsightsHandler submitEvents(List list)
    {
        final DefaultInsightsHandler handler = new DefaultInsightsHandler();
        final JSONArray eventsArray = new JSONArray();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (DefaultEvent)list.next();
            obj = (JSONObject)eventAdapter.translateFromEvent(((com.amazon.insights.event.InternalEvent) (obj)));
            if (obj != null)
            {
                eventsArray.put(obj);
            }
        } while (true);
        submissionExecutor.execute(new Runnable() {

            final ERSClient this$0;
            final JSONArray val$eventsArray;
            final DefaultInsightsHandler val$handler;

            public void run()
            {
                Object obj1;
                try
                {
                    obj1 = ersRequestBuilder.createHttpRequest(eventsArray);
                    obj1 = httpClient.execute(((com.amazon.insights.core.http.HttpClient.Request) (obj1)), Integer.valueOf(0));
                    if (((com.amazon.insights.core.http.HttpClient.Response) (obj1)).getCode() / 100 == 2)
                    {
                        ERSClient.logger.d(String.format("Success from EventService: %d", new Object[] {
                            Integer.valueOf(((com.amazon.insights.core.http.HttpClient.Response) (obj1)).getCode())
                        }));
                        handler.onComplete(Boolean.TRUE);
                        return;
                    }
                }
                catch (Exception exception)
                {
                    ERSClient.logger.e("Unable to send ers request", exception);
                    handler.onError(new UnexpectedError("Failed to submit events to EventService", exception));
                    return;
                }
                handler.onError(((_cls1) (obj1)). new InsightsError() {

                    private final String message;
                    final _cls1 this$1;
                    final com.amazon.insights.core.http.HttpClient.Response val$response;

                    public String getMessage()
                    {
                        return message;
                    }

            
            {
                this$1 = final__pcls1;
                response = com.amazon.insights.core.http.HttpClient.Response.this;
                super();
                message = String.format("Failed to submit events to EventService: %d", new Object[] {
                    Integer.valueOf(response.getCode())
                });
            }
                });
                return;
            }

            
            {
                this$0 = ERSClient.this;
                eventsArray = jsonarray;
                handler = defaultinsightshandler;
                super();
            }
        });
        return handler;
    }




}

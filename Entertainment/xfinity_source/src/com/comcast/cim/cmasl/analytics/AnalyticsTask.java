// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.squareup.tape.Task;
import java.io.Serializable;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            EventData, AnalyticsSenderFactory

public class AnalyticsTask
    implements Task, Serializable
{
    public static interface Callback
    {

        public abstract void onFailure();

        public abstract void onSuccess();
    }


    Logger LOG;
    private String analyticsHost;
    private transient AnalyticsSenderFactory analyticsSenderFactory;
    private Map dataPairs;
    private int failureCount;
    private transient TaskExecutorFactory taskExecutorFactory;

    public AnalyticsTask()
    {
        LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/analytics/AnalyticsTask);
        failureCount = 0;
    }

    public AnalyticsTask(String s, EventData eventdata)
    {
        LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/analytics/AnalyticsTask);
        failureCount = 0;
        analyticsHost = s;
        dataPairs = eventdata.getEventData();
    }

    public void execute(final Callback callback)
    {
        (new Thread(new Runnable() {

            final AnalyticsTask this$0;
            final Callback val$callback;

            public void run()
            {
                taskExecutorFactory.create(analyticsSenderFactory.createTask(getAnalyticsHost(), getDataPairs())).execute(new DefaultTaskExecutionListener() {

                    final _cls1 this$1;

                    public void onError(TaskExecutionException taskexecutionexception)
                    {
                        callback.onFailure();
                    }

                    public volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    public void onPostExecute(Void void1)
                    {
                        callback.onSuccess();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = AnalyticsTask.this;
                callback = callback1;
                super();
            }
        })).start();
    }

    public String getAnalyticsHost()
    {
        return analyticsHost;
    }

    public Map getDataPairs()
    {
        return dataPairs;
    }

    public int getFailureCount()
    {
        return failureCount;
    }

    public void setAnalyticsSenderFactory(AnalyticsSenderFactory analyticssenderfactory)
    {
        analyticsSenderFactory = analyticssenderfactory;
    }

    public void setTaskExecutorFactory(TaskExecutorFactory taskexecutorfactory)
    {
        taskExecutorFactory = taskexecutorfactory;
    }


}

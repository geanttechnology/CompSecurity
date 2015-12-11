// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEntityActivity, SeriesResource

private class <init> extends DefaultTaskExecutionListener
{

    final SeriesEntityActivity this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        SeriesEntityActivity.access$200().error("Proxy fetch listener received error", taskexecutionexception);
        SeriesEntityActivity.access$900(SeriesEntityActivity.this);
    }

    public void onPostExecute(SeriesResource seriesresource)
    {
        SeriesEntityActivity.access$200().debug("Data fetched with {} pending listeners", Integer.valueOf(SeriesEntityActivity.access$800(SeriesEntityActivity.this).size()));
        TaskExecutionListener taskexecutionlistener;
        for (Iterator iterator = SeriesEntityActivity.access$800(SeriesEntityActivity.this).iterator(); iterator.hasNext(); SeriesEntityActivity.access$200().debug("Delegate listener {} notified", taskexecutionlistener))
        {
            taskexecutionlistener = (TaskExecutionListener)iterator.next();
            taskexecutionlistener.onPostExecute(seriesresource);
            iterator.remove();
        }

        hideLoading();
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((SeriesResource)obj);
    }

    public void onPreAsynchronousExecute()
    {
        showLoading();
    }

    private ()
    {
        this$0 = SeriesEntityActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

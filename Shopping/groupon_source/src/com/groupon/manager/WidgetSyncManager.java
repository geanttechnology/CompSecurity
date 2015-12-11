// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.util.IOUtils;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.Callable;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager, WidgetsSyncHelper, AsyncHttp

public class WidgetSyncManager extends GrouponSyncManager
{

    private Bus globalBus;
    private DaoWidgetSummary widgetSummaryDao;
    private WidgetsSyncHelper widgetsSyncHelper;

    public WidgetSyncManager(Context context)
    {
        super(context);
    }

    public WidgetSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(final Void widgetsAsyncHttp)
        throws Exception
    {
        Ln.d((new StringBuilder()).append("Start doSync for channel ").append(widgetsSyncHelper.getChannel()).toString(), new Object[0]);
        widgetsAsyncHttp = widgetsSyncHelper.startAsyncRequest();
        final InputStream widgetsInputStream = (InputStream)widgetsAsyncHttp.get();
        widgetSummaryDao.callBatchTasks(new Callable() {

            final WidgetSyncManager this$0;
            final AsyncHttp val$widgetsAsyncHttp;
            final InputStream val$widgetsInputStream;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                widgetsSyncHelper.process(widgetsInputStream, widgetsAsyncHttp.getParams());
                if (widgetsInputStream != null)
                {
                    IOUtils.close(widgetsInputStream);
                }
                return null;
                Exception exception;
                exception;
                if (widgetsInputStream != null)
                {
                    IOUtils.close(widgetsInputStream);
                }
                throw exception;
            }

            
            {
                this$0 = WidgetSyncManager.this;
                widgetsInputStream = inputstream;
                widgetsAsyncHttp = asynchttp;
                super();
            }
        });
        globalBus.post(new ChannelUpdateEvent(widgetsSyncHelper.getWidgetsChannel(), -1));
        Ln.d((new StringBuilder()).append("End doSync for channel ").append(widgetsSyncHelper.getChannel()).toString(), new Object[0]);
    }

    public WidgetsSyncHelper getWidgetsSyncHelper()
    {
        return widgetsSyncHelper;
    }

    protected long lastUpdated()
        throws Exception
    {
        return widgetsSyncHelper.lastUpdated();
    }

    public void setFragmentName(String s)
    {
        widgetsSyncHelper.setFragmentName(s);
    }

    public void setWidgetsSyncHelper(WidgetsSyncHelper widgetssynchelper)
    {
        if (widgetssynchelper == null)
        {
            throw new InvalidParameterException();
        } else
        {
            widgetsSyncHelper = widgetssynchelper;
            return;
        }
    }

}

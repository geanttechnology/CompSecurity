// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.util.IOUtils;
import java.io.InputStream;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            WidgetSyncManager, AsyncHttp, WidgetsSyncHelper

class val.widgetsAsyncHttp
    implements Callable
{

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
        WidgetSyncManager.access$000(WidgetSyncManager.this).process(val$widgetsInputStream, val$widgetsAsyncHttp.getParams());
        if (val$widgetsInputStream != null)
        {
            IOUtils.close(val$widgetsInputStream);
        }
        return null;
        Exception exception;
        exception;
        if (val$widgetsInputStream != null)
        {
            IOUtils.close(val$widgetsInputStream);
        }
        throw exception;
    }

    ()
    {
        this$0 = final_widgetsyncmanager;
        val$widgetsInputStream = inputstream;
        val$widgetsAsyncHttp = AsyncHttp.this;
        super();
    }
}

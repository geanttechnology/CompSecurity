// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.util.Function1;
import java.util.concurrent.ThreadPoolExecutor;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.service:
//            LoginService

class val.onException
    implements Function1
{

    final LoginService this$0;
    final Function1 val$onException;

    public void execute(Exception exception)
        throws RuntimeException
    {
        LoginService.THREAD_POOL_EXECUTOR.execute(new arMyGrouponsRunnable((DaoMyGrouponItem)LoginService.access$700(LoginService.this).get(), (DaoMyGrouponItemSummary)LoginService.access$800(LoginService.this).get(), (DaoPagination)LoginService.access$900(LoginService.this).get()));
        if (val$onException != null)
        {
            val$onException.execute(exception);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    tor()
    {
        this$0 = final_loginservice;
        val$onException = Function1.this;
        super();
    }
}

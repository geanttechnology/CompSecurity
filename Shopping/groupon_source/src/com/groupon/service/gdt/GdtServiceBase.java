// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.gdt;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.http.synchronous.GdtSyncHttp;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.service.ApiServiceBase;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Ln;

public class GdtServiceBase extends ApiServiceBase
{

    public GdtServiceBase(Context context, Class class1)
    {
        super(context, class1);
    }

    public void execute(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1, String s, String s1, List list)
    {
        if (list != null)
        {
            list = new ArrayList(list);
        } else
        {
            list = new ArrayList();
        }
        list = new GdtSyncHttp(context, clazz, s, list.toArray());
        function1 = (new Http(function0_1, function0) {

            final GdtServiceBase this$0;
            final Function0 val$cancelRetryCallback;
            final ReturningFunction1 val$exceptionCallback;
            final Function0 val$finallyCallback;
            final Function1 val$successCallback;
            final String val$url;

            protected void onException(Exception exception)
            {
                Ln.d("PAYMENT: exception for %s: %s", new Object[] {
                    url, exception.getMessage()
                });
                if (exceptionCallback == null || ((Boolean)exceptionCallback.execute(exception)).booleanValue())
                {
                    super.onException(exception);
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                if (finallyCallback != null)
                {
                    finallyCallback.execute();
                }
            }

            protected void onSuccess(Object obj)
                throws Exception
            {
                super.onSuccess(obj);
                Ln.d("PAYMENT: success for %s", new Object[] {
                    url
                });
                if (successCallback != null)
                {
                    successCallback.execute(obj);
                }
            }

            public void onUserCancelRetry()
            {
                super.onUserCancelRetry();
                if (cancelRetryCallback != null)
                {
                    cancelRetryCallback.execute();
                }
            }

            
            {
                this$0 = GdtServiceBase.this;
                url = s;
                successCallback = function1;
                exceptionCallback = returningfunction1;
                cancelRetryCallback = function0;
                finallyCallback = function0_1;
                super(final_context, final_synchttp);
            }
        }).method(s1).setAuthorizationRequired(isAuthorizationRequired);
        if (progressId > 0)
        {
            function1.progressView(progressId);
        }
        function1.execute();
    }

    public volatile ApiServiceBase setAuthorizationRequired(boolean flag)
    {
        return setAuthorizationRequired(flag);
    }

    public GdtServiceBase setAuthorizationRequired(boolean flag)
    {
        super.setAuthorizationRequired(flag);
        return this;
    }

    public volatile ApiServiceBase withProgress(int i)
    {
        return withProgress(i);
    }

    public GdtServiceBase withProgress(int i)
    {
        progressId = i;
        return this;
    }
}

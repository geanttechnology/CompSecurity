// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.view.View;
import com.groupon.http.Http;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.squareup.okhttp.RequestBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class ApiServiceBase
{

    protected final Class clazz;
    protected Context context;
    private int delayMs;
    protected boolean isAuthorizationRequired;
    protected int progressId;
    private View progressView;
    protected String referrer;

    public ApiServiceBase(Context context1, Class class1)
    {
        isAuthorizationRequired = true;
        context = context1;
        clazz = class1;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    protected void execute(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1, String s, String s1)
    {
        execute(function1, returningfunction1, function0, function0_1, s, s1, null, null);
    }

    public void execute(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1, String s, String s1, List list)
    {
        execute(function1, returningfunction1, function0, null, s, s1, list, null);
    }

    public void execute(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1, String s, String s1, List list, 
            RequestBody requestbody)
    {
        if (list != null)
        {
            list = new ArrayList(list);
        } else
        {
            list = new ArrayList();
        }
        if (Strings.notEmpty(referrer))
        {
            list.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        function1 = (new Http(function1, returningfunction1, function0_1, function0) {

            final ApiServiceBase this$0;
            final Function0 val$cancelRetryCallback;
            final ReturningFunction1 val$exceptionCallback;
            final Function0 val$finallyCallback;
            final Function1 val$successCallback;
            final String val$url;

            protected void onException(Exception exception)
            {
                Ln.d("API SERVICE BASE: exception for %s: %s", new Object[] {
                    url, exception.getMessage()
                });
                boolean flag = true;
                if (exceptionCallback != null)
                {
                    flag = ((Boolean)exceptionCallback.execute(exception)).booleanValue();
                }
                if (flag)
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
                Ln.d("API SERVICE BASE: success for %s", new Object[] {
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

            transient 
            {
                this$0 = ApiServiceBase.this;
                url = s1;
                successCallback = function1;
                exceptionCallback = returningfunction1;
                cancelRetryCallback = function0;
                finallyCallback = function0_1;
                super(final_context1, final_class1, final_s, final_aobj);
            }
        }).method(s1).setAuthorizationRequired(isAuthorizationRequired).body(requestbody);
        if (progressId <= 0) goto _L2; else goto _L1
_L1:
        function1.progressView(progressId);
_L4:
        function1.execute(delayMs);
        return;
_L2:
        if (progressView != null)
        {
            function1.progressView(progressView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void execute(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, String s, String s1)
    {
        execute(function1, returningfunction1, function0, null, s, s1, null, null);
    }

    protected void execute(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, String s, String s1, List list)
    {
        execute(function1, returningfunction1, function0, null, s, s1, list, null);
    }

    public ApiServiceBase setAuthorizationRequired(boolean flag)
    {
        isAuthorizationRequired = flag;
        return this;
    }

    public ApiServiceBase withProgress(int i)
    {
        progressId = i;
        return this;
    }

    public ApiServiceBase withProgress(View view)
    {
        progressView = view;
        return this;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class ApiServiceBase2 extends Http
{

    private ReturningFunction1 exceptionCallback;
    private Function0 finallyCallback;
    private String referrer;
    private Function1 successCallback;
    private Function0 userCancelRetryCallback;

    public ApiServiceBase2(Context context, Class class1)
    {
        this(context, class1, null, new Object[0]);
    }

    public transient ApiServiceBase2(Context context, Class class1, String s, Object aobj[])
    {
        super(context, class1, s);
        RoboGuice.getInjector(context).injectMembers(this);
        context = new ArrayList();
        if (aobj != null)
        {
            context.addAll(Arrays.asList(aobj));
        }
        if (Strings.notEmpty(referrer))
        {
            context.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        nvps(context.toArray());
    }

    protected void onException(Exception exception)
    {
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
        if (successCallback != null)
        {
            successCallback.execute(obj);
        }
    }

    public void onUserCancelRetry()
    {
        super.onUserCancelRetry();
        if (userCancelRetryCallback != null)
        {
            userCancelRetryCallback.execute();
        }
    }

    public ApiServiceBase2 withCallbacks(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        successCallback = function1;
        exceptionCallback = returningfunction1;
        finallyCallback = function0;
        return this;
    }

    public ApiServiceBase2 withCancelCallback(Function0 function0)
    {
        userCancelRetryCallback = function0;
        return this;
    }
}

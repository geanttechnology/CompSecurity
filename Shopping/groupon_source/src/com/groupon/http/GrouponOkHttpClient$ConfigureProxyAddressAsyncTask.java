// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.Context;
import com.groupon.util.Function0;
import com.groupon.util.Function3;
import com.groupon.util.GrouponRoboAsyncTask;

// Referenced classes of package com.groupon.http:
//            GrouponOkHttpClient

private class exceptionListener extends GrouponRoboAsyncTask
{

    private Function3 exceptionListener;
    private String proxyIpAddress;
    private String proxyPort;
    private Function0 successListener;
    final GrouponOkHttpClient this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        GrouponOkHttpClient.access$200(GrouponOkHttpClient.this, proxyIpAddress, proxyPort);
        return null;
    }

    protected void onException(Exception exception)
    {
        if (exceptionListener != null)
        {
            exceptionListener.execute(exception, proxyIpAddress, proxyPort);
            return;
        } else
        {
            super.onException(exception);
            return;
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
        throws Exception
    {
        super.onSuccess(void1);
        if (successListener != null)
        {
            successListener.execute();
        }
    }

    protected I(Context context, String s, String s1, Function0 function0, Function3 function3)
    {
        this$0 = GrouponOkHttpClient.this;
        super(context);
        proxyIpAddress = s;
        proxyPort = s1;
        successListener = function0;
        exceptionListener = function3;
    }
}

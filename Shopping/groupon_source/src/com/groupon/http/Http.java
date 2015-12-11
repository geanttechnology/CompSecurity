// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.HttpExecutor;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.RequestBody;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Ln;
import roboguice.util.Strings;

public abstract class Http extends AbstractRetryAsyncTask
{

    private HttpExecutor httpExecutor;
    protected SharedPreferences prefs;
    protected SyncHttp syncHttp;

    public Http(Context context, SyncHttp synchttp)
    {
        super(context);
        executor = httpExecutor;
        syncHttp = synchttp;
    }

    public Http(Context context, Class class1, String s)
    {
        super(context);
        executor = httpExecutor;
        syncHttp = new SyncHttp(context, class1, s);
    }

    public Http(Context context, Class class1, String s, Headers headers, RequestBody requestbody)
    {
        super(context);
        executor = httpExecutor;
        syncHttp = new SyncHttp(context, class1, s, headers, requestbody);
    }

    public Http(Context context, Class class1, String s, RequestBody requestbody)
    {
        super(context);
        executor = httpExecutor;
        syncHttp = new SyncHttp(context, class1, s, requestbody);
    }

    public transient Http(Context context, Class class1, String s, Object aobj[])
    {
        super(context);
        executor = httpExecutor;
        syncHttp = new SyncHttp(context, class1, s, aobj);
    }

    public Http body(RequestBody requestbody)
    {
        syncHttp.body(requestbody);
        return this;
    }

    public Object call()
        throws Exception
    {
        return syncHttp.call();
    }

    public void execute(long l)
    {
        httpExecutor.schedule(new Runnable() {

            final Http this$0;

            public void run()
            {
                execute();
            }

            
            {
                this$0 = Http.this;
                super();
            }
        }, l, TimeUnit.MILLISECONDS);
    }

    public Http forceFullSizeBitmapDownload(boolean flag)
    {
        syncHttp.forceFullSizeBitmapDownload(flag);
        return this;
    }

    public Http method(String s)
    {
        syncHttp.method(s);
        return this;
    }

    public String method()
    {
        return syncHttp.method();
    }

    public transient Http nvps(Object aobj[])
    {
        syncHttp.nvps(aobj);
        return this;
    }

    public Object[] nvps()
    {
        return syncHttp.nvps();
    }

    protected void onInterrupted(Exception exception)
    {
        if (exception instanceof InterruptedException)
        {
            return;
        } else
        {
            onException(exception);
            return;
        }
    }

    public Http setAuthorizationRequired(boolean flag)
    {
        syncHttp.setAuthorizationRequired(flag);
        return this;
    }

    public Http setObjectMapper(ObjectMapper objectmapper)
    {
        syncHttp.setObjectMapper(objectmapper);
        return this;
    }

    protected boolean shouldRetry()
    {
        return Strings.equals(syncHttp.method(), "GET");
    }

    public SyncHttp syncHttp()
    {
        return syncHttp;
    }

    public String toString()
    {
        String s = "(unknown url)";
        String s1 = syncHttp().getFullURI().toString();
        s = s1;
_L2:
        return (new StringBuilder()).append(super.toString()).append("[").append(s).append("]").toString();
        Exception exception;
        exception;
        Ln.e(exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Http uri(String s)
    {
        syncHttp.uri(s);
        return this;
    }

    public Object uri()
    {
        return syncHttp.uri();
    }
}

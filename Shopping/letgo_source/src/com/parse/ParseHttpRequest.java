// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseHttpBody

class ParseHttpRequest
{
    public static class Builder
    {

        protected ParseHttpBody body;
        protected Map headers;
        protected boolean isCancelled;
        protected ParseRequest.Method method;
        protected String url;

        public Builder addHeader(String s, String s1)
        {
            headers.put(s, s1);
            return this;
        }

        public ParseHttpRequest build()
        {
            return new ParseHttpRequest(this);
        }

        public Builder setBody(ParseHttpBody parsehttpbody)
        {
            body = parsehttpbody;
            return this;
        }

        public Builder setHeaders(Map map)
        {
            headers = map;
            return this;
        }

        public Builder setMethod(ParseRequest.Method method1)
        {
            method = method1;
            return this;
        }

        public Builder setUrl(String s)
        {
            url = s;
            return this;
        }

        public Builder()
        {
            headers = new HashMap();
        }

        public Builder(ParseHttpRequest parsehttprequest)
        {
            url = parsehttprequest.url;
            method = parsehttprequest.method;
            headers = new HashMap(parsehttprequest.headers);
            body = parsehttprequest.body;
            isCancelled = parsehttprequest.isCancelled;
        }
    }


    private final ParseHttpBody body;
    private Runnable cancelRunnable;
    private final Map headers;
    private boolean isCancelled;
    private final Object lock = new Object();
    private final ParseRequest.Method method;
    private final String url;

    protected ParseHttpRequest(Builder builder)
    {
        url = builder.url;
        method = builder.method;
        headers = builder.headers;
        body = builder.body;
        isCancelled = builder.isCancelled;
    }

    public void cancel()
    {
label0:
        {
            synchronized (lock)
            {
                if (!isCancelled)
                {
                    break label0;
                }
            }
            return;
        }
        isCancelled = true;
        if (cancelRunnable != null)
        {
            cancelRunnable.run();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Map getAllHeaders()
    {
        return headers;
    }

    public ParseHttpBody getBody()
    {
        return body;
    }

    public String getHeader(String s)
    {
        return (String)headers.get(s);
    }

    public ParseRequest.Method getMethod()
    {
        return method;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isCancelled()
    {
        return isCancelled;
    }

    public void setCancelRunnable(Runnable runnable)
    {
        cancelRunnable = runnable;
    }





}

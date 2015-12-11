// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.mShop.platform.AndroidPlatform;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.net:
//            NetInfo, CallObserver, LRUCache, ServiceCallIdentifier

public abstract class HttpFetcher
    implements Runnable
{
    public static abstract class Params
    {

        protected boolean mCached;
        private final Subscriber mSubscriber;
        protected Object mTag;
        protected String mUrl;

        public String getCacheKey()
        {
            return getUrl();
        }

        public abstract ServiceCallIdentifier getServiceCallIdentifier();

        public Subscriber getSubscriber()
        {
            return mSubscriber;
        }

        public Object getTag()
        {
            return mTag;
        }

        public String getUrl()
        {
            return mUrl;
        }

        public void setCached(boolean flag)
        {
            mCached = flag;
        }

        public Params(String s, Subscriber subscriber)
        {
            mUrl = s;
            mSubscriber = subscriber;
            mTag = null;
        }

        public Params(String s, Subscriber subscriber, Object obj)
        {
            mUrl = s;
            mSubscriber = subscriber;
            mTag = obj;
        }
    }

    public static interface Subscriber
    {

        public abstract void onHttpRequestFailed(Params params);

        public abstract void onHttpResponseReceived(Object obj, Params params);
    }

    private static final class VoidFetcher extends HttpFetcher
    {

        protected Class getParameterizedClass()
        {
            return null;
        }

        public volatile Object handleResponse(HttpURLConnection httpurlconnection)
            throws IOException
        {
            return handleResponse(httpurlconnection);
        }

        public Void handleResponse(HttpURLConnection httpurlconnection)
            throws IOException
        {
            return null;
        }

        protected boolean isVoidRequest()
        {
            return true;
        }

        public VoidFetcher(String s)
        {
            super(new VoidParams(s));
        }
    }

    private static final class VoidFetcher.VoidParams extends Params
    {

        public final ServiceCallIdentifier getServiceCallIdentifier()
        {
            return null;
        }

        public final Subscriber getSubscriber()
        {
            return null;
        }

        public VoidFetcher.VoidParams(String s)
        {
            super(s, null);
        }
    }


    protected static final Executor sExecutor = Executors.newFixedThreadPool(8);
    private volatile boolean cancelled;
    private final boolean mCacheContent = true;
    protected CallObserver mCallObserver;
    private final Params mParams;

    public HttpFetcher(Params params)
    {
        cancelled = false;
        mParams = params;
    }

    public static void closeConnection(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        try
        {
            httpurlconnection.getInputStream().close();
        }
        catch (Exception exception) { }
        httpurlconnection.disconnect();
        return;
        httpurlconnection;
    }

    public static void fetch(String s)
    {
        (new VoidFetcher(s)).fetch();
    }

    public static HttpURLConnection getConnection(String s)
        throws IOException
    {
        NetInfo.waitForNetworkConnectivity();
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setRequestProperty("User-Agent", getUserAgent());
        s.setConnectTimeout(30000);
        s.setReadTimeout(30000);
        return s;
    }

    private static String getUserAgent()
    {
        return AndroidPlatform.getInstance().getUserAgent();
    }

    public void cancel()
    {
        cancelled = true;
    }

    public void fetch()
    {
        fetch(sExecutor);
    }

    public void fetch(Executor executor)
    {
        if (fetchInMemCache() == null)
        {
            executor.execute(this);
        }
    }

    protected Object fetchInMemCache()
    {
        Object obj = null;
        Object obj1 = getParams();
        boolean flag;
        if (!isVoidRequest())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            mCallObserver = CallObserver.start(mParams.getServiceCallIdentifier());
            obj1 = LRUCache.getValue(((Params) (obj1)).getCacheKey(), getParameterizedClass());
            obj = obj1;
            if (obj1 != null)
            {
                mCallObserver.onResponseReceived();
                mCallObserver.setCacheHit(true);
                mParams.setCached(true);
                onPostExecute(obj1);
                obj = obj1;
            }
        }
        return obj;
    }

    protected abstract Class getParameterizedClass();

    public Params getParams()
    {
        return mParams;
    }

    public abstract Object handleResponse(HttpURLConnection httpurlconnection)
        throws IOException;

    public boolean isCancelled()
    {
        return cancelled;
    }

    protected boolean isVoidRequest()
    {
        return false;
    }

    protected final void onPostExecute(final Object result)
    {
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final HttpFetcher this$0;
            final Object val$result;

            public void run()
            {
                if (!isCancelled())
                {
                    if (result == null)
                    {
                        mParams.getSubscriber().onHttpRequestFailed(mParams);
                    } else
                    {
                        mParams.getSubscriber().onHttpResponseReceived(result, mParams);
                    }
                }
                if (!mCallObserver.isFinished())
                {
                    mCallObserver.onComplete();
                }
            }

            
            {
                this$0 = HttpFetcher.this;
                result = obj;
                super();
            }
        });
    }

    public final void run()
    {
        if (fetchInMemCache() == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        Params params = getParams();
        Object obj3;
        Object obj4;
        boolean flag;
        int i;
        if (!isVoidRequest())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj4 = null;
        obj3 = null;
        obj1 = null;
        obj = null;
        obj2 = getConnection(params.getUrl());
        obj = obj2;
        obj1 = obj2;
        ((HttpURLConnection) (obj2)).connect();
        obj = obj2;
        obj1 = obj2;
        i = ((HttpURLConnection) (obj2)).getResponseCode();
        obj = obj4;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        if (i < 300) goto _L4; else goto _L3
_L3:
        obj = obj2;
        obj1 = obj2;
        Object obj5;
        try
        {
            throw new IOException((new StringBuilder()).append(((HttpURLConnection) (obj2)).getResponseCode()).append(" ").append(((HttpURLConnection) (obj2)).getResponseMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        finally
        {
            closeConnection(((HttpURLConnection) (obj1)));
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        obj1 = obj;
        obj2 = ((Throwable) (obj2)).toString();
        obj1 = obj;
        Log.w("Amazon", (new StringBuilder()).append(((String) (obj2))).append(" ").append(params.getUrl()).toString());
        obj1 = obj;
        mCallObserver.onFailed(((String) (obj2)));
        closeConnection(((HttpURLConnection) (obj)));
        obj = obj3;
_L5:
        if (obj != null && mCacheContent)
        {
            LRUCache.putValue(params.getCacheKey(), obj);
        }
        if (flag)
        {
            if (isCancelled())
            {
                if (!mCallObserver.isFinished())
                {
                    mCallObserver.onCancelled();
                    return;
                }
            } else
            {
                onPostExecute(obj);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj = obj2;
        obj1 = obj2;
        mCallObserver.onResponseReceived();
        obj = obj2;
        obj1 = obj2;
        obj5 = handleResponse(((HttpURLConnection) (obj2)));
        obj = obj5;
        closeConnection(((HttpURLConnection) (obj2)));
          goto _L5
        throw obj;
    }


}

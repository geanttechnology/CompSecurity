// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.a.a.a.e;
import com.a.a.a.h;
import com.a.a.a.k;
import com.a.a.b;
import com.a.a.d;
import com.a.a.j;
import com.a.a.l;
import com.a.a.m;
import com.a.a.n;
import com.a.a.t;
import com.google.a.g.a.o;
import com.google.api.a.a.a.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core:
//            OAuth2RdioService, RdioApiRequestArg, OAuth2Session, RdioApiResponse

public class VolleyOAuth2RdioService extends OAuth2RdioService
{
    public static class OAuth2JsonObjectRequest extends m
    {

        private String accessToken;
        private boolean cacheResponse;
        private boolean hasDeliveredResponse;
        private final com.a.a.o.b listener;
        private RdioApiRequestArg params[];
        private String userAgent;

        protected void deliverResponse(RdioApiResponse rdioapiresponse)
        {
            if (!hasDeliveredResponse && !isCanceled())
            {
                listener.onResponse(rdioapiresponse);
                hasDeliveredResponse = true;
            }
        }

        protected volatile void deliverResponse(Object obj)
        {
            deliverResponse((RdioApiResponse)obj);
        }

        public String getCacheKey()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(getUrl()).append("?");
            String s = "";
            RdioApiRequestArg ardioapirequestarg[] = params;
            int j1 = ardioapirequestarg.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                RdioApiRequestArg rdioapirequestarg = ardioapirequestarg[i1];
                stringbuilder.append(s);
                stringbuilder.append(rdioapirequestarg.toString());
                s = "&";
            }

            return stringbuilder.toString();
        }

        public Map getHeaders()
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Authorization", (new StringBuilder("Bearer ")).append(accessToken).toString());
            hashmap.put("User-Agent", userAgent);
            return hashmap;
        }

        public Map getParams()
        {
            return VolleyOAuth2RdioService.createMapFromArgs(params);
        }

        protected com.a.a.o parseNetworkResponse(j j1)
        {
            try
            {
                String s = new String(j1.b, e.a(j1.c));
                com.a.a.b.a a;
                if (cacheResponse)
                {
                    a = VolleyOAuth2RdioService.parseHeadersWithCustomCachePolicy(j1);
                } else
                {
                    a = e.a(j1);
                }
                return new com.a.a.o(RdioApiResponse.responseFactory(j1.a, new JSONObject(s), getCacheKey(), j1.c), a);
            }
            // Misplaced declaration of an exception variable
            catch (j j1)
            {
                j1.printStackTrace();
                return com.a.a.o.a(new l(j1));
            }
            // Misplaced declaration of an exception variable
            catch (j j1)
            {
                j1.printStackTrace();
            }
            return com.a.a.o.a(new l(j1));
        }

        public void updateAccessToken(String s)
        {
            accessToken = s;
        }

        public OAuth2JsonObjectRequest(int i1, String s, String s1, RdioApiRequestArg ardioapirequestarg[], String s2, boolean flag, com.a.a.o.b b1, 
                com.a.a.o.a a)
        {
            super(i1, s, a);
            listener = b1;
            params = ardioapirequestarg;
            accessToken = s1;
            cacheResponse = flag;
            userAgent = s2;
        }

        public OAuth2JsonObjectRequest(String s, String s1, RdioApiRequestArg ardioapirequestarg[], String s2, JSONObject jsonobject, com.a.a.o.b b1, com.a.a.o.a a, 
                boolean flag)
        {
            int i1;
            if (jsonobject == null && ardioapirequestarg == null)
            {
                i1 = 0;
            } else
            {
                i1 = 1;
            }
            this(i1, s, s1, ardioapirequestarg, s2, flag, b1, a);
        }
    }

    private class OAuth2ResponseErrorListener
        implements com.a.a.o.a
    {

        private final RdioService_Api.ResponseListener listener;
        private m request;
        final VolleyOAuth2RdioService this$0;

        public void onErrorResponse(t t1)
        {
            int l;
            l = -1;
            if (t1.a != null)
            {
                l = t1.a.a;
            }
            if (l == 401 && request != null)
            {
                addHeldRequest(request);
                refreshAccessToken(getOAuth2Session().getCredential());
                return;
            }
            if (t1.getMessage() == null) goto _L2; else goto _L1
_L1:
            t1 = t1.getMessage();
_L4:
            listener.onResponse(new RdioApiResponse(false, l, null, t1, null));
            return;
_L2:
            if (t1.a != null && t1.a.b != null)
            {
                t1 = new String(t1.a.b);
                String s;
                try
                {
                    s = (new JSONObject(t1)).getString("message");
                }
                catch (JSONException jsonexception)
                {
                    log(5, "Error body was not JSON, using body as string for error message");
                    continue; /* Loop/switch isn't completed */
                }
                t1 = s;
                continue; /* Loop/switch isn't completed */
            }
            t1 = null;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void setRequest(m m1)
        {
            request = m1;
        }

        public OAuth2ResponseErrorListener(RdioService_Api.ResponseListener responselistener)
        {
            this$0 = VolleyOAuth2RdioService.this;
            super();
            listener = responselistener;
        }
    }


    private static final int DEFAULT_IMAGE_CACHE_SIZE_IN_BYTES = 0xa00000;
    private static final int RETRY_POLICY_VALUE = 6000;
    private static final String TAG = "VolleyOAuth2RdioService";
    private List heldRequests;
    private final Object heldRequestsMonitor;
    private h imageLoader;
    private volatile boolean isInRefreshTokenMode;
    private final com.google.a.g.a.m listeningExecutorService;
    private n requestQueue;
    private String userAgent;

    public VolleyOAuth2RdioService(Context context, OAuth2Session oauth2session, h h1, String s)
    {
        super(oauth2session);
        heldRequestsMonitor = new Object();
        listeningExecutorService = o.a(Executors.newCachedThreadPool());
        userAgent = s;
        requestQueue = k.a(context);
        imageLoader = h1;
    }

    public VolleyOAuth2RdioService(Context context, OAuth2Session oauth2session, String s)
    {
        super(oauth2session);
        heldRequestsMonitor = new Object();
        listeningExecutorService = o.a(Executors.newCachedThreadPool());
        userAgent = s;
        requestQueue = k.a(context);
        imageLoader = new h(getRequestQueue(), createImageCache(0xa00000));
    }

    public VolleyOAuth2RdioService(OAuth2Session oauth2session, n n1, int l, String s)
    {
        super(oauth2session);
        heldRequestsMonitor = new Object();
        listeningExecutorService = o.a(Executors.newCachedThreadPool());
        requestQueue = n1;
        userAgent = s;
        imageLoader = new h(getRequestQueue(), createImageCache(l));
    }

    private void addHeldRequest(m m1)
    {
        log(4, (new StringBuilder("Holding request: ")).append(m1.getCacheKey()).append(" during token refresh").toString());
        synchronized (heldRequestsMonitor)
        {
            if (heldRequests == null)
            {
                heldRequests = new ArrayList(1);
            }
            heldRequests.add(m1);
        }
        return;
        m1;
        obj;
        JVM INSTR monitorexit ;
        throw m1;
    }

    private void addRequestToQueue(m m1, i l)
    {
        if (isInRefreshTokenMode)
        {
            addHeldRequest(m1);
            return;
        }
        if (l.d().longValue() < 60L)
        {
            addHeldRequest(m1);
            refreshAccessToken(l);
            return;
        } else
        {
            getRequestQueue().a(m1);
            return;
        }
    }

    private static Map createMapFromArgs(RdioApiRequestArg ardioapirequestarg[])
    {
        HashMap hashmap = new HashMap(ardioapirequestarg.length);
        for (int l = 0; l < ardioapirequestarg.length; l++)
        {
            if (ardioapirequestarg[l].getValue() != null)
            {
                hashmap.put(ardioapirequestarg[l].getName(), ardioapirequestarg[l].getValue());
            }
        }

        return hashmap;
    }

    public static com.a.a.b.a parseHeadersWithCustomCachePolicy(j j1)
    {
        long l1 = System.currentTimeMillis();
        Map map = j1.c;
        long l = 0L;
        String s = (String)map.get("Date");
        if (s != null)
        {
            l = e.a(s);
        }
        s = (String)map.get("ETag");
        com.a.a.b.a a = new com.a.a.b.a();
        a.a = j1.b;
        a.b = s;
        a.f = 0x2bf20L + l1;
        a.e = l1 + 0x5265c00L;
        a.c = l;
        a.g = map;
        return a;
    }

    private void refreshAccessToken(final i credential)
    {
        if (isInRefreshTokenMode)
        {
            return;
        } else
        {
            isInRefreshTokenMode = true;
            log(4, "Refreshing access token.");
            com.google.a.g.a.i.a(listeningExecutorService.a(new Runnable() {

                final VolleyOAuth2RdioService this$0;
                final i val$credential;

                public void run()
                {
                    credential.e();
                    isInRefreshTokenMode = false;
                    return;
                    Object obj;
                    obj;
                    log("TokenResponseException when refreshing token!", ((Throwable) (obj)));
                    isInRefreshTokenMode = false;
                    return;
                    obj;
                    log("IOException when refreshing token!", ((Throwable) (obj)));
                    isInRefreshTokenMode = false;
                    return;
                    obj;
                    isInRefreshTokenMode = false;
                    throw obj;
                }

            
            {
                this$0 = VolleyOAuth2RdioService.this;
                credential = l;
                super();
            }
            }), new com.google.a.g.a.h() {

                final VolleyOAuth2RdioService this$0;
                final i val$credential;

                public void onFailure(Throwable throwable)
                {
                    log("Failed to refresh token!", throwable);
                }

                public void onSuccess(Object obj)
                {
                    if (credential.a() == null)
                    {
                        break MISSING_BLOCK_LABEL_160;
                    }
                    log(4, "Token refresh successful");
                    obj = heldRequestsMonitor;
                    obj;
                    JVM INSTR monitorenter ;
                    if (heldRequests == null)
                    {
                        break MISSING_BLOCK_LABEL_157;
                    }
                    m m1;
                    for (Iterator iterator = heldRequests.iterator(); iterator.hasNext(); requestQueue.a(m1))
                    {
                        m1 = (m)iterator.next();
                        if (m1 instanceof OAuth2JsonObjectRequest)
                        {
                            ((OAuth2JsonObjectRequest)m1).updateAccessToken(credential.a());
                        }
                        log(4, (new StringBuilder("Adding held request: ")).append(m1.getCacheKey()).append(" to volley queue").toString());
                    }

                    break MISSING_BLOCK_LABEL_145;
                    Exception exception;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
                    heldRequests.clear();
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    log(6, "Token refresh failed!");
                    return;
                }

            
            {
                this$0 = VolleyOAuth2RdioService.this;
                credential = l;
                super();
            }
            });
            return;
        }
    }

    protected void asyncPostRequest(RdioApiRequestArg ardioapirequestarg[], final RdioService_Api.ResponseListener listener, boolean flag, Object obj)
    {
        i l = getOAuth2Session().getCredential();
        OAuth2ResponseErrorListener oauth2responseerrorlistener = new OAuth2ResponseErrorListener(listener);
        ardioapirequestarg = new OAuth2JsonObjectRequest(1, getApiInvokeUri(), l.a(), ardioapirequestarg, userAgent, flag, new com.a.a.o.b() {

            final VolleyOAuth2RdioService this$0;
            final RdioService_Api.ResponseListener val$listener;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (listener != null)
                {
                    listener.onResponse(rdioapiresponse);
                }
            }

            public volatile void onResponse(Object obj1)
            {
                onResponse((RdioApiResponse)obj1);
            }

            
            {
                this$0 = VolleyOAuth2RdioService.this;
                listener = responselistener;
                super();
            }
        }, oauth2responseerrorlistener);
        ardioapirequestarg.setRetryPolicy(new d(6000));
        oauth2responseerrorlistener.setRequest(ardioapirequestarg);
        ardioapirequestarg.setTag(obj);
        addRequestToQueue(ardioapirequestarg, l);
    }

    public void cancelAllRequestsWithTag(Object obj)
    {
        n n1 = requestQueue;
        if (obj == null)
        {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        } else
        {
            n1.a(new com.a.a.n._cls1(n1, obj));
            return;
        }
    }

    protected com.a.a.a.h.a createImageCache(final int cacheSize)
    {
        return new com.a.a.a.h.a() {

            private final android.support.v4.f.e cache;
            final VolleyOAuth2RdioService this$0;
            final int val$cacheSize;

            public Bitmap getBitmap(String s)
            {
                return (Bitmap)cache.get(s);
            }

            public void putBitmap(String s, Bitmap bitmap)
            {
                cache.put(s, bitmap);
            }

            
            {
                this$0 = VolleyOAuth2RdioService.this;
                cacheSize = l;
                super();
                cache = new _cls1(cacheSize);
            }
        };
    }

    public h getImageLoader()
    {
        return imageLoader;
    }

    public n getRequestQueue()
    {
        return requestQueue;
    }

    public void invalidateCacheEntry(String s, boolean flag)
    {
        getRequestQueue().d.a(s, flag);
    }

    protected void log(int l, String s)
    {
        Log.println(l, "VolleyOAuth2RdioService", s);
    }

    protected void log(String s, Throwable throwable)
    {
        Log.e("VolleyOAuth2RdioService", s, throwable);
    }

    protected void syncPostRequest(RdioApiRequestArg ardioapirequestarg[], RdioService_Api.ResponseListener responselistener, boolean flag, Object obj)
    {
        com.a.a.a.j j1 = com.a.a.a.j.a();
        ardioapirequestarg = new OAuth2JsonObjectRequest(1, getApiInvokeUri(), getOAuth2Session().getAccessToken(), ardioapirequestarg, userAgent, flag, j1, j1);
        ardioapirequestarg.setTag(obj);
        addRequestToQueue(ardioapirequestarg, getOAuth2Session().getCredential());
        try
        {
            responselistener.onResponse((RdioApiResponse)j1.get(30L, TimeUnit.SECONDS));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiRequestArg ardioapirequestarg[])
        {
            ardioapirequestarg.printStackTrace();
            responselistener.onResponse(new RdioApiResponse(false, -1, null, ardioapirequestarg.getMessage(), null));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiRequestArg ardioapirequestarg[])
        {
            ardioapirequestarg.printStackTrace();
            responselistener.onResponse(new RdioApiResponse(false, -1, null, ardioapirequestarg.getMessage(), null));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiRequestArg ardioapirequestarg[])
        {
            ardioapirequestarg.printStackTrace();
        }
        responselistener.onResponse(new RdioApiResponse(false, -1, null, ardioapirequestarg.getMessage(), null));
    }


/*
    static boolean access$002(VolleyOAuth2RdioService volleyoauth2rdioservice, boolean flag)
    {
        volleyoauth2rdioservice.isInRefreshTokenMode = flag;
        return flag;
    }

*/







    // Unreferenced inner class com/rdio/android/core/VolleyOAuth2RdioService$1$1

/* anonymous class */
    class _cls1 extends android.support.v4.f.e
    {

        final _cls1 this$1;

        protected volatile int sizeOf(Object obj, Object obj1)
        {
            return sizeOf((String)obj, (Bitmap)obj1);
        }

        protected int sizeOf(String s, Bitmap bitmap)
        {
            return bitmap.getByteCount();
        }

            
            {
                this$1 = _cls1.this;
                super(l);
            }
    }

}

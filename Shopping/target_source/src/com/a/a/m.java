// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.a.a:
//            d, f, n, u, 
//            a, q, t, j, 
//            o

public abstract class m
    implements Comparable
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/a/a/m$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("LOW", 0);
            b = new a("NORMAL", 1);
            c = new a("HIGH", 2);
            d = new a("IMMEDIATE", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private static final long SLOW_REQUEST_THRESHOLD_MS = 3000L;
    private static long sCounter;
    private b.a mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private final o.a mErrorListener;
    private final u.a mEventLog;
    private String mIdentifier;
    private final int mMethod;
    private String mRedirectUrl;
    private long mRequestBirthTime;
    private n mRequestQueue;
    private boolean mResponseDelivered;
    private q mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private Object mTag;
    private final String mUrl;

    public m(int i, String s, o.a a1)
    {
        u.a a2;
        if (u.a.a)
        {
            a2 = new u.a();
        } else
        {
            a2 = null;
        }
        mEventLog = a2;
        mShouldCache = true;
        mCanceled = false;
        mResponseDelivered = false;
        mRequestBirthTime = 0L;
        mCacheEntry = null;
        mMethod = i;
        mUrl = s;
        mIdentifier = createIdentifier(i, s);
        mErrorListener = a1;
        setRetryPolicy(new d());
        mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(s);
    }

    public m(String s, o.a a1)
    {
        this(-1, s, a1);
    }

    private static String createIdentifier(int i, String s)
    {
        s = (new StringBuilder()).append("Request:").append(i).append(":").append(s).append(":").append(System.currentTimeMillis()).append(":");
        long l = sCounter;
        sCounter = 1L + l;
        return f.a(s.append(l).toString());
    }

    private byte[] encodeParameters(Map map, String s)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        try
        {
            for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append('&'))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), s));
                stringbuilder.append('=');
                stringbuilder.append(URLEncoder.encode((String)entry.getValue(), s));
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException((new StringBuilder()).append("Encoding not supported: ").append(s).toString(), map);
        }
        map = stringbuilder.toString().getBytes(s);
        return map;
    }

    private static int findDefaultTrafficStatsTag(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            s = Uri.parse(s);
            if (s != null)
            {
                s = s.getHost();
                if (s != null)
                {
                    return s.hashCode();
                }
            }
        }
        return 0;
    }

    public void addMarker(String s)
    {
        if (u.a.a)
        {
            mEventLog.a(s, Thread.currentThread().getId());
        } else
        if (mRequestBirthTime == 0L)
        {
            mRequestBirthTime = SystemClock.elapsedRealtime();
            return;
        }
    }

    public void cancel()
    {
        mCanceled = true;
    }

    public int compareTo(m m1)
    {
        a a1 = getPriority();
        a a2 = m1.getPriority();
        if (a1 == a2)
        {
            return mSequence.intValue() - m1.mSequence.intValue();
        } else
        {
            return a2.ordinal() - a1.ordinal();
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((m)obj);
    }

    public void deliverError(t t)
    {
        if (mErrorListener != null)
        {
            mErrorListener.onErrorResponse(t);
        }
    }

    protected abstract void deliverResponse(Object obj);

    void finish(String s)
    {
        if (mRequestQueue != null)
        {
            mRequestQueue.b(this);
        }
        if (!u.a.a) goto _L2; else goto _L1
_L1:
        long l = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto _L4; else goto _L3
_L3:
        (new Handler(Looper.getMainLooper())).post(new Runnable(s, l) {

            final String a;
            final long b;
            final m c;

            public void run()
            {
                c.mEventLog.a(a, b);
                c.mEventLog.a(((Object)this).toString());
            }

            
            {
                c = m.this;
                a = s;
                b = l;
                super();
            }
        });
_L6:
        return;
_L4:
        mEventLog.a(s, l);
        mEventLog.a(toString());
        return;
_L2:
        long l1 = SystemClock.elapsedRealtime() - mRequestBirthTime;
        if (l1 >= 3000L)
        {
            u.b("%d ms: %s", new Object[] {
                Long.valueOf(l1), toString()
            });
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public byte[] getBody()
        throws com.a.a.a
    {
        Map map = getParams();
        if (map != null && map.size() > 0)
        {
            return encodeParameters(map, getParamsEncoding());
        } else
        {
            return null;
        }
    }

    public String getBodyContentType()
    {
        return (new StringBuilder()).append("application/x-www-form-urlencoded; charset=").append(getParamsEncoding()).toString();
    }

    public b.a getCacheEntry()
    {
        return mCacheEntry;
    }

    public String getCacheKey()
    {
        return getUrl();
    }

    public o.a getErrorListener()
    {
        return mErrorListener;
    }

    public Map getHeaders()
        throws com.a.a.a
    {
        return Collections.emptyMap();
    }

    public String getIdentifier()
    {
        return mIdentifier;
    }

    public int getMethod()
    {
        return mMethod;
    }

    public String getOriginUrl()
    {
        return mUrl;
    }

    protected Map getParams()
        throws com.a.a.a
    {
        return null;
    }

    protected String getParamsEncoding()
    {
        return "UTF-8";
    }

    public byte[] getPostBody()
        throws com.a.a.a
    {
        Map map = getPostParams();
        if (map != null && map.size() > 0)
        {
            return encodeParameters(map, getPostParamsEncoding());
        } else
        {
            return null;
        }
    }

    public String getPostBodyContentType()
    {
        return getBodyContentType();
    }

    protected Map getPostParams()
        throws com.a.a.a
    {
        return getParams();
    }

    protected String getPostParamsEncoding()
    {
        return getParamsEncoding();
    }

    public a getPriority()
    {
        return a.b;
    }

    public q getRetryPolicy()
    {
        return mRetryPolicy;
    }

    public final int getSequence()
    {
        if (mSequence == null)
        {
            throw new IllegalStateException("getSequence called before setSequence");
        } else
        {
            return mSequence.intValue();
        }
    }

    public Object getTag()
    {
        return mTag;
    }

    public final int getTimeoutMs()
    {
        return mRetryPolicy.a();
    }

    public int getTrafficStatsTag()
    {
        return mDefaultTrafficStatsTag;
    }

    public String getUrl()
    {
        if (mRedirectUrl != null)
        {
            return mRedirectUrl;
        } else
        {
            return mUrl;
        }
    }

    public boolean hasHadResponseDelivered()
    {
        return mResponseDelivered;
    }

    public boolean isCanceled()
    {
        return mCanceled;
    }

    public void markDelivered()
    {
        mResponseDelivered = true;
    }

    protected t parseNetworkError(t t)
    {
        return t;
    }

    protected abstract o parseNetworkResponse(j j);

    public m setCacheEntry(b.a a1)
    {
        mCacheEntry = a1;
        return this;
    }

    public void setRedirectUrl(String s)
    {
        mRedirectUrl = s;
    }

    public m setRequestQueue(n n1)
    {
        mRequestQueue = n1;
        return this;
    }

    public m setRetryPolicy(q q1)
    {
        mRetryPolicy = q1;
        return this;
    }

    public final m setSequence(int i)
    {
        mSequence = Integer.valueOf(i);
        return this;
    }

    public final m setShouldCache(boolean flag)
    {
        mShouldCache = flag;
        return this;
    }

    public m setTag(Object obj)
    {
        mTag = obj;
        return this;
    }

    public final boolean shouldCache()
    {
        return mShouldCache;
    }

    public String toString()
    {
        String s1 = (new StringBuilder()).append("0x").append(Integer.toHexString(getTrafficStatsTag())).toString();
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (mCanceled)
        {
            s = "[X] ";
        } else
        {
            s = "[ ] ";
        }
        return stringbuilder.append(s).append(getUrl()).append(" ").append(s1).append(" ").append(getPriority()).append(" ").append(mSequence).toString();
    }

}

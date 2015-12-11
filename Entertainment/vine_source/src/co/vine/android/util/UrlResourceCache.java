// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.Log;
import co.vine.android.client.VineAPI;
import co.vine.android.network.HttpOperation;
import co.vine.android.network.HttpOperationReader;
import co.vine.android.network.HttpResult;
import co.vine.android.network.ThreadedHttpOperationClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package co.vine.android.util:
//            UrlResource, CacheBinder, Util

public abstract class UrlResourceCache
{
    private class FetchRunnable
        implements Runnable
    {

        private final long mOwnerId;
        private final HashMap mWorkQueue;
        final UrlResourceCache this$0;

        public void run()
        {
            HashMap hashmap = mWorkQueue;
            if (UrlResourceCache.LOGGABLE)
            {
                Log.d("ResourceCache", (new StringBuilder()).append("Queueing ").append(hashmap.size()).toString());
            }
            if (!hashmap.isEmpty())
            {
                HashMap hashmap1 = new HashMap(hashmap.size());
                ThreadedHttpOperationClient threadedhttpoperationclient = ThreadedHttpOperationClient.getInstance(mContext);
                Iterator iterator = hashmap.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (java.util.Map.Entry)iterator.next();
                    Object obj2 = ((java.util.Map.Entry) (obj)).getKey();
                    Object obj1 = (PendingRes)((java.util.Map.Entry) (obj)).getValue();
                    String s = ((PendingRes) (obj1)).url;
                    obj = loadResource(mOwnerId, obj2, s);
                    if (obj != null)
                    {
                        hashmap1.put(obj2, obj);
                    } else
                    {
                        if (UrlResourceCache.LOGGABLE)
                        {
                            Log.d("ResourceCache", (new StringBuilder()).append("Fetch ").append(s).toString());
                        }
                        if (Util.parseURI(s) != null)
                        {
                            obj1 = new ResourceHttpOperationReader(mOwnerId, obj2, s, ((PendingRes) (obj1)).persist);
                            if (HttpOperation.createResourceGetRequest(threadedhttpoperationclient, new StringBuilder(s), VineAPI.getInstance(mContext), ((HttpOperationReader) (obj1))).execute().isOK())
                            {
                                obj = ((ResourceHttpOperationReader) (obj1)).getResultResource();
                            }
                            obj1 = obj;
                            if (obj == null)
                            {
                                obj1 = instantiateResource(obj2, s, null);
                                obj1.nextRequestTime = System.currentTimeMillis() + 60000L;
                            }
                            hashmap1.put(obj2, obj1);
                        }
                    }
                } while (true);
                UrlResourceCache.sMainHandler.post(new ResultRunnable(hashmap1));
            }
        }

        public FetchRunnable(long l, HashMap hashmap)
        {
            this$0 = UrlResourceCache.this;
            super();
            mOwnerId = l;
            mWorkQueue = hashmap;
        }
    }

    private static class MemoryLruCache extends LruCache
    {

        protected int sizeOf(Object obj, UrlResource urlresource)
        {
            return urlresource.size();
        }

        protected volatile int sizeOf(Object obj, Object obj1)
        {
            return sizeOf(obj, (UrlResource)obj1);
        }

        public MemoryLruCache(int i)
        {
            super(i);
        }
    }

    private static class PendingRes
    {

        final boolean persist;
        final String url;

        public PendingRes(String s, boolean flag)
        {
            url = s;
            persist = flag;
        }
    }

    private class QueueRunnable
        implements Runnable
    {

        private final long mOwnerId;
        final UrlResourceCache this$0;

        public void run()
        {
label0:
            {
                synchronized (mLock)
                {
                    if (!mQueuedDownload.isEmpty())
                    {
                        break label0;
                    }
                }
                return;
            }
            HashMap hashmap;
            hashmap = new HashMap(mQueuedDownload.size());
            hashmap.putAll(mQueuedDownload);
            mQueuedDownload.clear();
            ai;
            JVM INSTR monitorexit ;
            UrlResourceCache.sExecutor.execute(new FetchRunnable(mOwnerId, hashmap));
            return;
            exception;
            ai;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public QueueRunnable(long l)
        {
            this$0 = UrlResourceCache.this;
            super();
            mOwnerId = l;
        }
    }

    private class ResourceHttpOperationReader
        implements HttpOperationReader
    {

        private final Object mKey;
        private final long mOwnerId;
        private final boolean mPersist;
        private UrlResource mResource;
        private final String mUrl;
        final UrlResourceCache this$0;

        public final UrlResource getResultResource()
        {
            return mResource;
        }

        public void onHandleError(HttpResult httpresult)
        {
            onResourceError(mKey, httpresult);
        }

        public final void readInput(int i, int j, InputStream inputstream)
            throws IOException
        {
            if (mPersist)
            {
                mResource = saveResource(mOwnerId, mKey, mUrl, inputstream, true);
                return;
            } else
            {
                mResource = obtainResource(mKey, mUrl, inputstream);
                return;
            }
        }

        public ResourceHttpOperationReader(long l, Object obj, String s, boolean flag)
        {
            this$0 = UrlResourceCache.this;
            super();
            mResource = null;
            mOwnerId = l;
            mKey = obj;
            mUrl = s;
            mPersist = flag;
        }
    }

    private class ResultRunnable
        implements Runnable
    {

        private final HashMap mResult;
        final UrlResourceCache this$0;

        public void run()
        {
            urlResourceLoaded(mResult);
        }

        public ResultRunnable(HashMap hashmap)
        {
            this$0 = UrlResourceCache.this;
            super();
            mResult = hashmap;
        }
    }


    protected static final int IO_BUFFER_SIZE = 4096;
    protected static final boolean LOGGABLE = Log.isLoggable("ResourceCache", 3);
    static final long NEXT_REQUEST_INTERVAL = 60000L;
    private static final long POST_DELAY_MILLIS = 100L;
    protected static final String TAG = "ResourceCache";
    protected static final ExecutorService sExecutor = Executors.newSingleThreadExecutor();
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private CacheBinder mCacheBinder;
    protected final Context mContext;
    final int mLock[] = new int[0];
    protected final LinkedHashMap mPendingDownload = new LinkedHashMap(20, 10F, true);
    protected final HashMap mQueuedDownload = new HashMap(20, 10F);
    private final LruCache mResourceCache;

    public UrlResourceCache(Context context, int i)
    {
        mContext = context.getApplicationContext();
        if (i > 0)
        {
            mResourceCache = new MemoryLruCache(i);
            return;
        } else
        {
            mResourceCache = null;
            return;
        }
    }

    private UrlResource queueResourceLoad(long l, Object obj, String s, boolean flag, boolean flag1)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (flag1)
            {
                return loadResource(l, obj, s);
            }
            synchronized (mLock)
            {
                if (!mPendingDownload.containsKey(obj))
                {
                    s = new PendingRes(s, flag);
                    mPendingDownload.put(obj, s);
                    mQueuedDownload.put(obj, s);
                    sMainHandler.postDelayed(new QueueRunnable(l), 100L);
                }
            }
        }
        break MISSING_BLOCK_LABEL_108;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
        return null;
    }

    public int cancel(Object obj)
    {
        int ai[] = mLock;
        ai;
        JVM INSTR monitorenter ;
        if ((PendingRes)mQueuedDownload.remove(obj) == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        mPendingDownload.remove(obj);
        return 1;
        ai;
        JVM INSTR monitorexit ;
        return 0;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public int cancel(List list)
    {
        int i = 0;
        int ai[] = mLock;
        ai;
        JVM INSTR monitorenter ;
        for (list = list.iterator(); list.hasNext();)
        {
            i += cancel(list.next());
        }

        ai;
        JVM INSTR monitorexit ;
        return i;
        list;
        ai;
        JVM INSTR monitorexit ;
        throw list;
    }

    public void clear()
    {
        if (mResourceCache != null)
        {
            synchronized (mResourceCache)
            {
                mResourceCache.evictAll();
            }
        }
        synchronized (mLock)
        {
            mPendingDownload.clear();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected final UrlResource get(long l, Object obj, String s, boolean flag)
    {
        return get(l, obj, s, flag, false);
    }

    protected final UrlResource get(long l, Object obj, String s, boolean flag, boolean flag1)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        obj1 = null;
_L4:
        return ((UrlResource) (obj1));
_L2:
        if (LOGGABLE)
        {
            Log.d("ResourceCache", (new StringBuilder()).append("Url: ").append(s).toString());
        }
        UrlResource urlresource;
        if (mResourceCache != null)
        {
            synchronized (mResourceCache)
            {
                urlresource = (UrlResource)mResourceCache.get(obj);
            }
        } else
        {
            urlresource = null;
        }
        if (urlresource == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        if (LOGGABLE)
        {
            Log.d("ResourceCache", (new StringBuilder()).append("Have resource: ").append(urlresource.url).toString());
        }
        if (!urlresource.url.equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = urlresource;
        if (urlresource.nextRequestTime <= 0L) goto _L4; else goto _L3
_L3:
        obj1 = urlresource;
        if (urlresource.nextRequestTime >= System.currentTimeMillis()) goto _L4; else goto _L5
_L5:
        return queueResourceLoad(l, obj, s, flag, flag1);
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        if (LOGGABLE)
        {
            Log.d("ResourceCache", (new StringBuilder()).append("Looking in persistent storage: ").append(s).toString());
        }
        return queueResourceLoad(l, obj, s, flag, flag1);
    }

    public CacheBinder getCacheBinder()
    {
        if (mResourceCache != null)
        {
            synchronized (mResourceCache)
            {
                if (mCacheBinder == null)
                {
                    mCacheBinder = new CacheBinder(mResourceCache);
                }
            }
            return mCacheBinder;
        } else
        {
            return null;
        }
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract UrlResource instantiateResource(Object obj, String s, Object obj1);

    protected abstract UrlResource loadResource(long l, Object obj, String s);

    protected abstract UrlResource obtainResource(Object obj, String s, InputStream inputstream);

    protected abstract void onResourceError(Object obj, HttpResult httpresult);

    protected abstract void onResourceLoaded(HashMap hashmap);

    public UrlResource peek(Object obj)
    {
        if (mResourceCache != null)
        {
            synchronized (mResourceCache)
            {
                obj = (UrlResource)mResourceCache.get(obj);
            }
            return ((UrlResource) (obj));
        } else
        {
            return null;
        }
        obj;
        lrucache;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public UrlResource put(Object obj, UrlResource urlresource)
    {
        if (mResourceCache != null)
        {
            synchronized (mResourceCache)
            {
                obj = (UrlResource)mResourceCache.put(obj, urlresource);
            }
            return ((UrlResource) (obj));
        } else
        {
            return null;
        }
        obj;
        lrucache;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public UrlResource remove(Object obj)
    {
        if (mResourceCache != null)
        {
            synchronized (mResourceCache)
            {
                obj = (UrlResource)mResourceCache.remove(obj);
            }
            return ((UrlResource) (obj));
        } else
        {
            return null;
        }
        obj;
        lrucache;
        JVM INSTR monitorexit ;
        throw obj;
    }

    protected abstract UrlResource saveResource(long l, Object obj, String s, InputStream inputstream, boolean flag);

    public Map snapShot()
    {
        return mResourceCache.snapshot();
    }

    void urlResourceLoaded(HashMap hashmap)
    {
        if (hashmap.isEmpty())
        {
            return;
        }
        for (Iterator iterator = hashmap.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = entry.getKey();
            UrlResource urlresource = (UrlResource)entry.getValue();
            if (mResourceCache != null && urlresource != null)
            {
                synchronized (mResourceCache)
                {
                    mResourceCache.put(obj, urlresource);
                }
            }
            synchronized (mLock)
            {
                mPendingDownload.remove(obj);
            }
        }

        break MISSING_BLOCK_LABEL_129;
        hashmap;
        obj1;
        JVM INSTR monitorexit ;
        throw hashmap;
        hashmap;
        obj1;
        JVM INSTR monitorexit ;
        throw hashmap;
        onResourceLoaded(hashmap);
        return;
    }


}

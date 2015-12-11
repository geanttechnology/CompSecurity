// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.MShopIOUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.mShop.net:
//            HttpFetcher, CallObserver, LRUCache, MShopDiskCachePolicy, 
//            MShopDiskCache, ServiceCallIdentifier, MShopHttpHeaderHelper

public class BitmapFetcher extends HttpFetcher
{
    public static class BitmapFetcherParams extends HttpFetcher.Params
    {

        private static final ServiceCallIdentifier sServiceCallIdentifier = new ServiceCallIdentifier("images", "getImages");
        private String mBaseUrl;
        private int mMaxDimension;
        protected MShopDiskCachePolicy.ResidencePriority mResidencePriority;
        protected boolean mUseDiskCache;

        public String getBaseUrl()
        {
            return mBaseUrl;
        }

        public int getMaxDimension()
        {
            return mMaxDimension;
        }

        public MShopDiskCachePolicy.ResidencePriority getResidencePriority()
        {
            return mResidencePriority;
        }

        public ServiceCallIdentifier getServiceCallIdentifier()
        {
            return sServiceCallIdentifier;
        }

        public String getUrl()
        {
            if (mUrl == null)
            {
                mUrl = ImageUtil.getImageUrl(mBaseUrl, mMaxDimension);
            }
            return mUrl;
        }

        public boolean useDiskCache()
        {
            return mUseDiskCache;
        }


        public BitmapFetcherParams(String s, HttpFetcher.Subscriber subscriber)
        {
            super(s, subscriber);
        }

        public BitmapFetcherParams(String s, HttpFetcher.Subscriber subscriber, int i, Object obj)
        {
            this(s, subscriber, i, obj, false, null);
        }

        public BitmapFetcherParams(String s, HttpFetcher.Subscriber subscriber, int i, Object obj, boolean flag, MShopDiskCachePolicy.ResidencePriority residencepriority)
        {
            super(null, subscriber, obj);
            mMaxDimension = i;
            mBaseUrl = s;
            mUseDiskCache = flag;
            mResidencePriority = residencepriority;
        }

        public BitmapFetcherParams(String s, String s1, HttpFetcher.Subscriber subscriber)
        {
            this(s, subscriber);
            mBaseUrl = s1;
        }
    }


    public BitmapFetcher(BitmapFetcherParams bitmapfetcherparams)
    {
        super(bitmapfetcherparams);
    }

    public BitmapFetcher(String s, Integer integer, HttpFetcher.Subscriber subscriber)
    {
        this(s, integer, null, subscriber);
    }

    public BitmapFetcher(String s, Integer integer, HttpFetcher.Subscriber subscriber, boolean flag, MShopDiskCachePolicy.ResidencePriority residencepriority)
    {
        this(s, integer, null, subscriber, flag, residencepriority);
    }

    public BitmapFetcher(String s, Integer integer, Object obj, HttpFetcher.Subscriber subscriber)
    {
        super(new BitmapFetcherParams(s, subscriber, integer.intValue(), obj));
    }

    public BitmapFetcher(String s, Integer integer, Object obj, HttpFetcher.Subscriber subscriber, boolean flag, MShopDiskCachePolicy.ResidencePriority residencepriority)
    {
        super(new BitmapFetcherParams(s, subscriber, integer.intValue(), obj, flag, residencepriority));
    }

    public BitmapFetcher(String s, String s1, HttpFetcher.Subscriber subscriber)
    {
        super(new BitmapFetcherParams(s, s1, subscriber));
    }

    private void httpFetch(final String uriStr, final String key, final MShopDiskCachePolicy.ResidencePriority priority)
    {
        sExecutor.execute(new Runnable() {

            final BitmapFetcher this$0;
            final String val$key;
            final MShopDiskCachePolicy.ResidencePriority val$priority;
            final String val$uriStr;

            public void run()
            {
                Object obj;
                Object obj1;
                obj1 = null;
                obj = null;
                Object obj2 = HttpFetcher.getConnection(uriStr);
                obj = obj2;
                obj1 = obj2;
                long l = System.currentTimeMillis();
                obj = obj2;
                obj1 = obj2;
                ((HttpURLConnection) (obj2)).connect();
                obj = obj2;
                obj1 = obj2;
                mCallObserver.onResponseReceived();
                obj = obj2;
                obj1 = obj2;
                long l1 = System.currentTimeMillis();
                obj = obj2;
                obj1 = obj2;
                if (((HttpURLConnection) (obj2)).getResponseCode() < 300)
                {
                    break MISSING_BLOCK_LABEL_193;
                }
                Exception exception;
                obj = obj2;
                obj1 = obj2;
                byte abyte0[];
                Bitmap bitmap;
                try
                {
                    throw new IOException((new StringBuilder()).append(((HttpURLConnection) (obj2)).getResponseCode()).append(" ").append(((HttpURLConnection) (obj2)).getResponseMessage()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj2)
                {
                    obj1 = obj;
                }
                finally
                {
                    HttpFetcher.closeConnection(((HttpURLConnection) (obj1)));
                }
                if (!(obj2 instanceof OutOfMemoryError))
                {
                    break MISSING_BLOCK_LABEL_124;
                }
                obj1 = obj;
                LRUCache.reduceByPercent(50);
                obj1 = obj;
                obj2 = ((Throwable) (obj2)).toString();
                obj1 = obj;
                Log.w("BitmapFetcher", (new StringBuilder()).append(((String) (obj2))).append(" ").append(uriStr).toString());
                obj1 = obj;
                mCallObserver.onFailed(((String) (obj2)));
                obj1 = obj;
                onPostExecute(null);
                HttpFetcher.closeConnection(((HttpURLConnection) (obj)));
                return;
                obj = obj2;
                obj1 = obj2;
                abyte0 = MShopIOUtils.getByteArray(((HttpURLConnection) (obj2)).getInputStream());
                obj = obj2;
                obj1 = obj2;
                bitmap = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
                obj = obj2;
                obj1 = obj2;
                onPostExecute(bitmap);
                if (bitmap == null)
                {
                    break MISSING_BLOCK_LABEL_274;
                }
                obj = obj2;
                obj1 = obj2;
                MShopDiskCache.writeCacheFile(key, abyte0, ((HttpURLConnection) (obj2)), priority, l, l1);
                obj = obj2;
                obj1 = obj2;
                LRUCache.putValueWithKey(key, bitmap);
                HttpFetcher.closeConnection(((HttpURLConnection) (obj2)));
                return;
                throw exception;
            }

            
            {
                this$0 = BitmapFetcher.this;
                uriStr = s;
                key = s1;
                priority = residencepriority;
                super();
            }
        });
    }

    private void revalidate(final String uriStr, final String key, final Map cachedHeader, final MShopDiskCachePolicy.ResidencePriority priority)
    {
        sExecutor.execute(new Runnable() {

            final BitmapFetcher this$0;
            final Map val$cachedHeader;
            final String val$key;
            final MShopDiskCachePolicy.ResidencePriority val$priority;
            final String val$uriStr;

            public void run()
            {
                HttpURLConnection httpurlconnection;
                HttpURLConnection httpurlconnection1;
                httpurlconnection1 = null;
                httpurlconnection = null;
                HttpURLConnection httpurlconnection2 = HttpFetcher.getConnection(uriStr);
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                long l = System.currentTimeMillis();
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                long l1 = MShopHttpHeaderHelper.getLastModifiedDate(cachedHeader);
                if (l1 == -1L)
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                httpurlconnection2.setIfModifiedSince(l1);
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                httpurlconnection2.connect();
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                l1 = System.currentTimeMillis();
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                int i = httpurlconnection2.getResponseCode();
                Object obj = null;
                if (i != 304) goto _L2; else goto _L1
_L1:
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                mCallObserver.onResponseReceived();
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                obj = MShopDiskCache.readBitmap(key, priority, getParams().getMaxDimension());
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                onPostExecute(obj);
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                MShopDiskCache.updateHeaderInf(key, httpurlconnection2, priority, l, l1);
_L3:
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_205;
                }
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                LRUCache.putValueWithKey(key, obj);
                HttpFetcher.closeConnection(httpurlconnection2);
                return;
_L2:
                if (i != 200)
                {
                    break MISSING_BLOCK_LABEL_395;
                }
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                mCallObserver.onResponseReceived();
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                byte abyte0[] = MShopIOUtils.getByteArray(httpurlconnection2.getInputStream());
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                obj = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                onPostExecute(obj);
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                MShopDiskCache.writeCacheFile(key, abyte0, httpurlconnection2, priority, l, l1);
                  goto _L3
                Throwable throwable;
                throwable;
                httpurlconnection1 = httpurlconnection;
                if (!(throwable instanceof OutOfMemoryError))
                {
                    break MISSING_BLOCK_LABEL_326;
                }
                httpurlconnection1 = httpurlconnection;
                LRUCache.reduceByPercent(50);
                httpurlconnection1 = httpurlconnection;
                throwable = throwable.toString();
                httpurlconnection1 = httpurlconnection;
                Log.w("BitmapFetcher", (new StringBuilder()).append(throwable).append(" ").append(uriStr).toString());
                httpurlconnection1 = httpurlconnection;
                mCallObserver.onFailed(throwable);
                httpurlconnection1 = httpurlconnection;
                onPostExecute(null);
                HttpFetcher.closeConnection(httpurlconnection);
                return;
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                mCallObserver.onFailed("Something wrong happened while revalidate the cached file!");
                httpurlconnection = httpurlconnection2;
                httpurlconnection1 = httpurlconnection2;
                onPostExecute(null);
                  goto _L3
                Exception exception;
                exception;
                HttpFetcher.closeConnection(httpurlconnection1);
                throw exception;
            }

            
            {
                this$0 = BitmapFetcher.this;
                uriStr = s;
                cachedHeader = map;
                key = s1;
                priority = residencepriority;
                super();
            }
        });
    }

    public void fetch()
    {
        fetch(sExecutor);
    }

    public void fetch(Executor executor)
    {
        if (getParams().useDiskCache())
        {
            fetchInAllCache();
            return;
        } else
        {
            super.fetch(executor);
            return;
        }
    }

    protected void fetchInAllCache()
    {
        Object obj;
        Bitmap bitmap;
        BitmapFetcherParams bitmapfetcherparams;
        String s;
        String s1;
        MShopDiskCachePolicy.ResidencePriority residencepriority;
        boolean flag;
        boolean flag1;
        bitmapfetcherparams = getParams();
        mCallObserver = CallObserver.start(bitmapfetcherparams.getServiceCallIdentifier());
        s1 = bitmapfetcherparams.getCacheKey();
        residencepriority = bitmapfetcherparams.getResidencePriority();
        bitmap = (Bitmap)LRUCache.getValue(s1, getParameterizedClass());
        s = MShopDiskCachePolicy.uriStrToKey(s1);
        flag1 = false;
        flag = flag1;
        obj = bitmap;
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        if (!MShopDiskCachePolicy.isCacheDirReady()) goto _L4; else goto _L3
_L3:
        obj = MShopDiskCache.getFileCacheInf(s, residencepriority);
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((MShopDiskCache.FileCacheInf) (obj)).mHeaderFields;
        if (!MShopDiskCachePolicy.isExpired(((Map) (obj)))) goto _L8; else goto _L7
_L7:
        revalidate(s1, s, ((Map) (obj)), residencepriority);
        obj = bitmap;
        flag = flag1;
_L2:
        if (obj != null)
        {
            mCallObserver.onResponseReceived();
            mCallObserver.setCacheHit(true);
            bitmapfetcherparams.setCached(true);
            onPostExecute(obj);
            if (flag)
            {
                LRUCache.putValueWithKey(s, obj);
            }
        }
        return;
_L8:
        bitmap = MShopDiskCache.readBitmap(s, residencepriority, getParams().getMaxDimension());
        flag1 = true;
        flag = flag1;
        obj = bitmap;
        if (bitmap == null)
        {
            onPostExecute(null);
            flag = flag1;
            obj = bitmap;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        httpFetch(s1, s, residencepriority);
        flag = flag1;
        obj = bitmap;
        continue; /* Loop/switch isn't completed */
_L4:
        onPostExecute(null);
        flag = flag1;
        obj = bitmap;
        if (true) goto _L2; else goto _L9
_L9:
    }

    protected Class getParameterizedClass()
    {
        return android/graphics/Bitmap;
    }

    public BitmapFetcherParams getParams()
    {
        return (BitmapFetcherParams)super.getParams();
    }

    public volatile HttpFetcher.Params getParams()
    {
        return getParams();
    }

    public Bitmap handleResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        if (isCancelled())
        {
            return null;
        }
        try
        {
            httpurlconnection = BitmapFactory.decodeStream(httpurlconnection.getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            System.gc();
            throw httpurlconnection;
        }
        return httpurlconnection;
    }

    public volatile Object handleResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return handleResponse(httpurlconnection);
    }
}

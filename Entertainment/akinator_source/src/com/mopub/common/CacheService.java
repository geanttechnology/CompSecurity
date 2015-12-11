// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.mopub.common:
//            DiskLruCache

public class CacheService
{
    public static interface DiskLruCacheGetListener
    {

        public abstract void onComplete(String s, byte abyte0[]);
    }

    private static class DiskLruCacheGetTask extends AsyncTask
    {

        private final DiskLruCacheGetListener mDiskLruCacheGetListener;
        private final String mKey;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient byte[] doInBackground(Void avoid[])
        {
            return CacheService.getFromDiskCache(mKey);
        }

        protected void onCancelled()
        {
            if (mDiskLruCacheGetListener != null)
            {
                mDiskLruCacheGetListener.onComplete(mKey, null);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((byte[])obj);
        }

        protected void onPostExecute(byte abyte0[])
        {
            if (isCancelled())
            {
                onCancelled();
            } else
            if (mDiskLruCacheGetListener != null)
            {
                mDiskLruCacheGetListener.onComplete(mKey, abyte0);
                return;
            }
        }

        DiskLruCacheGetTask(String s, DiskLruCacheGetListener disklrucachegetlistener)
        {
            mDiskLruCacheGetListener = disklrucachegetlistener;
            mKey = s;
        }
    }

    private static class DiskLruCachePutTask extends AsyncTask
    {

        private final byte mContent[];
        private final String mKey;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            CacheService.putToDiskCache(mKey, mContent);
            return null;
        }

        DiskLruCachePutTask(String s, byte abyte0[])
        {
            mKey = s;
            mContent = abyte0;
        }
    }


    private static final int APP_VERSION = 1;
    private static final int DISK_CACHE_INDEX = 0;
    static final String UNIQUE_CACHE_NAME = "mopub-cache";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCache sDiskLruCache;

    public CacheService()
    {
    }

    public static void clearAndNullCaches()
    {
        if (sDiskLruCache == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        sDiskLruCache.delete();
        sDiskLruCache = null;
        return;
        IOException ioexception;
        ioexception;
        sDiskLruCache = null;
        return;
    }

    public static boolean containsKeyDiskCache(String s)
    {
        if (sDiskLruCache != null)
        {
            try
            {
                s = sDiskLruCache.get(createValidDiskCacheKey(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            if (s != null)
            {
                return true;
            }
        }
        return false;
    }

    public static String createValidDiskCacheKey(String s)
    {
        return Utils.sha1(s);
    }

    public static File getDiskCacheDirectory(Context context)
    {
        context = context.getCacheDir();
        if (context == null)
        {
            return null;
        } else
        {
            context = context.getPath();
            return new File((new StringBuilder()).append(context).append(File.separator).append("mopub-cache").toString());
        }
    }

    public static DiskLruCache getDiskLruCache()
    {
        return sDiskLruCache;
    }

    public static String getFilePathDiskCache(String s)
    {
        if (sDiskLruCache == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(sDiskLruCache.getDirectory()).append(File.separator).append(createValidDiskCacheKey(s)).append(".").append(0).toString();
        }
    }

    public static byte[] getFromDiskCache(String s)
    {
        if (sDiskLruCache != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((byte []) (obj));
_L2:
        byte abyte0[];
        String s1;
        byte abyte1[];
        BufferedInputStream bufferedinputstream;
        abyte1 = null;
        bufferedinputstream = null;
        obj = null;
        s1 = null;
        abyte0 = abyte1;
        s = sDiskLruCache.get(createValidDiskCacheKey(s));
        if (s == null)
        {
            if (s != null)
            {
                s.close();
            }
            return null;
        }
        abyte0 = abyte1;
        s1 = s;
        obj = s;
        InputStream inputstream = s.getInputStream(0);
        abyte0 = bufferedinputstream;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        abyte0 = abyte1;
        s1 = s;
        obj = s;
        abyte1 = new byte[(int)s.getLength(0)];
        abyte0 = abyte1;
        s1 = s;
        obj = s;
        bufferedinputstream = new BufferedInputStream(inputstream);
        Streams.readStream(bufferedinputstream, abyte1);
        abyte0 = abyte1;
        s1 = s;
        obj = s;
        Streams.closeStream(bufferedinputstream);
        abyte0 = abyte1;
        obj = abyte0;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return abyte0;
        Exception exception;
        exception;
        abyte0 = abyte1;
        s1 = s;
        obj = s;
        Streams.closeStream(bufferedinputstream);
        abyte0 = abyte1;
        s1 = s;
        obj = s;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            obj = s1;
        }
        finally
        {
            if (obj == null) goto _L0; else goto _L0
        }
        MoPubLog.d("Unable to get from DiskLruCache", s);
        obj = abyte0;
        if (s1 == null) goto _L4; else goto _L5
_L5:
        s1.close();
        return abyte0;
        ((DiskLruCache.Snapshot) (obj)).close();
        throw s;
    }

    public static void getFromDiskCacheAsync(String s, DiskLruCacheGetListener disklrucachegetlistener)
    {
        (new DiskLruCacheGetTask(s, disklrucachegetlistener)).execute(new Void[0]);
    }

    public static void initialize(Context context)
    {
        initializeDiskCache(context);
    }

    public static boolean initializeDiskCache(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (sDiskLruCache != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((context = getDiskCacheDirectory(context)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = DeviceUtils.diskCacheSizeBytes(context);
        try
        {
            sDiskLruCache = DiskLruCache.open(context, 1, 1, l);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("Unable to create DiskLruCache", context);
            return false;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean putToDiskCache(String s, InputStream inputstream)
    {
        if (sDiskLruCache != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s1 = null;
        s = sDiskLruCache.edit(createValidDiskCacheKey(s));
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = s;
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(s.newOutputStream(0));
        s1 = s;
        Streams.copyContent(inputstream, bufferedoutputstream);
        s1 = s;
        bufferedoutputstream.flush();
        s1 = s;
        bufferedoutputstream.close();
        s1 = s;
        sDiskLruCache.flush();
        s1 = s;
        s.commit();
        return true;
        s;
        MoPubLog.d("Unable to put to DiskLruCache", s);
        if (s1 != null)
        {
            try
            {
                s1.abort();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean putToDiskCache(String s, byte abyte0[])
    {
        return putToDiskCache(s, ((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    public static void putToDiskCacheAsync(String s, byte abyte0[])
    {
        (new DiskLruCachePutTask(s, abyte0)).execute(new Void[0]);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.util.Log;
import com.twinprime.TwinPrimeSDK.libcore.CacheUtils;
import com.twinprime.TwinPrimeSDK.libcore.DiskLruCache;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPControlChannelStateMachine, TPOptionManager, TPLog, TPCFHttp

public class TPCache
{
    static class HttpCache extends ResponseCache
    {

        final ResponseCache cache;

        public CacheResponse get(URI uri, String s, Map map)
            throws IOException
        {
            s = uri;
            if (uri.getHost().equals(TPControlChannelStateMachine.getInstance().accIPAddrStr))
            {
                s = uri;
                if (TPCFHttp.getOriginalURI(uri) != null)
                {
                    s = TPCFHttp.getOriginalURI(uri);
                }
            }
            uri = CacheUtils.uriToKey(s);
            try
            {
                uri = TPCache.diskLruCache.get(uri);
            }
            // Misplaced declaration of an exception variable
            catch (URI uri)
            {
                return null;
            }
            if (uri == null)
            {
                return null;
            }
            map = new com.twinprime.TwinPrimeSDK.libcore.DiskLruCache.Entry(uri.getInputStream(0));
            if (s.toString().startsWith("https"))
            {
                return new com.twinprime.TwinPrimeSDK.libcore.HttpResponseCache.EntrySecureCacheResponse(map, uri);
            } else
            {
                return new com.twinprime.TwinPrimeSDK.libcore.HttpResponseCache.EntryCacheResponse(map, uri);
            }
        }

        public CacheRequest put(URI uri, URLConnection urlconnection)
            throws IOException
        {
            URI uri1;
            uri1 = uri;
            if (uri.getHost().equals(TPControlChannelStateMachine.getInstance().accIPAddrStr))
            {
                uri1 = uri;
                if (TPCFHttp.getOriginalURI(uri) != null)
                {
                    uri1 = TPCFHttp.getOriginalURI(uri);
                }
            }
            if (urlconnection instanceof HttpURLConnection) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            Object obj;
            obj = ((HttpURLConnection)urlconnection).getRequestMethod();
            uri = CacheUtils.uriToKey(uri1);
            if (((String) (obj)).equals("POST") || ((String) (obj)).equals("PUT") || ((String) (obj)).equals("DELETE"))
            {
                try
                {
                    TPCache.diskLruCache.remove(uri);
                }
                // Misplaced declaration of an exception variable
                catch (URI uri)
                {
                    return null;
                }
                return null;
            }
            if (!((String) (obj)).equals("GET"))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (Collections.emptySet().isEmpty())
            {
                new TreeSet(String.CASE_INSENSITIVE_ORDER);
            }
            obj = new com.twinprime.TwinPrimeSDK.libcore.DiskLruCache.Entry(uri);
            uri = TPCache.diskLruCache.edit(uri);
            if (uri == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((com.twinprime.TwinPrimeSDK.libcore.DiskLruCache.Entry) (obj)).writeTo(uri, uri1, (HttpURLConnection)urlconnection);
            uri = new com.twinprime.TwinPrimeSDK.libcore.HttpResponseCache.CacheRequestImpl(uri);
            return uri;
            uri;
            if (TPLog.LOG10.isLoggable("TPCache"))
            {
                uri.printStackTrace();
                return null;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public HttpCache(ResponseCache responsecache)
        {
            cache = responsecache;
        }
    }


    private static String cacheName;
    private static DiskLruCache diskLruCache;
    private static int httpCacheSize;
    private static String okHttpCacheFile = "okhttp_entries";
    static ConcurrentHashMap okHttpCacheMap = new ConcurrentHashMap(1000);

    private static int getCacheSize()
    {
        return 0xa00000;
    }

    private static File getLatestDiskLruCacheFile()
    {
        File file = TPControlChannelStateMachine.getAppContext().getCacheDir();
        if (file != null)
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                File file2 = null;
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    File file3 = afile[i];
                    File file1 = file2;
                    if (file3.isDirectory())
                    {
                        file1 = file2;
                        if (isLikelyHTTPCacheDir(file3))
                        {
                            if (file2 == null)
                            {
                                file1 = file3;
                            } else
                            {
                                file1 = file2;
                                if (file3.lastModified() > file2.lastModified())
                                {
                                    file1 = file3;
                                }
                            }
                        }
                    }
                    i++;
                    file2 = file1;
                }
                if (file2 != null)
                {
                    return file2;
                }
            }
        }
        return null;
    }

    static void installHttpResponseCache()
    {
        httpCacheSize = getCacheSize();
        cacheName = TPOptionManager.getCacheNameOption();
        ResponseCache responsecache = ResponseCache.getDefault();
        if (responsecache == null)
        {
            try
            {
                installTPHttpResponseCache();
                return;
            }
            catch (IOException ioexception)
            {
                if (TPLog.LOG10.isLoggable("TPCache"))
                {
                    Log.d("TPCache", ioexception.getMessage());
                }
            }
            break MISSING_BLOCK_LABEL_68;
        }
        if (!(responsecache instanceof HttpCache))
        {
            ResponseCache.setDefault(new HttpCache(responsecache));
            openLatestDiskLruCache();
            return;
        }
    }

    private static void installTPHttpResponseCache()
    {
        File file = null;
        if (TPLog.LOG13.isLoggable("TPCache"))
        {
            Log.d("TPCache", (new StringBuilder()).append("Installing cache:\nSystem response cache: ").append(TPControlChannelStateMachine.getAppContext().getCacheDir()).append("\ncache name: ").append(cacheName).toString());
        }
        if (TPControlChannelStateMachine.getAppContext() == null)
        {
            if (TPLog.LOG13.isLoggable("TPCache"))
            {
                Log.d("TPCache", "Cannot install cache. Application context is null");
            }
        } else
        {
            if (cacheName.equals(TPOptionManager.defaultCacheName()))
            {
                file = getLatestDiskLruCacheFile();
            }
            File file1 = file;
            if (file == null)
            {
                file1 = new File(TPControlChannelStateMachine.getAppContext().getCacheDir(), cacheName);
            }
            try
            {
                HttpResponseCache httpresponsecache = (HttpResponseCache)Class.forName("android.net.http.HttpResponseCache").getMethod("install", new Class[] {
                    java/io/File, Long.TYPE
                }).invoke(null, new Object[] {
                    file1, Integer.valueOf(httpCacheSize)
                });
                openDiskLruCache(file1);
                ResponseCache.setDefault(new HttpCache(httpresponsecache));
                return;
            }
            catch (Exception exception)
            {
                if (TPLog.LOG10.isLoggable("TPCache"))
                {
                    Log.d("TPCache", exception.getMessage());
                    return;
                }
            }
        }
    }

    private static boolean isLikelyHTTPCacheDir(File file)
    {
        BufferedReader bufferedreader = null;
        file = new File(file, "journal");
        if (!file.exists())
        {
            return false;
        }
        bufferedreader = new BufferedReader(new FileReader(file));
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (s.equals("libcore.io.DiskLruCache"))
        {
            return true;
        }
        bufferedreader.close();
        return false;
        file;
        file = bufferedreader;
_L1:
        Exception exception;
        if (TPLog.LOG10.isLoggable("TPCache"))
        {
            TPLog.LOG10.d("TPCache", (new StringBuilder()).append("exception: ").append(file).append(" isn't likely a cache directory").toString());
            return false;
        } else
        {
            return false;
        }
        exception;
          goto _L1
        exception;
          goto _L1
    }

    private static void openDiskLruCache(File file)
        throws IOException
    {
        diskLruCache = DiskLruCache.open(file, 0x31191, 2, httpCacheSize);
    }

    private static void openLatestDiskLruCache()
        throws IOException
    {
        openDiskLruCache(getLatestDiskLruCacheFile());
    }

    static void setOkHttpCacheMap()
    {
        com/twinprime/TwinPrimeSDK/TPCache;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new PrintWriter(new BufferedWriter(new FileWriter((new StringBuilder()).append(TPControlChannelStateMachine.getAppContext().getCacheDir()).append("/").append(okHttpCacheFile).toString(), false)));
        String s;
        for (Iterator iterator = okHttpCacheMap.keySet().iterator(); iterator.hasNext(); ((PrintWriter) (obj)).println(okHttpCacheMap.get(s)))
        {
            s = (String)iterator.next();
        }

          goto _L1
        obj;
        if (TPLog.LOG10.isLoggable("TPCache"))
        {
            Log.d("TPCache", (new StringBuilder()).append("Exception while writing OkHttpCacheMap - ").append(((Exception) (obj)).getMessage()).toString());
        }
_L3:
        com/twinprime/TwinPrimeSDK/TPCache;
        JVM INSTR monitorexit ;
        return;
_L1:
        ((PrintWriter) (obj)).close();
        if (true) goto _L3; else goto _L2
_L2:
        Exception exception;
        exception;
        throw exception;
    }


}

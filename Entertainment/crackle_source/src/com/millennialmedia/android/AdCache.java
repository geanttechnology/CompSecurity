// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.millennialmedia.android:
//            HandShake, CachedAd, MMSDK, MMAdImpl, 
//            AdCacheThreadPool

final class AdCache
{
    static interface AdCacheTaskListener
    {

        public abstract void downloadCompleted(CachedAd cachedad, boolean flag);

        public abstract void downloadStart(CachedAd cachedad);
    }

    static class Iterator
    {

        static final int ITERATE_ID = 0;
        static final int ITERATE_INFO = 1;
        static final int ITERATE_OBJECT = 2;

        boolean callback(CachedAd cachedad)
        {
            return false;
        }

        boolean callback(String s)
        {
            return false;
        }

        boolean callback(String s, int i, Date date, String s1, long l, ObjectInputStream objectinputstream)
        {
            return false;
        }

        void done()
        {
        }

        Iterator()
        {
        }
    }


    private static final String CACHED_AD_FILE = "ad.dat";
    private static final String CACHE_INCOMPLETE_PREFIX = "incompleteDownload_";
    private static final String CACHE_PREFIX = "nextCachedAd_";
    private static final String CACHE_PREFIX_APID = "nextCachedAd_apids";
    private static final String LOCK_FILE = "ad.lock";
    static final int PRIORITY_FETCH = 3;
    static final int PRIORITY_PRECACHE = 1;
    static final int PRIORITY_REFRESH = 2;
    static final String PRIVATE_CACHE_DIR = ".mmsyscache";
    private static Set apidListSet;
    private static String cachedVideoList;
    private static boolean cachedVideoListLoaded;
    private static Set cachedVideoSet;
    private static Map incompleteDownloadHashMap;
    private static boolean incompleteDownloadHashMapLoaded;
    static boolean isExternalEnabled = true;
    private static Map nextCachedAdHashMap;
    private static boolean nextCachedAdHashMapLoaded;

    private AdCache()
    {
    }

    static void cachedVideoWasAdded(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (!cachedVideoListLoaded)
        {
            getCachedVideoList(context);
        }
        if (cachedVideoSet == null)
        {
            cachedVideoSet = new HashSet();
        }
        cachedVideoSet.add(s);
        cachedVideoList = null;
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void cachedVideoWasRemoved(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (!cachedVideoListLoaded)
        {
            getCachedVideoList(context);
        }
        if (cachedVideoSet != null)
        {
            cachedVideoSet.remove(s);
            cachedVideoList = null;
        }
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void cleanCache(Context context)
    {
        Utils.ThreadUtils.execute(new Runnable(context) {

            final Context val$context;

            public void run()
            {
                MMSDK.Log.d("AdCache");
                AdCache.cleanUpExpiredAds(context);
                AdCache.cleanupCache(context);
            }

            
            {
                context = context1;
                super();
            }
        });
    }

    static void cleanUpExpiredAds(Context context)
    {
        iterateCachedAds(context, 1, new Iterator(context) {

            final Context val$context;

            boolean callback(String s, int i, Date date, String s1, long l, ObjectInputStream objectinputstream)
            {
                if (date != null && date.getTime() <= System.currentTimeMillis())
                {
                    try
                    {
                        date = (CachedAd)objectinputstream.readObject();
                        MMSDK.Log.d("Deleting expired ad %s.", new Object[] {
                            date.getId()
                        });
                        date.delete(context);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Date date)
                    {
                        MMSDK.Log.d("There was a problem reading the cached ad %s.", new Object[] {
                            s
                        });
                        MMSDK.Log.d(date);
                        return true;
                    }
                }
                return true;
            }

            
            {
                context = context1;
                super();
            }
        });
    }

    static void cleanupCache(Context context)
    {
        cleanupInternalCache(context);
        if (isExternalStorageAvailable(context))
        {
            cleanupExternalCache(context);
        }
    }

    static void cleanupDirectory(File file, long l)
    {
        file = file.listFiles();
        int j = file.length;
        int i = 0;
        while (i < j) 
        {
            File file1 = file[i];
            if (file1.isFile())
            {
                if (System.currentTimeMillis() - file1.lastModified() > l)
                {
                    file1.delete();
                }
            } else
            if (file1.isDirectory())
            {
                try
                {
                    cleanupDirectory(file1, l);
                    if (file1.list().length == 0)
                    {
                        file1.delete();
                    }
                }
                catch (SecurityException securityexception) { }
            }
            i++;
        }
    }

    private static void cleanupExternalCache(Context context)
    {
        File file;
        for (file = getExternalCacheDirectory(context); file == null || !file.exists() || !file.isDirectory();)
        {
            return;
        }

        cleanupDirectory(file, HandShake.sharedHandShake(context).creativeCacheTimeout);
    }

    private static void cleanupInternalCache(Context context)
    {
        File file;
        for (file = getInternalCacheDirectory(context); file == null || !file.exists() || !file.isDirectory();)
        {
            return;
        }

        cleanupDirectory(file, HandShake.sharedHandShake(context).creativeCacheTimeout);
    }

    static boolean deleteFile(Context context, String s)
    {
        context = getCachedAdFile(context, s);
        if (context != null)
        {
            return context.delete();
        } else
        {
            return false;
        }
    }

    static boolean downloadComponent(String s, String s1, File file, Context context)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag;
        MMSDK.Log.d("No Url ...");
        flag = false;
_L4:
        return flag;
_L2:
        String s2;
        String s3;
        InputStream inputstream;
        InputStream inputstream1;
        Object obj;
        Object obj1;
        Object obj2;
        File file1;
        long l;
        file1 = new File(file, s1);
        MMSDK.Log.v("Downloading Component: %s from %s", new Object[] {
            s1, s
        });
        if (file1.exists() && file1.length() > 0L)
        {
            MMSDK.Log.v((new StringBuilder()).append(s1).append(" already exists, skipping...").toString());
            return true;
        }
        obj2 = null;
        inputstream1 = null;
        obj = null;
        obj1 = null;
        l = -1L;
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        s = new URL(s);
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        HttpURLConnection.setFollowRedirects(true);
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        s = (HttpURLConnection)s.openConnection();
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        s.setConnectTimeout(30000);
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        s.setRequestMethod("GET");
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        s.connect();
        inputstream = inputstream1;
        s3 = obj1;
        file = obj2;
        s2 = obj;
        inputstream1 = s.getInputStream();
        inputstream = inputstream1;
        s3 = obj1;
        file = inputstream1;
        s2 = obj;
        s = s.getHeaderField("Content-Length");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        inputstream = inputstream1;
        s3 = obj1;
        file = inputstream1;
        s2 = obj;
        l = Long.parseLong(s);
        if (inputstream1 != null)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        inputstream = inputstream1;
        s3 = obj1;
        file = inputstream1;
        s2 = obj;
        MMSDK.Log.e("Connection stream is null downloading %s.", new Object[] {
            s1
        });
        flag = false;
        if (inputstream1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream1.close();
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMSDK.Log.e("Content caching error: %s", new Object[] {
                s.getMessage()
            });
        }
        if (file1 != null)
        {
            file1.delete();
        }
        return false;
        inputstream = inputstream1;
        s3 = obj1;
        file = inputstream1;
        s2 = obj;
        if (!isInternalDir(context, getCacheDirectory(context))) goto _L6; else goto _L5
_L5:
        inputstream = inputstream1;
        s3 = obj1;
        file = inputstream1;
        s2 = obj;
        s = context.openFileOutput(file1.getName(), 1);
_L9:
        inputstream = inputstream1;
        s3 = s;
        file = inputstream1;
        s2 = s;
        context = new byte[4096];
_L8:
        inputstream = inputstream1;
        s3 = s;
        file = inputstream1;
        s2 = s;
        int i = inputstream1.read(context);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream = inputstream1;
        s3 = s;
        file = inputstream1;
        s2 = s;
        s.write(context, 0, i);
        if (true) goto _L8; else goto _L7
        s;
        file = inputstream;
        s2 = s3;
        MMSDK.Log.e("Exception downloading component %s: %s", new Object[] {
            s1, s.getMessage()
        });
        long l1;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMSDK.Log.e("Content caching error: %s", new Object[] {
                    s.getMessage()
                });
                if (file1 != null)
                {
                    file1.delete();
                }
                return false;
            }
        }
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_562;
        }
        s3.close();
_L12:
        if (file1 != null)
        {
            file1.delete();
        }
        return false;
_L6:
        inputstream = inputstream1;
        s3 = obj1;
        file = inputstream1;
        s2 = obj;
        s = new FileOutputStream(file1);
          goto _L9
_L7:
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_718;
        }
        inputstream = inputstream1;
        s3 = s;
        file = inputstream1;
        s2 = s;
        l1 = file1.length();
        if (l1 != l && l != -1L)
        {
            break MISSING_BLOCK_LABEL_699;
        }
        flag = true;
        if (inputstream1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            inputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMSDK.Log.e("Content caching error: %s", new Object[] {
                s.getMessage()
            });
            if (file1 != null)
            {
                file1.delete();
            }
            return false;
        }
        if (s == null) goto _L4; else goto _L10
_L10:
        s.close();
        return true;
        inputstream = inputstream1;
        s3 = s;
        file = inputstream1;
        s2 = s;
        MMSDK.Log.e("Content-Length does not match actual length.");
_L13:
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMSDK.Log.e("Content caching error: %s", new Object[] {
                    s.getMessage()
                });
                if (file1 != null)
                {
                    file1.delete();
                }
                return false;
            }
        }
        if (s == null) goto _L12; else goto _L11
_L11:
        s.close();
          goto _L12
        context;
        inputstream = inputstream1;
        s3 = s;
        file = inputstream1;
        s2 = s;
        MMSDK.Log.e("Exception downloading component %s: %s", new Object[] {
            s1, context.getMessage()
        });
          goto _L13
        s;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_817;
        }
        file.close();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        s2.close();
        throw s;
        s;
        MMSDK.Log.e("Content caching error: %s", new Object[] {
            s.getMessage()
        });
        if (file1 != null)
        {
            file1.delete();
        }
        return false;
          goto _L9
    }

    static boolean downloadComponentToCache(String s, String s1, Context context)
    {
        return downloadComponent(s, s1, getCacheDirectory(context), context);
    }

    static File getCacheDirectory(Context context)
    {
        if (isExternalStorageAvailable(context))
        {
            return getExternalCacheDirectory(context);
        } else
        {
            return getInternalCacheDirectory(context);
        }
    }

    private static File getCachedAdFile(Context context, String s)
    {
        String s1 = (new StringBuilder()).append(s).append("ad.dat").toString();
        boolean flag = isExternalStorageAvailable(context);
        File file = getCacheDirectory(context);
        Object obj = null;
        s = obj;
        if (file != null)
        {
            s = obj;
            try
            {
                if (file.isDirectory())
                {
                    s = new File(file, s1);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MMSDK.Log.e(context);
                return null;
            }
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        if (s.exists())
        {
            break MISSING_BLOCK_LABEL_148;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        context = context.getFilesDir();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        context = new File(context, (new StringBuilder()).append(".mmsyscache").append(File.separator).append(s1).toString());
        if (!context.exists())
        {
            break MISSING_BLOCK_LABEL_148;
        }
        flag = context.isFile();
        if (flag)
        {
            return context;
        }
        return s;
    }

    static String getCachedVideoList(Context context)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        java.util.Iterator iterator;
        if (cachedVideoList != null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        if (!cachedVideoListLoaded)
        {
            HashSet hashset = new HashSet();
            iterateCachedAds(context, 2, new Iterator(context, hashset) {

                final Context val$context;
                final Set val$hashSet;

                boolean callback(CachedAd cachedad)
                {
                    if (cachedad.acid != null && cachedad.getType() == 1 && cachedad.isOnDisk(context))
                    {
                        hashSet.add(cachedad.acid);
                    }
                    return true;
                }

            
            {
                context = context1;
                hashSet = set;
                super();
            }
            });
            cachedVideoSet = hashset;
            cachedVideoListLoaded = true;
        }
        if (cachedVideoSet == null || cachedVideoSet.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        context = new StringBuilder();
        iterator = cachedVideoSet.iterator();
_L1:
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_154;
            }
            s = (String)iterator.next();
            if (context.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_142;
            }
            context.append((new StringBuilder()).append(",").append((String)s).toString());
        } while (true);
        context;
        throw context;
        context.append((String)s);
          goto _L1
        cachedVideoList = context.toString();
        context = cachedVideoList;
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return context;
    }

    static File getDownloadFile(Context context, String s)
    {
        File file = getCacheDirectory(context);
        context = null;
        if (file != null)
        {
            context = new File(file, s);
        }
        return context;
    }

    private static File getExternalCacheDirectory(Context context)
    {
        context = null;
        File file = Environment.getExternalStorageDirectory();
        if (file != null)
        {
            file = new File(file, ".mmsyscache");
            context = file;
            if (!file.exists())
            {
                context = file;
                if (!file.mkdirs())
                {
                    context = null;
                }
            }
        }
        return context;
    }

    static String getIncompleteDownload(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!incompleteDownloadHashMapLoaded)
        {
            loadIncompleteDownloadHashMap(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = (String)incompleteDownloadHashMap.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    private static File getInternalCacheDirectory(Context context)
    {
        File file = context.getFilesDir();
        context = file;
        if (file != null)
        {
            context = file;
            if (!file.exists())
            {
                context = file;
                if (!file.mkdirs())
                {
                    context = null;
                }
            }
        }
        return context;
    }

    static String getNextCachedAd(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!nextCachedAdHashMapLoaded)
        {
            loadNextCachedAdHashMap(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = (String)nextCachedAdHashMap.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    static boolean hasDownloadFile(Context context, String s)
    {
        context = getDownloadFile(context, s);
        return context != null && context.exists();
    }

    static boolean isExternalStorageAvailable(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && Environment.getExternalStorageState().equals("mounted") && isExternalEnabled;
    }

    static boolean isInternalDir(Context context, File file)
    {
        context = getInternalCacheDirectory(context);
        return context != null && context.equals(file);
    }

    static void iterateCachedAds(Context context, int i, Iterator iterator)
    {
        context = getCacheDirectory(context);
        if (context == null) goto _L2; else goto _L1
_L1:
        File afile[];
        int j;
        int k;
        afile = context.listFiles(new FileFilter() {

            public boolean accept(File file1)
            {
                return !file1.isDirectory() && file1.getName().endsWith("ad.dat");
            }

        });
        k = afile.length;
        j = 0;
        context = null;
_L7:
        if (j >= k) goto _L2; else goto _L3
_L3:
        File file = afile[j];
        if (file == null) goto _L5; else goto _L4
_L4:
        boolean flag = file.exists();
        if (flag) goto _L6; else goto _L5
_L5:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        context.close();
        context = null;
_L8:
        j++;
          goto _L7
        IOException ioexception;
        ioexception;
          goto _L8
_L6:
        if (i != 0) goto _L10; else goto _L9
_L9:
        flag = iterator.callback(file.getName());
        if (flag) goto _L12; else goto _L11
_L11:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
_L2:
        iterator.done();
        return;
_L12:
        if (context == null) goto _L8; else goto _L13
_L13:
        context.close();
        context = null;
          goto _L8
        ioexception;
          goto _L8
_L10:
        Object obj = new ObjectInputStream(new FileInputStream(file));
        context = ((Context) (obj));
        int l = ((ObjectInputStream) (obj)).readInt();
        context = ((Context) (obj));
        Date date = (Date)((ObjectInputStream) (obj)).readObject();
        context = ((Context) (obj));
        String s = (String)((ObjectInputStream) (obj)).readObject();
        context = ((Context) (obj));
        long l1 = ((ObjectInputStream) (obj)).readLong();
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        context = ((Context) (obj));
        if (iterator.callback(file.getName(), l, date, s, l1, ((ObjectInputStream) (obj))))
        {
            break MISSING_BLOCK_LABEL_275;
        }
        context = ((Context) (obj));
        ((ObjectInputStream) (obj)).close();
        Exception exception;
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
          goto _L2
        context = ((Context) (obj));
        if (iterator.callback((CachedAd)((ObjectInputStream) (obj)).readObject()))
        {
            break MISSING_BLOCK_LABEL_275;
        }
        context = ((Context) (obj));
        ((ObjectInputStream) (obj)).close();
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
          goto _L2
        context = ((Context) (obj));
        if (obj == null) goto _L8; else goto _L14
_L14:
        ((ObjectInputStream) (obj)).close();
        context = null;
          goto _L8
        exception;
        obj = context;
_L17:
        context = ((Context) (obj));
        MMSDK.Log.d("There was a problem reading the cached ad %s.", new Object[] {
            file.getName()
        });
        context = ((Context) (obj));
        MMSDK.Log.d(exception);
        context = ((Context) (obj));
        if (obj == null) goto _L8; else goto _L15
_L15:
        ((ObjectInputStream) (obj)).close();
        context = null;
          goto _L8
        iterator;
_L16:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw iterator;
        context;
        context = ((Context) (obj));
          goto _L8
        context;
        context = ((Context) (obj));
          goto _L8
        iterator;
          goto _L16
        exception;
          goto _L17
    }

    static CachedAd load(Context context, String s)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj1;
        Object obj2;
        File file;
        obj2 = null;
        Object obj = null;
        obj1 = null;
        file = getCachedAdFile(context, s);
        if (file == null)
        {
            return null;
        }
        context = obj;
        ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream(file));
        objectinputstream.readInt();
        context = (Date)objectinputstream.readObject();
        objectinputstream.readObject();
        objectinputstream.readLong();
        context = (CachedAd)objectinputstream.readObject();
        if (objectinputstream != null)
        {
            try
            {
                objectinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return context;
            }
        }
        return context;
        context;
        objectinputstream = obj1;
_L7:
        context = objectinputstream;
        MMSDK.Log.e("There was a problem loading up the cached ad %s. Ad is not on disk.", new Object[] {
            s
        });
        if (objectinputstream != null)
        {
            try
            {
                objectinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return null;
            }
            return null;
        }
          goto _L1
        Exception exception;
        exception;
        objectinputstream = obj2;
_L6:
        context = objectinputstream;
        MMSDK.Log.e("There was a problem loading up the cached ad %s.", new Object[] {
            s
        });
        context = objectinputstream;
        MMSDK.Log.d(exception.getMessage());
        context = objectinputstream;
        MMSDK.Log.d(exception);
        if (objectinputstream == null) goto _L1; else goto _L3
_L3:
        try
        {
            objectinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return null;
        s;
_L5:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw s;
        s;
        context = objectinputstream;
        if (true) goto _L5; else goto _L4
_L4:
        exception;
          goto _L6
        context;
          goto _L7
    }

    private static void loadApidListSet(SharedPreferences sharedpreferences)
    {
        apidListSet = new HashSet();
        sharedpreferences = sharedpreferences.getString("nextCachedAd_apids", null);
        if (sharedpreferences != null)
        {
            sharedpreferences = sharedpreferences.split(MMSDK.COMMA);
            if (sharedpreferences != null && sharedpreferences.length > 0)
            {
                int j = sharedpreferences.length;
                for (int i = 0; i < j; i++)
                {
                    Object obj = sharedpreferences[i];
                    apidListSet.add(obj);
                }

            }
        }
    }

    static CachedAd loadIncompleteDownload(Context context, String s)
    {
        s = getIncompleteDownload(context, s);
        if (s == null)
        {
            return null;
        } else
        {
            return load(context, s);
        }
    }

    private static void loadIncompleteDownloadHashMap(Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0);
        incompleteDownloadHashMap = new ConcurrentHashMap();
        if (apidListSet == null)
        {
            loadApidListSet(context);
        }
        for (java.util.Iterator iterator = apidListSet.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String as[] = MMAdImpl.getAdTypes();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = as[i];
                String s2 = context.getString((new StringBuilder()).append("incompleteDownload_").append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    incompleteDownloadHashMap.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                i++;
            }
        }

        incompleteDownloadHashMapLoaded = true;
    }

    static CachedAd loadNextCachedAd(Context context, String s)
    {
        s = getNextCachedAd(context, s);
        if (s == null || s.equals(""))
        {
            return null;
        } else
        {
            return load(context, s);
        }
    }

    private static void loadNextCachedAdHashMap(Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0);
        nextCachedAdHashMap = new ConcurrentHashMap();
        if (apidListSet == null)
        {
            loadApidListSet(context);
        }
        for (java.util.Iterator iterator = apidListSet.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String as[] = MMAdImpl.getAdTypes();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = as[i];
                String s2 = context.getString((new StringBuilder()).append("nextCachedAd_").append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    nextCachedAdHashMap.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                i++;
            }
        }

        nextCachedAdHashMapLoaded = true;
    }

    static void resetCache(Context context)
    {
        iterateCachedAds(context, 2, new Iterator(context) {

            final Context val$context;

            boolean callback(CachedAd cachedad)
            {
                MMSDK.Log.d("Deleting ad %s.", new Object[] {
                    cachedad.getId()
                });
                cachedad.delete(context);
                return true;
            }

            
            {
                context = context1;
                super();
            }
        });
        cachedVideoSet = null;
        cachedVideoList = null;
        cachedVideoListLoaded = false;
        if (nextCachedAdHashMap != null)
        {
            for (java.util.Iterator iterator = nextCachedAdHashMap.keySet().iterator(); iterator.hasNext(); setNextCachedAd(context, (String)iterator.next(), null)) { }
        }
        if (incompleteDownloadHashMap != null)
        {
            for (java.util.Iterator iterator1 = incompleteDownloadHashMap.keySet().iterator(); iterator1.hasNext(); setIncompleteDownload(context, (String)iterator1.next(), null)) { }
        }
    }

    static boolean save(Context context, CachedAd cachedad)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        obj1 = null;
        obj5 = null;
        obj2 = null;
        obj4 = null;
        obj3 = null;
        if (cachedad != null) goto _L2; else goto _L1
_L1:
        File file;
        return false;
_L2:
        if ((file = getCachedAdFile(context, cachedad.getId())) == null) goto _L1; else goto _L3
_L3:
        MMSDK.Log.v("Saving CachedAd %s to %s", new Object[] {
            cachedad.getId(), file
        });
        Object obj = new File(file.getParent(), (new StringBuilder()).append(cachedad.getId()).append("ad.lock").toString());
        if (((File) (obj)).createNewFile())
        {
            break MISSING_BLOCK_LABEL_135;
        }
        MMSDK.Log.v("Could not save the cached ad %s. Ad was locked.", new Object[] {
            cachedad.getId()
        });
        ((File) (obj)).delete();
        IOException ioexception;
        Exception exception;
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return false;
        obj1 = new ObjectOutputStream(new FileOutputStream(file));
        ((ObjectOutputStream) (obj1)).writeInt(cachedad.getType());
        ((ObjectOutputStream) (obj1)).writeObject(cachedad.expiration);
        ((ObjectOutputStream) (obj1)).writeObject(cachedad.acid);
        ((ObjectOutputStream) (obj1)).writeLong(cachedad.deferredViewStart);
        ((ObjectOutputStream) (obj1)).writeObject(cachedad);
        ((File) (obj)).delete();
        if (obj1 != null)
        {
            try
            {
                ((ObjectOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
        }
        if (!cachedad.saveAssets(context))
        {
            cachedad.delete(context);
            return false;
        } else
        {
            return true;
        }
        obj;
        context = obj5;
_L7:
        obj1 = context;
        obj2 = obj3;
        MMSDK.Log.e("There was a problem saving the cached ad %s.", new Object[] {
            cachedad.getId()
        });
        obj1 = context;
        obj2 = obj3;
        MMSDK.Log.d(((Exception) (obj)).getMessage());
        obj1 = context;
        obj2 = obj3;
        MMSDK.Log.d(((Throwable) (obj)));
        try
        {
            context.delete();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (obj3 == null) goto _L1; else goto _L4
_L4:
        ((ObjectOutputStream) (obj3)).close();
        return false;
        context;
_L6:
        ((File) (obj1)).delete();
        if (obj2 != null)
        {
            try
            {
                ((ObjectOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (CachedAd cachedad) { }
        }
        throw context;
        context;
        obj1 = obj;
        obj2 = obj4;
        continue; /* Loop/switch isn't completed */
        context;
        obj2 = obj1;
        obj1 = obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        context = ((Context) (obj));
        obj = obj1;
          goto _L7
        exception;
        context = ((Context) (obj));
        obj = exception;
        obj3 = obj1;
          goto _L7
    }

    private static void saveApidListSet(android.content.SharedPreferences.Editor editor, String s)
    {
        int i = s.indexOf('_');
        if (i >= 0 && i < s.length())
        {
            String s1 = s.substring(i + 1);
            if (s1 != null && !apidListSet.contains(s1))
            {
                s = null;
                if (!apidListSet.isEmpty())
                {
                    java.util.Iterator iterator = apidListSet.iterator();
                    StringBuilder stringbuilder = new StringBuilder();
                    do
                    {
                        s = stringbuilder;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        stringbuilder.append((new StringBuilder()).append((String)iterator.next()).append(MMSDK.COMMA).toString());
                    } while (true);
                }
                StringBuilder stringbuilder1 = new StringBuilder();
                if (s == null)
                {
                    s = "";
                } else
                {
                    s = s.toString();
                }
                editor.putString("nextCachedAd_apids", stringbuilder1.append(s).append(s1).toString());
                apidListSet.add(s1);
            }
        }
    }

    private static void saveIncompleteDownloadHashMap(Context context, String s)
    {
        if (s != null)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(context, s);
            context.putString((new StringBuilder()).append("incompleteDownload_").append(s).toString(), (String)incompleteDownloadHashMap.get(s));
            context.commit();
        }
    }

    private static void saveNextCachedAdHashMapValue(Context context, String s)
    {
        if (s != null)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(context, s);
            context.putString((new StringBuilder()).append("nextCachedAd_").append(s).toString(), (String)nextCachedAdHashMap.get(s));
            context.commit();
        }
    }

    static void setEnableExternalStorage(boolean flag)
    {
        isExternalEnabled = flag;
    }

    static void setIncompleteDownload(Context context, String s, String s1)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!incompleteDownloadHashMapLoaded)
        {
            loadIncompleteDownloadHashMap(context);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Map map = incompleteDownloadHashMap;
        String s2;
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        map.put(s, s2);
        saveIncompleteDownloadHashMap(context, s);
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void setNextCachedAd(Context context, String s, String s1)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!nextCachedAdHashMapLoaded)
        {
            loadNextCachedAdHashMap(context);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Map map = nextCachedAdHashMap;
        String s2;
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        map.put(s, s2);
        saveNextCachedAdHashMapValue(context, s);
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static boolean startDownloadTask(Context context, String s, CachedAd cachedad, AdCacheTaskListener adcachetasklistener)
    {
        return AdCacheThreadPool.sharedThreadPool().startDownloadTask(context, s, cachedad, adcachetasklistener);
    }

}

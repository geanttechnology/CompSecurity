// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.VenueCacheIOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.pointinside.model:
//            Cachable, ZoneImage

class CacheController
{

    private static CacheController CACHE_INSTANCE;
    private static final String TAG = com/pointinside/model/CacheController.getSimpleName();
    private static final ExecutorService UPDATE_EXECUTOR = Executors.newFixedThreadPool(3);
    static final String UTF_8 = "UTF-8";
    private int DATA_DOWNLOAD_THROTTLE_DAYS;
    private int DATA_DOWNLOAD_THROTTLE_MINUTES;
    private WeakReference ctx;

    protected CacheController(Context context)
    {
        DATA_DOWNLOAD_THROTTLE_MINUTES = -2;
        DATA_DOWNLOAD_THROTTLE_DAYS = -14;
        ctx = new WeakReference(context);
    }

    private boolean cleanDir(File file)
    {
        boolean flag = false;
        File afile[] = listFiles(file);
        file = listDirs(file);
        if (afile != null && file != null && afile.length != file.length)
        {
            String as[] = new String[afile.length];
            for (int i = 0; i < afile.length; i++)
            {
                as[i] = afile[i].getName();
            }

            int k = file.length;
            for (int j = ((flag) ? 1 : 0); j < k; j++)
            {
                File file1 = file[j];
                if (!pathHasFile(file1, as))
                {
                    removeDir(file1);
                }
            }

        }
        return true;
    }

    private boolean cullCache(int i, File file)
    {
        File afile[] = listFiles(file);
        TreeMap treemap = new TreeMap();
        int k = afile.length;
        for (int j = 0; j < k; j++)
        {
            File file1 = afile[j];
            treemap.put(Long.valueOf(file1.lastModified()), file1);
        }

        return afile.length > i - 1 && ((File)treemap.get(treemap.firstKey())).delete() && cleanDir(file);
    }

    private Context getContext()
    {
        return (Context)ctx.get();
    }

    public static CacheController getInstance(Context context)
    {
        if (CACHE_INSTANCE == null)
        {
            CACHE_INSTANCE = new CacheController(context);
        }
        return CACHE_INSTANCE;
    }

    static BufferedReader getReader(File file)
        throws IOException
    {
        if (file == null)
        {
            throw new IOException("cacheFile cannot be null");
        } else
        {
            return new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsoluteFile()), Charset.forName("UTF-8").newDecoder()));
        }
    }

    private FileOutputStream getWriter(File file)
        throws IOException
    {
        return new FileOutputStream(file.getAbsoluteFile());
    }

    private boolean isCached(File file)
    {
        return file != null && file.exists();
    }

    private boolean isStale(File file)
    {
        if (file != null)
        {
            Calendar calendar2 = Calendar.getInstance();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(file.lastModified());
            Calendar calendar1 = (Calendar)calendar2.clone();
            calendar2 = (Calendar)calendar2.clone();
            calendar1.add(12, DATA_DOWNLOAD_THROTTLE_MINUTES);
            calendar2.add(7, DATA_DOWNLOAD_THROTTLE_DAYS);
            if (calendar.compareTo(calendar2) < 0)
            {
                file.delete();
            }
            cleanDir(file.getParentFile());
            return file.exists() && calendar.compareTo(calendar1) < 0;
        } else
        {
            return false;
        }
    }

    private File[] listDirs(File file)
    {
        return file.listFiles(new FileFilter() {

            final CacheController this$0;

            public boolean accept(File file1)
            {
                return file1.isDirectory();
            }

            
            {
                this$0 = CacheController.this;
                super();
            }
        });
    }

    private File[] listFiles(File file)
    {
        return file.listFiles(new FileFilter() {

            final CacheController this$0;

            public boolean accept(File file1)
            {
                return !file1.isDirectory();
            }

            
            {
                this$0 = CacheController.this;
                super();
            }
        });
    }

    private boolean pathHasFile(File file, String as[])
    {
        int i = 0;
        int j = as.length;
        boolean flag = false;
        for (; i < j; i++)
        {
            flag |= as[i].contains(file.getName());
        }

        return flag;
    }

    private void removeDir(File file)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                removeDir(afile[i]);
            }

        }
        file.delete();
    }

    private void throwOnNoNetwork()
        throws VenueCacheIOException
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if (networkinfo != null && networkinfo.isConnectedOrConnecting())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new VenueCacheIOException("Network not ready, try to proceed without cache update");
        } else
        {
            return;
        }
    }

    private void tryUpdate(Cachable cachable, File file)
        throws VenueCacheIOException
    {
        throwOnNoNetwork();
        cachable = cachable.tryUpdate(file);
        if (cachable == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (cachable.size() > 0)
        {
            add((Cachable)cachable.get(0));
            return;
        }
        if (file == null)
        {
            try
            {
                throw new VenueCacheIOException("Given VenueUuid or StoreId is not found, make sure to provide valid Id");
            }
            catch (IOException ioexception)
            {
                if (file == null)
                {
                    cachable = "";
                } else
                {
                    cachable = file.getAbsolutePath();
                }
            }
            LogUtils.logW(TAG, (new StringBuilder()).append("Attempt to update cache entry for cachable ").append(cachable).append(" failed").toString());
            throw new VenueCacheIOException(ioexception);
        }
        file.setLastModified((new Date()).getTime());
        return;
    }

    private void write(File file, InputStream inputstream)
    {
        Object obj;
        Object obj1;
        byte abyte0[];
        obj1 = null;
        obj = null;
        abyte0 = new byte[1024];
        Object obj2 = getWriter(file);
_L2:
        obj = obj2;
        obj1 = obj2;
        int i = inputstream.read(abyte0);
        if (i <= -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj2;
        ((FileOutputStream) (obj2)).write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        obj2;
        obj1 = obj;
        LogUtils.logW(TAG, (new StringBuilder()).append("Could not create cache for ").append(file.toString()).toString(), ((Throwable) (obj2)));
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return;
            }
        }
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        inputstream.close();
_L4:
        return;
_L1:
        obj = obj2;
        obj1 = obj2;
        ((FileOutputStream) (obj2)).flush();
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return;
            }
        }
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        inputstream.close();
        return;
        file;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        ((FileOutputStream) (obj1)).close();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
        }
        throw file;
    }

    File add(Cachable cachable)
    {
        this;
        JVM INSTR monitorenter ;
        if (!(cachable instanceof ZoneImage)) goto _L2; else goto _L1
_L1:
        File file = ((ZoneImage)cachable).getNewCacheFile(getCacheDir());
_L5:
        File file1 = file.getAbsoluteFile().getParentFile();
        if (file1.exists()) goto _L4; else goto _L3
_L3:
        file1.mkdirs();
_L7:
        write(file, cachable.getContentAsStream(getContext()));
        this;
        JVM INSTR monitorexit ;
        return file;
_L2:
        file = cachable.getCacheFile(getCacheDir());
          goto _L5
_L4:
        if (file.delete()) goto _L7; else goto _L6
_L6:
        cullCache(cachable.cacheSize(), file1);
          goto _L7
        cachable;
        throw cachable;
          goto _L5
    }

    void addInBackground(final Cachable c)
    {
        UPDATE_EXECUTOR.execute(new Runnable() {

            final CacheController this$0;
            final Cachable val$c;

            public void run()
            {
                add(c);
            }

            
            {
                this$0 = CacheController.this;
                c = cachable;
                super();
            }
        });
    }

    List fetch(Cachable cachable)
        throws VenueCacheIOException
    {
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist;
        File file;
        File file1;
        boolean flag1;
        linkedlist = new LinkedList();
        file = getCacheDir();
        file1 = cachable.getCacheFile(file);
        flag1 = isStale(file1);
        boolean flag;
        if (!isCached(file1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L1
_L3:
        tryUpdate(cachable, file1);
_L4:
        cachable = ((Cachable) (cachable.read(file)));
        if (cachable == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        linkedlist.add(cachable);
_L2:
        cachable = Collections.unmodifiableList(linkedlist);
        this;
        JVM INSTR monitorexit ;
        return cachable;
        cachable;
        throwOnNoNetwork();
          goto _L2
        cachable;
        throw cachable;
_L1:
        if (!flag1 && !flag) goto _L4; else goto _L3
    }

    List fetchCacheableIfExists(Cachable cachable)
        throws VenueCacheIOException
    {
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist;
        File file;
        boolean flag;
        linkedlist = new LinkedList();
        file = getCacheDir();
        flag = isCached(cachable.getCacheFile(file));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        cachable = ((Cachable) (cachable.read(file)));
        if (cachable == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        linkedlist.add(cachable);
_L1:
        cachable = Collections.unmodifiableList(linkedlist);
        this;
        JVM INSTR monitorexit ;
        return cachable;
        cachable;
        throwOnNoNetwork();
          goto _L1
        cachable;
        throw cachable;
    }

    protected File getCacheDir()
    {
        File file = getContext().getCacheDir();
        File afile[] = file.listFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file1 = afile[i];
            if ("PI".equals(file1.getName()))
            {
                return file1;
            }
        }

        return new File(file, "/PI/");
    }

    protected void refresh(Cachable cachable)
    {
        File file;
        file = cachable.getCacheFile(getCacheDir());
        if (!isStale(file))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        tryUpdate(cachable, file);
        return;
        cachable;
        cachable.printStackTrace();
        return;
    }

}

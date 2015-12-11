// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.cache;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.github.ignition.support.IgnitedStrings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public abstract class AbstractCache
{

    private ConcurrentMap cache;
    protected String diskCacheDirectory;
    private long expirationInMinutes;
    private boolean isDiskCacheEnabled;
    private String name;

    public AbstractCache(String s, int i, int j, long l, int k)
    {
        name = s;
        expirationInMinutes = l;
        s = CacheBuilder.newBuilder();
        s.initialCapacity(i);
        if (j != -1)
        {
            s.maximumSize(j);
        }
        s.expireAfterWrite(60L * l, TimeUnit.SECONDS);
        s.concurrencyLevel(k);
        cache = s.build().asMap();
    }

    private void cacheToDisk(Object obj, Object obj1)
    {
        obj = new File((new StringBuilder()).append(diskCacheDirectory).append("/").append(getFileNameForKey(obj)).toString());
        try
        {
            ((File) (obj)).createNewFile();
            ((File) (obj)).deleteOnExit();
            writeValueToDisk(((File) (obj)), obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((FileNotFoundException) (obj)).printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
    }

    private File getFileForKey(Object obj)
    {
        return new File((new StringBuilder()).append(diskCacheDirectory).append("/").append(getFileNameForKey(obj)).toString());
    }

    private void sanitizeDiskCache()
    {
        Iterator iterator = getCachedFiles().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            File file = (File)iterator.next();
            long l = file.lastModified();
            if (((new Date()).getTime() - l) / 60000L >= expirationInMinutes)
            {
                Log.d(name, (new StringBuilder()).append("DISK cache expiration for file ").append(file.toString()).toString());
                file.delete();
            }
        } while (true);
    }

    private void setRootDir(String s)
    {
        diskCacheDirectory = (new StringBuilder()).append(s).append("/cachefu/").append(IgnitedStrings.underscore(name.replaceAll("\\s", ""))).toString();
    }

    public boolean containsKeyInMemory(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = cache.containsKey(obj);
        this;
        JVM INSTR monitorexit ;
        return flag;
        obj;
        throw obj;
    }

    public boolean enableDiskCache(Context context, int i)
    {
        context = context.getApplicationContext();
        if (i == 1 && "mounted".equals(Environment.getExternalStorageState()))
        {
            context = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Android/data/").append(context.getPackageName()).append("/cache").toString();
        } else
        {
            context = context.getCacheDir();
            if (context == null)
            {
                isDiskCacheEnabled = false;
                return false;
            }
            context = context.getAbsolutePath();
        }
        setRootDir(context);
        context = new File(diskCacheDirectory);
        if (context.mkdirs())
        {
            File file = new File(diskCacheDirectory, ".nomedia");
            try
            {
                file.createNewFile();
            }
            catch (IOException ioexception)
            {
                Log.e("Droid-Fu[CacheFu]", "Failed creating .nomedia file");
            }
        }
        isDiskCacheEnabled = context.exists();
        if (!isDiskCacheEnabled)
        {
            Log.w("Droid-Fu[CacheFu]", (new StringBuilder()).append("Failed creating disk cache directory ").append(diskCacheDirectory).toString());
        } else
        {
            Log.d(name, (new StringBuilder()).append("enabled write through to ").append(diskCacheDirectory).toString());
            Log.d(name, "sanitize DISK cache");
            sanitizeDiskCache();
        }
        return isDiskCacheEnabled;
    }

    public Object get(Object obj)
    {
        Object obj2 = null;
        this;
        JVM INSTR monitorenter ;
        Object obj1 = cache.get(obj);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return obj1;
_L2:
        Object obj3 = getFileForKey(obj);
        obj1 = obj2;
        if (!((File) (obj3)).exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = ((File) (obj3)).lastModified();
        if (((new Date()).getTime() - l) / 60000L < expirationInMinutes)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        Log.d(name, (new StringBuilder()).append("DISK cache expiration for file ").append(((File) (obj3)).toString()).toString());
        ((File) (obj3)).delete();
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        Log.d(name, (new StringBuilder()).append("DISK cache hit for ").append(obj.toString()).toString());
        obj3 = parse(readValueFromDisk(((File) (obj3))));
        obj1 = obj2;
        if (obj3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        cache.put(obj, obj3);
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
        obj;
        ((IOException) (obj)).printStackTrace();
        obj1 = obj2;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public List getCachedFiles()
    {
        File afile[] = (new File(diskCacheDirectory)).listFiles();
        if (afile == null)
        {
            return Collections.emptyList();
        } else
        {
            return Arrays.asList(afile);
        }
    }

    public abstract String getFileNameForKey(Object obj);

    protected Object getFromMemory(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = cache.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    protected abstract Object parse(Object obj);

    public Object put(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (isDiskCacheEnabled)
        {
            cacheToDisk(obj, obj1);
        }
        obj = cache.put(obj, parse(obj1));
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    protected abstract Object readValueFromDisk(File file)
        throws IOException;

    protected abstract void writeValueToDisk(File file, Object obj)
        throws IOException;
}

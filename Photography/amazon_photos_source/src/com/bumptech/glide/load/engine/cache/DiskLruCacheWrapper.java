// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.bumptech.glide.load.engine.cache:
//            DiskCache, SafeKeyGenerator

public class DiskLruCacheWrapper
    implements DiskCache
{

    private static DiskLruCacheWrapper wrapper = null;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();

    protected DiskLruCacheWrapper(File file, int i)
    {
        directory = file;
        maxSize = i;
    }

    public static DiskCache get(File file, int i)
    {
        com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper;
        JVM INSTR monitorenter ;
        if (wrapper == null)
        {
            wrapper = new DiskLruCacheWrapper(file, i);
        }
        file = wrapper;
        com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper;
        JVM INSTR monitorexit ;
        return file;
        file;
        throw file;
    }

    private DiskLruCache getDiskCache()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache;
        if (diskLruCache == null)
        {
            diskLruCache = DiskLruCache.open(directory, 1, 1, maxSize);
        }
        disklrucache = diskLruCache;
        this;
        JVM INSTR monitorexit ;
        return disklrucache;
        Exception exception;
        exception;
        throw exception;
    }

    public void delete(Key key)
    {
        key = safeKeyGenerator.getSafeKey(key);
        getDiskCache().remove(key);
_L1:
        return;
        key;
        if (Log.isLoggable("DiskLruCacheWrapper", 5))
        {
            Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", key);
            return;
        }
          goto _L1
    }

    public File get(Key key)
    {
        Object obj;
        key = safeKeyGenerator.getSafeKey(key);
        obj = null;
        com.bumptech.glide.disklrucache.DiskLruCache.Value value = getDiskCache().get(key);
        key = obj;
        if (value != null)
        {
            try
            {
                key = value.getFile(0);
            }
            catch (IOException ioexception)
            {
                key = obj;
                if (Log.isLoggable("DiskLruCacheWrapper", 5))
                {
                    Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", ioexception);
                    return null;
                }
            }
        }
        return key;
    }

    public void put(Key key, DiskCache.Writer writer)
    {
        key = safeKeyGenerator.getSafeKey(key);
        key = getDiskCache().edit(key);
        if (key == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (writer.write(key.getFile(0)))
        {
            key.commit();
        }
        try
        {
            key.abortUnlessCommitted();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key) { }
        break MISSING_BLOCK_LABEL_53;
        writer;
        key.abortUnlessCommitted();
        throw writer;
        if (Log.isLoggable("DiskLruCacheWrapper", 5))
        {
            Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", key);
        }
    }

}

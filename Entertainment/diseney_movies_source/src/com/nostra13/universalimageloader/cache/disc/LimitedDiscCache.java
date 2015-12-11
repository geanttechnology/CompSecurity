// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc:
//            BaseDiscCache

public abstract class LimitedDiscCache extends BaseDiscCache
{

    private final AtomicInteger cacheSize;
    private final Map lastUsageDates;
    private final int sizeLimit;

    public LimitedDiscCache(File file, int i)
    {
        this(file, DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public LimitedDiscCache(File file, FileNameGenerator filenamegenerator, int i)
    {
        super(file, filenamegenerator);
        lastUsageDates = Collections.synchronizedMap(new HashMap());
        sizeLimit = i;
        cacheSize = new AtomicInteger();
        calculateCacheSizeAndFillUsageMap();
    }

    private void calculateCacheSizeAndFillUsageMap()
    {
        (new Thread(new Runnable() {

            final LimitedDiscCache this$0;

            public void run()
            {
                File afile[];
                int j;
                j = 0;
                afile = cacheDir.listFiles();
                if (afile == null) goto _L2; else goto _L1
_L1:
                int i;
                int k;
                k = afile.length;
                i = 0;
_L6:
                if (i < k) goto _L4; else goto _L3
_L3:
                cacheSize.set(j);
_L2:
                return;
_L4:
                File file = afile[i];
                j += getSize(file);
                lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                i++;
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = LimitedDiscCache.this;
                super();
            }
        })).start();
    }

    private int removeNext()
    {
        if (!lastUsageDates.isEmpty()) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        return i;
_L2:
        File file;
        Long long1;
        Object obj;
        long1 = null;
        file = null;
        obj = lastUsageDates.entrySet();
        Map map = lastUsageDates;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = ((Set) (obj)).iterator();
_L7:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int j;
        j = getSize(file);
        i = j;
        if (!file.delete()) goto _L6; else goto _L5
_L5:
        lastUsageDates.remove(file);
        return j;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (file != null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        file = (File)entry.getKey();
        long1 = (Long)entry.getValue();
          goto _L7
        obj = (Long)entry.getValue();
        if (((Long) (obj)).longValue() >= long1.longValue()) goto _L7; else goto _L8
_L8:
        long1 = ((Long) (obj));
        file = (File)entry.getKey();
          goto _L7
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clear()
    {
        lastUsageDates.clear();
        cacheSize.set(0);
        super.clear();
    }

    public File get(String s)
    {
        s = super.get(s);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        s.setLastModified(long1.longValue());
        lastUsageDates.put(s, long1);
        return s;
    }

    protected abstract int getSize(File file);

    public void put(String s, File file)
    {
        int i;
        int j;
        j = getSize(file);
        i = cacheSize.get();
_L5:
        if (i + j > sizeLimit) goto _L2; else goto _L1
_L1:
        cacheSize.addAndGet(j);
        s = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(s.longValue());
        lastUsageDates.put(file, s);
        return;
_L2:
        if ((i = removeNext()) == 0) goto _L1; else goto _L3
_L3:
        i = cacheSize.addAndGet(-i);
        if (true) goto _L5; else goto _L4
_L4:
    }


}

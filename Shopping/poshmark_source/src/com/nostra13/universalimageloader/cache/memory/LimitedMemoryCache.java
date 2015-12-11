// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.nostra13.universalimageloader.cache.memory:
//            BaseMemoryCache

public abstract class LimitedMemoryCache extends BaseMemoryCache
{

    private static final int MAX_NORMAL_CACHE_SIZE = 0x1000000;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final AtomicInteger cacheSize = new AtomicInteger();
    private final List hardCache = Collections.synchronizedList(new LinkedList());
    private final int sizeLimit;

    public LimitedMemoryCache(int i)
    {
        sizeLimit = i;
        if (i > 0x1000000)
        {
            L.w("You set too large memory cache size (more than %1$d Mb)", new Object[] {
                Integer.valueOf(16)
            });
        }
    }

    public void clear()
    {
        hardCache.clear();
        cacheSize.set(0);
        super.clear();
    }

    protected abstract int getSize(Bitmap bitmap);

    protected int getSizeLimit()
    {
        return sizeLimit;
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public boolean put(String s, Bitmap bitmap)
    {
        boolean flag = false;
        int j = getSize(bitmap);
        int k = getSizeLimit();
        int i = cacheSize.get();
        if (j < k)
        {
            do
            {
                if (i + j <= k)
                {
                    break;
                }
                Bitmap bitmap1 = removeNext();
                if (hardCache.remove(bitmap1))
                {
                    i = cacheSize.addAndGet(-getSize(bitmap1));
                }
            } while (true);
            hardCache.add(bitmap);
            cacheSize.addAndGet(j);
            flag = true;
        }
        super.put(s, bitmap);
        return flag;
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        Bitmap bitmap = super.get(s);
        if (bitmap != null && hardCache.remove(bitmap))
        {
            cacheSize.addAndGet(-getSize(bitmap));
        }
        super.remove(s);
    }

    protected abstract Bitmap removeNext();
}

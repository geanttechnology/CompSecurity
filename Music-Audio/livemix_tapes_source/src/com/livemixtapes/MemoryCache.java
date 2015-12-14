// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MemoryCache
{

    private static final String TAG = "MemoryCache";
    private Map cache;
    private long limit;
    private long size;

    public MemoryCache()
    {
        cache = Collections.synchronizedMap(new LinkedHashMap(10, 1.5F, true));
        size = 0L;
        limit = 0xf4240L;
        setLimit(Runtime.getRuntime().maxMemory() / 4L);
    }

    private void checkSize()
    {
        Log.i("MemoryCache", (new StringBuilder("cache size=")).append(size).append(" length=").append(cache.size()).toString());
        if (size <= limit) goto _L2; else goto _L1
_L1:
        Iterator iterator = cache.entrySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Log.i("MemoryCache", (new StringBuilder("Clean cache. New size ")).append(cache.size()).toString());
_L2:
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        size = size - getSizeInBytes((Bitmap)entry.getValue());
        iterator.remove();
        if (size > limit) goto _L5; else goto _L3
    }

    public void clear()
    {
        try
        {
            cache.clear();
            size = 0L;
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            nullpointerexception.printStackTrace();
        }
    }

    public Bitmap get(String s)
    {
        if (!cache.containsKey(s))
        {
            return null;
        }
        try
        {
            s = (Bitmap)cache.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    long getSizeInBytes(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return 0L;
        } else
        {
            return (long)(bitmap.getRowBytes() * bitmap.getHeight());
        }
    }

    public void put(String s, Bitmap bitmap)
    {
        try
        {
            if (cache.containsKey(s))
            {
                size = size - getSizeInBytes((Bitmap)cache.get(s));
            }
            cache.put(s, bitmap);
            size = size + getSizeInBytes(bitmap);
            checkSize();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void setLimit(long l)
    {
        limit = l;
        Log.i("MemoryCache", (new StringBuilder("MemoryCache will use up to ")).append((double)limit / 1024D / 1024D).append("MB").toString());
    }
}

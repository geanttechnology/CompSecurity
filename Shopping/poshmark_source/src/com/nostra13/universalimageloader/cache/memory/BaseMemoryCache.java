// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.nostra13.universalimageloader.cache.memory:
//            MemoryCache

public abstract class BaseMemoryCache
    implements MemoryCache
{

    private final Map softMap = Collections.synchronizedMap(new HashMap());

    public BaseMemoryCache()
    {
    }

    public void clear()
    {
        softMap.clear();
    }

    protected abstract Reference createReference(Bitmap bitmap);

    public Bitmap get(String s)
    {
        Object obj = null;
        Reference reference = (Reference)softMap.get(s);
        s = obj;
        if (reference != null)
        {
            s = (Bitmap)reference.get();
        }
        return s;
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    public Collection keys()
    {
        HashSet hashset;
        synchronized (softMap)
        {
            hashset = new HashSet(softMap.keySet());
        }
        return hashset;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public boolean put(String s, Bitmap bitmap)
    {
        softMap.put(s, createReference(bitmap));
        return true;
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        softMap.remove(s);
    }
}

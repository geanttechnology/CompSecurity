// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import android.content.Context;
import android.util.Log;
import it.sephiroth.android.library.disklrumulticache.DiskLruMultiCache;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import junit.framework.Assert;

public final class DiskCacheManager
{

    static final Object INSTANCES_OBJECT_LOCK = new Object();
    static final HashMap S_INSTANCES = new HashMap();
    static final String TAG = "DiskCacheManager";
    final int code;
    final Object imageCacheMapLock = new Object();
    final HashMap sCacheMap = new HashMap();

    private DiskCacheManager(int i)
    {
        code = i;
    }

    public static DiskLruMultiCache findCache(int i, String s)
    {
        Log.i("DiskCacheManager", (new StringBuilder()).append("instancesContains. skip: ").append(i).append(", name: ").append(s).toString());
        Object obj = INSTANCES_OBJECT_LOCK;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = S_INSTANCES.entrySet().iterator();
        Object obj1;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_123;
                }
                obj1 = (java.util.Map.Entry)iterator.next();
            } while (((DiskCacheManager)((java.util.Map.Entry) (obj1)).getValue()).code == i);
            obj1 = ((DiskCacheManager)((java.util.Map.Entry) (obj1)).getValue()).findCache(s);
        } while (obj1 == null);
        Log.v("DiskCacheManager", "cache found");
        obj;
        JVM INSTR monitorexit ;
        return ((DiskLruMultiCache) (obj1));
        obj;
        JVM INSTR monitorexit ;
        return null;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private DiskLruMultiCache findCache(String s)
    {
        synchronized (imageCacheMapLock)
        {
            s = (DiskLruMultiCache)sCacheMap.get(s);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static DiskCacheManager registerInstance(Context context)
    {
        int i = context.hashCode();
        Object obj = INSTANCES_OBJECT_LOCK;
        obj;
        JVM INSTR monitorenter ;
        DiskCacheManager diskcachemanager1 = (DiskCacheManager)S_INSTANCES.get(Integer.valueOf(i));
        DiskCacheManager diskcachemanager;
        diskcachemanager = diskcachemanager1;
        if (diskcachemanager1 != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        Log.i("DiskCacheManager", (new StringBuilder()).append("registerInstance: ").append(context.hashCode()).toString());
        diskcachemanager = new DiskCacheManager(i);
        S_INSTANCES.put(Integer.valueOf(i), diskcachemanager);
        obj;
        JVM INSTR monitorexit ;
        return diskcachemanager;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void removeInstance(Context context)
    {
        Log.i("DiskCacheManager", (new StringBuilder()).append("removeInstance: ").append(context.hashCode()).toString());
        int i = context.hashCode();
        DiskCacheManager diskcachemanager;
        synchronized (INSTANCES_OBJECT_LOCK)
        {
            diskcachemanager = (DiskCacheManager)S_INSTANCES.remove(Integer.valueOf(i));
        }
        if (diskcachemanager != null)
        {
            diskcachemanager.clear();
        }
        return;
        exception;
        context;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clear()
    {
        Log.i("DiskCacheManager", "clear");
        Object obj = imageCacheMapLock;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = sCacheMap.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        DiskLruMultiCache disklrumulticache;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_148;
        }
        entry = (java.util.Map.Entry)iterator.next();
        disklrumulticache = findCache(code, (String)entry.getKey());
        if (disklrumulticache != null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        Log.v("DiskCacheManager", (new StringBuilder()).append("closing ").append((String)entry.getKey()).toString());
        ((DiskLruMultiCache)entry.getValue()).close();
_L2:
        iterator.remove();
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
          goto _L2
        Log.v("DiskCacheManager", "not closing multi cache because retained by another instance");
          goto _L2
        obj;
        JVM INSTR monitorexit ;
        boolean flag;
        if (sCacheMap.size() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("sImageCacheMap sould be empty, but it's not", flag);
        return;
    }

    public DiskLruMultiCache getCache(Context context, String s, int i)
        throws IOException
    {
        Object obj1 = imageCacheMapLock;
        obj1;
        JVM INSTR monitorenter ;
        DiskLruMultiCache disklrumulticache = (DiskLruMultiCache)sCacheMap.get(s);
        Object obj = disklrumulticache;
        if (disklrumulticache != null) goto _L2; else goto _L1
_L1:
        obj = findCache(code, s);
        if (obj != null) goto _L4; else goto _L3
_L3:
        Log.v("DiskCacheManager", (new StringBuilder()).append("getCache: ").append(s).toString());
        context = new DiskLruMultiCache(context, s, i);
_L5:
        sCacheMap.put(s, context);
        obj = context;
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return ((DiskLruMultiCache) (obj));
_L4:
        Log.v("DiskCacheManager", "don't create a new instance. it already exists");
        context = ((Context) (obj));
          goto _L5
        context;
        obj1;
        JVM INSTR monitorexit ;
        throw context;
    }

    public DiskLruMultiCache removeCache(String s)
    {
        Log.i("DiskCacheManager", (new StringBuilder()).append("removeCache: ").append(s).toString());
        synchronized (imageCacheMapLock)
        {
            s = (DiskLruMultiCache)sCacheMap.remove(s);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

}

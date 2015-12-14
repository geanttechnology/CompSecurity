// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer.util.Assertions;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            Cache, CacheSpan, CacheEvictor

public final class SimpleCache
    implements Cache
{

    private final File cacheDir;
    private final HashMap cachedSpans = new HashMap();
    private final CacheEvictor evictor;
    private final HashMap listeners = new HashMap();
    private final HashMap lockedSpans = new HashMap();
    private long totalSpace;

    public SimpleCache(final File conditionVariable, CacheEvictor cacheevictor)
    {
        totalSpace = 0L;
        cacheDir = conditionVariable;
        evictor = cacheevictor;
        conditionVariable = new ConditionVariable();
        (new Thread() {

            final SimpleCache this$0;
            final ConditionVariable val$conditionVariable;

            public void run()
            {
                synchronized (SimpleCache.this)
                {
                    conditionVariable.open();
                    initialize();
                }
                return;
                exception;
                simplecache;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = SimpleCache.this;
                conditionVariable = conditionvariable;
                super();
            }
        }).start();
        conditionVariable.block();
    }

    private void addSpan(CacheSpan cachespan)
    {
        TreeSet treeset1 = (TreeSet)cachedSpans.get(cachespan.key);
        TreeSet treeset = treeset1;
        if (treeset1 == null)
        {
            treeset = new TreeSet();
            cachedSpans.put(cachespan.key, treeset);
        }
        treeset.add(cachespan);
        totalSpace = totalSpace + cachespan.length;
        notifySpanAdded(cachespan);
    }

    private CacheSpan getSpan(CacheSpan cachespan)
    {
        Object obj = cachespan.key;
        long l = cachespan.position;
        TreeSet treeset = (TreeSet)cachedSpans.get(obj);
        if (treeset == null)
        {
            obj = CacheSpan.createOpenHole(((String) (obj)), cachespan.position);
        } else
        {
            CacheSpan cachespan1 = (CacheSpan)treeset.floor(cachespan);
            if (cachespan1 != null && cachespan1.position <= l && l < cachespan1.position + cachespan1.length)
            {
                obj = cachespan1;
                if (!cachespan1.file.exists())
                {
                    removeStaleSpans();
                    return getSpan(cachespan);
                }
            } else
            {
                CacheSpan cachespan2 = (CacheSpan)treeset.ceiling(cachespan);
                if (cachespan2 == null)
                {
                    cachespan = CacheSpan.createOpenHole(((String) (obj)), cachespan.position);
                } else
                {
                    cachespan = CacheSpan.createClosedHole(((String) (obj)), cachespan.position, cachespan2.position - cachespan.position);
                }
                return cachespan;
            }
        }
        return ((CacheSpan) (obj));
    }

    private void initialize()
    {
        if (!cacheDir.exists())
        {
            cacheDir.mkdirs();
        }
        File afile[] = cacheDir.listFiles();
        if (afile != null)
        {
            int i = 0;
            while (i < afile.length) 
            {
                File file = afile[i];
                if (file.length() == 0L)
                {
                    file.delete();
                } else
                {
                    CacheSpan cachespan = CacheSpan.createCacheEntry(file);
                    if (cachespan == null)
                    {
                        file.delete();
                    } else
                    {
                        addSpan(cachespan);
                    }
                }
                i++;
            }
        }
    }

    private void notifySpanAdded(CacheSpan cachespan)
    {
        ArrayList arraylist = (ArrayList)listeners.get(cachespan.key);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((Cache.Listener)arraylist.get(i)).onSpanAdded(this, cachespan);
            }

        }
        evictor.onSpanAdded(this, cachespan);
    }

    private void notifySpanRemoved(CacheSpan cachespan)
    {
        ArrayList arraylist = (ArrayList)listeners.get(cachespan.key);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((Cache.Listener)arraylist.get(i)).onSpanRemoved(this, cachespan);
            }

        }
        evictor.onSpanRemoved(this, cachespan);
    }

    private void notifySpanTouched(CacheSpan cachespan, CacheSpan cachespan1)
    {
        ArrayList arraylist = (ArrayList)listeners.get(cachespan.key);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((Cache.Listener)arraylist.get(i)).onSpanTouched(this, cachespan, cachespan1);
            }

        }
        evictor.onSpanTouched(this, cachespan, cachespan1);
    }

    private void removeStaleSpans()
    {
        Iterator iterator = cachedSpans.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Iterator iterator1 = ((TreeSet)((java.util.Map.Entry)iterator.next()).getValue()).iterator();
            boolean flag = true;
            while (iterator1.hasNext()) 
            {
                CacheSpan cachespan = (CacheSpan)iterator1.next();
                if (!cachespan.file.exists())
                {
                    iterator1.remove();
                    if (cachespan.isCached)
                    {
                        totalSpace = totalSpace - cachespan.length;
                    }
                    notifySpanRemoved(cachespan);
                } else
                {
                    flag = false;
                }
            }
            if (flag)
            {
                iterator.remove();
            }
        } while (true);
    }

    private CacheSpan startReadWriteNonBlocking(CacheSpan cachespan)
    {
        this;
        JVM INSTR monitorenter ;
        CacheSpan cachespan1 = getSpan(cachespan);
        if (!cachespan1.isCached) goto _L2; else goto _L1
_L1:
        TreeSet treeset = (TreeSet)cachedSpans.get(cachespan1.key);
        Assertions.checkState(treeset.remove(cachespan1));
        cachespan = cachespan1.touch();
        treeset.add(cachespan);
        notifySpanTouched(cachespan1, cachespan);
_L4:
        this;
        JVM INSTR monitorexit ;
        return cachespan;
_L2:
        if (lockedSpans.containsKey(cachespan.key))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        lockedSpans.put(cachespan.key, cachespan1);
        cachespan = cachespan1;
        continue; /* Loop/switch isn't completed */
        cachespan = null;
        if (true) goto _L4; else goto _L3
_L3:
        cachespan;
        throw cachespan;
    }

    public NavigableSet addListener(String s, Cache.Listener listener)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist1 = (ArrayList)listeners.get(s);
        ArrayList arraylist;
        arraylist = arraylist1;
        if (arraylist1 != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        arraylist = new ArrayList();
        listeners.put(s, arraylist);
        arraylist.add(listener);
        s = getCachedSpans(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void commitFile(File file)
    {
        this;
        JVM INSTR monitorenter ;
        CacheSpan cachespan = CacheSpan.createCacheEntry(file);
        boolean flag;
        if (cachespan != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        Assertions.checkState(lockedSpans.containsKey(cachespan.key));
        flag = file.exists();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (file.length() != 0L)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        file.delete();
          goto _L1
        file;
        throw file;
        addSpan(cachespan);
        notifyAll();
          goto _L1
    }

    public long getCacheSpace()
    {
        this;
        JVM INSTR monitorenter ;
        long l = totalSpace;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public NavigableSet getCachedSpans(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (TreeSet)cachedSpans.get(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = new TreeSet(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public Set getKeys()
    {
        this;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet(cachedSpans.keySet());
        this;
        JVM INSTR monitorexit ;
        return hashset;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isCached(String s, long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (TreeSet)cachedSpans.get(s);
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s = (CacheSpan)((TreeSet) (obj)).floor(CacheSpan.createLookup(s, l));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        long l2;
        if (((CacheSpan) (s)).position + ((CacheSpan) (s)).length <= l)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        l2 = l + l1;
        l = ((CacheSpan) (s)).position + ((CacheSpan) (s)).length;
        if (l >= l2)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        s = ((TreeSet) (obj)).tailSet(s, false).iterator();
_L3:
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj = (CacheSpan)s.next();
        if (((CacheSpan) (obj)).position > l)
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        l1 = Math.max(l, ((CacheSpan) (obj)).position + ((CacheSpan) (obj)).length);
        l = l1;
        if (l1 >= l2)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
        flag = false;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void releaseHoleSpan(CacheSpan cachespan)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (cachespan == lockedSpans.remove(cachespan.key))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        cachespan;
        throw cachespan;
    }

    public void removeListener(String s, Cache.Listener listener)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)listeners.get(s);
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        arraylist.remove(listener);
        if (arraylist.isEmpty())
        {
            listeners.remove(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void removeSpan(CacheSpan cachespan)
    {
        this;
        JVM INSTR monitorenter ;
        TreeSet treeset = (TreeSet)cachedSpans.get(cachespan.key);
        totalSpace = totalSpace - cachespan.length;
        Assertions.checkState(treeset.remove(cachespan));
        cachespan.file.delete();
        if (treeset.isEmpty())
        {
            cachedSpans.remove(cachespan.key);
        }
        notifySpanRemoved(cachespan);
        this;
        JVM INSTR monitorexit ;
        return;
        cachespan;
        throw cachespan;
    }

    public File startFile(String s, long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Assertions.checkState(lockedSpans.containsKey(s));
        if (!cacheDir.exists())
        {
            removeStaleSpans();
            cacheDir.mkdirs();
        }
        evictor.onStartFile(this, s, l, l1);
        s = CacheSpan.getCacheFileName(cacheDir, s, l, System.currentTimeMillis());
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public CacheSpan startReadWrite(String s, long l)
        throws InterruptedException
    {
        this;
        JVM INSTR monitorenter ;
        s = CacheSpan.createLookup(s, l);
_L1:
        CacheSpan cachespan = startReadWriteNonBlocking(s);
        if (cachespan == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        this;
        JVM INSTR monitorexit ;
        return cachespan;
        wait();
          goto _L1
        s;
        throw s;
    }

    public CacheSpan startReadWriteNonBlocking(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = startReadWriteNonBlocking(CacheSpan.createLookup(s, l));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

}

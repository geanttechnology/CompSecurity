// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.util.ImageUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCachePolicy

public class LRUCache extends LinkedHashMap
    implements UserListener
{
    private static class TimeAttachment
        implements Comparable
    {

        private String key;
        private Long time;

        public int compareTo(TimeAttachment timeattachment)
        {
            if (timeattachment == null)
            {
                return -1;
            } else
            {
                return time.compareTo(timeattachment.getTime());
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((TimeAttachment)obj);
        }

        public String getKey()
        {
            return key;
        }

        public Long getTime()
        {
            return time;
        }

        public void setTime(Long long1)
        {
            time = long1;
        }

        public TimeAttachment(String s, Long long1)
        {
            time = long1;
            key = s;
        }
    }


    private static long mCurrentLimit = 0x500000L;
    private static volatile double sCacheGets = 0.0D;
    private static volatile double sCacheHits = 0.0D;
    private static final LRUCache sGlobalCache = new LRUCache();
    private long mBitmapSize;
    private final Map mInsertTime = new HashMap();

    private LRUCache()
    {
        super(200, 0.75F, true);
        mBitmapSize = 0L;
        User.addUserListener(this);
    }

    public static void clearCache()
    {
        synchronized (sGlobalCache)
        {
            sGlobalCache.clear();
            sGlobalCache.mInsertTime.clear();
            sGlobalCache.mBitmapSize = 0L;
        }
        return;
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Object getValue(String s, Class class1)
    {
        Object obj;
        LRUCache lrucache;
        obj = null;
        lrucache = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        sCacheGets++;
        s = lrucache;
_L8:
        return s;
_L2:
        String s1 = MShopDiskCachePolicy.uriStrToKey(s);
        lrucache = sGlobalCache;
        lrucache;
        JVM INSTR monitorenter ;
        TimeAttachment timeattachment = (TimeAttachment)sGlobalCache.mInsertTime.get(s1);
        if (timeattachment == null) goto _L4; else goto _L3
_L3:
        s = timeattachment.getTime();
_L9:
        if (s == null) goto _L6; else goto _L5
_L5:
        if (0x36ee80L >= SystemClock.elapsedRealtime() - s.longValue()) goto _L6; else goto _L7
_L7:
        sGlobalCache.remove(s1);
        sGlobalCache.mInsertTime.remove(s1);
        s = ((String) (obj));
_L11:
        obj = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        obj = s;
        if (class1.isInstance(s))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        obj = null;
        sGlobalCache.remove(s1);
        sGlobalCache.mInsertTime.remove(s1);
        lrucache;
        JVM INSTR monitorexit ;
        sCacheGets++;
        s = ((String) (obj));
        if (obj != null)
        {
            sCacheHits++;
            return obj;
        }
          goto _L8
_L4:
        s = null;
          goto _L9
_L6:
        obj = sGlobalCache.get(s1);
        s = ((String) (obj));
        if (timeattachment == null) goto _L11; else goto _L10
_L10:
        timeattachment.setTime(Long.valueOf(SystemClock.elapsedRealtime()));
        s = ((String) (obj));
          goto _L11
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
          goto _L9
    }

    private static List makeSortedList()
    {
        Object obj = new ArrayList();
        LRUCache lrucache = sGlobalCache;
        lrucache;
        JVM INSTR monitorenter ;
        for (Iterator iterator = sGlobalCache.mInsertTime.values().iterator(); iterator.hasNext(); ((List) (obj)).add((TimeAttachment)iterator.next())) { }
        break MISSING_BLOCK_LABEL_64;
        obj;
        lrucache;
        JVM INSTR monitorexit ;
        throw obj;
        Collections.sort(((List) (obj)));
        lrucache;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public static void onLowMemory()
    {
        clearCache();
    }

    public static void putValue(String s, Object obj)
    {
        putValueWithKey(MShopDiskCachePolicy.uriStrToKey(s), obj);
    }

    public static void putValueWithKey(String s, Object obj)
    {
        LRUCache lrucache = sGlobalCache;
        lrucache;
        JVM INSTR monitorenter ;
        sGlobalCache.put(s, obj);
        sGlobalCache.mInsertTime.put(s, new TimeAttachment(s, Long.valueOf(SystemClock.elapsedRealtime())));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (obj instanceof Bitmap)
        {
            s = (Bitmap)obj;
            obj = sGlobalCache;
            obj.mBitmapSize = ((LRUCache) (obj)).mBitmapSize + ImageUtil.sizeOfBitmap(s);
            if (sGlobalCache.mBitmapSize > mCurrentLimit)
            {
                reduceByPercent(25);
            }
        }
        lrucache;
        JVM INSTR monitorexit ;
        return;
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void reduceByPercent(int i)
    {
        if (i >= 100)
        {
            clearCache();
            return;
        }
        if (i < 0)
        {
            return;
        } else
        {
            long l = sGlobalCache.mBitmapSize;
            reduceBySize(((long)i * l) / 100L);
            return;
        }
    }

    public static void reduceBySize(long l)
    {
        reduceBySizeInternal(makeSortedList(), l);
    }

    private static long reduceBySizeInternal(List list, long l)
    {
        long l1 = 0L;
        LRUCache lrucache = sGlobalCache;
        lrucache;
        JVM INSTR monitorenter ;
        long l2 = l1;
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        list = list.iterator();
_L4:
        l2 = l1;
        Object obj;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (TimeAttachment)list.next();
        if (obj == null) goto _L4; else goto _L3
_L3:
        Object obj1 = sGlobalCache.get(((TimeAttachment) (obj)).getKey());
        if (obj1 == null) goto _L4; else goto _L5
_L5:
        if (!(obj1 instanceof Bitmap)) goto _L4; else goto _L6
_L6:
        long l3 = ImageUtil.sizeOfBitmap((Bitmap)obj1);
        l2 = l1 + l3;
        sGlobalCache.remove(((TimeAttachment) (obj)).getKey());
        sGlobalCache.mInsertTime.remove(((TimeAttachment) (obj)).getKey());
        obj = sGlobalCache;
        obj.mBitmapSize = ((LRUCache) (obj)).mBitmapSize - l3;
        l1 = l2;
        if (l2 < l) goto _L4; else goto _L2
_L2:
        lrucache;
        JVM INSTR monitorexit ;
        return l2;
        list;
        lrucache;
        JVM INSTR monitorexit ;
        throw list;
    }

    public static void setCacheLimit(long l)
    {
        mCurrentLimit = l;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        LRUCache lrucache = sGlobalCache;
        lrucache;
        JVM INSTR monitorenter ;
        Object obj;
        boolean flag;
        boolean flag1;
        if (size() > 200)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        obj = ((TimeAttachment)mInsertTime.get(entry.getKey())).getTime();
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        flag1 = flag;
        if (0x36ee80L < SystemClock.elapsedRealtime() - ((Long) (obj)).longValue())
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        mInsertTime.remove(entry.getKey());
        entry = ((java.util.Map.Entry) (entry.getValue()));
        if (entry == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (entry instanceof Bitmap)
        {
            obj = sGlobalCache;
            obj.mBitmapSize = ((LRUCache) (obj)).mBitmapSize - ImageUtil.sizeOfBitmap((Bitmap)entry);
        }
        lrucache;
        JVM INSTR monitorexit ;
        return flag1;
        entry;
        lrucache;
        JVM INSTR monitorexit ;
        throw entry;
    }

    public void userSignedIn(User user)
    {
    }

    public void userSignedOut()
    {
        clearCache();
    }

    public void userUpdated(User user)
    {
    }

}

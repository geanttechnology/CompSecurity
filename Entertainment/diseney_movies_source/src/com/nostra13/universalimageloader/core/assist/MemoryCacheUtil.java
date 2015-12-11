// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nostra13.universalimageloader.core.assist:
//            ImageSize

public final class MemoryCacheUtil
{

    private static final String URI_AND_SIZE_SEPARATOR = "_";
    private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    private MemoryCacheUtil()
    {
    }

    public static Comparator createFuzzyKeyComparator()
    {
        return new Comparator() {

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((String)obj, (String)obj1);
            }

            public int compare(String s, String s1)
            {
                return s.substring(0, s.lastIndexOf("_")).compareTo(s1.substring(0, s1.lastIndexOf("_")));
            }

        };
    }

    public static List findCacheKeysForImageUri(String s, MemoryCacheAware memorycacheaware)
    {
        ArrayList arraylist = new ArrayList();
        memorycacheaware = memorycacheaware.keys().iterator();
        do
        {
            String s1;
            do
            {
                if (!memorycacheaware.hasNext())
                {
                    return arraylist;
                }
                s1 = (String)memorycacheaware.next();
            } while (!s1.startsWith(s));
            arraylist.add(s1);
        } while (true);
    }

    public static List findCachedBitmapsForImageUri(String s, MemoryCacheAware memorycacheaware)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = memorycacheaware.keys().iterator();
        do
        {
            String s1;
            do
            {
                if (!iterator.hasNext())
                {
                    return arraylist;
                }
                s1 = (String)iterator.next();
            } while (!s1.startsWith(s));
            arraylist.add((Bitmap)memorycacheaware.get(s1));
        } while (true);
    }

    public static String generateKey(String s, ImageSize imagesize)
    {
        return (new StringBuilder(s)).append("_").append(imagesize.getWidth()).append("x").append(imagesize.getHeight()).toString();
    }

    public static void removeFromCache(String s, MemoryCacheAware memorycacheaware)
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = memorycacheaware.keys().iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        s = arraylist.iterator();
_L4:
        if (!s.hasNext())
        {
            return;
        }
        break MISSING_BLOCK_LABEL_78;
_L2:
        String s1 = (String)iterator.next();
        if (s1.startsWith(s))
        {
            arraylist.add(s1);
        }
          goto _L3
        memorycacheaware.remove((String)s.next());
          goto _L4
    }
}

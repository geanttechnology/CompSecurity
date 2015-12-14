// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            LruPoolStrategy, GroupedLinkedMap, Poolable, BaseKeyPool

public class SizeConfigStrategy
    implements LruPoolStrategy
{
    static final class Key
        implements Poolable
    {

        private android.graphics.Bitmap.Config config;
        private final KeyPool pool;
        private int size;

        public boolean equals(Object obj)
        {
            boolean flag;
            boolean flag1;
            flag1 = false;
            flag = flag1;
            if (!(obj instanceof Key)) goto _L2; else goto _L1
_L1:
            obj = (Key)obj;
            flag = flag1;
            if (size != ((Key) (obj)).size) goto _L2; else goto _L3
_L3:
            if (config != null) goto _L5; else goto _L4
_L4:
            flag = flag1;
            if (((Key) (obj)).config != null) goto _L2; else goto _L6
_L6:
            flag = true;
_L2:
            return flag;
_L5:
            flag = flag1;
            if (!config.equals(((Key) (obj)).config)) goto _L2; else goto _L6
        }

        public int hashCode()
        {
            int j = size;
            int i;
            if (config != null)
            {
                i = config.hashCode();
            } else
            {
                i = 0;
            }
            return j * 31 + i;
        }

        public void init(int i, android.graphics.Bitmap.Config config1)
        {
            size = i;
            config = config1;
        }

        public void offer()
        {
            pool.offer(this);
        }

        public String toString()
        {
            return SizeConfigStrategy.getBitmapString(size, config);
        }


        public Key(KeyPool keypool)
        {
            pool = keypool;
        }
    }

    static class KeyPool extends BaseKeyPool
    {

        protected volatile Poolable create()
        {
            return create();
        }

        protected Key create()
        {
            return new Key(this);
        }

        public Key get(int i, android.graphics.Bitmap.Config config)
        {
            Key key = (Key)get();
            key.init(i, config);
            return key;
        }

        KeyPool()
        {
        }
    }


    private static final android.graphics.Bitmap.Config ALPHA_8_IN_CONFIGS[];
    private static final android.graphics.Bitmap.Config ARGB_4444_IN_CONFIGS[];
    private static final android.graphics.Bitmap.Config ARGB_8888_IN_CONFIGS[];
    private static final android.graphics.Bitmap.Config RGB_565_IN_CONFIGS[];
    private final GroupedLinkedMap groupedMap = new GroupedLinkedMap();
    private final KeyPool keyPool = new KeyPool();
    private final Map sortedSizes = new HashMap();

    public SizeConfigStrategy()
    {
    }

    private void decrementBitmapOfSize(Integer integer, android.graphics.Bitmap.Config config)
    {
        config = getSizesForConfig(config);
        Integer integer1 = (Integer)config.get(integer);
        if (integer1.intValue() == 1)
        {
            config.remove(integer);
            return;
        } else
        {
            config.put(integer, Integer.valueOf(integer1.intValue() - 1));
            return;
        }
    }

    private Key findBestKey(Key key, int i, android.graphics.Bitmap.Config config)
    {
        Key key1;
        android.graphics.Bitmap.Config aconfig[];
        int j;
        int k;
        key1 = key;
        aconfig = getInConfigs(config);
        k = aconfig.length;
        j = 0;
_L10:
        Key key2 = key1;
        if (j >= k) goto _L2; else goto _L1
_L1:
        android.graphics.Bitmap.Config config1;
        Integer integer;
        config1 = aconfig[j];
        integer = (Integer)getSizesForConfig(config1).ceilingKey(Integer.valueOf(i));
        if (integer == null || integer.intValue() > i * 8) goto _L4; else goto _L3
_L3:
        if (integer.intValue() != i) goto _L6; else goto _L5
_L5:
        if (config1 != null) goto _L8; else goto _L7
_L7:
        key2 = key1;
        if (config == null) goto _L2; else goto _L6
_L6:
        keyPool.offer(key);
        key2 = keyPool.get(integer.intValue(), config1);
_L2:
        return key2;
_L8:
        key2 = key1;
        if (config1.equals(config)) goto _L2; else goto _L6
_L4:
        j++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static String getBitmapString(int i, android.graphics.Bitmap.Config config)
    {
        return (new StringBuilder()).append("[").append(i).append("](").append(config).append(")").toString();
    }

    private static android.graphics.Bitmap.Config[] getInConfigs(android.graphics.Bitmap.Config config)
    {
        static class _cls1
        {

            static final int $SwitchMap$android$graphics$Bitmap$Config[];

            static 
            {
                $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Bitmap.Config.values().length];
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.android.graphics.Bitmap.Config[config.ordinal()])
        {
        default:
            return (new android.graphics.Bitmap.Config[] {
                config
            });

        case 1: // '\001'
            return ARGB_8888_IN_CONFIGS;

        case 2: // '\002'
            return RGB_565_IN_CONFIGS;

        case 3: // '\003'
            return ARGB_4444_IN_CONFIGS;

        case 4: // '\004'
            return ALPHA_8_IN_CONFIGS;
        }
    }

    private NavigableMap getSizesForConfig(android.graphics.Bitmap.Config config)
    {
        NavigableMap navigablemap = (NavigableMap)sortedSizes.get(config);
        Object obj = navigablemap;
        if (navigablemap == null)
        {
            obj = new TreeMap();
            sortedSizes.put(config, obj);
        }
        return ((NavigableMap) (obj));
    }

    public Bitmap get(int i, int j, android.graphics.Bitmap.Config config)
    {
        int k = Util.getBitmapByteSize(i, j, config);
        config = findBestKey(keyPool.get(k, config), k, config);
        Bitmap bitmap = (Bitmap)groupedMap.get(config);
        if (bitmap != null)
        {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)), bitmap.getConfig());
            if (bitmap.getConfig() != null)
            {
                config = bitmap.getConfig();
            } else
            {
                config = android.graphics.Bitmap.Config.ARGB_8888;
            }
            bitmap.reconfigure(i, j, config);
        }
        return bitmap;
    }

    public int getSize(Bitmap bitmap)
    {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(int i, int j, android.graphics.Bitmap.Config config)
    {
        return getBitmapString(Util.getBitmapByteSize(i, j, config), config);
    }

    public String logBitmap(Bitmap bitmap)
    {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    public void put(Bitmap bitmap)
    {
        int i = Util.getBitmapByteSize(bitmap);
        Key key = keyPool.get(i, bitmap.getConfig());
        groupedMap.put(key, bitmap);
        bitmap = getSizesForConfig(bitmap.getConfig());
        Integer integer = (Integer)bitmap.get(Integer.valueOf(key.size));
        int j = key.size;
        if (integer == null)
        {
            i = 1;
        } else
        {
            i = integer.intValue() + 1;
        }
        bitmap.put(Integer.valueOf(j), Integer.valueOf(i));
    }

    public Bitmap removeLast()
    {
        Bitmap bitmap = (Bitmap)groupedMap.removeLast();
        if (bitmap != null)
        {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)), bitmap.getConfig());
        }
        return bitmap;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("SizeConfigStrategy{groupedMap=").append(groupedMap).append(", sortedSizes=(");
        java.util.Map.Entry entry;
        for (Iterator iterator = sortedSizes.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(entry.getKey()).append('[').append(entry.getValue()).append("], "))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        if (!sortedSizes.isEmpty())
        {
            stringbuilder.replace(stringbuilder.length() - 2, stringbuilder.length(), "");
        }
        return stringbuilder.append(")}").toString();
    }

    static 
    {
        ARGB_8888_IN_CONFIGS = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ARGB_8888, null
        });
        RGB_565_IN_CONFIGS = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.RGB_565
        });
        ARGB_4444_IN_CONFIGS = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ARGB_4444
        });
        ALPHA_8_IN_CONFIGS = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ALPHA_8
        });
    }

}

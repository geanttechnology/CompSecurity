// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            LruPoolStrategy, GroupedLinkedMap, Poolable, BaseKeyPool

class AttributeStrategy
    implements LruPoolStrategy
{
    static class Key
        implements Poolable
    {

        private android.graphics.Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof Key)
            {
                obj = (Key)obj;
                flag = flag1;
                if (width == ((Key) (obj)).width)
                {
                    flag = flag1;
                    if (height == ((Key) (obj)).height)
                    {
                        flag = flag1;
                        if (config == ((Key) (obj)).config)
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            int j = width;
            int k = height;
            int i;
            if (config != null)
            {
                i = config.hashCode();
            } else
            {
                i = 0;
            }
            return (j * 31 + k) * 31 + i;
        }

        public void init(int i, int j, android.graphics.Bitmap.Config config1)
        {
            width = i;
            height = j;
            config = config1;
        }

        public void offer()
        {
            pool.offer(this);
        }

        public String toString()
        {
            return AttributeStrategy.getBitmapString(width, height, config);
        }

        public Key(KeyPool keypool)
        {
            pool = keypool;
        }
    }

    static class KeyPool extends BaseKeyPool
    {

        protected Key create()
        {
            return new Key(this);
        }

        protected volatile Poolable create()
        {
            return create();
        }

        public Key get(int i, int j, android.graphics.Bitmap.Config config)
        {
            Key key = (Key)get();
            key.init(i, j, config);
            return key;
        }

        KeyPool()
        {
        }
    }


    private final GroupedLinkedMap groupedMap = new GroupedLinkedMap();
    private final KeyPool keyPool = new KeyPool();

    AttributeStrategy()
    {
    }

    private static String getBitmapString(int i, int j, android.graphics.Bitmap.Config config)
    {
        return (new StringBuilder()).append("[").append(i).append("x").append(j).append("], ").append(config).toString();
    }

    private static String getBitmapString(Bitmap bitmap)
    {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap get(int i, int j, android.graphics.Bitmap.Config config)
    {
        config = keyPool.get(i, j, config);
        return (Bitmap)groupedMap.get(config);
    }

    public int getSize(Bitmap bitmap)
    {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(int i, int j, android.graphics.Bitmap.Config config)
    {
        return getBitmapString(i, j, config);
    }

    public String logBitmap(Bitmap bitmap)
    {
        return getBitmapString(bitmap);
    }

    public void put(Bitmap bitmap)
    {
        Key key = keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        groupedMap.put(key, bitmap);
    }

    public Bitmap removeLast()
    {
        return (Bitmap)groupedMap.removeLast();
    }

    public String toString()
    {
        return (new StringBuilder()).append("AttributeStrategy:\n  ").append(groupedMap).toString();
    }

}

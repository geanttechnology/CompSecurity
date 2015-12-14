// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache
{
    static final class ModelKey
    {

        private static final Queue KEY_QUEUE = Util.createQueue(0);
        private int height;
        private Object model;
        private int width;

        static ModelKey get(Object obj, int i, int j)
        {
            ModelKey modelkey1 = (ModelKey)KEY_QUEUE.poll();
            ModelKey modelkey = modelkey1;
            if (modelkey1 == null)
            {
                modelkey = new ModelKey();
            }
            modelkey.init(obj, i, j);
            return modelkey;
        }

        private void init(Object obj, int i, int j)
        {
            model = obj;
            width = i;
            height = j;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof ModelKey)
            {
                obj = (ModelKey)obj;
                flag = flag1;
                if (width == ((ModelKey) (obj)).width)
                {
                    flag = flag1;
                    if (height == ((ModelKey) (obj)).height)
                    {
                        flag = flag1;
                        if (model.equals(((ModelKey) (obj)).model))
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
            return (height * 31 + width) * 31 + model.hashCode();
        }

        public void release()
        {
            KEY_QUEUE.offer(this);
        }


        private ModelKey()
        {
        }
    }


    private final LruCache cache;

    public ModelCache()
    {
        this(250);
    }

    public ModelCache(int i)
    {
        cache = new LruCache(i) {

            final ModelCache this$0;

            protected void onItemEvicted(ModelKey modelkey, Object obj)
            {
                modelkey.release();
            }

            protected volatile void onItemEvicted(Object obj, Object obj1)
            {
                onItemEvicted((ModelKey)obj, obj1);
            }

            
            {
                this$0 = ModelCache.this;
                super(i);
            }
        };
    }

    public Object get(Object obj, int i, int j)
    {
        obj = ModelKey.get(obj, i, j);
        Object obj1 = cache.get(obj);
        ((ModelKey) (obj)).release();
        return obj1;
    }

    public void put(Object obj, int i, int j, Object obj1)
    {
        obj = ModelKey.get(obj, i, j);
        cache.put(obj, obj1);
    }
}

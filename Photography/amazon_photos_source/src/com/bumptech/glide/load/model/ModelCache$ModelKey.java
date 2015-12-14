// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import com.bumptech.glide.util.Util;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelCache

static final class 
{

    private static final Queue KEY_QUEUE = Util.createQueue(0);
    private int height;
    private Object model;
    private int width;

    static  get(Object obj, int i, int j)
    {
         1 = ()KEY_QUEUE.poll();
          = 1;
        if (1 == null)
        {
             = new <init>();
        }
        .init(obj, i, j);
        return ;
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
        if (obj instanceof height)
        {
            obj = (height)obj;
            flag = flag1;
            if (width == ((width) (obj)).width)
            {
                flag = flag1;
                if (height == ((height) (obj)).height)
                {
                    flag = flag1;
                    if (model.equals(((model) (obj)).model))
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


    private ()
    {
    }
}

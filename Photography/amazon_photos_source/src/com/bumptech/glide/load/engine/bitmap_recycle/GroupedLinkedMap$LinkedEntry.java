// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            GroupedLinkedMap

private static class key
{

    private final Object key;
    values next;
    values prev;
    private List values;

    public void add(Object obj)
    {
        if (values == null)
        {
            values = new ArrayList();
        }
        values.add(obj);
    }

    public Object removeLast()
    {
        int i = size();
        if (i > 0)
        {
            return values.remove(i - 1);
        } else
        {
            return null;
        }
    }

    public int size()
    {
        if (values != null)
        {
            return values.size();
        } else
        {
            return 0;
        }
    }


    public ()
    {
        this(null);
    }

    public <init>(Object obj)
    {
        prev = this;
        next = this;
        key = obj;
    }
}

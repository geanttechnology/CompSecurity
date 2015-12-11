// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.client.framework.acf:
//            WeakRegistrar

private static class <init>
    implements Iterator
{

    static final boolean $assertionsDisabled;
    private int mIndex;
    private final List mRegistry;

    public boolean hasNext()
    {
        boolean flag1 = false;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (mIndex < mRegistry.size())
                {
                    WeakReference weakreference = (WeakReference)mRegistry.get(mIndex);
                    if (weakreference.get() == null || weakreference.isEnqueued())
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            mIndex = mIndex + 1;
        } while (true);
    }

    public Object next()
    {
        Object obj = null;
        do
        {
label0:
            {
                if (mIndex < mRegistry.size())
                {
                    WeakReference weakreference = (WeakReference)mRegistry.get(mIndex);
                    Object obj1 = weakreference.get();
                    obj = obj1;
                    if (obj1 == null)
                    {
                        continue;
                    }
                    mIndex = mIndex + 1;
                    if (weakreference.isEnqueued())
                    {
                        break label0;
                    }
                    obj = obj1;
                }
                return obj;
            }
            obj = null;
        } while (true);
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    static 
    {
        boolean flag;
        if (!com/amazon/client/framework/acf/WeakRegistrar.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private (List list)
    {
        if (!$assertionsDisabled && list == null)
        {
            throw new AssertionError();
        } else
        {
            mRegistry = list;
            mIndex = 0;
            return;
        }
    }

    mIndex(List list, mIndex mindex)
    {
        this(list);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.client.framework.acf:
//            Registrar

public class WeakRegistrar
    implements Registrar
{
    private static class WorkingSetIterator
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

        private WorkingSetIterator(List list)
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

    }


    private final ReferenceQueue mReferenceQueue = new ReferenceQueue();
    private final AtomicReference mRegistry = new AtomicReference(Collections.emptyList());

    public WeakRegistrar()
    {
    }

    public void add(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        for (Iterator iterator1 = ((List)mRegistry.get()).iterator(); iterator1.hasNext();)
        {
            if (((WeakReference)iterator1.next()).get() == obj)
            {
                return;
            }
        }

        addReferenceFast(obj);
    }

    public void addReferenceFast(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        List list;
        ArrayList arraylist;
        do
        {
            list = (List)mRegistry.get();
            arraylist = new ArrayList(list);
            arraylist.add(new WeakReference(obj, mReferenceQueue));
        } while (!mRegistry.compareAndSet(list, arraylist));
    }

    public void clean()
    {
        List list;
        ArrayList arraylist;
        do
        {
            list = (List)mRegistry.get();
            arraylist = new ArrayList(list);
            do
            {
                java.lang.ref.Reference reference = mReferenceQueue.poll();
                if (reference == null)
                {
                    break;
                }
                arraylist.remove(reference);
            } while (true);
        } while (!mRegistry.compareAndSet(list, arraylist));
    }

    public void clear()
    {
        mRegistry.set(Collections.emptyList());
    }

    public boolean enqueue(int i)
    {
        return ((WeakReference)((List)mRegistry.get()).get(i)).enqueue();
    }

    public int estimatedSize()
    {
        return ((List)mRegistry.get()).size();
    }

    public Iterator iterator()
    {
        return new WorkingSetIterator((List)mRegistry.get());
    }

    public boolean remove(Object obj)
    {
        boolean flag1 = false;
_L1:
        List list;
        ArrayList arraylist;
        int i;
        list = (List)mRegistry.get();
        arraylist = new ArrayList(list);
        i = 0;
_L2:
        Object obj1;
        boolean flag;
        do
        {
label0:
            {
                flag = flag1;
                if (i >= arraylist.size())
                {
                    break MISSING_BLOCK_LABEL_106;
                }
                WeakReference weakreference = (WeakReference)arraylist.get(i);
                obj1 = weakreference.get();
                if (obj1 != null && !weakreference.isEnqueued())
                {
                    break label0;
                }
                arraylist.remove(i);
            }
        } while (true);
        if (obj != obj1)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        if (arraylist.remove(i) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (mRegistry.compareAndSet(list, arraylist))
        {
            return flag;
        }
          goto _L1
        i++;
          goto _L2
    }

    public int size()
    {
        clean();
        return estimatedSize();
    }
}

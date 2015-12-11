// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            MapMakerInternalMap, AbstractSequentialIterator

static final class _cls2.this._cls0 extends AbstractQueue
{

    final etNextExpirable head = new MapMakerInternalMap.AbstractReferenceEntry() {

        MapMakerInternalMap.ReferenceEntry nextExpirable;
        MapMakerInternalMap.ReferenceEntry previousExpirable;
        final MapMakerInternalMap.ExpirationQueue this$0;

        public long getExpirationTime()
        {
            return 0x7fffffffffffffffL;
        }

        public MapMakerInternalMap.ReferenceEntry getNextExpirable()
        {
            return nextExpirable;
        }

        public MapMakerInternalMap.ReferenceEntry getPreviousExpirable()
        {
            return previousExpirable;
        }

        public void setExpirationTime(long l)
        {
        }

        public void setNextExpirable(MapMakerInternalMap.ReferenceEntry referenceentry)
        {
            nextExpirable = referenceentry;
        }

        public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry referenceentry)
        {
            previousExpirable = referenceentry;
        }

            
            {
                this$0 = MapMakerInternalMap.ExpirationQueue.this;
                super();
                nextExpirable = this;
                previousExpirable = this;
            }
    };

    public void clear()
    {
        _cls2.this._cls0 _lcls0_1;
        for (_cls2.this._cls0 _lcls0 = head.etNextExpirable(); _lcls0 != head; _lcls0 = _lcls0_1)
        {
            _lcls0_1 = _lcls0.etNextExpirable();
            MapMakerInternalMap.nullifyExpirable(_lcls0);
        }

        head.etNextExpirable(head);
        head.etPreviousExpirable(head);
    }

    public boolean contains(Object obj)
    {
        return ((head)obj).etNextExpirable() != CE;
    }

    public boolean isEmpty()
    {
        return head.etNextExpirable() == head;
    }

    public Iterator iterator()
    {
        return new AbstractSequentialIterator(peek()) {

            final MapMakerInternalMap.ExpirationQueue this$0;

            protected volatile Object computeNext(Object obj)
            {
                return computeNext((MapMakerInternalMap.ReferenceEntry)obj);
            }

            protected MapMakerInternalMap.ReferenceEntry computeNext(MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                MapMakerInternalMap.ReferenceEntry referenceentry1 = referenceentry.getNextExpirable();
                referenceentry = referenceentry1;
                if (referenceentry1 == head)
                {
                    referenceentry = null;
                }
                return referenceentry;
            }

            
            {
                this$0 = MapMakerInternalMap.ExpirationQueue.this;
                super(referenceentry);
            }
        };
    }

    public volatile boolean offer(Object obj)
    {
        return offer((offer)obj);
    }

    public boolean offer(offer offer1)
    {
        MapMakerInternalMap.connectExpirables(offer1.etPreviousExpirable(), offer1.etNextExpirable());
        MapMakerInternalMap.connectExpirables(head.etPreviousExpirable(), offer1);
        MapMakerInternalMap.connectExpirables(offer1, head);
        return true;
    }

    public volatile Object peek()
    {
        return peek();
    }

    public peek peek()
    {
        peek peek2 = head.etNextExpirable();
        peek peek1 = peek2;
        if (peek2 == head)
        {
            peek1 = null;
        }
        return peek1;
    }

    public volatile Object poll()
    {
        return poll();
    }

    public poll poll()
    {
        poll poll1 = head.etNextExpirable();
        if (poll1 == head)
        {
            return null;
        } else
        {
            remove(poll1);
            return poll1;
        }
    }

    public boolean remove(Object obj)
    {
        obj = (remove)obj;
        remove remove1 = ((remove) (obj)).etPreviousExpirable();
        remove remove2 = ((etPreviousExpirable) (obj)).etNextExpirable();
        MapMakerInternalMap.connectExpirables(remove1, remove2);
        MapMakerInternalMap.nullifyExpirable((() (obj)));
        return remove2 != CE;
    }

    public int size()
    {
        int i = 0;
        for (CE ce = head.etNextExpirable(); ce != head; ce = ce.etNextExpirable())
        {
            i++;
        }

        return i;
    }

    _cls2.this._cls0()
    {
    }
}

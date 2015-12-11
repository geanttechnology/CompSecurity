// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.collect:
//            BiMap

class this._cls0 extends AbstractSet
{

    final BiMap this$0;

    public boolean contains(Object obj)
    {
        return BiMap.access$201(BiMap.this).contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return BiMap.access$301(BiMap.this).containsAll(collection);
    }

    public Iterator iterator()
    {
        return new Iterator() {

            Iterator it;
            final BiMap._cls1 this$1;

            public boolean hasNext()
            {
                return it.hasNext();
            }

            public volatile Object next()
            {
                return next();
            }

            public java.util.Map.Entry next()
            {
                return (java.util.Map.Entry)it.next();
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }

            
            {
                this$1 = BiMap._cls1.this;
                super();
                it = BiMap.access$001(this$0).iterator();
            }
        };
    }

    public int size()
    {
        return BiMap.access$101(BiMap.this).size();
    }

    this._cls0()
    {
        this$0 = BiMap.this;
        super();
    }
}

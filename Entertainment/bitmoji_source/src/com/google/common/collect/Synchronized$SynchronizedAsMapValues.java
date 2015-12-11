// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            Synchronized, TransformedIterator

private static class init> extends init>
{

    private static final long serialVersionUID = 0L;

    public Iterator iterator()
    {
        return new TransformedIterator(super.terator()) {

            final Synchronized.SynchronizedAsMapValues this$0;

            volatile Object transform(Object obj)
            {
                return transform((Collection)obj);
            }

            Collection transform(Collection collection)
            {
                return Synchronized.access$400(collection, mutex);
            }

            
            {
                this$0 = Synchronized.SynchronizedAsMapValues.this;
                super(iterator1);
            }
        };
    }

    _cls1.this._cls0(Collection collection, Object obj)
    {
        super(collection, obj, null);
    }
}

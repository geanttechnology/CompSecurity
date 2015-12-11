// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            TransformedIterator, Synchronized

class this._cls0 extends TransformedIterator
{

    final tex this$0;

    volatile Object transform(Object obj)
    {
        return transform((Collection)obj);
    }

    Collection transform(Collection collection)
    {
        return Synchronized.access$400(collection, tex);
    }

    (Iterator iterator)
    {
        this$0 = this._cls0.this;
        super(iterator);
    }
}

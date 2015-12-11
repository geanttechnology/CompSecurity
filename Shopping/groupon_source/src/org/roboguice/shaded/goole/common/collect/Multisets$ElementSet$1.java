// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            TransformedIterator, Multisets

class it> extends TransformedIterator
{

    final nt this$0;

    volatile Object transform(Object obj)
    {
        return transform((transform)obj);
    }

    Object transform(transform transform1)
    {
        return transform1.nt();
    }

    (Iterator iterator)
    {
        this$0 = this._cls0.this;
        super(iterator);
    }
}

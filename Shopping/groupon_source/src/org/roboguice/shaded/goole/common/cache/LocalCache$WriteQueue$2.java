// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import org.roboguice.shaded.goole.common.collect.AbstractSequentialIterator;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LocalCache

class ator extends AbstractSequentialIterator
{

    final ad this$0;

    protected volatile Object computeNext(Object obj)
    {
        return computeNext((y)obj);
    }

    protected y computeNext(y y)
    {
        y y1 = y.getNextInWriteQueue();
        y = y1;
        if (y1 == ad)
        {
            y = null;
        }
        return y;
    }

    y(y y1)
    {
        this$0 = this._cls0.this;
        super(y1);
    }
}

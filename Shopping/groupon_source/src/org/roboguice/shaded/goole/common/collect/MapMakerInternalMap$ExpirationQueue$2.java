// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;


// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            AbstractSequentialIterator, MapMakerInternalMap

class this._cls0 extends AbstractSequentialIterator
{

    final ad this$0;

    protected volatile Object computeNext(Object obj)
    {
        return computeNext((computeNext)obj);
    }

    protected computeNext computeNext(computeNext computenext)
    {
        computeNext computenext1 = computenext.NextExpirable();
        computenext = computenext1;
        if (computenext1 == ad)
        {
            computenext = null;
        }
        return computenext;
    }

    ( 1)
    {
        this$0 = this._cls0.this;
        super(1);
    }
}

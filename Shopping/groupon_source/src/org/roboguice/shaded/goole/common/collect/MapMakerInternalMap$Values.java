// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            MapMakerInternalMap

final class this._cls0 extends AbstractCollection
{

    final MapMakerInternalMap this$0;

    public void clear()
    {
        MapMakerInternalMap.this.clear();
    }

    public boolean contains(Object obj)
    {
        return containsValue(obj);
    }

    public boolean isEmpty()
    {
        return MapMakerInternalMap.this.isEmpty();
    }

    public Iterator iterator()
    {
        return new erator(MapMakerInternalMap.this);
    }

    public int size()
    {
        return MapMakerInternalMap.this.size();
    }

    erator()
    {
        this$0 = MapMakerInternalMap.this;
        super();
    }
}

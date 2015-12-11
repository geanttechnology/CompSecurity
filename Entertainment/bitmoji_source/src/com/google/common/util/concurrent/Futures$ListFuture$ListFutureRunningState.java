// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures

private final class ate extends ate
{

    final combine this$0;

    public volatile Object combine(List list)
    {
        return combine(list);
    }

    public List combine(List list)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (Optional)iterator.next();
            if (list != null)
            {
                list = ((List) (list.orNull()));
            } else
            {
                list = null;
            }
            arraylist.add(list);
        }
        return Collections.unmodifiableList(arraylist);
    }

    ate(ImmutableCollection immutablecollection, boolean flag)
    {
        this$0 = this._cls0.this;
        super(ate.this, immutablecollection, flag);
    }
}

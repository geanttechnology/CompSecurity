// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

// Referenced classes of package com.google.common.util.concurrent:
//            CollectionFuture

abstract class values extends values
{

    final CollectionFuture this$0;
    private List values;

    final void collectOneValue(boolean flag, int i, Object obj)
    {
        List list = values;
        if (list != null)
        {
            list.set(i, Optional.fromNullable(obj));
            return;
        }
        if (flag || isCancelled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Future was done before all dependencies completed");
    }

    abstract Object combine(List list);

    final void handleAllCompleted()
    {
        List list = values;
        if (list != null)
        {
            set(combine(list));
            return;
        } else
        {
            Preconditions.checkState(isDone());
            return;
        }
    }

    void releaseResourcesAfterFailure()
    {
        super.fterFailure();
        values = null;
    }

    (ImmutableCollection immutablecollection, boolean flag)
    {
        this$0 = CollectionFuture.this;
        super(CollectionFuture.this, immutablecollection, flag, true);
        if (immutablecollection.isEmpty())
        {
            collectionfuture = ImmutableList.of();
        } else
        {
            collectionfuture = Lists.newArrayListWithCapacity(immutablecollection.size());
        }
        values = (List)CollectionFuture.this;
        for (int i = 0; i < immutablecollection.size(); i++)
        {
            values.add(null);
        }

    }
}

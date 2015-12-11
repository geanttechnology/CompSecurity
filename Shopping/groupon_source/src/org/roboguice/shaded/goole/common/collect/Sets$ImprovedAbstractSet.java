// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Sets

static abstract class  extends AbstractSet
{

    public boolean removeAll(Collection collection)
    {
        return Sets.removeAllImpl(this, collection);
    }

    public boolean retainAll(Collection collection)
    {
        return super.retainAll((Collection)Preconditions.checkNotNull(collection));
    }

    ()
    {
    }
}

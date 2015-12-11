// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.AbstractSet;
import java.util.Collection;

// Referenced classes of package com.google.a.c:
//            be

static abstract class  extends AbstractSet
{

    public boolean removeAll(Collection collection)
    {
        return be.a(this, collection);
    }

    public boolean retainAll(Collection collection)
    {
        return super.retainAll((Collection)g.a(collection));
    }

    ()
    {
    }
}

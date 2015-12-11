// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import org.roboguice.shaded.goole.common.base.Supplier;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LongAddables, LongAdder, LongAddable

static final class 
    implements Supplier
{

    public volatile Object get()
    {
        return get();
    }

    public LongAddable get()
    {
        return new LongAdder();
    }

    ()
    {
    }
}

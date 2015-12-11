// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableMapEntrySet, ImmutableMap, UnmodifiableIterator

class this._cls0 extends ImmutableMapEntrySet
{

    final this._cls0 this$0;

    public UnmodifiableIterator iterator()
    {
        return _mth0();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    ImmutableMap map()
    {
        return this._cls0.this;
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}

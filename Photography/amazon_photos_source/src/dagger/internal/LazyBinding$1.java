// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import dagger.Lazy;

// Referenced classes of package dagger.internal:
//            LazyBinding

class cess._cls000
    implements Lazy
{

    private Object cacheValue;
    final LazyBinding this$0;

    ()
    {
        this$0 = LazyBinding.this;
        super();
        cacheValue = LazyBinding.access$000();
    }
}

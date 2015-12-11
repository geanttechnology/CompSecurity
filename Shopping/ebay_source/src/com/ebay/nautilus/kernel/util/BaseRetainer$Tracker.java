// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;


// Referenced classes of package com.ebay.nautilus.kernel.util:
//            BaseRetainer

protected final class refCount
    implements refCount
{

    protected Class owningClass;
    protected volatile int refCount;
    protected Object state;
    final BaseRetainer this$0;
    protected long ttl;

    protected boolean decRefCount()
    {
        refCount = refCount - 1;
        return refCount <= 0;
    }

    protected void incRefCount()
    {
        refCount = refCount + 1;
    }

    public void onSweep()
    {
        removeTracker(this);
    }

    protected (Class class1, Object obj, long l)
    {
        this$0 = BaseRetainer.this;
        super();
        owningClass = class1;
        state = obj;
        ttl = l;
        refCount = 0;
    }
}

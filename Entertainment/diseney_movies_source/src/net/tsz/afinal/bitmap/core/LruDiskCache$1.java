// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import java.util.concurrent.Callable;

// Referenced classes of package net.tsz.afinal.bitmap.core:
//            LruDiskCache

class this._cls0
    implements Callable
{

    final LruDiskCache this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
label0:
        {
            synchronized (LruDiskCache.this)
            {
                if (LruDiskCache.access$0(LruDiskCache.this) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        LruDiskCache.access$1(LruDiskCache.this);
        if (LruDiskCache.access$2(LruDiskCache.this))
        {
            LruDiskCache.access$3(LruDiskCache.this);
            LruDiskCache.access$4(LruDiskCache.this, 0);
        }
        lrudiskcache;
        JVM INSTR monitorexit ;
        return null;
        exception;
        lrudiskcache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = LruDiskCache.this;
        super();
    }
}

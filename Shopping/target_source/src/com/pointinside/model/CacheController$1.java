// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;


// Referenced classes of package com.pointinside.model:
//            CacheController, Cachable

class val.c
    implements Runnable
{

    final CacheController this$0;
    final Cachable val$c;

    public void run()
    {
        add(val$c);
    }

    ()
    {
        this$0 = final_cachecontroller;
        val$c = Cachable.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;


// Referenced classes of package com.ebay.nautilus.kernel.util:
//            Sweeper

class this._cls0
    implements Runnable
{

    final Sweeper this$0;

    public void run()
    {
        performSweep();
    }

    ()
    {
        this$0 = Sweeper.this;
        super();
    }
}

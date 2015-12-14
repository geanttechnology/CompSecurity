// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.components;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.facebook.drawee.components:
//            DeferredReleaser

class this._cls0
    implements Runnable
{

    final DeferredReleaser this$0;

    public void run()
    {
        for (Iterator iterator = DeferredReleaser.access$000(DeferredReleaser.this).iterator(); iterator.hasNext(); ((leasable)iterator.next()).release()) { }
        DeferredReleaser.access$000(DeferredReleaser.this).clear();
    }

    leasable()
    {
        this$0 = DeferredReleaser.this;
        super();
    }
}

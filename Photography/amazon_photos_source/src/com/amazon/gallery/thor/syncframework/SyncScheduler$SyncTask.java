// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            SyncScheduler

private class context
    implements Runnable
{

    private Context context;
    final SyncScheduler this$0;

    public void run()
    {
        syncNow(context);
    }

    public (Context context1)
    {
        this$0 = SyncScheduler.this;
        super();
        context = context1;
    }
}

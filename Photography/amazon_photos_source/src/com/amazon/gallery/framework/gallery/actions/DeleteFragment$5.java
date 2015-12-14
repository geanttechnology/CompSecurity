// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.content.DialogInterface;
import android.os.AsyncTask;
import com.amazon.gallery.framework.gallery.metrics.EngagementMetrics;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class val.deleteOperation
    implements android.content.nClickListener
{

    final DeleteFragment this$0;
    final AsyncTask val$deleteOperation;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        DeleteFragment.access$400(DeleteFragment.this).trackEvent(com.amazon.gallery.framework.gallery.metrics..MetricsEvent.DeleteClickedFromAlbumsListDialog);
        val$deleteOperation.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    ()
    {
        this$0 = final_deletefragment;
        val$deleteOperation = AsyncTask.this;
        super();
    }
}

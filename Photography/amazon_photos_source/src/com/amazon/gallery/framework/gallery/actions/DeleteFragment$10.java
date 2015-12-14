// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.thor.albums.DeleteFromAlbumTask;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class val.deleteCloud
    implements Runnable
{

    final DeleteFragment this$0;
    final Activity val$activity;
    final boolean val$deleteCloud;
    final List val$mediaItemList;
    final String val$parentObjectId;

    public void run()
    {
        DeleteFromAlbumTask deletefromalbumtask = new DeleteFromAlbumTask(val$activity, val$mediaItemList, val$parentObjectId, val$deleteCloud, DeleteFragment.access$1100(DeleteFragment.this));
        deletefromalbumtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
_L2:
        GlobalMessagingBus.post(new ActionCompleteEvent());
        return;
        Object obj;
        obj;
        GLogger.ex(DeleteFragment.access$100(), "Error occurred trying to delete item(s) from album", ((Throwable) (obj)));
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        throw obj;
    }

    nt()
    {
        this$0 = final_deletefragment;
        val$activity = activity1;
        val$mediaItemList = list;
        val$parentObjectId = s;
        val$deleteCloud = Z.this;
        super();
    }
}

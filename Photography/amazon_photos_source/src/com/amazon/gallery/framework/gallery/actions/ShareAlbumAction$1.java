// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.os.AsyncTask;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            ShareAlbumAction

class val.shareTask
    implements Callback
{

    final ShareAlbumAction this$0;
    final AsyncTask val$shareTask;

    public void onError(Bundle bundle)
    {
        GLogger.e(ShareAlbumAction.access$000(), "Error occurred trying to fetch customer name for email subject", new Object[0]);
        val$shareTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void onSuccess(Bundle bundle)
    {
        bundle = bundle.getString("value_key");
        if (bundle != null && !bundle.equals(""))
        {
            ShareAlbumAction.access$102(ShareAlbumAction.this, bundle);
        }
        val$shareTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    ()
    {
        this$0 = final_sharealbumaction;
        val$shareTask = AsyncTask.this;
        super();
    }
}

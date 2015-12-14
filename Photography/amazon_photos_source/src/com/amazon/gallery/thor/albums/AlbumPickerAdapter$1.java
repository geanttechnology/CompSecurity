// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Dialog;
import android.os.AsyncTask;
import android.view.View;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.mixtape.utils.IdUtils;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumPickerAdapter, AddToAlbumTask

class val.position
    implements android.view.umPickerAdapter._cls1
{

    final AlbumPickerAdapter this$0;
    final int val$position;

    public void onClick(View view)
    {
        view = (Tag)getItem(val$position);
        view = IdUtils.objectIdToNodeId(view.getObjectId().getMostSignificantBits(), view.getObjectId().getLeastSignificantBits());
        if (view != null)
        {
            (new AddToAlbumTask(AlbumPickerAdapter.access$100(AlbumPickerAdapter.this), AlbumPickerAdapter.access$200(AlbumPickerAdapter.this), view, AlbumPickerAdapter.access$300(AlbumPickerAdapter.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        GlobalMessagingBus.post(new ActionCompleteEvent());
        AlbumPickerAdapter.access$400(AlbumPickerAdapter.this).dismiss();
    }

    MessagingBus()
    {
        this$0 = final_albumpickeradapter;
        val$position = I.this;
        super();
    }
}

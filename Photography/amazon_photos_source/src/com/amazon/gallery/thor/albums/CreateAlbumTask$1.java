// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.os.AsyncTask;
import com.amazon.clouddrive.model.CreateNodeResponse;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumTask, AddToAlbumTask

class this._cls0
    implements Runnable
{

    final CreateAlbumTask this$0;

    public void run()
    {
        (new AddToAlbumTask(getActivity(), CreateAlbumTask.access$000(CreateAlbumTask.this), CreateAlbumTask.access$100(CreateAlbumTask.this).getId(), profiler)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    ()
    {
        this$0 = CreateAlbumTask.this;
        super();
    }
}

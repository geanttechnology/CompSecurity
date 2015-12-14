// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            DeleteAlbumTask

class this._cls0
    implements android.view.er
{

    final DeleteAlbumTask this$0;

    public void onClick(View view)
    {
        view = new DeleteAlbumTask(getActivity(), DeleteAlbumTask.access$000(DeleteAlbumTask.this), profiler);
        view.setUndo();
        view.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    ()
    {
        this$0 = DeleteAlbumTask.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            DeleteFromAlbumTask

class this._cls0
    implements android.view.teFromAlbumTask._cls1
{

    final DeleteFromAlbumTask this$0;

    public void onClick(View view)
    {
        view = new DeleteFromAlbumTask(getActivity(), DeleteFromAlbumTask.access$000(DeleteFromAlbumTask.this), DeleteFromAlbumTask.access$100(DeleteFromAlbumTask.this), false, profiler);
        view.setUndo();
        view.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    ()
    {
        this$0 = DeleteFromAlbumTask.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.os.AsyncTask;
import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            AndroidGalleryBadgeableCoverView

private class <init>
    implements android.view.ew.RemoveDownloadClickListener
{

    private ObjectID tagId;
    final AndroidGalleryBadgeableCoverView this$0;

    private void update(ObjectID objectid)
    {
        tagId = objectid;
    }

    public void onClick(View view)
    {
        (new AsyncTask() {

            final AndroidGalleryBadgeableCoverView.RemoveDownloadClickListener this$1;
            final GalleryDownloadManager val$dm;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                dm.removeDownload(tagId);
                return null;
            }

            
            {
                this$1 = AndroidGalleryBadgeableCoverView.RemoveDownloadClickListener.this;
                dm = gallerydownloadmanager;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        AndroidGalleryBadgeableCoverView.access$302(AndroidGalleryBadgeableCoverView.this, true);
        AndroidGalleryBadgeableCoverView.access$400(AndroidGalleryBadgeableCoverView.this);
        toggleBadge(this._fld0, false);
        setQueued(false);
    }



    private _cls1.val.dm(ObjectID objectid)
    {
        this$0 = AndroidGalleryBadgeableCoverView.this;
        super();
        update(objectid);
    }

    update(ObjectID objectid, update update1)
    {
        this(objectid);
    }
}

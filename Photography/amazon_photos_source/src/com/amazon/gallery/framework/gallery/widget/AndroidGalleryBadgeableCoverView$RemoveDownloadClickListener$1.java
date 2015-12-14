// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.os.AsyncTask;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            AndroidGalleryBadgeableCoverView

class val.dm extends AsyncTask
{

    final this._cls1 this$1;
    final GalleryDownloadManager val$dm;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        val$dm.removeDownload(cess._mth200(this._cls1.this));
        return null;
    }

    ()
    {
        this$1 = final_;
        val$dm = GalleryDownloadManager.this;
        super();
    }
}

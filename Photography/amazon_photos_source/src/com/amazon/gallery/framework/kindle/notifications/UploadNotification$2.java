// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.os.AsyncTask;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            UploadNotification

class this._cls0 extends AsyncTask
{

    final UploadNotification this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((MediaItem[])aobj);
    }

    protected transient Void doInBackground(MediaItem amediaitem[])
    {
        UploadNotification.access$000(UploadNotification.this, amediaitem[0]);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        updateNotification();
    }

    ()
    {
        this$0 = UploadNotification.this;
        super();
    }
}

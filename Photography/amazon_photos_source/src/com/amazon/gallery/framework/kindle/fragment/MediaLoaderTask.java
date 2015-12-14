// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlay;
import java.lang.ref.WeakReference;

public class MediaLoaderTask extends AsyncTask
{

    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/MediaLoaderTask.getName();
    protected final WeakReference activityRef;
    private final Runnable postExecuteRunnable;

    public MediaLoaderTask(CommonActivity commonactivity, Runnable runnable)
    {
        activityRef = new WeakReference(commonactivity);
        postExecuteRunnable = runnable;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = (CommonActivity)activityRef.get();
        if (avoid != null)
        {
            ((MediaStoreSyncProvider)avoid.getApplicationBean(Keys.MEDIA_STORE_SYNC_PROVIDER)).syncMediaStore(false);
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        void1 = (CommonActivity)activityRef.get();
        if (void1 != null)
        {
            GLogger.d(TAG, "Hiding loading overlay", new Object[0]);
            void1.getNoContentOverlay().hide();
        }
        if (postExecuteRunnable != null)
        {
            postExecuteRunnable.run();
        }
    }

    protected void onPreExecute()
    {
        CommonActivity commonactivity = (CommonActivity)activityRef.get();
        if (commonactivity != null)
        {
            GLogger.d(TAG, "Showing loading overlay", new Object[0]);
            commonactivity.getNoContentOverlay().show();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationUploadView

private static class isUpdatingInProgress extends AsyncTask
{

    private final WeakReference contextReference;
    private final AtomicBoolean isUpdatingInProgress;
    private final MediaItemDao mediaItemDao;
    private final TagDao tagDao;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        int i;
        int j;
        long l = SystemClock.uptimeMillis();
        i = mediaItemDao.getAutosaveableMediaItemCount(false);
        j = mediaItemDao.getAutosaveableMediaItemCount(true);
        GLogger.d(AndroidNavigationUploadView.access$300(), "Async counter update completed in %dms", new Object[] {
            Long.valueOf(SystemClock.uptimeMillis() - l)
        });
        avoid = (Context)contextReference.get();
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        PreferenceManager.getDefaultSharedPreferences(avoid).edit().s("auto_save_count", i).s("unuploaded_auto_save_count", j).s("last_counter_update", SystemClock.uptimeMillis()).s();
        isUpdatingInProgress.set(false);
        return null;
        avoid;
        isUpdatingInProgress.set(false);
        throw avoid;
    }

    (Context context, MediaItemDao mediaitemdao, TagDao tagdao, AtomicBoolean atomicboolean)
    {
        contextReference = new WeakReference(context);
        mediaItemDao = mediaitemdao;
        tagDao = tagdao;
        isUpdatingInProgress = atomicboolean;
    }
}

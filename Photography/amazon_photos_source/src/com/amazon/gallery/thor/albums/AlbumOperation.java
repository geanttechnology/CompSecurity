// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            ListChildrenTask, AlbumsMetricsHelper

public abstract class AlbumOperation extends AsyncTask
{

    private static final String TAG = com/amazon/gallery/thor/albums/AlbumOperation.getName();
    private final WeakReference activityRef;
    protected CloudDriveServiceClientManager cdsClientManager;
    private final NetworkConnectivity networkConnectivity;
    protected long operationDurationMs;
    protected final ComponentProfiler profiler;
    private AppCompatProgressDialog progressDialog;
    protected boolean shouldCloseCAB;
    protected boolean showProgressDialog;
    protected boolean undo;

    protected AlbumOperation(Activity activity, ComponentProfiler componentprofiler)
    {
        shouldCloseCAB = false;
        undo = false;
        showProgressDialog = true;
        activityRef = new WeakReference(activity);
        cdsClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        networkConnectivity = (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY);
        profiler = componentprofiler;
    }

    protected final transient Boolean doInBackground(Void avoid[])
    {
        long l = SystemClock.uptimeMillis();
        boolean flag = doInBackground();
        if (flag)
        {
            onTaskComplete();
        }
        operationDurationMs = SystemClock.uptimeMillis() - l;
        return Boolean.valueOf(flag);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected abstract boolean doInBackground();

    protected android.view.View.OnClickListener getAction()
    {
        return null;
    }

    protected Activity getActivity()
    {
        return (Activity)activityRef.get();
    }

    protected abstract int getProgressMessage();

    protected void navigateToAlbum(String s)
    {
        Activity activity;
label0:
        {
            activity = getActivity();
            if (activity != null)
            {
                s = CDSUtil.getObjectId(s);
                s = ((TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO)).getTagById(s);
                if (!(activity instanceof NativeGalleryActivity))
                {
                    break label0;
                }
                NativeGalleryActivity nativegalleryactivity = (NativeGalleryActivity)activity;
                if (nativegalleryactivity.getMediaContentConfiguration().toViewDescriptor().getTag() == null || nativegalleryactivity.getMediaContentConfiguration().toViewDescriptor().getTag().getId() != s.getId())
                {
                    break label0;
                }
            }
            return;
        }
        ListChildrenTask.executeWithOffset(s, 0);
        Intent intent = new Intent(getActivity(), com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
        intent.setAction("com.amazon.photos.INTERNAL");
        intent.putExtra("mediaDynamicAlbum", true);
        intent.putExtra("mediaTag", s);
        intent.putExtra("com.amazon.photos.FROM_CLA", true);
        intent.putExtra("cameFromViewAlbumAction", true);
        activity.startActivity(intent);
        activity.overridePendingTransition(0x7f040019, 0x7f04001a);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void onPreExecute()
    {
        Activity activity = getActivity();
        if (activity != null && showProgressDialog && networkConnectivity.isNetworkConnected())
        {
            (new ShowDialogSyncTask(activity) {

                final AlbumOperation this$0;

                protected Dialog createDialog()
                {
                    progressDialog = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(getActivity())).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.SPINNER).setMessage(mActivity.getString(getProgressMessage())).setCancellable(false).build();
                    return progressDialog;
                }

            
            {
                this$0 = AlbumOperation.this;
                super(activity);
            }
            }).queue();
        }
    }

    protected void onTaskComplete()
    {
        GlobalMessagingBus.post(new ToggleContentObserverEvent(false));
        performLocalOperation();
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        if (shouldCloseCAB)
        {
            GlobalMessagingBus.post(new ActionCompleteEvent());
        }
    }

    protected List partitionIds(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i += 25)
        {
            arraylist.add(new ArrayList(list.subList(i, Math.min(list.size(), i + 25))));
        }

        return arraylist;
    }

    protected abstract void performLocalOperation();

    protected boolean promptIfOffline()
    {
        if (networkConnectivity.isNetworkConnected())
        {
            return false;
        }
        final Activity activity = getActivity();
        if (activity != null)
        {
            activity.runOnUiThread(new Runnable() {

                final AlbumOperation this$0;
                final Activity val$activity;

                public void run()
                {
                    networkConnectivity.promptIfOffline(activity);
                }

            
            {
                this$0 = AlbumOperation.this;
                activity = activity1;
                super();
            }
            });
        }
        return true;
    }

    protected void recordMetrics(boolean flag, int i)
    {
        if (profiler == null)
        {
            GLogger.v(TAG, "Failed to record metrics for operation [%s]", new Object[] {
                getClass().getName()
            });
            return;
        } else
        {
            recordOperationMetric(flag, i);
            return;
        }
    }

    protected void recordOperationDuration(AlbumsMetricsHelper.MetricsEvent metricsevent)
    {
        if (operationDurationMs > 0L)
        {
            profiler.trackTimer(metricsevent, operationDurationMs, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, AlbumsMetricsHelper.getPageName(getActivity())));
        }
    }

    protected abstract void recordOperationMetric(boolean flag, int i);

    protected void setUndo()
    {
        undo = true;
    }

    protected void showSnackbar(String s)
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            Snackbar.make(activity.findViewById(0x7f0c0122), s, 0).show();
        }
    }

    protected void showSnackbarWithAction(String s, android.view.View.OnClickListener onclicklistener, String s1)
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            s = Snackbar.make(activity.findViewById(0x7f0c0122), s, 0);
            if (onclicklistener != null)
            {
                s.setAction(s1, onclicklistener);
            }
            s.show();
        }
    }




/*
    static AppCompatProgressDialog access$002(AlbumOperation albumoperation, AppCompatProgressDialog appcompatprogressdialog)
    {
        albumoperation.progressDialog = appcompatprogressdialog;
        return appcompatprogressdialog;
    }

*/

}

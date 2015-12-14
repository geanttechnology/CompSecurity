// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.extended.model.CreateNodeExtendedResponse;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.albums.AlbumsMetricsHelper;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            ShareAlbumAction

private class tag extends AsyncTask
{

    private final AppCompatProgressDialog dialog;
    private final String nodeId;
    private long startTimeMs;
    private final Tag tag;
    final ShareAlbumAction this$0;

    private void recordMetric()
    {
        if (profiler == null)
        {
            return;
        } else
        {
            long l = SystemClock.uptimeMillis();
            long l1 = startTimeMs;
            profiler.trackEvent(com.amazon.gallery.thor.albums.SpinnerDialog.startTimeMs, AlbumsMetricsHelper.createMetricsExtra(com.amazon.gallery.thor.albums.SpinnerDialog.startTimeMs.startTimeMs(), null, AlbumsMetricsHelper.getPageName(ShareAlbumAction.access$800(ShareAlbumAction.this))));
            profiler.trackTimer(com.amazon.gallery.thor.albums.ime, l - l1, AlbumsMetricsHelper.createMetricsExtra(com.amazon.gallery.thor.albums.ime.ime(), null, AlbumsMetricsHelper.getPageName(ShareAlbumAction.access$900(ShareAlbumAction.this))));
            return;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        startTimeMs = SystemClock.uptimeMillis();
        String s = "";
        avoid = s;
        Object obj = s;
        com.amazon.mixtape.service.MixtapeCloudDriveServiceClient mixtapeclouddriveserviceclient;
        CreateNodeExtendedResponse createnodeextendedresponse;
        try
        {
            mixtapeclouddriveserviceclient = cloudDriveServiceClientManager.getForegroundCdsClient();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            GLogger.ex(ShareAlbumAction.access$000(), "Unable to create shared node", ((Throwable) (obj)));
            return avoid;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.d(ShareAlbumAction.access$000(), "Unable to create a shared node - interrupted", new Object[0]);
            return ((String) (obj));
        }
        avoid = s;
        obj = s;
        createnodeextendedresponse = mixtapeclouddriveserviceclient.createNodeExtended(new CreateNodeRequest(tag.getLabel(), "SHARED_COLLECTION"));
        avoid = s;
        obj = s;
        s = createnodeextendedresponse.getShareURL();
        avoid = s;
        obj = s;
        mixtapeclouddriveserviceclient.addChildToParent(new AddChildToParentRequest(createnodeextendedresponse.getId(), nodeId));
        return s;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        GlobalMessagingBus.post(new ActionCompleteEvent());
        if (dialog.isShowing())
        {
            dialog.dismiss();
        }
        if (s.isEmpty())
        {
            Toast.makeText(ShareAlbumAction.access$400(ShareAlbumAction.this), ShareAlbumAction.access$500(ShareAlbumAction.this).getString(0x7f0e01e5), 0).show();
            return;
        } else
        {
            recordMetric();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", s);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", String.format(ShareAlbumAction.access$600(ShareAlbumAction.this).getString(0x7f0e01e6), new Object[] {
                ShareAlbumAction.access$100(ShareAlbumAction.this)
            }));
            ShareAlbumAction.access$700(ShareAlbumAction.this).startActivity(intent);
            return;
        }
    }

    protected void onPreExecute()
    {
        (new ShowDialogSyncTask(ShareAlbumAction.access$200(ShareAlbumAction.this)) {

            final ShareAlbumAction.ShareAlbumBlockingSpinnerDialog this$1;

            protected Dialog createDialog()
            {
                return dialog;
            }

            
            {
                this$1 = ShareAlbumAction.ShareAlbumBlockingSpinnerDialog.this;
                super(activity);
            }
        }).queue();
    }


    public _cls1.this._cls1(Context context, Tag tag1, String s)
    {
        this$0 = ShareAlbumAction.this;
        super();
        dialog = (new com.amazon.gallery.thor.widget.SpinnerDialog.dialog(context)).dialog(com.amazon.gallery.thor.widget.SpinnerDialog.dialog).dialog(context.getString(0x7f0e01e8)).dialog(false).dialog();
        nodeId = s;
        tag = tag1;
    }
}

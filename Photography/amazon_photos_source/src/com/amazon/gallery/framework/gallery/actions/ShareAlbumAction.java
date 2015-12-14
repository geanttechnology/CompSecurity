// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.extended.model.CreateNodeExtendedResponse;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.albums.AlbumMediaItemAction;
import com.amazon.gallery.thor.albums.AlbumsMetricsHelper;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            SelectionAction

public class ShareAlbumAction extends AlbumMediaItemAction
    implements SelectionAction
{
    private class ShareAlbumBlockingSpinnerDialog extends AsyncTask
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
                profiler.trackEvent(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.SharePhotoAlbum, AlbumsMetricsHelper.createMetricsExtra(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.SharePhotoAlbum.name(), null, AlbumsMetricsHelper.getPageName(
// JavaClassFileOutputException: get_constant: invalid tag

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
                GLogger.ex(ShareAlbumAction.TAG, "Unable to create shared node", ((Throwable) (obj)));
                return avoid;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                GLogger.d(ShareAlbumAction.TAG, "Unable to create a shared node - interrupted", new Object[0]);
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
                Toast.makeText(
// JavaClassFileOutputException: get_constant: invalid tag

        protected void onPreExecute()
        {
            (new ShowDialogSyncTask(
// JavaClassFileOutputException: get_constant: invalid tag


        public ShareAlbumBlockingSpinnerDialog(Context context, Tag tag1, String s)
        {
            this$0 = ShareAlbumAction.this;
            super();
            dialog = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(context)).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.SPINNER).setMessage(context.getString(0x7f0e01e8)).setCancellable(false).build();
            nodeId = s;
            tag = tag1;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/actions/ShareAlbumAction.getName();
    private String customerName;
    private final MAPAccountManager mapAccountManager;
    private final NetworkConnectivity networkConnectivity;

    public ShareAlbumAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        AlbumMediaItemAction(activity, networkconnectivity, photosdemomanager, 0x7f0e0097);
        customerName = "";
        networkConnectivity = networkconnectivity;
        mapAccountManager = new MAPAccountManager(activity);
        customerName = activity.getString(0x7f0e01e7);
    }

    private void retrieveCustomerNameAndInitiateShare(final AsyncTask shareTask)
    {
        String s = mapAccountManager.getAccount();
        if (s != null)
        {
            CustomerAttributeStore.getInstance(context).getAttribute(s, "com.amazon.dcp.sso.property.username", new Callback() {

                final ShareAlbumAction this$0;
                final AsyncTask val$shareTask;

                public void onError(Bundle bundle)
                {
                    GLogger.e(ShareAlbumAction.TAG, "Error occurred trying to fetch customer name for email subject", new Object[0]);
                    shareTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }

                public void onSuccess(Bundle bundle)
                {
                    bundle = bundle.getString("value_key");
                    if (bundle != null && !bundle.equals(""))
                    {
                        customerName = bundle;
                    }
                    shareTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }

            
            {
                this$0 = ShareAlbumAction.this;
                shareTask = asynctask;
                super();
            }
            });
        }
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = getTagFromViewDescriptor(viewdescriptor);
        return mediaitem == null && viewdescriptor != null && FeatureManager.isFeatureEnabled(Features.SHARE_ALBUM) && viewdescriptor.getType() != TagType.LOCAL_FOLDER;
    }

    public boolean canExecute(List list)
    {
        return false;
    }

    public boolean canExecuteTags(List list)
    {
        boolean flag = true;
        if (list == null || list.size() != 1)
        {
            flag = false;
        } else
        {
            list = (Tag)list.get(0);
            if (!isValid(list) || list.hasProperty(TagProperty.CAMERA) || list.hasProperty(TagProperty.FREETIME))
            {
                return false;
            }
        }
        return flag;
    }

    public void execute(List list)
    {
    }

    public void executeTags(List list)
    {
        if (networkConnectivity.promptIfOffline(context))
        {
            return;
        } else
        {
            list = (Tag)list.get(0);
            Object obj = list.getObjectId();
            obj = IdUtils.objectIdToNodeId(((ObjectID) (obj)).getMostSignificantBits(), ((ObjectID) (obj)).getLeastSignificantBits());
            retrieveCustomerNameAndInitiateShare(new ShareAlbumBlockingSpinnerDialog(context, list, ((String) (obj))));
            return;
        }
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        executeTags(Collections.singletonList(getTagFromViewDescriptor(viewdescriptor)));
    }

    protected boolean isValid(Tag tag)
    {
        return FeatureManager.isFeatureEnabled(Features.SHARE_ALBUM) && tag.hasProperty(TagProperty.CLOUD);
    }

    public void recordOnActionMetrics(List list)
    {
    }





/*
    static String access$102(ShareAlbumAction sharealbumaction, String s)
    {
        sharealbumaction.customerName = s;
        return s;
    }

*/








    // Unreferenced inner class com/amazon/gallery/framework/gallery/actions/ShareAlbumAction$ShareAlbumBlockingSpinnerDialog$1

/* anonymous class */
    class ShareAlbumBlockingSpinnerDialog._cls1 extends ShowDialogSyncTask
    {

        final ShareAlbumBlockingSpinnerDialog this$1;

        protected Dialog createDialog()
        {
            return dialog;
        }

            
            {
                this$1 = ShareAlbumBlockingSpinnerDialog.this;
                super(activity);
            }
    }

}

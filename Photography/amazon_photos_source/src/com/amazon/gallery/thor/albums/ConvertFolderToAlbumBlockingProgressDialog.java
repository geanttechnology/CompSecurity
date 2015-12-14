// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.CreateNodeExtendedResponse;
import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.QueryAndBlock;
import com.amazon.clouddrive.model.QueryFilter;
import com.amazon.clouddrive.model.QueryObject;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.IntentPage;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.collectionfilter.CollectionFilterType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            ListChildrenTask, AlbumsMetricsHelper, RefreshCoverPhotoTask, AlbumsHelper

public class ConvertFolderToAlbumBlockingProgressDialog extends AsyncTask
{
    public static class FolderConversion
    {

        private Tag albumTag;
        private String folderNodeId;

        public Tag getAlbumTag()
        {
            return albumTag;
        }


        public FolderConversion(String s, Tag tag)
        {
            folderNodeId = s;
            albumTag = tag;
        }
    }


    public static final String TAG = com/amazon/gallery/thor/albums/ConvertFolderToAlbumBlockingProgressDialog.getName();
    private final MixtapeCloudDriveServiceClient cloudDriveServiceClient;
    private final ComponentProfiler componentProfiler;
    private final Context context;
    private final AppCompatProgressDialog dialog;
    private long startTimeMs;
    private List successfulTags;
    private final List tagList;

    public ConvertFolderToAlbumBlockingProgressDialog(Context context1, List list, ComponentProfiler componentprofiler, MixtapeCloudDriveServiceClient mixtapeclouddriveserviceclient)
    {
        com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder builder = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(context1)).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.HORIZONTAL);
        int i;
        if (list.size() == 1)
        {
            i = 0x7f0e01a9;
        } else
        {
            i = 0x7f0e01aa;
        }
        dialog = builder.setMessage(context1.getString(i)).setCancellable(false).setIndeterminate(false).setMax(list.size()).build();
        tagList = list;
        context = context1;
        componentProfiler = componentprofiler;
        cloudDriveServiceClient = mixtapeclouddriveserviceclient;
        successfulTags = new ArrayList();
    }

    private Tag createLocalAlbum(CreateNodeExtendedResponse createnodeextendedresponse, Tag tag)
    {
        ObjectID objectid = CDSUtil.getObjectId(createnodeextendedresponse.getId());
        TagDao tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        Tag tag1 = tagdao.create(TagType.ALBUM);
        tag1.setLabel(tag.getLabel());
        tag1.setProperty(TagProperty.CLOUD);
        tag1.setSortDateMs(CDSUtil.getUnixTimestamp(createnodeextendedresponse.getCreatedDate()));
        tag1.setHasSortDate(true);
        tag1.setValid(true);
        tag1.setObjectId(objectid);
        tag1.setCoverId(tag.getCustomCoverId());
        tag1.setCustomCoverId(tag.getCustomCoverId());
        tagdao.save(tag1, true);
        return tag1;
    }

    private void navigateToAlbum(Tag tag)
    {
        ListChildrenTask.executeWithOffset(tag, 0);
        context.startActivity(IntentUtil.getAlbumContentsIntent(context, tag));
        ((Activity)context).overridePendingTransition(0x7f040019, 0x7f04001a);
    }

    private void navigateToAlbumsView()
    {
        NavigationPaneController.ALBUMS.onClick((Activity)context);
    }

    private void recordMetrics()
    {
        if (componentProfiler == null)
        {
            GLogger.d(TAG, "Failed to record metrics for conversation of folder to album operation", new Object[0]);
            return;
        } else
        {
            componentProfiler.trackEvent(AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbum, AlbumsMetricsHelper.createMetricsExtra(AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbum.name(), "Folder", "FolderMigrationView"));
            long l = SystemClock.uptimeMillis();
            long l1 = startTimeMs;
            componentProfiler.trackTimer(AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbumTime, l - l1, AlbumsMetricsHelper.createMetricsExtra(AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbumTime.name(), "Folder", "FolderMigrationView"));
            return;
        }
    }

    private void showSnackbar(String s, String s1, android.view.View.OnClickListener onclicklistener)
    {
        s = Snackbar.make(((Activity)context).findViewById(0x7f0c0122), s, 0);
        if (onclicklistener != null)
        {
            s.setAction(s1, onclicklistener);
        }
        s.show();
    }

    protected transient Boolean doInBackground(Void avoid[])
    {
        Iterator iterator;
        startTimeMs = SystemClock.uptimeMillis();
        iterator = tagList.iterator();
_L2:
        Tag tag;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        tag = (Tag)iterator.next();
        String s = tag.getLabel();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        avoid = s;
        if (!s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        avoid = context.getString(0x7f0e009a);
        Object obj;
        avoid = new CreateNodeRequest(avoid, "VISUAL_COLLECTION");
        CollectionProperties collectionproperties = new CollectionProperties();
        QueryObject queryobject = new QueryObject();
        QueryAndBlock queryandblock = new QueryAndBlock();
        QueryFilter queryfilter = new QueryFilter(CollectionFilterType.FOLDER.getTypeId());
        obj = tag.getObjectId();
        obj = IdUtils.objectIdToNodeId(((ObjectID) (obj)).getMostSignificantBits(), ((ObjectID) (obj)).getLeastSignificantBits());
        queryfilter.setValues(Collections.singletonList(obj));
        queryandblock.setFilters(Collections.singletonList(queryfilter));
        queryobject.setInclude(Collections.singletonList(queryandblock));
        collectionproperties.setQuery(queryobject);
        avoid.setCollectionProperties(collectionproperties);
        avoid = createLocalAlbum((CreateNodeExtendedResponse)cloudDriveServiceClient.createNodePersistAsync(avoid, null).get(), tag);
        recordMetrics();
        publishProgress(new Integer[] {
            Integer.valueOf(successfulTags.size())
        });
        successfulTags.add(new FolderConversion(((String) (obj)), avoid));
        if (true) goto _L2; else goto _L1
        avoid;
_L4:
        GLogger.ex(TAG, "Unable to create visual collection node", avoid);
        return Boolean.valueOf(false);
        avoid;
        GLogger.d(TAG, "Unable to create a visual collection node - interrupted", new Object[0]);
        return Boolean.valueOf(false);
_L1:
        return Boolean.valueOf(true);
        avoid;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        GlobalMessagingBus.post(new ActionCompleteEvent());
        if (dialog.isShowing())
        {
            dialog.dismiss();
        }
        if (!boolean1.booleanValue())
        {
            showSnackbar(context.getString(0x7f0e01a5), null, null);
            return;
        }
        if (successfulTags.size() == 1)
        {
            boolean1 = ((FolderConversion)successfulTags.get(0)).getAlbumTag();
            (new RefreshCoverPhotoTask(context, IdUtils.objectIdToNodeId(boolean1.getObjectId().getMostSignificantBits(), boolean1.getObjectId().getLeastSignificantBits()), AlbumsHelper.getAlbumCoverPhotoBoundingSize(context))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            showSnackbar(context.getString(0x7f0e01a7), context.getString(0x7f0e01ff), new android.view.View.OnClickListener() {

                final ConvertFolderToAlbumBlockingProgressDialog this$0;

                public void onClick(View view)
                {
                    navigateToAlbum(((FolderConversion)successfulTags.get(0)).albumTag);
                }

            
            {
                this$0 = ConvertFolderToAlbumBlockingProgressDialog.this;
                super();
            }
            });
            return;
        } else
        {
            showSnackbar(context.getString(0x7f0e01a6, new Object[] {
                Integer.valueOf(successfulTags.size())
            }), context.getString(0x7f0e0200), new android.view.View.OnClickListener() {

                final ConvertFolderToAlbumBlockingProgressDialog this$0;

                public void onClick(View view)
                {
                    navigateToAlbumsView();
                }

            
            {
                this$0 = ConvertFolderToAlbumBlockingProgressDialog.this;
                super();
            }
            });
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void onPreExecute()
    {
        (new ShowDialogSyncTask((Activity)context) {

            final ConvertFolderToAlbumBlockingProgressDialog this$0;

            protected Dialog createDialog()
            {
                return dialog;
            }

            
            {
                this$0 = ConvertFolderToAlbumBlockingProgressDialog.this;
                super(activity);
            }
        }).queue();
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
        if (!dialog.isIndeterminate())
        {
            dialog.updateProgress(ainteger[0].intValue());
        }
    }

    public volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }





}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.Context;
import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.GetNodeExtendedResponse;
import com.amazon.clouddrive.handlers.AsyncHandler;
import com.amazon.clouddrive.model.CloudDriveRequest;
import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.CoverObject;
import com.amazon.clouddrive.model.GetNodeRequest;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.FutureTarget;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RefreshCoverPhotoTask extends AsyncTask
{

    private static final String TAG = com/amazon/gallery/thor/albums/RefreshCoverPhotoTask.getName();
    private final Context appContext;
    private final int coverPhotoSize;
    private String nodeId;

    public RefreshCoverPhotoTask(Context context, String s)
    {
        this(context, s, -1);
    }

    public RefreshCoverPhotoTask(Context context, String s, int i)
    {
        nodeId = s;
        coverPhotoSize = i;
        appContext = context.getApplicationContext();
    }

    private void downloadCoverPhoto(ObjectID objectid)
    {
        objectid = ((MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO)).getItemById(objectid);
        if (objectid == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        Glide.with(appContext).load(objectid).asBitmap().fitCenter().into(coverPhotoSize, coverPhotoSize).get();
        return;
        objectid;
_L2:
        GLogger.ex(TAG, "Exception while loading bitmap from uri using Glide", objectid);
        return;
        objectid;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new GetNodeRequest(nodeId);
        MixtapeCloudDriveServiceClient mixtapeclouddriveserviceclient = ((CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER)).getForegroundCdsClient();
        try
        {
            mixtapeclouddriveserviceclient.getNodePersistAsync(avoid, new AsyncHandler() {

                final RefreshCoverPhotoTask this$0;

                public volatile void onCanceled(CloudDriveRequest clouddriverequest)
                {
                    onCanceled((GetNodeRequest)clouddriverequest);
                }

                public void onCanceled(GetNodeRequest getnoderequest)
                {
                }

                public volatile void onError(CloudDriveRequest clouddriverequest, Exception exception)
                {
                    onError((GetNodeRequest)clouddriverequest, exception);
                }

                public void onError(GetNodeRequest getnoderequest, Exception exception)
                {
                }

                public volatile void onSuccess(CloudDriveRequest clouddriverequest, Object obj)
                {
                    onSuccess((GetNodeRequest)clouddriverequest, (GetNodeExtendedResponse)obj);
                }

                public void onSuccess(GetNodeRequest getnoderequest, GetNodeExtendedResponse getnodeextendedresponse)
                {
                    getnoderequest = getnodeextendedresponse.getCollectionProperties().getCovers();
                    if (getnoderequest != null && !getnoderequest.isEmpty())
                    {
                        Object obj = (CoverObject)getnoderequest.get(0);
                        getnoderequest = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
                        getnodeextendedresponse = getnoderequest.getTagById(CDSUtil.getObjectId(nodeId));
                        obj = CDSUtil.getObjectId(((CoverObject) (obj)).getId());
                        if (getnodeextendedresponse.getCoverId() == null || !getnodeextendedresponse.getCoverId().equals(obj))
                        {
                            if (coverPhotoSize > 0)
                            {
                                downloadCoverPhoto(((ObjectID) (obj)));
                            }
                            getnodeextendedresponse.setCoverId(((ObjectID) (obj)));
                            getnodeextendedresponse.setCustomCoverId(((ObjectID) (obj)));
                            getnoderequest.save(getnodeextendedresponse, true);
                        }
                    }
                }

            
            {
                this$0 = RefreshCoverPhotoTask.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.ex(TAG, "Error occurred performing getNode operation to refresh cover photo", avoid);
        }
        return null;
    }




}

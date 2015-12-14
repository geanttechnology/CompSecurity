// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import android.content.Context;
import android.os.AsyncTask;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.AcceptableTerminalException;
import com.amazon.gallery.framework.network.exceptions.AccountLockedException;
import com.amazon.gallery.framework.network.exceptions.CloudStorageLimitException;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.RetryLimitExceededException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.upload.MultipartUploader;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadResult, UploadProgressCallback

public class GalleryUploader
{

    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/GalleryUploader.getName();
    private final CloudDriveServiceClientManager cdsClientManager;
    private final Context context;
    private final MediaItemDao mediaItemDao;
    private final RestClient restClient;

    public GalleryUploader(Context context1, RestClient restclient, CloudDriveServiceClientManager clouddriveserviceclientmanager, MediaItemDao mediaitemdao)
    {
        context = context1;
        restClient = restclient;
        cdsClientManager = clouddriveserviceclientmanager;
        mediaItemDao = mediaitemdao;
    }

    private UploadResult uploadFailed(MediaItem mediaitem, Exception exception)
    {
        if (exception instanceof AcceptableTerminalException)
        {
            GLogger.i(TAG, "Exception while uploading media item: %s", new Object[] {
                exception
            });
        } else
        if (exception instanceof TransientException)
        {
            GLogger.w(TAG, "TransientException while uploading media item: %s", new Object[] {
                exception.getMessage()
            });
        } else
        {
            GLogger.ex(TAG, "Exception while uploading media item", exception);
        }
        return new UploadResult(UploadResult.Status.FAILED, exception);
    }

    public UploadResult uploadMediaItem(final MediaItem mediaItem, UploadProgressCallback uploadprogresscallback)
        throws CloudStorageLimitException, AccountLockedException
    {
        GLogger.d(TAG, "Starting the upload of %s", new Object[] {
            mediaItem.getName()
        });
        if (MediaItemUtil.isCloudMediaItem(mediaItem))
        {
            GLogger.d(TAG, "%s is already uploaded, skipping", new Object[] {
                mediaItem.getName()
            });
            return new UploadResult(UploadResult.Status.SUCCESSFUL, null);
        }
        if (!MediaItemUtil.localFileExists(mediaItem))
        {
            return uploadFailed(mediaItem, new TerminalException(String.format("%s does not exist", new Object[] {
                mediaItem.getObjectId()
            })));
        }
        String s;
        s = context.getString(0x7f0e007f);
        if (!MultipartUploader.shouldUseMultipart(mediaItem))
        {
            break MISSING_BLOCK_LABEL_197;
        }
        uploadprogresscallback = restClient.getMultipartUploadOperation(mediaItem, s, uploadprogresscallback);
_L1:
        GLogger.d(TAG, "%s uploading starting", new Object[] {
            mediaItem.getName()
        });
        uploadprogresscallback = (ObjectID)NetworkExecutor.getInstance().execute(uploadprogresscallback);
        if (uploadprogresscallback != null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        GLogger.d(TAG, "%s failed to upload", new Object[] {
            mediaItem.getName()
        });
        return uploadFailed(mediaItem, new TransientException());
        uploadprogresscallback = restClient.getUploadOperation(mediaItem, s);
          goto _L1
        uploadprogresscallback = new UploadResult(UploadResult.Status.SUCCESSFUL, null);
        return uploadprogresscallback;
        try
        {
            GLogger.d(TAG, "%s uploaded successfully!", new Object[] {
                mediaItem.getName()
            });
            mediaItemDao.mergeToCloud(mediaItem, uploadprogresscallback, true);
            if (mediaItem.getGroupType() == GroupType.EDIT)
            {
                (new AsyncTask() {

                    final GalleryUploader this$0;
                    final MediaItem val$mediaItem;

                    protected volatile Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        (new File(mediaItem.getLocalPath())).delete();
                        mediaItemDao.deleteLocalFields(mediaItem, true, false);
                        return null;
                    }

            
            {
                this$0 = GalleryUploader.this;
                mediaItem = mediaitem;
                super();
            }
                }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            }
            Iterator iterator = mediaItem.getTags().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (Tag)iterator.next();
                if (TagType.ALBUM == ((Tag) (obj)).getType())
                {
                    obj = ((Tag) (obj)).getObjectId();
                    obj = new AddChildToParentRequest(IdUtils.objectIdToNodeId(((ObjectID) (obj)).getMostSignificantBits(), ((ObjectID) (obj)).getLeastSignificantBits()), IdUtils.objectIdToNodeId(uploadprogresscallback.getMostSignificantBits(), uploadprogresscallback.getLeastSignificantBits()));
                    cdsClientManager.getBackgroundCdsClient().addChildToParentAsync(((AddChildToParentRequest) (obj)), null);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_387;
        }
        // Misplaced declaration of an exception variable
        catch (UploadProgressCallback uploadprogresscallback)
        {
            return uploadFailed(mediaItem, uploadprogresscallback);
        }
        // Misplaced declaration of an exception variable
        catch (UploadProgressCallback uploadprogresscallback) { }
        // Misplaced declaration of an exception variable
        catch (UploadProgressCallback uploadprogresscallback) { }
        // Misplaced declaration of an exception variable
        catch (UploadProgressCallback uploadprogresscallback)
        {
            return uploadFailed(mediaItem, uploadprogresscallback);
        }
        // Misplaced declaration of an exception variable
        catch (UploadProgressCallback uploadprogresscallback)
        {
            return uploadFailed(mediaItem, uploadprogresscallback);
        }
        uploadFailed(mediaItem, uploadprogresscallback);
        throw uploadprogresscallback;
    }


}

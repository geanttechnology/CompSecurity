// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.adrive.operations;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.remotestorage.RemoteStorageDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MultipartUpload;
import com.amazon.gallery.framework.model.media.UploadChunk;
import com.amazon.gallery.framework.model.media.UploadPart;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.CanceledException;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.http.senna.operations.upload.UploadLocationResponse;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadPathResolver;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadPathResolverWrapper;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadProgressCallback;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.upload.MultipartUploader;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.http.adrive.operations:
//            UploadOperation

public class MultipartUploadOperation
    implements com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation
{
    private class MultipartAndChunks
    {

        List chunks;
        MultipartUpload multipartUpload;
        final MultipartUploadOperation this$0;

        private MultipartAndChunks()
        {
            this$0 = MultipartUploadOperation.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/network/http/adrive/operations/MultipartUploadOperation.getName();
    private final String defaultCameraFolder;
    private final DeviceAttributeStore deviceAttributeStore;
    private final HttpFactory httpFactory;
    private final MediaItem mediaItem;
    private final MultipartUploader multipartUploader;
    private final ComponentProfiler profiler;
    private final RemoteStorageDao remoteStorageDao;
    private final RestClient restClient;
    private final HttpClient s3Client;
    private final UploadPathResolver uploadPathResolver;
    private final UploadProgressCallback uploadProgressCallback;

    public MultipartUploadOperation(RestClient restclient, HttpFactory httpfactory, MediaItem mediaitem, HttpClient httpclient, String s, DeviceAttributeStore deviceattributestore, Profiler profiler1, 
            UploadProgressCallback uploadprogresscallback, RemoteStorageDao remotestoragedao)
        throws InvalidParameterException
    {
        restClient = restclient;
        mediaItem = mediaitem;
        s3Client = httpclient;
        httpFactory = httpfactory;
        defaultCameraFolder = s;
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/network/http/adrive/operations/UploadOperation);
        uploadProgressCallback = uploadprogresscallback;
        deviceAttributeStore = deviceattributestore;
        remoteStorageDao = remotestoragedao;
        uploadPathResolver = new UploadPathResolverWrapper(restclient, deviceattributestore);
        multipartUploader = new MultipartUploader(remotestoragedao, s3Client);
    }

    private void clearProgress(String s)
    {
        remoteStorageDao.removeMultipartUpload(s);
    }

    private MultipartAndChunks getMultipartUploadChunks(MediaItem mediaitem, ObjectID objectid, File file)
        throws JSONException, TerminalException, TransientException
    {
        Object obj = remoteStorageDao.getMultipartUpload(mediaitem.getLocalPath());
        if (obj != null)
        {
            List list = remoteStorageDao.getMultipartUploadParts(mediaitem.getLocalPath());
            if (!urlsAreExpired(list))
            {
                mediaitem = new MultipartAndChunks();
                mediaitem.chunks = list;
                mediaitem.multipartUpload = ((MultipartUpload) (obj));
                return mediaitem;
            }
            GLogger.w(TAG, "Multi-part upload URLs expired. Starting from the beginning.", new Object[0]);
            remoteStorageDao.removeMultipartUpload(file.getAbsolutePath());
        }
        int i = (int)(file.length() / 0x500000L);
        mediaitem = (UploadLocationResponse)restClient.getGetUploadLocationWithPartsOperation(objectid, mediaitem, i + 1).get();
        if (mediaitem.getParts() == null)
        {
            throw new TerminalException("Could not parse multipart parts");
        }
        obj = mediaitem.getStorageKey();
        String s = mediaitem.getUploadId();
        objectid = new MultipartUpload(file.getAbsolutePath(), objectid, ((String) (obj)), s, file.lastModified());
        obj = new ArrayList();
        UploadPart uploadpart;
        long l;
        for (mediaitem = mediaitem.getParts().iterator(); mediaitem.hasNext(); ((List) (obj)).add(new UploadChunk(file.getAbsolutePath(), uploadpart, 0x500000L * l)))
        {
            uploadpart = (UploadPart)mediaitem.next();
            l = uploadpart.getPartNumber() - 1;
        }

        remoteStorageDao.putMultipartUpload(objectid);
        remoteStorageDao.putMultipartUploadParts(((List) (obj)));
        mediaitem = new MultipartAndChunks();
        mediaitem.multipartUpload = objectid;
        mediaitem.chunks = ((List) (obj));
        return mediaitem;
    }

    private ArrayList getRemainingChunks(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            UploadChunk uploadchunk = (UploadChunk)list.next();
            if (uploadchunk.getETag() == null)
            {
                arraylist.add(uploadchunk);
            }
        } while (true);
        Collections.sort(arraylist);
        return arraylist;
    }

    private ObjectID uploadChunksAndComplete(ObjectID objectid, File file, List list, MultipartUpload multipartupload)
        throws IOException, JSONException, TransientException, TerminalException, InterruptedException
    {
        ArrayList arraylist = getRemainingChunks(list);
        if (arraylist.size() > 0)
        {
            multipartUploader.multipartUpload(file, arraylist, uploadProgressCallback);
        }
        if (!file.exists() || file.lastModified() != multipartupload.getLastModified())
        {
            clearProgress(file.getAbsolutePath());
            return null;
        } else
        {
            restClient.getCompleteFileUploadByIdOperation(objectid, multipartupload.getStorageKey(), multipartupload.getUploadId(), list).get();
            GLogger.d(TAG, "Completed multi-part upload for file: %s, objectID: %s", new Object[] {
                file.getName(), objectid.toString()
            });
            clearProgress(file.getAbsolutePath());
            return objectid;
        }
    }

    private boolean urlsAreExpired(List list)
        throws JSONException
    {
        boolean flag1 = false;
        list = getRemainingChunks(list);
        boolean flag = flag1;
        if (list != null)
        {
            flag = flag1;
            if (!list.isEmpty())
            {
                long l = (new JSONObject(((UploadChunk)list.get(0)).getParameters())).getLong("Expires");
                flag = flag1;
                if ((new Date()).getTime() / 1000L > l)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public ObjectID get()
        throws TerminalException, TransientException
    {
        Object obj;
        Timer timer;
        JSONObject jsonobject;
        boolean flag;
        timer = profiler.newTimer(UploadOperation.MetricsEvent.TotalUpload);
        obj = uploadPathResolver.getPath(mediaItem, defaultCameraFolder);
        if (deviceAttributeStore.getCachedDeviceId() == null)
        {
            NetworkExecutor.getInstance().execute(restClient.getRegisterDeviceOperation());
        }
        jsonobject = (JSONObject)NetworkExecutor.getInstance().execute(restClient.getCreateByIdOperation(((String) (obj)), mediaItem.getName(), mediaItem.getDateCreatedUTCMs(), mediaItem.hasProperty(CommonMediaProperty.CAMERA)));
        if (jsonobject == null)
        {
            timer.stop(false);
            return null;
        }
        obj = null;
        flag = false;
        ObjectID objectid = ObjectID.parseString((String)jsonobject.get("id"));
        obj = objectid;
        boolean flag1 = ((Boolean)jsonobject.get("available")).booleanValue();
        flag = flag1;
        obj = objectid;
_L2:
        if (obj == null)
        {
            timer.stop(false);
            return null;
        }
        break; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        GLogger.ex(TAG, "Failed to get objectid/available from createbyid response json", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            GLogger.i(TAG, "Trying to upload file already existed on cloud", new Object[0]);
            return ((ObjectID) (obj));
        }
        File file = new File(mediaItem.getLocalPath());
        MultipartAndChunks multipartandchunks = getMultipartUploadChunks(mediaItem, ((ObjectID) (obj)), file);
        obj = uploadChunksAndComplete(((ObjectID) (obj)), file, multipartandchunks.chunks, multipartandchunks.multipartUpload);
        return ((ObjectID) (obj));
        Object obj1;
        obj1;
        GLogger.ex(TAG, "Failed to get multipart upload location", ((Throwable) (obj1)));
_L3:
        return null;
        obj1;
_L4:
        Thread.currentThread().interrupt();
        throw new CanceledException("Multipart upload canceled", ((Exception) (obj1)));
        obj1;
        GLogger.e(TAG, "IOException while attempting to upload multipart chunks (%s)", new Object[] {
            obj1.getClass()
        });
        GLogger.dx(TAG, "IOException while attempting to upload multipart chunks (continued)", ((Throwable) (obj1)));
          goto _L3
        obj1;
          goto _L4
    }

    public volatile Object get()
        throws TerminalException, TransientException
    {
        return get();
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.cds;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.RemoteException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.RebuildRequestException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.model.DownloadFileRequest;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DownloadMediaItemOperation
    implements com.amazon.gallery.framework.network.http.rest.RestClient.Operation
{

    private static final String TAG = com/amazon/gallery/framework/network/cds/DownloadMediaItemOperation.getName();
    private final int assetSize;
    private final AmazonCloudDriveExtendedClient client;
    private final Context context;
    private final File file;
    private final MediaItem mediaItem;
    private final MediaType mediaType;

    public DownloadMediaItemOperation(Context context1, AmazonCloudDriveExtendedClient amazonclouddriveextendedclient, MediaItem mediaitem, File file1)
    {
        this(context1, amazonclouddriveextendedclient, mediaitem, file1, -1);
    }

    public DownloadMediaItemOperation(Context context1, AmazonCloudDriveExtendedClient amazonclouddriveextendedclient, MediaItem mediaitem, File file1, int i)
    {
        context = context1;
        client = amazonclouddriveextendedclient;
        mediaItem = mediaitem;
        file = file1;
        assetSize = i;
        mediaType = MediaType.PHOTO;
    }

    public DownloadMediaItemOperation(Context context1, AmazonCloudDriveExtendedClient amazonclouddriveextendedclient, MediaItem mediaitem, File file1, int i, MediaType mediatype)
    {
        context = context1;
        client = amazonclouddriveextendedclient;
        mediaItem = mediaitem;
        file = file1;
        assetSize = i;
        mediaType = mediatype;
    }

    private boolean nodeTransformExists(String s, String s1)
    {
        Object obj;
        String s2;
        ContentProviderClient contentproviderclient;
        String s3;
        Object obj1;
        Object obj2;
        android.net.Uri uri;
        obj = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        uri = com.amazon.mixtape.provider.CloudNodesContract.NodeTransforms.getContentUri(context.getResources().getString(0x7f0e02fb), ((String) (obj)));
        contentproviderclient = null;
        obj = null;
        obj2 = null;
        obj1 = null;
        s2 = obj1;
        s3 = obj2;
        ContentProviderClient contentproviderclient1 = context.getContentResolver().acquireContentProviderClient(uri);
        obj = contentproviderclient1;
        s2 = obj1;
        contentproviderclient = contentproviderclient1;
        s3 = obj2;
        s = contentproviderclient1.query(uri, new String[] {
            "node_id", "transform"
        }, "node_id =? AND transform =?", new String[] {
            s, s1
        }, null);
        if (s == null)
        {
            if (s != null)
            {
                s.close();
            }
            if (contentproviderclient1 != null)
            {
                contentproviderclient1.release();
            }
            return false;
        }
        obj = contentproviderclient1;
        s2 = s;
        contentproviderclient = contentproviderclient1;
        s3 = s;
        int i = s.getColumnIndex("node_id");
        if (i == -1)
        {
            if (s != null)
            {
                s.close();
            }
            if (contentproviderclient1 != null)
            {
                contentproviderclient1.release();
            }
            return false;
        }
        obj = contentproviderclient1;
        s2 = s;
        contentproviderclient = contentproviderclient1;
        s3 = s;
        boolean flag = s.moveToFirst();
        if (flag)
        {
            if (s != null)
            {
                s.close();
            }
            if (contentproviderclient1 != null)
            {
                contentproviderclient1.release();
            }
            return true;
        }
        if (s != null)
        {
            s.close();
        }
        if (contentproviderclient1 != null)
        {
            contentproviderclient1.release();
        }
        return false;
        s;
        contentproviderclient = ((ContentProviderClient) (obj));
        s3 = s2;
        GLogger.ex(TAG, "Error while querying content provider client", s);
        if (s2 != null)
        {
            s2.close();
        }
        if (obj != null)
        {
            ((ContentProviderClient) (obj)).release();
        }
        return false;
        s;
        if (s3 != null)
        {
            s3.close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        throw s;
    }

    public volatile Object get()
        throws TerminalException, TransientException
    {
        return get();
    }

    public Void get()
        throws TerminalException, TransientException
    {
        Object obj = IdUtils.objectIdToNodeId(mediaItem.getObjectId().getMostSignificantBits(), mediaItem.getObjectId().getLeastSignificantBits());
        DownloadFileRequest downloadfilerequest = new DownloadFileRequest(((String) (obj)), new FileOutputStream(file));
        if (!(mediaItem instanceof Video) || assetSize <= 0) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaType.ordinal()];
        JVM INSTR tableswitch 1 2: default 216
    //                   1 126
    //                   2 175;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_175;
_L2:
        if (assetSize > 0)
        {
            downloadfilerequest.setViewBox(assetSize);
        }
        client.downloadFile(downloadfilerequest, null);
        return null;
_L4:
label0:
        {
            if (!nodeTransformExists(((String) (obj)), "IMAGE_THUMBNAIL"))
            {
                break label0;
            }
            downloadfilerequest.setTransform("IMAGE_THUMBNAIL");
        }
          goto _L2
        try
        {
            throw new TerminalException("No image thumbnail exists for this video");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new TransientException(((Exception) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        throw new TerminalException(((Throwable) (obj)));
label1:
        {
            if (!nodeTransformExists(((String) (obj)), "VIDEO_TRANSCODE"))
            {
                break label1;
            }
            downloadfilerequest.setTransform("VIDEO_TRANSCODE");
            downloadfilerequest.setResolution(assetSize);
        }
          goto _L2
        throw new TerminalException("No video transcode exists for this video.");
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.remotestorage.RemoteStorageDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.UploadChunk;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadProgressCallback;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            LimitedFileInputStream

public class MultipartUploader
{

    private static final String TAG = com/amazon/gallery/framework/network/upload/MultipartUploader.getName();
    private final HttpClient httpClient;
    private HttpPut httpPut;
    private final RemoteStorageDao remoteStorageDao;

    public MultipartUploader(RemoteStorageDao remotestoragedao, HttpClient httpclient)
        throws InvalidParameterException
    {
        remoteStorageDao = remotestoragedao;
        httpClient = httpclient;
    }

    private String extractEtag(Header header)
    {
        String s = header.getValue();
        header = s;
        if (s.charAt(0) == '"')
        {
            header = s;
            if (s.charAt(s.length() - 1) == '"')
            {
                header = s.substring(1, s.length() - 1);
            }
        }
        return header;
    }

    public static boolean shouldUseMultipart(MediaItem mediaitem)
    {
        File file = new File(mediaitem.getLocalPath());
        return MediaType.VIDEO == mediaitem.getType() && file.length() > 0x500000L;
    }

    private void uploadPart(File file, UploadChunk uploadchunk, long l)
        throws IOException, JSONException, TransientException, InvalidParameterException
    {
        HttpEntity httpentity;
        Object obj;
        StatusLine statusline;
        GLogger.d(TAG, "Starting upload for part %d", new Object[] {
            Integer.valueOf(uploadchunk.getChunkNumber())
        });
        statusline = null;
        httpentity = null;
        obj = null;
        Object obj2;
        JSONObject jsonobject = new JSONObject(uploadchunk.getParameters());
        obj2 = new StringBuilder(uploadchunk.getUploadUrl());
        ((StringBuilder) (obj2)).append('?');
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); ((StringBuilder) (obj2)).append('&'))
        {
            String s1 = (String)iterator.next();
            ((StringBuilder) (obj2)).append(URLEncoder.encode(s1));
            ((StringBuilder) (obj2)).append('=');
            ((StringBuilder) (obj2)).append(URLEncoder.encode(jsonobject.getString(s1), "UTF-8"));
        }

          goto _L1
        file;
        uploadchunk = obj;
_L3:
        Object obj1;
        HttpEntity httpentity1;
        String s;
        if (httpentity != null)
        {
            try
            {
                httpentity.consumeContent();
            }
            catch (IOException ioexception)
            {
                GLogger.wx(TAG, "IOException while consuming HTTP response entity", ioexception);
            }
        }
        if (uploadchunk != null)
        {
            try
            {
                uploadchunk.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (UploadChunk uploadchunk)
            {
                GLogger.wx(TAG, "IOException while consuming multipart request entity", uploadchunk);
            }
        }
        throw file;
_L1:
        httpPut = new HttpPut();
        httpPut.setURI(URI.create(((StringBuilder) (obj2)).toString()));
        obj1 = new JSONObject(uploadchunk.getHeaders());
        for (obj2 = ((JSONObject) (obj1)).keys(); ((Iterator) (obj2)).hasNext(); httpPut.addHeader(s, ((JSONObject) (obj1)).getString(s)))
        {
            s = (String)((Iterator) (obj2)).next();
        }

        obj1 = new InputStreamEntity(new LimitedFileInputStream(file, uploadchunk.getStartPosition(), l), l);
        httpentity = statusline;
        httpPut.setEntity(((HttpEntity) (obj1)));
        httpentity = statusline;
        GLogger.d(TAG, "Executing chunk upload to S3", new Object[0]);
        httpentity = statusline;
        obj2 = httpClient.execute(httpPut);
        httpentity = statusline;
        GLogger.d(TAG, "Completed chunk upload to S3", new Object[0]);
        httpentity = statusline;
        httpentity1 = ((HttpResponse) (obj2)).getEntity();
        httpentity = httpentity1;
        statusline = ((HttpResponse) (obj2)).getStatusLine();
        httpentity = httpentity1;
        GLogger.d(TAG, (new StringBuilder()).append("Upload response status: ").append(statusline).toString(), new Object[0]);
        httpentity = httpentity1;
        if (statusline.getStatusCode() < 300)
        {
            break MISSING_BLOCK_LABEL_435;
        }
        httpentity = httpentity1;
        throw new TransientException("Chunk upload to S3 was unsuccessful", statusline);
        httpentity = httpentity1;
        uploadchunk.setETag(extractEtag(((HttpResponse) (obj2)).getFirstHeader("ETag")));
        httpentity = httpentity1;
        remoteStorageDao.storeMultipartETag(file.getAbsolutePath(), uploadchunk.getChunkNumber(), uploadchunk.getETag());
        if (httpentity1 != null)
        {
            try
            {
                httpentity1.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                GLogger.wx(TAG, "IOException while consuming HTTP response entity", file);
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((InputStreamEntity) (obj1)).consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                GLogger.wx(TAG, "IOException while consuming multipart request entity", file);
            }
        }
        GLogger.d(TAG, "Finished upload for part %d", new Object[] {
            Integer.valueOf(uploadchunk.getChunkNumber())
        });
        return;
        file;
        uploadchunk = ((UploadChunk) (obj1));
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void multipartUpload(File file, List list, UploadProgressCallback uploadprogresscallback)
        throws IOException, JSONException, TransientException, InvalidParameterException, InterruptedException
    {
        int j = list.size() - 1;
        for (int i = 0; i <= j; i++)
        {
            UploadChunk uploadchunk = (UploadChunk)list.get(i);
            long l;
            if (i != j)
            {
                l = ((UploadChunk)list.get(i + 1)).getStartPosition();
            } else
            {
                l = file.length();
            }
            uploadPart(file, uploadchunk, l - uploadchunk.getStartPosition());
            if (Thread.currentThread().isInterrupted())
            {
                GLogger.d(TAG, "Multipart upload interrupted", new Object[0]);
                throw new InterruptedException();
            }
            uploadprogresscallback.onUploadProgressChanged(i, j);
        }

    }

}

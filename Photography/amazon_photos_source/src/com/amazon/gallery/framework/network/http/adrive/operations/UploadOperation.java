// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.adrive.operations;

import android.os.SystemClock;
import android.util.Log;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadPathResolver;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadPathResolverWrapper;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.upload.MultipartEntityWithProgress;
import com.amazon.gallery.framework.network.upload.UploadProgressListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadOperation
    implements com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent S3Upload;
        public static final MetricsEvent TotalUpload;
        public static final MetricsEvent UploadBandwidth;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/network/http/adrive/operations/UploadOperation$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            TotalUpload = new MetricsEvent("TotalUpload", 0);
            S3Upload = new MetricsEvent("S3Upload", 1);
            UploadBandwidth = new MetricsEvent("UploadBandwidth", 2);
            $VALUES = (new MetricsEvent[] {
                TotalUpload, S3Upload, UploadBandwidth
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/http/adrive/operations/UploadOperation.getName();
    private final String defaultCameraFolder;
    private final DeviceAttributeStore deviceAttributeStore;
    private final HttpFactory httpFactory;
    private final UploadProgressListener listener;
    private final MediaItem mediaItem;
    private final ComponentProfiler profiler;
    private final RestClient restClient;
    private final HttpClient s3Client;
    private final UploadPathResolver uploadPathResolver;

    public UploadOperation(RestClient restclient, HttpFactory httpfactory, MediaItem mediaitem, HttpClient httpclient, String s, DeviceAttributeStore deviceattributestore, Profiler profiler1, 
            UploadProgressListener uploadprogresslistener)
        throws InvalidParameterException
    {
        restClient = restclient;
        mediaItem = mediaitem;
        s3Client = httpclient;
        httpFactory = httpfactory;
        defaultCameraFolder = s;
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/network/http/adrive/operations/UploadOperation);
        listener = uploadprogresslistener;
        deviceAttributeStore = deviceattributestore;
        uploadPathResolver = new UploadPathResolverWrapper(restclient, deviceattributestore);
    }

    private boolean uploadToS3(File file, String s, String s1, JSONObject jsonobject)
        throws InvalidParameterException
    {
        String s2;
        String s3;
        String s4;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Timer timer;
        MultipartEntityWithProgress multipartentitywithprogress;
        HttpPost httppost;
        long l;
        httppost = httpFactory.getHttpPostRequest();
        httppost.setURI(URI.create(s1));
        multipartentitywithprogress = new MultipartEntityWithProgress(null, null, Charset.forName("UTF-8"), listener);
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj = null;
        timer = profiler.newTimer(MetricsEvent.S3Upload);
        l = SystemClock.uptimeMillis();
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        Iterator iterator = jsonobject.keys();
_L2:
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        String s5 = (String)iterator.next();
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        multipartentitywithprogress.addPart(s5, new StringBody((String)jsonobject.get(s5), Charset.forName("UTF-8")));
        if (true) goto _L2; else goto _L1
        file;
        s2 = s3;
_L8:
        s1 = s2;
        GLogger.ex(TAG, "Failed to get setup upload to s3", file);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        s2.consumeContent();
        double d;
        int i;
        boolean flag;
        if (multipartentitywithprogress != null)
        {
            try
            {
                multipartentitywithprogress.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                Log.w(TAG, (new StringBuilder()).append("IOException while consuming HTTP response entity: ").append(file.getMessage()).toString());
            }
        }
_L6:
        timer.stop(false);
        flag = false;
_L4:
        return flag;
_L1:
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        multipartentitywithprogress.addPart("filename", new StringBody(s, Charset.forName("UTF-8")));
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        multipartentitywithprogress.addPart("file", new FileBody(file));
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        httppost.setEntity(multipartentitywithprogress);
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        jsonobject = s3Client.execute(httppost);
        s3 = obj;
        s4 = obj1;
        s1 = obj2;
        s2 = obj3;
        s = jsonobject.getEntity();
        s3 = s;
        s4 = s;
        s1 = s;
        s2 = s;
        i = jsonobject.getStatusLine().getStatusCode();
        if (i < 200 || i > 299)
        {
            break MISSING_BLOCK_LABEL_573;
        }
        s3 = s;
        s4 = s;
        s1 = s;
        s2 = s;
        timer.stop(true);
        s3 = s;
        s4 = s;
        s1 = s;
        s2 = s;
        d = (1.0D * (double)(SystemClock.uptimeMillis() - l)) / 1000D;
        s3 = s;
        s4 = s;
        s1 = s;
        s2 = s;
        l = (long)((double)(file.length() * 8L) / d);
        s3 = s;
        s4 = s;
        s1 = s;
        s2 = s;
        profiler.trackTimer(MetricsEvent.UploadBandwidth, l);
        flag = true;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            s.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.w(TAG, (new StringBuilder()).append("IOException while consuming HTTP response entity: ").append(file.getMessage()).toString());
            return true;
        }
        if (multipartentitywithprogress == null) goto _L4; else goto _L3
_L3:
        multipartentitywithprogress.consumeContent();
        return true;
        s3 = s;
        s4 = s;
        s1 = s;
        s2 = s;
        GLogger.e(TAG, "Upload failed: Status code %d", new Object[] {
            Integer.valueOf(jsonobject.getStatusLine().getStatusCode())
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_624;
        }
        s.consumeContent();
        if (multipartentitywithprogress != null)
        {
            try
            {
                multipartentitywithprogress.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                Log.w(TAG, (new StringBuilder()).append("IOException while consuming HTTP response entity: ").append(file.getMessage()).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        file;
        s1 = s4;
        GLogger.e(TAG, "failed to upload to s3 (%s)", new Object[] {
            file.getClass()
        });
        s1 = s4;
        GLogger.dx(TAG, "failed to upload to s3 (continued)", file);
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_752;
        }
        s4.consumeContent();
        if (multipartentitywithprogress != null)
        {
            try
            {
                multipartentitywithprogress.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                Log.w(TAG, (new StringBuilder()).append("IOException while consuming HTTP response entity: ").append(file.getMessage()).toString());
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        file;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_809;
        }
        s1.consumeContent();
        if (multipartentitywithprogress != null)
        {
            try
            {
                multipartentitywithprogress.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.w(TAG, (new StringBuilder()).append("IOException while consuming HTTP response entity: ").append(s.getMessage()).toString());
            }
        }
        throw file;
        file;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public ObjectID get()
        throws TerminalException, TransientException
    {
        Object obj;
        Object obj1;
        Timer timer;
        boolean flag;
        timer = profiler.newTimer(MetricsEvent.TotalUpload);
        obj = uploadPathResolver.getPath(mediaItem, defaultCameraFolder);
        if (deviceAttributeStore.getCachedDeviceId() == null)
        {
            NetworkExecutor.getInstance().execute(restClient.getRegisterDeviceOperation());
        }
        obj1 = (JSONObject)NetworkExecutor.getInstance().execute(restClient.getCreateByIdOperation(((String) (obj)), mediaItem.getName(), mediaItem.getDateCreatedUTCMs(), mediaItem.hasProperty(CommonMediaProperty.CAMERA)));
        if (obj1 == null)
        {
            timer.stop(false);
            return null;
        }
        obj = null;
        flag = false;
        ObjectID objectid = ObjectID.parseString((String)((JSONObject) (obj1)).get("id"));
        obj = objectid;
        boolean flag1 = ((Boolean)((JSONObject) (obj1)).get("available")).booleanValue();
        flag = flag1;
_L2:
        if (objectid == null)
        {
            timer.stop(false);
            return null;
        }
        break; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        GLogger.e(TAG, "Failed to get objectid/available from createbyid response json", new Object[0]);
        objectid = ((ObjectID) (obj));
        if (true) goto _L2; else goto _L1
_L1:
        String s;
        Object obj3;
        JSONObject jsonobject;
        if (flag)
        {
            GLogger.i(TAG, "Trying to upload file already existed on cloud", new Object[0]);
            return objectid;
        }
        jsonobject = (JSONObject)NetworkExecutor.getInstance().execute(restClient.getGetUploadUrlByIdOperation(objectid, mediaItem));
        obj = null;
        s = null;
        obj3 = null;
        jsonexception = s;
        Object obj2 = (String)jsonobject.get("storageKey");
        jsonexception = s;
        obj = obj2;
        s = (String)jsonobject.get("host");
        jsonexception = s;
        obj = obj2;
        jsonobject = (JSONObject)jsonobject.get("params");
        obj = obj2;
        obj2 = jsonobject;
        jsonexception = s;
_L4:
        if (obj == null || jsonexception == null || obj2 == null)
        {
            timer.stop(false);
            return null;
        }
        break; /* Loop/switch isn't completed */
        JSONException jsonexception1;
        jsonexception1;
        GLogger.e(TAG, "Failed to get data from getUploadUrlById response json", new Object[0]);
        obj2 = obj3;
        if (true) goto _L4; else goto _L3
_L3:
        if (uploadToS3(new File(mediaItem.getLocalPath()), mediaItem.getName(), jsonexception, ((JSONObject) (obj2))))
        {
            NetworkExecutor.getInstance().execute(restClient.getCompleteFileUploadByIdOperation(objectid, ((String) (obj))));
            timer.stop(true);
            return objectid;
        } else
        {
            timer.stop(false);
            return null;
        }
    }

    public volatile Object get()
        throws TerminalException, TransientException
    {
        return get();
    }

}

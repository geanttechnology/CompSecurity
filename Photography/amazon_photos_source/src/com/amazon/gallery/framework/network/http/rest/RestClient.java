// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest;

import android.content.Context;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.UriFilter;
import com.amazon.gallery.foundation.utils.file.ReusedBufferedReader;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.remotestorage.RemoteStorageDao;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.cds.DownloadMediaItemOperation;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.amazon.gallery.framework.network.cloudfront.GetUpdateConfigOperation;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.AccountLockedException;
import com.amazon.gallery.framework.network.exceptions.CloudStorageLimitException;
import com.amazon.gallery.framework.network.exceptions.InvalidAuthTokenException;
import com.amazon.gallery.framework.network.exceptions.InvalidMediaItemException;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.MediaItemIdErrorHandlerFactory;
import com.amazon.gallery.framework.network.exceptions.NoNetworkException;
import com.amazon.gallery.framework.network.exceptions.SndsNoLinkedFacebookAccountException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.adrive.operations.GetCloudStorageOperation;
import com.amazon.gallery.framework.network.http.adrive.operations.MultipartUploadOperation;
import com.amazon.gallery.framework.network.http.adrive.operations.UploadOperation;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.framework.network.http.rest.account.HttpConfig;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.http.rest.http.UserAgent;
import com.amazon.gallery.framework.network.http.senna.operations.DeleteMediaItemsOperation;
import com.amazon.gallery.framework.network.http.senna.operations.DeleteTagsOperation;
import com.amazon.gallery.framework.network.http.senna.operations.GetAccountDetailsOperation;
import com.amazon.gallery.framework.network.http.senna.operations.GetContactInfoOperation;
import com.amazon.gallery.framework.network.http.senna.operations.GetEndpointOperation;
import com.amazon.gallery.framework.network.http.senna.operations.GetMediaItemOperation;
import com.amazon.gallery.framework.network.http.senna.operations.GetMediaItemURLOperation;
import com.amazon.gallery.framework.network.http.senna.operations.ImportFacebookOperation;
import com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation;
import com.amazon.gallery.framework.network.http.senna.operations.ShareOperation;
import com.amazon.gallery.framework.network.http.senna.operations.upload.CompleteMediaUploadOperation;
import com.amazon.gallery.framework.network.http.senna.operations.upload.CreateMediaOperation;
import com.amazon.gallery.framework.network.http.senna.operations.upload.GetUploadLocationOperation;
import com.amazon.gallery.framework.network.http.senna.operations.upload.GetUploadLocationWithPartsOperation;
import com.amazon.gallery.framework.network.http.snds.GetFacebookPermissionsOperation;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadProgressCallback;
import com.amazon.gallery.framework.network.throttle.GetNetworkThrottleOperation;
import com.amazon.gallery.framework.network.upload.DefaultDeviceAttributeStore;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.upload.RegisterDeviceOperation;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RestClient
{
    private class HttpOperation
        implements Operation
    {

        protected final AbstractHttpMessage httpMessage;
        final RestClient this$0;

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (HttpOperation)obj;
            if (httpMessage != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((HttpOperation) (obj)).httpMessage == null) goto _L1; else goto _L3
_L3:
            return false;
            if (httpMessage.equals(((HttpOperation) (obj)).httpMessage)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public Object get()
            throws TerminalException, TransientException
        {
            Object obj;
            try
            {
                obj = executeOperation(httpMessage);
                obj = httpMessage.buildResponse(((JSONObject) (obj)));
            }
            catch (RuntimeException runtimeexception)
            {
                throw new TerminalException(runtimeexception);
            }
            return obj;
        }

        public int hashCode()
        {
            int i;
            if (httpMessage == null)
            {
                i = 0;
            } else
            {
                i = httpMessage.hashCode();
            }
            return i + 31;
        }

        public String toString()
        {
            return httpMessage.toString();
        }

        public HttpOperation(AbstractHttpMessage abstracthttpmessage)
        {
            this$0 = RestClient.this;
            super();
            httpMessage = abstracthttpmessage;
        }
    }

    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent CompleteItem;
        public static final MetricsEvent CompleteMediaItemUpload;
        public static final MetricsEvent CreateAccount;
        public static final MetricsEvent CreateMediaItem;
        public static final MetricsEvent DeleteMediaItem;
        public static final MetricsEvent DeleteTag;
        public static final MetricsEvent DownloadBandwidth;
        public static final MetricsEvent FacebookExport;
        public static final MetricsEvent FacebookImport;
        public static final MetricsEvent GetAccountDetails;
        public static final MetricsEvent GetContactInfo;
        public static final MetricsEvent GetEndpoint;
        public static final MetricsEvent GetFacebookPermissionsOperation;
        public static final MetricsEvent GetMediaItem;
        public static final MetricsEvent GetMediaItemUploadLocation;
        public static final MetricsEvent GetMultiUploadLocationOperation;
        public static final MetricsEvent GetNetworkThrottle;
        public static final MetricsEvent GetTagCover;
        public static final MetricsEvent GetUpdateConfig;
        public static final MetricsEvent GetUploadUrl;
        public static final MetricsEvent GetUserStorage;
        public static final MetricsEvent ListMediaItems;
        public static final MetricsEvent ListTags;
        public static final MetricsEvent RegisterDeviceOperation;
        public static final MetricsEvent RenameTag;
        public static final MetricsEvent S3Download;
        public static final MetricsEvent SendNotification;
        public static final MetricsEvent SetupAccount;
        public static final MetricsEvent Share;
        public static final MetricsEvent Sync;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/network/http/rest/RestClient$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            GetEndpoint = new MetricsEvent("GetEndpoint", 0);
            CreateAccount = new MetricsEvent("CreateAccount", 1);
            SetupAccount = new MetricsEvent("SetupAccount", 2);
            GetUserStorage = new MetricsEvent("GetUserStorage", 3);
            RegisterDeviceOperation = new MetricsEvent("RegisterDeviceOperation", 4);
            Sync = new MetricsEvent("Sync", 5);
            GetAccountDetails = new MetricsEvent("GetAccountDetails", 6);
            CreateMediaItem = new MetricsEvent("CreateMediaItem", 7);
            DeleteMediaItem = new MetricsEvent("DeleteMediaItem", 8);
            ListMediaItems = new MetricsEvent("ListMediaItems", 9);
            GetMediaItem = new MetricsEvent("GetMediaItem", 10);
            GetMediaItemUploadLocation = new MetricsEvent("GetMediaItemUploadLocation", 11);
            GetMultiUploadLocationOperation = new MetricsEvent("GetMultiUploadLocationOperation", 12);
            CompleteMediaItemUpload = new MetricsEvent("CompleteMediaItemUpload", 13);
            GetUploadUrl = new MetricsEvent("GetUploadUrl", 14);
            CompleteItem = new MetricsEvent("CompleteItem", 15);
            FacebookImport = new MetricsEvent("FacebookImport", 16);
            FacebookExport = new MetricsEvent("FacebookExport", 17);
            GetFacebookPermissionsOperation = new MetricsEvent("GetFacebookPermissionsOperation", 18);
            ListTags = new MetricsEvent("ListTags", 19);
            GetTagCover = new MetricsEvent("GetTagCover", 20);
            DeleteTag = new MetricsEvent("DeleteTag", 21);
            RenameTag = new MetricsEvent("RenameTag", 22);
            SendNotification = new MetricsEvent("SendNotification", 23);
            GetContactInfo = new MetricsEvent("GetContactInfo", 24);
            Share = new MetricsEvent("Share", 25);
            S3Download = new MetricsEvent("S3Download", 26);
            DownloadBandwidth = new MetricsEvent("DownloadBandwidth", 27);
            GetNetworkThrottle = new MetricsEvent("GetNetworkThrottle", 28);
            GetUpdateConfig = new MetricsEvent("GetUpdateConfig", 29);
            $VALUES = (new MetricsEvent[] {
                GetEndpoint, CreateAccount, SetupAccount, GetUserStorage, RegisterDeviceOperation, Sync, GetAccountDetails, CreateMediaItem, DeleteMediaItem, ListMediaItems, 
                GetMediaItem, GetMediaItemUploadLocation, GetMultiUploadLocationOperation, CompleteMediaItemUpload, GetUploadUrl, CompleteItem, FacebookImport, FacebookExport, GetFacebookPermissionsOperation, ListTags, 
                GetTagCover, DeleteTag, RenameTag, SendNotification, GetContactInfo, Share, S3Download, DownloadBandwidth, GetNetworkThrottle, GetUpdateConfig
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface Operation
        extends com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation
    {
    }


    private static final String TAG = com/amazon/gallery/framework/network/http/rest/RestClient.getName();
    private final AuthenticationManager authenticationManager;
    protected final CloudDriveServiceClientManager cdsClientManager;
    protected final Context context;
    private DeviceAttributeStore deviceAttributeStore;
    private HttpClient do_not_use_me_httpClient;
    private HttpClient do_not_use_me_s3Client;
    private final EndpointManager endpointManager;
    private int errorCount;
    private final HttpFactory httpClientFactory;
    protected final HttpFactory httpFactory;
    private MediaItemIdErrorHandlerFactory mediaItemIdErrorHandlerFactory;
    private final NetworkConnectivity networkConnectivity;
    private Profiler parentProfiler;
    private ComponentProfiler profiler;
    private RemoteStorageDao remoteStorageDao;
    private UserAgent userAgent;

    protected RestClient(Context context1, HttpConfig httpconfig, NetworkConnectivity networkconnectivity, UserManager usermanager, AuthenticationManager authenticationmanager, HttpFactory httpfactory, HttpFactory httpfactory1, 
            MediaItemIdErrorHandlerFactory mediaitemiderrorhandlerfactory, DeviceAttributeStore deviceattributestore, CloudDriveServiceClientManager clouddriveserviceclientmanager, RemoteStorageDao remotestoragedao)
    {
        errorCount = 0;
        context = context1;
        httpClientFactory = httpfactory;
        httpFactory = httpfactory1;
        authenticationManager = authenticationmanager;
        networkConnectivity = networkconnectivity;
        mediaItemIdErrorHandlerFactory = mediaitemiderrorhandlerfactory;
        endpointManager = new EndpointManager(this, httpconfig, usermanager, authenticationmanager);
        context1 = deviceattributestore;
        if (deviceattributestore == null)
        {
            context1 = new DefaultDeviceAttributeStore();
        }
        deviceAttributeStore = context1;
        cdsClientManager = clouddriveserviceclientmanager;
        remoteStorageDao = remotestoragedao;
    }

    private JSONObject executeRequest(HttpRequest httprequest)
        throws TerminalException, TransientException
    {
        HttpRequest httprequest1;
        HttpRequest httprequest2;
        HttpRequest httprequest3;
        JSONObject jsonobject;
        StatusLine statusline;
        Object obj;
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        statusline = null;
        obj = null;
        jsonobject = null;
        httprequest2 = jsonobject;
        httprequest1 = statusline;
        httprequest3 = obj;
        String s = httprequest.getRequestLine().getUri();
        httprequest2 = jsonobject;
        httprequest1 = statusline;
        httprequest3 = obj;
        if (authenticationManager.getAccountId() != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        httprequest2 = jsonobject;
        httprequest1 = statusline;
        httprequest3 = obj;
        throw new TerminalException((new StringBuilder()).append("No Account Registered, stopping request: ").append(s).toString());
        httprequest;
        httprequest1 = httprequest2;
        GLogger.w(TAG, "An IOException occurred with the HTTP request: %s", new Object[] {
            httprequest.getMessage()
        });
        httprequest1 = httprequest2;
        throw new TransientException(httprequest);
        httprequest;
        HttpResponse httpresponse;
        int i;
        if (httprequest1 != null)
        {
            try
            {
                httprequest1.consumeContent();
            }
            catch (IOException ioexception)
            {
                GLogger.w(TAG, "IOException while consuming HTTP response entity: %s", new Object[] {
                    ioexception.getMessage()
                });
            }
        }
        throw httprequest;
        httprequest2 = jsonobject;
        httprequest1 = statusline;
        httprequest3 = obj;
        GLogger.t0(TAG, "HTTP request %s initiated", new Object[] {
            s
        });
        httprequest2 = jsonobject;
        httprequest1 = statusline;
        httprequest3 = obj;
        httpresponse = getHttpClient().execute(null, httprequest);
        httprequest2 = jsonobject;
        httprequest1 = statusline;
        httprequest3 = obj;
        httprequest = httpresponse.getEntity();
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        GLogger.t(TAG, "HTTP request is executed", new Object[0]);
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        jsonobject = parseJsonResponse(httprequest);
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        statusline = httpresponse.getStatusLine();
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        i = statusline.getStatusCode();
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        resetErrorCount();
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        GLogger.d(TAG, "HTTP request %s completed with status code = %s", new Object[] {
            s, Integer.valueOf(i)
        });
        if (httprequest != null)
        {
            try
            {
                httprequest.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequest httprequest)
            {
                GLogger.w(TAG, "IOException while consuming HTTP response entity: %s", new Object[] {
                    httprequest.getMessage()
                });
                return jsonobject;
            }
        }
        return jsonobject;
        if ((i < 500 || i >= 600) && i != 429)
        {
            break MISSING_BLOCK_LABEL_465;
        }
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        incrementErrorCount();
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        throw new TransientException(UriFilter.filter(s), statusline);
        httprequest;
        httprequest1 = httprequest3;
        GLogger.wxf(TAG, httprequest, "An unexpected RuntimeException occured", new Object[0]);
        httprequest1 = httprequest3;
        throw new TransientException(httprequest);
        if (i < 400 || i >= 500)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        parseAndThrowException(s, statusline, httpresponse);
        httprequest2 = httprequest;
        httprequest1 = httprequest;
        httprequest3 = httprequest;
        throw new TerminalException(UriFilter.filter(s), statusline);
    }

    private HttpClient getHttpClient()
    {
        this;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (do_not_use_me_httpClient == null)
        {
            do_not_use_me_httpClient = httpClientFactory.getHttpClient(context);
        }
        httpclient = do_not_use_me_httpClient;
        this;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    private HttpClient getS3Client()
    {
        this;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (do_not_use_me_s3Client == null)
        {
            do_not_use_me_s3Client = httpFactory.getHttpClient(context);
        }
        httpclient = do_not_use_me_s3Client;
        this;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    private void incrementErrorCount()
    {
        this;
        JVM INSTR monitorenter ;
        if (errorCount < 5)
        {
            errorCount = errorCount + 1;
            if (errorCount >= 5)
            {
                notifyErrorCountChanged(true);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void notifyErrorCountChanged(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        networkConnectivity.updateErrorCount(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void parseAndThrowException(String s, StatusLine statusline, HttpResponse httpresponse)
        throws TerminalException, TransientException
    {
        httpresponse = httpresponse.getHeaders("x-amzn-ErrorType");
        if (httpresponse.length <= 0) goto _L2; else goto _L1
_L1:
        httpresponse = httpresponse[0].getValue();
        if (httpresponse.contains("SndsNoLinkedFacebookAccountException"))
        {
            throw new SndsNoLinkedFacebookAccountException();
        }
        if (httpresponse.contains("StorageLimitError"))
        {
            throw new CloudStorageLimitException();
        }
        if (httpresponse.contains("InvalidTokenError"))
        {
            throw new InvalidAuthTokenException();
        }
        if (httpresponse.contains("PhotoIdError"))
        {
            throw new InvalidMediaItemException();
        }
        if (httpresponse.contains("AccountLockedError"))
        {
            throw new AccountLockedException();
        }
        if (!httpresponse.contains("CustomerIdError")) goto _L2; else goto _L3
_L3:
        endpointManager.removeEndpoint();
        getCdsClient().setupAccount(new SetupAccountRequest());
_L4:
        throw new TransientException("Caught and handled a CustomerIdError");
        s;
_L5:
        GLogger.i(TAG, "Exception while calling setupAccount", new Object[] {
            s
        });
        if (true) goto _L4; else goto _L2
_L2:
        throw new TerminalException(UriFilter.filter(s), statusline);
        s;
          goto _L5
    }

    private void resetErrorCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = errorCount;
        if (i != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        errorCount = 0;
        notifyErrorCountChanged(false);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void addRequestHeaders(HttpRequestBase httprequestbase)
    {
    }

    public JSONObject executeOperation(AbstractHttpMessage abstracthttpmessage)
        throws TerminalException, TransientException
    {
        if (abstracthttpmessage.getEndpoint() == null)
        {
            abstracthttpmessage.setEndpoint(endpointManager.getEndpoint());
        }
        abstracthttpmessage.request = abstracthttpmessage.buildRequest();
        abstracthttpmessage.request.removeHeaders("User-Agent");
        abstracthttpmessage.request.addHeader("User-Agent", userAgent.toString());
        addRequestHeaders(abstracthttpmessage.request);
        if (!networkConnectivity.isNetworkConnected())
        {
            throw new NoNetworkException();
        }
        Timer timer = profiler.newTimer(abstracthttpmessage.metricsEvent);
        if (abstracthttpmessage.metricsEventTag != null)
        {
            timer.addExtra("tag", abstracthttpmessage.metricsEventTag);
        }
        try
        {
            timer.start();
            abstracthttpmessage = executeRequest(abstracthttpmessage.request);
            timer.stop(true);
        }
        // Misplaced declaration of an exception variable
        catch (AbstractHttpMessage abstracthttpmessage)
        {
            timer.stop(false);
            throw abstracthttpmessage;
        }
        return abstracthttpmessage;
    }

    public Operation getAccountDetails()
        throws InvalidParameterException
    {
        GLogger.d(TAG, "Executing createAccount operation", new Object[0]);
        return new HttpOperation(new GetAccountDetailsOperation(httpFactory));
    }

    protected AmazonCloudDriveExtendedClient getCdsClient()
        throws IllegalStateException
    {
        return cdsClientManager.getForegroundCdsClient();
    }

    public Operation getCompleteFileUploadByIdOperation(ObjectID objectid, String s)
        throws InvalidParameterException
    {
        return new HttpOperation(new CompleteMediaUploadOperation(httpFactory, objectid, s, deviceAttributeStore));
    }

    public Operation getCompleteFileUploadByIdOperation(ObjectID objectid, String s, String s1, List list)
        throws InvalidParameterException
    {
        return new HttpOperation(new CompleteMediaUploadOperation(httpFactory, objectid, s, deviceAttributeStore, s1, list));
    }

    public Operation getContactInfo()
        throws InvalidParameterException
    {
        return new HttpOperation(new GetContactInfoOperation(httpFactory));
    }

    public Operation getCreateByIdOperation(String s, String s1, long l, boolean flag)
        throws InvalidParameterException
    {
        return new HttpOperation(new CreateMediaOperation(httpFactory, s, s1, l, deviceAttributeStore, flag));
    }

    public Operation getDeleteMediaItemsOperation(List list)
        throws InvalidParameterException
    {
        return new HttpOperation(new DeleteMediaItemsOperation(httpFactory, list));
    }

    public Operation getDeleteTagsOperation(List list)
        throws InvalidParameterException
    {
        return new HttpOperation(new DeleteTagsOperation(httpFactory, list));
    }

    public com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation getDownloadMediaItemOperation(File file, MediaItem mediaitem)
        throws InvalidParameterException, IllegalStateException
    {
        return new DownloadMediaItemOperation(context, getCdsClient(), mediaitem, file);
    }

    public com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation getDownloadMediaItemOperation(File file, MediaItem mediaitem, int i)
        throws InvalidParameterException, IllegalStateException
    {
        return new DownloadMediaItemOperation(context, getCdsClient(), mediaitem, file, i);
    }

    public com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation getDownloadMediaItemOperation(File file, MediaItem mediaitem, int i, MediaType mediatype)
        throws InvalidParameterException, IllegalStateException
    {
        return new DownloadMediaItemOperation(context, getCdsClient(), mediaitem, file, i, mediatype);
    }

    public EndpointManager getEndpointManager()
    {
        return endpointManager;
    }

    public Operation getEndpointOperation(Endpoint endpoint)
        throws InvalidParameterException
    {
        GetEndpointOperation getendpointoperation = new GetEndpointOperation(httpFactory);
        getendpointoperation.setEndpoint(endpoint);
        return new HttpOperation(getendpointoperation);
    }

    public Operation getFacebookPermissionsOperation()
        throws InvalidParameterException
    {
        return new HttpOperation(new GetFacebookPermissionsOperation(httpFactory));
    }

    public Operation getGetUploadLocationWithPartsOperation(ObjectID objectid, MediaItem mediaitem, int i)
        throws InvalidParameterException
    {
        return new HttpOperation(new GetUploadLocationWithPartsOperation(httpFactory, objectid, mediaitem, i));
    }

    public Operation getGetUploadUrlByIdOperation(ObjectID objectid, MediaItem mediaitem)
        throws InvalidParameterException
    {
        return new HttpOperation(new GetUploadLocationOperation(httpFactory, objectid, mediaitem));
    }

    public Operation getMediaItemOperation(ObjectID objectid, boolean flag)
        throws InvalidParameterException
    {
        return new HttpOperation(new GetMediaItemOperation(httpFactory, objectid, flag));
    }

    public GetMediaItemURLOperation getMediaItemURLOperation(ObjectID objectid, SennaMediaType sennamediatype, int i, int j, ScaleMode scalemode)
        throws InvalidParameterException
    {
        return new GetMediaItemURLOperation(sennamediatype, i, j, scalemode, getMediaItemOperation(objectid, false), mediaItemIdErrorHandlerFactory.getMediaItemIdErrorHandler(objectid));
    }

    public com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation getMultipartUploadOperation(MediaItem mediaitem, String s, UploadProgressCallback uploadprogresscallback)
        throws InvalidParameterException
    {
        return new MultipartUploadOperation(this, httpFactory, mediaitem, getS3Client(), s, deviceAttributeStore, parentProfiler, uploadprogresscallback, remoteStorageDao);
    }

    public Operation getNetworkThrottleOperation(CloudFrontConfig cloudfrontconfig)
        throws InvalidParameterException
    {
        return new HttpOperation(new GetNetworkThrottleOperation(cloudfrontconfig, httpFactory));
    }

    public Operation getRegisterDeviceOperation()
        throws InvalidParameterException
    {
        return new HttpOperation(new RegisterDeviceOperation(httpFactory, deviceAttributeStore));
    }

    public Operation getShareOperation(Collection collection, Collection collection1)
        throws InvalidParameterException
    {
        return new HttpOperation(new ShareOperation(httpFactory, collection, collection1));
    }

    public Operation getUpdateConfigOperation(CloudFrontConfig cloudfrontconfig)
        throws InvalidParameterException
    {
        return new HttpOperation(new GetUpdateConfigOperation(cloudfrontconfig, httpFactory));
    }

    public com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation getUploadOperation(MediaItem mediaitem, String s)
        throws InvalidParameterException
    {
        return new UploadOperation(this, httpFactory, mediaitem, getS3Client(), s, deviceAttributeStore, parentProfiler, null);
    }

    public Operation getUserStorageInformation()
        throws InvalidParameterException
    {
        return new HttpOperation(new GetCloudStorageOperation(httpFactory));
    }

    public Operation importFacebookPhotos(String s)
        throws InvalidParameterException
    {
        return new HttpOperation(new ImportFacebookOperation(httpFactory, s));
    }

    public void init()
    {
        getHttpClient();
        getS3Client();
    }

    JSONObject parseJsonResponse(HttpEntity httpentity)
    {
        Object obj1;
        Object obj6;
        Object obj7;
        String s;
        String s1;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        obj1 = null;
        obj7 = null;
        obj6 = null;
        obj8 = null;
        obj13 = null;
        obj12 = null;
        obj9 = null;
        s1 = null;
        obj14 = null;
        obj11 = null;
        obj10 = null;
        s = null;
        if (httpentity == null) goto _L2; else goto _L1
_L1:
        Object obj3;
        Object obj5;
        obj3 = obj14;
        obj5 = obj13;
        Object obj2 = httpentity.getContent();
        obj6 = obj2;
        obj3 = obj14;
        obj1 = obj2;
        obj5 = obj13;
        obj7 = obj2;
        httpentity = httpentity.getContentEncoding();
        Object obj;
        obj = obj2;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        obj6 = obj2;
        obj3 = obj14;
        obj1 = obj2;
        obj5 = obj13;
        obj7 = obj2;
        HeaderElement aheaderelement[] = httpentity.getElements();
        obj6 = obj2;
        obj3 = obj14;
        obj1 = obj2;
        obj5 = obj13;
        obj7 = obj2;
        int j = aheaderelement.length;
        int i;
        i = 0;
        httpentity = ((HttpEntity) (obj2));
_L5:
        if (i >= j) goto _L4; else goto _L3
_L3:
        if (!aheaderelement[i].getName().equalsIgnoreCase("gzip"))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new GZIPInputStream(httpentity);
        httpentity = ((HttpEntity) (obj));
        i++;
          goto _L5
_L4:
        obj = httpentity;
        obj6 = obj;
        obj3 = obj14;
        obj1 = obj;
        obj5 = obj13;
        obj7 = obj;
        httpentity = new InputStreamReader(((InputStream) (obj)), "UTF-8");
        obj1 = new ReusedBufferedReader(httpentity);
        obj7 = new StringBuilder();
_L8:
        obj2 = ((ReusedBufferedReader) (obj1)).readLine();
        if (obj2 == null) goto _L7; else goto _L6
_L6:
        ((StringBuilder) (obj7)).append(((String) (obj2))).append("\n");
          goto _L8
        obj3;
        obj2 = httpentity;
        httpentity = ((HttpEntity) (obj3));
        obj6 = obj1;
_L13:
        obj3 = obj6;
        obj1 = obj;
        obj5 = obj2;
        GLogger.exf(TAG, httpentity, "An IOException occurred with the HTTP request", new Object[0]);
        if (obj6 != null)
        {
            try
            {
                ((ReusedBufferedReader) (obj6)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing BufferedReader", new Object[0]);
            }
        }
        if (obj2 != null)
        {
            try
            {
                ((Reader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing InputStreamReader", new Object[0]);
            }
        }
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing HTTP InputStream", new Object[0]);
            }
        }
        GLogger.t(TAG, "HTTP response is converted to json", new Object[0]);
_L9:
        return new JSONObject();
_L7:
        if (((StringBuilder) (obj7)).length() > 0)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        obj2 = new JSONObject();
        if (obj1 != null)
        {
            try
            {
                ((ReusedBufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                GLogger.exf(TAG, ((Throwable) (obj1)), "IOException while closing BufferedReader", new Object[0]);
            }
        }
        if (httpentity != null)
        {
            try
            {
                httpentity.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing InputStreamReader", new Object[0]);
            }
        }
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing HTTP InputStream", new Object[0]);
            }
        }
        GLogger.t(TAG, "HTTP response is converted to json", new Object[0]);
        return ((JSONObject) (obj2));
        GLogger.t(TAG, "HTTP response is read", new Object[0]);
        obj2 = new JSONObject(((StringBuilder) (obj7)).toString());
        if (obj1 != null)
        {
            try
            {
                ((ReusedBufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                GLogger.exf(TAG, ((Throwable) (obj1)), "IOException while closing BufferedReader", new Object[0]);
            }
        }
        if (httpentity != null)
        {
            try
            {
                httpentity.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing InputStreamReader", new Object[0]);
            }
        }
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing HTTP InputStream", new Object[0]);
            }
        }
        GLogger.t(TAG, "HTTP response is converted to json", new Object[0]);
        return ((JSONObject) (obj2));
        httpentity;
        obj = obj8;
        obj7 = s;
        obj2 = s1;
_L11:
        obj3 = obj2;
        obj1 = obj6;
        obj5 = obj;
        s = TAG;
        obj3 = obj2;
        obj1 = obj6;
        obj5 = obj;
        s1 = httpentity.getMessage();
        if (obj7 == null)
        {
            obj7 = "";
        }
        obj3 = obj2;
        obj1 = obj6;
        obj5 = obj;
        GLogger.exf(s, httpentity, "Error parsing JSON - %s (%s)", new Object[] {
            s1, obj7
        });
        if (obj2 != null)
        {
            try
            {
                ((ReusedBufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing BufferedReader", new Object[0]);
            }
        }
        if (obj != null)
        {
            try
            {
                ((Reader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing InputStreamReader", new Object[0]);
            }
        }
        if (obj6 != null)
        {
            try
            {
                ((InputStream) (obj6)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing HTTP InputStream", new Object[0]);
            }
        }
        GLogger.t(TAG, "HTTP response is converted to json", new Object[0]);
          goto _L9
        obj;
        httpentity = ((HttpEntity) (obj5));
_L10:
        if (obj3 != null)
        {
            try
            {
                ((ReusedBufferedReader) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                GLogger.exf(TAG, ((Throwable) (obj2)), "IOException while closing BufferedReader", new Object[0]);
            }
        }
        if (httpentity != null)
        {
            try
            {
                httpentity.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing InputStreamReader", new Object[0]);
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                GLogger.exf(TAG, httpentity, "IOException while closing HTTP InputStream", new Object[0]);
            }
        }
        GLogger.t(TAG, "HTTP response is converted to json", new Object[0]);
        throw obj;
_L2:
        GLogger.e(TAG, "HTTP response entity was null", new Object[0]);
          goto _L9
        obj;
        obj3 = obj11;
        obj1 = httpentity;
        httpentity = obj12;
          goto _L10
        obj2;
        obj3 = obj11;
        obj1 = obj;
        obj = obj2;
          goto _L10
        obj2;
        obj3 = obj1;
        obj1 = obj;
        obj = obj2;
          goto _L10
        obj2;
        obj3 = obj1;
        obj1 = obj;
        obj = obj2;
          goto _L10
        obj;
        obj6 = httpentity;
        obj2 = s1;
        obj7 = s;
        httpentity = ((HttpEntity) (obj));
        obj = obj8;
          goto _L11
        Object obj4;
        obj4;
        obj1 = httpentity;
        obj2 = s1;
        obj7 = s;
        httpentity = ((HttpEntity) (obj4));
        obj6 = obj;
        obj = obj1;
          goto _L11
        obj4;
        obj2 = obj1;
        obj1 = httpentity;
        obj7 = s;
        httpentity = ((HttpEntity) (obj4));
        obj6 = obj;
        obj = obj1;
          goto _L11
        obj4;
        obj2 = obj1;
        obj1 = httpentity;
        httpentity = ((HttpEntity) (obj4));
        obj6 = obj;
        obj = obj1;
          goto _L11
        httpentity;
        obj6 = obj10;
        obj = obj7;
        obj2 = obj9;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj = httpentity;
        obj6 = obj10;
        httpentity = ((HttpEntity) (obj1));
        obj2 = obj9;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj2 = httpentity;
        obj6 = obj10;
        httpentity = ((HttpEntity) (obj1));
        continue; /* Loop/switch isn't completed */
        obj4;
        obj2 = httpentity;
        obj6 = obj1;
        httpentity = ((HttpEntity) (obj4));
        if (true) goto _L13; else goto _L12
_L12:
    }

    public Operation sendEmailNotification(com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType notificationtype, CharSequence charsequence)
        throws InvalidParameterException
    {
        return new HttpOperation(new SendNotificationOperation(httpFactory, com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationMode.EMAIL, notificationtype, charsequence));
    }

    public Operation sendSmsNotification(com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType notificationtype, CharSequence charsequence)
        throws InvalidParameterException
    {
        return new HttpOperation(new SendNotificationOperation(httpFactory, notificationtype.getNotificationMode(), notificationtype, charsequence));
    }

    public void setConfig(HttpConfig httpconfig)
    {
        endpointManager.setConfig(httpconfig);
    }

    public void setProfiler(Profiler profiler1)
    {
        parentProfiler = profiler1;
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/network/http/rest/RestClient);
    }

    public void setUserAgent(UserAgent useragent)
    {
        userAgent = useragent;
    }

}

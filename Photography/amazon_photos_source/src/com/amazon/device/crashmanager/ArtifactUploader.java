// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.TimeoutException;
import amazon.communication.authentication.AccountRequestContext;
import amazon.communication.authentication.RequestContext;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.srr.HttpClientSrrManager;
import amazon.communication.srr.SrrManager;
import android.net.http.AndroidHttpClient;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.communication.authentication.DcpRequestSigner;
import com.amazon.communication.authentication.RequestSigner;
import com.amazon.device.crashmanager.exception.DuplicateCrashDescriptorException;
import com.amazon.device.utils.DetUtil;
import com.amazon.device.utils.NetworkManager;
import com.amazon.device.utils.StatusNotifier;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactProcessor, Artifact, CrashDescriptorStorageUtil, ArtifactSource

class ArtifactUploader
{
    private static final class ArtifactUploadStatus extends Enum
    {

        private static final ArtifactUploadStatus $VALUES[];
        public static final ArtifactUploadStatus RETRY;
        public static final ArtifactUploadStatus SKIP;
        public static final ArtifactUploadStatus SUCCESS;

        public static ArtifactUploadStatus valueOf(String s)
        {
            return (ArtifactUploadStatus)Enum.valueOf(com/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus, s);
        }

        public static ArtifactUploadStatus[] values()
        {
            return (ArtifactUploadStatus[])$VALUES.clone();
        }

        static 
        {
            SUCCESS = new ArtifactUploadStatus("SUCCESS", 0);
            RETRY = new ArtifactUploadStatus("RETRY", 1);
            SKIP = new ArtifactUploadStatus("SKIP", 2);
            $VALUES = (new ArtifactUploadStatus[] {
                SUCCESS, RETRY, SKIP
            });
        }

        private ArtifactUploadStatus(String s, int i)
        {
            super(s, i);
        }
    }

    private class ArtifactUploaderResult
    {

        private ArtifactUploadStatus mArtifactUploadStatus;
        private String mCrashDescriptor;
        private String mUploadErrorMessage;
        private String mUploadErrorTag;
        final ArtifactUploader this$0;

        public ArtifactUploadStatus getArtifactUploadStatus()
        {
            return mArtifactUploadStatus;
        }

        public String getCrashDescriptor()
        {
            return mCrashDescriptor;
        }

        public String getUploadErrorTag()
        {
            return mUploadErrorTag;
        }


        public ArtifactUploaderResult(ArtifactUploadStatus artifactuploadstatus, String s)
        {
            this(artifactuploadstatus, s, null, null);
        }

        public ArtifactUploaderResult(ArtifactUploadStatus artifactuploadstatus, String s, String s1, String s2)
        {
            this$0 = ArtifactUploader.this;
            super();
            if (artifactuploadstatus == null)
            {
                throw new IllegalArgumentException("artifact upload status cannot be null");
            } else
            {
                mArtifactUploadStatus = artifactuploadstatus;
                mCrashDescriptor = s;
                mUploadErrorTag = s1;
                mUploadErrorMessage = s2;
                return;
            }
        }
    }


    private static final DPLogger log = new DPLogger("ArtifactUploader");
    private final boolean mAllowWANUpload;
    private final List mArtifactProcessors;
    private final List mArtifactSources;
    private final CrashDescriptorStorageUtil mCrashDescriptorStorageUtil;
    private final EndpointIdentity mDetEndpointIdentity;
    protected DetUtil mDetUtil;
    private final String mDeviceSerialNumber;
    private final String mDeviceType;
    private final NetworkManager mNetworkManager;
    private final RequestContext mRequestContext;
    private final RequestSigner mRequestSigner;
    private final StatusNotifier mStatusNotifier;

    public ArtifactUploader(EndpointIdentity endpointidentity, String s, String s1, List list, List list1, CrashDescriptorStorageUtil crashdescriptorstorageutil, StatusNotifier statusnotifier, 
            RequestSigner requestsigner, NetworkManager networkmanager, boolean flag)
        throws IllegalArgumentException
    {
        mDetUtil = new DetUtil();
        if (endpointidentity == null)
        {
            throw new IllegalArgumentException("Endpoint identity must not be null.");
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Device type: ").append(s).append(", is invalid").toString());
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Device type: ").append(s1).append(", is invalid").toString());
        }
        if (list == null)
        {
            throw new IllegalArgumentException("Artifact sources must not be null.");
        }
        if (list1 == null)
        {
            throw new IllegalArgumentException("Artifact processors must not be null.");
        }
        if (crashdescriptorstorageutil == null)
        {
            throw new IllegalArgumentException("CrashDescriptorStorageUtil must not be null.");
        }
        if (statusnotifier == null)
        {
            throw new IllegalArgumentException("StatusNotifier must not be null.");
        }
        if (requestsigner == null)
        {
            throw new IllegalArgumentException("RequestSigner must not be null.");
        }
        if (networkmanager == null)
        {
            throw new IllegalArgumentException("NetworkManager must not be null.");
        }
        mDetEndpointIdentity = endpointidentity;
        mDeviceType = s;
        mDeviceSerialNumber = s1;
        mArtifactSources = list;
        mArtifactProcessors = list1;
        mCrashDescriptorStorageUtil = crashdescriptorstorageutil;
        mStatusNotifier = statusnotifier;
        mRequestSigner = requestsigner;
        mNetworkManager = networkmanager;
        mAllowWANUpload = flag;
        if (mRequestSigner instanceof DcpRequestSigner)
        {
            mRequestContext = AccountRequestContext.EMPTY_ACCOUNT;
            return;
        } else
        {
            mRequestContext = null;
            return;
        }
    }

    private ArtifactProcessor chooseArtifactProcessor(Artifact artifact)
    {
        for (Iterator iterator = mArtifactProcessors.iterator(); iterator.hasNext();)
        {
            ArtifactProcessor artifactprocessor = (ArtifactProcessor)iterator.next();
            if (artifactprocessor != null && artifactprocessor.canProcessTag(artifact.getTag()))
            {
                return artifactprocessor;
            }
        }

        throw new IllegalStateException((new StringBuilder()).append("No artifact processor available for artifact. Tag:").append(artifact.getTag()).toString());
    }

    private String getExceptionMessage(Exception exception)
    {
        if (exception.getCause() == null)
        {
            return exception.getMessage();
        } else
        {
            return (new StringBuilder()).append(exception.getMessage()).append(" ").append(exception.getCause().getMessage()).toString();
        }
    }

    private byte[] processArtifact(Artifact artifact)
        throws Exception
    {
        return chooseArtifactProcessor(artifact).processArtifact(artifact);
    }

    protected ArtifactUploaderResult uploadArtifact(SrrManager srrmanager, MetricEvent metricevent, Artifact artifact, String s)
    {
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj = null;
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        log.debug("uploadArtifact", "About to upload artifact", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis()), "DeviceType", mDeviceType, "DeviceSerialNumber", mDeviceSerialNumber
        });
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        metricevent.incrementCounter("uploadAttempt", 1.0D);
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        Object obj5 = String.format("%s-%d", new Object[] {
            artifact.getTag(), Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        obj5 = mDetUtil.createDefaultHttpPost(((String) (obj5)), mDeviceType, mDeviceSerialNumber);
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        ((HttpPost) (obj5)).addHeader("X-Content-Type", "CrashReport");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        if (s.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        log.debug("uploadCrashEntry", "X-Upload-Tag", new Object[] {
            s
        });
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        ((HttpPost) (obj5)).addHeader("X-Upload-Tag", s);
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        byte abyte0[] = processArtifact(artifact);
        s1 = obj;
        s2 = obj1;
        s3 = obj2;
        s5 = obj3;
        s4 = obj4;
        s = artifact.getCrashDescriptor();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_644;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        if (!mCrashDescriptorStorageUtil.contains(s))
        {
            break MISSING_BLOCK_LABEL_644;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        if (!mCrashDescriptorStorageUtil.shouldDedupe(s).booleanValue())
        {
            break MISSING_BLOCK_LABEL_612;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        mCrashDescriptorStorageUtil.push(s);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        log.info("uploadCrashEntry", (new StringBuilder()).append("Duplicate CrashDescriptor found: ").append(s).toString(), new Object[0]);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        mCrashDescriptorStorageUtil.prune(s);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        ((HttpPost) (obj5)).setEntity(new ByteArrayEntity(abyte0));
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        metricevent.incrementCounter("uploadCrashSize", abyte0.length);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        metricevent.startTimer("uploadTime");
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        srrmanager = mDetUtil.postFileToDet(((HttpPost) (obj5)), srrmanager, mDetEndpointIdentity, mRequestContext);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[];
            static final int $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[];

            static 
            {
                $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse = new int[com.amazon.device.utils.DetUtil.DetResponse.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils.DetUtil.DetResponse.SUCCESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils.DetUtil.DetResponse.CLIENT_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils.DetUtil.DetResponse.SERVER_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus = new int[ArtifactUploadStatus.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.SUCCESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.SKIP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.RETRY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.device.utils.DetUtil.DetResponse[srrmanager.ordinal()];
        JVM INSTR tableswitch 1 3: default 1634
    //                   1 951
    //                   2 1027
    //                   3 1165;
           goto _L1 _L2 _L3 _L4
_L1:
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        log.error("uploadCrashEntries", "Unknown det response!", new Object[] {
            "DetReponse", srrmanager, "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
_L2:
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        mCrashDescriptorStorageUtil.push(s);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SUCCESS, s);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
_L3:
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        log.debug("uploadCrashEntries", "Client error on upload of artifact.", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        metricevent.incrementCounter("uploadFailed", 1.0D);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
_L4:
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        log.debug("uploadCrashEntries", "Server error on upload of artifact.", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        metricevent.incrementCounter("uploadFailed", 1.0D);
        s1 = s;
        s2 = s;
        s3 = s;
        s5 = s;
        s4 = s;
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "TimeoutException while uploading crashes.", new Object[] {
            srrmanager
        });
        metricevent.addCounter("uploadTimeoutException", 1.0D);
        srrmanager = getExceptionMessage(srrmanager);
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s1, "uploadTimeoutExceptionMessage", srrmanager);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "RequestFailedException while uploading crashes.", new Object[] {
            srrmanager.getCause()
        });
        metricevent.addCounter("uploadRequestFailedException", 1.0D);
        srrmanager = getExceptionMessage(srrmanager);
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s2, "uploadRequestFailedExceptionMessage", srrmanager);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "No Amazon account present, unable to upload crashes", new Object[] {
            srrmanager
        });
        metricevent.addCounter("uploadMissingCredentialsException", 1.0D);
        srrmanager = getExceptionMessage(srrmanager);
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s3, "uploadMissingCredentialsMessage", srrmanager);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.info("uploadCrashEntry", srrmanager.getMessage(), new Object[] {
            srrmanager
        });
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s5);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "Exception while uploading crashes", new Object[] {
            srrmanager
        });
        metricevent.incrementCounter("uploadFailed", 1.0D);
        metricevent.addCounter("uploadUnknowException", 1.0D);
        srrmanager = getExceptionMessage(srrmanager);
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s4, "uploadUnknownExceptionMessage", srrmanager);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        metricevent.stopTimer("uploadTime");
        throw srrmanager;
    }

    public int uploadArtifacts(MetricEvent metricevent)
    {
        return uploadArtifacts(metricevent, null);
    }

    public int uploadArtifacts(MetricEvent metricevent, String s)
    {
        if (mAllowWANUpload) goto _L2; else goto _L1
_L1:
        if (mNetworkManager.isWifiConnected() || mNetworkManager.isEthernetConnected()) goto _L4; else goto _L3
_L3:
        int i;
        log.info("uploadCrashes", "Skipping artifact upload because there is no usable connection.", new Object[0]);
        mStatusNotifier.broadcastUploadStatus("Device is not connected to WiFi or Ethernet and WAN upload is turned off.");
        metricevent.addCounter("noUsableConnection", 1.0D);
        i = 0;
_L16:
        return i;
_L2:
        if (mAllowWANUpload && !mNetworkManager.isWanConnected())
        {
            log.info("uploadCrashes", "Skipping artifact upload because WAN connection is not available.", new Object[0]);
            mStatusNotifier.broadcastUploadStatus("Upload through WAN is turned on but device is not connected to WAN");
            metricevent.addCounter("noUsableConnection", 1.0D);
            return 0;
        }
_L4:
        Object obj;
        Object obj1;
        AndroidHttpClient androidhttpclient;
        mStatusNotifier.broadcastUploadStatus("Uploading artifacts.");
        i = 0;
        log.verbose("uploadCrashEntries", "Uploading artifacts.", new Object[0]);
        obj1 = new HashSet();
        obj = new HashSet();
        androidhttpclient = AndroidHttpClient.newInstance("", null);
        HttpClientSrrManager httpclientsrrmanager;
        Iterator iterator;
        httpclientsrrmanager = new HttpClientSrrManager(androidhttpclient, mRequestSigner);
        iterator = mArtifactSources.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        ArtifactSource artifactsource = (ArtifactSource)iterator.next();
        int j = i;
_L9:
        Object obj2 = artifactsource.getNextArtifact(metricevent);
        i = j;
        if (obj2 == null) goto _L8; else goto _L7
_L7:
        ArtifactUploaderResult artifactuploaderresult;
        metricevent.incrementCounter("numArtifactsRead", 1.0D);
        artifactuploaderresult = uploadArtifact(httpclientsrrmanager, metricevent, ((Artifact) (obj2)), s);
        ((Artifact) (obj2)).close();
_L14:
        obj2 = artifactuploaderresult.getCrashDescriptor();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        ((Set) (obj1)).add(obj2);
        String s1;
        obj2 = artifactuploaderresult.mUploadErrorMessage;
        s1 = artifactuploaderresult.getUploadErrorTag();
        if (obj2 == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        ((Set) (obj)).add((new StringBuilder()).append(s1).append(".").append(((String) (obj2))).toString());
        _cls1..SwitchMap.com.amazon.device.crashmanager.ArtifactUploader.ArtifactUploadStatus[artifactuploaderresult.getArtifactUploadStatus().ordinal()];
        JVM INSTR tableswitch 1 3: default 1041
    //                   1 400
    //                   2 622
    //                   3 658;
           goto _L9 _L10 _L11 _L12
_L10:
        j++;
        artifactsource.saveCurrentIndex();
          goto _L9
        s;
        log.verbose("uploadArtifacts", "Exception thrown while uploading crash entries", new Object[] {
            s
        });
        mStatusNotifier.broadcastUploadStatus((new StringBuilder()).append("Exception while uploading artifacts:\n ").append(s.getMessage()).toString());
          goto _L13
        ioexception;
        log.warn("uploadCrashEntries", "Failed to close artifact.", new Object[] {
            ioexception
        });
          goto _L14
        s;
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.persistCrashDescriptors();
        new StringBuilder();
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); metricevent.addString("crashDescriptor", (String)((Iterator) (obj1)).next())) { }
        break; /* Loop/switch isn't completed */
_L11:
        log.info("uploadArtifacts", "Skipped an artifact.", new Object[0]);
        metricevent.incrementCounter("numArtifactsSkipped", 1.0D);
        artifactsource.saveCurrentIndex();
          goto _L9
_L12:
        log.info("uploadArtifacts", "Transient failure while uploading artifacts. Will retry later.", new Object[0]);
        metricevent.addCounter("partialUpload", 1.0D);
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.persistCrashDescriptors();
        new StringBuilder();
        for (s = ((Set) (obj1)).iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        s = ((Set) (obj)).iterator();
        do
        {
            i = j;
            if (!s.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            metricevent.addString("uploadExceptions", (String)s.next());
        } while (true);
_L13:
        j = 0;
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.persistCrashDescriptors();
        new StringBuilder();
        IOException ioexception;
        for (s = ((Set) (obj1)).iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        s = ((Set) (obj)).iterator();
        do
        {
            i = j;
            if (!s.hasNext())
            {
                break;
            }
            metricevent.addString("uploadExceptions", (String)s.next());
        } while (true);
        if (true) goto _L16; else goto _L15
_L15:
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); metricevent.addString("uploadExceptions", (String)((Iterator) (obj)).next())) { }
        throw s;
_L6:
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.persistCrashDescriptors();
        new StringBuilder();
        for (s = ((Set) (obj1)).iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        for (s = ((Set) (obj)).iterator(); s.hasNext(); metricevent.addString("uploadExceptions", (String)s.next())) { }
        log.info("uploadCrashEntries", (new StringBuilder()).append("Finished uploading artifacts. Uploaded ").append(i).append(" artifacts.").toString(), new Object[0]);
        mStatusNotifier.broadcastUploadStatus((new StringBuilder()).append("Uploaded ").append(i).append(" artifacts.").toString());
        return i;
    }

}

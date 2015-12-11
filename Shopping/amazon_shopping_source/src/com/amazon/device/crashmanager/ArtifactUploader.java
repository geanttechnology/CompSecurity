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
import java.util.Iterator;
import java.util.List;
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


    private static final DPLogger log = new DPLogger("ArtifactUploader");
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
            RequestSigner requestsigner, NetworkManager networkmanager)
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

    private void addExceptionMessageToMetricEvent(String s, MetricEvent metricevent, Exception exception)
    {
        if (exception.getCause() == null)
        {
            exception = exception.getMessage();
        } else
        {
            exception = (new StringBuilder()).append(exception.getMessage()).append(" ").append(exception.getCause().getMessage()).toString();
        }
        metricevent.addString(s, exception);
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

    private byte[] processArtifact(Artifact artifact)
        throws Exception
    {
        return chooseArtifactProcessor(artifact).processArtifact(artifact);
    }

    protected ArtifactUploadStatus uploadArtifact(SrrManager srrmanager, MetricEvent metricevent, Artifact artifact, String s)
    {
        Object obj;
        log.debug("uploadArtifact", "About to upload artifact", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis()), "DeviceType", mDeviceType, "DeviceSerialNumber", mDeviceSerialNumber
        });
        metricevent.incrementCounter("uploadAttempt", 1.0D);
        obj = String.format("%s-%d", new Object[] {
            artifact.getTag(), Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        obj = mDetUtil.createDefaultHttpPost(((String) (obj)), mDeviceType, mDeviceSerialNumber);
        ((HttpPost) (obj)).addHeader("X-Content-Type", "CrashReport");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        if (s.trim().length() > 0)
        {
            log.debug("uploadCrashEntry", "X-Upload-Tag", new Object[] {
                s
            });
            ((HttpPost) (obj)).addHeader("X-Upload-Tag", s);
        }
        byte abyte0[];
        abyte0 = processArtifact(artifact);
        s = artifact.getCrashDescriptor();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        metricevent.addString("crashDescriptor", artifact.getCrashDescriptor());
        if (!mCrashDescriptorStorageUtil.contains(s))
        {
            break MISSING_BLOCK_LABEL_302;
        }
        if (!mCrashDescriptorStorageUtil.shouldDedupe(s).booleanValue())
        {
            break MISSING_BLOCK_LABEL_292;
        }
        mCrashDescriptorStorageUtil.push(s);
        log.info("uploadCrashEntry", (new StringBuilder()).append("Duplicate CrashDescriptor found: ").append(s).toString(), new Object[0]);
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        mCrashDescriptorStorageUtil.prune(s);
        ((HttpPost) (obj)).setEntity(new ByteArrayEntity(abyte0));
        metricevent.incrementCounter("uploadCrashSize", abyte0.length);
        metricevent.startTimer("uploadTime");
        srrmanager = mDetUtil.postFileToDet(((HttpPost) (obj)), srrmanager, mDetEndpointIdentity, mRequestContext);
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
        JVM INSTR tableswitch 1 3: default 898
    //                   1 461
    //                   2 485
    //                   3 553;
           goto _L1 _L2 _L3 _L4
_L1:
        log.error("uploadCrashEntries", "Unknown det response!", new Object[] {
            "DetReponse", srrmanager, "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
_L2:
        mCrashDescriptorStorageUtil.push(s);
        srrmanager = ArtifactUploadStatus.SUCCESS;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
_L3:
        log.debug("uploadCrashEntries", "Client error on upload of artifact.", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        metricevent.incrementCounter("uploadFailed", 1.0D);
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
_L4:
        log.debug("uploadCrashEntries", "Server error on upload of artifact.", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        metricevent.incrementCounter("uploadFailed", 1.0D);
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "TimeoutException while uploading crashes.", new Object[] {
            srrmanager
        });
        metricevent.addCounter("uploadTimeoutException", 1.0D);
        addExceptionMessageToMetricEvent("uploadTimeoutExceptionMessage", metricevent, srrmanager);
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "RequestFailedException while uploading crashes.", new Object[] {
            srrmanager.getCause()
        });
        metricevent.addCounter("uploadRequestFailedException", 1.0D);
        addExceptionMessageToMetricEvent("uploadRequestFailedExceptionMessage", metricevent, srrmanager);
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "No Amazon account present, unable to upload crashes", new Object[] {
            srrmanager
        });
        metricevent.addCounter("uploadMissingCredentialsException", 1.0D);
        addExceptionMessageToMetricEvent("uploadMissingCredentialsMessage", metricevent, srrmanager);
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.info("uploadCrashEntry", srrmanager.getMessage(), new Object[] {
            srrmanager
        });
        srrmanager = ArtifactUploadStatus.SKIP;
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "Exception while uploading crashes", new Object[] {
            srrmanager
        });
        metricevent.incrementCounter("uploadFailed", 1.0D);
        metricevent.addCounter("uploadUnknowException", 1.0D);
        addExceptionMessageToMetricEvent("uploadUnknownExceptionMessage", metricevent, srrmanager);
        srrmanager = ArtifactUploadStatus.SKIP;
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
        AndroidHttpClient androidhttpclient;
        int i;
        if (!mNetworkManager.isWifiConnected() && !mNetworkManager.isEthernetConnected())
        {
            log.info("uploadCrashes", "Skipping artifact upload because there is no usable connection.", new Object[0]);
            mStatusNotifier.broadcastUploadStatus("Device is not connected to WiFi or Ethernet.");
            return 0;
        }
        mStatusNotifier.broadcastUploadStatus("Uploading artifacts.");
        i = 0;
        log.verbose("uploadCrashEntries", "Uploading artifacts.", new Object[0]);
        androidhttpclient = AndroidHttpClient.newInstance("", null);
        HttpClientSrrManager httpclientsrrmanager;
        Iterator iterator;
        httpclientsrrmanager = new HttpClientSrrManager(androidhttpclient, mRequestSigner);
        iterator = mArtifactSources.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ArtifactSource artifactsource = (ArtifactSource)iterator.next();
        int j = i;
_L5:
        Artifact artifact = artifactsource.getNextArtifact(metricevent);
        i = j;
        if (artifact == null) goto _L4; else goto _L3
_L3:
        ArtifactUploadStatus artifactuploadstatus = uploadArtifact(httpclientsrrmanager, metricevent, artifact, s);
        artifact.close();
_L9:
        _cls1..SwitchMap.com.amazon.device.crashmanager.ArtifactUploader.ArtifactUploadStatus[artifactuploadstatus.ordinal()];
        JVM INSTR tableswitch 1 3: default 480
    //                   1 212
    //                   2 334
    //                   3 360;
           goto _L5 _L6 _L7 _L8
_L6:
        j++;
        artifactsource.saveCurrentIndex();
          goto _L5
        metricevent;
        log.verbose("uploadArtifacts", "Exception thrown while uploading crash entries", new Object[] {
            metricevent
        });
        mStatusNotifier.broadcastUploadStatus((new StringBuilder()).append("Exception while uploading artifacts:\n ").append(metricevent.getMessage()).toString());
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.saveToSharedPreferences();
        return 0;
        IOException ioexception;
        ioexception;
        log.warn("uploadCrashEntries", "Failed to close artifact.", new Object[] {
            ioexception
        });
          goto _L9
        metricevent;
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.saveToSharedPreferences();
        throw metricevent;
_L7:
        log.info("uploadArtifacts", "Skipped an artifact.", new Object[0]);
        artifactsource.saveCurrentIndex();
          goto _L5
_L8:
        log.info("uploadArtifacts", "Transient failure while uploading artifacts. Will retry later.", new Object[0]);
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.saveToSharedPreferences();
        return j;
_L2:
        androidhttpclient.close();
        mCrashDescriptorStorageUtil.saveToSharedPreferences();
        log.info("uploadCrashEntries", (new StringBuilder()).append("Finished uploading artifacts. Uploaded ").append(i).append(" artifacts.").toString(), new Object[0]);
        mStatusNotifier.broadcastUploadStatus((new StringBuilder()).append("Uploaded ").append(i).append(" artifacts.").toString());
        return i;
    }

}

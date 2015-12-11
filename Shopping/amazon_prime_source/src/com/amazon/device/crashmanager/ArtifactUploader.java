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
import com.amazon.device.crashmanager.processor.ArtifactProcessor;
import com.amazon.device.crashmanager.source.ArtifactSource;
import com.amazon.device.crashmanager.source.DropBoxArtifactSource;
import com.amazon.device.crashmanager.utils.CrashDescriptorDedupeUtil;
import com.amazon.device.utils.DetUtil;
import com.amazon.device.utils.NetworkManager;
import com.amazon.device.utils.StatusNotifier;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;

// Referenced classes of package com.amazon.device.crashmanager:
//            Artifact

class ArtifactUploader
{
    private static final class ArtifactUploadStatus extends Enum
    {

        private static final ArtifactUploadStatus $VALUES[];
        public static final ArtifactUploadStatus DE_DUPED;
        public static final ArtifactUploadStatus FAILED;
        public static final ArtifactUploadStatus SERVER_ERROR;
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
            DE_DUPED = new ArtifactUploadStatus("DE_DUPED", 1);
            SKIP = new ArtifactUploadStatus("SKIP", 2);
            FAILED = new ArtifactUploadStatus("FAILED", 3);
            SERVER_ERROR = new ArtifactUploadStatus("SERVER_ERROR", 4);
            $VALUES = (new ArtifactUploadStatus[] {
                SUCCESS, DE_DUPED, SKIP, FAILED, SERVER_ERROR
            });
        }

        private ArtifactUploadStatus(String s, int i)
        {
            super(s, i);
        }
    }

    private class ArtifactUploaderResult
    {

        private final ArtifactUploadStatus mArtifactUploadStatus;
        private final String mCrashDescriptor;
        private final String mUploadErrorMessage;
        private final String mUploadErrorTag;
        final ArtifactUploader this$0;

        public ArtifactUploadStatus getArtifactUploadStatus()
        {
            return mArtifactUploadStatus;
        }

        public String getCrashDescriptor()
        {
            return mCrashDescriptor;
        }

        public String getUploadErrorMessage()
        {
            return mUploadErrorMessage;
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

    public class CrashUploadStatistics
    {

        private final CrashUploadStatus mCrashUploadStatus;
        private final int mNumArtifactsFailed;
        private final int mNumArtifactsUploaded;
        final ArtifactUploader this$0;

        public CrashUploadStatus getCrashUploadStatus()
        {
            return mCrashUploadStatus;
        }

        public int getNumArtifactsFailed()
        {
            return mNumArtifactsFailed;
        }

        public int getNumArtifactsUploaded()
        {
            return mNumArtifactsUploaded;
        }

        public CrashUploadStatistics(CrashUploadStatus crashuploadstatus)
        {
            this(crashuploadstatus, 0, 0);
        }

        public CrashUploadStatistics(CrashUploadStatus crashuploadstatus, int i, int j)
        {
            this$0 = ArtifactUploader.this;
            super();
            mCrashUploadStatus = crashuploadstatus;
            mNumArtifactsUploaded = i;
            mNumArtifactsFailed = j;
        }
    }

    public static final class CrashUploadStatus extends Enum
    {

        private static final CrashUploadStatus $VALUES[];
        public static final CrashUploadStatus FAILURE;
        public static final CrashUploadStatus SERVER_ERROR;
        public static final CrashUploadStatus SUCCESS;

        public static CrashUploadStatus valueOf(String s)
        {
            return (CrashUploadStatus)Enum.valueOf(com/amazon/device/crashmanager/ArtifactUploader$CrashUploadStatus, s);
        }

        public static CrashUploadStatus[] values()
        {
            return (CrashUploadStatus[])$VALUES.clone();
        }

        static 
        {
            SUCCESS = new CrashUploadStatus("SUCCESS", 0);
            FAILURE = new CrashUploadStatus("FAILURE", 1);
            SERVER_ERROR = new CrashUploadStatus("SERVER_ERROR", 2);
            $VALUES = (new CrashUploadStatus[] {
                SUCCESS, FAILURE, SERVER_ERROR
            });
        }

        private CrashUploadStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private static final DPLogger log = new DPLogger("ArtifactUploader");
    private final boolean mAllowWANUpload;
    private final List mArtifactProcessors;
    private final List mArtifactSources;
    private final CrashDescriptorDedupeUtil mCrashDescriptorDedupeUtil;
    private final EndpointIdentity mDetEndpointIdentity;
    protected DetUtil mDetUtil;
    private final String mDeviceSerialNumber;
    private final String mDeviceType;
    private final NetworkManager mNetworkManager;
    private final RequestContext mRequestContext;
    private final RequestSigner mRequestSigner;
    private final StatusNotifier mStatusNotifier;

    public ArtifactUploader(EndpointIdentity endpointidentity, String s, String s1, List list, List list1, CrashDescriptorDedupeUtil crashdescriptordedupeutil, StatusNotifier statusnotifier, 
            RequestSigner requestsigner, NetworkManager networkmanager, boolean flag, DetUtil detutil)
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
        if (crashdescriptordedupeutil == null)
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
        mCrashDescriptorDedupeUtil = crashdescriptordedupeutil;
        mStatusNotifier = statusnotifier;
        mRequestSigner = requestsigner;
        mNetworkManager = networkmanager;
        mAllowWANUpload = flag;
        mDetUtil = detutil;
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

    private void buildDedupeMapFromDropbox(DropBoxArtifactSource dropboxartifactsource, MetricEvent metricevent)
    {
        log.info("buildDedupeMapFromDropbox", "Starting to build descriptor dedupe map", new Object[0]);
        metricevent.startTimer("buildCrashDescriptorCounterMappingTime");
        do
        {
            Artifact artifact = dropboxartifactsource.getNextArtifact(metricevent, "BUILD_MAP");
            if (artifact != null)
            {
                try
                {
                    processArtifact(artifact);
                    artifact.close();
                }
                catch (IOException ioexception)
                {
                    log.warn("buildDedupeMapFromDropbox", "Failed to close artifact.", new Object[] {
                        ioexception
                    });
                }
                catch (Exception exception)
                {
                    log.warn("buildDedupeMapFromDropbox", "Exception thrown when process artifact.", new Object[] {
                        exception
                    });
                }
                mCrashDescriptorDedupeUtil.increaseCounter(artifact.getCrashDescriptor());
            } else
            {
                dropboxartifactsource.saveBuildMapIndex();
                mCrashDescriptorDedupeUtil.persistCrashDescriptors();
                metricevent.stopTimer("buildCrashDescriptorCounterMappingTime");
                log.info("buildDedupeMapFromDropbox", "Finish building descriptor dedupe map", new Object[0]);
                return;
            }
        } while (true);
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

    private InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return chooseArtifactProcessor(artifact).processArtifact(artifact);
    }

    private ArtifactUploaderResult uploadArtifactWithRetries(SrrManager srrmanager, MetricEvent metricevent, Artifact artifact, String s, String s1, HttpPost httppost)
    {
        String s2;
        Object obj1;
        int i;
        long l;
        obj1 = null;
        s2 = null;
        l = 500L;
        s = null;
        i = 0;
_L11:
        if (i >= 5) goto _L2; else goto _L1
_L1:
        long l1 = l;
        if (i <= 0) goto _L4; else goto _L3
_L3:
        Object obj;
        String s3;
        String s4;
        long l2;
        long l3;
        long l4;
        l2 = l;
        obj = s;
        l3 = l;
        s3 = s;
        l4 = l;
        s4 = s;
        Thread.sleep(l);
_L10:
        l1 = l * 2L;
_L4:
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        s = mDetUtil.postFileToDet(httppost, srrmanager, mDetEndpointIdentity, mRequestContext);
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
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
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils.DetUtil.DetResponse.CLIENT_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils.DetUtil.DetResponse.SERVER_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus = new int[ArtifactUploadStatus.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.SUCCESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.SKIP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.DE_DUPED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.FAILED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[ArtifactUploadStatus.SERVER_ERROR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.device.utils.DetUtil.DetResponse[s.ordinal()];
        JVM INSTR tableswitch 1 3: default 946
    //                   1 407
    //                   2 542
    //                   3 744;
           goto _L5 _L6 _L7 _L8
_L5:
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        log.error("uploadCrashEntries", "Unknown det response!", new Object[] {
            "DetReponse", s, "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        try
        {
            return new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("uploadCrashEntry", "TimeoutException while uploading crashes.", new Object[] {
                s
            });
            metricevent.addCounter("uploadTimeoutException", 1.0D);
            s2 = getExceptionMessage(s);
            s3 = "uploadTimeoutExceptionMessage";
            s = ((String) (obj));
            l = l2;
            obj = s3;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("uploadCrashEntry", "RequestFailedException while uploading crashes.", new Object[] {
                s.getCause()
            });
            metricevent.addCounter("uploadRequestFailedException", 1.0D);
            s2 = getExceptionMessage(s);
            obj = "uploadRequestFailedExceptionMessage";
            l = l3;
            s = s3;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("uploadCrashEntry", "No Amazon account present, unable to upload crashes", new Object[] {
                s
            });
            metricevent.addCounter("uploadMissingCredentialsException", 1.0D);
            s2 = getExceptionMessage(s);
            obj = "uploadMissingCredentialsMessage";
            l = l4;
            s = s4;
        }
        // Misplaced declaration of an exception variable
        catch (SrrManager srrmanager)
        {
            log.error("uploadCrashEntry", "Exception while uploading crashes", new Object[] {
                srrmanager
            });
            metricevent.incrementCounter("uploadFailed", 1.0D);
            metricevent.addCounter("uploadUnknowException", 1.0D);
            srrmanager = getExceptionMessage(srrmanager);
            return new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s1, "uploadUnknownExceptionMessage", srrmanager);
        }
        break; /* Loop/switch isn't completed */
        obj;
        l2 = l;
        obj = s;
        l3 = l;
        s3 = s;
        l4 = l;
        s4 = s;
        log.info("uploadArtifact", "Interrupted while uploading", new Object[0]);
        if (true) goto _L10; else goto _L9
_L9:
        i++;
        obj1 = obj;
          goto _L11
_L6:
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        mCrashDescriptorDedupeUtil.prune(s1);
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        s = new ArtifactUploaderResult(ArtifactUploadStatus.SUCCESS, s1);
        return s;
_L7:
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        log.debug("uploadCrashEntries", "Client error on upload of artifact.", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        metricevent.incrementCounter("uploadFailed", 1.0D);
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        s = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s1);
        return s;
_L8:
        l2 = l1;
        obj = s;
        l3 = l1;
        s3 = s;
        l4 = l1;
        s4 = s;
        log.debug("uploadCrashEntries", "Server error on upload of artifact.", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        obj = obj1;
        l = l1;
          goto _L9
_L2:
        metricevent.incrementCounter("uploadFailed", 1.0D);
        if (com.amazon.device.utils.DetUtil.DetResponse.SERVER_ERROR.equals(s))
        {
            return new ArtifactUploaderResult(ArtifactUploadStatus.SERVER_ERROR, s1, ((String) (obj1)), s2);
        } else
        {
            return new ArtifactUploaderResult(ArtifactUploadStatus.FAILED, s1, ((String) (obj1)), s2);
        }
    }

    protected ArtifactUploaderResult uploadArtifact(SrrManager srrmanager, MetricEvent metricevent, Artifact artifact, String s)
    {
        String s1;
        String s2;
        String s3;
        Object obj;
        obj = null;
        s3 = null;
        s2 = s3;
        s1 = obj;
        log.debug("uploadArtifact", "About to upload artifact", new Object[] {
            "Tag", artifact.getTag(), "Creation time UTC", Long.valueOf(artifact.getCreationTimeUTCMillis()), "DeviceType", mDeviceType, "DeviceSerialNumber", mDeviceSerialNumber
        });
        s2 = s3;
        s1 = obj;
        metricevent.incrementCounter("uploadAttempt", 1.0D);
        s2 = s3;
        s1 = obj;
        Object obj1 = String.format("%s-%d", new Object[] {
            artifact.getTag(), Long.valueOf(artifact.getCreationTimeUTCMillis())
        });
        s2 = s3;
        s1 = obj;
        obj1 = mDetUtil.createDefaultHttpPost(((String) (obj1)), mDeviceType, mDeviceSerialNumber);
        s2 = s3;
        s1 = obj;
        ((HttpPost) (obj1)).addHeader("X-Content-Type", "CrashReport");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        s2 = s3;
        s1 = obj;
        if (s.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        s2 = s3;
        s1 = obj;
        log.debug("uploadCrashEntry", "X-Upload-Tag", new Object[] {
            s
        });
        s2 = s3;
        s1 = obj;
        ((HttpPost) (obj1)).addHeader("X-Upload-Tag", s);
        s2 = s3;
        s1 = obj;
        InputStream inputstream = processArtifact(artifact);
        s2 = s3;
        s1 = obj;
        s3 = artifact.getCrashDescriptor();
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        s2 = s3;
        s1 = s3;
        if (mCrashDescriptorDedupeUtil.contains(s3))
        {
            break MISSING_BLOCK_LABEL_395;
        }
        s2 = s3;
        s1 = s3;
        log.debug("uploadCrashEntry", (new StringBuilder()).append("CrashDescriptor: ").append(s3).append(" not found in SharedPreferences, skipping.").toString(), new Object[0]);
        s2 = s3;
        s1 = s3;
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.DE_DUPED, s3);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        s2 = s3;
        s1 = s3;
        ((HttpPost) (obj1)).setEntity(new InputStreamEntity(inputstream, inputstream.available()));
        s2 = s3;
        s1 = s3;
        metricevent.incrementCounter("uploadCrashSize", inputstream.available());
        s2 = s3;
        s1 = s3;
        metricevent.startTimer("uploadTime");
        s2 = s3;
        s1 = s3;
        srrmanager = uploadArtifactWithRetries(srrmanager, metricevent, artifact, s, s3, ((HttpPost) (obj1)));
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.info("uploadCrashEntry", srrmanager.getMessage(), new Object[] {
            srrmanager
        });
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s2);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        log.error("uploadCrashEntry", "Exception while uploading crashes", new Object[] {
            srrmanager
        });
        metricevent.incrementCounter("uploadFailed", 1.0D);
        metricevent.addCounter("uploadUnknowException", 1.0D);
        srrmanager = getExceptionMessage(srrmanager);
        srrmanager = new ArtifactUploaderResult(ArtifactUploadStatus.SKIP, s1, "uploadUnknownExceptionMessage", srrmanager);
        metricevent.stopTimer("uploadTime");
        return srrmanager;
        srrmanager;
        metricevent.stopTimer("uploadTime");
        throw srrmanager;
    }

    public CrashUploadStatistics uploadArtifacts(MetricEvent metricevent)
    {
        return uploadArtifacts(metricevent, null);
    }

    public CrashUploadStatistics uploadArtifacts(MetricEvent metricevent, String s)
    {
        if (!mAllowWANUpload) goto _L2; else goto _L1
_L1:
        if (mNetworkManager.isConnected()) goto _L4; else goto _L3
_L3:
        log.info("uploadCrashes", "Cannot upload crashes since device not connected to a network", new Object[0]);
        mStatusNotifier.broadcastUploadStatus("Cannot upload crashes due to no connectivity");
        metricevent.addCounter("noUsableConnection", 1.0D);
        s = new CrashUploadStatistics(CrashUploadStatus.FAILURE, 0, 0);
_L18:
        return s;
_L2:
        if (!mNetworkManager.isWifiConnected() && !mNetworkManager.isEthernetConnected())
        {
            log.info("uploadCrashes", "Cannot upload crashes since device is not connected to wifi or ethernet.", new Object[0]);
            mStatusNotifier.broadcastUploadStatus("Cannot upload crashes due to no usable connection");
            metricevent.addCounter("noUsableConnection", 1.0D);
            return new CrashUploadStatistics(CrashUploadStatus.FAILURE, 0, 0);
        }
_L4:
        Object obj1;
        HashSet hashset;
        AndroidHttpClient androidhttpclient;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        mStatusNotifier.broadcastUploadStatus("Uploading artifacts.");
        log.debug("uploadCrashEntries", "Uploading artifacts.", new Object[0]);
        hashset = new HashSet();
        obj1 = new HashSet();
        l = 0;
        k = 0;
        i1 = 0;
        j1 = 0;
        androidhttpclient = AndroidHttpClient.newInstance("", null);
        i = i1;
        j = l;
        Object obj = new HttpClientSrrManager(androidhttpclient, mRequestSigner);
        i = i1;
        j = l;
        Iterator iterator1 = mArtifactSources.iterator();
_L8:
        i = j1;
        j = k;
        if (!iterator1.hasNext()) goto _L6; else goto _L5
_L5:
        i = j1;
        j = k;
        ArtifactSource artifactsource = (ArtifactSource)iterator1.next();
        l = j1;
        i1 = k;
        i = j1;
        j = k;
        if (!(artifactsource instanceof DropBoxArtifactSource))
        {
            break MISSING_BLOCK_LABEL_339;
        }
        i = j1;
        j = k;
        buildDedupeMapFromDropbox((DropBoxArtifactSource)artifactsource, metricevent);
        i1 = k;
        l = j1;
_L9:
        i = l;
        j = i1;
        Artifact artifact = artifactsource.getNextArtifact(metricevent, "ARTIFACT_UPLOAD");
        j1 = l;
        k = i1;
        if (artifact == null) goto _L8; else goto _L7
_L7:
        i = l;
        j = i1;
        metricevent.incrementCounter("numArtifactsRead", 1.0D);
        i = l;
        j = i1;
        ArtifactUploaderResult artifactuploaderresult = uploadArtifact(((SrrManager) (obj)), metricevent, artifact, s);
        i = l;
        j = i1;
        artifact.close();
_L16:
        i = l;
        j = i1;
        String s1 = artifactuploaderresult.getCrashDescriptor();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        i = l;
        j = i1;
        hashset.add(s1);
        i = l;
        j = i1;
        s1 = artifactuploaderresult.mUploadErrorMessage;
        i = l;
        j = i1;
        String s2 = artifactuploaderresult.getUploadErrorTag();
        if (s1 == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_543;
        }
        i = l;
        j = i1;
        ((Set) (obj1)).add((new StringBuilder()).append(s2).append(".").append(s1).toString());
        i = l;
        j = i1;
        _cls1..SwitchMap.com.amazon.device.crashmanager.ArtifactUploader.ArtifactUploadStatus[artifactuploaderresult.getArtifactUploadStatus().ordinal()];
        JVM INSTR tableswitch 1 5: default 1587
    //                   1 596
    //                   2 906
    //                   3 972
    //                   4 1032
    //                   5 1174;
           goto _L9 _L10 _L11 _L12 _L13 _L14
_L10:
        i1++;
        i = l;
        j = i1;
        log.info("uploadArtifacts", "Uploaded an artifact.", new Object[0]);
        i = l;
        j = i1;
        metricevent.addCounter("numArtifactsUploaded", 1.0D);
        i = l;
        j = i1;
        metricevent.addCounter((new StringBuilder()).append(artifact.getTag()).append(".SUCCESS").toString(), 1.0D);
        i = l;
        j = i1;
        artifactsource.saveCurrentIndex();
          goto _L9
        s;
        log.verbose("uploadArtifacts", "Exception thrown while uploading crash entries", new Object[] {
            s
        });
        mStatusNotifier.broadcastUploadStatus((new StringBuilder()).append("Exception while uploading artifacts:\n ").append(s.getMessage()).toString());
        obj = new CrashUploadStatistics(CrashUploadStatus.FAILURE, j, i);
          goto _L15
        ioexception;
        i = l;
        j = i1;
        log.warn("uploadCrashEntries", "Failed to close artifact.", new Object[] {
            ioexception
        });
          goto _L16
        s;
        androidhttpclient.close();
        new StringBuilder();
        for (obj = hashset.iterator(); ((Iterator) (obj)).hasNext(); metricevent.addString("crashDescriptor", (String)((Iterator) (obj)).next())) { }
        break; /* Loop/switch isn't completed */
_L11:
        l++;
        i = l;
        j = i1;
        log.info("uploadArtifacts", "Skipped an artifact due to client error", new Object[0]);
        i = l;
        j = i1;
        metricevent.incrementCounter("numArtifactsFailed", 1.0D);
        i = l;
        j = i1;
        artifactsource.saveCurrentIndex();
          goto _L9
_L12:
        i = l;
        j = i1;
        log.info("uploadArtifacts", "Skipped an artifact since this is a dupe and original artifact already uploaded", new Object[0]);
        i = l;
        j = i1;
        metricevent.addCounter("numArtifactsSkipped", 1.0D);
        i = l;
        j = i1;
        artifactsource.saveCurrentIndex();
          goto _L9
_L13:
        i = l;
        j = i1;
        log.info("uploadArtifacts", "Failed to upload artifact after local retries. CrashUpload will halt now and will be retried later", new Object[0]);
        i = l;
        j = i1;
        obj = new CrashUploadStatistics(CrashUploadStatus.FAILURE, i1, l);
        androidhttpclient.close();
        new StringBuilder();
        for (s = hashset.iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        obj1 = ((Set) (obj1)).iterator();
        do
        {
            s = ((String) (obj));
            if (!((Iterator) (obj1)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            metricevent.addString("uploadExceptions", (String)((Iterator) (obj1)).next());
        } while (true);
_L14:
        i = l;
        j = i1;
        log.info("uploadArtifacts", "Receiving consistent 500's from Server. CrashUpload will halt now and will be retried later", new Object[0]);
        i = l;
        j = i1;
        obj = new CrashUploadStatistics(CrashUploadStatus.SERVER_ERROR, i1, l);
        androidhttpclient.close();
        new StringBuilder();
        for (s = hashset.iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        obj1 = ((Set) (obj1)).iterator();
        do
        {
            s = ((String) (obj));
            if (!((Iterator) (obj1)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            metricevent.addString("uploadExceptions", (String)((Iterator) (obj1)).next());
        } while (true);
_L15:
        androidhttpclient.close();
        new StringBuilder();
        IOException ioexception;
        for (s = hashset.iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        obj1 = ((Set) (obj1)).iterator();
        do
        {
            s = ((String) (obj));
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            metricevent.addString("uploadExceptions", (String)((Iterator) (obj1)).next());
        } while (true);
        if (true) goto _L18; else goto _L17
_L17:
        for (Iterator iterator = ((Set) (obj1)).iterator(); iterator.hasNext(); metricevent.addString("uploadExceptions", (String)iterator.next())) { }
        throw s;
_L6:
        androidhttpclient.close();
        new StringBuilder();
        for (s = hashset.iterator(); s.hasNext(); metricevent.addString("crashDescriptor", (String)s.next())) { }
        for (s = ((Set) (obj1)).iterator(); s.hasNext(); metricevent.addString("uploadExceptions", (String)s.next())) { }
        log.info("uploadCrashEntries", (new StringBuilder()).append("Finished uploading artifacts. Uploaded ").append(k).append(" artifacts.").toString(), new Object[0]);
        mStatusNotifier.broadcastUploadStatus((new StringBuilder()).append("Uploaded ").append(k).append(" artifacts.").toString());
        mCrashDescriptorDedupeUtil.clearAll();
        return new CrashUploadStatistics(CrashUploadStatus.SUCCESS, k, j1);
    }

}

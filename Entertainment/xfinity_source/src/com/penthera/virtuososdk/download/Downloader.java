// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.interfaces.toolkit.VirtuosoContentBox;
import com.penthera.virtuososdk.internal.interfaces.IEngFileFragment;
import com.penthera.virtuososdk.internal.interfaces.IEngVFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVIdentifier;
import com.penthera.virtuososdk.monitor.BatteryMonitor;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.penthera.virtuososdk.download:
//            VirtuosoDownloadEngineStatus, MD5

public final class Downloader
    implements com.penthera.virtuososdk.monitor.BatteryMonitor.IBatteryObserver, com.penthera.virtuososdk.monitor.ConnectivityMonitor.IOnConnectivityChangeObserver
{
    private class DownloadInfo
    {

        boolean iBytesDownloaded;
        int iDownloadExceptions;
        boolean iDownloading;
        long iLastBytesRead;
        final Downloader this$0;

        private DownloadInfo()
        {
            this$0 = Downloader.this;
            super();
            iDownloading = false;
            iBytesDownloaded = false;
            iLastBytesRead = 0L;
            iDownloadExceptions = 0;
        }

        DownloadInfo(DownloadInfo downloadinfo)
        {
            this();
        }
    }

    static interface DownloadQuotaProvider
    {

        public abstract double getAllowedCellQuota(Downloader downloader);

        public abstract double getAllowedStorageQuota(Downloader downloader);
    }

    public class DownloadStop
    {

        EDownloadPermission iPermission;
        EStopReason iReason;
        private boolean iStopDownload;
        final Downloader this$0;

        void clear()
        {
            this;
            JVM INSTR monitorenter ;
            iStopDownload = false;
            iPermission = EDownloadPermission.EDownloadAllowed;
            iReason = EStopReason.ENone;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean isSet()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = iDownloadStop.iStopDownload;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        public void stop(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            iDownloadStop.iStopDownload = flag;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public DownloadStop()
        {
            this$0 = Downloader.this;
            super();
            iStopDownload = false;
            iPermission = EDownloadPermission.EDownloadAllowed;
            iReason = EStopReason.ENone;
        }
    }

    static interface DownloaderObserver
    {

        public abstract void downloadUpdate(Downloader downloader, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable);

        public abstract void fragmentsComplete(Downloader downloader, Bundle bundle);

        public abstract void hdsProgressUpdate(Downloader downloader, Bundle bundle);

        public abstract void quotaUpdate(Downloader downloader, Bundle bundle);

        public abstract void saveFileState(Downloader downloader, Bundle bundle);
    }

    public static final class EDownloadPermission extends Enum
    {

        public static final EDownloadPermission EDownloadAllowed;
        public static final EDownloadPermission EDownloadBlockedAuthentication;
        public static final EDownloadPermission EDownloadBlockedBattery;
        public static final EDownloadPermission EDownloadBlockedCell;
        public static final EDownloadPermission EDownloadBlockedHeadroom;
        public static final EDownloadPermission EDownloadBlockedPaused;
        public static final EDownloadPermission EDownloadBlockedStorage;
        public static final EDownloadPermission EDownloadBlockedWifi;
        private static final EDownloadPermission ENUM$VALUES[];

        public static EDownloadPermission valueOf(String s)
        {
            return (EDownloadPermission)Enum.valueOf(com/penthera/virtuososdk/download/Downloader$EDownloadPermission, s);
        }

        public static EDownloadPermission[] values()
        {
            EDownloadPermission aedownloadpermission[] = ENUM$VALUES;
            int i = aedownloadpermission.length;
            EDownloadPermission aedownloadpermission1[] = new EDownloadPermission[i];
            System.arraycopy(aedownloadpermission, 0, aedownloadpermission1, 0, i);
            return aedownloadpermission1;
        }

        static 
        {
            EDownloadAllowed = new EDownloadPermission("EDownloadAllowed", 0);
            EDownloadBlockedCell = new EDownloadPermission("EDownloadBlockedCell", 1);
            EDownloadBlockedBattery = new EDownloadPermission("EDownloadBlockedBattery", 2);
            EDownloadBlockedHeadroom = new EDownloadPermission("EDownloadBlockedHeadroom", 3);
            EDownloadBlockedStorage = new EDownloadPermission("EDownloadBlockedStorage", 4);
            EDownloadBlockedPaused = new EDownloadPermission("EDownloadBlockedPaused", 5);
            EDownloadBlockedAuthentication = new EDownloadPermission("EDownloadBlockedAuthentication", 6);
            EDownloadBlockedWifi = new EDownloadPermission("EDownloadBlockedWifi", 7);
            ENUM$VALUES = (new EDownloadPermission[] {
                EDownloadAllowed, EDownloadBlockedCell, EDownloadBlockedBattery, EDownloadBlockedHeadroom, EDownloadBlockedStorage, EDownloadBlockedPaused, EDownloadBlockedAuthentication, EDownloadBlockedWifi
            });
        }

        private EDownloadPermission(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EStopReason extends Enum
    {

        public static final EStopReason EBlocked;
        public static final EStopReason EFileExpired;
        public static final EStopReason EFileRemoved;
        private static final EStopReason ENUM$VALUES[];
        public static final EStopReason ENone;
        public static final EStopReason EPriorityChange;

        public static EStopReason valueOf(String s)
        {
            return (EStopReason)Enum.valueOf(com/penthera/virtuososdk/download/Downloader$EStopReason, s);
        }

        public static EStopReason[] values()
        {
            EStopReason aestopreason[] = ENUM$VALUES;
            int i = aestopreason.length;
            EStopReason aestopreason1[] = new EStopReason[i];
            System.arraycopy(aestopreason, 0, aestopreason1, 0, i);
            return aestopreason1;
        }

        static 
        {
            ENone = new EStopReason("ENone", 0);
            EBlocked = new EStopReason("EBlocked", 1);
            EPriorityChange = new EStopReason("EPriorityChange", 2);
            EFileRemoved = new EStopReason("EFileRemoved", 3);
            EFileExpired = new EStopReason("EFileExpired", 4);
            ENUM$VALUES = (new EStopReason[] {
                ENone, EBlocked, EPriorityChange, EFileRemoved, EFileExpired
            });
        }

        private EStopReason(String s, int i)
        {
            super(s, i);
        }
    }

    class Throughput
    {

        private double byteCount;
        private long interFrom;
        private long interval;
        final Downloader this$0;

        public double mbs()
        {
            if (interval > 0L)
            {
                return byteCount / 131072D / (double)interval;
            } else
            {
                return 0.0D;
            }
        }

        public void reset()
        {
            interval = 0L;
            byteCount = 0.0D;
        }

        public void signalStart()
        {
            interFrom = (new Date()).getTime() / 1000L;
        }

        public void update(long l)
        {
            long l1 = (new Date()).getTime() / 1000L;
            interval = interval + (l1 - interFrom);
            byteCount = byteCount + (double)l;
            interFrom = l1;
        }

        Throughput()
        {
            this$0 = Downloader.this;
            super();
            byteCount = 0.0D;
            interval = 0L;
            interFrom = 0L;
        }
    }

    private class VirtuosoDownloadThread extends Thread
    {

        private static int $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission[];
        private static int $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion[];
        private HttpClient client;
        private Object completionLock;
        private String iDiscoveredContentType;
        private long iDownloadStartTime;
        private IVirtuosoAsset iFile;
        private boolean iHlsReportedComplete;
        private long iLastUpdateTime;
        private long iMinimumUpdateInterval;
        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion killCode;
        private boolean killed;
        private Object mHlsLock;
        private boolean pauseAfterRemove;
        private boolean removeAfterPause;
        final Downloader this$0;

        static int[] $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()
        {
            int ai[] = $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission;
            if (ai != null)
            {
                return ai;
            }
            ai = new int[EDownloadPermission.values().length];
            try
            {
                ai[EDownloadPermission.EDownloadAllowed.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedAuthentication.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedBattery.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedCell.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedHeadroom.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedPaused.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedStorage.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai[EDownloadPermission.EDownloadBlockedWifi.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission = ai;
            return ai;
        }

        static int[] $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()
        {
            int ai[] = $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion;
            if (ai != null)
            {
                return ai;
            }
            ai = new int[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.values().length];
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedAuthentication.ordinal()] = 19;
            }
            catch (NoSuchFieldError nosuchfielderror19) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedBattery.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror18) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedCell.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror17) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorExpired.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror16) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFile.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror15) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileCorrupt.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorsMaxed.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedHeadroom.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedPaused.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedStorage.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedUnknown.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileExpired.ordinal()] = 18;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved.ordinal()] = 17;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadPriorityChange.ordinal()] = 16;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai[com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EInternalErrorRetryOn416.ordinal()] = 20;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion = ai;
            return ai;
        }

        private void HandleCompletion(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion)
        {
            if (iFile.type() == 1)
            {
                HandleFileCompletion(efiledownloadcompletion, (IEngVFile)iFile);
                return;
            }
            if (iFile.type() == 4)
            {
                HandleFileCompletion(efiledownloadcompletion, (IEngVHLSFile)iFile);
                return;
            } else
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HandleCompletion invalid contentType").append("[").append(iFile.type()).append("] completion reason -> ").append(efiledownloadcompletion).toString());
                return;
            }
        }

        private void HandleFileCompletion(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion, IEngVFile iengvfile)
        {
            Object obj1 = completionLock;
            obj1;
            JVM INSTR monitorenter ;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HandleFileCompletion: url -> ").append(iengvfile.assetURL()).append(" uuid -> ").append(iengvfile.uuid()).append(" Reason -> ").append(efiledownloadcompletion).toString());
            iHlsReportedComplete = true;
            $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[efiledownloadcompletion.ordinal()];
            JVM INSTR tableswitch 1 18: default 1560
        //                       1 176
        //                       2 531
        //                       3 582
        //                       4 442
        //                       5 531
        //                       6 531
        //                       7 761
        //                       8 811
        //                       9 1067
        //                       10 917
        //                       11 967
        //                       12 1017
        //                       13 811
        //                       14 176
        //                       15 531
        //                       16 1117
        //                       17 1388
        //                       18 176;
               goto _L1 _L2 _L3 _L4 _L5 _L3 _L3 _L6 _L7 _L8 _L9 _L10 _L11 _L7 _L2 _L3 _L12 _L13 _L2
_L1:
            return;
_L2:
            String s1;
            int i;
            if (efiledownloadcompletion == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorExpired)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, "Expired File should not have appeared in the downloader - marking as complete");
            }
            s1 = iengvfile.filePath();
            i = s1.lastIndexOf(".");
            i = iengvfile.filePath().length() - i;
            if (i <= 5 && i >= 2)
            {
                break MISSING_BLOCK_LABEL_325;
            }
            String s = iengvfile.mimeType();
            Object obj = s;
            if (TextUtils.isEmpty(s))
            {
                obj = iDiscoveredContentType;
            }
            obj = CommonUtil.mimeTypeToExtension(((String) (obj)));
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj = (new StringBuilder(String.valueOf(s1))).append(".").append(((String) (obj))).toString();
                iengvfile.setFilePath(((String) (obj)));
                (new File(s1)).renameTo(new File(((String) (obj))));
            }
            iCurrentDownload = null;
            iengvfile.setPending(false);
            if (efiledownloadcompletion != com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
            {
                break MISSING_BLOCK_LABEL_425;
            }
            obj = com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete;
_L14:
            iengvfile.setDownloadStatus(((com.penthera.virtuososdk.Common.EFileDownloadStatus) (obj)));
            sendBroadcastForDownloadUpdate(com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadEnd, iFile);
            if (!removeAfterPause && !pauseAfterRemove)
            {
                break MISSING_BLOCK_LABEL_432;
            }
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused, iengvfile);
              goto _L1
            efiledownloadcompletion;
            obj1;
            JVM INSTR monitorexit ;
            throw efiledownloadcompletion;
            obj = com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired;
              goto _L14
            setIdle();
              goto _L1
_L5:
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked, iengvfile);
            if (iPowerChangeResumePending)
            {
                iPowerChangeResumePending = false;
                if (getDownloadPermission() == EDownloadPermission.EDownloadAllowed)
                {
                    Resume();
                }
            }
              goto _L1
_L3:
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked, iengvfile);
              goto _L1
_L4:
            iengvfile = VirtuosoContentBox.getItem(iContext.getContentResolver(), iFile.uuid(), iClientAuthority);
            i = 0;
            if (iengvfile == null)
            {
                break MISSING_BLOCK_LABEL_635;
            }
            if (((IEngVIdentifier)iengvfile).getContentState() == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            iPriorityDownloadBundle = null;
            iPriorityDownload = null;
            iCurrentDownload = null;
            iengvfile = new Bundle();
            iengvfile.putParcelable("virtuoso_file", iFile);
            if (!i)
            {
                break MISSING_BLOCK_LABEL_729;
            }
            iengvfile.putInt("failure_reason", com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved.ordinal());
            iDObserver.downloadUpdate(Downloader.this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, iengvfile);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused);
              goto _L1
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused, iengvfile);
              goto _L1
_L6:
            iengvfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Reachability_Error);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvfile);
              goto _L1
_L7:
label0:
            {
                iengvfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Network_Error);
                iengvfile = new Bundle();
                iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
                iengvfile.putParcelable("virtuoso_file", iFile);
                reportErrorStatus(iengvfile);
                if (!iConnChangeResumePending)
                {
                    break label0;
                }
                iConnChangeResumePending = false;
                if (getDownloadPermission() == EDownloadPermission.EDownloadAllowed)
                {
                    Resume();
                }
            }
              goto _L1
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, "requesting wifi reset on eng file");
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.WIFI_RESET");
              goto _L1
_L9:
            iengvfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvfile);
              goto _L1
_L10:
            iengvfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvfile);
              goto _L1
_L11:
            iengvfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Corrupt);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvfile);
              goto _L1
_L8:
            iengvfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error);
            iengvfile = new Bundle();
            iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvfile);
              goto _L1
_L12:
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            efiledownloadcompletion = new Bundle();
            efiledownloadcompletion.putParcelable("virtuoso_file", iFile);
            iDObserver.saveFileState(Downloader.this, efiledownloadcompletion);
            iStatus.iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle;
            if (iPriorityDownloadBundle != null)
            {
                efiledownloadcompletion = iPriorityDownloadBundle.getParcelable("download_file_data");
                if (((IVirtuosoAsset)efiledownloadcompletion).uuid().equalsIgnoreCase(iFile.uuid()))
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] same file replacing prioirty bundled file").toString());
                    if (!((IEngVFile)efiledownloadcompletion).filePath().equalsIgnoreCase(iengvfile.filePath()) && iengvfile.currentSize() == 0.0D)
                    {
                        iengvfile.setFilePath(((IEngVFile)efiledownloadcompletion).filePath());
                    }
                    if (!((IEngVFile)efiledownloadcompletion).metadata().equalsIgnoreCase(iengvfile.metadata()))
                    {
                        iengvfile.setMetadata(((IEngVFile)efiledownloadcompletion).metadata());
                    }
                    iPriorityDownloadBundle.putParcelable("download_file_data", iFile);
                }
                NewItem(iPriorityDownloadBundle);
                iPriorityDownloadBundle = null;
                iPriorityDownload = null;
            }
              goto _L1
_L13:
label1:
            {
                iPriorityDownloadBundle = null;
                iPriorityDownload = null;
                iCurrentDownload = null;
                if (iFile == null)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] iFile is NULL!!").toString());
                }
                iengvfile = new Bundle();
                iengvfile.putParcelable("virtuoso_file", iFile);
                iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
                iDObserver.downloadUpdate(Downloader.this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, iengvfile);
                if (!removeAfterPause && !pauseAfterRemove)
                {
                    break label1;
                }
                iengvfile = new Bundle();
                iengvfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
                setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused, iengvfile);
            }
              goto _L1
            setIdle();
              goto _L1
        }

        private void HandleFileCompletion(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion, IEngVHLSFile iengvhlsfile)
        {
            Object obj = completionLock;
            obj;
            JVM INSTR monitorenter ;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HandleFileCompletion (HLS): url -> ").append(iengvhlsfile.assetURL()).append(" uuid -> ").append(iengvhlsfile.uuid()).append(" Reason -> ").append(efiledownloadcompletion).toString());
            iHlsReportedComplete = true;
            $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[efiledownloadcompletion.ordinal()];
            JVM INSTR tableswitch 1 18: default 1407
        //                       1 180
        //                       2 425
        //                       3 476
        //                       4 336
        //                       5 425
        //                       6 425
        //                       7 655
        //                       8 705
        //                       9 961
        //                       10 811
        //                       11 861
        //                       12 911
        //                       13 705
        //                       14 180
        //                       15 425
        //                       16 1011
        //                       17 1235
        //                       18 180;
               goto _L1 _L2 _L3 _L4 _L5 _L3 _L3 _L6 _L7 _L8 _L9 _L10 _L11 _L7 _L2 _L3 _L12 _L13 _L2
_L1:
            return;
_L2:
            com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus;
            if (efiledownloadcompletion == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorExpired)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, "Expired File should not have appeared in the downloader - marking as complete");
            }
            iCurrentDownload = null;
            iengvhlsfile.setPending(false);
            if (efiledownloadcompletion != com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
            {
                break MISSING_BLOCK_LABEL_319;
            }
            efiledownloadstatus = com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete;
_L14:
            iengvhlsfile.setDownloadStatus(efiledownloadstatus);
            iengvhlsfile.setCurrentSize(iengvhlsfile.expectedSize());
            iengvhlsfile.setCompletedCount(iengvhlsfile.totalFragments());
            sendBroadcastForDownloadUpdate(com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadEnd, iFile);
            if (!removeAfterPause && !pauseAfterRemove)
            {
                break MISSING_BLOCK_LABEL_326;
            }
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused, iengvhlsfile);
              goto _L1
            efiledownloadcompletion;
            obj;
            JVM INSTR monitorexit ;
            throw efiledownloadcompletion;
            efiledownloadstatus = com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired;
              goto _L14
            setIdle();
              goto _L1
_L5:
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked, iengvhlsfile);
            if (iPowerChangeResumePending)
            {
                iPowerChangeResumePending = false;
                if (getDownloadPermission() == EDownloadPermission.EDownloadAllowed)
                {
                    Resume();
                }
            }
              goto _L1
_L3:
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked, iengvhlsfile);
              goto _L1
_L4:
            iengvhlsfile = VirtuosoContentBox.getItem(iContext.getContentResolver(), iFile.uuid(), iClientAuthority);
            boolean flag;
            flag = false;
            if (iengvhlsfile == null)
            {
                break MISSING_BLOCK_LABEL_529;
            }
            if (((IEngVIdentifier)iengvhlsfile).getContentState() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            iPriorityDownloadBundle = null;
            iPriorityDownload = null;
            iCurrentDownload = null;
            iengvhlsfile = new Bundle();
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_623;
            }
            iengvhlsfile.putInt("failure_reason", com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved.ordinal());
            iDObserver.downloadUpdate(Downloader.this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, iengvhlsfile);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused);
              goto _L1
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused, iengvhlsfile);
              goto _L1
_L6:
            iengvhlsfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Reachability_Error);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvhlsfile);
              goto _L1
_L7:
label0:
            {
                iengvhlsfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Network_Error);
                iengvhlsfile = new Bundle();
                iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
                iengvhlsfile.putParcelable("virtuoso_file", iFile);
                reportErrorStatus(iengvhlsfile);
                if (!iConnChangeResumePending)
                {
                    break label0;
                }
                iConnChangeResumePending = false;
                if (getDownloadPermission() == EDownloadPermission.EDownloadAllowed)
                {
                    Resume();
                }
            }
              goto _L1
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, "requesting wifi reset");
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.WIFI_RESET");
              goto _L1
_L9:
            iengvhlsfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvhlsfile);
              goto _L1
_L10:
            iengvhlsfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvhlsfile);
              goto _L1
_L11:
            iengvhlsfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Corrupt);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvhlsfile);
              goto _L1
_L8:
            iengvhlsfile.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error);
            iengvhlsfile = new Bundle();
            iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
            iengvhlsfile.putParcelable("virtuoso_file", iFile);
            reportErrorStatus(iengvhlsfile);
              goto _L1
_L12:
            updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
            efiledownloadcompletion = new Bundle();
            efiledownloadcompletion.putParcelable("virtuoso_file", iFile);
            iDObserver.saveFileState(Downloader.this, efiledownloadcompletion);
            iStatus.iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle;
            if (iPriorityDownloadBundle != null)
            {
                efiledownloadcompletion = (IVirtuosoAsset)iPriorityDownloadBundle.getParcelable("download_file_data");
                if (efiledownloadcompletion.uuid().equalsIgnoreCase(iFile.uuid()))
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] same file replacing prioirty bundled file").toString());
                    if (!efiledownloadcompletion.metadata().equalsIgnoreCase(iFile.metadata()))
                    {
                        iFile.setMetadata(efiledownloadcompletion.metadata());
                    }
                    iPriorityDownloadBundle.putParcelable("download_file_data", iFile);
                }
                NewItem(iPriorityDownloadBundle);
                iPriorityDownloadBundle = null;
                iPriorityDownload = null;
            }
              goto _L1
_L13:
label1:
            {
                iPriorityDownloadBundle = null;
                iPriorityDownload = null;
                iCurrentDownload = null;
                if (iFile == null)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] iFile is NULL!!").toString());
                }
                iengvhlsfile = new Bundle();
                iengvhlsfile.putParcelable("virtuoso_file", iFile);
                iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
                iDObserver.downloadUpdate(Downloader.this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, iengvhlsfile);
                if (!removeAfterPause && !pauseAfterRemove)
                {
                    break label1;
                }
                iengvhlsfile = new Bundle();
                iengvhlsfile.putInt("failure_reason", efiledownloadcompletion.ordinal());
                setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused, iengvhlsfile);
            }
              goto _L1
            setIdle();
              goto _L1
        }

        private void addClientConfiguredHeaders(HttpGet httpget)
        {
            if (iClientConfiguredHeaders == null) goto _L2; else goto _L1
_L1:
            Iterator iterator = iClientConfiguredHeaders.keySet().iterator();
_L5:
            if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
            return;
_L3:
            String s = (String)iterator.next();
            httpget.addHeader(s, iClientConfiguredHeaders.getString(s));
            if (true) goto _L5; else goto _L4
_L4:
        }

        private com.penthera.virtuososdk.Common.EFileDownloadStatus completionToState(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion)
        {
            switch ($SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[efiledownloadcompletion.ordinal()])
            {
            default:
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending;

            case 14: // '\016'
            case 18: // '\022'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired;

            case 1: // '\001'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 15: // '\017'
            case 19: // '\023'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending;

            case 7: // '\007'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Reachability_Error;

            case 8: // '\b'
            case 13: // '\r'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Network_Error;

            case 10: // '\n'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch;

            case 11: // '\013'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch;

            case 12: // '\f'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Corrupt;

            case 9: // '\t'
            case 17: // '\021'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error;

            case 16: // '\020'
                return com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending;
            }
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion downloadFragment(IEngFileFragment iengfilefragment, int i, String s, HttpClient httpclient)
            throws IOException
        {
            long l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFragment(HLS): url -> ").append(iengfilefragment.remotePath()).append(" id -> ").append(iengfilefragment.id()).toString());
            l1 = 0L;
            s = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            s = new File(iengfilefragment.filePath());
            long l = l1;
            HttpGet httpget = new HttpGet(iengfilefragment.remotePath());
            l = l1;
            addClientConfiguredHeaders(httpget);
            l = l1;
            l1 = com.penthera.virtuososdk.utility.CommonUtil.FileHelpers.getFileSize(s);
            if (l1 <= 0L)
            {
                break MISSING_BLOCK_LABEL_275;
            }
            l = l1;
            if ((double)l1 != iengfilefragment.expectedSize())
            {
                break MISSING_BLOCK_LABEL_237;
            }
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] File already full downloaded: ").append(s.getName()).toString());
            l = l1;
            iengfilefragment = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return iengfilefragment;
            l = l1;
            httpget.addHeader("Range", (new StringBuilder("bytes=")).append(s.length()).append("-").toString());
            l = l1;
            httpclient = httpclient.execute(httpget);
            l = l1;
            int j = httpclient.getStatusLine().getStatusCode();
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("Http response for download: ")).append(j).toString());
            if (j < 500)
            {
                break MISSING_BLOCK_LABEL_440;
            }
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HTTP Server error: ").append(Integer.toString(j)).toString());
            l = l1;
            iengfilefragment = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return iengfilefragment;
            if (j >= 200 && j < 300)
            {
                break MISSING_BLOCK_LABEL_647;
            }
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HTTP other error: ").append(j).toString());
            if (j != 416)
            {
                break MISSING_BLOCK_LABEL_597;
            }
            l = l1;
            if (!s.exists())
            {
                break MISSING_BLOCK_LABEL_538;
            }
            l = l1;
            s.delete();
            l = l1;
            iengfilefragment.setCurrentSize(0.0D);
            l = l1;
            httpget.abort();
            l = l1;
            iengfilefragment = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EInternalErrorRetryOn416;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return iengfilefragment;
            l = l1;
            iengfilefragment = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return iengfilefragment;
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.HttpUtils.dumpHeaders(httpclient.getAllHeaders());
            l = l1;
            Header aheader[] = httpclient.getAllHeaders();
            l = l1;
            if (validFragmentMimeType(getMimetypeFromHeaders(aheader)))
            {
                break MISSING_BLOCK_LABEL_741;
            }
            l = l1;
            iengfilefragment = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return iengfilefragment;
            l = l1;
            double d = getFileSizeFromHeaders(aheader, s.length());
            l = l1;
            if (iengfilefragment.expectedSize() <= -1D)
            {
                break MISSING_BLOCK_LABEL_893;
            }
            l = l1;
            if (d == iengfilefragment.expectedSize())
            {
                break MISSING_BLOCK_LABEL_919;
            }
            l = l1;
            if (!s.exists())
            {
                break MISSING_BLOCK_LABEL_810;
            }
            l = l1;
            s.delete();
            l = l1;
            httpget.abort();
            l = l1;
            iengfilefragment.setCurrentSize(0.0D);
            l = l1;
            iengfilefragment.setExpectedSize(-1D);
            l = l1;
            iengfilefragment = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return iengfilefragment;
            l = l1;
            iengfilefragment.setExpectedSize(d);
            l = l1;
            iengfilefragment.update(CommonUtil.getApplicationContext());
            l = l1;
            httpclient = readStreamBytes(httpget, iengfilefragment, httpclient, s, iengfilefragment.expectedSize(), i, true);
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadFragment: finished url -> ").append(iengfilefragment.remotePath()).append(", Expected size -> ").append(iengfilefragment.expectedSize()).append(", Size -> ").append(s.length()).toString());
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            return httpclient;
            iengfilefragment;
            s = null;
            l = l1;
_L2:
            long l2 = s.length() - l;
            if (l2 > l)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l2;
            throw iengfilefragment;
            iengfilefragment;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion downloadItem()
            throws IOException
        {
            Object obj2;
            int i;
            boolean flag;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadItem").toString());
            iDownloadInfo.iDownloading = true;
            requestPermissionChecks(Downloader.this);
            flag = com.penthera.virtuososdk.utility.CommonUtil.NetworkHelpers.isCell(iContext);
            EDownloadPermission edownloadpermission;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            if (!iDownloadStop.isSet()) goto _L2; else goto _L1
_L1:
            edownloadpermission = iDownloadStop.iPermission;
            obj2 = iDownloadStop.iReason;
            iDownloadStop.clear();
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("downloadItem(): Download being stopped: ")).append(edownloadpermission).toString());
            removeHandlerPermissionCheck(Downloader.this);
            obj2 = permissionDeniedToFileCompletion(edownloadpermission, ((EStopReason) (obj2)));
_L8:
            return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj2));
_L2:
            String s;
            if (getDownloadPermission() != EDownloadPermission.EDownloadAllowed)
            {
                EDownloadPermission edownloadpermission1 = getDownloadPermission();
                com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("Downloads not permitted: ")).append(edownloadpermission1).toString());
                removeHandlerPermissionCheck(Downloader.this);
                return permissionDeniedToFileCompletion(edownloadpermission1);
            }
            Object obj;
            if (flag)
            {
                s = "cellular";
            } else
            {
                s = "wifi";
            }
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            obj = new BasicHttpParams();
            HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), Downloader.HTTP_SOCKET_TIMEOUT);
            HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), Downloader.HTTP_CONNECTION_TIMEOUT);
            obj2 = new ConnPerRouteBean(10);
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, "set params max per route");
            ConnManagerParams.setMaxTotalConnections(((org.apache.http.params.HttpParams) (obj)), 30);
            ConnManagerParams.setMaxConnectionsPerRoute(((org.apache.http.params.HttpParams) (obj)), ((org.apache.http.conn.params.ConnPerRoute) (obj2)));
            obj2 = new SchemeRegistry();
            ((SchemeRegistry) (obj2)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            ((SchemeRegistry) (obj2)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            client = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj)), ((SchemeRegistry) (obj2))), ((org.apache.http.params.HttpParams) (obj)));
            overallThroughPut.signalStart();
            currentThroughPut.reset();
            currentThroughPut.signalStart();
            if (iFile.type() != 1) goto _L4; else goto _L3
_L3:
            com.penthera.virtuososdk.utility.CommonUtil.Log.d("TIMED_DOWNLOAD", (new StringBuilder("Start SINGLE ")).append((new Date()).getTime() / 1000L).toString());
            obj2 = downloadItem((IEngVFile)iFile, i, s, client);
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EInternalErrorRetryOn416 != obj2) goto _L6; else goto _L5
_L5:
            obj1 = downloadItem((IEngVFile)iFile, i, s, client);
_L10:
            if (iDownloadStop.isSet())
            {
                iDownloadStop.clear();
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d("TIMED_DOWNLOAD", (new StringBuilder("Stop SINGLE ")).append((new Date()).getTime() / 1000L).toString());
_L14:
            removeHandlerPermissionCheck(Downloader.this);
            obj2 = obj1;
            if (client == null) goto _L8; else goto _L7
_L7:
            client.getConnectionManager().shutdown();
            return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj1));
            obj2;
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught Exception while shutting down connection manager: ").toString(), ((Throwable) (obj2)));
            return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj1));
_L6:
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize == obj2)
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = obj2;
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP != obj2) goto _L10; else goto _L9
_L13:
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize == obj2)
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = obj2;
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP != obj2) goto _L10; else goto _L11
_L11:
            obj1 = obj2;
            int j;
            if (j >= 3) goto _L10; else goto _L12
_L12:
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("received a http error or file size error retry attempt ")).append(j).toString());
            obj2 = downloadItem((IEngVFile)iFile, i, s, client);
            j++;
              goto _L13
_L4:
            if (iFile.type() != 4)
            {
                break MISSING_BLOCK_LABEL_937;
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d("TIMED_DOWNLOAD", (new StringBuilder("Start HLS ")).append((new Date()).getTime() / 1000L).toString());
            downloadItem((IEngVHLSFile)iFile, i, s, client);
            if (iDownloadStop.isSet())
            {
                iDownloadStop.clear();
            }
            synchronized (mHlsLock)
            {
                mHlsLock.wait();
            }
_L15:
            obj1 = mStatus;
            iDownloadInfo.iDownloading = false;
            com.penthera.virtuososdk.utility.CommonUtil.Log.d("TIMED_DOWNLOAD", (new StringBuilder("Stop HLS ")).append((new Date()).getTime() / 1000L).toString());
              goto _L14
            obj1;
            removeHandlerPermissionCheck(Downloader.this);
            InterruptedException interruptedexception;
            try
            {
                if (client != null)
                {
                    client.getConnectionManager().shutdown();
                }
            }
            catch (Exception exception1)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught Exception while shutting down connection manager: ").toString(), exception1);
            }
            throw obj1;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
            interruptedexception;
            interruptedexception.printStackTrace();
              goto _L15
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadItem invalid contentType").append("[").append(iFile.type()).append("]").toString());
            throw new RuntimeException("Invalid item for download");
_L9:
            j = 1;
              goto _L13
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion downloadItem(IEngVFile iengvfile, int i, String s, HttpClient httpclient)
            throws IOException
        {
            Object obj;
            long l;
            long l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadItem: url -> ").append(iengvfile.assetURL()).append(" uuid -> ").append(iengvfile.uuid()).toString());
            obj = null;
            l1 = 0L;
            s = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            l = l1;
            s = new File(iengvfile.filePath());
            l = l1;
            HttpGet httpget = new HttpGet(iengvfile.assetURL());
            l = l1;
            addClientConfiguredHeaders(httpget);
            l = l1;
            l1 = com.penthera.virtuososdk.utility.CommonUtil.FileHelpers.getFileSize(s);
            if (l1 <= 0L)
            {
                break MISSING_BLOCK_LABEL_512;
            }
            l = l1;
            if ((double)l1 != iFile.expectedSize()) goto _L2; else goto _L1
_L1:
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] File already full downloaded: ").append(s.getName()).toString());
            l = l1;
            httpclient = iengvfile.fileMD5();
            l = l1;
            if (!TextUtils.isEmpty(httpclient))
            {
                break MISSING_BLOCK_LABEL_319;
            }
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] no hash to check setting as complete").toString());
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] checking hash...").toString());
            l = l1;
            obj = new MD5();
            l = l1;
            ((MD5) (obj)).setState(iengvfile.md5State());
            l = l1;
            if (!httpclient.equalsIgnoreCase(((MD5) (obj)).getHashString())) goto _L4; else goto _L3
_L3:
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
_L5:
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
_L4:
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileCorrupt;
            if (true) goto _L5; else goto _L2
_L2:
            l = l1;
            httpget.addHeader("Range", (new StringBuilder("bytes=")).append(s.length()).append("-").toString());
            l = l1;
            HttpResponse httpresponse = httpclient.execute(httpget);
            l = l1;
            int j = httpresponse.getStatusLine().getStatusCode();
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("Http response for download: ")).append(j).toString());
            if (j < 500)
            {
                break MISSING_BLOCK_LABEL_688;
            }
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HTTP Server error: ").append(Integer.toString(j)).toString());
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
            if (j >= 200 && j < 300)
            {
                break MISSING_BLOCK_LABEL_917;
            }
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] HTTP other error: ").append(j).toString());
            if (j != 416)
            {
                break MISSING_BLOCK_LABEL_856;
            }
            l = l1;
            if (!s.exists())
            {
                break MISSING_BLOCK_LABEL_786;
            }
            l = l1;
            s.delete();
            l = l1;
            iengvfile.setCurrentSize(0.0D);
            l = l1;
            httpget.abort();
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EInternalErrorRetryOn416;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.HttpUtils.dumpHeaders(httpresponse.getAllHeaders());
            l = l1;
            Header aheader[] = httpresponse.getAllHeaders();
            l = l1;
            iDiscoveredContentType = getMimetypeFromHeaders(aheader);
            l = l1;
            httpclient = iengvfile.mimeType();
            l = l1;
            if (TextUtils.isEmpty(httpclient))
            {
                break MISSING_BLOCK_LABEL_1059;
            }
            l = l1;
            if (httpclient.equalsIgnoreCase(iDiscoveredContentType))
            {
                break MISSING_BLOCK_LABEL_1059;
            }
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
            l = l1;
            j = iengvfile.filePath().lastIndexOf(".");
            l = l1;
            j = iengvfile.filePath().length() - j;
            if (j <= 5 && j >= 2) goto _L7; else goto _L6
_L6:
            l = l1;
            httpclient = getFileNameFromHeaders(httpresponse.getHeaders("Content-Disposition"));
            l = l1;
            if (TextUtils.isEmpty(httpclient)) goto _L7; else goto _L8
_L8:
            l = l1;
            j = httpclient.lastIndexOf(".");
            if (j < 0) goto _L10; else goto _L9
_L9:
            l = l1;
            httpclient = httpclient.substring(j);
_L21:
            l = l1;
            if (TextUtils.isEmpty(httpclient)) goto _L7; else goto _L11
_L11:
            l = l1;
            iengvfile.setFilePath((new StringBuilder(String.valueOf(iengvfile.filePath()))).append(httpclient).toString());
            l = l1;
            httpclient = new File(iengvfile.filePath());
            l = l1;
            if (s.length() <= 0L) goto _L13; else goto _L12
_L12:
            l = l1;
            s.renameTo(httpclient);
_L7:
            obj = s;
            l = l1;
            double d = getFileSizeFromHeaders(aheader, s.length());
            obj = s;
            l = l1;
            if (iFile.expectedSize() <= -1D) goto _L15; else goto _L14
_L14:
            obj = s;
            l = l1;
            if (d == iFile.expectedSize()) goto _L17; else goto _L16
_L16:
            obj = s;
            l = l1;
            if (!s.exists())
            {
                break MISSING_BLOCK_LABEL_1350;
            }
            obj = s;
            l = l1;
            s.delete();
            obj = s;
            l = l1;
            httpget.abort();
            obj = s;
            l = l1;
            iengvfile.setCurrentSize(0.0D);
            obj = s;
            l = l1;
            iengvfile.setExpectedSize(-1D);
            obj = s;
            l = l1;
            iengvfile = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize;
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
_L10:
            httpclient = null;
            continue; /* Loop/switch isn't completed */
_L13:
            s = httpclient;
              goto _L7
_L15:
            obj = s;
            l = l1;
            iengvfile.setExpectedSize(d);
_L17:
            obj = s;
            l = l1;
            iengvfile = readStreamBytes(httpget, iengvfile, httpresponse, s, iFile.expectedSize(), i);
            obj = s;
            l = l1;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadItem: finished url -> ").append(iFile.assetURL()).append(", Expected size -> ").append(iFile.expectedSize()).append(", Size -> ").append(s.length()).toString());
            l = s.length() - l1;
            if (l > l1)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l;
            iDownloadInfo.iDownloading = false;
            return iengvfile;
            iengvfile;
_L19:
            long l2 = ((File) (obj)).length() - l;
            if (l2 > l)
            {
                iDownloadInfo.iBytesDownloaded = true;
            }
            iDownloadInfo.iLastBytesRead = l2;
            iDownloadInfo.iDownloading = false;
            throw iengvfile;
            iengvfile;
            obj = s;
            if (true) goto _L19; else goto _L18
_L18:
            if (true) goto _L21; else goto _L20
_L20:
        }

        private void downloadItem(IEngVHLSFile iengvhlsfile, int i, String s, HttpClient httpclient)
            throws IOException
        {
            (new HlsDownload(iengvhlsfile, i, s, httpclient)).begin();
        }

        private String getFileNameFromHeaders(Header aheader[])
        {
            if (aheader == null)
            {
                return null;
            }
            int i = 0;
            do
            {
                if (i >= aheader.length)
                {
                    return null;
                }
                String as[] = aheader[i].toString().split(":");
                String s1 = as[0];
                if (!TextUtils.isEmpty(s1) && s1.trim().equalsIgnoreCase("Content-disposition"))
                {
                    String s = as[1];
                    int j = s.indexOf("filename=");
                    if (j > 0)
                    {
                        j += "filename=".length() + 1;
                        if (j < s.length())
                        {
                            aheader = s.substring(j).trim();
                            return aheader.substring(0, aheader.indexOf('"'));
                        }
                    }
                }
                i++;
            } while (true);
        }

        private double getFileSizeFromHeaders(Header aheader[], long l)
        {
            if (aheader != null) goto _L2; else goto _L1
_L1:
            double d = 0.0D;
_L5:
            return d;
_L2:
            double d2;
            double d4;
            int i;
            d2 = 0.0D;
            d4 = 0.0D;
            i = 0;
_L7:
            if (i < aheader.length) goto _L4; else goto _L3
_L3:
            d = d2;
            if (d2 <= 0.0D)
            {
                return d4;
            }
              goto _L5
_L4:
            String as[] = aheader[i].toString().split(":");
            String s1 = as[0];
            double d1 = d4;
            if (!TextUtils.isEmpty(s1))
            {
                d1 = d4;
                if (s1.trim().equalsIgnoreCase("Content-Length"))
                {
                    d1 = Double.parseDouble(as[1].trim()) + (double)l;
                }
            }
            double d3 = d2;
            if (!TextUtils.isEmpty(s1))
            {
                d3 = d2;
                if (s1.trim().equalsIgnoreCase("Content-Range"))
                {
                    as = as[1].split("/");
                    d3 = d2;
                    if (as.length == 2)
                    {
                        String s = as[1];
                        try
                        {
                            d3 = Double.parseDouble(s.trim());
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            d3 = d2;
                        }
                    }
                }
            }
            if (d1 <= 0.0D)
            {
                break; /* Loop/switch isn't completed */
            }
            d4 = d1;
            d2 = d3;
            if (d3 > 0.0D) goto _L3; else goto _L6
_L6:
            i++;
            d4 = d1;
            d2 = d3;
              goto _L7
        }

        private String getMimetypeFromHeaders(Header aheader[])
        {
            if (aheader == null)
            {
                return "";
            }
            int i = 0;
            do
            {
                if (i >= aheader.length)
                {
                    return "";
                }
                String as[] = aheader[i].toString().split(":");
                String s = as[0];
                if (!TextUtils.isEmpty(s) && s.trim().equalsIgnoreCase("Content-Type"))
                {
                    return as[1].trim();
                }
                i++;
            } while (true);
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion permissionDeniedToFileCompletion(EDownloadPermission edownloadpermission)
        {
            return permissionDeniedToFileCompletion(edownloadpermission, EStopReason.EBlocked);
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion permissionDeniedToFileCompletion(EDownloadPermission edownloadpermission, EStopReason estopreason)
        {
            switch ($SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()[edownloadpermission.ordinal()])
            {
            default:
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedUnknown;

            case 2: // '\002'
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedCell;

            case 3: // '\003'
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedBattery;

            case 4: // '\004'
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedHeadroom;

            case 5: // '\005'
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedStorage;

            case 6: // '\006'
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedPaused;

            case 1: // '\001'
                if (estopreason == EStopReason.EPriorityChange)
                {
                    return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadPriorityChange;
                }
                if (estopreason == EStopReason.EFileRemoved)
                {
                    return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved;
                }
                if (estopreason == EStopReason.EFileExpired)
                {
                    return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileExpired;
                }
                // fall through

            case 7: // '\007'
                return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedAuthentication;
            }
        }

        private void reportFragmentComplete(IEngVHLSFile iengvhlsfile, IEngFileFragment iengfilefragment)
        {
            int j = iengvhlsfile.totalFragments();
            int i = Math.min(iengvhlsfile.totalFragmentsComplete() + 1, j);
            iengvhlsfile.setCompletedCount(i);
            if (iFragmentNotificationRate > 0 && i % iFragmentNotificationRate == 0)
            {
                Bundle bundle = new Bundle();
                bundle.putParcelable("virtuoso_file", iengvhlsfile);
                iDObserver.fragmentsComplete(Downloader.this, bundle);
            }
            j /= 100;
            if (j > 0 && i % j == 0)
            {
                reportHLSUpdate(iengvhlsfile, iengfilefragment);
            }
        }

        private void reportHLSUpdate(IEngVHLSFile iengvhlsfile, IEngFileFragment iengfilefragment)
        {
label0:
            {
                if (System.currentTimeMillis() - iLastUpdateTime >= iMinimumUpdateInterval)
                {
                    iLastUpdateTime = System.currentTimeMillis();
                    iengvhlsfile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
                    if (!iHlsReportedComplete)
                    {
                        break label0;
                    }
                }
                return;
            }
            iengfilefragment = new Bundle();
            iengfilefragment.putParcelable("virtuoso_file", iengvhlsfile);
            iDObserver.hdsProgressUpdate(Downloader.this, iengfilefragment);
        }

        private void sendQuotaUpdate(Bundle bundle)
        {
            currentThroughPut.update(bundle.getInt("bearer_data_usage"));
            overallThroughPut.update(bundle.getInt("bearer_data_usage"));
            iDObserver.quotaUpdate(Downloader.this, bundle);
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion tryDownloadFile()
        {
            boolean flag;
            com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            flag = false;
_L6:
            Object obj;
            Object obj1;
            if (flag)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network failure -- trying again for item: ")).append(iFile.assetURL()).toString());
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): bytes read on the previous attempt: ")).append(iDownloadInfo.iLastBytesRead).toString());
            }
            iDownloadInfo.iLastBytesRead = 0L;
            flag = false;
            try
            {
                obj = downloadItem();
                iDownloadInfo.iDownloadExceptions = 0;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network unavaialble -- Received unknown host excpetion: ")).append(((UnknownHostException) (obj)).getMessage()).toString());
                obj = iDownloadInfo;
                obj.iDownloadExceptions = ((DownloadInfo) (obj)).iDownloadExceptions + 1;
                com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast("virtuoso.intent.action.UNKNOWN_HOST");
                obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
                flag = true;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network problem -- Received a network error: ")).append(((Exception) (obj)).getMessage()).toString());
                obj = iDownloadInfo;
                obj.iDownloadExceptions = ((DownloadInfo) (obj)).iDownloadExceptions + 1;
                obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
                flag = true;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network problem -- unknown error: ")).append(((Throwable) (obj)).getMessage()).toString());
                obj = iDownloadInfo;
                obj.iDownloadExceptions = ((DownloadInfo) (obj)).iDownloadExceptions + 1;
                obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
                flag = true;
            }
            if (iDownloadInfo.iDownloadExceptions < 3) goto _L2; else goto _L1
_L1:
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] No internet connection: connection not usable").toString());
            obj1 = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorsMaxed;
_L4:
            return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj1));
_L2:
            obj1 = obj;
            if (!flag) goto _L4; else goto _L3
_L3:
            if (iDownloadInfo.iLastBytesRead <= 0L)
            {
                return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj));
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        private void updateDownloadProgress()
        {
            iLastUpdateTime = System.currentTimeMillis();
            sendBroadcastForDownloadUpdate(com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EProgressUpdate, iFile);
        }

        private void updateDownloadProgress(double d)
        {
            if (iFile.type() == 1)
            {
                ((IEngVFile)iFile).setCurrentSize(d);
            }
            updateDownloadProgress();
        }

        private void updateDownloadProgress(com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus)
        {
            ((IEngVIdentifier)iFile).setDownloadStatus(efiledownloadstatus);
            updateDownloadProgress();
        }

        private boolean validFragmentMimeType(String s)
        {
            return !TextUtils.isEmpty(s) && (s.toLowerCase(Locale.getDefault()).contains("video/mp2t") || s.toLowerCase(Locale.getDefault()).contains("video/mp2ts") || s.toLowerCase(Locale.getDefault()).contains("audio/") || s.toLowerCase(Locale.getDefault()).contains("video/") || "application/octet-stream".equalsIgnoreCase(s));
        }

        void killDownloadWithCompletionCode(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion)
        {
            killed = true;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] kill Download:  uuid -> ").append(iFile.uuid()).append(" Reason -> ").append(efiledownloadcompletion).toString());
            if (killCode == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedPaused && (efiledownloadcompletion == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved || efiledownloadcompletion == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileExpired))
            {
                removeAfterPause = true;
                killCode = efiledownloadcompletion;
                synchronized (completionLock)
                {
                    if (iHlsReportedComplete && VirtuosoContentBox.getItem(iContext.getContentResolver(), iFile.uuid(), iClientAuthority) != null)
                    {
                        com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] file completed removing ").toString());
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("virtuoso_file", iFile);
                        bundle.putInt("failure_reason", com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved.ordinal());
                        iDObserver.downloadUpdate(Downloader.this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, bundle);
                    }
                }
            } else
            if (efiledownloadcompletion == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedPaused && (killCode == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved || killCode == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileExpired))
            {
                pauseAfterRemove = true;
            } else
            {
                killCode = efiledownloadcompletion;
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] kill Download: code -> ").append(killCode).toString());
            return;
            exception;
            efiledownloadcompletion;
            JVM INSTR monitorexit ;
            throw exception;
        }

        com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion readStreamBytes(HttpRequestBase httprequestbase, Object obj, HttpResponse httpresponse, File file, double d, int i)
            throws IOException
        {
            return readStreamBytes(httprequestbase, obj, httpresponse, file, d, i, false);
        }

        com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion readStreamBytes(HttpRequestBase httprequestbase, Object obj, HttpResponse httpresponse, File file, double d, int i, 
                boolean flag)
            throws IOException
        {
            IEngVFile iengvfile;
            IEngFileFragment iengfilefragment;
            MD5 md5;
            InputStream inputstream;
            Bundle bundle;
            int j;
            int j1;
            int k1;
            int l1;
            boolean flag2;
            int j2;
            int k2;
            boolean flag3;
            long l3;
            md5 = new MD5();
            double d1;
            boolean flag1;
            if (flag)
            {
                flag2 = false;
            } else
            {
                flag2 = true;
            }
            iengvfile = null;
            iengfilefragment = null;
            if (flag)
            {
                iengfilefragment = (IEngFileFragment)obj;
            }
            if (flag2)
            {
                iengvfile = (IEngVFile)iFile;
            }
            try
            {
                obj = new FileOutputStream(file, true);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("wait and retry - file not found: ")).append(file.getName()).toString());
                try
                {
                    sleep(100L);
                    obj = new FileOutputStream(file, true);
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("file not found: ")).append(file.getName()).append(" ").append(httprequestbase.getMessage()).toString());
                    return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFile;
                }
            }
            flag3 = false;
            inputstream = httpresponse.getEntity().getContent();
            httpresponse = new byte[8192];
            l3 = file.length();
            l1 = 0;
            k1 = 0;
            flag1 = false;
            if (flag)
            {
                d1 = 0.25D * d;
            } else
            {
                d1 = 0.01D * d;
            }
            j2 = (int)d1;
            if (flag)
            {
                j1 = 0x20000;
            } else
            {
                j1 = j2;
            }
            if (d < 196608D)
            {
                k2 = (int)(0.5D * d);
            } else
            {
                k2 = 0x30000;
            }
            if (flag2)
            {
                md5.setState(iengvfile.md5State());
            }
            if (i == 0)
            {
                if (j2 > 0x20000)
                {
                    j1 = 0x20000;
                } else
                {
                    j1 = j2;
                }
            }
            if (flag2)
            {
                updateDownloadProgress(l3);
            } else
            {
                iengfilefragment.setCurrentSize(l3);
            }
            bundle = new Bundle();
            if (i == 0)
            {
                j = com.penthera.virtuososdk.Common.BearerType.cellular.ordinal();
            } else
            {
                j = com.penthera.virtuososdk.Common.BearerType.wifi.ordinal();
            }
            bundle.putInt("bearer", j);
            bundle.putInt("bearer_action", com.penthera.virtuososdk.utility.CommonUtil.BearerAction.EDownload.ordinal());
            j = ((flag1) ? 1 : 0);
            file = httpresponse;
_L29:
            if (!flag3) goto _L2; else goto _L1
_L1:
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            int l;
            int i1;
            int i2;
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                }
            }
            if (!flag2) goto _L4; else goto _L3
_L3:
            httprequestbase = iengvfile.fileMD5();
            if (!TextUtils.isEmpty(httprequestbase)) goto _L6; else goto _L5
_L5:
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("file: {")).append(iFile.assetURL()).append(", ").append(iFile.assetId()).append(", ").append(iengvfile.filePath()).append(", NO_HASH_IN_MD} has hash of [").append(md5.getHashString()).append("]").toString());
_L38:
            iengvfile.setCurrentSize(iFile.expectedSize());
            iengvfile.setPending(false);
_L39:
            httprequestbase = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
_L8:
            return httprequestbase;
_L2:
            l = j;
            i1 = j;
            if (!killed)
            {
                break MISSING_BLOCK_LABEL_964;
            }
            l = j;
            i1 = j;
            iDownloadStop.clear();
            l = j;
            i1 = j;
            httprequestbase.abort();
            l = j;
            i1 = j;
            httpresponse = killCode;
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            double d2;
            int k;
            int l2;
            long l4;
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L7
_L7:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
            d2 = l3;
            l = j;
            i1 = j;
            i2 = (int)Math.min(8192D, Math.max(0.0D, d - d2));
            if (i != 0) goto _L10; else goto _L9
_L9:
            l = j;
            i1 = j;
            if (iTestBundle.getBoolean("enable_download_cell", true))
            {
                break MISSING_BLOCK_LABEL_1273;
            }
            l = j;
            i1 = j;
            httprequestbase.abort();
            l = j;
            i1 = j;
            httpresponse = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedCell;
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L11
_L11:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
            httpresponse = file;
            l = j;
            i1 = j;
            if (cellOkay(i2)) goto _L13; else goto _L12
_L12:
            l = j;
            i1 = j;
            k = (int)availableCellUsage();
            if (k <= 0) goto _L15; else goto _L14
_L14:
            l = j;
            i1 = j;
            httpresponse = new byte[k];
_L13:
            l = j;
            i1 = j;
            if (storageOkay(i2))
            {
                break MISSING_BLOCK_LABEL_2369;
            }
            l = j;
            i1 = j;
            httpresponse = (new StringBuilder("Storage reported not okay - {\"storage_data\":{\"allowed_storage\" : ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAllowedStorageUsage)
            })).append(", \"allowed_cell\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAllowedCellUsage)
            })).append(", \"current_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iCurrentStorageUsage)
            })).append(", \"current_cell\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iCurrentCellUsage)
            })).append("}").append(", \"storage_increase_calc_data\" : { \"buffer_size\" : ").append(8192).append(", \"expected_size\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(d)
            })).append(", \"total_bytes\" : ").append(l3).append(", \"next_expected_storage\" : ").append(i2).append(" } }").toString();
            l = j;
            i1 = j;
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, httpresponse);
            l = j;
            i1 = j;
            httprequestbase.abort();
            l = j;
            i1 = j;
            httpresponse = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedStorage;
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L16
_L16:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
_L15:
            l = j;
            i1 = j;
            httprequestbase.abort();
            l = j;
            i1 = j;
            httpresponse = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedCell;
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L17
_L17:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
_L10:
            httpresponse = file;
            if (i != 1) goto _L13; else goto _L18
_L18:
            httpresponse = file;
            l = j;
            i1 = j;
            if (iTestBundle.getBoolean("enable_download_wifi", true)) goto _L13; else goto _L19
_L19:
            l = j;
            i1 = j;
            httprequestbase.abort();
            l = j;
            i1 = j;
            httpresponse = permissionDeniedToFileCompletion(EDownloadPermission.EDownloadBlockedWifi);
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L20
_L20:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
            l = j;
            i1 = j;
            k = inputstream.read(httpresponse);
            l1 += k;
            l2 = k1 + k;
            j += k;
            l4 = l3 + (long)k;
            if (k <= 0) goto _L22; else goto _L21
_L21:
            l = j;
            i1 = j;
            ((FileOutputStream) (obj)).write(httpresponse, 0, k);
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_2457;
            }
            l = j;
            i1 = j;
            md5.update(httpresponse, 0, k);
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_2498;
            }
            l = j;
            i1 = j;
            file = Downloader.this;
            l = j;
            i1 = j;
            file.iCurrentCellUsage = ((Downloader) (file)).iCurrentCellUsage + (double)k;
            l = j;
            i1 = j;
            file = Downloader.this;
            l = j;
            i1 = j;
            file.iCurrentStorageUsage = ((Downloader) (file)).iCurrentStorageUsage + (double)k;
            k = j;
            if (j < j1)
            {
                break MISSING_BLOCK_LABEL_2616;
            }
            l = j;
            i1 = j;
            bundle.putInt("bearer_data_usage", j);
            l = j;
            i1 = j;
            bundle.putInt("storage_usage", j);
            l = j;
            i1 = j;
            bundle.putInt("next_storage_usage", i2);
            l = j;
            i1 = j;
            sendQuotaUpdate(bundle);
            k = 0;
            if (l1 < j2) goto _L24; else goto _L23
_L23:
            if (!flag2) goto _L26; else goto _L25
_L25:
            l = k;
            i1 = k;
            try
            {
                updateDownloadProgress(l4);
                break MISSING_BLOCK_LABEL_4058;
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                i1 = l;
            }
            finally
            {
                if (flag2)
                {
                    iengvfile.setMd5State(md5.currentState());
                }
                if (i1 > 0)
                {
                    bundle.putInt("bearer_data_usage", i1);
                    bundle.putInt("storage_usage", i1);
                    bundle.putInt("next_storage_usage", 0);
                    sendQuotaUpdate(bundle);
                }
            }
              goto _L27
_L34:
            file = httpresponse;
            k1 = l2;
            l1 = i2;
            j = k;
            l3 = l4;
            if (l2 < k2) goto _L29; else goto _L28
_L28:
            l = k;
            i1 = k;
            if (!iDownloadStop.isSet()) goto _L31; else goto _L30
_L30:
            l = k;
            i1 = k;
            httpresponse = iDownloadStop.iPermission;
            l = k;
            i1 = k;
            file = iDownloadStop.iReason;
            l = k;
            i1 = k;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("downloadItem(): Download being stopped: ")).append(httpresponse).append(" reason: ").append(file).toString());
            l = k;
            i1 = k;
            iDownloadStop.clear();
            l = k;
            i1 = k;
            httprequestbase.abort();
            l = k;
            i1 = k;
            httpresponse = permissionDeniedToFileCompletion(httpresponse, file);
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (k > 0)
            {
                bundle.putInt("bearer_data_usage", k);
                bundle.putInt("storage_usage", k);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L32
_L32:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
_L26:
            d2 = l4;
            l = k;
            i1 = k;
            iengfilefragment.setCurrentSize(d2);
            l = k;
            i1 = k;
            if (killed)
            {
                break MISSING_BLOCK_LABEL_4058;
            }
            l = k;
            i1 = k;
            reportHLSUpdate((IEngVHLSFile)iFile, iengfilefragment);
            break MISSING_BLOCK_LABEL_4058;
_L27:
            throw httprequestbase;
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse) { }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httpresponse);
                }
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), ((Throwable) (obj)));
                }
            }
            throw httprequestbase;
_L24:
            i2 = l1;
            l = k;
            i1 = k;
            if (System.currentTimeMillis() - iLastUpdateTime < iMinimumUpdateInterval) goto _L34; else goto _L33
_L33:
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_3274;
            }
            l = k;
            i1 = k;
            updateDownloadProgress(l4);
            i2 = l1;
              goto _L34
            l = k;
            i1 = k;
            iengfilefragment.setCurrentSize(l4);
            i2 = l1;
            l = k;
            i1 = k;
            if (killed) goto _L34; else goto _L35
_L35:
            l = k;
            i1 = k;
            reportHLSUpdate((IEngVHLSFile)iFile, iengfilefragment);
            i2 = l1;
              goto _L34
_L31:
            k1 = 0;
            file = httpresponse;
            l1 = i2;
            j = k;
            l3 = l4;
              goto _L29
_L22:
            if (k >= 0)
            {
                break MISSING_BLOCK_LABEL_3463;
            }
            l = j;
            i1 = j;
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] reached EOF").toString());
            flag3 = true;
            file = httpresponse;
            k1 = l2;
            l3 = l4;
              goto _L29
            l = j;
            i1 = j;
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, "File corrupt: End of stream not found");
            l = j;
            i1 = j;
            httprequestbase.abort();
            l = j;
            i1 = j;
            httpresponse = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFile;
            if (flag2)
            {
                iengvfile.setMd5State(md5.currentState());
            }
            if (j > 0)
            {
                bundle.putInt("bearer_data_usage", j);
                bundle.putInt("storage_usage", j);
                bundle.putInt("next_storage_usage", 0);
                sendQuotaUpdate(bundle);
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] DownloadThread: closing istream").toString());
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase) { }
                // Misplaced declaration of an exception variable
                catch (HttpRequestBase httprequestbase)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing istream: ").toString(), httprequestbase);
                }
            }
            try
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] downloadFile(): closing ostream").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequestBase httprequestbase)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Caught IOException while closing ostream: ").toString(), httprequestbase);
                return httpresponse;
            }
            httprequestbase = httpresponse;
            if (obj == null) goto _L8; else goto _L36
_L36:
            ((FileOutputStream) (obj)).close();
            return httpresponse;
_L6:
            obj = md5.getHashString();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(Downloader.LOG_TAG, (new StringBuilder("file: {")).append(iFile.assetURL()).append(", ").append(iFile.assetId()).append(", ").append(iengvfile.filePath()).append(", ").append(httprequestbase).append("} has hash of [").append(((String) (obj))).append("]").toString());
            if (((String) (obj)).equalsIgnoreCase(httprequestbase)) goto _L38; else goto _L37
_L37:
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, "hash verification failed");
            return com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileCorrupt;
_L4:
            iengfilefragment.setCurrentSize(d);
            iengfilefragment.setPending(false);
              goto _L39
            i2 = 0;
              goto _L34
        }

        public void run()
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Download thread started").toString());
            if (iFile.downloadStatus() != com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired)
            {
                if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading)
                {
                    setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading);
                }
                ((IEngVIdentifier)iFile).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading);
                sendBroadcastForDownloadUpdate(com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadStart, iFile);
                iDownloadInfo.iDownloadExceptions = 0;
                iConnChangeResumePending = false;
                iPowerChangeResumePending = false;
                com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion = tryDownloadFile();
                if (killed)
                {
                    efiledownloadcompletion = killCode;
                }
                iLastFileCompletionErrorCode = efiledownloadcompletion;
                HandleCompletion(efiledownloadcompletion);
                return;
            }
            try
            {
                HandleCompletion(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorExpired);
                return;
            }
            catch (Exception exception)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Uncaught exception in Download Thread: ").toString(), exception);
            }
            return;
        }








        VirtuosoDownloadThread(IVirtuosoAsset ivirtuosoasset)
        {
            this$0 = Downloader.this;
            super((new StringBuilder("VirtuosoDownloadThread-")).append(ivirtuosoasset.uuid()).toString());
            mHlsLock = new Object();
            iDownloadStartTime = 0L;
            iLastUpdateTime = 0L;
            iMinimumUpdateInterval = 1000L;
            completionLock = new Object();
            killed = false;
            iHlsReportedComplete = false;
            killCode = null;
            pauseAfterRemove = false;
            removeAfterPause = false;
            iFile = ivirtuosoasset;
        }
    }

    private class VirtuosoDownloadThread.HlsDownload
    {

        private volatile boolean mAbort;
        private int mActiveWorkers;
        private HttpClient mClient;
        private int mConnectionType;
        private String mEventBearerType;
        private IEngVHLSFile mFile;
        private List mFragments;
        private Object mHlsWorkerLock;
        private volatile int mIndex;
        final VirtuosoDownloadThread this$1;

        private int MAX()
        {
            return 3;
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion download(IEngFileFragment iengfilefragment)
        {
            int i;
            com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            i = 0;
            if (TextUtils.isEmpty(iengfilefragment.filePath()))
            {
                iengfilefragment.generateFilePath();
            }
            iengfilefragment.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading);
            mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
_L10:
            boolean flag;
            if (i != 0)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network failure -- trying again for fragment: ")).append(iengfilefragment.remotePath()).toString());
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): bytes read on the previous attempt: ")).append(iDownloadInfo.iLastBytesRead).toString());
            }
            iDownloadInfo.iLastBytesRead = 0L;
            flag = false;
            Object obj1 = downloadFragment(iengfilefragment, mConnectionType, mEventBearerType, mClient);
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EInternalErrorRetryOn416 != obj1) goto _L2; else goto _L1
_L1:
            Object obj = downloadFragment(iengfilefragment, mConnectionType, mEventBearerType, mClient);
_L4:
            iDownloadInfo.iDownloadExceptions = 0;
            i = ((flag) ? 1 : 0);
_L8:
            if (iDownloadInfo.iDownloadExceptions < 3)
            {
                continue; /* Loop/switch isn't completed */
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] No internet connection: connection not usable").toString());
            iengfilefragment.setDownloadStatus(completionToState(((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj))));
            mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
            obj1 = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorsMaxed;
_L11:
            return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj1));
_L2:
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize == obj1 || com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType == obj1)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP != obj1) goto _L4; else goto _L3
_L7:
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize == obj1 || com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType == obj1)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP != obj1) goto _L4; else goto _L5
_L5:
            obj = obj1;
            if (i >= 3) goto _L4; else goto _L6
_L6:
            obj1 = downloadFragment(iengfilefragment, mConnectionType, mEventBearerType, mClient);
            i++;
              goto _L7
            obj;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network unavaialble -- Received unknown host excpetion: ")).append(((UnknownHostException) (obj)).getMessage()).toString());
            obj = iDownloadInfo;
            obj.iDownloadExceptions = ((DownloadInfo) (obj)).iDownloadExceptions + 1;
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast("virtuoso.intent.action.UNKNOWN_HOST");
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
            i = 1;
              goto _L8
            obj;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network problem -- Received a network error: ")).append(((Exception) (obj)).getMessage()).toString());
            obj = iDownloadInfo;
            obj.iDownloadExceptions = ((DownloadInfo) (obj)).iDownloadExceptions + 1;
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
            i = 1;
              goto _L8
            obj;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.LOG_TAG, (new StringBuilder("tryDownloadItem(): Network problem -- unknown error: ")).append(((Throwable) (obj)).getMessage()).toString());
            obj = iDownloadInfo;
            obj.iDownloadExceptions = ((DownloadInfo) (obj)).iDownloadExceptions + 1;
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
            i = 1;
              goto _L8
            if (i != 0 && iDownloadInfo.iLastBytesRead > 0L) goto _L10; else goto _L9
_L9:
            if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
            {
                iengfilefragment.markComplete();
            } else
            {
                iengfilefragment.setDownloadStatus(completionToState(((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj))));
            }
            if (iengfilefragment.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error && iengfilefragment.currentSize() <= 0.0D)
            {
                iengfilefragment.setFilePath(null);
            }
            mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
            obj1 = obj;
            if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
            {
                reportFragmentComplete(mFile, iengfilefragment);
                return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj));
            }
              goto _L11
_L3:
            i = 1;
              goto _L7
        }

        public void begin()
        {
            mStatus = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            mActiveWorkers = 0;
            int j = MAX();
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return;
                }
                mActiveWorkers = mActiveWorkers + 1;
                (new Thread(new Runnable() {

                    final VirtuosoDownloadThread.HlsDownload this$2;

                    public void run()
                    {
_L5:
                        obj = getNext();
                        if (obj == null) goto _L2; else goto _L1
_L1:
                        boolean flag = mAbort;
                        if (!flag) goto _L3; else goto _L2
_L2:
                        obj = VirtuosoDownloadThread.HlsDownload.this;
                        obj.mActiveWorkers = ((VirtuosoDownloadThread.HlsDownload) (obj)).mActiveWorkers - 1;
                        if (mActiveWorkers <= 0 && !mAbort)
                        {
                            synchronized (mHlsLock)
                            {
                                mHlsLock.notify();
                            }
                        }
                        return;
_L3:
                        obj = download(((IEngFileFragment) (obj)));
                        obj1 = mHlsWorkerLock;
                        obj1;
                        JVM INSTR monitorenter ;
                        if (killed)
                        {
                            obj = killCode;
                        }
                        if (!mAbort)
                        {
                            mStatus = ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj));
                        }
                        if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
                        {
                            break MISSING_BLOCK_LABEL_298;
                        }
                        mAbort = true;
                        mClient.getConnectionManager().shutdown();
                        synchronized (mHlsLock)
                        {
                            mHlsLock.notify();
                        }
                        obj1;
                        JVM INSTR monitorexit ;
                          goto _L2
                        obj;
                        obj1;
                        JVM INSTR monitorexit ;
                        throw obj;
                        obj;
                        obj1 = VirtuosoDownloadThread.HlsDownload.this;
                        obj1.mActiveWorkers = ((VirtuosoDownloadThread.HlsDownload) (obj1)).mActiveWorkers - 1;
                        if (mActiveWorkers <= 0 && !mAbort)
                        {
                            synchronized (mHlsLock)
                            {
                                mHlsLock.notify();
                            }
                        }
                        throw obj;
                        exception1;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception1;
                        obj1;
                        JVM INSTR monitorexit ;
                        if (true) goto _L5; else goto _L4
_L4:
                        obj;
                        obj1;
                        JVM INSTR monitorexit ;
                        throw obj;
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                this$2 = VirtuosoDownloadThread.HlsDownload.this;
                super();
            }
                })).start();
                i++;
            } while (true);
        }

        IEngFileFragment getNext()
        {
            this;
            JVM INSTR monitorenter ;
            IEngFileFragment iengfilefragment = null;
            if (mIndex < mFragments.size())
            {
                iengfilefragment = (IEngFileFragment)mFragments.get(mIndex);
                mIndex = mIndex + 1;
            }
            this;
            JVM INSTR monitorexit ;
            return iengfilefragment;
            Exception exception;
            exception;
            throw exception;
        }









        public VirtuosoDownloadThread.HlsDownload(IEngVHLSFile iengvhlsfile, int i, String s, HttpClient httpclient)
        {
            this$1 = VirtuosoDownloadThread.this;
            super();
            mAbort = false;
            mActiveWorkers = 0;
            mHlsWorkerLock = new Object();
            mFile = iengvhlsfile;
            mConnectionType = i;
            mEventBearerType = s;
            mClient = httpclient;
            mFragments = iengvhlsfile.pendingFragments(CommonUtil.getApplicationContext());
        }
    }


    private static int $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission[];
    private static int HTTP_CONNECTION_TIMEOUT = 60000;
    private static int HTTP_SOCKET_TIMEOUT = 30000;
    private static final String LOG_TAG = com/penthera/virtuososdk/download/Downloader.getName();
    private static final Handler iHandler = new Handler() {

        private void handleCheckPermissions(Message message)
        {
            message = (Downloader)message.obj;
            if (((Downloader) (message)).iDownloadInfo.iDownloading && !((Downloader) (message)).iDownloadStop.isSet())
            {
                boolean flag = false;
                EDownloadPermission edownloadpermission = message.getDownloadPermission();
                if (edownloadpermission != EDownloadPermission.EDownloadAllowed)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.i(Downloader.LOG_TAG, (new StringBuilder("Downloads not permitted: ")).append(edownloadpermission).toString());
                    ((Downloader) (message)).iDownloadStop.iPermission = edownloadpermission;
                    ((Downloader) (message)).iDownloadStop.iReason = EStopReason.EBlocked;
                    ((Downloader) (message)).iDownloadStop.stop(true);
                    flag = true;
                }
                if (((Downloader) (message)).iDownloadInfo.iDownloading && !flag)
                {
                    message.requestPermissionChecks(message);
                    return;
                }
            }
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.LOG_TAG, (new StringBuilder("c[] Wrong message ")).append(message.what).toString());
                return;

            case 1: // '\001'
                handleCheckPermissions(message);
                break;
            }
        }

    };
    private final boolean TEST_VD_LOCK = false;
    private final Object VirtuosoDownloadThreadCreationLock = new Object();
    Throughput currentThroughPut;
    double iAllowedCellUsage;
    double iAllowedStorageUsage;
    private BatteryMonitor iBatteryMonitor;
    private Bundle iBatterySettingsBundle;
    private int iBatteryThreshold;
    final String iClientAuthority;
    private Bundle iClientConfiguredHeaders;
    volatile boolean iConnChangeResumePending;
    private Context iContext;
    double iCurrentCellUsage;
    private IVirtuosoAsset iCurrentDownload;
    double iCurrentStorageUsage;
    private DownloaderObserver iDObserver;
    private boolean iDbInit;
    DownloadInfo iDownloadInfo;
    DownloadStop iDownloadStop;
    private VirtuosoDownloadThread iDownloadThread;
    private int iFragmentNotificationRate;
    com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion iLastFileCompletionErrorCode;
    private NetworkInfo iNetworkInfo;
    private boolean iPauseDownloadEngine;
    volatile boolean iPowerChangeResumePending;
    private IVirtuosoAsset iPriorityDownload;
    private Bundle iPriorityDownloadBundle;
    private DownloadQuotaProvider iQuotaProvider;
    boolean iRemoveRequestWhileNotDownloading;
    VirtuosoDownloadEngineStatus iStatus;
    private Bundle iTestBundle;
    private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion mStatus;
    Throughput overallThroughPut;

    static int[] $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()
    {
        int ai[] = $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[EDownloadPermission.values().length];
        try
        {
            ai[EDownloadPermission.EDownloadAllowed.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedAuthentication.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedBattery.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedCell.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedHeadroom.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedPaused.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedStorage.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[EDownloadPermission.EDownloadBlockedWifi.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission = ai;
        return ai;
    }

    Downloader(Context context, String s, DownloaderObserver downloaderobserver, DownloadQuotaProvider downloadquotaprovider, BatteryMonitor batterymonitor)
    {
        iStatus = null;
        iBatterySettingsBundle = new Bundle();
        iTestBundle = new Bundle();
        iDownloadThread = null;
        iCurrentDownload = null;
        iPriorityDownload = null;
        iPriorityDownloadBundle = null;
        iAllowedStorageUsage = 0.0D;
        iAllowedCellUsage = 0.0D;
        iCurrentStorageUsage = 0.0D;
        iCurrentCellUsage = 0.0D;
        iPauseDownloadEngine = false;
        iLastFileCompletionErrorCode = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
        iDbInit = false;
        iClientConfiguredHeaders = null;
        iRemoveRequestWhileNotDownloading = false;
        iFragmentNotificationRate = 0;
        iDownloadStop = new DownloadStop();
        iBatteryThreshold = 0;
        iDownloadInfo = new DownloadInfo(null);
        currentThroughPut = new Throughput();
        overallThroughPut = new Throughput();
        iPowerChangeResumePending = false;
        iConnChangeResumePending = false;
        iDObserver = downloaderobserver;
        iQuotaProvider = downloadquotaprovider;
        iClientAuthority = new String(s);
        iContext = context;
        iStatus = new VirtuosoDownloadEngineStatus();
        iNetworkInfo = ((ConnectivityManager)iContext.getSystemService("connectivity")).getActiveNetworkInfo();
        iBatteryMonitor = batterymonitor;
    }

    private void NewItemOrig(Bundle bundle)
    {
label0:
        {
            if (bundle != null && bundle.containsKey("fragment_download_progress_rate"))
            {
                iFragmentNotificationRate = bundle.getInt("fragment_download_progress_rate");
            }
            if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle && bundle != null)
            {
                bundle = bundle.getParcelable("download_file_data");
                if (bundle != null)
                {
                    if (!iRemoveRequestWhileNotDownloading)
                    {
                        break label0;
                    }
                    bundle = new Bundle();
                    bundle.putBoolean("forceIdleOnNewItemAfterDeleteDuringIdle", true);
                    iRemoveRequestWhileNotDownloading = false;
                    setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle, bundle, true);
                }
            }
            return;
        }
        iAllowedStorageUsage = iQuotaProvider.getAllowedStorageQuota(this);
        iAllowedCellUsage = iQuotaProvider.getAllowedCellQuota(this);
        iCurrentStorageUsage = 0.0D;
        iCurrentCellUsage = 0.0D;
        setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading);
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Creating download thread from new file request").toString());
        iCurrentDownload = (IVirtuosoAsset)bundle;
        iDownloadThread = new VirtuosoDownloadThread(iCurrentDownload);
        iDownloadThread.setPriority(1);
        iDownloadThread.start();
    }

    private void PriorityDownloadOrig(Bundle bundle)
    {
        if (bundle == null) goto _L2; else goto _L1
_L1:
        Parcelable parcelable;
        if (bundle.containsKey("fragment_download_progress_rate"))
        {
            iFragmentNotificationRate = bundle.getInt("fragment_download_progress_rate");
        }
        parcelable = bundle.getParcelable("download_file_data");
        if (parcelable == null) goto _L2; else goto _L3
_L3:
        iPriorityDownload = (IVirtuosoAsset)parcelable;
        if (com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading != iStatus.iStatus) goto _L5; else goto _L4
_L4:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] killing current download due to priority change").toString());
        removeHandlerPermissionCheck(this);
        iDownloadStop.iPermission = EDownloadPermission.EDownloadAllowed;
        iDownloadStop.iReason = EStopReason.EPriorityChange;
        iDownloadStop.stop(true);
        iPriorityDownloadBundle = bundle;
_L2:
        return;
_L5:
        double d;
        double d1;
        boolean flag;
        boolean flag1;
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle)
        {
            iCurrentDownload = iPriorityDownload;
            iPriorityDownload = null;
            iAllowedStorageUsage = iQuotaProvider.getAllowedStorageQuota(this);
            iAllowedCellUsage = iQuotaProvider.getAllowedCellQuota(this);
            iCurrentStorageUsage = 0.0D;
            iCurrentCellUsage = 0.0D;
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading);
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Creating download thread from idle state").toString());
            iCurrentDownload = (IVirtuosoAsset)parcelable;
            iDownloadThread = new VirtuosoDownloadThread(iCurrentDownload);
            iDownloadThread.setPriority(1);
            iDownloadThread.start();
            return;
        }
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = false;
        d = iQuotaProvider.getAllowedCellQuota(this);
        d1 = iQuotaProvider.getAllowedStorageQuota(this);
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] New Storage Settings received store_usage[ ").append(String.format("%1$,.2f", new Object[] {
            Double.valueOf(d1)
        })).append(" ] cell_usage[ ").append(String.format("%1$,.2f", new Object[] {
            Double.valueOf(d)
        })).append(" ]").toString());
        flag = flag1;
        $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()[getDownloadPermission().ordinal()];
        JVM INSTR tableswitch 1 5: default 448
    //                   1 914
    //                   2 877
    //                   3 452
    //                   4 452
    //                   5 895;
           goto _L6 _L7 _L8 _L9 _L9 _L10
_L9:
        break; /* Loop/switch isn't completed */
_L6:
        flag = flag1;
_L12:
        if (flag)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] can resume download").toString());
            iCurrentDownload = iPriorityDownload;
            iPriorityDownload = null;
            bundle = (new StringBuilder("Previous data \"storage_data\":{\"allowed_storage\" : ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAllowedStorageUsage)
            })).append(", \"allowed_cell\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAllowedCellUsage)
            })).append(", \"current_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iCurrentStorageUsage)
            })).append(", \"current_cell\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iCurrentCellUsage)
            })).append("}").toString();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, bundle);
            iAllowedStorageUsage = d1;
            iAllowedCellUsage = d;
            iCurrentStorageUsage = 0.0D;
            iCurrentCellUsage = 0.0D;
            bundle = (new StringBuilder("New data \"storage_data\":{\"allowed_storage\" : ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAllowedStorageUsage)
            })).append(", \"allowed_cell\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAllowedCellUsage)
            })).append(", \"current_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iCurrentStorageUsage)
            })).append(", \"current_cell\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iCurrentCellUsage)
            })).append("}").toString();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, bundle);
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading);
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Creating download thread from blocked state").toString());
            iCurrentDownload = (IVirtuosoAsset)parcelable;
            iDownloadThread = new VirtuosoDownloadThread(iCurrentDownload);
            iDownloadThread.setPriority(1);
            iDownloadThread.start();
            return;
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (d > 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (d1 > 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        flag = true;
        if (true) goto _L12; else goto _L11
_L11:
        if (true) goto _L2; else goto _L13
_L13:
        iCurrentDownload = iPriorityDownload;
        iPriorityDownload = null;
        iAllowedStorageUsage = iQuotaProvider.getAllowedStorageQuota(this);
        iAllowedCellUsage = iQuotaProvider.getAllowedCellQuota(this);
        iCurrentStorageUsage = 0.0D;
        iCurrentCellUsage = 0.0D;
        return;
    }

    private void ResumeOrig()
    {
label0:
        {
            iPauseDownloadEngine = false;
            if (iDownloadStop.isSet() && iDownloadStop.iPermission == EDownloadPermission.EDownloadBlockedPaused)
            {
                iDownloadStop.clear();
            }
            if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading)
            {
                if (iCurrentDownload == null)
                {
                    break label0;
                }
                setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading);
                com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Creating download thread from download resume").toString());
                iDownloadThread = new VirtuosoDownloadThread(iCurrentDownload);
                iDownloadThread.setPriority(1);
                iDownloadThread.start();
            }
            return;
        }
        setIdle();
    }

    private void reportErrorStatus(Bundle bundle)
    {
        if (com.penthera.virtuososdk.utility.CommonUtil.Config.BuildFeatures.isFlagSet(4))
        {
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked, bundle);
            return;
        } else
        {
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors, bundle);
            setIdle();
            return;
        }
    }

    private void sendBroadcastForDownloadUpdate(com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("download_update_type", edownloadcallbacktype.ordinal());
        bundle.putParcelable("download_update_data", parcelable);
        iDObserver.downloadUpdate(this, edownloadcallbacktype, bundle);
    }

    private void setIdle()
    {
        setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle);
    }

    private void setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus)
    {
        setStatus(evirtuosodownloadenginestatus, null);
    }

    private void setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus, Bundle bundle)
    {
        setStatus(evirtuosodownloadenginestatus, bundle, false);
    }

    private void setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus, Bundle bundle, boolean flag)
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Engine changing status: from ").append(iStatus.iStatus.name()).append(" to ").append(evirtuosodownloadenginestatus.name()).toString());
        if (evirtuosodownloadenginestatus == iStatus.iStatus && !flag)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "Status is the same not sending status change");
            return;
        }
        iStatus.iStatus = evirtuosodownloadenginestatus;
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        iStatus.iExtras = bundle1;
        bundle = new VirtuosoDownloadEngineStatus();
        bundle.iExtras = bundle1;
        bundle.iStatus = evirtuosodownloadenginestatus;
        sendBroadcastForDownloadUpdate(com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EStatusChange, bundle);
    }

    void BatterySettingChanged(Bundle bundle)
    {
        String s = bundle.getString("battery_threshold");
        if (s == null)
        {
            s = "-1";
        }
        double d = Double.parseDouble(s);
        iBatterySettingsBundle.putInt("battery_threshold", (int)(d * 100D));
        if (bundle.containsKey("battery_threshold_override"))
        {
            bundle = bundle.getString("battery_threshold_override");
            if (bundle == null)
            {
                bundle = "-1";
            }
            double d1 = Double.parseDouble(bundle);
            iBatterySettingsBundle.putInt("battery_threshold_override", (int)(d1 * 100D));
        } else
        {
            iBatterySettingsBundle.remove("battery_threshold_override");
        }
        onBatteryLevelChanged(-1);
    }

    void InitiliazationComplete(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        }
        String s = bundle.getString("battery_threshold");
        if (s == null)
        {
            s = "-1";
        }
        double d = Double.parseDouble(s);
        iBatterySettingsBundle.putInt("battery_threshold", (int)(100D * d));
        if (bundle.containsKey("battery_threshold_override"))
        {
            String s1 = bundle.getString("battery_threshold_override");
            if (s1 == null)
            {
                s1 = "-1";
            }
            double d1 = Double.parseDouble(s1);
            iBatterySettingsBundle.putInt("battery_threshold_override", (int)(100D * d1));
        }
        if (!bundle.containsKey("client_configuration_headers")) goto _L2; else goto _L1
_L1:
        Object obj = bundle.getString("client_configuration_headers");
        obj = new JSONObject(((String) (obj)));
        Object obj2;
        obj = ((JSONObject) (obj)).getJSONArray("headers");
        obj2 = new Bundle();
        int i = 0;
_L8:
        int j = ((JSONArray) (obj)).length();
        if (i < j) goto _L3; else goto _L2
_L2:
        int k;
        char c;
        k = 60000;
        c = '\u7530';
        obj2 = bundle.getString("client_configuration_conn_to");
        obj = bundle.getString("client_configuration_socket_to");
        j = k;
        if (TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L5; else goto _L4
_L4:
        i = -1;
        j = Integer.parseInt(((String) (obj2)));
        i = j;
_L10:
        j = k;
        if (i >= 0)
        {
            j = i;
        }
_L5:
        k = c;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L7; else goto _L6
_L6:
        i = -1;
        k = Integer.parseInt(((String) (obj)));
        i = k;
_L11:
        k = c;
        if (i >= 0)
        {
            k = i;
        }
_L7:
        Object obj1;
        setClientConfiguration(bundle.getBundle("client_configuration_headers"), k, j);
        bundle = bundle.getString("downloader_init_state");
        bundle = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.values()[Integer.parseInt(bundle)];
        if (bundle != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle)
        {
            JSONObject jsonobject;
            Iterator iterator;
            String s2;
            String s3;
            boolean flag;
            if (bundle == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            iPauseDownloadEngine = flag;
            setStatus(bundle);
            return;
        } else
        {
            setIdle();
            return;
        }
_L3:
        jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        iterator = jsonobject.keys();
_L9:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_370;
        }
        i++;
          goto _L8
        s2 = (String)iterator.next();
        s3 = jsonobject.optString(s2);
        if (!TextUtils.isEmpty(s3))
        {
            ((Bundle) (obj2)).putString(s2, s3);
        }
          goto _L9
        obj1;
_L12:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "INvalid JSON header object", ((Throwable) (obj1)));
          goto _L2
        Exception exception;
        exception;
          goto _L10
        obj1;
          goto _L11
        obj1;
          goto _L12
        obj1;
          goto _L12
    }

    void ItemRemoved(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        synchronized (VirtuosoDownloadThreadCreationLock)
        {
            ItemRemovedNoLock(ivirtuosoidentifier);
        }
        return;
        ivirtuosoidentifier;
        obj;
        JVM INSTR monitorexit ;
        throw ivirtuosoidentifier;
    }

    void ItemRemovedNoLock(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading) goto _L2; else goto _L1
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] remove item while downloading").toString());
        if (ivirtuosoidentifier == null || iCurrentDownload != null && ivirtuosoidentifier.uuid().equals(iCurrentDownload.uuid())) goto _L4; else goto _L3
_L3:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] not current download").toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("virtuoso_file", ivirtuosoidentifier);
        iDObserver.downloadUpdate(this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, bundle);
_L6:
        return;
_L4:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] is current download").toString());
        removeHandlerPermissionCheck(this);
        if (iDownloadThread != null)
        {
            VirtuosoDownloadThread virtuosodownloadthread = iDownloadThread;
            if (ivirtuosoidentifier.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired)
            {
                ivirtuosoidentifier = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileExpired;
            } else
            {
                ivirtuosoidentifier = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadFileRemoved;
            }
            virtuosodownloadthread.killDownloadWithCompletionCode(ivirtuosoidentifier);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] not current download state not download").toString());
        iRemoveRequestWhileNotDownloading = true;
        iCurrentDownload = null;
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("virtuoso_file", ivirtuosoidentifier);
        iDObserver.downloadUpdate(this, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved, bundle1);
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
        {
            setIdle();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void NewItem(Bundle bundle)
    {
        synchronized (VirtuosoDownloadThreadCreationLock)
        {
            NewItemOrig(bundle);
        }
        return;
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    void Pause()
    {
        iPauseDownloadEngine = true;
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading && iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
        {
            setStatus(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused);
        } else
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading && iDownloadThread != null)
        {
            iDownloadThread.killDownloadWithCompletionCode(com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedPaused);
            return;
        }
    }

    void PriorityDownload(Bundle bundle)
    {
        synchronized (VirtuosoDownloadThreadCreationLock)
        {
            PriorityDownloadOrig(bundle);
        }
        return;
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    void Resume()
    {
        synchronized (VirtuosoDownloadThreadCreationLock)
        {
            ResumeOrig();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void RetryOnStorageChange()
    {
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked && (iLastFileCompletionErrorCode == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedStorage || iLastFileCompletionErrorCode == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedHeadroom))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Creating Retry from blocked storage state").toString());
            setIdle();
        }
    }

    double availableCellUsage()
    {
        return iAllowedCellUsage - iCurrentCellUsage;
    }

    public boolean cellOkay(int i)
    {
        return iAllowedCellUsage >= iCurrentCellUsage + (double)i;
    }

    public void clearTestSettings()
    {
        iTestBundle.clear();
    }

    EDownloadPermission getDownloadPermission()
    {
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_AuthenticationFailure)
        {
            return EDownloadPermission.EDownloadBlockedAuthentication;
        }
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused || iPauseDownloadEngine)
        {
            return EDownloadPermission.EDownloadBlockedPaused;
        }
        boolean flag = false;
        iNetworkInfo = ((ConnectivityManager)iContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (iNetworkInfo != null)
        {
            if (iNetworkInfo.getType() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag && (!cellOkay(1) || !iTestBundle.getBoolean("enable_download_cell", true)))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Blocking download because of cellular considerations").toString());
            return EDownloadPermission.EDownloadBlockedCell;
        }
        if (flag && !iTestBundle.getBoolean("enable_download_wifi", true))
        {
            return EDownloadPermission.EDownloadBlockedWifi;
        }
        if (iNetworkInfo == null || iNetworkInfo != null && !iNetworkInfo.isAvailable())
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Blocking download because of no network").toString());
            return EDownloadPermission.EDownloadBlockedWifi;
        }
        if (!storageOkay(1))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Blocking download because storage not available").toString());
            return EDownloadPermission.EDownloadBlockedStorage;
        }
        iBatteryThreshold = iBatterySettingsBundle.getInt("battery_threshold_override", iBatterySettingsBundle.getInt("battery_threshold", -1));
        if (iBatteryThreshold < 0)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Blocking download for battery because we could not get the setting from the bundle!!").toString());
            return EDownloadPermission.EDownloadBlockedBattery;
        }
        if (!iTestBundle.getBoolean("battery_charging", iBatteryMonitor.isCharging()))
        {
            int i = iTestBundle.getInt("battery_level", iBatteryMonitor.getLevel());
            int j = Math.min(100, iBatteryThreshold);
            if (j > i)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] Blocking download because battery level (").append(i).append(") < setting (").append(j).append(")").toString());
                return EDownloadPermission.EDownloadBlockedBattery;
            }
        }
        return EDownloadPermission.EDownloadAllowed;
    }

    public void onBatteryLevelChanged(int i)
    {
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading && getDownloadPermission() == EDownloadPermission.EDownloadAllowed)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "battery change call resume");
            Resume();
        } else
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "battery change during download set resume pending");
            iPowerChangeResumePending = true;
            return;
        }
    }

    public void onConnectivityChange(NetworkInfo networkinfo)
    {
label0:
        {
            com.penthera.virtuososdk.utility.CommonUtil.NetworkHelpers.dump(networkinfo);
            com.penthera.virtuososdk.utility.CommonUtil.NetworkHelpers.dump((WifiManager)CommonUtil.getApplicationContext().getSystemService("wifi"));
            if (networkinfo != null && networkinfo.isAvailable())
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("c[ ")).append(iClientAuthority).append("] onConnectivityChange(): Network gained - current status ").append(iStatus.iStatus).toString());
                if (!iPauseDownloadEngine)
                {
                    boolean flag;
                    if (networkinfo.getType() == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag || cellOkay(1))
                    {
                        break label0;
                    }
                    com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "connectivity change cell not okay returning");
                }
            }
            return;
        }
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "connectivity change call resume");
            Resume();
            return;
        } else
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "connectivity change during download set resume pending");
            iConnChangeResumePending = true;
            return;
        }
    }

    public void onPowerConnected()
    {
        if (iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading && getDownloadPermission() == EDownloadPermission.EDownloadAllowed)
        {
            Resume();
        } else
        if (iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading)
        {
            iPowerChangeResumePending = true;
            return;
        }
    }

    public void onPowerDisconnected()
    {
    }

    public boolean powerStatusOK()
    {
        int i = iBatterySettingsBundle.getInt("battery_threshold_override", iBatterySettingsBundle.getInt("battery_threshold", -1));
        if (i >= 0)
        {
            if (iTestBundle.getBoolean("battery_charging", iBatteryMonitor.isCharging()))
            {
                return true;
            }
            int j = iTestBundle.getInt("battery_level", iBatteryMonitor.getLevel());
            if (Math.min(100, i) <= j)
            {
                return true;
            }
        }
        return false;
    }

    void removeHandlerPermissionCheck(Downloader downloader)
    {
        iHandler.removeMessages(1, downloader);
    }

    void requestPermissionChecks(Downloader downloader)
    {
        Message message = new Message();
        message.what = 1;
        message.obj = downloader;
        iHandler.sendMessageDelayed(message, 5000L);
    }

    public void setClientConfiguration(Bundle bundle, int i, int j)
    {
        iClientConfiguredHeaders = bundle;
        if (j > -1)
        {
            HTTP_SOCKET_TIMEOUT = j;
        } else
        {
            HTTP_SOCKET_TIMEOUT = 30000;
        }
        if (i > -1)
        {
            HTTP_CONNECTION_TIMEOUT = i;
            return;
        } else
        {
            HTTP_CONNECTION_TIMEOUT = 60000;
            return;
        }
    }

    public void setTestSettings(Bundle bundle)
    {
        boolean flag2 = false;
        boolean flag4 = false;
        boolean flag3 = false;
        boolean flag5 = false;
        int j = 0;
        int i = 0;
        if (bundle != null)
        {
            boolean flag;
            boolean flag1;
            if (iTestBundle.containsKey("battery_charging") && bundle.containsKey("battery_charging"))
            {
                boolean flag6 = iTestBundle.getBoolean("battery_charging");
                boolean flag7 = bundle.getBoolean("battery_charging");
                flag = flag4;
                flag1 = flag5;
                if (flag7 != flag6)
                {
                    if (flag7)
                    {
                        flag = true;
                        flag1 = flag5;
                    } else
                    {
                        flag1 = true;
                        flag = flag4;
                    }
                }
            } else
            {
                flag = flag4;
                flag1 = flag5;
                if (bundle.containsKey("battery_charging"))
                {
                    if (bundle.getBoolean("battery_charging"))
                    {
                        flag = true;
                        flag1 = flag5;
                    } else
                    {
                        flag1 = true;
                        flag = flag4;
                    }
                }
            }
            if (iTestBundle.containsKey("battery_level") && bundle.containsKey("battery_level"))
            {
                i = iTestBundle.getInt("battery_level");
                if (bundle.getInt("battery_level") != i)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            } else
            if (bundle.containsKey("battery_level"))
            {
                i = 1;
            }
            iTestBundle.putAll(bundle);
            j = i;
            flag2 = flag;
            flag3 = flag1;
            if (iTestBundle.containsKey("enable_download_wifi"))
            {
                bundle = (WifiManager)CommonUtil.getApplicationContext().getSystemService("wifi");
                j = i;
                flag2 = flag;
                flag3 = flag1;
                if (bundle != null)
                {
                    bundle.setWifiEnabled(iTestBundle.getBoolean("enable_download_wifi"));
                    flag3 = flag1;
                    flag2 = flag;
                    j = i;
                }
            }
        }
        if (flag2)
        {
            onPowerConnected();
        }
        if (flag3)
        {
            onPowerDisconnected();
        }
        if (j != 0)
        {
            onBatteryLevelChanged(iTestBundle.getInt("battery_level"));
        }
    }

    public IVirtuosoDownloadEngineStatus status()
    {
        return iStatus;
    }

    public boolean storageOkay(int i)
    {
        return iAllowedStorageUsage >= iCurrentStorageUsage + (double)i;
    }




















}

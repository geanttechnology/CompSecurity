// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.database.impl.provider.ProvidersInstance;
import com.penthera.virtuososdk.database.impl.provider.SettingsInstance;
import com.penthera.virtuososdk.download.DownloadEngineClientManager;
import com.penthera.virtuososdk.download.VirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback;
import com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback;
import com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback;
import com.penthera.virtuososdk.internal.interfaces.IEngVFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.penthera.virtuososdk.service:
//            VirtuosoServiceThread

public class VirtuosoService extends Service
{
    private class QuotaResetter
        implements Runnable
    {

        String client;
        final VirtuosoService this$0;

        public void run()
        {
            performQuotaReset(this, client, true);
        }

        public QuotaResetter(String s)
        {
            this$0 = VirtuosoService.this;
            super();
            client = s;
        }
    }


    private static int $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType[];
    private static String LOG_TAG = "VirtuosoService";
    static VirtuosoServiceThread iServiceThread;
    ConcurrentHashMap QuotaResettersMap;
    private final long SEVEN_DAYS = 0x93a80L;
    private BroadcastReceiver iApiReceiver;
    private final com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD_TYPE iBT;
    private String iBackplaneBaseUrl;
    private final HashMap iClientDownloadCallbackList = new HashMap();
    private final HashMap iClientEngineCallbackList = new HashMap();
    private final HashMap iClientQueueCallbackList = new HashMap();
    private String iCurrentAuthority;
    private DownloadEngineClientManager iDownloaderClientManager;
    private Handler iHandler;
    private PowerManager iPowerManager;
    private List iProviderAuthList;
    private ProvidersInstance iProviders;
    private ContentResolver iResolver;
    private final com.penthera.virtuososdk.interfaces.IVirtuosoService.Stub iServiceInterfaceImpl = new com.penthera.virtuososdk.interfaces.IVirtuosoService.Stub() {

        final VirtuosoService this$0;

        public double allowableStorageRemaining(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "allowableStorageRemaining");
            return toMbytes(iDownloaderClientManager.availableStorage(s));
        }

        public boolean cellularDataQuotaOK(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "cellularDataQuotaOK");
            return iDownloaderClientManager.cellularDataQuotaOK(s);
        }

        public void cleanup(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "cleanup");
        }

        public void configure(Bundle bundle, int i, int j, String s)
            throws RemoteException
        {
            int k = i;
            if (i < 0)
            {
                k = -1;
            }
            i = j;
            if (j < 0)
            {
                i = -1;
            }
            iDownloaderClientManager.setClientConfiguration(bundle, k, i, s);
            s = new Bundle();
            if (bundle != null)
            {
                s.putBundle("client_configuration_headers", bundle);
            }
            s.putInt("client_configuration_conn_to", k);
            s.putInt("client_configuration_socket_to", i);
        }

        public boolean diskStatusOK(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "diskStatusOK");
            return iDownloaderClientManager.diskStatusOK() && toMbytes(iDownloaderClientManager.availableStorage(s)) > 0.0080000000000000002D;
        }

        public boolean enabled(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "enabled");
            return iDownloaderClientManager.status(s).status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Disabled;
        }

        public double getCurrentThroughput(String s)
            throws RemoteException
        {
            return iDownloaderClientManager.getCurrentThroughput(s);
        }

        public double getOverallThroughput(String s)
            throws RemoteException
        {
            return iDownloaderClientManager.getOverallThroughput(s);
        }

        public void markComplete(IVirtuosoIdentifier ivirtuosoidentifier, String s)
            throws RemoteException
        {
            if (ivirtuosoidentifier.type() == 1)
            {
                ((IEngVFile)ivirtuosoidentifier).setPending(false);
                ((IEngVFile)ivirtuosoidentifier).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete);
            }
            if (ivirtuosoidentifier.type() == 4)
            {
                ((IEngVHLSFile)ivirtuosoidentifier).setPending(false);
                ((IEngVHLSFile)ivirtuosoidentifier).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete);
            }
            s = new Bundle();
            s.putInt("download_update_type", com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadEnd.ordinal());
            s.putParcelable("download_update_data", ivirtuosoidentifier);
            ivirtuosoidentifier = new VirtuosoDownloadEngineStatus();
            ivirtuosoidentifier.iExtras = new Bundle();
            ((VirtuosoDownloadEngineStatus) (ivirtuosoidentifier)).iExtras.putInt("failure_reason", 0);
            ivirtuosoidentifier.iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle;
            s = new Bundle();
            s.putInt("download_update_type", com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EStatusChange.ordinal());
            s.putParcelable("download_update_data", ivirtuosoidentifier);
        }

        public void markErrored(IVirtuosoIdentifier ivirtuosoidentifier, int i, String s)
            throws RemoteException
        {
            new Bundle();
            s = new VirtuosoDownloadEngineStatus();
            s.iExtras = new Bundle();
            ((VirtuosoDownloadEngineStatus) (s)).iExtras.putInt("failure_reason", i);
            ((VirtuosoDownloadEngineStatus) (s)).iExtras.putParcelable("virtuoso_file", ivirtuosoidentifier);
            s.iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors;
            ivirtuosoidentifier = new Bundle();
            ivirtuosoidentifier.putInt("download_update_type", com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EStatusChange.ordinal());
            ivirtuosoidentifier.putParcelable("download_update_data", s);
            ivirtuosoidentifier = new VirtuosoDownloadEngineStatus();
            ivirtuosoidentifier.iExtras = new Bundle();
            ((VirtuosoDownloadEngineStatus) (ivirtuosoidentifier)).iExtras.putInt("failure_reason", 0);
            ivirtuosoidentifier.iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle;
            s = new Bundle();
            s.putInt("download_update_type", com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EStatusChange.ordinal());
            s.putParcelable("download_update_data", ivirtuosoidentifier);
        }

        public boolean networkStatusOK(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "networkStatusOK");
            return iDownloaderClientManager.networkStatusOK(s, iDownloaderClientManager.cellularDataQuotaOK(s));
        }

        public void pauseDownloads(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "pauseDownloads");
            iDownloaderClientManager.pauseClient(s);
        }

        public boolean powerStatusOK(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "powerStatusOK");
            return iDownloaderClientManager.powerStatusOK(s);
        }

        public int queueSize(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "queueSize");
            return iDownloaderClientManager.fullPendingQueueSize(s);
        }

        public long quotaRecordingStart(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "quotaRecordingStart");
            return iDownloaderClientManager.cellQuotaStart(s);
        }

        public void registerDownloadCallbackHandler(IVirtuosoDownloadedCallback ivirtuosodownloadedcallback, String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "registerDownloadCallbackHandler for download updates");
            if (ivirtuosodownloadedcallback != null)
            {
                if (!iClientDownloadCallbackList.containsKey(s))
                {
                    iClientDownloadCallbackList.put(s, new RemoteCallbackList());
                }
                ((RemoteCallbackList)iClientDownloadCallbackList.get(s)).register(ivirtuosodownloadedcallback);
            }
        }

        public void registerEngineCallbackHandler(IVirtuosoEngineCallback ivirtuosoenginecallback, String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "registerEngineCallbackHandler for download updates");
            if (ivirtuosoenginecallback != null)
            {
                if (!iClientEngineCallbackList.containsKey(s))
                {
                    iClientEngineCallbackList.put(s, new RemoteCallbackList());
                }
                ((RemoteCallbackList)iClientEngineCallbackList.get(s)).register(ivirtuosoenginecallback);
            }
        }

        public void registerQueueCallbackHandler(IVirtuosoDownloadQueueCallback ivirtuosodownloadqueuecallback, String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "registerQueueCallbackHandler for download updates");
            if (ivirtuosodownloadqueuecallback != null)
            {
                if (!iClientQueueCallbackList.containsKey(s))
                {
                    iClientQueueCallbackList.put(s, new RemoteCallbackList());
                }
                ((RemoteCallbackList)iClientQueueCallbackList.get(s)).register(ivirtuosodownloadqueuecallback);
            }
        }

        public void resetCellularDataQuota(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "resetCellularDataQuota");
            if (!QuotaResettersMap.containsKey(s))
            {
                QuotaResettersMap.put(s, new QuotaResetter(s));
            }
            performQuotaReset((QuotaResetter)QuotaResettersMap.get(s), s, true);
        }

        public void resetErrorQueue(String s)
            throws RemoteException
        {
            iDownloaderClientManager.resetErrorQueue(s);
        }

        public void resetTestSettings(String s)
            throws RemoteException
        {
            iDownloaderClientManager.clearTestSettings(s);
        }

        public void resumeDownloads(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "resumeDownloads");
            iDownloaderClientManager.resumeClient(s);
        }

        public void setTestSettings(Bundle bundle, String s)
            throws RemoteException
        {
            if (bundle != null)
            {
                if (bundle.containsKey("headroom_override"))
                {
                    bundle.putDouble("headroom_override", toBytes(bundle.getDouble("headroom_override")));
                }
                if (bundle.containsKey("max_storage_override"))
                {
                    bundle.putDouble("max_storage_override", toBytes(bundle.getDouble("max_storage_override")));
                }
            }
            iDownloaderClientManager.setTestSettings(bundle, s);
        }

        public void signalDelete(String s, IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            iDownloaderClientManager.clientDeletedItem(s, ivirtuosoidentifier);
        }

        public void signalDownloadSettingChange(String s, int i)
            throws RemoteException
        {
            if ((i & 0x20) > 0 || (i & 0x10) > 0 || (i & 0x80) > 0 || (i & 0x400) > 0 || (i & 0x100) > 0)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "doInterruptOnSettingChange");
                iDownloaderClientManager.clientSettingChange(s, i);
            }
            Bundle bundle = new Bundle();
            bundle.putString("com.penthera.virtuososdk.client.pckg", s);
            bundle.putInt("flags", i);
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.SETTING_CHANGED", bundle);
        }

        public void signalExpire(String s, IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            iDownloaderClientManager.clientExpiredItem(s, ivirtuosoidentifier);
        }

        public void signalQueueChange(String s, boolean flag)
            throws RemoteException
        {
            if (flag)
            {
                iDownloaderClientManager.clientQueueChange(s);
            }
            Bundle bundle = new Bundle();
            bundle.putString("com.penthera.virtuososdk.client.pckg", s);
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.QUEUE_CHANGED", bundle);
        }

        public IVirtuosoDownloadEngineStatus status(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "status");
            return iDownloaderClientManager.status(s);
        }

        public double storageUsed(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "storageUsed");
            return toMbytes(iDownloaderClientManager.storageUsed(s));
        }

        public double totalFileSize(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "totalFileSize");
            return toMbytes(iDownloaderClientManager.totalFileSize(s));
        }

        public void unregisterDownloadCallbackHandler(IVirtuosoDownloadedCallback ivirtuosodownloadedcallback, String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "unregisterDownloadCallbackHandler");
            if (ivirtuosodownloadedcallback != null && iClientDownloadCallbackList.containsKey(s))
            {
                ((RemoteCallbackList)iClientDownloadCallbackList.get(s)).unregister(ivirtuosodownloadedcallback);
                System.gc();
            }
        }

        public void unregisterEngineCallbackHandler(IVirtuosoEngineCallback ivirtuosoenginecallback, String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "unregisterEngineCallbackHandler");
            if (ivirtuosoenginecallback != null && iClientEngineCallbackList.containsKey(s))
            {
                ((RemoteCallbackList)iClientEngineCallbackList.get(s)).unregister(ivirtuosoenginecallback);
                System.gc();
            }
        }

        public void unregisterQueueCallbackHandler(IVirtuosoDownloadQueueCallback ivirtuosodownloadqueuecallback, String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "unregisterQueueCallbackHandler");
            if (ivirtuosodownloadqueuecallback != null && iClientQueueCallbackList.containsKey(s))
            {
                ((RemoteCallbackList)iClientQueueCallbackList.get(s)).unregister(ivirtuosodownloadqueuecallback);
                System.gc();
            }
        }

        public double utilizedCellularDataQuota(String s)
            throws RemoteException
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoService.LOG_TAG, "utilizedCellularDataQuota");
            return iDownloaderClientManager.usedCellQuota(s);
        }

            
            {
                this$0 = VirtuosoService.this;
                super();
            }
    };
    private boolean iServiceStarted;

    static int[] $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()
    {
        int ai[] = $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.values().length];
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.ECollectionComplete.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.ECollectionProgress.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.ECollectionsChanged.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.ECollectionsDeleted.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadEnd.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadQueueChanged.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadStart.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadedListChanged.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EFragmentComplete.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EFullListChanged.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemDownloadRemoved.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EItemUpdate.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EListFiles.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EListFilesIteratively.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EProgressUpdate.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.ESettingsChanged.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EStatusChange.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType = ai;
        return ai;
    }

    public VirtuosoService()
    {
        iServiceStarted = false;
        iBackplaneBaseUrl = null;
        iBT = com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD;
        iHandler = null;
        iProviders = null;
        QuotaResettersMap = new ConcurrentHashMap();
        iApiReceiver = new BroadcastReceiver() {

            final VirtuosoService this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                if (context == null)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e("VirtuosoService-ApiReceiver", "onReceive(): null action");
                } else
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.d("VirtuosoService-ApiReceiver", (new StringBuilder("got action [")).append(context).append("]").toString());
                    if (!context.equals("virtuoso.intent.action.COMMS_FAILURE"))
                    {
                        if (context.equals("virtuoso.intent.action.QUEUE_CHANGED"))
                        {
                            context = intent.getExtras();
                            performDownloadEngineCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadQueueChanged, context);
                            performEngineCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EFullListChanged, context);
                            return;
                        }
                        if (context.equals("virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"))
                        {
                            context = intent.getExtras();
                            performDownloadEngineCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EDownloadedListChanged, context);
                            performEngineCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EFullListChanged, context);
                            return;
                        }
                        if (context.equals("virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK"))
                        {
                            context = intent.getExtras();
                            performQueueCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EFragmentComplete, context);
                            return;
                        }
                        if (context.equals("virtuoso.intent.action.DOWNLOAD_CALLBACK"))
                        {
                            if (!iServiceStarted)
                            {
                                com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast("virtuoso.intent.action.DOWNLOAD_UPDATE");
                            }
                            context = intent.getExtras();
                            performDownloadEngineCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.values()[context.getInt("download_update_type")], context.getParcelable("download_update_data"));
                            return;
                        }
                        if (context.equals("virtuoso.intent.action.SETTING_CHANGED"))
                        {
                            context = intent.getExtras();
                            performDownloadEngineCallback(context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.ESettingsChanged, context);
                            return;
                        } else
                        {
                            com.penthera.virtuososdk.utility.CommonUtil.Log.w("VirtuosoService-ApiReceiver", (new StringBuilder("onReceive(): unknown action: ")).append(context).toString());
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = VirtuosoService.this;
                super();
            }
        };
    }

    private void initCellQuota(String s)
    {
        if (!QuotaResettersMap.containsKey(s))
        {
            QuotaResettersMap.put(s, new QuotaResetter(s));
        }
        QuotaResetter quotaresetter = (QuotaResetter)QuotaResettersMap.get(s);
        long l = (new Date()).getTime() / 1000L;
        long l1 = iDownloaderClientManager.cellQuotaStart(s);
        if (l - 0x93a80L <= l1)
        {
            performQuotaReset(quotaresetter, s, true);
            return;
        } else
        {
            iHandler.removeCallbacks(quotaresetter);
            iHandler.postDelayed(quotaresetter, ((l1 + 0x93a80L) - l) * 1000L);
            return;
        }
    }

    private void initCellQuotas()
    {
        Iterator iterator = iProviderAuthList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            initCellQuota((String)iterator.next());
        } while (true);
    }

    private boolean isServiceThreadAlive()
    {
        this;
        JVM INSTR monitorenter ;
        if (iServiceThread == null) goto _L2; else goto _L1
_L1:
        boolean flag = iServiceThread.isAlive();
        if (flag) goto _L3; else goto _L2
_L2:
        flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private void performDownloadEngineCallback(String s, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        this;
        JVM INSTR monitorenter ;
        performDownloadEngineCallbackOnNewInterfaces(s, edownloadcallbacktype, parcelable);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void performDownloadEngineCallbackOnNewInterfaces(String s, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        this;
        JVM INSTR monitorenter ;
        $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[edownloadcallbacktype.ordinal()];
        JVM INSTR tableswitch 1 16: default 218
    //                   1 152
    //                   2 114
    //                   3 114
    //                   4 114
    //                   5 114
    //                   6 185
    //                   7 152
    //                   8 111
    //                   9 88
    //                   10 152
    //                   11 88
    //                   12 152
    //                   13 152
    //                   14 114
    //                   15 114
    //                   16 114;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L4 _L2 _L5 _L1 _L2 _L1 _L2 _L2 _L3 _L3 _L3
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("performDownloadEngineCallbackOnNewInterfaces unhandled message ")).append(edownloadcallbacktype).toString());
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performDownloadEngineCallbackOnNewInterfaces ")).append(edownloadcallbacktype).toString());
        performQueueCallback(s, edownloadcallbacktype, parcelable);
          goto _L5
        s;
        throw s;
_L2:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performDownloadEngineCallbackOnNewInterfaces ")).append(edownloadcallbacktype).toString());
        performEngineCallback(s, edownloadcallbacktype, parcelable);
          goto _L5
_L4:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performDownloadEngineCallbackOnNewInterfaces ")).append(edownloadcallbacktype).toString());
        performDownloadedCallback(s, edownloadcallbacktype, parcelable);
          goto _L5
    }

    private void performDownloadedCallback(String s, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        this;
        JVM INSTR monitorenter ;
        RemoteCallbackList remotecallbacklist = (RemoteCallbackList)iClientDownloadCallbackList.get(s);
        if (remotecallbacklist != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j = remotecallbacklist.beginBroadcast();
        int i = 0;
          goto _L3
_L12:
        remotecallbacklist.finishBroadcast();
        if (true) goto _L1; else goto _L4
_L4:
        s;
        throw s;
_L13:
        $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[edownloadcallbacktype.ordinal()];
        JVM INSTR tableswitch 6 9: default 289
    //                   6 238
    //                   7 88
    //                   8 88
    //                   9 114;
           goto _L5 _L6 _L5 _L5 _L7
_L5:
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("performDownloadedCallback unhandled message ")).append(edownloadcallbacktype).toString());
          goto _L8
_L7:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performDownloadedCallback ")).append(edownloadcallbacktype).toString());
        s = (Bundle)parcelable;
        if (com.penthera.virtuososdk.utility.CommonUtil.FileAction.values()[s.getInt("manage_files_action")] != com.penthera.virtuososdk.utility.CommonUtil.FileAction.EListDownloaded) goto _L8; else goto _L9
_L9:
        Parcelable parcelable1;
        int k;
        int l;
        k = s.getInt("manage_files_list_size");
        l = s.getInt("manage_files_index");
        parcelable1 = s.getParcelable("virtuoso_file");
        s = null;
        if (parcelable1 == null) goto _L11; else goto _L10
_L10:
        s = (IVirtuosoIdentifier)parcelable1;
_L11:
        ((IVirtuosoDownloadedCallback)remotecallbacklist.getBroadcastItem(i)).engineContentInDownloadedList(s, l, k);
          goto _L8
        s;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(com/penthera/virtuososdk/service/VirtuosoService.getName(), "Exception during performDownloadedCallback callbacks", s);
          goto _L12
_L6:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performDownloadedCallback ")).append(edownloadcallbacktype).toString());
        ((IVirtuosoDownloadedCallback)remotecallbacklist.getBroadcastItem(i)).engineDownloadedListChanged();
          goto _L8
_L3:
        if (i < j) goto _L13; else goto _L12
_L8:
        i++;
          goto _L3
    }

    private void performEngineCallback(String s, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        this;
        JVM INSTR monitorenter ;
        RemoteCallbackList remotecallbacklist = (RemoteCallbackList)iClientEngineCallbackList.get(s);
        if (remotecallbacklist != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j = remotecallbacklist.beginBroadcast();
        int i = 0;
          goto _L3
_L14:
        remotecallbacklist.finishBroadcast();
        if (true) goto _L1; else goto _L4
_L4:
        s;
        throw s;
_L24:
        $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[edownloadcallbacktype.ordinal()];
        JVM INSTR tableswitch 1 13: default 725
    //                   1 150
    //                   2 124
    //                   3 124
    //                   4 124
    //                   5 124
    //                   6 124
    //                   7 460
    //                   8 124
    //                   9 292
    //                   10 408
    //                   11 648
    //                   12 501
    //                   13 576;
           goto _L5 _L6 _L5 _L5 _L5 _L5 _L5 _L7 _L5 _L8 _L9 _L10 _L11 _L12
_L5:
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("performEngineCallback unhandled message ")).append(edownloadcallbacktype).toString());
          goto _L13
_L6:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).downloadEngineStatusDidChange((IVirtuosoDownloadEngineStatus)parcelable);
        IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus = (IVirtuosoDownloadEngineStatus)parcelable;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Got status change ")).append(ivirtuosodownloadenginestatus.status()).toString());
        if (ivirtuosodownloadenginestatus.status() == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors && ((VirtuosoDownloadEngineStatus)ivirtuosodownloadenginestatus).extras().containsKey("virtuoso_file"))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "status change has file");
            performQueueCallback(s, edownloadcallbacktype, parcelable);
        }
          goto _L13
        s;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(com/penthera/virtuososdk/service/VirtuosoService.getName(), "Exception during performEngineCallback callbacks", s);
          goto _L14
_L8:
        Object obj;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        obj = (Bundle)parcelable;
        if (com.penthera.virtuososdk.utility.CommonUtil.FileAction.values()[((Bundle) (obj)).getInt("manage_files_action")] != com.penthera.virtuososdk.utility.CommonUtil.FileAction.EListAllFiles) goto _L13; else goto _L15
_L15:
        Parcelable parcelable1;
        int k;
        int l;
        k = ((Bundle) (obj)).getInt("manage_files_list_size");
        l = ((Bundle) (obj)).getInt("manage_files_index");
        parcelable1 = ((Bundle) (obj)).getParcelable("virtuoso_file");
        obj = null;
        if (parcelable1 == null) goto _L17; else goto _L16
_L16:
        obj = (IVirtuosoIdentifier)parcelable1;
_L17:
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).engineContentInList(((IVirtuosoIdentifier) (obj)), l, k);
          goto _L13
_L9:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).settingChanged(((Bundle)parcelable).getInt("flags", 0));
          goto _L13
_L7:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).engineListChanged();
          goto _L13
_L11:
        Object aobj[];
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        aobj = ((Bundle)parcelable).getParcelableArray("virtuoso_files");
        if (aobj != null) goto _L19; else goto _L18
_L18:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Collection changed array is NULL!");
          goto _L13
_L19:
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).collectionsChanged((IVirtuosoIdentifier[])aobj);
          goto _L13
_L12:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        aobj = ((Bundle)parcelable).getStringArray("virtuoso_files");
        if (aobj != null) goto _L21; else goto _L20
_L20:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Collection changed array is NULL!");
          goto _L13
_L21:
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).collectionsDeleted(((String []) (aobj)));
          goto _L13
_L10:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performEngineCallback ")).append(edownloadcallbacktype).toString());
        if (parcelable == null) goto _L13; else goto _L22
_L22:
        aobj = ((Bundle)parcelable).getParcelable("virtuoso_file");
        if (aobj == null) goto _L13; else goto _L23
_L23:
        ((IVirtuosoEngineCallback)remotecallbacklist.getBroadcastItem(i)).itemUpdated((IVirtuosoIdentifier)aobj);
          goto _L13
_L3:
        if (i < j) goto _L24; else goto _L14
_L13:
        i++;
          goto _L3
    }

    private void performQueueCallback(String s, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        this;
        JVM INSTR monitorenter ;
        RemoteCallbackList remotecallbacklist = (RemoteCallbackList)iClientQueueCallbackList.get(s);
        if (remotecallbacklist != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int k = remotecallbacklist.beginBroadcast();
        int i = 0;
          goto _L3
_L41:
        remotecallbacklist.finishBroadcast();
        if (true) goto _L1; else goto _L4
_L4:
        s;
        throw s;
_L42:
        $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[edownloadcallbacktype.ordinal()];
        JVM INSTR tableswitch 1 16: default 1160
    //                   1 162
    //                   2 366
    //                   3 486
    //                   4 606
    //                   5 834
    //                   6 136
    //                   7 136
    //                   8 136
    //                   9 726
    //                   10 136
    //                   11 136
    //                   12 136
    //                   13 136
    //                   14 875
    //                   15 947
    //                   16 1019;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L5 _L5 _L5 _L11 _L5 _L5 _L5 _L5 _L12 _L13 _L14
_L5:
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("performQueueCallback unhandled message ")).append(edownloadcallbacktype).toString());
          goto _L15
_L6:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = (IVirtuosoDownloadEngineStatus)parcelable;
        if (s.status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors && s.status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked) goto _L15; else goto _L16
_L16:
        s = ((VirtuosoDownloadEngineStatus)s).extras();
        if (!s.containsKey("virtuoso_file")) goto _L15; else goto _L17
_L17:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "status change erred file");
        s = (IVirtuosoAsset)s.getParcelable("virtuoso_file");
        if (s == null) goto _L15; else goto _L18
_L18:
        double d;
        double d1;
        Object obj;
        String s1;
        int l;
        obj = (IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i);
        s1 = s.uuid();
        l = s.downloadStatus().ordinal();
        d = s.expectedSize();
        d1 = s.currentSize();
        if (s.type() != 4) goto _L20; else goto _L19
_L19:
        int j = ((IVirtuosoHLSFile)s).totalFragmentsComplete();
_L21:
        ((IVirtuosoDownloadQueueCallback) (obj)).downloadEngineFileWithErrorMin(s1, l, d, d1, j);
          goto _L15
        s;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(com/penthera/virtuososdk/service/VirtuosoService.getName(), "Exception during performQueueCallback callbacks", s);
        break; /* Loop/switch isn't completed */
_L20:
        j = 0;
          goto _L21
_L7:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = (IVirtuosoAsset)parcelable;
        if (s == null) goto _L15; else goto _L22
_L22:
        obj = (IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i);
        s1 = s.uuid();
        l = s.downloadStatus().ordinal();
        d = s.expectedSize();
        d1 = s.currentSize();
        if (s.type() != 4) goto _L24; else goto _L23
_L23:
        j = ((IVirtuosoHLSFile)s).totalFragmentsComplete();
_L43:
        ((IVirtuosoDownloadQueueCallback) (obj)).downloadEngineDidStartDownloadingFileMin(s1, l, d, d1, j);
          goto _L15
_L8:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = (IVirtuosoAsset)parcelable;
        if (s == null) goto _L15; else goto _L25
_L25:
        obj = (IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i);
        s1 = s.uuid();
        l = s.downloadStatus().ordinal();
        d = s.expectedSize();
        d1 = s.currentSize();
        if (s.type() != 4) goto _L27; else goto _L26
_L26:
        j = ((IVirtuosoHLSFile)s).totalFragmentsComplete();
_L44:
        ((IVirtuosoDownloadQueueCallback) (obj)).downloadEngineProgressUpdatedForFileMin(s1, l, d, d1, j);
          goto _L15
_L9:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = (IVirtuosoAsset)parcelable;
        if (s == null) goto _L15; else goto _L28
_L28:
        obj = (IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i);
        s1 = s.uuid();
        l = s.downloadStatus().ordinal();
        d = s.expectedSize();
        d1 = s.currentSize();
        if (s.type() != 4) goto _L30; else goto _L29
_L29:
        j = ((IVirtuosoHLSFile)s).totalFragmentsComplete();
_L45:
        ((IVirtuosoDownloadQueueCallback) (obj)).downloadEngineDidFinishDownloadingFileMin(s1, l, d, d1, j);
          goto _L15
_L11:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = (Bundle)parcelable;
        if (com.penthera.virtuososdk.utility.CommonUtil.FileAction.values()[s.getInt("manage_files_action")] != com.penthera.virtuososdk.utility.CommonUtil.FileAction.EListQueued) goto _L15; else goto _L31
_L31:
        j = s.getInt("manage_files_list_size");
        l = s.getInt("manage_files_index");
        obj = s.getParcelable("virtuoso_file");
        s = null;
        if (obj == null) goto _L33; else goto _L32
_L32:
        s = (IVirtuosoIdentifier)obj;
_L33:
        ((IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i)).engineContentInQueuedList(s, l, j);
          goto _L15
_L10:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        ((IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i)).engineDownloadQueueChanged();
          goto _L15
_L12:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = ((Bundle)parcelable).getParcelableArray("virtuoso_files");
        if (s != null) goto _L35; else goto _L34
_L34:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Collection array is NULL!");
          goto _L15
_L35:
        ((IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i)).collectionsProgressUpdated((IVirtuosoIdentifier[])s);
          goto _L15
_L13:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = ((Bundle)parcelable).getParcelableArray("virtuoso_files");
        if (s != null) goto _L37; else goto _L36
_L36:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Collection array is NULL!");
          goto _L15
_L37:
        ((IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i)).collectionsComplete((IVirtuosoIdentifier[])s);
          goto _L15
_L14:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("performQueueCallback ")).append(edownloadcallbacktype).toString());
        s = (IVirtuosoAsset)((Bundle)parcelable).getParcelable("virtuoso_file");
        obj = (IVirtuosoDownloadQueueCallback)remotecallbacklist.getBroadcastItem(i);
        s1 = s.uuid();
        l = s.downloadStatus().ordinal();
        d = s.expectedSize();
        d1 = s.currentSize();
        if (s.type() != 4) goto _L39; else goto _L38
_L38:
        j = ((IVirtuosoHLSFile)s).totalFragmentsComplete();
_L40:
        ((IVirtuosoDownloadQueueCallback) (obj)).fragmentCompleteMin(s1, l, d, d1, j);
          goto _L15
_L39:
        j = 0;
          goto _L40
_L3:
        if (i < k) goto _L42; else goto _L41
_L15:
        i++;
          goto _L3
_L24:
        j = 0;
          goto _L43
_L27:
        j = 0;
          goto _L44
_L30:
        j = 0;
          goto _L45
    }

    private void performQuotaReset(QuotaResetter quotaresetter, String s, boolean flag)
    {
        iHandler.removeCallbacks(quotaresetter);
        SettingsInstance settingsinstance = new SettingsInstance(iResolver, s);
        settingsinstance.set("cell_quota_start_date", (new StringBuilder()).append((new Date()).getTime() / 1000L).toString());
        settingsinstance.set("cell_quota_used", "0");
        if (flag)
        {
            iDownloaderClientManager.clientSettingChange(s, 64);
        }
        iHandler.postDelayed(quotaresetter, 0x240c8400L);
    }

    private void registerApiReceiver()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(iApiReceiver, new IntentFilter("virtuoso.intent.action.COMMS_FAILURE"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(iApiReceiver, new IntentFilter("virtuoso.intent.action.QUEUE_CHANGED"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(iApiReceiver, new IntentFilter("virtuoso.intent.action.SETTING_CHANGED"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(iApiReceiver, new IntentFilter("virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(iApiReceiver, new IntentFilter("virtuoso.intent.action.DOWNLOAD_CALLBACK"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(iApiReceiver, new IntentFilter("virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK"));
    }

    private boolean startServiceThread()
    {
        this;
        JVM INSTR monitorenter ;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "startServiceThread(): Aquiring cpu level wake lock before starting the sync thread");
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    private double toBytes(double d)
    {
        if (d < 0.0D)
        {
            return -1D;
        } else
        {
            return d * 1024D * 1024D;
        }
    }

    private double toMbytes(double d)
    {
        if (d < 0.0D)
        {
            return d != -1000D ? -1D : -1000D;
        } else
        {
            return d / 1024D / 1024D;
        }
    }

    private void unregisterApiReceiver()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.unregisterLocalReceiver(iApiReceiver);
    }

    public IBinder onBind(final Intent auth)
    {
        auth = auth.getExtras();
        if (auth != null)
        {
            auth = auth.getString("com.penthera.virtuososdk.client.pckg");
            if (!TextUtils.isEmpty(auth) && !iProviderAuthList.contains(auth))
            {
                iDownloaderClientManager.initClient(auth);
                initCellQuota(auth);
                (new Thread(new Runnable() {

                    final VirtuosoService this$0;
                    private final String val$auth;

                    public void run()
                    {
                        iProviderAuthList = iProviders.addProvider(auth);
                        if (!iClientDownloadCallbackList.containsKey(auth))
                        {
                            iClientDownloadCallbackList.put(auth, new RemoteCallbackList());
                        }
                        if (!iClientQueueCallbackList.containsKey(auth))
                        {
                            iClientQueueCallbackList.put(auth, new RemoteCallbackList());
                        }
                        if (!iClientEngineCallbackList.containsKey(auth))
                        {
                            iClientEngineCallbackList.put(auth, new RemoteCallbackList());
                        }
                    }

            
            {
                this$0 = VirtuosoService.this;
                auth = s;
                super();
            }
                })).start();
            }
        }
        return iServiceInterfaceImpl;
    }

    public void onCreate()
    {
        super.onCreate();
        iHandler = new Handler();
        CommonUtil.setApplicationContext(getApplicationContext());
        try
        {
            iCurrentAuthority = getApplicationContext().getPackageManager().getApplicationInfo(getApplicationContext().getPackageName(), 128).metaData.getString("com.penthera.virtuososdk.client.pckg");
        }
        catch (Exception exception)
        {
            throw new RuntimeException("cannot retrieve authority", exception);
        }
        if (TextUtils.isEmpty(iCurrentAuthority))
        {
            throw new RuntimeException("cannot retrieve client. was the metadata for com.penthera.virtuososdk.client.pckg specified in the manifest under application?");
        } else
        {
            iProviders = new ProvidersInstance(getApplicationContext().getContentResolver(), iCurrentAuthority);
            iProviderAuthList = iProviders.addProvider(iCurrentAuthority);
            iClientDownloadCallbackList.put(iCurrentAuthority, new RemoteCallbackList());
            iClientQueueCallbackList.put(iCurrentAuthority, new RemoteCallbackList());
            iClientEngineCallbackList.put(iCurrentAuthority, new RemoteCallbackList());
            iResolver = getApplicationContext().getContentResolver();
            iDownloaderClientManager = DownloadEngineClientManager.getInstance(getApplicationContext(), iCurrentAuthority);
            initCellQuotas();
            registerApiReceiver();
            iPowerManager = (PowerManager)getSystemService("power");
            com.penthera.virtuososdk.utility.CommonUtil.Directory.createRoot(CommonUtil.getApplicationContext());
            return;
        }
    }

    public void onDestroy()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "onDestroy(): Entering the onDestroy method");
        unregisterApiReceiver();
        iDownloaderClientManager.release();
        super.onDestroy();
    }

    public void onLowMemory()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "Service: OnLowMemory()");
        super.onLowMemory();
    }

    public void onRebind(Intent intent)
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "onRebind");
        super.onRebind(intent);
    }

    public void onStart(Intent intent, int i)
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "onStart(): Entering the onStart method");
        iServiceStarted = true;
        if (intent == null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "c): Intent is null: not starting service");
        } else
        {
            String s = intent.getAction();
            if (s == null)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "onStart(): No Action: not starting service");
                return;
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("onStart(): action is ")).append(s).toString());
            if (s.equals("virtuoso.intent.action.START_VIRTUOSO_SERVICE_LOGGING"))
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.a(LOG_TAG, "setting log level");
                i = intent.getExtras().getInt("loglevel", 0);
                com.penthera.virtuososdk.utility.CommonUtil.Log.iLogLevel = i;
                com.penthera.virtuososdk.utility.CommonUtil.Log.a(LOG_TAG, (new StringBuilder("setting log level to ")).append(i).toString());
            }
            if (s.equals("android.intent.action.BOOT_COMPLETED") && !isServiceThreadAlive())
            {
                startServiceThread();
                return;
            }
        }
    }

    public boolean onUnbind(Intent intent)
    {
        return false;
    }















}

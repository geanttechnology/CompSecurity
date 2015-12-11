// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.StatFs;
import android.text.TextUtils;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.database.impl.provider.ProvidersInstance;
import com.penthera.virtuososdk.database.impl.provider.RegistryInstance;
import com.penthera.virtuososdk.database.impl.provider.SettingsInstance;
import com.penthera.virtuososdk.interfaces.toolkit.VirtuosoContentBox;
import com.penthera.virtuososdk.internal.interfaces.IEngVFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVIdentifier;
import com.penthera.virtuososdk.manager.FileManager;
import com.penthera.virtuososdk.monitor.BatteryMonitor;
import com.penthera.virtuososdk.monitor.ConnectivityMonitor;
import com.penthera.virtuososdk.monitor.LocalWifiMonitor;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader, VirtuosoDownloadEngineStatus, MD5State

public final class DownloadEngineClientManager
    implements Downloader.DownloadQuotaProvider, Downloader.DownloaderObserver, com.penthera.virtuososdk.monitor.BatteryMonitor.IBatteryObserver, com.penthera.virtuososdk.monitor.ConnectivityMonitor.IOnConnectivityChangeObserver, com.penthera.virtuososdk.monitor.LocalWifiMonitor.IWifiCheckObserver
{
    private class ClientStorageInfo
    {

        String iAuthority;
        double iAvailable;
        double iAvailableForStorage;
        double iAvailableLessHeadroom;
        double iFree;
        double iTotal;
        double iUsedByApp;
        final DownloadEngineClientManager this$0;

        void reset()
        {
            iFree = 0.0D;
            iUsedByApp = 0.0D;
            iTotal = 0.0D;
            iAvailable = 0.0D;
            iAvailableForStorage = 0.0D;
            iAvailableLessHeadroom = 0.0D;
        }

        void update(SettingsInstance settingsinstance)
        {
            if (settingsinstance == null)
            {
                reset();
                return;
            } else
            {
                update(settingsinstance.get("root_destination_path"), settingsinstance);
                return;
            }
        }

        void update(String s, SettingsInstance settingsinstance)
        {
            if (!diskStatusOK() || TextUtils.isEmpty(s))
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, "no path resetting storage");
                reset();
                return;
            }
            String s1 = (new StringBuilder("+updateStorageInfo \"storage_info\":{\"free_storage\" : ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iFree)
            })).append(", \"total_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iTotal)
            })).append(", \"app_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iUsedByApp)
            })).append(", \"available\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAvailable)
            })).append(", \"availableLessHeadroom\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAvailableLessHeadroom)
            })).append(", \"available_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAvailableForStorage)
            })).append("}").toString();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, s1);
            s = new StatFs(s);
            long l = s.getAvailableBlocks();
            long l1 = s.getBlockSize();
            long l2 = s.getBlockCount();
            iFree = l * l1;
            iTotal = l2 * l1;
            iUsedByApp = calcDiskUsage(iAuthority);
            s = (new StringBuilder("from stat \"storage_info\":{\"free_storage\" : ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iFree)
            })).append(", \"total_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iTotal)
            })).append(", \"app_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iUsedByApp)
            })).append("}").toString();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, s);
            s1 = settingsinstance.get("headroom_override");
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = settingsinstance.get("headroom");
            }
            s1 = s;
            if (TextUtils.isEmpty(s))
            {
                s1 = "-1";
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, (new StringBuilder("headroom from registry [")).append(s1).append(" ]").toString());
            String s2 = settingsinstance.get("max_storage_override");
            s = s2;
            if (TextUtils.isEmpty(s2))
            {
                s = settingsinstance.get("max_storage");
            }
            settingsinstance = s;
            if (TextUtils.isEmpty(s))
            {
                settingsinstance = "-1";
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, (new StringBuilder("max storage from registry [")).append(settingsinstance).append(" ]").toString());
            double d = Double.parseDouble(settingsinstance);
            double d2 = Double.parseDouble(s1);
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, (new StringBuilder("After parse - max storage [ ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(d)
            })).append(" ] headroom [ ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(d2)
            })).append(" ]").toString());
            double d1;
            if (d == -1D)
            {
                d = iTotal;
            } else
            {
                d = Math.min(iTotal, d);
            }
            d1 = d2;
            if (d2 == -1D)
            {
                d1 = 0.0D;
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, (new StringBuilder("After checks for disabled -max storage [ ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(d)
            })).append(" ] headroom [ ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(d1)
            })).append(" ]").toString());
            iAvailableForStorage = Math.max(0.0D, d - iUsedByApp);
            iAvailableLessHeadroom = Math.max(0.0D, iFree - d1);
            iAvailable = iAvailableLessHeadroom;
            if (iAvailable > 0.0D)
            {
                iAvailable = Math.min(iAvailableLessHeadroom, iAvailableForStorage);
            }
            s = (new StringBuilder("-updateStorageInfo \"storage_info\":{\"free_storage\" : ")).append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iFree)
            })).append(", \"total_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iTotal)
            })).append(", \"app_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iUsedByApp)
            })).append(", \"available\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAvailable)
            })).append(", \"availableLessHeadroom\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAvailableLessHeadroom)
            })).append(", \"available_storage\" : ").append(String.format("%1$,.2f", new Object[] {
                Double.valueOf(iAvailableForStorage)
            })).append("}").toString();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(DownloadEngineClientManager.LOG_TAG, s);
        }

        ClientStorageInfo(String s)
        {
            this$0 = DownloadEngineClientManager.this;
            super();
            iFree = 0.0D;
            iUsedByApp = 0.0D;
            iTotal = 0.0D;
            iAvailable = 0.0D;
            iAvailableForStorage = 0.0D;
            iAvailableLessHeadroom = 0.0D;
            iAuthority = s;
        }
    }

    private class QueueException extends Exception
    {

        final DownloadEngineClientManager this$0;

        public QueueException(String s)
        {
            this$0 = DownloadEngineClientManager.this;
            super(s);
        }
    }


    private static int $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus[];
    private static int $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus[];
    private static int $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType[];
    private static final String LOG_TAG = com/penthera/virtuososdk/download/DownloadEngineClientManager.getName();
    private static final Handler iDiskCheckHandler = new Handler() {

        private void handleCheckStorage(Message message)
        {
            message = (Downloader)message.obj;
            ClientStorageInfo clientstorageinfo = (ClientStorageInfo)DownloadEngineClientManager.iDownloadClientStorage.get(((Downloader) (message)).iClientAuthority);
            SettingsInstance settingsinstance = (SettingsInstance)DownloadEngineClientManager.iDownloadClientSettings.get(((Downloader) (message)).iClientAuthority);
            if (clientstorageinfo == null)
            {
                return;
            }
            clientstorageinfo.update(settingsinstance);
            if (clientstorageinfo.iAvailable > 0.0D)
            {
                message.RetryOnStorageChange();
                return;
            } else
            {
                DownloadEngineClientManager.requestDiskCheck(message);
                return;
            }
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                com.penthera.virtuososdk.utility.CommonUtil.Log.e(DownloadEngineClientManager.LOG_TAG, (new StringBuilder("c[] Wrong message ")).append(message.what).toString());
                return;

            case 1: // '\001'
                handleCheckStorage(message);
                break;
            }
        }

    };
    private static ConcurrentHashMap iDownloadClientSettings;
    private static ConcurrentHashMap iDownloadClientStorage;
    private static ConcurrentHashMap iDownloadClients;
    private static SoftReference iInstance;
    private BatteryMonitor iBatteryMonitor;
    private ConnectivityMonitor iConnectivityMonitor;
    private Context iContext;
    private boolean iDbInit;
    private String iDefaultAuthority;
    Timer iErrorItemsTimer;
    FileManager iFileManager;
    private NetworkInfo iNetworkInfo;
    ProvidersInstance iProvidersInstance;
    private ContentResolver iResolver;
    private LocalWifiMonitor lwm;

    static int[] $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus()
    {
        int ai[] = $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[com.penthera.virtuososdk.Common.EFileDownloadStatus.values().length];
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete_Pending_Integrity_Check.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Corrupt.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_HLS_Fragment_Copy_Error.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Network_Error.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Reachability_Error.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Collection_Partially_Complete.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_HLS_Manifest_Processing.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus = ai;
        return ai;
    }

    static int[] $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus()
    {
        int ai[] = $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.values().length];
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_AuthenticationFailure.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Disabled.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus = ai;
        return ai;
    }

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

    private DownloadEngineClientManager(Context context, String s)
    {
        lwm = null;
        iFileManager = null;
        iErrorItemsTimer = null;
        iDbInit = false;
        iContext = context;
        iNetworkInfo = ((ConnectivityManager)iContext.getSystemService("connectivity")).getActiveNetworkInfo();
        iDefaultAuthority = s;
        iResolver = iContext.getContentResolver();
        iProvidersInstance = new ProvidersInstance(iResolver, s);
        iFileManager = new FileManager();
        iConnectivityMonitor = ConnectivityMonitor.getInstance();
        iBatteryMonitor = BatteryMonitor.getInstance();
        initClients();
        iConnectivityMonitor.addObserver(this);
        iBatteryMonitor.addObserver(this);
        lwm = LocalWifiMonitor.instance();
        lwm.addObserver(this);
    }

    private double availableCellQuota(SettingsInstance settingsinstance)
    {
        double d1 = cellquota(settingsinstance) - usedCellQuota(settingsinstance);
        double d = d1;
        if (d1 < 0.0D)
        {
            d = 0.0D;
        }
        return d;
    }

    private boolean cellQuotaDisabled(SettingsInstance settingsinstance)
    {
        return cellquota(settingsinstance) < 0.0D;
    }

    private double cellquota(SettingsInstance settingsinstance)
    {
        String s1 = settingsinstance.get("cell_data_quota_override");
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = settingsinstance.get("cell_data_quota");
        }
        if (!TextUtils.isEmpty(s))
        {
            return Double.parseDouble(s);
        } else
        {
            return 0.0D;
        }
    }

    private SettingsInstance clientSettings(String s)
    {
        if (!iDownloadClientSettings.containsKey(s))
        {
            SettingsInstance settingsinstance = new SettingsInstance(iResolver, s);
            iDownloadClientSettings.put(s, settingsinstance);
        }
        return (SettingsInstance)iDownloadClientSettings.get(s);
    }

    private Bundle downloadBundleForNextItem(Downloader downloader)
    {
        IVirtuosoIdentifier ivirtuosoidentifier = nextItemForDownloader(downloader);
        if (ivirtuosoidentifier != null)
        {
            ClientStorageInfo clientstorageinfo = (ClientStorageInfo)iDownloadClientStorage.get(downloader.iClientAuthority);
            downloader = clientSettings(downloader.iClientAuthority);
            clientstorageinfo.update(downloader);
            Bundle bundle = new Bundle();
            bundle.putInt("fragment_download_progress_rate", Integer.parseInt(downloader.get("default_configuration_fragment_rate", true)));
            bundle.putParcelable("download_file_data", ivirtuosoidentifier);
            double d;
            if (cellQuotaDisabled(downloader))
            {
                d = clientstorageinfo.iAvailable;
            } else
            {
                d = availableCellQuota(downloader);
            }
            bundle.putDouble("max_download_size_cellular", d);
            bundle.putDouble("max_download_size", clientstorageinfo.iAvailable);
            return bundle;
        } else
        {
            return null;
        }
    }

    private Downloader downloadClient(String s)
    {
        return (Downloader)iDownloadClients.get(s);
    }

    private Downloader getDownloadClientAddIfNeeded(String s)
    {
        if (!iDownloadClients.containsKey(s))
        {
            Downloader downloader = new Downloader(iContext, s, this, this, iBatteryMonitor);
            iDownloadClients.put(s, downloader);
            SettingsInstance settingsinstance = clientSettings(s);
            iDownloadClientStorage.put(s, new ClientStorageInfo(s));
            downloader.InitiliazationComplete(settingsinstance.getBundle());
        }
        return downloadClient(s);
    }

    public static DownloadEngineClientManager getInstance(Context context, String s)
    {
        com/penthera/virtuososdk/download/DownloadEngineClientManager;
        JVM INSTR monitorenter ;
        if (iInstance == null) goto _L2; else goto _L1
_L1:
        DownloadEngineClientManager downloadengineclientmanager = (DownloadEngineClientManager)iInstance.get();
_L8:
        if (downloadengineclientmanager != null) goto _L4; else goto _L3
_L3:
        context = new DownloadEngineClientManager(context, s);
        iInstance = new SoftReference(context);
_L6:
        com/penthera/virtuososdk/download/DownloadEngineClientManager;
        JVM INSTR monitorexit ;
        return context;
        context;
_L5:
        com/penthera/virtuososdk/download/DownloadEngineClientManager;
        JVM INSTR monitorexit ;
        throw context;
        context;
        if (true) goto _L5; else goto _L4
_L4:
        context = downloadengineclientmanager;
        if (true) goto _L6; else goto _L2
_L2:
        downloadengineclientmanager = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void handleFileComplete(Downloader downloader, IVirtuosoIdentifier ivirtuosoidentifier, Bundle bundle)
    {
        if (ivirtuosoidentifier.type() != 1) goto _L2; else goto _L1
_L1:
        ((IEngVFile)ivirtuosoidentifier).setPending(false);
_L4:
        saveFileState((IEngVIdentifier)ivirtuosoidentifier);
        RegistryInstance registryinstance = new RegistryInstance(iResolver, downloader.iClientAuthority);
        List list = registryinstance.pendingQueue(null);
        if (list.remove(ivirtuosoidentifier.uuid()))
        {
            registryinstance.savePendingQueueNoAdd(null, list);
            ivirtuosoidentifier = VirtuosoContentBox.getItem(iResolver, ivirtuosoidentifier.uuid(), downloader.iClientAuthority);
            if (ivirtuosoidentifier != null && ((IEngVIdentifier)ivirtuosoidentifier).getContentState() == 0)
            {
                bundle.putParcelable("download_update_data", ivirtuosoidentifier);
                bundle.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
                com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_CALLBACK", bundle);
            }
        }
        ivirtuosoidentifier = new Bundle();
        ivirtuosoidentifier.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.QUEUE_CHANGED", ivirtuosoidentifier);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_LIST_CHANGED", ivirtuosoidentifier);
        return;
_L2:
        if (ivirtuosoidentifier.type() == 4)
        {
            ((IEngVHLSFile)ivirtuosoidentifier).setPending(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void handleFileErrored(Downloader downloader, IVirtuosoIdentifier ivirtuosoidentifier)
    {
        if (ivirtuosoidentifier.type() == 1)
        {
            ((IEngVFile)ivirtuosoidentifier).setErrorCount(((IEngVFile)ivirtuosoidentifier).errorCount() + 1L);
        }
        saveFileState((IEngVIdentifier)ivirtuosoidentifier);
        downloader = new RegistryInstance(iResolver, downloader.iClientAuthority);
        List list = downloader.pendingQueue(null);
        list.remove(ivirtuosoidentifier.uuid());
        downloader.savePendingQueueNoAdd(null, list);
        list = downloader.errorQueue(null);
        list.add(ivirtuosoidentifier.uuid());
        downloader.saveErrorQueue(null, list);
    }

    private boolean handleFileStart(Downloader downloader, IVirtuosoIdentifier ivirtuosoidentifier)
        throws QueueException
    {
        boolean flag1 = false;
        downloader = new RegistryInstance(iResolver, downloader.iClientAuthority);
        List list = downloader.pendingQueue(null);
        boolean flag = flag1;
        if (list.size() > 0)
        {
            flag = flag1;
            if (!((String)list.get(0)).equals(ivirtuosoidentifier.uuid()))
            {
                if (!list.contains(ivirtuosoidentifier.uuid()))
                {
                    throw new QueueException(ivirtuosoidentifier.uuid());
                }
                list.remove(ivirtuosoidentifier.uuid());
                list.add(0, ivirtuosoidentifier.uuid());
                downloader.savePendingQueueNoAdd(null, list);
                flag = true;
            }
        }
        list = downloader.errorQueue(null);
        if (list.contains(ivirtuosoidentifier.uuid()))
        {
            list.remove(ivirtuosoidentifier.uuid());
            downloader.saveErrorQueue(null, list);
        }
        ((IEngVIdentifier)ivirtuosoidentifier).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading);
        saveFileState((IEngVIdentifier)ivirtuosoidentifier);
        return flag;
    }

    private void handleRetryErrorQueue(Downloader downloader)
    {
        downloader = new RegistryInstance(iResolver, downloader.iClientAuthority);
        List list = downloader.pendingQueue(null);
        List list1 = downloader.errorQueue(null);
        if (list1.size() > 0)
        {
            list.addAll(list1);
            list1.clear();
            downloader.saveErrorQueue(null, list1);
            downloader.savePendingQueue(null, list);
        }
    }

    private void interruptClientDownloader(Downloader downloader)
    {
        Bundle bundle = downloadBundleForNextItem(downloader);
        if (bundle != null)
        {
            downloader.PriorityDownload(bundle);
        }
    }

    private IVirtuosoIdentifier nextItemForDownloader(Downloader downloader)
    {
        Object obj = (new RegistryInstance(iResolver, downloader.iClientAuthority)).pendingQueue(null).iterator();
_L8:
        if (((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((IVirtuosoIdentifier) (obj));
_L2:
        IVirtuosoIdentifier ivirtuosoidentifier;
        Object obj1;
        obj1 = (String)((Iterator) (obj)).next();
        ivirtuosoidentifier = VirtuosoContentBox.getItem(iResolver, ((String) (obj1)), downloader.iClientAuthority);
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        if (ivirtuosoidentifier.type() != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (IEngVFile)ivirtuosoidentifier;
        obj = ivirtuosoidentifier;
        if (TextUtils.isEmpty(((IEngVFile) (obj1)).filePath()))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "updating file path.");
            ((IEngVFile) (obj1)).regenerateFilePath(iResolver, downloader.iClientAuthority, iContext);
            saveFileState(((IEngVIdentifier) (obj1)), 4);
            return ivirtuosoidentifier;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = ivirtuosoidentifier;
        if (ivirtuosoidentifier.type() != 4) goto _L4; else goto _L5
_L5:
        obj1 = (IEngVHLSFile)ivirtuosoidentifier;
        if (TextUtils.isEmpty(((IEngVHLSFile) (obj1)).localBaseDir()))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ivirtuosoidentifier;
        if (!"/".equalsIgnoreCase(((IEngVHLSFile) (obj1)).localBaseDir())) goto _L4; else goto _L6
_L6:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "updating file path hls.");
        ((IEngVHLSFile) (obj1)).regenerateFilePath(iResolver, downloader.iClientAuthority, iContext);
        saveFileState(((IEngVIdentifier) (obj1)), 4);
        return ivirtuosoidentifier;
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("item [")).append(((String) (obj1))).append("] not retrieved deleted from under us? moving to next").toString());
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void notifyListChanges(boolean flag, boolean flag1, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.penthera.virtuososdk.client.pckg", s);
        if (flag)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.QUEUE_CHANGED", bundle);
        }
        if (flag1)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_LIST_CHANGED", bundle);
        }
    }

    private void notifyQueueChanged(String s)
    {
        notifyListChanges(true, false, s);
    }

    private void performDownloadResume(Downloader downloader)
    {
        if (iErrorItemsTimer != null)
        {
            iErrorItemsTimer.cancel();
            iErrorItemsTimer.purge();
            iErrorItemsTimer = null;
        }
        performRetryErrorQueue(downloader);
    }

    private void performRetryErrorQueue(Downloader downloader)
    {
        if (downloader == null)
        {
            return;
        } else
        {
            handleRetryErrorQueue(downloader);
            provideItemToClientDownloader(downloader);
            return;
        }
    }

    private void performRetryErrorQueue(String s)
    {
        performRetryErrorQueue(getDownloadClientAddIfNeeded(s));
    }

    private void provideItemToClientDownloader(Downloader downloader)
    {
        Bundle bundle = downloadBundleForNextItem(downloader);
        if (bundle != null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Providing new item to downloader");
            downloader.NewItem(bundle);
        }
    }

    static void requestDiskCheck(Downloader downloader)
    {
        Message message = new Message();
        message.what = 1;
        message.obj = downloader;
        iDiskCheckHandler.sendMessageDelayed(message, 5000L);
    }

    private void saveFileState(IEngVIdentifier iengvidentifier)
    {
        saveFileState(iengvidentifier, 6);
    }

    private void saveFileState(IEngVIdentifier iengvidentifier, int i)
    {
        VirtuosoContentBox.saveFileState(iResolver, iengvidentifier, i);
    }

    private double usedCellQuota(SettingsInstance settingsinstance)
    {
        settingsinstance = settingsinstance.get("cell_quota_used");
        if (TextUtils.isEmpty(settingsinstance))
        {
            return 0.0D;
        } else
        {
            return Double.parseDouble(settingsinstance);
        }
    }

    public double availableStorage(String s)
    {
        getDownloadClientAddIfNeeded(s);
        ClientStorageInfo clientstorageinfo = (ClientStorageInfo)iDownloadClientStorage.get(s);
        clientstorageinfo.update(clientSettings(s));
        return clientstorageinfo.iAvailable;
    }

    double calcDiskUsage(String s)
    {
        return VirtuosoContentBox.appDiskUsage(iResolver, s);
    }

    public long cellQuotaStart(String s)
    {
        s = clientSettings(s);
        if (!TextUtils.isEmpty(s.get("cell_quota_start_date")))
        {
            return Long.parseLong(s.get("cell_quota_start_date"));
        } else
        {
            return -1L;
        }
    }

    public boolean cellularDataQuotaOK(String s)
    {
        for (s = clientSettings(s); cellQuotaDisabled(s) || availableCellQuota(s) > 0.0D;)
        {
            return true;
        }

        return false;
    }

    public void clearTestSettings(String s)
    {
        Downloader downloader = getDownloadClientAddIfNeeded(s);
        downloader.clearTestSettings();
        s = clientSettings(s);
        Bundle bundle = new Bundle();
        bundle.putString("headroom_override", "headroom_override");
        bundle.putString("max_storage_override", "max_storage_override");
        bundle.putString("cell_data_quota_override", "cell_data_quota_override");
        bundle.putString("battery_threshold_override", "battery_threshold_override");
        bundle.putString("destination_path_override", "destination_path_override");
        s.removeOverrideValues(bundle);
        downloader.BatterySettingChanged(s.getBundle());
    }

    public void clientDeletedItem(String s, IVirtuosoIdentifier ivirtuosoidentifier)
    {
        getDownloadClientAddIfNeeded(s).ItemRemoved(ivirtuosoidentifier);
    }

    public void clientExpiredItem(String s, IVirtuosoIdentifier ivirtuosoidentifier)
    {
        getDownloadClientAddIfNeeded(s).ItemRemoved(ivirtuosoidentifier);
    }

    public void clientQueueChange(String s)
    {
        interruptClientDownloader(getDownloadClientAddIfNeeded(s));
    }

    public void clientSettingChange(String s, int i)
    {
        Downloader downloader = getDownloadClientAddIfNeeded(s);
        if ((i & 0x100) > 0)
        {
            downloader.BatterySettingChanged(clientSettings(s).getBundle());
            return;
        } else
        {
            interruptClientDownloader(downloader);
            return;
        }
    }

    public boolean diskStatusOK()
    {
        String s = Environment.getExternalStorageState();
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("diskStatus is ")).append(s).toString());
        return s.equals("mounted");
    }

    void doDownloadStart(IVirtuosoIdentifier ivirtuosoidentifier, Bundle bundle, Downloader downloader)
        throws QueueException
    {
        boolean flag = handleFileStart(downloader, ivirtuosoidentifier);
        bundle.putParcelable("download_update_data", VirtuosoContentBox.getItem(iResolver, ivirtuosoidentifier.uuid(), downloader.iClientAuthority));
        bundle.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_CALLBACK", bundle);
        if (flag)
        {
            notifyQueueChanged(downloader.iClientAuthority);
        }
    }

    void doDownloadUpdate(IVirtuosoIdentifier ivirtuosoidentifier, boolean flag, Bundle bundle, Downloader downloader)
    {
        if (flag)
        {
            handleFileComplete(downloader, ivirtuosoidentifier, bundle);
        } else
        {
            saveFileState((IEngVIdentifier)ivirtuosoidentifier);
            if (downloader.iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
            {
                ivirtuosoidentifier = VirtuosoContentBox.getItem(iResolver, ivirtuosoidentifier.uuid(), downloader.iClientAuthority);
                if (ivirtuosoidentifier != null && ((IEngVIdentifier)ivirtuosoidentifier).getContentState() == 0)
                {
                    bundle.putParcelable("download_update_data", ivirtuosoidentifier);
                    bundle.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
                    com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_CALLBACK", bundle);
                    return;
                }
            }
        }
    }

    TimerTask doGetRetryErrorsTask(String s)
    {
        return new TimerTask(s) {

            final String client;
            final DownloadEngineClientManager this$0;

            public void run()
            {
                performRetryErrorQueue(client);
            }

            
            {
                this$0 = DownloadEngineClientManager.this;
                super();
                client = s;
            }
        };
    }

    void doRemoveFileFromDisk(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        if (ivirtuosoidentifier.type() == 1)
        {
            iFileManager.remove(((IEngVFile)ivirtuosoidentifier).filePath());
        } else
        if (ivirtuosoidentifier.type() == 4)
        {
            iFileManager.remove(((IEngVHLSFile)ivirtuosoidentifier).localBaseDir());
            return;
        }
    }

    public void downloadUpdate(Downloader downloader, com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType edownloadcallbacktype, Parcelable parcelable)
    {
        $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[edownloadcallbacktype.ordinal()];
        JVM INSTR tableswitch 1 17: default 92
    //                   1 139
    //                   2 997
    //                   3 1185
    //                   4 1377
    //                   5 138
    //                   6 138
    //                   7 138
    //                   8 138
    //                   9 138
    //                   10 138
    //                   11 138
    //                   12 138
    //                   13 138
    //                   14 138
    //                   15 138
    //                   16 138
    //                   17 1528;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L6 _L7
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("unhandled download callback type ")).append(edownloadcallbacktype).toString());
        edownloadcallbacktype = (Bundle)parcelable;
        edownloadcallbacktype.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_CALLBACK", edownloadcallbacktype);
_L6:
        return;
_L2:
        VirtuosoDownloadEngineStatus virtuosodownloadenginestatus;
        int i;
        boolean flag1;
        flag1 = false;
        edownloadcallbacktype = (Bundle)parcelable;
        virtuosodownloadenginestatus = (VirtuosoDownloadEngineStatus)edownloadcallbacktype.getParcelable("download_update_data");
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Got status ")).append(virtuosodownloadenginestatus.status()).toString());
        i = ((flag1) ? 1 : 0);
        $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus()[virtuosodownloadenginestatus.status().ordinal()];
        JVM INSTR tableswitch 2 6: default 236
    //                   2 576
    //                   3 240
    //                   4 240
    //                   5 609
    //                   6 653;
           goto _L8 _L9 _L10 _L10 _L11 _L12
_L8:
        i = ((flag1) ? 1 : 0);
_L10:
        edownloadcallbacktype.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_CALLBACK", edownloadcallbacktype);
        if (i != 0)
        {
            notifyListChanges(true, false, downloader.iClientAuthority);
        }
        Bundle bundle;
        switch ($SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus()[virtuosodownloadenginestatus.status().ordinal()])
        {
        default:
            return;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            bundle = new Bundle();
            break;
        }
        Bundle bundle1 = virtuosodownloadenginestatus.extras();
        parcelable = null;
        SettingsInstance settingsinstance = null;
        Object obj = "";
        edownloadcallbacktype = ((com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType) (obj));
        if (bundle1 != null)
        {
            IVirtuosoIdentifier ivirtuosoidentifier = (IVirtuosoIdentifier)bundle1.getParcelable("virtuoso_file");
            edownloadcallbacktype = ((com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType) (obj));
            parcelable = settingsinstance;
            if (ivirtuosoidentifier != null)
            {
                edownloadcallbacktype = ivirtuosoidentifier.uuid();
                parcelable = ivirtuosoidentifier.parentUuid();
                bundle.putParcelable("notification_file", ivirtuosoidentifier);
            }
            bundle.putInt("notification_engine_status_info_ordinal", bundle1.getInt("failure_reason"));
        }
        settingsinstance = clientSettings(downloader.iClientAuthority);
        obj = settingsinstance.pendingQueue(parcelable);
        parcelable = settingsinstance.errorQueue(parcelable);
        bundle.putInt("notification_num_queued_files", ((List) (obj)).size() + parcelable.size());
        bundle.putInt("notification_engine_status_ordinal", virtuosodownloadenginestatus.status().ordinal());
        parcelable = ".NOTIFICATION_DOWNLOAD_STOPPED";
        if (virtuosodownloadenginestatus.status() == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
        {
            parcelable = ".NOTIFICATION_DOWNLOADS_PAUSED";
        }
        com.penthera.virtuososdk.utility.CommonUtil.Log.d("NOTIFICATION SEND", (new StringBuilder("notification: [")).append(downloader.iClientAuthority).append(parcelable).append("] for file [").append(edownloadcallbacktype).append("]").toString());
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast((new StringBuilder(String.valueOf(downloader.iClientAuthority))).append(parcelable).toString(), bundle);
        return;
_L9:
        provideItemToClientDownloader(downloader);
        i = ((flag1) ? 1 : 0);
        if (virtuosodownloadenginestatus.extras().getBoolean("forceIdleOnNewItemAfterDeleteDuringIdle"))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Got EXTRA_DELETION_DURING_IDLE_FORCED_NEW_IDLE");
            return;
        }
          goto _L13
_L11:
        parcelable = virtuosodownloadenginestatus.extras();
        if (parcelable != null)
        {
            i = parcelable.getInt("failure_reason");
            parcelable = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.values()[i];
            if (parcelable == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedStorage || parcelable == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedHeadroom)
            {
                requestDiskCheck(downloader);
            }
        }
_L12:
        Object obj1;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Got error status");
        parcelable = (IVirtuosoAsset)virtuosodownloadenginestatus.extras().getParcelable("virtuoso_file");
        if (parcelable == null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Null File sent when reporting update");
        }
        obj1 = parcelable.downloadStatus();
        $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus()[((com.penthera.virtuososdk.Common.EFileDownloadStatus) (obj1)).ordinal()];
        JVM INSTR tableswitch 6 9: default 736
    //                   6 872
    //                   7 736
    //                   8 736
    //                   9 942;
           goto _L14 _L15 _L14 _L14 _L16
_L14:
        if (VirtuosoContentBox.getItem(iResolver, parcelable.uuid(), downloader.iClientAuthority) != null)
        {
            if (com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors == virtuosodownloadenginestatus.status())
            {
                handleFileErrored(downloader, parcelable);
                if (iErrorItemsTimer != null)
                {
                    iErrorItemsTimer.cancel();
                    iErrorItemsTimer.purge();
                }
                iErrorItemsTimer = new Timer("RetryErrorDownloads");
                iErrorItemsTimer.schedule(doGetRetryErrorsTask(downloader.iClientAuthority), 0x36ee80L);
            } else
            {
                saveFileState((IEngVIdentifier)parcelable);
            }
        }
        parcelable = VirtuosoContentBox.getItem(iResolver, parcelable.uuid(), downloader.iClientAuthority);
        virtuosodownloadenginestatus.extras().putParcelable("virtuoso_file", parcelable);
        edownloadcallbacktype.putParcelable("download_update_data", virtuosodownloadenginestatus);
        i = 1;
_L13:
        if (true) goto _L10; else goto _L15
_L15:
        if (parcelable.currentSize() <= 0.0D)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "***** Resetting file path");
            if (parcelable.type() == 1)
            {
                ((IEngVFile)parcelable).setFilePath("");
            } else
            if (parcelable.type() == 4)
            {
                ((IEngVHLSFile)parcelable).setLocalBaseDir("");
            }
        }
          goto _L14
_L16:
        doRemoveFileFromDisk(parcelable);
        if (parcelable.type() == 1)
        {
            ((IEngVFile)parcelable).setCurrentSize(0.0D);
            ((IEngVFile)parcelable).setMd5State(new MD5State());
        }
          goto _L14
_L3:
        parcelable = (Bundle)parcelable;
        edownloadcallbacktype = parcelable.getParcelable("download_update_data");
        obj1 = (IVirtuosoIdentifier)edownloadcallbacktype;
        try
        {
            if (VirtuosoContentBox.getItem(iResolver, ((IVirtuosoIdentifier) (obj1)).uuid(), downloader.iClientAuthority) != null)
            {
                doDownloadStart(((IVirtuosoIdentifier) (obj1)), parcelable, downloader);
            }
            parcelable = clientSettings(downloader.iClientAuthority);
            String s = ((IVirtuosoIdentifier) (obj1)).parentUuid();
            obj1 = parcelable.pendingQueue(s);
            parcelable = parcelable.errorQueue(s);
            int j = ((List) (obj1)).size();
            int l = parcelable.size();
            parcelable = new Bundle();
            parcelable.putParcelable("notification_file", edownloadcallbacktype);
            parcelable.putInt("notification_num_queued_files", j + l);
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast((new StringBuilder(String.valueOf(downloader.iClientAuthority))).append(".NOTIFICATION_DOWNLOAD_START").toString(), parcelable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Downloader downloader)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("QueueException for ")).append(downloader.getMessage()).append(" on start").toString());
        }
        return;
_L4:
        Object obj2;
        obj1 = (Bundle)parcelable;
        edownloadcallbacktype = ((Bundle) (obj1)).getParcelable("download_update_data");
        parcelable = (IVirtuosoIdentifier)edownloadcallbacktype;
        obj2 = VirtuosoContentBox.getItem(iResolver, parcelable.uuid(), downloader.iClientAuthority);
        if (obj2 != null)
        {
            doDownloadUpdate(parcelable, false, ((Bundle) (obj1)), downloader);
        }
        if (downloader.iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused || obj2 == null || ((IEngVIdentifier)obj2).getContentState() != 0) goto _L6; else goto _L17
_L17:
        obj1 = clientSettings(downloader.iClientAuthority);
        obj2 = parcelable.parentUuid();
        parcelable = ((SettingsInstance) (obj1)).pendingQueue(((String) (obj2)));
        obj1 = ((SettingsInstance) (obj1)).errorQueue(((String) (obj2)));
        int k = parcelable.size();
        int i1 = ((List) (obj1)).size();
        parcelable = new Bundle();
        parcelable.putParcelable("notification_file", edownloadcallbacktype);
        parcelable.putInt("notification_num_queued_files", k + i1);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast((new StringBuilder(String.valueOf(downloader.iClientAuthority))).append(".NOTIFICATION_DOWNLOAD_UPDATE").toString(), parcelable);
        return;
_L5:
        parcelable = (Bundle)parcelable;
        edownloadcallbacktype = parcelable.getParcelable("download_update_data");
        obj1 = (IVirtuosoAsset)edownloadcallbacktype;
        obj2 = VirtuosoContentBox.getItem(iResolver, ((IVirtuosoAsset) (obj1)).uuid(), downloader.iClientAuthority);
        if (obj2 == null) goto _L6; else goto _L18
_L18:
        if (((IVirtuosoIdentifier) (obj2)).downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired)
        {
            ((IEngVIdentifier)obj1).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired);
            if (((IVirtuosoAsset) (obj1)).type() == 1)
            {
                ((IEngVFile)obj1).setCurrentSize(0.0D);
            }
            doRemoveFileFromDisk(((IVirtuosoIdentifier) (obj1)));
        }
        doDownloadUpdate(((IVirtuosoIdentifier) (obj1)), true, parcelable, downloader);
        parcelable = new Bundle();
        parcelable.putParcelable("notification_file", edownloadcallbacktype);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast((new StringBuilder(String.valueOf(downloader.iClientAuthority))).append(".NOTIFICATION_DOWNLOAD_COMPLETE").toString(), parcelable);
        return;
_L7:
        boolean flag;
        boolean flag2;
        boolean flag3;
        edownloadcallbacktype = (IVirtuosoIdentifier)((Bundle)parcelable).getParcelable("virtuoso_file");
        flag3 = false;
        flag2 = false;
        flag = true;
        if (edownloadcallbacktype == null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "ILLEGAL STATE: EItemDownloadRemoved called with no file as extra data!!");
            return;
        }
        $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus()[edownloadcallbacktype.downloadStatus().ordinal()];
        JVM INSTR tableswitch 2 12: default 1636
    //                   2 1708
    //                   3 1708
    //                   4 1693
    //                   5 1693
    //                   6 1693
    //                   7 1693
    //                   8 1693
    //                   9 1693
    //                   10 1636
    //                   11 1646
    //                   12 1723;
           goto _L19 _L20 _L20 _L21 _L21 _L21 _L21 _L21 _L21 _L19 _L22 _L23
_L19:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "ILLEGAL STATE: unhandled file error condition.");
        return;
_L22:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "Download Completed removing file on disk");
        flag3 = true;
_L25:
        if (flag)
        {
            VirtuosoContentBox.remove(edownloadcallbacktype, iContext, downloader.iClientAuthority);
        }
        doRemoveFileFromDisk(edownloadcallbacktype);
        notifyListChanges(flag2, flag3, downloader.iClientAuthority);
        return;
_L21:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "Download Completed with error removing file as requested");
        flag2 = true;
        continue; /* Loop/switch isn't completed */
_L20:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "no error on file removing it from disk");
        flag2 = true;
        continue; /* Loop/switch isn't completed */
_L23:
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "expired file removing it only from disk");
        flag3 = true;
        flag2 = true;
        flag = false;
        if (true) goto _L25; else goto _L24
_L24:
    }

    public void fragmentsComplete(Downloader downloader, Bundle bundle)
    {
        if (downloader.iStatus.iStatus == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
        {
            return;
        } else
        {
            bundle.putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK", bundle);
            return;
        }
    }

    public int fullPendingQueueSize(String s)
    {
        int i = 0;
        Object obj = clientSettings(s);
        if (obj != null)
        {
            s = ((SettingsInstance) (obj)).pendingQueue(null);
            obj = ((SettingsInstance) (obj)).errorQueue(null);
            i = s.size() + ((List) (obj)).size();
        }
        return i;
    }

    public double getAllowedCellQuota(Downloader downloader)
    {
        if (downloader != null)
        {
            ClientStorageInfo clientstorageinfo = (ClientStorageInfo)iDownloadClientStorage.get(downloader.iClientAuthority);
            downloader = clientSettings(downloader.iClientAuthority);
            clientstorageinfo.update(downloader);
            if (cellQuotaDisabled(downloader))
            {
                return clientstorageinfo.iAvailable;
            } else
            {
                return availableCellQuota(downloader);
            }
        } else
        {
            return 0.0D;
        }
    }

    public double getAllowedStorageQuota(Downloader downloader)
    {
        if (downloader != null)
        {
            ClientStorageInfo clientstorageinfo = (ClientStorageInfo)iDownloadClientStorage.get(downloader.iClientAuthority);
            clientstorageinfo.update(clientSettings(downloader.iClientAuthority));
            return clientstorageinfo.iAvailable;
        } else
        {
            return 0.0D;
        }
    }

    public double getCurrentThroughput(String s)
    {
        return getDownloadClientAddIfNeeded(s).currentThroughPut.mbs();
    }

    public double getOverallThroughput(String s)
    {
        return getDownloadClientAddIfNeeded(s).overallThroughPut.mbs();
    }

    public void hdsProgressUpdate(Downloader downloader, Bundle bundle)
    {
        Object obj1;
label0:
        {
            bundle = (IEngVHLSFile)bundle.getParcelable("virtuoso_file");
            obj1 = VirtuosoContentBox.getItem(iResolver, bundle.uuid(), downloader.iClientAuthority);
            if (obj1 != null)
            {
                saveFileState(bundle, 4);
                if (downloader.iStatus.iStatus != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
                {
                    break label0;
                }
            }
            return;
        }
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("com.penthera.virtuososdk.client.pckg", downloader.iClientAuthority);
        ((Bundle) (obj)).putInt("download_update_type", com.penthera.virtuososdk.utility.CommonUtil.EDownloadCallbackType.EProgressUpdate.ordinal());
        ((Bundle) (obj)).putParcelable("download_update_data", bundle);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendLocalBroadcast("virtuoso.intent.action.DOWNLOAD_CALLBACK", ((Bundle) (obj)));
        obj = clientSettings(downloader.iClientAuthority);
        String s = ((IVirtuosoIdentifier) (obj1)).parentUuid();
        obj1 = ((SettingsInstance) (obj)).pendingQueue(s);
        obj = ((SettingsInstance) (obj)).errorQueue(s);
        int i = ((List) (obj1)).size();
        int j = ((List) (obj)).size();
        obj = new Bundle();
        ((Bundle) (obj)).putParcelable("notification_file", bundle);
        ((Bundle) (obj)).putInt("notification_num_queued_files", i + j);
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast((new StringBuilder(String.valueOf(downloader.iClientAuthority))).append(".NOTIFICATION_DOWNLOAD_UPDATE").toString(), ((Bundle) (obj)));
    }

    public void initClient(String s)
    {
        getDownloadClientAddIfNeeded(s);
    }

    void initClients()
    {
        iDownloadClients = new ConcurrentHashMap();
        iDownloadClientSettings = new ConcurrentHashMap();
        iDownloadClientStorage = new ConcurrentHashMap();
        Iterator iterator = iProvidersInstance.getProviders().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            getDownloadClientAddIfNeeded((String)iterator.next());
        } while (true);
    }

    public void isOkay(boolean flag)
    {
        Object obj;
label0:
        {
            String s = LOG_TAG;
            StringBuilder stringbuilder = new StringBuilder("received is okay from monitor [");
            if (flag)
            {
                obj = "true]";
            } else
            {
                obj = "false]";
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(s, stringbuilder.append(((String) (obj))).toString());
            if (flag)
            {
                obj = (ConnectivityManager)iContext.getSystemService("connectivity");
                if (obj != null)
                {
                    break label0;
                }
            }
            return;
        }
        onConnectivityChange(((ConnectivityManager) (obj)).getActiveNetworkInfo());
    }

    public boolean networkStatusOK(String s, boolean flag)
    {
        s = ((ConnectivityManager)iContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (s == null || s.getType() == 0 && !flag)
        {
            return false;
        } else
        {
            return s.isAvailable();
        }
    }

    public void onBatteryLevelChanged(int i)
    {
        Iterator iterator = iDownloadClients.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Downloader downloader = (Downloader)iterator.next();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("sending onBatteryLevelChanged to ")).append(downloader.iClientAuthority).toString());
            downloader.onBatteryLevelChanged(i);
        } while (true);
    }

    public void onConnectivityChange(NetworkInfo networkinfo)
    {
        Iterator iterator = iDownloadClients.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Downloader downloader = (Downloader)iterator.next();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("sending onConnectivityChange to ")).append(downloader.iClientAuthority).toString());
            downloader.onConnectivityChange(networkinfo);
        } while (true);
    }

    public void onPowerConnected()
    {
        Iterator iterator = iDownloadClients.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Downloader downloader = (Downloader)iterator.next();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("sending onPowerConnected to ")).append(downloader.iClientAuthority).toString());
            downloader.onPowerConnected();
        } while (true);
    }

    public void onPowerDisconnected()
    {
        Iterator iterator = iDownloadClients.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Downloader downloader = (Downloader)iterator.next();
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("sending onPowerDisconnected to ")).append(downloader.iClientAuthority).toString());
            downloader.onPowerDisconnected();
        } while (true);
    }

    public void pauseClient(String s)
    {
        getDownloadClientAddIfNeeded(s).Pause();
        clientSettings(s).set("downloader_init_state", (new StringBuilder()).append(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused.ordinal()).toString());
    }

    public boolean powerStatusOK(String s)
    {
        return getDownloadClientAddIfNeeded(s).powerStatusOK();
    }

    public void quotaUpdate(Downloader downloader, Bundle bundle)
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "QuotaUpdate Callback");
        com.penthera.virtuososdk.Common.BearerType bearertype;
        if (bundle != null)
        {
            if (com.penthera.virtuososdk.Common.BearerType.cellular == (bearertype = com.penthera.virtuososdk.Common.BearerType.values()[bundle.getInt("bearer", 0)]))
            {
                SettingsInstance settingsinstance = clientSettings(downloader.iClientAuthority);
                double d = usedCellQuota(settingsinstance);
                double d1 = bundle.getInt("bearer_data_usage", 0);
                settingsinstance.set("cell_quota_used", (new StringBuilder()).append(d + d1).toString());
                ((ClientStorageInfo)iDownloadClientStorage.get(downloader.iClientAuthority)).update(settingsinstance);
                return;
            }
        }
    }

    public void release()
    {
        lwm.release();
    }

    public void resetErrorQueue(String s)
    {
        if (iErrorItemsTimer != null)
        {
            iErrorItemsTimer.cancel();
            iErrorItemsTimer.purge();
        }
        iErrorItemsTimer = new Timer("RetryErrorDownloads");
        iErrorItemsTimer.schedule(doGetRetryErrorsTask(s), 500L);
    }

    public void resumeClient(String s)
    {
        Downloader downloader = getDownloadClientAddIfNeeded(s);
        downloader.Resume();
        clientSettings(s).set("downloader_init_state", (new StringBuilder()).append(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle.ordinal()).toString());
        performDownloadResume(downloader);
    }

    public void saveFileState(Downloader downloader, Bundle bundle)
    {
        saveFileState((IEngVIdentifier)bundle.getParcelable("virtuoso_file"));
    }

    public void setClientConfiguration(Bundle bundle, int i, int j, String s)
    {
        Downloader downloader;
        downloader = getDownloadClientAddIfNeeded(s);
        s = clientSettings(s);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        StringBuffer stringbuffer;
        Object obj;
        obj = bundle.keySet();
        stringbuffer = new StringBuffer();
        if (!((Set) (obj)).isEmpty())
        {
            stringbuffer.append("{\"headers\":[");
        }
        obj = ((Set) (obj)).iterator();
_L6:
        if (((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        if (stringbuffer.length() > 0)
        {
            stringbuffer.append("]}");
            s.set("client_configuration_headers", stringbuffer.toString());
        }
_L2:
        s.set("client_configuration_conn_to", (new StringBuilder()).append(i).toString());
        s.set("client_configuration_socket_to", (new StringBuilder()).append(j).toString());
        downloader.setClientConfiguration(bundle, i, j);
        return;
_L4:
        String s1 = (String)((Iterator) (obj)).next();
        String s2 = bundle.getString(s1);
        if (!TextUtils.isEmpty(s2))
        {
            stringbuffer.append("{\"");
            stringbuffer.append(s1);
            stringbuffer.append("\":\"");
            stringbuffer.append(s2);
            stringbuffer.append("\"},");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setTestSettings(Bundle bundle, String s)
    {
        Downloader downloader = getDownloadClientAddIfNeeded(s);
        downloader.setTestSettings(bundle);
        s = clientSettings(s);
        if (bundle != null)
        {
            if (bundle.containsKey("headroom_override"))
            {
                s.set("headroom_override", bundle.get("headroom_override").toString());
            }
            if (bundle.containsKey("max_storage_override"))
            {
                s.set("max_storage_override", bundle.get("max_storage_override").toString());
            }
            if (bundle.containsKey("cell_data_quota_override"))
            {
                s.set("cell_data_quota_override", bundle.get("cell_data_quota_override").toString());
            }
            if (bundle.containsKey("destination_path_override"))
            {
                s.set("destination_path_override", bundle.get("destination_path_override").toString());
            }
            if (bundle.containsKey("battery_threshold_override"))
            {
                s.set("battery_threshold_override", bundle.get("battery_threshold_override").toString());
                downloader.BatterySettingChanged(s.getBundle());
            }
        }
    }

    public IVirtuosoDownloadEngineStatus status(String s)
    {
        return getDownloadClientAddIfNeeded(s).status();
    }

    public double storageUsed(String s)
    {
        getDownloadClientAddIfNeeded(s);
        ClientStorageInfo clientstorageinfo = (ClientStorageInfo)iDownloadClientStorage.get(s);
        clientstorageinfo.update(clientSettings(s));
        return clientstorageinfo.iUsedByApp;
    }

    public double totalFileSize(String s)
    {
        return 0.0D;
    }

    public double usedCellQuota(String s)
    {
        return usedCellQuota(clientSettings(s));
    }





}

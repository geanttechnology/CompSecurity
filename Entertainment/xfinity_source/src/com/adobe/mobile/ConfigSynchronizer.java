// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, Config, MobilePrivacyStatus, VisitorIDService, 
//            WearableDataConnection, WearableDataRequest, MobileConfig, RemoteDownload

final class ConfigSynchronizer
{

    private static final Object _adiDMutex = new Object();
    private static final Object _aidMutex = new Object();
    private static final Object _handheldInstallDateMutex = new Object();
    private static final Object _privacyStatusMutex = new Object();
    private static final Object _pushEnabledMutex = new Object();
    private static final Object _visServiceMutex = new Object();
    private static final Object _visitorIDMutex = new Object();

    ConfigSynchronizer()
    {
    }

    protected static DataMap getSharedConfig()
    {
        DataMap datamap = new DataMap();
        try
        {
            datamap.putLong("ADMS_InstallDate", StaticMethods.getSharedPreferences().getLong("ADMS_InstallDate", 0L));
            datamap.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", StaticMethods.getSharedPreferences().getBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", false));
            datamap.putString("ADOBEMOBILE_STOREDDEFAULTS_AID", StaticMethods.getSharedPreferences().getString("ADOBEMOBILE_STOREDDEFAULTS_AID", null));
            datamap.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", StaticMethods.getSharedPreferences().getBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", false));
            datamap.putString("APP_MEASUREMENT_VISITOR_ID", StaticMethods.getSharedPreferences().getString("APP_MEASUREMENT_VISITOR_ID", null));
            datamap.putString("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER", StaticMethods.getSharedPreferences().getString("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER", null));
            datamap.putBoolean("ADBMOBILE_KEY_PUSH_ENABLED", StaticMethods.getSharedPreferences().getBoolean("ADBMOBILE_KEY_PUSH_ENABLED", false));
            datamap.putString("ADBMOBILE_PERSISTED_MID", StaticMethods.getSharedPreferences().getString("ADBMOBILE_PERSISTED_MID", null));
            datamap.putString("ADBMOBILE_PERSISTED_MID_HINT", StaticMethods.getSharedPreferences().getString("ADBMOBILE_PERSISTED_MID_HINT", null));
            datamap.putString("ADBMOBILE_PERSISTED_MID_BLOB", StaticMethods.getSharedPreferences().getString("ADBMOBILE_PERSISTED_MID_BLOB", null));
            datamap.putLong("ADBMOBILE_VISITORID_TTL", StaticMethods.getSharedPreferences().getLong("ADBMOBILE_VISITORID_TTL", 0L));
            datamap.putLong("ADBMOBILE_VISITORID_SYNC", StaticMethods.getSharedPreferences().getLong("ADBMOBILE_VISITORID_SYNC", 0L));
            if (StaticMethods.getSharedPreferences().contains("PrivacyStatus"))
            {
                datamap.putInt("PrivacyStatus", StaticMethods.getSharedPreferences().getInt("PrivacyStatus", 0));
            }
        }
        catch (StaticMethods.NullContextException nullcontextexception)
        {
            StaticMethods.logErrorFormat("Wearable - Error getting shared preferences", new Object[0]);
            return datamap;
        }
        return datamap;
    }

    private static void restoreAdid(DataMap datamap)
    {
        synchronized (_adiDMutex)
        {
            Config.submitAdvertisingIdentifierTask(new Callable(datamap) {

                final DataMap val$dataMap;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public String call()
                    throws Exception
                {
                    return dataMap.getString("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER");
                }

            
            {
                dataMap = datamap;
                super();
            }
            });
        }
        return;
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    private static void restoreAid(DataMap datamap)
    {
        Object obj = _aidMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
        editor.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", datamap.getBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID"));
        editor.putString("ADOBEMOBILE_STOREDDEFAULTS_AID", datamap.getString("ADOBEMOBILE_STOREDDEFAULTS_AID"));
        editor.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", datamap.getBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED"));
        editor.commit();
_L1:
        return;
        datamap;
        StaticMethods.logErrorFormat("Wearable - Error saving Aid data to shared preferences", new Object[0]);
          goto _L1
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    protected static void restoreConfig(DataItem dataitem)
    {
        DataMap datamap;
        if (dataitem != null && dataitem.getUri() != null && dataitem.getUri().getPath() != null)
        {
            if ((datamap = DataMapItem.fromDataItem(dataitem).getDataMap()) != null)
            {
                dataitem = dataitem.getUri().getPath();
                if (dataitem.compareTo("/abdmobile/data/config/visitorId") == 0)
                {
                    restoreVisitorID(datamap);
                    return;
                }
                if (dataitem.compareTo("/abdmobile/data/config/vidService") == 0)
                {
                    restoreVidService(datamap);
                    return;
                }
                if (dataitem.compareTo("/abdmobile/data/config/privacyStatus") == 0)
                {
                    restorePrivacyStatus(datamap);
                    return;
                }
                if (dataitem.compareTo("/abdmobile/data/config/adId") == 0)
                {
                    restoreAdid(datamap);
                    return;
                }
                if (dataitem.compareTo("/abdmobile/data/config/pushEnabled") == 0)
                {
                    restorePushEnabled(datamap);
                    return;
                }
            }
        }
    }

    private static void restoreHandheldInstallDate(DataMap datamap)
    {
        Object obj = _handheldInstallDateMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
        if (datamap.containsKey("ADMS_InstallDate"))
        {
            editor.putLong("ADMS_Handheld_App_InstallDate", datamap.getLong("ADMS_InstallDate", 0L));
        }
        editor.commit();
_L1:
        return;
        datamap;
        StaticMethods.logErrorFormat("Wearable - Error saving Handheld App install date to shared preferences", new Object[0]);
          goto _L1
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    private static void restorePrivacyStatus(DataMap datamap)
    {
label0:
        {
            synchronized (_privacyStatusMutex)
            {
                if (datamap.getInt("PrivacyStatus") < MobilePrivacyStatus.values().length)
                {
                    break label0;
                }
                StaticMethods.logWarningFormat("Wearable - Invalid PrivacyStatus value (%d)", new Object[] {
                    Integer.valueOf(datamap.getInt("PrivacyStatus"))
                });
            }
            return;
        }
        if (datamap.containsKey("PrivacyStatus"))
        {
            Config.setPrivacyStatus(MobilePrivacyStatus.values()[datamap.getInt("PrivacyStatus")]);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    private static void restorePushEnabled(DataMap datamap)
    {
        synchronized (_pushEnabledMutex)
        {
            StaticMethods.setPushEnabled(datamap.getBoolean("ADBMOBILE_KEY_PUSH_ENABLED"));
        }
        return;
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    protected static void restoreSharedConfig(DataMap datamap)
    {
        restoreHandheldInstallDate(datamap);
        restorePrivacyStatus(datamap);
        restoreVisitorID(datamap);
        restoreVidService(datamap);
        restoreAid(datamap);
        restoreAdid(datamap);
        restorePushEnabled(datamap);
    }

    private static void restoreVidService(DataMap datamap)
    {
        Object obj = _visServiceMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
        editor.putString("ADBMOBILE_PERSISTED_MID", datamap.getString("ADBMOBILE_PERSISTED_MID"));
        editor.putString("ADBMOBILE_PERSISTED_MID_HINT", datamap.getString("ADBMOBILE_PERSISTED_MID_HINT"));
        editor.putString("ADBMOBILE_PERSISTED_MID_BLOB", datamap.getString("ADBMOBILE_PERSISTED_MID_BLOB"));
        editor.putLong("ADBMOBILE_VISITORID_TTL", datamap.getLong("ADBMOBILE_VISITORID_TTL"));
        editor.putLong("ADBMOBILE_VISITORID_SYNC", datamap.getLong("ADBMOBILE_VISITORID_SYNC"));
        editor.commit();
_L1:
        VisitorIDService.sharedInstance().resetVariablesFromSharedPreferences();
        return;
        datamap;
        StaticMethods.logErrorFormat("Wearable - Error saving Visitor Id Service data to shared preferences", new Object[0]);
          goto _L1
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    private static void restoreVisitorID(DataMap datamap)
    {
        synchronized (_visitorIDMutex)
        {
            Config.setUserIdentifier(datamap.getString("APP_MEASUREMENT_VISITOR_ID"));
        }
        return;
        datamap;
        obj;
        JVM INSTR monitorexit ;
        throw datamap;
    }

    protected static void syncAdvertisingIdentifier(String s)
    {
        if (StaticMethods.isWearableApp())
        {
            return;
        } else
        {
            DataMap datamap = new DataMap();
            datamap.putString("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER", s);
            syncData("/abdmobile/data/config/adId", datamap);
            return;
        }
    }

    protected static void syncConfigFromHandheld()
    {
        if (!StaticMethods.isWearableApp())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        Object obj;
        Context context;
        context = StaticMethods.getSharedContext().getApplicationContext();
        obj = (WearableDataResponse.ShareConfigResponse)(new WearableDataConnection(context)).send(WearableDataRequest.createShareConfigRequest(15000));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (((WearableDataResponse.ShareConfigResponse) (obj)).getResult() != null)
        {
            restoreSharedConfig(((WearableDataResponse.ShareConfigResponse) (obj)).getResult());
        }
        String s;
        String s1;
        s = MobileConfig.getInstance().getPointsOfInterestURL();
        s1 = MobileConfig.getInstance().getInAppMessageURL();
        if (s == null && s1 == null)
        {
            return;
        }
        obj = null;
        Object obj1 = RemoteDownload.getFileForCachedURL(s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        obj = ((File) (obj1)).getName();
        obj1 = null;
        File file = RemoteDownload.getFileForCachedURL(s1);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        obj1 = file.getName();
        (new WearableDataConnection(context)).send(WearableDataRequest.createFileRequest(s, ((String) (obj)), 15000));
        (new WearableDataConnection(context)).send(WearableDataRequest.createFileRequest(s1, ((String) (obj1)), 15000));
        MobileConfig.getInstance().loadCachedRemotes();
        return;
        StaticMethods.NullContextException nullcontextexception;
        nullcontextexception;
        StaticMethods.logErrorFormat("Analytics - Error syncing Points of Interest and In-app Messages from handheld app to wearable app (%s)", new Object[] {
            nullcontextexception.getLocalizedMessage()
        });
    }

    protected static void syncData(String s, DataMap datamap)
    {
        GoogleApiClient googleapiclient;
        ConnectionResult connectionresult;
        try
        {
            googleapiclient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(StaticMethods.getSharedContext())).addApi(Wearable.API).build();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        googleapiclient.connect();
        connectionresult = googleapiclient.blockingConnect(15000L, TimeUnit.MILLISECONDS);
        if (connectionresult == null || !connectionresult.isSuccess())
        {
            StaticMethods.logWarningFormat("Wearable - Failed to setup connection", new Object[0]);
            return;
        } else
        {
            s = PutDataMapRequest.create(s);
            s.getDataMap().putAll(datamap);
            s = s.asPutDataRequest();
            Wearable.DataApi.putDataItem(googleapiclient, s);
            return;
        }
    }

    protected static void syncPrivacyStatus(int i)
    {
        if (StaticMethods.isWearableApp())
        {
            return;
        } else
        {
            DataMap datamap = new DataMap();
            datamap.putInt("PrivacyStatus", i);
            syncData("/abdmobile/data/config/privacyStatus", datamap);
            return;
        }
    }

    protected static void syncPushEnabled(boolean flag)
    {
        if (StaticMethods.isWearableApp())
        {
            return;
        } else
        {
            DataMap datamap = new DataMap();
            datamap.putBoolean("ADBMOBILE_KEY_PUSH_ENABLED", flag);
            syncData("/abdmobile/data/config/pushEnabled", datamap);
            return;
        }
    }

    protected static void syncVidService(String s, String s1, String s2, long l, long l1)
    {
        if (StaticMethods.isWearableApp())
        {
            return;
        } else
        {
            DataMap datamap = new DataMap();
            datamap.putString("ADBMOBILE_PERSISTED_MID", s);
            datamap.putString("ADBMOBILE_PERSISTED_MID_BLOB", s2);
            datamap.putString("ADBMOBILE_PERSISTED_MID_HINT", s1);
            datamap.putLong("ADBMOBILE_VISITORID_TTL", l);
            datamap.putLong("ADBMOBILE_VISITORID_SYNC", l1);
            syncData("/abdmobile/data/config/vidService", datamap);
            return;
        }
    }

    protected static void syncVisitorID(String s)
    {
        if (StaticMethods.isWearableApp())
        {
            return;
        } else
        {
            DataMap datamap = new DataMap();
            datamap.putString("APP_MEASUREMENT_VISITOR_ID", s);
            syncData("/abdmobile/data/config/visitorId", datamap);
            return;
        }
    }

}

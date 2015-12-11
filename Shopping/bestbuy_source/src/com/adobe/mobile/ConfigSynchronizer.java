// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import atr;
import atx;
import atz;
import aua;
import aui;
import auj;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import pp;
import qm;
import qn;

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

    protected static atz getSharedConfig()
    {
        atz atz1 = new atz();
        try
        {
            atz1.a("ADMS_InstallDate", StaticMethods.getSharedPreferences().getLong("ADMS_InstallDate", 0L));
            atz1.a("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", StaticMethods.getSharedPreferences().getBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", false));
            atz1.a("ADOBEMOBILE_STOREDDEFAULTS_AID", StaticMethods.getSharedPreferences().getString("ADOBEMOBILE_STOREDDEFAULTS_AID", null));
            atz1.a("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", StaticMethods.getSharedPreferences().getBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", false));
            atz1.a("APP_MEASUREMENT_VISITOR_ID", StaticMethods.getSharedPreferences().getString("APP_MEASUREMENT_VISITOR_ID", null));
            atz1.a("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER", StaticMethods.getSharedPreferences().getString("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER", null));
            atz1.a("ADBMOBILE_KEY_PUSH_ENABLED", StaticMethods.getSharedPreferences().getBoolean("ADBMOBILE_KEY_PUSH_ENABLED", false));
            atz1.a("ADBMOBILE_PERSISTED_MID", StaticMethods.getSharedPreferences().getString("ADBMOBILE_PERSISTED_MID", null));
            atz1.a("ADBMOBILE_PERSISTED_MID_HINT", StaticMethods.getSharedPreferences().getString("ADBMOBILE_PERSISTED_MID_HINT", null));
            atz1.a("ADBMOBILE_PERSISTED_MID_BLOB", StaticMethods.getSharedPreferences().getString("ADBMOBILE_PERSISTED_MID_BLOB", null));
            atz1.a("ADBMOBILE_VISITORID_TTL", StaticMethods.getSharedPreferences().getLong("ADBMOBILE_VISITORID_TTL", 0L));
            atz1.a("ADBMOBILE_VISITORID_SYNC", StaticMethods.getSharedPreferences().getLong("ADBMOBILE_VISITORID_SYNC", 0L));
            if (StaticMethods.getSharedPreferences().contains("PrivacyStatus"))
            {
                atz1.a("PrivacyStatus", StaticMethods.getSharedPreferences().getInt("PrivacyStatus", 0));
            }
        }
        catch (StaticMethods.NullContextException nullcontextexception)
        {
            StaticMethods.logErrorFormat("Wearable - Error getting shared preferences", new Object[0]);
            return atz1;
        }
        return atz1;
    }

    private static void restoreAdid(final atz dataMap)
    {
        synchronized (_adiDMutex)
        {
            Config.submitAdvertisingIdentifierTask(new Callable() {

                final atz val$dataMap;

                public volatile Object call()
                {
                    return call();
                }

                public String call()
                {
                    return dataMap.f("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER");
                }

            
            {
                dataMap = atz1;
                super();
            }
            });
        }
        return;
        dataMap;
        obj;
        JVM INSTR monitorexit ;
        throw dataMap;
    }

    private static void restoreAid(atz atz1)
    {
        Object obj = _aidMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
        editor.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", atz1.c("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID"));
        editor.putString("ADOBEMOBILE_STOREDDEFAULTS_AID", atz1.f("ADOBEMOBILE_STOREDDEFAULTS_AID"));
        editor.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", atz1.c("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED"));
        editor.commit();
_L1:
        return;
        atz1;
        StaticMethods.logErrorFormat("Wearable - Error saving Aid data to shared preferences", new Object[0]);
          goto _L1
        atz1;
        obj;
        JVM INSTR monitorexit ;
        throw atz1;
    }

    protected static void restoreConfig(atx atx1)
    {
        atz atz1;
        if (atx1 != null && atx1.b() != null && atx1.b().getPath() != null)
        {
            if ((atz1 = aua.a(atx1).a()) != null)
            {
                atx1 = atx1.b().getPath();
                if (atx1.compareTo("/abdmobile/data/config/visitorId") == 0)
                {
                    restoreVisitorID(atz1);
                    return;
                }
                if (atx1.compareTo("/abdmobile/data/config/vidService") == 0)
                {
                    restoreVidService(atz1);
                    return;
                }
                if (atx1.compareTo("/abdmobile/data/config/privacyStatus") == 0)
                {
                    restorePrivacyStatus(atz1);
                    return;
                }
                if (atx1.compareTo("/abdmobile/data/config/adId") == 0)
                {
                    restoreAdid(atz1);
                    return;
                }
                if (atx1.compareTo("/abdmobile/data/config/pushEnabled") == 0)
                {
                    restorePushEnabled(atz1);
                    return;
                }
            }
        }
    }

    private static void restoreHandheldInstallDate(atz atz1)
    {
        Object obj = _handheldInstallDateMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
        if (atz1.a("ADMS_InstallDate"))
        {
            editor.putLong("ADMS_Handheld_App_InstallDate", atz1.b("ADMS_InstallDate", 0L));
        }
        editor.commit();
_L1:
        return;
        atz1;
        StaticMethods.logErrorFormat("Wearable - Error saving Handheld App install date to shared preferences", new Object[0]);
          goto _L1
        atz1;
        obj;
        JVM INSTR monitorexit ;
        throw atz1;
    }

    private static void restorePrivacyStatus(atz atz1)
    {
label0:
        {
            synchronized (_privacyStatusMutex)
            {
                if (atz1.d("PrivacyStatus") < MobilePrivacyStatus.values().length)
                {
                    break label0;
                }
                StaticMethods.logWarningFormat("Wearable - Invalid PrivacyStatus value (%d)", new Object[] {
                    Integer.valueOf(atz1.d("PrivacyStatus"))
                });
            }
            return;
        }
        if (atz1.a("PrivacyStatus"))
        {
            Config.setPrivacyStatus(MobilePrivacyStatus.values()[atz1.d("PrivacyStatus")]);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        atz1;
        obj;
        JVM INSTR monitorexit ;
        throw atz1;
    }

    private static void restorePushEnabled(atz atz1)
    {
        synchronized (_pushEnabledMutex)
        {
            StaticMethods.setPushEnabled(atz1.c("ADBMOBILE_KEY_PUSH_ENABLED"));
        }
        return;
        atz1;
        obj;
        JVM INSTR monitorexit ;
        throw atz1;
    }

    protected static void restoreSharedConfig(atz atz1)
    {
        restoreHandheldInstallDate(atz1);
        restorePrivacyStatus(atz1);
        restoreVisitorID(atz1);
        restoreVidService(atz1);
        restoreAid(atz1);
        restoreAdid(atz1);
        restorePushEnabled(atz1);
    }

    private static void restoreVidService(atz atz1)
    {
        Object obj = _visServiceMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
        editor.putString("ADBMOBILE_PERSISTED_MID", atz1.f("ADBMOBILE_PERSISTED_MID"));
        editor.putString("ADBMOBILE_PERSISTED_MID_HINT", atz1.f("ADBMOBILE_PERSISTED_MID_HINT"));
        editor.putString("ADBMOBILE_PERSISTED_MID_BLOB", atz1.f("ADBMOBILE_PERSISTED_MID_BLOB"));
        editor.putLong("ADBMOBILE_VISITORID_TTL", atz1.e("ADBMOBILE_VISITORID_TTL"));
        editor.putLong("ADBMOBILE_VISITORID_SYNC", atz1.e("ADBMOBILE_VISITORID_SYNC"));
        editor.commit();
_L1:
        VisitorIDService.sharedInstance().resetVariablesFromSharedPreferences();
        return;
        atz1;
        StaticMethods.logErrorFormat("Wearable - Error saving Visitor Id Service data to shared preferences", new Object[0]);
          goto _L1
        atz1;
        obj;
        JVM INSTR monitorexit ;
        throw atz1;
    }

    private static void restoreVisitorID(atz atz1)
    {
        synchronized (_visitorIDMutex)
        {
            Config.setUserIdentifier(atz1.f("APP_MEASUREMENT_VISITOR_ID"));
        }
        return;
        atz1;
        obj;
        JVM INSTR monitorexit ;
        throw atz1;
    }

    protected static void syncAdvertisingIdentifier(String s)
    {
        if (StaticMethods.isWearableApp())
        {
            return;
        } else
        {
            atz atz1 = new atz();
            atz1.a("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER", s);
            syncData("/abdmobile/data/config/adId", atz1);
            return;
        }
    }

    protected static void syncConfigFromHandheld()
    {
        Object obj;
        Object obj1;
        if (!StaticMethods.isWearableApp())
        {
            break MISSING_BLOCK_LABEL_183;
        }
        Context context;
        String s;
        String s1;
        try
        {
            context = StaticMethods.getSharedContext().getApplicationContext();
            obj = (WearableDataResponse.ShareConfigResponse)(new WearableDataConnection(context)).send(WearableDataRequest.createShareConfigRequest(15000));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            StaticMethods.logErrorFormat("Analytics - Error syncing Points of Interest and In-app Messages from handheld app to wearable app (%s)", new Object[] {
                ((StaticMethods.NullContextException) (obj)).getLocalizedMessage()
            });
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (((WearableDataResponse.ShareConfigResponse) (obj)).getResult() != null)
        {
            restoreSharedConfig(((WearableDataResponse.ShareConfigResponse) (obj)).getResult());
        }
        s = MobileConfig.getInstance().getPointsOfInterestURL();
        s1 = MobileConfig.getInstance().getInAppMessageURL();
        if (s == null && s1 == null)
        {
            return;
        }
        obj = RemoteDownload.getFileForCachedURL(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = ((File) (obj)).getName();
_L2:
        obj1 = RemoteDownload.getFileForCachedURL(s1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        obj1 = ((File) (obj1)).getName();
_L1:
        (new WearableDataConnection(context)).send(WearableDataRequest.createFileRequest(s, ((String) (obj)), 15000));
        (new WearableDataConnection(context)).send(WearableDataRequest.createFileRequest(s1, ((String) (obj1)), 15000));
        MobileConfig.getInstance().loadCachedRemotes();
        return;
        obj1 = null;
          goto _L1
        obj = null;
          goto _L2
    }

    protected static void syncData(String s, atz atz1)
    {
        qm qm1;
        pp pp1;
        try
        {
            qm1 = (new qn(StaticMethods.getSharedContext())).a(auj.g).b();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        qm1.b();
        pp1 = qm1.a(15000L, TimeUnit.MILLISECONDS);
        if (pp1 == null || !pp1.b())
        {
            StaticMethods.logWarningFormat("Wearable - Failed to setup connection", new Object[0]);
            return;
        } else
        {
            s = aui.a(s);
            s.a().a(atz1);
            s = s.b();
            auj.a.a(qm1, s);
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
            atz atz1 = new atz();
            atz1.a("PrivacyStatus", i);
            syncData("/abdmobile/data/config/privacyStatus", atz1);
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
            atz atz1 = new atz();
            atz1.a("ADBMOBILE_KEY_PUSH_ENABLED", flag);
            syncData("/abdmobile/data/config/pushEnabled", atz1);
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
            atz atz1 = new atz();
            atz1.a("ADBMOBILE_PERSISTED_MID", s);
            atz1.a("ADBMOBILE_PERSISTED_MID_BLOB", s2);
            atz1.a("ADBMOBILE_PERSISTED_MID_HINT", s1);
            atz1.a("ADBMOBILE_VISITORID_TTL", l);
            atz1.a("ADBMOBILE_VISITORID_SYNC", l1);
            syncData("/abdmobile/data/config/vidService", atz1);
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
            atz atz1 = new atz();
            atz1.a("APP_MEASUREMENT_VISITOR_ID", s);
            syncData("/abdmobile/data/config/visitorId", atz1);
            return;
        }
    }

}

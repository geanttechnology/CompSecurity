// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ManifestInfo, PushType, PLog, ParseInstallation, 
//            ServiceUtils, GcmRegistrar, ProxyService, PPNSUtil, 
//            GCMService

public final class PushService extends Service
{
    static interface ServiceLifecycleCallbacks
    {

        public abstract void onServiceCreated(Service service);

        public abstract void onServiceDestroyed(Service service);
    }


    static final String ACTION_START_IF_REQUIRED = "com.parse.PushService.startIfRequired";
    private static final String TAG = "com.parse.PushService";
    private static boolean loggedStartError = false;
    private static List serviceLifecycleCallbacks = null;
    private ProxyService proxy;

    public PushService()
    {
    }

    private static Object[] collectServiceLifecycleCallbacks()
    {
        Object aobj[] = null;
        com/parse/PushService;
        JVM INSTR monitorenter ;
        if (serviceLifecycleCallbacks != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        com/parse/PushService;
        JVM INSTR monitorexit ;
        return null;
        if (serviceLifecycleCallbacks.size() > 0)
        {
            aobj = serviceLifecycleCallbacks.toArray();
        }
        com/parse/PushService;
        JVM INSTR monitorexit ;
        return aobj;
        Exception exception;
        exception;
        com/parse/PushService;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void dispatchOnServiceCreated(Service service)
    {
        Object aobj[] = collectServiceLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ServiceLifecycleCallbacks)aobj[i]).onServiceCreated(service);
            }

        }
    }

    private static void dispatchOnServiceDestroyed(Service service)
    {
        Object aobj[] = collectServiceLifecycleCallbacks();
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                ((ServiceLifecycleCallbacks)aobj[i]).onServiceDestroyed(service);
            }

        }
    }

    static void registerServiceLifecycleCallbacks(ServiceLifecycleCallbacks servicelifecyclecallbacks)
    {
        com/parse/PushService;
        JVM INSTR monitorenter ;
        if (serviceLifecycleCallbacks == null)
        {
            serviceLifecycleCallbacks = new ArrayList();
        }
        serviceLifecycleCallbacks.add(servicelifecyclecallbacks);
        com/parse/PushService;
        JVM INSTR monitorexit ;
        return;
        servicelifecyclecallbacks;
        com/parse/PushService;
        JVM INSTR monitorexit ;
        throw servicelifecyclecallbacks;
    }

    static void startServiceIfRequired(Context context)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$parse$PushType[];

            static 
            {
                $SwitchMap$com$parse$PushType = new int[PushType.values().length];
                try
                {
                    $SwitchMap$com$parse$PushType[PushType.PPNS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$PushType[PushType.GCM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            if (!loggedStartError)
            {
                PLog.e("com.parse.PushService", (new StringBuilder()).append("Tried to use push, but this app is not configured for push due to: ").append(ManifestInfo.getNonePushTypeLogMessage()).toString());
                loggedStartError = true;
            }
            return;

        case 1: // '\001'
            ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
            if (parseinstallation.getPushType() == PushType.GCM)
            {
                PLog.w("com.parse.PushService", "Detected a client that used to use GCM and is now using PPNS.");
                parseinstallation.removePushType();
                parseinstallation.removeDeviceToken();
                parseinstallation.saveEventually();
            }
            ServiceUtils.runIntentInService(context, new Intent("com.parse.PushService.startIfRequired"), com/parse/PushService);
            return;

        case 2: // '\002'
            GcmRegistrar.getInstance().registerAsync();
            return;
        }
    }

    static void stopServiceIfRequired(Context context)
    {
        switch (_cls1..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            context.stopService(new Intent(context, com/parse/PushService));
            break;
        }
    }

    static void unregisterServiceLifecycleCallbacks(ServiceLifecycleCallbacks servicelifecyclecallbacks)
    {
        com/parse/PushService;
        JVM INSTR monitorenter ;
        serviceLifecycleCallbacks.remove(servicelifecyclecallbacks);
        if (serviceLifecycleCallbacks.size() <= 0)
        {
            serviceLifecycleCallbacks = null;
        }
        com/parse/PushService;
        JVM INSTR monitorexit ;
        return;
        servicelifecyclecallbacks;
        com/parse/PushService;
        JVM INSTR monitorexit ;
        throw servicelifecyclecallbacks;
    }

    public IBinder onBind(Intent intent)
    {
        throw new IllegalArgumentException("You cannot bind directly to the PushService. Use PushService.subscribe instead.");
    }

    public void onCreate()
    {
        super.onCreate();
        if (ParsePlugins.Android.get().applicationContext() == null)
        {
            PLog.e("com.parse.PushService", "The Parse push service cannot start because Parse.initialize has not yet been called. If you call Parse.initialize from an Activity's onCreate, that call should instead be in the Application.onCreate. Be sure your Application class is registered in your AndroidManifest.xml with the android:name property of your <application> tag.");
            stopSelf();
            return;
        }
        _cls1..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()];
        JVM INSTR tableswitch 1 2: default 56
    //                   1 84
    //                   2 95;
           goto _L1 _L2 _L3
_L1:
        PLog.e("com.parse.PushService", "PushService somehow started even though this device doesn't support push.");
_L5:
        if (proxy != null)
        {
            proxy.onCreate();
        }
        dispatchOnServiceCreated(this);
        return;
_L2:
        proxy = PPNSUtil.newPPNSService(this);
        continue; /* Loop/switch isn't completed */
_L3:
        proxy = new GCMService(this);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onDestroy()
    {
        if (proxy != null)
        {
            proxy.onDestroy();
        }
        dispatchOnServiceDestroyed(this);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        switch (_cls1..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            PLog.e("com.parse.PushService", (new StringBuilder()).append("Started push service even though no push service is enabled: ").append(intent).toString());
            ServiceUtils.completeWakefulIntent(intent);
            return 2;

        case 1: // '\001'
        case 2: // '\002'
            return proxy.onStartCommand(intent, i, j);
        }
    }

}

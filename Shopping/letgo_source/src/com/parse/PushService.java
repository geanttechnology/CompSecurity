// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.parse:
//            ManifestInfo, ParseException, PushRouter, ParseTaskUtils, 
//            GcmRegistrar, PLog, ServiceUtils, PushType, 
//            ParseInstallation, PushConnection

public final class PushService extends Service
{
    static interface ServiceLifecycleCallbacks
    {

        public abstract void onServiceCreated(Service service);

        public abstract void onServiceDestroyed(Service service);
    }


    static final String CANNOT_USE_PUSH_V1_ERROR_MESSAGE = "PushService.subscribe, PushService.unsubscribe, and PushService.setDefaultPushCallback methods cannot be used in conjunction with ParsePushBroadcastReceiver. See ParsePush.subscribe and ParsePush.unsubscribe.";
    private static final String START_IF_REQUIRED_ACTION = "com.parse.PushService.startIfRequired";
    private static final String TAG = "com.parse.PushService";
    private static final int WAKE_LOCK_TIMEOUT_MS = 20000;
    private static String host = "push.parse.com";
    private static boolean loggedStartError = false;
    private static int port = 443;
    private static List serviceLifecycleCallbacks = null;
    private PushConnection connection;
    private ExecutorService executor;

    public PushService()
    {
    }

    private static void checkManifestAndThrowExceptionIfNeeded()
    {
        if (ManifestInfo.getPushUsesBroadcastReceivers())
        {
            throw new IllegalStateException("PushService.subscribe, PushService.unsubscribe, and PushService.setDefaultPushCallback methods cannot be used in conjunction with ParsePushBroadcastReceiver. See ParsePush.subscribe and ParsePush.unsubscribe.");
        } else
        {
            return;
        }
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

    public static Set getSubscriptions(Context context)
    {
        try
        {
            context = (Set)ParseTaskUtils.wait(PushRouter.getSubscriptionsAsync(false));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        return context;
    }

    private int onGcmStartCommand(final Intent intent, int i, final int startId)
    {
        executor.execute(new Runnable() {

            final PushService this$0;
            final Intent val$intent;
            final int val$startId;

            public void run()
            {
                onHandleGcmIntent(intent);
                ServiceUtils.completeWakefulIntent(intent);
                stopSelf(startId);
                return;
                Exception exception;
                exception;
                ServiceUtils.completeWakefulIntent(intent);
                stopSelf(startId);
                throw exception;
            }

            
            {
                this$0 = PushService.this;
                intent = intent1;
                startId = i;
                super();
            }
        });
        return 2;
    }

    private void onHandleGcmIntent(Intent intent)
    {
label0:
        {
            if (intent != null)
            {
                GcmRegistrar gcmregistrar = GcmRegistrar.getInstance();
                if (!gcmregistrar.isRegistrationIntent(intent))
                {
                    break label0;
                }
                gcmregistrar.handleRegistrationIntentAsync(intent);
            }
            return;
        }
        if (PushRouter.isGcmPushIntent(intent))
        {
            PushRouter.handleGcmPushIntent(intent);
            return;
        } else
        {
            PLog.e("com.parse.PushService", (new StringBuilder()).append("PushService got unknown intent in GCM mode: ").append(intent).toString());
            return;
        }
    }

    private int onPpnsStartCommand(final Intent forceEnabledCapture, int i, int j)
    {
        final PushConnection conn = connection;
        if (forceEnabledCapture == null || forceEnabledCapture.getAction() == null || forceEnabledCapture.getAction().equals("com.parse.PushService.startIfRequired"))
        {
            PLog.i("com.parse.PushService", "Received request to start service if required");
            forceEnabledCapture = new cs();
            PushRouter.getForceEnabledStateAsync().d(new ct() {

                final PushService this$0;
                final cs val$forceEnabledCapture;

                public cu then(cu cu1)
                    throws Exception
                {
                    forceEnabledCapture.a(cu1.e());
                    return PushRouter.getSubscriptionsAsync(true);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = PushService.this;
                forceEnabledCapture = cs1;
                super();
            }
            }).c(new ct() {

                final PushService this$0;
                final PushConnection val$conn;
                final cs val$forceEnabledCapture;

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

                public Void then(cu cu1)
                    throws Exception
                {
                    Boolean boolean1;
                    boolean flag;
                    boolean1 = (Boolean)forceEnabledCapture.a();
                    flag = ManifestInfo.getPushUsesBroadcastReceivers();
                    cu1 = (Set)cu1.e();
                    if (flag) goto _L2; else goto _L1
_L1:
                    if (cu1 == null || cu1.size() != 0) goto _L4; else goto _L3
_L3:
                    cu1 = "Not starting PushService because this device has no subscriptions";
_L6:
                    if (cu1 != null)
                    {
                        PLog.i("com.parse.PushService", cu1);
                        stopSelf();
                        return null;
                    } else
                    {
                        PLog.d("com.parse.PushService", "Starting PushService.");
                        conn.start();
                        return null;
                    }
_L2:
                    if (ParseInstallation.getCurrentInstallation().getObjectId() == null)
                    {
                        cu1 = "Not starting PushService because this device is not registered for push notifications.";
                        continue; /* Loop/switch isn't completed */
                    }
                    if (boolean1 != null && !boolean1.booleanValue())
                    {
                        cu1 = "Not starting PushService because push has been manually disabled.";
                        continue; /* Loop/switch isn't completed */
                    }
_L4:
                    cu1 = null;
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                this$0 = PushService.this;
                forceEnabledCapture = cs1;
                conn = pushconnection;
                super();
            }
            });
        }
        return 1;
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

    static void runGcmIntentInService(Context context, Intent intent)
    {
        ServiceUtils.runWakefulIntentInService(context, intent, com/parse/PushService, 20000L);
    }

    public static void setDefaultPushCallback(Context context, Class class1)
    {
        setDefaultPushCallback(context, class1, context.getApplicationInfo().icon);
    }

    public static void setDefaultPushCallback(Context context, Class class1, int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Must subscribe to channel with a valid icon identifier.");
        }
        if (class1 == null)
        {
            unsubscribeInternal(null);
            return;
        } else
        {
            PushRouter.subscribeAsync(null, class1, i).c(new ct() {

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

                public Void then(cu cu1)
                {
                    PushService.startServiceIfRequired(ParsePlugins.Android.get().applicationContext());
                    return null;
                }

            });
            return;
        }
    }

    private static void startPpnsServiceIfRequired(Context context)
    {
        if (ManifestInfo.getPushType() == PushType.PPNS)
        {
            ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
            if (parseinstallation.getPushType() == PushType.GCM)
            {
                PLog.w("com.parse.PushService", "Detected a client that used to use GCM and is now using PPNS.");
                parseinstallation.removePushType();
                parseinstallation.removeDeviceToken();
                parseinstallation.saveEventually();
            }
            ServiceUtils.runIntentInService(context, new Intent("com.parse.PushService.startIfRequired"), com/parse/PushService);
        }
    }

    public static void startServiceIfRequired(Context context)
    {
        static class _cls8
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

        switch (_cls8..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            if (!loggedStartError)
            {
                PLog.e("com.parse.PushService", (new StringBuilder()).append("Tried to use push, but this app is not configured for push due to: ").append(ManifestInfo.getNonePushTypeLogMessage()).toString());
                loggedStartError = true;
            }
            return;

        case 1: // '\001'
            startPpnsServiceIfRequired(context);
            return;

        case 2: // '\002'
            GcmRegistrar.getInstance().registerAsync();
            return;
        }
    }

    static void stopPpnsService(Context context)
    {
        if (ManifestInfo.getPushType() == PushType.PPNS)
        {
            context.stopService(new Intent(context, com/parse/PushService));
        }
    }

    public static void subscribe(Context context, String s, Class class1)
    {
        subscribe(context, s, class1, context.getApplicationInfo().icon);
    }

    public static void subscribe(Context context, String s, Class class1, int i)
    {
        com/parse/PushService;
        JVM INSTR monitorenter ;
        checkManifestAndThrowExceptionIfNeeded();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        throw new IllegalArgumentException("Can't subscribe to null channel.");
        context;
        com/parse/PushService;
        JVM INSTR monitorexit ;
        throw context;
        PushRouter.subscribeAsync(s, class1, i).c(new ct() {

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                PushService.startServiceIfRequired(ParsePlugins.Android.get().applicationContext());
                return null;
            }

        });
        com/parse/PushService;
        JVM INSTR monitorexit ;
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

    public static void unsubscribe(Context context, String s)
    {
        com/parse/PushService;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        throw new IllegalArgumentException("Can't unsubscribe from null channel.");
        context;
        com/parse/PushService;
        JVM INSTR monitorexit ;
        throw context;
        unsubscribeInternal(s);
        com/parse/PushService;
        JVM INSTR monitorexit ;
    }

    private static void unsubscribeInternal(String s)
    {
        checkManifestAndThrowExceptionIfNeeded();
        PushRouter.unsubscribeAsync(s).d(new ct() {

            public cu then(cu cu1)
            {
                return PushRouter.getSubscriptionsAsync(true);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        }).c(new ct() {

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                if (((Set)cu1.e()).size() == 0)
                {
                    PushService.stopPpnsService(ParsePlugins.Android.get().applicationContext());
                }
                return null;
            }

        });
    }

    static void useServer(String s, int i)
    {
        host = s;
        port = i;
    }

    private void wipeRoutingAndUpgradePushStateIfNeeded()
    {
        if (ManifestInfo.getPushUsesBroadcastReceivers())
        {
            PushRouter.wipeRoutingAndUpgradePushStateAsync();
        }
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
        _cls8..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 73
    //                   2 94;
           goto _L1 _L2 _L3
_L1:
        PLog.e("com.parse.PushService", "PushService somehow started even though this device doesn't support push.");
_L5:
        dispatchOnServiceCreated(this);
        return;
_L2:
        connection = new PushConnection(this, host, port);
        continue; /* Loop/switch isn't completed */
_L3:
        executor = Executors.newSingleThreadExecutor();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onDestroy()
    {
        if (connection != null)
        {
            connection.stop();
        }
        if (executor != null)
        {
            executor.shutdown();
        }
        dispatchOnServiceDestroyed(this);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        wipeRoutingAndUpgradePushStateIfNeeded();
        switch (_cls8..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            PLog.e("com.parse.PushService", (new StringBuilder()).append("Started push service even though no push service is enabled: ").append(intent).toString());
            ServiceUtils.completeWakefulIntent(intent);
            return 2;

        case 1: // '\001'
            return onPpnsStartCommand(intent, i, j);

        case 2: // '\002'
            return onGcmStartCommand(intent, i, j);
        }
    }


}

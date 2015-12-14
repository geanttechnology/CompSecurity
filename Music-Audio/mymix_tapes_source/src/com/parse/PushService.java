// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.parse:
//            ManifestInfo, ParseException, PushRouter, Parse, 
//            GcmRegistrar, ServiceUtils, PushType, ParseInstallation, 
//            PushConnection

public final class PushService extends Service
{
    static interface LifecycleListener
    {

        public abstract void onServiceCreated(Service service);

        public abstract void onServiceDestroyed(Service service);
    }


    static final String CANNOT_USE_PUSH_V1_ERROR_MESSAGE = "PushService.subscribe, PushService.unsubscribe, and PushService.setDefaultPushCallback methods cannot be used in conjunction with ParsePushBroadcastReceiver. See ParsePush.subscribe and ParsePush.unsubscribe.";
    private static final String START_IF_REQUIRED_ACTION = "com.parse.PushService.startIfRequired";
    private static final String TAG = "com.parse.PushService";
    private static final int WAKE_LOCK_TIMEOUT_MS = 20000;
    private static String host = "push.parse.com";
    private static LifecycleListener lifecycleListener = null;
    private static boolean loggedStartError = false;
    private static int port = 8253;
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

    public static Set getSubscriptions(Context context)
    {
        try
        {
            context = (Set)Parse.waitForTask(PushRouter.getSubscriptionsAsync(false));
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
                if (!GcmRegistrar.getInstance().isRegistrationIntent(intent))
                {
                    break label0;
                }
                GcmRegistrar.getInstance().handleRegistrationIntent(intent);
            }
            return;
        }
        if (PushRouter.isGcmPushIntent(intent))
        {
            PushRouter.handleGcmPushIntent(intent);
            return;
        } else
        {
            Parse.logE("com.parse.PushService", (new StringBuilder()).append("PushService got unknown intent in GCM mode: ").append(intent).toString());
            return;
        }
    }

    private int onPpnsStartCommand(final Intent forceEnabledCapture, int i, int j)
    {
        final PushConnection conn = connection;
        if (forceEnabledCapture == null || forceEnabledCapture.getAction() == null || forceEnabledCapture.getAction().equals("com.parse.PushService.startIfRequired"))
        {
            Parse.logI("com.parse.PushService", "Received request to start service if required");
            forceEnabledCapture = new Capture();
            PushRouter.getForceEnabledStateAsync().onSuccessTask(new Continuation() {

                final PushService this$0;
                final Capture val$forceEnabledCapture;

                public Task then(Task task)
                    throws Exception
                {
                    forceEnabledCapture.set(task.getResult());
                    return PushRouter.getSubscriptionsAsync(true);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = PushService.this;
                forceEnabledCapture = capture;
                super();
            }
            }).onSuccess(new Continuation() {

                final PushService this$0;
                final PushConnection val$conn;
                final Capture val$forceEnabledCapture;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
                    throws Exception
                {
                    Boolean boolean1 = (Boolean)forceEnabledCapture.get();
                    boolean flag = ManifestInfo.getPushUsesBroadcastReceivers();
                    Set set = (Set)task.getResult();
                    Object obj = null;
                    if (!flag)
                    {
                        task = obj;
                        if (set != null)
                        {
                            task = obj;
                            if (set.size() == 0)
                            {
                                task = "Not starting PushService because this device has no subscriptions";
                            }
                        }
                    } else
                    if (ParseInstallation.getCurrentInstallation().getObjectId() == null)
                    {
                        task = "Not starting PushService because this device is not registered for push notifications.";
                    } else
                    {
                        task = obj;
                        if (boolean1 != null)
                        {
                            task = obj;
                            if (!boolean1.booleanValue())
                            {
                                task = "Not starting PushService because push has been manually disabled.";
                            }
                        }
                    }
                    if (task != null)
                    {
                        Parse.logI("com.parse.PushService", task);
                        stopSelf();
                    } else
                    {
                        Parse.logD("com.parse.PushService", "Starting PushService.");
                        conn.start();
                    }
                    return null;
                }

            
            {
                this$0 = PushService.this;
                forceEnabledCapture = capture;
                conn = pushconnection;
                super();
            }
            });
        }
        return 1;
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
            PushRouter.subscribeAsync(null, class1, i).onSuccess(new Continuation() {

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
                {
                    PushService.startServiceIfRequired(Parse.applicationContext);
                    return null;
                }

            });
            return;
        }
    }

    static void setLifecycleListener(LifecycleListener lifecyclelistener)
    {
        lifecycleListener = lifecyclelistener;
    }

    private static void startPpnsServiceIfRequired(Context context)
    {
        if (ManifestInfo.getPushType() == PushType.PPNS)
        {
            ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
            if (parseinstallation.getPushType() == PushType.GCM)
            {
                Parse.logW("com.parse.PushService", "Detected a client that used to use GCM and is now using PPNS.");
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
                Parse.logE("com.parse.PushService", (new StringBuilder()).append("Tried to use push, but this app is not configured for push due to: ").append(ManifestInfo.getNonePushTypeLogMessage()).toString());
                loggedStartError = true;
            }
            return;

        case 1: // '\001'
            startPpnsServiceIfRequired(context);
            return;

        case 2: // '\002'
            GcmRegistrar.getInstance().register();
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
        PushRouter.subscribeAsync(s, class1, i).onSuccess(new Continuation() {

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
            {
                PushService.startServiceIfRequired(Parse.applicationContext);
                return null;
            }

        });
        com/parse/PushService;
        JVM INSTR monitorexit ;
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
        PushRouter.unsubscribeAsync(s).onSuccessTask(new Continuation() {

            public Task then(Task task)
            {
                return PushRouter.getSubscriptionsAsync(true);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        }).onSuccess(new Continuation() {

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
            {
                if (((Set)task.getResult()).size() == 0)
                {
                    PushService.stopPpnsService(Parse.applicationContext);
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
        if (Parse.applicationContext != null) goto _L2; else goto _L1
_L1:
        Parse.logE("com.parse.PushService", "The Parse push service cannot start because Parse.initialize has not yet been called. If you call Parse.initialize from an Activity's onCreate, that call should instead be in the Application.onCreate. Be sure your Application class is registered in your AndroidManifest.xml with the android:name property of your <application> tag.");
        stopSelf();
_L4:
        return;
_L2:
        switch (_cls8..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            Parse.logE("com.parse.PushService", "PushService somehow started even though this device doesn't support push.");
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_101;
        }
_L5:
        if (lifecycleListener != null)
        {
            lifecycleListener.onServiceCreated(this);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        connection = new PushConnection(this, host, port);
          goto _L5
        executor = Executors.newSingleThreadExecutor();
          goto _L5
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
        if (lifecycleListener != null)
        {
            lifecycleListener.onServiceDestroyed(this);
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        wipeRoutingAndUpgradePushStateIfNeeded();
        switch (_cls8..SwitchMap.com.parse.PushType[ManifestInfo.getPushType().ordinal()])
        {
        default:
            Parse.logE("com.parse.PushService", (new StringBuilder()).append("Started push service even though no push service is enabled: ").append(intent).toString());
            ServiceUtils.completeWakefulIntent(intent);
            return 2;

        case 1: // '\001'
            return onPpnsStartCommand(intent, i, j);

        case 2: // '\002'
            return onGcmStartCommand(intent, i, j);
        }
    }


}

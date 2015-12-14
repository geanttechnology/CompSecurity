// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import bolts.Continuation;
import bolts.Task;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.parse:
//            ManifestInfo, Parse, ParseInstallation, PushType

class GcmRegistrar
{
    private static class Request
    {

        private static final int BACKOFF_INTERVAL_MS = 3000;
        private static final int MAX_RETRIES = 5;
        private static final String RETRY_ACTION = "com.parse.RetryGcmRegistration";
        private final PendingIntent appIntent;
        private final Context context;
        private final int identifier;
        private final Random random = new Random();
        private final PendingIntent retryIntent;
        private final BroadcastReceiver retryReceiver = new _cls1();
        private final String senderId;
        private final bolts.Task.TaskCompletionSource tcs = Task.create();
        private final AtomicInteger tries = new AtomicInteger(0);

        public static Request createAndSend(Context context1, String s)
        {
            context1 = new Request(context1, s);
            context1.send();
            return context1;
        }

        private void finish(String s, String s1)
        {
            boolean flag;
            if (s != null)
            {
                flag = tcs.trySetResult(s);
            } else
            {
                flag = tcs.trySetError(new Exception((new StringBuilder()).append("GCM registration error: ").append(s1).toString()));
            }
            if (flag)
            {
                appIntent.cancel();
                retryIntent.cancel();
                context.unregisterReceiver(retryReceiver);
            }
        }

        private void send()
        {
            android.content.ComponentName componentname;
            Object obj;
            obj = new Intent("com.google.android.c2dm.intent.REGISTER");
            ((Intent) (obj)).setPackage("com.google.android.gsf");
            ((Intent) (obj)).putExtra("sender", senderId);
            ((Intent) (obj)).putExtra("app", appIntent);
            componentname = null;
            obj = context.startService(((Intent) (obj)));
            componentname = ((android.content.ComponentName) (obj));
_L2:
            if (componentname == null)
            {
                finish(null, "GSF_PACKAGE_NOT_AVAILABLE");
            }
            tries.incrementAndGet();
            Parse.logV("com.parse.GcmRegistrar", "Sending GCM registration intent");
            return;
            SecurityException securityexception;
            securityexception;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public Task getTask()
        {
            return tcs.getTask();
        }

        public void onReceiveResponseIntent(Intent intent)
        {
            String s = intent.getStringExtra("registration_id");
            intent = intent.getStringExtra("error");
            if (s == null && intent == null)
            {
                Parse.logE("com.parse.GcmRegistrar", "Got no registration info in GCM onReceiveResponseIntent");
                return;
            }
            if ("SERVICE_NOT_AVAILABLE".equals(intent) && tries.get() < 5)
            {
                intent = (AlarmManager)context.getSystemService("alarm");
                long l = (1 << tries.get()) * 3000 + random.nextInt(3000);
                intent.set(2, SystemClock.elapsedRealtime() + l, retryIntent);
                return;
            } else
            {
                finish(s, intent);
                return;
            }
        }



        private Request(Context context1, String s)
        {
            context = context1;
            senderId = s;
            identifier = random.nextInt();
            appIntent = PendingIntent.getBroadcast(context, identifier, new Intent(), 0);
            s = context.getPackageName();
            Object obj = (new Intent("com.parse.RetryGcmRegistration")).setPackage(s);
            ((Intent) (obj)).addCategory(s);
            ((Intent) (obj)).putExtra("random", identifier);
            retryIntent = PendingIntent.getBroadcast(context, identifier, ((Intent) (obj)), 0);
            obj = new IntentFilter();
            ((IntentFilter) (obj)).addAction("com.parse.RetryGcmRegistration");
            ((IntentFilter) (obj)).addCategory(s);
            context1.registerReceiver(retryReceiver, ((IntentFilter) (obj)));
        }
    }

    private static class Singleton
    {

        public static final GcmRegistrar INSTANCE = new GcmRegistrar(Parse.getApplicationContext());


        private Singleton()
        {
        }
    }


    private static final String ERROR_EXTRA = "error";
    private static final String PARSE_SENDER_ID = "1076345567071";
    public static final String REGISTER_ACTION = "com.google.android.c2dm.intent.REGISTER";
    public static final String REGISTER_RESPONSE_ACTION = "com.google.android.c2dm.intent.REGISTRATION";
    private static final String REGISTRATION_ID_EXTRA = "registration_id";
    private static final String SENDER_ID_EXTRA = "com.parse.push.gcm_sender_id";
    private static final String TAG = "com.parse.GcmRegistrar";
    private Context context;
    private Object lock;
    private Request request;

    GcmRegistrar(Context context1)
    {
        lock = new Object();
        request = null;
        context = null;
        context = context1;
    }

    private static String actualSenderIDFromExtra(Object obj)
    {
        if (obj instanceof String)
        {
            if (((String) (obj = (String)obj)).startsWith("id:"))
            {
                return ((String) (obj)).substring(3);
            }
        }
        return null;
    }

    public static GcmRegistrar getInstance()
    {
        return Singleton.INSTANCE;
    }

    private void sendRegistrationRequest()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (request != null) goto _L2; else goto _L1
_L1:
        Object obj1 = ManifestInfo.getApplicationMetadata();
        String s;
        String s1;
        s1 = "1076345567071";
        s = s1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj1 = ((Bundle) (obj1)).get("com.parse.push.gcm_sender_id");
        s = s1;
        if (obj1 == null) goto _L4; else goto _L5
_L5:
        s = actualSenderIDFromExtra(obj1);
        if (s == null) goto _L7; else goto _L6
_L6:
        s = (new StringBuilder()).append("1076345567071").append(",").append(s).toString();
_L4:
        request = Request.createAndSend(context, s);
        request.getTask().continueWith(new Continuation() {

            final GcmRegistrar this$0;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
            {
                task = task.getError();
                if (task != null)
                {
                    Parse.logE("com.parse.GcmRegistrar", "Got error when trying to register for GCM push", task);
                }
                synchronized (lock)
                {
                    request = null;
                }
                return null;
                exception1;
                task;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                this$0 = GcmRegistrar.this;
                super();
            }
        });
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L7:
        Parse.logE("com.parse.GcmRegistrar", (new StringBuilder()).append("Found com.parse.push.gcm_sender_id <meta-data> element with value \"").append(obj1.toString()).append("\", but the value is missing the expected \"id:\" ").append("prefix.").toString());
        s = s1;
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void updateAsync()
    {
        Task.callInBackground(new Callable() {

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
            {
                GcmRegistrar.getInstance().update();
                return null;
            }

        });
    }

    int getRequestIdentifier()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        int i;
        if (request == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        i = request.identifier;
_L2:
        return i;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void handleRegistrationIntent(Intent intent)
    {
        if (isRegistrationIntent(intent))
        {
            String s = intent.getStringExtra("registration_id");
            if (s != null && s.length() > 0)
            {
                ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
                parseinstallation.setPushType(PushType.GCM);
                parseinstallation.setDeviceToken(s);
                parseinstallation.saveEventually();
            }
            synchronized (lock)
            {
                if (request != null)
                {
                    request.onReceiveResponseIntent(intent);
                }
            }
            return;
        } else
        {
            return;
        }
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
    }

    public boolean isRegistrationIntent(Intent intent)
    {
        return intent != null && "com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction());
    }

    public void register()
    {
        if (ManifestInfo.getPushType() == PushType.GCM)
        {
            synchronized (lock)
            {
                ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
                if (parseinstallation.getDeviceToken() == null || parseinstallation.isDeviceTokenStale())
                {
                    if (parseinstallation.getPushType() != PushType.GCM)
                    {
                        parseinstallation.setPushType(PushType.GCM);
                        parseinstallation.saveEventually();
                    }
                    sendRegistrationRequest();
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void update()
    {
        if (ParseInstallation.hasCurrentInstallation() && ManifestInfo.getPushType() == PushType.GCM)
        {
            synchronized (lock)
            {
                ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
                if (parseinstallation.getPushType() == PushType.GCM && (parseinstallation.getDeviceToken() == null || parseinstallation.isDeviceTokenStale()))
                {
                    sendRegistrationRequest();
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }



/*
    static Request access$102(GcmRegistrar gcmregistrar, Request request1)
    {
        gcmregistrar.request = request1;
        return request1;
    }

*/

    // Unreferenced inner class com/parse/GcmRegistrar$Request$1

/* anonymous class */
    class Request._cls1 extends BroadcastReceiver
    {

        final Request this$0;

        public void onReceive(Context context1, Intent intent)
        {
            if (intent != null && intent.getIntExtra("random", 0) == identifier)
            {
                send();
            }
        }

            
            {
                this$0 = Request.this;
                super();
            }
    }

}

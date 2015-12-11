// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.parse:
//            ParseFileUtils, Parse, ManifestInfo, PLog, 
//            ParseInstallation, PushType

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
        private final a.j.a tcs = j.a();
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
                flag = tcs.a(s);
            } else
            {
                flag = tcs.a(new Exception((new StringBuilder()).append("GCM registration error: ").append(s1).toString()));
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
            Object obj = new Intent("com.google.android.c2dm.intent.REGISTER");
            ((Intent) (obj)).setPackage("com.google.android.gsf");
            ((Intent) (obj)).putExtra("sender", senderId);
            ((Intent) (obj)).putExtra("app", appIntent);
            try
            {
                obj = context.startService(((Intent) (obj)));
            }
            catch (SecurityException securityexception)
            {
                securityexception = null;
            }
            if (obj == null)
            {
                finish(null, "GSF_PACKAGE_NOT_AVAILABLE");
            }
            tries.incrementAndGet();
            PLog.v("com.parse.GcmRegistrar", "Sending GCM registration intent");
        }

        public j getTask()
        {
            return tcs.a();
        }

        public void onReceiveResponseIntent(Intent intent)
        {
            String s = intent.getStringExtra("registration_id");
            intent = intent.getStringExtra("error");
            if (s == null && intent == null)
            {
                PLog.e("com.parse.GcmRegistrar", "Got no registration info in GCM onReceiveResponseIntent");
                return;
            }
            if ("SERVICE_NOT_AVAILABLE".equals(intent) && tries.get() < 5)
            {
                ((AlarmManager)context.getSystemService("alarm")).set(2, (long)((1 << tries.get()) * 3000 + random.nextInt(3000)) + SystemClock.elapsedRealtime(), retryIntent);
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
    private static final String FILENAME_DEVICE_TOKEN_LAST_MODIFIED = "deviceTokenLastModified";
    private static final String PARSE_SENDER_ID = "1076345567071";
    public static final String REGISTER_ACTION = "com.google.android.c2dm.intent.REGISTER";
    private static final String REGISTRATION_ID_EXTRA = "registration_id";
    private static final String SENDER_ID_EXTRA = "com.parse.push.gcm_sender_id";
    private static final String TAG = "com.parse.GcmRegistrar";
    private Context context;
    private long localDeviceTokenLastModified;
    private final Object localDeviceTokenLastModifiedMutex = new Object();
    private final Object lock = new Object();
    private Request request;

    GcmRegistrar(Context context1)
    {
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

    static void deleteLocalDeviceTokenLastModifiedFile()
    {
        ParseFileUtils.deleteQuietly(getLocalDeviceTokenLastModifiedFile());
    }

    public static GcmRegistrar getInstance()
    {
        return Singleton.INSTANCE;
    }

    private j getLocalDeviceTokenLastModifiedAsync()
    {
        return j.a(new Callable() {

            final GcmRegistrar this$0;

            public Long call()
                throws Exception
            {
                Object obj = localDeviceTokenLastModifiedMutex;
                obj;
                JVM INSTR monitorenter ;
                long l = localDeviceTokenLastModified;
                if (l != 0L)
                {
                    break MISSING_BLOCK_LABEL_48;
                }
                String s = ParseFileUtils.readFileToString(GcmRegistrar.getLocalDeviceTokenLastModifiedFile(), "UTF-8");
                localDeviceTokenLastModified = Long.valueOf(s).longValue();
_L1:
                l = localDeviceTokenLastModified;
                obj;
                JVM INSTR monitorexit ;
                return Long.valueOf(l);
                Object obj1;
                obj1;
                localDeviceTokenLastModified = 0L;
                  goto _L1
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GcmRegistrar.this;
                super();
            }
        }, j.a);
    }

    static File getLocalDeviceTokenLastModifiedFile()
    {
        return new File(Parse.getParseCacheDir("GCMRegistrar"), "deviceTokenLastModified");
    }

    private j sendRegistrationRequestAsync()
    {
label0:
        {
            j j1;
            synchronized (lock)
            {
                if (request == null)
                {
                    break label0;
                }
                j1 = j.a(null);
            }
            return j1;
        }
        Object obj2 = ManifestInfo.getApplicationMetadata(context);
        String s;
        s = "1076345567071";
        obj = s;
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        obj2 = ((Bundle) (obj2)).get("com.parse.push.gcm_sender_id");
        obj = s;
        if (obj2 == null) goto _L2; else goto _L3
_L3:
        obj = actualSenderIDFromExtra(obj2);
        if (obj == null) goto _L5; else goto _L4
_L4:
        obj = (new StringBuilder()).append("1076345567071").append(",").append(((String) (obj))).toString();
_L2:
        request = Request.createAndSend(context, ((String) (obj)));
        obj = request.getTask().a(new i() {

            final GcmRegistrar this$0;

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            public Void then(j j2)
            {
                j2 = j2.f();
                if (j2 != null)
                {
                    PLog.e("com.parse.GcmRegistrar", "Got error when trying to register for GCM push", j2);
                }
                synchronized (lock)
                {
                    request = null;
                }
                return null;
                exception;
                j2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = GcmRegistrar.this;
                super();
            }
        });
        obj1;
        JVM INSTR monitorexit ;
        return ((j) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L5:
        PLog.e("com.parse.GcmRegistrar", (new StringBuilder()).append("Found com.parse.push.gcm_sender_id <meta-data> element with value \"").append(obj2.toString()).append("\", but the value is missing the expected \"id:\" ").append("prefix.").toString());
        obj = s;
          goto _L2
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

    public j handleRegistrationIntentAsync(Intent intent)
    {
        ArrayList arraylist = new ArrayList();
        String s = intent.getStringExtra("registration_id");
        if (s != null && s.length() > 0)
        {
            ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
            if (!s.equals(parseinstallation.getDeviceToken()))
            {
                parseinstallation.setPushType(PushType.GCM);
                parseinstallation.setDeviceToken(s);
                arraylist.add(parseinstallation.saveInBackground());
            }
            arraylist.add(updateLocalDeviceTokenLastModifiedAsync());
        }
        synchronized (lock)
        {
            if (request != null)
            {
                request.onReceiveResponseIntent(intent);
            }
        }
        return j.a(arraylist);
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
    }

    j isLocalDeviceTokenStaleAsync()
    {
        return getLocalDeviceTokenLastModifiedAsync().d(new i() {

            final GcmRegistrar this$0;

            public j then(j j1)
                throws Exception
            {
                boolean flag;
                if (((Long)j1.e()).longValue() != ManifestInfo.getLastModified())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return j.a(Boolean.valueOf(flag));
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = GcmRegistrar.this;
                super();
            }
        });
    }

    public j registerAsync()
    {
        if (ManifestInfo.getPushType() != PushType.GCM)
        {
            return j.a(null);
        }
        Object obj1 = lock;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        final ParseInstallation installation;
        installation = ParseInstallation.getCurrentInstallation();
        if (installation.getDeviceToken() != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = j.a(Boolean.valueOf(true));
_L1:
        obj = ((j) (obj)).d(new i() {

            final GcmRegistrar this$0;
            final ParseInstallation val$installation;

            public j then(j j1)
                throws Exception
            {
                if (!((Boolean)j1.e()).booleanValue())
                {
                    return j.a(null);
                }
                if (installation.getPushType() != PushType.GCM)
                {
                    installation.setPushType(PushType.GCM);
                    j1 = installation.saveInBackground();
                } else
                {
                    j1 = j.a(null);
                }
                sendRegistrationRequestAsync();
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = GcmRegistrar.this;
                installation = parseinstallation;
                super();
            }
        });
        return ((j) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj = isLocalDeviceTokenStaleAsync();
          goto _L1
    }

    j updateLocalDeviceTokenLastModifiedAsync()
    {
        return j.a(new Callable() {

            final GcmRegistrar this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                Object obj = localDeviceTokenLastModifiedMutex;
                obj;
                JVM INSTR monitorenter ;
                long l;
                localDeviceTokenLastModified = ManifestInfo.getLastModified();
                l = localDeviceTokenLastModified;
                Exception exception;
                try
                {
                    ParseFileUtils.writeStringToFile(GcmRegistrar.getLocalDeviceTokenLastModifiedFile(), String.valueOf(l), "UTF-8");
                }
                catch (IOException ioexception) { }
                return null;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = GcmRegistrar.this;
                super();
            }
        }, j.a);
    }




/*
    static Request access$202(GcmRegistrar gcmregistrar, Request request1)
    {
        gcmregistrar.request = request1;
        return request1;
    }

*/




/*
    static long access$502(GcmRegistrar gcmregistrar, long l)
    {
        gcmregistrar.localDeviceTokenLastModified = l;
        return l;
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

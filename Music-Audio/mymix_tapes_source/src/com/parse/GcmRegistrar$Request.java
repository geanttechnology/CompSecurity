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
import android.os.SystemClock;
import bolts.Task;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.parse:
//            GcmRegistrar, Parse

private static class retryReceiver
{

    private static final int BACKOFF_INTERVAL_MS = 3000;
    private static final int MAX_RETRIES = 5;
    private static final String RETRY_ACTION = "com.parse.RetryGcmRegistration";
    private final PendingIntent appIntent;
    private final Context context;
    private final int identifier;
    private final Random random = new Random();
    private final PendingIntent retryIntent;
    private final BroadcastReceiver retryReceiver = new BroadcastReceiver() {

        final GcmRegistrar.Request this$0;

        public void onReceive(Context context2, Intent intent)
        {
            if (intent != null && intent.getIntExtra("random", 0) == identifier)
            {
                send();
            }
        }

            
            {
                this$0 = GcmRegistrar.Request.this;
                super();
            }
    };
    private final String senderId;
    private final bolts.urce tcs = Task.create();
    private final AtomicInteger tries = new AtomicInteger(0);

    public static retryReceiver createAndSend(Context context1, String s)
    {
        context1 = new <init>(context1, s);
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



    private er(Context context1, String s)
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

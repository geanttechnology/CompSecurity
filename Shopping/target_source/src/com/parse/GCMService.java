// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// Referenced classes of package com.parse:
//            ProxyService, PLog, PushRouter, GcmRegistrar, 
//            ServiceUtils

class GCMService
    implements ProxyService
{

    public static final String RECEIVE_PUSH_ACTION = "com.google.android.c2dm.intent.RECEIVE";
    public static final String REGISTER_RESPONSE_ACTION = "com.google.android.c2dm.intent.REGISTRATION";
    private static final String TAG = "GCMService";
    private ExecutorService executor;
    private final WeakReference parent;

    GCMService(Service service)
    {
        parent = new WeakReference(service);
    }

    private void handleGcmPushIntent(Intent intent)
    {
        String s = intent.getStringExtra("message_type");
        if (s != null)
        {
            PLog.i("GCMService", (new StringBuilder()).append("Ignored special message type ").append(s).append(" from GCM via intent ").append(intent).toString());
            return;
        }
        s = intent.getStringExtra("push_id");
        String s1 = intent.getStringExtra("time");
        String s2 = intent.getStringExtra("data");
        String s3 = intent.getStringExtra("channel");
        intent = null;
        if (s2 != null)
        {
            try
            {
                intent = JSONObjectInstrumentation.init(s2);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                PLog.e("GCMService", (new StringBuilder()).append("Ignoring push because of JSON exception while processing: ").append(s2).toString(), intent);
                return;
            }
        }
        PushRouter.getInstance().handlePush(s, s1, s3, intent);
    }

    private void handleGcmRegistrationIntent(Intent intent)
    {
        try
        {
            GcmRegistrar.getInstance().handleRegistrationIntentAsync(intent).g();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
    }

    private void onHandleIntent(Intent intent)
    {
        String s;
label0:
        {
            if (intent != null)
            {
                s = intent.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(s))
                {
                    break label0;
                }
                handleGcmRegistrationIntent(intent);
            }
            return;
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals(s))
        {
            handleGcmPushIntent(intent);
            return;
        } else
        {
            PLog.e("GCMService", (new StringBuilder()).append("PushService got unknown intent in GCM mode: ").append(intent).toString());
            return;
        }
    }

    private void stopParent(int i)
    {
        Service service = (Service)parent.get();
        if (service != null)
        {
            service.stopSelf(i);
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        executor = Executors.newSingleThreadExecutor();
    }

    public void onDestroy()
    {
        if (executor != null)
        {
            executor.shutdown();
            executor = null;
        }
    }

    public int onStartCommand(final Intent intent, int i, final int startId)
    {
        executor.execute(new Runnable() {

            final GCMService this$0;
            final Intent val$intent;
            final int val$startId;

            public void run()
            {
                onHandleIntent(intent);
                ServiceUtils.completeWakefulIntent(intent);
                stopParent(startId);
                return;
                Exception exception;
                exception;
                ServiceUtils.completeWakefulIntent(intent);
                stopParent(startId);
                throw exception;
            }

            
            {
                this$0 = GCMService.this;
                intent = intent1;
                startId = i;
                super();
            }
        });
        return 2;
    }


}

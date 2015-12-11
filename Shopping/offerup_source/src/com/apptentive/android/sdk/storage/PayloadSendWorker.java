// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.storage;

import android.content.Context;
import com.apptentive.android.sdk.Log;

// Referenced classes of package com.apptentive.android.sdk.storage:
//            ApptentiveDatabase, PayloadStore

public class PayloadSendWorker
{

    private static final int EMPTY_QUEUE_SLEEP_TIME = 5000;
    private static final int NO_CONNECTION_SLEEP_TIME = 5000;
    private static final int NO_TOKEN_SLEEP = 5000;
    private static Context appContext;
    private static boolean appInForeground;
    private static PayloadSendThread payloadSendThread;
    private static boolean threadRunning;

    public PayloadSendWorker()
    {
    }

    public static void appWentToBackground()
    {
        appInForeground = false;
        wakeUp();
    }

    public static void appWentToForeground(Context context)
    {
        appInForeground = true;
        doStart(context);
    }

    public static void doStart(Context context)
    {
        com/apptentive/android/sdk/storage/PayloadSendWorker;
        JVM INSTR monitorenter ;
        appContext = context.getApplicationContext();
        if (!threadRunning)
        {
            Log.i("Starting PayloadSendWorker.", new Object[0]);
            threadRunning = true;
            payloadSendThread = new PayloadSendThread(null);
            context = new _cls1();
            payloadSendThread.setUncaughtExceptionHandler(context);
            payloadSendThread.setName("Apptentive-PayloadSendWorker");
            payloadSendThread.start();
        }
        com/apptentive/android/sdk/storage/PayloadSendWorker;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private static PayloadStore getPayloadStore(Context context)
    {
        return ApptentiveDatabase.getInstance(context);
    }

    private static void goToSleep(int i)
    {
        long l = i;
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    private static void wakeUp()
    {
        if (payloadSendThread != null)
        {
            Log.v("Waking PayloadSendThread.", new Object[0]);
            payloadSendThread.interrupt();
        }
    }






/*
    static boolean access$502(boolean flag)
    {
        threadRunning = flag;
        return flag;
    }

*/

    private class PayloadSendThread extends Thread
    {

        public void run()
        {
            this;
            JVM INSTR monitorenter ;
            Log.v("Started %s", new Object[] {
                toString()
            });
            if (PayloadSendWorker.appContext != null)
            {
                break MISSING_BLOCK_LABEL_41;
            }
            this;
            JVM INSTR monitorexit ;
            Log.v("Stopping PayloadSendThread.", new Object[0]);
            PayloadSendWorker.threadRunning = false;
            return;
_L2:
            PayloadStore payloadstore;
            while (PayloadSendWorker.appInForeground) 
            {
                payloadstore = PayloadSendWorker.getPayloadStore(PayloadSendWorker.appContext);
                if (!Util.isEmpty(GlobalInfo.conversationToken))
                {
                    break MISSING_BLOCK_LABEL_103;
                }
                Log.i("No conversation token yet.", new Object[0]);
                PayloadSendWorker.goToSleep(5000);
            }
              goto _L1
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            exception;
            Log.v("Stopping PayloadSendThread.", new Object[0]);
            PayloadSendWorker.threadRunning = false;
            throw exception;
label0:
            {
                if (Util.isNetworkConnectionPresent(PayloadSendWorker.appContext))
                {
                    break label0;
                }
                Log.d("Can't send payloads. No network connection.", new Object[0]);
                PayloadSendWorker.goToSleep(5000);
            }
              goto _L2
            Payload payload;
            Log.v("Checking for payloads to send.", new Object[0]);
            payload = payloadstore.getOldestUnsentPayload();
            if (payload != null)
            {
                break MISSING_BLOCK_LABEL_159;
            }
            PayloadSendWorker.goToSleep(5000);
              goto _L2
            Log.d("Got a payload to send: %s:%d", new Object[] {
                payload.getBaseType(), Long.valueOf(payload.getDatabaseId())
            });
            ApptentiveHttpResponse apptentivehttpresponse = null;
            _cls2..SwitchMap.com.apptentive.android.sdk.model.Payload.BaseType[payload.getBaseType().ordinal()];
            JVM INSTR tableswitch 1 7: default 485
        //                       1 303
        //                       2 328
        //                       3 339
        //                       4 356
        //                       5 367
        //                       6 378
        //                       7 389;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
            Log.e((new StringBuilder("Didn't send unknown Payload BaseType: ")).append(payload.getBaseType()).toString(), new Object[0]);
            payloadstore.deletePayload(payload);
_L14:
            if (apptentivehttpresponse == null) goto _L2; else goto _L11
_L11:
            if (!apptentivehttpresponse.isSuccessful()) goto _L13; else goto _L12
_L12:
            Log.d("Payload submission successful. Removing from send queue.", new Object[0]);
            payloadstore.deletePayload(payload);
              goto _L2
_L4:
            apptentivehttpresponse = ApptentiveClient.postMessage(PayloadSendWorker.appContext, (Message)payload);
            MessageManager.onSentMessage(PayloadSendWorker.appContext, (Message)payload, apptentivehttpresponse);
              goto _L14
_L5:
            apptentivehttpresponse = ApptentiveClient.postEvent((Event)payload);
              goto _L14
_L6:
            apptentivehttpresponse = ApptentiveClient.putDevice((Device)payload);
            DeviceManager.onSentDeviceInfo(PayloadSendWorker.appContext);
              goto _L14
_L7:
            apptentivehttpresponse = ApptentiveClient.putSdk((Sdk)payload);
              goto _L14
_L8:
            apptentivehttpresponse = ApptentiveClient.putAppRelease((AppRelease)payload);
              goto _L14
_L9:
            apptentivehttpresponse = ApptentiveClient.putPerson((Person)payload);
              goto _L14
_L10:
            apptentivehttpresponse = ApptentiveClient.postSurvey((SurveyResponse)payload);
              goto _L14
_L13:
            if (!apptentivehttpresponse.isRejectedPermanently() && !apptentivehttpresponse.isBadPayload()) goto _L16; else goto _L15
_L15:
            Log.d("Payload rejected. Removing from send queue.", new Object[0]);
            Log.v("Rejected json:", new Object[] {
                payload.toString()
            });
            payloadstore.deletePayload(payload);
              goto _L2
_L16:
            if (!apptentivehttpresponse.isRejectedTemporarily()) goto _L2; else goto _L17
_L17:
            Log.d("Unable to send JSON. Leaving in queue.", new Object[0]);
              goto _L2
_L1:
            this;
            JVM INSTR monitorexit ;
            Log.v("Stopping PayloadSendThread.", new Object[0]);
            PayloadSendWorker.threadRunning = false;
            return;
        }

        private PayloadSendThread()
        {
        }

        PayloadSendThread(_cls1 _pcls1)
        {
            this();
        }

        private class _cls2
        {

            static final int $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[];

            static 
            {
                $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType = new int[com.apptentive.android.sdk.model.Payload.BaseType.values().length];
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.message.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.event.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.device.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.sdk.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.app_release.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.person.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$apptentive$android$sdk$model$Payload$BaseType[com.apptentive.android.sdk.model.Payload.BaseType.survey.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

    }


    private class _cls1
        implements Thread.UncaughtExceptionHandler
    {

        public final void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.e("Error in PayloadSendWorker.", throwable, new Object[0]);
            MetricModule.sendError(PayloadSendWorker.appContext, throwable, null, null);
        }

        _cls1()
        {
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.drive.events:
//            ChangeListener, CompletionListener, zzc, DriveEvent, 
//            ChangeEvent, CompletionEvent, ChangesAvailableEvent

public abstract class DriveEventService extends Service
    implements ChangeListener, CompletionListener, zzc
{
    final class zza extends Handler
    {

        final DriveEventService zzajO;

        static Message zza(zza zza1)
        {
            return zza1.zzrg();
        }

        static Message zza(zza zza1, OnEventResponse oneventresponse)
        {
            return zza1.zzb(oneventresponse);
        }

        private Message zzb(OnEventResponse oneventresponse)
        {
            return obtainMessage(1, oneventresponse);
        }

        private Message zzrg()
        {
            return obtainMessage(2);
        }

        public void handleMessage(Message message)
        {
            zzz.zzx("DriveEventService", (new StringBuilder()).append("handleMessage message type:").append(message.what).toString());
            switch (message.what)
            {
            default:
                zzz.zzy("DriveEventService", (new StringBuilder()).append("Unexpected message type:").append(message.what).toString());
                return;

            case 1: // '\001'
                DriveEventService.zza(zzajO, (OnEventResponse)message.obj);
                return;

            case 2: // '\002'
                getLooper().quit();
                break;
            }
        }

        zza()
        {
            zzajO = DriveEventService.this;
            super();
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzao.zza
    {

        final DriveEventService zzajO;

        public void zzc(OnEventResponse oneventresponse)
            throws RemoteException
        {
            DriveEventService driveeventservice = zzajO;
            driveeventservice;
            JVM INSTR monitorenter ;
            zzz.zzx("DriveEventService", (new StringBuilder()).append("onEvent: ").append(oneventresponse).toString());
            DriveEventService.zza(zzajO);
            if (zzajO.zzajL == null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            oneventresponse = zza.zza(zzajO.zzajL, oneventresponse);
            zzajO.zzajL.sendMessage(oneventresponse);
_L2:
            return;
            zzz.zzz("DriveEventService", "Receiving event before initialize is completed.");
            if (true) goto _L2; else goto _L1
_L1:
            oneventresponse;
            driveeventservice;
            JVM INSTR monitorexit ;
            throw oneventresponse;
        }

        zzb()
        {
            zzajO = DriveEventService.this;
            super();
        }
    }


    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzaeG;
    private CountDownLatch zzajK;
    zza zzajL;
    boolean zzajM;

    protected DriveEventService()
    {
        this("DriveEventService");
    }

    protected DriveEventService(String s)
    {
        zzajM = false;
        zzaeG = -1;
        mName = s;
    }

    static void zza(DriveEventService driveeventservice)
        throws SecurityException
    {
        driveeventservice.zzrf();
    }

    static void zza(DriveEventService driveeventservice, OnEventResponse oneventresponse)
    {
        driveeventservice.zza(oneventresponse);
    }

    private void zza(OnEventResponse oneventresponse)
    {
        oneventresponse = oneventresponse.zzrA();
        zzz.zzx("DriveEventService", (new StringBuilder()).append("handleEventMessage: ").append(oneventresponse).toString());
        oneventresponse.getType();
        JVM INSTR tableswitch 1 4: default 147
    //                   1 91
    //                   2 129
    //                   3 64
    //                   4 138;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        zzz.zzy(mName, (new StringBuilder()).append("Unhandled event: ").append(oneventresponse).toString());
        return;
_L2:
        try
        {
            onChange((ChangeEvent)oneventresponse);
            return;
        }
        catch (Exception exception)
        {
            zzz.zza(mName, exception, (new StringBuilder()).append("Error handling event: ").append(oneventresponse).toString());
        }
        return;
_L3:
        onCompletion((CompletionEvent)oneventresponse);
        return;
_L4:
        zza((ChangesAvailableEvent)oneventresponse);
        return;
    }

    static CountDownLatch zzb(DriveEventService driveeventservice)
    {
        return driveeventservice.zzajK;
    }

    private void zzrf()
        throws SecurityException
    {
        int i = getCallingUid();
        if (i == zzaeG)
        {
            return;
        }
        if (GooglePlayServicesUtil.zze(this, i))
        {
            zzaeG = i;
            return;
        } else
        {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid()
    {
        return Binder.getCallingUid();
    }

    public final IBinder onBind(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (!"com.google.android.gms.drive.events.HANDLE_EVENT".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        if (zzajL != null || zzajM)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        zzajM = true;
        intent = new CountDownLatch(1);
        zzajK = new CountDownLatch(1);
        (new Thread(intent) {

            final CountDownLatch zzajN;
            final DriveEventService zzajO;

            public void run()
            {
                Looper.prepare();
                zzajO.zzajL = zzajO. new zza();
                zzajO.zzajM = false;
                zzajN.countDown();
                zzz.zzx("DriveEventService", "Bound and starting loop");
                Looper.loop();
                zzz.zzx("DriveEventService", "Finished loop");
                if (DriveEventService.zzb(zzajO) != null)
                {
                    DriveEventService.zzb(zzajO).countDown();
                }
                return;
                Exception exception;
                exception;
                if (DriveEventService.zzb(zzajO) != null)
                {
                    DriveEventService.zzb(zzajO).countDown();
                }
                throw exception;
            }

            
            {
                zzajO = DriveEventService.this;
                zzajN = countdownlatch;
                super();
            }
        }).start();
        if (!intent.await(5000L, TimeUnit.MILLISECONDS))
        {
            zzz.zzz("DriveEventService", "Failed to synchronously initialize event handler.");
        }
        intent = (new zzb()).asBinder();
_L4:
        this;
        JVM INSTR monitorexit ;
        return intent;
        intent;
        throw new RuntimeException("Unable to start event handler", intent);
        intent;
        this;
        JVM INSTR monitorexit ;
        throw intent;
_L2:
        intent = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onChange(ChangeEvent changeevent)
    {
        zzz.zzy(mName, (new StringBuilder()).append("Unhandled change event: ").append(changeevent).toString());
    }

    public void onCompletion(CompletionEvent completionevent)
    {
        zzz.zzy(mName, (new StringBuilder()).append("Unhandled completion event: ").append(completionevent).toString());
    }

    public void onDestroy()
    {
        this;
        JVM INSTR monitorenter ;
        zzz.zzx("DriveEventService", "onDestroy");
        if (zzajL == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        Message message = zza.zza(zzajL);
        zzajL.sendMessage(message);
        zzajL = null;
        Exception exception;
        try
        {
            if (!zzajK.await(5000L, TimeUnit.MILLISECONDS))
            {
                zzz.zzy("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
            }
        }
        catch (InterruptedException interruptedexception) { }
        zzajK = null;
        super.onDestroy();
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    public boolean onUnbind(Intent intent)
    {
        return true;
    }

    public void zza(ChangesAvailableEvent changesavailableevent)
    {
        zzz.zzy(mName, (new StringBuilder()).append("Unhandled changes available event: ").append(changesavailableevent).toString());
    }
}

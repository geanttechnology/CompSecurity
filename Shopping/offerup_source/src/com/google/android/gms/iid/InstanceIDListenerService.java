// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.iid:
//            MessengerCompat, zzd, zzc, InstanceID

public class InstanceIDListenerService extends Service
{

    static String ACTION = "action";
    private static String zzaCn = "gcm.googleapis.com/refresh";
    private static String zzaDF = "google.com/iid";
    private static String zzaDG = "CMD";
    MessengerCompat zzaDD;
    BroadcastReceiver zzaDE;
    int zzaDH;
    int zzaDI;

    public InstanceIDListenerService()
    {
        zzaDD = new MessengerCompat(new _cls1(Looper.getMainLooper()));
        zzaDE = new _cls2();
    }

    static void zza(Context context, zzd zzd1)
    {
        zzd1.zzwt();
        zzd1 = new Intent("com.google.android.gms.iid.InstanceID");
        zzd1.putExtra(zzaDG, "RST");
        zzd1.setPackage(context.getPackageName());
        context.startService(zzd1);
    }

    private void zza(Message message, int i)
    {
        zzc.zzaE(this);
        getPackageManager();
        if (i != zzc.zzaDP && i != zzc.zzaDO)
        {
            Log.w("InstanceID", (new StringBuilder("Message from unexpected caller ")).append(i).append(" mine=").append(zzc.zzaDO).append(" appid=").append(zzc.zzaDP).toString());
            return;
        } else
        {
            zzn((Intent)message.obj);
            return;
        }
    }

    static void zza(InstanceIDListenerService instanceidlistenerservice, Message message, int i)
    {
        instanceidlistenerservice.zza(message, i);
    }

    static void zzaD(Context context)
    {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzaDG, "SYNC");
        context.startService(intent);
    }

    public IBinder onBind(Intent intent)
    {
        if (intent != null && "com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            return zzaDD.getBinder();
        } else
        {
            return null;
        }
    }

    public void onCreate()
    {
        IntentFilter intentfilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentfilter.addCategory(getPackageName());
        registerReceiver(zzaDE, intentfilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy()
    {
        unregisterReceiver(zzaDE);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        zzgI(j);
        if (intent == null)
        {
            stop();
            return 2;
        }
        Intent intent1;
        if (!"com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (android.os.Build.VERSION.SDK_INT > 18)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        intent1 = (Intent)intent.getParcelableExtra("GSF");
        if (intent1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        startService(intent1);
        stop();
        return 1;
        zzn(intent);
        stop();
        if (intent.getStringExtra("from") != null)
        {
            GcmReceiver.completeWakefulIntent(intent);
        }
        return 2;
        intent;
        stop();
        throw intent;
    }

    public void onTokenRefresh()
    {
    }

    void stop()
    {
        this;
        JVM INSTR monitorenter ;
        zzaDH = zzaDH - 1;
        if (zzaDH == 0)
        {
            stopSelf(zzaDI);
        }
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder("Stop ")).append(zzaDH).append(" ").append(zzaDI).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzag(boolean flag)
    {
        onTokenRefresh();
    }

    void zzgI(int i)
    {
        this;
        JVM INSTR monitorenter ;
        zzaDH = zzaDH + 1;
        if (i > zzaDI)
        {
            zzaDI = i;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzn(Intent intent)
    {
        Object obj;
        String s;
        String s1;
        s1 = intent.getStringExtra("subtype");
        if (s1 == null)
        {
            obj = InstanceID.getInstance(this);
        } else
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("subtype", s1);
            obj = InstanceID.zza(this, ((Bundle) (obj)));
        }
        s = intent.getStringExtra(zzaDG);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder("Register result in service ")).append(s1).toString());
        }
        ((InstanceID) (obj)).zzwp().zzr(intent);
_L4:
        return;
_L2:
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder("Service command ")).append(s1).append(" ").append(s).append(" ").append(intent.getExtras()).toString());
        }
        if (intent.getStringExtra("unregistered") != null)
        {
            zzd zzd1 = ((InstanceID) (obj)).zzwo();
            s = s1;
            if (s1 == null)
            {
                s = "";
            }
            zzd1.zzds(s);
            ((InstanceID) (obj)).zzwp().zzr(intent);
            return;
        }
        if (zzaCn.equals(intent.getStringExtra("from")))
        {
            ((InstanceID) (obj)).zzwo().zzds(s1);
            zzag(false);
            return;
        }
        if ("RST".equals(s))
        {
            ((InstanceID) (obj)).zzwn();
            zzag(true);
            return;
        }
        if (!"RST_FULL".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((InstanceID) (obj)).zzwo().isEmpty())
        {
            ((InstanceID) (obj)).zzwo().zzwt();
            zzag(true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if ("SYNC".equals(s))
        {
            ((InstanceID) (obj)).zzwo().zzds(s1);
            zzag(false);
            return;
        }
        if ("PING".equals(s))
        {
            try
            {
                GoogleCloudMessaging.getInstance(this).send(zzaDF, zzc.zzws(), 0L, intent.getExtras());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.w("InstanceID", "Failed to send ping response");
            }
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }


    private class _cls1 extends Handler
    {

        final InstanceIDListenerService zzaDJ;

        public void handleMessage(Message message)
        {
            InstanceIDListenerService.zza(zzaDJ, message, MessengerCompat.zzc(message));
        }

        _cls1(Looper looper)
        {
            zzaDJ = InstanceIDListenerService.this;
            super(looper);
        }
    }


    private class _cls2 extends BroadcastReceiver
    {

        final InstanceIDListenerService zzaDJ;

        public void onReceive(Context context, Intent intent)
        {
            if (Log.isLoggable("InstanceID", 3))
            {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", (new StringBuilder("Received GSF callback using dynamic receiver: ")).append(intent.getExtras()).toString());
            }
            zzaDJ.zzn(intent);
            zzaDJ.stop();
        }

        _cls2()
        {
            zzaDJ = InstanceIDListenerService.this;
            super();
        }
    }

}

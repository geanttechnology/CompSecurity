// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.android.gms.gcm:
//            GcmReceiver, zza

public abstract class GcmListenerService extends Service
{

    private int zzazD;
    private int zzazE;
    private final Object zzpc = new Object();

    public GcmListenerService()
    {
        zzazE = 0;
    }

    static void zza(GcmListenerService gcmlistenerservice, Intent intent)
    {
        gcmlistenerservice.zzk(intent);
    }

    private final void zzk(Intent intent)
    {
        boolean flag = "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
        if (!flag)
        {
            GcmReceiver.completeWakefulIntent(intent);
            return;
        }
        obj = intent.getStringExtra("message_type");
        byte byte0;
        if (obj == null)
        {
            obj = "gcm";
        }
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 251
    //                   -2062414158: 140
    //                   102161: 125
    //                   814694033: 170
    //                   814800675: 155;
           goto _L1 _L2 _L3 _L4 _L5
_L6:
        synchronized (zzpc)
        {
            zzazE = zzazE - 1;
            if (zzazE == 0)
            {
                zzgr(zzazD);
            }
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
_L3:
        if (((String) (obj)).equals("gcm"))
        {
            byte0 = 0;
        }
          goto _L1
_L2:
        if (((String) (obj)).equals("deleted_messages"))
        {
            byte0 = 1;
        }
          goto _L1
_L5:
        if (((String) (obj)).equals("send_event"))
        {
            byte0 = 2;
        }
          goto _L1
_L4:
        if (((String) (obj)).equals("send_error"))
        {
            byte0 = 3;
        }
          goto _L1
_L7:
        zzt(intent.getExtras());
          goto _L6
        obj;
        GcmReceiver.completeWakefulIntent(intent);
        throw obj;
_L8:
        onDeletedMessages();
          goto _L6
_L9:
        onMessageSent(intent.getStringExtra("google.message_id"));
          goto _L6
_L10:
        onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
          goto _L6
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 284
    //                   0 185
    //                   1 204
    //                   2 211
    //                   3 224;
           goto _L6 _L7 _L8 _L9 _L10
    }

    private void zzt(Bundle bundle)
    {
        bundle.remove("message_type");
        bundle.remove("android.support.content.wakelockid");
        if (com.google.android.gms.gcm.zza.zzu(bundle))
        {
            com.google.android.gms.gcm.zza.zzay(this).zzv(bundle);
            return;
        } else
        {
            String s = bundle.getString("from");
            bundle.remove("from");
            onMessageReceived(s, bundle);
            return;
        }
    }

    public final IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onDeletedMessages()
    {
    }

    public void onMessageReceived(String s, Bundle bundle)
    {
    }

    public void onMessageSent(String s)
    {
    }

    public void onSendError(String s, String s1)
    {
    }

    public final int onStartCommand(final Intent intent, int i, int j)
    {
        synchronized (zzpc)
        {
            zzazD = j;
            zzazE = zzazE + 1;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new _cls1());
        } else
        {
            (new _cls2()).execute(new Void[0]);
        }
        return 3;
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
    }

    boolean zzgr(int i)
    {
        return stopSelfResult(i);
    }

    private class _cls1
        implements Runnable
    {

        final Intent val$intent;
        final GcmListenerService zzazF;

        public void run()
        {
            GcmListenerService.zza(zzazF, intent);
        }

        _cls1()
        {
            zzazF = GcmListenerService.this;
            intent = intent1;
            super();
        }
    }


    private class _cls2 extends AsyncTask
    {

        final Intent val$intent;
        final GcmListenerService zzazF;

        protected Object doInBackground(Object aobj[])
        {
            return zzb((Void[])aobj);
        }

        protected transient Void zzb(Void avoid[])
        {
            GcmListenerService.zza(zzazF, intent);
            return null;
        }

        _cls2()
        {
            zzazF = GcmListenerService.this;
            intent = intent1;
            super();
        }
    }

}

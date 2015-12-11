// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.gcm:
//            PendingCallback, e, f

public abstract class c extends Service
{
    private class a extends Thread
    {

        final c a;
        private final String b;
        private final f c;
        private final Bundle d;

        public void run()
        {
            int i = a.a(new e(b, d));
            c.a(i);
            c.a(a, b);
            return;
            Object obj;
            obj;
            Log.e("GcmTaskService", (new StringBuilder()).append("Error reporting result of operation to scheduler for ").append(b).toString());
            c.a(a, b);
            return;
            obj;
            c.a(a, b);
            throw obj;
        }

        a(String s, IBinder ibinder, Bundle bundle)
        {
            a = c.this;
            super();
            b = s;
            c = f.a.a(ibinder);
            d = bundle;
        }
    }


    private final Set a = new HashSet();
    private int b;

    public c()
    {
    }

    static void a(c c1, String s)
    {
        c1.a(s);
    }

    private void a(String s)
    {
        synchronized (a)
        {
            a.remove(s);
            if (a.size() == 0)
            {
                stopSelf(b);
            }
        }
        return;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
    }

    public abstract int a(e e);

    public void a()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        intent.setExtrasClassLoader(com/google/android/gms/gcm/PendingCallback.getClassLoader());
        if (!"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        String s;
        android.os.Parcelable parcelable;
        Bundle bundle;
        s = intent.getStringExtra("tag");
        parcelable = intent.getParcelableExtra("callback");
        bundle = (Bundle)intent.getParcelableExtra("extras");
        if (parcelable != null && (parcelable instanceof PendingCallback)) goto _L4; else goto _L3
_L3:
        Log.e("GcmTaskService", (new StringBuilder()).append(getPackageName()).append(" ").append(s).append(": Could not process request, invalid callback.").toString());
_L6:
        return 2;
_L4:
        synchronized (a)
        {
            a.add(s);
            stopSelf(b);
            b = j;
        }
        (new a(s, ((PendingCallback)parcelable).a(), bundle)).start();
        return 2;
        exception;
        intent;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (!"com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(intent.getAction())) goto _L6; else goto _L5
_L5:
        a();
        synchronized (a)
        {
            b = j;
            if (a.size() == 0)
            {
                stopSelf(b);
            }
        }
        return 2;
        exception1;
        intent;
        JVM INSTR monitorexit ;
        throw exception1;
    }
}

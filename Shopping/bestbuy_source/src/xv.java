// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class xv extends abn
    implements ServiceConnection
{

    private final Object a = new Object();
    private boolean b;
    private Context c;
    private yv d;
    private xu e;
    private ya f;
    private List g;
    private ye h;

    public xv(Context context, yv yv, ye ye)
    {
        b = false;
        g = null;
        c = context;
        d = yv;
        h = ye;
        e = new xu(context);
        f = ya.a(c);
        g = f.a(10L);
    }

    static ye a(xv xv1)
    {
        return xv1.h;
    }

    private void a(long l)
    {
        do
        {
            if (!b(l))
            {
                acb.e("Timeout waiting for pending transaction to be processed.");
            }
        } while (!b);
    }

    private void a(xy xy1, String s, String s1)
    {
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", s);
        intent.putExtra("INAPP_DATA_SIGNATURE", s1);
        aca.a.post(new Runnable(xy1, intent) {

            final xy a;
            final Intent b;
            final xv c;

            public void run()
            {
                if (xv.a(c).a(a.b, -1, b))
                {
                    xv.c(c).a(new xz(xv.b(c), a.c, true, -1, b, a));
                    return;
                }
                try
                {
                    xv.c(c).a(new xz(xv.b(c), a.c, false, -1, b, a));
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    acb.e("Fail to verify and dispatch pending transaction");
                }
                return;
            }

            
            {
                c = xv.this;
                a = xy1;
                b = intent;
                super();
            }
        });
    }

    static Context b(xv xv1)
    {
        return xv1.c;
    }

    private boolean b(long l)
    {
        l = 60000L - (SystemClock.elapsedRealtime() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            a.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            acb.e("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    static yv c(xv xv1)
    {
        return xv1.d;
    }

    private void c()
    {
        if (!g.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        xy xy1;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); hashmap.put(xy1.c, xy1))
        {
            xy1 = (xy)iterator.next();
        }

        obj = null;
_L6:
        obj = e.b(c.getPackageName(), ((String) (obj)));
          goto _L3
_L5:
        obj = hashmap.keySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            String s = (String)((Iterator) (obj)).next();
            f.a((xy)hashmap.get(s));
        }
          goto _L1
_L3:
        if (obj == null || yc.a(((Bundle) (obj))) != 0) goto _L5; else goto _L4
_L4:
        ArrayList arraylist = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList arraylist1 = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList arraylist2 = ((Bundle) (obj)).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        obj = ((Bundle) (obj)).getString("INAPP_CONTINUATION_TOKEN");
        for (int i = 0; i < arraylist.size(); i++)
        {
            if (!hashmap.containsKey(arraylist.get(i)))
            {
                continue;
            }
            String s1 = (String)arraylist.get(i);
            String s2 = (String)arraylist1.get(i);
            String s3 = (String)arraylist2.get(i);
            xy xy2 = (xy)hashmap.get(s1);
            String s4 = yc.a(s2);
            if (xy2.b.equals(s4))
            {
                a(xy2, s2, s3);
                hashmap.remove(s1);
            }
        }

        if (obj == null || hashmap.isEmpty()) goto _L5; else goto _L6
    }

    public void a()
    {
        synchronized (a)
        {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            c.bindService(intent, this, 1);
            a(SystemClock.elapsedRealtime());
            c.unbindService(this);
            e.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        synchronized (a)
        {
            c.unbindService(this);
            e.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        synchronized (a)
        {
            e.a(ibinder);
            c();
            b = true;
            a.notify();
        }
        return;
        ibinder;
        componentname;
        JVM INSTR monitorexit ;
        throw ibinder;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        acb.c("In-app billing service disconnected.");
        e.a();
    }
}

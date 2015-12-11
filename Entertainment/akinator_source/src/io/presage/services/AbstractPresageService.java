// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import io.presage.Presage;
import io.presage.services.for.j;
import io.presage.utils.e;
import io.presage.utils.f;
import io.presage.utils.i;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

// Referenced classes of package io.presage.services:
//            d, c, e, a, 
//            b

public abstract class AbstractPresageService extends Service
    implements d
{
    private final class a extends Handler
    {

        final AbstractPresageService a;

        public final void handleMessage(Message message)
        {
            AbstractPresageService abstractpresageservice = a;
            message = ((Message) (message.obj));
            abstractpresageservice.d();
        }

        public a(Looper looper)
        {
            a = AbstractPresageService.this;
            super(looper);
        }
    }


    AsyncTask a;
    Timer b;
    long c;
    boolean d;
    private HashMap e;
    private HashMap f;
    private long g;
    private boolean h;
    private boolean i;
    private boolean j;
    private final Handler k = new c(this, Looper.getMainLooper());
    private volatile Looper l;
    private volatile a m;

    public AbstractPresageService()
    {
        g = 0L;
        h = false;
        i = true;
        j = true;
        c = 0L;
        d = false;
        io.presage.utils.e.b(new String[] {
            "PresageService", "Create"
        });
        Presage.getInstance().setService(this);
        e = new HashMap();
        f = new HashMap();
    }

    static HashMap a(AbstractPresageService abstractpresageservice)
    {
        return abstractpresageservice.e;
    }

    static void b(AbstractPresageService abstractpresageservice)
    {
        if (abstractpresageservice.g > 0L)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        abstractpresageservice.c = abstractpresageservice.c + 1L;
        Iterator iterator = abstractpresageservice.e.keySet().iterator();
_L2:
        j j1;
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_125;
            }
            obj = (String)iterator.next();
            j1 = (j)abstractpresageservice.e.get(obj);
            obj = (io.presage.services.e)abstractpresageservice.f.get(obj);
        } while (j1 == null || obj == null);
        if (((io.presage.services.e) (obj)).d() || !((io.presage.services.e) (obj)).c(abstractpresageservice.c)) goto _L2; else goto _L1
_L1:
        j1.h();
          goto _L2
        abstractpresageservice;
        io.presage.utils.e.c(new String[] {
            abstractpresageservice.getMessage()
        });
    }

    static Handler c(AbstractPresageService abstractpresageservice)
    {
        return abstractpresageservice.k;
    }

    static void d(AbstractPresageService abstractpresageservice)
    {
        if (abstractpresageservice.g > 0L)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        Iterator iterator = abstractpresageservice.e.keySet().iterator();
_L2:
        j j1;
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_123;
            }
            obj = (String)iterator.next();
            j1 = (j)abstractpresageservice.e.get(obj);
            obj = (io.presage.services.e)abstractpresageservice.f.get(obj);
        } while (j1 == null || obj == null);
        if (((io.presage.services.e) (obj)).d() || !((io.presage.services.e) (obj)).c(abstractpresageservice.c)) goto _L2; else goto _L1
_L1:
        j1.b();
        ((io.presage.services.e) (obj)).d(abstractpresageservice.c);
          goto _L2
        abstractpresageservice;
        io.presage.utils.e.c(new String[] {
            abstractpresageservice.getMessage()
        });
    }

    private void e()
    {
        if (b != null)
        {
            b.cancel();
            b = null;
        }
    }

    public abstract void a();

    public final void a(j j1, String s, io.presage.services.e e1)
    {
        if (!Presage.getInstance().getPackageHelper().a(j1.g()))
        {
            return;
        } else
        {
            e.put(s, j1);
            f.put(s, e1);
            return;
        }
    }

    public final void a(String s, io.presage.services.e e1)
    {
        if (s != null && e1 != null && f.containsKey(s) && !((io.presage.services.e)f.get(s)).equals(e1))
        {
            f.put(s, e1);
        }
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
    }

    public final void b()
    {
        if (g > 0L)
        {
            c = c + ((new Date()).getTime() / 1000L - g);
            g = 0L;
        }
        if (!h)
        {
            j = true;
        } else
        if (i && e.size() > 0)
        {
            i = false;
            a = new io.presage.services.a(this);
            a.executeOnExecutor(io.presage.utils.i.a(), new Void[0]);
            return;
        }
    }

    public final void c()
    {
        g = (new Date()).getTime() / 1000L;
    }

    protected final void d()
    {
        e();
        if (!Presage.getInstance().isApplicationSet())
        {
            Presage.getInstance().setApplication(getApplication());
        }
        b = new Timer();
        b.scheduleAtFixedRate(new b(this), 1000L, 1000L);
        b();
    }

    public IBinder onBind(Intent intent)
    {
        return new Binder();
    }

    public void onCreate()
    {
        super.onCreate();
        HandlerThread handlerthread = new HandlerThread("IntentService[Presage]");
        handlerthread.start();
        l = handlerthread.getLooper();
        m = new a(l);
        if (!Presage.getInstance().isApplicationSet())
        {
            Presage.getInstance().setApplication(getApplication());
        }
        a();
        h = true;
        if (j)
        {
            j = false;
            b();
        }
    }

    public void onDestroy()
    {
        l.quit();
        e();
        a.cancel(false);
        for (Iterator iterator = e.values().iterator(); iterator.hasNext(); ((j)iterator.next()).e()) { }
        e.clear();
        f.clear();
        e = null;
        f = null;
        e();
        Presage.getInstance().setService(null);
    }

    public void onStart(Intent intent, int i1)
    {
        Message message = m.obtainMessage();
        message.arg1 = i1;
        message.obj = intent;
        m.sendMessage(message);
    }

    public int onStartCommand(Intent intent, int i1, int j1)
    {
        onStart(intent, j1);
        return 1;
    }
}

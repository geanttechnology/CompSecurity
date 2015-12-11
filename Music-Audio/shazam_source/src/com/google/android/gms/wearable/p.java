// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.wearable:
//            e, k, x

public abstract class p extends Service
    implements a.a, b.a, c.b, j.a, m.b, m.c
{
    private final class a extends com.google.android.gms.wearable.internal.w.a
    {

        boolean a;
        final p b;

        public final void a(DataHolder dataholder)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onDataItemChanged: ")).append(p.a(b)).append(": ").append(dataholder);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                    dataholder.b();
                }
                return;
            }
            p.e(b).post(new Runnable(this, dataholder) {

                final DataHolder a;
                final a b;

                public final void run()
                {
                    (new e(a)).b();
                }

            
            {
                b = a1;
                a = dataholder;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            dataholder;
            obj;
            JVM INSTR monitorexit ;
            throw dataholder;
        }

        public final void a(AmsEntityUpdateParcelable amsentityupdateparcelable)
        {
            x x1;
            if (Log.isLoggable("WearableLS", 3))
            {
                (new StringBuilder("onEntityUpdate: ")).append(amsentityupdateparcelable);
            }
            if (!a)
            {
                return;
            }
            p.b(b);
            x1 = (x)b;
            synchronized (p.c(b))
            {
                if (!p.d(b))
                {
                    break MISSING_BLOCK_LABEL_74;
                }
            }
            return;
            amsentityupdateparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw amsentityupdateparcelable;
            p.e(b).post(new Runnable(this, x1, amsentityupdateparcelable) {

                final x a;
                final AmsEntityUpdateParcelable b;
                final a c;

                public final void run()
                {
                }

            
            {
                c = a1;
                a = x;
                b = amsentityupdateparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
        }

        public final void a(AncsNotificationParcelable ancsnotificationparcelable)
        {
            x x1;
            if (Log.isLoggable("WearableLS", 3))
            {
                (new StringBuilder("onNotificationReceived: ")).append(ancsnotificationparcelable);
            }
            if (!a)
            {
                return;
            }
            p.b(b);
            x1 = (x)b;
            synchronized (p.c(b))
            {
                if (!p.d(b))
                {
                    break MISSING_BLOCK_LABEL_74;
                }
            }
            return;
            ancsnotificationparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw ancsnotificationparcelable;
            p.e(b).post(new Runnable(this, x1, ancsnotificationparcelable) {

                final x a;
                final AncsNotificationParcelable b;
                final a c;

                public final void run()
                {
                }

            
            {
                c = a1;
                a = x;
                b = ancsnotificationparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
        }

        public final void a(CapabilityInfoParcelable capabilityinfoparcelable)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onConnectedCapabilityChanged: ")).append(capabilityinfoparcelable);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                }
                return;
            }
            p.e(b).post(new Runnable(this, capabilityinfoparcelable) {

                final CapabilityInfoParcelable a;
                final a b;

                public final void run()
                {
                }

            
            {
                b = a1;
                a = capabilityinfoparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            capabilityinfoparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw capabilityinfoparcelable;
        }

        public final void a(ChannelEventParcelable channeleventparcelable)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onChannelEvent: ")).append(channeleventparcelable);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                }
                return;
            }
            p.e(b).post(new Runnable(this, channeleventparcelable) {

                final ChannelEventParcelable a;
                final a b;

                public final void run()
                {
                    a.a();
                }

            
            {
                b = a1;
                a = channeleventparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            channeleventparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw channeleventparcelable;
        }

        public final void a(MessageEventParcelable messageeventparcelable)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onMessageReceived: ")).append(messageeventparcelable);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                }
                return;
            }
            p.e(b).post(new Runnable(this, messageeventparcelable) {

                final MessageEventParcelable a;
                final a b;

                public final void run()
                {
                    b.b.a(a);
                }

            
            {
                b = a1;
                a = messageeventparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            messageeventparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw messageeventparcelable;
        }

        public final void a(NodeParcelable nodeparcelable)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onPeerConnected: ")).append(p.a(b)).append(": ").append(nodeparcelable);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                }
                return;
            }
            p.e(b).post(new Runnable(this, nodeparcelable) {

                final NodeParcelable a;
                final a b;

                public final void run()
                {
                }

            
            {
                b = a1;
                a = nodeparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            nodeparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw nodeparcelable;
        }

        public final void a(List list)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onConnectedNodes: ")).append(p.a(b)).append(": ").append(list);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                }
                return;
            }
            p.e(b).post(new Runnable(this, list) {

                final List a;
                final a b;

                public final void run()
                {
                }

            
            {
                b = a1;
                a = list;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            list;
            obj;
            JVM INSTR monitorexit ;
            throw list;
        }

        public final void b(NodeParcelable nodeparcelable)
        {
label0:
            {
                if (Log.isLoggable("WearableLS", 3))
                {
                    (new StringBuilder("onPeerDisconnected: ")).append(p.a(b)).append(": ").append(nodeparcelable);
                }
                p.b(b);
                synchronized (p.c(b))
                {
                    if (!p.d(b))
                    {
                        break label0;
                    }
                }
                return;
            }
            p.e(b).post(new Runnable(this, nodeparcelable) {

                final NodeParcelable a;
                final a b;

                public final void run()
                {
                }

            
            {
                b = a1;
                a = nodeparcelable;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            nodeparcelable;
            obj;
            JVM INSTR monitorexit ;
            throw nodeparcelable;
        }

        a()
        {
            b = p.this;
            super();
            a = false;
            a = p.this instanceof x;
        }
    }


    private volatile int a;
    private String b;
    private Handler c;
    private IBinder d;
    private Object e;
    private boolean f;

    public p()
    {
        a = -1;
        e = new Object();
    }

    static String a(p p1)
    {
        return p1.b;
    }

    static void b(p p1)
    {
label0:
        {
            int i = Binder.getCallingUid();
            if (i != p1.a)
            {
                if (!GooglePlayServicesUtil.zze(p1, i))
                {
                    break label0;
                }
                p1.a = i;
            }
            return;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    static Object c(p p1)
    {
        return p1.e;
    }

    static boolean d(p p1)
    {
        return p1.f;
    }

    static Handler e(p p1)
    {
        return p1.c;
    }

    public final void a(e e1)
    {
    }

    public void a(k k)
    {
    }

    public final IBinder onBind(Intent intent)
    {
        if ("com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()))
        {
            return d;
        } else
        {
            return null;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3))
        {
            (new StringBuilder("onCreate: ")).append(getPackageName());
        }
        b = getPackageName();
        HandlerThread handlerthread = new HandlerThread("WearableListenerService");
        handlerthread.start();
        c = new Handler(handlerthread.getLooper());
        d = new a();
    }

    public void onDestroy()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        f = true;
        if (c == null)
        {
            throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
        }
        break MISSING_BLOCK_LABEL_34;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        c.getLooper().quit();
        obj;
        JVM INSTR monitorexit ;
        super.onDestroy();
        return;
    }
}

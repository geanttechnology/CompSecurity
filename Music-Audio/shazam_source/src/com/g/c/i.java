// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.g.c:
//            ah, a, c, u, 
//            w, x, z, r, 
//            j, d, ab, q

public final class i
{
    private static final class a extends Handler
    {

        private final i a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 12: default 68
        //                       1 85
        //                       2 103
        //                       3 68
        //                       4 663
        //                       5 746
        //                       6 763
        //                       7 781
        //                       8 68
        //                       9 830
        //                       10 847
        //                       11 294
        //                       12 649;
               goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L7 _L1 _L8 _L9 _L10 _L11
_L5:
            break MISSING_BLOCK_LABEL_746;
_L6:
            break MISSING_BLOCK_LABEL_763;
_L7:
            break MISSING_BLOCK_LABEL_781;
_L8:
            break MISSING_BLOCK_LABEL_830;
_L9:
            break MISSING_BLOCK_LABEL_847;
_L1:
            u.a.post(new Runnable(this, message) {

                final Message a;
                final a b;

                public final void run()
                {
                    throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(a.what).toString());
                }

            
            {
                b = a1;
                a = message;
                super();
            }
            });
_L12:
            return;
_L2:
            message = (com.g.c.a)message.obj;
            a.a(message, true);
            return;
_L3:
            message = (com.g.c.a)message.obj;
            i i1 = a;
            String s = ((com.g.c.a) (message)).i;
            com.g.c.c c1 = (com.g.c.c)i1.e.get(s);
            if (c1 != null)
            {
                c1.a(message);
                if (c1.a())
                {
                    i1.e.remove(s);
                    if (((com.g.c.a) (message)).a.n)
                    {
                        ah.a("Dispatcher", "canceled", ((com.g.c.a) (message)).b.a());
                    }
                }
            }
            if (i1.h.contains(((com.g.c.a) (message)).j))
            {
                i1.g.remove(message.c());
                if (((com.g.c.a) (message)).a.n)
                {
                    ah.a("Dispatcher", "canceled", ((com.g.c.a) (message)).b.a(), "because paused request got canceled");
                }
            }
            message = (com.g.c.a)i1.f.remove(message.c());
            if (message != null && ((com.g.c.a) (message)).a.n)
            {
                ah.a("Dispatcher", "canceled", ((com.g.c.a) (message)).b.a(), "from replaying");
                return;
            }
            continue; /* Loop/switch isn't completed */
_L10:
            message = ((Message) (message.obj));
            i j1 = a;
            if (j1.h.add(message))
            {
                Iterator iterator = j1.e.values().iterator();
                while (iterator.hasNext()) 
                {
                    com.g.c.c c2 = (com.g.c.c)iterator.next();
                    boolean flag = c2.b.n;
                    com.g.c.a a1 = c2.k;
                    List list = c2.l;
                    int i2;
                    if (list != null && !list.isEmpty())
                    {
                        i2 = 1;
                    } else
                    {
                        i2 = 0;
                    }
                    if (a1 != null || i2 != 0)
                    {
                        if (a1 != null && a1.j.equals(message))
                        {
                            c2.a(a1);
                            j1.g.put(a1.c(), a1);
                            if (flag)
                            {
                                ah.a("Dispatcher", "paused", a1.b.a(), (new StringBuilder("because tag '")).append(message).append("' was paused").toString());
                            }
                        }
                        if (i2 != 0)
                        {
                            for (i2 = list.size() - 1; i2 >= 0; i2--)
                            {
                                com.g.c.a a2 = (com.g.c.a)list.get(i2);
                                if (!a2.j.equals(message))
                                {
                                    continue;
                                }
                                c2.a(a2);
                                j1.g.put(a2.c(), a2);
                                if (flag)
                                {
                                    ah.a("Dispatcher", "paused", a2.b.a(), (new StringBuilder("because tag '")).append(message).append("' was paused").toString());
                                }
                            }

                        }
                        if (c2.a())
                        {
                            iterator.remove();
                            if (flag)
                            {
                                ah.a("Dispatcher", "canceled", ah.a(c2), "all actions paused");
                            }
                        }
                    }
                }
            }
            if (true) goto _L12; else goto _L11
_L11:
            message = ((Message) (message.obj));
            a.a(message);
            return;
_L4:
            message = (com.g.c.c)message.obj;
            i k1 = a;
            if (q.b(((com.g.c.c) (message)).h))
            {
                k1.k.a(((com.g.c.c) (message)).f, ((com.g.c.c) (message)).m);
            }
            k1.e.remove(((com.g.c.c) (message)).f);
            k1.d(message);
            if (!((com.g.c.c) (message)).b.n) goto _L12; else goto _L13
_L13:
            ah.a("Dispatcher", "batched", ah.a(message), "for completion");
            return;
            message = (com.g.c.c)message.obj;
            a.c(message);
            return;
            message = (com.g.c.c)message.obj;
            a.a(message, false);
            return;
            message = a;
            ArrayList arraylist = new ArrayList(((i) (message)).m);
            ((i) (message)).m.clear();
            ((i) (message)).j.sendMessage(((i) (message)).j.obtainMessage(8, arraylist));
            i.a(arraylist);
            return;
            message = (NetworkInfo)message.obj;
            a.a(message);
            return;
            i l1 = a;
            boolean flag1;
            if (message.arg1 == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            l1.p = flag1;
            return;
        }

        public a(Looper looper, i i1)
        {
            super(looper);
            a = i1;
        }
    }

    static final class b extends HandlerThread
    {

        b()
        {
            super("Picasso-Dispatcher", 10);
        }
    }

    static final class c extends BroadcastReceiver
    {

        final i a;

        public final void onReceive(Context context, Intent intent)
        {
            if (intent != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s;
            s = intent.getAction();
            if (!"android.intent.action.AIRPLANE_MODE".equals(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!intent.hasExtra("state")) goto _L1; else goto _L3
_L3:
            context = a;
            boolean flag = intent.getBooleanExtra("state", false);
            intent = ((i) (context)).i;
            context = ((i) (context)).i;
            int i1;
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            intent.sendMessage(context.obtainMessage(10, i1, 0));
            return;
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(s)) goto _L1; else goto _L4
_L4:
            intent = (ConnectivityManager)ah.a(context, "connectivity");
            context = a;
            intent = intent.getActiveNetworkInfo();
            ((i) (context)).i.sendMessage(((i) (context)).i.obtainMessage(9, intent));
            return;
        }

        c(i i1)
        {
            a = i1;
        }
    }


    final b a = new b();
    final Context b;
    final ExecutorService c;
    final j d;
    final Map e = new LinkedHashMap();
    final Map f = new WeakHashMap();
    final Map g = new WeakHashMap();
    final Set h = new HashSet();
    final Handler i;
    final Handler j;
    final d k;
    final ab l;
    final List m = new ArrayList(4);
    final c n = new c(this);
    final boolean o;
    boolean p;

    public i(Context context, ExecutorService executorservice, Handler handler, j j1, d d1, ab ab)
    {
        a.start();
        ah.a(a.getLooper());
        b = context;
        c = executorservice;
        i = new a(a.getLooper(), this);
        d = j1;
        j = handler;
        k = d1;
        l = ab;
        p = ah.d(b);
        o = ah.b(context, "android.permission.ACCESS_NETWORK_STATE");
        context = n;
        executorservice = new IntentFilter();
        executorservice.addAction("android.intent.action.AIRPLANE_MODE");
        if (((c) (context)).a.o)
        {
            executorservice.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        ((c) (context)).a.b.registerReceiver(context, executorservice);
    }

    private void a(com.g.c.a a1)
    {
        Object obj = a1.c();
        if (obj != null)
        {
            a1.k = true;
            f.put(obj, a1);
        }
    }

    static void a(List list)
    {
        while (list.isEmpty() || !((com.g.c.c)list.get(0)).b.n) 
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        com.g.c.c c1;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(ah.a(c1)))
        {
            c1 = (com.g.c.c)list.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(", ");
            }
        }

        ah.a("Dispatcher", "delivered", stringbuilder.toString());
    }

    private void e(com.g.c.c c1)
    {
        com.g.c.a a1 = c1.k;
        if (a1 != null)
        {
            a(a1);
        }
        c1 = c1.l;
        if (c1 != null)
        {
            int j1 = c1.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                a((com.g.c.a)c1.get(i1));
            }

        }
    }

    final void a(NetworkInfo networkinfo)
    {
        if (!(c instanceof w)) goto _L2; else goto _L1
_L1:
        Object obj = (w)c;
        if (networkinfo != null && networkinfo.isConnectedOrConnecting()) goto _L4; else goto _L3
_L3:
        ((w) (obj)).a(3);
_L2:
        if (networkinfo != null && networkinfo.isConnected() && !f.isEmpty())
        {
            for (networkinfo = f.values().iterator(); networkinfo.hasNext(); a(((com.g.c.a) (obj)), false))
            {
                obj = (com.g.c.a)networkinfo.next();
                networkinfo.remove();
                if (((com.g.c.a) (obj)).a.n)
                {
                    ah.a("Dispatcher", "replaying", ((com.g.c.a) (obj)).b.a());
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L4:
        switch (networkinfo.getType())
        {
        default:
            ((w) (obj)).a(3);
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 6: // '\006'
        case 9: // '\t'
            ((w) (obj)).a(4);
            continue; /* Loop/switch isn't completed */

        case 0: // '\0'
            switch (networkinfo.getSubtype())
            {
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            default:
                ((w) (obj)).a(3);
                break;

            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
                ((w) (obj)).a(3);
                break;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 12: // '\f'
                ((w) (obj)).a(2);
                break;

            case 1: // '\001'
            case 2: // '\002'
                ((w) (obj)).a(1);
                break;
            }
            break;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    final void a(com.g.c.a a1, boolean flag)
    {
        if (!h.contains(a1.j)) goto _L2; else goto _L1
_L1:
        g.put(a1.c(), a1);
        if (a1.a.n)
        {
            ah.a("Dispatcher", "paused", a1.b.a(), (new StringBuilder("because tag '")).append(a1.j).append("' is paused").toString());
        }
_L4:
        return;
_L2:
        com.g.c.c c1 = (com.g.c.c)e.get(a1.i);
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = c1.b.n;
        x x1 = a1.b;
        if (c1.k == null)
        {
            c1.k = a1;
            if (flag)
            {
                if (c1.l == null || c1.l.isEmpty())
                {
                    ah.a("Hunter", "joined", x1.a(), "to empty hunter");
                    return;
                } else
                {
                    ah.a("Hunter", "joined", x1.a(), ah.a(c1, "to "));
                    return;
                }
            }
        } else
        {
            if (c1.l == null)
            {
                c1.l = new ArrayList(3);
            }
            c1.l.add(a1);
            if (flag)
            {
                ah.a("Hunter", "joined", x1.a(), ah.a(c1, "to "));
            }
            a1 = a1.b.r;
            if (a1.ordinal() > c1.s.ordinal())
            {
                c1.s = a1;
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!c.isShutdown())
        {
            break; /* Loop/switch isn't completed */
        }
        if (a1.a.n)
        {
            ah.a("Dispatcher", "ignored", a1.b.a(), "because shut down");
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        com.g.c.c c2 = com.g.c.c.a(a1.a, this, k, l, a1);
        c2.n = c.submit(c2);
        e.put(a1.i, c2);
        if (flag)
        {
            f.remove(a1.c());
        }
        if (a1.a.n)
        {
            ah.a("Dispatcher", "enqueued", a1.b.a());
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    final void a(com.g.c.c c1)
    {
        i.sendMessageDelayed(i.obtainMessage(5, c1), 500L);
    }

    final void a(com.g.c.c c1, boolean flag)
    {
        if (c1.b.n)
        {
            String s1 = ah.a(c1);
            StringBuilder stringbuilder = new StringBuilder("for error");
            String s;
            if (flag)
            {
                s = " (will replay)";
            } else
            {
                s = "";
            }
            ah.a("Dispatcher", "batched", s1, stringbuilder.append(s).toString());
        }
        e.remove(c1.f);
        d(c1);
    }

    final void a(Object obj)
    {
        if (h.remove(obj))
        {
            ArrayList arraylist = null;
            Iterator iterator = g.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.g.c.a a1 = (com.g.c.a)iterator.next();
                if (a1.j.equals(obj))
                {
                    ArrayList arraylist1 = arraylist;
                    if (arraylist == null)
                    {
                        arraylist1 = new ArrayList();
                    }
                    arraylist1.add(a1);
                    iterator.remove();
                    arraylist = arraylist1;
                }
            } while (true);
            if (arraylist != null)
            {
                j.sendMessage(j.obtainMessage(13, arraylist));
                return;
            }
        }
    }

    final void b(com.g.c.c c1)
    {
        i.sendMessage(i.obtainMessage(6, c1));
    }

    final void c(com.g.c.c c1)
    {
        boolean flag3 = true;
        if (!c1.b()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (c.isShutdown())
        {
            a(c1, false);
            return;
        }
        NetworkInfo networkinfo;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag4;
        if (o)
        {
            networkinfo = ((ConnectivityManager)ah.a(b, "connectivity")).getActiveNetworkInfo();
        } else
        {
            networkinfo = null;
        }
        if (networkinfo != null && networkinfo.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (c1.r > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            flag2 = false;
        } else
        {
            c1.r = c1.r - 1;
            flag2 = c1.j.a(networkinfo);
        }
        flag4 = c1.j.b();
        if (flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (o && flag4)
        {
            flag2 = flag3;
        } else
        {
            flag2 = false;
        }
        a(c1, flag2);
        if (flag2)
        {
            e(c1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!o || flag)
        {
            if (c1.b.n)
            {
                ah.a("Dispatcher", "retrying", ah.a(c1));
            }
            if (c1.p instanceof s.a)
            {
                c1.i = c1.i | r.a.d;
            }
            c1.n = c.submit(c1);
            return;
        }
        a(c1, flag4);
        if (flag4)
        {
            e(c1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    final void d(com.g.c.c c1)
    {
        if (!c1.b())
        {
            m.add(c1);
            if (!i.hasMessages(7))
            {
                i.sendEmptyMessageDelayed(7, 200L);
                return;
            }
        }
    }
}

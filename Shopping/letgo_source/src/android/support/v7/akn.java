// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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

// Referenced classes of package android.support.v7:
//            alj, akh, aky, akf, 
//            alb, ala, akv, aku, 
//            aki, ako, alf

class akn
{
    private static class a extends Handler
    {

        private final akn a;

        public void handleMessage(Message message)
        {
            boolean flag = true;
            akn akn1;
            switch (message.what)
            {
            case 3: // '\003'
            case 8: // '\b'
            default:
                aky.a.post(new Runnable(this, message) {

                    final Message a;
                    final a b;

                    public void run()
                    {
                        throw new AssertionError((new StringBuilder()).append("Unknown handler message received: ").append(a.what).toString());
                    }

            
            {
                b = a1;
                a = message;
                super();
            }
                });
                return;

            case 1: // '\001'
                message = (akf)message.obj;
                a.c(message);
                return;

            case 2: // '\002'
                message = (akf)message.obj;
                a.d(message);
                return;

            case 11: // '\013'
                message = ((Message) (message.obj));
                a.a(message);
                return;

            case 12: // '\f'
                message = ((Message) (message.obj));
                a.b(message);
                return;

            case 4: // '\004'
                message = (akh)message.obj;
                a.e(message);
                return;

            case 5: // '\005'
                message = (akh)message.obj;
                a.d(message);
                return;

            case 6: // '\006'
                message = (akh)message.obj;
                a.a(message, false);
                return;

            case 7: // '\007'
                a.a();
                return;

            case 9: // '\t'
                message = (NetworkInfo)message.obj;
                a.b(message);
                return;

            case 10: // '\n'
                akn1 = a;
                break;
            }
            if (message.arg1 != 1)
            {
                flag = false;
            }
            akn1.b(flag);
        }

        public a(Looper looper, akn akn1)
        {
            super(looper);
            a = akn1;
        }
    }

    static class b extends HandlerThread
    {

        b()
        {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver
    {

        private final akn a;

        void a()
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (a.o)
            {
                intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            a.b.registerReceiver(this, intentfilter);
        }

        public void onReceive(Context context, Intent intent)
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
            a.a(intent.getBooleanExtra("state", false));
            return;
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(s)) goto _L1; else goto _L4
_L4:
            context = (ConnectivityManager)alj.a(context, "connectivity");
            a.a(context.getActiveNetworkInfo());
            return;
        }

        c(akn akn1)
        {
            a = akn1;
        }
    }


    final b a = new b();
    final Context b;
    final ExecutorService c;
    final ako d;
    final Map e = new LinkedHashMap();
    final Map f = new WeakHashMap();
    final Map g = new WeakHashMap();
    final Set h = new HashSet();
    final Handler i;
    final Handler j;
    final aki k;
    final alf l;
    final List m = new ArrayList(4);
    final c n = new c(this);
    final boolean o;
    boolean p;

    akn(Context context, ExecutorService executorservice, Handler handler, ako ako, aki aki1, alf alf)
    {
        a.start();
        b = context;
        c = executorservice;
        i = new a(a.getLooper(), this);
        d = ako;
        j = handler;
        k = aki1;
        l = alf;
        p = alj.d(b);
        o = alj.b(context, "android.permission.ACCESS_NETWORK_STATE");
        n.a();
    }

    private void a(List list)
    {
        while (list == null || list.isEmpty() || !((akh)list.get(0)).j().l) 
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        akh akh1;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(alj.a(akh1)))
        {
            akh1 = (akh)list.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(", ");
            }
        }

        alj.a("Dispatcher", "delivered", stringbuilder.toString());
    }

    private void b()
    {
        if (!f.isEmpty())
        {
            akf akf1;
            for (Iterator iterator = f.values().iterator(); iterator.hasNext(); a(akf1, false))
            {
                akf1 = (akf)iterator.next();
                iterator.remove();
                if (akf1.j().l)
                {
                    alj.a("Dispatcher", "replaying", akf1.c().a());
                }
            }

        }
    }

    private void e(akf akf1)
    {
        Object obj = akf1.d();
        if (obj != null)
        {
            akf1.k = true;
            f.put(obj, akf1);
        }
    }

    private void f(akh akh1)
    {
        akf akf1 = akh1.i();
        if (akf1 != null)
        {
            e(akf1);
        }
        akh1 = akh1.k();
        if (akh1 != null)
        {
            int j1 = akh1.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                e((akf)akh1.get(i1));
            }

        }
    }

    private void g(akh akh1)
    {
        if (!akh1.c())
        {
            m.add(akh1);
            if (!i.hasMessages(7))
            {
                i.sendEmptyMessageDelayed(7, 200L);
                return;
            }
        }
    }

    void a()
    {
        ArrayList arraylist = new ArrayList(m);
        m.clear();
        j.sendMessage(j.obtainMessage(8, arraylist));
        a(((List) (arraylist)));
    }

    void a(NetworkInfo networkinfo)
    {
        i.sendMessage(i.obtainMessage(9, networkinfo));
    }

    void a(akf akf1)
    {
        i.sendMessage(i.obtainMessage(1, akf1));
    }

    void a(akf akf1, boolean flag)
    {
        if (!h.contains(akf1.l())) goto _L2; else goto _L1
_L1:
        g.put(akf1.d(), akf1);
        if (akf1.j().l)
        {
            alj.a("Dispatcher", "paused", akf1.b.a(), (new StringBuilder()).append("because tag '").append(akf1.l()).append("' is paused").toString());
        }
_L4:
        return;
_L2:
        akh akh1 = (akh)e.get(akf1.e());
        if (akh1 != null)
        {
            akh1.a(akf1);
            return;
        }
        if (!c.isShutdown())
        {
            break; /* Loop/switch isn't completed */
        }
        if (akf1.j().l)
        {
            alj.a("Dispatcher", "ignored", akf1.b.a(), "because shut down");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        akh akh2 = akh.a(akf1.j(), this, k, l, akf1);
        akh2.n = c.submit(akh2);
        e.put(akf1.e(), akh2);
        if (flag)
        {
            f.remove(akf1.d());
        }
        if (akf1.j().l)
        {
            alj.a("Dispatcher", "enqueued", akf1.b.a());
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    void a(akh akh1)
    {
        i.sendMessage(i.obtainMessage(4, akh1));
    }

    void a(akh akh1, boolean flag)
    {
        if (akh1.j().l)
        {
            String s1 = alj.a(akh1);
            StringBuilder stringbuilder = (new StringBuilder()).append("for error");
            String s;
            if (flag)
            {
                s = " (will replay)";
            } else
            {
                s = "";
            }
            alj.a("Dispatcher", "batched", s1, stringbuilder.append(s).toString());
        }
        e.remove(akh1.f());
        g(akh1);
    }

    void a(Object obj)
    {
        if (h.add(obj))
        {
            Iterator iterator = e.values().iterator();
            while (iterator.hasNext()) 
            {
                akh akh1 = (akh)iterator.next();
                boolean flag = akh1.j().l;
                akf akf1 = akh1.i();
                List list = akh1.k();
                int i1;
                if (list != null && !list.isEmpty())
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (akf1 != null || i1 != 0)
                {
                    if (akf1 != null && akf1.l().equals(obj))
                    {
                        akh1.b(akf1);
                        g.put(akf1.d(), akf1);
                        if (flag)
                        {
                            alj.a("Dispatcher", "paused", akf1.b.a(), (new StringBuilder()).append("because tag '").append(obj).append("' was paused").toString());
                        }
                    }
                    if (i1 != 0)
                    {
                        i1 = list.size() - 1;
                        while (i1 >= 0) 
                        {
                            akf akf2 = (akf)list.get(i1);
                            if (akf2.l().equals(obj))
                            {
                                akh1.b(akf2);
                                g.put(akf2.d(), akf2);
                                if (flag)
                                {
                                    alj.a("Dispatcher", "paused", akf2.b.a(), (new StringBuilder()).append("because tag '").append(obj).append("' was paused").toString());
                                }
                            }
                            i1--;
                        }
                    }
                    if (akh1.b())
                    {
                        iterator.remove();
                        if (flag)
                        {
                            alj.a("Dispatcher", "canceled", alj.a(akh1), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void a(boolean flag)
    {
        Handler handler = i;
        Handler handler1 = i;
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        handler.sendMessage(handler1.obtainMessage(10, i1, 0));
    }

    void b(NetworkInfo networkinfo)
    {
        if (c instanceof ala)
        {
            ((ala)c).a(networkinfo);
        }
        if (networkinfo != null && networkinfo.isConnected())
        {
            b();
        }
    }

    void b(akf akf1)
    {
        i.sendMessage(i.obtainMessage(2, akf1));
    }

    void b(akh akh1)
    {
        i.sendMessageDelayed(i.obtainMessage(5, akh1), 500L);
    }

    void b(Object obj)
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
                akf akf1 = (akf)iterator.next();
                if (akf1.l().equals(obj))
                {
                    ArrayList arraylist1 = arraylist;
                    if (arraylist == null)
                    {
                        arraylist1 = new ArrayList();
                    }
                    arraylist1.add(akf1);
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

    void b(boolean flag)
    {
        p = flag;
    }

    void c(akf akf1)
    {
        a(akf1, true);
    }

    void c(akh akh1)
    {
        i.sendMessage(i.obtainMessage(6, akh1));
    }

    void d(akf akf1)
    {
        String s = akf1.e();
        akh akh1 = (akh)e.get(s);
        if (akh1 != null)
        {
            akh1.b(akf1);
            if (akh1.b())
            {
                e.remove(s);
                if (akf1.j().l)
                {
                    alj.a("Dispatcher", "canceled", akf1.c().a());
                }
            }
        }
        if (h.contains(akf1.l()))
        {
            g.remove(akf1.d());
            if (akf1.j().l)
            {
                alj.a("Dispatcher", "canceled", akf1.c().a(), "because paused request got canceled");
            }
        }
        akf1 = (akf)f.remove(akf1.d());
        if (akf1 != null && akf1.j().l)
        {
            alj.a("Dispatcher", "canceled", akf1.c().a(), "from replaying");
        }
    }

    void d(akh akh1)
    {
        boolean flag1 = true;
        if (!akh1.c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (c.isShutdown())
        {
            a(akh1, false);
            return;
        }
        NetworkInfo networkinfo;
        boolean flag;
        boolean flag2;
        boolean flag3;
        if (o)
        {
            networkinfo = ((ConnectivityManager)alj.a(b, "connectivity")).getActiveNetworkInfo();
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
        flag2 = akh1.a(p, networkinfo);
        flag3 = akh1.d();
        if (flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!o || !flag3)
        {
            flag1 = false;
        }
        a(akh1, flag1);
        if (flag1)
        {
            f(akh1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!o || flag)
        {
            if (akh1.j().l)
            {
                alj.a("Dispatcher", "retrying", alj.a(akh1));
            }
            if (akh1.l() instanceof akw.a)
            {
                akh1.i = akh1.i | akv.a.d;
            }
            akh1.n = c.submit(akh1);
            return;
        }
        a(akh1, flag3);
        if (flag3)
        {
            f(akh1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    void e(akh akh1)
    {
        if (aku.b(akh1.g()))
        {
            k.a(akh1.f(), akh1.e());
        }
        e.remove(akh1.f());
        g(akh1);
        if (akh1.j().l)
        {
            alj.a("Dispatcher", "batched", alj.a(akh1), "for completion");
        }
    }
}

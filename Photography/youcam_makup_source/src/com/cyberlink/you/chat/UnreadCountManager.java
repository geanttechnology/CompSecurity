// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.jivesoftware.smackx.receipts.DeliveryReceipt;

// Referenced classes of package com.cyberlink.you.chat:
//            i, h, g, n, 
//            j, l, w, b

public class UnreadCountManager
{

    private static ThreadGroup l = new ThreadGroup("SingleAsyncTask");
    private static ThreadPoolExecutor m;
    l a;
    private Map b;
    private Map c;
    private Map d;
    private Map e;
    private List f;
    private boolean g;
    private boolean h;
    private Object i;
    private AsyncTask j;
    private AsyncTask k;
    private w n;
    private List o;
    private List p;

    public UnreadCountManager()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = false;
        h = false;
        i = new Object();
        n = new w() {

            final UnreadCountManager a;

            public String a(b b1)
            {
                if (!b1.q() || b1.p().equals(com.cyberlink.you.g.a().f()) || b1.e().equals(String.valueOf(com.cyberlink.you.g.a().g())) || !b1.k().after(com.cyberlink.you.g.a().q())) goto _L2; else goto _L1
_L1:
                if (b1.r() != null) goto _L4; else goto _L3
_L3:
                return null;
_L4:
                class OnUnreadCountListner.Type extends Enum
                {

                    public static final OnUnreadCountListner.Type a;
                    public static final OnUnreadCountListner.Type b;
                    public static final OnUnreadCountListner.Type c;
                    private static final OnUnreadCountListner.Type d[];

                    public static OnUnreadCountListner.Type valueOf(String s1)
                    {
                        return (OnUnreadCountListner.Type)Enum.valueOf(com/cyberlink/you/chat/UnreadCountManager$OnUnreadCountListner$Type, s1);
                    }

                    public static OnUnreadCountListner.Type[] values()
                    {
                        return (OnUnreadCountListner.Type[])d.clone();
                    }

                    static 
                    {
                        a = new OnUnreadCountListner.Type("Message", 0);
                        b = new OnUnreadCountListner.Type("Bulletin", 1);
                        c = new OnUnreadCountListner.Type("All", 2);
                        d = (new OnUnreadCountListner.Type[] {
                            a, b, c
                        });
                    }

                        private OnUnreadCountListner.Type(String s, int i1)
                        {
                            super(s, i1);
                        }
                }

                String s = b1.p();
                Log.d("UnreadCountManager", (new StringBuilder()).append("receive message id=").append(b1.i()).toString());
                a.a(s, true);
                a.a(OnUnreadCountListner.Type.a);
                UnreadCountManager.a(a, com.cyberlink.you.g.I());
                return null;
_L2:
                if (b1.g().equals(com.cyberlink.you.database.MessageObj.MessageType.e))
                {
                    Object obj = (DeliveryReceipt)b1.a("received", "urn:xmpp:receipts");
                    if (obj != null)
                    {
                        obj = ((DeliveryReceipt) (obj)).c();
                        if (b1.e().equals(String.valueOf(com.cyberlink.you.g.a().g())))
                        {
                            obj = com.cyberlink.you.e.d().a(((String) (obj)));
                            if (obj != null)
                            {
                                b1 = com.cyberlink.you.e.f().d(((MessageObj) (obj)).c());
                                if (b1 != null)
                                {
                                    UnreadCountManager.a(a, ((Group) (b1)).c, ((Group) (b1)).l);
                                    a.a(OnUnreadCountListner.Type.a);
                                    UnreadCountManager.a(a, com.cyberlink.you.g.I());
                                    return null;
                                } else
                                {
                                    Log.d("UnreadCountManager", (new StringBuilder()).append("Unread count update fail. group is null. message=").append(((MessageObj) (obj)).toString()).toString());
                                    return null;
                                }
                            } else
                            {
                                Log.d("UnreadCountManager", (new StringBuilder()).append("Unread count update fail. messageObj is null. message=").append(b1.toString()).toString());
                                return null;
                            }
                        }
                    }
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            public boolean a()
            {
                return false;
            }

            
            {
                a = UnreadCountManager.this;
                super();
            }
        };
        a = new l() {

            final UnreadCountManager a;

            public void a()
            {
                if (UnreadCountManager.a(a) == null)
                {
                    UnreadCountManager.a(a, new AsyncTask(this) {

                        final _cls3 a;

                        protected void a(Object aobj[])
                        {
                            aobj = (List)aobj[0];
                            Log.d("UnreadCountManager", "second init update unread count from database start.");
                            if (aobj != null)
                            {
                                ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), "second init update unread count from database");
                                Group group;
                                for (aobj = ((List) (aobj)).iterator(); ((Iterator) (aobj)).hasNext(); UnreadCountManager.a(a.a, group.c, group.l))
                                {
                                    group = (Group)((Iterator) (aobj)).next();
                                    if (group.l != 0)
                                    {
                                        Log.d("UnreadCountManager", (new StringBuilder()).append("second init group jid=").append(group.c).append(" unread=").append(group.l).toString());
                                    }
                                }

                                UnreadCountManager.a(a.a, com.cyberlink.you.g.I());
                            }
                            a.a.a(OnUnreadCountListner.Type.c);
                            Log.d("UnreadCountManager", "second init update unread count from database end.");
                            UnreadCountManager.a(a.a, true);
                            UnreadCountManager.b(a.a, true);
                            UnreadCountManager.b(a.a);
                        }

                        protected transient Object[] a(Void avoid[])
                        {
                            return (new Object[] {
                                com.cyberlink.you.e.f().c()
                            });
                        }

                        protected Object doInBackground(Object aobj[])
                        {
                            return ((Object) (a((Void[])aobj)));
                        }

                        protected void onPostExecute(Object obj)
                        {
                            a((Object[])obj);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    UnreadCountManager.a(a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
            }

            public void b()
            {
            }

            
            {
                a = UnreadCountManager.this;
                super();
            }
        };
        o = new ArrayList();
        p = new ArrayList();
        i = new Object();
        c();
    }

    static AsyncTask a(UnreadCountManager unreadcountmanager)
    {
        return unreadcountmanager.k;
    }

    static AsyncTask a(UnreadCountManager unreadcountmanager, AsyncTask asynctask)
    {
        unreadcountmanager.k = asynctask;
        return asynctask;
    }

    public static void a(Context context)
    {
        Object obj = com.cyberlink.you.e.f().c();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            int i1;
            for (i1 = 0; ((Iterator) (obj)).hasNext(); i1 = ((Group)((Iterator) (obj)).next()).l + i1) { }
            a(context, i1);
        }
    }

    private static void a(Context context, int i1)
    {
    }

    static void a(UnreadCountManager unreadcountmanager, Context context)
    {
        unreadcountmanager.b(context);
    }

    static void a(UnreadCountManager unreadcountmanager, String s, int i1)
    {
        unreadcountmanager.b(s, i1);
    }

    private void a(String s, int i1)
    {
        if (s == null)
        {
            return;
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)b.get(s);
        int j1;
        j1 = i1;
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        j1 = i1;
        if (integer.intValue() != 0)
        {
            j1 = i1 + integer.intValue();
        }
        b.put(s, Integer.valueOf(j1));
        ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), (new StringBuilder()).append("reset unread(whendoarchive) jid=").append(s).append(" count=").append(j1).toString());
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static boolean a(UnreadCountManager unreadcountmanager, boolean flag)
    {
        unreadcountmanager.g = flag;
        return flag;
    }

    public static UnreadCountManager b()
    {
        return com.cyberlink.you.chat.i.a();
    }

    private void b(Context context)
    {
        if (b == null)
        {
            return;
        } else
        {
            a(context, d());
            return;
        }
    }

    static void b(UnreadCountManager unreadcountmanager)
    {
        unreadcountmanager.f();
    }

    static void b(UnreadCountManager unreadcountmanager, String s, int i1)
    {
        unreadcountmanager.a(s, i1);
    }

    private void b(String s, int i1)
    {
        if (s == null)
        {
            return;
        }
        synchronized (i)
        {
            b.put(s, Integer.valueOf(i1));
            ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), (new StringBuilder()).append("reset unread jid=").append(s).append(" count=").append(i1).toString());
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static boolean b(UnreadCountManager unreadcountmanager, boolean flag)
    {
        unreadcountmanager.h = flag;
        return flag;
    }

    static ThreadGroup e()
    {
        return l;
    }

    private void f()
    {
        Object obj = p;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = p.iterator(); iterator.hasNext(); ((h)iterator.next()).a(h)) { }
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((ConcurrentModificationException) (obj)).printStackTrace();
        }
        return;
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(long l1)
    {
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = (List)c.get(Long.valueOf(l1));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); b(((Long)((Iterator) (obj1)).next()).longValue())) { }
        break MISSING_BLOCK_LABEL_76;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        b(com.cyberlink.you.g.I());
        obj;
        JVM INSTR monitorexit ;
        m.execute(new com.cyberlink.you.chat.g(this, OnUnreadCountListner.Type.b));
        return;
    }

    public void a(OnUnreadCountListner.Type type)
    {
        List list = o;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = o.iterator(); iterator.hasNext(); ((OnUnreadCountListner)iterator.next()).a(type)) { }
        break MISSING_BLOCK_LABEL_49;
        type;
        list;
        JVM INSTR monitorexit ;
        throw type;
        list;
        JVM INSTR monitorexit ;
    }

    public void a(OnUnreadCountListner onunreadcountlistner)
    {
        synchronized (o)
        {
            o.add(onunreadcountlistner);
        }
        return;
        onunreadcountlistner;
        list;
        JVM INSTR monitorexit ;
        throw onunreadcountlistner;
    }

    public void a(h h1)
    {
label0:
        {
            synchronized (p)
            {
                Iterator iterator = p.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while ((h)iterator.next() != h1);
            }
            return;
        }
        p.add(h1);
        list;
        JVM INSTR monitorexit ;
        return;
        h1;
        list;
        JVM INSTR monitorexit ;
        throw h1;
    }

    public void a(String s)
    {
        b(s, true);
    }

    public void a(String s, boolean flag)
    {
        if (s == null)
        {
            return;
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (!g || f.contains(s)) goto _L2; else goto _L1
_L1:
        Group group = com.cyberlink.you.e.f().c(s);
        b.put(group.c, Integer.valueOf(group.l));
        f.add(group.c);
        Log.d("UnreadCountManager", (new StringBuilder()).append("reset update unread jid=").append(s).append(" count=").append(group.l).toString());
        ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), (new StringBuilder()).append("reset update unread jid=").append(s).append(" count=").append(group.l).toString());
_L7:
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        Integer integer1 = (Integer)b.get(s);
        if (integer1 == null) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        Integer integer = Integer.valueOf(integer1.intValue() + 1);
_L9:
        Log.d("UnreadCountManager", (new StringBuilder()).append("update unread jid=").append(s).append(" count=").append(integer).toString());
        ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), (new StringBuilder()).append("update unread jid=").append(s).append(" count=").append(integer).toString());
        b.put(s, integer);
          goto _L7
_L6:
        integer = integer1;
        if (integer1.intValue() <= 0) goto _L9; else goto _L8
_L8:
        integer = Integer.valueOf(integer1.intValue() - 1);
          goto _L9
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        integer = Integer.valueOf(1);
          goto _L9
        integer = Integer.valueOf(0);
          goto _L9
    }

    public boolean a()
    {
        return h;
    }

    public int b(String s)
    {
        boolean flag;
        flag = false;
        if (s == null)
        {
            return 0;
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        int i1 = ((flag) ? 1 : 0);
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        i1 = ((flag) ? 1 : 0);
        if (b.get(s) != null)
        {
            i1 = ((Integer)b.get(s)).intValue();
        }
        obj;
        JVM INSTR monitorexit ;
        return i1;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void b(long l1)
    {
        synchronized (i)
        {
            d.put(Long.valueOf(l1), Integer.valueOf(0));
            b(com.cyberlink.you.g.I());
        }
        m.execute(new com.cyberlink.you.chat.g(this, OnUnreadCountListner.Type.b));
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(OnUnreadCountListner onunreadcountlistner)
    {
        synchronized (o)
        {
            o.remove(onunreadcountlistner);
        }
        return;
        onunreadcountlistner;
        list;
        JVM INSTR monitorexit ;
        throw onunreadcountlistner;
    }

    public void b(h h1)
    {
        synchronized (p)
        {
            p.remove(h1);
        }
        return;
        h1;
        list;
        JVM INSTR monitorexit ;
        throw h1;
    }

    public void b(String s, boolean flag)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        synchronized (i)
        {
            b.put(s, Integer.valueOf(0));
            b(com.cyberlink.you.g.I());
        }
        if (!flag) goto _L1; else goto _L3
_L3:
        m.execute(new com.cyberlink.you.chat.g(this, OnUnreadCountListner.Type.a));
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void c()
    {
        com.cyberlink.you.chat.n.a().a(n);
        com.cyberlink.you.chat.j.a(a);
        synchronized (i)
        {
            b = new HashMap();
            f = new ArrayList();
        }
        if (k == null || !k.getStatus().equals(android.os.AsyncTask.Status.RUNNING) && !k.getStatus().equals(android.os.AsyncTask.Status.FINISHED))
        {
            j = new AsyncTask() {

                final UnreadCountManager a;

                protected void a(Object aobj[])
                {
                    ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), "first init unread count from database");
                    aobj = (List)aobj[0];
                    Log.d("UnreadCountManager", "first init unread count from database start");
                    if (aobj != null)
                    {
                        Group group;
                        for (aobj = ((List) (aobj)).iterator(); ((Iterator) (aobj)).hasNext(); UnreadCountManager.b(a, group.c, group.l))
                        {
                            group = (Group)((Iterator) (aobj)).next();
                        }

                    }
                    Log.d("UnreadCountManager", "first init unread count from database end");
                    UnreadCountManager.b(a, true);
                    UnreadCountManager.b(a);
                }

                protected transient Object[] a(Void avoid[])
                {
                    return (new Object[] {
                        com.cyberlink.you.e.f().c()
                    });
                }

                protected Object doInBackground(Object aobj[])
                {
                    return ((Object) (a((Void[])aobj)));
                }

                protected void onPostExecute(Object obj1)
                {
                    a((Object[])obj1);
                }

            
            {
                a = UnreadCountManager.this;
                super();
            }
            };
            j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        Log.d("UnreadCountManager", "init UnreadManager");
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int d()
    {
        int i1 = 0;
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = b.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            if (((Integer)entry.getValue()).intValue() > 0)
            {
                i1 = ((Integer)entry.getValue()).intValue() + i1;
            }
        } while (true);
        obj;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        m = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(com.cyberlink.you.chat.UnreadCountManager.e(), runnable, (new StringBuilder()).append("Single AsyncTask #").append(a.getAndIncrement()).toString());
            }

        });
    }

    private class OnUnreadCountListner
    {

        public abstract void a(Type type);
    }

}

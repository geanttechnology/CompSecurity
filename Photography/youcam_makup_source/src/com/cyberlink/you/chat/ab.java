// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import com.cyberlink.you.a;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.j;
import com.cyberlink.you.database.k;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.ArrayUtils;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.StreamMgmt;

// Referenced classes of package com.cyberlink.you.chat:
//            XMPPObject, d, n, ae, 
//            ad, ac, o, aa, 
//            r

public class ab
{

    private static ThreadGroup i = new ThreadGroup("SingleAsyncTask");
    private static ThreadPoolExecutor j;
    private static com.cyberlink.you.database.MessageObj.MessageType l[];
    private ac a;
    private boolean b;
    private ExecutorService c;
    private final Object d = new Object();
    private PriorityBlockingQueue e;
    private Thread f;
    private final Semaphore g = new Semaphore(1, true);
    private final Object h = new Object();
    private List k;
    private o m;
    private aa n;

    public ab()
    {
        b = false;
        c = Executors.newFixedThreadPool(1);
        e = new PriorityBlockingQueue(100, new Comparator() {

            final ab a;
            private final int b = 3;
            private final int c = 2;
            private final int d = 1;

            private int a(XMPPObject xmppobject)
            {
                if (b(xmppobject))
                {
                    return 1;
                }
                return !xmppobject.b.equals(com.cyberlink.you.chat.XMPPObject.ContentType.a) ? 2 : 3;
            }

            private boolean b(XMPPObject xmppobject)
            {
                xmppobject = xmppobject.c;
                if (xmppobject != null)
                {
                    xmppobject = xmppobject.j();
                    if (xmppobject.equals("6") || xmppobject.equals("10"))
                    {
                        return true;
                    }
                }
                return false;
            }

            public int a(XMPPObject xmppobject, XMPPObject xmppobject1)
            {
                int i1 = a(xmppobject);
                return a(xmppobject1) - i1;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((XMPPObject)obj, (XMPPObject)obj1);
            }

            
            {
                a = ab.this;
                super();
            }
        });
        k = new ArrayList();
        m = new o() {

            final ab a;

            public void a(boolean flag)
            {
                if (flag)
                {
                    synchronized (com.cyberlink.you.chat.ab.a(a))
                    {
                        com.cyberlink.you.chat.ab.a(a).notify();
                    }
                    return;
                } else
                {
                    return;
                }
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = ab.this;
                super();
            }
        };
        n = new aa() {

            final ab a;

            public boolean a(StreamMgmt streammgmt)
            {
                if (streammgmt != null) goto _L2; else goto _L1
_L1:
                return false;
_L2:
                if ((streammgmt = streammgmt.q()) == null) goto _L1; else goto _L3
_L3:
                XMPPObject xmppobject;
                Log.d("XMPPQueue", (new StringBuilder()).append("StreamMgmt: ").append(streammgmt).toString());
                xmppobject = (XMPPObject)ab.b(a).peek();
                if (xmppobject == null || !xmppobject.b.equals(com.cyberlink.you.chat.XMPPObject.ContentType.a) || !xmppobject.c.b().equals(streammgmt)) goto _L5; else goto _L4
_L4:
                com.cyberlink.you.chat.ab.a(a, xmppobject, true);
_L7:
                return true;
_L5:
                if (xmppobject != null && xmppobject.b.equals(XMPPObject.ContentType.b) && xmppobject.e.q().equals(streammgmt))
                {
                    com.cyberlink.you.chat.ab.a(a, xmppobject, true);
                }
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                a = ab.this;
                super();
            }
        };
        b();
    }

    private int a(XMPPObject xmppobject)
    {
        MessageObj messageobj = e().a(xmppobject.c.b());
        if (messageobj == null || messageobj.j().equals("0"))
        {
            a(xmppobject, false);
            Log.d("XMPPQueue", (new StringBuilder()).append("Already Sent: ").append(xmppobject.c.b()).toString());
            return 0;
        }
        long l2 = System.currentTimeMillis();
        long l3 = messageobj.d().getTime();
        long l1;
        if (com.cyberlink.you.chat.d.a(messageobj))
        {
            l1 = 0x36ee80L;
        } else
        {
            l1 = 60000L;
        }
        if (l2 > l1 + l3)
        {
            a(xmppobject, false);
            synchronized (h)
            {
                messageobj.c("3");
                e().a(messageobj.b(), messageobj, "Status");
                a(false, messageobj);
            }
            Log.d("XMPPQueue", (new StringBuilder()).append("Expired: ").append(xmppobject.c.b()).toString());
            return 1;
        }
        break MISSING_BLOCK_LABEL_195;
        xmppobject;
        obj;
        JVM INSTR monitorexit ;
        throw xmppobject;
        if (com.cyberlink.you.chat.n.a != org.jivesoftware.smack.packet.Presence.Type.a)
        {
            Log.d("XMPPQueue", "Presence Not Available");
            return 2;
        } else
        {
            Log.d("XMPPQueue", (new StringBuilder()).append("Send: ").append(xmppobject.c.b()).toString());
            a(xmppobject.a, xmppobject.c);
            xmppobject.c.c("10");
            return 3;
        }
    }

    static int a(ab ab1, XMPPObject xmppobject)
    {
        return ab1.a(xmppobject);
    }

    public static ab a()
    {
        return com.cyberlink.you.chat.ae.a();
    }

    static Object a(ab ab1)
    {
        return ab1.d;
    }

    private void a(XMPPObject xmppobject, boolean flag)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        e.remove(xmppobject);
        if (e.isEmpty())
        {
            com.cyberlink.you.a.a().b("XMPPQueue");
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        d.notify();
        obj;
        JVM INSTR monitorexit ;
        return;
        xmppobject;
        obj;
        JVM INSTR monitorexit ;
        throw xmppobject;
    }

    static void a(ab ab1, XMPPObject xmppobject, boolean flag)
    {
        ab1.b(xmppobject, flag);
    }

    private void a(String s, MessageObj messageobj)
    {
        s = new Runnable(messageobj, s) {

            final MessageObj a;
            final String b;
            final ab c;

            public void run()
            {
                Object obj;
                Object obj1;
                Thread.currentThread().setName("SendMessage (Internal)");
                try
                {
                    ab.c(c).acquire();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ab.c(c).release();
                    return;
                }
                obj = com.cyberlink.you.chat.ab.d(c);
                obj;
                JVM INSTR monitorenter ;
                obj1 = c.f().a(a.c());
                if (obj1 != null)
                {
                    break MISSING_BLOCK_LABEL_75;
                }
                ab.c(c).release();
                obj;
                JVM INSTR monitorexit ;
                return;
                obj1 = com.cyberlink.you.chat.d.a(((Group) (obj1)).e, b, a);
                String s1 = a.b();
                a.a(((Message) (obj1)).q());
                c.e().a(s1, a, "MessageId");
                obj;
                JVM INSTR monitorexit ;
                if (com.cyberlink.you.chat.n.a != org.jivesoftware.smack.packet.Presence.Type.a)
                {
                    ab.c(c).release();
                    return;
                } else
                {
                    c.a(((Message) (obj1)), new r(this) {

                        final _cls6 a;

                        public void a()
                        {
                            ab.c(a.c).release();
                            com.cyberlink.you.chat.ab.a(a.c, true, a.a);
                        }

                        public void b()
                        {
                            ab.c(a.c).release();
                            com.cyberlink.you.chat.ab.a(a.c, false, a.a);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    return;
                }
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
            }

            
            {
                c = ab.this;
                a = messageobj;
                b = s;
                super();
            }
        };
        c.execute(s);
    }

    static boolean a(ab ab1, boolean flag)
    {
        ab1.b = flag;
        return flag;
    }

    static boolean a(ab ab1, boolean flag, MessageObj messageobj)
    {
        return ab1.a(flag, messageobj);
    }

    static boolean a(com.cyberlink.you.database.MessageObj.MessageType messagetype)
    {
        return b(messagetype);
    }

    private boolean a(boolean flag, MessageObj messageobj)
    {
        boolean flag1 = false;
        ab ab1 = a();
        ab1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = k.iterator(); iterator.hasNext();)
        {
            flag1 = ((ad)iterator.next()).a(flag, messageobj);
        }

        ab1;
        JVM INSTR monitorexit ;
        return flag1;
        messageobj;
        ab1;
        JVM INSTR monitorexit ;
        throw messageobj;
    }

    private int b(XMPPObject xmppobject)
    {
        MessageObj messageobj = e().a(xmppobject.d);
        if (messageobj == null)
        {
            return 4;
        }
        if (messageobj.j().equals("5"))
        {
            a(xmppobject, true);
            return 0;
        }
        k k1 = new k(xmppobject.d, xmppobject.e.q(), "2");
        g().a(k1);
        if (a != null && a.a == xmppobject.e.q() && System.currentTimeMillis() - a.b < 30000L)
        {
            return 1;
        } else
        {
            messageobj.c("6");
            e().a(xmppobject.d, messageobj, "Status");
            com.cyberlink.you.chat.d.a(xmppobject.e, null);
            xmppobject.c = messageobj;
            a = new ac(this, xmppobject.e.q(), System.currentTimeMillis());
            return 0;
        }
    }

    static int b(ab ab1, XMPPObject xmppobject)
    {
        return ab1.b(xmppobject);
    }

    static PriorityBlockingQueue b(ab ab1)
    {
        return ab1.e;
    }

    private void b(XMPPObject xmppobject, boolean flag)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            (new AsyncTask(xmppobject, flag) {

                final XMPPObject a;
                final boolean b;
                final ab c;

                protected transient Void a(Void avoid[])
                {
                    ab.b(c, a, b);
                    return null;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                c = ab.this;
                a = xmppobject;
                b = flag;
                super();
            }
            }).executeOnExecutor(j, new Void[0]);
            return;
        } else
        {
            a(xmppobject, flag);
            return;
        }
    }

    static void b(ab ab1, XMPPObject xmppobject, boolean flag)
    {
        ab1.a(xmppobject, flag);
    }

    private static boolean b(com.cyberlink.you.database.MessageObj.MessageType messagetype)
    {
        return ArrayUtils.indexOf(l, messagetype) != -1;
    }

    static Semaphore c(ab ab1)
    {
        return ab1.g;
    }

    static Object d(ab ab1)
    {
        return ab1.h;
    }

    static ThreadGroup h()
    {
        return i;
    }

    public void a(ad ad1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ad1 == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        k.add(ad1);
        this;
        JVM INSTR monitorexit ;
        return;
        ad1;
        this;
        JVM INSTR monitorexit ;
        throw ad1;
    }

    public void a(String s, String s1, Message message)
    {
label0:
        {
            synchronized (d)
            {
                if (e.isEmpty())
                {
                    com.cyberlink.you.a.a().a("XMPPQueue");
                }
                Iterator iterator = e.iterator();
                XMPPObject xmppobject;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    xmppobject = (XMPPObject)iterator.next();
                } while (!xmppobject.b.equals(XMPPObject.ContentType.b) || !xmppobject.d.equals(s1));
            }
            return;
        }
        e.add(new XMPPObject(s, s1, message));
        d.notify();
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(String s, List list)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        MessageObj messageobj;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); e.add(new XMPPObject(s, messageobj)))
        {
            messageobj = (MessageObj)iterator.next();
            if (e.isEmpty())
            {
                com.cyberlink.you.a.a().a("XMPPQueue");
            }
        }

        break MISSING_BLOCK_LABEL_81;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        d.notify();
        obj;
        JVM INSTR monitorexit ;
        list.clear();
        return;
    }

    protected void a(Message message, r r)
    {
        com.cyberlink.you.chat.d.a(message, r);
    }

    protected void b()
    {
        com.cyberlink.you.chat.n.a().a(m);
        com.cyberlink.you.chat.n.a().a(n);
        d();
    }

    public void b(ad ad1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ad1 == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        k.remove(ad1);
        this;
        JVM INSTR monitorexit ;
        return;
        ad1;
        this;
        JVM INSTR monitorexit ;
        throw ad1;
    }

    public void b(String s, String s1, Message message)
    {
        if (s == null || s1 == null || message == null)
        {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            (new AsyncTask(s, s1, message) {

                final String a;
                final String b;
                final Message c;
                final ab d;

                protected transient Void a(Void avoid[])
                {
                    d.a(a, b, c);
                    return null;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                d = ab.this;
                a = s;
                b = s1;
                c = message;
                super();
            }
            }).executeOnExecutor(j, new Void[0]);
            return;
        } else
        {
            a(s, s1, message);
            return;
        }
    }

    public void b(String s, List list)
    {
        if (list == null || list.size() == 0)
        {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            (new AsyncTask(s, list) {

                final String a;
                final List b;
                final ab c;

                protected transient Void a(Void avoid[])
                {
                    c.a(a, b);
                    return null;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                c = ab.this;
                a = s;
                b = list;
                super();
            }
            }).executeOnExecutor(j, new Void[0]);
            return;
        } else
        {
            a(s, list);
            return;
        }
    }

    public void c()
    {
        synchronized (d)
        {
            d.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        if (b)
        {
            return;
        } else
        {
            b = true;
            f = new Thread(new Runnable() {

                final ab a;

                public void run()
                {
                    Thread.currentThread().setName("Send Message");
                    com.cyberlink.you.chat.n.a();
                    Log.d("XMPPQueue", "Send Message Thread Enter");
_L5:
                    Object obj = com.cyberlink.you.chat.ab.a(a);
                    obj;
                    JVM INSTR monitorenter ;
                    com.cyberlink.you.chat.ab.a(a).wait(60000L);
_L6:
                    if (ab.b(a).size() <= 0) goto _L2; else goto _L1
_L1:
                    Object obj1 = (XMPPObject)ab.b(a).peek();
                    if (obj1 != null) goto _L4; else goto _L3
_L3:
                    Log.d("XMPPQueue", "Queue Empty");
_L2:
                    obj;
                    JVM INSTR monitorexit ;
                    Log.d("XMPPQueue", "Send Message Thread Loop");
                      goto _L5
_L4:
                    int i1;
                    if (!((XMPPObject) (obj1)).b.equals(com.cyberlink.you.chat.XMPPObject.ContentType.a))
                    {
                        break MISSING_BLOCK_LABEL_172;
                    }
                    i1 = com.cyberlink.you.chat.ab.a(a, ((XMPPObject) (obj1)));
                    if (i1 == 0)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    if (i1 != 1)
                    {
                        break MISSING_BLOCK_LABEL_164;
                    }
                    try
                    {
                        com.cyberlink.you.chat.ab.a(a).wait(1000L);
                        break; /* Loop/switch isn't completed */
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1) { }
                    finally { }
                    com.cyberlink.you.chat.ab.a(a, false);
                    ((InterruptedException) (obj1)).printStackTrace();
                      goto _L2
                    obj;
                    JVM INSTR monitorexit ;
                    throw obj1;
                    if (i1 != 2);
                      goto _L2
                    if (!((XMPPObject) (obj1)).b.equals(XMPPObject.ContentType.b))
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    i1 = ab.b(a, ((XMPPObject) (obj1)));
                    if (i1 != 1)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    com.cyberlink.you.chat.ab.a(a).wait(1000L);
                    break; /* Loop/switch isn't completed */
                    if (i1 != 4) goto _L6; else goto _L2
                }

            
            {
                a = ab.this;
                super();
            }
            });
            f.start();
            (new Thread(new Runnable() {

                final ab a;

                public void run()
                {
                    ab.b(a).clear();
                    Thread.currentThread().setName("Fill Message Queue");
                    Object obj = a.e().b();
                    if (obj != null)
                    {
                        obj = ((List) (obj)).iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break;
                            }
                            MessageObj messageobj = (MessageObj)((Iterator) (obj)).next();
                            if ((com.cyberlink.you.friends.l.c() - messageobj.d().getTime()) / 1000L < 3600L && com.cyberlink.you.chat.ab.a(messageobj.e()))
                            {
                                Log.d("XMPPQueue", (new StringBuilder()).append("Add ").append(messageobj.b()).toString());
                                Group group = a.f().a(messageobj.c());
                                if (group != null)
                                {
                                    ab.b(a).add(new XMPPObject(group.c, messageobj));
                                }
                            } else
                            if (!messageobj.j().equals("3"))
                            {
                                messageobj.c("3");
                                a.e().a(messageobj.b(), messageobj, "Status");
                            }
                        } while (true);
                        synchronized (com.cyberlink.you.chat.ab.a(a))
                        {
                            com.cyberlink.you.chat.ab.a(a).notify();
                        }
                        return;
                    } else
                    {
                        return;
                    }
                    exception;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                a = ab.this;
                super();
            }
            })).start();
            return;
        }
    }

    protected f e()
    {
        return com.cyberlink.you.e.d();
    }

    protected d f()
    {
        return com.cyberlink.you.e.f();
    }

    protected j g()
    {
        return com.cyberlink.you.e.j();
    }

    static 
    {
        j = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(ab.h(), runnable, (new StringBuilder()).append("Single AsyncTask #").append(a.getAndIncrement()).toString());
            }

        });
        l = (new com.cyberlink.you.database.MessageObj.MessageType[] {
            com.cyberlink.you.database.MessageObj.MessageType.b, com.cyberlink.you.database.MessageObj.MessageType.a, com.cyberlink.you.database.MessageObj.MessageType.c, com.cyberlink.you.database.MessageObj.MessageType.d, com.cyberlink.you.database.MessageObj.MessageType.i, com.cyberlink.you.database.MessageObj.MessageType.k
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.a;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.friends.q;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.d;
import org.jivesoftware.smack.i;
import org.jivesoftware.smack.j;
import org.jivesoftware.smack.packet.CLResumed;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.provider.h;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.tcp.c;
import org.jivesoftware.smack.util.a.b;
import org.jivesoftware.smackx.carbons.provider.CarbonManagerProvider;
import org.jivesoftware.smackx.delay.provider.DelayInfoProvider;
import org.jivesoftware.smackx.forward.provider.ForwardedProvider;
import org.jivesoftware.smackx.ping.PingManager;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.chat:
//            u, s, t, ab, 
//            af, p, o, r, 
//            z, v, aa, w, 
//            x, q, j

public class n
{

    private static boolean A = false;
    public static org.jivesoftware.smack.packet.Presence.Type a;
    public static boolean b = true;
    private static String e = null;
    private static String f = null;
    private static long g = 0L;
    private static SSLContext h = null;
    private static boolean i = false;
    private static Queue j = new ArrayDeque();
    private static String l = "";
    private static Thread m;
    private static XMPPConnection r = null;
    private static boolean t = false;
    private static List u;
    private static int v = 0;
    private static int w = 0;
    private static long x = 0L;
    private static int y = -1;
    private static Object z = new Object();
    d c;
    List d;
    private Object k;
    private u n;
    private org.jivesoftware.smackx.ping.a o;
    private z p;
    private v q;
    private List s;

    public n()
    {
        k = new Object();
        c = new d() {

            final n a;

            public void authenticated(XMPPConnection xmppconnection)
            {
                Log.d("XMPPManager", "authenticated");
                ULogUtility.a("authenticated", "XMPP Connection");
            }

            public void connected(XMPPConnection xmppconnection)
            {
                com.cyberlink.you.g.a().e(false);
                com.cyberlink.you.chat.n.a(a, true);
                Log.d("XMPPManager", "connected");
                ULogUtility.a("connected", "XMPP Connection");
            }

            public void connectionClosed()
            {
                com.cyberlink.you.g.a().e(true);
                com.cyberlink.you.chat.n.a = org.jivesoftware.smack.packet.Presence.Type.b;
                Log.w("XMPPManager", "connectionClosed");
                ULogUtility.a("connectionClosed", "XMPP Connection");
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[connectionClosed] is ui thread start");
                }
                com.cyberlink.you.chat.n.a(a, false);
                a.c();
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[connectionClosed] is ui thread end");
                }
            }

            public void connectionClosedOnError(Exception exception)
            {
                String s1 = (new StringBuilder()).append("connectionClosedOnError ").append(exception.getMessage()).toString();
                Log.w("XMPPManager", s1);
                ULogUtility.a(s1, "XMPP Connection");
                com.cyberlink.you.chat.n.a(a, false);
                com.cyberlink.you.g.a().e(true);
                com.cyberlink.you.chat.n.a = org.jivesoftware.smack.packet.Presence.Type.b;
                if (com.cyberlink.you.a.a() == null || !com.cyberlink.you.a.a().c() || !(exception instanceof org.jivesoftware.smack.XMPPException.StreamErrorException) || !"conflict".equals(((org.jivesoftware.smack.XMPPException.StreamErrorException)exception).a().a())) goto _L2; else goto _L1
_L1:
                exception = com.cyberlink.you.chat.n.a(a);
                if (exception == null || !exception.equals("LOGOUT")) goto _L2; else goto _L3
_L3:
                com.cyberlink.you.g.a().v();
_L5:
                return;
_L2:
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[connectionClosedOnError] is ui thread start");
                }
                a.c();
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[connectionClosedOnError] is ui thread end");
                    return;
                }
                if (true) goto _L5; else goto _L4
_L4:
            }

            public void reconnectingIn(int i1)
            {
                if (i1 <= 1)
                {
                    String s1 = (new StringBuilder()).append("reconnectingIn ").append(i1).append(" seconds").toString();
                    Log.d("XMPPManager", s1);
                    ULogUtility.a(s1, "XMPP Connection");
                }
            }

            public void reconnectionFailed(Exception exception)
            {
                com.cyberlink.you.g.a().e(true);
                com.cyberlink.you.chat.n.a = org.jivesoftware.smack.packet.Presence.Type.b;
                String s2 = (new StringBuilder()).append("reconnectionFailed. ").append(exception.toString()).toString();
                String s1 = s2;
                if (exception instanceof org.jivesoftware.smack.SmackException.ConnectionException)
                {
                    exception = (org.jivesoftware.smack.SmackException.ConnectionException)exception;
                    s1 = (new StringBuilder()).append(s2).append(" ").append(exception.a()).toString();
                }
                Log.w("XMPPManager", s1);
                ULogUtility.a(s1, "XMPP Connection");
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[reconnectionFailed] is ui thread start");
                }
                com.cyberlink.you.chat.n.a(a, false);
                a.c();
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[reconnectionFailed] is ui thread end");
                }
            }

            public void reconnectionSuccessful()
            {
                com.cyberlink.you.g.a().e(false);
                com.cyberlink.you.chat.n.a(a, true);
                Log.d("XMPPManager", "reconnectionSuccessful");
                ULogUtility.a("reconnectionSuccessful", "XMPP Connection");
            }

            
            {
                a = n.this;
                super();
            }
        };
        n = new u();
        o = new org.jivesoftware.smackx.ping.a() {

            final n a;

            public void a()
            {
                ULogUtility.a("ping failed", "XMPP Connection");
                Log.e("XMPPManager", "PingManager reported failed ping");
                if (com.cyberlink.you.chat.n.l() == null)
                {
                    break MISSING_BLOCK_LABEL_27;
                }
                com.cyberlink.you.chat.n.l().r();
                return;
                org.jivesoftware.smack.SmackException.NotConnectedException notconnectedexception;
                notconnectedexception;
                Log.d("XMPPManager", "NotConnectedException");
                return;
            }

            
            {
                a = n.this;
                super();
            }
        };
        p = new z() {

            final n a;

            public void a(Presence presence)
            {
                com.cyberlink.you.chat.n.a(a, presence);
            }

            
            {
                a = n.this;
                super();
            }
        };
        q = new v() {

            final n a;

            public void a(CLResumed clresumed)
            {
                com.cyberlink.you.chat.n.a(a, clresumed);
            }

            
            {
                a = n.this;
                super();
            }
        };
        s = new ArrayList();
        d = new ArrayList();
        org.jivesoftware.smack.provider.h.a("request", (new DeliveryReceiptRequest()).b(), new org.jivesoftware.smackx.receipts.DeliveryReceiptRequest.Provider());
        org.jivesoftware.smack.provider.h.a("received", "urn:xmpp:receipts", new org.jivesoftware.smackx.receipts.DeliveryReceipt.Provider());
        org.jivesoftware.smack.provider.h.a("delay", "urn:xmpp:delay", new DelayInfoProvider());
        org.jivesoftware.smack.provider.h.a("forwarded", "urn:xmpp:forward:0", new ForwardedProvider());
        org.jivesoftware.smack.provider.h.a("sent", "urn:xmpp:carbons:2", new CarbonManagerProvider());
        org.jivesoftware.smack.provider.h.a("received", "urn:xmpp:carbons:2", new CarbonManagerProvider());
        org.jivesoftware.smack.provider.h.a("result", "urn:xmpp:mam:tmp", new ExtensionProviderUtils.resultExtensionProvider());
        org.jivesoftware.smack.provider.h.a("result", "urn:xmpp:mam:0", new ExtensionProviderUtils.resultExtensionProvider());
        org.jivesoftware.smack.provider.h.a("message", "urn:xmpp:forward:0", new ExtensionProviderUtils.archiveMsgExtensionProvider());
        org.jivesoftware.smack.provider.h.a("event", "urn:xmpp:custom:event", new ExtensionProviderUtils.EventExtensionProvider());
        org.jivesoftware.smack.provider.h.a("textReply", "urn:xmpp:textreply:0", new ExtensionProviderUtils.ReplyMessageExtensionProvider());
        org.jivesoftware.smack.provider.h.a("post", "U", new ExtensionProviderUtils.BCPostExtensionProvider());
        n.a(q);
        n.a(p);
    }

    static long a(long l1)
    {
        g = l1;
        return l1;
    }

    static Pair a(n n1, String s1, String s2, boolean flag)
    {
        return n1.a(s1, s2, flag);
    }

    private Pair a(String s1, String s2, boolean flag)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[doAuthenticate2XMPPServer] is ui thread start");
        }
        d("doAuthenticate2XMPPServer step 1");
        Object obj1 = z;
        obj1;
        JVM INSTR monitorenter ;
        d("doAuthenticate2XMPPServer step 2");
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[doAuthenticate2XMPPServer] is ui thread end");
        }
        if (r == null || flag)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        d("doAuthenticate2XMPPServer exit 2 (has connection)");
        s1 = new Pair(Boolean.valueOf(true), "Has connection");
        obj1;
        JVM INSTR monitorexit ;
        return s1;
        Object obj;
        e = s1;
        f = s2;
        d("doAuthenticate2XMPPServer step 3");
        long l1 = System.currentTimeMillis();
        obj = u();
        long l4 = System.currentTimeMillis();
        d((new StringBuilder()).append("doAuthenticate2XMPPServer step 4. ").append(l4 - l1).append(" ms").toString());
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        d("doAuthenticate2XMPPServer exit 4 (Server Info is null)");
        s1 = new Pair(Boolean.valueOf(false), "Server Info is null");
        obj1;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        obj1;
        JVM INSTR monitorexit ;
        throw s1;
        String s3;
        Object obj2;
        Object obj3;
        StringBuilder stringbuilder;
        int i1;
        obj2 = ((s) (obj)).a;
        i1 = ((s) (obj)).b;
        s3 = ((s) (obj)).c;
        flag = ((s) (obj)).d;
        d("doAuthenticate2XMPPServer step 5");
        long l2 = System.currentTimeMillis();
        obj3 = com.cyberlink.you.friends.l.a("chat", "xmpp.domain");
        long l5 = System.currentTimeMillis();
        d((new StringBuilder()).append("doAuthenticate2XMPPServer step 6. ").append(l5 - l2).append(" ms").toString());
        stringbuilder = (new StringBuilder()).append(((String) (obj2))).append(":").append(i1).append(" (").append(s3).append(")");
        Object obj4;
        if (flag)
        {
            obj = "+ TLS";
        } else
        {
            obj = "- No TLS";
        }
        obj = stringbuilder.append(((String) (obj))).toString();
        d((new StringBuilder()).append("XMPP connect ").append(((String) (obj))).toString());
        if (obj2 != null && obj3 != null)
        {
            break MISSING_BLOCK_LABEL_410;
        }
        d("doAuthenticate2XMPPServer exit 6");
        s1 = new Pair(Boolean.valueOf(false), "host or service is null");
        obj1;
        JVM INSTR monitorexit ;
        return s1;
        if (!i)
        {
            long l3 = System.currentTimeMillis();
            org.jivesoftware.smack.j.a(10000);
            long l6 = System.currentTimeMillis();
            d((new StringBuilder()).append("Smack version: ").append(org.jivesoftware.smack.j.a()).toString());
            d((new StringBuilder()).append("Smack Initialize Latency = ").append(l6 - l3).append(" ms").toString());
            i = true;
        }
        obj2 = new ConnectionConfiguration(((String) (obj2)), i1, ((String) (obj3)));
        if (flag) goto _L2; else goto _L1
_L1:
        ((ConnectionConfiguration) (obj2)).a(org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.c);
_L3:
        ((ConnectionConfiguration) (obj2)).a(true);
        ((ConnectionConfiguration) (obj2)).c(true);
        ((ConnectionConfiguration) (obj2)).b(false);
        org.jivesoftware.smack.i.a("PLAIN", 0);
        s2 = new Callable(((String) (obj)), s1, new c(((ConnectionConfiguration) (obj2))), s2) {

            final String a;
            final String b;
            final c c;
            final String d;
            final n e;

            public Pair a()
            {
                Thread.currentThread().setName("XMPP Auth Callable");
                String s4;
                com.cyberlink.you.chat.n.b((new StringBuilder()).append("Connect to (").append(n.m()).append(") ").append(a).append(" by ").append(b).toString());
                com.cyberlink.you.chat.n.a(System.currentTimeMillis());
                c.h();
                com.cyberlink.you.chat.n.a(e, c);
                com.cyberlink.you.chat.n.b("Connected");
                s4 = com.cyberlink.you.chat.n.c(e);
                c.d(s4);
                if (s4 != null) goto _L2; else goto _L1
_L1:
                c.a(b, d, com.cyberlink.you.g.a().i());
                com.cyberlink.you.chat.n.b((new StringBuilder()).append("Login as ").append(c.e()).toString());
_L3:
                com.cyberlink.you.g.a().c(c.e());
                e.a(c);
                e.a(b);
                e.g();
                com.cyberlink.you.chat.j.a();
                com.cyberlink.you.chat.j.b();
                com.cyberlink.you.g.a().e(false);
                com.cyberlink.you.chat.n.c(true);
                com.cyberlink.you.chat.n.b("Auth complete");
                Object obj5;
                s4 = "Success";
                obj5 = Boolean.valueOf(true);
_L4:
                return new Pair(obj5, s4);
_L2:
                c.c(b, d, com.cyberlink.you.g.a().i());
                com.cyberlink.you.chat.n.b((new StringBuilder()).append("Resume as ").append(c.e()).toString());
                  goto _L3
                Object obj6;
                obj6;
                Log.w("XMPPManager", (new StringBuilder()).append("Connect Fail, spent ").append(System.currentTimeMillis() - n.n()).append(" ms").toString());
                com.cyberlink.you.chat.n.b(((Exception) (obj6)).toString());
                s4 = ((Exception) (obj6)).toString();
                if (obj6 instanceof org.jivesoftware.smack.SmackException.ConnectionException)
                {
                    obj6 = (org.jivesoftware.smack.SmackException.ConnectionException)obj6;
                    com.cyberlink.you.chat.n.b(((org.jivesoftware.smack.SmackException.ConnectionException) (obj6)).a().toString());
                    for (int j1 = 0; j1 < ((org.jivesoftware.smack.SmackException.ConnectionException) (obj6)).a().size(); j1++)
                    {
                        com.cyberlink.you.chat.n.b(((b)((org.jivesoftware.smack.SmackException.ConnectionException) (obj6)).a().get(j1)).c().toString());
                    }

                } else
                if (obj6 instanceof SASLErrorException)
                {
                    Object obj7 = ((SASLErrorException)obj6).a();
                    if (obj7 != null)
                    {
                        obj7 = ((org.jivesoftware.smack.sasl.SASLMechanism.SASLFailure) (obj7)).a();
                        if (obj7 != null && ((String) (obj7)).contains("not-authorized") && com.cyberlink.you.chat.n.d(e))
                        {
                            com.cyberlink.you.chat.n.c(false);
                            com.cyberlink.you.chat.n.b("Log out");
                            s4 = "Force Logout";
                        }
                    }
                }
                n.o();
                com.cyberlink.you.chat.n.a().a(null);
                com.cyberlink.you.chat.n.a().a("");
                obj6 = Boolean.valueOf(false);
                  goto _L4
            }

            public Object call()
            {
                return a();
            }

            
            {
                e = n.this;
                a = s1;
                b = s2;
                c = c1;
                d = s3;
                super();
            }
        };
        s1 = Executors.newCachedThreadPool();
        s2 = new FutureTask(s2);
        s1.execute(s2);
        s1 = (Pair)s2.get(15L, TimeUnit.SECONDS);
        d((new StringBuilder()).append("doAuth = ").append(((Pair) (s1)).first).append(" ").append((String)((Pair) (s1)).second).toString());
        obj1;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        obj3 = h;
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_753;
        }
        h = SSLContext.getInstance("TLS");
        if (h != null)
        {
            h.init(null, null, new SecureRandom());
            h.getClientSessionContext().setSessionTimeout(0x15180);
            ((ConnectionConfiguration) (obj2)).a(h);
        }
_L4:
        if (!s3.equalsIgnoreCase("tls"))
        {
            break MISSING_BLOCK_LABEL_764;
        }
        ((ConnectionConfiguration) (obj2)).a(org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.d);
          goto _L3
        obj4;
        ((NoSuchAlgorithmException) (obj4)).printStackTrace();
          goto _L4
        obj4;
        ((KeyManagementException) (obj4)).printStackTrace();
          goto _L4
        ((ConnectionConfiguration) (obj2)).a(h);
          goto _L4
        ((ConnectionConfiguration) (obj2)).a(org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.b);
          goto _L3
        s1;
        s2 = s1.toString();
        if (s1 instanceof TimeoutException)
        {
            v++;
        }
        d((new StringBuilder()).append("doAuth ").append(s1.toString()).toString());
        s1 = new Pair(Boolean.valueOf(false), s2);
        obj1;
        JVM INSTR monitorexit ;
        return s1;
    }

    public static n a()
    {
        return com.cyberlink.you.chat.t.a();
    }

    static String a(n n1)
    {
        return n1.p();
    }

    static void a(n n1, XMPPConnection xmppconnection)
    {
        n1.b(xmppconnection);
    }

    static void a(n n1, CLResumed clresumed)
    {
        n1.a(clresumed);
    }

    static void a(n n1, Presence presence)
    {
        n1.a(presence);
    }

    static void a(n n1, boolean flag)
    {
        n1.d(flag);
    }

    private void a(CLResumed clresumed)
    {
        Log.i("Auth", (new StringBuilder()).append("CLResumed: ").append(clresumed.c()).append(" expiration=").append(clresumed.e()).append(" time=").append(String.valueOf(System.currentTimeMillis() - g)).toString());
        Log.i("Auth", "-------------------------------------------------------------------");
        if (clresumed.c().equals("success"))
        {
            c((new StringBuilder()).append("Connected to server, it costs ").append(String.valueOf(System.currentTimeMillis() - g)).append(" milliseconds").toString());
            com.cyberlink.you.g.a().f(clresumed.d());
            if (r != null && (r instanceof c))
            {
                ((c)r).d(clresumed.d());
            }
            com.cyberlink.you.g.a().e(clresumed.e());
            com.cyberlink.you.g.a().f(System.currentTimeMillis());
            return;
        }
        com.cyberlink.you.g.a().f(null);
        com.cyberlink.you.g.a().e(0L);
        com.cyberlink.you.g.a().f(0L);
        try
        {
            ((c)r).c(false);
            r.a(e, f, com.cyberlink.you.g.a().i());
            return;
        }
        catch (Exception exception)
        {
            clresumed = (new StringBuilder()).append(exception.toString()).append(". Failed to connect or login as ").append(e).toString();
            if (exception instanceof org.jivesoftware.smack.SmackException.ConnectionException)
            {
                org.jivesoftware.smack.SmackException.ConnectionException connectionexception = (org.jivesoftware.smack.SmackException.ConnectionException)exception;
                clresumed = (new StringBuilder()).append(clresumed).append(" ").append(connectionexception.a()).toString();
                for (int i1 = 0; i1 < connectionexception.a().size(); i1++)
                {
                    Log.v("Auth", ((b)connectionexception.a().get(i1)).c().toString());
                }

            }
            Log.e("Auth", clresumed);
            c(clresumed);
            clresumed = exception.getMessage();
        }
        if (clresumed != null && clresumed.contains("not-authorized"))
        {
            A = false;
        }
        a().a(((XMPPConnection) (null)));
        a().a("");
    }

    private void a(Presence presence)
    {
        Log.d("XMPPManager", (new StringBuilder()).append("Presense packet: ").append(presence.toString()).toString());
        if (presence.s().equals(com.cyberlink.you.g.a().j()))
        {
            a = presence.a();
        }
        if (a == org.jivesoftware.smack.packet.Presence.Type.a)
        {
            com.cyberlink.you.chat.ab.a().c();
            com.cyberlink.you.chat.af.a().b();
        }
    }

    static boolean a(n n1, e e1)
    {
        return n1.a(e1);
    }

    private boolean a(e e1)
    {
        if (r == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        Message message;
        Date date;
        if (!(e1 instanceof Message))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        message = (Message)e1;
        date = message.j();
        if (date == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        Date date1 = new Date((new Date()).getTime() + l.e);
        Log.v("XMPPManager", (new StringBuilder()).append("Message Sending Time Diff = ").append(date1.getTime() - date.getTime()).append(" ms").toString());
        message.b(date1);
        r.b(e1);
        ULogUtility.a((new StringBuilder()).append("U Token=").append(com.cyberlink.you.g.a().e()).append("; ").append(e1.g().toString()).toString(), "Send");
        return true;
        org.jivesoftware.smack.SmackException.NotConnectedException notconnectedexception;
        notconnectedexception;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("Packet not send by exception:\n");
        stringbuffer.append("Packet = ").append(e1.g().toString()).append("\n");
        stringbuffer.append(Log.getStackTraceString(notconnectedexception));
        ULogUtility.a(stringbuffer.toString(), "Send");
        return false;
    }

    static u b(n n1)
    {
        return n1.n;
    }

    static void b(String s1)
    {
        d(s1);
    }

    private void b(XMPPConnection xmppconnection)
    {
        if (xmppconnection != null)
        {
            xmppconnection.a(n, null);
        }
    }

    static boolean b(boolean flag)
    {
        t = flag;
        return flag;
    }

    static String c(n n1)
    {
        return n1.v();
    }

    private void c(String s1)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((p)iterator.next()).a(s1)) { }
    }

    static boolean c(boolean flag)
    {
        A = flag;
        return flag;
    }

    private static void d(String s1)
    {
        s1 = (new StringBuilder()).append(s1).append(" (Thread=").append(Thread.currentThread().getId()).append(",").append(Thread.currentThread().getName()).append(")").toString();
        Log.d("Auth", s1);
        ULogUtility.a(s1, "XMPP Connection");
    }

    private void d(boolean flag)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[passConnectionChangedToListener] is ui thread start");
        }
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[passConnectionChangedToListener] is ui thread end");
        }
        iterator = s.iterator();
_L1:
        o o1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        o1 = (o)iterator.next();
        o1.a(flag);
          goto _L1
        Exception exception1;
        exception1;
        d(exception1.toString());
        exception1.printStackTrace();
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    static boolean d(n n1)
    {
        return n1.q();
    }

    private Pair e(boolean flag)
    {
        String s1 = com.cyberlink.you.g.a().e();
        String s2 = com.cyberlink.you.g.a().f();
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
        {
            return new Pair(Boolean.valueOf(false), "No JID or Token");
        } else
        {
            return a(s2, s1, flag);
        }
    }

    static XMPPConnection l()
    {
        return r;
    }

    static int m()
    {
        return v;
    }

    static long n()
    {
        return g;
    }

    static int o()
    {
        int i1 = v;
        v = i1 + 1;
        return i1;
    }

    private String p()
    {
        Object obj = new l();
        String s1 = com.cyberlink.you.g.a().e();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", s1));
        obj = ((l) (obj)).a("user", "userStatus", arraylist);
        if (obj != null)
        {
            Log.d("XMPPManager", (new StringBuilder()).append("[UserStatus] statuscode=").append((String)((Pair) (obj)).first).append(" result=").append((String)((Pair) (obj)).second).toString());
        } else
        {
            Log.d("XMPPManager", "[UserStatus] no response.");
        }
        if (obj != null && ((Pair) (obj)).first != null && ((String)((Pair) (obj)).first).equals("200") && ((Pair) (obj)).second != null)
        {
            return com.cyberlink.you.utility.h.d(com.cyberlink.you.utility.h.a((String)((Pair) (obj)).second));
        } else
        {
            return null;
        }
    }

    private boolean q()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (com.cyberlink.you.a.a() == null)
            {
                break label0;
            }
            flag = flag1;
            if (!com.cyberlink.you.a.a().c())
            {
                break label0;
            }
            String s1 = p();
            flag = flag1;
            if (s1 == null)
            {
                break label0;
            }
            if (!s1.equals("LOGOUT"))
            {
                flag = flag1;
                if (!s1.equals("401"))
                {
                    break label0;
                }
            }
            flag = true;
            com.cyberlink.you.g.a().v();
        }
        return flag;
    }

    private Boolean r()
    {
        if (t)
        {
            Log.d("XMPPManager", "already connecting...");
            return Boolean.valueOf(false);
        }
        Object obj1 = new Callable() {

            final n a;

            public Boolean a()
            {
                Boolean boolean1;
                com.cyberlink.you.chat.n.b(true);
                Thread.currentThread().setName("connect");
                boolean1 = Boolean.valueOf(false);
                com.cyberlink.you.chat.n.a(System.currentTimeMillis());
                com.cyberlink.you.chat.n.l().h();
                a.g();
                com.cyberlink.you.chat.n.b(false);
                return Boolean.valueOf(true);
                Object obj2;
                obj2;
                Log.e("XMPPManager", (new StringBuilder()).append("[connect] ConnectionException: ").append(((org.jivesoftware.smack.SmackException.ConnectionException) (obj2)).a()).toString());
                int i1 = 0;
_L2:
                if (i1 >= ((org.jivesoftware.smack.SmackException.ConnectionException) (obj2)).a().size())
                {
                    break; /* Loop/switch isn't completed */
                }
                Log.e("XMPPManager", ((b)((org.jivesoftware.smack.SmackException.ConnectionException) (obj2)).a().get(i1)).c().toString());
                i1++;
                if (true) goto _L2; else goto _L1
_L1:
                com.cyberlink.you.chat.n.b(false);
                return boolean1;
                obj2;
                Log.e("XMPPManager", (new StringBuilder()).append("[connect] Exception: ").append(((Exception) (obj2)).getMessage()).toString());
                com.cyberlink.you.chat.n.b(false);
                return boolean1;
                Exception exception1;
                exception1;
                com.cyberlink.you.chat.n.b(false);
                throw exception1;
            }

            public Object call()
            {
                return a();
            }

            
            {
                a = n.this;
                super();
            }
        };
        Object obj = Executors.newFixedThreadPool(1);
        obj1 = new FutureTask(((Callable) (obj1)));
        ((ExecutorService) (obj)).execute(((Runnable) (obj1)));
        try
        {
            obj = (Boolean)((FutureTask) (obj1)).get(10L, TimeUnit.SECONDS);
            Log.d("XMPPManager", (new StringBuilder()).append("ret = ").append(obj).toString());
        }
        catch (Exception exception)
        {
            t = false;
            exception.printStackTrace();
            return Boolean.valueOf(false);
        }
        return ((Boolean) (obj));
    }

    private static void s()
    {
        boolean flag = false;
        com/cyberlink/you/chat/n;
        JVM INSTR monitorenter ;
        long l1;
        l1 = System.currentTimeMillis();
        d("UpdateServerList");
        com.cyberlink.you.friends.l.e();
        u = new ArrayList();
        if (!u.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = com.cyberlink.you.friends.l.a("chat", "xmpp.serversV2");
        if (obj == null) goto _L2; else goto _L3
_L3:
        JSONArray jsonarray;
        jsonarray = new JSONArray(((String) (obj)));
        d(jsonarray.toString());
        int i1 = 0;
_L17:
        if (i1 >= jsonarray.length()) goto _L2; else goto _L4
_L4:
        Object obj2 = jsonarray.getJSONObject(i1);
        if (obj2 == null) goto _L6; else goto _L5
_L5:
        d((new StringBuilder()).append("V2 ").append(((JSONObject) (obj2)).getString("server")).append(":").append(((JSONObject) (obj2)).getInt("port")).toString());
        obj2 = new s(((JSONObject) (obj2)).getString("server"), ((JSONObject) (obj2)).getInt("port"), ((JSONObject) (obj2)).getString("type"), ((JSONObject) (obj2)).getBoolean("tlsRequired"));
        if (u.contains(obj2)) goto _L8; else goto _L7
_L7:
        u.add(obj2);
          goto _L6
_L8:
        Log.d("Auth", "dupliate server !");
          goto _L6
        JSONException jsonexception;
        jsonexception;
        d((new StringBuilder()).append("Parse ").append(((String) (obj))).append(" failed").toString());
_L2:
        if (u.size() != 0) goto _L10; else goto _L9
_L9:
        obj = com.cyberlink.you.friends.l.a("chat", "xmpp.servers");
        if (obj == null) goto _L10; else goto _L11
_L11:
        jsonexception = new JSONArray(((String) (obj)));
        d(jsonexception.toString());
        i1 = ((flag) ? 1 : 0);
_L18:
        if (i1 >= jsonexception.length()) goto _L10; else goto _L12
_L12:
        obj2 = jsonexception.getJSONObject(i1);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_692;
        }
        d((new StringBuilder()).append("V1 ").append(((JSONObject) (obj2)).getString("server")).append(":").append(((JSONObject) (obj2)).getInt("port")).toString());
        obj2 = new s(((JSONObject) (obj2)).getString("server"), ((JSONObject) (obj2)).getInt("port"));
        if (!u.contains(obj2))
        {
            u.add(obj2);
            break MISSING_BLOCK_LABEL_692;
        }
        Object obj1;
        long l2;
        try
        {
            Log.d("Auth", "dupliate server !");
            break MISSING_BLOCK_LABEL_692;
        }
        catch (JSONException jsonexception1) { }
        finally
        {
            throw exception;
        }
        d((new StringBuilder()).append("Parse ").append(((String) (obj))).append(" failed").toString());
_L10:
        if (u.size() != 0) goto _L14; else goto _L13
_L13:
        obj = com.cyberlink.you.friends.l.a("chat", "xmpp.server");
        if (obj == null) goto _L14; else goto _L15
_L15:
        obj1 = com.cyberlink.you.friends.l.a("chat", "xmpp.port");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_550;
        }
        i1 = NumberUtils.toInt(((String) (obj1)), 443);
        d((new StringBuilder()).append("V0 ").append(((String) (obj))).append(":").append(i1).toString());
        obj1 = new s(((String) (obj)), i1);
        if (!u.contains(obj1))
        {
            u.add(obj1);
        }
        obj1 = com.cyberlink.you.friends.l.a("chat", "xmpp.standardPort");
        if (obj1 == null) goto _L14; else goto _L16
_L16:
        i1 = NumberUtils.toInt(((String) (obj1)), 5222);
        d((new StringBuilder()).append("O ").append(((String) (obj))).append(":").append(i1).toString());
        obj = new s(((String) (obj)), i1);
        if (!u.contains(obj))
        {
            u.add(obj);
        }
_L14:
        l2 = System.currentTimeMillis();
        d((new StringBuilder()).append("UpdateServerList done ").append(l2 - l1).append(" ms").toString());
        com/cyberlink/you/chat/n;
        JVM INSTR monitorexit ;
        return;
_L6:
        i1++;
          goto _L17
        i1++;
          goto _L18
    }

    private void t()
    {
        long l1 = System.currentTimeMillis() - x;
        if (l1 >= 30000L)
        {
            x = 0L;
            return;
        }
        try
        {
            d((new StringBuilder()).append("waiting for next server list update, ").append((30000L - l1) / 1000L).append("s").toString());
            Thread.sleep(5000L);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    private s u()
    {
        long l1 = System.currentTimeMillis();
        d("getXMPPServer");
        if (x == 0L || System.currentTimeMillis() - x > 0x5265c00L)
        {
            x = System.currentTimeMillis();
            s();
            v = 0;
            w = 0;
        }
        if (u == null || u.isEmpty())
        {
            d("ServerList is empty");
            t();
            long l2 = System.currentTimeMillis();
            d((new StringBuilder()).append("getXMPPServer exit a ").append(l2 - l1).append(" ms").toString());
            return null;
        }
        if (v >= u.size() || (long)v >= 10L)
        {
            w++;
            if ((long)w >= 3L)
            {
                d("Tried 3 times");
                t();
                long l3 = System.currentTimeMillis();
                d((new StringBuilder()).append("getXMPPServer exit b ").append(l3 - l1).append(" ms").toString());
                return null;
            }
            v = 0;
        }
        s s2 = (s)u.get(v);
        s s1 = s2;
        if (y >= 0)
        {
            s1 = s2;
            if (y < u.size())
            {
                s1 = (s)u.get(y);
            }
        }
        long l4 = System.currentTimeMillis();
        d((new StringBuilder()).append("getXMPPServer done ").append(l4 - l1).append(" ms").toString());
        return s1;
    }

    private String v()
    {
        String s1;
label0:
        {
            long l1 = com.cyberlink.you.g.a().E();
            long l2 = com.cyberlink.you.g.a().F();
            if (l2 != 0L && l1 * 1000L + l2 >= System.currentTimeMillis())
            {
                s1 = com.cyberlink.you.g.a().D();
                if (s1 == null || s1.length() != 0)
                {
                    break label0;
                }
            }
            return null;
        }
        return s1;
    }

    public Pair a(boolean flag)
    {
        if (!com.cyberlink.you.friends.l.a() && !com.cyberlink.you.friends.l.e())
        {
            return new Pair(Boolean.valueOf(false), "Init fail");
        } else
        {
            return e(flag);
        }
    }

    public void a(int i1)
    {
        y = i1;
    }

    public void a(aa aa)
    {
        if (n != null)
        {
            n.a(aa);
        }
    }

    public void a(o o1)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[addCLXMPPConnectionListener] is ui thread start");
        }
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[addCLXMPPConnectionListener] is ui thread end");
        }
        if (o1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s.add(o1);
        obj;
        JVM INSTR monitorexit ;
        return;
        o1;
        obj;
        JVM INSTR monitorexit ;
        throw o1;
    }

    public void a(p p1)
    {
        d.add(p1);
    }

    public void a(w w1)
    {
        if (n != null)
        {
            n.a(w1);
        }
    }

    public void a(x x1)
    {
        if (n != null)
        {
            n.a(x1);
        }
    }

    public void a(String s1)
    {
        l = s1;
    }

    public void a(String s1, String s2, boolean flag, com.cyberlink.you.chat.q q1)
    {
        if (com.cyberlink.you.friends.l.a())
        {
            (new Thread(s1, s2, flag, q1) {

                final String a;
                final String b;
                final boolean c;
                final com.cyberlink.you.chat.q d;
                final n e;

                public void run()
                {
                    Thread.currentThread().setName("XMPP Auth");
                    Pair pair = com.cyberlink.you.chat.n.a(e, a, b, c);
                    if (((Boolean)pair.first).booleanValue())
                    {
                        if (d != null)
                        {
                            d.a();
                        }
                    } else
                    if (d != null)
                    {
                        d.a((String)pair.second);
                        return;
                    }
                }

            
            {
                e = n.this;
                a = s1;
                b = s2;
                c = flag;
                d = q1;
                super();
            }
            }).start();
            return;
        } else
        {
            com.cyberlink.you.friends.l.a(com.cyberlink.you.g.a().e(), new q(s1, s2, flag, q1) {

                final String a;
                final String b;
                final boolean c;
                final com.cyberlink.you.chat.q d;
                final n e;

                public void a()
                {
                    Pair pair = com.cyberlink.you.chat.n.a(e, a, b, c);
                    if (((Boolean)pair.first).booleanValue())
                    {
                        if (d != null)
                        {
                            d.a();
                        }
                    } else
                    if (d != null)
                    {
                        d.a((String)pair.second);
                        return;
                    }
                }

                public void b()
                {
                    if (d != null)
                    {
                        d.a("LoadCommandUrl failed");
                    }
                }

            
            {
                e = n.this;
                a = s1;
                b = s2;
                c = flag;
                d = q1;
                super();
            }
            }, true);
            return;
        }
    }

    public void a(List list, String s1)
    {
        if (n != null)
        {
            n.a(list, s1);
        }
    }

    public void a(List list, String s1, boolean flag)
    {
        if (n != null)
        {
            n.a(list, s1, flag);
        }
    }

    public void a(XMPPConnection xmppconnection)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("setXMPPConnection = ");
        String s1;
        if (xmppconnection == null)
        {
            s1 = "null";
        } else
        {
            s1 = xmppconnection.toString();
        }
        Log.d("XMPPManager", stringbuilder.append(s1).toString());
        r = xmppconnection;
        if (r != null)
        {
            r.a(c);
            xmppconnection = PingManager.a(xmppconnection);
            if (xmppconnection != null)
            {
                xmppconnection.a(30);
                xmppconnection.a(o);
            }
        }
        d(d());
    }

    public void a(e e1, r r1)
    {
        if (r != null) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        ULogUtility.a("Message not send by no xmpp connection!!", "Send");
        s1 = com.cyberlink.you.g.a().e();
        s2 = com.cyberlink.you.g.a().f();
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) goto _L4; else goto _L3
_L3:
        a(s2, s1, false, new com.cyberlink.you.chat.q(e1, r1) {

            final e a;
            final r b;
            final n c;

            public void a()
            {
                if (com.cyberlink.you.chat.n.a(c, a))
                {
                    Log.d("XMPPManager", "connect and send success.");
                    if (b != null)
                    {
                        b.a();
                    }
                } else
                {
                    Log.d("XMPPManager", "connect success and send fail.");
                    if (b != null)
                    {
                        b.b();
                        return;
                    }
                }
            }

            public void a(String s3)
            {
                Log.d("XMPPManager", (new StringBuilder()).append("connect fail. ").append(s3).toString());
                if (b != null)
                {
                    b.b();
                }
            }

            
            {
                c = n.this;
                a = e1;
                b = r1;
                super();
            }
        });
_L6:
        return;
_L4:
        Log.d("XMPPManager", "does not register.");
        if (r1 != null)
        {
            r1.b();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!r.f())
        {
            Boolean boolean1 = r();
            Log.d("XMPPManager", (new StringBuilder()).append("connect: ").append(boolean1).toString());
        }
        if (!a(e1))
        {
            break; /* Loop/switch isn't completed */
        }
        Log.d("XMPPManager", "send success.");
        if (r1 != null)
        {
            r1.a();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        Log.d("XMPPManager", "send fail.");
        if (r1 != null)
        {
            r1.b();
            return;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public boolean a(org.jivesoftware.smack.packet.Presence.Type type)
    {
        Log.i("XMPPManager", (new StringBuilder()).append("setPresence: ").append(type.toString()).toString());
        return a(((e) (new Presence(type))));
    }

    public String b()
    {
        return l;
    }

    public void b(aa aa)
    {
        if (n != null)
        {
            n.b(aa);
        }
    }

    public void b(o o1)
    {
        Object obj;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[removeCLXMPPConnectionListener] is ui thread start");
        } else
        {
            Log.d("LockTesting", "[removeCLXMPPConnectionListener] is not ui thread start");
        }
        obj = k;
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto _L2; else goto _L1
_L1:
        Log.d("LockTesting", "[removeCLXMPPConnectionListener] is ui thread end");
_L4:
        if (o1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s.remove(o1);
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        Log.d("LockTesting", "[removeCLXMPPConnectionListener] is not ui thread end");
        if (true) goto _L4; else goto _L3
_L3:
        o1;
        obj;
        JVM INSTR monitorexit ;
        throw o1;
    }

    public void b(w w1)
    {
        if (n != null)
        {
            n.b(w1);
        }
    }

    protected void c()
    {
        this;
        JVM INSTR monitorenter ;
        ULogUtility.a("re-connect", "XMPP Connection");
        if (b) goto _L2; else goto _L1
_L1:
        d("don't need re-connect");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (m == null || !m.isAlive())
        {
            break MISSING_BLOCK_LABEL_55;
        }
        d("re-connect thread is alive");
          goto _L3
        Exception exception;
        exception;
        throw exception;
        m = new Thread() {

            final n a;

            public void run()
            {
                int i1;
                int l1;
                i1 = 0;
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                l1 = random.nextInt(3);
                com.cyberlink.you.chat.n.b("Reconnect Thread, enter");
_L4:
                int k1;
label0:
                {
                    if (com.cyberlink.you.chat.n.l() != null && !com.cyberlink.you.chat.n.l().f() && com.cyberlink.you.a.a() != null && com.cyberlink.you.a.a().c())
                    {
                        k1 = i1 + 1;
                        if (k1 <= 15)
                        {
                            break label0;
                        }
                        try
                        {
                            com.cyberlink.you.chat.n.b("tried 15 times, give up");
                            com.cyberlink.you.chat.n.l().r();
                            com.cyberlink.you.chat.n.a().a(null);
                            com.cyberlink.you.a.a().e();
                        }
                        catch (org.jivesoftware.smack.SmackException.NotConnectedException notconnectedexception)
                        {
                            notconnectedexception.printStackTrace();
                        }
                    }
                    com.cyberlink.you.chat.j.a();
                    com.cyberlink.you.chat.j.b();
                    com.cyberlink.you.chat.n.b("Reconnect Thread, exit");
                    return;
                }
                i1 = (int)((double)(l1 + 3) * Math.pow(1.2D, k1));
                com.cyberlink.you.chat.n.b((new StringBuilder()).append("Waiting for ").append(i1).append(" second(s) to reconnect").toString());
_L2:
                int j1;
                if (i1 <= 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                j1 = i1;
                Thread.sleep(1000L);
                i1--;
                j1 = i1;
                try
                {
                    a.c.reconnectingIn(i1);
                }
                catch (InterruptedException interruptedexception)
                {
                    Log.w("XMPPManager", "Sleeping thread interrupted");
                    a.c.reconnectionFailed(interruptedexception);
                    i1 = j1;
                }
                if (true) goto _L2; else goto _L1
_L1:
                com.cyberlink.you.chat.n.b((new StringBuilder()).append("reconnect #").append(k1).toString());
                i1 = k1;
                if (com.cyberlink.you.chat.n.l() == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                com.cyberlink.you.chat.n.a(System.currentTimeMillis());
                com.cyberlink.you.chat.n.l().h();
                com.cyberlink.you.g.a().e(false);
                a.g();
                i1 = k1;
                continue; /* Loop/switch isn't completed */
                Exception exception1;
                exception1;
                a.c.reconnectionFailed(exception1);
                com.cyberlink.you.chat.n.b(exception1.toString());
                i1 = k1;
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = n.this;
                super();
            }
        };
        m.setName("Reconnect Thread");
        m.setDaemon(true);
        m.start();
          goto _L3
    }

    public boolean d()
    {
        return r != null && r.f();
    }

    public void e()
    {
        (new Thread() {

            final n a;

            public void run()
            {
                Thread.currentThread().setName("disconnect");
                Log.d("XMPPManager", "disconnect");
                if (com.cyberlink.you.chat.n.l() == null || !com.cyberlink.you.chat.n.l().f())
                {
                    break MISSING_BLOCK_LABEL_44;
                }
                com.cyberlink.you.chat.n.l().r();
                com.cyberlink.you.g.a().e(true);
_L2:
                com.cyberlink.you.chat.n.a().a(null);
                com.cyberlink.you.chat.n.b(a).a();
                Log.d("XMPPManager", "disconnected");
                return;
                Object obj;
                obj;
                Log.d("XMPPManager", "NotConnectedException");
                continue; /* Loop/switch isn't completed */
                obj;
                if (((Exception) (obj)).getMessage() != null)
                {
                    Log.e("XMPPManager", ((Exception) (obj)).getMessage());
                }
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                a = n.this;
                super();
            }
        }).start();
    }

    public void f()
    {
        Log.d("XMPPManager", "disconnectNow");
        if (r == null || !r.f())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        r.r();
        com.cyberlink.you.g.a().e(true);
_L2:
        a().a(((XMPPConnection) (null)));
        n.a();
        Log.d("XMPPManager", "disconnected");
        return;
        Object obj;
        obj;
        Log.d("XMPPManager", "NotConnectedException");
        continue; /* Loop/switch isn't completed */
        obj;
        if (((Exception) (obj)).getMessage() != null)
        {
            Log.e("XMPPManager", ((Exception) (obj)).getMessage());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void g()
    {
        (new Thread() {

            final n a;

            public void run()
            {
                try
                {
                    sleep(10000L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                a.a(org.jivesoftware.smack.packet.Presence.Type.a);
            }

            
            {
                a = n.this;
                super();
            }
        }).start();
    }

    public boolean h()
    {
        return A;
    }

    public void i()
    {
        d.clear();
    }

    public List j()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = u.iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (s)iterator.next();
            StringBuilder stringbuilder = (new StringBuilder()).append(((s) (obj)).a).append(":").append(((s) (obj)).b).append("(").append(((s) (obj)).c).append(")");
            if (((s) (obj)).d)
            {
                obj = " TLS Required";
            } else
            {
                obj = " TLS not Required";
            }
            arraylist.add(stringbuilder.append(((String) (obj))).toString());
        }
        return arraylist;
    }

    public void k()
    {
        x = 0L;
    }

    static 
    {
        a = org.jivesoftware.smack.packet.Presence.Type.b;
    }
}

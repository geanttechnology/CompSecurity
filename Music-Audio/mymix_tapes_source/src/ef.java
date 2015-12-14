// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.b;
import java.util.Vector;

public class ef
    implements bn.b, eg
{
    public static final class a
    {

        private int a;
        private String b;
        private String c;
        private ef d;
        private boolean e;

        static void a(a a1, String s)
        {
            if (a1.c.equals("INTERNAL_ERROR"))
            {
                a1.c = s;
            } else
            {
                a1.c = (new StringBuilder()).append(a1.c).append(":").append(s).toString();
            }
            ef.a(a1.d, a1);
        }

        protected final int a()
        {
            return a;
        }

        protected final void a(eg.a a1)
        {
            if (c.equals("INTERNAL_ERROR"))
            {
                c = a1.toString();
            } else
            {
                c = (new StringBuilder()).append(c).append(":").append(a1.toString()).toString();
            }
            ef.a(d, this);
        }

        protected final void a(String s)
        {
            b = s;
        }

        protected final String b()
        {
            return b;
        }

        protected final String c()
        {
            return c;
        }

        protected final void d()
        {
            e = true;
        }

        protected final boolean e()
        {
            return e;
        }

        protected a(int i1, ef ef1)
        {
            a = i1;
            if (ef.e(ef1).f() != null)
            {
                b = dm.a(ef.e(ef1).f());
            } else
            {
                b = "";
            }
            c = "INTERNAL_ERROR";
            d = ef1;
            e = false;
        }
    }


    private static final bm b = d.a(ef);
    protected byte a;
    private dp c;
    private dk d;
    private ej e;
    private dm f;
    private ce g;
    private short h;
    private bn i;
    private bq j;
    private long k;
    private boolean l;
    private String m;
    private boolean n;
    private a o;
    private Object p;

    protected ef(bn bn1, ej ej1, String s, String s1, dm dm1, String s2, String s3, 
            String s4, String s5, String s6, String s7, bi bi1, String s8, String s9, 
            String s10, String s11, String s12, cv cv1, dp dp1, dk dk1, byte byte0)
    {
        e = null;
        f = null;
        h = -1;
        n = false;
        if (b.b())
        {
            b.b("PDXTransactionImpl()");
        }
        p = new Object();
        i = bn1;
        f = dm1;
        e = ej1;
        k = 30000L;
        c = dp1;
        d = dk1;
        a = byte0;
        m = s;
        l = false;
        if (((dl)dp1.g()).i() != null)
        {
            o = new a(a, this);
            b(o, "INTERNAL_ERROR");
        }
        synchronized (p)
        {
            h = 0;
        }
        ej1 = ((ej) (new Object[18]));
        ej1[0] = s2;
        ej1[1] = s3;
        ej1[2] = s4;
        ej1[3] = s5;
        ej1[4] = s6;
        ej1[5] = s7;
        ej1[6] = bi1;
        ej1[7] = s8;
        ej1[8] = new Short((short)1);
        ej1[9] = new Short((short)1);
        ej1[10] = s9;
        ej1[11] = s10;
        ej1[12] = s11;
        ej1[13] = s12;
        ej1[14] = s1;
        ej1[15] = s;
        ej1[16] = cv1;
        ej1 = new bn.a((byte)1, ej1);
        s = Thread.currentThread();
        bn1.a();
        bn1.a(ej1, this, s);
    }

    static Object a(ef ef1)
    {
        return ef1.p;
    }

    static void a(a a1, String s)
    {
        b(a1, s);
    }

    static void a(ef ef1, a a1)
    {
        ef1 = (Vector)((dl)ef1.c.g()).i();
        if (ef1 == null)
        {
            b.c("appendLogToResLogs: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled.");
        } else
        if (!ef1.contains(a1))
        {
            ef1.addElement(a1);
            return;
        }
    }

    static void a(ef ef1, String s)
    {
        ef1.a(s);
    }

    private void a(String s)
    {
        if (g != null)
        {
            g.a(s).a();
        }
    }

    private void a(String s, boolean flag)
    {
        cg cg1;
        cg cg2;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        cg2 = g.a("NMASResponse");
        cg1 = cg2;
        cg cg3 = cg2.a("ResultType", s);
        cg2 = cg3;
        cg1 = cg3;
        if (s.compareTo("QUERY_RESULT") == 0)
        {
            cg1 = cg3;
            try
            {
                cg2 = cg3.a("IsFinal", flag);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                cg2 = cg1;
            }
        }
        cg2.a();
    }

    private static String b(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i1 = 0;
        while (i1 < abyte0.length) 
        {
            String s = Integer.toHexString(abyte0[i1]);
            if (s.length() > 1)
            {
                stringbuffer.append(s.substring(s.length() - 2));
            } else
            {
                stringbuffer.append(s);
            }
            if (i1 == 3 || i1 == 5 || i1 == 7 || i1 == 9)
            {
                stringbuffer.append('-');
            }
            i1++;
        }
        return stringbuffer.toString();
    }

    static short b(ef ef1)
    {
        ef1.h = -1;
        return -1;
    }

    private static void b(a a1, String s)
    {
        if (a1 != null)
        {
            a.a(a1, s);
        }
    }

    static ej c(ef ef1)
    {
        return ef1.e;
    }

    static a d(ef ef1)
    {
        return ef1.o;
    }

    static dm e(ef ef1)
    {
        return ef1.f;
    }

    static bm g()
    {
        return b;
    }

    public final void a()
        throws da, db
    {
label0:
        {
            if (b.b())
            {
                b.b("PDXTransactionImpl.end()");
            }
            synchronized (p)
            {
                if (h == -1)
                {
                    b.e("PDXTransactionImpl.end() transaction already finished!");
                    throw new da("transaction already finished!");
                }
                break label0;
            }
        }
        if (h != 0)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        h = 1;
        bn bn1 = i;
        bn.a a1 = new bn.a((byte)4, null);
        Thread thread = Thread.currentThread();
        i.a();
        bn1.a(a1, this, thread);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        if (h == 1)
        {
            b.e("PDXTransactionImpl.end() transaction already finished!");
            throw new da("transaction already finished!");
        }
        if (h == 2)
        {
            b.e("PDXTransactionImpl.end() transaction already expired!");
            throw new db("transaction already expired!");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(bj.j j1)
        throws da, db
    {
label0:
        {
            if (b.b())
            {
                b.b("PDXTransactionImpl.sendParam()");
            }
            if (j1 == null)
            {
                throw new NullPointerException("Parameter cannot be null");
            }
            synchronized (p)
            {
                if (h == -1)
                {
                    b.e("PDXTransactionImpl.sendParam() transaction already finished!");
                    throw new da("transaction already finished!");
                }
                break label0;
            }
        }
        if (h != 0)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        bn bn1 = i;
        j1 = new bn.a((byte)2, j1);
        Thread thread = Thread.currentThread();
        i.a();
        bn1.a(j1, this, thread);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        if (h == 1)
        {
            b.e("PDXTransactionImpl.sendParam() transaction already finished!");
            throw new da("transaction already finished!");
        }
        if (h == 2)
        {
            b.e("PDXTransactionImpl.sendParam() transaction already expired!");
            throw new db("transaction already expired!");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(dy dy, byte byte0)
    {
label0:
        {
            b.b("PDXTransactionImpl.onQueryError()");
            if (byte0 != a)
            {
                return;
            }
            synchronized (p)
            {
                if (h != -1 && h != 2)
                {
                    break label0;
                }
            }
            return;
        }
        ej ej1;
        h = -1;
        a("QUERY_ERROR", true);
        if (j != null)
        {
            i.a(j);
        }
        ej1 = e;
        if (ej1 == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        b(o, "QUERY_ERROR");
        e.a(dy);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        dy;
        b.e((new StringBuilder("got exp in PDXCommandListener.PDXQueryErrorReturned() [")).append(dy.getClass().getName()).append("] msg [").append(dy.getMessage()).append("]").toString());
          goto _L1
    }

    public final void a(ea ea1, byte byte0)
    {
label0:
        {
            if (b.b())
            {
                b.b("PDXTransactionImpl.onQueryResults()");
            }
            if (byte0 != a)
            {
                return;
            }
            synchronized (p)
            {
                if (h != -1 && h != 2)
                {
                    break label0;
                }
            }
            return;
        }
        ej ej1;
        l = true;
        a("QUERY_RESULT", ea1.g());
        if (j != null && ea1.g())
        {
            i.a(j);
        }
        ej1 = e;
        if (ej1 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (ea1.g())
        {
            b(o, "FINAL_RESULT");
        }
        e.a(ea1);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        ea1;
        b.e((new StringBuilder("got exp in PDXCommandListener.PDXQueryResultReturned() [")).append(ea1.getClass().getName()).append("] msg [").append(ea1.getMessage()).append("]").toString());
          goto _L1
    }

    public final void a(eb eb, byte byte0)
    {
label0:
        {
            b.b("PDXTransactionImpl.onQueryRetry()");
            if (byte0 != a)
            {
                return;
            }
            synchronized (p)
            {
                if (h != -1 && h != 2)
                {
                    break label0;
                }
            }
            return;
        }
        ej ej1;
        h = -1;
        a("QUERY_RETRY", true);
        if (j != null)
        {
            i.a(j);
        }
        ej1 = e;
        if (ej1 == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        b(o, "QUERY_RETRY");
        e.a(eb);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        eb;
        b.e((new StringBuilder("got exp in PDXCommandListener.PDXQueryRetryReturned() [")).append(eb.getClass().getName()).append("] msg [").append(eb.getMessage()).append("]").toString());
          goto _L1
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        obj1 = ((bn.a) (obj)).b;
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 1 6: default 52
    //                   1 53
    //                   2 799
    //                   3 958
    //                   4 1005
    //                   5 1075
    //                   6 1086;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        obj = ((Object) ((Object[])obj1));
        Object obj2 = (String)obj[0];
        Object obj3 = (String)obj[1];
        Object obj4 = (String)obj[2];
        Object obj5 = (String)obj[3];
        String s = (String)obj[4];
        String s1 = (String)obj[5];
        obj1 = (bi)obj[6];
        String s2 = (String)obj[7];
        short word0 = ((Short)obj[8]).shortValue();
        short word1 = ((Short)obj[9]).shortValue();
        String s3 = (String)obj[10];
        String s4 = (String)obj[11];
        String s5 = (String)obj[12];
        String s6 = (String)obj[13];
        byte abyte0[] = f.f();
        String s7 = (String)obj[14];
        String s8 = (String)obj[15];
        cv cv1 = (cv)obj[16];
        obj = obj1;
        if ((new b(c.b)).a())
        {
            obj = bx.c(((bi) (obj1)));
        }
        do.i();
        obj1 = f.j();
        if (obj1 != null)
        {
            obj1 = ((ce) (obj1)).a("NMASCommand");
            cg cg1;
            int i1;
            int j1;
            try
            {
                g = ((cg) (obj1)).a("Name", m).a("TransID", (new Integer(a)).toString()).a();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        obj = new dw(((String) (obj2)), ((String) (obj3)), ((String) (obj4)), ((String) (obj5)), s, s1, ((bi) (obj)), s2, word0, word1, s3, s4, s5, s6, abyte0, s7, s8, cv1);
        obj1 = (Vector)((dl)c.g()).i();
        if (obj1 == null)
        {
            b.c("appendLogToQueryBegin: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled");
        } else
        if (((Vector) (obj1)).size() == 0)
        {
            b.c("appendLogToQueryBegin: nmasResLogsToServer is empty, nothing to log to server");
        } else
        {
            j1 = ((Vector) (obj1)).size();
            obj2 = new cq();
            obj3 = new ct();
            for (i1 = 0; i1 < j1; i1++)
            {
                obj4 = (a)((Vector) (obj1)).elementAt(i1);
                if (((a) (obj4)).a() != a)
                {
                    obj5 = new cq();
                    ((cq) (obj5)).a("id", (new StringBuilder()).append(((a) (obj4)).b()).append(":").append(((a) (obj4)).a()).toString(), (short)193);
                    ((cq) (obj5)).a("status", ((a) (obj4)).c().toString(), (short)193);
                    ((ct) (obj3)).a(((cv) (obj5)));
                    ((a) (obj4)).d();
                }
            }

            ((cq) (obj2)).a("device_log", ((cw) (obj3)));
            ((dw) (obj)).a("app_info", ((cv) (obj2)));
        }
        f.a((short)2597, (new StringBuilder("SEND_BCP_BEGIN")).append(a).toString(), ((dw) (obj)).f(), null, a, 0L, c, false);
        if (abyte0 != null)
        {
            try
            {
                if (!n)
                {
                    n = true;
                    b.b((new StringBuilder("PDXCommandCreated() called from handleInit()")).append(b(abyte0)).append(":").append(a).append(" (").append(this).append(",").append(d).append(")").toString());
                    d.a((new StringBuilder()).append(b(abyte0)).append(":").append(a).toString());
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b.e((new StringBuilder("got exp in PDXCommandListener.PDXCommandCreated() [")).append(obj.getClass().getName()).append("] msg [").append(((Throwable) (obj)).getMessage()).append("]").toString());
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        obj = (bj.j)obj1;
        if (((dv)obj).c() == 127)
        {
            f.a(((ed)obj).a(), ((ed)obj).e(), c);
        }
        do.i();
        if (obj instanceof dq)
        {
            obj1 = ((dq)obj).b();
            i1 = ((dq)obj).a();
            if (g != null)
            {
                cg1 = g.a("NMASAudioParameter");
                try
                {
                    cg1.a("Name", ((String) (obj1))).a("AudioID", i1).a();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
        }
        obj = new dz((dv)obj);
        f.a((short)2585, "SEND_BCP_DATA", ((dz) (obj)).d(), null, a, 0L, c, false);
        return;
_L4:
        obj = (byte[])obj1;
        do.i();
        obj = new ds(((byte []) (obj)));
        f.a((short)2585, "SEND_BCP_DATA", ((ds) (obj)).d(), null, a, 0L, c, false);
        return;
_L5:
        do.i();
        obj = new dx();
        f.a((short)2585, "SEND_BCP_DATA", ((dx) (obj)).d(), null, a, 0L, c, false);
        j = new bq() {

            private ef a;

            public final void run()
            {
                synchronized (ef.a(a))
                {
                    ef.b(a);
                }
                ef.a(a, "CommandExpired");
                if (ef.c(a) == null)
                {
                    break MISSING_BLOCK_LABEL_77;
                }
                ef.g().b("PDXTransactionImpl.end() timed out waiting for results. ");
                obj6 = a;
                ef.a(ef.d(a), "TIMEOUT_CMD");
                ef.c(a).a((short)1);
                return;
                exception;
                obj6;
                JVM INSTR monitorexit ;
                throw exception;
                Object obj7;
                obj7;
                ef.g().e((new StringBuilder("PDXTransactionImpl.run() ")).append(obj7.getClass().getName()).append(" ").append(((Exception) (obj7)).getMessage()).toString());
                return;
                obj7;
                ef.g().e((new StringBuilder("got exp in PDXCommandListener.PDXCommandEvent(TIMED_OUT_WAITING_FOR_RESULT) [")).append(obj7.getClass().getName()).append("] msg [").append(((Throwable) (obj7)).getMessage()).append("]").toString());
                return;
            }

            
            {
                a = ef.this;
                super();
            }
        };
        i.a(j, k);
        return;
_L6:
        e.a((short)4);
        return;
_L7:
        obj = (eg.a)obj1;
        obj1 = o;
        if (obj1 != null)
        {
            ((a) (obj1)).a(((eg.a) (obj)));
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public final void a(short word0)
    {
label0:
        {
            if (b.b())
            {
                b.b((new StringBuilder("PDXTransactionImpl.onSessionDisconnected() ")).append(word0).toString());
            }
            synchronized (p)
            {
                if (h == 1 && j != null)
                {
                    i.a(j);
                }
                if (h != 2)
                {
                    break label0;
                }
            }
            return;
        }
        if (word0 != 0) goto _L2; else goto _L1
_L1:
        if (h != -1)
        {
            b(o, "REMOTE_DISC");
            e.a((short)3);
        }
_L4:
        h = 2;
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (word0 != 1)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (h == -1) goto _L4; else goto _L3
_L3:
        e.a((short)4);
          goto _L4
        Throwable throwable;
        throwable;
        b.e((new StringBuilder("got exp in PDXCommandListener.PDXCommandEvent() or PDXManagerListener.PDXManagerError() or PDXManagerListener.PDXManagerDisconnected() reasonCode [")).append(word0).append("] [").append(throwable.getClass().getName()).append("] msg [").append(throwable.getMessage()).append("]").toString());
          goto _L4
        if (word0 != 3)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        if (h == -1) goto _L4; else goto _L5
_L5:
        b(o, "TIMEOUT_IDLE");
        e.a((short)5);
          goto _L4
        if (word0 != 4)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        if (h == -1) goto _L4; else goto _L6
_L6:
        b(o, "CONN_FAILED");
        d.a();
          goto _L4
        if (word0 != 5)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        if (h == -1) goto _L4; else goto _L7
_L7:
        b(o, "CONN_FAILED");
        d.a();
          goto _L4
        if (word0 != 6)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if (h == -1) goto _L4; else goto _L8
_L8:
        b(o, "REMOTE_DISC");
        e.a((short)3);
          goto _L4
        if (word0 != 7) goto _L10; else goto _L9
_L9:
        if (h == -1) goto _L4; else goto _L11
_L11:
        b(o, "CONN_FAILED");
        d.a();
          goto _L4
_L10:
        if (word0 != 8) goto _L4; else goto _L12
_L12:
        if (h == -1) goto _L4; else goto _L13
_L13:
        b(o, "REMOTE_DISC");
        e.a((short)3);
          goto _L4
    }

    public final void a(byte abyte0[])
    {
        if (b.b())
        {
            b.b("PDXTransactionImpl.onSessionConnected()");
        }
        Object obj = p;
        obj;
        JVM INSTR monitorenter ;
        short word0;
        if (h == 0)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        word0 = h;
        if (word0 != 1)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        a a1;
        abyte0 = b(abyte0);
        a1 = o;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        a1.a(abyte0);
        if (!n)
        {
            n = true;
            b.b((new StringBuilder("PDXCommandCreated() called from onSessionConnected()")).append(abyte0).append(":").append(a).append(" (").append(this).append(",").append(d).append(")").toString());
            d.a((new StringBuilder()).append(abyte0).append(":").append(a).toString());
        }
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        b.e((new StringBuilder("got exp in PDXCommandListener.PDXCommandCreated() [")).append(abyte0.getClass().getName()).append("] msg [").append(abyte0.getMessage()).append("]").toString());
          goto _L1
        abyte0;
        throw abyte0;
    }

    public final void b()
    {
        f();
    }

    public final void c()
    {
        f();
    }

    public final void d()
    {
        f();
    }

    public final void e()
    {
label0:
        {
            bn bn1;
            bn.a a1;
            Thread thread;
            synchronized (p)
            {
                if (h == 1 && j != null)
                {
                    i.a(j);
                }
                if (h != 2)
                {
                    break label0;
                }
            }
            return;
        }
        if (h != -1)
        {
            if (!l)
            {
                a("CommandAbort");
            }
            bn1 = i;
            a1 = new bn.a((byte)5, null);
            thread = Thread.currentThread();
            i.a();
            bn1.a(a1, this, thread);
        }
        h = 2;
        obj;
        JVM INSTR monitorexit ;
    }

    protected final void f()
    {
        if (j != null)
        {
            i.a(j);
            i.a(j, k);
        }
    }

}

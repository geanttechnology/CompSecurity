// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.Vector;

public abstract class j
    implements g
{

    protected i a;
    protected final String b;
    protected final df c;
    protected final k d;
    private h e;
    private eh f;
    private eg g;
    private final dk h;
    private final ej i;

    public j(df df, k k1, h h1)
    {
        this(df, k1, k1.j(), h1);
    }

    public j(df df, k k1, String s, h h1)
    {
        e = h1;
        c = df;
        d = k1;
        df = s;
        if (s == null)
        {
            df = k1.j();
        }
        b = df;
        h = new dk() {

            final j a;

            public final void a()
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.c(a, "PDX Create Command Failed");
                ax.a(new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
                        a.a.a.e();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public final void a(String s1)
            {
                ax.a(new Runnable(this, s1) {

                    private String a;
                    private _cls1 b;

                    public final void run()
                    {
                        Object obj = b.a.a;
                        obj = a;
                    }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                });
            }

            
            {
                a = j.this;
                super();
            }
        };
        i = new ej() {

            final j a;

            public final void a(cv cv1)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, "PDX Query Result Returned");
                ax.a(new Runnable(this, cv1) {

                    private cv a;
                    private _cls2 b;

                    public final void run()
                    {
                        b.a.a.a(a);
                    }

            
            {
                b = _pcls2;
                a = cv1;
                super();
            }
                });
            }

            public final void a(ek ek1)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, (new StringBuilder()).append("PDX Query Error Returned: ").append(ek1.g()).append("(").append(ek1.h()).append(")").toString());
                ax.a(new Runnable(this, ek1) {

                    private ek a;
                    private _cls2 b;

                    public final void run()
                    {
                        i i1 = b.a.a;
                        a.g();
                        i1.a(a.h());
                    }

            
            {
                b = _pcls2;
                a = ek1;
                super();
            }
                });
            }

            public final void a(el el1)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, (new StringBuilder()).append("PDX Query Retry Returned: ").append(el1.h()).append("(").append(el1.g()).append(")").toString());
                ax.a(new Runnable(this, el1.i(), el1.g()) {

                    private String a;
                    private String b;
                    private _cls2 c;

                    public final void run()
                    {
                        i i1 = c.a.a;
                        String s = a;
                        String s1 = b;
                        i1.b(s);
                    }

            
            {
                c = _pcls2;
                a = s;
                b = s1;
                super();
            }
                });
            }

            public final void a(short word0)
            {
                switch (word0)
                {
                case 2: // '\002'
                default:
                    return;

                case 1: // '\001'
                case 3: // '\003'
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(a, (new StringBuilder()).append("PDX Command Event: ").append(word0).toString());
                    break;
                }
                ax.a(new Runnable(this, word0) {

                    private short a;
                    private _cls2 b;

                    public final void run()
                    {
                        i i1 = b.a.a;
                        short word0 = a;
                        i1.f();
                    }

            
            {
                b = _pcls2;
                a = word0;
                super();
            }
                });
            }

            
            {
                a = j.this;
                super();
            }
        };
        f = null;
        g = null;
    }

    private void a(bj.j j1)
        throws l
    {
        try
        {
            g.a(j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bj.j j1)
        {
            throw new l("Error sending parameter (TransactionAlreadyFinishedException)", j1);
        }
        // Misplaced declaration of an exception variable
        catch (bj.j j1)
        {
            throw new l("Error sending parameter (TransactionExpiredException)", j1);
        }
    }

    public final void a()
    {
        a.c();
    }

    protected void a(cv cv1)
    {
    }

    public final void a(i i1)
    {
        a.b();
        a = i1;
        a.a();
    }

    public final void a(String s)
        throws dj
    {
        if (f == null) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        cv cv1;
        String s3;
        String s4;
        Object obj;
        cv1 = g();
        s3 = d.i();
        s4 = d.k();
        String s1 = d.l();
        String s2 = d.m();
        String s5 = d.o();
        obj = d;
        obj = k.q();
        Object obj1 = d;
        obj1 = k.n();
        String s6 = d.b();
        String s7 = d.g();
        cv1.b("ui_language", b.substring(0, 2).toLowerCase());
        cv1.b("phone_submodel", s4);
        cv1.b("phone_OS", s1);
        cv1.b("locale", s2);
        cv1.b("nmdp_version", ((String) (obj1)));
        cv1.b("nmaid", s6);
        cv1.b("network_type", s5);
        if (s7 != null)
        {
            cv1.b("subscription_id", s7);
        }
        abyte0 = new byte[100];
        byte abyte1[] = d.a(abyte0);
        abyte0 = abyte1;
_L4:
        cv1.a("app_transaction_id", abyte0);
        a(cv1);
        g = f.a(i, s, ((String) (obj)), b, s3, s4, cv1);
_L2:
        return;
        Throwable throwable;
        throwable;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(String s, cv cv1)
        throws l
    {
        a(f.a(s, cv1));
    }

    public final void a(String s, String s1)
        throws l
    {
        a(f.a(s, s1));
    }

    public final void a(String s, String s1, cx cx)
        throws l
    {
        cv cv1 = g();
        cv1.b("tts_input", s1);
        cv1.b("tts_type", s);
        a(f.a("TEXT_TO_READ", cv1, cx));
    }

    public final cx b(String s)
        throws l
    {
        s = f.a(s);
        a(s);
        return s;
    }

    public final void b()
    {
        a.d();
    }

    public final void b(String s, cv cv1)
        throws l
    {
        a(f.d(s, cv1));
    }

    public final h c()
    {
        return e;
    }

    public final void c(String s, cv cv1)
        throws l
    {
        a(f.b(s, cv1));
    }

    public final void d()
    {
        Vector vector = new Vector();
        vector.add(new cz("Android_Context", d.a(), cz.a.a));
        df df = c;
        dk dk = h;
        d.b();
        f = ei.a(df, dk, vector);
    }

    public final void d(String s, cv cv1)
        throws l
    {
        a(f.c(s, cv1));
    }

    public final void e()
    {
        if (f != null)
        {
            try
            {
                f.a();
            }
            catch (dj dj1) { }
            f = null;
        }
    }

    public final void f()
        throws l
    {
        try
        {
            g.a();
            return;
        }
        catch (da da1)
        {
            throw new l("Error ending PDX command (TransactionAlreadyFinishedException)", da1);
        }
        catch (db db1)
        {
            throw new l("Error ending PDX command (TransactionExpiredException)", db1);
        }
    }

    public final cv g()
    {
        return f.j();
    }

    public final cw h()
    {
        return f.k();
    }
}

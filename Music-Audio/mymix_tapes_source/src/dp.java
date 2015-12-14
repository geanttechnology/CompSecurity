// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public class dp extends do
    implements eh
{

    private static final bm g = d.a(dp);
    private static String k;
    private bn h;
    private dk i;
    private ef j;

    public dp(dl dl1, dk dk, Vector vector)
    {
        super(dl1, dk, vector);
        i = dk;
        h = dl1.c_();
        a = dl1.h();
        a.a(this);
        j = null;
        dl1 = h;
        dk = new bn.a((byte)0, null);
        vector = Thread.currentThread();
        h.a();
        dl1.a(dk, this, vector);
    }

    private void a(byte byte0)
    {
        if (byte0 == j.a)
        {
            Vector vector = (Vector)((dl)g()).i();
            if (vector != null && vector.size() > 0)
            {
                g.b((new StringBuilder("clearResLogsToServer() before clean the log vector tranId[")).append(byte0).append("] log list size [").append(vector.size()).append("]").toString());
                for (int l = 0; l < vector.size();)
                {
                    ef.a a1 = (ef.a)vector.elementAt(l);
                    if (a1.e())
                    {
                        vector.removeElement(a1);
                    } else
                    {
                        l++;
                    }
                }

                g.b((new StringBuilder("clearResLogsToServer() after clean the log vector tranId[")).append(byte0).append("] log list size [").append(vector.size()).append("]").toString());
            }
        }
    }

    public final bj.j a(String s, cv cv)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        }
        if (cv == null)
        {
            throw new NullPointerException("dict can not be null");
        } else
        {
            return new dr(s, (cq)cv);
        }
    }

    public final bj.j a(String s, cv cv, cx cx)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        }
        if (cv == null)
        {
            throw new NullPointerException("tts_dict can not be null");
        }
        if (cx == null)
        {
            throw new NullPointerException("audioSink can not be null");
        } else
        {
            return new ed(s, a, (cq)cv, cx);
        }
    }

    public final bj.j a(String s, String s1)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        }
        if (s1 == null)
        {
            throw new NullPointerException("text can not be null");
        } else
        {
            return new ee(s, s1);
        }
    }

    public final cx a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        } else
        {
            return new dq(s, a, h);
        }
    }

    public final eg a(ej ej, String s, String s1, String s2, String s3, String s4, cv cv)
        throws dj
    {
        String s5;
label0:
        {
            String s6 = "";
            if (ej == null)
            {
                s6 = (new StringBuilder()).append("").append("commandListener is invalid; ").toString();
            }
            if (s != null)
            {
                s5 = s6;
                if (!s.equals(""))
                {
                    break label0;
                }
            }
            s5 = (new StringBuilder()).append(s6).append("cmd should be non-null; ").toString();
        }
        String s7;
label1:
        {
            if (s1 != null)
            {
                s7 = s5;
                if (!s1.equals(""))
                {
                    break label1;
                }
            }
            s7 = (new StringBuilder()).append(s5).append("scriptVersion should be non-null; ").toString();
        }
label2:
        {
            if (s2 != null)
            {
                s5 = s7;
                if (!s2.equals(""))
                {
                    break label2;
                }
            }
            s5 = (new StringBuilder()).append(s7).append("dictationLanguage should be non-null; ").toString();
        }
label3:
        {
            if (s4 != null)
            {
                s7 = s5;
                if (!s4.equals(""))
                {
                    break label3;
                }
            }
            s7 = (new StringBuilder()).append(s5).append("phoneModel should be non-null; ").toString();
        }
        s5 = s7;
        if (30000L <= 0L)
        {
            s5 = (new StringBuilder()).append(s7).append("commandTimeout is invalid; ").toString();
        }
        if (!s5.equals(""))
        {
            g.e((new StringBuilder("NMASResourceImpl.createCommand() ")).append(s5).toString());
            throw new IllegalArgumentException(s5);
        }
        synchronized (e)
        {
            if (j != null)
            {
                j.e();
            }
            dm dm1 = a;
            dm.d();
            if (d == 0)
            {
                bn bn1 = h;
                bn.a a1 = new bn.a((byte)0, null);
                Thread thread = Thread.currentThread();
                h.a();
                bn1.a(a1, this, thread);
            }
            f = a.h();
            j = new ef(h, ej, s, ((dl)c).b, a, ((dl)c).d(), "1", k, s1, "enus", "ne", ((dl)c).e(), s2, s3, s4, ((dl)c).d(), "", cv, this, i, f);
            ej = j;
        }
        return ej;
    }

    public final void a()
        throws dj
    {
label0:
        {
            g.b((new StringBuilder("freeResource() disconnectTimeout:")).append(0).toString());
            if (j != null)
            {
                j.e();
            }
            synchronized (e)
            {
                if (d != 2)
                {
                    break label0;
                }
                d = 0;
                Object obj1 = new Integer(0);
                bn bn1 = h;
                obj1 = new bn.a((byte)3, obj1);
                Thread thread = Thread.currentThread();
                h.a();
                bn1.a(obj1, this, thread);
            }
            return;
        }
        throw new dj("the resource was unloaded. ");
    }

    public final void a(byte byte0, short word0)
    {
        if (byte0 != f)
        {
            return;
        }
        if (j != null)
        {
            j.e();
        }
        super.a(byte0, word0);
    }

    public final void a(byte byte0, byte abyte0[])
    {
        abyte0 = du.a(abyte0);
        abyte0.e();
        JVM INSTR tableswitch 29185 29189: default 44
    //                   29185 77
    //                   29186 102
    //                   29187 44
    //                   29188 44
    //                   29189 122;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        g.e((new StringBuilder("Session.parseXModeMsgBcpData() Unknown command: ")).append(abyte0.e()).append(". ").toString());
_L6:
        return;
_L2:
        a(byte0);
        if (j != null)
        {
            j.a((ea)abyte0, byte0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j != null)
        {
            j.a((dy)abyte0, byte0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        a(byte0);
        if (j != null)
        {
            j.a((eb)abyte0, byte0);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(Object obj, Object obj1)
    {
        switch (((bn.a)obj).a)
        {
        case 1: // '\001'
        case 2: // '\002'
        default:
            super.a(obj, obj1);
            return;

        case 0: // '\0'
            super.a(this);
            return;

        case 3: // '\003'
            a.b(this);
            break;
        }
        obj = i;
    }

    public final void a(short word0)
    {
        g.b((new StringBuilder("onSessionDisconnected() reasonCode:")).append(word0).toString());
        if (j != null)
        {
            j.a(word0);
        }
        super.a(word0);
    }

    public final void a(byte abyte0[])
    {
        super.a(abyte0);
        if (j != null)
        {
            j.a(abyte0);
        }
    }

    public final bj.j b(String s, cv cv)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        }
        if (cv == null)
        {
            throw new NullPointerException("dict can not be null");
        } else
        {
            return new ec(s, (cq)cv, (byte)2);
        }
    }

    public final bj.j c(String s, cv cv)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        }
        if (cv == null)
        {
            throw new NullPointerException("dict can not be null");
        } else
        {
            return new ec(s, (cq)cv, (byte)3);
        }
    }

    public final void c()
    {
        j.f();
    }

    public final bj.j d(String s, cv cv)
    {
        if (s == null)
        {
            throw new NullPointerException("name can not be null");
        }
        if (cv == null)
        {
            throw new NullPointerException("dict can not be null");
        } else
        {
            return new ec(s, (cq)cv, (byte)1);
        }
    }

    public final void d()
    {
        j.b();
    }

    public final void e()
    {
        j.c();
    }

    public final void f()
    {
        j.d();
    }

    public final long h()
    {
        return super.h();
    }

    public final cv j()
    {
        return new cq();
    }

    public final cw k()
    {
        return new ct();
    }

    static 
    {
        k = android.os.Build.VERSION.RELEASE;
    }
}

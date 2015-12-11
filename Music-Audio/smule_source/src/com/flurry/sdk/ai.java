// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.flurry.sdk:
//            gl, gd, fn, gk, 
//            al, hp, fp, hq, 
//            ao

public abstract class ai
{

    private static final String a = com/flurry/sdk/ai.getSimpleName();
    private a b;
    private String c;
    private long d;
    private int e;
    private al f;
    private long g;
    private boolean h;
    private int i;
    private long j;
    private int k;
    private boolean l;
    private boolean m;

    public ai()
    {
        d = 0x7fffffffffffffffL;
        e = 40000;
        j = 0x19000L;
    }

    static int a(ai ai1, int i1)
    {
        ai1.i = i1;
        return i1;
    }

    static long a(ai ai1, long l1)
    {
        ai1.g = l1;
        return l1;
    }

    static long a(ai ai1, gl gl1)
    {
        return ai1.a(gl1);
    }

    private long a(gl gl1)
    {
        gl1 = gl1.b("Content-Length");
        if (gl1 == null || gl1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        long l1 = Long.parseLong((String)gl1.get(0));
        return l1;
        gl1;
        gd.a(3, a, (new StringBuilder()).append("Downloader: could not determine content length for url: ").append(c).toString());
        return -1L;
    }

    static boolean a(ai ai1)
    {
        return ai1.p();
    }

    static boolean a(ai ai1, boolean flag)
    {
        ai1.l = flag;
        return flag;
    }

    private String b(int i1)
    {
        return String.format(Locale.US, "%s__%03d", new Object[] {
            c, Integer.valueOf(i1)
        });
    }

    static void b(ai ai1)
    {
        ai1.k();
    }

    static boolean b(ai ai1, boolean flag)
    {
        ai1.h = flag;
        return flag;
    }

    private String c(int i1)
    {
        return String.format("%s=%d-%d", new Object[] {
            "bytes", Long.valueOf((long)i1 * j), Long.valueOf(Math.min(g, (long)(i1 + 1) * j) - 1L)
        });
    }

    static void c(ai ai1)
    {
        ai1.j();
    }

    static long d(ai ai1)
    {
        return ai1.g;
    }

    static long e(ai ai1)
    {
        return ai1.d;
    }

    static String f(ai ai1)
    {
        return ai1.c;
    }

    static boolean g(ai ai1)
    {
        return ai1.l;
    }

    static void h(ai ai1)
    {
        ai1.o();
    }

    static long i(ai ai1)
    {
        return ai1.j;
    }

    static String i()
    {
        return a;
    }

    private void j()
    {
        if (b())
        {
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Downloader: Requesting file from url: ").append(c).toString());
            gl gl1 = new gl();
            gl1.a(c);
            gl1.a(gl.a.b);
            gl1.a(e);
            gl1.a(new gl.b() {

                final ai a;

                public void a(gl gl2)
                {
                    if (a.b())
                    {
                        return;
                    } else
                    {
                        int i1 = gl2.e();
                        gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Download status code is:").append(i1).append(" for url: ").append(ai.f(a)).toString());
                        ai.a(a, gl2.c());
                        fp.a().b(new hq(this) {

                            final _cls2 a;

                            public void safeRun()
                            {
                                if (!ai.g(a.a))
                                {
                                    a.a.h();
                                }
                                ai.h(a.a);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    }
                }

                public void a(gl gl2, InputStream inputstream)
                {
                    if (a.b())
                    {
                        throw new IOException("Downloader: request cancelled");
                    }
                    ai.a(a, ai.a(a, gl2));
                    if (ai.d(a) > ai.e(a))
                    {
                        throw new IOException((new StringBuilder()).append("Downloader: content length: ").append(ai.d(a)).append(" exceeds size limit: ").append(ai.e(a)).toString());
                    }
                    inputstream = new ao(inputstream, ai.e(a));
                    hp.a(inputstream, a.f());
                    a.g();
                    hp.a(inputstream);
                    return;
                    gl2;
                    inputstream = null;
_L2:
                    a.g();
                    hp.a(inputstream);
                    throw gl2;
                    gl2;
                    if (true) goto _L2; else goto _L1
_L1:
                }

            
            {
                a = ai.this;
                super();
            }
            });
            fn.a().a(this, gl1);
            return;
        }
    }

    static void j(ai ai1)
    {
        ai1.l();
    }

    static al k(ai ai1)
    {
        return ai1.f;
    }

    private void k()
    {
        if (b())
        {
            return;
        } else
        {
            gk gk1 = new gk();
            gk1.a(c);
            gk1.a(gl.a.f);
            gk1.a(new gk.a() {

                final ai a;

                public volatile void a(gk gk2, Object obj)
                {
                    a(gk2, (Void)obj);
                }

                public void a(gk gk2, Void void1)
                {
                    if (a.b())
                    {
                        return;
                    }
                    int i1 = gk2.e();
                    gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: HTTP HEAD status code is:").append(i1).append(" for url: ").append(ai.f(a)).toString());
                    if (gk2.c())
                    {
                        ai.a(a, ai.a(a, gk2));
                        gk2 = gk2.b("Accept-Ranges");
                        if (ai.d(a) > 0L && gk2 != null && !gk2.isEmpty())
                        {
                            ai.b(a, "bytes".equals(((String)gk2.get(0)).trim()));
                            gk2 = a;
                            long l1 = ai.d(a) / ai.i(a);
                            int j1;
                            if (ai.d(a) % ai.i(a) > 0L)
                            {
                                j1 = 1;
                            } else
                            {
                                j1 = 0;
                            }
                            ai.a(gk2, (int)((long)j1 + l1));
                        } else
                        {
                            ai.a(a, 1);
                        }
                        if (ai.e(a) > 0L && ai.d(a) > ai.e(a))
                        {
                            gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Size limit exceeded -- limit: ").append(ai.e(a)).append(", content-length: ").append(ai.d(a)).append(" bytes!").toString());
                            fp.a().b(new hq(this) {

                                final _cls3 a;

                                public void safeRun()
                                {
                                    ai.h(a.a);
                                }

            
            {
                a = _pcls3;
                super();
            }
                            });
                            return;
                        } else
                        {
                            fp.a().b(new hq(this) {

                                final _cls3 a;

                                public void safeRun()
                                {
                                    ai.j(a.a);
                                }

            
            {
                a = _pcls3;
                super();
            }
                            });
                            return;
                        }
                    } else
                    {
                        fp.a().b(new hq(this) {

                            final _cls3 a;

                            public void safeRun()
                            {
                                ai.h(a.a);
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                a = ai.this;
                super();
            }
            });
            gd.a(3, a, (new StringBuilder()).append("Downloader: requesting HTTP HEAD for url: ").append(c).toString());
            fn.a().a(this, gk1);
            return;
        }
    }

    static int l(ai ai1)
    {
        return ai1.k;
    }

    private void l()
    {
        if (b())
        {
            return;
        }
        if (q())
        {
            for (int i1 = 0; i1 < i; i1++)
            {
                f.d(b(i1));
            }

            m();
            return;
        } else
        {
            j();
            return;
        }
    }

    static int m(ai ai1)
    {
        int i1 = ai1.k;
        ai1.k = i1 + 1;
        return i1;
    }

    private void m()
    {
        while (k < i) 
        {
            if (b())
            {
                return;
            }
            String s = b(k);
            String s1 = c(k);
            if (f.d(s))
            {
                gd.a(3, a, (new StringBuilder()).append("Downloader: Skipping chunk with range:").append(s1).append(" for url: ").append(c).append(" chunk: ").append(k).toString());
                k = k + 1;
            } else
            {
                gd.a(3, a, (new StringBuilder()).append("Downloader: Requesting chunk with range:").append(s1).append(" for url: ").append(c).append(" chunk: ").append(k).toString());
                gl gl1 = new gl();
                gl1.a(c);
                gl1.a(gl.a.b);
                gl1.a(e);
                gl1.a("Range", s1);
                gl1.a(new gl.b(s, s1) {

                    final String a;
                    final String b;
                    final ai c;

                    public void a(gl gl2)
                    {
                        if (c.b())
                        {
                            return;
                        }
                        int i1 = gl2.e();
                        gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Download status code is:").append(i1).append(" for url: ").append(ai.f(c)).append(" chunk: ").append(ai.l(c)).toString());
                        Object obj = null;
                        List list = gl2.b("Content-Range");
                        String s2 = obj;
                        if (list != null)
                        {
                            s2 = obj;
                            if (!list.isEmpty())
                            {
                                s2 = (String)list.get(0);
                                gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Content range is:").append(s2).append(" for url: ").append(ai.f(c)).append(" chunk: ").append(ai.l(c)).toString());
                            }
                        }
                        if (gl2.c() && i1 == 206 && s2 != null && s2.startsWith(b.replaceAll("=", " ")))
                        {
                            ai.m(c);
                            fp.a().b(new hq(this) {

                                final _cls4 a;

                                public void safeRun()
                                {
                                    ai.n(a.c);
                                }

            
            {
                a = _pcls4;
                super();
            }
                            });
                            return;
                        } else
                        {
                            fp.a().b(new hq(this) {

                                final _cls4 a;

                                public void safeRun()
                                {
                                    ai.h(a.c);
                                }

            
            {
                a = _pcls4;
                super();
            }
                            });
                            return;
                        }
                    }

                    public void a(gl gl2, InputStream inputstream)
                    {
                        Object obj;
                        Object obj1;
                        al.c c1;
                        obj = null;
                        obj1 = null;
                        if (c.b())
                        {
                            throw new IOException("Downloader: request cancelled");
                        }
                        c1 = ai.k(c).b(a);
                        gl2 = obj1;
                        if (c1 == null)
                        {
                            break MISSING_BLOCK_LABEL_87;
                        }
                        inputstream = new ao(inputstream, ai.e(c));
                        hp.a(inputstream, c1.a());
                        hp.a(inputstream);
                        hp.a(c1);
                        gl2 = obj1;
_L1:
                        if (gl2 != null)
                        {
                            ai.k(c).c(a);
                            throw gl2;
                        } else
                        {
                            return;
                        }
                        gl2;
                        inputstream = null;
_L4:
                        hp.a(inputstream);
                        hp.a(c1);
                          goto _L1
                        gl2;
                        inputstream = obj;
_L3:
                        hp.a(inputstream);
                        hp.a(c1);
                        throw gl2;
                        gl2;
                        if (true) goto _L3; else goto _L2
_L2:
                        gl2;
                          goto _L4
                    }

            
            {
                c = ai.this;
                a = s;
                b = s1;
                super();
            }
                });
                fn.a().a(this, gl1);
                return;
            }
        }
        n();
    }

    private void n()
    {
        Object obj1;
        boolean flag;
        obj1 = null;
        flag = false;
        if (b())
        {
            return;
        }
        gd.a(3, a, (new StringBuilder()).append("Downloader: assembling output file for url: ").append(c).toString());
        Object obj2 = f();
        int i1 = 0;
_L6:
        if (i1 >= i) goto _L2; else goto _L1
_L1:
        if (b())
        {
            throw new IOException("Download cancelled");
        }
          goto _L3
        Object obj;
        obj;
        g();
_L7:
        String s;
        if (obj == null)
        {
            gd.a(3, a, (new StringBuilder()).append("Downloader: assemble succeeded for url: ").append(c).toString());
            l = true;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Downloader: assemble failed for url: ").append(c).append(" failed with exception: ").append(obj).toString());
            for (int j1 = ((flag) ? 1 : 0); j1 < i; j1++)
            {
                f.c(b(j1));
            }

            h();
        }
        o();
        return;
_L3:
        s = b(i1);
        obj = f.a(s);
        if (obj != null) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder()).append("Could not create reader for chunk key: ").append(s).toString());
        obj2;
        obj1 = obj;
        obj = obj2;
_L8:
        hp.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        g();
        throw obj;
_L5:
        hp.a(((al.b) (obj)).a(), ((OutputStream) (obj2)));
        hp.a(((java.io.Closeable) (obj)));
        f.c(s);
        i1++;
          goto _L6
_L2:
        g();
        obj = obj1;
          goto _L7
        obj;
        obj1 = null;
          goto _L8
    }

    static void n(ai ai1)
    {
        ai1.m();
    }

    private void o()
    {
        while (b() || b == null) 
        {
            return;
        }
        gd.a(3, a, (new StringBuilder()).append("Downloader: finished -- success: ").append(l).append(" for url: ").append(c).toString());
        b.a(this);
    }

    private boolean p()
    {
        return f != null;
    }

    private boolean q()
    {
        return f != null && h && i > 1;
    }

    public void a(int i1)
    {
        e = i1;
    }

    public void a(a a1)
    {
        b = a1;
    }

    public void a(al al1)
    {
        f = al1;
    }

    public void a(String s)
    {
        c = s;
    }

    public boolean a()
    {
        return l;
    }

    public boolean b()
    {
        return m;
    }

    public long c()
    {
        return g;
    }

    public void d()
    {
        fp.a().b(new hq() {

            final ai a;

            public void safeRun()
            {
                if (ai.a(a))
                {
                    ai.b(a);
                    return;
                } else
                {
                    ai.c(a);
                    return;
                }
            }

            
            {
                a = ai.this;
                super();
            }
        });
    }

    public void e()
    {
        m = true;
        fn.a().a(this);
    }

    protected abstract OutputStream f();

    protected abstract void g();

    protected abstract void h();


    private class a
    {

        public abstract void a(ai ai1);
    }

}

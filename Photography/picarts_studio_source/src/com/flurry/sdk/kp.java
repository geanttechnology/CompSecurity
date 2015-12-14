// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            jy, jo, kc, kr, 
//            kq, jv, ji, jx, 
//            lr, jh, jw, la, 
//            kx

public abstract class kp
{

    protected final String a;
    Set b;
    kr c;
    protected String d;
    private jx e;

    public kp(String s, String s1)
    {
        b = new HashSet();
        d = "defaultDataKey_";
        e = new jx() {

            final kp a;

            public void a(jh jh1)
            {
                kc.a(4, a.a, (new StringBuilder("onNetworkStateChanged : isNetworkEnable = ")).append(jh1.a).toString());
                if (jh1.a)
                {
                    a.e();
                }
            }

            public volatile void a(jw jw)
            {
                a((jh)jw);
            }

            
            {
                a = kp.this;
                super();
            }
        };
        a = s1;
        jy.a().a("com.flurry.android.sdk.NetworkStateEvent", e);
        a(s);
    }

    public String a(String s, String s1)
    {
        return (new StringBuilder()).append(d).append(s).append("_").append(s1).toString();
    }

    protected void a(a a1)
    {
        a(((lr) (new lr(a1) {

            final a a;
            final kp b;

            public void a()
            {
                b.g();
                if (a != null)
                {
                    a.a();
                }
            }

            
            {
                b = kp.this;
                a = a1;
                super();
            }

            private class a
            {

                public abstract void a();
            }

        })));
    }

    protected void a(lr lr)
    {
        jo.a().b(lr);
    }

    protected void a(String s)
    {
        a(((lr) (new lr(s) {

            final String a;
            final kp b;

            public void a()
            {
                b.c = new kr(a);
            }

            
            {
                b = kp.this;
                a = s;
                super();
            }
        })));
    }

    protected void a(String s, String s1, int i)
    {
        a(((lr) (new lr(s, s1) {

            final String a;
            final String b;
            final kp c;

            public void a()
            {
                if (!c.c.a(a, b))
                {
                    kc.a(6, c.a, (new StringBuilder("Internal error. Block wasn't deleted with id = ")).append(a).toString());
                }
                if (!c.b.remove(a))
                {
                    kc.a(6, c.a, (new StringBuilder("Internal error. Block with id = ")).append(a).append(" was not in progress state").toString());
                }
            }

            
            {
                c = kp.this;
                a = s;
                b = s1;
                super();
            }
        })));
    }

    protected abstract void a(byte abyte0[], String s, String s1);

    public void a(byte abyte0[], String s, String s1, a a1)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            kc.a(6, a, "Report that has to be sent is EMPTY or NULL");
            return;
        } else
        {
            c(abyte0, s, s1);
            a(a1);
            return;
        }
    }

    protected void b(String s, String s1)
    {
        a(new lr(s) {

            final String a;
            final kp b;

            public void a()
            {
                if (!b.b.remove(a))
                {
                    kc.a(6, b.a, (new StringBuilder("Internal error. Block with id = ")).append(a).append(" was not in progress state").toString());
                }
            }

            
            {
                b = kp.this;
                a = s;
                super();
            }
        });
    }

    public void b(byte abyte0[], String s, String s1)
    {
        a(abyte0, s, s1, null);
    }

    protected void c(String s, String s1)
    {
        if (!c.a(s, s1))
        {
            kc.a(6, a, (new StringBuilder("Internal error. Block wasn't deleted with id = ")).append(s).toString());
        }
        if (!b.remove(s))
        {
            kc.a(6, a, (new StringBuilder("Internal error. Block with id = ")).append(s).append(" was not in progress state").toString());
        }
    }

    protected void c(byte abyte0[], String s, String s1)
    {
        a(new lr(abyte0, s, s1) {

            final byte a[];
            final String b;
            final String c;
            final kp d;

            public void a()
            {
                d.d(a, b, c);
            }

            
            {
                d = kp.this;
                a = abyte0;
                b = s;
                c = s1;
                super();
            }
        });
    }

    public int d()
    {
        return b.size();
    }

    protected void d(byte abyte0[], String s, String s1)
    {
        s = a(s, s1);
        abyte0 = new kq(abyte0);
        s1 = abyte0.a();
        (new jv(jo.a().c().getFileStreamPath(kq.a(s1)), ".yflurrydatasenderblock.", 1, new la() {

            final kp a;

            public kx a(int i)
            {
                return new kq.a();
            }

            
            {
                a = kp.this;
                super();
            }
        })).a(abyte0);
        kc.a(5, a, (new StringBuilder("Saving Block File ")).append(s1).append(" at ").append(jo.a().c().getFileStreamPath(kq.a(s1))).toString());
        c.a(abyte0, s);
    }

    protected void e()
    {
        a(((a) (null)));
    }

    protected boolean f()
    {
        return d() <= 5;
    }

    protected void g()
    {
        if (ji.a().c()) goto _L2; else goto _L1
_L1:
        kc.a(5, a, "Reports were not sent! No Internet connection!");
_L4:
        return;
_L2:
        Object obj;
        obj = c.a();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            kc.a(4, a, "No more reports to send.");
            return;
        }
        obj = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        String s = (String)((Iterator) (obj)).next();
        if (!f()) goto _L4; else goto _L5
_L5:
        List list;
        int i;
        list = c.c(s);
        kc.a(4, a, (new StringBuilder("Number of not sent blocks = ")).append(list.size()).toString());
        i = 0;
_L9:
        if (i >= list.size()) goto _L7; else goto _L6
_L6:
        String s1;
        s1 = (String)list.get(i);
        if (b.contains(s1))
        {
            break MISSING_BLOCK_LABEL_238;
        }
        if (!f()) goto _L7; else goto _L8
_L8:
        kq kq1 = (kq)(new jv(jo.a().c().getFileStreamPath(kq.a(s1)), ".yflurrydatasenderblock.", 1, new la() {

            final kp a;

            public kx a(int j)
            {
                return new kq.a();
            }

            
            {
                a = kp.this;
                super();
            }
        })).a();
        if (kq1 == null)
        {
            kc.a(6, a, "Internal ERROR! Cannot read!");
            c.a(s1, s);
        } else
        {
            byte abyte0[] = kq1.b();
            if (abyte0 == null || abyte0.length == 0)
            {
                kc.a(6, a, "Internal ERROR! Report is empty!");
                c.a(s1, s);
            } else
            {
                kc.a(5, a, (new StringBuilder("Reading block info ")).append(s1).toString());
                b.add(s1);
                a(abyte0, s1, s);
            }
        }
        i++;
          goto _L9
    }
}

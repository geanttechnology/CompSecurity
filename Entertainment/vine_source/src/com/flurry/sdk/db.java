// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            er, es, dl, el, 
//            dd, dc, fc

public abstract class db
    implements er
{
    public static interface a
    {

        public abstract void a();
    }


    protected final String d;
    Set e;
    dd f;
    protected String g;

    public db(String s, String s1)
    {
        e = new HashSet();
        g = "defaultDataKey_";
        d = s1;
        es.a().a(this);
        a(s);
    }

    protected String a(String s, String s1)
    {
        return (new StringBuilder()).append(g).append(s).append("_").append(s1).toString();
    }

    protected void a(a a1)
    {
        a(((fc) (new fc(a1) {

            final a a;
            final db b;

            public void a()
            {
                b.f();
                if (a != null)
                {
                    a.a();
                }
            }

            
            {
                b = db.this;
                a = a1;
                super();
            }
        })));
    }

    protected void a(fc fc)
    {
        dl.a().c(fc);
    }

    protected void a(String s)
    {
        a(((fc) (new fc(s) {

            final String a;
            final db b;

            public void a()
            {
                b.f = new dd(a);
            }

            
            {
                b = db.this;
                a = s;
                super();
            }
        })));
    }

    protected void a(String s, String s1, int i)
    {
        a(((fc) (new fc(s, s1) {

            final String a;
            final String b;
            final db c;

            public void a()
            {
                if (!c.f.a(a, b))
                {
                    el.a(6, c.d, (new StringBuilder()).append("Internal error. Block wasn't deleted with id = ").append(a).toString());
                }
                if (!c.e.remove(a))
                {
                    el.a(6, c.d, (new StringBuilder()).append("Internal error. Block with id = ").append(a).append(" was not in progress state").toString());
                }
            }

            
            {
                c = db.this;
                a = s;
                b = s1;
                super();
            }
        })));
    }

    public void a(boolean flag)
    {
        el.a(4, d, (new StringBuilder()).append("onNetworkStateChanged : isNetworkEnable = ").append(flag).toString());
        if (flag)
        {
            d();
        }
    }

    protected abstract void a(byte abyte0[], String s, String s1);

    protected void a(byte abyte0[], String s, String s1, a a1)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            el.a(6, d, "Report that has to be sent is EMPTY or NULL");
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
        a(new fc(s) {

            final String a;
            final db b;

            public void a()
            {
                if (!b.e.remove(a))
                {
                    el.a(6, b.d, (new StringBuilder()).append("Internal error. Block with id = ").append(a).append(" was not in progress state").toString());
                }
            }

            
            {
                b = db.this;
                a = s;
                super();
            }
        });
    }

    public void b(byte abyte0[], String s, String s1)
    {
        a(abyte0, s, s1, null);
    }

    protected int c()
    {
        return e.size();
    }

    protected void c(String s, String s1)
    {
        if (!f.a(s, s1))
        {
            el.a(6, d, (new StringBuilder()).append("Internal error. Block wasn't deleted with id = ").append(s).toString());
        }
        if (!e.remove(s))
        {
            el.a(6, d, (new StringBuilder()).append("Internal error. Block with id = ").append(s).append(" was not in progress state").toString());
        }
    }

    protected void c(byte abyte0[], String s, String s1)
    {
        a(new fc(abyte0, s, s1) {

            final byte a[];
            final String b;
            final String c;
            final db d;

            public void a()
            {
                d.d(a, b, c);
            }

            
            {
                d = db.this;
                a = abyte0;
                b = s;
                c = s1;
                super();
            }
        });
    }

    protected String d(byte abyte0[], String s, String s1)
    {
        s = a(s, s1);
        s1 = new dc();
        s1.a(abyte0);
        abyte0 = s1.a();
        f.a(s1, s);
        return abyte0;
    }

    protected void d()
    {
        a(((a) (null)));
    }

    protected boolean e()
    {
        return c() <= 5;
    }

    protected void f()
    {
        if (es.a().c()) goto _L2; else goto _L1
_L1:
        el.a(5, d, "Reports were not sent! No Internet connection!");
_L4:
        return;
_L2:
        Object obj;
        obj = f.a();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            el.a(4, d, "No more reports to send.");
            return;
        }
        obj = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        String s = (String)((Iterator) (obj)).next();
        if (!e()) goto _L4; else goto _L5
_L5:
        List list;
        int i;
        list = f.c(s);
        el.a(4, d, (new StringBuilder()).append("Number of not sent blocks = ").append(list.size()).toString());
        i = 0;
_L8:
        if (i >= list.size()) goto _L7; else goto _L6
_L6:
        String s1;
        s1 = (String)list.get(i);
        if (!e.contains(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
_L10:
        i++;
          goto _L8
        if (!e()) goto _L7; else goto _L9
_L9:
        byte abyte0[] = (new dc(s1)).b();
        if (abyte0 == null || abyte0.length == 0)
        {
            el.a(6, d, "Internal ERROR! Report is empty!");
            f.a(s1, s);
        } else
        {
            e.add(s1);
            a(abyte0, s1, s);
        }
          goto _L10
    }
}

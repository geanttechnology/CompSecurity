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
//            kc, js, kg, kv, 
//            ku, jz, jl, kb, 
//            ly

public abstract class kt
{

    protected final String a;
    Set b;
    kv c;
    protected String d;
    private kb e;

    public kt(String s, String s1)
    {
        b = new HashSet();
        d = "defaultDataKey_";
        e = new _cls1();
        a = s1;
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", e);
        a(s);
    }

    public String a(String s, String s1)
    {
        return (new StringBuilder()).append(d).append(s).append("_").append(s1).toString();
    }

    protected void a(a a1)
    {
        a(((ly) (new _cls4(a1))));
    }

    protected void a(ly ly)
    {
        js.a().b(ly);
    }

    protected void a(String s)
    {
        a(((ly) (new _cls2(s))));
    }

    protected void a(String s, String s1, int i)
    {
        a(((ly) (new _cls7(s, s1))));
    }

    protected abstract void a(byte abyte0[], String s, String s1);

    public void a(byte abyte0[], String s, String s1, a a1)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            kg.a(6, a, "Report that has to be sent is EMPTY or NULL");
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
        a(new _cls8(s));
    }

    public void b(byte abyte0[], String s, String s1)
    {
        a(abyte0, s, s1, null);
    }

    protected void c(String s, String s1)
    {
        if (!c.a(s, s1))
        {
            kg.a(6, a, (new StringBuilder()).append("Internal error. Block wasn't deleted with id = ").append(s).toString());
        }
        if (!b.remove(s))
        {
            kg.a(6, a, (new StringBuilder()).append("Internal error. Block with id = ").append(s).append(" was not in progress state").toString());
        }
    }

    protected void c(byte abyte0[], String s, String s1)
    {
        a(new _cls3(abyte0, s, s1));
    }

    public int d()
    {
        return b.size();
    }

    protected void d(byte abyte0[], String s, String s1)
    {
        s = a(s, s1);
        abyte0 = new ku(abyte0);
        s1 = abyte0.a();
        (new jz(js.a().c().getFileStreamPath(ku.a(s1)), ".yflurrydatasenderblock.", 1, new _cls5())).a(abyte0);
        kg.a(5, a, (new StringBuilder()).append("Saving Block File ").append(s1).append(" at ").append(js.a().c().getFileStreamPath(ku.a(s1))).toString());
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
        if (jl.a().c()) goto _L2; else goto _L1
_L1:
        kg.a(5, a, "Reports were not sent! No Internet connection!");
_L4:
        return;
_L2:
        Object obj;
        obj = c.a();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            kg.a(4, a, "No more reports to send.");
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
        kg.a(4, a, (new StringBuilder()).append("Number of not sent blocks = ").append(list.size()).toString());
        i = 0;
_L8:
        if (i >= list.size()) goto _L7; else goto _L6
_L6:
        String s1;
        s1 = (String)list.get(i);
        if (!b.contains(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
_L10:
        i++;
          goto _L8
        if (!f()) goto _L7; else goto _L9
_L9:
        ku ku1 = (ku)(new jz(js.a().c().getFileStreamPath(ku.a(s1)), ".yflurrydatasenderblock.", 1, new _cls6())).a();
        if (ku1 == null)
        {
            kg.a(6, a, "Internal ERROR! Cannot read!");
            c.a(s1, s);
        } else
        {
            byte abyte0[] = ku1.b();
            if (abyte0 == null || abyte0.length == 0)
            {
                kg.a(6, a, "Internal ERROR! Report is empty!");
                c.a(s1, s);
            } else
            {
                kg.a(5, a, (new StringBuilder()).append("Reading block info ").append(s1).toString());
                b.add(s1);
                a(abyte0, s1, s);
            }
        }
          goto _L10
    }

    private class _cls1
        implements kb
    {

        final kt a;

        public void a(jk jk1)
        {
            kg.a(4, a.a, (new StringBuilder()).append("onNetworkStateChanged : isNetworkEnable = ").append(jk1.a).toString());
            if (jk1.a)
            {
                a.e();
            }
        }

        public volatile void a(ka ka)
        {
            a((jk)ka);
        }

        _cls1()
        {
            a = kt.this;
            super();
        }
    }


    private class _cls4 extends ly
    {

        final a a;
        final kt b;

        public void a()
        {
            b.g();
            if (a != null)
            {
                a.a();
            }
        }

        _cls4(a a1)
        {
            b = kt.this;
            a = a1;
            super();
        }

        private class a
        {

            public abstract void a();
        }

    }


    private class _cls2 extends ly
    {

        final String a;
        final kt b;

        public void a()
        {
            b.c = new kv(a);
        }

        _cls2(String s)
        {
            b = kt.this;
            a = s;
            super();
        }
    }


    private class _cls7 extends ly
    {

        final String a;
        final String b;
        final kt c;

        public void a()
        {
            if (!c.c.a(a, b))
            {
                kg.a(6, c.a, (new StringBuilder()).append("Internal error. Block wasn't deleted with id = ").append(a).toString());
            }
            if (!c.b.remove(a))
            {
                kg.a(6, c.a, (new StringBuilder()).append("Internal error. Block with id = ").append(a).append(" was not in progress state").toString());
            }
        }

        _cls7(String s, String s1)
        {
            c = kt.this;
            a = s;
            b = s1;
            super();
        }
    }


    private class _cls8 extends ly
    {

        final String a;
        final kt b;

        public void a()
        {
            if (!b.b.remove(a))
            {
                kg.a(6, b.a, (new StringBuilder()).append("Internal error. Block with id = ").append(a).append(" was not in progress state").toString());
            }
        }

        _cls8(String s)
        {
            b = kt.this;
            a = s;
            super();
        }
    }


    private class _cls3 extends ly
    {

        final byte a[];
        final String b;
        final String c;
        final kt d;

        public void a()
        {
            d.d(a, b, c);
        }

        _cls3(byte abyte0[], String s, String s1)
        {
            d = kt.this;
            a = abyte0;
            b = s;
            c = s1;
            super();
        }
    }


    private class _cls5
        implements le
    {

        final kt a;

        public lb a(int i)
        {
            return new ku.a();
        }

        _cls5()
        {
            a = kt.this;
            super();
        }
    }


    private class _cls6
        implements le
    {

        final kt a;

        public lb a(int i)
        {
            return new ku.a();
        }

        _cls6()
        {
            a = kt.this;
            super();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.chromium.net.HttpUrlRequestFactory;
import org.chromium.net.HttpUrlRequestFactoryConfig;
import org.chromium.net.UrlRequestContextConfig;

final class chy
    implements bjp
{

    private ary a;
    private boolean b;
    private chw c;

    chy(chw chw1, ary ary, boolean flag)
    {
        c = chw1;
        a = ary;
        b = flag;
        super();
    }

    private art a(boolean flag)
    {
_L11:
        Object obj = (bwp)chw.a(c).b_();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new asd(chw.b(c), asd.a, a, 8000, 8000);
_L9:
        if (!b) goto _L4; else goto _L3
_L3:
        int ai[] = chz.a;
        Object obj2 = chw.j(c);
        Object obj3 = cnc.a;
        Object obj1;
        IllegalStateException illegalstateexception;
        Object obj4;
        cmh cmh1;
        int i;
        int k;
        int i1;
        if (!((cnb) (obj2)).d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ai[((cnc)((cnb) (obj2)).a("medialib_diagnostic_bandwidth_throttling_policy", cnc, ((Enum) (obj3)), flag)).ordinal()];
        JVM INSTR tableswitch 1 1: default 120
    //                   1 735;
           goto _L4 _L5
_L4:
        return ((art) (obj));
_L2:
        if (!flag) goto _L7; else goto _L6
_L6:
        if (((bwp) (obj)).a.f != null)
        {
            if (((bwp) (obj)).a.f.a == 2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 0;
        }
        if (!i) goto _L7; else goto _L8
_L8:
        if (((bwp) (obj)).l() != chw.c(c) || ((bwp) (obj)).k() != chw.d(c))
        {
            chw.a(c, ((bwp) (obj)).l());
            chw.b(c, ((bwp) (obj)).k());
            chw.a(c, null);
        }
        if (chw.e(c) == null)
        {
            obj1 = new HttpUrlRequestFactoryConfig();
            ((UrlRequestContextConfig) (obj1)).a("ENABLE_QUIC", chw.c(c)).a("ENABLE_SPDY", chw.d(c)).a("foo.googlevideo.com", 80, 80).a("foo.googlevideo.com", 443, 443).a("foo.c.youtube.com", 80, 80).a("foo.c.youtube.com", 443, 443);
            try
            {
                chw.a(c, HttpUrlRequestFactory.a(chw.f(c), ((UrlRequestContextConfig) (obj1))));
            }
            // Misplaced declaration of an exception variable
            catch (IllegalStateException illegalstateexception)
            {
                chw.a(c, null);
            }
            if (chw.e(c) == null)
            {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = new cly(chw.e(c), asd.a, a, ((bwp) (obj)).f(), ((bwp) (obj)).g());
          goto _L9
_L7:
        if (((bwp) (obj)).a.b != null)
        {
            flag = ((bwp) (obj)).a.b.G;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (chw.g(c) == null)
            {
                chw.a(c, new cmh(chw.f(c)));
            }
            illegalstateexception = chw.b(c);
            obj2 = asd.a;
            obj3 = a;
            obj4 = chw.h(c);
            cmh1 = chw.g(c);
            if (((bwp) (obj)).a.b != null)
            {
                flag = ((bwp) (obj)).a.b.H;
            } else
            {
                flag = false;
            }
            obj = new clw(illegalstateexception, ((atj) (obj2)), ((asq) (obj3)), ((clv) (obj4)), cmh1, flag, chw.f(c));
        } else
        {
            if (((bwp) (obj)).a.b != null)
            {
                flag = ((bwp) (obj)).a.b.w;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                illegalstateexception = chw.i(c);
                obj2 = chw.b(c);
                obj3 = asd.a;
                obj4 = a;
                k = ((bwp) (obj)).f();
                i1 = ((bwp) (obj)).g();
                if (((bwp) (obj)).a.b != null)
                {
                    i = ((bwp) (obj)).a.b.x;
                } else
                {
                    i = 0;
                }
                if (((bwp) (obj)).a.b != null)
                {
                    flag = ((bwp) (obj)).a.b.y;
                } else
                {
                    flag = false;
                }
                obj = new clt(illegalstateexception, ((String) (obj2)), ((atj) (obj3)), ((asq) (obj4)), k, i1, i, flag);
            } else
            {
                obj = new asd(chw.b(c), asd.a, a, ((bwp) (obj)).f(), ((bwp) (obj)).g());
            }
        }
          goto _L9
_L5:
        int ai1[] = chw.j(c).e();
        bmi bmi = chw.i(c);
        int j;
        int l;
        int j1;
        int k1;
        if (ai1.length > 0)
        {
            j = ai1[0];
        } else
        {
            j = 0;
        }
        if (ai1.length > 1)
        {
            l = ai1[1];
        } else
        {
            l = 0;
        }
        if (ai1.length > 2)
        {
            j1 = ai1[2];
        } else
        {
            j1 = 0;
        }
        if (ai1.length > 3)
        {
            k1 = ai1[3];
        } else
        {
            k1 = 0;
        }
        return new cme(bmi, ((art) (obj)), j, l, j1, k1);
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final Object b_()
    {
        return a(true);
    }
}

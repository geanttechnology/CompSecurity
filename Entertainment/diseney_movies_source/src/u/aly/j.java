// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.g;
import com.umeng.analytics.onlineconfig.c;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            o, q, h, w, 
//            r, bf, cc, bj, 
//            bi, ci, ah, d, 
//            c, bd, p

public final class j
    implements c, o
{

    private q a;
    private r b;
    private com.umeng.analytics.ReportPolicy.e c;
    private g d;
    private w e;
    private d f;
    private int g;
    private Context h;

    public j(Context context)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = 10;
        h = context;
        a = new q(context);
        f = u.aly.h.a(context);
        e = new w(context);
        b = new r(context);
        b.a(e);
        d = com.umeng.analytics.g.a(context);
        context = AnalyticsConfig.getReportPolicy(h);
        a(context[0], context[1]);
    }

    private bf a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        bf bf1;
        try
        {
            bf1 = new bf();
            (new cc()).a(bf1, abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return bf1;
    }

    private void a(int i, int k)
    {
        i;
        JVM INSTR tableswitch 0 7: default 48
    //                   0 142
    //                   1 90
    //                   2 48
    //                   3 48
    //                   4 124
    //                   5 156
    //                   6 104
    //                   7 174;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
        c = new com.umeng.analytics.ReportPolicy.a();
_L9:
        u.aly.bj.c("MobclickAgent", (new StringBuilder("report policy:")).append(i).append(" interval:").append(k).toString());
        return;
_L3:
        c = new com.umeng.analytics.ReportPolicy.a();
        continue; /* Loop/switch isn't completed */
_L6:
        c = new com.umeng.analytics.ReportPolicy.b(e, k);
        continue; /* Loop/switch isn't completed */
_L4:
        c = new com.umeng.analytics.ReportPolicy.d(e);
        continue; /* Loop/switch isn't completed */
_L2:
        c = new com.umeng.analytics.ReportPolicy.e();
        continue; /* Loop/switch isn't completed */
_L5:
        c = new com.umeng.analytics.ReportPolicy.f(h);
        continue; /* Loop/switch isn't completed */
_L7:
        c = new com.umeng.analytics.ReportPolicy.c(a, k);
        if (true) goto _L9; else goto _L8
_L8:
    }

    private boolean a(boolean flag)
    {
        boolean flag2 = true;
        if (bi.l(h)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        if (bj.a)
        {
            u.aly.bj.c("MobclickAgent", "network is unavailable");
        }
        flag1 = false;
_L4:
        return flag1;
_L2:
        flag1 = flag2;
        if (e.b()) goto _L4; else goto _L3
_L3:
        if (!bj.a)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (bi.w(h)) goto _L4; else goto _L5
_L5:
        return c.a(flag);
    }

    private byte[] a(bf bf1)
    {
        try
        {
            bf1 = (new ci()).a(bf1);
        }
        // Misplaced declaration of an exception variable
        catch (bf bf1)
        {
            bf1.printStackTrace();
            return null;
        }
        return bf1;
    }

    private boolean d()
    {
        return a.b() > g;
    }

    private void e()
    {
        if (e.b())
        {
            a.a(new ah(e.j()));
        }
        f();
_L1:
        return;
        Throwable throwable;
        throwable;
        boolean flag = throwable instanceof OutOfMemoryError;
        if (throwable != null)
        {
            throwable.printStackTrace();
            return;
        }
          goto _L1
    }

    private void f()
    {
        byte abyte0[];
        g g1;
        boolean flag;
        g1 = com.umeng.analytics.g.a(h);
        flag = g1.f();
        if (flag)
        {
            abyte0 = g1.d();
        } else
        {
            f.a();
            abyte0 = c();
            if (abyte0 == null)
            {
                bj.e("MobclickAgent", "message is null");
                return;
            }
            abyte0 = u.aly.c.a(h, AnalyticsConfig.getAppkey(h), abyte0).c();
            g1.c();
        }
        b.a(abyte0);
        JVM INSTR tableswitch 1 3: default 56
    //                   1 163
    //                   2 107
    //                   3 147;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        if (e.i())
        {
            e.h();
        }
        f.d();
        e.g();
        if (flag)
        {
            g1.e();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        e.g();
        if (flag)
        {
            g1.e();
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        if (!flag)
        {
            g1.b(abyte0);
        }
        bj.b("MobclickAgent", "connection error");
        return;
    }

    public void a()
    {
        if (bi.l(h))
        {
            e();
        } else
        if (bj.a)
        {
            u.aly.bj.c("MobclickAgent", "network is unavailable");
            return;
        }
    }

    public void a(int i, long l)
    {
        AnalyticsConfig.setReportPolicy(i, (int)l);
        a(i, (int)l);
    }

    public void a(p p)
    {
        if (p != null)
        {
            a.a(p);
        }
        if (a(p instanceof bd))
        {
            e();
        } else
        if (d())
        {
            b();
            return;
        }
    }

    public void b()
    {
        if (a.b() <= 0)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        byte abyte0[] = c();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        d.a(abyte0);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (throwable instanceof OutOfMemoryError)
        {
            d.c();
        }
        if (throwable != null)
        {
            throwable.printStackTrace();
            return;
        }
          goto _L1
    }

    public void b(p p)
    {
        a.a(p);
    }

    protected byte[] c()
    {
        if (!TextUtils.isEmpty(AnalyticsConfig.getAppkey(h)))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        bj.b("MobclickAgent", "Appkey is missing ,Please check AndroidManifest.xml");
        return null;
        Object obj;
        Exception exception;
        byte abyte0[];
        boolean flag;
        try
        {
            obj = com.umeng.analytics.g.a(h).b();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            bj.b("MobclickAgent", "Fail to construct message ...", exception);
            com.umeng.analytics.g.a(h).c();
            return null;
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a.b() == 0)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj = a(((byte []) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = new bf();
        a.a(((bf) (obj)));
        if (!bj.a || !((bf) (obj)).B()) goto _L6; else goto _L5
_L5:
        abyte0 = ((bf) (obj)).z().iterator();
        flag = false;
_L14:
        if (abyte0.hasNext()) goto _L8; else goto _L7
_L7:
        if (flag) goto _L6; else goto _L9
_L9:
        bj.e("MobclickAgent", "missing Activities or PageViews");
_L6:
        abyte0 = a(((bf) (obj)));
        if (!bj.a) goto _L11; else goto _L10
_L10:
        u.aly.bj.c("MobclickAgent", ((bf) (obj)).toString());
        return abyte0;
        exception;
_L12:
        bj.b("MobclickAgent", "Fail to serialize log ...");
        return abyte0;
_L8:
        int i = ((bd)abyte0.next()).p();
        if (i > 0)
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
        exception;
        abyte0 = null;
        if (true) goto _L12; else goto _L11
_L11:
        return abyte0;
        if (true) goto _L14; else goto _L13
_L13:
    }
}

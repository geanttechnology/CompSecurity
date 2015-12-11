// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.jumio.clientlib.impl.livenessAndTM.FrameProcessorTemplateMatcher;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;
import com.jumio.netverify.sdk.gui.view.TemplateMatcherDrawView;

// Referenced classes of package jumiomobile:
//            jk, g, ao, ns, 
//            ab, nl, po, os, 
//            js, kc, kb, ii, 
//            n, ka, q, cs, 
//            mr, kd, pw, pv, 
//            jl

class jr extends Handler
{

    final jk a;

    private jr(jk jk1)
    {
        a = jk1;
        super();
    }

    jr(jk jk1, jl jl)
    {
        this(jk1);
    }

    private void a()
    {
        jk.k(a);
    }

    private void a(int i)
    {
        if (jk.j(a) != null)
        {
            jk.j(a).discardFrameByID(i);
        }
    }

    private void a(TemplateInfoWrapper templateinfowrapper, boolean flag)
    {
        boolean flag2 = false;
        if (templateinfowrapper.e())
        {
            PointF pointf1 = templateinfowrapper.w();
            PointF pointf2 = templateinfowrapper.x();
            PointF pointf3 = templateinfowrapper.y();
            PointF pointf4 = templateinfowrapper.z();
            PointF pointf = templateinfowrapper.u();
            boolean flag1;
            if (jk.K(a).c())
            {
                if (jk.O(a).g())
                {
                    float f = templateinfowrapper.E() / 2.0F;
                    pointf1.x = (f - pointf1.x) + f;
                    pointf2.x = (f - pointf2.x) + f;
                    pointf3.x = (f - pointf3.x) + f;
                    pointf4.x = (f - pointf4.x) + f;
                    pointf.x = f + (f - pointf.x);
                } else
                {
                    float f1 = templateinfowrapper.F() / 2.0F;
                    pointf1.y = (f1 - pointf1.y) + f1;
                    pointf2.y = (f1 - pointf2.y) + f1;
                    pointf3.y = (f1 - pointf3.y) + f1;
                    pointf4.y = (f1 - pointf4.y) + f1;
                    pointf.y = f1 + (f1 - pointf.y);
                }
            }
            if (templateinfowrapper.h() || !templateinfowrapper.g())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (jk.I(a).getResultView() != null)
            {
                jk.I(a).getResultView().setPolygon(pointf1, pointf2, pointf3, pointf4, pointf);
                templateinfowrapper = jk.I(a).getResultView();
                int i;
                byte byte0;
                if (flag1)
                {
                    i = 0xffff0000;
                } else
                {
                    i = 0xff00ff00;
                }
                templateinfowrapper.setBorderColor(i);
            }
            if (flag)
            {
                ab.a("TemplateMatcher", (new StringBuilder("setPoly: ")).append(pointf1).append("/").append(pointf2).append("/").append(pointf3).append("/").append(pointf4).toString());
            }
            if (jk.I(a).getProgressView() != null)
            {
                i = Math.round(((float)jk.P(a) / (float)(jk.n(a) - 1)) * 100F);
                if (i > 100 || flag)
                {
                    i = 100;
                }
                int j;
                if (flag1)
                {
                    j = 0x99ffffff;
                } else
                {
                    j = 0xd95e760a;
                }
                templateinfowrapper = jk.I(a).getProgressView();
                byte0 = flag2;
                if (flag1)
                {
                    byte0 = flag2;
                    if (i == 0)
                    {
                        byte0 = 8;
                    }
                }
                templateinfowrapper.setVisibility(byte0);
                jk.I(a).getProgressView().setColor(j);
                jk.I(a).getProgressView().setProgress(i);
                jk.I(a).getProgressView().a(pointf);
                return;
            }
        }
    }

    private void a(byte abyte0[], TemplateInfoWrapper templateinfowrapper)
    {
        a(templateinfowrapper, true);
        templateinfowrapper.a(jk.y(a).b());
        os.a(new po(jk.z(a).j, templateinfowrapper.n()));
        synchronized (jk.l(a))
        {
            ab.a("TemplateMatcher", (new StringBuilder("Handler: final result, fIx = ")).append(templateinfowrapper.n()).toString());
            jk.b(a, 0);
            jk.A(a).interrupt();
        }
        if (templateinfowrapper.g() && !templateinfowrapper.h())
        {
            jk.B(a).a();
            float f = (float)templateinfowrapper.B() / (float)templateinfowrapper.C();
            int i = templateinfowrapper.s().width();
            int j = (int)((float)i / f);
            abyte1 = kb.a(abyte0, jk.C(a).f(), jk.D(a).j, templateinfowrapper);
            f = a.c(abyte1, i, j, true);
            if (f >= 0.12F)
            {
                jk.E(a).a(f);
                jk.F(a).c(true);
                n n1 = new n(-1, -1);
                byte abyte2[] = kb.a(abyte0, 1.1F, n1, jk.G(a).f(), jk.H(a).j, templateinfowrapper);
                if (jk.I(a).getResultView() != null)
                {
                    jk.I(a).getResultView().setPolygon(null, null, null, null, null);
                }
                if (jk.I(a).getProgressView() != null)
                {
                    jk.I(a).getProgressView().setVisibility(8);
                }
                a.a(abyte0, abyte2, n1.a, n1.b, abyte1, i, j, templateinfowrapper);
                synchronized (a)
                {
                    jk.b(a, true);
                }
            } else
            {
                ab.e("TemplateMatcher", "discard final result because focus < 0.12");
            }
        } else
        {
            ab.e("TemplateMatcher", "discard final result - out of bounds or object too small");
        }
        jk.j(a).reset();
        jk.p(a).a();
        return;
        abyte0;
        abyte1;
        JVM INSTR monitorexit ;
        throw abyte0;
        templateinfowrapper;
        abyte0;
        JVM INSTR monitorexit ;
        throw templateinfowrapper;
    }

    private byte[] a(byte abyte0[], TemplateInfoWrapper templateinfowrapper, boolean flag, n n1)
    {
        Rect rect;
        int i;
        int j;
        int i1;
        int j1;
        rect = templateinfowrapper.t();
        j = rect.left;
        j1 = rect.top;
        i1 = rect.height();
        i = rect.width();
        if (flag) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        if (jk.Q(a).f())
        {
            k = rect.height();
            l = rect.width();
        } else
        {
            k = rect.width();
            l = rect.height();
        }
_L9:
        if (n1 != null)
        {
            n1.a = k;
            n1.b = l;
        }
        return q.b(abyte0, jk.S(a).f(), jk.T(a), i, i1, j, j1, k, l);
_L2:
        if (!jk.R(a).f()) goto _L4; else goto _L3
_L3:
        i1 = (int)templateinfowrapper.q();
        k = (int)((float)rect.width() * 1.1F);
        l = rect.left - (int)((float)rect.width() * 0.05F);
        if (l >= 0) goto _L6; else goto _L5
_L5:
        j = 0;
        i = k;
_L7:
        j1 = i;
        boolean flag1 = false;
        l = i;
        k = i1;
        i = j1;
        j1 = ((flag1) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L6:
        i = k;
        j = l;
        if ((float)(k + l) > templateinfowrapper.r())
        {
            i = (int)(templateinfowrapper.r() - (float)l);
            j = l;
        }
        if (true) goto _L7; else goto _L4
_L4:
        i1 = (int)templateinfowrapper.r();
        k = (int)((float)rect.width() * 1.1F);
        l = rect.left - (int)((float)rect.width() * 0.05F);
        if (l >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 0;
        i = k;
_L10:
        j1 = i;
        boolean flag2 = false;
        l = i1;
        k = i;
        i = j1;
        j1 = ((flag2) ? 1 : 0);
        if (true) goto _L9; else goto _L8
_L8:
        i = k;
        j = l;
        if ((float)(k + l) > templateinfowrapper.q())
        {
            i = (int)(templateinfowrapper.q() - (float)l);
            j = l;
        }
          goto _L10
        if (true) goto _L9; else goto _L11
_L11:
    }

    private void b(byte abyte0[], TemplateInfoWrapper templateinfowrapper)
    {
        boolean flag1 = true;
        boolean flag = flag1;
        float f;
        n n1;
        if (!templateinfowrapper.h())
        {
            if (!templateinfowrapper.g())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            a(templateinfowrapper.n());
        } else
        {
            jk.J(a);
        }
        a(templateinfowrapper, false);
        if (abyte0 == null || flag)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        System.gc();
        n1 = new n(-1, -1);
        abyte0 = a(abyte0, templateinfowrapper, false, n1);
        f = 0.0F;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        f = a.a(abyte0, n1.a, n1.b, true);
        if (cs.a() && a.i() != null)
        {
            a.i().a(-1F, f);
        }
        if (f >= 0.12F)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        ab.c("TemplateMatcher", (new StringBuilder("request refocus - focus too low (")).append(f).append(")").toString());
        jk.K(a).a((int)templateinfowrapper.u().x, (int)templateinfowrapper.u().y);
        System.gc();
_L1:
        if (!templateinfowrapper.g())
        {
            jk.B(a).a(kd.c);
            ab.a("TemplateMatcher", "discard intermediate result - out of bounds");
            os.a(new pw(jk.L(a).j, kd.c));
        } else
        if (templateinfowrapper.h())
        {
            jk.B(a).a(kd.b);
            ab.a("TemplateMatcher", "discard intermediate result - object too small");
            os.a(new pw(jk.M(a).j, kd.b));
        } else
        {
            jk.B(a).a(kd.d);
        }
        os.a(new pv(jk.N(a).j, templateinfowrapper.n()));
        return;
        abyte0;
        ab.b("TemplateMatcher", "Intermediate result: focus check skipped - OOM!", abyte0);
        System.gc();
          goto _L1
        abyte0;
        ab.b("TemplateMatcher handle IntermediateResult exception ", abyte0);
          goto _L1
    }

    public void handleMessage(Message message)
    {
        TemplateInfoWrapper templateinfowrapper;
        byte abyte0[];
        templateinfowrapper = (TemplateInfoWrapper)message.getData().getParcelable("templateInfo");
        abyte0 = message.getData().getByteArray("finalResultFrame");
        if (templateinfowrapper != null)
        {
            templateinfowrapper.a(jk.w(a), jk.x(a));
            templateinfowrapper.a(jk.n(a));
            templateinfowrapper.a(true);
        }
        message.what;
        JVM INSTR tableswitch 101 103: default 92
    //                   101 111
    //                   102 118
    //                   103 127;
           goto _L1 _L2 _L3 _L4
_L1:
        synchronized (a)
        {
            jk.b(a, false);
        }
        return;
_L2:
        a();
        continue; /* Loop/switch isn't completed */
_L3:
        b(abyte0, templateinfowrapper);
        continue; /* Loop/switch isn't completed */
_L4:
        a(abyte0, templateinfowrapper);
        if (true) goto _L1; else goto _L5
_L5:
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

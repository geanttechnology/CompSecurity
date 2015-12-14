// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.q;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            b, BeautyToolPanel, n

public class o extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b
{

    protected aw a;

    public o()
    {
        a = null;
    }

    protected void a()
    {
        k = Globals.d().t();
        b = (ImageView)g.findViewById(0x7f0c064b);
        c = (ImageView)g.findViewById(0x7f0c064c);
        d = (TextView)g.findViewById(0x7f0c064e);
        e = g.findViewById(0x7f0c064d);
        Object obj = StatusManager.j().s();
        i j = StatusManager.j().d();
        float f = m.J();
        q = true;
        String s;
        if (j != null && j.a(((BeautyMode) (obj))) != null && j.a(((BeautyMode) (obj))).c() != null)
        {
            s = j.a(((BeautyMode) (obj))).c();
            f = j.a(((BeautyMode) (obj))).g();
            q = a(((BeautyMode) (obj)), j);
        } else
        if (this.f != null)
        {
            s = SkuTemplateUtils.e(h.b().a(this.f.b(), this.f.a()).d());
        } else
        {
            s = PanelDataCenter.a().a(((BeautyMode) (obj)), 1);
        }
        if (s == null)
        {
            bo.d(((BeautyMode) (obj)));
        }
        a = PanelDataCenter.a().i(s);
        obj = (new StringBuilder()).append("MultiColorToolPanelMenu initValue, BeautyMode = ").append(String.valueOf(obj)).append(" , bNeedApply = ").append(q).append(" , default palette = ").append(String.valueOf(s)).toString();
        Globals.d().e(((String) (obj)));
        if (a == null)
        {
            q = false;
            return;
        }
        obj = a.i();
        ((n)m).a(a, true);
        boolean flag;
        if (this.f != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d(flag);
        Globals.d().j().d(((List) (obj)));
        if (k != null)
        {
            k.a(this);
            k.a(this);
        }
        p = f;
        m.a(p, 0.0F, 0.0F, true, false);
        h = g.findViewById(0x7f0c064a);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final o a;

                public void onClick(View view)
                {
                    if (a.o)
                    {
                        return;
                    } else
                    {
                        view.setClickable(false);
                        view = new Runnable(this, new ch(this, view) {

                            final View a;
                            final _cls1 b;

                            public void onAnimationEnd(Animator animator)
                            {
                                a.setClickable(true);
                            }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                        }) {

                            final ch a;
                            final _cls1 b;

                            public void run()
                            {
                                Object obj = null;
                                if (b.a.f != null)
                                {
                                    obj = h.b().a(b.a.f.b(), b.a.f.a()).d();
                                }
                                com.cyberlink.youcammakeup.clflurry.b.a(new q(((String) (obj)), YMKFeatures.a(StatusManager.j().s())));
                                obj = b.a.m;
                                boolean flag;
                                if (b.a.m.q() != 0)
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                ((BeautyToolPanel) (obj)).a(flag, a);
                            }

            
            {
                b = _pcls1;
                a = ch;
                super();
            }
                        };
                        a.h.post(view);
                        return;
                    }
                }

            
            {
                a = o.this;
                super();
            }
            });
        }
        if (!q)
        {
            c(s);
        }
        o = false;
    }

    public void a(ae ae, int j)
    {
    }

    public transient void a(String s, Float afloat[])
    {
        if (s == null || k == null)
        {
            if (k != null)
            {
                Globals.d().i().h(k);
            }
        } else
        {
            Object obj = StatusManager.j().s();
            StringBuilder stringbuilder = (new StringBuilder()).append("MultiColorToolPanelMenu changePalette, BeautyMode = ");
            if (obj == null)
            {
                obj = "null";
            }
            stringbuilder = stringbuilder.append(obj).append(" , palette = ");
            if (s != null)
            {
                obj = s;
            } else
            {
                obj = "null";
            }
            obj = stringbuilder.append(((String) (obj))).toString();
            Globals.d().e(((String) (obj)));
            if (m.d() != null)
            {
                m.a(f, s);
            } else
            {
                m.a(null, null);
            }
            if (s.equals(StatusManager.j().g()))
            {
                m.b(false);
                m.a(false, null);
                if (k != null)
                {
                    Globals.d().i().h(k);
                    return;
                }
            } else
            {
                (new AsyncTask(s, afloat) {

                    MotionControlHelper a;
                    PanelDataCenter b;
                    aw c;
                    int d;
                    int e;
                    final String f;
                    final Float g[];
                    final o h;

                    protected transient Boolean a(Void avoid[])
                    {
                        a.t();
                        c = b.i(f);
                        if (c == null)
                        {
                            return Boolean.valueOf(false);
                        }
                        StatusManager.j().c(f);
                        h.d(f);
                        List list = c.i();
                        float f1;
                        if (g.length > 0)
                        {
                            f1 = g[0].floatValue();
                        } else
                        {
                            f1 = a.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                        }
                        d = (int)f1;
                        if (list.size() == 0)
                        {
                            return Boolean.valueOf(false);
                        }
                        if (h.m.d() != null)
                        {
                            avoid = c.c();
                            if (avoid.size() > 0)
                            {
                                String s1 = StatusManager.j().e();
                                e = avoid.indexOf(s1);
                                if (s1 != null && e > -1)
                                {
                                    avoid = s1;
                                } else
                                {
                                    e = 0;
                                    String s2 = (String)avoid.get(e);
                                    avoid = s2;
                                    if (s2 != null)
                                    {
                                        avoid = s2;
                                        if (!s2.equals(""))
                                        {
                                            avoid = s2;
                                            if (!s2.equals(s1))
                                            {
                                                StatusManager.j().b(s2);
                                                MotionControlHelper.e().t();
                                                MotionControlHelper.e().a(true);
                                                avoid = s2;
                                            }
                                        }
                                    }
                                }
                                if (g.length == 0)
                                {
                                    avoid = b.b(avoid, f);
                                    if (avoid.size() > 0)
                                    {
                                        d = ((Integer)avoid.get(0)).intValue();
                                    }
                                }
                            } else
                            {
                                int j;
                                if (g.length == 0 && ((at)list.get(0)).d() != 0)
                                {
                                    j = ((at)list.get(0)).d();
                                } else
                                {
                                    j = d;
                                }
                                d = j;
                            }
                        } else
                        {
                            avoid = StatusManager.j().e();
                            int k;
                            if (h.m.i(avoid) && PanelDataCenter.d(avoid))
                            {
                                k = 1;
                            } else
                            {
                                k = 0;
                            }
                            if (k != 0)
                            {
                                k = 0;
                            } else
                            {
                                k = -1;
                            }
                            e = k;
                        }
                        if (e == -1)
                        {
                            StatusManager.j().b(h.m.g());
                        }
                        avoid = new ArrayList();
                        avoid.add(Integer.valueOf(d));
                        a.d(list);
                        a.c(avoid);
                        a.a(null, true);
                        return Boolean.valueOf(true);
                    }

                    protected void a(Boolean boolean1)
                    {
                        if (!boolean1.booleanValue())
                        {
                            if (h.k != null)
                            {
                                Globals.d().i().h(h.k);
                            }
                            return;
                        } else
                        {
                            h.m.d(StatusManager.j().e());
                            h.m.a(false, null);
                            h.m.b(false);
                            h.m.a(d);
                            ((n)h.m).a(c);
                            return;
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj1)
                    {
                        a((Boolean)obj1);
                    }

                    protected void onPreExecute()
                    {
                        a = MotionControlHelper.e();
                        b = PanelDataCenter.a();
                    }

            
            {
                h = o.this;
                f = s;
                g = afloat;
                super();
                e = -1;
            }
                }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                return;
            }
        }
    }

    protected boolean a(BeautyMode beautymode, i j)
    {
        Object obj;
        long l = StatusManager.j().l();
        if (k.p())
        {
            obj = k.r();
        } else
        {
            obj = StatusManager.j().f(Long.valueOf(l).longValue());
        }
        break MISSING_BLOCK_LABEL_26;
        if (obj != null && ((a) (obj)).f() != null && ((a) (obj)).f().g() != null && ((a) (obj)).f().g().a(beautymode) != null)
        {
            obj = ((a) (obj)).f().g();
            j = j.a(beautymode);
            Object obj1 = ((i) (obj)).a(beautymode);
            beautymode = j.b();
            obj = ((r) (obj1)).b();
            j = j.c();
            obj1 = ((r) (obj1)).c();
            if ((j == null || j.equals(obj1)) && (beautymode == null || beautymode.equals(obj)))
            {
                return false;
            }
        }
        return true;
    }

    protected void b()
    {
    }

    protected void c()
    {
        if (k == null)
        {
            return;
        }
        if (q)
        {
            q = false;
            k.i(false);
            k.a(new c() {

                final o a;

                public void a()
                {
                    if (a.k != null)
                    {
                        a.k.b(this);
                    }
                    a.i();
                }

            
            {
                a = o.this;
                super();
            }
            });
            a(a.a(), new Float[0]);
            return;
        }
        Object obj;
        if (k.A())
        {
            obj = StatusManager.j().j(StatusManager.j().l());
        } else
        {
            obj = StatusManager.j().g(StatusManager.j().l());
        }
        if (obj != null)
        {
            obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
            if (obj != null)
            {
                ((a) (obj)).a(MotionControlHelper.e().M());
            }
        }
        StatusManager.j().y();
        i();
    }

    protected void c(String s)
    {
        StatusManager.j().c(s);
        BeautyMode beautymode = StatusManager.j().s();
        BeautyToolPanel beautytoolpanel = m;
        if (f != null)
        {
            s = a.a();
        } else
        {
            s = null;
        }
        beautytoolpanel.b(s);
        ((n)m).a(a);
        m.d(m.c(beautymode));
        m.g(null);
    }

    protected void d()
    {
        if (k != null)
        {
            long l = StatusManager.j().l();
            MotionControlHelper.e().t();
            Object obj;
            if (k.A())
            {
                obj = StatusManager.j().j(l);
            } else
            {
                obj = StatusManager.j().g(l);
            }
            if (obj != null)
            {
                obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
                if (obj != null)
                {
                    v v1 = ((a) (obj)).f();
                    StringBuilder stringbuilder;
                    if (v1.c() != null)
                    {
                        obj = PanelDataCenter.a().i(v1.c());
                    } else
                    {
                        obj = null;
                    }
                    if (obj != null)
                    {
                        Object obj1 = ((aw) (obj)).i();
                        Globals.d().j().d(((List) (obj1)));
                        obj1 = (n)m;
                        ((n) (obj1)).a(((aw) (obj)), true);
                        ((n) (obj1)).a(((aw) (obj)));
                        a = ((aw) (obj));
                        StatusManager.j().c(((aw) (obj)).a());
                    }
                    obj = StatusManager.j().s();
                    stringbuilder = (new StringBuilder()).append("MultiColorToolPanelMenu onUndoRedo, BeautyMode = ");
                    if (obj == null)
                    {
                        obj = "null";
                    }
                    stringbuilder = stringbuilder.append(obj).append(" , palette = ");
                    if (a != null && a.a() != null)
                    {
                        obj = a.a();
                    } else
                    {
                        obj = "null";
                    }
                    obj = stringbuilder.append(((String) (obj))).toString();
                    Globals.d().e(((String) (obj)));
                    if (v1 != null)
                    {
                        m.a(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                        obj = new ArrayList();
                        ((List) (obj)).add(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
                        MotionControlHelper.e().c(((List) (obj)));
                        return;
                    }
                }
            }
        }
    }

    protected void d(String s)
    {
    }

    protected void g()
    {
        Object obj = StatusManager.j().s();
        StringBuilder stringbuilder = (new StringBuilder()).append("MultiColorToolPanelMenu unInitValue, BeautyMode = ");
        if (obj == null)
        {
            obj = "null";
        }
        stringbuilder = stringbuilder.append(obj).append(" , palette = ");
        if (a != null && a.a() != null)
        {
            obj = a.a();
        } else
        {
            obj = "null";
        }
        obj = stringbuilder.append(((String) (obj))).toString();
        Globals.d().e(((String) (obj)));
        super.g();
        StatusManager.j().c(null);
    }
}

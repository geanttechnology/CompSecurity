// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.x;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

public class e extends Fragment
    implements k, x, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k
{

    final aq a = new aq() {

        final e a;

        public void a(Exception exception)
        {
            m.e("MultiChoicePatternTool", exception.toString());
            if (com.cyberlink.youcammakeup.widgetpool.panel.d.e.c(a) == null)
            {
                return;
            } else
            {
                Globals.c(new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.panel.d.e.c(a.a) != null)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.d.e.c(a.a).v();
                            a.a.a();
                        }
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((String)obj);
        }

        public void a(String s)
        {
            if (com.cyberlink.youcammakeup.widgetpool.panel.d.e.c(a) == null)
            {
                return;
            } else
            {
                Globals.c(new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.panel.d.e.c(a.a) != null)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.d.e.c(a.a).v();
                            a.a.a();
                        }
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
                a = e.this;
                super();
            }
    };
    private View b;
    private EditViewActivity c;
    private d d;
    private at e;
    private boolean f;
    private android.content.DialogInterface.OnDismissListener g;

    public e()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        g = new android.content.DialogInterface.OnDismissListener() {

            final e a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.e.a(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.e.a(a).Y();
                }
                e.b(a);
            }

            
            {
                a = e.this;
                super();
            }
        };
    }

    static EditViewActivity a(e e1)
    {
        return e1.c;
    }

    static void b(e e1)
    {
        e1.j();
    }

    static d c(e e1)
    {
        return e1.d;
    }

    private void j()
    {
        if (!f)
        {
            i();
            return;
        }
        f = false;
        if (c != null)
        {
            c.j(true);
            c.i(false);
            c.a(new c() {

                final e a;

                public void a()
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.e.a(a).b(this);
                    a.i();
                }

            
            {
                a = e.this;
                super();
            }
            });
        }
        MotionControlHelper.e();
        MotionControlHelper.e().a(null, true);
    }

    private void k()
    {
        Globals.d().i().b(Globals.d().t());
    }

    protected void a()
    {
    }

    protected void a(float f1)
    {
        d.a(f1);
    }

    protected void a(float f1, boolean flag, boolean flag1)
    {
        d.a(f1, flag, flag1);
    }

    protected void a(int l)
    {
        d d1 = d;
        boolean flag;
        if (l == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d1.b(flag);
        d.a(l);
    }

    public void a(ae ae, int l)
    {
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        c(imagestatechangedevent);
    }

    public void a(at at1)
    {
        MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, at1, true);
        e = at1;
    }

    protected void a(at at1, boolean flag)
    {
        d.a(at1, flag);
    }

    public void a(az az)
    {
    }

    public void a(a a1)
    {
        d = (d)a1;
        MotionControlHelper.e().a(a);
    }

    public void a(String s)
    {
    }

    public void a(String s, boolean flag)
    {
    }

    public transient void a(String s, Float afloat[])
    {
    }

    protected void a(boolean flag)
    {
        if (d != null)
        {
            d.c(flag);
        }
    }

    protected void a(boolean flag, String s, String s1)
    {
        d.a(flag, s, s1);
    }

    protected void b()
    {
        c = Globals.d().t();
        if (c != null)
        {
            k();
            Globals.d().i().b(true);
            Object obj = StatusManager.j().s();
            at at1 = new at(0);
            List list = PanelDataCenter.a().d(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj)));
            obj = at1;
            if (list != null)
            {
                obj = at1;
                if (list.size() > 0)
                {
                    obj = (at)list.get(0);
                }
            }
            f = true;
            MotionControlHelper.e().m();
            if (obj != null)
            {
                e = ((at) (obj));
            }
            MotionControlHelper.e().a(((at) (obj)));
            if (c != null)
            {
                c.a(this);
                c.a(this);
                if (true)
                {
                    c.a(Boolean.valueOf(false), Boolean.valueOf(false));
                    a(false);
                }
            }
            if (d != null)
            {
                d.a("Apply", Boolean.valueOf(true));
                return;
            }
        }
    }

    public void b(ImageStateChangedEvent imagestatechangedevent)
    {
        c(imagestatechangedevent);
    }

    public void b(boolean flag)
    {
    }

    protected int c()
    {
        return d.z();
    }

    protected void c(ImageStateChangedEvent imagestatechangedevent)
    {
    }

    protected void d()
    {
        h();
        if (c != null)
        {
            c.b(this);
        }
        c = null;
    }

    public at e()
    {
        return e;
    }

    public void f()
    {
        d();
    }

    protected void g()
    {
    }

    protected void h()
    {
    }

    public void i()
    {
        if (d != null)
        {
            d.w();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b();
        g();
        if (!IntroDialogUtils.b(getFragmentManager(), g, null))
        {
            if (c != null)
            {
                c.a(false, null);
            }
            j();
        } else
        if (c != null)
        {
            c.X();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = new View(viewgroup.getContext());
        return b;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        d();
    }
}

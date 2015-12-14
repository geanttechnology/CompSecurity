// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            n, k, p

public abstract class o extends Fragment
{

    protected n a;
    protected k b;
    protected CameraCtrl c;
    private View d;
    private HorizontalGridView e;
    private HorizontalGridView f;
    private View g;
    private View h;
    private com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p i;
    private com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p j;

    public o(CameraCtrl cameractrl)
    {
        g = null;
        i = new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p() {

            final o a;

            public void a(AdapterView adapterview, View view, int l, long l1)
            {
                if (l == a.a.b())
                {
                    return;
                }
                a.a.b(l);
                if (a.b.a() == 0)
                {
                    a.b.c(1);
                    o.b(a).a(1, true);
                }
                view.post(new Runnable(this, view, l) {

                    final View a;
                    final int b;
                    final _cls4 c;

                    public void run()
                    {
                        ((TemplateButton)a).a(false);
                        c.a.a.a(b, false);
                    }

            
            {
                c = _pcls4;
                a = view;
                b = l;
                super();
            }
                });
                a.c();
            }

            
            {
                a = o.this;
                super();
            }
        };
        j = new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p() {

            final o a;

            public void a(AdapterView adapterview, View view, int l, long l1)
            {
                if (l == a.b.a())
                {
                    return;
                }
                a.b.c(l);
                if (l != 0) goto _L2; else goto _L1
_L1:
                p.a().a(a.b(), null);
                a.a.b(-1);
                o.a(a).a(-1, true);
_L4:
                a.c();
                return;
_L2:
                if (a.a.b() == -1)
                {
                    l = a.d();
                    a.a.b(l);
                    o.a(a).a(l, true);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = o.this;
                super();
            }
        };
        c = cameractrl;
    }

    static HorizontalGridView a(o o1)
    {
        return o1.f;
    }

    static HorizontalGridView b(o o1)
    {
        return o1.e;
    }

    static View c(o o1)
    {
        return o1.h;
    }

    private void f()
    {
        e = (HorizontalGridView)d.findViewById(0x7f0c0699);
        e.setChoiceMode(1);
        f = (HorizontalGridView)d.findViewById(0x7f0c069a);
        f.setChoiceMode(1);
        android.app.Activity activity = getActivity();
        if (a == null)
        {
            a = new n(activity, b());
        }
        if (b == null)
        {
            b = new k(activity, b());
        }
        if (getActivity() == null)
        {
            Globals.d();
        }
        int l = d();
        a.b(l);
        e.setAdapter(b);
        f.setAdapter(a);
        g = d.findViewById(0x7f0c0697);
        h = d.findViewById(0x7f0c0107);
    }

    private void g()
    {
        f.setOnItemClickListener(i);
        e.setOnItemClickListener(j);
        f.post(new Runnable() {

            final o a;

            public void run()
            {
                int l = a.d();
                if (l > -1)
                {
                    o.a(a).a(a.a.getView(l, null, null), l, 0L);
                } else
                {
                    o.a(a).a(-1, true);
                }
                o.a(a).setSelection(l);
            }

            
            {
                a = o.this;
                super();
            }
        });
        e.post(new Runnable() {

            final o a;

            public void run()
            {
                int l = a.e();
                if (l > -1)
                {
                    o.b(a).a(a.b.getView(l, null, null), l, 0L);
                }
                o.b(a).setSelection(l);
            }

            
            {
                a = o.this;
                super();
            }
        });
        if (g != null)
        {
            g.setOnTouchListener(new android.view.View.OnTouchListener() {

                final o a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    boolean flag = o.c(a).dispatchTouchEvent(motionevent);
                    if (a.c != null)
                    {
                        if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
                        {
                            if (!flag);
                        } else
                        if (motionevent.getAction() != 1 && motionevent.getAction() == 6)
                        {
                            return true;
                        }
                    }
                    return true;
                }

            
            {
                a = o.this;
                super();
            }
            });
        }
    }

    private void h()
    {
        if (g != null)
        {
            g.setOnTouchListener(null);
        }
    }

    private boolean i()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (PanelDataCenter.a().i(p.a().b(b())) != null)
        {
            flag = flag1;
            if (PanelDataCenter.a().i(p.a().b(b())).k() != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    protected abstract int a();

    protected abstract BeautyMode b();

    protected abstract void c();

    protected int d()
    {
        boolean flag = false;
        if (p.a().c(b()) != null || b.a() != 0) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
_L4:
        return byte0;
_L2:
        String s = p.a().a(b());
        byte0 = flag;
        if (s == null)
        {
            continue;
        }
        int l = 0;
        do
        {
            byte0 = flag;
            if (l >= a.getCount())
            {
                continue;
            }
            if (a.a(l) != null && a.a(l).c.equals(s))
            {
                return l;
            }
            l++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected int e()
    {
        at at1 = p.a().c(b());
        if (at1 != null)
        {
            if (i())
            {
                return -1;
            }
            int l = 0;
            while (l < b.getCount()) 
            {
                if (b.b(l) != null && b.b(l).equals(at1))
                {
                    return l;
                }
                l++;
            }
        }
        return 0;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        f();
        g();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d = layoutinflater.inflate(a(), viewgroup, false);
        return d;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        h();
    }
}

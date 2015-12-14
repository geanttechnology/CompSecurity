// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            k, BeautyToolPanel

public class e extends Fragment
    implements k, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k
{

    private final android.content.DialogInterface.OnDismissListener a = new android.content.DialogInterface.OnDismissListener() {

        final e a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            if (a.k != null)
            {
                a.k.Y();
            }
            a.c();
        }

            
            {
                a = e.this;
                super();
            }
    };
    protected View g;
    protected View h;
    protected View i;
    protected boolean j;
    protected EditViewActivity k;
    protected View l;
    protected BeautyToolPanel m;
    protected at n;
    protected boolean o;
    protected float p;
    protected boolean q;

    public e()
    {
        g = null;
        h = null;
        i = null;
        j = false;
        k = null;
        l = null;
        m = null;
        n = null;
        o = false;
        p = -1F;
    }

    static void a(e e1)
    {
        e1.h();
    }

    private void a(boolean flag)
    {
        if (i == null)
        {
            return;
        }
        View view = i;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        view.setVisibility(i1);
    }

    private void h()
    {
        if (o)
        {
            return;
        }
        if (k != null)
        {
            k.W();
            if (k.w() != 0)
            {
                k.a(Boolean.valueOf(true), Boolean.valueOf(true));
                if (n != null)
                {
                    at at1 = n.m();
                    k.a(at1, true);
                }
                j = true;
            } else
            {
                k.a(Boolean.valueOf(false), Boolean.valueOf(false));
                j = false;
            }
        }
        a(j);
    }

    private void j()
    {
        Globals.d().i().b(Globals.d().t());
    }

    protected void a()
    {
        at at1;
        i i1;
        BeautyMode beautymode;
        k = Globals.d().t();
        j = false;
        i1 = StatusManager.j().d();
        beautymode = StatusManager.j().s();
        at at2 = new at(0);
        List list = PanelDataCenter.a().d(beautymode);
        at1 = at2;
        if (list != null)
        {
            at1 = at2;
            if (list.size() > 0)
            {
                at1 = (at)list.get(0);
            }
        }
        q = true;
        MotionControlHelper.e().m();
        if (i1 == null) goto _L2; else goto _L1
_L1:
        if (beautymode != BeautyMode.m || i1.f() == null || i1.f().e() == null) goto _L4; else goto _L3
_L3:
        float f1;
        at1 = i1.f().e();
        f1 = i1.f().g();
        boolean flag;
        if (!MotionControlHelper.e().o())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = flag;
_L6:
        if (at1 != null)
        {
            if (k != null)
            {
                k.a(at1, true);
            }
            n = at1;
        }
        Globals.d().j().a(at1);
        if (k != null)
        {
            k.a(this);
            k.a(Boolean.valueOf(true), f1, 100F, 0.0F);
            k.a(this);
            k.a(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        p = f1;
        h = g.findViewById(0x7f0c064a);
        l = g.findViewById(0x7f0c065e);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final e a;

                public void onClick(View view)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.e.a(a);
                }

            
            {
                a = e.this;
                super();
            }
            });
        }
        b(((Bitmap) (null)));
        i = g.findViewById(0x7f0c065d);
        a(false);
        o = false;
        return;
_L4:
        if (beautymode == BeautyMode.l && i1.e() != null && i1.e().e() != null)
        {
            at1 = i1.e().e();
            f1 = i1.e().g();
            boolean flag1;
            if (!MotionControlHelper.e().o())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            q = flag1;
            continue; /* Loop/switch isn't completed */
        }
        if (beautymode == BeautyMode.a && i1.g() != null && i1.g().e() != null)
        {
            at1 = i1.g().e();
            f1 = i1.g().g();
            boolean flag2;
            if (!MotionControlHelper.e().o())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            q = flag2;
            continue; /* Loop/switch isn't completed */
        }
        if (beautymode == BeautyMode.b && i1.i() != null && i1.i().e() != null)
        {
            at1 = i1.i().e();
            f1 = i1.i().g();
            boolean flag3;
            if (!MotionControlHelper.e().o())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            q = flag3;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        f1 = 50F;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        d();
    }

    public void a(at at1)
    {
        if (k == null)
        {
            return;
        }
        if ((at1 instanceof ba) && at1.d() != 0)
        {
            m.a(at1.d());
            ArrayList arraylist = new ArrayList();
            arraylist.add(Integer.valueOf(at1.d()));
            MotionControlHelper.e().c(arraylist);
        } else
        {
            at1.a(m.K());
        }
        if (l != null)
        {
            ((ImageView)l).setBackgroundColor(at1.e());
        }
        if (MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, at1, true))
        {
            k.j(true);
            j();
        }
        m.a(at1, false);
        m.a(at1, StatusManager.j().e());
        n = at1;
    }

    public void a(az az)
    {
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.panel.a a1)
    {
        m = (BeautyToolPanel)a1;
        if (m != null)
        {
            m.b(null);
        }
    }

    public void a(String s)
    {
    }

    public void a(String s, boolean flag)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = PanelDataCenter.a().p(s);
        s = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj1 = ((ax) (obj1)).f();
        s = obj;
        if (obj1 != null)
        {
            try
            {
                s = BitmapFactory.decodeStream(new BufferedInputStream(Globals.d().getAssets().open(((String) (obj1)))));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = obj;
            }
        }
        b(s);
        return;
    }

    public transient void a(String s, Float afloat[])
    {
    }

    protected void b()
    {
    }

    public void b(Bitmap bitmap)
    {
        if (l != null)
        {
            BeautyMode beautymode = StatusManager.j().s();
            if (bitmap == null)
            {
                if (beautymode == BeautyMode.a)
                {
                    ((ImageView)l).setImageResource(0x7f0202d4);
                    return;
                }
                if (beautymode == BeautyMode.m)
                {
                    ((ImageView)l).setImageResource(0x7f0202d6);
                    return;
                }
                if (beautymode == BeautyMode.l)
                {
                    ((ImageView)l).setImageResource(0x7f0202d7);
                    return;
                }
                if (beautymode == BeautyMode.v)
                {
                    ((ImageView)l).setImageResource(0x7f0202de);
                    return;
                }
                if (beautymode == BeautyMode.r)
                {
                    ((ImageView)l).setImageResource(0x7f0202d5);
                    return;
                }
            } else
            {
                ((ImageView)l).setImageBitmap(bitmap);
                return;
            }
        }
    }

    public void b(ImageStateChangedEvent imagestatechangedevent)
    {
        d();
    }

    public void b(boolean flag)
    {
        o = flag;
    }

    protected void c()
    {
    }

    protected void d()
    {
        if (l != null && k != null)
        {
            Object obj1 = StatusManager.j().s();
            Object obj;
            long l1;
            boolean flag;
            if (k.C() == 0 && obj1 != BeautyMode.r)
            {
                k.a(Boolean.valueOf(false), Boolean.valueOf(true));
            }
            l1 = StatusManager.j().l();
            MotionControlHelper.e().t();
            obj = (EditViewActivity)getActivity();
            if (obj != null)
            {
                flag = ((EditViewActivity) (obj)).A();
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = StatusManager.j().j(l1);
            } else
            {
                obj = StatusManager.j().g(l1);
            }
            if (obj != null)
            {
                obj = ((d) (obj)).e();
                if (obj != null)
                {
                    obj = ((a) (obj)).f();
                    if (obj != null && ((v) (obj)).a() != null)
                    {
                        k.a(((v) (obj)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                        obj1 = new ArrayList();
                        ((List) (obj1)).add(((v) (obj)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
                        MotionControlHelper.e().c(((List) (obj1)));
                        obj = ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                    } else
                    {
                        k.a(0);
                        obj = new ArrayList();
                        ((List) (obj)).add(Integer.valueOf(0));
                        MotionControlHelper.e().c(((List) (obj)));
                        obj = PanelDataCenter.a().d(((BeautyMode) (obj1)));
                        if (obj != null && ((List) (obj)).size() > 0)
                        {
                            obj = (at)((List) (obj)).get(0);
                        } else
                        {
                            obj = null;
                        }
                    }
                    if (obj != null)
                    {
                        Globals.d().j().a(((at) (obj)));
                        ((ImageView)l).setBackgroundColor(((at) (obj)).e());
                        n = ((at) (obj));
                        k.a(((at) (obj)), true);
                        return;
                    }
                }
            }
        }
    }

    public at e()
    {
        return n;
    }

    public void f()
    {
        g();
    }

    protected void g()
    {
        if (k != null)
        {
            k.b(this);
        }
        j = false;
        k = null;
        o = false;
        p = -1F;
    }

    public void i()
    {
        if (m != null)
        {
            m.h();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        a();
        b();
        super.onActivityCreated(bundle);
        bundle = StatusManager.j().s();
        boolean flag;
        if (m != null && m.C())
        {
            m.a(m.o);
            bundle = IntroDialogUtils.a(bundle, m.C(), false);
            flag = IntroDialogUtils.a(getFragmentManager(), a, null, bundle, false);
        } else
        {
            flag = IntroDialogUtils.b(getFragmentManager(), a, null);
        }
        if (!flag)
        {
            if (k != null)
            {
                k.a(false, null);
            }
            c();
        } else
        if (k != null)
        {
            k.X();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f030167, viewgroup, false);
        return g;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        g();
    }
}

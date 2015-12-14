// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.af;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            k, BeautyToolPanel, d

public class c extends Fragment
    implements k, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k
{

    private List A;
    private List B;
    private final Handler C = new Handler(Looper.getMainLooper());
    private ag D;
    protected h a;
    protected az b;
    android.view.View.OnTouchListener c;
    private View d;
    private ViewSwitcher e;
    private ImageView f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private GestureDetector q;
    private boolean r;
    private boolean s;
    private Boolean t;
    private com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode u;
    private EditViewActivity v;
    private BeautyToolPanel w;
    private View x;
    private int y;
    private List z;

    public c()
    {
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        r = false;
        s = false;
        t = null;
        u = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a;
        v = null;
        w = null;
        x = null;
        y = 0;
        z = null;
        A = null;
        D = null;
        c = new android.view.View.OnTouchListener() {

            final c a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (c.q(a))
                {
                    return true;
                } else
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.k(a, view);
                    return com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.r(a).onTouchEvent(motionevent);
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
    }

    static int a(c c1, int i1)
    {
        c1.y = i1;
        return i1;
    }

    static GestureDetector a(c c1, GestureDetector gesturedetector)
    {
        c1.q = gesturedetector;
        return gesturedetector;
    }

    static View a(c c1, View view)
    {
        c1.g = view;
        return view;
    }

    static ImageView a(c c1, ImageView imageview)
    {
        c1.f = imageview;
        return imageview;
    }

    static ViewSwitcher a(c c1, ViewSwitcher viewswitcher)
    {
        c1.e = viewswitcher;
        return viewswitcher;
    }

    static EditViewActivity a(c c1)
    {
        return c1.v;
    }

    static EditViewActivity a(c c1, EditViewActivity editviewactivity)
    {
        c1.v = editviewactivity;
        return editviewactivity;
    }

    static ag a(c c1, ag ag1)
    {
        c1.D = ag1;
        return ag1;
    }

    private aw a(int i1)
    {
        String s2 = "";
        String s1 = s2;
        if (i1 >= 0)
        {
            s1 = s2;
            if (i1 < z.size())
            {
                s1 = (String)z.get(i1);
            }
        }
        return PanelDataCenter.a().i(s1);
    }

    static com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode a(c c1, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        c1.u = switchermode;
        return switchermode;
    }

    private Boolean a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        int i1;
        if (B.size() == 0)
        {
            return null;
        }
        if (switchermode != null && switchermode.ordinal() < B.size())
        {
            return Boolean.valueOf(((at)MotionControlHelper.e().C().f().get(switchermode.ordinal())).k());
        }
        i1 = 0;
_L3:
        if (i1 >= B.size())
        {
            break MISSING_BLOCK_LABEL_170;
        }
        if (i1 + 1 >= B.size() || ((at)B.get(i1)).k() == ((at)B.get(i1 + 1)).k()) goto _L2; else goto _L1
_L1:
        switchermode = Boolean.valueOf(false);
_L4:
        if (switchermode.booleanValue())
        {
            return Boolean.valueOf(((at)B.get(0)).k());
        } else
        {
            return null;
        }
_L2:
        i1++;
          goto _L3
        switchermode = Boolean.valueOf(true);
          goto _L4
    }

    static Boolean a(c c1, Boolean boolean1)
    {
        c1.t = boolean1;
        return boolean1;
    }

    static Boolean a(c c1, ArrayList arraylist, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        return c1.a(arraylist, switchermode);
    }

    private Boolean a(ArrayList arraylist, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        int i1;
        if (arraylist.size() == 0)
        {
            return null;
        }
        i1 = 0;
_L3:
        if (i1 >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (i1 + 1 >= arraylist.size() || ((at)arraylist.get(i1)).k() == ((at)arraylist.get(i1 + 1)).k()) goto _L2; else goto _L1
_L1:
        Boolean boolean1 = Boolean.valueOf(false);
_L4:
        if (boolean1.booleanValue())
        {
            if (switchermode != null && switchermode.ordinal() < arraylist.size())
            {
                return Boolean.valueOf(((at)MotionControlHelper.e().C().f().get(switchermode.ordinal())).k());
            } else
            {
                return Boolean.valueOf(((at)arraylist.get(0)).k());
            }
        } else
        {
            return null;
        }
_L2:
        i1++;
          goto _L3
        boolean1 = Boolean.valueOf(true);
          goto _L4
    }

    static List a(c c1, List list)
    {
        c1.B = list;
        return list;
    }

    private void a(LinearLayout linearlayout, android.view.View.OnTouchListener ontouchlistener)
    {
        for (int i1 = 0; i1 < linearlayout.getChildCount(); i1++)
        {
            Object obj = (RelativeLayout)linearlayout.getChildAt(i1);
            if (obj == null)
            {
                continue;
            }
            obj = (ImageView)((RelativeLayout) (obj)).getChildAt(0);
            if (obj != null)
            {
                ((ImageView) (obj)).setOnTouchListener(ontouchlistener);
            }
        }

    }

    private void a(aw aw1)
    {
        if (aw1 == null)
        {
            return;
        } else
        {
            A = aw1.c();
            return;
        }
    }

    private void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, at at1)
    {
        if (v == null)
        {
            return;
        }
        v.W();
        if (w.m() != 0)
        {
            w.a(0);
            w.h(true);
            w.a(at1, true);
            w.a(a(switchermode));
        } else
        if (u == switchermode)
        {
            w.a(8);
            w.h(false);
            w.a(a(((com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode) (null))));
        } else
        {
            w.a(at1, true);
            w.a(a(switchermode));
        }
        c(switchermode);
    }

    static void a(c c1, aw aw1)
    {
        c1.c(aw1);
    }

    static void a(c c1, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, at at1)
    {
        c1.a(switchermode, at1);
    }

    static void a(c c1, String s1)
    {
        c1.b(s1);
    }

    private boolean a(i i1)
    {
        Object obj;
        long l1 = StatusManager.j().l();
        if (v.p())
        {
            obj = v.r();
        } else
        {
            obj = StatusManager.j().f(Long.valueOf(l1).longValue());
        }
        break MISSING_BLOCK_LABEL_26;
        if (obj != null && ((a) (obj)).f() != null && ((a) (obj)).f().g() != null && ((a) (obj)).f().g().b() != null)
        {
            obj = ((a) (obj)).f().g();
            Object obj1 = i1.b();
            Object obj2 = ((i) (obj)).b();
            i1 = ((r) (obj1)).b();
            obj = ((r) (obj2)).b();
            obj1 = ((r) (obj1)).c();
            obj2 = ((r) (obj2)).c();
            if ((obj1 == null || ((String) (obj1)).equals(obj2)) && (i1 == null || i1.equals(obj)))
            {
                return false;
            }
        }
        return true;
    }

    static boolean a(c c1, i i1)
    {
        return c1.a(i1);
    }

    static boolean a(c c1, boolean flag)
    {
        c1.s = flag;
        return flag;
    }

    private int b(at at1)
    {
        int i1 = 0;
        if (at1 != null)
        {
            i1 = Color.rgb(at1.a().intValue(), at1.b().intValue(), at1.c().intValue());
        }
        return i1;
    }

    static View b(c c1, View view)
    {
        c1.h = view;
        return view;
    }

    private void b()
    {
        (new AsyncTask() {

            String a;
            String b;
            boolean c;
            final c d;

            protected transient Boolean a(Void avoid[])
            {
                if (c.g(d).size() > 0)
                {
                    Globals.d().j().d(c.g(d));
                }
                MotionControlHelper.e().b();
                avoid = MotionControlHelper.e().d();
                if (avoid != null && avoid.size() > 0)
                {
                    for (int i1 = 0; i1 < c.g(d).size(); i1++)
                    {
                        if (avoid.size() > i1)
                        {
                            ((at)c.g(d).get(i1)).a(((Integer)avoid.get(i1)).intValue());
                        }
                    }

                    Globals.d().j().c(avoid);
                }
                if (c.j(d) != null && c.j(d).contains(b))
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, c.j(d).indexOf(b));
                }
                if (c)
                {
                    if (MotionControlHelper.e().a(null, c))
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).i(false);
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a(new com.cyberlink.youcammakeup.activity.c(this) {

                            final _cls1 a;

                            public void a()
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(a.d).b(this);
                                a.a();
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return Boolean.valueOf(true);
                    }
                    a();
                } else
                {
                    boolean flag;
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d) != null)
                    {
                        flag = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).A();
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        avoid = StatusManager.j().j(StatusManager.j().l());
                    } else
                    {
                        avoid = StatusManager.j().g(StatusManager.j().l());
                    }
                    if (avoid != null)
                    {
                        avoid = avoid.e();
                        if (avoid != null)
                        {
                            avoid.a(MotionControlHelper.e().M());
                        }
                    }
                    StatusManager.j().y();
                    a();
                }
                return Boolean.valueOf(false);
            }

            void a()
            {
                d.getActivity().runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        a.d.a();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            protected void a(Boolean boolean1)
            {
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d) != null)
                {
                    if (!boolean1.booleanValue())
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).j(false);
                        c.m(d);
                    }
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, b);
                    c.c(d).a(((at)c.g(d).get(0)).d(), 0.0F, 0.0F, false, true);
                    c.c(d).k(MotionControlHelper.e().a(MotionControlHelper.e().C()));
                    c.c(d).a(c.c(d, null));
                    c.j(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c064f));
                    if (c.n(d) != null)
                    {
                        c.n(d).setOnClickListener(new android.view.View.OnClickListener(this) {

                            final _cls1 a;

                            public void onClick(View view)
                            {
                                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(a.d) == null)
                                {
                                    return;
                                } else
                                {
                                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(a.d).S();
                                    return;
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.o(d).setOnClickListener(new android.view.View.OnClickListener(this) {

                            final _cls1 a;

                            public void onClick(View view)
                            {
                                view.setClickable(false);
                                view.post(new Runnable(this, new ch(this, view) {

                                    final View a;
                                    final _cls3 b;

                                    public void onAnimationEnd(Animator animator)
                                    {
                                        a.setClickable(true);
                                    }

            
            {
                b = _pcls3;
                a = view;
                super();
            }
                                }) {

                                    final ch a;
                                    final _cls3 b;

                                    public void run()
                                    {
                                        BeautyToolPanel beautytoolpanel = c.c(b.a.d);
                                        boolean flag;
                                        if (c.c(b.a.d).r() != 0)
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        beautytoolpanel.b(flag, a);
                                    }

            
            {
                b = _pcls3;
                a = ch;
                super();
            }
                                });
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return;
                    }
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Boolean)obj);
            }

            protected void onPreExecute()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, Globals.d().t());
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d) == null)
                {
                    return;
                }
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, false);
                d.a = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, null);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a(d);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a(d);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).j(true);
                c.c(d).a(8);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, new GestureDetector(d.getActivity(), new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.d(d)));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, (ViewSwitcher)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0651));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, (ImageView)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0652));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0654));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0655));
                c.c(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0659));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c065a));
                c.e(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c065b));
                c.f(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c065c));
                c.g(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0656));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.h(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0657));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.i(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0658));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, new ag(d.getActivity()));
                Object obj = new com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k(d.getActivity(), null);
                obj.g = false;
                ((com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k) (obj)).a(0.15F);
                c.e(d).a(d.getActivity().getFragmentManager(), ((com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k) (obj)));
                MotionControlHelper.e().m();
                obj = new at(0, 50, null);
                obj = Arrays.asList(new at[] {
                    obj, obj, obj, obj, obj, obj
                });
                Globals.d().j().d(((List) (obj)));
                StatusManager.j().a(c.f(d));
                obj = StatusManager.j().d();
                if (obj != null && ((i) (obj)).b() != null && ((i) (obj)).b().f().size() != 0 && ((i) (obj)).b().c() != null && PanelDataCenter.f(((i) (obj)).b().c()))
                {
                    int i1 = ((i) (obj)).b().f().size() - 1;
                    int k1 = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values().length - 1;
                    c c1 = d;
                    com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode aswitchermode[] = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values();
                    if (i1 > k1)
                    {
                        i1 = k1;
                    }
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(c1, aswitchermode[i1]);
                    b = ((i) (obj)).b().c();
                    a = ((i) (obj)).b().b();
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, new ArrayList());
                    at at1;
                    for (Iterator iterator = ((i) (obj)).b().f().iterator(); iterator.hasNext(); c.g(d).add(at1.m()))
                    {
                        at1 = (at)iterator.next();
                    }

                    if (c.g(d).get(0) != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a((at)c.g(d).get(0), true);
                    }
                    c = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, ((i) (obj)));
                    StatusManager.j().c(b);
                    obj = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.h(d);
                } else
                {
                    int j1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.i(d);
                    if (b == null)
                    {
                        if (c.j(d) != null && c.j(d).size() > 0 && j1 >= 0 && j1 < c.j(d).size())
                        {
                            obj = (String)c.j(d).get(j1);
                        } else
                        {
                            obj = null;
                        }
                        b = ((String) (obj));
                    }
                    StatusManager.j().c(b);
                    obj = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.h(d);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, ((aw) (obj)));
                }
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d, ((aw) (obj)));
                c.c(d, ((aw) (obj)));
                if (a == null)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.k(d) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.k(d).size() > 0)
                    {
                        obj = (String)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.k(d).get(0);
                    } else
                    {
                        obj = null;
                    }
                    a = ((String) (obj));
                }
                StatusManager.j().b(a);
                c.l(d);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d, c.f(d));
            }

            
            {
                d = c.this;
                super();
                a = null;
                b = null;
                c = true;
            }
        }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private void b(aw aw1)
    {
label0:
        {
            {
                while (e == null || aw1 == null) 
                {
                    return;
                }
                x = null;
                Object obj5 = null;
                Object obj3 = null;
                at at1 = null;
                Object obj4 = null;
                Object obj = Boolean.valueOf(false);
                Object obj1 = Boolean.valueOf(false);
                Object obj2 = Boolean.valueOf(false);
                Object obj6 = e.getNextView();
                if (obj6 != null)
                {
                    e.removeView(((View) (obj6)));
                }
                List list = aw1.i();
                if (aw1.b() != 1)
                {
                    break label0;
                }
                obj1 = k();
                Object obj7;
                View view;
                boolean flag;
                boolean flag1;
                boolean flag2;
                if (list != null && list.size() >= 1)
                {
                    aw1 = (at)list.get(0);
                } else
                {
                    aw1 = null;
                }
                if (aw1 != null)
                {
                    ((ImageView)((View) (obj1)).findViewById(0x7f0c0880)).setBackgroundColor(b(((at) (aw1))));
                    obj = Boolean.valueOf(aw1.k());
                }
                if (obj != null)
                {
                    if (((Boolean) (obj)).booleanValue())
                    {
                        aw1 = getResources().getDrawable(0x7f0202d9);
                    } else
                    {
                        aw1 = getResources().getDrawable(0x7f0202d8);
                    }
                    ((ImageView)((View) (obj1)).findViewById(0x7f0c0881)).setImageDrawable(aw1);
                }
                e.addView(((View) (obj1)));
            }
            MotionControlHelper.e().b(list);
            Globals.d().j().d(list);
            return;
        }
        if (aw1.b() == 2)
        {
            obj5 = l();
            if (list != null && list.size() >= 2)
            {
                obj3 = (at)list.get(0);
                obj2 = (at)list.get(1);
            } else
            {
                aw1 = null;
                obj2 = obj3;
                obj3 = aw1;
            }
            aw1 = ((aw) (obj1));
            obj4 = obj;
            if (obj3 != null)
            {
                aw1 = ((aw) (obj1));
                obj4 = obj;
                if (obj2 != null)
                {
                    ((ImageView)((View) (obj5)).findViewById(0x7f0c0881)).setBackgroundColor(b(((at) (obj3))));
                    ((ImageView)((View) (obj5)).findViewById(0x7f0c0882)).setBackgroundColor(b(((at) (obj2))));
                    obj4 = Boolean.valueOf(((at) (obj3)).k());
                    aw1 = Boolean.valueOf(((at) (obj2)).k());
                }
            }
            if (obj4 != null && aw1 != null)
            {
                if (((Boolean) (obj4)).booleanValue())
                {
                    obj = getResources().getDrawable(0x7f0202d9);
                } else
                {
                    obj = getResources().getDrawable(0x7f0202d8);
                }
                ((ImageView)((View) (obj5)).findViewById(0x7f0c0881)).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                if (aw1.booleanValue())
                {
                    aw1 = getResources().getDrawable(0x7f0202d9);
                } else
                {
                    aw1 = getResources().getDrawable(0x7f0202d8);
                }
                ((ImageView)((View) (obj5)).findViewById(0x7f0c0882)).setImageDrawable(aw1);
            }
            e.addView(((View) (obj5)));
        } else
        if (aw1.b() == 3 || aw1.b() == 4)
        {
            view = m();
            if (list != null && list.size() >= 3)
            {
                aw1 = (at)list.get(0);
                obj5 = (at)list.get(1);
                at1 = (at)list.get(2);
                if (list.size() == 4)
                {
                    obj4 = (at)list.get(3);
                }
            } else
            {
                aw1 = null;
            }
            obj3 = obj2;
            obj6 = obj1;
            obj7 = obj;
            if (aw1 != null)
            {
                obj3 = obj2;
                obj6 = obj1;
                obj7 = obj;
                if (obj5 != null)
                {
                    obj3 = obj2;
                    obj6 = obj1;
                    obj7 = obj;
                    if (at1 != null)
                    {
                        ((ImageView)view.findViewById(0x7f0c0883)).setBackgroundColor(b(((at) (aw1))));
                        ((ImageView)view.findViewById(0x7f0c0884)).setBackgroundColor(b(((at) (obj5))));
                        ((ImageView)view.findViewById(0x7f0c0885)).setBackgroundColor(b(at1));
                        aw1 = Boolean.valueOf(aw1.k());
                        obj = Boolean.valueOf(((at) (obj5)).k());
                        obj1 = Boolean.valueOf(at1.k());
                        obj3 = obj1;
                        obj6 = obj;
                        obj7 = aw1;
                        if (obj4 != null)
                        {
                            ((at) (obj4)).k();
                            obj7 = aw1;
                            obj6 = obj;
                            obj3 = obj1;
                        }
                    }
                }
            }
            if (obj7 != null && obj6 != null && obj3 != null)
            {
                if (((Boolean) (obj7)).booleanValue())
                {
                    aw1 = getResources().getDrawable(0x7f0202db);
                } else
                {
                    aw1 = getResources().getDrawable(0x7f0202da);
                }
                ((ImageView)view.findViewById(0x7f0c0883)).setImageDrawable(aw1);
                if (((Boolean) (obj6)).booleanValue())
                {
                    aw1 = getResources().getDrawable(0x7f0202db);
                } else
                {
                    aw1 = getResources().getDrawable(0x7f0202da);
                }
                ((ImageView)view.findViewById(0x7f0c0884)).setImageDrawable(aw1);
                if (((Boolean) (obj3)).booleanValue())
                {
                    aw1 = getResources().getDrawable(0x7f0202db);
                } else
                {
                    aw1 = getResources().getDrawable(0x7f0202da);
                }
                ((ImageView)view.findViewById(0x7f0c0885)).setImageDrawable(aw1);
            }
            e.addView(view);
        } else
        if (aw1.b() == 4)
        {
            obj6 = n();
            if (list != null && list.size() >= 4)
            {
                obj3 = (at)list.get(0);
                at1 = (at)list.get(1);
                aw1 = (at)list.get(2);
                obj5 = (at)list.get(3);
                obj4 = obj3;
                obj3 = at1;
            } else
            {
                obj5 = null;
                obj4 = null;
                aw1 = null;
                obj3 = null;
            }
            if (obj4 != null && obj3 != null && aw1 != null && obj5 != null)
            {
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0886)).setBackgroundColor(b(((at) (obj4))));
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0887)).setBackgroundColor(b(((at) (obj3))));
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0888)).setBackgroundColor(b(((at) (aw1))));
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0889)).setBackgroundColor(b(((at) (obj5))));
                flag = ((at) (obj4)).k();
                flag1 = ((at) (obj3)).k();
                flag2 = aw1.k();
                obj2 = Boolean.valueOf(((at) (obj5)).k());
                obj3 = Boolean.valueOf(flag);
                obj = Boolean.valueOf(flag1);
                aw1 = Boolean.valueOf(flag2);
            } else
            {
                obj3 = Boolean.valueOf(false);
                aw1 = ((aw) (obj2));
                obj2 = obj3;
                obj3 = obj;
                obj = obj1;
            }
            if (obj3 != null && obj != null && aw1 != null && obj2 != null)
            {
                if (((Boolean) (obj3)).booleanValue())
                {
                    obj1 = getResources().getDrawable(0x7f0202db);
                } else
                {
                    obj1 = getResources().getDrawable(0x7f0202da);
                }
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0883)).setImageDrawable(((android.graphics.drawable.Drawable) (obj1)));
                if (((Boolean) (obj)).booleanValue())
                {
                    obj = getResources().getDrawable(0x7f0202db);
                } else
                {
                    obj = getResources().getDrawable(0x7f0202da);
                }
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0884)).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                if (aw1.booleanValue())
                {
                    aw1 = getResources().getDrawable(0x7f0202db);
                } else
                {
                    aw1 = getResources().getDrawable(0x7f0202da);
                }
                ((ImageView)((View) (obj6)).findViewById(0x7f0c0885)).setImageDrawable(aw1);
            }
            e.addView(((View) (obj6)));
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_189;
        }
    }

    private void b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        w.a(MotionControlHelper.e().a(switchermode));
    }

    private void b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, at at1)
    {
        if (at1 != null)
        {
            int i1 = at1.e();
            switchermode = d(switchermode);
            if (switchermode != null)
            {
                ((ImageView)switchermode).setBackgroundColor(i1);
                return;
            }
        }
    }

    static void b(c c1)
    {
        c1.o();
    }

    static void b(c c1, aw aw1)
    {
        c1.d(aw1);
    }

    static void b(c c1, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        c1.c(switchermode);
    }

    private void b(String s1)
    {
        C.post(new Runnable(s1) {

            final String a;
            final c b;

            public void run()
            {
                if (c.c(b) != null)
                {
                    c.c(b).b(a);
                }
            }

            
            {
                b = c.this;
                a = s1;
                super();
            }
        });
    }

    static View c(c c1, View view)
    {
        c1.i = view;
        return view;
    }

    static BeautyToolPanel c(c c1)
    {
        return c1.w;
    }

    static Boolean c(c c1, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        return c1.a(switchermode);
    }

    private void c()
    {
_L2:
        return;
        if (z == null || y + 1 >= z.size()) goto _L2; else goto _L1
_L1:
        aw aw1;
        y = y + 1;
        aw1 = a(y);
        if (aw1 == null) goto _L2; else goto _L3
_L3:
        o();
        b(aw1);
        StatusManager.j().c(aw1.a());
        if (t != null) goto _L5; else goto _L4
_L4:
        e.setInAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f04002f));
        e.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f040030));
        t = Boolean.valueOf(false);
_L7:
        e.showNext();
        c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        e.postDelayed(new Runnable(aw1) {

            final aw a;
            final c b;

            public void run()
            {
                c.p(b);
                if (a == null)
                {
                    c.c(b).a(null);
                    return;
                } else
                {
                    c.c(b).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(b, (ArrayList)a.i(), null));
                    return;
                }
            }

            
            {
                b = c.this;
                a = aw1;
                super();
            }
        }, 1000L);
        return;
_L5:
        if (t.booleanValue())
        {
            e.setInAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f04002f));
            e.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f040030));
            t = Boolean.valueOf(false);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void c(aw aw1)
    {
        if (aw1 != null)
        {
            int i1 = aw1.b();
            Object obj;
            if (StatusManager.j().e() != null)
            {
                obj = MotionControlHelper.e().d();
            } else
            {
                obj = new ArrayList();
                ((List) (obj)).add(Integer.valueOf(50));
                if (i1 > 1)
                {
                    ((List) (obj)).add(Integer.valueOf(50));
                } else
                {
                    ((List) (obj)).add(Integer.valueOf(0));
                }
                if (i1 > 2)
                {
                    ((List) (obj)).add(Integer.valueOf(50));
                } else
                {
                    ((List) (obj)).add(Integer.valueOf(0));
                }
                if (i1 > 3)
                {
                    ((List) (obj)).add(Integer.valueOf(50));
                } else
                {
                    ((List) (obj)).add(Integer.valueOf(0));
                }
            }
            B = aw1.i();
            aw1 = ((aw) (obj));
        } else
        {
            B = new ArrayList();
            B.add(new at(0));
            aw1 = null;
        }
        i1 = 0;
        while (i1 < B.size()) 
        {
            obj = (at)B.get(i1);
            int j1;
            if (aw1 != null && aw1.size() > i1)
            {
                j1 = ((Integer)aw1.get(i1)).intValue();
            } else
            {
                j1 = 50;
            }
            ((at) (obj)).a(j1);
            i1++;
        }
    }

    private void c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        aw aw1;
        byte byte2;
        byte byte5;
        byte2 = 0;
        byte5 = 4;
        aw1 = g();
        if (aw1 != null && v != null && g != null && h != null && i != null && j != null && k != null && l != null && m != null && n != null && o != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        int j1;
        byte byte0;
        byte byte1;
        byte byte3;
        byte byte4;
        int k1;
        u = switchermode;
        StatusManager.j().a(switchermode);
        b(switchermode);
        j1 = aw1.b();
        i1 = j1;
        if (j1 == 4)
        {
            i1 = 3;
        }
        if (i1 % 2 == 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (w.m() != 0)
        {
            break MISSING_BLOCK_LABEL_678;
        }
        if (u != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j1 != 0)
        {
            if (i1 == 2)
            {
                i1 = 4;
                j1 = 4;
                byte0 = 4;
                byte1 = 4;
                byte3 = 4;
                byte4 = 4;
                k1 = 0;
                byte2 = 4;
            } else
            {
                if (i1 != 4)
                {
                    break MISSING_BLOCK_LABEL_678;
                }
                i1 = 4;
                j1 = 4;
                byte0 = 4;
                byte1 = 4;
                byte3 = 0;
                byte4 = 4;
                k1 = 4;
                byte2 = 4;
            }
        } else
        if (i1 == 1)
        {
            i1 = 4;
            j1 = 4;
            byte0 = 4;
            byte1 = 4;
            byte3 = 4;
            byte4 = 4;
            k1 = 4;
            byte2 = 4;
            byte5 = 0;
        } else
        {
            if (i1 != 3)
            {
                break MISSING_BLOCK_LABEL_678;
            }
            i1 = 0;
            j1 = 4;
            byte0 = 4;
            byte1 = 4;
            byte3 = 4;
            byte4 = 4;
            k1 = 4;
            byte2 = 4;
        }
_L4:
        if (g.getVisibility() != k1)
        {
            g.setVisibility(k1);
        }
        if (h.getVisibility() != byte4)
        {
            h.setVisibility(byte4);
        }
        if (i.getVisibility() != byte3)
        {
            i.setVisibility(byte3);
        }
        if (j.getVisibility() != byte1)
        {
            j.setVisibility(byte1);
        }
        if (k.getVisibility() != byte0)
        {
            k.setVisibility(byte0);
        }
        if (l.getVisibility() != j1)
        {
            l.setVisibility(j1);
        }
        if (m.getVisibility() != i1)
        {
            m.setVisibility(i1);
        }
        if (n.getVisibility() != byte5)
        {
            n.setVisibility(byte5);
        }
        if (o.getVisibility() != byte2)
        {
            o.setVisibility(byte2);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (u == com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b)
        {
            if (j1 != 0)
            {
                if (i1 == 2)
                {
                    i1 = 4;
                    j1 = 4;
                    byte0 = 4;
                    byte1 = 4;
                    byte3 = 4;
                    byte4 = 0;
                    k1 = 4;
                    byte2 = 4;
                } else
                {
                    if (i1 != 4)
                    {
                        break MISSING_BLOCK_LABEL_678;
                    }
                    i1 = 4;
                    j1 = 4;
                    byte0 = 4;
                    byte1 = 0;
                    byte3 = 4;
                    byte4 = 4;
                    k1 = 4;
                    byte2 = 4;
                }
            } else
            {
                i1 = 4;
                j1 = 4;
                byte0 = 4;
                byte1 = 4;
                byte3 = 4;
                byte4 = 4;
                k1 = 4;
                byte2 = 4;
                byte5 = 0;
            }
        } else
        if (u == com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c)
        {
            if (j1 != 0)
            {
                i1 = 4;
                j1 = 4;
                byte0 = 0;
                byte1 = 4;
                byte3 = 4;
                byte4 = 4;
                k1 = 4;
                byte2 = 4;
            } else
            {
                i1 = 4;
                j1 = 4;
                byte0 = 4;
                byte1 = 4;
                byte3 = 4;
                byte4 = 4;
                k1 = 4;
            }
        } else
        {
            if (u != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d)
            {
                break MISSING_BLOCK_LABEL_678;
            }
            i1 = 4;
            j1 = 0;
            byte0 = 4;
            byte1 = 4;
            byte3 = 4;
            byte4 = 4;
            k1 = 4;
            byte2 = 4;
        }
          goto _L4
        byte2 = 4;
        i1 = 4;
        j1 = 4;
        byte0 = 4;
        byte1 = 4;
        byte3 = 4;
        byte4 = 4;
        k1 = 4;
          goto _L4
    }

    private void c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, at at1)
    {
        if (at1 == null)
        {
            return;
        } else
        {
            a(switchermode, Boolean.valueOf(at1.k()));
            return;
        }
    }

    static void c(c c1, aw aw1)
    {
        c1.a(aw1);
    }

    private void c(String s1)
    {
        if (s1 != null)
        {
            f.setVisibility(0);
            e.setVisibility(8);
        } else
        {
            f.setVisibility(8);
            e.setVisibility(0);
        }
        D.a(s1, f);
    }

    private void c(boolean flag)
    {
        Object obj = d(u);
        if (obj != null && v != null)
        {
            if ((obj = (ColorDrawable)((View) (obj)).getBackground()) != null)
            {
                obj = new at(((ColorDrawable) (obj)).getColor());
                if (w != null)
                {
                    w.a(((at) (obj)), flag);
                    return;
                }
            }
        }
    }

    private View d(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        aw aw1 = g();
        if (aw1 != null && e != null && e.getCurrentView() != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        View view;
        view = e.getCurrentView();
        if (switchermode != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a)
        {
            break; /* Loop/switch isn't completed */
        }
        if (aw1.b() == 1)
        {
            return view.findViewById(0x7f0c0880);
        }
        if (aw1.b() == 2)
        {
            return view.findViewById(0x7f0c0881);
        }
        if (aw1.b() == 3)
        {
            return view.findViewById(0x7f0c0883);
        }
        if (aw1.b() >= 4)
        {
            return view.findViewById(0x7f0c0883);
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (switchermode != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (aw1.b() == 2)
        {
            return view.findViewById(0x7f0c0882);
        }
        if (aw1.b() == 3)
        {
            return view.findViewById(0x7f0c0884);
        }
        if (aw1.b() >= 4)
        {
            return view.findViewById(0x7f0c0884);
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (switchermode != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (aw1.b() == 3)
        {
            return view.findViewById(0x7f0c0885);
        }
        if (aw1.b() < 4) goto _L1; else goto _L5
_L5:
        return view.findViewById(0x7f0c0885);
        if (switchermode != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d) goto _L1; else goto _L6
_L6:
        return view.findViewById(0x7f0c0889);
    }

    static View d(c c1)
    {
        return c1.d;
    }

    static View d(c c1, View view)
    {
        c1.j = view;
        return view;
    }

    private void d()
    {
        if (y > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        aw aw1;
        y = y - 1;
        aw1 = a(y);
        if (aw1 == null) goto _L1; else goto _L3
_L3:
        o();
        b(aw1);
        StatusManager.j().c(aw1.a());
        if (t != null) goto _L5; else goto _L4
_L4:
        e.setInAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0002));
        e.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0003));
        t = Boolean.valueOf(true);
_L7:
        e.showPrevious();
        c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        e.postDelayed(new Runnable(aw1) {

            final aw a;
            final c b;

            public void run()
            {
                c.p(b);
                if (a == null)
                {
                    c.c(b).a(null);
                    return;
                } else
                {
                    c.c(b).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(b, (ArrayList)a.i(), null));
                    return;
                }
            }

            
            {
                b = c.this;
                a = aw1;
                super();
            }
        }, 1000L);
        return;
_L5:
        if (!t.booleanValue())
        {
            e.setInAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0002));
            e.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0003));
            t = Boolean.valueOf(true);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void d(aw aw1)
    {
label0:
        {
            if (w != null)
            {
                if (aw1 == null || aw1.k() == null)
                {
                    break label0;
                }
                w.a(a.c(aw1.k()), true);
                w.h(aw1.a());
                w.f(aw1.k());
                c(a.c("eye_shadow", aw1.k(), aw1.a()));
                com.cyberlink.youcammakeup.clflurry.b.a(new af(aw1.k(), YMKFeatures.a(BeautyMode.n)));
            }
            return;
        }
        w.a(null, true);
        w.h(null);
        w.f(null);
        c(((String) (null)));
    }

    static View e(c c1, View view)
    {
        c1.k = view;
        return view;
    }

    static ag e(c c1)
    {
        return c1.D;
    }

    static View f(c c1, View view)
    {
        c1.l = view;
        return view;
    }

    static com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode f(c c1)
    {
        return c1.u;
    }

    static View g(c c1, View view)
    {
        c1.m = view;
        return view;
    }

    private aw g()
    {
        String s1 = StatusManager.j().g();
        if (s1 == null)
        {
            return null;
        } else
        {
            return PanelDataCenter.a().i(s1);
        }
    }

    static List g(c c1)
    {
        return c1.B;
    }

    static View h(c c1, View view)
    {
        c1.n = view;
        return view;
    }

    static aw h(c c1)
    {
        return c1.g();
    }

    private void h()
    {
        String s1;
        aw aw1;
label0:
        {
            aw1 = g();
            if (aw1 == null || e == null || e.getCurrentView() == null)
            {
                p();
                return;
            }
            MotionControlHelper.e().b();
            A = aw1.c();
            String s2 = StatusManager.j().e();
            if (s2 != null)
            {
                s1 = s2;
                if (s2 == null)
                {
                    break label0;
                }
                s1 = s2;
                if (A == null)
                {
                    break label0;
                }
                s1 = s2;
                if (A.size() <= 0)
                {
                    break label0;
                }
                s1 = s2;
                if (A.contains(s2))
                {
                    break label0;
                }
            }
            s1 = (String)A.get(0);
        }
        if (s1 == null)
        {
            p();
            return;
        } else
        {
            w.a(s1, true);
            w.getView().post(new Runnable(aw1) {

                final aw a;
                final c b;

                public void run()
                {
                    if (c.c(b) != null)
                    {
                        c.c(b).b(a.a());
                    }
                }

            
            {
                b = c.this;
                a = aw1;
                super();
            }
            });
            return;
        }
    }

    static int i(c c1)
    {
        return c1.r();
    }

    static View i(c c1, View view)
    {
        c1.o = view;
        return view;
    }

    private void i()
    {
        StatusManager.j().a(null);
        StatusManager.j().c(null);
        if (v != null)
        {
            v.b(this);
        }
        d = null;
        e = null;
        t = null;
        v = null;
        q = null;
        x = null;
        r = true;
        y = 0;
        z = null;
        s = false;
        f = null;
    }

    static View j(c c1, View view)
    {
        c1.p = view;
        return view;
    }

    static List j(c c1)
    {
        return c1.z;
    }

    private void j()
    {
        if (e != null)
        {
            x = null;
            aw aw1 = PanelDataCenter.a().i(StatusManager.j().g());
            if (aw1 != null)
            {
                Object obj = aw1.i();
                if (aw1.b() == 1)
                {
                    e.removeAllViews();
                    View view = k();
                    if (B.size() >= aw1.b())
                    {
                        obj = B;
                    }
                    if (obj != null && ((List) (obj)).size() >= aw1.b() && ((List) (obj)).get(0) != null)
                    {
                        Globals.d().j().d(((List) (obj)));
                        ((ImageView)view.findViewById(0x7f0c0880)).setBackgroundColor(b((at)((List) (obj)).get(0)));
                        if (((at)((List) (obj)).get(0)).k())
                        {
                            obj = getResources().getDrawable(0x7f0202d9);
                        } else
                        {
                            obj = getResources().getDrawable(0x7f0202d8);
                        }
                        ((ImageView)view.findViewById(0x7f0c0880)).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                    }
                    e.addView(view);
                    return;
                }
                if (aw1.b() == 2)
                {
                    e.removeAllViews();
                    View view1 = l();
                    if (B.size() >= aw1.b())
                    {
                        obj = B;
                    }
                    if (((List) (obj)).get(0) != null && ((List) (obj)).get(1) != null)
                    {
                        Globals.d().j().d(((List) (obj)));
                        ((ImageView)view1.findViewById(0x7f0c0881)).setBackgroundColor(b((at)((List) (obj)).get(0)));
                        ((ImageView)view1.findViewById(0x7f0c0882)).setBackgroundColor(b((at)((List) (obj)).get(1)));
                        android.graphics.drawable.Drawable drawable;
                        if (((at)((List) (obj)).get(0)).k())
                        {
                            drawable = getResources().getDrawable(0x7f0202d9);
                        } else
                        {
                            drawable = getResources().getDrawable(0x7f0202d8);
                        }
                        ((ImageView)view1.findViewById(0x7f0c0881)).setImageDrawable(drawable);
                        if (((at)((List) (obj)).get(1)).k())
                        {
                            obj = getResources().getDrawable(0x7f0202db);
                        } else
                        {
                            obj = getResources().getDrawable(0x7f0202da);
                        }
                        ((ImageView)view1.findViewById(0x7f0c0882)).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                    }
                    e.addView(view1);
                    return;
                }
                if (aw1.b() >= 3)
                {
                    e.removeAllViews();
                    View view2 = m();
                    if (B.size() >= aw1.b())
                    {
                        obj = B;
                    }
                    if (((List) (obj)).get(0) != null && ((List) (obj)).get(1) != null && ((List) (obj)).get(2) != null)
                    {
                        Globals.d().j().d(((List) (obj)));
                        ((ImageView)view2.findViewById(0x7f0c0883)).setBackgroundColor(b((at)((List) (obj)).get(0)));
                        ((ImageView)view2.findViewById(0x7f0c0884)).setBackgroundColor(b((at)((List) (obj)).get(1)));
                        ((ImageView)view2.findViewById(0x7f0c0885)).setBackgroundColor(b((at)((List) (obj)).get(2)));
                        android.graphics.drawable.Drawable drawable1;
                        if (((at)((List) (obj)).get(0)).k())
                        {
                            drawable1 = getResources().getDrawable(0x7f0202d9);
                        } else
                        {
                            drawable1 = getResources().getDrawable(0x7f0202d8);
                        }
                        ((ImageView)view2.findViewById(0x7f0c0883)).setImageDrawable(drawable1);
                        if (((at)((List) (obj)).get(1)).k())
                        {
                            drawable1 = getResources().getDrawable(0x7f0202db);
                        } else
                        {
                            drawable1 = getResources().getDrawable(0x7f0202da);
                        }
                        ((ImageView)view2.findViewById(0x7f0c0884)).setImageDrawable(drawable1);
                        if (((at)((List) (obj)).get(2)).k())
                        {
                            obj = getResources().getDrawable(0x7f0202dd);
                        } else
                        {
                            obj = getResources().getDrawable(0x7f0202dc);
                        }
                        ((ImageView)view2.findViewById(0x7f0c0885)).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                    }
                    e.addView(view2);
                    return;
                }
            }
        }
    }

    private View k()
    {
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f0301e9, e, false);
        if (linearlayout != null)
        {
            a(linearlayout, c);
        }
        return linearlayout;
    }

    static View k(c c1, View view)
    {
        c1.x = view;
        return view;
    }

    static List k(c c1)
    {
        return c1.A;
    }

    private View l()
    {
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f0301ea, e, false);
        if (linearlayout != null)
        {
            a(linearlayout, c);
        }
        return linearlayout;
    }

    static void l(c c1)
    {
        c1.j();
    }

    private View m()
    {
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f0301eb, e, false);
        if (linearlayout != null)
        {
            a(linearlayout, c);
        }
        return linearlayout;
    }

    static void m(c c1)
    {
        c1.p();
    }

    private View n()
    {
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f0301ec, e, false);
        if (linearlayout != null)
        {
            a(linearlayout, c);
        }
        return linearlayout;
    }

    static View n(c c1)
    {
        return c1.p;
    }

    static ImageView o(c c1)
    {
        return c1.f;
    }

    private void o()
    {
        Globals.d().i().a(Globals.d().t(), 0L);
    }

    private void p()
    {
        Globals.d().i().h(Globals.d().t());
    }

    static void p(c c1)
    {
        c1.h();
    }

    private void q()
    {
        if (v != null && w != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j1;
        long l1 = StatusManager.j().l();
        Object obj;
        Object obj1;
        Object obj2;
        if (v.A())
        {
            obj = StatusManager.j().j(l1);
        } else
        {
            obj = StatusManager.j().g(l1);
        }
        MotionControlHelper.e().t();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = false;
        obj = ((d) (obj)).e();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1297;
        }
        obj = ((a) (obj)).f();
        if (obj == null || ((v) (obj)).a() == null || ((v) (obj)).c() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = PanelDataCenter.a().i(((v) (obj)).c());
        obj2 = g();
        if (obj1 != null)
        {
            int k1 = ((aw) (obj1)).b();
            at at1;
            ArrayList arraylist;
            boolean flag;
            if (obj2 != null && ((aw) (obj1)).b() != ((aw) (obj2)).b())
            {
                flag = true;
            } else
            if (obj2 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u = ((v) (obj)).e();
            StatusManager.j().c(((v) (obj)).c());
            StatusManager.j().b(((v) (obj)).a());
            MotionControlHelper.e().b();
            if (w != null)
            {
                w.a(((v) (obj)).b(((v) (obj)).e()).intValue());
                w.a(Boolean.valueOf(((v) (obj)).a(((v) (obj)).e()).k()));
                obj2 = w;
                int i1;
                boolean flag1;
                if (((aw) (obj1)).k() != null)
                {
                    i1 = 8;
                } else
                {
                    i1 = 0;
                }
                ((BeautyToolPanel) (obj2)).a(i1);
                obj2 = w;
                if (((aw) (obj1)).k() == null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ((BeautyToolPanel) (obj2)).h(flag1);
            }
            obj2 = ((aw) (obj1)).i();
            at1 = ((v) (obj)).a(u);
            arraylist = new ArrayList();
            for (i1 = 0; i1 < ((List) (obj2)).size(); i1++)
            {
                if (((v) (obj)).a(i1) != null)
                {
                    arraylist.add(((v) (obj)).a(i1));
                }
            }

        } else
        {
            StatusManager.j().c(null);
            StatusManager.j().b(null);
            s = true;
            if (v != null && w != null)
            {
                w.a(8);
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (at1 != null && ((aw) (obj1)).k() == null)
        {
            for (j1 = 0; j1 < ((List) (obj2)).size(); j1++)
            {
                ((List) (obj2)).set(j1, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values()[j1]).m());
                ((at)((List) (obj2)).get(j1)).a(((Integer)arraylist.get(j1)).intValue());
                ((at)((List) (obj2)).get(j1)).b(((v) (obj)).c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values()[j1]));
            }

            B = ((List) (obj2));
            MotionControlHelper.e().d(((List) (obj2)));
            MotionControlHelper.e().c(arraylist);
        }
        if (k1 == 1)
        {
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, ((v) (obj)).a(u));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj2)).get(0));
        } else
        if (k1 == 2)
        {
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj2)).get(0));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj2)).get(1));
        } else
        if (k1 == 3)
        {
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b));
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj2)).get(0));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj2)).get(1));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj2)).get(2));
        } else
        if (k1 >= 4)
        {
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b));
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c));
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj2)).get(0));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj2)).get(1));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj2)).get(2));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, (at)((List) (obj2)).get(3));
        }
        j1 = ((flag) ? 1 : 0);
_L4:
        StatusManager.j().a(u);
        y = 0;
        z = null;
        A = null;
        obj = g();
        d(((aw) (obj)));
        r();
        a(((aw) (obj)));
        b(StatusManager.j().g());
        if (j1 != 0)
        {
            j();
        }
        if (z != null && z.contains(StatusManager.j().g()))
        {
            y = z.indexOf(StatusManager.j().g());
        }
        c(true);
        c(u);
        if (w != null)
        {
            w.k(MotionControlHelper.e().a(MotionControlHelper.e().C()));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (u != com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a)
        {
            u = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a;
            flag = true;
        } else
        {
            flag = false;
        }
        if (w != null)
        {
            w.a(0.0F);
        }
        obj = StatusManager.j().g();
        obj1 = new ArrayList();
        for (j1 = 0; j1 < B.size(); j1++)
        {
            ((List) (obj1)).add(Integer.valueOf(0));
        }

        Globals.d().j().c(((List) (obj1)));
        v.R();
        obj = PanelDataCenter.a().i(((String) (obj)));
        j1 = ((flag) ? 1 : 0);
        if (obj != null)
        {
            obj = ((aw) (obj)).i();
            j1 = ((flag) ? 1 : 0);
            if (obj != null)
            {
                j1 = ((flag) ? 1 : 0);
                if (((List) (obj)).size() > 0)
                {
                    b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj)).get(0));
                    if (((List) (obj)).size() > 1)
                    {
                        b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj)).get(1));
                    }
                    if (((List) (obj)).size() > 2)
                    {
                        b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj)).get(2));
                    }
                    j1 = ((flag) ? 1 : 0);
                    if (((List) (obj)).size() > 3)
                    {
                        b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, (at)((List) (obj)).get(3));
                        j1 = ((flag) ? 1 : 0);
                    }
                }
            }
        }
        break MISSING_BLOCK_LABEL_576;
        j1 = 0;
          goto _L4
    }

    static boolean q(c c1)
    {
        return c1.r;
    }

    private int r()
    {
        int j1;
label0:
        {
            int i1 = -1;
            if (b != null)
            {
                com.cyberlink.youcammakeup.database.more.i.d d1 = a.a(b.b(), b.a());
                i1 = 0;
                z = PanelDataCenter.a().l(d1.d());
            }
            j1 = i1;
            if (z != null)
            {
                break label0;
            }
            Object obj11 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 4);
            Object obj10 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 3);
            Object obj9 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 2);
            Object obj8 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 1);
            Object obj6 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 4);
            Object obj4 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 3);
            Object obj2 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 2);
            Object obj = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 1);
            Object obj7 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 4);
            Object obj5 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 3);
            Object obj3 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 2);
            Object obj1 = PanelDataCenter.a().b(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 1);
            Collections.reverse(((List) (obj7)));
            Collections.reverse(((List) (obj5)));
            Collections.reverse(((List) (obj3)));
            Collections.reverse(((List) (obj1)));
            ((List) (obj7)).addAll(((java.util.Collection) (obj6)));
            ((List) (obj5)).addAll(((java.util.Collection) (obj4)));
            ((List) (obj3)).addAll(((java.util.Collection) (obj2)));
            ((List) (obj1)).addAll(((java.util.Collection) (obj)));
            z = new ArrayList();
            j1 = i1;
            if (obj11 != null)
            {
                j1 = i1;
                if (((List) (obj11)).size() > 0)
                {
                    String s4;
                    for (obj11 = ((List) (obj11)).iterator(); ((Iterator) (obj11)).hasNext(); z.add(s4))
                    {
                        s4 = (String)((Iterator) (obj11)).next();
                    }

                    j1 = 0;
                }
            }
            i1 = j1;
            if (obj10 != null)
            {
                i1 = j1;
                if (((List) (obj10)).size() > 0)
                {
                    String s3;
                    for (obj10 = ((List) (obj10)).iterator(); ((Iterator) (obj10)).hasNext(); z.add(s3))
                    {
                        s3 = (String)((Iterator) (obj10)).next();
                    }

                    i1 = 0;
                }
            }
            j1 = i1;
            if (obj9 != null)
            {
                j1 = i1;
                if (((List) (obj9)).size() > 0)
                {
                    String s2;
                    for (obj9 = ((List) (obj9)).iterator(); ((Iterator) (obj9)).hasNext(); z.add(s2))
                    {
                        s2 = (String)((Iterator) (obj9)).next();
                    }

                    j1 = 0;
                }
            }
            i1 = j1;
            if (obj8 != null)
            {
                i1 = j1;
                if (((List) (obj8)).size() > 0)
                {
                    String s1;
                    for (obj8 = ((List) (obj8)).iterator(); ((Iterator) (obj8)).hasNext(); z.add(s1))
                    {
                        s1 = (String)((Iterator) (obj8)).next();
                    }

                    i1 = 0;
                }
            }
            j1 = i1;
            if (obj7 != null)
            {
                j1 = i1;
                if (((List) (obj7)).size() > 0)
                {
                    if (i1 < 0)
                    {
                        i1 = (z.size() + ((List) (obj7)).size()) - ((List) (obj6)).size();
                    }
                    for (obj6 = ((List) (obj7)).iterator(); ((Iterator) (obj6)).hasNext(); z.add(obj7))
                    {
                        obj7 = (String)((Iterator) (obj6)).next();
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (obj5 != null)
            {
                i1 = j1;
                if (((List) (obj5)).size() > 0)
                {
                    if (j1 >= 0)
                    {
                        i1 = j1;
                    } else
                    {
                        i1 = (z.size() + ((List) (obj5)).size()) - ((List) (obj4)).size();
                    }
                    for (obj4 = ((List) (obj5)).iterator(); ((Iterator) (obj4)).hasNext(); z.add(obj5))
                    {
                        obj5 = (String)((Iterator) (obj4)).next();
                    }

                }
            }
            j1 = i1;
            if (obj3 != null)
            {
                j1 = i1;
                if (((List) (obj3)).size() > 0)
                {
                    if (i1 < 0)
                    {
                        i1 = (z.size() + ((List) (obj3)).size()) - ((List) (obj2)).size();
                    }
                    for (obj2 = ((List) (obj3)).iterator(); ((Iterator) (obj2)).hasNext(); z.add(obj3))
                    {
                        obj3 = (String)((Iterator) (obj2)).next();
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (obj1 != null)
            {
                i1 = j1;
                if (((List) (obj1)).size() > 0)
                {
                    if (j1 >= 0)
                    {
                        i1 = j1;
                    } else
                    {
                        i1 = (z.size() + ((List) (obj1)).size()) - ((List) (obj)).size();
                    }
                    for (obj = ((List) (obj1)).iterator(); ((Iterator) (obj)).hasNext(); z.add(obj1))
                    {
                        obj1 = (String)((Iterator) (obj)).next();
                    }

                }
            }
            j1 = i1;
            if (z.size() <= 0)
            {
                break label0;
            }
            if (i1 >= 0)
            {
                j1 = i1;
                if (z.size() > i1)
                {
                    break label0;
                }
            }
            j1 = 0;
        }
        return j1;
    }

    static GestureDetector r(c c1)
    {
        return c1.q;
    }

    static View s(c c1)
    {
        return c1.x;
    }

    private void s()
    {
        y = 0;
        if (z != null && z.contains(StatusManager.j().g()))
        {
            y = z.indexOf(StatusManager.j().g());
        }
    }

    static boolean t(c c1)
    {
        return c1.s;
    }

    static void u(c c1)
    {
        c1.c();
    }

    static void v(c c1)
    {
        c1.d();
    }

    public void a()
    {
        if (w != null)
        {
            w.h();
        }
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        q();
    }

    public void a(at at1)
    {
        Object obj;
label0:
        {
            obj = d(u);
            if (obj != null)
            {
                at1.a(w.K());
                at1.a(MotionControlHelper.e().b(u).booleanValue());
                at1.b(MotionControlHelper.e().c(u));
                ((ImageView)obj).setBackgroundColor(at1.e());
                obj = new com.cyberlink.youcammakeup.activity.c() {

                    final c a;

                    public void a()
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(a) == null || c.c(a) == null)
                        {
                            return;
                        } else
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(a).b(this);
                            c.c(a).k(MotionControlHelper.e().a(MotionControlHelper.e().C()));
                            return;
                        }
                    }

            
            {
                a = c.this;
                super();
            }
                };
                v.a(((com.cyberlink.youcammakeup.activity.c) (obj)));
                if (!MotionControlHelper.e().a(u, at1, true))
                {
                    break label0;
                }
                MotionControlHelper.e().M();
                if (v != null)
                {
                    v.j(true);
                    o();
                }
            }
            return;
        }
        ((com.cyberlink.youcammakeup.activity.c) (obj)).a();
    }

    public void a(az az1)
    {
        b = az1;
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, Boolean boolean1)
    {
        int i1 = g().b();
        if (isAdded()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = switchermode;
        if (switchermode == null)
        {
            obj = u;
        }
        obj = d(((com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode) (obj)));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!boolean1.booleanValue())
        {
            break; /* Loop/switch isn't completed */
        }
        if (i1 <= 2)
        {
            switchermode = getResources().getDrawable(0x7f0202d9);
        } else
        if (i1 == 3)
        {
            switchermode = getResources().getDrawable(0x7f0202db);
        } else
        {
            switchermode = getResources().getDrawable(0x7f0202dd);
        }
        if (switchermode != null)
        {
            ((ImageView)obj).setImageDrawable(switchermode);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (i1 <= 2)
        {
            switchermode = getResources().getDrawable(0x7f0202d8);
        } else
        if (i1 == 3)
        {
            switchermode = getResources().getDrawable(0x7f0202da);
        } else
        {
            switchermode = getResources().getDrawable(0x7f0202dc);
        }
        if (switchermode != null)
        {
            ((ImageView)obj).setImageDrawable(switchermode);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, boolean flag)
    {
        com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode1 = switchermode;
        if (switchermode == null)
        {
            switchermode1 = u;
        }
        if (switchermode1.ordinal() < B.size())
        {
            ((at)B.get(switchermode1.ordinal())).a(flag);
        }
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.panel.a a1)
    {
        w = (BeautyToolPanel)a1;
    }

    public void a(Boolean boolean1)
    {
        if (g() != null)
        {
            int i1 = g().b();
            if (i1 >= 1)
            {
                a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, boolean1);
            }
            if (i1 >= 2)
            {
                a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, boolean1);
            }
            if (i1 >= 3)
            {
                a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, boolean1);
            }
            if (i1 >= 4)
            {
                a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, boolean1);
                return;
            }
        }
    }

    public void a(String s1)
    {
        z = null;
        r();
        if (s1 != null)
        {
            a(s1, new Float[0]);
            return;
        } else
        {
            s();
            return;
        }
    }

    public void a(String s1, boolean flag)
    {
        if (PanelDataCenter.a().p(s1) == null)
        {
            return;
        }
        c(g());
        s1 = new ArrayList();
        for (Iterator iterator = B.iterator(); iterator.hasNext(); s1.add(Integer.valueOf(((at)iterator.next()).d()))) { }
        MotionControlHelper.e().c(s1);
        if (w != null)
        {
            w.a(((Integer)s1.get(0)).intValue());
        }
        if (flag)
        {
            u = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a;
            StatusManager.j().a(u);
        }
        if (v != null && v.C() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag);
        w.a(a((ArrayList)MotionControlHelper.e().C().f(), u));
    }

    public transient void a(String s1, Float afloat[])
    {
        MotionControlHelper.e().t();
        if (s1 != null && v != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = PanelDataCenter.a().i(s1)) == null) goto _L1; else goto _L3
_L3:
        Object obj1;
        int i1;
        int j1;
        obj1 = g();
        afloat = null;
        if (obj1 != null)
        {
            afloat = ((aw) (obj1)).a();
        }
        if (afloat != null && afloat.equals(s1))
        {
            s();
            return;
        }
        if (obj1 == null)
        {
            i1 = 1;
        } else
        {
            if (((aw) (obj1)).b() >= 4)
            {
                i1 = 3;
            } else
            {
                i1 = ((aw) (obj1)).b();
            }
            if (((aw) (obj)).b() >= 4)
            {
                j1 = 3;
            } else
            {
                j1 = ((aw) (obj)).b();
            }
            if (i1 != j1)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        }
        StatusManager.j().c(s1);
        d(((aw) (obj)));
        a(((aw) (obj)));
        b(s1);
        s1 = StatusManager.j().e();
        if (s1 == null || s1 != null && A != null && A.size() > 0 && !A.contains(s1))
        {
            s1 = (String)A.get(0);
        }
        if (s1 == null) goto _L1; else goto _L4
_L4:
        StatusManager.j().b(s1);
        c(((aw) (obj)));
        MotionControlHelper.e().b();
        afloat = MotionControlHelper.e().d();
        obj1 = ((aw) (obj)).i();
        j1 = ((aw) (obj)).b();
        MotionControlHelper.e().b(((List) (obj1)));
        if (afloat == null || afloat.size() <= 0 || obj1 == null || ((List) (obj1)).size() <= 0) goto _L6; else goto _L5
_L5:
        if (w != null)
        {
            w.a(((Integer)afloat.get(0)).intValue());
        }
        obj = Globals.d().j();
        if (j1 != 1) goto _L8; else goto _L7
_L7:
        if (i1 == 0)
        {
            b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
            c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
            ((MotionControlHelper) (obj)).d(((List) (obj1)));
        }
        ((MotionControlHelper) (obj)).c(afloat);
_L10:
        if (i1 != 0)
        {
            (new Handler()).post(new Runnable() {

                final c a;

                public void run()
                {
                    c.l(a);
                }

            
            {
                a = c.this;
                super();
            }
            });
        }
_L6:
        w.k(false);
        w.a(8);
        w.h(false);
        w.a(a(((com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode) (null))));
        v.W();
        s();
        c(u);
        StatusManager.j().a(s1, true, new Float[0]);
        return;
_L8:
        if (j1 == 2 && afloat.size() > 1 && ((List) (obj1)).size() > 1)
        {
            if (i1 == 0)
            {
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                ((MotionControlHelper) (obj)).d(((List) (obj1)));
            }
            ((MotionControlHelper) (obj)).c(afloat);
        } else
        if (j1 == 3 && afloat.size() > 2 && ((List) (obj1)).size() > 2)
        {
            if (i1 == 0)
            {
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj1)).get(2));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj1)).get(2));
                ((MotionControlHelper) (obj)).d(((List) (obj1)));
            }
            ((MotionControlHelper) (obj)).c(afloat);
        } else
        if (j1 == 4 && afloat.size() > 3 && ((List) (obj1)).size() > 3)
        {
            if (i1 == 0)
            {
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj1)).get(2));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, (at)((List) (obj1)).get(3));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj1)).get(2));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, (at)((List) (obj1)).get(3));
                ((MotionControlHelper) (obj)).d(((List) (obj1)));
            }
            ((MotionControlHelper) (obj)).c(afloat);
        } else
        if (j1 >= 4 && afloat.size() >= 3 && ((List) (obj1)).size() > 3)
        {
            if (i1 == 0)
            {
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj1)).get(2));
                b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, (at)((List) (obj1)).get(3));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, (at)((List) (obj1)).get(0));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, (at)((List) (obj1)).get(1));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, (at)((List) (obj1)).get(2));
                c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, (at)((List) (obj1)).get(3));
                ((MotionControlHelper) (obj)).d(((List) (obj1)));
            }
            ((MotionControlHelper) (obj)).c(afloat);
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void a(boolean flag)
    {
        for (Iterator iterator = B.iterator(); iterator.hasNext(); ((at)iterator.next()).a(flag)) { }
    }

    public void b(ImageStateChangedEvent imagestatechangedevent)
    {
        q();
    }

    public void b(boolean flag)
    {
        r = flag;
    }

    public at e()
    {
        return null;
    }

    public void f()
    {
        i();
    }

    public void onActivityCreated(Bundle bundle)
    {
        b();
        super.onActivityCreated(bundle);
        if (!IntroDialogUtils.b(getFragmentManager(), null, null))
        {
            bundle = Globals.d().t();
            if (bundle != null)
            {
                bundle.a(false, null);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d = layoutinflater.inflate(0x7f030166, viewgroup, false);
        return d;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        i();
    }
}

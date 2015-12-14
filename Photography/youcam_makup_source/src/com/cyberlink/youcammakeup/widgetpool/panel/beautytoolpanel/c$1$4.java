// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.app.Activity;
import android.os.AsyncTask;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            c, BeautyToolPanel, d

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.a();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/c$1

/* anonymous class */
    class c._cls1 extends AsyncTask
    {

        String a;
        String b;
        boolean c;
        final com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c d;

        protected transient Boolean a(Void avoid[])
        {
            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).size() > 0)
            {
                Globals.d().j().d(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d));
            }
            MotionControlHelper.e().b();
            avoid = MotionControlHelper.e().d();
            if (avoid != null && avoid.size() > 0)
            {
                for (int j = 0; j < com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).size(); j++)
                {
                    if (avoid.size() > j)
                    {
                        ((at)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).get(j)).a(((Integer)avoid.get(j)).intValue());
                    }
                }

                Globals.d().j().c(avoid);
            }
            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d).contains(b))
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d).indexOf(b));
            }
            if (c)
            {
                if (MotionControlHelper.e().a(null, c))
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).i(false);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a(new c._cls1._cls1());
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
            d.getActivity().runOnUiThread(new c._cls1._cls4(this));
        }

        protected void a(Boolean boolean1)
        {
            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d) != null)
            {
                if (!boolean1.booleanValue())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).j(false);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.m(d);
                }
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, b);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d).a(((at)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).get(0)).d(), 0.0F, 0.0F, false, true);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d).k(MotionControlHelper.e().a(MotionControlHelper.e().C()));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d, null));
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c064f));
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.n(d) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.n(d).setOnClickListener(new c._cls1._cls2());
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.o(d).setOnClickListener(new c._cls1._cls3());
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
            d.a = h.b();
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, null);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a(d);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a(d);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).j(true);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d).a(8);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, new GestureDetector(d.getActivity(), new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.d(d)));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, (ViewSwitcher)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0651));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, (ImageView)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0652));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0654));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0655));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0659));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c065a));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.e(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c065b));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.f(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c065c));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0656));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.h(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0657));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.i(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.d(d).findViewById(0x7f0c0658));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, new ag(d.getActivity()));
            Object obj = new k(d.getActivity(), null);
            obj.g = false;
            ((k) (obj)).a(0.15F);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.e(d).a(d.getActivity().getFragmentManager(), ((k) (obj)));
            MotionControlHelper.e().m();
            obj = new at(0, 50, null);
            obj = Arrays.asList(new at[] {
                obj, obj, obj, obj, obj, obj
            });
            Globals.d().j().d(((List) (obj)));
            StatusManager.j().a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.f(d));
            obj = StatusManager.j().d();
            if (obj != null && ((i) (obj)).b() != null && ((i) (obj)).b().f().size() != 0 && ((i) (obj)).b().c() != null && PanelDataCenter.f(((i) (obj)).b().c()))
            {
                int j = ((i) (obj)).b().f().size() - 1;
                int i1 = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values().length - 1;
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c c1 = d;
                com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode aswitchermode[] = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values();
                if (j > i1)
                {
                    j = i1;
                }
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(c1, aswitchermode[j]);
                b = ((i) (obj)).b().c();
                a = ((i) (obj)).b().b();
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, new ArrayList());
                at at1;
                for (Iterator iterator = ((i) (obj)).b().f().iterator(); iterator.hasNext(); com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).add(at1.m()))
                {
                    at1 = (at)iterator.next();
                }

                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).get(0) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d).a((at)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.g(d).get(0), true);
                }
                c = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, ((i) (obj)));
                StatusManager.j().c(b);
                obj = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.h(d);
            } else
            {
                int l = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.i(d);
                if (b == null)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d).size() > 0 && l >= 0 && l < com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d).size())
                    {
                        obj = (String)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.j(d).get(l);
                    } else
                    {
                        obj = null;
                    }
                    b = ((String) (obj));
                }
                StatusManager.j().c(b);
                obj = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.h(d);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(d, ((com.cyberlink.youcammakeup.utility.aw) (obj)));
            }
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d, ((com.cyberlink.youcammakeup.utility.aw) (obj)));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(d, ((com.cyberlink.youcammakeup.utility.aw) (obj)));
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
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.l(d);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.b(d, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.f(d));
        }

            
            {
                d = c1;
                super();
                a = null;
                b = null;
                c = true;
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/c$1$1

/* anonymous class */
        class c._cls1._cls1
            implements c
        {

            final c._cls1 a;

            public void a()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.a(a.d).b(this);
                a.a();
            }

                    
                    {
                        a = c._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/c$1$2

/* anonymous class */
        class c._cls1._cls2
            implements android.view.View.OnClickListener
        {

            final c._cls1 a;

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
                        a = c._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/c$1$3

/* anonymous class */
        class c._cls1._cls3
            implements android.view.View.OnClickListener
        {

            final c._cls1 a;

            public void onClick(View view)
            {
                view.setClickable(false);
                view.post(new c._cls1._cls3._cls2(this, new c._cls1._cls3._cls1(this, view)));
            }

                    
                    {
                        a = c._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/c$1$3$1

/* anonymous class */
        class c._cls1._cls3._cls1 extends ch
        {

            final View a;
            final c._cls1._cls3 b;

            public void onAnimationEnd(Animator animator)
            {
                a.setClickable(true);
            }

                    
                    {
                        b = _pcls3;
                        a = view;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/c$1$3$2

/* anonymous class */
        class c._cls1._cls3._cls2
            implements Runnable
        {

            final ch a;
            final c._cls1._cls3 b;

            public void run()
            {
                BeautyToolPanel beautytoolpanel = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(b.a.d);
                boolean flag;
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c.c(b.a.d).r() != 0)
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
        }

    }

}

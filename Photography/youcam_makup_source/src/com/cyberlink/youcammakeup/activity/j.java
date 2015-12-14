// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.ViewAnimationUtils;
import com.cyberlink.youcammakeup.utility.cg;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class j
{

    final EditViewActivity a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;

    public j(EditViewActivity editviewactivity, Fragment fragment, Fragment fragment1, Fragment fragment2)
    {
        a = editviewactivity;
        super();
        b = a(fragment);
        c = a(fragment1);
        d = a(fragment2);
        e = editviewactivity.findViewById(0x7f0c00c5);
        f = editviewactivity.findViewById(0x7f0c00d2);
    }

    private View a(Fragment fragment)
    {
        if (fragment != null && fragment.getView() != null)
        {
            return fragment.getView();
        } else
        {
            return new View(a);
        }
    }

    private void a(View view, Animation animation, cg cg)
    {
        view.setVisibility(0);
        view.clearAnimation();
        if (cg == null)
        {
            animation.setAnimationListener(new cg(view) {

                final View a;
                final j b;

                public void onAnimationEnd(Animation animation1)
                {
                    if (a.getAnimation() == animation1)
                    {
                        a.clearAnimation();
                    }
                }

            
            {
                b = j.this;
                a = view;
                super();
            }
            });
        } else
        {
            animation.setAnimationListener(cg);
        }
        view.startAnimation(animation);
    }

    static void a(j j1)
    {
        j1.b();
    }

    static void a(j j1, boolean flag)
    {
        j1.a(flag);
    }

    private void a(boolean flag)
    {
        boolean flag2 = true;
        boolean flag1 = false;
        if (b.getVisibility() != 0)
        {
            Animation animation = ViewAnimationUtils.a(com.cyberlink.youcammakeup.utility.ViewAnimationUtils.SlideDirection.b);
            a(b, animation, null);
            flag1 = true;
        }
        Object obj;
        if (e.getVisibility() != 0)
        {
            Animation animation1 = ViewAnimationUtils.a(com.cyberlink.youcammakeup.utility.ViewAnimationUtils.SlideDirection.a);
            View view = e;
            if (flag)
            {
                obj = new cg() {

                    final j a;

                    public void onAnimationEnd(Animation animation2)
                    {
                        if (EditViewActivity.f(a.a) != null)
                        {
                            EditViewActivity.f(a.a).a();
                        }
                        if (j.b(a).getAnimation() == animation2)
                        {
                            j.b(a).clearAnimation();
                        }
                    }

            
            {
                a = j.this;
                super();
            }
                };
            } else
            {
                obj = null;
            }
            a(view, animation1, ((cg) (obj)));
            flag1 = flag2;
        }
        obj = new Runnable() {

            final j a;

            public void run()
            {
                j.c(a).setVisibility(0);
            }

            
            {
                a = j.this;
                super();
            }
        };
        if (flag1)
        {
            Globals.a(((Runnable) (obj)), ViewAnimationUtils.a());
            return;
        } else
        {
            ((Runnable) (obj)).run();
            return;
        }
    }

    static View b(j j1)
    {
        return j1.e;
    }

    private void b()
    {
        b.setVisibility(4);
        e.setVisibility(4);
        f.setVisibility(4);
    }

    static View c(j j1)
    {
        return j1.f;
    }

    public void a()
    {
        c.setVisibility(0);
        d.setVisibility(8);
    }
}

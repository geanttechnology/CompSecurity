// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            a, d

class c
    implements android.view.View.OnTouchListener
{

    final a a;
    private Handler b;
    private Runnable c;
    private GestureDetector d;
    private boolean e;
    private Animation f;
    private Animation g;
    private Animation h;
    private Animation i;

    public c(a a1, Activity activity, View view)
    {
        a = a1;
        super();
        e = true;
        b = new Handler();
        c = new Runnable(a1) {

            final a a;
            final c b;

            public void run()
            {
                if (com.cyberlink.youcammakeup.b.a.a(b.a))
                {
                    return;
                } else
                {
                    c.a(b);
                    return;
                }
            }

            
            {
                b = c.this;
                a = a1;
                super();
            }
        };
        d = new GestureDetector(activity, new android.view.GestureDetector.SimpleOnGestureListener(a1, activity.getResources().getDisplayMetrics().density) {

            final a a;
            final float b;
            final c c;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
            {
                if (!com.cyberlink.youcammakeup.b.a.a(c.a) && !c.a.s())
                {
                    float f3 = f1 / b;
                    float f4 = f2 / b;
                    if ((Math.abs(f3) >= 500F || Math.abs(f4) >= 500F) && com.cyberlink.youcammakeup.b.a.b(c.a) != 1)
                    {
                        c.c(c).removeCallbacks(c.b(c));
                        c.a(c, false);
                        boolean flag;
                        if (c.a.r())
                        {
                            if (f2 < 0.0F)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                        } else
                        if (f1 < 0.0F)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            com.cyberlink.youcammakeup.b.a.c(c.a).setInAnimation(c.d(c));
                            com.cyberlink.youcammakeup.b.a.c(c.a).setOutAnimation(c.e(c));
                            com.cyberlink.youcammakeup.b.a.c(c.a).showNext();
                        } else
                        {
                            com.cyberlink.youcammakeup.b.a.c(c.a).setInAnimation(c.f(c));
                            com.cyberlink.youcammakeup.b.a.c(c.a).setOutAnimation(c.g(c));
                            com.cyberlink.youcammakeup.b.a.c(c.a).showPrevious();
                        }
                        com.cyberlink.youcammakeup.b.a.c(c.a).setPressed(false);
                        return true;
                    }
                }
                return false;
            }

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                if (com.cyberlink.youcammakeup.b.a.a(c.a))
                {
                    return false;
                }
                c.a.a(com.cyberlink.youcammakeup.b.a.c(c.a).getCurrentView());
                motionevent = (Runnable)com.cyberlink.youcammakeup.b.a.d(c.a).get(com.cyberlink.youcammakeup.b.a.c(c.a).getCurrentView());
                if (motionevent != null)
                {
                    motionevent.run();
                }
                return true;
            }

            
            {
                c = c.this;
                a = a1;
                b = f1;
                super();
            }
        });
        View view1 = activity.findViewById(a1.p());
        activity = view1;
        if (view1 == null)
        {
            activity = view.findViewById(a1.p());
        }
        activity = new android.view.animation.Animation.AnimationListener(a1, activity) {

            final a a;
            final View b;
            final c c;

            public void onAnimationEnd(Animation animation)
            {
                if (!com.cyberlink.youcammakeup.b.a.a(c.a))
                {
                    c.a.b(com.cyberlink.youcammakeup.b.a.c(c.a).getCurrentView());
                    c.a(c);
                    c.a(c, true);
                    b.invalidate();
                    if (com.cyberlink.youcammakeup.b.a.e(c.a) != null)
                    {
                        com.cyberlink.youcammakeup.b.a.e(c.a).setPressed(false);
                        return;
                    }
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                if (com.cyberlink.youcammakeup.b.a.e(c.a) != null)
                {
                    com.cyberlink.youcammakeup.b.a.e(c.a).setPressed(false);
                }
            }

            
            {
                c = c.this;
                a = a1;
                b = view;
                super();
            }
        };
        if (a1.t())
        {
            activity = new android.view.animation.Animation.AnimationListener(a1) {

                final a a;
                final c b;

                public void onAnimationEnd(Animation animation)
                {
                    if (com.cyberlink.youcammakeup.b.a.a(b.a))
                    {
                        return;
                    } else
                    {
                        b.a.b(com.cyberlink.youcammakeup.b.a.c(b.a).getCurrentView());
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                b = c.this;
                a = a1;
                super();
            }
            };
            f = new Animation(a1) {

                final a a;
                final c b;

            
            {
                b = c.this;
                a = a1;
                super();
            }
            };
            f.setAnimationListener(activity);
            h = new Animation(a1) {

                final a a;
                final c b;

            
            {
                b = c.this;
                a = a1;
                super();
            }
            };
            h.setAnimationListener(activity);
        } else
        {
            f = a1.a(a1.q());
            f.setAnimationListener(activity);
            g = a1.b(a1.q());
            h = a1.c(a1.q());
            h.setAnimationListener(activity);
            i = a1.d(a1.q());
        }
        if (com.cyberlink.youcammakeup.b.a.b(a1) == 1)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.b.a.c(a1).setInAnimation(f);
            com.cyberlink.youcammakeup.b.a.c(a1).setOutAnimation(g);
            return;
        }
    }

    private void a()
    {
        if (com.cyberlink.youcammakeup.b.a.a(a))
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.b.a.c(a).stopFlipping();
            com.cyberlink.youcammakeup.b.a.c(a).setAutoStart(false);
            com.cyberlink.youcammakeup.b.a.c(a).setInAnimation(null);
            com.cyberlink.youcammakeup.b.a.c(a).setOutAnimation(null);
            return;
        }
    }

    static void a(c c1)
    {
        c1.b();
    }

    static boolean a(c c1, boolean flag)
    {
        c1.e = flag;
        return flag;
    }

    static Runnable b(c c1)
    {
        return c1.c;
    }

    private void b()
    {
        if (com.cyberlink.youcammakeup.b.a.a(a) || com.cyberlink.youcammakeup.b.a.b(a) == 1)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.b.a.c(a).setInAnimation(null);
            com.cyberlink.youcammakeup.b.a.c(a).setOutAnimation(null);
            com.cyberlink.youcammakeup.b.a.c(a).setAutoStart(true);
            com.cyberlink.youcammakeup.b.a.c(a).startFlipping();
            com.cyberlink.youcammakeup.b.a.c(a).setInAnimation(f);
            com.cyberlink.youcammakeup.b.a.c(a).setOutAnimation(g);
            return;
        }
    }

    static Handler c(c c1)
    {
        return c1.b;
    }

    static Animation d(c c1)
    {
        return c1.f;
    }

    static Animation e(c c1)
    {
        return c1.g;
    }

    static Animation f(c c1)
    {
        return c1.h;
    }

    static Animation g(c c1)
    {
        return c1.i;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!com.cyberlink.youcammakeup.b.a.a(a) && e) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1;
        a();
        b.removeCallbacks(c);
        if (com.cyberlink.youcammakeup.b.a.b(a) > 1)
        {
            b.postDelayed(c, a.d());
        }
        flag1 = d.onTouchEvent(motionevent);
        flag = flag1;
        if (com.cyberlink.youcammakeup.b.a.f(a) == null) goto _L4; else goto _L3
_L3:
        if (motionevent.getActionMasked() == 0)
        {
            com.cyberlink.youcammakeup.b.a.f(a).a(true);
            return flag1;
        }
        if (motionevent.getActionMasked() == 1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (motionevent.getActionMasked() != 3) goto _L4; else goto _L5
_L5:
        com.cyberlink.youcammakeup.b.a.f(a).a(false);
        return flag1;
    }
}

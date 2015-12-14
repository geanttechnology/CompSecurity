// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import myobfuscated.be.a;

// Referenced classes of package com.socialin.picsin.camera.view:
//            d

public class Panel extends LinearLayout
{

    Runnable a;
    private boolean b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private View h;
    private View i;
    private Drawable j;
    private Drawable k;
    private float l;
    private float m;
    private float n;
    private State o;
    private Interpolator p;
    private GestureDetector q;
    private int r;
    private int s;
    private int t;
    private float u;
    private d v;
    private boolean w;
    private android.view.View.OnTouchListener x;
    private android.view.View.OnClickListener y;
    private android.view.animation.Animation.AnimationListener z;

    public Panel(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        x = new android.view.View.OnTouchListener() {

            private int a;
            private int b;
            private boolean c;
            private Panel d;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                int j1 = -1;
                if (com.socialin.picsin.camera.view.Panel.a(d) != State.ANIMATING)
                {
                    int l1 = motionevent.getAction();
                    if (l1 == 0)
                    {
                        if (Panel.b(d))
                        {
                            d.bringToFront();
                        }
                        a = 0;
                        b = 0;
                        if (Panel.c(d).getVisibility() == 8)
                        {
                            if (Panel.d(d) == 1)
                            {
                                if (Panel.e(d) != 0)
                                {
                                    j1 = 1;
                                }
                                b = j1;
                            } else
                            {
                                if (Panel.e(d) != 2)
                                {
                                    j1 = 1;
                                }
                                a = j1;
                            }
                        }
                        c = true;
                    } else
                    {
                        if (c)
                        {
                            a = a * Panel.f(d);
                            b = b * Panel.g(d);
                            view = Panel.h(d);
                            int k1 = a;
                            int i2 = b;
                            view.b = k1;
                            view.a = i2;
                            c = false;
                            a = -a;
                            b = -b;
                        }
                        motionevent.offsetLocation(a, b);
                    }
                    if (!Panel.i(d).onTouchEvent(motionevent) && l1 == 1)
                    {
                        d.post(d.a);
                        return false;
                    }
                }
                return false;
            }

            
            {
                d = Panel.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            private Panel a;

            public final void onClick(View view)
            {
                if (Panel.b(a))
                {
                    a.bringToFront();
                }
                if (a.a())
                {
                    a.post(a.a);
                }
            }

            
            {
                a = Panel.this;
                super();
            }
        };
        a = new Runnable() {

            private Panel a;

            public final void run()
            {
                int j1;
                int k1;
                int j2;
                boolean flag1;
                boolean flag2;
                flag2 = true;
                flag1 = true;
                j2 = 0;
                if (com.socialin.picsin.camera.view.Panel.a(a) == State.FLYING)
                {
                    Panel panel = a;
                    int k2;
                    if (Panel.e(a) == 0 || Panel.e(a) == 2)
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                    if (Panel.j(a) > 0.0F)
                    {
                        k1 = 1;
                    } else
                    {
                        k1 = 0;
                    }
                    com.socialin.picsin.camera.view.Panel.a(panel, j1 ^ k1);
                }
                if (Panel.d(a) != 1) goto _L2; else goto _L1
_L1:
                int l1 = Panel.g(a);
                if (!Panel.k(a))
                {
                    j1 = l1;
                    if (Panel.e(a) == 0)
                    {
                        j1 = -l1;
                    }
                    k1 = 0;
                    l1 = j1;
                } else
                {
                    k1 = l1;
                    if (Panel.e(a) == 0)
                    {
                        k1 = -l1;
                    }
                    l1 = 0;
                }
                if (com.socialin.picsin.camera.view.Panel.a(a) == State.TRACKING)
                {
                    Object obj;
                    int i2;
                    boolean flag;
                    if (Math.abs(Panel.l(a) - (float)l1) < Math.abs(Panel.l(a) - (float)k1))
                    {
                        panel = a;
                        if (Panel.k(a))
                        {
                            flag1 = false;
                        }
                        com.socialin.picsin.camera.view.Panel.a(panel, flag1);
                    } else
                    {
                        l1 = k1;
                    }
                    k1 = (int)Panel.l(a);
                    j1 = l1;
                    l1 = k1;
                } else
                {
                    j1 = k1;
                    if (com.socialin.picsin.camera.view.Panel.a(a) == State.FLYING)
                    {
                        l1 = (int)Panel.l(a);
                        j1 = k1;
                    }
                }
                if (com.socialin.picsin.camera.view.Panel.a(a) == State.FLYING && Panel.m(a))
                {
                    k2 = Math.max((int)(Math.abs((float)(j1 - l1) / Panel.j(a)) * 1000F), 20);
                    k1 = 0;
                    j2 = j1;
                    i2 = 0;
                    j1 = k2;
                } else
                {
                    if (Panel.g(a) > 0)
                    {
                        k1 = (Panel.n(a) * Math.abs(j1 - l1)) / Panel.g(a);
                    } else
                    {
                        k1 = 0;
                    }
                    flag = false;
                    i2 = 0;
                    j2 = j1;
                    j1 = k1;
                    k1 = ((flag) ? 1 : 0);
                }
                com.socialin.picsin.camera.view.Panel.a(a, Panel.b(a, 0.0F));
                if (j1 == 0)
                {
                    com.socialin.picsin.camera.view.Panel.a(a, State.READY);
                    if (Panel.k(a))
                    {
                        Panel.c(a).setVisibility(8);
                    }
                    Panel.p(a);
                    return;
                }
                  goto _L3
_L2:
                l1 = Panel.f(a);
                if (!Panel.k(a))
                {
                    j1 = l1;
                    if (Panel.e(a) == 2)
                    {
                        j1 = -l1;
                    }
                    k1 = 0;
                } else
                {
                    k1 = l1;
                    if (Panel.e(a) == 2)
                    {
                        k1 = -l1;
                    }
                    j1 = 0;
                }
                if (com.socialin.picsin.camera.view.Panel.a(a) == State.TRACKING)
                {
                    if (Math.abs(Panel.o(a) - (float)j1) < Math.abs(Panel.o(a) - (float)k1))
                    {
                        obj = a;
                        if (!Panel.k(a))
                        {
                            flag1 = flag2;
                        } else
                        {
                            flag1 = false;
                        }
                        com.socialin.picsin.camera.view.Panel.a(((Panel) (obj)), flag1);
                    } else
                    {
                        j1 = k1;
                    }
                    k1 = (int)Panel.o(a);
                    i2 = j1;
                    j1 = k1;
                } else
                {
                    i2 = k1;
                    if (com.socialin.picsin.camera.view.Panel.a(a) == State.FLYING)
                    {
                        j1 = (int)Panel.o(a);
                        i2 = k1;
                    }
                }
                if (com.socialin.picsin.camera.view.Panel.a(a) == State.FLYING && Panel.m(a))
                {
                    if (Panel.j(a) != 0.0F)
                    {
                        k1 = (int)(Math.abs((float)(i2 - j1) / Panel.j(a)) * 1000F);
                    } else
                    {
                        k1 = 0;
                    }
                    l1 = Math.max(k1, 20);
                    k1 = j1;
                    flag = false;
                    j1 = l1;
                    l1 = ((flag) ? 1 : 0);
                } else
                if (Panel.f(a) != 0)
                {
                    l1 = (Panel.n(a) * Math.abs(i2 - j1)) / Panel.f(a);
                    k1 = j1;
                    flag = false;
                    j1 = l1;
                    l1 = ((flag) ? 1 : 0);
                } else
                {
                    l1 = 0;
                    k1 = j1;
                    flag = false;
                    j1 = l1;
                    l1 = ((flag) ? 1 : 0);
                }
                if (false)
                {
                    break MISSING_BLOCK_LABEL_758;
                } else
                {
                    break MISSING_BLOCK_LABEL_266;
                }
_L3:
                obj = new TranslateAnimation(k1, i2, l1, j2);
                ((TranslateAnimation) (obj)).setDuration(j1);
                ((TranslateAnimation) (obj)).setAnimationListener(Panel.q(a));
                if (com.socialin.picsin.camera.view.Panel.a(a) != State.FLYING || !Panel.m(a)) goto _L5; else goto _L4
_L4:
                ((TranslateAnimation) (obj)).setInterpolator(new LinearInterpolator());
_L7:
                a.startAnimation(((Animation) (obj)));
                return;
_L5:
                if (Panel.r(a) != null)
                {
                    ((TranslateAnimation) (obj)).setInterpolator(Panel.r(a));
                }
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                a = Panel.this;
                super();
            }
        };
        z = new android.view.animation.Animation.AnimationListener() {

            private Panel a;

            public final void onAnimationEnd(Animation animation)
            {
                com.socialin.picsin.camera.view.Panel.a(a, State.READY);
                if (Panel.k(a))
                {
                    Panel.c(a).setVisibility(8);
                }
                Panel.p(a);
            }

            public final void onAnimationRepeat(Animation animation)
            {
            }

            public final void onAnimationStart(Animation animation)
            {
                com.socialin.picsin.camera.view.Panel.a(a, State.ANIMATING);
            }

            
            {
                a = Panel.this;
                super();
            }
        };
        attributeset = context.obtainStyledAttributes(attributeset, a.Panel);
        d = attributeset.getInteger(a.Panel_animationDuration, 750);
        c = attributeset.getInteger(a.Panel_position, 1);
        e = attributeset.getBoolean(a.Panel_linearFlying, false);
        u = attributeset.getFraction(a.Panel_weight, 0, 1, 0.0F);
        if (u < 0.0F || u > 1.0F)
        {
            u = 0.0F;
            Log.w("Panel", (new StringBuilder()).append(attributeset.getPositionDescription()).append(": weight must be > 0 and <= 1").toString());
        }
        j = attributeset.getDrawable(a.Panel_openedHandle);
        k = attributeset.getDrawable(a.Panel_closedHandle);
        context = null;
        f = attributeset.getResourceId(a.Panel_defaultHandle, 0);
        if (f == 0)
        {
            context = new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": The handle attribute is required and must refer to a valid child.").toString());
        }
        g = attributeset.getResourceId(a.Panel_defaultContent, 0);
        if (g == 0)
        {
            context = new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": The content attribute is required and must refer to a valid child.").toString());
        }
        attributeset.recycle();
        if (context != null)
        {
            throw context;
        }
        int i1;
        if (c == 0 || c == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        t = i1;
        setOrientation(t);
        o = State.READY;
        v = new d(this);
        q = new GestureDetector(v);
        q.setIsLongpressEnabled(false);
        setBaselineAligned(false);
    }

    static float a(float f1, int i1, int j1)
    {
        return Math.min(Math.max(f1, i1), j1);
    }

    static float a(Panel panel, float f1)
    {
        panel.l = f1;
        return f1;
    }

    static State a(Panel panel)
    {
        return panel.o;
    }

    static State a(Panel panel, State state)
    {
        panel.o = state;
        return state;
    }

    static boolean a(Panel panel, boolean flag)
    {
        panel.b = flag;
        return flag;
    }

    static float b(Panel panel, float f1)
    {
        panel.m = f1;
        return f1;
    }

    static boolean b(Panel panel)
    {
        return panel.w;
    }

    static float c(Panel panel, float f1)
    {
        panel.n = f1;
        return f1;
    }

    static View c(Panel panel)
    {
        return panel.i;
    }

    static int d(Panel panel)
    {
        return panel.t;
    }

    static int e(Panel panel)
    {
        return panel.c;
    }

    static int f(Panel panel)
    {
        return panel.s;
    }

    static int g(Panel panel)
    {
        return panel.r;
    }

    static d h(Panel panel)
    {
        return panel.v;
    }

    static GestureDetector i(Panel panel)
    {
        return panel.q;
    }

    static float j(Panel panel)
    {
        return panel.n;
    }

    static boolean k(Panel panel)
    {
        return panel.b;
    }

    static float l(Panel panel)
    {
        return panel.m;
    }

    static boolean m(Panel panel)
    {
        return panel.e;
    }

    static int n(Panel panel)
    {
        return panel.d;
    }

    static float o(Panel panel)
    {
        return panel.l;
    }

    static void p(Panel panel)
    {
        if (panel.b && panel.k != null)
        {
            panel.h.setBackgroundDrawable(panel.k);
        } else
        if (!panel.b && panel.j != null)
        {
            panel.h.setBackgroundDrawable(panel.j);
            return;
        }
    }

    static android.view.animation.Animation.AnimationListener q(Panel panel)
    {
        return panel.z;
    }

    static Interpolator r(Panel panel)
    {
        return panel.p;
    }

    public final boolean a()
    {
        if (o != State.READY)
        {
            return false;
        }
        o = State.ABOUT_TO_ANIMATE;
        boolean flag;
        if (i.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        if (!b)
        {
            i.setVisibility(0);
        }
        return true;
    }

    protected void dispatchDraw(Canvas canvas)
    {
label0:
        {
            int j1;
label1:
            {
                if (o != State.ABOUT_TO_ANIMATE || b)
                {
                    break label0;
                }
                int i1;
                if (t == 1)
                {
                    i1 = r;
                } else
                {
                    i1 = s;
                }
                if (c != 2)
                {
                    j1 = i1;
                    if (c != 0)
                    {
                        break label1;
                    }
                }
                j1 = -i1;
            }
            if (t == 1)
            {
                canvas.translate(0.0F, j1);
            } else
            {
                canvas.translate(j1, 0.0F);
            }
        }
        if (o == State.TRACKING || o == State.FLYING)
        {
            canvas.translate(l, m);
        }
        super.dispatchDraw(canvas);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        android.view.ViewParent viewparent = getParent();
        if (viewparent != null && (viewparent instanceof FrameLayout))
        {
            w = true;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        h = findViewById(f);
        if (h == null)
        {
            String s1 = getResources().getResourceEntryName(f);
            throw new RuntimeException((new StringBuilder("Your Panel must have a child View whose id attribute is 'R.id.")).append(s1).append("'").toString());
        }
        h.setOnTouchListener(x);
        h.setOnClickListener(y);
        i = findViewById(g);
        if (i == null)
        {
            String s2 = getResources().getResourceEntryName(f);
            throw new RuntimeException((new StringBuilder("Your Panel must have a child View whose id attribute is 'R.id.")).append(s2).append("'").toString());
        }
        removeView(h);
        removeView(i);
        if (c == 0 || c == 2)
        {
            addView(i);
            addView(h);
        } else
        {
            addView(h);
            addView(i);
        }
        if (k != null)
        {
            h.setBackgroundDrawable(k);
        }
        i.setClickable(true);
        i.setVisibility(8);
        if (u > 0.0F)
        {
            android.view.ViewGroup.LayoutParams layoutparams = i.getLayoutParams();
            if (t == 1)
            {
                layoutparams.height = -1;
            } else
            {
                layoutparams.width = -1;
            }
            i.setLayoutParams(layoutparams);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        s = i.getWidth();
        r = i.getHeight();
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = i1;
        int l1 = j1;
        if (u > 0.0F)
        {
            k1 = i1;
            l1 = j1;
            if (i.getVisibility() == 0)
            {
                View view = (View)getParent();
                k1 = i1;
                l1 = j1;
                if (view != null)
                {
                    if (t == 1)
                    {
                        l1 = android.view.View.MeasureSpec.makeMeasureSpec((int)((float)view.getHeight() * u), 0x40000000);
                        k1 = i1;
                    } else
                    {
                        k1 = android.view.View.MeasureSpec.makeMeasureSpec((int)((float)view.getWidth() * u), 0x40000000);
                        l1 = j1;
                    }
                }
            }
        }
        super.onMeasure(k1, l1);
    }

    public void setInterpolator(Interpolator interpolator)
    {
        p = interpolator;
    }

    public void setOnPanelListener$50e708a5(com.melnykov.fab.a a1)
    {
    }

    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State ABOUT_TO_ANIMATE;
        public static final State ANIMATING;
        public static final State FLYING;
        public static final State READY;
        public static final State TRACKING;

        public static State valueOf(String s1)
        {
            return (State)Enum.valueOf(com/socialin/picsin/camera/view/Panel$State, s1);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            ABOUT_TO_ANIMATE = new State("ABOUT_TO_ANIMATE", 0);
            ANIMATING = new State("ANIMATING", 1);
            READY = new State("READY", 2);
            TRACKING = new State("TRACKING", 3);
            FLYING = new State("FLYING", 4);
            $VALUES = (new State[] {
                ABOUT_TO_ANIMATE, ANIMATING, READY, TRACKING, FLYING
            });
        }

        private State(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}

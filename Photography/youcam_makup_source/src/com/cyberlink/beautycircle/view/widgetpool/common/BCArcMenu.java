// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            ArcLayout, ArcView, b

public class BCArcMenu extends RelativeLayout
{

    private RelativeLayout a;
    private ArcLayout b;
    private View c;
    private View d;
    private View e;
    private View f;
    private PointF g;
    private b h;
    private android.view.View.OnLayoutChangeListener i;
    private android.view.View.OnTouchListener j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;

    public BCArcMenu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = new PointF();
        h = null;
        i = new android.view.View.OnLayoutChangeListener() {

            final BCArcMenu a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (BCArcMenu.a(a) != null)
                {
                    j1 = BCArcMenu.a(a).getWidth();
                    i1 = BCArcMenu.a(a).getHeight();
                    BCArcMenu.a(a).setLeft((int)BCArcMenu.b(a).x - j1 / 2);
                    BCArcMenu.a(a).setTop((int)BCArcMenu.b(a).y - i1 / 2);
                    view = BCArcMenu.a(a);
                    k1 = (int)BCArcMenu.b(a).x;
                    view.setRight(j1 / 2 + k1);
                    view = BCArcMenu.a(a);
                    j1 = (int)BCArcMenu.b(a).y;
                    view.setBottom(i1 / 2 + j1);
                }
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        };
        j = new android.view.View.OnTouchListener() {

            final BCArcMenu a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0)
                {
                    float f1 = motionevent.getX();
                    float f2 = motionevent.getY();
                    BCArcMenu.b(a).set(f1, f2);
                    BCArcMenu.c(a);
                } else
                {
                    if (motionevent.getAction() == 1)
                    {
                        BCArcMenu.a(a).dispatchTouchEvent(motionevent);
                        BCArcMenu.d(a);
                        a.requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                    if (motionevent.getAction() == 2)
                    {
                        BCArcMenu.a(a).dispatchTouchEvent(motionevent);
                        return true;
                    }
                }
                return true;
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        };
        k = new android.view.View.OnClickListener() {

            final BCArcMenu a;

            public void onClick(View view)
            {
                if (BCArcMenu.f(a) != null)
                {
                    BCArcMenu.f(a).b();
                }
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final BCArcMenu a;

            public void onClick(View view)
            {
                if (BCArcMenu.f(a) != null)
                {
                    BCArcMenu.f(a).c();
                }
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final BCArcMenu a;

            public void onClick(View view)
            {
                if (BCArcMenu.f(a) != null)
                {
                    BCArcMenu.f(a).d();
                }
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final BCArcMenu a;

            public void onClick(View view)
            {
                if (BCArcMenu.f(a) != null)
                {
                    BCArcMenu.f(a).e();
                }
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        };
        a(context);
    }

    static ArcLayout a(BCArcMenu bcarcmenu)
    {
        return bcarcmenu.b;
    }

    private void a()
    {
        ObjectAnimator.ofFloat(a, "alpha", new float[] {
            0.0F, 1.0F
        }).setDuration(200L).start();
        int j1 = b.getWidth();
        int i1 = b.getHeight();
        b.setLeft((int)g.x - j1 / 2);
        b.setTop((int)g.y - i1 / 2);
        ArcLayout arclayout = b;
        int k1 = (int)g.x;
        arclayout.setRight(j1 / 2 + k1);
        arclayout = b;
        j1 = (int)g.y;
        arclayout.setBottom(i1 / 2 + j1);
        b();
        b.a(500);
    }

    private void a(Context context)
    {
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_view_arcmenu, this);
        a = (RelativeLayout)context.findViewById(j.bc_arc_mainLayout);
        a.setVisibility(4);
        a.setOnTouchListener(j);
        b = (ArcLayout)context.findViewById(j.bc_arc_circleLayout);
        b.setVisibility(4);
        b.addOnLayoutChangeListener(i);
        c = context.findViewById(j.bc_arc_circle_it);
        c.setOnClickListener(k);
        d = context.findViewById(j.bc_arc_like);
        d.setOnClickListener(l);
        e = context.findViewById(j.bc_arc_share);
        e.setOnClickListener(m);
        f = context.findViewById(j.bc_arc_edit);
        f.setOnClickListener(n);
    }

    private void a(View view, int i1)
    {
        if (view != null)
        {
            if (i1 != 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
    }

    static PointF b(BCArcMenu bcarcmenu)
    {
        return bcarcmenu.g;
    }

    private void b()
    {
        float f4 = getWidth();
        float f3 = g.x;
        float f2 = g.y;
        float f6 = ((float)b.getOutterRadius() * 5F) / 4F;
        float f5 = (float)b.getOutterRadius() / 4F;
        float f1 = b.getAngleRange();
        boolean flag = false;
        if (f2 - f6 > 0.0F)
        {
            f2 = 270F;
        } else
        {
            f2 = 90F - f1;
            flag = true;
        }
        f6 = f4 - f5;
        if (f3 > f5 && f3 < f6)
        {
            f1 = (f1 * (f3 - f5)) / (f4 - 2.0F * f5);
        } else
        if (f3 <= f6)
        {
            f1 = 0.0F;
        }
        if (flag)
        {
            f1 += f2;
        } else
        {
            f1 = f2 - f1;
        }
        b.setAngleOffset(f1);
    }

    private void c()
    {
        b.b(200);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(a, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.addListener(new android.animation.Animator.AnimatorListener() {

            final BCArcMenu a;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                BCArcMenu.b(a).set(0.0F, 0.0F);
                int i1 = BCArcMenu.a(a).getWidth();
                int j1 = BCArcMenu.a(a).getHeight();
                int k1 = 0 - i1;
                BCArcMenu.a(a).setLeft(k1 - i1 / 2);
                BCArcMenu.a(a).setTop(0 - j1 / 2);
                BCArcMenu.a(a).setRight(i1 / 2 + k1);
                BCArcMenu.a(a).setBottom(j1 / 2 + 0);
                BCArcMenu.e(a).setVisibility(4);
                if (BCArcMenu.f(a) != null)
                {
                    BCArcMenu.f(a).a();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = BCArcMenu.this;
                super();
            }
        });
        objectanimator.start();
    }

    static void c(BCArcMenu bcarcmenu)
    {
        bcarcmenu.a();
    }

    static void d(BCArcMenu bcarcmenu)
    {
        bcarcmenu.c();
    }

    static RelativeLayout e(BCArcMenu bcarcmenu)
    {
        return bcarcmenu.a;
    }

    static b f(BCArcMenu bcarcmenu)
    {
        return bcarcmenu.h;
    }

    public void a(int i1)
    {
        a(c, i1 & 0x20);
        a(d, i1 & 0x40);
        a(e, i1 & 0x80);
        a(f, i1 & 0x100);
        a.setVisibility(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (a.getVisibility() != 0)
        {
            return false;
        }
        if (motionevent.getAction() == 0)
        {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionevent);
    }

    public void setCallback(b b1)
    {
        h = b1;
    }

    public void setIsLike(boolean flag)
    {
        String s;
        int i1;
        if (flag)
        {
            i1 = i.bc_arc_icon_like;
            s = getResources().getString(m.bc_arc_like);
        } else
        {
            i1 = i.bc_arc_icon_unlike;
            s = getResources().getString(m.bc_arc_unlike);
        }
        ((ArcView)d).setCircleImageResource(i1);
        ((ArcView)d).setHintText(s);
    }
}

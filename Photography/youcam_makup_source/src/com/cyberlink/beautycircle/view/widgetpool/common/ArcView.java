// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.n;

public class ArcView extends LinearLayout
{

    public boolean a;
    public boolean b;
    public Rect c;
    public Rect d;
    private int e;
    private String f;
    private TextView g;
    private ImageView h;

    public ArcView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = 200;
        a = false;
        b = false;
        f = "";
        c = new Rect();
        d = new Rect();
        a(context, attributeset);
    }

    static TextView a(ArcView arcview)
    {
        return arcview.g;
    }

    private void a()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("scaleX", new float[] {
                1.0F, 1.3F
            }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                1.0F, 1.3F
            }), PropertyValuesHolder.ofFloat("x", new float[] {
                (float)c.left, (float)d.left
            }), PropertyValuesHolder.ofFloat("y", new float[] {
                (float)c.top, (float)d.top
            })
        });
        objectanimator.setDuration(e);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.start();
    }

    private void a(Context context, AttributeSet attributeset)
    {
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_view_arc_item, this);
        g = (TextView)context.findViewById(j.hint_text);
        h = (ImageView)context.findViewById(j.circle_view);
        if (attributeset != null)
        {
            context = getContext().obtainStyledAttributes(attributeset, n.bc_arc_view, 0, 0);
            f = context.getString(n.bc_arc_view_bc_arc_hintText);
            int i = context.getResourceId(n.bc_arc_view_bc_arc_circleBackground, 0);
            h.setImageResource(i);
            context.recycle();
        }
    }

    private void b()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("scaleX", new float[] {
                1.3F, 1.0F
            }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                1.3F, 1.0F
            }), PropertyValuesHolder.ofFloat("x", new float[] {
                (float)d.left, (float)c.left
            }), PropertyValuesHolder.ofFloat("y", new float[] {
                (float)d.top, (float)c.top
            })
        });
        objectanimator.setDuration(e);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.start();
    }

    private void c()
    {
        Object obj = PropertyValuesHolder.ofFloat("scaleX", new float[] {
            0.0F, 1.0F
        });
        PropertyValuesHolder propertyvaluesholder = PropertyValuesHolder.ofFloat("scaleY", new float[] {
            0.0F, 1.0F
        });
        obj = ObjectAnimator.ofPropertyValuesHolder(g, new PropertyValuesHolder[] {
            obj, propertyvaluesholder
        });
        ((ObjectAnimator) (obj)).setDuration(e);
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).start();
    }

    private void d()
    {
        Object obj = PropertyValuesHolder.ofFloat("scaleX", new float[] {
            1.0F, 0.0F
        });
        PropertyValuesHolder propertyvaluesholder = PropertyValuesHolder.ofFloat("scaleY", new float[] {
            1.0F, 0.0F
        });
        obj = ObjectAnimator.ofPropertyValuesHolder(g, new PropertyValuesHolder[] {
            obj, propertyvaluesholder
        });
        ((ObjectAnimator) (obj)).setDuration(e);
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).addListener(new android.animation.Animator.AnimatorListener() {

            final ArcView a;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                ArcView.a(a).setText("");
                ArcView.a(a).setVisibility(4);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = ArcView.this;
                super();
            }
        });
        ((ObjectAnimator) (obj)).start();
    }

    public void a(int i, int l, int i1, int j1)
    {
        c.left = i;
        c.top = l;
        c.right = i1;
        c.bottom = j1;
    }

    public void b(int i, int l, int i1, int j1)
    {
        d.left = i;
        d.top = l;
        d.right = i1;
        d.bottom = j1;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        setIsEntered(false);
        performClick();
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (motionevent.getAction() == 2 && a && !b)
        {
            b = true;
            g.setVisibility(0);
            g.setText(f);
            a();
            c();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setCircleImageResource(int i)
    {
        h.setImageResource(i);
    }

    public void setHintText(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            f = s;
            return;
        }
    }

    public void setIsEntered(boolean flag)
    {
        a = flag;
        h.setSelected(flag);
        if (!flag && b)
        {
            b = false;
            b();
            d();
        }
    }
}

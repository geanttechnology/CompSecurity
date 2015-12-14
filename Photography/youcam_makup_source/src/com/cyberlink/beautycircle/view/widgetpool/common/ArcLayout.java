// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.cyberlink.beautycircle.n;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            a, ArcView

public class ArcLayout extends ViewGroup
{

    private Drawable a;
    private float b;
    private float c;
    private int d;
    private Paint e;
    private int f;
    private PointF g;
    private ObjectAnimator h;

    public ArcLayout(Context context)
    {
        this(context, null);
    }

    public ArcLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = null;
        h = null;
        e = new Paint(1);
        e.setStyle(android.graphics.Paint.Style.STROKE);
        context = context.getTheme().obtainStyledAttributes(attributeset, n.bc_arc_layout, 0, 0);
        a = context.getDrawable(n.bc_arc_layout_bc_arc_innerCircle);
        if (a instanceof ColorDrawable)
        {
            int i = context.getColor(n.bc_arc_layout_bc_arc_innerCircle, 0x106000b);
            e.setColor(i);
        }
        float f1 = context.getDimension(n.bc_arc_layout_bc_arc_innerCircleBorderWidth, 0.0F);
        e.setStrokeWidth(f1);
        b = context.getFloat(n.bc_arc_layout_bc_arc_angleOffset, 270F);
        c = context.getFloat(n.bc_arc_layout_bc_arc_angleRange, 90F);
        d = context.getDimensionPixelSize(n.bc_arc_layout_bc_arc_innerRadius, 80);
        f = context.getDimensionPixelSize(n.bc_arc_layout_bc_arc_outterRadius, c());
        context.recycle();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(1, null);
        }
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private a a(View view)
    {
        return (a)view.getLayoutParams();
    }

    private void a(Canvas canvas, float f1, float f2)
    {
        if (a != null)
        {
            canvas.drawCircle(f1, f2, d, e);
        }
    }

    private void b()
    {
        int i3 = getChildCount();
        if (i3 != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f1;
        float f2;
        float f4;
        int i;
        int j;
        int k;
        int l;
        f1 = 0.0F;
        i = 0;
        while (i < i3) 
        {
            View view = getChildAt(i);
            if (view.getVisibility() == 0)
            {
                f1 = a(view).c + f1;
            }
            i++;
        }
        i = getWidth();
        j = getHeight();
        f4 = getOutterRadius();
        f2 = b;
        l = 0;
        k = i3 - 1;
_L4:
        View view1 = getChildAt(k);
        float f3 = f2;
        if (view1.getVisibility() == 0)
        {
            a a1 = a(view1);
            f3 = c / (f1 - 1.0F);
            float f5 = a1.c;
            PointF pointf = getCenter();
            int k3 = view1.getMeasuredWidth() / 2;
            int j3 = view1.getMeasuredHeight() / 2;
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            if (i3 > 1)
            {
                i2 = (int)((double)f4 * Math.cos(Math.toRadians(f2))) + (int)pointf.x;
                i1 = (int)((double)f4 * Math.sin(Math.toRadians(f2)));
                j2 = (int)pointf.y + i1;
                k1 = (int)((double)(1.2F * f4) * Math.cos(Math.toRadians(f2))) + (int)pointf.x;
                i1 = (int)((double)(1.2F * f4) * Math.sin(Math.toRadians(f2)));
                i1 = (int)pointf.y + i1;
            } else
            {
                k1 = (int)pointf.x;
                i1 = (int)pointf.y;
                j2 = i1;
                i2 = k1;
            }
            if (a1.width != -1)
            {
                j1 = i2 - k3;
            } else
            {
                j1 = 0;
            }
            if (a1.height != -1)
            {
                l1 = j2 - j3;
            } else
            {
                l1 = 0;
            }
            if (a1.width != -1)
            {
                i2 += k3;
            } else
            {
                i2 = i;
            }
            if (a1.height != -1)
            {
                j2 += j3;
            } else
            {
                j2 = j;
            }
            if (a1.width != -1)
            {
                k2 = k1 - k3;
            } else
            {
                k2 = 0;
            }
            if (a1.height != -1)
            {
                l2 = i1 - j3;
            } else
            {
                l2 = 0;
            }
            if (a1.width != -1)
            {
                k1 += k3;
            } else
            {
                k1 = i;
            }
            if (a1.height != -1)
            {
                i1 += j3;
            } else
            {
                i1 = j;
            }
            view1.layout(j1, l1, i2, j2);
            ((ArcView)view1).a(j1, l1, i2, j2);
            ((ArcView)view1).b(k2, l2, k1, i1);
            a1.a = f2;
            f3 = f2 + f3 * f5;
            a1.b = f3;
        }
        l++;
        if (l >= i3) goto _L1; else goto _L3
_L3:
        k = (k + 1) % i3;
        f2 = f3;
          goto _L4
    }

    private int c()
    {
        int i = getWidth();
        int j = getHeight();
        float f1;
        if (i > j)
        {
            f1 = j;
        } else
        {
            f1 = i;
        }
        return (int)((f1 - (float)d) / 2.0F);
    }

    protected a a()
    {
        return new a(-2, -2);
    }

    public a a(AttributeSet attributeset)
    {
        return new a(getContext(), attributeset);
    }

    protected a a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a a1 = new a(layoutparams.width, layoutparams.height);
        if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
        {
            a1.c = ((android.widget.LinearLayout.LayoutParams)layoutparams).weight;
        }
        return a1;
    }

    public void a(int i)
    {
        setVisibility(0);
        h = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                0.0F, 1.0F
            }), PropertyValuesHolder.ofFloat("scaleX", new float[] {
                0.0F, 1.05F, 1.0F
            }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                0.0F, 1.05F, 1.0F
            })
        });
        h.setDuration(i);
        h.start();
    }

    public void b(int i)
    {
        if (h != null)
        {
            h.cancel();
        }
        ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("alpha", new float[] {
                1.0F, 0.0F
            }), PropertyValuesHolder.ofFloat("scaleX", new float[] {
                1.0F, 0.0F
            }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                1.0F, 0.0F
            })
        });
        objectanimator.setDuration(i);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.addListener(new android.animation.Animator.AnimatorListener() {

            final ArcLayout a;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                a.setVisibility(4);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = ArcLayout.this;
                super();
            }
        });
        objectanimator.start();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof a;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (a != null)
        {
            PointF pointf = getCenter();
            a(canvas, pointf.x, pointf.y);
        }
        b();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (!onInterceptTouchEvent(motionevent))
        {
            int i = 0;
            boolean flag = false;
            while (i < getChildCount()) 
            {
                View view = getChildAt(i);
                if (view != null && view.getVisibility() == 0)
                {
                    int j = (int)motionevent.getX();
                    int k = (int)motionevent.getY();
                    int l = (int)getX();
                    int i1 = (int)getY();
                    int j1 = view.getLeft();
                    int k1 = view.getTop();
                    int l1 = view.getRight();
                    int i2 = view.getBottom();
                    if (j1 + l <= j && l + l1 >= j && k1 + i1 <= k && i1 + i2 >= k)
                    {
                        ((ArcView)view).setIsEntered(true);
                        if (view.dispatchTouchEvent(motionevent))
                        {
                            flag = true;
                        }
                    } else
                    {
                        ((ArcView)view).setIsEntered(false);
                    }
                }
                i++;
            }
            if (flag)
            {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public float getAngleRange()
    {
        return c;
    }

    public PointF getCenter()
    {
        if (g == null)
        {
            g = new PointF();
            g.set((float)getWidth() / 2.0F, getHeight() / 2);
        }
        return g;
    }

    public Drawable getInnerCircle()
    {
        return a;
    }

    public int getOutterRadius()
    {
        return f;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        b();
        invalidate();
    }

    protected void onMeasure(int i, int j)
    {
        int i1 = 0;
        int l1 = getChildCount();
        int k = 0;
        int l;
        int j1;
        for (l = 0; k < l1; l = j1)
        {
            View view = getChildAt(k);
            int k1 = i1;
            j1 = l;
            if (view.getVisibility() != 8)
            {
                measureChild(view, i, j);
                k1 = Math.max(i1, view.getMeasuredWidth());
                j1 = Math.max(l, view.getMeasuredHeight());
            }
            k++;
            i1 = k1;
        }

        k = Math.max(l, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSize(Math.max(i1, getSuggestedMinimumWidth()), i), resolveSize(k, j));
    }

    public void setAngleOffset(float f1)
    {
        b = f1;
    }

    public void setInnerCircleColor(int i)
    {
        a = new ColorDrawable(i);
        requestLayout();
        invalidate();
    }
}

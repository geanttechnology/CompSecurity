// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.c;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            al, am

public class TextLoopView extends View
{

    private List a;
    private float b;
    private int c;
    private int d;
    private TextView e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private ValueAnimator k;
    private al l;
    private am m;
    private Handler n;

    public TextLoopView(Context context)
    {
        super(context);
        b = 0.0F;
        c = -1;
        d = 0xffff0000;
        f = 0;
        g = -1;
        h = -1;
        i = -1;
        j = true;
        l = new al(this);
        a(context);
    }

    public TextLoopView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = 0.0F;
        c = -1;
        d = 0xffff0000;
        f = 0;
        g = -1;
        h = -1;
        i = -1;
        j = true;
        l = new al(this);
        a(context);
    }

    public TextLoopView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = 0.0F;
        c = -1;
        d = 0xffff0000;
        f = 0;
        g = -1;
        h = -1;
        i = -1;
        j = true;
        l = new al(this);
        a(context);
    }

    static int a(TextLoopView textloopview)
    {
        return textloopview.g;
    }

    private void a(int i1, boolean flag)
    {
        if (j)
        {
            int j1 = h + i1;
            if (j1 < 0 || a.size() <= j1)
            {
                return;
            }
        }
        k = ValueAnimator.ofInt(com.cyberlink.youcammakeup.utility.c.b(0, f * -i1));
        k.setDuration(Math.abs(i1) * 150);
        k.setInterpolator(new AccelerateDecelerateInterpolator());
        k.addUpdateListener(l);
        k.addListener(l);
        al.a(l, flag);
        al.a(l, i1);
        k.start();
    }

    private void a(Context context)
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            n = new Handler();
            e = new TextView(context);
            e.setGravity(17);
            e.setLineSpacing(0.0F, 0.95F);
            e.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
            setOnTouchListener(new android.view.View.OnTouchListener(context) {

                final Context a;
                final TextLoopView b;
                private GestureDetector c;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (!al.a(TextLoopView.d(b)))
                    {
                        c.onTouchEvent(motionevent);
                    }
                    return true;
                }

            
            {
                b = TextLoopView.this;
                a = context;
                super();
                c = new GestureDetector(a, new _cls1(this));
            }
            });
            return;
        }
    }

    static void a(TextLoopView textloopview, int i1, boolean flag)
    {
        textloopview.a(i1, flag);
    }

    private int b(int i1)
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        int j1 = -1;
_L4:
        return j1;
_L2:
        j1 = i1;
        if (!j)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = i1;
        if (a.size() > i1) goto _L4; else goto _L3
_L3:
        return -1;
        for (; j1 < 0; j1 += a.size()) { }
        return j1 % a.size();
    }

    static int b(TextLoopView textloopview)
    {
        return textloopview.f;
    }

    private void b(int i1, boolean flag)
    {
        h = b(h + i1);
        invalidate();
        i1 = h;
        n.post(new Runnable(i1, flag) {

            final int a;
            final boolean b;
            final TextLoopView c;

            public void run()
            {
                if (TextLoopView.e(c) != null)
                {
                    TextLoopView.e(c).a(a, b);
                }
            }

            
            {
                c = TextLoopView.this;
                a = i1;
                b = flag;
                super();
            }
        });
    }

    static void b(TextLoopView textloopview, int i1, boolean flag)
    {
        textloopview.b(i1, flag);
    }

    static int c(TextLoopView textloopview)
    {
        return textloopview.i;
    }

    private String c(int i1)
    {
        i1 = b(i1);
        if (i1 != -1)
        {
            return (String)a.get(b(i1));
        } else
        {
            return "";
        }
    }

    static al d(TextLoopView textloopview)
    {
        return textloopview.l;
    }

    static am e(TextLoopView textloopview)
    {
        return textloopview.m;
    }

    public void a(int i1)
    {
        h = b(i1);
        invalidate();
    }

    public List getCategoryList()
    {
        return a;
    }

    public float getDisplayCount()
    {
        return b;
    }

    public int getHighlightColor()
    {
        return d;
    }

    public int getNormalColor()
    {
        return c;
    }

    protected void onDraw(Canvas canvas)
    {
        boolean flag = false;
        if (!isInEditMode() && a != null && a.size() >= 1 && b > 0.0F)
        {
            int k3 = h - i;
            int i3 = (getWidth() - g * f) / 2;
            int l1 = g;
            int k2 = i;
            int i1;
            int j1;
            int k1;
            int i2;
            int j2;
            if (al.a(l))
            {
                int l2 = al.b(l);
                int l3 = com.cyberlink.youcammakeup.widgetpool.common.al.c(l);
                int j3 = l1 + Math.abs(l3);
                k1 = k2;
                l1 = j3;
                i2 = l2;
                j2 = ((flag) ? 1 : 0);
                j1 = i3;
                i1 = k3;
                if (l3 < 0)
                {
                    i1 = k3 + l3;
                    j1 = i3 + f * l3;
                    k1 = k2 - l3;
                    j2 = ((flag) ? 1 : 0);
                    i2 = l2;
                    l1 = j3;
                }
            } else
            {
                i2 = 0;
                k1 = k2;
                j2 = ((flag) ? 1 : 0);
                j1 = i3;
                i1 = k3;
            }
            while (j2 < l1) 
            {
                if (j2 == k1)
                {
                    e.setTextColor(d);
                } else
                {
                    e.setTextColor(c);
                }
                e.setText(c(i1));
                canvas.save();
                canvas.translate(j1 + i2, 0.0F);
                e.draw(canvas);
                canvas.restore();
                j1 += f;
                i1++;
                j2++;
            }
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            f = (int)((float)i1 / b);
            e.measure(android.view.View.MeasureSpec.makeMeasureSpec(f, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000));
            e.layout(0, 0, f, j1);
            return;
        }
    }

    public void setCategoryList(List list)
    {
        a = list;
    }

    public void setDisableLoop(boolean flag)
    {
        j = flag;
    }

    public void setDisplayCount(float f1)
    {
        b = f1;
        if (b <= 0.0F)
        {
            g = -1;
            h = -1;
            i = -1;
            return;
        }
        g = (int)Math.ceil(f1);
        if (g % 2 == 0)
        {
            g = g + 1;
        }
        h = 0;
        i = (int)Math.ceil((float)(g - 1) / 2.0F);
    }

    public void setHighlightColor(int i1)
    {
        d = i1;
    }

    public void setNormalColor(int i1)
    {
        c = i1;
    }

    public void setOnIndexChangeListener(am am)
    {
        m = am;
    }

    public void setTextSize(String s)
    {
        s = aj.a(s);
        aj.a(e, true, s);
    }

    public void setTypeface(Typeface typeface)
    {
        e.setTypeface(typeface);
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/common/TextLoopView$1$1

/* anonymous class */
    class _cls1 extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final _cls1 a;

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
        {
            if (f1 > 0.0F)
            {
                TextLoopView.a(a.b, -1, false);
                return true;
            } else
            {
                TextLoopView.a(a.b, 1, false);
                return true;
            }
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            float f1;
            int i1;
            int j1;
            f1 = motionevent.getX();
            float f2 = motionevent.getY();
            if (0.0F > f2 || f2 > (float)a.b.getHeight())
            {
                break MISSING_BLOCK_LABEL_173;
            }
            j1 = (a.b.getWidth() - TextLoopView.a(a.b) * TextLoopView.b(a.b)) / 2;
            i1 = 0;
_L3:
            if (i1 >= TextLoopView.a(a.b))
            {
                break MISSING_BLOCK_LABEL_173;
            }
            if ((float)j1 > f1 || f1 > (float)(TextLoopView.b(a.b) + j1)) goto _L2; else goto _L1
_L1:
            if (i1 != -1)
            {
                j1 = com.cyberlink.youcammakeup.widgetpool.common.TextLoopView.c(a.b);
                TextLoopView.a(a.b, i1 - j1, true);
            }
            return true;
_L2:
            j1 += TextLoopView.b(a.b);
            i1++;
              goto _L3
            i1 = -1;
              goto _L1
        }

            
            {
                a = _pcls1;
                super();
            }
    }

}

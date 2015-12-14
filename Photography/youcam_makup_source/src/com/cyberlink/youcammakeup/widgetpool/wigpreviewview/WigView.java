// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.wigpreviewview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.wigpreviewview:
//            g, c, a, b

public class WigView extends View
    implements android.view.View.OnTouchListener
{

    public static final int a;
    private RectF b;
    private RectF c;
    private Bitmap d;
    private Bitmap e;
    private List f;
    private g g;
    private ImageViewer h;
    private t i;
    private a j;
    private Animator k;
    private boolean l;

    public WigView(Context context)
    {
        super(context);
        g = null;
        h = null;
        i = null;
        k = null;
        l = false;
        d();
    }

    public WigView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0);
        g = null;
        h = null;
        i = null;
        k = null;
        l = false;
        d();
    }

    public WigView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        g = null;
        h = null;
        i = null;
        k = null;
        l = false;
        d();
    }

    private void a(Canvas canvas)
    {
        canvas.save();
        canvas.clipRect(b);
        canvas.translate(b.left, b.top);
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((g)iterator.next()).a(canvas)) { }
        canvas.restore();
    }

    private void a(MotionEvent motionevent)
    {
        m.b("WigView", "onSingleTapConfirmed");
        float f1 = motionevent.getX();
        float f2 = b.left;
        float f3 = motionevent.getY();
        float f4 = b.top;
        if (g == null)
        {
            e();
            return;
        }
        if (g.f(f1 - f2, f3 - f4))
        {
            g();
            return;
        } else
        {
            a();
            return;
        }
    }

    private void a(t t1, g g1)
    {
        Bitmap bitmap = VenusHelper.a().e();
        if (!aa.b(bitmap))
        {
            m.d("updateRenderer(CurViewInfo, WigRenderer)", "wigBitmap is invalid.");
            return;
        }
        bi bi1 = VenusHelper.a().f();
        if (bi1 == null)
        {
            m.d("updateRenderer(CurViewInfo, WigRenderer)", "transform is null.");
            return;
        } else
        {
            c c1 = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h();
            c1.a(t1, bitmap, bi1);
            t1 = c1.a((float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
            float f1 = ((RectF) (t1)).left;
            float f2 = ((RectF) (t1)).top;
            float f3 = t1.width();
            float f4 = t1.height();
            float f5 = (float)Math.toDegrees(bi1.c());
            g1.a(f1, f2);
            g1.b(f3, f4);
            g1.c(f3, f4);
            g1.a(c1.l() + f5);
            g1.b(f5);
            l = true;
            return;
        }
    }

    static void a(WigView wigview, MotionEvent motionevent)
    {
        wigview.a(motionevent);
    }

    private void b(Canvas canvas, t t1)
    {
        canvas.save();
        canvas.translate((float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
        if (g == null || !g.b())
        {
            canvas.clipRect(t1.g);
        }
        Object obj = VenusHelper.a().a;
        obj;
        JVM INSTR monitorenter ;
        Bitmap bitmap = VenusHelper.a().e();
        if (aa.b(bitmap)) goto _L2; else goto _L1
_L1:
        m.b("renderWig(Canvas)", "wigBitmap is invalid.");
_L3:
        canvas.restore();
        return;
_L2:
        if (aa.b(bitmap))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        m.b("renderWig(Canvas)", "wigBitmap is invalid.");
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        bi bi1 = VenusHelper.a().f();
        if (bi1 != null) goto _L5; else goto _L4
_L4:
        m.b("renderWig(Canvas)", "transform is null.");
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L5:
        c c1 = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h();
        c1.a(t1, bitmap, bi1);
        canvas.translate(c1.a(), c1.b());
        canvas.scale(c1.c(), c1.c());
        canvas.rotate((float)c1.d());
        canvas.drawBitmap(bitmap, null, c1.e(), c1.a);
        obj;
        JVM INSTR monitorexit ;
          goto _L3
    }

    private void d()
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            b = new RectF();
            c = new RectF();
            f = new LinkedList();
            d = aa.a(getResources(), 0x7f020727);
            e = aa.a(getResources(), 0x7f020702);
            j = new a(getResources());
            j.a(new b() {

                final WigView a;

                public void a(MotionEvent motionevent)
                {
                    WigView.a(a, motionevent);
                }

            
            {
                a = WigView.this;
                super();
            }
            });
            setOnTouchListener(this);
            return;
        }
    }

    private void e()
    {
        g = getCurrentTextBubble();
        if (g != null)
        {
            g.a(true);
            invalidate();
        }
    }

    private void f()
    {
        m.b("WigView", "WigView calculateContentPosition");
        if (getWidth() <= 0 || getHeight() <= 0)
        {
            m.e("WigView", "calculateContentPosition() some parameter is <= 0.");
            return;
        } else
        {
            float f1 = ((float)getWidth() * 128F) / 1080F;
            b.set(0.0F, 0.0F, getWidth(), getHeight());
            c.set(a, a, b.width() - (float)a, b.height() - (float)a - f1);
            c.sort();
            invalidate();
            return;
        }
    }

    private void g()
    {
        boolean flag1 = true;
        String s = StatusManager.j().e();
        if (s == null)
        {
            return;
        }
        boolean flag2 = MotionControlHelper.e().o(s);
        Object obj = VenusHelper.a();
        boolean flag;
        if (!flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((VenusHelper) (obj)).a(flag);
        obj = MotionControlHelper.e();
        if (!flag2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((MotionControlHelper) (obj)).c(s, flag);
    }

    private g getCurrentTextBubble()
    {
        int i1 = f.size();
        if (i1 > 0)
        {
            return (g)f.get(i1 - 1);
        } else
        {
            return null;
        }
    }

    public void a()
    {
        if (g != null)
        {
            g.a(false);
            g = null;
            invalidate();
        }
    }

    public void a(Canvas canvas, t t1)
    {
        if (isInEditMode() || t1 == null || t1.g == null)
        {
            return;
        } else
        {
            b(canvas, t1);
            a(canvas);
            return;
        }
    }

    public void a(t t1)
    {
        if (b.width() == 0.0F || b.height() == 0.0F)
        {
            return;
        }
        m.b("WigView", "updateRenderer()");
        g g2 = getCurrentTextBubble();
        g g1 = g2;
        if (g2 == null)
        {
            g1 = new g(d, e);
            f.add(g1);
        }
        synchronized (VenusHelper.a().a)
        {
            a(t1, g1);
        }
        return;
        t1;
        obj;
        JVM INSTR monitorexit ;
        throw t1;
    }

    public void b()
    {
        for (; f.size() > 0; ((g)f.remove(0)).c()) { }
        aa.a(d);
        d = null;
        aa.a(e);
        e = null;
        h = null;
        i = null;
        j.c();
    }

    public void b(t t1)
    {
        i = t1;
        invalidate();
    }

    public void c()
    {
        if (k != null)
        {
            k.cancel();
            k = null;
        }
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            1.0F, 0.0F
        });
        valueanimator.setDuration(200L);
        valueanimator.setInterpolator(new LinearInterpolator());
        class a
            implements android.animation.Animator.AnimatorListener, android.animation.ValueAnimator.AnimatorUpdateListener
        {

            final WigView a;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                a.setAlpha(255F);
                a.setVisibility(4);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                float f1 = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                a.setAlpha((int)(f1 * 255F));
                a.invalidate();
            }

            a()
            {
                a = WigView.this;
                super();
            }
        }

        a a1 = new a();
        valueanimator.addUpdateListener(a1);
        valueanimator.addListener(a1);
        valueanimator.start();
        k = valueanimator;
    }

    public int getTextBubbleRendererCount()
    {
        return f.size();
    }

    public void invalidate()
    {
        if (h != null)
        {
            h.invalidate();
        }
    }

    protected void onDraw(Canvas canvas)
    {
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        m.b("WigView", "WigView onSizeChanged");
        super.onSizeChanged(i1, j1, k1, l1);
        f();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag2 = true;
        m.b("WigView", "WigView onTouch");
        boolean flag;
        boolean flag1;
        if (!aa.b(VenusHelper.a().e()))
        {
            m.d("onTouch", "wigBitmap is invalid.");
            flag = true;
        } else
        if (VenusHelper.a().f() == null)
        {
            m.d("onTouch", "transform is null.");
            flag = true;
        } else
        {
            view = StatusManager.j().e();
            if (view == null || "default_original_wig".equalsIgnoreCase(view))
            {
                m.d("onTouch", "patternGuid is invalid.");
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (!l || flag)
        {
            a();
            flag1 = false;
        } else
        {
            if (g != null)
            {
                g.c(com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().c());
                g.a(this, motionevent, b.left, b.top, c);
            }
            j.a(motionevent);
            flag1 = flag2;
            if (!j.a())
            {
                flag1 = flag2;
                if (g == null)
                {
                    flag1 = flag2;
                    if (h != null)
                    {
                        view = j.b();
                        if (view != null)
                        {
                            m.b("WigView#onTouch", "Pass touch down event.");
                            h.onTouchEvent(view);
                            j.c();
                        }
                        h.onTouchEvent(motionevent);
                        return true;
                    }
                }
            }
        }
        return flag1;
    }

    public void setImageViewer(ImageViewer imageviewer)
    {
        h = imageviewer;
    }

    static 
    {
        int i1 = 30;
        int j1 = Globals.d().getResources().getDimensionPixelSize(0x7f0802c8);
        i1 = j1;
_L2:
        a = i1;
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

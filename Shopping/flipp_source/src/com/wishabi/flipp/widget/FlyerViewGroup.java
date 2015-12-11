// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.a.ag;
import android.support.v4.view.a.aj;
import android.support.v4.view.a.e;
import android.support.v4.view.af;
import android.support.v4.view.ap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.wishabi.flipp.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            dw, bv, bo, bn, 
//            bp, bq, br, bt, 
//            bs, bi

public class FlyerViewGroup extends ViewGroup
{

    public final dw a;
    public final bo b;
    public final bv c;
    public final bn d;
    public int e;
    public int f;
    private final List g;
    private final View h;
    private final bp i;
    private bt j;
    private float k;
    private float l;
    private float m;
    private SavedState n;
    private final ScaleGestureDetector o;
    private final GestureDetector p;
    private final OverScroller q;
    private boolean r;
    private RectF s;

    public FlyerViewGroup(Context context)
    {
        this(context, null);
    }

    public FlyerViewGroup(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FlyerViewGroup(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        g = new ArrayList();
        k = 1.0F;
        l = 1.0F;
        m = 1.0F;
        ap.c(this, 1);
        setWillNotDraw(false);
        h = new View(context);
        h.setBackgroundResource(0x7f020072);
        addView(h);
        a = new dw(context);
        addView(a);
        c = new bv(context);
        addView(c);
        b = new bo(context);
        addView(b);
        d = new bn(context);
        addView(d);
        i = new bp(context);
        addView(i);
        o = new ScaleGestureDetector(context, new bq(this));
        af.a(o);
        p = new GestureDetector(context, new br(this));
        q = new OverScroller(context);
        q.setFriction(0.03F);
    }

    static float a(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.k;
    }

    static void a(FlyerViewGroup flyerviewgroup, int i1, int j1)
    {
        float f1 = flyerviewgroup.k;
        flyerviewgroup.q.forceFinished(true);
        flyerviewgroup.q.fling((int)((float)flyerviewgroup.getScrollX() * f1), (int)((float)flyerviewgroup.getScrollY() * f1), i1, j1, 0, (int)((float)flyerviewgroup.e * f1 - (float)flyerviewgroup.getWidth()), 0, (int)(f1 * (float)flyerviewgroup.f - (float)flyerviewgroup.getHeight()), flyerviewgroup.getWidth() / 4, flyerviewgroup.getHeight() / 2);
        ap.d(flyerviewgroup);
    }

    static dw b(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.a;
    }

    private void b()
    {
        int i2 = (int)Math.max(0.0F, (float)getWidth() - (float)e * k) / 2;
        int i1 = getScrollX();
        int j1 = i1 + i2;
        int k1 = getScrollY();
        int l1 = getWidth();
        i2 = (getWidth() + i1) - i2;
        int j2 = getHeight() + k1;
        h.layout(0, 0, e, f);
        a.layout(j1, k1, i2, j2);
        b.layout(j1, k1, i2, j2);
        c.layout(j1, k1, i2, j2);
        d.layout(j1, k1, i2, j2);
        i.layout(i1, k1, l1 + i1, j2);
    }

    static int c(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.e;
    }

    static int d(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.f;
    }

    static bt e(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.j;
    }

    static bp f(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.i;
    }

    static OverScroller g(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.q;
    }

    static bn h(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.d;
    }

    static List i(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.g;
    }

    static float j(FlyerViewGroup flyerviewgroup)
    {
        return flyerviewgroup.l;
    }

    static boolean k(FlyerViewGroup flyerviewgroup)
    {
        flyerviewgroup.r = true;
        return true;
    }

    public final void a()
    {
        bn bn1 = d;
        bn1.f = true;
        bn1.invalidate();
    }

    public final void a(long l1, RectF rectf)
    {
        bo bo1 = b;
        Object obj = bo1.getResources();
        if (obj != null)
        {
            obj = ((Resources) (obj)).getDrawable(0x7f020006);
            if (obj != null)
            {
                ((Drawable) (obj)).setBounds((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
                bo1.c.put(Long.valueOf(l1), obj);
                bo1.invalidate();
            }
        }
    }

    public final void a(RectF rectf)
    {
        float f1;
        RectF rectf1;
        RectF rectf2;
        rectf1 = new RectF(getScrollX(), getScrollY(), (float)getScrollX() + (float)getWidth() / l, (float)getScrollY() + (float)getHeight() / l);
        f1 = Math.max(rectf.width() * l, rectf1.width());
        rectf2 = new RectF();
        rectf2.top = 0.0F;
        rectf2.bottom = rectf1.height();
        rectf2.left = rectf.left;
        rectf2.right = rectf.right;
        if (rectf.right <= rectf1.right) goto _L2; else goto _L1
_L1:
        rectf2.right = rectf2.left + f1;
_L4:
        a(rectf2, true, true);
        return;
_L2:
        if (rectf.left < rectf1.left)
        {
            rectf2.left = rectf2.right - f1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(RectF rectf, boolean flag, boolean flag1)
    {
        if (rectf.width() != 0.0F && rectf.height() != 0.0F) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f1 = Math.max(Math.min(Math.min((float)getWidth() / rectf.width(), (float)getHeight() / rectf.height()), m), l);
        float f2 = (float)getWidth() / f1;
        float f3 = (float)getHeight() / f1;
        if (flag1)
        {
            rectf.left = rectf.centerX() - f2 / 2.0F;
            rectf.top = rectf.centerY() - f3 / 2.0F;
            rectf.right = rectf.centerX() + f2 / 2.0F;
            rectf.bottom = rectf.centerY() + f3 / 2.0F;
        }
        int i1 = (int)Math.max(e, f2);
        if (rectf.left < 0.0F)
        {
            rectf.offset(0.0F - rectf.left, 0.0F);
        } else
        if (rectf.right > (float)i1)
        {
            rectf.offset((float)i1 - rectf.right, 0.0F);
        }
        do
        {
label0:
            {
                i1 = (int)Math.max(f, f3);
                if (rectf.top < 0.0F)
                {
                    rectf.offset(0.0F, 0.0F - rectf.top);
                } else
                if (rectf.bottom > (float)i1)
                {
                    rectf.offset(0.0F, (float)i1 - rectf.bottom);
                }
                q.forceFinished(true);
                if (flag)
                {
                    break label0;
                }
                scrollTo((int)rectf.left, (int)rectf.top);
                setZoomScale(f1);
                if (j != null)
                {
                    j.a(this);
                    return;
                }
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
            ValueAnimator valueanimator = ValueAnimator.ofObject(new a(), new Object[] {
                getVisibleRect(), rectf
            });
            valueanimator.setDuration(400L);
            valueanimator.addUpdateListener(new bs(this, rectf, f1));
            a.setZooming(true);
            valueanimator.start();
            return;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected int computeHorizontalScrollExtent()
    {
        return (int)((float)getWidth() / k);
    }

    protected int computeHorizontalScrollOffset()
    {
        return getScrollX();
    }

    protected int computeHorizontalScrollRange()
    {
        return e;
    }

    public void computeScroll()
    {
        super.computeScroll();
        if (q.computeScrollOffset())
        {
            float f1 = k;
            int i1 = (int)((float)q.getCurrX() / f1);
            int j1 = (int)((float)q.getCurrY() / f1);
            if (i1 < 0)
            {
                bp bp1 = i;
                int k1 = (int)q.getCurrVelocity();
                if (bp1.a.isFinished() && !bp1.e)
                {
                    bp1.a.onAbsorb(k1);
                    bp1.e = true;
                    bp1.invalidate();
                }
            }
            if ((float)i1 > (float)e - (float)getWidth() / k)
            {
                bp bp2 = i;
                int l1 = (int)q.getCurrVelocity();
                if (bp2.b.isFinished() && !bp2.f)
                {
                    bp2.b.onAbsorb(l1);
                    bp2.f = true;
                    bp2.invalidate();
                }
            }
            if (j1 < 0 && k > l)
            {
                bp bp3 = i;
                int i2 = (int)q.getCurrVelocity();
                if (bp3.c.isFinished() && !bp3.g)
                {
                    bp3.c.onAbsorb(i2);
                    bp3.g = true;
                    bp3.invalidate();
                }
            }
            if ((float)j1 > (float)f - (float)getHeight() / k && k > l)
            {
                bp bp4 = i;
                int j2 = (int)q.getCurrVelocity();
                if (bp4.d.isFinished() && !bp4.h)
                {
                    bp4.d.onAbsorb(j2);
                    bp4.h = true;
                    bp4.invalidate();
                }
            }
            scrollTo((int)Math.max(0.0F, Math.min(i1, (float)e - (float)getWidth() / k)), (int)Math.max(0.0F, Math.min(j1, (float)f - (float)getHeight() / k)));
            if (j != null)
            {
                j.a(this);
            }
            if (!awakenScrollBars())
            {
                ap.d(this);
            }
        }
    }

    protected int computeVerticalScrollExtent()
    {
        return (int)((float)getHeight() / k);
    }

    protected int computeVerticalScrollOffset()
    {
        return getScrollY();
    }

    protected int computeVerticalScrollRange()
    {
        return f;
    }

    public List getHighlightAnnotations()
    {
        return c.getHighlightAnnotations();
    }

    public float getMinZoomScale()
    {
        return l;
    }

    public List getVisibleHighlightAnnotations()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = c.getHighlightAnnotations();
        if (obj == null)
        {
            return arraylist;
        }
        RectF rectf = getVisibleRect();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            bi bi1 = (bi)((Iterator) (obj)).next();
            if (bi1.a.right >= rectf.left && bi1.a.left <= rectf.right)
            {
                arraylist.add(bi1);
            }
        } while (true);
        return arraylist;
    }

    public RectF getVisibleRect()
    {
        if (k == 0.0F)
        {
            return new RectF();
        } else
        {
            return new RectF(getScrollX(), getScrollY(), (float)getScrollX() + (float)getWidth() / k, (float)getScrollY() + (float)getHeight() / k);
        }
    }

    public float getZoomScale()
    {
        return k;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
        String s1 = com/wishabi/flipp/widget/FlyerViewGroup.getName();
        ag.a.a(((ag) (accessibilityevent)).b, s1);
        accessibilityevent.a(true);
        int i1 = getScrollX();
        ag.a.d(((ag) (accessibilityevent)).b, i1);
        i1 = getScrollY();
        ag.a.c(((ag) (accessibilityevent)).b, i1);
        i1 = computeHorizontalScrollRange();
        int j1 = computeHorizontalScrollExtent();
        ag.a.g(((ag) (accessibilityevent)).b, i1 - j1);
        i1 = computeVerticalScrollRange();
        j1 = computeVerticalScrollExtent();
        ag.a.f(((ag) (accessibilityevent)).b, i1 - j1);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo = new e(accessibilitynodeinfo);
        accessibilitynodeinfo.a(com/wishabi/flipp/widget/FlyerViewGroup.getName());
        accessibilitynodeinfo.a(true);
        accessibilitynodeinfo.a(8192);
        accessibilitynodeinfo.a(4096);
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        b();
        if (n != null)
        {
            i1 = n.a;
            j1 = (n.b - i1) / 2;
            setZoomScale(l);
            scrollTo((int)Math.max(0.0D, Math.min((double)(i1 + j1) - (0.5D * (double)getWidth()) / (double)k, (float)e - (float)getWidth() / k)), 0);
            if (j != null)
            {
                j.a(this);
            }
            n = null;
        } else
        if (s != null)
        {
            RectF rectf = new RectF(s);
            rectf.inset(-rectf.width() * 0.05F, -rectf.height() * 0.05F);
            s = null;
            a(rectf, false, true);
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        n = parcelable;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), getScrollX(), getScrollX() + (int)((float)getWidth() / getZoomScale() / 2.0F));
    }

    protected void onScrollChanged(int i1, int j1, int k1, int l1)
    {
        super.onScrollChanged(i1, j1, k1, l1);
        Object obj = a;
        float f1 = i1;
        float f2 = j1;
        obj.a = f1;
        obj.b = f2;
        ((dw) (obj)).invalidate();
        obj = b;
        obj.a = f1;
        obj.b = f2;
        ((bo) (obj)).invalidate();
        obj = c;
        obj.c = f1;
        obj.d = f2;
        ((bv) (obj)).invalidate();
        obj = d;
        obj.a = f1;
        obj.b = f2;
        ((bn) (obj)).invalidate();
        b();
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        float f1 = 1.0F;
        Resources resources = getResources();
        if (resources != null)
        {
            f1 = resources.getDisplayMetrics().density;
        }
        l = (float)j1 / (float)f;
        m = f1;
        setZoomScale(l);
        scrollTo((int)Math.max(0.0F, Math.min(getScrollX(), (float)e - (float)getWidth() / k)), (int)Math.max(0.0F, Math.min(getScrollY(), (float)f - (float)getHeight() / k)));
        if (j != null)
        {
            j.a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = false;
        boolean flag2 = o.onTouchEvent(motionevent);
        boolean flag;
        if (p.onTouchEvent(motionevent) || flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (motionevent.getAction() == 1 && r)
        {
            j.a();
        }
        if (flag || super.onTouchEvent(motionevent))
        {
            flag1 = true;
        }
        return flag1;
    }

    public void setFlyerViewListener(bt bt1)
    {
        j = bt1;
    }

    public void setHighlightAnnotations(List list)
    {
        c.setHighlightAnnotations(list);
    }

    public void setInitialRect(RectF rectf)
    {
        s = new RectF(rectf);
    }

    public void setTapAnnotations(List list)
    {
        g.clear();
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                bi bi1 = (bi)list.next();
                g.add(bi1);
            }
        }
    }

    public void setZoomScale(float f1)
    {
        k = Math.max(l, Math.min(f1, m));
        a.setZoomScale(k);
        b.setZoomScale(k);
        c.setZoomScale(k);
        d.setZoomScale(k);
        b();
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new bu();
        final int a;
        final int b;

        public String toString()
        {
            return (new StringBuilder("FlyerViewGroup.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" mLeft =").append(a).append(" mRight =").append(b).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            parcel.writeInt(b);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
            b = parcel.readInt();
        }

        SavedState(Parcelable parcelable, int i1, int j1)
        {
            super(parcelable);
            a = i1;
            b = j1;
        }
    }

}

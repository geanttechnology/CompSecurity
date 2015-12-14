// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.ae;
import com.pf.common.utility.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            b, w, m, n, 
//            o

public class CollageLayout extends ViewGroup
    implements ae
{

    private static String j = "CollageLayout";
    int a;
    int b;
    int c;
    int d;
    double e;
    int f;
    int g;
    int h;
    int i;
    private Bitmap k;
    private Bitmap l;
    private Bitmap m;
    private Bitmap n;
    private Drawable o;
    private Rect p;
    private HashMap q;
    private w r;
    private o s;
    private Paint t;
    private b u;
    private Map v;
    private Map w;
    private Map x;
    private int y;
    private BlockingQueue z;

    public CollageLayout(Context context)
    {
        super(context);
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = new Rect();
        q = null;
        s = null;
        t = new Paint();
        v = new HashMap();
        w = new HashMap();
        x = new HashMap();
        y = 0;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 1.0D;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        a(context);
    }

    public CollageLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = new Rect();
        q = null;
        s = null;
        t = new Paint();
        v = new HashMap();
        w = new HashMap();
        x = new HashMap();
        y = 0;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 1.0D;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        a(context);
    }

    private void a(Context context)
    {
        setBackgroundColor(0);
        setChildrenDrawingOrderEnabled(true);
        if (isInEditMode())
        {
            return;
        } else
        {
            u = new b();
            r = new w(context, this);
            r.a(u);
            z = new LinkedBlockingQueue();
            return;
        }
    }

    private boolean a(int i1, int j1)
    {
        if (n != null)
        {
            i1 -= h;
            j1 -= i;
            int k1 = n.getWidth();
            int l1 = n.getHeight();
            if (i1 >= 0 && j1 >= 0 && i1 < k1 && j1 < l1 && n.getPixel(i1, j1) >>> 24 != 255)
            {
                return true;
            }
        }
        return false;
    }

    private boolean a(int i1, int j1, int k1)
    {
        Object obj = (com.cyberlink.youcammakeup.kernelctrl.collageComposer.m)x.get(Integer.valueOf(i1));
        if (obj == null)
        {
            return true;
        }
        obj = (Bitmap)w.get(((com.cyberlink.youcammakeup.kernelctrl.collageComposer.m) (obj)).a);
        i1 = ((Bitmap) (obj)).getWidth();
        int l1 = ((Bitmap) (obj)).getHeight();
        if (j1 < 0 || k1 < 0 || j1 >= i1 || k1 >= l1)
        {
            return false;
        }
        boolean flag;
        if (((Bitmap) (obj)).getPixel(j1, k1) >>> 24 == 255)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private void g()
    {
        y = 0;
        StatusManager.j().a(this);
        if (!z.isEmpty())
        {
            z.clear();
        }
    }

    Bitmap a(String s1)
    {
        return (Bitmap)v.get(s1);
    }

    View a(MotionEvent motionevent)
    {
        com.pf.common.utility.m.e(j, String.format("getViewFromPoint, x = %d, y = %d", new Object[] {
            Integer.valueOf((int)motionevent.getX()), Integer.valueOf((int)motionevent.getY())
        }));
        View view = null;
        int i1 = -1;
        int j1 = 0;
        while (j1 < getChildCount()) 
        {
            View view1 = getChildAt(j1);
            if (view1 instanceof PanZoomViewer)
            {
                n n1 = (n)view1.getLayoutParams();
                MotionEvent motionevent1 = MotionEvent.obtain(motionevent);
                motionevent1.offsetLocation(getScrollX() - view1.getLeft(), getScrollY() - view1.getTop());
                int k1 = (int)motionevent.getX();
                int l1 = (int)motionevent.getY();
                int i2 = (int)motionevent1.getX();
                int j2 = (int)motionevent1.getY();
                boolean flag = n1.a(motionevent1);
                motionevent1.recycle();
                if (flag)
                {
                    if (n != null && r != null)
                    {
                        if (a(k1, l1) && a(view1.hashCode(), i2, j2) && n1.c > i1)
                        {
                            i1 = n1.c;
                            view = view1;
                        }
                    } else
                    if (a(view1.hashCode(), i2, j2) && n1.c > i1)
                    {
                        i1 = n1.c;
                        view = view1;
                    }
                }
            }
            j1++;
        }
        return view;
    }

    com.cyberlink.youcammakeup.kernelctrl.collageComposer.m a(Integer integer)
    {
        return (com.cyberlink.youcammakeup.kernelctrl.collageComposer.m)x.get(integer);
    }

    public void a()
    {
        if (r == null)
        {
            return;
        }
        r.b();
        r = null;
        if (k != null)
        {
            k.recycle();
        }
        if (l != null)
        {
            l.recycle();
        }
        if (m != null)
        {
            m.recycle();
        }
        if (n != null)
        {
            n.recycle();
        }
        c();
        b();
        d();
    }

    public void a(o o1, boolean flag)
    {
        if (o1 != null)
        {
            long l1 = Runtime.getRuntime().totalMemory();
            com.pf.common.utility.m.e(j, (new StringBuilder()).append("totalMemory:").append(l1).toString());
            l1 = Runtime.getRuntime().totalMemory();
            long l2 = Runtime.getRuntime().freeMemory();
            com.pf.common.utility.m.e(j, (new StringBuilder()).append("totalMemory (in-used):").append(l1 - l2).toString());
            com.pf.common.utility.m.e(j, (new StringBuilder()).append("nativeHeapAllocatedSize:").append(Debug.getNativeHeapAllocatedSize()).toString());
            com.pf.common.utility.m.e(j, (new StringBuilder()).append("nativeHeapSize:").append(Debug.getNativeHeapSize()).toString());
            s = o1;
            r.a(s);
            r.a();
            if (flag)
            {
                g();
                requestLayout();
            }
        }
    }

    void a(Integer integer, com.cyberlink.youcammakeup.kernelctrl.collageComposer.m m1)
    {
        x.put(integer, m1);
    }

    void a(String s1, Bitmap bitmap)
    {
        v.put(s1, bitmap);
    }

    Bitmap b(String s1)
    {
        return (Bitmap)w.get(s1);
    }

    void b()
    {
        x.clear();
    }

    void c()
    {
        String s1;
        for (Iterator iterator = v.keySet().iterator(); iterator.hasNext(); ((Bitmap)v.get(s1)).recycle())
        {
            s1 = (String)iterator.next();
        }

        v.clear();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof n;
    }

    void d()
    {
        String s1;
        for (Iterator iterator = w.keySet().iterator(); iterator.hasNext(); ((Bitmap)w.get(s1)).recycle())
        {
            s1 = (String)iterator.next();
        }

        w.clear();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        com.pf.common.utility.m.e(j, "dispatchDraw");
        com.pf.common.utility.m.e(j, String.format("dispatchDraw, canvas.getWidth() = %d, canvas.getHeight() = %d", new Object[] {
            Integer.valueOf(canvas.getWidth()), Integer.valueOf(canvas.getHeight())
        }));
        com.pf.common.utility.m.e(j, String.format("dispatchDraw, getMeasuredWidth() = %d, getMeasuredHeight() = %d", new Object[] {
            Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight())
        }));
        com.pf.common.utility.m.e(j, String.format("dispatchDraw, getWidth() = %d, getHeight() = %d", new Object[] {
            Integer.valueOf(getWidth()), Integer.valueOf(getHeight())
        }));
        com.pf.common.utility.m.e(j, String.format("dispatchDraw, getPaddingLeft() = %d, getPaddingRight() = %d", new Object[] {
            Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight())
        }));
        com.pf.common.utility.m.e(j, String.format("dispatchDraw, getLeft() = %d, getRight() = %d", new Object[] {
            Integer.valueOf(getLeft()), Integer.valueOf(getRight())
        }));
        com.pf.common.utility.m.e(j, String.format("dispatchDraw, getTop() = %d, getBottom() = %d", new Object[] {
            Integer.valueOf(getTop()), Integer.valueOf(getBottom())
        }));
        if (s != null && r != null)
        {
            if (o != null)
            {
                r.a(s, h, i, f, g, e);
            } else
            {
                r.a(s, c, d, a, b, e);
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    public void e()
    {
        r.a(s, 1, 1, 1.0D);
        r.a(s, 0, 0, 1, 1, 1.0D);
    }

    public void f()
    {
        if (StatusManager.j().m() == null)
        {
            z.add(new Object());
        } else
        {
            int i1 = StatusManager.j().m().size();
            y = y + 1;
            if (y == i1)
            {
                StatusManager.j().b(this);
                z.add(new Object());
                return;
            }
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new n(-2, -2, 0, 0, 0);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new n(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new n(layoutparams);
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        com.pf.common.utility.m.e(j, String.format("getChildDrawingOrder, childCount = %d, i = %d", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1)
        }));
        return ((n)(n)getChildAt(j1).getLayoutParams()).c;
    }

    Bitmap getCoverImage()
    {
        return k;
    }

    public HashMap getFaceRectMap()
    {
        return q;
    }

    Bitmap getGlobalMask()
    {
        return l;
    }

    int getImageMaskCount()
    {
        return v.size();
    }

    Bitmap getResizedCoverImage()
    {
        return m;
    }

    Bitmap getResizedGlobalMask()
    {
        return n;
    }

    public o getTemplate()
    {
        return s;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (s != null)
        {
            o.setBounds(c, d, a + c, b + d);
            o.draw(canvas);
            t.setColor(s.h);
            canvas.drawRect(h, i, h + f, i + g, t);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        com.pf.common.utility.m.e(j, String.format((new StringBuilder()).append("onLayout, changed ").append(flag).append(", l = %d, t = %d, r = %d, b = %d").toString(), new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1)
        }));
        if (r != null && s != null)
        {
            com.pf.common.utility.m.e(j, String.format("onLayout, getMeasuredWidth() = %d, getMeasuredHeight() = %d", new Object[] {
                Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight())
            }));
            com.pf.common.utility.m.e(j, String.format("onLayout, getWidth() = %d, getHeight() = %d", new Object[] {
                Integer.valueOf(getWidth()), Integer.valueOf(getHeight())
            }));
            com.pf.common.utility.m.e(j, String.format("onLayout, getPaddingLeft() = %d, getPaddingRight() = %d", new Object[] {
                Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight())
            }));
            com.pf.common.utility.m.e(j, String.format("onLayout, getLeft() = %d, getRight() = %d", new Object[] {
                Integer.valueOf(getLeft()), Integer.valueOf(getRight())
            }));
            com.pf.common.utility.m.e(j, String.format("onLayout, getTop() = %d, getBottom() = %d", new Object[] {
                Integer.valueOf(getTop()), Integer.valueOf(getBottom())
            }));
            l1 = getWidth();
            k1 = getHeight();
            j1 = k1;
            i1 = l1;
            if (o != null)
            {
                i1 = l1 - (p.left + p.right);
                j1 = k1 - (p.top + p.bottom);
            }
            e = Math.min((double)i1 / (double)s.i, (double)j1 / (double)s.j);
            e = Math.min(e, 1.0D);
            a = (int)((double)s.i * e);
            b = (int)((double)s.j * e);
            if (o != null)
            {
                a = a + (p.left + p.right);
                b = b + (p.top + p.bottom);
                a = Math.min(a, getWidth());
                b = Math.min(b, getHeight());
            }
            c = (getWidth() - a) / 2;
            d = (getHeight() - b) / 2;
            h = c + p.left;
            i = d + p.top;
            f = a - (p.left + p.right);
            g = b - (p.top + p.bottom);
            r.a(s, f, g, e);
        }
        j1 = getChildCount();
        for (i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (view.getVisibility() != 8)
            {
                n n1 = (n)view.getLayoutParams();
                k1 = getPaddingLeft() + n1.a;
                l1 = getPaddingTop();
                l1 = n1.b + l1;
                view.layout(k1, l1, view.getMeasuredWidth() + k1, view.getMeasuredHeight() + l1);
            }
        }

    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        measureChildren(i1, j1);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        com.pf.common.utility.m.e(j, String.format("onSizeChanged", new Object[0]));
        if (r != null)
        {
            r.a();
        }
    }

    public void requestLayout()
    {
        com.pf.common.utility.m.e(j, "requestLayout");
        super.requestLayout();
    }

    public void setBorderDrawable(Drawable drawable)
    {
        o = drawable;
        o.getPadding(p);
        com.pf.common.utility.m.e(j, (new StringBuilder()).append("setBorderDrawable, mBorderDrawablePadding = ").append(p).toString());
        r.a();
        requestLayout();
    }

    void setCoverImage(Bitmap bitmap)
    {
        k = bitmap;
    }

    public void setFaceRectMap(HashMap hashmap)
    {
        q = hashmap;
    }

    void setGlobalMask(Bitmap bitmap)
    {
        l = bitmap;
    }

    void setResizedCoverImage(Bitmap bitmap)
    {
        m = bitmap;
    }

    void setResizedGlobalMask(Bitmap bitmap)
    {
        n = bitmap;
    }

    public void setTemplate(o o1)
    {
        a(o1, true);
    }

    public void setThumbnailView(ImageView imageview)
    {
        r.a(imageview);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

}

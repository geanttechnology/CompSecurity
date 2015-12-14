// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.huewu.pla.a.b;
import com.huewu.pla.a.c;
import com.huewu.pla.lib.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AdapterView, g, k, c, 
//            d, f, b, i, 
//            a, e, n, l, 
//            h

public abstract class PLA_AbsListView extends PLA_AdapterView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnTouchModeChangeListener
{

    boolean A;
    boolean B;
    int C;
    final boolean D[];
    private VelocityTracker a;
    private i ad;
    private d ae;
    private boolean af;
    private Rect ag;
    private android.view.ContextMenu.ContextMenuInfo ah;
    private int ai;
    private boolean aj;
    private boolean ak;
    private Runnable al;
    private e am;
    private int an;
    private int ao;
    private boolean ap;
    private int aq;
    private int ar;
    private Runnable as;
    private int at;
    private int au;
    private int av;
    private com.huewu.pla.lib.internal.b b;
    int c;
    l d;
    protected ListAdapter e;
    boolean f;
    Drawable g;
    Rect h;
    final g i;
    int j;
    int k;
    int l;
    int m;
    protected Rect n;
    protected int o;
    protected boolean p;
    protected int q;
    int r;
    int s;
    int t;
    int u;
    protected int v;
    int w;
    int x;
    f y;
    int z;

    public PLA_AbsListView(Context context)
    {
        super(context);
        c = 0;
        f = false;
        h = new Rect();
        i = new g(this);
        j = 0;
        k = 0;
        l = 0;
        m = 0;
        n = new Rect();
        o = 0;
        v = -1;
        z = 0;
        af = true;
        C = -1;
        ah = null;
        ai = -1;
        aj = false;
        ak = false;
        aq = 0;
        D = new boolean[1];
        av = -1;
        n();
        setVerticalScrollBarEnabled(true);
        context = context.obtainStyledAttributes(c.PLA_View);
        try
        {
            android/view/View.getDeclaredMethod("initializeScrollbars", new Class[] {
                android/content/res/TypedArray
            }).invoke(this, new Object[] {
                context
            });
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            nosuchmethodexception.printStackTrace();
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            invocationtargetexception.printStackTrace();
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
        }
        context.recycle();
    }

    public PLA_AbsListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, b.PLA_absListViewStyle);
    }

    public PLA_AbsListView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        c = 0;
        f = false;
        h = new Rect();
        i = new g(this);
        j = 0;
        k = 0;
        l = 0;
        m = 0;
        n = new Rect();
        o = 0;
        v = -1;
        z = 0;
        af = true;
        C = -1;
        ah = null;
        ai = -1;
        aj = false;
        ak = false;
        aq = 0;
        D = new boolean[1];
        av = -1;
        n();
        context = context.obtainStyledAttributes(attributeset, c.PLA_AbsListView, i1, 0);
        attributeset = context.getDrawable(c.PLA_AbsListView_PLA_listSelector);
        if (attributeset != null)
        {
            setSelector(attributeset);
        }
        f = context.getBoolean(c.PLA_AbsListView_PLA_drawSelectorOnTop, false);
        setStackFromBottom(context.getBoolean(c.PLA_AbsListView_PLA_stackFromBottom, false));
        setScrollingCacheEnabled(context.getBoolean(c.PLA_AbsListView_PLA_scrollingCache, true));
        setTranscriptMode(context.getInt(c.PLA_AbsListView_PLA_transcriptMode, 0));
        setCacheColorHint(context.getColor(c.PLA_AbsListView_PLA_cacheColorHint, 0));
        setSmoothScrollbarEnabled(context.getBoolean(c.PLA_AbsListView_PLA_smoothScrollbar, true));
        context.recycle();
    }

    static int a(Rect rect, Rect rect1, int i1)
    {
        i1;
        JVM INSTR lookupswitch 4: default 44
    //                   17: 150
    //                   33: 189
    //                   66: 55
    //                   130: 109;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L4:
        int j1;
        int k1;
        int l1;
        l1 = rect.right;
        k1 = rect.top + rect.height() / 2;
        j1 = rect1.left;
        i1 = rect1.top + rect1.height() / 2;
_L7:
        j1 -= l1;
        i1 -= k1;
        return i1 * i1 + j1 * j1;
_L5:
        l1 = rect.left + rect.width() / 2;
        k1 = rect.bottom;
        i1 = rect1.left;
        j1 = rect1.width() / 2 + i1;
        i1 = rect1.top;
        continue; /* Loop/switch isn't completed */
_L2:
        l1 = rect.left;
        k1 = rect.top + rect.height() / 2;
        j1 = rect1.right;
        i1 = rect1.top + rect1.height() / 2;
        continue; /* Loop/switch isn't completed */
_L3:
        l1 = rect.left + rect.width() / 2;
        k1 = rect.top;
        i1 = rect1.left;
        j1 = rect1.width() / 2 + i1;
        i1 = rect1.bottom;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static int a(PLA_AbsListView pla_abslistview)
    {
        return pla_abslistview.getWindowAttachCount();
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        h.set(i1 - j, j1 - k, l + k1, m + l1);
    }

    private void a(Canvas canvas)
    {
        if (f() && h != null && !h.isEmpty())
        {
            Drawable drawable = g;
            drawable.setBounds(h);
            drawable.draw(canvas);
        }
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = (motionevent.getAction() & 0xff00) >> 8;
        if (motionevent.getPointerId(i1) == av)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            t = (int)motionevent.getX(i1);
            u = (int)motionevent.getY(i1);
            av = motionevent.getPointerId(i1);
            if (a != null)
            {
                a.clear();
            }
        }
    }

    static void a(PLA_AbsListView pla_abslistview, View view)
    {
        pla_abslistview.c(view);
    }

    static void a(PLA_AbsListView pla_abslistview, View view, boolean flag)
    {
        pla_abslistview.removeDetachedView(view, flag);
    }

    static void a(PLA_AbsListView pla_abslistview, boolean flag)
    {
        pla_abslistview.setChildrenDrawnWithCacheEnabled(flag);
    }

    private boolean a(int i1)
    {
        if (Math.abs(i1) > ar)
        {
            p();
            v = 3;
            x = i1;
            setPressed(false);
            View view = getChildAt(q - E);
            if (view != null)
            {
                view.setPressed(false);
            }
            g(1);
            requestDisallowInterceptTouchEvent(true);
            return true;
        } else
        {
            return false;
        }
    }

    static int b(PLA_AbsListView pla_abslistview)
    {
        return pla_abslistview.getWindowAttachCount();
    }

    static void b(PLA_AbsListView pla_abslistview, View view, boolean flag)
    {
        pla_abslistview.removeDetachedView(view, flag);
    }

    static void b(PLA_AbsListView pla_abslistview, boolean flag)
    {
        pla_abslistview.setChildrenDrawingCacheEnabled(flag);
    }

    private void c(View view)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        view.onFinishTemporaryDetach();
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int j1 = view.getChildCount();
            int i1 = 0;
            while (i1 < j1) 
            {
                c(view.getChildAt(i1));
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    static void c(PLA_AbsListView pla_abslistview)
    {
        pla_abslistview.q();
    }

    static void c(PLA_AbsListView pla_abslistview, View view, boolean flag)
    {
        pla_abslistview.removeDetachedView(view, flag);
    }

    static void d(PLA_AbsListView pla_abslistview, View view, boolean flag)
    {
        pla_abslistview.removeDetachedView(view, flag);
    }

    static void e(PLA_AbsListView pla_abslistview, View view, boolean flag)
    {
        pla_abslistview.removeDetachedView(view, flag);
    }

    private void n()
    {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        ar = viewconfiguration.getScaledTouchSlop();
        at = viewconfiguration.getScaledMinimumFlingVelocity();
        au = viewconfiguration.getScaledMaximumFlingVelocity();
    }

    private void o()
    {
        setSelector(getResources().getDrawable(0x1080062));
    }

    private void p()
    {
        if (B && !p)
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            p = true;
        }
    }

    private void q()
    {
        if (as == null)
        {
            as = new Runnable() {

                final PLA_AbsListView a;

                public void run()
                {
                    if (a.p)
                    {
                        a.p = false;
                        com.huewu.pla.lib.internal.PLA_AbsListView.a(a, false);
                        if ((a.getPersistentDrawingCache() & 2) == 0)
                        {
                            com.huewu.pla.lib.internal.PLA_AbsListView.b(a, false);
                        }
                        if (!a.isAlwaysDrawnWithCacheEnabled())
                        {
                            a.invalidate();
                        }
                    }
                }

            
            {
                a = PLA_AbsListView.this;
                super();
            }
            };
        }
        post(as);
    }

    public int a(int i1, int j1)
    {
        Rect rect1 = ag;
        Rect rect = rect1;
        if (rect1 == null)
        {
            ag = new Rect();
            rect = ag;
        }
        for (int k1 = getChildCount() - 1; k1 >= 0; k1--)
        {
            View view = getChildAt(k1);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            view.getHitRect(rect);
            if (rect.contains(i1, j1))
            {
                return E + k1;
            }
        }

        return -1;
    }

    android.view.ContextMenu.ContextMenuInfo a(View view, int i1, long l1)
    {
        return new k(view, i1, l1);
    }

    View a(int i1, boolean aflag[])
    {
        View view2;
        aflag[0] = false;
        view2 = i.d(i1);
        if (view2 == null) goto _L2; else goto _L1
_L1:
        View view = e.getView(i1, view2, this);
        if (view == view2) goto _L4; else goto _L3
_L3:
        com.huewu.pla.lib.a.b("obtainView");
        i.a(view2);
        aflag = view;
        if (ao != 0)
        {
            view.setDrawingCacheBackgroundColor(ao);
            aflag = view;
        }
_L6:
        return aflag;
_L4:
        aflag[0] = true;
        c(view);
        return view;
_L2:
        com.huewu.pla.lib.a.b((new StringBuilder()).append("makeView:").append(i1).toString());
        View view1 = e.getView(i1, null, this);
        aflag = view1;
        if (ao != 0)
        {
            view1.setDrawingCacheBackgroundColor(ao);
            return view1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public com.huewu.pla.lib.internal.c a(AttributeSet attributeset)
    {
        return new com.huewu.pla.lib.internal.c(getContext(), attributeset);
    }

    void a()
    {
        if (ae != null)
        {
            ae.a(this, E, getChildCount(), V);
        }
    }

    void a(View view)
    {
        Rect rect = h;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        a(rect.left, rect.top, rect.right, rect.bottom);
        boolean flag = ap;
        if (view.isEnabled() != flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ap = flag;
            refreshDrawableState();
        }
    }

    public void addTouchables(ArrayList arraylist)
    {
        int j1 = getChildCount();
        int k1 = E;
        ListAdapter listadapter = e;
        if (listadapter != null)
        {
            int i1 = 0;
            while (i1 < j1) 
            {
                View view = getChildAt(i1);
                if (listadapter.isEnabled(k1 + i1))
                {
                    arraylist.add(view);
                }
                view.addTouchables(arraylist);
                i1++;
            }
        }
    }

    void b()
    {
        if (getChildCount() > 0)
        {
            c();
            requestLayout();
            invalidate();
        }
    }

    protected void b(int i1)
    {
    }

    public void b(int i1, int j1)
    {
        if (y == null)
        {
            y = new f(this);
        }
        y.a(i1, j1);
    }

    abstract void b(boolean flag);

    void c()
    {
        removeAllViewsInLayout();
        E = 0;
        Q = false;
        K = false;
        aa = -1;
        ab = 0x8000000000000000L;
        z = 0;
        h.setEmpty();
        invalidate();
    }

    protected void c(int i1)
    {
    }

    public void c(int i1, int j1)
    {
        if (b == null)
        {
            b = new com.huewu.pla.lib.internal.b(this);
        }
        int k1 = E;
        int l1 = getChildCount();
        int i2 = getPaddingTop();
        int j2 = getHeight();
        int k2 = getPaddingBottom();
        if (i1 == 0 || V == 0 || l1 == 0 || k1 == 0 && getChildAt(0).getTop() == i2 && i1 < 0 || k1 + l1 == V && getChildAt(l1 - 1).getBottom() == j2 - k2 && i1 > 0)
        {
            b.a();
            if (y != null)
            {
                y.a();
            }
            return;
        } else
        {
            g(2);
            b.a(i1, j1);
            return;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof com.huewu.pla.lib.internal.c;
    }

    protected int computeVerticalScrollExtent()
    {
        int k1 = getChildCount();
        if (k1 > 0)
        {
            if (af)
            {
                int j1 = k1 * 100;
                View view = getChildAt(0);
                int l1 = getFillChildTop();
                int i2 = view.getHeight();
                int i1 = j1;
                if (i2 > 0)
                {
                    i1 = j1 + (l1 * 100) / i2;
                }
                view = getChildAt(k1 - 1);
                k1 = getScrollChildBottom();
                l1 = view.getHeight();
                j1 = i1;
                if (l1 > 0)
                {
                    j1 = i1 - ((k1 - getHeight()) * 100) / l1;
                }
                return j1;
            } else
            {
                return 1;
            }
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollOffset()
    {
        int l1;
        int i2;
        int j2;
label0:
        {
            l1 = 0;
            boolean flag = false;
            i2 = E;
            j2 = getChildCount();
            int i1 = ((flag) ? 1 : 0);
            if (i2 >= 0)
            {
                i1 = ((flag) ? 1 : 0);
                if (j2 > 0)
                {
                    if (!af)
                    {
                        break label0;
                    }
                    View view = getChildAt(0);
                    l1 = getFillChildTop();
                    j2 = view.getHeight();
                    i1 = ((flag) ? 1 : 0);
                    if (j2 > 0)
                    {
                        i1 = Math.max((i2 * 100 - (l1 * 100) / j2) + (int)(((float)getScrollY() / (float)getHeight()) * (float)V * 100F), 0);
                    }
                }
            }
            return i1;
        }
        int k1 = V;
        float f1;
        float f2;
        int j1;
        if (i2 == 0)
        {
            j1 = l1;
        } else
        if (i2 + j2 == k1)
        {
            j1 = k1;
        } else
        {
            j1 = j2 / 2 + i2;
        }
        f1 = i2;
        f2 = j2;
        return (int)(((float)j1 / (float)k1) * f2 + f1);
    }

    protected int computeVerticalScrollRange()
    {
        if (af)
        {
            return Math.max(V * 100, 0);
        } else
        {
            return V;
        }
    }

    protected void d()
    {
    }

    boolean d(int i1, int j1)
    {
        Object obj;
        int j2;
        int k2;
        int l2;
        int i4;
        int j4;
        int k4;
        int l4;
        j4 = getChildCount();
        if (j4 == 0)
        {
            return true;
        }
        int k1 = getScrollChildTop();
        k2 = getScrollChildBottom();
        obj = n;
        int i3 = getHeight() - ((Rect) (obj)).bottom;
        int j3 = ((Rect) (obj)).top;
        int k3 = getFillChildTop();
        int l3 = getFillChildBottom();
        j2 = getHeight() - getPaddingBottom() - getPaddingTop();
        int i2;
        if (i1 < 0)
        {
            i2 = Math.max(-(j2 - 1), i1);
        } else
        {
            i2 = Math.min(j2 - 1, i1);
        }
        if (j1 < 0)
        {
            j2 = Math.max(-(j2 - 1) / 2, j1);
        } else
        {
            j2 = Math.min((j2 - 1) / 2, j1);
        }
        i4 = E;
        if (i4 == 0 && k1 >= ((Rect) (obj)).top && i2 >= 0)
        {
            return true;
        }
        if (i4 + j4 == V && k2 <= i3 && i2 <= 0)
        {
            return true;
        }
        int i5;
        boolean flag;
        if (j2 < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k4 = getHeaderViewsCount();
        l4 = V - getFooterViewsCount();
        k2 = 0;
        k1 = 0;
        if (!flag) goto _L2; else goto _L1
_L1:
        i5 = ((Rect) (obj)).top;
        i1 = 0;
        j1 = 0;
_L7:
        k2 = i1;
        l2 = k1;
        if (j1 >= j4) goto _L4; else goto _L3
_L3:
        obj = getChildAt(j1);
        if (((View) (obj)).getBottom() < i5 - j2) goto _L6; else goto _L5
_L5:
        l2 = k1;
        k2 = i1;
_L4:
        s = r + i2;
        ac = true;
        if (k2 > 0)
        {
            detachViewsFromParent(l2, k2);
        }
        i(j2);
        if (flag)
        {
            E = k2 + E;
        }
        invalidate();
        i1 = Math.abs(j2);
        if (j3 - k3 < i1 || l3 - i3 < i1)
        {
            b(flag);
        }
        ac = false;
        a();
        awakenScrollBars();
        return false;
_L6:
        k2 = i4 + j1;
        if (k2 >= k4 && k2 < l4)
        {
            i.a(((View) (obj)));
        }
        j1++;
        i1++;
          goto _L7
_L2:
        int l1;
        int j5;
        int k5;
        j5 = getHeight();
        k5 = ((Rect) (obj)).bottom;
        j1 = 0;
        i1 = j4 - 1;
        l1 = k2;
_L10:
        k2 = j1;
        l2 = l1;
        if (i1 < 0) goto _L4; else goto _L8
_L8:
        obj = getChildAt(i1);
        k2 = j1;
        l2 = l1;
        if (((View) (obj)).getTop() <= j5 - k5 - j2) goto _L4; else goto _L9
_L9:
        l1 = i4 + i1;
        if (l1 >= k4 && l1 < l4)
        {
            i.a(((View) (obj)));
        }
        j1++;
        l1 = i1;
        i1--;
          goto _L10
    }

    protected void dispatchDraw(Canvas canvas)
    {
        boolean flag = f;
        if (!flag)
        {
            a(canvas);
        }
        super.dispatchDraw(canvas);
        if (flag)
        {
            a(canvas);
        }
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (g != null)
        {
            g.setState(getDrawableState());
        }
    }

    boolean e()
    {
        switch (v)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    protected boolean f()
    {
        return hasFocus() && !isInTouchMode() || e();
    }

    int g()
    {
        int j1 = T;
        int i1 = j1;
        if (j1 < 0)
        {
            i1 = C;
        }
        return Math.min(Math.max(0, i1), V - 1);
    }

    void g(int i1)
    {
        if (i1 != aq && ae != null)
        {
            ae.a(this, i1);
            aq = i1;
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new com.huewu.pla.lib.internal.c(layoutparams);
    }

    protected float getBottomFadingEdgeStrength()
    {
        int i1 = getChildCount();
        float f1 = super.getBottomFadingEdgeStrength();
        if (i1 != 0)
        {
            if ((E + i1) - 1 < V - 1)
            {
                return 1.0F;
            }
            i1 = getChildAt(i1 - 1).getBottom();
            int j1 = getHeight();
            float f2 = getVerticalFadingEdgeLength();
            if (i1 > j1 - getPaddingBottom())
            {
                return (float)((i1 - j1) + getPaddingBottom()) / f2;
            }
        }
        return f1;
    }

    public int getCacheColorHint()
    {
        return ao;
    }

    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo()
    {
        return ah;
    }

    protected int getFillChildBottom()
    {
        int i1 = getChildCount();
        if (i1 == 0)
        {
            return 0;
        } else
        {
            return getChildAt(i1 - 1).getBottom();
        }
    }

    protected int getFillChildTop()
    {
        if (getChildCount() == 0)
        {
            return 0;
        } else
        {
            return getChildAt(0).getTop();
        }
    }

    protected int getFirstChildTop()
    {
        if (getChildCount() == 0)
        {
            return 0;
        } else
        {
            return getChildAt(0).getTop();
        }
    }

    public void getFocusedRect(Rect rect)
    {
        View view = getSelectedView();
        if (view != null && view.getParent() == this)
        {
            view.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(view, rect);
            return;
        } else
        {
            super.getFocusedRect(rect);
            return;
        }
    }

    int getFooterViewsCount()
    {
        return 0;
    }

    int getHeaderViewsCount()
    {
        return 0;
    }

    public int getListPaddingBottom()
    {
        return n.bottom;
    }

    public int getListPaddingLeft()
    {
        return n.left;
    }

    public int getListPaddingRight()
    {
        return n.right;
    }

    public int getListPaddingTop()
    {
        return n.top;
    }

    protected int getScrollChildBottom()
    {
        int i1 = getChildCount();
        if (i1 == 0)
        {
            return 0;
        } else
        {
            return getChildAt(i1 - 1).getBottom();
        }
    }

    protected int getScrollChildTop()
    {
        if (getChildCount() == 0)
        {
            return 0;
        } else
        {
            return getChildAt(0).getTop();
        }
    }

    public View getSelectedView()
    {
        return null;
    }

    public Drawable getSelector()
    {
        return g;
    }

    public int getSolidColor()
    {
        return ao;
    }

    protected float getTopFadingEdgeStrength()
    {
        int i1 = getChildCount();
        float f1 = super.getTopFadingEdgeStrength();
        if (i1 != 0)
        {
            if (E > 0)
            {
                return 1.0F;
            }
            int j1 = getChildAt(0).getTop();
            float f2 = getVerticalFadingEdgeLength();
            if (j1 < getPaddingTop())
            {
                return (float)(-(j1 - getPaddingTop())) / f2;
            }
        }
        return f1;
    }

    public int getTranscriptMode()
    {
        return an;
    }

    protected void h()
    {
        int l1 = V;
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        if (!K) goto _L4; else goto _L3
_L3:
        K = false;
        ad = null;
        if (an != 2 && (an != 1 || E + getChildCount() < W)) goto _L6; else goto _L5
_L5:
        c = 3;
_L11:
        return;
_L6:
        L;
        JVM INSTR tableswitch 0 1: default 92
    //                   0 182
    //                   1 262;
           goto _L4 _L7 _L8
_L4:
        if (isInTouchMode()) goto _L10; else goto _L9
_L9:
        int k1;
        k1 = getSelectedItemPosition();
        int i1 = k1;
        if (k1 >= l1)
        {
            i1 = l1 - 1;
        }
        k1 = i1;
        if (i1 < 0)
        {
            k1 = 0;
        }
        if (b(k1, true) >= 0 || b(k1, false) >= 0) goto _L11; else goto _L2
_L2:
        int j1;
        if (A)
        {
            j1 = 3;
        } else
        {
            j1 = 1;
        }
        c = j1;
        T = -1;
        U = 0x8000000000000000L;
        K = false;
        ad = null;
        k();
        return;
_L7:
        if (isInTouchMode())
        {
            c = 5;
            H = Math.min(Math.max(0, H), l1 - 1);
            return;
        }
        j1 = l();
        if (j1 >= 0 && b(j1, true) == j1)
        {
            H = j1;
            if (J == (long)getHeight())
            {
                c = 5;
                return;
            } else
            {
                c = 2;
                return;
            }
        }
          goto _L4
_L8:
        c = 5;
        H = Math.min(Math.max(0, H), l1 - 1);
        return;
_L10:
        if (C < 0) goto _L2; else goto _L12
_L12:
          goto _L4
    }

    public void h(int i1)
    {
        if (y == null)
        {
            y = new f(this);
        }
        y.a(i1);
    }

    protected void i(int i1)
    {
        int k1 = getChildCount();
        for (int j1 = 0; j1 < k1; j1++)
        {
            getChildAt(j1).offsetTopAndBottom(i1);
        }

    }

    abstract int j(int i1);

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver != null)
        {
            viewtreeobserver.addOnTouchModeChangeListener(this);
        }
    }

    protected int[] onCreateDrawableState(int i1)
    {
        if (!ap) goto _L2; else goto _L1
_L1:
        int ai1[] = super.onCreateDrawableState(i1);
_L5:
        return ai1;
_L2:
        int ai2[];
        int j1;
        j1 = ENABLED_STATE_SET[0];
        ai2 = super.onCreateDrawableState(i1 + 1);
        i1 = ai2.length - 1;
_L6:
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (ai2[i1] != j1) goto _L4; else goto _L3
_L3:
        ai1 = ai2;
        if (i1 >= 0)
        {
            System.arraycopy(ai2, i1 + 1, ai2, i1, ai2.length - i1 - 1);
            return ai2;
        }
          goto _L5
_L4:
        i1--;
          goto _L6
        i1 = -1;
          goto _L3
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        i.b();
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver != null)
        {
            viewtreeobserver.removeOnTouchModeChangeListener(this);
        }
    }

    public void onGlobalLayout()
    {
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 52
    //                   0 54
    //                   1 210
    //                   2 157
    //                   3 52
    //                   4 52
    //                   5 52
    //                   6 228;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
        return false;
_L2:
        int i1 = v;
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        av = motionevent.getPointerId(0);
        int l1 = j(k1);
        if (i1 != 4 && l1 >= 0)
        {
            r = getChildAt(l1 - E).getTop();
            t = j1;
            u = k1;
            q = l1;
            v = 0;
            q();
        }
        w = 0x80000000;
        if (i1 == 4)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        switch (v)
        {
        case 0: // '\0'
            if (a((int)motionevent.getY(motionevent.findPointerIndex(av)) - u))
            {
                return true;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        v = -1;
        av = -1;
        g(0);
        continue; /* Loop/switch isn't completed */
_L5:
        a(motionevent);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        return false;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        M = true;
        if (flag)
        {
            j1 = getChildCount();
            for (i1 = 0; i1 < j1; i1++)
            {
                getChildAt(i1).forceLayout();
            }

            i.a();
        }
        com.huewu.pla.lib.a.b("onLayout");
        d();
        M = false;
    }

    protected void onMeasure(int i1, int j1)
    {
        if (g == null)
        {
            o();
        }
        Rect rect = n;
        rect.left = j + getPaddingLeft();
        rect.top = k + getPaddingTop();
        rect.right = l + getPaddingRight();
        rect.bottom = m + getPaddingBottom();
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        Object obj = parcelable;
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            Q = true;
            J = parcelable.getInt("height");
            long l1 = parcelable.getLong("firstId");
            if (l1 >= 0L)
            {
                K = true;
                obj = new i();
                obj.a = l1;
                obj.d = (int)J;
                obj.c = parcelable.getInt("position");
                obj.b = parcelable.getInt("viewTop");
                obj.e = parcelable.getInt("childCount");
                obj.f = parcelable.getIntArray("viewTops");
                ad = ((i) (obj));
                I = ((i) (obj)).a;
                H = ((i) (obj)).c;
                F = ((i) (obj)).b;
                G = ((i) (obj)).f;
            }
            obj = parcelable.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(((Parcelable) (obj)));
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        if (ad != null)
        {
            bundle.putLong("firstId", ad.a);
            bundle.putInt("viewTop", ad.b);
            bundle.putIntArray("viewTops", ad.f);
            bundle.putInt("position", ad.c);
            bundle.putInt("height", ad.d);
            bundle.putInt("childCount", ad.e);
            return bundle;
        }
        bundle.putInt("height", getHeight());
        int k1 = getChildCount();
        bundle.putInt("childCount", k1);
        int i1;
        if (k1 > 0 && V > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0 && E > 0)
        {
            int j1 = E;
            i1 = j1;
            if (j1 >= V)
            {
                i1 = V - 1;
            }
            bundle.putInt("position", i1);
            bundle.putLong("firstId", e.getItemId(i1));
            bundle.putInt("viewTop", getChildAt(0).getTop());
            int ai1[] = new int[k1];
            for (i1 = 0; i1 < k1; i1++)
            {
                ai1[i1] = getChildAt(i1).getTop();
            }

            bundle.putIntArray("viewTops", ai1);
        } else
        {
            bundle.putInt("viewTop", 0);
            bundle.putLong("firstId", -1L);
            bundle.putInt("position", 0);
            bundle.putIntArray("viewTops", new int[1]);
        }
        return bundle;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (getChildCount() > 0)
        {
            com.huewu.pla.lib.a.a("data changed by onSizeChanged()");
            Q = true;
            m();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag2;
        flag = true;
        flag2 = false;
        if (isEnabled()) goto _L2; else goto _L1
_L1:
        if (isClickable() || isLongClickable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L9:
        return flag;
_L2:
        int i1;
        i1 = motionevent.getAction();
        if (a == null)
        {
            a = VelocityTracker.obtain();
        }
        a.addMovement(motionevent);
        i1 & 0xff;
        JVM INSTR tableswitch 0 6: default 116
    //                   0 118
    //                   1 593
    //                   2 394
    //                   3 1100
    //                   4 116
    //                   5 116
    //                   6 1163;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L3 _L8
_L3:
        return true;
_L4:
        if (v == 4)
        {
            b.a();
            if (y != null)
            {
                y.a();
            }
            v = 3;
            t = (int)motionevent.getX();
            u = (int)motionevent.getY();
            w = u;
            x = 0;
            return true;
        }
        av = motionevent.getPointerId(0);
        int l2 = (int)motionevent.getX();
        int l3 = (int)motionevent.getY();
        int j1 = a(l2, l3);
        if (!Q)
        {
            if (v != 4 && j1 >= 0 && ((ListAdapter)getAdapter()).isEnabled(j1))
            {
                v = 0;
                if (al == null)
                {
                    al = new com.huewu.pla.lib.internal.a(this);
                }
                postDelayed(al, ViewConfiguration.getTapTimeout());
            } else
            {
                if (motionevent.getEdgeFlags() != 0 && j1 < 0)
                {
                    return false;
                }
                if (v == 4)
                {
                    p();
                    v = 3;
                    x = 0;
                    j1 = j(l3);
                    g(1);
                }
            }
        }
        if (j1 >= 0)
        {
            r = getChildAt(j1 - E).getTop();
        }
        t = l2;
        u = l3;
        q = j1;
        w = 0x80000000;
        return true;
_L6:
        int i4 = (int)motionevent.getY(motionevent.findPointerIndex(av));
        int k1 = i4 - u;
        switch (v)
        {
        default:
            return true;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            a(k1);
            return true;

        case 3: // '\003'
            break;
        }
        if (i4 != w)
        {
            int i3 = k1 - x;
            boolean flag1;
            if (w != 0x80000000)
            {
                k1 = i4 - w;
            } else
            {
                k1 = i3;
            }
            flag1 = flag2;
            if (k1 != 0)
            {
                flag1 = d(i3, k1);
            }
            if (flag1 && getChildCount() > 0)
            {
                k1 = j(i4);
                if (k1 >= 0)
                {
                    r = getChildAt(k1 - E).getTop();
                }
                u = i4;
                q = k1;
                invalidate();
            }
            w = i4;
            return true;
        }
          goto _L9
_L5:
        v;
        JVM INSTR tableswitch 0 3: default 628
    //                   0 663
    //                   1 663
    //                   2 663
    //                   3 911;
           goto _L10 _L11 _L11 _L11 _L12
_L10:
        setPressed(false);
        invalidate();
        if (a != null)
        {
            a.recycle();
            a = null;
        }
        av = -1;
        return true;
_L11:
        int l1 = q;
        motionevent = getChildAt(l1 - E);
        if (motionevent != null && !motionevent.hasFocusable())
        {
            if (v != 0)
            {
                motionevent.setPressed(false);
            }
            if (am == null)
            {
                am = new e(this);
            }
            e e1 = am;
            e1.a = motionevent;
            e1.b = l1;
            e1.a();
            C = l1;
            if (v == 0 || v == 1)
            {
                c = 0;
                if (!Q && e.isEnabled(l1))
                {
                    v = 1;
                    d();
                    motionevent.setPressed(true);
                    a(motionevent);
                    setPressed(true);
                    if (g != null)
                    {
                        Drawable drawable = g.getCurrent();
                        if (drawable != null && (drawable instanceof TransitionDrawable))
                        {
                            ((TransitionDrawable)drawable).resetTransition();
                        }
                    }
                    postDelayed(new Runnable(motionevent, e1) {

                        final View a;
                        final e b;
                        final PLA_AbsListView c;

                        public void run()
                        {
                            a.setPressed(false);
                            c.setPressed(false);
                            if (!c.Q)
                            {
                                c.post(b);
                            }
                            c.v = -1;
                        }

            
            {
                c = PLA_AbsListView.this;
                a = view;
                b = e1;
                super();
            }
                    }, ViewConfiguration.getPressedStateDuration());
                    return true;
                } else
                {
                    v = -1;
                    return true;
                }
            }
            if (!Q && e.isEnabled(l1))
            {
                post(e1);
            }
        }
        v = -1;
          goto _L10
_L12:
        int i2 = getChildCount();
        if (i2 > 0)
        {
            int j3 = getFillChildTop();
            int j4 = getFillChildBottom();
            if (E == 0 && j3 >= n.top && i2 + E < V && j4 <= getHeight() - n.bottom)
            {
                v = -1;
                g(0);
            } else
            {
                motionevent = a;
                motionevent.computeCurrentVelocity(1000, au);
                int j2 = (int)motionevent.getYVelocity(av);
                if (Math.abs(j2) > at)
                {
                    if (b == null)
                    {
                        b = new com.huewu.pla.lib.internal.b(this);
                    }
                    g(2);
                    b.a(-j2);
                } else
                {
                    v = -1;
                    g(0);
                }
            }
        } else
        {
            v = -1;
            g(0);
        }
          goto _L10
_L7:
        v = -1;
        setPressed(false);
        motionevent = getChildAt(q - E);
        if (motionevent != null)
        {
            motionevent.setPressed(false);
        }
        q();
        if (a != null)
        {
            a.recycle();
            a = null;
        }
        av = -1;
        return true;
_L8:
        a(motionevent);
        int k3 = t;
        int k2 = u;
        k3 = a(k3, k2);
        if (k3 >= 0)
        {
            r = getChildAt(k3 - E).getTop();
            q = k3;
        }
        w = k2;
        return true;
    }

    public void onTouchModeChanged(boolean flag)
    {
        if (flag && getHeight() > 0 && getChildCount() > 0)
        {
            d();
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        int i1;
        super.onWindowFocusChanged(flag);
        com.huewu.pla.lib.a.b("onWindowFocusChanged");
        if (isInTouchMode())
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        setChildrenDrawingCacheEnabled(false);
        if (b != null)
        {
            removeCallbacks(b);
            b.a();
            if (getScrollY() != 0)
            {
                scrollTo(getScrollX(), 0);
                invalidate();
            }
        }
_L4:
        ai = i1;
        return;
_L2:
        if (i1 != ai && ai != -1)
        {
            c = 0;
            com.huewu.pla.lib.a.b("onWindowFocusChanged");
            d();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void postOnAnimation(Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            super.postOnAnimation(runnable);
            return;
        } else
        {
            postDelayed(runnable, 10L);
            return;
        }
    }

    public void requestLayout()
    {
        if (!ac && !M)
        {
            super.requestLayout();
        }
    }

    public void setCacheColorHint(int i1)
    {
        if (i1 != ao)
        {
            ao = i1;
            int k1 = getChildCount();
            for (int j1 = 0; j1 < k1; j1++)
            {
                getChildAt(j1).setDrawingCacheBackgroundColor(i1);
            }

            i.e(i1);
        }
    }

    public void setDrawSelectorOnTop(boolean flag)
    {
        f = flag;
    }

    public void setOnScrollListener(d d1)
    {
        ae = d1;
        a();
    }

    public void setRecyclerListener(h h1)
    {
        com.huewu.pla.lib.internal.g.a(i, h1);
    }

    public void setScrollingCacheEnabled(boolean flag)
    {
        if (B && !flag)
        {
            q();
        }
        B = flag;
    }

    public void setSelector(int i1)
    {
        setSelector(getResources().getDrawable(i1));
    }

    public void setSelector(Drawable drawable)
    {
        if (g != null)
        {
            g.setCallback(null);
            unscheduleDrawable(g);
        }
        g = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        j = rect.left;
        k = rect.top;
        l = rect.right;
        m = rect.bottom;
        drawable.setCallback(this);
        drawable.setState(getDrawableState());
    }

    public void setSmoothScrollbarEnabled(boolean flag)
    {
        af = flag;
    }

    public void setStackFromBottom(boolean flag)
    {
        if (A != flag)
        {
            A = flag;
            b();
        }
    }

    public void setTranscriptMode(int i1)
    {
        an = i1;
    }

    public boolean showContextMenuForChild(View view)
    {
        boolean flag = false;
        boolean flag1 = false;
        int i1 = b(view);
        if (i1 >= 0)
        {
            long l1 = e.getItemId(i1);
            if (P != null)
            {
                flag1 = P.a(this, view, i1, l1);
            }
            flag = flag1;
            if (!flag1)
            {
                ah = a(getChildAt(i1 - E), i1, l1);
                flag = super.showContextMenuForChild(view);
            }
        }
        return flag;
    }

    public boolean verifyDrawable(Drawable drawable)
    {
        return g == drawable || super.verifyDrawable(drawable);
    }
}

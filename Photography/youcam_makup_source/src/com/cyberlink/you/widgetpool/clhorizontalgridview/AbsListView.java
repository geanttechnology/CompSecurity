// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Adapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.cyberlink.you.t;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AdapterView, i, t, e, 
//            f, d, h, k, 
//            m, q, a, n, 
//            c, g, u, b, 
//            j

public abstract class AbsListView extends AdapterView
    implements android.view.ViewTreeObserver.OnTouchModeChangeListener
{

    static final Interpolator Q = new LinearInterpolator();
    int A;
    int B;
    int C;
    int D;
    int E;
    h F;
    int G;
    boolean H;
    boolean I;
    int J;
    int K;
    Runnable L;
    final boolean M[];
    int N;
    int O;
    boolean P;
    float R;
    int a;
    private Runnable aA;
    private a aB;
    private g aC;
    private Runnable aD;
    private int aE;
    private int aF;
    private boolean aG;
    private int aH;
    private int aI;
    private float aJ;
    private Runnable aK;
    private int aL;
    private int aM;
    private float aN;
    private int aO;
    private com.cyberlink.you.widgetpool.clhorizontalgridview.t aP;
    private com.cyberlink.you.widgetpool.clhorizontalgridview.t aQ;
    private int aR;
    private int aS;
    private int aT;
    private boolean aU;
    private int aV;
    private int aW;
    private int aX;
    private int aY;
    private int aZ;
    private VelocityTracker aq;
    private d ar;
    private f as;
    private boolean at;
    private Rect au;
    private android.view.ContextMenu.ContextMenuInfo av;
    private int aw;
    private boolean ax;
    private boolean ay;
    private b az;
    int b;
    private SavedState ba;
    SparseBooleanArray c;
    LongSparseArray d;
    int e;
    n f;
    ListAdapter g;
    boolean h;
    boolean i;
    Drawable j;
    int k;
    Rect l;
    final i m;
    int n;
    int o;
    int p;
    int q;
    Rect r;
    int s;
    View t;
    View u;
    boolean v;
    boolean w;
    int x;
    int y;
    int z;

    public AbsListView(Context context)
    {
        super(context);
        a = 0;
        e = 0;
        i = false;
        k = -1;
        l = new Rect();
        m = new i(this);
        n = 0;
        o = 0;
        p = 0;
        q = 0;
        r = new Rect();
        s = 0;
        C = -1;
        G = 0;
        at = true;
        J = -1;
        av = null;
        aw = -1;
        ax = false;
        ay = false;
        aH = 0;
        aN = 1.0F;
        M = new boolean[1];
        aO = -1;
        aT = 0;
        R = 0.0F;
        x();
    }

    public AbsListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101006a);
    }

    public AbsListView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = 0;
        e = 0;
        i = false;
        k = -1;
        l = new Rect();
        m = new i(this);
        n = 0;
        o = 0;
        p = 0;
        q = 0;
        r = new Rect();
        s = 0;
        C = -1;
        G = 0;
        at = true;
        J = -1;
        av = null;
        aw = -1;
        ax = false;
        ay = false;
        aH = 0;
        aN = 1.0F;
        M = new boolean[1];
        aO = -1;
        aT = 0;
        R = 0.0F;
        x();
        context = context.obtainStyledAttributes(attributeset, t.AbsListView, i1, 0);
        attributeset = context.getDrawable(t.AbsListView_listSelector);
        if (attributeset != null)
        {
            setSelector(attributeset);
        }
        i = context.getBoolean(t.AbsListView_drawSelectorOnTop, false);
        setStackFromRight(context.getBoolean(t.AbsListView_stackFromRight, false));
        setScrollingCacheEnabled(context.getBoolean(t.AbsListView_scrollingCache, true));
        setTranscriptMode(context.getInt(t.AbsListView_transcriptMode, 0));
        setCacheColorHint(context.getColor(t.AbsListView_cacheColorHint, 0));
        setSmoothScrollbarEnabled(context.getBoolean(t.AbsListView_smoothScrollbar, true));
        setChoiceMode(context.getInt(t.AbsListView_choiceMode, 0));
        context.recycle();
    }

    private void A()
    {
        setSelector(getResources().getDrawable(0x1080062));
    }

    private void B()
    {
        if (aq == null)
        {
            aq = VelocityTracker.obtain();
            return;
        } else
        {
            aq.clear();
            return;
        }
    }

    private void C()
    {
        if (aq == null)
        {
            aq = VelocityTracker.obtain();
        }
    }

    private void D()
    {
        if (aq != null)
        {
            aq.recycle();
            aq = null;
        }
    }

    private void E()
    {
        if (I && !v && !b(this))
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            w = true;
            v = true;
        }
    }

    private void F()
    {
        if (!b(this))
        {
            if (aK == null)
            {
                aK = new Runnable() {

                    final AbsListView a;

                    public void run()
                    {
                        if (a.v)
                        {
                            AbsListView abslistview = a;
                            a.w = false;
                            abslistview.v = false;
                            AbsListView.a(a, false);
                            if ((a.getPersistentDrawingCache() & 2) == 0)
                            {
                                AbsListView.b(a, false);
                            }
                            if (!a.isAlwaysDrawnWithCacheEnabled())
                            {
                                a.invalidate();
                            }
                        }
                    }

            
            {
                a = AbsListView.this;
                super();
            }
                };
            }
            post(aK);
        }
    }

    private void G()
    {
        if (aP != null)
        {
            aP.b();
            aQ.b();
        }
    }

    static int a(Rect rect, Rect rect1, int i1)
    {
        i1;
        JVM INSTR lookupswitch 6: default 60
    //                   1: 246
    //                   2: 246
    //                   17: 166
    //                   33: 205
    //                   66: 71
    //                   130: 125;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
_L5:
        int j1;
        int k1;
        int l1;
        l1 = rect.right;
        k1 = rect.top + rect.height() / 2;
        j1 = rect1.left;
        i1 = rect1.top + rect1.height() / 2;
_L8:
        j1 -= l1;
        i1 -= k1;
        return i1 * i1 + j1 * j1;
_L6:
        l1 = rect.left + rect.width() / 2;
        k1 = rect.bottom;
        i1 = rect1.left;
        j1 = rect1.width() / 2 + i1;
        i1 = rect1.top;
        continue; /* Loop/switch isn't completed */
_L3:
        l1 = rect.left;
        k1 = rect.top + rect.height() / 2;
        j1 = rect1.right;
        i1 = rect1.top + rect1.height() / 2;
        continue; /* Loop/switch isn't completed */
_L4:
        l1 = rect.left + rect.width() / 2;
        k1 = rect.top;
        i1 = rect1.left;
        j1 = rect1.width() / 2 + i1;
        i1 = rect1.bottom;
        continue; /* Loop/switch isn't completed */
_L2:
        l1 = rect.right + rect.width() / 2;
        k1 = rect.top + rect.height() / 2;
        i1 = rect1.left;
        j1 = rect1.width() / 2 + i1;
        i1 = rect1.top + rect1.height() / 2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static int a(AbsListView abslistview)
    {
        return abslistview.getWindowAttachCount();
    }

    static View a(ArrayList arraylist, int i1)
    {
        int k1 = arraylist.size();
        if (k1 > 0)
        {
            for (int j1 = 0; j1 < k1; j1++)
            {
                View view = (View)arraylist.get(j1);
                if (((e)view.getLayoutParams()).c == i1)
                {
                    arraylist.remove(j1);
                    return view;
                }
            }

            return (View)arraylist.remove(k1 - 1);
        } else
        {
            return null;
        }
    }

    static b a(AbsListView abslistview, b b1)
    {
        abslistview.az = b1;
        return b1;
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        l.set(i1 - n, j1 - o, p + k1, q + l1);
    }

    private void a(Canvas canvas)
    {
        if (!l.isEmpty())
        {
            Drawable drawable = j;
            drawable.setBounds(l);
            drawable.draw(canvas);
        }
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = (motionevent.getAction() & 0xff00) >> 8;
        if (motionevent.getPointerId(i1) == aO)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            A = (int)motionevent.getX(i1);
            B = (int)motionevent.getY(i1);
            E = 0;
            aO = motionevent.getPointerId(i1);
        }
    }

    private static void a(View view, int i1)
    {
        view.scrollTo(i1, view.getScrollY());
    }

    static void a(AbsListView abslistview, View view, boolean flag)
    {
        abslistview.removeDetachedView(view, flag);
    }

    static void a(AbsListView abslistview, boolean flag)
    {
        abslistview.setChildrenDrawnWithCacheEnabled(flag);
    }

    static boolean a(AbsListView abslistview, int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, boolean flag)
    {
        return abslistview.overScrollBy(i1, j1, k1, l1, i2, j2, k2, l2, flag);
    }

    static int b(AbsListView abslistview)
    {
        return abslistview.getWindowAttachCount();
    }

    static void b(AbsListView abslistview, View view, boolean flag)
    {
        abslistview.removeDetachedView(view, flag);
    }

    static void b(AbsListView abslistview, boolean flag)
    {
        abslistview.setChildrenDrawingCacheEnabled(flag);
    }

    private static boolean b(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return view.isHardwareAccelerated();
        } else
        {
            return false;
        }
    }

    static boolean b(AbsListView abslistview, int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, boolean flag)
    {
        return abslistview.overScrollBy(i1, j1, k1, l1, i2, j2, k2, l2, flag);
    }

    static b c(AbsListView abslistview)
    {
        return abslistview.az;
    }

    static void c(AbsListView abslistview, View view, boolean flag)
    {
        abslistview.removeDetachedView(view, flag);
    }

    static int d(AbsListView abslistview)
    {
        return abslistview.aO;
    }

    static void d(AbsListView abslistview, View view, boolean flag)
    {
        abslistview.removeDetachedView(view, flag);
    }

    static VelocityTracker e(AbsListView abslistview)
    {
        return abslistview.aq;
    }

    static void e(AbsListView abslistview, View view, boolean flag)
    {
        abslistview.removeDetachedView(view, flag);
    }

    static int f(AbsListView abslistview)
    {
        return abslistview.aM;
    }

    private boolean f(int i1)
    {
        int k1 = i1 - A;
        int l1 = Math.abs(k1);
        boolean flag;
        if (getScrollX() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || l1 > aI)
        {
            E();
            Object obj;
            if (flag)
            {
                C = 5;
                E = 0;
            } else
            {
                C = 3;
                int j1;
                if (k1 > 0)
                {
                    j1 = aI;
                } else
                {
                    j1 = -aI;
                }
                E = j1;
            }
            obj = getHandler();
            if (obj != null)
            {
                ((Handler) (obj)).removeCallbacks(az);
            }
            setPressed(false);
            obj = getChildAt(x - S);
            if (obj != null)
            {
                ((View) (obj)).setPressed(false);
            }
            a(1);
            obj = getParent();
            if (obj != null)
            {
                ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(true);
            }
            g(i1);
            return true;
        } else
        {
            return false;
        }
    }

    static int g(AbsListView abslistview)
    {
        return abslistview.aL;
    }

    private void g(int i1)
    {
        int j1;
        boolean flag;
        int k2;
        flag = false;
        k2 = i1 - A;
        int i2 = k2 - E;
        View view;
        if (D != 0x80000000)
        {
            j1 = i1 - D;
        } else
        {
            j1 = i2;
        }
        if (C != 3) goto _L2; else goto _L1
_L1:
        if (i1 == D) goto _L4; else goto _L3
_L3:
        int k1;
        int l1;
        boolean flag1;
        if (x >= 0)
        {
            k1 = x - S;
        } else
        {
            k1 = getChildCount() / 2;
        }
        view = getChildAt(k1);
        View view1;
        int j2;
        int l2;
        if (view != null)
        {
            l1 = view.getLeft();
        } else
        {
            l1 = 0;
        }
        if (j1 != 0)
        {
            flag1 = b(i2, j1);
        } else
        {
            flag1 = false;
        }
        view = getChildAt(k1);
        if (view == null) goto _L6; else goto _L5
_L5:
        k1 = view.getLeft();
        if (!flag1) goto _L8; else goto _L7
_L7:
        j1 = -j1 - (k1 - l1);
        overScrollBy(j1, 0, getScrollX(), 0, 0, 0, N, 0, true);
        if (Math.abs(N) == Math.abs(getScrollX()) && aq != null)
        {
            aq.clear();
        }
        k1 = getOverScrollMode();
        if (k1 != 0 && (k1 != 1 || z())) goto _L8; else goto _L9
_L9:
        aT = 0;
        C = 5;
        if (k2 <= 0) goto _L11; else goto _L10
_L10:
        aP.a((float)j1 / (float)getWidth());
        if (!aQ.a())
        {
            aQ.c();
        }
        invalidate(aP.a(false));
_L8:
        A = i1;
_L6:
        D = i1;
_L4:
        return;
_L11:
        if (k2 < 0)
        {
            aQ.a((float)j1 / (float)getWidth());
            if (!aP.a())
            {
                aP.c();
            }
            invalidate(aQ.a(true));
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (C != 5 || i1 == D) goto _L4; else goto _L12
_L12:
        j2 = getScrollX();
        l2 = j2 - j1;
        if (i1 > D)
        {
            k1 = 1;
        } else
        {
            k1 = -1;
        }
        if (aT == 0)
        {
            aT = k1;
        }
        l1 = -j1;
        if (l2 < 0 && j2 >= 0 || l2 > 0 && j2 <= 0)
        {
            j2 = -j2;
            l1 = j1 + j2;
            j1 = j2;
        } else
        {
            j2 = 0;
            j1 = l1;
            l1 = j2;
        }
        if (j1 == 0) goto _L14; else goto _L13
_L13:
        overScrollBy(j1, 0, getScrollX(), 0, 0, 0, N, 0, true);
        j2 = getOverScrollMode();
        if (j2 != 0 && (j2 != 1 || z())) goto _L14; else goto _L15
_L15:
        if (k2 <= 0) goto _L17; else goto _L16
_L16:
        aP.a((float)j1 / (float)getWidth());
        if (!aQ.a())
        {
            aQ.c();
        }
        invalidate(aP.a(false));
_L14:
        if (l1 != 0)
        {
            if (getScrollX() != 0)
            {
                a(this, 0);
            }
            b(l1, l1);
            C = 3;
            l1 = c(i1);
            E = 0;
            view1 = getChildAt(l1 - S);
            j1 = ((flag) ? 1 : 0);
            if (view1 != null)
            {
                j1 = view1.getLeft();
            }
            y = j1;
            A = i1;
            x = l1;
        }
        D = i1;
        aT = k1;
        return;
_L17:
        if (k2 < 0)
        {
            aQ.a((float)j1 / (float)getWidth());
            if (!aP.a())
            {
                aP.c();
            }
            invalidate(aQ.a(true));
        }
        if (true) goto _L14; else goto _L18
_L18:
        if (true) goto _L8; else goto _L19
_L19:
    }

    static boolean h(AbsListView abslistview)
    {
        return abslistview.z();
    }

    static com.cyberlink.you.widgetpool.clhorizontalgridview.t i(AbsListView abslistview)
    {
        return abslistview.aP;
    }

    static com.cyberlink.you.widgetpool.clhorizontalgridview.t j(AbsListView abslistview)
    {
        return abslistview.aQ;
    }

    static void k(AbsListView abslistview)
    {
        abslistview.F();
    }

    private void x()
    {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        aI = viewconfiguration.getScaledTouchSlop();
        aL = viewconfiguration.getScaledMinimumFlingVelocity();
        aM = viewconfiguration.getScaledMaximumFlingVelocity();
        N = viewconfiguration.getScaledOverscrollDistance();
        O = viewconfiguration.getScaledOverflingDistance();
        aJ = getContext().getResources().getDisplayMetrics().density;
    }

    private void y()
    {
        int j1 = S;
        int k1 = getChildCount();
        for (int i1 = 0; i1 < k1; i1++)
        {
            View view = getChildAt(i1);
            if (view instanceof Checkable)
            {
                ((Checkable)view).setChecked(c.get(j1 + i1));
            }
        }

    }

    private boolean z()
    {
        int i1 = getChildCount();
        if (i1 != 0)
        {
            if (i1 != al)
            {
                return false;
            }
            if (getChildAt(0).getLeft() < r.left || getChildAt(i1 - 1).getRight() > getWidth() - r.right)
            {
                return false;
            }
        }
        return true;
    }

    public int a(int i1, int j1)
    {
        Rect rect1 = au;
        Rect rect = rect1;
        if (rect1 == null)
        {
            au = new Rect();
            rect = au;
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
                return S + k1;
            }
        }

        return -1;
    }

    View a(int i1, boolean aflag[])
    {
        Object obj;
        aflag[0] = false;
        obj = m.d(i1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((View) (obj));
_L2:
        View view = m.e(i1);
        if (view == null) goto _L4; else goto _L3
_L3:
        obj = g.getView(i1, view, this);
        if (obj != view)
        {
            m.a(view, i1);
            aflag = ((boolean []) (obj));
            if (aF != 0)
            {
                ((View) (obj)).setDrawingCacheBackgroundColor(aF);
                aflag = ((boolean []) (obj));
            }
        } else
        {
            aflag[0] = true;
            aflag = ((boolean []) (obj));
        }
_L5:
        obj = aflag;
        if (h)
        {
            obj = aflag.getLayoutParams();
            if (obj == null)
            {
                obj = (e)generateDefaultLayoutParams();
            } else
            if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
            {
                obj = (e)generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj = (e)obj;
            }
            obj.d = g.getItemId(i1);
            aflag.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            return aflag;
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj = g.getView(i1, null, this);
        aflag = ((boolean []) (obj));
        if (aF != 0)
        {
            ((View) (obj)).setDrawingCacheBackgroundColor(aF);
            aflag = ((boolean []) (obj));
        }
          goto _L5
    }

    public e a(AttributeSet attributeset)
    {
        return new e(getContext(), attributeset);
    }

    public void a()
    {
        if (c != null)
        {
            c.clear();
        }
        if (d != null)
        {
            d.clear();
        }
        b = 0;
    }

    void a(int i1)
    {
        if (i1 != aH && as != null)
        {
            aH = i1;
            as.a(this, i1);
        }
    }

    void a(int i1, int j1, boolean flag)
    {
        if (ar == null)
        {
            ar = new d(this);
        }
        int k1 = S;
        int l1 = getChildCount();
        int i2 = getPaddingLeft();
        int j2 = getWidth();
        int k2 = getPaddingRight();
        if (i1 == 0 || al == 0 || l1 == 0 || k1 == 0 && getChildAt(0).getLeft() == i2 && i1 < 0 || k1 + l1 == al && getChildAt(l1 - 1).getRight() == j2 - k2 && i1 > 0)
        {
            ar.b();
            if (F != null)
            {
                F.a();
            }
            return;
        } else
        {
            a(2);
            ar.a(i1, j1, flag);
            return;
        }
    }

    void a(int i1, View view)
    {
        if (i1 != -1)
        {
            k = i1;
        }
        Rect rect = l;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof k)
        {
            ((k)view).a(rect);
        }
        a(rect.left, rect.top, rect.right, rect.bottom);
        boolean flag = aG;
        if (view.isEnabled() != flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aG = flag;
            if (getSelectedItemPosition() != -1)
            {
                refreshDrawableState();
            }
        }
    }

    abstract void a(boolean flag);

    public boolean a(View view, int i1, long l1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag = false;
        flag2 = false;
        if (a == 0) goto _L2; else goto _L1
_L1:
        if (a != 2) goto _L4; else goto _L3
_L3:
        if (!c.get(i1, false))
        {
            flag2 = true;
        }
        c.put(i1, flag2);
        if (d != null && g.hasStableIds())
        {
            if (flag2)
            {
                d.put(g.getItemId(i1), Integer.valueOf(i1));
            } else
            {
                d.delete(g.getItemId(i1));
            }
        }
        if (flag2)
        {
            b = b + 1;
        } else
        {
            b = b - 1;
        }
        flag = true;
_L6:
        if (flag)
        {
            y();
        }
        flag = true;
_L2:
        return flag | super.a(view, i1, l1);
_L4:
        flag = flag1;
        if (a != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!c.get(i1, false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        c.clear();
        c.put(i1, true);
        if (d != null && g.hasStableIds())
        {
            d.clear();
            d.put(g.getItemId(i1), Integer.valueOf(i1));
        }
        b = 1;
_L8:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        if (c.size() != 0 && c.valueAt(0)) goto _L8; else goto _L7
_L7:
        b = 0;
          goto _L8
    }

    public void addTouchables(ArrayList arraylist)
    {
        int j1 = getChildCount();
        int k1 = S;
        ListAdapter listadapter = g;
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

    abstract int b(int i1);

    android.view.ContextMenu.ContextMenuInfo b(View view, int i1, long l1)
    {
        return new m(view, i1, l1);
    }

    void b()
    {
        if (as != null)
        {
            as.a(this, S, getChildCount(), al);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    boolean b(int i1, int j1)
    {
        Object obj;
        int j2;
        int k2;
        int l2;
        int l3;
        int i4;
        int j4;
        int k4;
        i4 = getChildCount();
        if (i4 == 0)
        {
            return true;
        }
        int i3 = getChildAt(0).getLeft();
        int j3 = getChildAt(i4 - 1).getRight();
        obj = r;
        int k3 = getWidth();
        int k1 = getWidth() - getPaddingRight() - getPaddingLeft();
        int i2;
        if (i1 < 0)
        {
            i2 = Math.max(-(k1 - 1), i1);
        } else
        {
            i2 = Math.min(k1 - 1, i1);
        }
        if (j1 < 0)
        {
            j2 = Math.max(-(k1 - 1), j1);
        } else
        {
            j2 = Math.min(k1 - 1, j1);
        }
        l3 = S;
        if (l3 == 0)
        {
            aR = i3 - ((Rect) (obj)).left;
        } else
        {
            aR = aR + j2;
        }
        if (l3 + i4 == al)
        {
            aS = ((Rect) (obj)).right + j3;
        } else
        {
            aS = aS + j2;
        }
        if (l3 == 0 && i3 >= ((Rect) (obj)).left && j2 >= 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (l3 + i4 == al && j3 <= getWidth() - ((Rect) (obj)).right && j2 <= 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (i1 != 0 || j1 != 0)
        {
            return j2 != 0;
        }
        int l4;
        boolean flag;
        boolean flag1;
        if (j2 < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = isInTouchMode();
        if (flag1)
        {
            l();
        }
        j4 = getHeaderViewsCount();
        k4 = al - getFooterViewsCount();
        k2 = 0;
        k1 = 0;
        if (!flag) goto _L2; else goto _L1
_L1:
        l4 = -j2;
        i1 = 0;
        j1 = 0;
_L7:
        k2 = i1;
        l2 = k1;
        if (j1 >= i4) goto _L4; else goto _L3
_L3:
        obj = getChildAt(j1);
        if (((View) (obj)).getRight() < l4) goto _L6; else goto _L5
_L5:
        l2 = k1;
        k2 = i1;
_L4:
        z = y + i2;
        ap = true;
        if (k2 > 0)
        {
            detachViewsFromParent(l2, k2);
            m.d();
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        d(j2);
        if (flag)
        {
            S = k2 + S;
        }
        i1 = Math.abs(j2);
        if (0 - i3 < i1 || j3 - (k3 - 0) < i1)
        {
            a(flag);
        }
        int l1;
        int i5;
        if (!flag1 && aj != -1)
        {
            i1 = aj - S;
            if (i1 >= 0 && i1 < getChildCount())
            {
                a(aj, getChildAt(i1));
            }
        } else
        if (k != -1)
        {
            i1 = k - S;
            if (i1 >= 0 && i1 < getChildCount())
            {
                a(-1, getChildAt(i1));
            }
        } else
        {
            l.setEmpty();
        }
        ap = false;
        b();
        return false;
_L6:
        k2 = l3 + j1;
        if (k2 >= j4 && k2 < k4)
        {
            m.a(((View) (obj)), k2);
        }
        j1++;
        i1++;
          goto _L7
_L2:
        i5 = getWidth();
        j1 = 0;
        i1 = i4 - 1;
        l1 = k2;
_L10:
        k2 = j1;
        l2 = l1;
        if (i1 < 0) goto _L4; else goto _L8
_L8:
        obj = getChildAt(i1);
        k2 = j1;
        l2 = l1;
        if (((View) (obj)).getLeft() <= i5 - j2) goto _L4; else goto _L9
_L9:
        l1 = l3 + i1;
        if (l1 >= j4 && l1 < k4)
        {
            m.a(((View) (obj)), l1);
        }
        j1++;
        l1 = i1;
        i1--;
          goto _L10
    }

    int c(int i1)
    {
        int k1 = getChildCount();
        if (k1 == 0)
        {
            i1 = -1;
        } else
        {
            int j1 = b(i1);
            i1 = j1;
            if (j1 == -1)
            {
                return (S + k1) - 1;
            }
        }
        return i1;
    }

    public boolean c()
    {
        return H;
    }

    boolean c(View view, int i1, long l1)
    {
        boolean flag1;
        if (a == 3)
        {
            flag1 = true;
        } else
        {
            boolean flag;
            if (af != null)
            {
                flag1 = af.a(this, view, i1, l1);
            } else
            {
                flag1 = false;
            }
            flag = flag1;
            if (!flag1)
            {
                av = b(view, i1, l1);
                flag = super.showContextMenuForChild(this);
            }
            flag1 = flag;
            if (flag)
            {
                performHapticFeedback(0);
                return flag;
            }
        }
        return flag1;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof e;
    }

    protected int computeHorizontalScrollExtent()
    {
        int k1 = getChildCount();
        if (k1 > 0)
        {
            if (at)
            {
                int j1 = k1 * 100;
                View view = getChildAt(0);
                int l1 = view.getLeft();
                int i2 = view.getWidth();
                int i1 = j1;
                if (i2 > 0)
                {
                    i1 = j1 + (l1 * 100) / i2;
                }
                view = getChildAt(k1 - 1);
                k1 = view.getRight();
                l1 = view.getWidth();
                j1 = i1;
                if (l1 > 0)
                {
                    j1 = i1 - ((k1 - getWidth()) * 100) / l1;
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

    protected int computeHorizontalScrollOffset()
    {
        int l1;
        int i2;
        int j2;
label0:
        {
            l1 = 0;
            boolean flag = false;
            i2 = S;
            j2 = getChildCount();
            int i1 = ((flag) ? 1 : 0);
            if (i2 >= 0)
            {
                i1 = ((flag) ? 1 : 0);
                if (j2 > 0)
                {
                    if (!at)
                    {
                        break label0;
                    }
                    View view = getChildAt(0);
                    l1 = view.getLeft();
                    j2 = view.getWidth();
                    i1 = ((flag) ? 1 : 0);
                    if (j2 > 0)
                    {
                        i1 = Math.max((i2 * 100 - (l1 * 100) / j2) + (int)(((float)getScrollX() / (float)getWidth()) * (float)al * 100F), 0);
                    }
                }
            }
            return i1;
        }
        int k1 = al;
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

    protected int computeHorizontalScrollRange()
    {
        if (at)
        {
            int j1 = Math.max(al * 100, 0);
            int i1 = j1;
            if (getScrollX() != 0)
            {
                i1 = j1 + Math.abs((int)(((float)getScrollX() / (float)getWidth()) * (float)al * 100F));
            }
            return i1;
        } else
        {
            return al;
        }
    }

    void d()
    {
        if (getChildCount() > 0)
        {
            e();
            requestLayout();
            invalidate();
        }
    }

    public void d(int i1)
    {
        int k1 = getChildCount();
        for (int j1 = 0; j1 < k1; j1++)
        {
            getChildAt(j1).offsetLeftAndRight(i1);
        }

    }

    protected void dispatchDraw(Canvas canvas)
    {
        boolean flag = i;
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

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (aP != null)
        {
            int i1 = getScrollX();
            if (!aP.a())
            {
                int j1 = canvas.save();
                int l1 = r.top + aV;
                int j2 = r.bottom;
                int l2 = aW;
                int j3 = getHeight();
                int l3 = Math.min(0, aR + i1);
                canvas.translate(l3, l1);
                aP.a(getWidth(), j3 - l1 - (j2 + l2));
                if (aP.a(canvas))
                {
                    aP.b(l3, l1);
                    invalidate(aP.a(false));
                }
                canvas.restoreToCount(j1);
            }
            if (!aQ.a())
            {
                int k1 = canvas.save();
                int k2 = r.top + aV;
                int i3 = r.bottom;
                int k3 = aW;
                int i2 = getWidth();
                i3 = getHeight() - k2 - (i3 + k3);
                i1 = Math.max(i2, i1 + aS);
                k2 += -i3;
                canvas.translate(i1, k2);
                canvas.rotate(180F, 0.0F, i3);
                aQ.a(i2, i3);
                if (aQ.a(canvas))
                {
                    aQ.b(i1, k2 + i3);
                    invalidate(aQ.a(true));
                }
                canvas.restoreToCount(k1);
            }
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        k();
    }

    void e()
    {
        removeAllViewsInLayout();
        S = 0;
        ag = false;
        L = null;
        aa = false;
        ba = null;
        an = -1;
        ao = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        G = 0;
        k = -1;
        l.setEmpty();
        invalidate();
    }

    protected void f()
    {
    }

    void g()
    {
        boolean flag1 = true;
        boolean flag = false;
        int i1;
        if (t != null)
        {
            int j1;
            if (S > 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            j1 = i1;
            if (i1 == 0)
            {
                j1 = i1;
                View view;
                if (getChildCount() > 0)
                {
                    if (getChildAt(0).getLeft() < r.left)
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                }
            }
            view = t;
            if (j1 != 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
        if (u != null)
        {
            j1 = getChildCount();
            if (S + j1 < al)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0 && j1 > 0)
            {
                if (getChildAt(j1 - 1).getRight() > getRight() - r.right)
                {
                    i1 = ((flag1) ? 1 : 0);
                } else
                {
                    i1 = 0;
                }
            }
            view = u;
            if (i1 != 0)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new e(-1, -2, 0);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new e(layoutparams);
    }

    public int getCacheColorHint()
    {
        return aF;
    }

    public int getCheckedItemCount()
    {
        return b;
    }

    public long[] getCheckedItemIds()
    {
        int i1 = 0;
        if (a != 0 && d != null && g != null) goto _L2; else goto _L1
_L1:
        long al[] = new long[0];
_L4:
        return al;
_L2:
        LongSparseArray longsparsearray = d;
        int j1 = longsparsearray.size();
        long al1[] = new long[j1];
        do
        {
            al = al1;
            if (i1 >= j1)
            {
                continue;
            }
            al1[i1] = longsparsearray.keyAt(i1);
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getCheckedItemPosition()
    {
        if (a == 1 && c != null && c.size() == 1)
        {
            return c.keyAt(0);
        } else
        {
            return -1;
        }
    }

    public SparseBooleanArray getCheckedItemPositions()
    {
        if (a != 0)
        {
            return c;
        } else
        {
            return null;
        }
    }

    public int getChoiceMode()
    {
        return a;
    }

    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo()
    {
        return av;
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

    protected float getLeftFadingEdgeStrength()
    {
        int i1 = getChildCount();
        float f1 = super.getLeftFadingEdgeStrength();
        if (i1 != 0)
        {
            if (S > 0)
            {
                return 1.0F;
            }
            int j1 = getChildAt(0).getLeft();
            float f2 = getVerticalFadingEdgeLength();
            if (j1 < getPaddingLeft())
            {
                return (float)(-(j1 - getPaddingLeft())) / f2;
            }
        }
        return f1;
    }

    public int getListPaddingBottom()
    {
        return r.bottom;
    }

    public int getListPaddingLeft()
    {
        return r.left;
    }

    public int getListPaddingRight()
    {
        return r.right;
    }

    public int getListPaddingTop()
    {
        return r.top;
    }

    protected float getRightFadingEdgeStrength()
    {
        int i1 = getChildCount();
        float f1 = super.getRightFadingEdgeStrength();
        if (i1 != 0)
        {
            if ((S + i1) - 1 < al - 1)
            {
                return 1.0F;
            }
            i1 = getChildAt(i1 - 1).getRight();
            int j1 = getWidth();
            float f2 = getVerticalFadingEdgeLength();
            if (i1 > j1 - getPaddingRight())
            {
                return (float)((i1 - j1) + getPaddingRight()) / f2;
            }
        }
        return f1;
    }

    public View getSelectedView()
    {
        if (al > 0 && aj >= 0)
        {
            return getChildAt(aj - S);
        } else
        {
            return null;
        }
    }

    public Drawable getSelector()
    {
        return j;
    }

    public int getSolidColor()
    {
        return aF;
    }

    public int getTranscriptMode()
    {
        return aE;
    }

    protected float getVerticalScrollFactor()
    {
        if (R == 0.0F)
        {
            TypedValue typedvalue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(0x101004d, typedvalue, true))
            {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            R = typedvalue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return R;
    }

    boolean h()
    {
        switch (C)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    boolean i()
    {
        return hasFocus() && !isInTouchMode() || h();
    }

    void j()
    {
        if (isEnabled() && isClickable()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Drawable drawable;
        drawable = j;
        Object obj = l;
        if (drawable == null || !isFocused() && !h() || ((Rect) (obj)).isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = getChildAt(aj - S);
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((View) (obj)).hasFocusable())
        {
            continue; /* Loop/switch isn't completed */
        }
        ((View) (obj)).setPressed(true);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        setPressed(true);
        boolean flag = isLongClickable();
        drawable = drawable.getCurrent();
        if (drawable != null && (drawable instanceof TransitionDrawable))
        {
            if (flag)
            {
                ((TransitionDrawable)drawable).startTransition(ViewConfiguration.getLongPressTimeout());
            } else
            {
                ((TransitionDrawable)drawable).resetTransition();
            }
        }
        if (flag && !ag)
        {
            if (aB == null)
            {
                aB = new a(this);
            }
            aB.a();
            postDelayed(aB, ViewConfiguration.getLongPressTimeout());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void jumpDrawablesToCurrentState()
    {
        super.jumpDrawablesToCurrentState();
        if (j != null)
        {
            j.jumpToCurrentState();
        }
    }

    void k()
    {
label0:
        {
            if (j != null)
            {
                if (!i())
                {
                    break label0;
                }
                j.setState(getDrawableState());
            }
            return;
        }
        j.setState(new int[] {
            0
        });
    }

    void l()
    {
        if (aj != -1)
        {
            if (e != 4)
            {
                J = aj;
            }
            if (ah >= 0 && ah != aj)
            {
                J = ah;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            G = 0;
        }
    }

    int m()
    {
        int j1 = aj;
        int i1 = j1;
        if (j1 < 0)
        {
            i1 = J;
        }
        return Math.min(Math.max(0, i1), al - 1);
    }

    boolean n()
    {
        if (aj < 0 && o())
        {
            k();
            return true;
        } else
        {
            return false;
        }
    }

    boolean o()
    {
        int i1;
        int j1;
        int k1;
        int l2;
        int i3;
        boolean flag1;
        flag1 = true;
        i3 = getChildCount();
        if (i3 <= 0)
        {
            return false;
        }
        i1 = r.left;
        j1 = getRight() - getLeft() - r.right;
        l2 = S;
        k1 = J;
        if (k1 < l2 || k1 >= l2 + i3) goto _L2; else goto _L1
_L1:
        boolean flag;
        View view = getChildAt(k1 - S);
        int l1 = view.getLeft();
        int j2 = view.getRight();
        if (l1 < i1)
        {
            i1 = getVerticalFadingEdgeLength() + i1;
        } else
        {
            i1 = l1;
            if (j2 > j1)
            {
                i1 = j1 - view.getMeasuredHeight() - getVerticalFadingEdgeLength();
            }
        }
        flag = true;
        j1 = k1;
_L7:
        J = -1;
        removeCallbacks(ar);
        if (F != null)
        {
            F.a();
        }
        C = -1;
        F();
        T = i1;
        i1 = a(j1, flag);
        View view1;
        int i2;
        int j3;
        int k3;
        if (i1 >= l2 && i1 <= getLastVisiblePosition())
        {
            e = 4;
            k();
            setSelectionInt(i1);
            b();
        } else
        {
            i1 = -1;
        }
        a(0);
        if (i1 >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return flag;
_L2:
        if (k1 >= l2) goto _L4; else goto _L3
_L3:
        i2 = 0;
        j1 = 0;
_L8:
        if (i2 >= i3)
        {
            break MISSING_BLOCK_LABEL_488;
        }
        k1 = getChildAt(i2).getLeft();
        int k2;
        if (i2 == 0)
        {
            if (l2 > 0 || k1 < i1)
            {
                i1 = getVerticalFadingEdgeLength() + i1;
                j1 = k1;
            } else
            {
                j1 = k1;
            }
        }
        if (k1 < i1) goto _L6; else goto _L5
_L5:
        i1 = l2 + i2;
_L10:
        flag = true;
        j1 = i1;
        i1 = k1;
          goto _L7
_L6:
        i2++;
          goto _L8
_L4:
        j3 = al;
        i2 = i3 - 1;
        i1 = 0;
_L9:
label0:
        {
            if (i2 < 0)
            {
                break MISSING_BLOCK_LABEL_465;
            }
            view1 = getChildAt(i2);
            k1 = view1.getLeft();
            k3 = view1.getRight();
            if (i2 == i3 - 1)
            {
                if (l2 + i3 < j3 || k3 > j1)
                {
                    i1 = j1 - getVerticalFadingEdgeLength();
                    j1 = k1;
                } else
                {
                    i1 = j1;
                    j1 = k1;
                }
            } else
            {
                k2 = i1;
                i1 = j1;
                j1 = k2;
            }
            if (k3 > i1)
            {
                break label0;
            }
            i1 = k1;
            j1 = l2 + i2;
            flag = false;
        }
          goto _L7
        i2--;
        k1 = i1;
        i1 = j1;
        j1 = k1;
          goto _L9
        j1 = (l2 + i3) - 1;
        flag = false;
          goto _L7
        i1 = l2;
        k1 = j1;
          goto _L10
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (g != null && f == null)
        {
            f = new n(this);
            g.registerDataSetObserver(f);
            ag = true;
            am = al;
            al = g.getCount();
        }
        P = true;
    }

    protected int[] onCreateDrawableState(int i1)
    {
        if (!aG) goto _L2; else goto _L1
_L1:
        int ai[] = super.onCreateDrawableState(i1);
_L5:
        return ai;
_L2:
        int ai1[];
        int j1;
        j1 = ENABLED_STATE_SET[0];
        ai1 = super.onCreateDrawableState(i1 + 1);
        i1 = ai1.length - 1;
_L6:
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (ai1[i1] != j1) goto _L4; else goto _L3
_L3:
        ai = ai1;
        if (i1 >= 0)
        {
            System.arraycopy(ai1, i1 + 1, ai1, i1, ai1.length - i1 - 1);
            return ai1;
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
        m.b();
        if (g != null)
        {
            g.unregisterDataSetObserver(f);
            f = null;
        }
        if (ar != null)
        {
            removeCallbacks(ar);
        }
        if (F != null)
        {
            F.a();
        }
        if (aK != null)
        {
            removeCallbacks(aK);
        }
        if (aC != null)
        {
            removeCallbacks(aC);
        }
        if (aD != null)
        {
            removeCallbacks(aD);
            aD = null;
        }
        P = false;
    }

    protected void onFocusChanged(boolean flag, int i1, Rect rect)
    {
        super.onFocusChanged(flag, i1, rect);
        if (flag && aj < 0 && !isInTouchMode())
        {
            if (!P && g != null)
            {
                ag = true;
                am = al;
                al = g.getCount();
            }
            o();
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if ((motionevent.getSource() & 2) == 0) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 8 8: default 32
    //                   8 38;
           goto _L2 _L3
_L2:
        return super.onGenericMotionEvent(motionevent);
_L3:
        float f1;
        int i1;
        if (C == -1 && (f1 = motionevent.getAxisValue(9)) != 0.0F && !b(i1 = (int)(f1 * getVerticalScrollFactor()), i1))
        {
            return true;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        i1 = motionevent.getAction();
        if (F != null)
        {
            F.a();
        }
        if (P) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (i1 & 0xff)
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            return false;

        case 0: // '\0'
            int j1 = C;
            if (j1 == 6 || j1 == 5)
            {
                E = 0;
                return true;
            }
            int l1 = (int)motionevent.getX();
            int j2 = (int)motionevent.getY();
            aO = motionevent.getPointerId(0);
            int k2 = b(l1);
            if (j1 != 4 && k2 >= 0)
            {
                y = getChildAt(k2 - S).getLeft();
                A = l1;
                B = j2;
                x = k2;
                C = 0;
                F();
            }
            D = 0x80000000;
            B();
            aq.addMovement(motionevent);
            if (j1 == 4)
            {
                return true;
            }
            break;

        case 2: // '\002'
            int i2;
            switch (C)
            {
            default:
                return false;

            case 0: // '\0'
                i2 = motionevent.findPointerIndex(aO);
                break;
            }
            int k1 = i2;
            if (i2 == -1)
            {
                aO = motionevent.getPointerId(0);
                k1 = 0;
            }
            k1 = (int)motionevent.getX(k1);
            C();
            aq.addMovement(motionevent);
            if (f(k1))
            {
                return true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            C = -1;
            aO = -1;
            D();
            a(0);
            return false;

        case 6: // '\006'
            a(motionevent);
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        boolean flag = true;
        i1;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 37
    //                   66: 37;
           goto _L1 _L2 _L2
_L1:
        flag = super.onKeyUp(i1, keyevent);
_L4:
        return flag;
_L2:
        if (!isEnabled()) goto _L4; else goto _L3
_L3:
        if (isClickable() && isPressed() && aj >= 0 && g != null && aj < g.getCount())
        {
            keyevent = getChildAt(aj - S);
            if (keyevent != null)
            {
                a(keyevent, aj, ak);
                keyevent.setPressed(false);
            }
            setPressed(false);
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        ac = true;
        if (flag)
        {
            l1 = getChildCount();
            for (j1 = 0; j1 < l1; j1++)
            {
                getChildAt(j1).forceLayout();
            }

            m.a();
        }
        f();
        ac = false;
        K = (k1 - i1) / 3;
    }

    protected void onMeasure(int i1, int j1)
    {
        if (j == null)
        {
            A();
        }
        Rect rect = r;
        rect.left = n + getPaddingLeft();
        rect.top = o + getPaddingTop();
        rect.right = p + getPaddingRight();
        rect.bottom = q + getPaddingBottom();
        if (aE == 1)
        {
            int k1 = getChildCount();
            j1 = getWidth() - getPaddingRight();
            View view = getChildAt(k1 - 1);
            boolean flag;
            if (view != null)
            {
                i1 = view.getRight();
            } else
            {
                i1 = j1;
            }
            if (k1 + S >= aZ && i1 <= j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aU = flag;
        }
    }

    protected void onOverScrolled(int i1, int j1, boolean flag, boolean flag1)
    {
        j1 = getScrollX();
        int k1 = getScrollY();
        if (j1 != i1)
        {
            onScrollChanged(i1, k1, j1, k1);
            a(this, i1);
            awakenScrollBars();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        ag = true;
        W = ((SavedState) (parcelable)).e;
        if (((SavedState) (parcelable)).a < 0L) goto _L2; else goto _L1
_L1:
        aa = true;
        ba = parcelable;
        V = ((SavedState) (parcelable)).a;
        U = ((SavedState) (parcelable)).d;
        T = ((SavedState) (parcelable)).c;
        ab = 0;
_L4:
        if (((SavedState) (parcelable)).i != null)
        {
            c = ((SavedState) (parcelable)).i;
        }
        if (((SavedState) (parcelable)).j != null)
        {
            d = ((SavedState) (parcelable)).j;
        }
        b = ((SavedState) (parcelable)).h;
        requestLayout();
        return;
_L2:
        if (((SavedState) (parcelable)).b >= 0L)
        {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            k = -1;
            aa = true;
            ba = parcelable;
            V = ((SavedState) (parcelable)).b;
            U = ((SavedState) (parcelable)).d;
            T = ((SavedState) (parcelable)).c;
            ab = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Parcelable onSaveInstanceState()
    {
        boolean flag = false;
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (ba != null)
        {
            savedstate.a = ba.a;
            savedstate.b = ba.b;
            savedstate.c = ba.c;
            savedstate.d = ba.d;
            savedstate.e = ba.e;
            savedstate.f = ba.f;
            savedstate.g = ba.g;
            savedstate.h = ba.h;
            savedstate.i = ba.i;
            savedstate.j = ba.j;
            return savedstate;
        }
        int i1;
        long l2;
        if (getChildCount() > 0 && al > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        l2 = getSelectedItemId();
        savedstate.a = l2;
        savedstate.e = getHeight();
        if (l2 >= 0L)
        {
            savedstate.c = G;
            savedstate.d = getSelectedItemPosition();
            savedstate.b = -1L;
        } else
        if (i1 != 0 && S > 0)
        {
            savedstate.c = getChildAt(0).getLeft();
            int l1 = S;
            int j1 = l1;
            if (l1 >= al)
            {
                j1 = al - 1;
            }
            savedstate.d = j1;
            savedstate.b = g.getItemId(j1);
        } else
        {
            savedstate.c = 0;
            savedstate.b = -1L;
            savedstate.d = 0;
        }
        savedstate.f = null;
        savedstate.g = false;
        if (c != null)
        {
            savedstate.i = c.clone();
        }
        if (d != null)
        {
            LongSparseArray longsparsearray = new LongSparseArray();
            int k1 = d.size();
            for (i1 = ((flag) ? 1 : 0); i1 < k1; i1++)
            {
                longsparsearray.put(d.keyAt(i1), d.valueAt(i1));
            }

            savedstate.j = longsparsearray;
        }
        savedstate.h = b;
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (getChildCount() > 0)
        {
            ag = true;
            w();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        i1 = 0;
        if (!isEnabled())
        {
            boolean flag;
            if (isClickable() || isLongClickable())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }
        if (F != null)
        {
            F.a();
        }
        if (!P)
        {
            return false;
        }
        j1 = motionevent.getAction();
        C();
        aq.addMovement(motionevent);
        j1 & 0xff;
        JVM INSTR tableswitch 0 6: default 124
    //                   0 126
    //                   1 527
    //                   2 420
    //                   3 1381
    //                   4 124
    //                   5 1583
    //                   6 1523;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return true;
_L2:
        switch (C)
        {
        default:
            aO = motionevent.getPointerId(0);
            int k1 = (int)motionevent.getX();
            int i2 = (int)motionevent.getY();
            i1 = a(k1, i2);
            if (!ag)
            {
                if (C != 4 && i1 >= 0 && ((ListAdapter)getAdapter()).isEnabled(i1))
                {
                    C = 0;
                    if (aA == null)
                    {
                        aA = new c(this);
                    }
                    postDelayed(aA, ViewConfiguration.getTapTimeout());
                } else
                if (C == 4)
                {
                    E();
                    C = 3;
                    E = 0;
                    i1 = b(k1);
                    ar.c();
                }
            }
            if (i1 >= 0)
            {
                y = getChildAt(i1 - S).getLeft();
            }
            A = k1;
            B = i2;
            x = i1;
            D = 0x80000000;
            return true;

        case 6: // '\006'
            ar.b();
            if (F != null)
            {
                F.a();
            }
            C = 5;
            i1 = (int)motionevent.getX();
            D = i1;
            A = i1;
            B = (int)motionevent.getY();
            E = 0;
            aO = motionevent.getPointerId(0);
            aT = 0;
            return true;
        }
_L4:
        int l1 = motionevent.findPointerIndex(aO);
        float f1;
        View view;
        g g1;
        Handler handler;
        int j2;
        int k2;
        int l2;
        int i3;
        if (l1 == -1)
        {
            aO = motionevent.getPointerId(0);
        } else
        {
            i1 = l1;
        }
        i1 = (int)motionevent.getX(i1);
        if (ag)
        {
            f();
        }
        switch (C)
        {
        case 4: // '\004'
        default:
            return true;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            f(i1);
            return true;

        case 3: // '\003'
        case 5: // '\005'
            g(i1);
            break;
        }
        return true;
_L3:
        C;
        JVM INSTR tableswitch 0 5: default 568
    //                   0 626
    //                   1 626
    //                   2 626
    //                   3 1003
    //                   4 568
    //                   5 1294;
           goto _L8 _L9 _L9 _L9 _L10 _L8 _L11
_L8:
        setPressed(false);
        if (aP != null)
        {
            aP.c();
            aQ.c();
        }
        invalidate();
        motionevent = getHandler();
        if (motionevent != null)
        {
            motionevent.removeCallbacks(az);
        }
        D();
        aO = -1;
        return true;
_L9:
        l1 = x;
        view = getChildAt(l1 - S);
        f1 = motionevent.getY();
        if (f1 > (float)r.top && f1 < (float)(getHeight() - r.bottom))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (view != null && !view.hasFocusable() && i1 != 0)
        {
            if (C != 0)
            {
                view.setPressed(false);
            }
            if (aC == null)
            {
                aC = new g(this);
            }
            g1 = aC;
            g1.a = l1;
            g1.a();
            J = l1;
            if (C == 0 || C == 1)
            {
                handler = getHandler();
                if (handler != null)
                {
                    if (C == 0)
                    {
                        motionevent = aA;
                    } else
                    {
                        motionevent = az;
                    }
                    handler.removeCallbacks(motionevent);
                }
                e = 0;
                if (!ag && g.isEnabled(l1))
                {
                    C = 1;
                    setSelectedPositionInt(x);
                    f();
                    view.setPressed(true);
                    a(x, view);
                    setPressed(true);
                    if (j != null)
                    {
                        motionevent = j.getCurrent();
                        if (motionevent != null && (motionevent instanceof TransitionDrawable))
                        {
                            ((TransitionDrawable)motionevent).resetTransition();
                        }
                    }
                    if (aD != null)
                    {
                        removeCallbacks(aD);
                    }
                    aD = new Runnable(view, g1) {

                        final View a;
                        final g b;
                        final AbsListView c;

                        public void run()
                        {
                            c.C = -1;
                            a.setPressed(false);
                            c.setPressed(false);
                            if (!c.ag)
                            {
                                b.run();
                            }
                        }

            
            {
                c = AbsListView.this;
                a = view;
                b = g1;
                super();
            }
                    };
                    postDelayed(aD, ViewConfiguration.getPressedStateDuration());
                    return true;
                } else
                {
                    C = -1;
                    k();
                    return true;
                }
            }
            if (!ag && g.isEnabled(l1))
            {
                g1.run();
            }
        }
        C = -1;
        k();
          goto _L8
_L10:
        i1 = getChildCount();
        if (i1 > 0)
        {
            l1 = getChildAt(0).getLeft();
            j2 = getChildAt(i1 - 1).getRight();
            k2 = r.left;
            l2 = getWidth() - r.right;
            if (S == 0 && l1 >= k2 && S + i1 < al && j2 <= getWidth() - l2)
            {
                C = -1;
                a(0);
            } else
            {
                motionevent = aq;
                motionevent.computeCurrentVelocity(1000, aM);
                i3 = (int)(motionevent.getXVelocity(aO) * aN);
                if (Math.abs(i3) > aL && (S != 0 || l1 != k2 - N) && (i1 + S != al || j2 != N + l2))
                {
                    if (ar == null)
                    {
                        ar = new d(this);
                    }
                    a(2);
                    ar.a(-i3);
                } else
                {
                    C = -1;
                    a(0);
                    if (ar != null)
                    {
                        ar.b();
                    }
                    if (F != null)
                    {
                        F.a();
                    }
                }
            }
        } else
        {
            C = -1;
            a(0);
        }
          goto _L8
_L11:
        if (ar == null)
        {
            ar = new d(this);
        }
        motionevent = aq;
        motionevent.computeCurrentVelocity(1000, aM);
        i1 = (int)motionevent.getXVelocity(aO);
        a(2);
        if (Math.abs(i1) > aL)
        {
            ar.b(-i1);
        } else
        {
            ar.a();
        }
          goto _L8
_L5:
        C;
        JVM INSTR tableswitch 5 6: default 1408
    //                   5 1494
    //                   6 1466;
           goto _L12 _L13 _L14
_L14:
        break; /* Loop/switch isn't completed */
_L12:
        C = -1;
        setPressed(false);
        motionevent = getChildAt(x - S);
        if (motionevent != null)
        {
            motionevent.setPressed(false);
        }
        F();
        motionevent = getHandler();
        if (motionevent != null)
        {
            motionevent.removeCallbacks(az);
        }
        D();
_L15:
        if (aP != null)
        {
            aP.c();
            aQ.c();
        }
        aO = -1;
        return true;
_L13:
        if (ar == null)
        {
            ar = new d(this);
        }
        ar.a();
          goto _L15
_L7:
        a(motionevent);
        i1 = A;
        l1 = a(i1, B);
        if (l1 >= 0)
        {
            y = getChildAt(l1 - S).getLeft();
            x = l1;
        }
        D = i1;
        return true;
_L6:
        j2 = motionevent.getActionIndex();
        l1 = motionevent.getPointerId(j2);
        i1 = (int)motionevent.getX(j2);
        j2 = (int)motionevent.getY(j2);
        E = 0;
        aO = l1;
        A = i1;
        B = j2;
        l1 = a(i1, j2);
        if (l1 >= 0)
        {
            y = getChildAt(l1 - S).getLeft();
            x = l1;
        }
        D = i1;
        return true;
    }

    public void onTouchModeChanged(boolean flag)
    {
        if (flag)
        {
            l();
            if (getWidth() > 0 && getChildCount() > 0)
            {
                f();
            }
            k();
        } else
        {
            int i1 = C;
            if (i1 == 5 || i1 == 6)
            {
                if (ar != null)
                {
                    ar.b();
                }
                if (F != null)
                {
                    F.a();
                }
                if (getScrollX() != 0)
                {
                    a(this, 0);
                    G();
                    invalidate();
                    return;
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        int i1;
        super.onWindowFocusChanged(flag);
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
        if (ar != null)
        {
            removeCallbacks(ar);
            ar.b();
            if (F != null)
            {
                F.a();
            }
            if (getScrollX() != 0)
            {
                a(this, 0);
                G();
                invalidate();
            }
        }
        if (i1 == 1)
        {
            J = aj;
        }
_L4:
        aw = i1;
        return;
_L2:
        if (i1 != aw && aw != -1)
        {
            if (i1 == 1)
            {
                o();
            } else
            {
                l();
                e = 0;
                f();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void p()
    {
        int i1;
        c.clear();
        i1 = 0;
_L7:
        if (i1 >= d.size()) goto _L2; else goto _L1
_L1:
        int k1;
        long l1;
        l1 = d.keyAt(i1);
        k1 = ((Integer)d.valueAt(i1)).intValue();
        if (l1 == g.getItemId(k1)) goto _L4; else goto _L3
_L3:
        int j1;
        j1 = Math.max(0, k1 - 20);
        k1 = Math.min(k1 + 20, al);
_L8:
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (l1 != g.getItemId(j1)) goto _L6; else goto _L5
_L5:
        c.put(j1, true);
        d.setValueAt(i1, Integer.valueOf(j1));
        j1 = 1;
_L10:
        k1 = i1;
        if (j1 == 0)
        {
            d.delete(l1);
            k1 = i1 - 1;
            b = b - 1;
        }
_L9:
        i1 = k1 + 1;
          goto _L7
_L6:
        j1++;
          goto _L8
_L4:
        c.put(k1, true);
        k1 = i1;
          goto _L9
_L2:
        return;
        j1 = 0;
          goto _L10
    }

    protected void q()
    {
        int l2;
        int i3;
        l2 = al;
        i3 = aZ;
        aZ = al;
        if (a != 0 && g != null && g.hasStableIds())
        {
            p();
        }
        m.c();
        if (l2 <= 0) goto _L2; else goto _L1
_L1:
        if (!aa) goto _L4; else goto _L3
_L3:
        aa = false;
        ba = null;
        if (aE != 2) goto _L6; else goto _L5
_L5:
        e = 3;
_L10:
        return;
_L6:
        if (aE == 1)
        {
            if (aU)
            {
                aU = false;
                e = 3;
                return;
            }
            int j3 = getChildCount();
            int j2 = getWidth() - getPaddingRight();
            View view = getChildAt(j3 - 1);
            int i1;
            if (view != null)
            {
                i1 = view.getRight();
            } else
            {
                i1 = j2;
            }
            if (j3 + S >= i3 && i1 <= j2)
            {
                e = 3;
                return;
            }
            awakenScrollBars();
        }
        ab;
        JVM INSTR tableswitch 0 1: default 212
    //                   0 262
    //                   1 350;
           goto _L4 _L7 _L8
_L4:
        int k2;
        if (isInTouchMode())
        {
            continue; /* Loop/switch isn't completed */
        }
        k2 = getSelectedItemPosition();
        int j1 = k2;
        if (k2 >= l2)
        {
            j1 = l2 - 1;
        }
        k2 = j1;
        if (j1 < 0)
        {
            k2 = 0;
        }
        j1 = a(k2, true);
        if (j1 >= 0)
        {
            setNextSelectedPositionInt(j1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (isInTouchMode())
        {
            e = 5;
            U = Math.min(Math.max(0, U), l2 - 1);
            return;
        }
        int k1 = v();
        if (k1 >= 0 && a(k1, true) == k1)
        {
            U = k1;
            if (W == (long)getHeight())
            {
                e = 5;
            } else
            {
                e = 2;
            }
            setNextSelectedPositionInt(k1);
            return;
        }
        if (true) goto _L4; else goto _L9
_L8:
        e = 5;
        U = Math.min(Math.max(0, U), l2 - 1);
        return;
_L9:
        int l1 = a(k2, false);
        if (l1 >= 0)
        {
            setNextSelectedPositionInt(l1);
            return;
        }
        break; /* Loop/switch isn't completed */
        if (J >= 0) goto _L10; else goto _L2
_L2:
        int i2;
        if (H)
        {
            i2 = 3;
        } else
        {
            i2 = 1;
        }
        e = i2;
        aj = -1;
        ak = 0x8000000000000000L;
        ah = -1;
        ai = 0x8000000000000000L;
        aa = false;
        ba = null;
        k = -1;
        u();
        return;
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        if (flag)
        {
            D();
        }
        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!ap && !ac)
        {
            super.requestLayout();
        }
    }

    public void sendAccessibilityEvent(int i1)
    {
        if (i1 == 4096)
        {
            int j1 = getFirstVisiblePosition();
            int k1 = getLastVisiblePosition();
            if (aX == j1 && aY == k1)
            {
                return;
            }
            aX = j1;
            aY = k1;
        }
        super.sendAccessibilityEvent(i1);
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (listadapter != null)
        {
            h = g.hasStableIds();
            if (a != 0 && h && d == null)
            {
                d = new LongSparseArray();
            }
        }
        if (c != null)
        {
            c.clear();
        }
        if (d != null)
        {
            d.clear();
        }
    }

    public void setCacheColorHint(int i1)
    {
        if (i1 != aF)
        {
            aF = i1;
            int k1 = getChildCount();
            for (int j1 = 0; j1 < k1; j1++)
            {
                getChildAt(j1).setDrawingCacheBackgroundColor(i1);
            }

            m.f(i1);
        }
    }

    public void setChoiceMode(int i1)
    {
        a = i1;
        if (a != 0)
        {
            if (c == null)
            {
                c = new SparseBooleanArray();
            }
            if (d == null && g != null && g.hasStableIds())
            {
                d = new LongSparseArray();
            }
            if (a == 3)
            {
                a();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean flag)
    {
        i = flag;
    }

    public void setFriction(float f1)
    {
        if (ar == null)
        {
            ar = new d(this);
        }
        com.cyberlink.you.widgetpool.clhorizontalgridview.d.a(ar).a(f1);
    }

    public void setOnScrollListener(f f1)
    {
        as = f1;
        b();
    }

    public void setOverScrollMode(int i1)
    {
        if (i1 != 2)
        {
            if (aP == null)
            {
                Context context = getContext();
                aP = new com.cyberlink.you.widgetpool.clhorizontalgridview.t(context);
                aQ = new com.cyberlink.you.widgetpool.clhorizontalgridview.t(context);
            }
        } else
        {
            aP = null;
            aQ = null;
        }
        super.setOverScrollMode(i1);
    }

    public void setRecyclerListener(j j1)
    {
        com.cyberlink.you.widgetpool.clhorizontalgridview.i.a(m, j1);
    }

    public void setScrollingCacheEnabled(boolean flag)
    {
        if (I && !flag)
        {
            F();
        }
        I = flag;
    }

    abstract void setSelectionInt(int i1);

    public void setSelector(int i1)
    {
        setSelector(getResources().getDrawable(i1));
    }

    public void setSelector(Drawable drawable)
    {
        if (j != null)
        {
            j.setCallback(null);
            unscheduleDrawable(j);
        }
        j = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        n = rect.left;
        o = rect.top;
        p = rect.right;
        q = rect.bottom;
        drawable.setCallback(this);
        k();
    }

    public void setSmoothScrollbarEnabled(boolean flag)
    {
        at = flag;
    }

    public void setStackFromRight(boolean flag)
    {
        if (H != flag)
        {
            H = flag;
            d();
        }
    }

    public void setTranscriptMode(int i1)
    {
        aE = i1;
    }

    public void setVelocityScale(float f1)
    {
        aN = f1;
    }

    public boolean showContextMenuForChild(View view)
    {
        boolean flag = false;
        boolean flag1 = false;
        int i1 = a(view);
        if (i1 >= 0)
        {
            long l1 = g.getItemId(i1);
            if (af != null)
            {
                flag1 = af.a(this, view, i1, l1);
            }
            flag = flag1;
            if (!flag1)
            {
                av = b(getChildAt(i1 - S), i1, l1);
                flag = super.showContextMenuForChild(view);
            }
        }
        return flag;
    }

    public boolean verifyDrawable(Drawable drawable)
    {
        return j == drawable || super.verifyDrawable(drawable);
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        long a;
        long b;
        int c;
        int d;
        int e;
        String f;
        boolean g;
        int h;
        SparseBooleanArray i;
        LongSparseArray j;

        public String toString()
        {
            return (new StringBuilder()).append("AbsListView.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(a).append(" firstId=").append(b).append(" viewLeft=").append(c).append(" position=").append(d).append(" height=").append(e).append(" filter=").append(f).append(" checkState=").append(i).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            int j1 = 0;
            super.writeToParcel(parcel, i1);
            parcel.writeLong(a);
            parcel.writeLong(b);
            parcel.writeInt(c);
            parcel.writeInt(d);
            parcel.writeInt(e);
            parcel.writeString(f);
            if (g)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeByte((byte)i1);
            parcel.writeInt(h);
            parcel.writeSparseBooleanArray(i);
            if (j != null)
            {
                i1 = j.size();
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            for (; j1 < i1; j1++)
            {
                parcel.writeLong(j.keyAt(j1));
                parcel.writeInt(((Integer)j.valueAt(j1)).intValue());
            }

        }


        private SavedState(Parcel parcel)
        {
            int i1 = 0;
            super(parcel);
            a = parcel.readLong();
            b = parcel.readLong();
            c = parcel.readInt();
            d = parcel.readInt();
            e = parcel.readInt();
            f = parcel.readString();
            int j1;
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            g = flag;
            h = parcel.readInt();
            i = parcel.readSparseBooleanArray();
            j1 = parcel.readInt();
            if (j1 > 0)
            {
                j = new LongSparseArray();
                for (; i1 < j1; i1++)
                {
                    long l1 = parcel.readLong();
                    int k1 = parcel.readInt();
                    j.put(l1, Integer.valueOf(k1));
                }

            }
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

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
import com.cyberlink.youcammakeup.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            AdapterView, i, t, e, 
//            d, h, k, m, 
//            f, q, a, n, 
//            c, g, u, b, 
//            j

public abstract class AbsListView extends AdapterView
    implements android.view.ViewTreeObserver.OnTouchModeChangeListener
{

    static final Interpolator R = new LinearInterpolator();
    int A;
    int B;
    int C;
    int D;
    int E;
    int F;
    h G;
    int H;
    boolean I;
    boolean J;
    int K;
    int L;
    Runnable M;
    final boolean N[];
    int O;
    int P;
    boolean Q;
    float S;
    private VelocityTracker a;
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
    private t aP;
    private t aQ;
    private int aR;
    private int aS;
    private int aT;
    private boolean aU;
    private int aV;
    private int aW;
    private int aX;
    private int aY;
    private int aZ;
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
    int c;
    SparseBooleanArray d;
    LongSparseArray e;
    int f;
    n g;
    ListAdapter h;
    boolean i;
    boolean j;
    Drawable k;
    int l;
    Rect m;
    final i n;
    int o;
    int p;
    int q;
    int r;
    Rect s;
    int t;
    View u;
    View v;
    boolean w;
    boolean x;
    int y;
    int z;

    public AbsListView(Context context)
    {
        super(context);
        b = 0;
        f = 0;
        j = false;
        l = -1;
        m = new Rect();
        n = new i(this);
        o = 0;
        p = 0;
        q = 0;
        r = 0;
        s = new Rect();
        t = 0;
        D = -1;
        H = 0;
        at = true;
        K = -1;
        av = null;
        aw = -1;
        ax = false;
        ay = false;
        aH = 0;
        aN = 1.0F;
        N = new boolean[1];
        aO = -1;
        aT = 0;
        S = 0.0F;
        a();
    }

    public AbsListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101006a);
    }

    public AbsListView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = 0;
        f = 0;
        j = false;
        l = -1;
        m = new Rect();
        n = new i(this);
        o = 0;
        p = 0;
        q = 0;
        r = 0;
        s = new Rect();
        t = 0;
        D = -1;
        H = 0;
        at = true;
        K = -1;
        av = null;
        aw = -1;
        ax = false;
        ay = false;
        aH = 0;
        aN = 1.0F;
        N = new boolean[1];
        aO = -1;
        aT = 0;
        S = 0.0F;
        a();
        context = context.obtainStyledAttributes(attributeset, j.AbsListView, i1, 0);
        attributeset = context.getDrawable(0);
        if (attributeset != null)
        {
            setSelector(attributeset);
        }
        j = context.getBoolean(1, false);
        setStackFromRight(context.getBoolean(2, false));
        setScrollingCacheEnabled(context.getBoolean(3, true));
        setTranscriptMode(context.getInt(5, 0));
        setCacheColorHint(context.getColor(6, 0));
        setSmoothScrollbarEnabled(context.getBoolean(7, true));
        setChoiceMode(context.getInt(8, 0));
        context.recycle();
    }

    private boolean A()
    {
        int i1 = getChildCount();
        if (i1 != 0)
        {
            if (i1 != am)
            {
                return false;
            }
            if (getChildAt(0).getLeft() < s.left || getChildAt(i1 - 1).getRight() > getWidth() - s.right)
            {
                return false;
            }
        }
        return true;
    }

    private void B()
    {
        setSelector(getResources().getDrawable(0x1080062));
    }

    private void C()
    {
        if (a == null)
        {
            a = VelocityTracker.obtain();
            return;
        } else
        {
            a.clear();
            return;
        }
    }

    private void D()
    {
        if (a == null)
        {
            a = VelocityTracker.obtain();
        }
    }

    private void E()
    {
        if (a != null)
        {
            a.recycle();
            a = null;
        }
    }

    private void F()
    {
        if (J && !w && !b(this))
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            x = true;
            w = true;
        }
    }

    private void G()
    {
        if (!b(this))
        {
            if (aK == null)
            {
                aK = new Runnable() {

                    final AbsListView a;

                    public void run()
                    {
                        if (a.w)
                        {
                            AbsListView abslistview = a;
                            a.x = false;
                            abslistview.w = false;
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

    private void H()
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

    private void a()
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
        O = viewconfiguration.getScaledOverscrollDistance();
        P = viewconfiguration.getScaledOverflingDistance();
        aJ = getContext().getResources().getDisplayMetrics().density;
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        m.set(i1 - o, j1 - p, q + k1, r + l1);
    }

    private void a(Canvas canvas)
    {
        if (!m.isEmpty())
        {
            Drawable drawable = k;
            drawable.setBounds(m);
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
            B = (int)motionevent.getX(i1);
            C = (int)motionevent.getY(i1);
            F = 0;
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
        return abslistview.a;
    }

    static void e(AbsListView abslistview, View view, boolean flag)
    {
        abslistview.removeDetachedView(view, flag);
    }

    static int f(AbsListView abslistview)
    {
        return abslistview.aM;
    }

    static int g(AbsListView abslistview)
    {
        return abslistview.aL;
    }

    private boolean h(int i1)
    {
        int k1 = i1 - B;
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
            F();
            Object obj;
            if (flag)
            {
                D = 5;
                F = 0;
            } else
            {
                D = 3;
                int j1;
                if (k1 > 0)
                {
                    j1 = aI;
                } else
                {
                    j1 = -aI;
                }
                F = j1;
            }
            obj = getHandler();
            if (obj != null)
            {
                ((Handler) (obj)).removeCallbacks(az);
            }
            setPressed(false);
            obj = getChildAt(y - T);
            if (obj != null)
            {
                ((View) (obj)).setPressed(false);
            }
            b(1);
            obj = getParent();
            if (obj != null)
            {
                ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(true);
            }
            i(i1);
            return true;
        } else
        {
            return false;
        }
    }

    static boolean h(AbsListView abslistview)
    {
        return abslistview.A();
    }

    static t i(AbsListView abslistview)
    {
        return abslistview.aP;
    }

    private void i(int i1)
    {
        int j1;
        boolean flag;
        int k2;
        flag = false;
        k2 = i1 - B;
        int i2 = k2 - F;
        View view;
        if (E != 0x80000000)
        {
            j1 = i1 - E;
        } else
        {
            j1 = i2;
        }
        if (D != 3) goto _L2; else goto _L1
_L1:
        if (i1 == E) goto _L4; else goto _L3
_L3:
        int k1;
        int l1;
        boolean flag1;
        if (y >= 0)
        {
            k1 = y - T;
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
            flag1 = c(i2, j1);
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
        overScrollBy(j1, 0, getScrollX(), 0, 0, 0, O, 0, true);
        if (Math.abs(O) == Math.abs(getScrollX()) && a != null)
        {
            a.clear();
        }
        k1 = getOverScrollMode();
        if (k1 != 0 && (k1 != 1 || A())) goto _L8; else goto _L9
_L9:
        aT = 0;
        D = 5;
        if (k2 <= 0) goto _L11; else goto _L10
_L10:
        aP.a((float)j1 / (float)getWidth());
        if (!aQ.a())
        {
            aQ.c();
        }
        invalidate(aP.a(false));
_L8:
        B = i1;
_L6:
        E = i1;
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
        if (D != 5 || i1 == E) goto _L4; else goto _L12
_L12:
        j2 = getScrollX();
        l2 = j2 - j1;
        if (i1 > E)
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
        overScrollBy(j1, 0, getScrollX(), 0, 0, 0, O, 0, true);
        j2 = getOverScrollMode();
        if (j2 != 0 && (j2 != 1 || A())) goto _L14; else goto _L15
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
            c(l1, l1);
            D = 3;
            l1 = e(i1);
            F = 0;
            view1 = getChildAt(l1 - T);
            j1 = ((flag) ? 1 : 0);
            if (view1 != null)
            {
                j1 = view1.getLeft();
            }
            z = j1;
            B = i1;
            y = l1;
        }
        E = i1;
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

    static t j(AbsListView abslistview)
    {
        return abslistview.aQ;
    }

    static void k(AbsListView abslistview)
    {
        abslistview.G();
    }

    private void z()
    {
        int j1 = T;
        int k1 = getChildCount();
        for (int i1 = 0; i1 < k1; i1++)
        {
            View view = getChildAt(i1);
            if (view instanceof Checkable)
            {
                ((Checkable)view).setChecked(d.get(j1 + i1));
            }
        }

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
                return T + k1;
            }
        }

        return -1;
    }

    View a(int i1, boolean aflag[])
    {
        Object obj;
        aflag[0] = false;
        obj = n.d(i1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((View) (obj));
_L2:
        View view = n.e(i1);
        if (view == null) goto _L4; else goto _L3
_L3:
        obj = h.getView(i1, view, this);
        if (obj != view)
        {
            n.a(view, i1);
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
        if (i)
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
            obj.d = h.getItemId(i1);
            aflag.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            return aflag;
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj = h.getView(i1, null, this);
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

    void a(int i1, int j1, boolean flag)
    {
        if (ar == null)
        {
            ar = new d(this);
        }
        int k1 = T;
        int l1 = getChildCount();
        int i2 = getPaddingLeft();
        int j2 = getWidth();
        int k2 = getPaddingRight();
        if (i1 == 0 || am == 0 || l1 == 0 || k1 == 0 && getChildAt(0).getLeft() == i2 && i1 < 0 || k1 + l1 == am && getChildAt(l1 - 1).getRight() == j2 - k2 && i1 > 0)
        {
            ar.b();
            if (G != null)
            {
                G.a();
            }
            return;
        } else
        {
            b(2);
            ar.a(i1, j1, flag);
            return;
        }
    }

    void a(int i1, View view)
    {
        if (i1 != -1)
        {
            l = i1;
        }
        Rect rect = m;
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

    public void a(int i1, boolean flag)
    {
        if (b != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (b != 2 && b != 3)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag2 = d.get(i1);
        d.put(i1, flag);
        if (e != null && h.hasStableIds())
        {
            if (flag)
            {
                e.put(h.getItemId(i1), Integer.valueOf(i1));
            } else
            {
                e.delete(h.getItemId(i1));
            }
        }
        if (flag2 != flag)
        {
            if (flag)
            {
                c = c + 1;
            } else
            {
                c = c - 1;
            }
        }
_L4:
        if (!ad && !aq)
        {
            ah = true;
            y();
            requestLayout();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag1;
        if (e != null && h.hasStableIds())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || a(i1))
        {
            d.clear();
            if (flag1)
            {
                e.clear();
            }
        }
        if (flag)
        {
            d.put(i1, true);
            if (flag1)
            {
                e.put(h.getItemId(i1), Integer.valueOf(i1));
            }
            c = 1;
        } else
        if (d.size() == 0 || !d.valueAt(0))
        {
            c = 0;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    abstract void a(boolean flag);

    public boolean a(int i1)
    {
        if (b != 0 && d != null)
        {
            return d.get(i1);
        } else
        {
            return false;
        }
    }

    public boolean a(View view, int i1, long l1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag = false;
        flag2 = false;
        if (b == 0) goto _L2; else goto _L1
_L1:
        if (b != 2) goto _L4; else goto _L3
_L3:
        if (!d.get(i1, false))
        {
            flag2 = true;
        }
        d.put(i1, flag2);
        if (e != null && h.hasStableIds())
        {
            if (flag2)
            {
                e.put(h.getItemId(i1), Integer.valueOf(i1));
            } else
            {
                e.delete(h.getItemId(i1));
            }
        }
        if (flag2)
        {
            c = c + 1;
        } else
        {
            c = c - 1;
        }
        flag = true;
_L6:
        if (flag)
        {
            z();
        }
        flag = true;
_L2:
        return flag | super.a(view, i1, l1);
_L4:
        flag = flag1;
        if (b != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!d.get(i1, false))
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
        d.clear();
        d.put(i1, true);
        if (e != null && h.hasStableIds())
        {
            e.clear();
            e.put(h.getItemId(i1), Integer.valueOf(i1));
        }
        c = 1;
_L8:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        if (d.size() != 0 && d.valueAt(0)) goto _L8; else goto _L7
_L7:
        c = 0;
          goto _L8
    }

    public void addTouchables(ArrayList arraylist)
    {
        int j1 = getChildCount();
        int k1 = T;
        ListAdapter listadapter = h;
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

    android.view.ContextMenu.ContextMenuInfo b(View view, int i1, long l1)
    {
        return new m(view, i1, l1);
    }

    public void b()
    {
        if (d != null)
        {
            d.clear();
        }
        if (e != null)
        {
            e.clear();
        }
        c = 0;
    }

    void b(int i1)
    {
        if (i1 != aH && as != null)
        {
            aH = i1;
            as.a(this, i1);
        }
    }

    public void b(int i1, int j1)
    {
        a(i1, j1, false);
    }

    void c()
    {
        if (as != null)
        {
            as.a(this, T, getChildCount(), am);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public void c(int i1)
    {
        if (G == null)
        {
            G = new h(this);
        }
        G.a(i1);
    }

    boolean c(int i1, int j1)
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
        obj = s;
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
        l3 = T;
        if (l3 == 0)
        {
            aR = i3 - ((Rect) (obj)).left;
        } else
        {
            aR = aR + j2;
        }
        if (l3 + i4 == am)
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
        if (l3 + i4 == am && j3 <= getWidth() - ((Rect) (obj)).right && j2 <= 0)
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
            m();
        }
        j4 = getHeaderViewsCount();
        k4 = am - getFooterViewsCount();
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
        A = z + i2;
        aq = true;
        if (k2 > 0)
        {
            detachViewsFromParent(l2, k2);
            n.d();
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        f(j2);
        if (flag)
        {
            T = k2 + T;
        }
        i1 = Math.abs(j2);
        if (0 - i3 < i1 || j3 - (k3 - 0) < i1)
        {
            a(flag);
        }
        int l1;
        int i5;
        if (!flag1 && ak != -1)
        {
            i1 = ak - T;
            if (i1 >= 0 && i1 < getChildCount())
            {
                a(ak, getChildAt(i1));
            }
        } else
        if (l != -1)
        {
            i1 = l - T;
            if (i1 >= 0 && i1 < getChildCount())
            {
                a(-1, getChildAt(i1));
            }
        } else
        {
            m.setEmpty();
        }
        aq = false;
        c();
        return false;
_L6:
        k2 = l3 + j1;
        if (k2 >= j4 && k2 < k4)
        {
            n.a(((View) (obj)), k2);
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
            n.a(((View) (obj)), l1);
        }
        j1++;
        l1 = i1;
        i1--;
          goto _L10
    }

    boolean c(View view, int i1, long l1)
    {
        boolean flag1;
        if (b == 3)
        {
            flag1 = true;
        } else
        {
            boolean flag;
            if (ag != null)
            {
                flag1 = ag.a(this, view, i1, l1);
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
            i2 = T;
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
                        i1 = Math.max((i2 * 100 - (l1 * 100) / j2) + (int)(((float)getScrollX() / (float)getWidth()) * (float)am * 100F), 0);
                    }
                }
            }
            return i1;
        }
        int k1 = am;
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
            int j1 = Math.max(am * 100, 0);
            int i1 = j1;
            if (getScrollX() != 0)
            {
                i1 = j1 + Math.abs((int)(((float)getScrollX() / (float)getWidth()) * (float)am * 100F));
            }
            return i1;
        } else
        {
            return am;
        }
    }

    abstract int d(int i1);

    public boolean d()
    {
        return I;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        boolean flag = j;
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
                int l1 = s.top + aV;
                int j2 = s.bottom;
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
                int k2 = s.top + aV;
                int i3 = s.bottom;
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
        l();
    }

    int e(int i1)
    {
        int k1 = getChildCount();
        if (k1 == 0)
        {
            i1 = -1;
        } else
        {
            int j1 = d(i1);
            i1 = j1;
            if (j1 == -1)
            {
                return (T + k1) - 1;
            }
        }
        return i1;
    }

    void e()
    {
        if (getChildCount() > 0)
        {
            f();
            requestLayout();
            invalidate();
        }
    }

    void f()
    {
        removeAllViewsInLayout();
        T = 0;
        ah = false;
        M = null;
        ab = false;
        ba = null;
        ao = -1;
        ap = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        H = 0;
        l = -1;
        m.setEmpty();
        invalidate();
    }

    public void f(int i1)
    {
        int k1 = getChildCount();
        for (int j1 = 0; j1 < k1; j1++)
        {
            getChildAt(j1).offsetLeftAndRight(i1);
        }

    }

    protected void g()
    {
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
        return c;
    }

    public long[] getCheckedItemIds()
    {
        int i1 = 0;
        if (b != 0 && e != null && h != null) goto _L2; else goto _L1
_L1:
        long al[] = new long[0];
_L4:
        return al;
_L2:
        LongSparseArray longsparsearray = e;
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
        if (b == 1 && d != null && d.size() == 1)
        {
            return d.keyAt(0);
        } else
        {
            return -1;
        }
    }

    public SparseBooleanArray getCheckedItemPositions()
    {
        if (b != 0)
        {
            return d;
        } else
        {
            return null;
        }
    }

    public int getChoiceMode()
    {
        return b;
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
            if (T > 0)
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
        return s.bottom;
    }

    public int getListPaddingLeft()
    {
        return s.left;
    }

    public int getListPaddingRight()
    {
        return s.right;
    }

    public int getListPaddingTop()
    {
        return s.top;
    }

    protected float getRightFadingEdgeStrength()
    {
        int i1 = getChildCount();
        float f1 = super.getRightFadingEdgeStrength();
        if (i1 != 0)
        {
            if ((T + i1) - 1 < am - 1)
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
        if (am > 0 && ak >= 0)
        {
            return getChildAt(ak - T);
        } else
        {
            return null;
        }
    }

    public Drawable getSelector()
    {
        return k;
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
        if (S == 0.0F)
        {
            TypedValue typedvalue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(0x101004d, typedvalue, true))
            {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            S = typedvalue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return S;
    }

    void h()
    {
        boolean flag1 = true;
        boolean flag = false;
        int i1;
        if (u != null)
        {
            int j1;
            if (T > 0)
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
                    if (getChildAt(0).getLeft() < s.left)
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                }
            }
            view = u;
            if (j1 != 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
        if (v != null)
        {
            j1 = getChildCount();
            if (T + j1 < am)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0 && j1 > 0)
            {
                if (getChildAt(j1 - 1).getRight() > getRight() - s.right)
                {
                    i1 = ((flag1) ? 1 : 0);
                } else
                {
                    i1 = 0;
                }
            }
            view = v;
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

    boolean i()
    {
        switch (D)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    boolean j()
    {
        return hasFocus() && !isInTouchMode() || i();
    }

    public void jumpDrawablesToCurrentState()
    {
        super.jumpDrawablesToCurrentState();
        if (k != null)
        {
            k.jumpToCurrentState();
        }
    }

    void k()
    {
        if (isEnabled() && isClickable()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Drawable drawable;
        drawable = k;
        Object obj = m;
        if (drawable == null || !isFocused() && !i() || ((Rect) (obj)).isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = getChildAt(ak - T);
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
        if (flag && !ah)
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

    void l()
    {
label0:
        {
            if (k != null)
            {
                if (!j())
                {
                    break label0;
                }
                k.setState(getDrawableState());
            }
            return;
        }
        k.setState(new int[] {
            0
        });
    }

    void m()
    {
        if (ak != -1)
        {
            if (f != 4)
            {
                K = ak;
            }
            if (ai >= 0 && ai != ak)
            {
                K = ai;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            H = 0;
        }
    }

    int n()
    {
        int j1 = ak;
        int i1 = j1;
        if (j1 < 0)
        {
            i1 = K;
        }
        return Math.min(Math.max(0, i1), am - 1);
    }

    public void o()
    {
        ah = true;
        y();
        requestLayout();
        invalidate();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (h != null && g == null)
        {
            g = new n(this);
            h.registerDataSetObserver(g);
            ah = true;
            an = am;
            am = h.getCount();
        }
        Q = true;
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
        n.b();
        if (h != null)
        {
            h.unregisterDataSetObserver(g);
            g = null;
        }
        if (ar != null)
        {
            removeCallbacks(ar);
        }
        if (G != null)
        {
            G.a();
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
        Q = false;
    }

    protected void onFocusChanged(boolean flag, int i1, Rect rect)
    {
        super.onFocusChanged(flag, i1, rect);
        if (flag && ak < 0 && !isInTouchMode())
        {
            if (!Q && h != null)
            {
                ah = true;
                an = am;
                am = h.getCount();
            }
            q();
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
        if (D == -1 && (f1 = motionevent.getAxisValue(9)) != 0.0F && !c(i1 = (int)(f1 * getVerticalScrollFactor()), i1))
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
        if (G != null)
        {
            G.a();
        }
        if (Q) goto _L2; else goto _L1
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
            int j1 = D;
            if (j1 == 6 || j1 == 5)
            {
                F = 0;
                return true;
            }
            int l1 = (int)motionevent.getX();
            int j2 = (int)motionevent.getY();
            aO = motionevent.getPointerId(0);
            int k2 = d(l1);
            if (j1 != 4 && k2 >= 0)
            {
                z = getChildAt(k2 - T).getLeft();
                B = l1;
                C = j2;
                y = k2;
                D = 0;
                G();
            }
            E = 0x80000000;
            C();
            a.addMovement(motionevent);
            if (j1 == 4)
            {
                return true;
            }
            break;

        case 2: // '\002'
            int i2;
            switch (D)
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
            D();
            a.addMovement(motionevent);
            if (h(k1))
            {
                return true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            D = -1;
            aO = -1;
            E();
            b(0);
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
        if (isClickable() && isPressed() && ak >= 0 && h != null && ak < h.getCount())
        {
            keyevent = getChildAt(ak - T);
            if (keyevent != null)
            {
                a(keyevent, ak, al);
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
        ad = true;
        if (flag)
        {
            l1 = getChildCount();
            for (j1 = 0; j1 < l1; j1++)
            {
                getChildAt(j1).forceLayout();
            }

            n.a();
        }
        g();
        ad = false;
        L = (k1 - i1) / 3;
    }

    protected void onMeasure(int i1, int j1)
    {
        if (k == null)
        {
            B();
        }
        Rect rect = s;
        rect.left = o + getPaddingLeft();
        rect.top = p + getPaddingTop();
        rect.right = q + getPaddingRight();
        rect.bottom = r + getPaddingBottom();
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
            if (k1 + T >= aZ && i1 <= j1)
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
        ah = true;
        aa = ((SavedState) (parcelable)).e;
        if (((SavedState) (parcelable)).a < 0L) goto _L2; else goto _L1
_L1:
        ab = true;
        ba = parcelable;
        W = ((SavedState) (parcelable)).a;
        V = ((SavedState) (parcelable)).d;
        U = ((SavedState) (parcelable)).c;
        ac = 0;
_L4:
        if (((SavedState) (parcelable)).i != null)
        {
            d = ((SavedState) (parcelable)).i;
        }
        if (((SavedState) (parcelable)).j != null)
        {
            e = ((SavedState) (parcelable)).j;
        }
        c = ((SavedState) (parcelable)).h;
        requestLayout();
        return;
_L2:
        if (((SavedState) (parcelable)).b >= 0L)
        {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            l = -1;
            ab = true;
            ba = parcelable;
            W = ((SavedState) (parcelable)).b;
            V = ((SavedState) (parcelable)).d;
            U = ((SavedState) (parcelable)).c;
            ac = 1;
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
        if (getChildCount() > 0 && am > 0)
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
            savedstate.c = H;
            savedstate.d = getSelectedItemPosition();
            savedstate.b = -1L;
        } else
        if (i1 != 0 && T > 0)
        {
            savedstate.c = getChildAt(0).getLeft();
            int l1 = T;
            int j1 = l1;
            if (l1 >= am)
            {
                j1 = am - 1;
            }
            savedstate.d = j1;
            savedstate.b = h.getItemId(j1);
        } else
        {
            savedstate.c = 0;
            savedstate.b = -1L;
            savedstate.d = 0;
        }
        savedstate.f = null;
        savedstate.g = false;
        if (d != null)
        {
            savedstate.i = d.clone();
        }
        if (e != null)
        {
            LongSparseArray longsparsearray = new LongSparseArray();
            int k1 = e.size();
            for (i1 = ((flag) ? 1 : 0); i1 < k1; i1++)
            {
                longsparsearray.put(e.keyAt(i1), e.valueAt(i1));
            }

            savedstate.j = longsparsearray;
        }
        savedstate.h = c;
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (getChildCount() > 0)
        {
            ah = true;
            y();
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
        if (G != null)
        {
            G.a();
        }
        if (!Q)
        {
            return false;
        }
        j1 = motionevent.getAction();
        D();
        a.addMovement(motionevent);
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
        switch (D)
        {
        default:
            aO = motionevent.getPointerId(0);
            int k1 = (int)motionevent.getX();
            int i2 = (int)motionevent.getY();
            i1 = a(k1, i2);
            if (!ah)
            {
                if (D != 4 && i1 >= 0 && ((ListAdapter)getAdapter()).isEnabled(i1))
                {
                    D = 0;
                    if (aA == null)
                    {
                        aA = new c(this);
                    }
                    postDelayed(aA, ViewConfiguration.getTapTimeout());
                } else
                if (D == 4)
                {
                    F();
                    D = 3;
                    F = 0;
                    i1 = d(k1);
                    ar.c();
                }
            }
            if (i1 >= 0)
            {
                z = getChildAt(i1 - T).getLeft();
            }
            B = k1;
            C = i2;
            y = i1;
            E = 0x80000000;
            return true;

        case 6: // '\006'
            ar.b();
            if (G != null)
            {
                G.a();
            }
            D = 5;
            i1 = (int)motionevent.getX();
            E = i1;
            B = i1;
            C = (int)motionevent.getY();
            F = 0;
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
        if (ah)
        {
            g();
        }
        switch (D)
        {
        case 4: // '\004'
        default:
            return true;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            h(i1);
            return true;

        case 3: // '\003'
        case 5: // '\005'
            i(i1);
            break;
        }
        return true;
_L3:
        D;
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
        E();
        aO = -1;
        return true;
_L9:
        l1 = y;
        view = getChildAt(l1 - T);
        f1 = motionevent.getY();
        if (f1 > (float)s.top && f1 < (float)(getHeight() - s.bottom))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (view != null && !view.hasFocusable() && i1 != 0)
        {
            if (D != 0)
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
            K = l1;
            if (D == 0 || D == 1)
            {
                handler = getHandler();
                if (handler != null)
                {
                    if (D == 0)
                    {
                        motionevent = aA;
                    } else
                    {
                        motionevent = az;
                    }
                    handler.removeCallbacks(motionevent);
                }
                f = 0;
                if (!ah && h.isEnabled(l1))
                {
                    D = 1;
                    setSelectedPositionInt(y);
                    g();
                    view.setPressed(true);
                    a(y, view);
                    setPressed(true);
                    if (k != null)
                    {
                        motionevent = k.getCurrent();
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
                            c.D = -1;
                            a.setPressed(false);
                            c.setPressed(false);
                            if (!c.ah)
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
                    D = -1;
                    l();
                    return true;
                }
            }
            if (!ah && h.isEnabled(l1))
            {
                g1.run();
            }
        }
        D = -1;
        l();
          goto _L8
_L10:
        i1 = getChildCount();
        if (i1 > 0)
        {
            l1 = getChildAt(0).getLeft();
            j2 = getChildAt(i1 - 1).getRight();
            k2 = s.left;
            l2 = getWidth() - s.right;
            if (T == 0 && l1 >= k2 && T + i1 < am && j2 <= getWidth() - l2)
            {
                D = -1;
                b(0);
            } else
            {
                motionevent = a;
                motionevent.computeCurrentVelocity(1000, aM);
                i3 = (int)(motionevent.getXVelocity(aO) * aN);
                if (Math.abs(i3) > aL && (T != 0 || l1 != k2 - O) && (i1 + T != am || j2 != O + l2))
                {
                    if (ar == null)
                    {
                        ar = new d(this);
                    }
                    b(2);
                    ar.a(-i3);
                } else
                {
                    D = -1;
                    b(0);
                    if (ar != null)
                    {
                        ar.b();
                    }
                    if (G != null)
                    {
                        G.a();
                    }
                }
            }
        } else
        {
            D = -1;
            b(0);
        }
          goto _L8
_L11:
        if (ar == null)
        {
            ar = new d(this);
        }
        motionevent = a;
        motionevent.computeCurrentVelocity(1000, aM);
        i1 = (int)motionevent.getXVelocity(aO);
        b(2);
        if (Math.abs(i1) > aL)
        {
            ar.b(-i1);
        } else
        {
            ar.a();
        }
          goto _L8
_L5:
        D;
        JVM INSTR tableswitch 5 6: default 1408
    //                   5 1494
    //                   6 1466;
           goto _L12 _L13 _L14
_L14:
        break; /* Loop/switch isn't completed */
_L12:
        D = -1;
        setPressed(false);
        motionevent = getChildAt(y - T);
        if (motionevent != null)
        {
            motionevent.setPressed(false);
        }
        G();
        motionevent = getHandler();
        if (motionevent != null)
        {
            motionevent.removeCallbacks(az);
        }
        E();
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
        i1 = B;
        l1 = a(i1, C);
        if (l1 >= 0)
        {
            z = getChildAt(l1 - T).getLeft();
            y = l1;
        }
        E = i1;
        return true;
_L6:
        j2 = motionevent.getActionIndex();
        l1 = motionevent.getPointerId(j2);
        i1 = (int)motionevent.getX(j2);
        j2 = (int)motionevent.getY(j2);
        F = 0;
        aO = l1;
        B = i1;
        C = j2;
        l1 = a(i1, j2);
        if (l1 >= 0)
        {
            z = getChildAt(l1 - T).getLeft();
            y = l1;
        }
        E = i1;
        return true;
    }

    public void onTouchModeChanged(boolean flag)
    {
        if (flag)
        {
            m();
            if (getWidth() > 0 && getChildCount() > 0)
            {
                g();
            }
            l();
        } else
        {
            int i1 = D;
            if (i1 == 5 || i1 == 6)
            {
                if (ar != null)
                {
                    ar.b();
                }
                if (G != null)
                {
                    G.a();
                }
                if (getScrollX() != 0)
                {
                    a(this, 0);
                    H();
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
            if (G != null)
            {
                G.a();
            }
            if (getScrollX() != 0)
            {
                a(this, 0);
                H();
                invalidate();
            }
        }
        if (i1 == 1)
        {
            K = ak;
        }
_L4:
        aw = i1;
        return;
_L2:
        if (i1 != aw && aw != -1)
        {
            if (i1 == 1)
            {
                q();
            } else
            {
                m();
                f = 0;
                g();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean p()
    {
        if (ak < 0 && q())
        {
            l();
            return true;
        } else
        {
            return false;
        }
    }

    boolean q()
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
        i1 = s.left;
        j1 = getRight() - getLeft() - s.right;
        l2 = T;
        k1 = K;
        if (k1 < l2 || k1 >= l2 + i3) goto _L2; else goto _L1
_L1:
        boolean flag;
        View view = getChildAt(k1 - T);
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
        K = -1;
        removeCallbacks(ar);
        if (G != null)
        {
            G.a();
        }
        D = -1;
        G();
        U = i1;
        i1 = b(j1, flag);
        View view1;
        int i2;
        int j3;
        int k3;
        if (i1 >= l2 && i1 <= getLastVisiblePosition())
        {
            f = 4;
            l();
            setSelectionInt(i1);
            c();
        } else
        {
            i1 = -1;
        }
        b(0);
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
        j3 = am;
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

    void r()
    {
        int i1;
        d.clear();
        i1 = 0;
_L7:
        if (i1 >= e.size()) goto _L2; else goto _L1
_L1:
        int k1;
        long l1;
        l1 = e.keyAt(i1);
        k1 = ((Integer)e.valueAt(i1)).intValue();
        if (l1 == h.getItemId(k1)) goto _L4; else goto _L3
_L3:
        int j1;
        j1 = Math.max(0, k1 - 20);
        k1 = Math.min(k1 + 20, am);
_L8:
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (l1 != h.getItemId(j1)) goto _L6; else goto _L5
_L5:
        d.put(j1, true);
        e.setValueAt(i1, Integer.valueOf(j1));
        j1 = 1;
_L10:
        k1 = i1;
        if (j1 == 0)
        {
            e.delete(l1);
            k1 = i1 - 1;
            c = c - 1;
        }
_L9:
        i1 = k1 + 1;
          goto _L7
_L6:
        j1++;
          goto _L8
_L4:
        d.put(k1, true);
        k1 = i1;
          goto _L9
_L2:
        return;
        j1 = 0;
          goto _L10
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        if (flag)
        {
            E();
        }
        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!aq && !ad)
        {
            super.requestLayout();
        }
    }

    protected void s()
    {
        int l2;
        int i3;
        l2 = am;
        i3 = aZ;
        aZ = am;
        if (b != 0 && h != null && h.hasStableIds())
        {
            r();
        }
        n.c();
        if (l2 <= 0) goto _L2; else goto _L1
_L1:
        if (!ab) goto _L4; else goto _L3
_L3:
        ab = false;
        ba = null;
        if (aE != 2) goto _L6; else goto _L5
_L5:
        f = 3;
_L10:
        return;
_L6:
        if (aE == 1)
        {
            if (aU)
            {
                aU = false;
                f = 3;
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
            if (j3 + T >= i3 && i1 <= j2)
            {
                f = 3;
                return;
            }
            awakenScrollBars();
        }
        ac;
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
        j1 = b(k2, true);
        if (j1 >= 0)
        {
            setNextSelectedPositionInt(j1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (isInTouchMode())
        {
            f = 5;
            V = Math.min(Math.max(0, V), l2 - 1);
            return;
        }
        int k1 = x();
        if (k1 >= 0 && b(k1, true) == k1)
        {
            V = k1;
            if (aa == (long)getHeight())
            {
                f = 5;
            } else
            {
                f = 2;
            }
            setNextSelectedPositionInt(k1);
            return;
        }
        if (true) goto _L4; else goto _L9
_L8:
        f = 5;
        V = Math.min(Math.max(0, V), l2 - 1);
        return;
_L9:
        int l1 = b(k2, false);
        if (l1 >= 0)
        {
            setNextSelectedPositionInt(l1);
            return;
        }
        break; /* Loop/switch isn't completed */
        if (K >= 0) goto _L10; else goto _L2
_L2:
        int i2;
        if (I)
        {
            i2 = 3;
        } else
        {
            i2 = 1;
        }
        f = i2;
        ak = -1;
        al = 0x8000000000000000L;
        ai = -1;
        aj = 0x8000000000000000L;
        ab = false;
        ba = null;
        l = -1;
        w();
        return;
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
            i = h.hasStableIds();
            if (b != 0 && i && e == null)
            {
                e = new LongSparseArray();
            }
        }
        if (d != null)
        {
            d.clear();
        }
        if (e != null)
        {
            e.clear();
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

            n.f(i1);
        }
    }

    public void setChoiceMode(int i1)
    {
        b = i1;
        if (b != 0)
        {
            if (d == null)
            {
                d = new SparseBooleanArray();
            }
            if (e == null && h != null && h.hasStableIds())
            {
                e = new LongSparseArray();
            }
            if (b == 3)
            {
                b();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean flag)
    {
        j = flag;
    }

    public void setFriction(float f1)
    {
        if (ar == null)
        {
            ar = new d(this);
        }
        com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.d.a(ar).a(f1);
    }

    public void setOnScrollListener(f f1)
    {
        as = f1;
        c();
    }

    public void setOverScrollMode(int i1)
    {
        if (i1 != 2)
        {
            if (aP == null)
            {
                Context context = getContext();
                aP = new t(context);
                aQ = new t(context);
            }
        } else
        {
            aP = null;
            aQ = null;
        }
        super.setOverScrollMode(i1);
    }

    public void setRecyclerListener(com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.j j1)
    {
        com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.i.a(n, j1);
    }

    public void setScrollingCacheEnabled(boolean flag)
    {
        if (J && !flag)
        {
            G();
        }
        J = flag;
    }

    abstract void setSelectionInt(int i1);

    public void setSelector(int i1)
    {
        setSelector(getResources().getDrawable(i1));
    }

    public void setSelector(Drawable drawable)
    {
        if (k != null)
        {
            k.setCallback(null);
            unscheduleDrawable(k);
        }
        k = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        o = rect.left;
        p = rect.top;
        q = rect.right;
        r = rect.bottom;
        drawable.setCallback(this);
        l();
    }

    public void setSmoothScrollbarEnabled(boolean flag)
    {
        at = flag;
    }

    public void setStackFromRight(boolean flag)
    {
        if (I != flag)
        {
            I = flag;
            e();
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
            long l1 = h.getItemId(i1);
            if (ag != null)
            {
                flag1 = ag.a(this, view, i1, l1);
            }
            flag = flag1;
            if (!flag1)
            {
                av = b(getChildAt(i1 - T), i1, l1);
                flag = super.showContextMenuForChild(view);
            }
        }
        return flag;
    }

    public boolean verifyDrawable(Drawable drawable)
    {
        return k == drawable || super.verifyDrawable(drawable);
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

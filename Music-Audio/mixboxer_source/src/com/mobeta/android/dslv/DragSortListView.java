// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

// Referenced classes of package com.mobeta.android.dslv:
//            o, d, q, f, 
//            c, p, b, m, 
//            k, DragSortItemView, l, i, 
//            h, j, r, g

public class DragSortListView extends ListView
{

    private float A;
    private float B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private o J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private l Q;
    private MotionEvent R;
    private int S;
    private float T;
    private float U;
    private h V;
    private boolean W;
    private f Z;
    private View a;
    private boolean aa;
    private boolean ab;
    private d ac;
    private b ad;
    private m ae;
    private boolean af;
    private float ag;
    private boolean ah;
    private Point b;
    private Point c;
    private int d;
    private boolean e;
    private DataSetObserver f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private j p;
    private i q;
    private r r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private View y[];
    private p z;

    public DragSortListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new Point();
        c = new Point();
        e = false;
        g = 1.0F;
        h = 1.0F;
        l = false;
        s = true;
        t = 0;
        u = 1;
        x = 0;
        y = new View[1];
        A = 0.3333333F;
        B = 0.3333333F;
        I = 0.5F;
        J = new o(this);
        N = 0;
        O = false;
        P = false;
        Q = null;
        S = 0;
        T = 0.25F;
        U = 0.0F;
        W = false;
        aa = false;
        ab = false;
        ac = new d(this, 3);
        ag = 0.0F;
        ah = false;
        int j1 = 150;
        int i1 = 150;
        if (attributeset != null)
        {
            context = getContext().obtainStyledAttributes(attributeset, q.DragSortListView, 0, 0);
            u = Math.max(1, context.getDimensionPixelSize(0, 1));
            W = context.getBoolean(5, false);
            if (W)
            {
                Z = new f(this);
            }
            g = context.getFloat(6, g);
            h = g;
            s = context.getBoolean(10, s);
            T = Math.max(0.0F, Math.min(1.0F, 1.0F - context.getFloat(7, 0.75F)));
            boolean flag;
            if (T > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l = flag;
            setDragScrollStart(context.getFloat(1, A));
            I = context.getFloat(2, I);
            j1 = context.getInt(8, 150);
            i1 = context.getInt(9, 150);
            if (context.getBoolean(17, true))
            {
                flag = context.getBoolean(12, false);
                int k1 = context.getInt(4, 1);
                boolean flag1 = context.getBoolean(11, true);
                int l1 = context.getInt(13, 0);
                int i2 = context.getResourceId(14, 0);
                int j2 = context.getResourceId(15, 0);
                int k2 = context.getResourceId(16, 0);
                int l2 = context.getColor(3, 0xff000000);
                attributeset = new c(this, i2, l1, k1, k2, j2);
                attributeset.b(flag);
                attributeset.a(flag1);
                attributeset.d(l2);
                Q = attributeset;
                setOnTouchListener(attributeset);
            }
            context.recycle();
        }
        z = new p(this);
        if (j1 > 0)
        {
            ad = new b(this, 0.5F, j1);
        }
        if (i1 > 0)
        {
            ae = new m(this, 0.5F, i1);
        }
        R = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
        f = new k(this);
    }

    static float a(DragSortListView dragsortlistview)
    {
        return dragsortlistview.I;
    }

    static float a(DragSortListView dragsortlistview, float f1)
    {
        dragsortlistview.ag = f1;
        return f1;
    }

    private int a(int i1, int j1)
    {
        int k1 = getHeaderViewsCount();
        int l1 = getFooterViewsCount();
        if (i1 <= k1 || i1 >= getCount() - l1)
        {
            return j1;
        }
        l1 = getDividerHeight();
        int j2 = v - u;
        int i2 = d(i1);
        int k2 = b(i1);
        if (k <= m)
        {
            if (i1 == k && j != k)
            {
                if (i1 == m)
                {
                    k1 = (j1 + k2) - v;
                } else
                {
                    k1 = ((k2 - i2) + j1) - j2;
                }
            } else
            {
                k1 = j1;
                if (i1 > k)
                {
                    k1 = j1;
                    if (i1 <= m)
                    {
                        k1 = j1 - j2;
                    }
                }
            }
        } else
        if (i1 > m && i1 <= j)
        {
            k1 = j1 + j2;
        } else
        {
            k1 = j1;
            if (i1 == k)
            {
                k1 = j1;
                if (j != k)
                {
                    k1 = j1 + (k2 - i2);
                }
            }
        }
        if (i1 <= m)
        {
            return (v - l1 - d(i1 - 1)) / 2 + k1;
        } else
        {
            return (i2 - l1 - v) / 2 + k1;
        }
    }

    static int a(DragSortListView dragsortlistview, int i1)
    {
        dragsortlistview.t = i1;
        return i1;
    }

    static int a(DragSortListView dragsortlistview, int i1, int j1)
    {
        return dragsortlistview.a(i1, j1);
    }

    private void a(int i1, float f1)
    {
        if (t != 0 && t != 4) goto _L2; else goto _L1
_L1:
        if (t == 0)
        {
            m = getHeaderViewsCount() + i1;
            j = m;
            k = m;
            i = m;
            View view = getChildAt(m - getFirstVisiblePosition());
            if (view != null)
            {
                view.setVisibility(4);
            }
        }
        t = 1;
        ag = f1;
        if (!P) goto _L4; else goto _L3
_L3:
        S;
        JVM INSTR tableswitch 1 2: default 124
    //                   1 139
    //                   2 151;
           goto _L4 _L5 _L6
_L4:
        if (ad == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ad.c();
_L2:
        return;
_L5:
        super.onTouchEvent(R);
        continue; /* Loop/switch isn't completed */
_L6:
        super.onInterceptTouchEvent(R);
        if (true) goto _L4; else goto _L7
_L7:
        c(i1);
        return;
    }

    private void a(int i1, Canvas canvas)
    {
        Drawable drawable = getDivider();
        int i2 = getDividerHeight();
        if (drawable != null && i2 != 0)
        {
            ViewGroup viewgroup = (ViewGroup)getChildAt(i1 - getFirstVisiblePosition());
            if (viewgroup != null)
            {
                int k1 = getPaddingLeft();
                int l1 = getWidth() - getPaddingRight();
                int j1 = viewgroup.getChildAt(0).getHeight();
                if (i1 > m)
                {
                    j1 += viewgroup.getTop();
                    i1 = j1 + i2;
                } else
                {
                    i1 = viewgroup.getBottom() - j1;
                    j1 = i1 - i2;
                }
                canvas.save();
                canvas.clipRect(k1, j1, l1, i1);
                drawable.setBounds(k1, j1, l1, i1);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void a(int i1, View view, boolean flag)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        int j1;
        boolean flag1;
        int k1;
        if (i1 != m && i1 != j && i1 != k)
        {
            j1 = -2;
        } else
        {
            j1 = b(i1, b(i1, view, flag));
        }
        if (j1 != layoutparams.height)
        {
            layoutparams.height = j1;
            view.setLayoutParams(layoutparams);
        }
        if (i1 != j && i1 != k) goto _L2; else goto _L1
_L1:
        if (i1 >= m) goto _L4; else goto _L3
_L3:
        ((DragSortItemView)view).setGravity(80);
_L2:
        k1 = view.getVisibility();
        flag1 = false;
        j1 = ((flag1) ? 1 : 0);
        if (i1 == m)
        {
            j1 = ((flag1) ? 1 : 0);
            if (a != null)
            {
                j1 = 4;
            }
        }
        if (j1 != k1)
        {
            view.setVisibility(j1);
        }
        return;
_L4:
        if (i1 > m)
        {
            ((DragSortItemView)view).setGravity(48);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = motionevent.getAction() & 0xff;
        if (i1 != 0)
        {
            M = L;
        }
        K = (int)motionevent.getX();
        L = (int)motionevent.getY();
        if (i1 == 0)
        {
            M = L;
        }
        motionevent.getRawX();
        motionevent.getRawY();
    }

    private void a(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        Object obj = layoutparams;
        if (layoutparams == null)
        {
            obj = new android.widget.AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        int j1 = ViewGroup.getChildMeasureSpec(x, getListPaddingLeft() + getListPaddingRight(), ((android.view.ViewGroup.LayoutParams) (obj)).width);
        int i1;
        if (((android.view.ViewGroup.LayoutParams) (obj)).height > 0)
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(((android.view.ViewGroup.LayoutParams) (obj)).height, 0x40000000);
        } else
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(j1, i1);
    }

    static void a(DragSortListView dragsortlistview, int i1, View view, boolean flag)
    {
        dragsortlistview.a(i1, view, true);
    }

    static void a(DragSortListView dragsortlistview, boolean flag)
    {
        dragsortlistview.a(true);
    }

    private void a(boolean flag)
    {
        int i1 = getFirstVisiblePosition();
        int j1 = getChildCount() / 2;
        View view = getChildAt(getChildCount() / 2);
        if (view == null)
        {
            return;
        } else
        {
            c(i1 + j1, view, flag);
            return;
        }
    }

    static float b(DragSortListView dragsortlistview, float f1)
    {
        f1 = dragsortlistview.ag + f1;
        dragsortlistview.ag = f1;
        return f1;
    }

    private int b(int i1)
    {
        View view = getChildAt(i1 - getFirstVisiblePosition());
        if (view != null)
        {
            return view.getHeight();
        } else
        {
            return b(i1, d(i1));
        }
    }

    private int b(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        getDividerHeight();
        if (l && j != k)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        l1 = v - u;
        i2 = (int)(U * (float)l1);
        if (i1 != m) goto _L2; else goto _L1
_L1:
        if (m != j) goto _L4; else goto _L3
_L3:
        if (k1 == 0) goto _L6; else goto _L5
_L5:
        k1 = i2 + u;
_L8:
        return k1;
_L6:
        return v;
_L4:
        if (m == k)
        {
            return v - i2;
        } else
        {
            return u;
        }
_L2:
        if (i1 == j)
        {
            if (k1 != 0)
            {
                return j1 + i2;
            } else
            {
                return j1 + l1;
            }
        }
        k1 = j1;
        if (i1 == k)
        {
            return (j1 + l1) - i2;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int b(int i1, View view, boolean flag)
    {
        boolean flag1 = false;
        if (i1 == m)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            View view1 = view;
            if (i1 >= getHeaderViewsCount())
            {
                if (i1 >= getCount() - getFooterViewsCount())
                {
                    view1 = view;
                } else
                {
                    view1 = ((ViewGroup)view).getChildAt(0);
                }
            }
            view = view1.getLayoutParams();
            if (view != null && ((android.view.ViewGroup.LayoutParams) (view)).height > 0)
            {
                return ((android.view.ViewGroup.LayoutParams) (view)).height;
            }
            i1 = view1.getHeight();
            if (i1 == 0 || flag)
            {
                a(view1);
                return view1.getMeasuredHeight();
            }
        }
        return i1;
    }

    static int b(DragSortListView dragsortlistview)
    {
        return dragsortlistview.t;
    }

    static int b(DragSortListView dragsortlistview, int i1)
    {
        return dragsortlistview.b(i1);
    }

    static int b(DragSortListView dragsortlistview, int i1, View view, boolean flag)
    {
        return dragsortlistview.b(i1, view, false);
    }

    static boolean b(DragSortListView dragsortlistview, boolean flag)
    {
        dragsortlistview.aa = flag;
        return flag;
    }

    private boolean b(boolean flag, float f1)
    {
        if (a != null)
        {
            z.a(true);
            if (flag)
            {
                a(m - getHeaderViewsCount(), f1);
            } else
            if (ae != null)
            {
                ae.c();
            } else
            {
                e();
            }
            if (W)
            {
                Z.c();
            }
            return true;
        } else
        {
            return false;
        }
    }

    static int c(DragSortListView dragsortlistview)
    {
        return dragsortlistview.w;
    }

    static int c(DragSortListView dragsortlistview, int i1)
    {
        return dragsortlistview.d(i1);
    }

    private void c(int i1)
    {
        t = 1;
        k();
        f();
        d();
        if (P)
        {
            t = 3;
            return;
        } else
        {
            t = 0;
            return;
        }
    }

    private void c(int i1, View view, boolean flag)
    {
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l3;
        int i4;
        aa = true;
        if (Q != null)
        {
            c.set(K, L);
            Q.a(b);
        }
        j1 = b.x;
        i2 = b.y;
        k1 = getPaddingLeft();
        float f1;
        float f2;
        View view1;
        View view2;
        int l2;
        int k3;
        if ((N & 1) == 0 && j1 > k1)
        {
            b.x = k1;
        } else
        if ((N & 2) == 0 && j1 < k1)
        {
            b.x = k1;
        }
        k1 = getHeaderViewsCount();
        l1 = getFooterViewsCount();
        j2 = getFirstVisiblePosition();
        k2 = getLastVisiblePosition();
        j1 = getPaddingTop();
        if (j2 < k1)
        {
            j1 = getChildAt(k1 - j2 - 1).getBottom();
        }
        k1 = j1;
        if ((N & 8) == 0)
        {
            k1 = j1;
            if (j2 <= m)
            {
                k1 = Math.max(getChildAt(m - j2).getTop(), j1);
            }
        }
        j1 = getHeight() - getPaddingBottom();
        if (k2 >= getCount() - l1 - 1)
        {
            j1 = getChildAt(getCount() - l1 - 1 - j2).getBottom();
        }
        l1 = j1;
        if ((N & 4) == 0)
        {
            l1 = j1;
            if (k2 >= m)
            {
                l1 = Math.min(getChildAt(m - j2).getBottom(), j1);
            }
        }
        if (i2 < k1)
        {
            b.y = k1;
        } else
        if (v + i2 > l1)
        {
            b.y = l1 - v;
        }
        d = b.y + w;
        k3 = j;
        l3 = k;
        j1 = getFirstVisiblePosition();
        k1 = j;
        view2 = getChildAt(k1 - j1);
        view1 = view2;
        if (view2 == null)
        {
            k1 = j1 + getChildCount() / 2;
            view1 = getChildAt(k1 - j1);
        }
        k2 = view1.getTop();
        l1 = view1.getHeight();
        j1 = a(k1, k2);
        i4 = getDividerHeight();
        if (d >= j1) goto _L2; else goto _L1
_L1:
        i2 = j1;
        j2 = k1;
_L8:
        k1 = j2;
        l1 = i2;
        if (j2 < 0) goto _L4; else goto _L3
_L3:
        j2--;
        j1 = b(j2);
        if (j2 != 0) goto _L6; else goto _L5
_L5:
        j1 = k2 - i4 - j1;
        l1 = i2;
        k1 = j2;
_L4:
label0:
        {
            {
                j2 = getHeaderViewsCount();
                int j3 = getFooterViewsCount();
                k2 = j;
                l2 = k;
                f1 = U;
                if (l)
                {
                    i4 = Math.abs(j1 - l1);
                    float f3;
                    int i3;
                    int j4;
                    if (d >= j1)
                    {
                        i2 = l1;
                        l1 = j1;
                        j1 = i2;
                    }
                    f2 = T;
                    i2 = (int)((float)i4 * (0.5F * f2));
                    f3 = i2;
                    l1 += i2;
                    if (d < l1)
                    {
                        j = k1 - 1;
                        k = k1;
                        U = ((float)(l1 - d) * 0.5F) / f3;
                    } else
                    if (d < j1 - i2)
                    {
                        j = k1;
                        k = k1;
                    } else
                    {
                        j = k1;
                        k = k1 + 1;
                        U = 0.5F * ((float)(j1 - d) / f3 + 1.0F);
                    }
                } else
                {
                    j = k1;
                    k = k1;
                }
                if (j < j2)
                {
                    j = j2;
                    k = j2;
                    k1 = j2;
                } else
                if (k >= getCount() - j3)
                {
                    k1 = getCount() - j3 - 1;
                    j = k1;
                    k = k1;
                }
                if (j != k2 || k != l2 || U != f1)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                if (k1 != i)
                {
                    i = k1;
                    k1 = 1;
                } else
                {
                    k1 = j1;
                }
                if (k1 == 0)
                {
                    break label0;
                }
                i();
                l1 = d(i1);
                j2 = view.getHeight();
                k2 = b(i1, l1);
                if (i1 != m)
                {
                    j1 = j2 - l1;
                    l1 = k2 - l1;
                } else
                {
                    j1 = j2;
                    l1 = k2;
                }
                l2 = v;
                i2 = l2;
                if (m != j)
                {
                    i2 = l2;
                    if (m != k)
                    {
                        i2 = l2 - u;
                    }
                }
                if (i1 <= k3)
                {
                    if (i1 <= j)
                    {
                        break MISSING_BLOCK_LABEL_1315;
                    }
                    j1 = (i2 - l1) + 0;
                } else
                if (i1 == l3)
                {
                    if (i1 <= j)
                    {
                        j1 = (j1 - i2) + 0;
                    } else
                    if (i1 == k)
                    {
                        j1 = (j2 - k2) + 0;
                    } else
                    {
                        j1 += 0;
                    }
                } else
                if (i1 <= j)
                {
                    j1 = 0 - i2;
                } else
                {
                    if (i1 != k)
                    {
                        break MISSING_BLOCK_LABEL_1315;
                    }
                    j1 = 0 - l1;
                }
            }
            setSelectionFromTop(i1, (j1 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (k1 != 0 || flag)
        {
            invalidate();
        }
        aa = false;
        return;
_L6:
        i3 = k2 - (j1 + i4);
        k2 = a(j2, i3);
        k1 = j2;
        l1 = i2;
        j1 = k2;
        if (d >= k2) goto _L4; else goto _L7
_L7:
        i2 = k2;
        j1 = k2;
        k2 = i3;
          goto _L8
_L2:
        j4 = getCount();
        i3 = k2;
        k2 = l1;
        j2 = j1;
        i2 = k1;
_L10:
        k1 = i2;
        l1 = j2;
        if (i2 < j4)
        {
label1:
            {
                if (i2 != j4 - 1)
                {
                    break label1;
                }
                j1 = i3 + i4 + k2;
                k1 = i2;
                l1 = j2;
            }
        }
          goto _L4
        i3 += i4 + k2;
        j3 = b(i2 + 1);
        k2 = a(i2 + 1, i3);
        k1 = i2;
        l1 = j2;
        j1 = k2;
        if (d < k2) goto _L4; else goto _L9
_L9:
        i2++;
        j2 = k2;
        j1 = k2;
        k2 = j3;
          goto _L10
        j1 = 0;
        break MISSING_BLOCK_LABEL_798;
    }

    static void c(DragSortListView dragsortlistview, int i1, View view, boolean flag)
    {
        dragsortlistview.c(i1, view, false);
    }

    private int d(int i1)
    {
        int j1 = 0;
        if (i1 != m)
        {
            View view = getChildAt(i1 - getFirstVisiblePosition());
            if (view != null)
            {
                return b(i1, view, false);
            }
            int l1 = ac.a(i1);
            j1 = l1;
            if (l1 == -1)
            {
                Object obj = getAdapter();
                int k1 = ((ListAdapter) (obj)).getItemViewType(i1);
                int i2 = ((ListAdapter) (obj)).getViewTypeCount();
                if (i2 != y.length)
                {
                    y = new View[i2];
                }
                if (k1 >= 0)
                {
                    if (y[k1] == null)
                    {
                        obj = ((ListAdapter) (obj)).getView(i1, null, this);
                        y[k1] = ((View) (obj));
                    } else
                    {
                        obj = ((ListAdapter) (obj)).getView(i1, y[k1], this);
                    }
                } else
                {
                    obj = ((ListAdapter) (obj)).getView(i1, null, this);
                }
                k1 = b(i1, ((View) (obj)), true);
                ac.a(i1, k1);
                return k1;
            }
        }
        return j1;
    }

    static Point d(DragSortListView dragsortlistview)
    {
        return dragsortlistview.b;
    }

    private void d()
    {
        m = -1;
        j = -1;
        k = -1;
        i = -1;
    }

    static int e(DragSortListView dragsortlistview)
    {
        return dragsortlistview.L;
    }

    private void e()
    {
        t = 2;
        if (q != null && i >= 0 && i < getCount())
        {
            int i1 = getHeaderViewsCount();
            q.drop(m - i1, i - i1);
        }
        k();
        f();
        d();
        i();
        if (P)
        {
            t = 3;
            return;
        } else
        {
            t = 0;
            return;
        }
    }

    static int f(DragSortListView dragsortlistview)
    {
        return dragsortlistview.i;
    }

    private void f()
    {
        int i1 = 0;
        int j1 = getFirstVisiblePosition();
        if (m < j1)
        {
            View view = getChildAt(0);
            if (view != null)
            {
                i1 = view.getTop();
            }
            setSelectionFromTop(j1 - 1, i1 - getPaddingTop());
        }
    }

    static int g(DragSortListView dragsortlistview)
    {
        return dragsortlistview.m;
    }

    private void g()
    {
        S = 0;
        P = false;
        if (t == 3)
        {
            t = 0;
        }
        h = g;
        ah = false;
        ac.a();
    }

    static int h(DragSortListView dragsortlistview)
    {
        return dragsortlistview.u;
    }

    private void h()
    {
        int i1 = getPaddingTop();
        int j1 = getHeight() - i1 - getPaddingBottom();
        float f1 = j1;
        F = (float)i1 + A * f1;
        float f2 = i1;
        E = f1 * (1.0F - B) + f2;
        C = (int)F;
        D = (int)E;
        G = F - (float)i1;
        H = (float)(i1 + j1) - E;
    }

    static int i(DragSortListView dragsortlistview)
    {
        return dragsortlistview.v;
    }

    private void i()
    {
        int j1 = getFirstVisiblePosition();
        int k1 = getLastVisiblePosition();
        int i1 = Math.max(0, getHeaderViewsCount() - j1);
        for (k1 = Math.min(k1 - j1, getCount() - 1 - getFooterViewsCount() - j1); i1 <= k1; i1++)
        {
            View view = getChildAt(i1);
            if (view != null)
            {
                a(j1 + i1, view, false);
            }
        }

    }

    private void j()
    {
        if (a != null)
        {
            a(a);
            v = a.getMeasuredHeight();
            w = v / 2;
        }
    }

    static void j(DragSortListView dragsortlistview)
    {
        dragsortlistview.e();
    }

    static int k(DragSortListView dragsortlistview)
    {
        return dragsortlistview.j;
    }

    private void k()
    {
        if (a != null)
        {
            a.setVisibility(8);
            if (Q != null)
            {
                Q.a(a);
            }
            a = null;
            invalidate();
        }
    }

    static int l(DragSortListView dragsortlistview)
    {
        return dragsortlistview.k;
    }

    static boolean m(DragSortListView dragsortlistview)
    {
        return dragsortlistview.af;
    }

    static float n(DragSortListView dragsortlistview)
    {
        return dragsortlistview.ag;
    }

    static void o(DragSortListView dragsortlistview)
    {
        dragsortlistview.k();
    }

    static void p(DragSortListView dragsortlistview)
    {
        dragsortlistview.c(dragsortlistview.m - dragsortlistview.getHeaderViewsCount());
    }

    static int q(DragSortListView dragsortlistview)
    {
        return dragsortlistview.d;
    }

    static float r(DragSortListView dragsortlistview)
    {
        return dragsortlistview.F;
    }

    static float s(DragSortListView dragsortlistview)
    {
        return dragsortlistview.G;
    }

    static o t(DragSortListView dragsortlistview)
    {
        return dragsortlistview.J;
    }

    static float u(DragSortListView dragsortlistview)
    {
        return dragsortlistview.E;
    }

    static float v(DragSortListView dragsortlistview)
    {
        return dragsortlistview.H;
    }

    static int w(DragSortListView dragsortlistview)
    {
        return dragsortlistview.M;
    }

    public final void a()
    {
label0:
        {
            if (t == 4)
            {
                z.a(true);
                k();
                d();
                i();
                if (!P)
                {
                    break label0;
                }
                t = 3;
            }
            return;
        }
        t = 0;
    }

    public final void a(int i1)
    {
        af = false;
        a(i1, 0.0F);
    }

    public final boolean a(int i1, int j1, int k1, int l1)
    {
        if (P && Q != null) goto _L2; else goto _L1
_L1:
        View view;
        return false;
_L2:
        if ((view = Q.c(i1)) == null || t != 0 || !P || a != null || view == null || !s) goto _L1; else goto _L3
_L3:
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        i1 = getHeaderViewsCount() + i1;
        j = i1;
        k = i1;
        m = i1;
        i = i1;
        t = 4;
        N = 0;
        N = N | j1;
        a = view;
        j();
        n = k1;
        o = l1;
        b.x = K - n;
        b.y = L - o;
        view = getChildAt(m - getFirstVisiblePosition());
        if (view != null)
        {
            view.setVisibility(4);
        }
        if (W)
        {
            Z.a();
        }
        S;
        JVM INSTR tableswitch 1 2: default 248
    //                   1 254
    //                   2 266;
           goto _L4 _L5 _L6
_L4:
        requestLayout();
        return true;
_L5:
        super.onTouchEvent(R);
        continue; /* Loop/switch isn't completed */
_L6:
        super.onInterceptTouchEvent(R);
        if (true) goto _L4; else goto _L7
_L7:
    }

    public final boolean a(boolean flag, float f1)
    {
        af = true;
        return b(true, f1);
    }

    public final boolean b()
    {
        return ah;
    }

    public final boolean c()
    {
        return s;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (t != 0)
        {
            if (j != m)
            {
                a(j, canvas);
            }
            if (k != j && k != m)
            {
                a(k, canvas);
            }
        }
        if (a != null)
        {
            int k1 = a.getWidth();
            int l1 = a.getHeight();
            int j1 = b.x;
            int i2 = getWidth();
            int i1 = j1;
            if (j1 < 0)
            {
                i1 = -j1;
            }
            float f1;
            if (i1 < i2)
            {
                f1 = (float)(i2 - i1) / (float)i2;
                f1 *= f1;
            } else
            {
                f1 = 0.0F;
            }
            i1 = (int)(f1 * (255F * h));
            canvas.save();
            canvas.translate(b.x, b.y);
            canvas.clipRect(0, 0, k1, l1);
            canvas.saveLayerAlpha(0.0F, 0.0F, k1, l1, i1, 31);
            a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    protected void layoutChildren()
    {
        super.layoutChildren();
        if (a != null)
        {
            if (a.isLayoutRequested() && !e)
            {
                j();
            }
            a.layout(0, 0, a.getMeasuredWidth(), a.getMeasuredHeight());
            e = false;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (W)
        {
            Z.b();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        if (!s)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        a(motionevent);
        O = true;
        i1 = motionevent.getAction() & 0xff;
        if (i1 == 0)
        {
            if (t != 0)
            {
                ab = true;
                return true;
            }
            P = true;
        }
        if (a == null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        if (i1 == 1 || i1 == 3)
        {
            P = false;
        }
        return flag;
_L2:
        if (super.onInterceptTouchEvent(motionevent))
        {
            ah = true;
            flag = true;
        } else
        {
            flag = false;
        }
        switch (i1)
        {
        case 2: // '\002'
        default:
            if (flag)
            {
                S = 1;
            } else
            {
                S = 2;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            g();
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        if (a != null)
        {
            if (a.isLayoutRequested())
            {
                j();
            }
            e = true;
        }
        x = i1;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        h();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag3;
        flag3 = false;
        flag = false;
        if (!ab) goto _L2; else goto _L1
_L1:
        ab = false;
        flag3 = flag;
_L10:
        return flag3;
_L2:
        if (!s)
        {
            return super.onTouchEvent(motionevent);
        }
        boolean flag1 = O;
        O = false;
        if (!flag1)
        {
            a(motionevent);
        }
        if (t != 4) goto _L4; else goto _L3
_L3:
        motionevent.getAction();
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 1 3: default 108
    //                   1 129
    //                   2 156
    //                   3 110;
           goto _L5 _L6 _L7 _L8
_L5:
        return true;
_L8:
        if (t == 4)
        {
            a();
        }
        g();
        continue; /* Loop/switch isn't completed */
_L6:
        if (t == 4)
        {
            af = false;
            b(false, 0.0F);
        }
        g();
        continue; /* Loop/switch isn't completed */
_L7:
        int i1 = (int)motionevent.getX();
        int j1 = (int)motionevent.getY();
        b.x = i1 - n;
        b.y = j1 - o;
        a(true);
        i1 = Math.min(j1, d + w);
        j1 = Math.max(j1, d - w);
        int k1 = z.b();
        if (i1 > M && i1 > D && k1 != 1)
        {
            if (k1 != -1)
            {
                z.a(true);
            }
            z.a(1);
        } else
        if (j1 < M && j1 < C && k1 != 0)
        {
            if (k1 != -1)
            {
                z.a(true);
            }
            z.a(0);
        } else
        if (j1 >= C && i1 <= D && z.a())
        {
            z.a(true);
        }
        if (true) goto _L5; else goto _L4
_L4:
        boolean flag2 = flag3;
        if (t == 0)
        {
            flag2 = flag3;
            if (super.onTouchEvent(motionevent))
            {
                flag2 = true;
            }
        }
        switch (motionevent.getAction() & 0xff)
        {
        case 2: // '\002'
        default:
            flag3 = flag2;
            if (flag2)
            {
                S = 1;
                return flag2;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            g();
            return flag2;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void requestLayout()
    {
        if (!aa)
        {
            super.requestLayout();
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (listadapter != null)
        {
            V = new h(this, listadapter);
            listadapter.registerDataSetObserver(f);
            if (listadapter instanceof i)
            {
                setDropListener((i)listadapter);
            }
            if (listadapter instanceof j)
            {
                setDragListener((j)listadapter);
            }
            if (listadapter instanceof r)
            {
                setRemoveListener((r)listadapter);
            }
        } else
        {
            V = null;
        }
        super.setAdapter(V);
    }

    public void setDragEnabled(boolean flag)
    {
        s = flag;
    }

    public void setDragListener(j j1)
    {
        p = j1;
    }

    public void setDragScrollProfile(o o1)
    {
        if (o1 != null)
        {
            J = o1;
        }
    }

    public void setDragScrollStart(float f1)
    {
        setDragScrollStarts(f1, f1);
    }

    public void setDragScrollStarts(float f1, float f2)
    {
        if (f2 > 0.5F)
        {
            B = 0.5F;
        } else
        {
            B = f2;
        }
        if (f1 > 0.5F)
        {
            A = 0.5F;
        } else
        {
            A = f1;
        }
        if (getHeight() != 0)
        {
            h();
        }
    }

    public void setDragSortListener(g g1)
    {
        setDropListener(g1);
        setDragListener(g1);
        setRemoveListener(g1);
    }

    public void setDropListener(i i1)
    {
        q = i1;
    }

    public void setFloatAlpha(float f1)
    {
        h = f1;
    }

    public void setFloatViewManager(l l1)
    {
        Q = l1;
    }

    public void setMaxScrollSpeed(float f1)
    {
        I = f1;
    }

    public void setRemoveListener(r r1)
    {
        r = r1;
    }
}

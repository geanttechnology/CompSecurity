// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import myobfuscated.bi.a;

// Referenced classes of package com.mobeta.android.dslv:
//            d, k, g, a, 
//            j, e, l, h, 
//            DragSortItemView, i, b, c, 
//            m, f

public class DragSortListView extends ListView
{

    private View A[];
    private e B;
    private float C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private d L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private MotionEvent R;
    private int S;
    private float T;
    private float U;
    private b V;
    private boolean W;
    boolean a;
    private g aa;
    private boolean ab;
    private boolean ac;
    private k ad;
    private l ae;
    private h af;
    private float ag;
    boolean b;
    j c;
    boolean d;
    boolean e;
    private View f;
    private Point g;
    private Point h;
    private int i;
    private boolean j;
    private DataSetObserver k;
    private float l;
    private float m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private i u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public DragSortListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = new Point();
        h = new Point();
        j = false;
        l = 1.0F;
        m = 1.0F;
        q = false;
        a = true;
        v = 0;
        w = 1;
        z = 0;
        A = new View[1];
        C = 0.3333333F;
        D = 0.3333333F;
        K = 0.5F;
        L = new d(this);
        P = 0;
        Q = false;
        b = false;
        c = null;
        S = 0;
        T = 0.25F;
        U = 0.0F;
        W = false;
        ab = false;
        ac = false;
        ad = new k();
        ag = 0.0F;
        e = false;
        int j1 = 150;
        int i1 = 150;
        if (attributeset != null)
        {
            context = getContext().obtainStyledAttributes(attributeset, a.DragSortListView, 0, 0);
            w = Math.max(1, context.getDimensionPixelSize(a.DragSortListView_collapsed_height, 1));
            W = context.getBoolean(a.DragSortListView_track_drag_sort, false);
            if (W)
            {
                aa = new g(this);
            }
            l = context.getFloat(a.DragSortListView_float_alpha, l);
            m = l;
            a = context.getBoolean(a.DragSortListView_drag_enabled, a);
            T = Math.max(0.0F, Math.min(1.0F, 1.0F - context.getFloat(a.DragSortListView_slide_shuffle_speed, 0.75F)));
            boolean flag;
            if (T > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            q = flag;
            setDragScrollStart(context.getFloat(a.DragSortListView_drag_scroll_start, C));
            K = context.getFloat(a.DragSortListView_max_drag_scroll_speed, K);
            j1 = context.getInt(a.DragSortListView_remove_animation_duration, 150);
            i1 = context.getInt(a.DragSortListView_drop_animation_duration, 150);
            if (context.getBoolean(a.DragSortListView_use_default_controller, true))
            {
                flag = context.getBoolean(a.DragSortListView_remove_enabled, false);
                int k1 = context.getInt(a.DragSortListView_remove_mode, 1);
                boolean flag1 = context.getBoolean(a.DragSortListView_sort_enabled, true);
                int l1 = context.getInt(a.DragSortListView_drag_start_mode, 0);
                int i2 = context.getResourceId(a.DragSortListView_drag_handle_id, 0);
                int j2 = context.getResourceId(a.DragSortListView_fling_handle_id, 0);
                int k2 = context.getResourceId(a.DragSortListView_click_remove_id, 0);
                int l2 = context.getColor(a.DragSortListView_float_background_color, 0xff000000);
                attributeset = new com.mobeta.android.dslv.a(this, i2, l1, k1, k2, j2);
                attributeset.c = flag;
                attributeset.b = flag1;
                attributeset.g = l2;
                c = attributeset;
                setOnTouchListener(attributeset);
            }
            context.recycle();
        }
        B = new e(this);
        if (j1 > 0)
        {
            ae = new l(this, j1);
        }
        if (i1 > 0)
        {
            af = new h(this, i1);
        }
        R = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
        k = new DataSetObserver() {

            private DragSortListView a;

            private void a()
            {
                if (DragSortListView.b(a) == 4)
                {
                    a.a();
                }
            }

            public final void onChanged()
            {
                a();
            }

            public final void onInvalidated()
            {
                a();
            }

            
            {
                a = DragSortListView.this;
                super();
            }
        };
    }

    static float a(DragSortListView dragsortlistview)
    {
        return dragsortlistview.K;
    }

    static float a(DragSortListView dragsortlistview, float f1)
    {
        dragsortlistview.ag = f1;
        return f1;
    }

    private int a(int i1)
    {
        View view = getChildAt(i1 - getFirstVisiblePosition());
        if (view != null)
        {
            return view.getHeight();
        } else
        {
            return b(i1, b(i1));
        }
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
        int j2 = x - w;
        int i2 = b(i1);
        int k2 = a(i1);
        if (p <= r)
        {
            if (i1 == p && o != p)
            {
                if (i1 == r)
                {
                    k1 = (j1 + k2) - x;
                } else
                {
                    k1 = ((k2 - i2) + j1) - j2;
                }
            } else
            {
                k1 = j1;
                if (i1 > p)
                {
                    k1 = j1;
                    if (i1 <= r)
                    {
                        k1 = j1 - j2;
                    }
                }
            }
        } else
        if (i1 > r && i1 <= o)
        {
            k1 = j1 + j2;
        } else
        {
            k1 = j1;
            if (i1 == p)
            {
                k1 = j1;
                if (o != p)
                {
                    k1 = j1 + (k2 - i2);
                }
            }
        }
        if (i1 <= r)
        {
            return (x - l1 - b(i1 - 1)) / 2 + k1;
        } else
        {
            return (i2 - l1 - x) / 2 + k1;
        }
    }

    static int a(DragSortListView dragsortlistview, int i1)
    {
        dragsortlistview.v = i1;
        return i1;
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
                if (i1 > r)
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
        if (i1 != r && i1 != o && i1 != p)
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
        if (i1 != o && i1 != p) goto _L2; else goto _L1
_L1:
        if (i1 >= r) goto _L4; else goto _L3
_L3:
        ((DragSortItemView)view).setGravity(80);
_L2:
        k1 = view.getVisibility();
        flag1 = false;
        j1 = ((flag1) ? 1 : 0);
        if (i1 == r)
        {
            j1 = ((flag1) ? 1 : 0);
            if (f != null)
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
        if (i1 > r)
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
            O = N;
        }
        M = (int)motionevent.getX();
        N = (int)motionevent.getY();
        if (i1 == 0)
        {
            O = N;
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
        int j1 = ViewGroup.getChildMeasureSpec(z, getListPaddingLeft() + getListPaddingRight(), ((android.view.ViewGroup.LayoutParams) (obj)).width);
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

    static void a(DragSortListView dragsortlistview, int i1, View view)
    {
        dragsortlistview.a(i1, view, true);
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
            c(i1 + j1, view, true);
            return;
        }
    }

    static boolean a(DragSortListView dragsortlistview, boolean flag)
    {
        dragsortlistview.ab = flag;
        return flag;
    }

    private boolean a(boolean flag, float f1)
    {
        boolean flag1 = false;
        if (f != null)
        {
            B.a();
            if (flag)
            {
                a(r - getHeaderViewsCount(), f1);
            } else
            if (af != null)
            {
                af.c();
            } else
            {
                c();
            }
            if (W)
            {
                g g1 = aa;
                if (g1.d)
                {
                    g1.a.append("</DSLVStates>\n");
                    g1.a();
                    g1.d = false;
                }
            }
            flag1 = true;
        }
        return flag1;
    }

    static float b(DragSortListView dragsortlistview, float f1)
    {
        f1 = dragsortlistview.ag + f1;
        dragsortlistview.ag = f1;
        return f1;
    }

    private int b(int i1)
    {
        int j1;
        if (i1 == r)
        {
            j1 = 0;
        } else
        {
            View view = getChildAt(i1 - getFirstVisiblePosition());
            if (view != null)
            {
                return b(i1, view, false);
            }
            int l1 = ad.a.get(i1, -1);
            j1 = l1;
            if (l1 == -1)
            {
                Object obj = getAdapter();
                int k1 = ((ListAdapter) (obj)).getItemViewType(i1);
                int i2 = ((ListAdapter) (obj)).getViewTypeCount();
                if (i2 != A.length)
                {
                    A = new View[i2];
                }
                if (k1 >= 0)
                {
                    if (A[k1] == null)
                    {
                        obj = ((ListAdapter) (obj)).getView(i1, null, this);
                        A[k1] = ((View) (obj));
                    } else
                    {
                        obj = ((ListAdapter) (obj)).getView(i1, A[k1], this);
                    }
                } else
                {
                    obj = ((ListAdapter) (obj)).getView(i1, null, this);
                }
                k1 = b(i1, ((View) (obj)), true);
                obj = ad;
                i2 = ((k) (obj)).a.get(i1, -1);
                if (i2 != k1)
                {
                    if (i2 == -1)
                    {
                        if (((k) (obj)).a.size() == ((k) (obj)).c)
                        {
                            ((k) (obj)).a.delete(((Integer)((k) (obj)).b.remove(0)).intValue());
                        }
                    } else
                    {
                        ((k) (obj)).b.remove(Integer.valueOf(i1));
                    }
                    ((k) (obj)).a.put(i1, k1);
                    ((k) (obj)).b.add(Integer.valueOf(i1));
                }
                return k1;
            }
        }
        return j1;
    }

    private int b(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        getDividerHeight();
        if (q && o != p)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        l1 = x - w;
        i2 = (int)(U * (float)l1);
        if (i1 != r) goto _L2; else goto _L1
_L1:
        if (r != o) goto _L4; else goto _L3
_L3:
        if (k1 == 0) goto _L6; else goto _L5
_L5:
        k1 = i2 + w;
_L8:
        return k1;
_L6:
        return x;
_L4:
        if (r == p)
        {
            return x - i2;
        } else
        {
            return w;
        }
_L2:
        if (i1 == o)
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
        if (i1 == p)
        {
            return (j1 + l1) - i2;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int b(int i1, View view, boolean flag)
    {
        boolean flag1 = false;
        if (i1 == r)
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
        return dragsortlistview.v;
    }

    static int b(DragSortListView dragsortlistview, int i1, View view)
    {
        return dragsortlistview.b(i1, view, false);
    }

    private void b()
    {
        r = -1;
        o = -1;
        p = -1;
        n = -1;
    }

    static int c(DragSortListView dragsortlistview)
    {
        return dragsortlistview.y;
    }

    private void c()
    {
        v = 2;
        if (u != null && n >= 0 && n < getCount())
        {
            int i1 = getHeaderViewsCount();
            u.a(r - i1, n - i1);
        }
        j();
        e();
        b();
        h();
        if (b)
        {
            v = 3;
            return;
        } else
        {
            v = 0;
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
        int j3;
        int l3;
        int i4;
        ab = true;
        if (c != null)
        {
            h.set(M, N);
            c.a(g);
        }
        j1 = g.x;
        i2 = g.y;
        k1 = getPaddingLeft();
        float f1;
        float f2;
        View view1;
        View view2;
        int l2;
        int k3;
        if ((P & 1) == 0 && j1 > k1)
        {
            g.x = k1;
        } else
        if ((P & 2) == 0 && j1 < k1)
        {
            g.x = k1;
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
        if ((P & 8) == 0)
        {
            k1 = j1;
            if (j2 <= r)
            {
                k1 = Math.max(getChildAt(r - j2).getTop(), j1);
            }
        }
        j1 = getHeight() - getPaddingBottom();
        if (k2 >= getCount() - l1 - 1)
        {
            j1 = getChildAt(getCount() - l1 - 1 - j2).getBottom();
        }
        l1 = j1;
        if ((P & 4) == 0)
        {
            l1 = j1;
            if (k2 >= r)
            {
                l1 = Math.min(getChildAt(r - j2).getBottom(), j1);
            }
        }
        if (i2 < k1)
        {
            g.y = k1;
        } else
        if (x + i2 > l1)
        {
            g.y = l1 - x;
        }
        i = g.y + y;
        k3 = o;
        l3 = p;
        j1 = getFirstVisiblePosition();
        k1 = o;
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
        if (i >= j1) goto _L2; else goto _L1
_L1:
        i2 = j1;
        j2 = k1;
_L8:
        k1 = j2;
        l1 = i2;
        if (j2 < 0) goto _L4; else goto _L3
_L3:
        j2--;
        j1 = a(j2);
        if (j2 != 0) goto _L6; else goto _L5
_L5:
        j1 = k2 - i4 - j1;
        l1 = i2;
        k1 = j2;
_L4:
        j2 = getHeaderViewsCount();
        j3 = getFooterViewsCount();
        k2 = o;
        l2 = p;
        f1 = U;
        if (!q)
        {
            break MISSING_BLOCK_LABEL_1156;
        }
        i4 = Math.abs(j1 - l1);
        float f3;
        int i3;
        int j4;
        if (i >= j1)
        {
            i2 = l1;
            l1 = j1;
            j1 = i2;
        }
        f2 = T;
        i2 = (int)((float)i4 * (0.5F * f2));
        f3 = i2;
        l1 += i2;
        if (i < l1)
        {
            o = k1 - 1;
            p = k1;
            U = ((float)(l1 - i) * 0.5F) / f3;
        } else
        {
            if (i < j1 - i2)
            {
                break MISSING_BLOCK_LABEL_1156;
            }
            o = k1;
            p = k1 + 1;
            U = 0.5F * ((float)(j1 - i) / f3 + 1.0F);
        }
_L11:
label0:
        {
            {
                if (o < j2)
                {
                    o = j2;
                    p = j2;
                    k1 = j2;
                } else
                if (p >= getCount() - j3)
                {
                    k1 = getCount() - j3 - 1;
                    o = k1;
                    p = k1;
                }
                if (o != k2 || p != l2 || U != f1)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                if (k1 != n)
                {
                    n = k1;
                    k1 = 1;
                } else
                {
                    k1 = j1;
                }
                if (k1 == 0)
                {
                    break label0;
                }
                h();
                l1 = b(i1);
                j2 = view.getHeight();
                k2 = b(i1, l1);
                if (i1 != r)
                {
                    j1 = j2 - l1;
                    l1 = k2 - l1;
                } else
                {
                    j1 = j2;
                    l1 = k2;
                }
                l2 = x;
                i2 = l2;
                if (r != o)
                {
                    i2 = l2;
                    if (r != p)
                    {
                        i2 = l2 - w;
                    }
                }
                if (i1 <= k3)
                {
                    if (i1 <= o)
                    {
                        break MISSING_BLOCK_LABEL_1300;
                    }
                    j1 = (i2 - l1) + 0;
                } else
                if (i1 == l3)
                {
                    if (i1 <= o)
                    {
                        j1 = (j1 - i2) + 0;
                    } else
                    if (i1 == p)
                    {
                        j1 = (j2 - k2) + 0;
                    } else
                    {
                        j1 += 0;
                    }
                } else
                if (i1 <= o)
                {
                    j1 = 0 - i2;
                } else
                {
                    if (i1 != p)
                    {
                        break MISSING_BLOCK_LABEL_1300;
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
        ab = false;
        return;
_L6:
        i3 = k2 - (j1 + i4);
        k2 = a(j2, i3);
        k1 = j2;
        l1 = i2;
        j1 = k2;
        if (i >= k2) goto _L4; else goto _L7
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
        j3 = a(i2 + 1);
        k2 = a(i2 + 1, i3);
        k1 = i2;
        l1 = j2;
        j1 = k2;
        if (i < k2) goto _L4; else goto _L9
_L9:
        i2++;
        j2 = k2;
        j1 = k2;
        k2 = j3;
          goto _L10
        o = k1;
        p = k1;
          goto _L11
        j1 = 0;
        break MISSING_BLOCK_LABEL_798;
    }

    static void c(DragSortListView dragsortlistview, int i1, View view)
    {
        dragsortlistview.c(i1, view, false);
    }

    static Point d(DragSortListView dragsortlistview)
    {
        return dragsortlistview.g;
    }

    private void d()
    {
        v = 1;
        j();
        e();
        b();
        if (b)
        {
            v = 3;
            return;
        } else
        {
            v = 0;
            return;
        }
    }

    static int e(DragSortListView dragsortlistview)
    {
        return dragsortlistview.N;
    }

    private void e()
    {
        int i1 = 0;
        int j1 = getFirstVisiblePosition();
        if (r < j1)
        {
            View view = getChildAt(0);
            if (view != null)
            {
                i1 = view.getTop();
            }
            setSelectionFromTop(j1 - 1, i1 - getPaddingTop());
        }
    }

    private void f()
    {
        S = 0;
        b = false;
        if (v == 3)
        {
            v = 0;
        }
        m = l;
        e = false;
        k k1 = ad;
        k1.a.clear();
        k1.b.clear();
    }

    static void f(DragSortListView dragsortlistview)
    {
        dragsortlistview.a(true);
    }

    static int g(DragSortListView dragsortlistview)
    {
        return dragsortlistview.n;
    }

    private void g()
    {
        int i1 = getPaddingTop();
        int j1 = getHeight() - i1 - getPaddingBottom();
        float f1 = j1;
        H = (float)i1 + C * f1;
        float f2 = i1;
        G = f1 * (1.0F - D) + f2;
        E = (int)H;
        F = (int)G;
        I = H - (float)i1;
        J = (float)(i1 + j1) - G;
    }

    static int h(DragSortListView dragsortlistview)
    {
        return dragsortlistview.r;
    }

    private void h()
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

    static int i(DragSortListView dragsortlistview)
    {
        return dragsortlistview.w;
    }

    private void i()
    {
        if (f != null)
        {
            a(f);
            x = f.getMeasuredHeight();
            y = x / 2;
        }
    }

    static int j(DragSortListView dragsortlistview)
    {
        return dragsortlistview.x;
    }

    private void j()
    {
        if (f != null)
        {
            f.setVisibility(8);
            if (c != null)
            {
                j j1 = c;
                ((ImageView)f).setImageDrawable(null);
                j1.e.recycle();
                j1.e = null;
            }
            f = null;
            invalidate();
        }
    }

    static void k(DragSortListView dragsortlistview)
    {
        dragsortlistview.c();
    }

    static int l(DragSortListView dragsortlistview)
    {
        return dragsortlistview.o;
    }

    static int m(DragSortListView dragsortlistview)
    {
        return dragsortlistview.p;
    }

    static boolean n(DragSortListView dragsortlistview)
    {
        return dragsortlistview.d;
    }

    static float o(DragSortListView dragsortlistview)
    {
        return dragsortlistview.ag;
    }

    static void p(DragSortListView dragsortlistview)
    {
        dragsortlistview.j();
    }

    static void q(DragSortListView dragsortlistview)
    {
        dragsortlistview.getHeaderViewsCount();
        dragsortlistview.d();
    }

    static int r(DragSortListView dragsortlistview)
    {
        return dragsortlistview.i;
    }

    static float s(DragSortListView dragsortlistview)
    {
        return dragsortlistview.H;
    }

    static float t(DragSortListView dragsortlistview)
    {
        return dragsortlistview.I;
    }

    static d u(DragSortListView dragsortlistview)
    {
        return dragsortlistview.L;
    }

    static float v(DragSortListView dragsortlistview)
    {
        return dragsortlistview.G;
    }

    static float w(DragSortListView dragsortlistview)
    {
        return dragsortlistview.J;
    }

    public final void a()
    {
label0:
        {
            if (v == 4)
            {
                B.a();
                j();
                b();
                h();
                if (!b)
                {
                    break label0;
                }
                v = 3;
            }
            return;
        }
        v = 0;
    }

    public final void a(int i1, float f1)
    {
        if (v != 0 && v != 4) goto _L2; else goto _L1
_L1:
        if (v == 0)
        {
            r = getHeaderViewsCount() + i1;
            o = r;
            p = r;
            n = r;
            View view = getChildAt(r - getFirstVisiblePosition());
            if (view != null)
            {
                view.setVisibility(4);
            }
        }
        v = 1;
        ag = f1;
        if (!b) goto _L4; else goto _L3
_L3:
        S;
        JVM INSTR tableswitch 1 2: default 124
    //                   1 139
    //                   2 151;
           goto _L4 _L5 _L6
_L4:
        if (ae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ae.c();
_L2:
        return;
_L5:
        super.onTouchEvent(R);
        continue; /* Loop/switch isn't completed */
_L6:
        super.onInterceptTouchEvent(R);
        if (true) goto _L4; else goto _L7
_L7:
        d();
        return;
    }

    public final boolean a(float f1)
    {
        d = true;
        return a(true, f1);
    }

    public final boolean a(int i1, View view, int j1, int k1, int l1)
    {
        if (v != 0 || !b || f != null || view == null || !a)
        {
            return false;
        }
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        i1 = getHeaderViewsCount() + i1;
        o = i1;
        p = i1;
        r = i1;
        n = i1;
        v = 4;
        P = 0;
        P = P | j1;
        f = view;
        i();
        s = k1;
        t = l1;
        g.x = M - s;
        g.y = N - t;
        view = getChildAt(r - getFirstVisiblePosition());
        if (view != null)
        {
            view.setVisibility(4);
        }
        if (W)
        {
            view = aa;
            ((g) (view)).a.append("<DSLVStates>\n");
            view.c = 0;
            view.d = true;
        }
        S;
        JVM INSTR tableswitch 1 2: default 232
    //                   1 238
    //                   2 250;
           goto _L1 _L2 _L3
_L1:
        requestLayout();
        return true;
_L2:
        super.onTouchEvent(R);
        continue; /* Loop/switch isn't completed */
_L3:
        super.onInterceptTouchEvent(R);
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (v != 0)
        {
            if (o != r)
            {
                a(o, canvas);
            }
            if (p != o && p != r)
            {
                a(p, canvas);
            }
        }
        if (f != null)
        {
            int k1 = f.getWidth();
            int l1 = f.getHeight();
            int j1 = g.x;
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
            i1 = (int)(f1 * (255F * m));
            canvas.save();
            canvas.translate(g.x, g.y);
            canvas.clipRect(0, 0, k1, l1);
            canvas.saveLayerAlpha(0.0F, 0.0F, k1, l1, i1, 31);
            f.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    protected void layoutChildren()
    {
        super.layoutChildren();
        if (f != null)
        {
            if (f.isLayoutRequested() && !j)
            {
                i();
            }
            f.layout(0, 0, f.getMeasuredWidth(), f.getMeasuredHeight());
            j = false;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (W)
        {
            canvas = aa;
            if (((g) (canvas)).d)
            {
                ((g) (canvas)).a.append("<DSLVState>\n");
                int i2 = ((g) (canvas)).e.getChildCount();
                int j2 = ((g) (canvas)).e.getFirstVisiblePosition();
                ((g) (canvas)).a.append("    <Positions>");
                for (int i1 = 0; i1 < i2; i1++)
                {
                    ((g) (canvas)).a.append(j2 + i1).append(",");
                }

                ((g) (canvas)).a.append("</Positions>\n");
                ((g) (canvas)).a.append("    <Tops>");
                for (int j1 = 0; j1 < i2; j1++)
                {
                    ((g) (canvas)).a.append(((g) (canvas)).e.getChildAt(j1).getTop()).append(",");
                }

                ((g) (canvas)).a.append("</Tops>\n");
                ((g) (canvas)).a.append("    <Bottoms>");
                for (int k1 = 0; k1 < i2; k1++)
                {
                    ((g) (canvas)).a.append(((g) (canvas)).e.getChildAt(k1).getBottom()).append(",");
                }

                ((g) (canvas)).a.append("</Bottoms>\n");
                ((g) (canvas)).a.append("    <FirstExpPos>").append(((g) (canvas)).e.o).append("</FirstExpPos>\n");
                ((g) (canvas)).a.append("    <FirstExpBlankHeight>").append(((g) (canvas)).e.a(((g) (canvas)).e.o) - ((g) (canvas)).e.b(((g) (canvas)).e.o)).append("</FirstExpBlankHeight>\n");
                ((g) (canvas)).a.append("    <SecondExpPos>").append(((g) (canvas)).e.p).append("</SecondExpPos>\n");
                ((g) (canvas)).a.append("    <SecondExpBlankHeight>").append(((g) (canvas)).e.a(((g) (canvas)).e.p) - ((g) (canvas)).e.b(((g) (canvas)).e.p)).append("</SecondExpBlankHeight>\n");
                ((g) (canvas)).a.append("    <SrcPos>").append(((g) (canvas)).e.r).append("</SrcPos>\n");
                ((g) (canvas)).a.append("    <SrcHeight>").append(((g) (canvas)).e.x + ((g) (canvas)).e.getDividerHeight()).append("</SrcHeight>\n");
                ((g) (canvas)).a.append("    <ViewHeight>").append(((g) (canvas)).e.getHeight()).append("</ViewHeight>\n");
                ((g) (canvas)).a.append("    <LastY>").append(((g) (canvas)).e.O).append("</LastY>\n");
                ((g) (canvas)).a.append("    <FloatY>").append(((g) (canvas)).e.i).append("</FloatY>\n");
                ((g) (canvas)).a.append("    <ShuffleEdges>");
                for (int l1 = 0; l1 < i2; l1++)
                {
                    ((g) (canvas)).a.append(((g) (canvas)).e.a(j2 + l1, ((g) (canvas)).e.getChildAt(l1).getTop())).append(",");
                }

                ((g) (canvas)).a.append("</ShuffleEdges>\n");
                ((g) (canvas)).a.append("</DSLVState>\n");
                canvas.b = ((g) (canvas)).b + 1;
                if (((g) (canvas)).b > 1000)
                {
                    canvas.a();
                    canvas.b = 0;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        if (!a)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        a(motionevent);
        Q = true;
        i1 = motionevent.getAction() & 0xff;
        if (i1 == 0)
        {
            if (v != 0)
            {
                ac = true;
                return true;
            }
            b = true;
        }
        if (f == null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        if (i1 == 1 || i1 == 3)
        {
            b = false;
        }
        return flag;
_L2:
        if (super.onInterceptTouchEvent(motionevent))
        {
            e = true;
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
            f();
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        if (f != null)
        {
            if (f.isLayoutRequested())
            {
                i();
            }
            j = true;
        }
        z = i1;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        g();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (ac)
        {
            ac = false;
            return false;
        }
        if (!a)
        {
            return super.onTouchEvent(motionevent);
        }
        boolean flag = Q;
        Q = false;
        if (!flag)
        {
            a(motionevent);
        }
        if (v != 4) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 1 3: default 96
    //                   1 121
    //                   2 148
    //                   3 102;
           goto _L3 _L4 _L5 _L6
_L3:
        boolean flag2 = true;
_L8:
        return flag2;
_L6:
        if (v == 4)
        {
            a();
        }
        f();
        continue; /* Loop/switch isn't completed */
_L4:
        if (v == 4)
        {
            d = false;
            a(false, 0.0F);
        }
        f();
        continue; /* Loop/switch isn't completed */
_L5:
        int j1 = (int)motionevent.getX();
        int i1 = (int)motionevent.getY();
        g.x = j1 - s;
        g.y = i1 - t;
        a(true);
        j1 = Math.min(i1, i + y);
        int k1 = Math.max(i1, i - y);
        motionevent = B;
        if (((e) (motionevent)).b)
        {
            i1 = ((e) (motionevent)).a;
        } else
        {
            i1 = -1;
        }
        if (j1 > O && j1 > F && i1 != 1)
        {
            if (i1 != -1)
            {
                B.a();
            }
            B.a(1);
        } else
        if (k1 < O && k1 < E && i1 != 0)
        {
            if (i1 != -1)
            {
                B.a();
            }
            B.a(0);
        } else
        if (k1 >= E && j1 <= F && B.b)
        {
            B.a();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        boolean flag1;
        if (v == 0 && super.onTouchEvent(motionevent))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        switch (motionevent.getAction() & 0xff)
        {
        case 2: // '\002'
        default:
            flag2 = flag1;
            if (flag1)
            {
                S = 1;
                flag2 = flag1;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            f();
            flag2 = flag1;
            break;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L3; else goto _L9
_L9:
    }

    public void requestLayout()
    {
        if (!ab)
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
            V = new b(this, listadapter);
            listadapter.registerDataSetObserver(k);
            if (listadapter instanceof i)
            {
                setDropListener((i)listadapter);
            }
            if (listadapter instanceof c)
            {
                setDragListener((c)listadapter);
            }
            if (listadapter instanceof m)
            {
                setRemoveListener((m)listadapter);
            }
        } else
        {
            V = null;
        }
        super.setAdapter(V);
    }

    public void setDragEnabled(boolean flag)
    {
        a = flag;
    }

    public void setDragListener(c c1)
    {
    }

    public void setDragScrollProfile(d d1)
    {
        if (d1 != null)
        {
            L = d1;
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
            D = 0.5F;
        } else
        {
            D = f2;
        }
        if (f1 > 0.5F)
        {
            C = 0.5F;
        } else
        {
            C = f1;
        }
        if (getHeight() != 0)
        {
            g();
        }
    }

    public void setDragSortListener(f f1)
    {
        setDropListener(f1);
        setDragListener(f1);
        setRemoveListener(f1);
    }

    public void setDropListener(i i1)
    {
        u = i1;
    }

    public void setFloatViewManager(j j1)
    {
        c = j1;
    }

    public void setRemoveListener(m m1)
    {
    }
}

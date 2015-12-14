// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import com.huewu.pla.a.b;
import com.huewu.pla.a.c;
import com.huewu.pla.lib.a;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView, g, r, c, 
//            l, f, q

public class PLA_ListView extends PLA_AbsListView
{

    private ArrayList a;
    Drawable ad;
    int ae;
    Drawable af;
    Drawable ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private final Rect ao;
    private Paint ap;
    private ArrayList b;

    public PLA_ListView(Context context)
    {
        this(context, null);
    }

    public PLA_ListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, b.PLA_listViewStyle);
    }

    public PLA_ListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new ArrayList();
        b = new ArrayList();
        am = true;
        an = false;
        ao = new Rect();
        context = context.obtainStyledAttributes(attributeset, c.PLA_ListView, i, 0);
        attributeset = context.getDrawable(c.PLA_ListView_PLA_overScrollHeader);
        if (attributeset != null)
        {
            setOverscrollHeader(attributeset);
        }
        attributeset = context.getDrawable(c.PLA_ListView_PLA_overScrollFooter);
        if (attributeset != null)
        {
            setOverscrollFooter(attributeset);
        }
        i = context.getDimensionPixelSize(c.PLA_ListView_PLA_dividerHeight, 0);
        if (i != 0)
        {
            setDividerHeight(i);
        }
        ak = context.getBoolean(c.PLA_ListView_PLA_headerDividersEnabled, true);
        al = context.getBoolean(c.PLA_ListView_PLA_footerDividersEnabled, true);
        context.recycle();
    }

    private View a(int i)
    {
        E = Math.min(E, -1);
        E = Math.min(E, V - 1);
        if (E < 0)
        {
            E = 0;
        }
        return f(E, i);
    }

    private View a(int i, int k, boolean flag, boolean flag1)
    {
        if (!Q)
        {
            View view = this.i.c(i);
            if (view != null)
            {
                a(view, i, k, flag, d(i), flag1, true);
                return view;
            }
        }
        a(i, flag);
        int i1 = d(i);
        com.huewu.pla.lib.a.b((new StringBuilder()).append("makeAndAddView:").append(i).toString());
        View view1 = a(i, D);
        a(view1, i, k, flag, i1, flag1, D[0]);
        return view1;
    }

    private View a(View view, int i)
    {
        int k = i - 1;
        com.huewu.pla.lib.a.b((new StringBuilder()).append("addViewAbove:").append(i).toString());
        View view1 = a(k, D);
        a(view1, k, view.getTop() - ae, false, n.left, false, D[0]);
        return view1;
    }

    private void a(int i, int ai1[])
    {
        for (int k = 0; k < ai1.length; k++)
        {
            a(i + k, ai1[k], true, false);
            o();
        }

        E = i;
    }

    private void a(Canvas canvas)
    {
        if (getHeaderViewsCount() > 0)
        {
            canvas = ao;
            canvas.left = getLeft();
            canvas.right = getRight();
            if (e(getChildAt(getFirstVisiblePosition())))
            {
                canvas.top = ((r)a.get(a.size() - 1)).a.getBottom();
            } else
            {
                canvas.top = 0;
            }
            canvas.bottom = getBottom();
        }
    }

    private void a(View view, int i, int k)
    {
        com.huewu.pla.lib.internal.c c2 = (com.huewu.pla.lib.internal.c)view.getLayoutParams();
        com.huewu.pla.lib.internal.c c1 = c2;
        if (c2 == null)
        {
            c1 = new com.huewu.pla.lib.internal.c(-1, -2, 0);
            view.setLayoutParams(c1);
        }
        c1.a = e.getItemViewType(i);
        c1.d = true;
        k = ViewGroup.getChildMeasureSpec(k, n.left + n.right, c1.width);
        i = c1.height;
        if (i > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(k, i);
    }

    private void a(View view, int i, int k, boolean flag, int i1, boolean flag1, boolean flag2)
    {
        com.huewu.pla.lib.internal.c c1;
        com.huewu.pla.lib.internal.c c2;
        int j1;
        boolean flag3;
        int k1;
        int l1;
        boolean flag4;
        if (flag1 && f())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 != view.isSelected())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        j1 = v;
        if (j1 > 0 && j1 < 3 && q == i)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (flag4 != view.isPressed())
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (!flag2 || k1 != 0 || view.isLayoutRequested())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        c2 = (com.huewu.pla.lib.internal.c)view.getLayoutParams();
        c1 = c2;
        if (c2 == null)
        {
            c1 = new com.huewu.pla.lib.internal.c(-1, -2, 0);
        }
        c1.a = e.getItemViewType(i);
        c1.b = i;
        if (flag2 && !c1.d || c1.c && c1.a == -2)
        {
            byte byte0;
            if (flag)
            {
                byte0 = -1;
            } else
            {
                byte0 = 0;
            }
            attachViewToParent(view, byte0, c1);
        } else
        {
            c1.d = false;
            if (c1.a == -2)
            {
                c1.c = true;
            }
            byte byte1;
            if (flag)
            {
                byte1 = -1;
            } else
            {
                byte1 = 0;
            }
            addViewInLayout(view, byte1, c1, true);
        }
        if (k1 != 0)
        {
            view.setSelected(flag1);
        }
        if (l1 != 0)
        {
            view.setPressed(flag4);
        }
        if (flag3)
        {
            l1 = ViewGroup.getChildMeasureSpec(o, n.left + n.right, c1.width);
            k1 = c1.height;
            if (k1 > 0)
            {
                k1 = android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000);
            } else
            {
                k1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            a(view, i, l1, k1);
        } else
        {
            cleanupLayoutState(view);
        }
        k1 = view.getMeasuredWidth();
        l1 = view.getMeasuredHeight();
        if (!flag)
        {
            k -= l1;
        }
        if (flag3)
        {
            a(view, i, i1, k, i1 + k1, k + l1);
        } else
        {
            b(view, i, i1 - view.getLeft(), k - view.getTop());
        }
        if (p && !view.isDrawingCacheEnabled())
        {
            view.setDrawingCacheEnabled(true);
        }
    }

    private void a(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            int k = arraylist.size();
            for (int i = 0; i < k; i++)
            {
                com.huewu.pla.lib.internal.c c1 = (com.huewu.pla.lib.internal.c)((r)arraylist.get(i)).a.getLayoutParams();
                if (c1 != null)
                {
                    c1.c = false;
                }
            }

        }
    }

    private View b(View view, int i)
    {
        int k = i + 1;
        com.huewu.pla.lib.a.b((new StringBuilder()).append("addViewBelow:").append(i).toString());
        View view1 = a(k, D);
        i = view.getBottom();
        a(view1, k, ae + i, true, n.left, false, D[0]);
        return view1;
    }

    private boolean e(View view)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (((r)iterator.next()).a == view)
            {
                return true;
            }
        }

        return false;
    }

    private View f(int i, int k)
    {
        com.huewu.pla.lib.a.b((new StringBuilder()).append("fill down: ").append(i).toString());
        int i1 = getBottom();
        int j1 = getTop();
        for (int k1 = n.bottom; k < i1 - j1 - k1 && i < V; k = getFillChildBottom() + ae)
        {
            a(i, e(i), true, false);
            i++;
        }

        return null;
    }

    private View g(int i, int k)
    {
        com.huewu.pla.lib.a.b((new StringBuilder()).append("fill up: ").append(i).toString());
        for (int i1 = n.top; k > i1 && i >= 0; k = f(i))
        {
            a(i, f(i), false, false);
            i--;
        }

        E = i + 1;
        return null;
    }

    private View h(int i, int k)
    {
        View view;
        if (Q)
        {
            com.huewu.pla.lib.a.b((new StringBuilder()).append("fill specific: ").append(i).append(":").append(k).toString());
        }
        view = a(i, k, true, false);
        E = i;
        k = ae;
        if (A) goto _L2; else goto _L1
_L1:
        g(i - 1, getFillChildTop());
        o();
        f(i + 1, getFillChildBottom() + ae);
        i = getChildCount();
        if (i > 0)
        {
            m(i);
        }
_L4:
        return null;
_L2:
        f(i + 1, view.getBottom() + k);
        o();
        g(i - 1, getFillChildTop());
        i = getChildCount();
        if (i > 0)
        {
            n(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void m(int i)
    {
        if ((E + i) - 1 == V - 1 && i > 0)
        {
            i = getScrollChildBottom();
            int k = getBottom() - getTop() - n.bottom - i;
            int i1 = getScrollChildTop();
            if (k > 0 && (E > 0 || i1 < n.top))
            {
                i = k;
                if (E == 0)
                {
                    i = Math.min(k, n.top - i1);
                }
                i(i);
                if (E > 0)
                {
                    g(E - 1, getFillChildTop());
                    o();
                }
            }
        }
    }

    private void n(int i)
    {
        if (E == 0 && i > 0)
        {
            int k = getScrollChildTop();
            int j1 = n.top;
            int i1 = getBottom() - getTop() - n.bottom;
            k -= j1;
            j1 = getScrollChildBottom();
            int k1 = (E + i) - 1;
            if (k > 0)
            {
                if (k1 < V - 1 || j1 > i1)
                {
                    i = k;
                    if (k1 == V - 1)
                    {
                        i = Math.min(k, j1 - i1);
                    }
                    i(-i);
                    if (k1 < V - 1)
                    {
                        f(k1 + 1, getFillChildBottom() + ae);
                        o();
                    }
                } else
                if (k1 == V - 1)
                {
                    o();
                    return;
                }
            }
        }
    }

    private void o()
    {
        boolean flag;
        int j1;
        flag = false;
        j1 = getChildCount();
        if (j1 <= 0) goto _L2; else goto _L1
_L1:
        if (A) goto _L4; else goto _L3
_L3:
        int i1;
        i1 = getScrollChildTop() - n.top;
        int i = i1;
        if (E != 0)
        {
            i = i1 - ae;
        }
        i1 = i;
        if (i < 0)
        {
            i1 = ((flag) ? 1 : 0);
        }
_L6:
        if (i1 != 0)
        {
            i(-i1);
        }
_L2:
        return;
_L4:
        i1 = getScrollChildBottom() - (getHeight() - n.bottom);
        int k = i1;
        if (j1 + E < V)
        {
            k = i1 + ae;
        }
        i1 = ((flag) ? 1 : 0);
        if (k <= 0)
        {
            i1 = k;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void o(int i)
    {
        i(i);
        int k = getHeight() - n.bottom;
        int i1 = n.top;
        g g1 = this.i;
        if (i < 0)
        {
            View view = getLastChild();
            i = getChildCount();
            do
            {
                if (view.getBottom() >= k)
                {
                    break;
                }
                int j1 = (E + i) - 1;
                if (j1 >= V - 1)
                {
                    break;
                }
                b(view, j1);
                view = getLastChild();
                i++;
            } while (true);
            if (view.getBottom() < k)
            {
                i(k - view.getBottom());
            }
            view = getChildAt(0);
            while (view.getBottom() < i1) 
            {
                if (g1.b(((com.huewu.pla.lib.internal.c)view.getLayoutParams()).a))
                {
                    detachViewFromParent(view);
                    g1.a(view);
                } else
                {
                    removeViewInLayout(view);
                }
                view = getChildAt(0);
                E = E + 1;
            }
        } else
        {
            View view1;
            for (view1 = getChildAt(0); view1.getTop() > i1 && E > 0; E = E - 1)
            {
                view1 = a(view1, E);
            }

            if (view1.getTop() > i1)
            {
                i(i1 - view1.getTop());
            }
            i = getChildCount() - 1;
            view1 = getChildAt(i);
            while (view1.getTop() > k) 
            {
                if (g1.b(((com.huewu.pla.lib.internal.c)view1.getLayoutParams()).a))
                {
                    detachViewFromParent(view1);
                    g1.a(view1);
                } else
                {
                    removeViewInLayout(view1);
                }
                i--;
                view1 = getChildAt(i);
            }
        }
    }

    private boolean p()
    {
        boolean flag = false;
        int i = getScrollY();
        int k = n.top;
        if (E > 0 || getChildAt(0).getTop() > i + k)
        {
            flag = true;
        }
        return flag;
    }

    private boolean q()
    {
        int i = getChildCount();
        int k = getChildAt(i - 1).getBottom();
        int i1 = E;
        int j1 = getScrollY();
        int k1 = getHeight();
        int l1 = n.bottom;
        return (i + i1) - 1 < V - 1 || k < (j1 + k1) - l1;
    }

    final int a(int i, int k, int i1, int j1, int k1)
    {
        Object obj;
        int j2;
        j2 = 0;
        obj = e;
        if (obj != null) goto _L2; else goto _L1
_L1:
        i = n.top + n.bottom;
_L4:
        return i;
_L2:
        int k2 = n.top + n.bottom;
        boolean aflag[];
        int l1;
        int i2;
        boolean flag;
        if (ae > 0 && ad != null)
        {
            l1 = ae;
        } else
        {
            l1 = 0;
        }
        i2 = i1;
        if (i1 == -1)
        {
            i2 = ((ListAdapter) (obj)).getCount() - 1;
        }
        obj = this.i;
        flag = n();
        aflag = D;
        i1 = k;
        k = k2;
        while (i1 <= i2) 
        {
            com.huewu.pla.lib.a.b((new StringBuilder()).append("measureHeightOfChildren:").append(i1).toString());
            View view = a(i1, aflag);
            a(view, i1, i);
            if (i1 > 0)
            {
                k += l1;
            }
            if (flag && ((g) (obj)).b(((com.huewu.pla.lib.internal.c)view.getLayoutParams()).a))
            {
                com.huewu.pla.lib.a.b("measureHeightOfChildren");
                ((g) (obj)).a(view);
            }
            k = view.getMeasuredHeight() + k;
            if (k >= j1)
            {
                i = j1;
                if (k1 >= 0)
                {
                    i = j1;
                    if (i1 > k1)
                    {
                        i = j1;
                        if (j2 > 0)
                        {
                            i = j1;
                            if (k != j1)
                            {
                                return j2;
                            }
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
            }
            int l2 = j2;
            if (k1 >= 0)
            {
                l2 = j2;
                if (i1 >= k1)
                {
                    l2 = k;
                }
            }
            i1++;
            j2 = l2;
        }
        return k;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(int i, boolean flag)
    {
    }

    void a(Canvas canvas, Rect rect, int i)
    {
        Drawable drawable = ad;
        boolean flag = aj;
        if (!flag)
        {
            drawable.setBounds(rect);
        } else
        {
            canvas.save();
            canvas.clipRect(rect);
        }
        drawable.draw(canvas);
        if (flag)
        {
            canvas.restore();
        }
    }

    void a(Canvas canvas, Drawable drawable, Rect rect)
    {
        int i = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.bottom - rect.top < i)
        {
            rect.top = rect.bottom - i;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    protected void a(View view, int i, int k, int i1)
    {
        view.measure(k, i1);
    }

    protected void a(View view, int i, int k, int i1, int j1, int k1)
    {
        view.layout(k, i1, j1, k1);
    }

    public void a(View view, Object obj, boolean flag)
    {
        if (e != null)
        {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        } else
        {
            r r1 = new r(this);
            r1.a = view;
            r1.b = obj;
            r1.c = flag;
            a.add(r1);
            return;
        }
    }

    protected void a(boolean flag)
    {
        if (flag)
        {
            m(getChildCount());
            return;
        } else
        {
            n(getChildCount());
            return;
        }
    }

    int b(int i, boolean flag)
    {
        ListAdapter listadapter = e;
        if (listadapter != null && !isInTouchMode()) goto _L2; else goto _L1
_L1:
        int k = -1;
_L4:
        return k;
_L2:
        int i1;
        i1 = listadapter.getCount();
        if (am)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        if (flag)
        {
            k = Math.max(0, i);
            do
            {
                i = k;
                if (k >= i1)
                {
                    break;
                }
                i = k;
                if (listadapter.isEnabled(k))
                {
                    break;
                }
                k++;
            } while (true);
        } else
        {
            k = Math.min(i, i1 - 1);
            do
            {
                i = k;
                if (k < 0)
                {
                    break;
                }
                i = k;
                if (listadapter.isEnabled(k))
                {
                    break;
                }
                k--;
            } while (true);
        }
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        if (i < i1) goto _L4; else goto _L3
_L3:
        return -1;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        if (i < i1) goto _L4; else goto _L5
_L5:
        return -1;
    }

    void b(Canvas canvas, Drawable drawable, Rect rect)
    {
        int i = drawable.getMinimumHeight();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.bottom - rect.top < i)
        {
            rect.bottom = i + rect.top;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    protected void b(View view, int i, int k, int i1)
    {
        view.offsetLeftAndRight(k);
        view.offsetTopAndBottom(i1);
    }

    public void b(View view, Object obj, boolean flag)
    {
        r r1 = new r(this);
        r1.a = view;
        r1.b = obj;
        r1.c = flag;
        b.add(r1);
        if (d != null)
        {
            d.onChanged();
        }
    }

    protected void b(boolean flag)
    {
        int i = getChildCount();
        if (flag)
        {
            f(i + E, getFillChildBottom() + ae);
        } else
        {
            g(E - 1, getFillChildTop());
        }
        a(flag);
    }

    public boolean b(View view, int i, long l1)
    {
        return false | super.b(view, i, l1);
    }

    void c()
    {
        a(a);
        a(b);
        super.c();
        c = 0;
    }

    public void c(View view)
    {
        a(view, null, true);
    }

    protected boolean canAnimate()
    {
        return super.canAnimate() && V > 0;
    }

    protected int d(int i)
    {
        return n.left;
    }

    protected void d()
    {
        boolean flag = ac;
        if (flag) goto _L2; else goto _L1
_L1:
        ac = true;
        invalidate();
        if (e != null) goto _L4; else goto _L3
_L3:
        c();
        a();
        if (!flag)
        {
            ac = false;
        }
_L2:
        return;
_L4:
        Object obj;
        int k;
        int i1;
        int j1;
        k = getFillChildBottom() + ae;
        i1 = getFillChildTop();
        j1 = getChildCount();
        switch (c)
        {
        case 2: // '\002'
        default:
            obj = getChildAt(0);
            break;

        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            break MISSING_BLOCK_LABEL_155;
        }
_L5:
        boolean flag1 = Q;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        h();
        if (V != 0)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        c();
        a();
        if (!flag)
        {
            ac = false;
            return;
        }
          goto _L2
        obj = null;
          goto _L5
        if (V != e.getCount())
        {
            throw new IllegalStateException((new StringBuilder()).append("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(").append(getId()).append(", ").append(getClass()).append(") with Adapter(").append(e.getClass()).append(")]").toString());
        }
        break MISSING_BLOCK_LABEL_255;
          goto _L2
        obj;
        if (!flag)
        {
            ac = false;
        }
        throw obj;
        g g1;
        int i;
        i = E;
        g1 = this.i;
        if (!flag1) goto _L7; else goto _L6
_L6:
        i = j1 - 1;
_L9:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        g1.a(getChildAt(i));
        i--;
        if (true) goto _L9; else goto _L8
_L7:
        g1.a(j1, i);
_L8:
        c;
        JVM INSTR tableswitch 1 5: default 731
    //                   1 566
    //                   2 340
    //                   3 542
    //                   4 589
    //                   5 446;
           goto _L10 _L11 _L10 _L12 _L13 _L14
_L10:
        if (j1 != 0) goto _L16; else goto _L15
_L15:
        detachAllViewsFromParent();
        if (A) goto _L18; else goto _L17
_L17:
        a(k);
_L22:
        g1.c();
        if (v <= 0 || v >= 3)
        {
            break MISSING_BLOCK_LABEL_713;
        }
        obj = getChildAt(q - E);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        a(((View) (obj)));
_L26:
        c = 0;
        Q = false;
        K = false;
        if (V > 0)
        {
            k();
        }
        a();
        if (flag) goto _L2; else goto _L19
_L19:
        ac = false;
        return;
_L14:
        b(H);
        detachAllViewsFromParent();
        if (G == null)
        {
            break MISSING_BLOCK_LABEL_526;
        }
        if (H + G.length > V) goto _L21; else goto _L20
_L20:
        a(H, G);
_L23:
        G = null;
_L24:
        c(H);
          goto _L22
_L21:
        h(H, F);
          goto _L23
        h(H, F);
          goto _L24
_L12:
        detachAllViewsFromParent();
        g(V - 1, i1);
        o();
          goto _L22
_L11:
        detachAllViewsFromParent();
        E = 0;
        a(k);
        o();
          goto _L22
_L13:
        detachAllViewsFromParent();
        h(g(), F);
          goto _L22
_L18:
        g(V - 1, i1);
          goto _L22
_L16:
        if (E >= V)
        {
            break MISSING_BLOCK_LABEL_688;
        }
        b(E);
        detachAllViewsFromParent();
        i1 = E;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_680;
        }
        i = k;
_L25:
        h(i1, i);
        c(E);
          goto _L22
        i = ((View) (obj)).getTop();
          goto _L25
        b(0);
        detachAllViewsFromParent();
        h(0, k);
        c(0);
          goto _L22
        z = 0;
        h.setEmpty();
          goto _L26
    }

    public boolean d(View view)
    {
        ArrayList arraylist = a;
        int i1 = arraylist.size();
        for (int i = 0; i < i1; i++)
        {
            if (((r)arraylist.get(i)).a == view)
            {
                return true;
            }
        }

        arraylist = b;
        i1 = arraylist.size();
        for (int k = 0; k < i1; k++)
        {
            if (((r)arraylist.get(k)).a == view)
            {
                return true;
            }
        }

        return false;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        Drawable drawable;
        Drawable drawable1;
        Rect rect;
        ListAdapter listadapter;
        Paint paint;
        int i;
        boolean flag;
        int i1;
        boolean flag1;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        j2 = ae;
        drawable = af;
        drawable1 = ag;
        int j1;
        if (drawable != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (drawable1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j2 > 0 && ad != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        a(canvas);
        if (i1 == 0 && i == 0 && !flag) goto _L2; else goto _L1
_L1:
        rect = ao;
        rect.left = getPaddingLeft();
        rect.right = getRight() - getLeft() - getPaddingRight();
        k2 = getChildCount();
        i3 = a.size();
        l3 = V;
        j3 = l3 - b.size() - 1;
        flag2 = ak;
        flag3 = al;
        l2 = E;
        flag4 = am;
        listadapter = e;
        if (i1 != 0 && isOpaque() && !super.isOpaque())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 && ap == null && ah)
        {
            ap = new Paint();
            ap.setColor(getCacheColorHint());
        }
        paint = ap;
        k3 = (getBottom() - getTop() - n.bottom) + getScrollY();
        if (A) goto _L4; else goto _L3
_L3:
        j1 = getScrollY();
        if (k2 <= 0 || j1 >= 0) goto _L6; else goto _L5
_L5:
        if (i == 0) goto _L8; else goto _L7
_L7:
        rect.bottom = 0;
        rect.top = j1;
        a(canvas, drawable, rect);
          goto _L6
_L8:
        if (i1 != 0)
        {
            rect.bottom = 0;
            rect.top = -j2;
            a(canvas, rect, -1);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0;
        j1 = 0;
label0:
        do
        {
label1:
            {
                if (j1 >= k2)
                {
                    break label0;
                }
                int l1;
                if (!flag2)
                {
                    l1 = i;
                    if (l2 + j1 < i3)
                    {
                        break label1;
                    }
                }
                if (!flag3)
                {
                    l1 = i;
                    if (l2 + j1 >= j3)
                    {
                        break label1;
                    }
                }
                i = getChildAt(j1).getBottom();
                l1 = i;
                if (i1 == 0)
                {
                    break label1;
                }
                l1 = i;
                if (i >= k3)
                {
                    break label1;
                }
                if (flag)
                {
                    l1 = i;
                    if (j1 == k2 - 1)
                    {
                        break label1;
                    }
                }
                if (flag4 || listadapter.isEnabled(l2 + j1) && (j1 == k2 - 1 || listadapter.isEnabled(l2 + j1 + 1)))
                {
                    rect.top = i;
                    rect.bottom = i + j2;
                    a(canvas, rect, j1);
                    l1 = i;
                } else
                {
                    l1 = i;
                    if (flag1)
                    {
                        rect.top = i;
                        rect.bottom = i + j2;
                        canvas.drawRect(rect, paint);
                        l1 = i;
                    }
                }
            }
            j1++;
            i = l1;
        } while (true);
        i1 = getBottom() + getScrollY();
        if (flag && l2 + k2 == l3 && i1 > i)
        {
            rect.top = i;
            rect.bottom = i1;
            b(canvas, drawable1, rect);
        }
_L2:
        super.dispatchDraw(canvas);
        return;
_L4:
        int i2 = n.top;
        int k1 = getScrollY();
        if (k2 > 0 && i != 0)
        {
            rect.top = k1;
            rect.bottom = getChildAt(0).getTop();
            a(canvas, drawable, rect);
        }
        if (i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        while (i < k2) 
        {
            if (!flag2 && l2 + i < i3 || !flag3 && l2 + i >= j3)
            {
                continue;
            }
            int i4 = getChildAt(i).getTop();
            if (i1 != 0 && i4 > i2)
            {
                if (flag4 || listadapter.isEnabled(l2 + i) && (i == k2 - 1 || listadapter.isEnabled(l2 + i + 1)))
                {
                    rect.top = i4 - j2;
                    rect.bottom = i4;
                    a(canvas, rect, i - 1);
                } else
                if (flag1)
                {
                    rect.top = i4 - j2;
                    rect.bottom = i4;
                    canvas.drawRect(rect, paint);
                }
            }
            i++;
        }
        if (k2 > 0 && k1 > 0)
        {
            if (flag)
            {
                int k = getBottom();
                rect.top = k;
                rect.bottom = k + k1;
                b(canvas, drawable1, rect);
            } else
            if (i1 != 0)
            {
                rect.top = k3;
                rect.bottom = k3 + j2;
                a(canvas, rect, -1);
            }
        }
        if (true) goto _L2; else goto _L9
_L9:
        if (true) goto _L6; else goto _L10
_L10:
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        int i1 = 0;
        int i = 0;
        boolean flag = super.dispatchPopulateAccessibilityEvent(accessibilityevent);
        if (!flag)
        {
            int k = getSelectedItemPosition();
            ListAdapter listadapter = getAdapter();
            int k1 = k;
            if (listadapter != null)
            {
                int l1 = listadapter.getCount();
                if (l1 < 15)
                {
                    int j1 = 0;
                    do
                    {
                        k1 = k;
                        i1 = i;
                        if (j1 >= l1)
                        {
                            break;
                        }
                        if (listadapter.isEnabled(j1))
                        {
                            k1 = i + 1;
                            i1 = k;
                        } else
                        {
                            i1 = k;
                            k1 = i;
                            if (j1 <= k)
                            {
                                i1 = k - 1;
                                k1 = i;
                            }
                        }
                        j1++;
                        k = i1;
                        i = k1;
                    } while (true);
                } else
                {
                    i1 = l1;
                    k1 = k;
                }
            }
            accessibilityevent.setItemCount(i1);
            accessibilityevent.setCurrentItemIndex(k1);
        }
        return flag;
    }

    protected int e(int i)
    {
        i = getChildCount();
        if (i > 0)
        {
            return getChildAt(i - 1).getBottom() + ae;
        } else
        {
            return getListPaddingTop();
        }
    }

    public void e(int i, int k)
    {
        if (e != null)
        {
            if (!isInTouchMode())
            {
                int i1 = b(i, true);
                i = i1;
                if (i1 >= 0)
                {
                    setNextSelectedPositionInt(i1);
                    i = i1;
                }
            } else
            {
                C = i;
            }
            if (i >= 0)
            {
                c = 4;
                F = n.top + k;
                if (K)
                {
                    H = i;
                    I = e.getItemId(i);
                }
                if (y != null)
                {
                    y.a();
                }
                requestLayout();
                return;
            }
        }
    }

    protected int f(int i)
    {
        if (getChildCount() > 0)
        {
            return getChildAt(0).getTop() - ae;
        } else
        {
            return getHeight() - getListPaddingBottom();
        }
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return e;
    }

    public long[] getCheckItemIds()
    {
        if (e != null && e.hasStableIds())
        {
            return getCheckedItemIds();
        } else
        {
            return new long[0];
        }
    }

    public long[] getCheckedItemIds()
    {
        return new long[0];
    }

    public int getCheckedItemPosition()
    {
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions()
    {
        return null;
    }

    public Drawable getDivider()
    {
        return ad;
    }

    public int getDividerHeight()
    {
        return ae;
    }

    public int getFirstVisiblePosition()
    {
        return Math.max(0, E - getHeaderViewsCount());
    }

    public int getFooterViewsCount()
    {
        return b.size();
    }

    public int getHeaderViewsCount()
    {
        return a.size();
    }

    public boolean getItemsCanFocus()
    {
        return an;
    }

    protected View getLastChild()
    {
        return getChildAt(getChildCount() - 1);
    }

    public int getLastVisiblePosition()
    {
        return Math.min((E + getChildCount()) - 1, e.getCount() - 1);
    }

    public int getMaxScrollAmount()
    {
        return (int)(0.33F * (float)(getBottom() - getTop()));
    }

    public Drawable getOverscrollFooter()
    {
        return ag;
    }

    public Drawable getOverscrollHeader()
    {
        return af;
    }

    public boolean isOpaque()
    {
        return p && ah && ai || super.isOpaque();
    }

    int j(int i)
    {
        int j1 = getChildCount();
        if (j1 > 0)
        {
            if (!A)
            {
                for (int k = 0; k < j1; k++)
                {
                    if (i <= getChildAt(k).getBottom())
                    {
                        return k + E;
                    }
                }

            } else
            {
                for (int i1 = j1 - 1; i1 >= 0; i1--)
                {
                    if (i >= getChildAt(i1).getTop())
                    {
                        return i1 + E;
                    }
                }

            }
        }
        return -1;
    }

    public boolean l(int i)
    {
        boolean flag1 = true;
        if (i != 33) goto _L2; else goto _L1
_L1:
        if (b(0, true) < 0) goto _L4; else goto _L3
_L3:
        boolean flag;
        c = 1;
        a();
        flag = flag1;
_L6:
        if (flag && !awakenScrollBars())
        {
            awakenScrollBars();
            invalidate();
        }
        return flag;
_L2:
        if (i == 130)
        {
            flag = flag1;
            if (b(V - 1, true) >= 0)
            {
                c = 3;
                a();
                flag = flag1;
            }
            continue; /* Loop/switch isn't completed */
        }
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected boolean n()
    {
        return true;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        int k = getChildCount();
        if (k > 0)
        {
            for (int i = 0; i < k; i++)
            {
                c(getChildAt(i));
            }

            removeAllViews();
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        int i1 = 0;
        super.onFocusChanged(flag, i, rect);
        int k = -1;
        int k1 = k;
        if (flag)
        {
            k1 = k;
            if (rect != null)
            {
                rect.offset(getScrollX(), getScrollY());
                ListAdapter listadapter = e;
                if (listadapter.getCount() < getChildCount() + E)
                {
                    c = 0;
                    d();
                }
                Rect rect1 = ao;
                int j1 = 0x7fffffff;
                int l1 = getChildCount();
                int i2 = E;
                do
                {
                    k1 = k;
                    if (i1 >= l1)
                    {
                        break;
                    }
                    if (listadapter.isEnabled(i2 + i1))
                    {
                        View view = getChildAt(i1);
                        view.getDrawingRect(rect1);
                        offsetDescendantRectToMyCoords(view, rect1);
                        k1 = a(rect, rect1, i);
                        if (k1 < j1)
                        {
                            j1 = k1;
                            k = i1;
                        }
                    }
                    i1++;
                } while (true);
            }
        }
        if (k1 >= 0)
        {
            setSelection(E + k1);
            return;
        } else
        {
            requestLayout();
            return;
        }
    }

    protected void onMeasure(int i, int k)
    {
        super.onMeasure(i, k);
        int i2 = android.view.View.MeasureSpec.getMode(i);
        int l1 = android.view.View.MeasureSpec.getMode(k);
        int j1 = android.view.View.MeasureSpec.getSize(i);
        int k1 = android.view.View.MeasureSpec.getSize(k);
        int i1;
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.getCount();
        }
        V = k;
        if (V > 0 && (i2 == 0 || l1 == 0))
        {
            View view = a(0, D);
            a(view, 0, i);
            k = view.getMeasuredWidth();
            i1 = view.getMeasuredHeight();
            if (n() && this.i.b(((com.huewu.pla.lib.internal.c)view.getLayoutParams()).a))
            {
                this.i.a(view);
            }
        } else
        {
            i1 = 0;
            k = 0;
        }
        if (i2 == 0)
        {
            j1 = k + (n.left + n.right) + getVerticalScrollbarWidth();
        }
        k = k1;
        if (l1 == 0)
        {
            k = n.top + n.bottom + i1 + getVerticalFadingEdgeLength() * 2;
        }
        i1 = k;
        if (l1 == 0x80000000)
        {
            i1 = a(i, 0, -1, k, -1);
        }
        setMeasuredDimension(j1, i1);
        o = i;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (an && motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = super.onTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return false;
        }
        return flag;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        int k1 = rect.top;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int j1 = getHeight();
        int k = getScrollY();
        int i1 = k + j1;
        int l1 = getVerticalFadingEdgeLength();
        int i = k;
        if (p())
        {
            i = k;
            if (k1 > l1)
            {
                i = k + l1;
            }
        }
        k1 = getChildAt(getChildCount() - 1).getBottom();
        k = i1;
        if (q())
        {
            k = i1;
            if (rect.bottom < k1 - l1)
            {
                k = i1 - l1;
            }
        }
        if (rect.bottom > k && rect.top > i)
        {
            if (rect.height() > j1)
            {
                i = (rect.top - i) + 0;
            } else
            {
                i = (rect.bottom - k) + 0;
            }
            i = Math.min(i, k1 - k);
        } else
        if (rect.top < i && rect.bottom < k)
        {
            if (rect.height() > j1)
            {
                k = 0 - (k - rect.bottom);
            } else
            {
                k = 0 - (i - rect.top);
            }
            i = Math.max(k, getChildAt(0).getTop() - i);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            o(-i);
            a(view);
            z = view.getTop();
            invalidate();
        }
        return flag;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (e != null)
        {
            e.unregisterDataSetObserver(d);
        }
        c();
        i.b();
        if (a.size() > 0 || b.size() > 0)
        {
            e = new q(a, b, listadapter);
        } else
        {
            e = listadapter;
        }
        aa = -1;
        ab = 0x8000000000000000L;
        if (e != null)
        {
            am = e.areAllItemsEnabled();
            W = V;
            V = e.getCount();
            d = new l(this);
            e.registerDataSetObserver(d);
            i.a(e.getViewTypeCount());
        } else
        {
            am = true;
        }
        requestLayout();
    }

    public void setCacheColorHint(int i)
    {
        boolean flag;
        if (i >>> 24 == 255)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ah = flag;
        if (flag)
        {
            if (ap == null)
            {
                ap = new Paint();
            }
            ap.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable)
    {
        boolean flag = false;
        if (drawable != null)
        {
            ae = drawable.getIntrinsicHeight();
            aj = drawable instanceof ColorDrawable;
        } else
        {
            ae = 0;
            aj = false;
        }
        ad = drawable;
        if (drawable == null || drawable.getOpacity() == -1)
        {
            flag = true;
        }
        ai = flag;
        b();
    }

    public void setDividerHeight(int i)
    {
        ae = i;
        b();
    }

    public void setFooterDividersEnabled(boolean flag)
    {
        al = flag;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean flag)
    {
        ak = flag;
        invalidate();
    }

    public void setItemsCanFocus(boolean flag)
    {
        an = flag;
        if (!flag)
        {
            setDescendantFocusability(0x60000);
        }
    }

    public void setOverscrollFooter(Drawable drawable)
    {
        ag = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable)
    {
        af = drawable;
        if (getScrollY() < 0)
        {
            invalidate();
        }
    }

    public void setSelection(int i)
    {
        e(i, 0);
    }
}

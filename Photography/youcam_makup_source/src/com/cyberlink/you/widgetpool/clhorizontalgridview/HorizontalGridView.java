// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.KeyEventCompat;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.cyberlink.you.t;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AbsListView, i, e, n, 
//            h

public class HorizontalGridView extends AbsListView
{

    private int aA;
    private final Rect aB;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private int aw;
    private int ax;
    private View ay;
    private View az;

    public HorizontalGridView(Context context)
    {
        this(context, null);
    }

    public HorizontalGridView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010071);
    }

    public HorizontalGridView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        aq = -1;
        ar = 0;
        as = 0;
        au = 2;
        ay = null;
        az = null;
        aA = 0x800003;
        aB = new Rect();
        context = context.obtainStyledAttributes(attributeset, t.HorizontalGridView, i1, 0);
        setHorizontalSpacing(context.getDimensionPixelOffset(t.HorizontalGridView_horizontalSpacing, 0));
        setVerticalSpacing(context.getDimensionPixelOffset(t.HorizontalGridView_verticalSpacing, 0));
        i1 = context.getInt(t.HorizontalGridView_stretchMode, 2);
        if (i1 >= 0)
        {
            setStretchMode(i1);
        }
        i1 = context.getDimensionPixelOffset(t.HorizontalGridView_rowHeight, -1);
        if (i1 > 0)
        {
            setRowHeight(i1);
        }
        setNumRows(context.getInt(t.HorizontalGridView_numRows, 1));
        i1 = context.getInt(t.HorizontalGridView_android_gravity, -1);
        if (i1 >= 0)
        {
            setGravity(i1);
        }
        context.recycle();
    }

    private int a(int i1, int j1, int k1, int l1)
    {
        int i2 = i1;
        if ((l1 + k1) - 1 < al - 1)
        {
            i2 = i1 - j1;
        }
        return i2;
    }

    private View a(int i1, int j1, boolean flag, int k1, boolean flag1, int l1)
    {
        if (!ag)
        {
            View view = m.c(i1);
            if (view != null)
            {
                a(view, i1, j1, flag, k1, flag1, true, l1);
                return view;
            }
        }
        View view1 = a(i1, M);
        a(view1, i1, j1, flag, k1, flag1, M[0], l1);
        return view1;
    }

    private void a(int i1, int j1, int k1)
    {
        if ((S + k1) - 1 == al - 1 && k1 > 0)
        {
            k1 = getChildAt(k1 - 1).getRight();
            int l1 = getRight() - getLeft() - r.right - k1;
            View view = getChildAt(0);
            int i2 = view.getLeft();
            if (l1 > 0 && (S > 0 || i2 < r.left))
            {
                k1 = l1;
                if (S == 0)
                {
                    k1 = Math.min(l1, r.left - i2);
                }
                d(k1);
                if (S > 0)
                {
                    k1 = S;
                    if (H)
                    {
                        i1 = 1;
                    }
                    d(k1 - i1, view.getLeft() - j1);
                    x();
                }
            }
        }
    }

    private void a(View view, int i1, int j1)
    {
        if (view.getRight() > j1)
        {
            d(-Math.min(view.getLeft() - i1, view.getRight() - j1));
        }
    }

    private void a(View view, int i1, int j1, boolean flag, int k1, boolean flag1, boolean flag2, 
            int l1)
    {
        int l2;
        e e1;
        int i2;
        boolean flag3;
        int j2;
        int k2;
        boolean flag4;
        if (flag1 && i())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 != view.isSelected())
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        i2 = C;
        if (i2 > 0 && i2 < 3 && x == i1)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (flag4 != view.isPressed())
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (!flag2 || j2 != 0 || view.isLayoutRequested())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        e1 = (e)view.getLayoutParams();
        if (e1 == null)
        {
            e1 = (e)generateDefaultLayoutParams();
        }
        e1.a = g.getItemViewType(i1);
        if (flag2 && !e1.b)
        {
            attachViewToParent(view, l1, e1);
        } else
        {
            e1.b = false;
            addViewInLayout(view, l1, e1, true);
        }
        if (j2 != 0)
        {
            view.setSelected(flag1);
            if (flag1)
            {
                requestFocus();
            }
        }
        if (k2 != 0)
        {
            view.setPressed(flag4);
        }
        if (a != 0 && c != null && (view instanceof Checkable))
        {
            ((Checkable)view).setChecked(c.get(i1));
        }
        if (flag3)
        {
            view.measure(ViewGroup.getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), 0, e1.width), ViewGroup.getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(av, 0x40000000), 0, e1.height));
        } else
        {
            cleanupLayoutState(view);
        }
        k2 = view.getMeasuredWidth();
        l2 = view.getMeasuredHeight();
        if (flag)
        {
            l1 = j1;
        } else
        {
            l1 = j1 - k2;
        }
        if (android.os.Build.VERSION.SDK_INT > 14)
        {
            j2 = Gravity.getAbsoluteGravity(aA, 0);
        } else
        {
            j2 = aA;
        }
        j1 = k1;
        j2 & 7;
        JVM INSTR lookupswitch 3: default 340
    //                   16: 484
    //                   48: 343
    //                   80: 500;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_500;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        j1 = k1;
_L5:
        if (flag3)
        {
            view.layout(l1, j1, l1 + k2, j1 + l2);
        } else
        {
            view.offsetTopAndBottom(j1 - view.getTop());
            view.offsetLeftAndRight(l1 - view.getLeft());
        }
        if (v)
        {
            view.setDrawingCacheEnabled(true);
        }
        if (android.os.Build.VERSION.SDK_INT > 11 && flag2 && ((e)view.getLayoutParams()).c != i1)
        {
            view.jumpDrawablesToCurrentState();
        }
        return;
_L2:
        j1 = k1 + (av - l2) / 2;
          goto _L5
        j1 = (av + k1) - l2;
          goto _L5
    }

    private boolean a(int i1, int j1, KeyEvent keyevent)
    {
        int k1;
        if (g == null)
        {
            return false;
        }
        if (ag)
        {
            f();
        }
        k1 = keyevent.getAction();
        if (k1 == 1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 11: default 132
    //                   19: 212
    //                   20: 283
    //                   21: 142
    //                   22: 177
    //                   23: 356
    //                   62: 410
    //                   66: 356
    //                   92: 416
    //                   93: 487
    //                   122: 560
    //                   123: 595;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L7 _L9 _L10 _L11 _L12
_L2:
        boolean flag = false;
          goto _L13
_L5:
        if (!KeyEventCompat.hasNoModifiers(keyevent)) goto _L2; else goto _L14
_L14:
        if (n() || h(17))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L6:
        if (!KeyEventCompat.hasNoModifiers(keyevent)) goto _L2; else goto _L15
_L15:
        if (n() || h(66))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L3:
        if (!KeyEventCompat.hasNoModifiers(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (n() || h(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L16
_L16:
        if (n() || g(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L4:
        if (!KeyEventCompat.hasNoModifiers(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (n() || h(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L17
_L17:
        if (n() || g(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L7:
        if (!KeyEventCompat.hasNoModifiers(keyevent)) goto _L2; else goto _L18
_L18:
        boolean flag1 = n();
        flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (keyevent.getRepeatCount() == 0)
            {
                flag = flag1;
                if (getChildCount() > 0)
                {
                    j();
                    flag = true;
                }
            }
        }
          goto _L13
_L8:
        flag = false;
          goto _L13
_L9:
        if (!KeyEventCompat.hasNoModifiers(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (n() || f(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L19
_L19:
        if (n() || g(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L10:
        if (!KeyEventCompat.hasNoModifiers(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (n() || f(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L20
_L20:
        if (n() || g(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L11:
        if (!KeyEventCompat.hasNoModifiers(keyevent)) goto _L2; else goto _L21
_L21:
        if (n() || g(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
_L12:
        if (!KeyEventCompat.hasNoModifiers(keyevent)) goto _L2; else goto _L22
_L22:
        if (n() || g(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L13:
        if (flag)
        {
            return true;
        }
        switch (k1)
        {
        default:
            return false;

        case 0: // '\0'
            return super.onKeyDown(i1, keyevent);

        case 1: // '\001'
            return super.onKeyUp(i1, keyevent);

        case 2: // '\002'
            return super.onKeyMultiple(i1, j1, keyevent);
        }
    }

    private View b(int i1, int j1, boolean flag)
    {
        int i3 = av;
        int l2 = as;
        int l1 = r.top;
        View view;
        View view1;
        int k1;
        int j2;
        int j3;
        boolean flag2;
        boolean flag3;
        if (au == 3)
        {
            k1 = l2;
        } else
        {
            k1 = 0;
        }
        l1 = k1 + l1;
        if (!H)
        {
            int i2 = Math.min(aq + i1, al);
            k1 = i1;
            i1 = i2;
        } else
        {
            k1 = i1 + 1;
            j2 = Math.max(0, (i1 - aq) + 1);
            if (k1 - j2 < aq)
            {
                l1 += (aq - (k1 - j2)) * (i3 + l2);
                i1 = k1;
                k1 = j2;
            } else
            {
                i1 = k1;
                k1 = j2;
            }
        }
        view = null;
        flag2 = i();
        flag3 = h();
        j3 = aj;
        view1 = null;
        j2 = k1;
        while (j2 < i1) 
        {
            int k2;
            boolean flag1;
            if (j2 == j3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag)
            {
                k2 = -1;
            } else
            {
                k2 = j2 - k1;
            }
            view1 = a(j2, j1, flag, l1, flag1, k2);
            l1 += i3;
            if (j2 < i1 - 1)
            {
                l1 += l2;
            }
            if (flag1 && (flag2 || flag3))
            {
                view = view1;
            }
            j2++;
        }
        ay = view1;
        if (view != null)
        {
            az = ay;
        }
        return view;
    }

    private void b(int i1, int j1, int k1)
    {
        if (S == 0 && k1 > 0)
        {
            int l1 = getChildAt(0).getLeft();
            int j2 = r.left;
            int i2 = getRight() - getLeft() - r.right;
            l1 -= j2;
            View view = getChildAt(k1 - 1);
            int k2 = view.getRight();
            j2 = (S + k1) - 1;
            if (l1 > 0 && (j2 < al - 1 || k2 > i2))
            {
                k1 = l1;
                if (j2 == al - 1)
                {
                    k1 = Math.min(l1, k2 - i2);
                }
                d(-k1);
                if (j2 < al - 1)
                {
                    if (!H)
                    {
                        i1 = 1;
                    }
                    c(j2 + i1, view.getRight() + j1);
                    x();
                }
            }
        }
    }

    private void b(View view, int i1, int j1)
    {
        if (view.getLeft() < i1)
        {
            d(Math.min(i1 - view.getLeft(), j1 - view.getRight()));
        }
    }

    private View c(int i1, int j1)
    {
        View view = null;
        int k1 = getRight();
        for (int l1 = getLeft(); j1 < k1 - l1 && i1 < al; i1 += aq)
        {
            View view1 = b(i1, j1, true);
            if (view1 != null)
            {
                view = view1;
            }
            j1 = ay.getRight() + ar;
        }

        return view;
    }

    private View c(int i1, int j1, int k1)
    {
        int l2 = getVerticalFadingEdgeLength();
        int i2 = aj;
        int j2 = aq;
        int k2 = ar;
        int l1 = -1;
        View view;
        View view1;
        int i3;
        if (!H)
        {
            i2 -= i2 % j2;
        } else
        {
            l1 = al - 1 - i2;
            l1 = al - 1 - (l1 - l1 % j2);
            i2 = Math.max(0, (l1 - j2) + 1);
        }
        i3 = d(j1, l2, i2);
        k1 = a(k1, l2, j2, i2);
        if (H)
        {
            j1 = l1;
        } else
        {
            j1 = i2;
        }
        view = b(j1, i1, true);
        S = i2;
        view1 = ay;
        b(view1, i3, k1);
        a(view1, i3, k1);
        if (!H)
        {
            d(i2 - j2, view1.getLeft() - k2);
            x();
            c(i2 + j2, view1.getRight() + k2);
            return view;
        } else
        {
            c(l1 + j2, view1.getRight() + k2);
            x();
            d(i2 - 1, view1.getLeft() - k2);
            return view;
        }
    }

    private int d(int i1, int j1, int k1)
    {
        int l1 = i1;
        if (k1 > 0)
        {
            l1 = i1 + j1;
        }
        return l1;
    }

    private View d(int i1, int j1)
    {
        View view = null;
        for (; j1 > 0 && i1 >= 0; i1 -= aq)
        {
            View view1 = b(i1, j1, false);
            if (view1 != null)
            {
                view = view1;
            }
            j1 = ay.getLeft() - ar;
            S = i1;
        }

        if (H)
        {
            S = Math.max(0, i1 + 1);
        }
        return view;
    }

    private View e(int i1, int j1)
    {
        i1 = Math.min(Math.max(i1, aj), al - 1);
        i1 = al - 1 - i1;
        return d(al - 1 - (i1 - i1 % aq), j1);
    }

    private View e(int i1, int j1, int k1)
    {
        boolean flag = false;
        int i3 = getHorizontalFadingEdgeLength();
        int j3 = aj;
        int k2 = aq;
        int l2 = ar;
        int j2 = -1;
        View view;
        View view1;
        int l1;
        int i2;
        if (!H)
        {
            i2 = j3 - i1 - (j3 - i1) % k2;
            l1 = j3 - j3 % k2;
            i1 = j2;
        } else
        {
            l1 = al - 1 - j3;
            i2 = al - 1 - (l1 - l1 % k2);
            l1 = Math.max(0, (i2 - k2) + 1);
            i1 = al - 1 - (j3 - i1);
            j2 = Math.max(0, (al - 1 - (i1 - i1 % k2) - k2) + 1);
            i1 = i2;
            i2 = j2;
        }
        j3 = l1 - i2;
        i2 = d(j1, i3, l1);
        j2 = a(k1, i3, k2, l1);
        S = l1;
        if (j3 > 0)
        {
            if (az == null)
            {
                j1 = 0;
            } else
            {
                j1 = az.getRight();
            }
            if (H)
            {
                k1 = i1;
            } else
            {
                k1 = l1;
            }
            view1 = b(k1, j1 + l2, true);
            view = ay;
            a(view, i2, j2);
        } else
        if (j3 < 0)
        {
            if (az == null)
            {
                j1 = 0;
            } else
            {
                j1 = az.getLeft();
            }
            if (H)
            {
                k1 = i1;
            } else
            {
                k1 = l1;
            }
            view1 = b(k1, j1 - l2, false);
            view = ay;
            b(view, i2, j2);
        } else
        {
            if (az == null)
            {
                j1 = ((flag) ? 1 : 0);
            } else
            {
                j1 = az.getLeft();
            }
            if (H)
            {
                k1 = i1;
            } else
            {
                k1 = l1;
            }
            view1 = b(k1, j1, true);
            view = ay;
        }
        if (!H)
        {
            d(l1 - k2, view.getLeft() - l2);
            x();
            c(l1 + k2, view.getRight() + l2);
            return view1;
        } else
        {
            c(i1 + k2, view.getRight() + l2);
            x();
            d(l1 - 1, view.getLeft() - l2);
            return view1;
        }
    }

    private View f(int i1, int j1)
    {
        int l1 = m();
        int j2 = aq;
        int k2 = ar;
        int k1 = -1;
        View view;
        View view1;
        int i2;
        int l2;
        int i3;
        if (!H)
        {
            l1 -= l1 % j2;
        } else
        {
            k1 = al - 1 - l1;
            k1 = al - 1 - (k1 - k1 % j2);
            l1 = Math.max(0, (k1 - j2) + 1);
        }
        l2 = getHorizontalFadingEdgeLength();
        i3 = d(i1, l2, l1);
        if (H)
        {
            i2 = k1;
        } else
        {
            i2 = l1;
        }
        view = b(i2, i3, true);
        S = l1;
        view1 = ay;
        if (!H)
        {
            c(l1 + j2, view1.getRight() + k2);
            k(j1);
            d(l1 - j2, view1.getLeft() - k2);
            x();
            return view;
        } else
        {
            d(a(j1, l2, j2, l1) - view1.getRight());
            d(l1 - 1, view1.getLeft() - k2);
            j(i1);
            c(k1 + j2, view1.getRight() + k2);
            x();
            return view;
        }
    }

    private View g(int i1, int j1)
    {
        View view;
        View view2;
        View view5;
        int k1;
        int i2;
        i2 = aq;
        int l1 = -1;
        if (!H)
        {
            k1 = i1 - i1 % i2;
            i1 = l1;
        } else
        {
            i1 = al - 1 - i1;
            i1 = al - 1 - (i1 - i1 % i2);
            k1 = Math.max(0, (i1 - i2) + 1);
        }
        if (H)
        {
            l1 = i1;
        } else
        {
            l1 = k1;
        }
        view5 = b(l1, j1, true);
        S = k1;
        view = ay;
        if (view != null) goto _L2; else goto _L1
_L1:
        view2 = null;
_L8:
        return view2;
_L2:
        j1 = ar;
        if (H) goto _L4; else goto _L3
_L3:
        View view1;
        view2 = d(k1 - i2, view.getLeft() - j1);
        x();
        View view3 = c(k1 + i2, view.getRight() + j1);
        i1 = getChildCount();
        view = view2;
        view1 = view3;
        if (i1 > 0)
        {
            a(i2, j1, i1);
            view1 = view3;
            view = view2;
        }
_L6:
        if (view5 != null)
        {
            return view5;
        }
        break; /* Loop/switch isn't completed */
_L4:
        view2 = c(i1 + i2, view.getRight() + j1);
        x();
        View view4 = d(i1 - 1, view.getLeft() - j1);
        i1 = getChildCount();
        view = view4;
        view1 = view2;
        if (i1 > 0)
        {
            b(i2, j1, i1);
            view = view4;
            view1 = view2;
        }
        if (true) goto _L6; else goto _L5
_L5:
        view2 = view;
        if (view == null)
        {
            return view1;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean h(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        i2 = getChildCount();
        k1 = i2 - 1 - i1;
        if (!H)
        {
            l1 = i1 - i1 % aq;
            k1 = Math.max((aq + l1) - 1, i2);
        } else
        {
            k1 = i2 - 1 - (k1 - k1 % aq);
            l1 = Math.max(0, (k1 - aq) + 1);
        }
        j1;
        JVM INSTR lookupswitch 6: default 104
    //                   1: 193
    //                   2: 180
    //                   17: 163
    //                   33: 173
    //                   66: 146
    //                   130: 155;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
_L6:
        if (l1 != 0) goto _L9; else goto _L8
_L8:
        return true;
_L9:
        return false;
_L7:
        if (i1 != l1)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (k1 != i2 - 1)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (i1 != k1)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (i1 != l1 || l1 != 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 != k1 || k1 != i2 - 1)
        {
            return false;
        }
        if (true) goto _L8; else goto _L10
_L10:
    }

    private View i(int i1)
    {
        S = Math.min(S, aj);
        S = Math.min(S, al - 1);
        if (S < 0)
        {
            S = 0;
        }
        S = S - S % aq;
        return c(S, i1);
    }

    private void j(int i1)
    {
        if (S == 0)
        {
            i1 -= getChildAt(0).getLeft();
            if (i1 < 0)
            {
                d(i1);
            }
        }
    }

    private void k(int i1)
    {
        int j1 = getChildCount();
        if (S + j1 == al)
        {
            i1 -= getChildAt(j1 - 1).getRight();
            if (i1 > 0)
            {
                d(i1);
            }
        }
    }

    private boolean l(int i1)
    {
        int j1 = at;
        int k1 = au;
        int l1 = aw;
        boolean flag = false;
        if (ax == -1)
        {
            if (l1 > 0)
            {
                aq = (i1 + j1) / (l1 + j1);
            } else
            {
                aq = 2;
            }
        } else
        {
            aq = ax;
        }
        if (aq <= 0)
        {
            aq = 1;
        }
        switch (k1)
        {
        default:
            i1 = i1 - aq * l1 - (aq - 1) * j1;
            if (i1 < 0)
            {
                flag = true;
            }
            switch (k1)
            {
            default:
                return flag;

            case 2: // '\002'
                av = i1 / aq + l1;
                as = j1;
                return flag;

            case 1: // '\001'
                av = l1;
                if (aq > 1)
                {
                    as = i1 / (aq - 1) + j1;
                    return flag;
                } else
                {
                    as = j1 + i1;
                    return flag;
                }

            case 3: // '\003'
                av = l1;
                break;
            }
            break;

        case 0: // '\0'
            av = l1;
            as = j1;
            return false;
        }
        if (aq > 1)
        {
            as = i1 / (aq + 1) + j1;
            return flag;
        } else
        {
            as = j1 + i1;
            return flag;
        }
    }

    private void x()
    {
        boolean flag;
        int l1;
        flag = false;
        l1 = getChildCount();
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        if (H) goto _L4; else goto _L3
_L3:
        int k1;
        k1 = getChildAt(0).getLeft() - r.left;
        int i1 = k1;
        if (S != 0)
        {
            i1 = k1 - ar;
        }
        k1 = i1;
        if (i1 < 0)
        {
            k1 = ((flag) ? 1 : 0);
        }
_L6:
        if (k1 != 0)
        {
            d(-k1);
        }
_L2:
        return;
_L4:
        k1 = getChildAt(l1 - 1).getRight() - (getWidth() - r.right);
        int j1 = k1;
        if (l1 + S < al)
        {
            j1 = k1 + ar;
        }
        k1 = ((flag) ? 1 : 0);
        if (j1 <= 0)
        {
            k1 = j1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    int a(int i1, boolean flag)
    {
        if (g != null && !isInTouchMode()) goto _L2; else goto _L1
_L1:
        int j1 = -1;
_L4:
        return j1;
_L2:
        if (i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = i1;
        if (i1 < al) goto _L4; else goto _L3
_L3:
        return -1;
    }

    void a(boolean flag)
    {
        int i1 = 0;
        int l1 = aq;
        int i2 = ar;
        int j1 = getChildCount();
        if (flag)
        {
            if (j1 > 0)
            {
                i1 = getChildAt(j1 - 1).getRight() + i2;
            }
            int k1 = j1 + S;
            j1 = k1;
            if (H)
            {
                j1 = k1 + (l1 - 1);
            }
            c(j1, i1);
            a(l1, i2, getChildCount());
            return;
        }
        if (j1 > 0)
        {
            i1 = getChildAt(0).getLeft() - i2;
        } else
        {
            i1 = getWidth() - 0;
        }
        j1 = S;
        if (!H)
        {
            j1 -= l1;
        } else
        {
            j1--;
        }
        d(j1, i1);
        b(l1, i2, getChildCount());
    }

    protected void attachLayoutAnimationParameters(View view, android.view.ViewGroup.LayoutParams layoutparams, int i1, int j1)
    {
        android.view.animation.GridLayoutAnimationController.AnimationParameters animationparameters = (android.view.animation.GridLayoutAnimationController.AnimationParameters)layoutparams.layoutAnimationParameters;
        view = animationparameters;
        if (animationparameters == null)
        {
            view = new android.view.animation.GridLayoutAnimationController.AnimationParameters();
            layoutparams.layoutAnimationParameters = view;
        }
        view.count = j1;
        view.index = i1;
        view.columnsCount = j1 / aq;
        view.rowsCount = aq;
        if (!H)
        {
            view.column = i1 / aq;
            view.row = i1 % aq;
            return;
        } else
        {
            i1 = j1 - 1 - i1;
            view.column = ((android.view.animation.GridLayoutAnimationController.AnimationParameters) (view)).columnsCount - 1 - i1 / aq;
            view.row = aq - 1 - i1 % aq;
            return;
        }
    }

    int b(int i1)
    {
        int i2 = getChildCount();
        if (i2 > 0)
        {
            int l1 = aq;
            if (!H)
            {
                for (int j1 = 0; j1 < i2; j1 += l1)
                {
                    if (i1 <= getChildAt(j1).getRight())
                    {
                        return j1 + S;
                    }
                }

            } else
            {
                for (int k1 = i2 - 1; k1 >= 0; k1 -= l1)
                {
                    if (i1 >= getChildAt(k1).getLeft())
                    {
                        return k1 + S;
                    }
                }

            }
        }
        return -1;
    }

    protected int computeHorizontalScrollExtent()
    {
        int k1 = getChildCount();
        if (k1 > 0)
        {
            int i1 = aq;
            int j1 = (((k1 + i1) - 1) / i1) * 100;
            View view = getChildAt(0);
            int l1 = view.getLeft();
            int i2 = view.getWidth();
            i1 = j1;
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
            return 0;
        }
    }

    protected int computeHorizontalScrollOffset()
    {
        boolean flag = false;
        int i1 = ((flag) ? 1 : 0);
        if (S >= 0)
        {
            i1 = ((flag) ? 1 : 0);
            if (getChildCount() > 0)
            {
                View view = getChildAt(0);
                int k1 = view.getLeft();
                int l1 = view.getWidth();
                i1 = ((flag) ? 1 : 0);
                if (l1 > 0)
                {
                    int j1 = aq;
                    int i2 = ((al + j1) - 1) / j1;
                    if (c())
                    {
                        i1 = i2 * j1 - al;
                    } else
                    {
                        i1 = 0;
                    }
                    i1 = Math.max((((i1 + S) / j1) * 100 - (k1 * 100) / l1) + (int)(((float)getScrollX() / (float)getWidth()) * (float)i2 * 100F), 0);
                }
            }
        }
        return i1;
    }

    protected int computeHorizontalScrollRange()
    {
        int i1 = aq;
        int k1 = ((al + i1) - 1) / i1;
        int j1 = Math.max(k1 * 100, 0);
        i1 = j1;
        if (getScrollX() != 0)
        {
            float f1 = (float)getScrollX() / (float)getWidth();
            i1 = j1 + Math.abs((int)((float)k1 * f1 * 100F));
        }
        return i1;
    }

    protected void f()
    {
        i i1;
        byte byte0;
        boolean flag;
        byte0 = -1;
        i1 = null;
        flag = ap;
        if (!flag)
        {
            ap = true;
        }
        super.f();
        invalidate();
        if (g != null) goto _L2; else goto _L1
_L1:
        e();
        b();
        if (!flag)
        {
            ap = false;
        }
_L14:
        return;
_L2:
        int k1;
        int i2;
        int j2;
        k1 = r.left;
        i2 = getRight() - getLeft() - r.right;
        j2 = getChildCount();
        e;
        JVM INSTR tableswitch 1 6: default 913
    //                   1 916
    //                   2 219
    //                   3 916
    //                   4 916
    //                   5 916
    //                   6 259;
           goto _L3 _L4 _L5 _L4 _L4 _L4 _L6
_L3:
        int j1 = aj - S;
        if (j1 < 0 || j1 >= j2) goto _L8; else goto _L7
_L7:
        Object obj = getChildAt(j1);
_L51:
        Object obj2 = getChildAt(0);
        Object obj1;
        j1 = 0;
        obj1 = obj;
        obj = obj2;
        obj2 = i1;
_L17:
        boolean flag1 = ag;
        if (!flag1) goto _L10; else goto _L9
_L9:
        q();
_L10:
        if (al != 0) goto _L12; else goto _L11
_L11:
        e();
        b();
        if (flag) goto _L14; else goto _L13
_L13:
        ap = false;
        return;
_L5:
        j1 = ah - S;
        if (j1 < 0 || j1 >= j2) goto _L16; else goto _L15
_L15:
        obj2 = getChildAt(j1);
        obj = null;
        obj1 = null;
        j1 = 0;
          goto _L17
_L6:
        if (ah < 0) goto _L16; else goto _L18
_L18:
        int l1;
        j1 = ah;
        l1 = aj;
        obj = null;
        obj1 = null;
        j1 -= l1;
        obj2 = i1;
          goto _L17
_L12:
        int k2;
        setSelectedPositionInt(ah);
        k2 = S;
        i1 = m;
        if (!flag1) goto _L20; else goto _L19
_L19:
        l1 = 0;
_L22:
        if (l1 >= j2)
        {
            break; /* Loop/switch isn't completed */
        }
        i1.a(getChildAt(l1), k2 + l1);
        l1++;
        if (true) goto _L22; else goto _L21
_L20:
        i1.a(j2, k2);
_L21:
        detachAllViewsFromParent();
        i1.d();
        e;
        JVM INSTR tableswitch 1 6: default 929
    //                   1 592
    //                   2 560
    //                   3 624
    //                   4 644
    //                   5 660
    //                   6 676;
           goto _L23 _L24 _L25 _L26 _L27 _L28 _L29
_L23:
        if (j2 != 0) goto _L31; else goto _L30
_L30:
        if (H) goto _L33; else goto _L32
_L32:
        j1 = byte0;
        if (g != null)
        {
            if (isInTouchMode())
            {
                j1 = byte0;
            } else
            {
                j1 = 0;
            }
        }
        setSelectedPositionInt(j1);
        obj = i(k1);
_L38:
        i1.e();
        if (obj == null) goto _L35; else goto _L34
_L34:
        a(-1, ((View) (obj)));
        G = ((View) (obj)).getLeft();
_L50:
        e = 0;
        ag = false;
        if (L != null)
        {
            post(L);
            L = null;
        }
        aa = false;
        setNextSelectedPositionInt(aj);
        g();
        if (al > 0)
        {
            u();
        }
        b();
        if (!flag)
        {
            ap = false;
            return;
        }
          goto _L14
_L25:
        if (obj2 == null) goto _L37; else goto _L36
_L36:
        obj = c(((View) (obj2)).getLeft(), k1, i2);
          goto _L38
_L37:
        obj = f(k1, i2);
          goto _L38
_L24:
        S = 0;
        obj = i(k1);
        x();
          goto _L38
        obj;
        if (!flag)
        {
            ap = false;
        }
        throw obj;
_L26:
        obj = d(al - 1, i2);
        x();
          goto _L38
_L27:
        obj = g(aj, T);
          goto _L38
_L28:
        obj = g(U, T);
          goto _L38
_L29:
        obj = e(j1, k1, i2);
          goto _L38
_L33:
        k1 = al - 1;
        if (g == null || isInTouchMode())
        {
            j1 = -1;
        } else
        {
            j1 = k1;
        }
        setSelectedPositionInt(j1);
        obj = e(k1, i2);
          goto _L38
_L31:
        if (aj < 0 || aj >= al) goto _L40; else goto _L39
_L39:
        j1 = aj;
        if (obj1 != null) goto _L42; else goto _L41
_L41:
        obj = g(j1, k1);
          goto _L38
_L42:
        k1 = ((View) (obj1)).getLeft();
          goto _L41
_L40:
        if (S >= al) goto _L44; else goto _L43
_L43:
        j1 = S;
        if (obj != null) goto _L46; else goto _L45
_L45:
        obj = g(j1, k1);
          goto _L38
_L46:
        k1 = ((View) (obj)).getLeft();
          goto _L45
_L44:
        obj = g(0, k1);
          goto _L38
_L35:
        if (C <= 0 || C >= 3) goto _L48; else goto _L47
_L47:
        obj = getChildAt(x - S);
        if (obj == null) goto _L50; else goto _L49
_L49:
        a(x, ((View) (obj)));
          goto _L50
_L48:
        G = 0;
        l.setEmpty();
          goto _L50
_L8:
        obj = null;
          goto _L51
_L16:
        obj = null;
        obj1 = null;
        j1 = 0;
        obj2 = i1;
          goto _L17
_L4:
        obj = null;
        obj1 = null;
        j1 = 0;
        obj2 = i1;
          goto _L17
    }

    boolean f(int i1)
    {
        int j1;
        boolean flag;
        flag = false;
        j1 = -1;
        if (i1 != 17) goto _L2; else goto _L1
_L1:
        j1 = Math.max(0, aj - getChildCount());
_L4:
        if (j1 >= 0)
        {
            setSelectionInt(j1);
            b();
            awakenScrollBars();
            flag = true;
        }
        return flag;
_L2:
        if (i1 == 66)
        {
            j1 = Math.min(al - 1, aj + getChildCount());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean g(int i1)
    {
        boolean flag = true;
        if (i1 == 17)
        {
            e = 2;
            setSelectionInt(0);
            b();
        } else
        if (i1 == 66)
        {
            e = 2;
            setSelectionInt(al - 1);
            b();
        } else
        {
            flag = false;
        }
        if (flag)
        {
            awakenScrollBars();
        }
        return flag;
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return g;
    }

    public int getGravity()
    {
        return aA;
    }

    public int getHorizontalSpacing()
    {
        return ar;
    }

    public int getNumRows()
    {
        return aq;
    }

    public int getRequestedRowHeight()
    {
        return aw;
    }

    public int getRequestedVerticalSpacing()
    {
        return at;
    }

    public int getRowHeight()
    {
        return av;
    }

    public int getStretchMode()
    {
        return au;
    }

    public int getVerticalSpacing()
    {
        return as;
    }

    boolean h(int i1)
    {
        int j1;
        int k1;
        int l1;
        int i2;
        boolean flag = true;
        l1 = aj;
        i2 = aq;
        if (!H)
        {
            k1 = (l1 / i2) * i2;
            j1 = Math.min((k1 + i2) - 1, al - 1);
        } else
        {
            j1 = al;
            j1 = al - 1 - ((j1 - 1 - l1) / i2) * i2;
            k1 = Math.max(0, (j1 - i2) + 1);
        }
        i1;
        JVM INSTR lookupswitch 4: default 92
    //                   17: 164
    //                   33: 227
    //                   66: 190
    //                   130: 254;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        flag = false;
_L7:
        if (flag)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i1));
            b();
        }
        if (flag)
        {
            awakenScrollBars();
        }
        return flag;
_L2:
        if (k1 <= 0) goto _L1; else goto _L6
_L6:
        e = 6;
        setSelectionInt(Math.max(0, l1 - i2));
          goto _L7
_L4:
        if (j1 >= al - 1) goto _L1; else goto _L8
_L8:
        e = 6;
        setSelectionInt(Math.min(l1 + i2, al - 1));
          goto _L7
_L3:
        if (l1 <= k1) goto _L1; else goto _L9
_L9:
        e = 6;
        setSelectionInt(Math.max(0, l1 - 1));
          goto _L7
_L5:
        if (l1 >= j1) goto _L1; else goto _L10
_L10:
        e = 6;
        setSelectionInt(Math.min(l1 + 1, al - 1));
          goto _L7
    }

    protected void onFocusChanged(boolean flag, int i1, Rect rect)
    {
        super.onFocusChanged(flag, i1, rect);
        int j1 = -1;
        int i2 = j1;
        if (flag)
        {
            i2 = j1;
            if (rect != null)
            {
                rect.offset(getScrollX(), getScrollY());
                Rect rect1 = aB;
                int l1 = 0x7fffffff;
                int j2 = getChildCount();
                int k1 = 0;
                do
                {
                    i2 = j1;
                    if (k1 >= j2)
                    {
                        break;
                    }
                    if (h(k1, i1))
                    {
                        View view = getChildAt(k1);
                        view.getDrawingRect(rect1);
                        offsetDescendantRectToMyCoords(view, rect1);
                        i2 = a(rect, rect1, i1);
                        if (i2 < l1)
                        {
                            l1 = i2;
                            j1 = k1;
                        }
                    }
                    k1++;
                } while (true);
            }
        }
        if (i2 >= 0)
        {
            setSelection(S + i2);
            return;
        } else
        {
            requestLayout();
            return;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(com/cyberlink/you/widgetpool/clhorizontalgridview/HorizontalGridView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(com/cyberlink/you/widgetpool/clhorizontalgridview/HorizontalGridView.getName());
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        return a(i1, 1, keyevent);
    }

    public boolean onKeyMultiple(int i1, int j1, KeyEvent keyevent)
    {
        return a(i1, j1, keyevent);
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        return a(i1, 1, keyevent);
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        int j2 = android.view.View.MeasureSpec.getMode(i1);
        int l2 = android.view.View.MeasureSpec.getMode(j1);
        int l1 = android.view.View.MeasureSpec.getSize(i1);
        i1 = android.view.View.MeasureSpec.getSize(j1);
        int k1;
        int j3;
        if (l2 == 0)
        {
            e e1;
            e e2;
            View view;
            int i2;
            int k2;
            int i3;
            boolean flag;
            if (av > 0)
            {
                i1 = av + r.top + r.bottom;
            } else
            {
                i1 = r.top + r.bottom;
            }
            i1 += getHorizontalScrollbarHeight();
        }
        flag = l(i1 - r.top - r.bottom);
        i2 = 0;
        if (g == null)
        {
            k1 = 0;
        } else
        {
            k1 = g.getCount();
        }
        al = k1;
        i3 = al;
        if (i3 > 0)
        {
            view = a(0, M);
            e2 = (e)view.getLayoutParams();
            e1 = e2;
            if (e2 == null)
            {
                e1 = (e)generateDefaultLayoutParams();
                view.setLayoutParams(e1);
            }
            e1.a = g.getItemViewType(0);
            e1.b = true;
            view.measure(getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), 0, e1.width), getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(av, 0x40000000), 0, e1.height));
            k1 = view.getMeasuredWidth();
            i2 = k1;
            if (m.b(e1.a))
            {
                m.a(view, -1);
                i2 = k1;
            }
        }
        if (j2 == 0)
        {
            k1 = r.left + r.right + i2 + getHorizontalFadingEdgeLength() * 2;
        } else
        {
            k1 = l1;
        }
        l1 = k1;
        if (j2 != 0x80000000) goto _L2; else goto _L1
_L1:
        l1 = r.left;
        j2 = r.right;
        j3 = aq;
        l1 = j2 + l1;
        j2 = 0;
_L7:
        if (j2 >= i3) goto _L2; else goto _L3
_L3:
        k2 = l1 + i2;
        l1 = k2;
        if (j2 + j3 < i3)
        {
            l1 = k2 + ar;
        }
        if (l1 < k1) goto _L5; else goto _L4
_L4:
        l1 = k1;
_L2:
label0:
        {
            k1 = i1;
            if (l2 != 0x80000000)
            {
                break label0;
            }
            k1 = i1;
            if (ax == -1)
            {
                break label0;
            }
            if (ax * av + (ax - 1) * as + r.top + r.bottom <= i1)
            {
                k1 = i1;
                if (!flag)
                {
                    break label0;
                }
            }
            k1 = i1 | 0x1000000;
        }
        setMeasuredDimension(l1, k1);
        s = j1;
        return;
_L5:
        j2 += j3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (g != null && f != null)
        {
            g.unregisterDataSetObserver(f);
        }
        e();
        m.b();
        g = listadapter;
        an = -1;
        ao = 0x8000000000000000L;
        super.setAdapter(listadapter);
        if (g != null)
        {
            am = al;
            al = g.getCount();
            ag = true;
            s();
            f = new n(this);
            g.registerDataSetObserver(f);
            m.a(g.getViewTypeCount());
            int i1;
            if (H)
            {
                i1 = a(al - 1, false);
            } else
            {
                i1 = a(0, true);
            }
            setSelectedPositionInt(i1);
            setNextSelectedPositionInt(i1);
            u();
        } else
        {
            s();
            u();
        }
        requestLayout();
    }

    public void setGravity(int i1)
    {
        if (aA != i1)
        {
            aA = i1;
            d();
        }
    }

    public void setHorizontalSpacing(int i1)
    {
        if (i1 != ar)
        {
            ar = i1;
            d();
        }
    }

    public void setNumRows(int i1)
    {
        if (i1 != ax)
        {
            ax = i1;
            d();
        }
    }

    public void setRowHeight(int i1)
    {
        if (i1 != aw)
        {
            aw = i1;
            d();
        }
    }

    public void setSelection(int i1)
    {
        if (!isInTouchMode())
        {
            setNextSelectedPositionInt(i1);
        } else
        {
            J = i1;
        }
        e = 2;
        if (F != null)
        {
            F.a();
        }
        requestLayout();
    }

    void setSelectionInt(int i1)
    {
        int k1 = ah;
        if (F != null)
        {
            F.a();
        }
        setNextSelectedPositionInt(i1);
        f();
        int j1;
        if (H)
        {
            i1 = al - 1 - ah;
        } else
        {
            i1 = ah;
        }
        j1 = k1;
        if (H)
        {
            j1 = al - 1 - k1;
        }
        if (i1 / aq != j1 / aq)
        {
            awakenScrollBars();
        }
    }

    public void setStretchMode(int i1)
    {
        if (i1 != au)
        {
            au = i1;
            d();
        }
    }

    public void setVerticalSpacing(int i1)
    {
        if (i1 != at)
        {
            at = i1;
            d();
        }
    }
}

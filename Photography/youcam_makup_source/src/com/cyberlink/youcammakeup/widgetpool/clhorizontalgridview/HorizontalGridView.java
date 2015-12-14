// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

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
import com.cyberlink.youcammakeup.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            AbsListView, i, e, n, 
//            h

public class HorizontalGridView extends AbsListView
{

    private int a;
    private int aA;
    private final Rect aB;
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
        a = -1;
        ar = 0;
        as = 0;
        au = 2;
        ay = null;
        az = null;
        aA = 0x800003;
        aB = new Rect();
        context = context.obtainStyledAttributes(attributeset, j.HorizontalGridView, i1, 0);
        setHorizontalSpacing(context.getDimensionPixelOffset(1, 0));
        setVerticalSpacing(context.getDimensionPixelOffset(5, 0));
        i1 = context.getInt(2, 2);
        if (i1 >= 0)
        {
            setStretchMode(i1);
        }
        i1 = context.getDimensionPixelOffset(3, -1);
        if (i1 > 0)
        {
            setRowHeight(i1);
        }
        setNumRows(context.getInt(4, 1));
        i1 = context.getInt(0, -1);
        if (i1 >= 0)
        {
            setGravity(i1);
        }
        context.recycle();
    }

    private int a(int i1, int j1, int k1, int l1)
    {
        int i2 = i1;
        if ((l1 + k1) - 1 < am - 1)
        {
            i2 = i1 - j1;
        }
        return i2;
    }

    private View a(int i1, int j1, boolean flag, int k1, boolean flag1, int l1)
    {
        if (!ah)
        {
            View view = n.c(i1);
            if (view != null)
            {
                a(view, i1, j1, flag, k1, flag1, true, l1);
                return view;
            }
        }
        View view1 = a(i1, N);
        a(view1, i1, j1, flag, k1, flag1, N[0], l1);
        return view1;
    }

    private void a()
    {
        boolean flag;
        int l1;
        flag = false;
        l1 = getChildCount();
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        if (I) goto _L4; else goto _L3
_L3:
        int k1;
        k1 = getChildAt(0).getLeft() - s.left;
        int i1 = k1;
        if (T != 0)
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
            f(-k1);
        }
_L2:
        return;
_L4:
        k1 = getChildAt(l1 - 1).getRight() - (getWidth() - s.right);
        int j1 = k1;
        if (l1 + T < am)
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

    private void a(int i1, int j1, int k1)
    {
        if ((T + k1) - 1 == am - 1 && k1 > 0)
        {
            k1 = getChildAt(k1 - 1).getRight();
            int l1 = getRight() - getLeft() - s.right - k1;
            View view = getChildAt(0);
            int i2 = view.getLeft();
            if (l1 > 0 && (T > 0 || i2 < s.left))
            {
                k1 = l1;
                if (T == 0)
                {
                    k1 = Math.min(l1, s.left - i2);
                }
                f(k1);
                if (T > 0)
                {
                    k1 = T;
                    if (I)
                    {
                        i1 = 1;
                    }
                    f(k1 - i1, view.getLeft() - j1);
                    a();
                }
            }
        }
    }

    private void a(View view, int i1, int j1)
    {
        if (view.getRight() > j1)
        {
            f(-Math.min(view.getLeft() - i1, view.getRight() - j1));
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
        if (flag1 && j())
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
        i2 = D;
        if (i2 > 0 && i2 < 3 && y == i1)
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
        e1.a = h.getItemViewType(i1);
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
        if (b != 0 && d != null && (view instanceof Checkable))
        {
            ((Checkable)view).setChecked(d.get(i1));
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
        if (w)
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
        if (h == null)
        {
            return false;
        }
        if (ah)
        {
            g();
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
        if (p() || j(17))
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
        if (p() || j(66))
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
        if (p() || j(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L16
_L16:
        if (p() || i(33))
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
        if (p() || j(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L17
_L17:
        if (p() || i(130))
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
        boolean flag1 = p();
        flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (keyevent.getRepeatCount() == 0)
            {
                flag = flag1;
                if (getChildCount() > 0)
                {
                    k();
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
        if (p() || h(33))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L19
_L19:
        if (p() || i(33))
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
        if (p() || h(130))
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L13
        if (!KeyEventCompat.hasModifiers(keyevent, 2)) goto _L2; else goto _L20
_L20:
        if (p() || i(130))
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
        if (p() || i(33))
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
        if (p() || i(130))
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
        int l1 = s.top;
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
        if (!I)
        {
            int i2 = Math.min(a + i1, am);
            k1 = i1;
            i1 = i2;
        } else
        {
            k1 = i1 + 1;
            j2 = Math.max(0, (i1 - a) + 1);
            if (k1 - j2 < a)
            {
                l1 += (a - (k1 - j2)) * (i3 + l2);
                i1 = k1;
                k1 = j2;
            } else
            {
                i1 = k1;
                k1 = j2;
            }
        }
        view = null;
        flag2 = j();
        flag3 = i();
        j3 = ak;
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
        if (T == 0 && k1 > 0)
        {
            int l1 = getChildAt(0).getLeft();
            int j2 = s.left;
            int i2 = getRight() - getLeft() - s.right;
            l1 -= j2;
            View view = getChildAt(k1 - 1);
            int k2 = view.getRight();
            j2 = (T + k1) - 1;
            if (l1 > 0 && (j2 < am - 1 || k2 > i2))
            {
                k1 = l1;
                if (j2 == am - 1)
                {
                    k1 = Math.min(l1, k2 - i2);
                }
                f(-k1);
                if (j2 < am - 1)
                {
                    if (!I)
                    {
                        i1 = 1;
                    }
                    e(j2 + i1, view.getRight() + j1);
                    a();
                }
            }
        }
    }

    private void b(View view, int i1, int j1)
    {
        if (view.getLeft() < i1)
        {
            f(Math.min(i1 - view.getLeft(), j1 - view.getRight()));
        }
    }

    private View c(int i1, int j1, int k1)
    {
        int l2 = getVerticalFadingEdgeLength();
        int i2 = ak;
        int j2 = a;
        int k2 = ar;
        int l1 = -1;
        View view;
        View view1;
        int i3;
        if (!I)
        {
            i2 -= i2 % j2;
        } else
        {
            l1 = am - 1 - i2;
            l1 = am - 1 - (l1 - l1 % j2);
            i2 = Math.max(0, (l1 - j2) + 1);
        }
        i3 = d(j1, l2, i2);
        k1 = a(k1, l2, j2, i2);
        if (I)
        {
            j1 = l1;
        } else
        {
            j1 = i2;
        }
        view = b(j1, i1, true);
        T = i2;
        view1 = ay;
        b(view1, i3, k1);
        a(view1, i3, k1);
        if (!I)
        {
            f(i2 - j2, view1.getLeft() - k2);
            a();
            e(i2 + j2, view1.getRight() + k2);
            return view;
        } else
        {
            e(l1 + j2, view1.getRight() + k2);
            a();
            f(i2 - 1, view1.getLeft() - k2);
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

    private View e(int i1, int j1)
    {
        View view = null;
        int k1 = getRight();
        for (int l1 = getLeft(); j1 < k1 - l1 && i1 < am; i1 += a)
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

    private View e(int i1, int j1, int k1)
    {
        boolean flag = false;
        int i3 = getHorizontalFadingEdgeLength();
        int j3 = ak;
        int k2 = a;
        int l2 = ar;
        int j2 = -1;
        View view;
        View view1;
        int l1;
        int i2;
        if (!I)
        {
            i2 = j3 - i1 - (j3 - i1) % k2;
            l1 = j3 - j3 % k2;
            i1 = j2;
        } else
        {
            l1 = am - 1 - j3;
            i2 = am - 1 - (l1 - l1 % k2);
            l1 = Math.max(0, (i2 - k2) + 1);
            i1 = am - 1 - (j3 - i1);
            j2 = Math.max(0, (am - 1 - (i1 - i1 % k2) - k2) + 1);
            i1 = i2;
            i2 = j2;
        }
        j3 = l1 - i2;
        i2 = d(j1, i3, l1);
        j2 = a(k1, i3, k2, l1);
        T = l1;
        if (j3 > 0)
        {
            if (az == null)
            {
                j1 = 0;
            } else
            {
                j1 = az.getRight();
            }
            if (I)
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
            if (I)
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
            if (I)
            {
                k1 = i1;
            } else
            {
                k1 = l1;
            }
            view1 = b(k1, j1, true);
            view = ay;
        }
        if (!I)
        {
            f(l1 - k2, view.getLeft() - l2);
            a();
            e(l1 + k2, view.getRight() + l2);
            return view1;
        } else
        {
            e(i1 + k2, view.getRight() + l2);
            a();
            f(l1 - 1, view.getLeft() - l2);
            return view1;
        }
    }

    private View f(int i1, int j1)
    {
        View view = null;
        for (; j1 > 0 && i1 >= 0; i1 -= a)
        {
            View view1 = b(i1, j1, false);
            if (view1 != null)
            {
                view = view1;
            }
            j1 = ay.getLeft() - ar;
            T = i1;
        }

        if (I)
        {
            T = Math.max(0, i1 + 1);
        }
        return view;
    }

    private View g(int i1, int j1)
    {
        i1 = Math.min(Math.max(i1, ak), am - 1);
        i1 = am - 1 - i1;
        return f(am - 1 - (i1 - i1 % a), j1);
    }

    private View h(int i1, int j1)
    {
        int l1 = n();
        int j2 = a;
        int k2 = ar;
        int k1 = -1;
        View view;
        View view1;
        int i2;
        int l2;
        int i3;
        if (!I)
        {
            l1 -= l1 % j2;
        } else
        {
            k1 = am - 1 - l1;
            k1 = am - 1 - (k1 - k1 % j2);
            l1 = Math.max(0, (k1 - j2) + 1);
        }
        l2 = getHorizontalFadingEdgeLength();
        i3 = d(i1, l2, l1);
        if (I)
        {
            i2 = k1;
        } else
        {
            i2 = l1;
        }
        view = b(i2, i3, true);
        T = l1;
        view1 = ay;
        if (!I)
        {
            e(l1 + j2, view1.getRight() + k2);
            m(j1);
            f(l1 - j2, view1.getLeft() - k2);
            a();
            return view;
        } else
        {
            f(a(j1, l2, j2, l1) - view1.getRight());
            f(l1 - 1, view1.getLeft() - k2);
            l(i1);
            e(k1 + j2, view1.getRight() + k2);
            a();
            return view;
        }
    }

    private View i(int i1, int j1)
    {
        View view;
        View view2;
        View view5;
        int k1;
        int i2;
        i2 = a;
        int l1 = -1;
        if (!I)
        {
            k1 = i1 - i1 % i2;
            i1 = l1;
        } else
        {
            i1 = am - 1 - i1;
            i1 = am - 1 - (i1 - i1 % i2);
            k1 = Math.max(0, (i1 - i2) + 1);
        }
        if (I)
        {
            l1 = i1;
        } else
        {
            l1 = k1;
        }
        view5 = b(l1, j1, true);
        T = k1;
        view = ay;
        if (view != null) goto _L2; else goto _L1
_L1:
        view2 = null;
_L8:
        return view2;
_L2:
        j1 = ar;
        if (I) goto _L4; else goto _L3
_L3:
        View view1;
        view2 = f(k1 - i2, view.getLeft() - j1);
        a();
        View view3 = e(k1 + i2, view.getRight() + j1);
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
        view2 = e(i1 + i2, view.getRight() + j1);
        a();
        View view4 = f(i1 - 1, view.getLeft() - j1);
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

    private boolean j(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        i2 = getChildCount();
        k1 = i2 - 1 - i1;
        if (!I)
        {
            l1 = i1 - i1 % a;
            k1 = Math.max((a + l1) - 1, i2);
        } else
        {
            k1 = i2 - 1 - (k1 - k1 % a);
            l1 = Math.max(0, (k1 - a) + 1);
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

    private View k(int i1)
    {
        T = Math.min(T, ak);
        T = Math.min(T, am - 1);
        if (T < 0)
        {
            T = 0;
        }
        T = T - T % a;
        return e(T, i1);
    }

    private void l(int i1)
    {
        if (T == 0)
        {
            i1 -= getChildAt(0).getLeft();
            if (i1 < 0)
            {
                f(i1);
            }
        }
    }

    private void m(int i1)
    {
        int j1 = getChildCount();
        if (T + j1 == am)
        {
            i1 -= getChildAt(j1 - 1).getRight();
            if (i1 > 0)
            {
                f(i1);
            }
        }
    }

    private boolean n(int i1)
    {
        int j1 = at;
        int k1 = au;
        int l1 = aw;
        boolean flag = false;
        if (ax == -1)
        {
            if (l1 > 0)
            {
                a = (i1 + j1) / (l1 + j1);
            } else
            {
                a = 2;
            }
        } else
        {
            a = ax;
        }
        if (a <= 0)
        {
            a = 1;
        }
        switch (k1)
        {
        default:
            i1 = i1 - a * l1 - (a - 1) * j1;
            if (i1 < 0)
            {
                flag = true;
            }
            switch (k1)
            {
            default:
                return flag;

            case 2: // '\002'
                av = i1 / a + l1;
                as = j1;
                return flag;

            case 1: // '\001'
                av = l1;
                if (a > 1)
                {
                    as = i1 / (a - 1) + j1;
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
        if (a > 1)
        {
            as = i1 / (a + 1) + j1;
            return flag;
        } else
        {
            as = j1 + i1;
            return flag;
        }
    }

    void a(boolean flag)
    {
        int i1 = 0;
        int l1 = a;
        int i2 = ar;
        int j1 = getChildCount();
        if (flag)
        {
            if (j1 > 0)
            {
                i1 = getChildAt(j1 - 1).getRight() + i2;
            }
            int k1 = j1 + T;
            j1 = k1;
            if (I)
            {
                j1 = k1 + (l1 - 1);
            }
            e(j1, i1);
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
        j1 = T;
        if (!I)
        {
            j1 -= l1;
        } else
        {
            j1--;
        }
        f(j1, i1);
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
        view.columnsCount = j1 / a;
        view.rowsCount = a;
        if (!I)
        {
            view.column = i1 / a;
            view.row = i1 % a;
            return;
        } else
        {
            i1 = j1 - 1 - i1;
            view.column = ((android.view.animation.GridLayoutAnimationController.AnimationParameters) (view)).columnsCount - 1 - i1 / a;
            view.row = a - 1 - i1 % a;
            return;
        }
    }

    int b(int i1, boolean flag)
    {
        if (h != null && !isInTouchMode()) goto _L2; else goto _L1
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
        if (i1 < am) goto _L4; else goto _L3
_L3:
        return -1;
    }

    protected int computeHorizontalScrollExtent()
    {
        int k1 = getChildCount();
        if (k1 > 0)
        {
            int i1 = a;
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
        if (T >= 0)
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
                    int j1 = a;
                    int i2 = ((am + j1) - 1) / j1;
                    if (d())
                    {
                        i1 = i2 * j1 - am;
                    } else
                    {
                        i1 = 0;
                    }
                    i1 = Math.max((((i1 + T) / j1) * 100 - (k1 * 100) / l1) + (int)(((float)getScrollX() / (float)getWidth()) * (float)i2 * 100F), 0);
                }
            }
        }
        return i1;
    }

    protected int computeHorizontalScrollRange()
    {
        int i1 = a;
        int k1 = ((am + i1) - 1) / i1;
        int j1 = Math.max(k1 * 100, 0);
        i1 = j1;
        if (getScrollX() != 0)
        {
            float f1 = (float)getScrollX() / (float)getWidth();
            i1 = j1 + Math.abs((int)((float)k1 * f1 * 100F));
        }
        return i1;
    }

    int d(int i1)
    {
        int i2 = getChildCount();
        if (i2 > 0)
        {
            int l1 = a;
            if (!I)
            {
                for (int j1 = 0; j1 < i2; j1 += l1)
                {
                    if (i1 <= getChildAt(j1).getRight())
                    {
                        return j1 + T;
                    }
                }

            } else
            {
                for (int k1 = i2 - 1; k1 >= 0; k1 -= l1)
                {
                    if (i1 >= getChildAt(k1).getLeft())
                    {
                        return k1 + T;
                    }
                }

            }
        }
        return -1;
    }

    public void d(int i1, int j1)
    {
        M = new Runnable(i1, j1) {

            final int a;
            final int b;
            final HorizontalGridView c;

            public void run()
            {
                View view = c.getChildAt(a - c.getFirstVisiblePosition());
                if (view == null)
                {
                    return;
                } else
                {
                    int k1 = (int)(view.getX() - (float)((c.getWidth() - view.getWidth()) / 2));
                    c.b(k1, b);
                    return;
                }
            }

            
            {
                c = HorizontalGridView.this;
                a = i1;
                b = j1;
                super();
            }
        };
        setSelection(i1);
    }

    protected void g()
    {
        i i1;
        byte byte0;
        boolean flag;
        byte0 = -1;
        i1 = null;
        flag = aq;
        if (!flag)
        {
            aq = true;
        }
        super.g();
        invalidate();
        if (h != null) goto _L2; else goto _L1
_L1:
        f();
        c();
        if (!flag)
        {
            aq = false;
        }
_L14:
        return;
_L2:
        int k1;
        int i2;
        int j2;
        k1 = s.left;
        i2 = getRight() - getLeft() - s.right;
        j2 = getChildCount();
        f;
        JVM INSTR tableswitch 1 6: default 913
    //                   1 916
    //                   2 219
    //                   3 916
    //                   4 916
    //                   5 916
    //                   6 259;
           goto _L3 _L4 _L5 _L4 _L4 _L4 _L6
_L3:
        int j1 = ak - T;
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
        boolean flag1 = ah;
        if (!flag1) goto _L10; else goto _L9
_L9:
        s();
_L10:
        if (am != 0) goto _L12; else goto _L11
_L11:
        f();
        c();
        if (flag) goto _L14; else goto _L13
_L13:
        aq = false;
        return;
_L5:
        j1 = ai - T;
        if (j1 < 0 || j1 >= j2) goto _L16; else goto _L15
_L15:
        obj2 = getChildAt(j1);
        obj = null;
        obj1 = null;
        j1 = 0;
          goto _L17
_L6:
        if (ai < 0) goto _L16; else goto _L18
_L18:
        int l1;
        j1 = ai;
        l1 = ak;
        obj = null;
        obj1 = null;
        j1 -= l1;
        obj2 = i1;
          goto _L17
_L12:
        int k2;
        setSelectedPositionInt(ai);
        k2 = T;
        i1 = n;
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
        f;
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
        if (I) goto _L33; else goto _L32
_L32:
        j1 = byte0;
        if (h != null)
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
        obj = k(k1);
_L38:
        i1.e();
        if (obj == null) goto _L35; else goto _L34
_L34:
        a(-1, ((View) (obj)));
        H = ((View) (obj)).getLeft();
_L50:
        f = 0;
        ah = false;
        if (M != null)
        {
            post(M);
            M = null;
        }
        ab = false;
        setNextSelectedPositionInt(ak);
        h();
        if (am > 0)
        {
            w();
        }
        c();
        if (!flag)
        {
            aq = false;
            return;
        }
          goto _L14
_L25:
        if (obj2 == null) goto _L37; else goto _L36
_L36:
        obj = c(((View) (obj2)).getLeft(), k1, i2);
          goto _L38
_L37:
        obj = h(k1, i2);
          goto _L38
_L24:
        T = 0;
        obj = k(k1);
        a();
          goto _L38
        obj;
        if (!flag)
        {
            aq = false;
        }
        throw obj;
_L26:
        obj = f(am - 1, i2);
        a();
          goto _L38
_L27:
        obj = i(ak, U);
          goto _L38
_L28:
        obj = i(V, U);
          goto _L38
_L29:
        obj = e(j1, k1, i2);
          goto _L38
_L33:
        k1 = am - 1;
        if (h == null || isInTouchMode())
        {
            j1 = -1;
        } else
        {
            j1 = k1;
        }
        setSelectedPositionInt(j1);
        obj = g(k1, i2);
          goto _L38
_L31:
        if (ak < 0 || ak >= am) goto _L40; else goto _L39
_L39:
        j1 = ak;
        if (obj1 != null) goto _L42; else goto _L41
_L41:
        obj = i(j1, k1);
          goto _L38
_L42:
        k1 = ((View) (obj1)).getLeft();
          goto _L41
_L40:
        if (T >= am) goto _L44; else goto _L43
_L43:
        j1 = T;
        if (obj != null) goto _L46; else goto _L45
_L45:
        obj = i(j1, k1);
          goto _L38
_L46:
        k1 = ((View) (obj)).getLeft();
          goto _L45
_L44:
        obj = i(0, k1);
          goto _L38
_L35:
        if (D <= 0 || D >= 3) goto _L48; else goto _L47
_L47:
        obj = getChildAt(y - T);
        if (obj == null) goto _L50; else goto _L49
_L49:
        a(y, ((View) (obj)));
          goto _L50
_L48:
        H = 0;
        m.setEmpty();
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

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new e(-2, -1, 0);
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return h;
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
        return a;
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
        boolean flag;
        flag = false;
        j1 = -1;
        if (i1 != 17) goto _L2; else goto _L1
_L1:
        j1 = Math.max(0, ak - getChildCount());
_L4:
        if (j1 >= 0)
        {
            setSelectionInt(j1);
            c();
            awakenScrollBars();
            flag = true;
        }
        return flag;
_L2:
        if (i1 == 66)
        {
            j1 = Math.min(am - 1, ak + getChildCount());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean i(int i1)
    {
        boolean flag = true;
        if (i1 == 17)
        {
            f = 2;
            setSelectionInt(0);
            c();
        } else
        if (i1 == 66)
        {
            f = 2;
            setSelectionInt(am - 1);
            c();
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

    boolean j(int i1)
    {
        int j1;
        int k1;
        int l1;
        int i2;
        boolean flag = true;
        l1 = ak;
        i2 = a;
        if (!I)
        {
            k1 = (l1 / i2) * i2;
            j1 = Math.min((k1 + i2) - 1, am - 1);
        } else
        {
            j1 = am;
            j1 = am - 1 - ((j1 - 1 - l1) / i2) * i2;
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
            c();
        }
        if (flag)
        {
            awakenScrollBars();
        }
        return flag;
_L2:
        if (k1 <= 0) goto _L1; else goto _L6
_L6:
        f = 6;
        setSelectionInt(Math.max(0, l1 - i2));
          goto _L7
_L4:
        if (j1 >= am - 1) goto _L1; else goto _L8
_L8:
        f = 6;
        setSelectionInt(Math.min(l1 + i2, am - 1));
          goto _L7
_L3:
        if (l1 <= k1) goto _L1; else goto _L9
_L9:
        f = 6;
        setSelectionInt(Math.max(0, l1 - 1));
          goto _L7
_L5:
        if (l1 >= j1) goto _L1; else goto _L10
_L10:
        f = 6;
        setSelectionInt(Math.min(l1 + 1, am - 1));
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
                    if (j(k1, i1))
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
            setSelection(T + i2);
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
        accessibilityevent.setClassName(com/cyberlink/youcammakeup/widgetpool/clhorizontalgridview/HorizontalGridView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(com/cyberlink/youcammakeup/widgetpool/clhorizontalgridview/HorizontalGridView.getName());
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
                i1 = av + s.top + s.bottom;
            } else
            {
                i1 = s.top + s.bottom;
            }
            i1 += getHorizontalScrollbarHeight();
        }
        flag = n(i1 - s.top - s.bottom);
        i2 = 0;
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.getCount();
        }
        am = k1;
        i3 = am;
        if (i3 > 0)
        {
            view = a(0, N);
            e2 = (e)view.getLayoutParams();
            e1 = e2;
            if (e2 == null)
            {
                e1 = (e)generateDefaultLayoutParams();
                view.setLayoutParams(e1);
            }
            e1.a = h.getItemViewType(0);
            e1.b = true;
            view.measure(getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), 0, e1.width), getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(av, 0x40000000), 0, e1.height));
            k1 = view.getMeasuredWidth();
            i2 = k1;
            if (n.b(e1.a))
            {
                n.a(view, -1);
                i2 = k1;
            }
        }
        if (j2 == 0)
        {
            k1 = s.left + s.right + i2 + getHorizontalFadingEdgeLength() * 2;
        } else
        {
            k1 = l1;
        }
        l1 = k1;
        if (j2 != 0x80000000) goto _L2; else goto _L1
_L1:
        l1 = s.left;
        j2 = s.right;
        j3 = a;
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
            if (ax * av + (ax - 1) * as + s.top + s.bottom <= i1)
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
        t = j1;
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
        if (h != null && g != null)
        {
            h.unregisterDataSetObserver(g);
        }
        f();
        n.b();
        h = listadapter;
        ao = -1;
        ap = 0x8000000000000000L;
        super.setAdapter(listadapter);
        if (h != null)
        {
            an = am;
            am = h.getCount();
            ah = true;
            u();
            g = new n(this);
            h.registerDataSetObserver(g);
            n.a(h.getViewTypeCount());
            int i1;
            if (I)
            {
                i1 = b(am - 1, false);
            } else
            {
                i1 = b(0, true);
            }
            setSelectedPositionInt(i1);
            setNextSelectedPositionInt(i1);
            w();
        } else
        {
            u();
            w();
        }
        requestLayout();
    }

    public void setGravity(int i1)
    {
        if (aA != i1)
        {
            aA = i1;
            e();
        }
    }

    public void setHorizontalSpacing(int i1)
    {
        if (i1 != ar)
        {
            ar = i1;
            e();
        }
    }

    public void setNumRows(int i1)
    {
        if (i1 != ax)
        {
            ax = i1;
            e();
        }
    }

    public void setRowHeight(int i1)
    {
        if (i1 != aw)
        {
            aw = i1;
            e();
        }
    }

    public void setSelection(int i1)
    {
        if (!isInTouchMode())
        {
            setNextSelectedPositionInt(i1);
        } else
        {
            K = i1;
        }
        f = 2;
        if (G != null)
        {
            G.a();
        }
        requestLayout();
    }

    void setSelectionInt(int i1)
    {
        int k1 = ai;
        if (G != null)
        {
            G.a();
        }
        setNextSelectedPositionInt(i1);
        g();
        int j1;
        if (I)
        {
            i1 = am - 1 - ai;
        } else
        {
            i1 = ai;
        }
        j1 = k1;
        if (I)
        {
            j1 = am - 1 - k1;
        }
        if (i1 / a != j1 / a)
        {
            awakenScrollBars();
        }
    }

    public void setStretchMode(int i1)
    {
        if (i1 != au)
        {
            au = i1;
            e();
        }
    }

    public void setVerticalSpacing(int i1)
    {
        if (i1 != at)
        {
            at = i1;
            e();
        }
    }
}

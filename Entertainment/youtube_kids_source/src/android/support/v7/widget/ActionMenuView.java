// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import bn;
import gu;
import gv;
import ie;
import ku;
import kv;
import kw;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutCompat

public class ActionMenuView extends LinearLayoutCompat
    implements bn, gu
{

    private boolean c;
    private int d;
    private int e;
    private int f;

    public ActionMenuView(Context context)
    {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        super.a = false;
        float f1 = context.getResources().getDisplayMetrics().density;
        e = (int)(56F * f1);
        f = (int)(f1 * 4F);
    }

    private boolean a(int i)
    {
        boolean flag1 = false;
        if (i == 0)
        {
            return false;
        }
        View view = getChildAt(i - 1);
        View view1 = getChildAt(i);
        boolean flag = flag1;
        if (i < getChildCount())
        {
            flag = flag1;
            if (view instanceof ku)
            {
                flag = ((ku)view).d() | false;
            }
        }
        if (i > 0 && (view1 instanceof ku))
        {
            return ((ku)view1).c() | flag;
        } else
        {
            return flag;
        }
    }

    private kv b(AttributeSet attributeset)
    {
        return new kv(getContext(), attributeset);
    }

    private static kv d()
    {
        kv kv1 = new kv(-2, -2);
        kv1.h = 16;
        return kv1;
    }

    public final kv a()
    {
        kv kv1 = d();
        kv1.a = true;
        return kv1;
    }

    public final kv a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams != null)
        {
            if (layoutparams instanceof kv)
            {
                layoutparams = new kv((kv)layoutparams);
            } else
            {
                layoutparams = new kv(layoutparams);
            }
            if (((kv) (layoutparams)).h <= 0)
            {
                layoutparams.h = 16;
            }
            return layoutparams;
        } else
        {
            return d();
        }
    }

    public final kw a(AttributeSet attributeset)
    {
        return b(attributeset);
    }

    public final boolean a(gv gv)
    {
        throw new NullPointerException();
    }

    protected final kw b()
    {
        return d();
    }

    protected final kw b(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams != null && (layoutparams instanceof kv);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return d();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return b(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        throw new NullPointerException();
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (c) goto _L2; else goto _L1
_L1:
        super.onLayout(flag, i, j, k, l);
_L4:
        return;
_L2:
        int i3 = getChildCount();
        int l2 = (l - j) / 2;
        int j3 = super.b;
        j = 0;
        int i1 = k - i - getPaddingRight() - getPaddingLeft();
        l = 0;
        flag = ie.a(this);
        int j1 = 0;
        while (j1 < i3) 
        {
            View view = getChildAt(j1);
            kv kv2;
            if (view.getVisibility() != 8)
            {
                kv kv1 = (kv)view.getLayoutParams();
                if (kv1.a)
                {
                    int k1 = view.getMeasuredWidth();
                    l = k1;
                    if (a(j1))
                    {
                        l = k1 + j3;
                    }
                    int k3 = view.getMeasuredHeight();
                    int j2;
                    int i4;
                    if (flag)
                    {
                        k1 = getPaddingLeft();
                        k1 = kv1.leftMargin + k1;
                        j2 = k1 + l;
                    } else
                    {
                        j2 = getWidth() - getPaddingRight() - kv1.rightMargin;
                        k1 = j2 - l;
                    }
                    i4 = l2 - k3 / 2;
                    view.layout(k1, i4, j2, k3 + i4);
                    l = i1 - l;
                    k1 = 1;
                    i1 = j;
                    j = k1;
                } else
                {
                    int k2 = view.getMeasuredWidth();
                    int l3 = kv1.leftMargin;
                    int j4 = kv1.rightMargin;
                    a(j1);
                    int l1 = j + 1;
                    i1 -= j4 + (k2 + l3);
                    j = l;
                    l = i1;
                    i1 = l1;
                }
            } else
            {
                int i2 = j;
                j = l;
                l = i1;
                i1 = i2;
            }
            k1 = j1 + 1;
            j1 = i1;
            i1 = l;
            l = j;
            j = j1;
            j1 = k1;
        }
        if (i3 == 1 && l == 0)
        {
            view = getChildAt(0);
            j = view.getMeasuredWidth();
            l = view.getMeasuredHeight();
            i = (k - i) / 2 - j / 2;
            k = l2 - l / 2;
            view.layout(i, k, j + i, l + k);
            return;
        }
        if (l != 0)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        i = j - i;
        if (i > 0)
        {
            i = i1 / i;
        } else
        {
            i = 0;
        }
        k = Math.max(0, i);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = getWidth() - getPaddingRight();
        j = 0;
        while (j < i3) 
        {
            view = getChildAt(j);
            kv2 = (kv)view.getLayoutParams();
            if (view.getVisibility() != 8 && !kv2.a)
            {
                i -= kv2.rightMargin;
                l = view.getMeasuredWidth();
                i1 = view.getMeasuredHeight();
                j1 = l2 - i1 / 2;
                view.layout(i - l, j1, i, i1 + j1);
                i -= kv2.leftMargin + l + k;
            }
            j++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = getPaddingLeft();
        j = 0;
        while (j < i3) 
        {
            view = getChildAt(j);
            kv2 = (kv)view.getLayoutParams();
            if (view.getVisibility() != 8 && !kv2.a)
            {
                i += kv2.leftMargin;
                l = view.getMeasuredWidth();
                i1 = view.getMeasuredHeight();
                j1 = l2 - i1 / 2;
                view.layout(i, j1, i + l, i1 + j1);
                i = kv2.rightMargin + l + k + i;
            }
            j++;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void onMeasure(int i, int j)
    {
        int i1;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        boolean flag2 = c;
        int k;
        boolean flag;
        if (android.view.View.MeasureSpec.getMode(i) == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (flag2 != c)
        {
            d = 0;
        }
        android.view.View.MeasureSpec.getSize(i);
        flag = c;
        i1 = getChildCount();
        if (!c || i1 <= 0) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k4;
        int l4;
        long l5;
        l3 = android.view.View.MeasureSpec.getMode(j);
        i = android.view.View.MeasureSpec.getSize(i);
        k3 = android.view.View.MeasureSpec.getSize(j);
        k = getPaddingLeft();
        i1 = getPaddingRight();
        j3 = getPaddingTop() + getPaddingBottom();
        i4 = getChildMeasureSpec(j, j3, -2);
        j4 = i - (k + i1);
        i = j4 / e;
        j = e;
        if (i == 0)
        {
            setMeasuredDimension(j4, 0);
            return;
        }
        k4 = e + (j4 % j) / i;
        j = 0;
        l1 = 0;
        k1 = 0;
        i2 = 0;
        j1 = 0;
        l5 = 0L;
        l4 = getChildCount();
        j2 = 0;
_L4:
        int l;
        int k2;
        boolean flag1;
label0:
        {
            if (j2 >= l4)
            {
                break; /* Loop/switch isn't completed */
            }
            View view = getChildAt(j2);
            if (view.getVisibility() == 8)
            {
                break MISSING_BLOCK_LABEL_1580;
            }
            flag1 = view instanceof ActionMenuItemView;
            k2 = i2 + 1;
            if (flag1)
            {
                view.setPadding(f, 0, f, 0);
            }
            kv kv2 = (kv)view.getLayoutParams();
            kv2.f = false;
            kv2.c = 0;
            kv2.b = 0;
            kv2.d = false;
            kv2.leftMargin = 0;
            kv2.rightMargin = 0;
            ActionMenuItemView actionmenuitemview;
            kv kv3;
            int l2;
            int i5;
            long l6;
            if (flag1 && ((ActionMenuItemView)view).b())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            kv2.e = flag1;
            if (kv2.a)
            {
                l = 1;
            } else
            {
                l = i;
            }
            kv3 = (kv)view.getLayoutParams();
            i5 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i4) - j3, android.view.View.MeasureSpec.getMode(i4));
            if (view instanceof ActionMenuItemView)
            {
                actionmenuitemview = (ActionMenuItemView)view;
            } else
            {
                actionmenuitemview = null;
            }
            if (actionmenuitemview != null && actionmenuitemview.b())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            l2 = 0;
            i2 = l2;
            if (l <= 0)
            {
                break label0;
            }
            if (i1 != 0)
            {
                i2 = l2;
                if (l < 2)
                {
                    break label0;
                }
            }
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k4 * l, 0x80000000), i5);
            l2 = view.getMeasuredWidth();
            i2 = l2 / k4;
            l = i2;
            if (l2 % k4 != 0)
            {
                l = i2 + 1;
            }
            i2 = l;
            if (i1 != 0)
            {
                i2 = l;
                if (l < 2)
                {
                    i2 = 2;
                }
            }
        }
        if (!kv3.a && i1 != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        kv3.d = flag1;
        kv3.b = i2;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i2 * k4, 0x40000000), i5);
        l1 = Math.max(l1, i2);
        float f1;
        float f2;
        float f3;
        Object obj;
        kv kv1;
        int i3;
        long l7;
        long l8;
        if (kv2.d)
        {
            l = k1 + 1;
        } else
        {
            l = k1;
        }
        if (kv2.a)
        {
            i1 = 1;
        } else
        {
            i1 = j1;
        }
        i -= i2;
        k1 = Math.max(j, view.getMeasuredHeight());
        if (i2 == 1)
        {
            l6 = 1 << j2;
            j = k2;
            i2 = k1;
            l5 = l6 | l5;
            j1 = i1;
            k1 = l;
            i1 = i2;
            l = l1;
        } else
        {
            j1 = i1;
            j = k2;
            i1 = k1;
            k1 = l;
            l = l1;
        }
_L27:
        j2++;
        i2 = j;
        l1 = l;
        j = i1;
        if (true) goto _L4; else goto _L3
_L3:
        if (j1 != 0 && i2 == 2)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        l = 0;
        j2 = i;
        i = l;
_L18:
        l8 = l5;
        if (k1 <= 0) goto _L6; else goto _L5
_L5:
        l8 = l5;
        if (j2 <= 0) goto _L6; else goto _L7
_L7:
        l = 0x7fffffff;
        l7 = 0L;
        i1 = 0;
        i3 = 0;
_L14:
        if (i3 >= l4) goto _L9; else goto _L8
_L8:
        obj = (kv)getChildAt(i3).getLayoutParams();
        if (!((kv) (obj)).d) goto _L11; else goto _L10
_L10:
        if (((kv) (obj)).b >= l) goto _L13; else goto _L12
_L12:
        i1 = ((kv) (obj)).b;
        l7 = 1 << i3;
        l = 1;
_L16:
        j3 = i3 + 1;
        i3 = i1;
        i1 = l;
        l = i3;
        i3 = j3;
          goto _L14
_L13:
        if (((kv) (obj)).b != l) goto _L11; else goto _L15
_L15:
        l7 |= 1 << i3;
        j3 = i1 + 1;
        i1 = l;
        l = j3;
          goto _L16
_L9:
        l5 |= l7;
        l8 = l5;
        if (i1 > j2) goto _L6; else goto _L17
_L17:
        i = j2;
        i1 = 0;
        while (i1 < l4) 
        {
            obj = getChildAt(i1);
            kv1 = (kv)((View) (obj)).getLayoutParams();
            if (((long)(1 << i1) & l7) == 0L)
            {
                if (kv1.b == l + 1)
                {
                    l5 |= 1 << i1;
                }
            } else
            {
                if (k2 != 0 && kv1.e && i == 1)
                {
                    ((View) (obj)).setPadding(f + k4, 0, f, 0);
                }
                kv1.b = kv1.b + 1;
                kv1.f = true;
                i--;
            }
            i1++;
        }
        j2 = i;
        i = 1;
          goto _L18
_L6:
        if (j1 == 0 && i2 == 1)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (j2 <= 0 || l8 == 0L || j2 >= i2 - 1 && l == 0 && l1 <= 1) goto _L20; else goto _L19
_L19:
        f3 = Long.bitCount(l8);
        f2 = f3;
        if (l != 0) goto _L22; else goto _L21
_L21:
        f1 = f3;
        if ((1L & l8) != 0L)
        {
            f1 = f3;
            if (!((kv)getChildAt(0).getLayoutParams()).e)
            {
                f1 = f3 - 0.5F;
            }
        }
        f2 = f1;
        if (((long)(1 << l4 - 1) & l8) == 0L) goto _L22; else goto _L23
_L23:
        f2 = f1;
        if (((kv)getChildAt(l4 - 1).getLayoutParams()).e) goto _L22; else goto _L24
_L24:
        f1 -= 0.5F;
_L26:
        if (f1 > 0.0F)
        {
            l = (int)((float)(j2 * k4) / f1);
        } else
        {
            l = 0;
        }
        i1 = 0;
        do
        {
            j1 = i;
            if (i1 >= l4)
            {
                break;
            }
            if (((long)(1 << i1) & l8) != 0L)
            {
                obj = getChildAt(i1);
                kv1 = (kv)((View) (obj)).getLayoutParams();
                if (obj instanceof ActionMenuItemView)
                {
                    kv1.c = l;
                    kv1.f = true;
                    if (i1 == 0 && !kv1.e)
                    {
                        kv1.leftMargin = -l / 2;
                    }
                    i = 1;
                } else
                if (kv1.a)
                {
                    kv1.c = l;
                    kv1.f = true;
                    kv1.rightMargin = -l / 2;
                    i = 1;
                } else
                {
                    if (i1 != 0)
                    {
                        kv1.leftMargin = l / 2;
                    }
                    if (i1 != l4 - 1)
                    {
                        kv1.rightMargin = l / 2;
                    }
                }
            }
            i1++;
        } while (true);
          goto _L25
_L20:
        j1 = i;
_L25:
        if (j1 != 0)
        {
            for (i = 0; i < l4; i++)
            {
                obj = getChildAt(i);
                kv1 = (kv)((View) (obj)).getLayoutParams();
                if (kv1.f)
                {
                    l = kv1.b;
                    ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(kv1.c + l * k4, 0x40000000), i4);
                }
            }

        }
        if (l3 == 0x40000000)
        {
            j = k3;
        }
        setMeasuredDimension(j4, j);
        return;
_L2:
        for (l = 0; l < i1; l++)
        {
            obj = (kv)getChildAt(l).getLayoutParams();
            obj.rightMargin = 0;
            obj.leftMargin = 0;
        }

        super.onMeasure(i, j);
        return;
_L22:
        f1 = f2;
        if (true) goto _L26; else goto _L11
_L11:
        j3 = l;
        l = i1;
        i1 = j3;
          goto _L16
        l = l1;
        i1 = j;
        j = i2;
          goto _L27
    }
}

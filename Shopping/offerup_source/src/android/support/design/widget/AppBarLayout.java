// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.v4.view.bi;
import android.support.v4.view.dn;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            cb, c, g, h

public class AppBarLayout extends LinearLayout
{

    boolean a;
    private int b;
    private int c;
    private int d;
    private float e;
    private int f;
    private dn g;
    private final List h;

    public AppBarLayout(Context context)
    {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = -1;
        c = -1;
        d = -1;
        f = 0;
        setOrientation(1);
        context = context.obtainStyledAttributes(attributeset, a.a, 0, 0x7f0c0191);
        e = context.getDimensionPixelSize(a.f, 0);
        setBackgroundDrawable(context.getDrawable(a.e));
        if (context.hasValue(a.g))
        {
            setExpanded(context.getBoolean(a.g, false));
        }
        context.recycle();
        android.support.design.widget.cb.a(this);
        h = new ArrayList();
        bi.f(this, e);
        bi.a(this, new c(this));
    }

    private g a(AttributeSet attributeset)
    {
        return new g(getContext(), attributeset);
    }

    private static g a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
        {
            return new g((android.widget.LinearLayout.LayoutParams)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new g((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new g(layoutparams);
        }
    }

    static List a(AppBarLayout appbarlayout)
    {
        return appbarlayout.h;
    }

    static void a(AppBarLayout appbarlayout, dn dn1)
    {
        appbarlayout.setWindowInsets(dn1);
    }

    private static g b()
    {
        return new g(-1, -2);
    }

    private void setWindowInsets(dn dn1)
    {
        b = -1;
        g = dn1;
        int i = 0;
        int j = getChildCount();
        do
        {
            if (i >= j)
            {
                break;
            }
            dn1 = bi.b(getChildAt(i), dn1);
            if (dn1.e())
            {
                break;
            }
            i++;
        } while (true);
    }

    final void a()
    {
        f = 0;
    }

    public final void a(h h1)
    {
        if (h1 != null && !h.contains(h1))
        {
            h.add(h1);
        }
    }

    public final void b(h h1)
    {
        if (h1 != null)
        {
            h.remove(h1);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof g;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return b();
    }

    protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams()
    {
        return b();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public android.widget.LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    final int getDownNestedPreScrollRange()
    {
        int i;
        int j;
        if (c != -1)
        {
            return c;
        }
        i = 0;
        j = getChildCount() - 1;
_L5:
        if (j < 0) goto _L2; else goto _L1
_L1:
        int k;
        View view = getChildAt(j);
        g g1 = (g)view.getLayoutParams();
        int l;
        int i1;
        if (bi.B(view))
        {
            k = view.getHeight();
        } else
        {
            k = view.getMeasuredHeight();
        }
        l = g1.a;
        if ((l & 5) != 5) goto _L4; else goto _L3
_L3:
        i1 = g1.topMargin;
        i = g1.bottomMargin + i1 + i;
        if ((l & 8) != 0)
        {
            i += bi.p(view);
        } else
        {
            i += k;
        }
_L6:
        j--;
          goto _L5
_L4:
        if (i > 0) goto _L2; else goto _L6
_L2:
        c = i;
        return i;
    }

    final int getDownNestedScrollRange()
    {
        if (d != -1)
        {
            return d;
        }
        int l = getChildCount();
        int i = 0;
        int j = 0;
        do
        {
            if (i >= l)
            {
                break;
            }
            View view = getChildAt(i);
            g g1 = (g)view.getLayoutParams();
            int k;
            int i1;
            int j1;
            int k1;
            if (bi.B(view))
            {
                k = view.getHeight();
            } else
            {
                k = view.getMeasuredHeight();
            }
            j1 = g1.topMargin;
            k1 = g1.bottomMargin;
            i1 = g1.a;
            if ((i1 & 1) == 0)
            {
                break;
            }
            j += k + (j1 + k1);
            if ((i1 & 2) != 0)
            {
                return j - bi.p(view);
            }
            i++;
        } while (true);
        d = j;
        return j;
    }

    final int getMinimumHeightForVisibleOverlappingContent()
    {
        int j = 0;
        int i;
        int k;
        if (g != null)
        {
            i = g.b();
        } else
        {
            i = 0;
        }
        k = bi.p(this);
        if (k != 0)
        {
            j = (k << 1) + i;
        } else
        {
            int l = getChildCount();
            if (l > 0)
            {
                return (bi.p(getChildAt(l - 1)) << 1) + i;
            }
        }
        return j;
    }

    int getPendingAction()
    {
        return f;
    }

    public float getTargetElevation()
    {
        return e;
    }

    public final int getTotalScrollRange()
    {
        if (b != -1)
        {
            return b;
        }
        int l = getChildCount();
        int j = 0;
        int i = 0;
        do
        {
label0:
            {
                if (j < l)
                {
                    View view = getChildAt(j);
                    g g1 = (g)view.getLayoutParams();
                    int k;
                    int i1;
                    if (bi.B(view))
                    {
                        k = view.getHeight();
                    } else
                    {
                        k = view.getMeasuredHeight();
                    }
                    i1 = g1.a;
                    if ((i1 & 1) != 0)
                    {
                        int j1 = g1.topMargin;
                        i += g1.bottomMargin + (k + j1);
                        if ((i1 & 2) == 0)
                        {
                            break label0;
                        }
                        i -= bi.p(view);
                    }
                }
                if (g != null)
                {
                    j = g.b();
                } else
                {
                    j = 0;
                }
                i -= j;
                b = i;
                return i;
            }
            j++;
        } while (true);
    }

    final int getUpNestedPreScrollRange()
    {
        return getTotalScrollRange();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        b = -1;
        c = -1;
        c = -1;
        a = false;
        j = getChildCount();
        i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    if (((g)getChildAt(i).getLayoutParams()).b == null)
                    {
                        break label0;
                    }
                    a = true;
                }
                return;
            }
            i++;
        } while (true);
    }

    public void setExpanded(boolean flag)
    {
        boolean flag1 = bi.B(this);
        byte byte0;
        byte byte1;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 2;
        }
        if (flag1)
        {
            byte1 = 4;
        } else
        {
            byte1 = 0;
        }
        f = byte1 | byte0;
        requestLayout();
    }

    public void setOrientation(int i)
    {
        if (i != 1)
        {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        } else
        {
            super.setOrientation(i);
            return;
        }
    }

    public void setTargetElevation(float f1)
    {
        e = f1;
    }
}

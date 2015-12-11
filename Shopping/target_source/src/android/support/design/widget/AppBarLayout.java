// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ai;
import android.support.v4.view.bh;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

public class AppBarLayout extends LinearLayout
{

    boolean a;
    private int b;
    private int c;
    private int d;
    private float e;
    private bh f;
    private final List g;

    static List a(AppBarLayout appbarlayout)
    {
        return appbarlayout.g;
    }

    private void setWindowInsets(bh bh1)
    {
        b = -1;
        f = bh1;
        int i = 0;
        int j = getChildCount();
        do
        {
label0:
            {
                if (i < j)
                {
                    bh1 = ai.b(getChildAt(i), bh1);
                    if (!bh1.e())
                    {
                        break label0;
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    protected a a()
    {
    /* block-local class not found */
    class a {}

        return new a(-1, -2);
    }

    public a a(AttributeSet attributeset)
    {
        return new a(getContext(), attributeset);
    }

    protected a a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
        {
            return new a((android.widget.LinearLayout.LayoutParams)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new a((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new a(layoutparams);
        }
    }

    final boolean b()
    {
        return a;
    }

    final boolean c()
    {
        return getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof a;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams()
    {
        return a();
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
        a a1 = (a)view.getLayoutParams();
        int l;
        if (ai.A(view))
        {
            k = view.getHeight();
        } else
        {
            k = view.getMeasuredHeight();
        }
        l = a1.a;
        if ((l & 5) != 5) goto _L4; else goto _L3
_L3:
        if ((l & 8) != 0)
        {
            i = ai.r(view) + i;
        } else
        {
            i += k;
        }
_L6:
        j--;
          goto _L5
_L4:
        if (i <= 0) goto _L6; else goto _L2
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
        int j = 0;
        int i = getChildCount() - 1;
        do
        {
            if (i < 0)
            {
                break;
            }
            View view = getChildAt(i);
            a a1 = (a)view.getLayoutParams();
            int k;
            int l;
            if (ai.A(view))
            {
                k = view.getHeight();
            } else
            {
                k = view.getMeasuredHeight();
            }
            l = a1.a;
            if ((l & 1) == 0)
            {
                break;
            }
            j += k;
            if ((l & 2) != 0)
            {
                return j - ai.r(view);
            }
            i--;
        } while (true);
        d = j;
        return j;
    }

    final int getMinimumHeightForVisibleOverlappingContent()
    {
        int j = 0;
        int i;
        int k;
        if (f != null)
        {
            i = f.b();
        } else
        {
            i = 0;
        }
        k = ai.r(this);
        if (k != 0)
        {
            j = k * 2 + i;
        } else
        {
            int l = getChildCount();
            if (l >= 1)
            {
                return ai.r(getChildAt(l - 1)) * 2 + i;
            }
        }
        return j;
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
                    a a1 = (a)view.getLayoutParams();
                    int k;
                    int i1;
                    if (ai.A(view))
                    {
                        k = view.getHeight();
                    } else
                    {
                        k = view.getMeasuredHeight();
                    }
                    i1 = a1.a;
                    if ((i1 & 1) != 0)
                    {
                        i += k;
                        if ((i1 & 2) == 0)
                        {
                            break label0;
                        }
                        i -= ai.r(view);
                    }
                }
                if (f != null)
                {
                    j = f.b();
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
                    if (((a)getChildAt(i).getLayoutParams()).b() == null)
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

    // Unreferenced inner class android/support/design/widget/AppBarLayout$Behavior
    /* block-local class not found */
    class Behavior {}


    // Unreferenced inner class android/support/design/widget/AppBarLayout$b
    /* block-local class not found */
    class b {}

}

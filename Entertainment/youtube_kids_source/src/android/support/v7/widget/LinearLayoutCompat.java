// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import do;
import dz;
import gl;
import ib;
import ie;
import kw;

public class LinearLayoutCompat extends ViewGroup
{

    boolean a;
    int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private boolean i;
    private int j[];
    private int k[];
    private Drawable l;
    private int m;
    private int n;
    private int o;

    public LinearLayoutCompat(Context context)
    {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = true;
        c = -1;
        d = 0;
        f = 0x800033;
        context = ib.a(context, attributeset, gl.g, i1, 0);
        i1 = context.a(1, -1);
        if (i1 >= 0 && e != i1)
        {
            e = i1;
            requestLayout();
        }
        int j1 = context.a(0, -1);
        if (j1 >= 0 && f != j1)
        {
            i1 = j1;
            if ((0x800007 & j1) == 0)
            {
                i1 = j1 | 0x800003;
            }
            j1 = i1;
            if ((i1 & 0x70) == 0)
            {
                j1 = i1 | 0x30;
            }
            f = j1;
            requestLayout();
        }
        boolean flag = context.a(2, true);
        if (!flag)
        {
            a = flag;
        }
        h = ((ib) (context)).a.getFloat(4, -1F);
        c = context.a(3, -1);
        i = context.a(6, false);
        attributeset = context.a(5);
        if (attributeset != l)
        {
            l = attributeset;
            boolean flag1;
            if (attributeset != null)
            {
                b = attributeset.getIntrinsicWidth();
                m = attributeset.getIntrinsicHeight();
            } else
            {
                b = 0;
                m = 0;
            }
            if (attributeset == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            setWillNotDraw(flag1);
            requestLayout();
        }
        n = context.a(7, 0);
        o = context.c(8, 0);
        ((ib) (context)).a.recycle();
    }

    private void a(int i1, int j1)
    {
        int l1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000);
        for (int k1 = 0; k1 < i1; k1++)
        {
            View view = getChildAt(k1);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            kw kw1 = (kw)view.getLayoutParams();
            if (kw1.width == -1)
            {
                int i2 = kw1.height;
                kw1.height = view.getMeasuredHeight();
                measureChildWithMargins(view, l1, 0, j1, 0);
                kw1.height = i2;
            }
        }

    }

    private void a(Canvas canvas, int i1)
    {
        l.setBounds(getPaddingLeft() + o, i1, getWidth() - getPaddingRight() - o, m + i1);
        l.draw(canvas);
    }

    private void a(View view, int i1, int j1, int k1, int l1)
    {
        measureChildWithMargins(view, i1, j1, k1, l1);
    }

    private boolean a(int i1)
    {
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if ((n & 1) == 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (i1 != getChildCount())
        {
            break; /* Loop/switch isn't completed */
        }
        if ((n & 4) == 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
        if ((n & 2) == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i1--;
        do
        {
            if (i1 < 0)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            if (getChildAt(i1).getVisibility() != 8)
            {
                break;
            }
            i1--;
        } while (true);
        if (true) goto _L3; else goto _L6
_L6:
        return false;
        return false;
    }

    private void b(int i1, int j1)
    {
        float f1;
        int ai[];
        int ai1[];
        Object obj;
        int k1;
        boolean flag;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        boolean flag1;
        int l3;
        int i4;
        int k4;
        int j5;
        int k5;
        int l5;
        boolean flag2;
        boolean flag3;
        g = 0;
        j3 = 0;
        j2 = 0;
        i2 = 0;
        i3 = 0;
        k2 = 1;
        f1 = 0.0F;
        j5 = getChildCount();
        l5 = android.view.View.MeasureSpec.getMode(i1);
        k5 = android.view.View.MeasureSpec.getMode(j1);
        l2 = 0;
        flag = false;
        if (j == null || k == null)
        {
            j = new int[4];
            k = new int[4];
        }
        ai = j;
        ai1 = k;
        ai[3] = -1;
        ai[2] = -1;
        ai[1] = -1;
        ai[0] = -1;
        ai1[3] = -1;
        ai1[2] = -1;
        ai1[1] = -1;
        ai1[0] = -1;
        flag2 = a;
        flag3 = i;
        if (l5 == 0x40000000)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        k1 = 0x80000000;
        l3 = 0;
        if (l3 >= j5) goto _L2; else goto _L1
_L1:
        obj = getChildAt(l3);
        if (obj != null) goto _L4; else goto _L3
_L3:
        g = g;
        k4 = j3;
        i4 = j2;
        k3 = i2;
        j2 = i3;
        i2 = k2;
        j3 = k1;
        k1 = l2;
_L6:
        l3++;
        l2 = k1;
        k1 = j3;
        k2 = i2;
        i3 = j2;
        i2 = k3;
        j2 = i4;
        j3 = k4;
        break MISSING_BLOCK_LABEL_155;
_L4:
        if (((View) (obj)).getVisibility() == 8)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a(l3))
        {
            g = g + b;
        }
        kw kw2 = (kw)((View) (obj)).getLayoutParams();
        f1 += kw2.g;
        int l4;
        int i5;
        if (l5 == 0x40000000 && kw2.width == 0 && kw2.g > 0.0F)
        {
            if (flag1)
            {
                g = g + (kw2.leftMargin + kw2.rightMargin);
            } else
            {
                k3 = g;
                g = Math.max(k3, kw2.leftMargin + k3 + kw2.rightMargin);
            }
            if (flag2)
            {
                k3 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                ((View) (obj)).measure(k3, k3);
            } else
            {
                flag = true;
            }
        } else
        {
            i4 = 0x80000000;
            k3 = i4;
            if (kw2.width == 0)
            {
                k3 = i4;
                if (kw2.g > 0.0F)
                {
                    k3 = 0;
                    kw2.width = -2;
                }
            }
            if (f1 == 0.0F)
            {
                i4 = g;
            } else
            {
                i4 = 0;
            }
            a(((View) (obj)), i1, i4, j1, 0);
            if (k3 != 0x80000000)
            {
                kw2.width = k3;
            }
            k3 = ((View) (obj)).getMeasuredWidth();
            if (flag1)
            {
                g = g + (kw2.leftMargin + k3 + kw2.rightMargin);
            } else
            {
                i4 = g;
                g = Math.max(i4, i4 + k3 + kw2.leftMargin + kw2.rightMargin);
            }
            if (flag3)
            {
                k1 = Math.max(k3, k1);
            }
        }
        i4 = 0;
        float f2;
        View view;
        kw kw1;
        int l1;
        if (k5 != 0x40000000 && kw2.height == -1)
        {
            k3 = 1;
            i4 = 1;
        } else
        {
            k3 = l2;
        }
        k4 = kw2.topMargin + kw2.bottomMargin;
        l4 = ((View) (obj)).getMeasuredHeight() + k4;
        i5 = ie.a(j2, dz.b(((View) (obj))));
        if (flag2)
        {
            l2 = ((View) (obj)).getBaseline();
            if (l2 != -1)
            {
                if (kw2.h < 0)
                {
                    j2 = f;
                } else
                {
                    j2 = kw2.h;
                }
                j2 = ((j2 & 0x70) >> 4 & -2) >> 1;
                ai[j2] = Math.max(ai[j2], l2);
                ai1[j2] = Math.max(ai1[j2], l4 - l2);
            }
        }
        l2 = Math.max(j3, l4);
        if (k2 != 0 && kw2.height == -1)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        if (kw2.g > 0.0F)
        {
            if (i4 == 0)
            {
                k4 = l4;
            }
            k2 = Math.max(i3, k4);
            j3 = j2;
            j2 = k2;
            i3 = i5;
            k2 = i2;
            i2 = j3;
        } else
        {
            if (i4 == 0)
            {
                k4 = l4;
            }
            k2 = Math.max(i2, k4);
            i2 = j2;
            j2 = i3;
            i3 = i5;
        }
_L7:
        j3 = k1;
        k1 = k3;
        k3 = k2;
        i4 = i3;
        k4 = l2;
        if (true) goto _L6; else goto _L5
_L2:
        if (g > 0 && a(j5))
        {
            g = g + b;
        }
        if (ai[1] != -1 || ai[0] != -1 || ai[2] != -1 || ai[3] != -1)
        {
            j3 = Math.max(j3, Math.max(ai[3], Math.max(ai[0], Math.max(ai[1], ai[2]))) + Math.max(ai1[3], Math.max(ai1[0], Math.max(ai1[1], ai1[2]))));
        }
        if (flag3 && (l5 == 0x80000000 || l5 == 0))
        {
            g = 0;
            k3 = 0;
            while (k3 < j5) 
            {
                obj = getChildAt(k3);
                if (obj == null)
                {
                    g = g;
                } else
                if (((View) (obj)).getVisibility() != 8)
                {
                    obj = (kw)((View) (obj)).getLayoutParams();
                    if (flag1)
                    {
                        l3 = g;
                        i4 = ((kw) (obj)).leftMargin;
                        g = ((kw) (obj)).rightMargin + (i4 + k1) + l3;
                    } else
                    {
                        l3 = g;
                        i4 = ((kw) (obj)).leftMargin;
                        g = Math.max(l3, ((kw) (obj)).rightMargin + (l3 + k1 + i4));
                    }
                }
                k3++;
            }
        }
        g = g + (getPaddingLeft() + getPaddingRight());
        k4 = dz.a(Math.max(g, getSuggestedMinimumWidth()), i1, 0);
        k3 = (0xffffff & k4) - g;
        if (flag || k3 != 0 && f1 > 0.0F)
        {
label0:
            {
                if (h > 0.0F)
                {
                    f1 = h;
                }
                ai[3] = -1;
                ai[2] = -1;
                ai[1] = -1;
                ai[0] = -1;
                ai1[3] = -1;
                ai1[2] = -1;
                ai1[1] = -1;
                ai1[0] = -1;
                g = 0;
                j3 = 0;
                l1 = k2;
                k2 = -1;
                k1 = j2;
                j2 = k2;
                k2 = k3;
                while (j3 < j5) 
                {
                    obj = getChildAt(j3);
                    if (obj != null && ((View) (obj)).getVisibility() != 8)
                    {
                        kw2 = (kw)((View) (obj)).getLayoutParams();
                        f2 = kw2.g;
                        if (f2 > 0.0F)
                        {
                            k3 = (int)(((float)k2 * f2) / f1);
                            i4 = getChildMeasureSpec(j1, getPaddingTop() + getPaddingBottom() + kw2.topMargin + kw2.bottomMargin, kw2.height);
                            if (kw2.width != 0 || l5 != 0x40000000)
                            {
                                l3 = k3 + ((View) (obj)).getMeasuredWidth();
                                i3 = l3;
                                if (l3 < 0)
                                {
                                    i3 = 0;
                                }
                            } else
                            if (k3 > 0)
                            {
                                i3 = k3;
                            } else
                            {
                                i3 = 0;
                            }
                            ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(i3, 0x40000000), i4);
                            k1 = ie.a(k1, dz.b(((View) (obj))) & 0xff000000);
                            f1 -= f2;
                            i3 = k2 - k3;
                            k2 = k1;
                            k1 = i3;
                        } else
                        {
                            i3 = k1;
                            k1 = k2;
                            k2 = i3;
                        }
                        if (flag1)
                        {
                            g = g + (((View) (obj)).getMeasuredWidth() + kw2.leftMargin + kw2.rightMargin);
                        } else
                        {
                            i3 = g;
                            g = Math.max(i3, ((View) (obj)).getMeasuredWidth() + i3 + kw2.leftMargin + kw2.rightMargin);
                        }
                        if (k5 != 0x40000000 && kw2.height == -1)
                        {
                            i3 = 1;
                        } else
                        {
                            i3 = 0;
                        }
                        i4 = kw2.topMargin + kw2.bottomMargin;
                        l3 = ((View) (obj)).getMeasuredHeight() + i4;
                        k3 = Math.max(j2, l3);
                        if (i3 != 0)
                        {
                            j2 = i4;
                        } else
                        {
                            j2 = l3;
                        }
                        j2 = Math.max(i2, j2);
                        if (l1 != 0 && kw2.height == -1)
                        {
                            l1 = 1;
                        } else
                        {
                            l1 = 0;
                        }
                        if (flag2)
                        {
                            i3 = ((View) (obj)).getBaseline();
                            if (i3 != -1)
                            {
                                if (kw2.h < 0)
                                {
                                    i2 = f;
                                } else
                                {
                                    i2 = kw2.h;
                                }
                                i2 = ((i2 & 0x70) >> 4 & -2) >> 1;
                                ai[i2] = Math.max(ai[i2], i3);
                                ai1[i2] = Math.max(ai1[i2], l3 - i3);
                            }
                        }
                        i3 = k2;
                        k2 = l1;
                        i2 = k3;
                        l1 = i3;
                    } else
                    {
                        k3 = l1;
                        l1 = k1;
                        i3 = j2;
                        k1 = k2;
                        k2 = k3;
                        j2 = i2;
                        i2 = i3;
                    }
                    k3 = j3 + 1;
                    i3 = k2;
                    j3 = i2;
                    k2 = k1;
                    k1 = l1;
                    l1 = i3;
                    i2 = j2;
                    j2 = j3;
                    j3 = k3;
                }
                g = g + (getPaddingLeft() + getPaddingRight());
                if (ai[1] == -1 && ai[0] == -1 && ai[2] == -1)
                {
                    k2 = j2;
                    if (ai[3] == -1)
                    {
                        break label0;
                    }
                }
                k2 = Math.max(j2, Math.max(ai[3], Math.max(ai[0], Math.max(ai[1], ai[2]))) + Math.max(ai1[3], Math.max(ai1[0], Math.max(ai1[1], ai1[2]))));
            }
            j2 = k1;
            i3 = l1;
            l1 = k2;
            k1 = i2;
            do
            {
                if (i3 != 0 || k5 == 0x40000000)
                {
                    k1 = l1;
                }
                setMeasuredDimension(0xff000000 & j2 | k4, dz.a(Math.max(k1 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), j1, j2 << 16));
                if (l2 != 0)
                {
                    k1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0x40000000);
                    for (j1 = 0; j1 < j5; j1++)
                    {
                        view = getChildAt(j1);
                        if (view.getVisibility() != 8)
                        {
                            kw1 = (kw)view.getLayoutParams();
                            if (kw1.height == -1)
                            {
                                l1 = kw1.width;
                                kw1.width = view.getMeasuredWidth();
                                measureChildWithMargins(view, i1, 0, k1, 0);
                                kw1.width = l1;
                            }
                        }
                    }

                }
                return;
            } while (true);
        } else
        {
            i2 = Math.max(i2, i3);
            if (flag3 && l5 != 0x40000000)
            {
                for (l1 = 0; l1 < j5; l1++)
                {
                    view = getChildAt(l1);
                    if (view != null && view.getVisibility() != 8 && ((kw)view.getLayoutParams()).g > 0.0F)
                    {
                        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000));
                    }
                }

            }
            k1 = i2;
            l1 = j3;
            i3 = k2;
            continue;
        }
_L5:
        int j4 = i2;
        k3 = l2;
        l2 = j3;
        j3 = j2;
        i2 = k2;
        j2 = i3;
        k2 = j4;
        i3 = j3;
          goto _L7
    }

    private void b(Canvas canvas, int i1)
    {
        l.setBounds(i1, getPaddingTop() + o, b + i1, getHeight() - getPaddingBottom() - o);
        l.draw(canvas);
    }

    private static void b(View view, int i1, int j1, int k1, int l1)
    {
        view.layout(i1, j1, i1 + k1, j1 + l1);
    }

    public kw a(AttributeSet attributeset)
    {
        return new kw(getContext(), attributeset);
    }

    protected kw b()
    {
        if (e == 0)
        {
            return new kw(-2, -2);
        }
        if (e == 1)
        {
            return new kw(-1, -2);
        } else
        {
            return null;
        }
    }

    protected kw b(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new kw(layoutparams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof kw;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return b();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return b(layoutparams);
    }

    public int getBaseline()
    {
        int i1 = -1;
        if (c >= 0) goto _L2; else goto _L1
_L1:
        i1 = super.getBaseline();
_L4:
        return i1;
_L2:
        View view;
        int j1;
        if (getChildCount() <= c)
        {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        view = getChildAt(c);
        j1 = view.getBaseline();
        if (j1 != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (c != 0)
        {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        if (true) goto _L4; else goto _L3
_L3:
        i1 = d;
        if (e != 1) goto _L6; else goto _L5
_L5:
        int k1 = f & 0x70;
        if (k1 == 48) goto _L6; else goto _L7
_L7:
        k1;
        JVM INSTR lookupswitch 2: default 132
    //                   16: 170
    //                   80: 147;
           goto _L6 _L8 _L9
_L6:
        return ((kw)view.getLayoutParams()).topMargin + i1 + j1;
_L9:
        i1 = getBottom() - getTop() - getPaddingBottom() - g;
        continue; /* Loop/switch isn't completed */
_L8:
        i1 += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - g) / 2;
        if (true) goto _L6; else goto _L10
_L10:
    }

    protected void onDraw(Canvas canvas)
    {
        if (l != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (e != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        int i2 = getChildCount();
        for (int i1 = 0; i1 < i2; i1++)
        {
            View view = getChildAt(i1);
            if (view != null && view.getVisibility() != 8 && a(i1))
            {
                kw kw1 = (kw)view.getLayoutParams();
                a(canvas, view.getTop() - kw1.topMargin - m);
            }
        }

        if (a(i2))
        {
            View view1 = getChildAt(i2 - 1);
            int j1;
            if (view1 == null)
            {
                j1 = getHeight() - getPaddingBottom() - m;
            } else
            {
                kw kw2 = (kw)view1.getLayoutParams();
                j1 = view1.getBottom();
                j1 = kw2.bottomMargin + j1;
            }
            a(canvas, j1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int k2 = getChildCount();
        boolean flag = ie.a(this);
        int k1 = 0;
        while (k1 < k2) 
        {
            View view2 = getChildAt(k1);
            if (view2 != null && view2.getVisibility() != 8 && a(k1))
            {
                kw kw3 = (kw)view2.getLayoutParams();
                int j2;
                if (flag)
                {
                    j2 = view2.getRight();
                    j2 = kw3.rightMargin + j2;
                } else
                {
                    j2 = view2.getLeft() - kw3.leftMargin - b;
                }
                b(canvas, j2);
            }
            k1++;
        }
        if (a(k2))
        {
            View view3 = getChildAt(k2 - 1);
            int l1;
            if (view3 == null)
            {
                if (flag)
                {
                    l1 = getPaddingLeft();
                } else
                {
                    l1 = getWidth() - getPaddingRight() - b;
                }
            } else
            {
                kw kw4 = (kw)view3.getLayoutParams();
                if (flag)
                {
                    l1 = view3.getLeft() - kw4.leftMargin - b;
                } else
                {
                    l1 = view3.getRight();
                    l1 = kw4.rightMargin + l1;
                }
            }
            b(canvas, l1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.onInitializeAccessibilityEvent(accessibilityevent);
            accessibilityevent.setClassName(android/support/v7/widget/LinearLayoutCompat.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
            accessibilitynodeinfo.setClassName(android/support/v7/widget/LinearLayoutCompat.getName());
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (e != 1) goto _L2; else goto _L1
_L1:
        int i2;
        int k2;
        int i3;
        int j3;
        int l3;
        int i4;
        i2 = getPaddingLeft();
        k2 = k1 - i1;
        i3 = getPaddingRight();
        j3 = getPaddingRight();
        l3 = getChildCount();
        i1 = f;
        i4 = f;
        i1 & 0x70;
        JVM INSTR lookupswitch 2: default 80
    //                   16: 135
    //                   80: 117;
           goto _L3 _L4 _L5
_L3:
        i1 = getPaddingTop();
_L29:
        k1 = 0;
_L8:
        View view;
        if (k1 >= l3)
        {
            break; /* Loop/switch isn't completed */
        }
        view = getChildAt(k1);
          goto _L6
_L10:
        k1++;
        if (true) goto _L8; else goto _L7
_L5:
        i1 = (getPaddingTop() + l1) - j1 - g;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = getPaddingTop() + (l1 - j1 - g) / 2;
        continue; /* Loop/switch isn't completed */
_L6:
        if (view == null || view.getVisibility() == 8) goto _L10; else goto _L9
_L9:
        kw kw1;
        int j4;
        int k4;
        j4 = view.getMeasuredWidth();
        k4 = view.getMeasuredHeight();
        kw1 = (kw)view.getLayoutParams();
        l1 = kw1.h;
        j1 = l1;
        if (l1 < 0)
        {
            j1 = 0x800007 & i4;
        }
        do.a(j1, dz.a(this)) & 7;
        JVM INSTR lookupswitch 2: default 248
    //                   1: 311
    //                   5: 343;
           goto _L11 _L12 _L13
_L13:
        break MISSING_BLOCK_LABEL_343;
_L11:
        j1 = kw1.leftMargin + i2;
_L14:
        l1 = i1;
        if (a(k1))
        {
            l1 = i1 + m;
        }
        i1 = l1 + kw1.topMargin;
        b(view, j1, i1, j4, k4);
        i1 += kw1.bottomMargin + k4;
          goto _L10
_L12:
        j1 = ((k2 - i2 - j3 - j4) / 2 + i2 + kw1.leftMargin) - kw1.rightMargin;
          goto _L14
        j1 = k2 - i3 - j4 - kw1.rightMargin;
          goto _L14
_L2:
        int ai[];
        int ai1[];
        int l4;
        boolean flag1;
        flag = ie.a(this);
        i3 = getPaddingTop();
        l3 = l1 - j1;
        i4 = getPaddingBottom();
        j4 = getPaddingBottom();
        k4 = getChildCount();
        j1 = f;
        l4 = f;
        flag1 = a;
        ai = j;
        ai1 = k;
        do.a(j1 & 0x800007, dz.a(this));
        JVM INSTR lookupswitch 2: default 464
    //                   1: 544
    //                   5: 526;
           goto _L15 _L16 _L17
_L15:
        i1 = getPaddingLeft();
_L20:
        View view1;
        kw kw2;
        int j2;
        int l2;
        int k3;
        int i5;
        int j5;
        int k5;
        if (flag)
        {
            l1 = k4 - 1;
            k1 = -1;
        } else
        {
            l1 = 0;
            k1 = 1;
        }
        j2 = 0;
        j1 = i1;
_L19:
        if (j2 >= k4)
        {
            break; /* Loop/switch isn't completed */
        }
        k5 = l1 + k1 * j2;
        view1 = getChildAt(k5);
          goto _L18
_L22:
        j2++;
        if (true) goto _L19; else goto _L7
_L17:
        i1 = (getPaddingLeft() + k1) - i1 - g;
          goto _L20
_L16:
        i1 = getPaddingLeft() + (k1 - i1 - g) / 2;
          goto _L20
_L18:
        if (view1 == null || view1.getVisibility() == 8) goto _L22; else goto _L21
_L21:
        i5 = view1.getMeasuredWidth();
        j5 = view1.getMeasuredHeight();
        i1 = -1;
        kw2 = (kw)view1.getLayoutParams();
        l2 = i1;
        if (flag1)
        {
            l2 = i1;
            if (kw2.height != -1)
            {
                l2 = view1.getBaseline();
            }
        }
        k3 = kw2.h;
        i1 = k3;
        if (k3 < 0)
        {
            i1 = l4 & 0x70;
        }
        i1 & 0x70;
        JVM INSTR lookupswitch 3: default 688
    //                   16: 773
    //                   48: 740
    //                   80: 805;
           goto _L23 _L24 _L25 _L26
_L26:
        break MISSING_BLOCK_LABEL_805;
_L23:
        i1 = i3;
_L27:
        if (a(k5))
        {
            j1 = b + j1;
        }
        j1 += kw2.leftMargin;
        b(view1, j1, i1, i5, j5);
        j1 += kw2.rightMargin + i5;
          goto _L22
_L25:
        k3 = kw2.topMargin + i3;
        i1 = k3;
        if (l2 != -1)
        {
            i1 = (ai[1] - l2) + k3;
        }
          goto _L27
_L24:
        i1 = ((l3 - i3 - j4 - j5) / 2 + i3 + kw2.topMargin) - kw2.bottomMargin;
          goto _L27
        k3 = l3 - i4 - j5 - kw2.bottomMargin;
        i1 = k3;
        if (l2 != -1)
        {
            i1 = view1.getMeasuredHeight();
            i1 = k3 - (ai1[2] - (i1 - l2));
        }
          goto _L27
_L7:
        return;
        if (true) goto _L29; else goto _L28
_L28:
    }

    protected void onMeasure(int i1, int j1)
    {
        if (e != 1) goto _L2; else goto _L1
_L1:
        float f1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        boolean flag;
        int i3;
        int j3;
        int k7;
        int l7;
        int i8;
        int j8;
        boolean flag1;
        g = 0;
        i2 = 0;
        k1 = 0;
        l1 = 0;
        i3 = 0;
        j2 = 1;
        f1 = 0.0F;
        k7 = getChildCount();
        l7 = android.view.View.MeasureSpec.getMode(i1);
        i8 = android.view.View.MeasureSpec.getMode(j1);
        flag = false;
        l2 = 0;
        j8 = c;
        flag1 = i;
        k2 = 0x80000000;
        j3 = 0;
_L7:
        if (j3 >= k7) goto _L4; else goto _L3
_L3:
        View view = getChildAt(j3);
        if (view != null) goto _L6; else goto _L5
_L5:
        int j4;
        int k5;
        int k6;
        int j7;
        g = g;
        j7 = i2;
        k6 = k1;
        k5 = l1;
        j4 = i3;
        i2 = j2;
        l1 = l2;
        k1 = k2;
_L12:
        j3++;
        k2 = k1;
        l2 = l1;
        j2 = i2;
        i3 = j4;
        l1 = k5;
        k1 = k6;
        i2 = j7;
          goto _L7
_L6:
        kw kw1;
        if (view.getVisibility() == 8)
        {
            break MISSING_BLOCK_LABEL_1609;
        }
        if (a(j3))
        {
            g = g + m;
        }
        kw1 = (kw)view.getLayoutParams();
        f1 += kw1.g;
        if (i8 != 0x40000000 || kw1.height != 0 || kw1.g <= 0.0F) goto _L9; else goto _L8
_L8:
        l2 = g;
        g = Math.max(l2, kw1.topMargin + l2 + kw1.bottomMargin);
        l2 = 1;
_L11:
        if (j8 >= 0 && j8 == j3 + 1)
        {
            d = g;
        }
        if (j3 < j8 && kw1.g > 0.0F)
        {
            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
        break; /* Loop/switch isn't completed */
_L9:
        k5 = 0x80000000;
        j4 = k5;
        if (kw1.height == 0)
        {
            j4 = k5;
            if (kw1.g > 0.0F)
            {
                j4 = 0;
                kw1.height = -2;
            }
        }
        if (f1 == 0.0F)
        {
            k5 = g;
        } else
        {
            k5 = 0;
        }
        a(view, i1, 0, j1, k5);
        if (j4 != 0x80000000)
        {
            kw1.height = j4;
        }
        j4 = view.getMeasuredHeight();
        k5 = g;
        g = Math.max(k5, k5 + j4 + kw1.topMargin + kw1.bottomMargin);
        if (flag1)
        {
            k2 = Math.max(j4, k2);
        }
        if (true) goto _L11; else goto _L10
_L10:
        j4 = 0;
        if (l7 != 0x40000000 && kw1.width == -1)
        {
            flag = true;
            j4 = 1;
        }
        k5 = kw1.leftMargin + kw1.rightMargin;
        k6 = view.getMeasuredWidth() + k5;
        i2 = Math.max(i2, k6);
        j7 = ie.a(k1, dz.b(view));
        if (j2 != 0 && kw1.width == -1)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (kw1.g > 0.0F)
        {
            if (j4 == 0)
            {
                k5 = k6;
            }
            i3 = Math.max(i3, k5);
            j2 = l1;
            l1 = l2;
            l2 = i2;
            i2 = i3;
            j4 = k2;
            i3 = j7;
            k2 = j2;
            j2 = i2;
            i2 = k1;
            k1 = j4;
        } else
        {
            if (j4 == 0)
            {
                k5 = k6;
            }
            j4 = Math.max(l1, k5);
            j2 = k1;
            l1 = l2;
            k1 = k2;
            l2 = i2;
            i2 = j2;
            j2 = i3;
            k2 = j4;
            i3 = j7;
        }
_L13:
        j4 = j2;
        k5 = k2;
        k6 = i3;
        j7 = l2;
          goto _L12
_L2:
        b(i1, j1);
        return;
_L4:
label0:
        {
            {
                if (g > 0 && a(k7))
                {
                    g = g + m;
                }
                if (flag1 && (i8 == 0x80000000 || i8 == 0))
                {
                    g = 0;
                    int k3 = 0;
                    while (k3 < k7) 
                    {
                        Object obj = getChildAt(k3);
                        if (obj == null)
                        {
                            g = g;
                        } else
                        if (((View) (obj)).getVisibility() != 8)
                        {
                            obj = (kw)((View) (obj)).getLayoutParams();
                            int k4 = g;
                            int l5 = ((kw) (obj)).topMargin;
                            g = Math.max(k4, ((kw) (obj)).bottomMargin + (k4 + k2 + l5));
                        }
                        k3++;
                    }
                }
                g = g + (getPaddingTop() + getPaddingBottom());
                int i6 = dz.a(Math.max(g, getSuggestedMinimumHeight()), j1, 0);
                int l3 = (0xffffff & i6) - g;
                if (l2 == 0 && (l3 == 0 || f1 <= 0.0F))
                {
                    break label0;
                }
                if (h > 0.0F)
                {
                    f1 = h;
                }
                g = 0;
                i3 = 0;
                k2 = j2;
                j2 = i2;
                i2 = l1;
                l1 = k2;
                k2 = l3;
                while (i3 < k7) 
                {
                    View view1 = getChildAt(i3);
                    if (view1.getVisibility() != 8)
                    {
                        kw kw2 = (kw)view1.getLayoutParams();
                        float f2 = kw2.g;
                        int i5;
                        if (f2 > 0.0F)
                        {
                            int i4 = (int)(((float)k2 * f2) / f1);
                            int l6 = getChildMeasureSpec(i1, getPaddingLeft() + getPaddingRight() + kw2.leftMargin + kw2.rightMargin, kw2.width);
                            if (kw2.height != 0 || i8 != 0x40000000)
                            {
                                int l4 = i4 + view1.getMeasuredHeight();
                                l2 = l4;
                                if (l4 < 0)
                                {
                                    l2 = 0;
                                }
                            } else
                            if (i4 > 0)
                            {
                                l2 = i4;
                            } else
                            {
                                l2 = 0;
                            }
                            view1.measure(l6, android.view.View.MeasureSpec.makeMeasureSpec(l2, 0x40000000));
                            k1 = ie.a(k1, dz.b(view1) & 0xffffff00);
                            l2 = k2 - i4;
                            k2 = k1;
                            f1 -= f2;
                            k1 = l2;
                        } else
                        {
                            l2 = k1;
                            k1 = k2;
                            k2 = l2;
                        }
                        i4 = kw2.leftMargin + kw2.rightMargin;
                        i5 = view1.getMeasuredWidth() + i4;
                        l2 = Math.max(j2, i5);
                        if (l7 != 0x40000000 && kw2.width == -1)
                        {
                            j2 = 1;
                        } else
                        {
                            j2 = 0;
                        }
                        if (j2 != 0)
                        {
                            j2 = i4;
                        } else
                        {
                            j2 = i5;
                        }
                        i2 = Math.max(i2, j2);
                        if (l1 != 0 && kw2.width == -1)
                        {
                            l1 = 1;
                        } else
                        {
                            l1 = 0;
                        }
                        j2 = g;
                        i4 = view1.getMeasuredHeight();
                        i5 = kw2.topMargin;
                        g = Math.max(j2, kw2.bottomMargin + (i4 + j2 + i5));
                        j2 = l1;
                        l1 = l2;
                    } else
                    {
                        l2 = l1;
                        l1 = j2;
                        j2 = k1;
                        k1 = k2;
                        k2 = j2;
                        j2 = l2;
                    }
                    i4 = i3 + 1;
                    i3 = k2;
                    l2 = l1;
                    k2 = k1;
                    k1 = i3;
                    l1 = j2;
                    j2 = l2;
                    i3 = i4;
                }
                g = g + (getPaddingTop() + getPaddingBottom());
                k2 = i2;
                i2 = j2;
                j2 = l1;
                l1 = k2;
            }
            if (j2 != 0 || l7 == 0x40000000)
            {
                l1 = i2;
            }
            setMeasuredDimension(dz.a(Math.max(l1 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i1, k1), i6);
            if (flag)
            {
                a(k7, j1);
            }
            return;
        }
        l2 = Math.max(l1, i3);
        if (flag1 && i8 != 0x40000000)
        {
            for (l1 = 0; l1 < k7; l1++)
            {
                view1 = getChildAt(l1);
                if (view1 != null && view1.getVisibility() != 8 && ((kw)view1.getLayoutParams()).g > 0.0F)
                {
                    view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(view1.getMeasuredWidth(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k2, 0x40000000));
                }
            }

        }
        l1 = l2;
        if (true)
        {
            break MISSING_BLOCK_LABEL_1383;
        }
        int j5 = k2;
        int j6 = l2;
        k2 = l1;
        l2 = i2;
        int i7 = k1;
        k1 = j5;
        l1 = j6;
        i2 = j2;
        j2 = i3;
        i3 = i7;
          goto _L13
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}

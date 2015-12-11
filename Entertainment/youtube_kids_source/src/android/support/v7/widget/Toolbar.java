// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import do;
import ds;
import dw;
import dz;
import fw;
import gl;
import hw;
import ib;
import ic;
import ie;
import java.util.ArrayList;
import java.util.List;
import ll;
import lm;
import ln;
import lo;

public class Toolbar extends ViewGroup
{

    private final Runnable A;
    public TextView a;
    public TextView b;
    public ImageButton c;
    public ImageView d;
    View e;
    public int f;
    public int g;
    public final hw h;
    public CharSequence i;
    public CharSequence j;
    public ic k;
    private Drawable l;
    private CharSequence m;
    private ImageButton n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private final ArrayList x;
    private final int y[];
    private int z;

    public Toolbar(Context context)
    {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0100b4);
    }

    public Toolbar(Context context, AttributeSet attributeset, int i1)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, gl.l, i1, 0);
        int j1 = typedarray.getResourceId(17, 0);
        Object obj = context;
        if (j1 != 0)
        {
            obj = new ContextThemeWrapper(context, j1);
        }
        typedarray.recycle();
        super(((Context) (obj)), attributeset, i1);
        h = new hw();
        v = 0x800013;
        x = new ArrayList();
        y = new int[2];
        new ll(this);
        A = new lm(this);
        context = ib.a(getContext(), attributeset, gl.l, i1, 0);
        f = context.e(9, 0);
        g = context.e(10, 0);
        i1 = v;
        v = ((ib) (context)).a.getInteger(0, i1);
        p = 48;
        i1 = context.b(11, 0);
        u = i1;
        t = i1;
        s = i1;
        r = i1;
        i1 = context.b(12, -1);
        if (i1 >= 0)
        {
            r = i1;
        }
        i1 = context.b(13, -1);
        if (i1 >= 0)
        {
            s = i1;
        }
        i1 = context.b(14, -1);
        if (i1 >= 0)
        {
            t = i1;
        }
        i1 = context.b(15, -1);
        if (i1 >= 0)
        {
            u = i1;
        }
        q = context.c(16, -1);
        i1 = context.b(4, 0x80000000);
        j1 = context.b(5, 0x80000000);
        int k1 = context.c(6, 0);
        int l1 = context.c(7, 0);
        attributeset = h;
        attributeset.h = false;
        if (k1 != 0x80000000)
        {
            attributeset.e = k1;
            attributeset.a = k1;
        }
        if (l1 != 0x80000000)
        {
            attributeset.f = l1;
            attributeset.b = l1;
        }
        if (i1 != 0x80000000 || j1 != 0x80000000)
        {
            h.a(i1, j1);
        }
        l = context.a(18);
        m = context.b(19);
        attributeset = context.b(2);
        if (!TextUtils.isEmpty(attributeset))
        {
            a(attributeset);
        }
        attributeset = context.b(3);
        if (!TextUtils.isEmpty(attributeset))
        {
            b(attributeset);
        }
        getContext();
        a(context.e(8, 0));
        attributeset = context.a(20);
        if (attributeset != null)
        {
            a(attributeset);
        }
        attributeset = context.b(21);
        if (!TextUtils.isEmpty(attributeset))
        {
            c(attributeset);
        }
        z = context.c(1, 0);
        ((ib) (context)).a.recycle();
        context.a();
    }

    private int a(View view, int i1)
    {
        ln ln1;
        int j1;
        int k1;
        int l1;
        int i2;
        ln1 = (ln)view.getLayoutParams();
        l1 = view.getMeasuredHeight();
        if (i1 > 0)
        {
            i1 = (l1 - i1) / 2;
        } else
        {
            i1 = 0;
        }
        k1 = ln1.a & 0x70;
        j1 = k1;
        k1;
        JVM INSTR lookupswitch 3: default 76
    //                   16: 85
    //                   48: 85
    //                   80: 85;
           goto _L1 _L2 _L2 _L2
_L1:
        j1 = v & 0x70;
_L2:
        j1;
        JVM INSTR lookupswitch 2: default 112
    //                   48: 167
    //                   80: 174;
           goto _L3 _L4 _L5
_L3:
        j1 = getPaddingTop();
        k1 = getPaddingBottom();
        i2 = getHeight();
        i1 = (i2 - j1 - k1 - l1) / 2;
        if (i1 >= ln1.topMargin) goto _L7; else goto _L6
_L6:
        i1 = ln1.topMargin;
_L9:
        return i1 + j1;
_L4:
        return getPaddingTop() - i1;
_L5:
        return getHeight() - getPaddingBottom() - l1 - ln1.bottomMargin - i1;
_L7:
        k1 = i2 - k1 - l1 - i1 - j1;
        if (k1 < ln1.bottomMargin)
        {
            i1 = Math.max(0, i1 - (ln1.bottomMargin - k1));
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    private int a(View view, int i1, int j1, int k1, int l1, int ai[])
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i2 = marginlayoutparams.leftMargin - ai[0];
        int j2 = marginlayoutparams.rightMargin - ai[1];
        int k2 = Math.max(0, i2) + Math.max(0, j2);
        ai[0] = Math.max(0, -i2);
        ai[1] = Math.max(0, -j2);
        view.measure(getChildMeasureSpec(i1, getPaddingLeft() + getPaddingRight() + k2 + j1, marginlayoutparams.width), getChildMeasureSpec(k1, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin + l1, marginlayoutparams.height));
        return view.getMeasuredWidth() + k2;
    }

    private int a(View view, int i1, int ai[], int j1)
    {
        ln ln1 = (ln)view.getLayoutParams();
        int k1 = ln1.leftMargin - ai[0];
        i1 = Math.max(0, k1) + i1;
        ai[0] = Math.max(0, -k1);
        j1 = a(view, j1);
        k1 = view.getMeasuredWidth();
        view.layout(i1, j1, i1 + k1, view.getMeasuredHeight() + j1);
        return ln1.rightMargin + k1 + i1;
    }

    private static ln a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof ln)
        {
            return new ln((ln)layoutparams);
        }
        if (layoutparams instanceof fw)
        {
            return new ln((fw)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new ln((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new ln(layoutparams);
        }
    }

    private void a(View view, int i1, int j1, int k1, int l1, int i2)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        l1 = getChildMeasureSpec(i1, getPaddingLeft() + getPaddingRight() + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin + j1, marginlayoutparams.width);
        j1 = getChildMeasureSpec(k1, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, marginlayoutparams.height);
        k1 = android.view.View.MeasureSpec.getMode(j1);
        i1 = j1;
        if (k1 != 0x40000000)
        {
            i1 = j1;
            if (i2 >= 0)
            {
                i1 = i2;
                if (k1 != 0)
                {
                    i1 = Math.min(android.view.View.MeasureSpec.getSize(j1), i2);
                }
                i1 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            }
        }
        view.measure(l1, i1);
    }

    private void a(List list, int i1)
    {
        boolean flag = true;
        boolean flag1 = false;
        int j1;
        int k1;
        if (dz.a(this) != 1)
        {
            flag = false;
        }
        k1 = getChildCount();
        j1 = do.a(i1, dz.a(this));
        list.clear();
        i1 = ((flag1) ? 1 : 0);
        if (flag)
        {
            for (i1 = k1 - 1; i1 >= 0; i1--)
            {
                View view = getChildAt(i1);
                ln ln1 = (ln)view.getLayoutParams();
                if (ln1.b == 0 && c(view) && b(ln1.a) == j1)
                {
                    list.add(view);
                }
            }

        } else
        {
            for (; i1 < k1; i1++)
            {
                View view1 = getChildAt(i1);
                ln ln2 = (ln)view1.getLayoutParams();
                if (ln2.b == 0 && c(view1) && b(ln2.a) == j1)
                {
                    list.add(view1);
                }
            }

        }
    }

    private int b(int i1)
    {
label0:
        {
            int k1 = dz.a(this);
            int j1 = do.a(i1, k1) & 7;
            i1 = j1;
            switch (j1)
            {
            case 2: // '\002'
            case 4: // '\004'
            default:
                if (k1 != 1)
                {
                    break label0;
                }
                i1 = 5;
                break;

            case 1: // '\001'
            case 3: // '\003'
            case 5: // '\005'
                break;
            }
            return i1;
        }
        return 3;
    }

    private int b(View view, int i1, int ai[], int j1)
    {
        ln ln1 = (ln)view.getLayoutParams();
        int k1 = ln1.rightMargin - ai[1];
        i1 -= Math.max(0, k1);
        ai[1] = Math.max(0, -k1);
        j1 = a(view, j1);
        k1 = view.getMeasuredWidth();
        view.layout(i1 - k1, j1, i1, view.getMeasuredHeight() + j1);
        return i1 - (ln1.leftMargin + k1);
    }

    protected static ln c()
    {
        return new ln(-2, -2);
    }

    private boolean c(View view)
    {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }

    private int d()
    {
        return h.a;
    }

    private static int d(View view)
    {
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i1 = ds.a(view);
        return ds.b(view) + i1;
    }

    private int e()
    {
        return h.b;
    }

    private static int e(View view)
    {
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i1 = ((android.view.ViewGroup.MarginLayoutParams) (view)).topMargin;
        return ((android.view.ViewGroup.MarginLayoutParams) (view)).bottomMargin + i1;
    }

    public final CharSequence a()
    {
        if (c != null)
        {
            return c.getContentDescription();
        } else
        {
            return null;
        }
    }

    public final void a(int i1)
    {
label0:
        {
            if (o != i1)
            {
                o = i1;
                if (i1 != 0)
                {
                    break label0;
                }
                getContext();
            }
            return;
        }
        new ContextThemeWrapper(getContext(), i1);
    }

    public final void a(Drawable drawable)
    {
        if (drawable == null) goto _L2; else goto _L1
_L1:
        b();
        if (c.getParent() == null)
        {
            a(((View) (c)));
            b(c);
        }
_L4:
        if (c != null)
        {
            c.setImageDrawable(drawable);
        }
        return;
_L2:
        if (c != null && c.getParent() != null)
        {
            removeView(c);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(View view)
    {
        Object obj = view.getLayoutParams();
        if (obj == null)
        {
            obj = c();
        } else
        if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
        {
            obj = a(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        {
            obj = (ln)obj;
        }
        obj.b = 1;
        addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public final void a(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        if (a == null)
        {
            Context context = getContext();
            a = new TextView(context);
            a.setSingleLine();
            a.setEllipsize(android.text.TextUtils.TruncateAt.END);
            if (f != 0)
            {
                a.setTextAppearance(context, f);
            }
        }
        if (a.getParent() == null)
        {
            a(((View) (a)));
            b(a);
        }
_L4:
        if (a != null)
        {
            a.setText(charsequence);
        }
        i = charsequence;
        return;
_L2:
        if (a != null && a.getParent() != null)
        {
            removeView(a);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b()
    {
        if (c == null)
        {
            c = new ImageButton(getContext(), null, 0x7f0100b5);
            ln ln1 = c();
            ln1.a = 0x800003 | p & 0x70;
            c.setLayoutParams(ln1);
        }
    }

    public void b(View view)
    {
        if (((ln)view.getLayoutParams()).b != 2 && view != null)
        {
            byte byte0;
            if (e != null)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        }
    }

    public final void b(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        if (b == null)
        {
            Context context = getContext();
            b = new TextView(context);
            b.setSingleLine();
            b.setEllipsize(android.text.TextUtils.TruncateAt.END);
            if (g != 0)
            {
                b.setTextAppearance(context, g);
            }
        }
        if (b.getParent() == null)
        {
            a(b);
            b(((View) (b)));
        }
_L4:
        if (b != null)
        {
            b.setText(charsequence);
        }
        j = charsequence;
        return;
_L2:
        if (b != null && b.getParent() != null)
        {
            removeView(b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void c(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            b();
        }
        if (c != null)
        {
            c.setContentDescription(charsequence);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return super.checkLayoutParams(layoutparams) && (layoutparams instanceof ln);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return c();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new ln(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(A);
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        Object obj;
        Object obj1;
        int ai[];
        int i2;
        int j2;
        boolean flag1;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        boolean flag2;
        if (dz.a(this) == 1)
        {
            i3 = 1;
        } else
        {
            i3 = 0;
        }
        k3 = getWidth();
        j4 = getHeight();
        j2 = getPaddingLeft();
        l3 = getPaddingRight();
        i4 = getPaddingTop();
        k4 = getPaddingBottom();
        i1 = k3 - l3;
        ai = y;
        ai[1] = 0;
        ai[0] = 0;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            i2 = dz.d(this);
        } else
        {
            i2 = z;
        }
        ln ln3;
        int l2;
        if (c(c))
        {
            if (i3 != 0)
            {
                i1 = b(c, i1, ai, i2);
                j1 = j2;
            } else
            {
                j1 = a(c, j2, ai, i2);
            }
        } else
        {
            j1 = j2;
        }
        k1 = i1;
        l1 = j1;
        if (c(n))
        {
            if (i3 != 0)
            {
                k1 = b(n, i1, ai, i2);
                l1 = j1;
            } else
            {
                l1 = a(n, j1, ai, i2);
                k1 = i1;
            }
        }
        i1 = k1;
        j1 = l1;
        if (c(((View) (null))))
        {
            if (i3 != 0)
            {
                j1 = a(null, l1, ai, i2);
                i1 = k1;
            } else
            {
                i1 = b(null, k1, ai, i2);
                j1 = l1;
            }
        }
        ai[0] = Math.max(0, d() - j1);
        ai[1] = Math.max(0, e() - (k3 - l3 - i1));
        k1 = Math.max(j1, d());
        l1 = Math.min(i1, k3 - l3 - e());
        j1 = l1;
        i1 = k1;
        if (c(e))
        {
            if (i3 != 0)
            {
                j1 = b(e, l1, ai, i2);
                i1 = k1;
            } else
            {
                i1 = a(e, k1, ai, i2);
                j1 = l1;
            }
        }
        if (c(d))
        {
            if (i3 != 0)
            {
                j1 = b(d, j1, ai, i2);
                k1 = i1;
            } else
            {
                k1 = a(d, i1, ai, i2);
            }
        } else
        {
            k1 = i1;
        }
        flag = c(a);
        flag2 = c(b);
        i1 = 0;
        if (flag)
        {
            ln ln1 = (ln)a.getLayoutParams();
            i1 = ln1.topMargin;
            l1 = a.getMeasuredHeight();
            i1 = ln1.bottomMargin + (i1 + l1) + 0;
        }
        if (flag2)
        {
            ln ln2 = (ln)b.getLayoutParams();
            l1 = ln2.topMargin;
            int k2 = b.getMeasuredHeight();
            j3 = ln2.bottomMargin + (l1 + k2) + i1;
        } else
        {
            j3 = i1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        l1 = j1;
        i1 = k1;
        if (!flag2) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            obj = a;
        } else
        {
            obj = b;
        }
        if (flag2)
        {
            obj1 = b;
        } else
        {
            obj1 = a;
        }
        obj = (ln)((View) (obj)).getLayoutParams();
        obj1 = (ln)((View) (obj1)).getLayoutParams();
        if (flag && a.getMeasuredWidth() > 0 || flag2 && b.getMeasuredWidth() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        v & 0x70;
        JVM INSTR lookupswitch 2: default 556
    //                   48: 1001
    //                   80: 1075;
           goto _L4 _L5 _L6
_L4:
        i1 = (j4 - i4 - k4 - j3) / 2;
        if (i1 < ((ln) (obj)).topMargin + t)
        {
            i1 = ((ln) (obj)).topMargin + t;
        } else
        {
            l1 = j4 - k4 - j3 - i1 - i4;
            if (l1 < ((ln) (obj)).bottomMargin + u)
            {
                i1 = Math.max(0, i1 - ((((ln) (obj1)).bottomMargin + u) - l1));
            }
        }
        i1 = i4 + i1;
_L8:
        if (i3 != 0)
        {
            if (flag1)
            {
                l1 = r;
            } else
            {
                l1 = 0;
            }
            l1 -= ai[1];
            j1 -= Math.max(0, l1);
            ai[1] = Math.max(0, -l1);
            if (flag)
            {
                obj = (ln)a.getLayoutParams();
                l1 = j1 - a.getMeasuredWidth();
                i3 = a.getMeasuredHeight() + i1;
                a.layout(l1, i1, j1, i3);
                j3 = s;
                i1 = i3 + ((ln) (obj)).bottomMargin;
                l1 -= j3;
            } else
            {
                l1 = j1;
            }
            if (flag2)
            {
                obj = (ln)b.getLayoutParams();
                i1 = ((ln) (obj)).topMargin + i1;
                i3 = b.getMeasuredWidth();
                j3 = b.getMeasuredHeight();
                b.layout(j1 - i3, i1, j1, j3 + i1);
                i1 = s;
                i3 = ((ln) (obj)).bottomMargin;
                i1 = j1 - i1;
            } else
            {
                i1 = j1;
            }
            if (flag1)
            {
                i1 = Math.min(l1, i1);
            } else
            {
                i1 = j1;
            }
            l1 = i1;
            i1 = k1;
        } else
        {
            if (flag1)
            {
                l1 = r;
            } else
            {
                l1 = 0;
            }
            l1 -= ai[0];
            k1 += Math.max(0, l1);
            ai[0] = Math.max(0, -l1);
            if (flag)
            {
                obj = (ln)a.getLayoutParams();
                i3 = a.getMeasuredWidth() + k1;
                l1 = a.getMeasuredHeight() + i1;
                a.layout(k1, i1, i3, l1);
                j3 = s;
                i1 = ((ln) (obj)).bottomMargin;
                i3 += j3;
                i1 += l1;
            } else
            {
                i3 = k1;
            }
            if (flag2)
            {
                obj = (ln)b.getLayoutParams();
                l1 = i1 + ((ln) (obj)).topMargin;
                i1 = b.getMeasuredWidth() + k1;
                j3 = b.getMeasuredHeight();
                b.layout(k1, l1, i1, j3 + l1);
                l1 = s;
                j3 = ((ln) (obj)).bottomMargin;
                j3 = l1 + i1;
            } else
            {
                j3 = k1;
            }
            l1 = j1;
            i1 = k1;
            if (flag1)
            {
                i1 = Math.max(i3, j3);
                l1 = j1;
            }
        }
_L3:
        a(x, 3);
        k1 = x.size();
        for (j1 = 0; j1 < k1; j1++)
        {
            i1 = a((View)x.get(j1), i1, ai, i2);
        }

        a(x, 5);
        l2 = x.size();
        k1 = 0;
        j1 = l1;
        for (; k1 < l2; k1++)
        {
            j1 = b((View)x.get(k1), j1, ai, i2);
        }

        a(x, 1);
        obj = x;
        i3 = ai[0];
        l2 = ai[1];
        j3 = ((List) (obj)).size();
        l1 = 0;
        for (k1 = 0; l1 < j3; k1 += k4 + i4 + j4)
        {
            obj1 = (View)((List) (obj)).get(l1);
            ln3 = (ln)((View) (obj1)).getLayoutParams();
            i3 = ln3.leftMargin - i3;
            l2 = ln3.rightMargin - l2;
            i4 = Math.max(0, i3);
            j4 = Math.max(0, l2);
            i3 = Math.max(0, -i3);
            l2 = Math.max(0, -l2);
            k4 = ((View) (obj1)).getMeasuredWidth();
            l1++;
        }

        l1 = ((k3 - j2 - l3) / 2 + j2) - k1 / 2;
        k1 = l1 + k1;
          goto _L7
_L5:
        i1 = getPaddingTop();
        i1 = ((ln) (obj)).topMargin + i1 + t;
        break MISSING_BLOCK_LABEL_600;
_L6:
        i1 = j4 - k4 - ((ln) (obj1)).bottomMargin - u - j3;
          goto _L8
_L7:
        if (l1 >= i1) goto _L10; else goto _L9
_L9:
        l1 = x.size();
        k1 = 0;
        j1 = i1;
        for (i1 = k1; i1 < l1; i1++)
        {
            j1 = a((View)x.get(i1), j1, ai, i2);
        }

        break; /* Loop/switch isn't completed */
_L10:
        i1 = l1;
        if (k1 > j1)
        {
            i1 = l1 - (k1 - j1);
        }
        if (true) goto _L9; else goto _L11
_L11:
        x.clear();
        return;
          goto _L8
    }

    protected void onMeasure(int i1, int j1)
    {
        int ai[] = y;
        Object obj;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        if (ie.a(this))
        {
            k2 = 0;
            l2 = 1;
        } else
        {
            k2 = 1;
            l2 = 0;
        }
        k1 = 0;
        if (c(c))
        {
            a(c, i1, 0, j1, 0, q);
            k1 = c.getMeasuredWidth() + d(c);
            j2 = Math.max(0, c.getMeasuredHeight() + e(c));
            i2 = ie.a(0, dz.b(c));
        } else
        {
            i2 = 0;
            j2 = 0;
        }
        i3 = k1;
        l1 = i2;
        k1 = j2;
        if (c(n))
        {
            a(n, i1, 0, j1, 0, q);
            i3 = n.getMeasuredWidth() + d(n);
            k1 = Math.max(j2, n.getMeasuredHeight() + e(n));
            l1 = ie.a(i2, dz.b(n));
        }
        obj = h;
        if (((hw) (obj)).g)
        {
            i2 = ((hw) (obj)).b;
        } else
        {
            i2 = ((hw) (obj)).a;
        }
        j2 = Math.max(i2, i3) + 0;
        ai[l2] = Math.max(0, i2 - i3);
        if (c(((View) (null))))
        {
            a(null, i1, j2, j1, 0, q);
            throw new NullPointerException();
        }
        obj = h;
        if (((hw) (obj)).g)
        {
            i2 = ((hw) (obj)).a;
        } else
        {
            i2 = ((hw) (obj)).b;
        }
        i3 = j2 + Math.max(i2, 0);
        ai[k2] = Math.max(0, i2 - 0);
        l2 = i3;
        j2 = l1;
        k2 = k1;
        if (c(e))
        {
            l2 = i3 + a(e, i1, i3, j1, 0, ai);
            k2 = Math.max(k1, e.getMeasuredHeight() + e(e));
            j2 = ie.a(l1, dz.b(e));
        }
        i2 = l2;
        k1 = j2;
        l1 = k2;
        if (c(d))
        {
            i2 = l2 + a(d, i1, l2, j1, 0, ai);
            l1 = Math.max(k2, d.getMeasuredHeight() + e(d));
            k1 = ie.a(j2, dz.b(d));
        }
        k2 = getChildCount();
        j2 = 0;
        l2 = i2;
        while (j2 < k2) 
        {
            obj = getChildAt(j2);
            int j3;
            int k3;
            int l3;
            int i4;
            if (((ln)((View) (obj)).getLayoutParams()).b == 0 && c(((View) (obj))))
            {
                l2 += a(((View) (obj)), i1, l2, j1, 0, ai);
                i2 = Math.max(l1, ((View) (obj)).getMeasuredHeight() + e(((View) (obj))));
                l1 = ie.a(k1, dz.b(((View) (obj))));
                k1 = i2;
            } else
            {
                i2 = k1;
                k1 = l1;
                l1 = i2;
            }
            j2++;
            i2 = l1;
            l1 = k1;
            k1 = i2;
        }
        k2 = 0;
        j2 = 0;
        l3 = t + u;
        i4 = r + s;
        i2 = k1;
        if (c(a))
        {
            a(a, i1, l2 + i4, j1, l3, ai);
            i2 = a.getMeasuredWidth();
            k2 = d(a) + i2;
            j2 = a.getMeasuredHeight() + e(a);
            i2 = ie.a(k1, dz.b(a));
        }
        k3 = j2;
        j3 = k2;
        k1 = i2;
        if (c(b))
        {
            j3 = Math.max(k2, a(b, i1, l2 + i4, j1, l3 + j2, ai));
            k3 = j2 + (b.getMeasuredHeight() + e(b));
            k1 = ie.a(i2, dz.b(b));
        }
        k2 = Math.max(l1, k3);
        j2 = getPaddingLeft();
        i2 = getPaddingRight();
        k3 = getPaddingTop();
        l1 = getPaddingBottom();
        setMeasuredDimension(dz.a(Math.max(j3 + l2 + (j2 + i2), getSuggestedMinimumWidth()), i1, 0xff000000 & k1), dz.a(Math.max(k2 + (k3 + l1), getSuggestedMinimumHeight()), j1, k1 << 16));
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (lo)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        int i1 = ((lo) (parcelable)).a;
        if (((lo) (parcelable)).b)
        {
            removeCallbacks(A);
            post(A);
        }
    }

    public void onRtlPropertiesChanged(int i1)
    {
        hw hw1;
label0:
        {
label1:
            {
                boolean flag = true;
                if (android.os.Build.VERSION.SDK_INT >= 17)
                {
                    super.onRtlPropertiesChanged(i1);
                }
                hw1 = h;
                if (i1 != 1)
                {
                    flag = false;
                }
                if (flag != hw1.g)
                {
                    hw1.g = flag;
                    if (!hw1.h)
                    {
                        break label0;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                    if (hw1.d != 0x80000000)
                    {
                        i1 = hw1.d;
                    } else
                    {
                        i1 = hw1.e;
                    }
                    hw1.a = i1;
                    if (hw1.c != 0x80000000)
                    {
                        i1 = hw1.c;
                    } else
                    {
                        i1 = hw1.f;
                    }
                    hw1.b = i1;
                }
                return;
            }
            if (hw1.c != 0x80000000)
            {
                i1 = hw1.c;
            } else
            {
                i1 = hw1.e;
            }
            hw1.a = i1;
            if (hw1.d != 0x80000000)
            {
                i1 = hw1.d;
            } else
            {
                i1 = hw1.f;
            }
            hw1.b = i1;
            return;
        }
        hw1.a = hw1.e;
        hw1.b = hw1.f;
    }

    protected Parcelable onSaveInstanceState()
    {
        lo lo1 = new lo(super.onSaveInstanceState());
        lo1.b = false;
        return lo1;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1 = dw.a(motionevent);
        if (i1 == 0)
        {
            w = false;
        }
        if (!w)
        {
            boolean flag = super.onTouchEvent(motionevent);
            if (i1 == 0 && !flag)
            {
                w = true;
            }
        }
        if (i1 == 1 || i1 == 3)
        {
            w = false;
        }
        return true;
    }

    public void setMinimumHeight(int i1)
    {
        z = i1;
        super.setMinimumHeight(i1);
    }
}

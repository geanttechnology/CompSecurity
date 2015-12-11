// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.e;
import android.support.v4.view.m;
import android.support.v4.view.n;
import android.support.v4.view.w;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.p;
import android.support.v7.internal.widget.l;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.support.v7.internal.widget.s;
import android.support.v7.internal.widget.t;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView, a

public class Toolbar extends ViewGroup
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        int a;
        boolean b;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            if (b)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b = flag;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    private final class a
        implements android.support.v7.internal.view.menu.l
    {

        f a;
        public h b;
        final Toolbar c;

        public final void a(Context context, f f1)
        {
            if (a != null && b != null)
            {
                a.b(b);
            }
            a = f1;
        }

        public final void a(f f1, boolean flag)
        {
        }

        public final boolean a()
        {
            return false;
        }

        public final boolean a(p p1)
        {
            return false;
        }

        public final void b(boolean flag)
        {
            boolean flag2 = false;
            if (b == null) goto _L2; else goto _L1
_L1:
            boolean flag1 = flag2;
            if (a == null) goto _L4; else goto _L3
_L3:
            int i1;
            int j1;
            j1 = a.size();
            i1 = 0;
_L9:
            flag1 = flag2;
            if (i1 >= j1) goto _L4; else goto _L5
_L5:
            if (a.getItem(i1) != b) goto _L7; else goto _L6
_L6:
            flag1 = true;
_L4:
            if (!flag1)
            {
                c(b);
            }
_L2:
            return;
_L7:
            i1++;
            if (true) goto _L9; else goto _L8
_L8:
        }

        public final boolean b(h h1)
        {
            Toolbar.b(c);
            if (Toolbar.c(c).getParent() != c)
            {
                c.addView(Toolbar.c(c));
            }
            c.d = h1.getActionView();
            b = h1;
            if (c.d.getParent() != c)
            {
                b b1 = android.support.v7.widget.Toolbar.e();
                b1.a = 0x800003 | Toolbar.d(c) & 0x70;
                b1.b = 2;
                c.d.setLayoutParams(b1);
                c.addView(c.d);
            }
            Toolbar.a(c, true);
            c.requestLayout();
            h1.d(true);
            if (c.d instanceof android.support.v7.e.b)
            {
                ((android.support.v7.e.b)c.d).a();
            }
            return true;
        }

        public final boolean c(h h1)
        {
            if (c.d instanceof android.support.v7.e.b)
            {
                ((android.support.v7.e.b)c.d).b();
            }
            c.removeView(c.d);
            c.removeView(Toolbar.c(c));
            c.d = null;
            Toolbar.a(c, false);
            b = null;
            c.requestLayout();
            h1.d(false);
            return true;
        }

        private a()
        {
            c = Toolbar.this;
            super();
        }

        public a(byte byte0)
        {
            this();
        }
    }

    public static final class b extends android.support.v7.a.a.a
    {

        int b;

        public b()
        {
            b = 0;
            a = 0x800013;
        }

        public b(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            b = 0;
        }

        public b(android.support.v7.a.a.a a1)
        {
            super(a1);
            b = 0;
        }

        public b(b b1)
        {
            super(b1);
            b = 0;
            b = b1.b;
        }

        public b(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            b = 0;
        }

        public b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            b = 0;
            leftMargin = marginlayoutparams.leftMargin;
            topMargin = marginlayoutparams.topMargin;
            rightMargin = marginlayoutparams.rightMargin;
            bottomMargin = marginlayoutparams.bottomMargin;
        }
    }

    public static interface c
    {

        public abstract boolean a(MenuItem menuitem);
    }


    private CharSequence A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private final ArrayList F;
    private final int G[];
    private c H;
    private final ActionMenuView.e I;
    private s J;
    private boolean K;
    private final Runnable L;
    private final q M;
    public ActionMenuView a;
    public TextView b;
    public TextView c;
    View d;
    public Context e;
    public int f;
    public int g;
    public int h;
    public final l i;
    public android.support.v7.widget.a j;
    public a k;
    public android.support.v7.internal.view.menu.l.a l;
    public android.support.v7.internal.view.menu.f.a m;
    private ImageButton n;
    private ImageView o;
    private Drawable p;
    private CharSequence q;
    private ImageButton r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private CharSequence z;

    public Toolbar(Context context)
    {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = new l();
        y = 0x800013;
        F = new ArrayList();
        G = new int[2];
        I = new ActionMenuView.e() {

            final Toolbar a;

            public final boolean a(MenuItem menuitem)
            {
                if (Toolbar.a(a) != null)
                {
                    return Toolbar.a(a).a(menuitem);
                } else
                {
                    return false;
                }
            }

            
            {
                a = Toolbar.this;
                super();
            }
        };
        L = new Runnable() {

            final Toolbar a;

            public final void run()
            {
                a.b();
            }

            
            {
                a = Toolbar.this;
                super();
            }
        };
        context = android.support.v7.internal.widget.r.a(getContext(), attributeset, android.support.v7.b.a.k.Toolbar, i1);
        g = context.e(android.support.v7.b.a.k.Toolbar_titleTextAppearance, 0);
        h = context.e(android.support.v7.b.a.k.Toolbar_subtitleTextAppearance, 0);
        i1 = android.support.v7.b.a.k.Toolbar_android_gravity;
        int j1 = y;
        y = ((r) (context)).a.getInteger(i1, j1);
        s = 48;
        i1 = context.b(android.support.v7.b.a.k.Toolbar_titleMargins, 0);
        x = i1;
        w = i1;
        v = i1;
        u = i1;
        i1 = context.b(android.support.v7.b.a.k.Toolbar_titleMarginStart, -1);
        if (i1 >= 0)
        {
            u = i1;
        }
        i1 = context.b(android.support.v7.b.a.k.Toolbar_titleMarginEnd, -1);
        if (i1 >= 0)
        {
            v = i1;
        }
        i1 = context.b(android.support.v7.b.a.k.Toolbar_titleMarginTop, -1);
        if (i1 >= 0)
        {
            w = i1;
        }
        i1 = context.b(android.support.v7.b.a.k.Toolbar_titleMarginBottom, -1);
        if (i1 >= 0)
        {
            x = i1;
        }
        t = context.c(android.support.v7.b.a.k.Toolbar_maxButtonHeight, -1);
        i1 = context.b(android.support.v7.b.a.k.Toolbar_contentInsetStart, 0x80000000);
        j1 = context.b(android.support.v7.b.a.k.Toolbar_contentInsetEnd, 0x80000000);
        int k1 = context.c(android.support.v7.b.a.k.Toolbar_contentInsetLeft, 0);
        int l1 = context.c(android.support.v7.b.a.k.Toolbar_contentInsetRight, 0);
        attributeset = i;
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
            i.a(i1, j1);
        }
        p = context.a(android.support.v7.b.a.k.Toolbar_collapseIcon);
        q = context.c(android.support.v7.b.a.k.Toolbar_collapseContentDescription);
        attributeset = context.c(android.support.v7.b.a.k.Toolbar_title);
        if (!TextUtils.isEmpty(attributeset))
        {
            setTitle(attributeset);
        }
        attributeset = context.c(android.support.v7.b.a.k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(attributeset))
        {
            setSubtitle(attributeset);
        }
        e = getContext();
        setPopupTheme(context.e(android.support.v7.b.a.k.Toolbar_popupTheme, 0));
        attributeset = context.a(android.support.v7.b.a.k.Toolbar_navigationIcon);
        if (attributeset != null)
        {
            setNavigationIcon(attributeset);
        }
        attributeset = context.c(android.support.v7.b.a.k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(attributeset))
        {
            setNavigationContentDescription(attributeset);
        }
        ((r) (context)).a.recycle();
        M = context.a();
    }

    private int a(View view, int i1)
    {
        b b1;
        int j1;
        int k1;
        int l1;
        int i2;
        b1 = (b)view.getLayoutParams();
        l1 = view.getMeasuredHeight();
        if (i1 > 0)
        {
            i1 = (l1 - i1) / 2;
        } else
        {
            i1 = 0;
        }
        k1 = b1.a & 0x70;
        j1 = k1;
        k1;
        JVM INSTR lookupswitch 3: default 76
    //                   16: 85
    //                   48: 85
    //                   80: 85;
           goto _L1 _L2 _L2 _L2
_L1:
        j1 = y & 0x70;
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
        if (i1 >= b1.topMargin) goto _L7; else goto _L6
_L6:
        i1 = b1.topMargin;
_L9:
        return i1 + j1;
_L4:
        return getPaddingTop() - i1;
_L5:
        return getHeight() - getPaddingBottom() - l1 - b1.bottomMargin - i1;
_L7:
        k1 = i2 - k1 - l1 - i1 - j1;
        if (k1 < b1.bottomMargin)
        {
            i1 = Math.max(0, i1 - (b1.bottomMargin - k1));
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
        b b1 = (b)view.getLayoutParams();
        int k1 = b1.leftMargin - ai[0];
        i1 = Math.max(0, k1) + i1;
        ai[0] = Math.max(0, -k1);
        j1 = a(view, j1);
        k1 = view.getMeasuredWidth();
        view.layout(i1, j1, i1 + k1, view.getMeasuredHeight() + j1);
        return b1.rightMargin + k1 + i1;
    }

    private static b a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof b)
        {
            return new b((b)layoutparams);
        }
        if (layoutparams instanceof android.support.v7.a.a.a)
        {
            return new b((android.support.v7.a.a.a)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new b((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new b(layoutparams);
        }
    }

    static c a(Toolbar toolbar)
    {
        return toolbar.H;
    }

    static void a(Toolbar toolbar, boolean flag)
    {
        toolbar.setChildVisibilityForExpandedActionView(flag);
    }

    private void a(View view)
    {
        Object obj = view.getLayoutParams();
        if (obj == null)
        {
            obj = new b();
        } else
        if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
        {
            obj = a(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        {
            obj = (b)obj;
        }
        obj.b = 1;
        addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    private void a(View view, int i1, int j1, int k1, int l1)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i2 = getChildMeasureSpec(i1, getPaddingLeft() + getPaddingRight() + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin + j1, marginlayoutparams.width);
        j1 = getChildMeasureSpec(k1, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin + 0, marginlayoutparams.height);
        k1 = android.view.View.MeasureSpec.getMode(j1);
        i1 = j1;
        if (k1 != 0x40000000)
        {
            i1 = j1;
            if (l1 >= 0)
            {
                i1 = l1;
                if (k1 != 0)
                {
                    i1 = Math.min(android.view.View.MeasureSpec.getSize(j1), l1);
                }
                i1 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            }
        }
        view.measure(i2, i1);
    }

    private void a(List list, int i1)
    {
        boolean flag = true;
        boolean flag1 = false;
        int j1;
        int k1;
        if (android.support.v4.view.w.h(this) != 1)
        {
            flag = false;
        }
        k1 = getChildCount();
        j1 = android.support.v4.view.e.a(i1, android.support.v4.view.w.h(this));
        list.clear();
        i1 = ((flag1) ? 1 : 0);
        if (flag)
        {
            for (i1 = k1 - 1; i1 >= 0; i1--)
            {
                View view = getChildAt(i1);
                b b1 = (b)view.getLayoutParams();
                if (b1.b == 0 && b(view) && b(b1.a) == j1)
                {
                    list.add(view);
                }
            }

        } else
        {
            for (; i1 < k1; i1++)
            {
                View view1 = getChildAt(i1);
                b b2 = (b)view1.getLayoutParams();
                if (b2.b == 0 && b(view1) && b(b2.a) == j1)
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
            int k1 = android.support.v4.view.w.h(this);
            int j1 = android.support.v4.view.e.a(i1, k1) & 7;
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
        b b1 = (b)view.getLayoutParams();
        int k1 = b1.rightMargin - ai[1];
        i1 -= Math.max(0, k1);
        ai[1] = Math.max(0, -k1);
        j1 = a(view, j1);
        k1 = view.getMeasuredWidth();
        view.layout(i1 - k1, j1, i1, view.getMeasuredHeight() + j1);
        return i1 - (b1.leftMargin + k1);
    }

    static void b(Toolbar toolbar)
    {
        if (toolbar.r == null)
        {
            toolbar.r = new ImageButton(toolbar.getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
            toolbar.r.setImageDrawable(toolbar.p);
            toolbar.r.setContentDescription(toolbar.q);
            b b1 = new b();
            b1.a = 0x800003 | toolbar.s & 0x70;
            b1.b = 2;
            toolbar.r.setLayoutParams(b1);
            toolbar.r.setOnClickListener(toolbar. new android.view.View.OnClickListener() {

                final Toolbar a;

                public final void onClick(View view)
                {
                    a.c();
                }

            
            {
                a = Toolbar.this;
                super();
            }
            });
        }
    }

    private boolean b(View view)
    {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }

    private static int c(View view)
    {
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i1 = android.support.v4.view.l.a(view);
        return android.support.v4.view.l.b(view) + i1;
    }

    static ImageButton c(Toolbar toolbar)
    {
        return toolbar.r;
    }

    static int d(Toolbar toolbar)
    {
        return toolbar.s;
    }

    private static int d(View view)
    {
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i1 = ((android.view.ViewGroup.MarginLayoutParams) (view)).topMargin;
        return ((android.view.ViewGroup.MarginLayoutParams) (view)).bottomMargin + i1;
    }

    protected static b e()
    {
        return new b();
    }

    private void e(View view)
    {
        if (((b)view.getLayoutParams()).b != 2 && view != a)
        {
            byte byte0;
            if (d != null)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        }
    }

    private void f()
    {
        if (o == null)
        {
            o = new ImageView(getContext());
        }
    }

    private void g()
    {
        if (n == null)
        {
            n = new ImageButton(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
            b b1 = new b();
            b1.a = 0x800003 | s & 0x70;
            n.setLayoutParams(b1);
        }
    }

    private MenuInflater getMenuInflater()
    {
        return new android.support.v7.internal.view.e(getContext());
    }

    private void setChildVisibilityForExpandedActionView(boolean flag)
    {
        int j1 = getChildCount();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view = getChildAt(i1);
            if (((b)view.getLayoutParams()).b != 2 && view != a)
            {
                byte byte0;
                if (flag)
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                }
                view.setVisibility(byte0);
            }
            i1++;
        }
    }

    public final void a(int i1)
    {
        getMenuInflater().inflate(i1, getMenu());
    }

    public final boolean a()
    {
        if (a != null)
        {
            ActionMenuView actionmenuview = a;
            boolean flag;
            if (actionmenuview.c != null && actionmenuview.c.h())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean b()
    {
        if (a != null)
        {
            ActionMenuView actionmenuview = a;
            boolean flag;
            if (actionmenuview.c != null && actionmenuview.c.d())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final void c()
    {
        h h1;
        if (k == null)
        {
            h1 = null;
        } else
        {
            h1 = k.b;
        }
        if (h1 != null)
        {
            h1.collapseActionView();
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return super.checkLayoutParams(layoutparams) && (layoutparams instanceof b);
    }

    public final void d()
    {
        if (a == null)
        {
            a = new ActionMenuView(getContext());
            a.setPopupTheme(f);
            a.setOnMenuItemClickListener(I);
            Object obj = a;
            android.support.v7.internal.view.menu.l.a a1 = l;
            android.support.v7.internal.view.menu.f.a a2 = m;
            obj.d = a1;
            obj.e = a2;
            obj = new b();
            obj.a = 0x800005 | s & 0x70;
            a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            a(a);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new b();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new b(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public int getContentInsetEnd()
    {
        l l1 = i;
        if (l1.g)
        {
            return l1.a;
        } else
        {
            return l1.b;
        }
    }

    public int getContentInsetLeft()
    {
        return i.a;
    }

    public int getContentInsetRight()
    {
        return i.b;
    }

    public int getContentInsetStart()
    {
        l l1 = i;
        if (l1.g)
        {
            return l1.b;
        } else
        {
            return l1.a;
        }
    }

    public Drawable getLogo()
    {
        if (o != null)
        {
            return o.getDrawable();
        } else
        {
            return null;
        }
    }

    public CharSequence getLogoDescription()
    {
        if (o != null)
        {
            return o.getContentDescription();
        } else
        {
            return null;
        }
    }

    public Menu getMenu()
    {
        d();
        if (a.a == null)
        {
            f f1 = (f)a.getMenu();
            if (k == null)
            {
                k = new a((byte)0);
            }
            a.setExpandedActionViewsExclusive(true);
            f1.a(k, e);
        }
        return a.getMenu();
    }

    public CharSequence getNavigationContentDescription()
    {
        if (n != null)
        {
            return n.getContentDescription();
        } else
        {
            return null;
        }
    }

    public Drawable getNavigationIcon()
    {
        if (n != null)
        {
            return n.getDrawable();
        } else
        {
            return null;
        }
    }

    public int getPopupTheme()
    {
        return f;
    }

    public CharSequence getSubtitle()
    {
        return A;
    }

    public CharSequence getTitle()
    {
        return z;
    }

    public android.support.v7.internal.widget.h getWrapper()
    {
        if (J == null)
        {
            J = new s(this, true);
        }
        return J;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(L);
    }

    public boolean onHoverEvent(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.n.a(motionevent);
        if (i1 == 9)
        {
            E = false;
        }
        if (!E)
        {
            boolean flag = super.onHoverEvent(motionevent);
            if (i1 == 9 && !flag)
            {
                E = true;
            }
        }
        if (i1 == 10 || i1 == 3)
        {
            E = false;
        }
        return true;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        Object obj;
        Object obj1;
        int ai[];
        int i2;
        boolean flag1;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        boolean flag2;
        if (android.support.v4.view.w.h(this) == 1)
        {
            l2 = 1;
        } else
        {
            l2 = 0;
        }
        k3 = getWidth();
        j4 = getHeight();
        i2 = getPaddingLeft();
        l3 = getPaddingRight();
        i4 = getPaddingTop();
        k4 = getPaddingBottom();
        l1 = k3 - l3;
        ai = G;
        ai[1] = 0;
        ai[0] = 0;
        j3 = android.support.v4.view.w.m(this);
        b b3;
        int k2;
        if (b(n))
        {
            if (l2 != 0)
            {
                l1 = b(n, l1, ai, j3);
                i1 = i2;
            } else
            {
                i1 = a(n, i2, ai, j3);
            }
        } else
        {
            i1 = i2;
        }
        j1 = l1;
        k1 = i1;
        if (b(r))
        {
            if (l2 != 0)
            {
                j1 = b(r, l1, ai, j3);
                k1 = i1;
            } else
            {
                k1 = a(r, i1, ai, j3);
                j1 = l1;
            }
        }
        i1 = j1;
        l1 = k1;
        if (b(a))
        {
            if (l2 != 0)
            {
                l1 = a(a, k1, ai, j3);
                i1 = j1;
            } else
            {
                i1 = b(a, j1, ai, j3);
                l1 = k1;
            }
        }
        ai[0] = Math.max(0, getContentInsetLeft() - l1);
        ai[1] = Math.max(0, getContentInsetRight() - (k3 - l3 - i1));
        k1 = Math.max(l1, getContentInsetLeft());
        l1 = Math.min(i1, k3 - l3 - getContentInsetRight());
        j1 = l1;
        i1 = k1;
        if (b(d))
        {
            if (l2 != 0)
            {
                j1 = b(d, l1, ai, j3);
                i1 = k1;
            } else
            {
                i1 = a(d, k1, ai, j3);
                j1 = l1;
            }
        }
        if (b(o))
        {
            if (l2 != 0)
            {
                j1 = b(o, j1, ai, j3);
                k1 = i1;
            } else
            {
                k1 = a(o, i1, ai, j3);
            }
        } else
        {
            k1 = i1;
        }
        flag = b(b);
        flag2 = b(c);
        i1 = 0;
        if (flag)
        {
            b b1 = (b)b.getLayoutParams();
            i1 = b1.topMargin;
            l1 = b.getMeasuredHeight();
            i1 = b1.bottomMargin + (i1 + l1) + 0;
        }
        if (flag2)
        {
            b b2 = (b)c.getLayoutParams();
            l1 = b2.topMargin;
            int j2 = c.getMeasuredHeight();
            i3 = b2.bottomMargin + (l1 + j2) + i1;
        } else
        {
            i3 = i1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        l1 = j1;
        i1 = k1;
        if (!flag2) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            obj = b;
        } else
        {
            obj = c;
        }
        if (flag2)
        {
            obj1 = c;
        } else
        {
            obj1 = b;
        }
        obj = (b)((View) (obj)).getLayoutParams();
        obj1 = (b)((View) (obj1)).getLayoutParams();
        if (flag && b.getMeasuredWidth() > 0 || flag2 && c.getMeasuredWidth() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        y & 0x70;
        JVM INSTR lookupswitch 2: default 560
    //                   48: 999
    //                   80: 1073;
           goto _L4 _L5 _L6
_L4:
        i1 = (j4 - i4 - k4 - i3) / 2;
        if (i1 < ((b) (obj)).topMargin + w)
        {
            i1 = ((b) (obj)).topMargin + w;
        } else
        {
            l1 = j4 - k4 - i3 - i1 - i4;
            if (l1 < ((b) (obj)).bottomMargin + x)
            {
                i1 = Math.max(0, i1 - ((((b) (obj1)).bottomMargin + x) - l1));
            }
        }
        i1 = i4 + i1;
_L8:
        if (l2 != 0)
        {
            if (flag1)
            {
                l1 = u;
            } else
            {
                l1 = 0;
            }
            l1 -= ai[1];
            j1 -= Math.max(0, l1);
            ai[1] = Math.max(0, -l1);
            if (flag)
            {
                obj = (b)b.getLayoutParams();
                l1 = j1 - b.getMeasuredWidth();
                l2 = b.getMeasuredHeight() + i1;
                b.layout(l1, i1, j1, l2);
                i3 = v;
                i1 = l2 + ((b) (obj)).bottomMargin;
                l1 -= i3;
            } else
            {
                l1 = j1;
            }
            if (flag2)
            {
                obj = (b)c.getLayoutParams();
                i1 = ((b) (obj)).topMargin + i1;
                l2 = c.getMeasuredWidth();
                i3 = c.getMeasuredHeight();
                c.layout(j1 - l2, i1, j1, i3 + i1);
                i1 = v;
                l2 = ((b) (obj)).bottomMargin;
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
                l1 = u;
            } else
            {
                l1 = 0;
            }
            l1 -= ai[0];
            k1 += Math.max(0, l1);
            ai[0] = Math.max(0, -l1);
            if (flag)
            {
                obj = (b)b.getLayoutParams();
                l2 = b.getMeasuredWidth() + k1;
                l1 = b.getMeasuredHeight() + i1;
                b.layout(k1, i1, l2, l1);
                i3 = v;
                i1 = ((b) (obj)).bottomMargin;
                l2 += i3;
                i1 += l1;
            } else
            {
                l2 = k1;
            }
            if (flag2)
            {
                obj = (b)c.getLayoutParams();
                l1 = i1 + ((b) (obj)).topMargin;
                i1 = c.getMeasuredWidth() + k1;
                i3 = c.getMeasuredHeight();
                c.layout(k1, l1, i1, i3 + l1);
                l1 = v;
                i3 = ((b) (obj)).bottomMargin;
                i3 = l1 + i1;
            } else
            {
                i3 = k1;
            }
            l1 = j1;
            i1 = k1;
            if (flag1)
            {
                i1 = Math.max(l2, i3);
                l1 = j1;
            }
        }
_L3:
        a(F, 3);
        k1 = F.size();
        for (j1 = 0; j1 < k1; j1++)
        {
            i1 = a((View)F.get(j1), i1, ai, j3);
        }

        a(F, 5);
        k2 = F.size();
        k1 = 0;
        j1 = l1;
        for (; k1 < k2; k1++)
        {
            j1 = b((View)F.get(k1), j1, ai, j3);
        }

        a(F, 1);
        obj = F;
        l2 = ai[0];
        k2 = ai[1];
        i3 = ((List) (obj)).size();
        l1 = 0;
        for (k1 = 0; l1 < i3; k1 += k4 + i4 + j4)
        {
            obj1 = (View)((List) (obj)).get(l1);
            b3 = (b)((View) (obj1)).getLayoutParams();
            l2 = b3.leftMargin - l2;
            k2 = b3.rightMargin - k2;
            i4 = Math.max(0, l2);
            j4 = Math.max(0, k2);
            l2 = Math.max(0, -l2);
            k2 = Math.max(0, -k2);
            k4 = ((View) (obj1)).getMeasuredWidth();
            l1++;
        }

        l1 = ((k3 - i2 - l3) / 2 + i2) - k1 / 2;
        k1 = l1 + k1;
          goto _L7
_L5:
        i1 = getPaddingTop();
        i1 = ((b) (obj)).topMargin + i1 + w;
        break MISSING_BLOCK_LABEL_604;
_L6:
        i1 = j4 - k4 - ((b) (obj1)).bottomMargin - x - i3;
          goto _L8
_L7:
        if (l1 >= i1) goto _L10; else goto _L9
_L9:
        l1 = F.size();
        k1 = 0;
        j1 = i1;
        for (i1 = k1; i1 < l1; i1++)
        {
            j1 = a((View)F.get(i1), j1, ai, j3);
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
        F.clear();
        return;
          goto _L8
    }

    protected void onMeasure(int i1, int j1)
    {
        int ai[] = G;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int k3;
        if (android.support.v7.internal.widget.t.a(this))
        {
            k2 = 0;
            l2 = 1;
        } else
        {
            k2 = 1;
            l2 = 0;
        }
        k1 = 0;
        if (b(n))
        {
            a(n, i1, 0, j1, t);
            k1 = n.getMeasuredWidth() + c(n);
            j2 = Math.max(0, n.getMeasuredHeight() + d(n));
            i2 = android.support.v7.internal.widget.t.a(0, android.support.v4.view.w.i(n));
        } else
        {
            i2 = 0;
            j2 = 0;
        }
        i3 = k1;
        k1 = i2;
        l1 = j2;
        if (b(r))
        {
            a(r, i1, 0, j1, t);
            i3 = r.getMeasuredWidth() + c(r);
            l1 = Math.max(j2, r.getMeasuredHeight() + d(r));
            k1 = android.support.v7.internal.widget.t.a(i2, android.support.v4.view.w.i(r));
        }
        i2 = getContentInsetStart();
        k3 = Math.max(i2, i3) + 0;
        ai[l2] = Math.max(0, i2 - i3);
        l2 = 0;
        i2 = k1;
        j2 = l1;
        if (b(a))
        {
            a(a, i1, k3, j1, t);
            l2 = a.getMeasuredWidth() + c(a);
            j2 = Math.max(l1, a.getMeasuredHeight() + d(a));
            i2 = android.support.v7.internal.widget.t.a(k1, android.support.v4.view.w.i(a));
        }
        k1 = getContentInsetEnd();
        i3 = k3 + Math.max(k1, l2);
        ai[k2] = Math.max(0, k1 - l2);
        k2 = i3;
        k1 = i2;
        l1 = j2;
        if (b(d))
        {
            k2 = i3 + a(d, i1, i3, j1, 0, ai);
            l1 = Math.max(j2, d.getMeasuredHeight() + d(d));
            k1 = android.support.v7.internal.widget.t.a(i2, android.support.v4.view.w.i(d));
        }
        i2 = k2;
        l2 = k1;
        j2 = l1;
        if (b(o))
        {
            i2 = k2 + a(o, i1, k2, j1, 0, ai);
            j2 = Math.max(l1, o.getMeasuredHeight() + d(o));
            l2 = android.support.v7.internal.widget.t.a(k1, android.support.v4.view.w.i(o));
        }
        i3 = getChildCount();
        k2 = 0;
        k1 = l2;
        l1 = j2;
        j2 = k2;
        l2 = i2;
        while (j2 < i3) 
        {
            View view1 = getChildAt(j2);
            View view;
            int j3;
            int l3;
            int i4;
            int j4;
            if (((b)view1.getLayoutParams()).b == 0 && b(view1))
            {
                l2 += a(view1, i1, l2, j1, 0, ai);
                i2 = Math.max(l1, view1.getMeasuredHeight() + d(view1));
                l1 = android.support.v7.internal.widget.t.a(k1, android.support.v4.view.w.i(view1));
                k1 = i2;
            } else
            {
                i2 = l1;
                l1 = k1;
                k1 = i2;
            }
            j2++;
            i2 = k1;
            k1 = l1;
            l1 = i2;
        }
        k2 = 0;
        j2 = 0;
        i4 = w + x;
        j4 = u + v;
        i2 = k1;
        if (b(b))
        {
            a(b, i1, l2 + j4, j1, i4, ai);
            i2 = b.getMeasuredWidth();
            k2 = c(b) + i2;
            j2 = b.getMeasuredHeight() + d(b);
            i2 = android.support.v7.internal.widget.t.a(k1, android.support.v4.view.w.i(b));
        }
        l3 = j2;
        j3 = k2;
        k1 = i2;
        if (b(c))
        {
            j3 = Math.max(k2, a(c, i1, l2 + j4, j1, i4 + j2, ai));
            l3 = j2 + (c.getMeasuredHeight() + d(c));
            k1 = android.support.v7.internal.widget.t.a(i2, android.support.v4.view.w.i(c));
        }
        i2 = Math.max(l1, l3);
        l1 = getPaddingLeft();
        l3 = getPaddingRight();
        j2 = getPaddingTop();
        k2 = getPaddingBottom();
        l1 = android.support.v4.view.w.a(Math.max(j3 + l2 + (l1 + l3), getSuggestedMinimumWidth()), i1, 0xff000000 & k1);
        j1 = android.support.v4.view.w.a(Math.max(i2 + (j2 + k2), getSuggestedMinimumHeight()), j1, k1 << 16);
        if (K) goto _L2; else goto _L1
_L1:
        i1 = 0;
_L4:
        if (i1 != 0)
        {
            j1 = 0;
        }
        setMeasuredDimension(l1, j1);
        return;
_L2:
        k1 = getChildCount();
        i1 = 0;
        do
        {
            if (i1 >= k1)
            {
                break;
            }
            view = getChildAt(i1);
            if (b(view) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0)
            {
                i1 = 0;
                continue; /* Loop/switch isn't completed */
            }
            i1++;
        } while (true);
        i1 = 1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (a != null)
        {
            parcelable = a.a;
        } else
        {
            parcelable = null;
        }
        if (savedstate.a != 0 && k != null && parcelable != null)
        {
            parcelable = parcelable.findItem(savedstate.a);
            if (parcelable != null)
            {
                android.support.v4.view.m.c(parcelable);
            }
        }
        if (savedstate.b)
        {
            removeCallbacks(L);
            post(L);
        }
    }

    public void onRtlPropertiesChanged(int i1)
    {
        l l1;
label0:
        {
label1:
            {
                boolean flag = true;
                if (android.os.Build.VERSION.SDK_INT >= 17)
                {
                    super.onRtlPropertiesChanged(i1);
                }
                l1 = i;
                if (i1 != 1)
                {
                    flag = false;
                }
                if (flag != l1.g)
                {
                    l1.g = flag;
                    if (!l1.h)
                    {
                        break label0;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                    if (l1.d != 0x80000000)
                    {
                        i1 = l1.d;
                    } else
                    {
                        i1 = l1.e;
                    }
                    l1.a = i1;
                    if (l1.c != 0x80000000)
                    {
                        i1 = l1.c;
                    } else
                    {
                        i1 = l1.f;
                    }
                    l1.b = i1;
                }
                return;
            }
            if (l1.c != 0x80000000)
            {
                i1 = l1.c;
            } else
            {
                i1 = l1.e;
            }
            l1.a = i1;
            if (l1.d != 0x80000000)
            {
                i1 = l1.d;
            } else
            {
                i1 = l1.f;
            }
            l1.b = i1;
            return;
        }
        l1.a = l1.e;
        l1.b = l1.f;
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (k != null && k.b != null)
        {
            savedstate.a = k.b.getItemId();
        }
        savedstate.b = a();
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.n.a(motionevent);
        if (i1 == 0)
        {
            D = false;
        }
        if (!D)
        {
            boolean flag = super.onTouchEvent(motionevent);
            if (i1 == 0 && !flag)
            {
                D = true;
            }
        }
        if (i1 == 1 || i1 == 3)
        {
            D = false;
        }
        return true;
    }

    public void setCollapsible(boolean flag)
    {
        K = flag;
        requestLayout();
    }

    public void setLogo(int i1)
    {
        setLogo(M.a(i1, false));
    }

    public void setLogo(Drawable drawable)
    {
        if (drawable == null) goto _L2; else goto _L1
_L1:
        f();
        if (o.getParent() == null)
        {
            a(o);
            e(o);
        }
_L4:
        if (o != null)
        {
            o.setImageDrawable(drawable);
        }
        return;
_L2:
        if (o != null && o.getParent() != null)
        {
            removeView(o);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setLogoDescription(int i1)
    {
        setLogoDescription(getContext().getText(i1));
    }

    public void setLogoDescription(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            f();
        }
        if (o != null)
        {
            o.setContentDescription(charsequence);
        }
    }

    public void setNavigationContentDescription(int i1)
    {
        CharSequence charsequence;
        if (i1 != 0)
        {
            charsequence = getContext().getText(i1);
        } else
        {
            charsequence = null;
        }
        setNavigationContentDescription(charsequence);
    }

    public void setNavigationContentDescription(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            g();
        }
        if (n != null)
        {
            n.setContentDescription(charsequence);
        }
    }

    public void setNavigationIcon(int i1)
    {
        setNavigationIcon(M.a(i1, false));
    }

    public void setNavigationIcon(Drawable drawable)
    {
        if (drawable == null) goto _L2; else goto _L1
_L1:
        g();
        if (n.getParent() == null)
        {
            a(n);
            e(n);
        }
_L4:
        if (n != null)
        {
            n.setImageDrawable(drawable);
        }
        return;
_L2:
        if (n != null && n.getParent() != null)
        {
            removeView(n);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        g();
        n.setOnClickListener(onclicklistener);
    }

    public void setOnMenuItemClickListener(c c1)
    {
        H = c1;
    }

    public void setPopupTheme(int i1)
    {
label0:
        {
            if (f != i1)
            {
                f = i1;
                if (i1 != 0)
                {
                    break label0;
                }
                e = getContext();
            }
            return;
        }
        e = new ContextThemeWrapper(getContext(), i1);
    }

    public void setSubtitle(int i1)
    {
        setSubtitle(getContext().getText(i1));
    }

    public void setSubtitle(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        if (c == null)
        {
            Context context = getContext();
            c = new TextView(context);
            c.setSingleLine();
            c.setEllipsize(android.text.TextUtils.TruncateAt.END);
            if (h != 0)
            {
                c.setTextAppearance(context, h);
            }
            if (C != 0)
            {
                c.setTextColor(C);
            }
        }
        if (c.getParent() == null)
        {
            a(c);
            e(c);
        }
_L4:
        if (c != null)
        {
            c.setText(charsequence);
        }
        A = charsequence;
        return;
_L2:
        if (c != null && c.getParent() != null)
        {
            removeView(c);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSubtitleTextColor(int i1)
    {
        C = i1;
        if (c != null)
        {
            c.setTextColor(i1);
        }
    }

    public void setTitle(int i1)
    {
        setTitle(getContext().getText(i1));
    }

    public void setTitle(CharSequence charsequence)
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
            if (B != 0)
            {
                b.setTextColor(B);
            }
        }
        if (b.getParent() == null)
        {
            a(b);
            e(b);
        }
_L4:
        if (b != null)
        {
            b.setText(charsequence);
        }
        z = charsequence;
        return;
_L2:
        if (b != null && b.getParent() != null)
        {
            removeView(b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setTitleTextColor(int i1)
    {
        B = i1;
        if (b != null)
        {
            b.setTextColor(i1);
        }
    }
}

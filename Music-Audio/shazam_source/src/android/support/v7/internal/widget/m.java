// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.internal.view.a;
import android.support.v7.widget.l;
import android.support.v7.widget.q;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat, AbsSpinnerCompat, r

public final class m extends HorizontalScrollView
    implements e.b
{
    private final class a extends BaseAdapter
    {

        final m a;

        public final int getCount()
        {
            return android.support.v7.internal.widget.m.a(a).getChildCount();
        }

        public final Object getItem(int j)
        {
            return ((b)android.support.v7.internal.widget.m.a(a).getChildAt(j)).a;
        }

        public final long getItemId(int j)
        {
            return (long)j;
        }

        public final View getView(int j, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                return android.support.v7.internal.widget.m.a(a, (android.support.v7.a.a.b)getItem(j));
            } else
            {
                viewgroup = (b)view;
                viewgroup.a = (android.support.v7.a.a.b)getItem(j);
                viewgroup.a();
                return view;
            }
        }

        private a()
        {
            a = m.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b extends q
        implements android.view.View.OnLongClickListener
    {

        android.support.v7.a.a.b a;
        final m b;
        private final int c[] = {
            0x10100d4
        };
        private TextView d;
        private ImageView e;
        private View f;

        public final void a()
        {
            Object obj = a;
            Object obj1 = ((android.support.v7.a.a.b) (obj)).c();
            if (obj1 != null)
            {
                obj = ((View) (obj1)).getParent();
                if (obj != this)
                {
                    if (obj != null)
                    {
                        ((ViewGroup)obj).removeView(((View) (obj1)));
                    }
                    addView(((View) (obj1)));
                }
                f = ((View) (obj1));
                if (d != null)
                {
                    d.setVisibility(8);
                }
                if (e != null)
                {
                    e.setVisibility(8);
                    e.setImageDrawable(null);
                }
                return;
            }
            if (f != null)
            {
                removeView(f);
                f = null;
            }
            android.graphics.drawable.Drawable drawable = ((android.support.v7.a.a.b) (obj)).a();
            obj1 = ((android.support.v7.a.a.b) (obj)).b();
            boolean flag;
            if (drawable != null)
            {
                if (e == null)
                {
                    ImageView imageview = new ImageView(getContext());
                    android.support.v7.widget.q.a a2 = new android.support.v7.widget.q.a(-2, -2);
                    a2.h = 16;
                    imageview.setLayoutParams(a2);
                    addView(imageview, 0);
                    e = imageview;
                }
                e.setImageDrawable(drawable);
                e.setVisibility(0);
            } else
            if (e != null)
            {
                e.setVisibility(8);
                e.setImageDrawable(null);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (d == null)
                {
                    l l1 = new l(getContext(), null, android.support.v7.b.a.a.actionBarTabTextStyle);
                    l1.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    android.support.v7.widget.q.a a1 = new android.support.v7.widget.q.a(-2, -2);
                    a1.h = 16;
                    l1.setLayoutParams(a1);
                    addView(l1);
                    d = l1;
                }
                d.setText(((CharSequence) (obj1)));
                d.setVisibility(0);
            } else
            if (d != null)
            {
                d.setVisibility(8);
                d.setText(null);
            }
            if (e != null)
            {
                e.setContentDescription(((android.support.v7.a.a.b) (obj)).d());
            }
            if (!flag && !TextUtils.isEmpty(((android.support.v7.a.a.b) (obj)).d()))
            {
                setOnLongClickListener(this);
                return;
            } else
            {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(accessibilityevent);
            accessibilityevent.setClassName(android/support/v7/a/a$b.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
        {
            super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                accessibilitynodeinfo.setClassName(android/support/v7/a/a$b.getName());
            }
        }

        public final boolean onLongClick(View view)
        {
            view = new int[2];
            getLocationOnScreen(view);
            Object obj = getContext();
            int j = getWidth();
            int k = getHeight();
            int i1 = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
            obj = Toast.makeText(((Context) (obj)), a.d(), 0);
            ((Toast) (obj)).setGravity(49, (view[0] + j / 2) - i1 / 2, k);
            ((Toast) (obj)).show();
            return true;
        }

        public final void onMeasure(int j, int k)
        {
            super.onMeasure(j, k);
            if (b.b > 0 && getMeasuredWidth() > b.b)
            {
                super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(b.b, 0x40000000), k);
            }
        }

        public final void setSelected(boolean flag)
        {
            boolean flag1;
            if (isSelected() != flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            super.setSelected(flag);
            if (flag1 && flag)
            {
                sendAccessibilityEvent(4);
            }
        }

        public b(Context context, android.support.v7.a.a.b b1)
        {
            b = m.this;
            super(context, null, android.support.v7.b.a.a.actionBarTabStyle);
            a = b1;
            m1 = android.support.v7.internal.widget.r.a(context, null, c, android.support.v7.b.a.a.actionBarTabStyle);
            if (r.this.d(0))
            {
                setBackgroundDrawable(r.this.a(0));
            }
            m.this.a.recycle();
            setGravity(0x800013);
            a();
        }
    }


    private static final Interpolator i = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private q d;
    private SpinnerCompat e;
    private boolean f;
    private int g;
    private int h;

    static b a(m m1, android.support.v7.a.a.b b1)
    {
        b1 = m1. new b(m1.getContext(), b1);
        b1.setBackgroundDrawable(null);
        b1.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, m1.g));
        return b1;
    }

    static q a(m m1)
    {
        return m1.d;
    }

    private boolean a()
    {
        return e != null && e.getParent() == this;
    }

    private boolean b()
    {
        if (!a())
        {
            return false;
        } else
        {
            removeView(e);
            addView(d, new android.view.ViewGroup.LayoutParams(-2, -1));
            setTabSelected(e.getSelectedItemPosition());
            return false;
        }
    }

    public final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (a != null)
        {
            post(a);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        configuration = android.support.v7.internal.view.a.a(getContext());
        TypedArray typedarray = ((android.support.v7.internal.view.a) (configuration)).a.obtainStyledAttributes(null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
        int k = typedarray.getLayoutDimension(android.support.v7.b.a.k.ActionBar_height, 0);
        Resources resources = ((android.support.v7.internal.view.a) (configuration)).a.getResources();
        int j = k;
        if (!configuration.a())
        {
            j = Math.min(k, resources.getDimensionPixelSize(android.support.v7.b.a.d.abc_action_bar_stacked_max_height));
        }
        typedarray.recycle();
        setContentHeight(j);
        c = ((android.support.v7.internal.view.a) (configuration)).a.getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_action_bar_stacked_tab_max_width);
    }

    public final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (a != null)
        {
            removeCallbacks(a);
        }
    }

    public final void onMeasure(int j, int k)
    {
        k = 1;
        int l = android.view.View.MeasureSpec.getMode(j);
        int j1;
        boolean flag;
        if (l == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        j1 = d.getChildCount();
        if (j1 > 1 && (l == 0x40000000 || l == 0x80000000))
        {
            SpinnerCompat spinnercompat;
            int i1;
            if (j1 > 2)
            {
                b = (int)((float)android.view.View.MeasureSpec.getSize(j) * 0.4F);
            } else
            {
                b = android.view.View.MeasureSpec.getSize(j) / 2;
            }
            b = Math.min(b, c);
        } else
        {
            b = -1;
        }
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(g, 0x40000000);
        if (flag || !f)
        {
            k = 0;
        }
        if (k != 0)
        {
            d.measure(0, i1);
            if (d.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(j))
            {
                if (!a())
                {
                    if (e == null)
                    {
                        spinnercompat = new SpinnerCompat(getContext(), android.support.v7.b.a.a.actionDropDownStyle);
                        spinnercompat.setLayoutParams(new android.support.v7.widget.q.a(-2, -1));
                        spinnercompat.a(this);
                        e = spinnercompat;
                    }
                    removeView(d);
                    addView(e, new android.view.ViewGroup.LayoutParams(-2, -1));
                    if (((AbsSpinnerCompat) (e)).a == null)
                    {
                        e.a(new a((byte)0));
                    }
                    if (a != null)
                    {
                        removeCallbacks(a);
                        a = null;
                    }
                    e.setSelection(h);
                }
            } else
            {
                b();
            }
        } else
        {
            b();
        }
        k = getMeasuredWidth();
        super.onMeasure(j, i1);
        j = getMeasuredWidth();
        if (flag && k != j)
        {
            setTabSelected(h);
        }
    }

    public final void setAllowCollapse(boolean flag)
    {
        f = flag;
    }

    public final void setContentHeight(int j)
    {
        g = j;
        requestLayout();
    }

    public final void setTabSelected(int j)
    {
        h = j;
        int l = d.getChildCount();
        int k = 0;
        while (k < l) 
        {
            View view = d.getChildAt(k);
            boolean flag;
            if (k == j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (!flag)
            {
                continue;
            }
            view = d.getChildAt(j);
            if (a != null)
            {
                removeCallbacks(a);
            }
            a = new Runnable(view) {

                final View a;
                final m b;

                public final void run()
                {
                    int i1 = a.getLeft();
                    int j1 = (b.getWidth() - a.getWidth()) / 2;
                    b.smoothScrollTo(i1 - j1, 0);
                    b.a = null;
                }

            
            {
                b = m.this;
                a = view;
                super();
            }
            };
            post(a);
            k++;
        }
        if (e != null && j >= 0)
        {
            e.setSelection(j);
        }
    }

}

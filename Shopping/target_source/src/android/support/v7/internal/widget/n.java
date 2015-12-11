// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.internal.view.a;
import android.support.v7.widget.k;
import android.support.v7.widget.u;
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
//            SpinnerCompat, e, s

public class n extends HorizontalScrollView
    implements e.b
{
    private class a extends BaseAdapter
    {

        final n a;

        public int getCount()
        {
            return android.support.v7.internal.widget.n.a(a).getChildCount();
        }

        public Object getItem(int k)
        {
            return ((c)android.support.v7.internal.widget.n.a(a).getChildAt(k)).b();
        }

        public long getItemId(int k)
        {
            return (long)k;
        }

        public View getView(int k, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                return android.support.v7.internal.widget.n.a(a, (android.support.v7.app.a.c)getItem(k), true);
            } else
            {
                ((c)view).a((android.support.v7.app.a.c)getItem(k));
                return view;
            }
        }

        private a()
        {
            a = n.this;
            super();
        }

    }

    private class b
        implements android.view.View.OnClickListener
    {

        final n a;

        public void onClick(View view)
        {
            ((c)view).b().d();
            int l = android.support.v7.internal.widget.n.a(a).getChildCount();
            int k = 0;
            while (k < l) 
            {
                View view1 = android.support.v7.internal.widget.n.a(a).getChildAt(k);
                boolean flag;
                if (view1 == view)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view1.setSelected(flag);
                k++;
            }
        }

        private b()
        {
            a = n.this;
            super();
        }

    }

    private class c extends u
        implements android.view.View.OnLongClickListener
    {

        final n a;
        private final int b[] = {
            0x10100d4
        };
        private android.support.v7.app.a.c c;
        private TextView d;
        private ImageView e;
        private View f;

        public void a()
        {
            Object obj = c;
            Object obj1 = ((android.support.v7.app.a.c) (obj)).c();
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
            android.graphics.drawable.Drawable drawable = ((android.support.v7.app.a.c) (obj)).a();
            obj1 = ((android.support.v7.app.a.c) (obj)).b();
            boolean flag;
            if (drawable != null)
            {
                if (e == null)
                {
                    ImageView imageview = new ImageView(getContext());
                    android.support.v7.widget.u.a a2 = new android.support.v7.widget.u.a(-2, -2);
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
                    k k1 = new k(getContext(), null, android.support.v7.a.a.a.actionBarTabTextStyle);
                    k1.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    android.support.v7.widget.u.a a1 = new android.support.v7.widget.u.a(-2, -2);
                    a1.h = 16;
                    k1.setLayoutParams(a1);
                    addView(k1);
                    d = k1;
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
                e.setContentDescription(((android.support.v7.app.a.c) (obj)).e());
            }
            if (!flag && !TextUtils.isEmpty(((android.support.v7.app.a.c) (obj)).e()))
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

        public void a(android.support.v7.app.a.c c1)
        {
            c = c1;
            a();
        }

        public android.support.v7.app.a.c b()
        {
            return c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(accessibilityevent);
            accessibilityevent.setClassName(android/support/v7/app/a$c.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
        {
            super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                accessibilitynodeinfo.setClassName(android/support/v7/app/a$c.getName());
            }
        }

        public boolean onLongClick(View view)
        {
            view = new int[2];
            getLocationOnScreen(view);
            Object obj = getContext();
            int l = getWidth();
            int i1 = getHeight();
            int j1 = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
            obj = Toast.makeText(((Context) (obj)), c.e(), 0);
            ((Toast) (obj)).setGravity(49, (view[0] + l / 2) - j1 / 2, i1);
            ((Toast) (obj)).show();
            return true;
        }

        public void onMeasure(int l, int i1)
        {
            super.onMeasure(l, i1);
            if (a.b > 0 && getMeasuredWidth() > a.b)
            {
                super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(a.b, 0x40000000), i1);
            }
        }

        public void setSelected(boolean flag)
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

        public c(Context context, android.support.v7.app.a.c c1, boolean flag)
        {
            a = n.this;
            super(context, null, android.support.v7.a.a.a.actionBarTabStyle);
            c = c1;
            n1 = android.support.v7.internal.widget.s.a(context, null, b, android.support.v7.a.a.a.actionBarTabStyle, 0);
            if (s.this.e(0))
            {
                setBackgroundDrawable(s.this.a(0));
            }
            s.this.b();
            if (flag)
            {
                setGravity(0x800013);
            }
            a();
        }
    }


    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private b d;
    private u e;
    private SpinnerCompat f;
    private boolean g;
    private int h;
    private int i;

    private c a(android.support.v7.app.a.c c1, boolean flag)
    {
        c1 = new c(getContext(), c1, flag);
        if (flag)
        {
            c1.setBackgroundDrawable(null);
            c1.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, h));
            return c1;
        }
        c1.setFocusable(true);
        if (d == null)
        {
            d = new b();
        }
        c1.setOnClickListener(d);
        return c1;
    }

    static c a(n n1, android.support.v7.app.a.c c1, boolean flag)
    {
        return n1.a(c1, flag);
    }

    static u a(n n1)
    {
        return n1.e;
    }

    private boolean a()
    {
        return f != null && f.getParent() == this;
    }

    private void b()
    {
        if (a())
        {
            return;
        }
        if (f == null)
        {
            f = d();
        }
        removeView(e);
        addView(f, new android.view.ViewGroup.LayoutParams(-2, -1));
        if (f.c() == null)
        {
            f.a(new a());
        }
        if (a != null)
        {
            removeCallbacks(a);
            a = null;
        }
        f.setSelection(i);
    }

    private boolean c()
    {
        if (!a())
        {
            return false;
        } else
        {
            removeView(f);
            addView(e, new android.view.ViewGroup.LayoutParams(-2, -1));
            setTabSelected(f.getSelectedItemPosition());
            return false;
        }
    }

    private SpinnerCompat d()
    {
        SpinnerCompat spinnercompat = new SpinnerCompat(getContext(), null, android.support.v7.a.a.a.actionDropDownStyle);
        spinnercompat.setLayoutParams(new android.support.v7.widget.u.a(-2, -1));
        spinnercompat.a(this);
        return spinnercompat;
    }

    public void a(int k)
    {
        View view = e.getChildAt(k);
        if (a != null)
        {
            removeCallbacks(a);
        }
        a = new Runnable(view) {

            final View a;
            final n b;

            public void run()
            {
                int l = a.getLeft();
                int i1 = (b.getWidth() - a.getWidth()) / 2;
                b.smoothScrollTo(l - i1, 0);
                b.a = null;
            }

            
            {
                b = n.this;
                a = view;
                super();
            }
        };
        post(a);
    }

    public void a(e e1, View view, int k, long l)
    {
        ((c)view).b().d();
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (a != null)
        {
            post(a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        configuration = android.support.v7.internal.view.a.a(getContext());
        setContentHeight(configuration.e());
        c = configuration.g();
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (a != null)
        {
            removeCallbacks(a);
        }
    }

    public void onMeasure(int k, int l)
    {
        l = 1;
        int i1 = android.view.View.MeasureSpec.getMode(k);
        int k1;
        boolean flag;
        if (i1 == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        k1 = e.getChildCount();
        if (k1 > 1 && (i1 == 0x40000000 || i1 == 0x80000000))
        {
            int j1;
            if (k1 > 2)
            {
                b = (int)((float)android.view.View.MeasureSpec.getSize(k) * 0.4F);
            } else
            {
                b = android.view.View.MeasureSpec.getSize(k) / 2;
            }
            b = Math.min(b, c);
        } else
        {
            b = -1;
        }
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(h, 0x40000000);
        if (flag || !g)
        {
            l = 0;
        }
        if (l != 0)
        {
            e.measure(0, j1);
            if (e.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(k))
            {
                b();
            } else
            {
                c();
            }
        } else
        {
            c();
        }
        l = getMeasuredWidth();
        super.onMeasure(k, j1);
        k = getMeasuredWidth();
        if (flag && l != k)
        {
            setTabSelected(i);
        }
    }

    public void setAllowCollapse(boolean flag)
    {
        g = flag;
    }

    public void setContentHeight(int k)
    {
        h = k;
        requestLayout();
    }

    public void setTabSelected(int k)
    {
        i = k;
        int i1 = e.getChildCount();
        int l = 0;
        while (l < i1) 
        {
            View view = e.getChildAt(l);
            boolean flag;
            if (l == k)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (flag)
            {
                a(k);
            }
            l++;
        }
        if (f != null && k >= 0)
        {
            f.setSelection(k);
        }
    }

}

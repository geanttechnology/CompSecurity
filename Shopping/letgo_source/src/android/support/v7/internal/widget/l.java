// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.ca;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
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
//            SpinnerCompat, e, q

public class l extends HorizontalScrollView
    implements e.b
{
    private class a extends BaseAdapter
    {

        final l a;

        public int getCount()
        {
            return l.a(a).getChildCount();
        }

        public Object getItem(int k)
        {
            return ((c)l.a(a).getChildAt(k)).b();
        }

        public long getItemId(int k)
        {
            return (long)k;
        }

        public View getView(int k, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                return l.a(a, (android.support.v7.app.ActionBar.b)getItem(k), true);
            } else
            {
                ((c)view).a((android.support.v7.app.ActionBar.b)getItem(k));
                return view;
            }
        }

        private a()
        {
            a = l.this;
            super();
        }

    }

    private class b
        implements android.view.View.OnClickListener
    {

        final l a;

        public void onClick(View view)
        {
            ((c)view).b().d();
            int i1 = l.a(a).getChildCount();
            int k = 0;
            while (k < i1) 
            {
                View view1 = l.a(a).getChildAt(k);
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
            a = l.this;
            super();
        }

    }

    private class c extends LinearLayoutCompat
        implements android.view.View.OnLongClickListener
    {

        final l a;
        private final int b[] = {
            0x10100d4
        };
        private android.support.v7.app.ActionBar.b c;
        private TextView d;
        private ImageView e;
        private View f;

        public void a()
        {
            Object obj = c;
            Object obj1 = ((android.support.v7.app.ActionBar.b) (obj)).c();
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
            android.graphics.drawable.Drawable drawable = ((android.support.v7.app.ActionBar.b) (obj)).a();
            obj1 = ((android.support.v7.app.ActionBar.b) (obj)).b();
            boolean flag;
            if (drawable != null)
            {
                if (e == null)
                {
                    ImageView imageview = new ImageView(getContext());
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutparams1 = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutparams1.gravity = 16;
                    imageview.setLayoutParams(layoutparams1);
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
                    AppCompatTextView appcompattextview = new AppCompatTextView(getContext(), null, android.support.v7.br.a.actionBarTabTextStyle);
                    appcompattextview.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutparams = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutparams.gravity = 16;
                    appcompattextview.setLayoutParams(layoutparams);
                    addView(appcompattextview);
                    d = appcompattextview;
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
                e.setContentDescription(((android.support.v7.app.ActionBar.b) (obj)).e());
            }
            if (!flag && !TextUtils.isEmpty(((android.support.v7.app.ActionBar.b) (obj)).e()))
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

        public void a(android.support.v7.app.ActionBar.b b1)
        {
            c = b1;
            a();
        }

        public android.support.v7.app.ActionBar.b b()
        {
            return c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(accessibilityevent);
            accessibilityevent.setClassName(android/support/v7/app/ActionBar$b.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
        {
            super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                accessibilitynodeinfo.setClassName(android/support/v7/app/ActionBar$b.getName());
            }
        }

        public boolean onLongClick(View view)
        {
            view = new int[2];
            getLocationOnScreen(view);
            Object obj = getContext();
            int k = getWidth();
            int i1 = getHeight();
            int j1 = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
            obj = Toast.makeText(((Context) (obj)), c.e(), 0);
            ((Toast) (obj)).setGravity(49, (view[0] + k / 2) - j1 / 2, i1);
            ((Toast) (obj)).show();
            return true;
        }

        public void onMeasure(int k, int i1)
        {
            super.onMeasure(k, i1);
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

        public c(Context context, android.support.v7.app.ActionBar.b b1, boolean flag)
        {
            a = l.this;
            super(context, null, android.support.v7.br.a.actionBarTabStyle);
            c = b1;
            l1 = q.a(context, null, b, android.support.v7.br.a.actionBarTabStyle, 0);
            if (q.this.e(0))
            {
                setBackgroundDrawable(q.this.a(0));
            }
            q.this.b();
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
    private LinearLayoutCompat e;
    private SpinnerCompat f;
    private boolean g;
    private int h;
    private int i;

    private c a(android.support.v7.app.ActionBar.b b1, boolean flag)
    {
        b1 = new c(getContext(), b1, flag);
        if (flag)
        {
            b1.setBackgroundDrawable(null);
            b1.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, h));
            return b1;
        }
        b1.setFocusable(true);
        if (d == null)
        {
            d = new b();
        }
        b1.setOnClickListener(d);
        return b1;
    }

    static c a(l l1, android.support.v7.app.ActionBar.b b1, boolean flag)
    {
        return l1.a(b1, flag);
    }

    static LinearLayoutCompat a(l l1)
    {
        return l1.e;
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
        SpinnerCompat spinnercompat = new SpinnerCompat(getContext(), null, android.support.v7.br.a.actionDropDownStyle);
        spinnercompat.setLayoutParams(new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -1));
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
            final l b;

            public void run()
            {
                int i1 = a.getLeft();
                int j1 = (b.getWidth() - a.getWidth()) / 2;
                b.smoothScrollTo(i1 - j1, 0);
                b.a = null;
            }

            
            {
                b = l.this;
                a = view;
                super();
            }
        };
        post(a);
    }

    public void a(e e1, View view, int k, long l1)
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
        configuration = ca.a(getContext());
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

    public void onMeasure(int k, int i1)
    {
        i1 = 1;
        int j1 = android.view.View.MeasureSpec.getMode(k);
        int l1;
        boolean flag;
        if (j1 == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        l1 = e.getChildCount();
        if (l1 > 1 && (j1 == 0x40000000 || j1 == 0x80000000))
        {
            int k1;
            if (l1 > 2)
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
        k1 = android.view.View.MeasureSpec.makeMeasureSpec(h, 0x40000000);
        if (flag || !g)
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            e.measure(0, k1);
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
        i1 = getMeasuredWidth();
        super.onMeasure(k, k1);
        k = getMeasuredWidth();
        if (flag && i1 != k)
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
        int j1 = e.getChildCount();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view = e.getChildAt(i1);
            boolean flag;
            if (i1 == k)
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
            i1++;
        }
        if (f != null && k >= 0)
        {
            f.setSelection(k);
        }
    }

}

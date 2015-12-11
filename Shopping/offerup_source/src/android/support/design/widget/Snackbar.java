// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package android.support.design.widget:
//            ap, ar, CoordinatorLayout, ba, 
//            a, au, av, aq, 
//            u, SwipeDismissBehavior, aw, ax, 
//            ay, as, at, bc, 
//            r

public final class Snackbar
{

    private static final Handler a = new Handler(Looper.getMainLooper(), new ap());
    private final ViewGroup b;
    private final Context c;
    private final SnackbarLayout d;
    private int e;
    private final bc f = new ar(this);

    private Snackbar(ViewGroup viewgroup)
    {
        b = viewgroup;
        c = viewgroup.getContext();
        d = (SnackbarLayout)LayoutInflater.from(c).inflate(0x7f040071, b, false);
    }

    public static Snackbar a(View view, CharSequence charsequence, int i)
    {
        view = new Snackbar(a(view));
        ((Snackbar) (view)).d.getMessageView().setText(charsequence);
        view.e = 0;
        return view;
    }

    static bc a(Snackbar snackbar)
    {
        return snackbar.f;
    }

    private static ViewGroup a(View view)
    {
        ViewGroup viewgroup1 = null;
        View view1 = view;
        do
        {
            if (view1 instanceof CoordinatorLayout)
            {
                return (ViewGroup)view1;
            }
            ViewGroup viewgroup = viewgroup1;
            if (view1 instanceof FrameLayout)
            {
                if (view1.getId() == 0x1020002)
                {
                    return (ViewGroup)view1;
                }
                viewgroup = (ViewGroup)view1;
            }
            view = view1;
            if (view1 != null)
            {
                view = view1.getParent();
                if (view instanceof View)
                {
                    view = (View)view;
                } else
                {
                    view = null;
                }
            }
            view1 = view;
            viewgroup1 = viewgroup;
        } while (view != null);
        return viewgroup;
    }

    static void a(Snackbar snackbar, int i)
    {
        snackbar.c(i);
    }

    static void b(Snackbar snackbar)
    {
        snackbar.e();
    }

    static void b(Snackbar snackbar, int i)
    {
        snackbar.d(i);
    }

    static SnackbarLayout c(Snackbar snackbar)
    {
        return snackbar.d;
    }

    private void c(int i)
    {
        android.support.design.widget.ba.a().a(f, i);
    }

    static Handler d()
    {
        return a;
    }

    static r d(Snackbar snackbar)
    {
        return null;
    }

    private void d(int i)
    {
        b.removeView(d);
        android.support.design.widget.ba.a().a(f);
    }

    private void e()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            bi.b(d, d.getHeight());
            bi.q(d).c(0.0F).a(android.support.design.widget.a.a).a(250L).a(new au(this)).c();
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(d.getContext(), 0x7f05000c);
            animation.setInterpolator(android.support.design.widget.a.a);
            animation.setDuration(250L);
            animation.setAnimationListener(new av(this));
            d.startAnimation(animation);
            return;
        }
    }

    public final Snackbar a(int i)
    {
        d.getActionView().setTextColor(i);
        return this;
    }

    public final Snackbar a(CharSequence charsequence, android.view.View.OnClickListener onclicklistener)
    {
        Button button = d.getActionView();
        if (TextUtils.isEmpty(charsequence))
        {
            button.setVisibility(8);
            button.setOnClickListener(null);
            return this;
        } else
        {
            button.setVisibility(0);
            button.setText(charsequence);
            button.setOnClickListener(new aq(this, onclicklistener));
            return this;
        }
    }

    public final void a()
    {
        android.support.design.widget.ba.a().a(e, f);
    }

    public final void b()
    {
        c(3);
    }

    final void b(int i)
    {
        if (d.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        Object obj = d.getLayoutParams();
        if (!(obj instanceof u)) goto _L4; else goto _L3
_L3:
        obj = ((u)obj).a;
        if (!(obj instanceof SwipeDismissBehavior)) goto _L4; else goto _L5
_L5:
        boolean flag;
        if (((SwipeDismissBehavior)obj).a() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L7:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        d(i);
        return;
_L4:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            bi.q(d).c(d.getHeight()).a(android.support.design.widget.a.a).a(250L).a(new aw(this, i)).c();
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(d.getContext(), 0x7f05000d);
            animation.setInterpolator(android.support.design.widget.a.a);
            animation.setDuration(250L);
            animation.setAnimationListener(new ax(this, i));
            d.startAnimation(animation);
            return;
        }
    }

    final void c()
    {
        if (d.getParent() == null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = d.getLayoutParams();
            if (layoutparams instanceof u)
            {
                ay ay1 = new ay(this);
                ay1.a(0.1F);
                ay1.b(0.6F);
                ay1.a(0);
                ay1.a(new as(this));
                ((u)layoutparams).a(ay1);
            }
            b.addView(d);
        }
        if (bi.B(d))
        {
            e();
            return;
        } else
        {
            d.setOnLayoutChangeListener(new at(this));
            return;
        }
    }


    private class SnackbarLayout extends LinearLayout
    {

        private TextView a;
        private Button b;
        private int c;
        private int d;
        private az e;

        private boolean a(int i, int j, int k)
        {
            boolean flag = false;
            if (i != getOrientation())
            {
                setOrientation(i);
                flag = true;
            }
            if (a.getPaddingTop() != j || a.getPaddingBottom() != k)
            {
                TextView textview = a;
                if (bi.y(textview))
                {
                    bi.a(textview, bi.k(textview), j, bi.l(textview), k);
                } else
                {
                    textview.setPadding(textview.getPaddingLeft(), j, textview.getPaddingRight(), k);
                }
                flag = true;
            }
            return flag;
        }

        final void a(int i, int j)
        {
            bi.c(a, 0.0F);
            bi.q(a).a(1.0F).a(180L).b(70L).c();
            if (b.getVisibility() == 0)
            {
                bi.c(b, 0.0F);
                bi.q(b).a(1.0F).a(180L).b(70L).c();
            }
        }

        final void b(int i, int j)
        {
            bi.c(a, 1.0F);
            bi.q(a).a(0.0F).a(180L).b(0L).c();
            if (b.getVisibility() == 0)
            {
                bi.c(b, 1.0F);
                bi.q(b).a(0.0F).a(180L).b(0L).c();
            }
        }

        Button getActionView()
        {
            return b;
        }

        TextView getMessageView()
        {
            return a;
        }

        protected void onFinishInflate()
        {
            super.onFinishInflate();
            a = (TextView)findViewById(0x7f1001cb);
            b = (Button)findViewById(0x7f1001cc);
        }

        protected void onLayout(boolean flag, int i, int j, int k, int l)
        {
            super.onLayout(flag, i, j, k, l);
            if (flag && e != null)
            {
                e.a();
            }
        }

        protected void onMeasure(int i, int j)
        {
            int l;
            int i1;
            super.onMeasure(i, j);
            int k = i;
            if (c > 0)
            {
                k = i;
                if (getMeasuredWidth() > c)
                {
                    k = android.view.View.MeasureSpec.makeMeasureSpec(c, 0x40000000);
                    super.onMeasure(k, j);
                }
            }
            l = getResources().getDimensionPixelSize(0x7f0b0021);
            i1 = getResources().getDimensionPixelSize(0x7f0b00b1);
            if (a.getLayout().getLineCount() > 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i == 0 || d <= 0 || b.getMeasuredWidth() <= d) goto _L2; else goto _L1
_L1:
            if (!a(1, l, l - i1)) goto _L4; else goto _L3
_L3:
            i = 1;
_L6:
            if (i != 0)
            {
                super.onMeasure(k, j);
            }
            return;
_L2:
            if (i != 0)
            {
                i = l;
            } else
            {
                i = i1;
            }
            if (a(0, i, i))
            {
                i = 1;
                continue; /* Loop/switch isn't completed */
            }
_L4:
            i = 0;
            if (true) goto _L6; else goto _L5
_L5:
        }

        void setOnLayoutChangeListener(az az1)
        {
            e = az1;
        }

        public SnackbarLayout(Context context)
        {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            attributeset = context.obtainStyledAttributes(attributeset, a.ag);
            c = attributeset.getDimensionPixelSize(a.ah, -1);
            d = attributeset.getDimensionPixelSize(a.aj, -1);
            if (attributeset.hasValue(a.ai))
            {
                bi.f(this, attributeset.getDimensionPixelSize(a.ai, 0));
            }
            attributeset.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(0x7f040072, this);
        }
    }

}

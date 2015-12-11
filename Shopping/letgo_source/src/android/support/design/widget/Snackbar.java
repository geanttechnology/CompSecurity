// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ah;
import android.support.v4.view.ay;
import android.support.v4.view.bd;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package android.support.design.widget:
//            a, e, f, CoordinatorLayout

public class Snackbar
{
    public static class SnackbarLayout extends LinearLayout
    {

        private TextView a;
        private TextView b;
        private int c;
        private int d;
        private a e;

        private static void a(View view, int i, int j)
        {
            if (ah.x(view))
            {
                ah.a(view, ah.k(view), i, ah.l(view), j);
                return;
            } else
            {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), j);
                return;
            }
        }

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
                a(((View) (a)), j, k);
                flag = true;
            }
            return flag;
        }

        void a(int i, int j)
        {
            ah.c(a, 0.0F);
            ah.q(a).a(1.0F).a(j).b(i).b();
            if (b.getVisibility() == 0)
            {
                ah.c(b, 0.0F);
                ah.q(b).a(1.0F).a(j).b(i).b();
            }
        }

        void b(int i, int j)
        {
            ah.c(a, 1.0F);
            ah.q(a).a(0.0F).a(j).b(i).b();
            if (b.getVisibility() == 0)
            {
                ah.c(b, 1.0F);
                ah.q(b).a(0.0F).a(j).b(i).b();
            }
        }

        TextView getActionView()
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
            a = (TextView)findViewById(android.support.v7.a.d.snackbar_text);
            b = (TextView)findViewById(android.support.v7.a.d.snackbar_action);
        }

        protected void onLayout(boolean flag, int i, int j, int k, int l)
        {
            super.onLayout(flag, i, j, k, l);
            if (flag && e != null)
            {
                e.a(this, i, j, k, l);
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
            l = getResources().getDimensionPixelSize(android.support.v7.a.c.snackbar_padding_vertical_2lines);
            i1 = getResources().getDimensionPixelSize(android.support.v7.a.c.snackbar_padding_vertical);
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

        void setOnLayoutChangeListener(a a1)
        {
            e = a1;
        }

        public SnackbarLayout(Context context)
        {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.a.g.SnackbarLayout);
            c = attributeset.getDimensionPixelSize(android.support.v7.a.g.SnackbarLayout_android_maxWidth, -1);
            d = attributeset.getDimensionPixelSize(android.support.v7.a.g.SnackbarLayout_maxActionInlineWidth, -1);
            if (attributeset.hasValue(android.support.v7.a.g.SnackbarLayout_elevation))
            {
                ah.f(this, attributeset.getDimensionPixelSize(android.support.v7.a.g.SnackbarLayout_elevation, 0));
            }
            attributeset.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(android.support.v7.a.e.layout_snackbar_include, this);
        }
    }

    static interface SnackbarLayout.a
    {

        public abstract void a(View view, int i, int j, int k, int l);
    }

    final class a extends f
    {

        final Snackbar a;

        public boolean a(CoordinatorLayout coordinatorlayout, SnackbarLayout snackbarlayout, MotionEvent motionevent)
        {
            if (!coordinatorlayout.a(snackbarlayout, (int)motionevent.getX(), (int)motionevent.getY())) goto _L2; else goto _L1
_L1:
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 3: default 52
        //                       0 60
        //                       1 76
        //                       2 52
        //                       3 76;
               goto _L2 _L3 _L4 _L2 _L4
_L2:
            return super.a(coordinatorlayout, snackbarlayout, motionevent);
_L3:
            android.support.design.widget.e.a().d(Snackbar.a(a));
            continue; /* Loop/switch isn't completed */
_L4:
            android.support.design.widget.e.a().e(Snackbar.a(a));
            if (true) goto _L2; else goto _L5
_L5:
        }

        public volatile boolean a(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
        {
            return a(coordinatorlayout, (SnackbarLayout)view, motionevent);
        }

        a()
        {
            a = Snackbar.this;
            super();
        }
    }


    private static final Handler a = new Handler(Looper.getMainLooper(), new android.os.Handler.Callback() {

        public boolean handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return false;

            case 0: // '\0'
                ((Snackbar)message.obj).b();
                return true;

            case 1: // '\001'
                ((Snackbar)message.obj).c();
                break;
            }
            return true;
        }

    });
    private final ViewGroup b;
    private final SnackbarLayout c;
    private final e.a d;

    static e.a a(Snackbar snackbar)
    {
        return snackbar.d;
    }

    static void b(Snackbar snackbar)
    {
        snackbar.d();
    }

    static SnackbarLayout c(Snackbar snackbar)
    {
        return snackbar.c;
    }

    private void d()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            ah.b(c, c.getHeight());
            ah.q(c).c(0.0F).a(android.support.design.widget.a.b).a(250L).a(new bd() {

                final Snackbar a;

                public void onAnimationEnd(View view)
                {
                    android.support.design.widget.e.a().c(Snackbar.a(a));
                }

                public void onAnimationStart(View view)
                {
                    Snackbar.c(a).a(70, 180);
                }

            
            {
                a = Snackbar.this;
                super();
            }
            }).b();
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(c.getContext(), android.support.v7.a.a.snackbar_in);
            animation.setInterpolator(android.support.design.widget.a.b);
            animation.setDuration(250L);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final Snackbar a;

                public void onAnimationEnd(Animation animation1)
                {
                    android.support.design.widget.e.a().c(Snackbar.a(a));
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                a = Snackbar.this;
                super();
            }
            });
            c.startAnimation(animation);
            return;
        }
    }

    static void d(Snackbar snackbar)
    {
        snackbar.f();
    }

    private void e()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            ah.q(c).c(c.getHeight()).a(android.support.design.widget.a.b).a(250L).a(new bd() {

                final Snackbar a;

                public void onAnimationEnd(View view)
                {
                    Snackbar.d(a);
                }

                public void onAnimationStart(View view)
                {
                    Snackbar.c(a).b(0, 180);
                }

            
            {
                a = Snackbar.this;
                super();
            }
            }).b();
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(c.getContext(), android.support.v7.a.a.snackbar_out);
            animation.setInterpolator(android.support.design.widget.a.b);
            animation.setDuration(250L);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final Snackbar a;

                public void onAnimationEnd(Animation animation1)
                {
                    Snackbar.d(a);
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                a = Snackbar.this;
                super();
            }
            });
            c.startAnimation(animation);
            return;
        }
    }

    private void f()
    {
        b.removeView(c);
        android.support.design.widget.e.a().b(d);
    }

    private boolean g()
    {
        Object obj = c.getLayoutParams();
        if (obj instanceof CoordinatorLayout.c)
        {
            obj = ((CoordinatorLayout.c)obj).a();
            if (obj instanceof f)
            {
                return ((f)obj).a() != 0;
            }
        }
        return false;
    }

    public void a()
    {
        android.support.design.widget.e.a().a(d);
    }

    final void b()
    {
        if (c.getParent() == null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = c.getLayoutParams();
            if (layoutparams instanceof CoordinatorLayout.c)
            {
                a a1 = new a();
                a1.a(0.1F);
                a1.b(0.6F);
                a1.a(0);
                a1.a(new f.a() {

                    final Snackbar a;

                    public void a(int i)
                    {
                        switch (i)
                        {
                        default:
                            return;

                        case 1: // '\001'
                        case 2: // '\002'
                            android.support.design.widget.e.a().d(Snackbar.a(a));
                            return;

                        case 0: // '\0'
                            android.support.design.widget.e.a().e(Snackbar.a(a));
                            return;
                        }
                    }

                    public void a(View view)
                    {
                        a.a();
                    }

            
            {
                a = Snackbar.this;
                super();
            }
                });
                ((CoordinatorLayout.c)layoutparams).a(a1);
            }
            b.addView(c);
        }
        if (ah.z(c))
        {
            d();
            return;
        } else
        {
            c.setOnLayoutChangeListener(new SnackbarLayout.a() {

                final Snackbar a;

                public void a(View view, int i, int j, int k, int l)
                {
                    Snackbar.b(a);
                    Snackbar.c(a).setOnLayoutChangeListener(null);
                }

            
            {
                a = Snackbar.this;
                super();
            }
            });
            return;
        }
    }

    final void c()
    {
        if (c.getVisibility() != 0 || g())
        {
            f();
            return;
        } else
        {
            e();
            return;
        }
    }

}

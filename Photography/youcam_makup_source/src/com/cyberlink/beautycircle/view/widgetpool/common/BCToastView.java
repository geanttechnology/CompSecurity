// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            UICImageView, CircleList

public class BCToastView extends LinearLayout
{

    private View a;
    private UICImageView b;
    private TextView c;
    private TextView d;
    private Handler e;
    private int f;
    private AnimationType g;
    private android.view.View.OnLayoutChangeListener h;
    private Runnable i;

    public BCToastView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = null;
        c = null;
        d = null;
        e = new Handler(Looper.getMainLooper());
        f = 0;
        g = AnimationType.a;
        h = new android.view.View.OnLayoutChangeListener() {

            final BCToastView a;

            public void onLayoutChange(View view, int l, int i1, int j1, int k1, int l1, int i2, 
                    int j2, int k2)
            {
                l = ((View)view.getParent()).getHeight();
                BCToastView.a(a, l - i1);
            }

            
            {
                a = BCToastView.this;
                super();
            }
        };
        i = new Runnable() {

            final BCToastView a;

            public void run()
            {
                if (BCToastView.c(a).equals(AnimationType.a))
                {
                    BCToastView.a(a, null);
                    return;
                } else
                {
                    a.a(null);
                    return;
                }
            }

            
            {
                a = BCToastView.this;
                super();
            }
        };
        a(context);
    }

    static int a(BCToastView bctoastview, int l)
    {
        bctoastview.f = l;
        return l;
    }

    static Runnable a(BCToastView bctoastview)
    {
        return bctoastview.i;
    }

    private void a(Context context)
    {
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_view_toast, this);
        a = context.findViewById(j.bc_toast_outter);
        b = (UICImageView)context.findViewById(j.bc_toast_left_image);
        c = (TextView)context.findViewById(j.bc_toast_main_desc);
        d = (TextView)context.findViewById(j.bc_toast_sub_desc);
        addOnLayoutChangeListener(h);
    }

    static void a(BCToastView bctoastview, Runnable runnable)
    {
        bctoastview.c(runnable);
    }

    static Handler b(BCToastView bctoastview)
    {
        return bctoastview.e;
    }

    private void b(Runnable runnable, long l)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(l);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(runnable) {

            final Runnable a;
            final BCToastView b;

            public void onAnimationEnd(Animation animation)
            {
                b.setVisibility(4);
                if (a != null)
                {
                    BCToastView.b(b).post(a);
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                b = BCToastView.this;
                a = runnable;
                super();
            }
        });
        startAnimation(alphaanimation);
    }

    static AnimationType c(BCToastView bctoastview)
    {
        return bctoastview.g;
    }

    private void c(long l)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(300L);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(l) {

            final long a;
            final BCToastView b;

            public void onAnimationEnd(Animation animation)
            {
                b.setVisibility(0);
                BCToastView.b(b).postDelayed(BCToastView.a(b), a);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                b = BCToastView.this;
                a = l;
                super();
            }
        });
        startAnimation(alphaanimation);
    }

    private void c(Runnable runnable)
    {
        b(runnable, 300L);
    }

    public void a(long l)
    {
        clearAnimation();
        e.removeCallbacks(i);
        if (g.equals(AnimationType.a))
        {
            c(l);
            return;
        } else
        {
            b(l);
            return;
        }
    }

    public void a(Uri uri, String s)
    {
        CircleList.a(b, uri, s);
    }

    public void a(Runnable runnable)
    {
        a(runnable, 300L);
    }

    public void a(Runnable runnable, long l)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
        translateanimation.setDuration(l);
        translateanimation.setFillAfter(true);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(runnable) {

            final Runnable a;
            final BCToastView b;

            public void onAnimationEnd(Animation animation)
            {
                b.setVisibility(8);
                if (a != null)
                {
                    BCToastView.b(b).post(a);
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                b = BCToastView.this;
                a = runnable;
                super();
            }
        });
        startAnimation(translateanimation);
    }

    public void b(long l)
    {
        setVisibility(0);
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
        translateanimation.setDuration(300L);
        translateanimation.setFillAfter(true);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(l) {

            final long a;
            final BCToastView b;

            public void onAnimationEnd(Animation animation)
            {
                BCToastView.b(b).postDelayed(BCToastView.a(b), a);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                b = BCToastView.this;
                a = l;
                super();
            }
        });
        startAnimation(translateanimation);
    }

    public void b(Runnable runnable)
    {
        clearAnimation();
        e.removeCallbacks(i);
        if (g.equals(AnimationType.a))
        {
            b(runnable, 200L);
            return;
        } else
        {
            a(runnable, 200L);
            return;
        }
    }

    public void setAnimataionType(AnimationType animationtype)
    {
        g = animationtype;
    }

    public void setClickListener(android.view.View.OnClickListener onclicklistener)
    {
        a.setOnClickListener(onclicklistener);
    }

    public void setMainDescText(String s)
    {
        if (s != null)
        {
            c.setVisibility(0);
            c.setText(Html.fromHtml(s));
            return;
        } else
        {
            c.setVisibility(8);
            c.setText("");
            return;
        }
    }

    public void setSubDescText(String s)
    {
        if (s != null)
        {
            d.setVisibility(0);
            d.setText(Html.fromHtml(s));
            return;
        } else
        {
            d.setVisibility(8);
            d.setText("");
            return;
        }
    }

    private class AnimationType extends Enum
    {

        public static final AnimationType a;
        public static final AnimationType b;
        private static final AnimationType c[];

        public static AnimationType valueOf(String s)
        {
            return (AnimationType)Enum.valueOf(com/cyberlink/beautycircle/view/widgetpool/common/BCToastView$AnimationType, s);
        }

        public static AnimationType[] values()
        {
            return (AnimationType[])c.clone();
        }

        static 
        {
            a = new AnimationType("FADE", 0);
            b = new AnimationType("TRANSLATE", 1);
            c = (new AnimationType[] {
                a, b
            });
        }

        private AnimationType(String s, int l)
        {
            super(s, l);
        }
    }

}

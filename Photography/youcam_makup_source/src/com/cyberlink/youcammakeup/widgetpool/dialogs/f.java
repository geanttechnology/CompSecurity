// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class f
{

    private Handler a;
    private Dialog b;
    private View c;
    private int d;
    private Runnable e;

    private f()
    {
        a = null;
        b = null;
        c = null;
        d = 0;
        e = null;
        a = new Handler();
    }

    private static Dialog a(Activity activity)
    {
        Window window;
        int i;
        if (a(activity.getWindow()))
        {
            i = 0x7f0a0209;
        } else
        {
            i = 0x7f0a0225;
        }
        activity = new Dialog(activity, i) {

            public void dismiss()
            {
                super.dismiss();
            }

        };
        window = activity.getWindow();
        window.requestFeature(1);
        window.setBackgroundDrawableResource(0x106000d);
        return activity;
    }

    static Dialog a(f f1, Dialog dialog)
    {
        f1.b = dialog;
        return dialog;
    }

    public static f a(Activity activity, CharSequence charsequence, int i)
    {
        f f1 = new f();
        f1.d = i;
        f1.b = a(activity);
        activity = LayoutInflater.from(activity).inflate(0x7f030196, null);
        activity.setOnTouchListener(f1. new android.view.View.OnTouchListener() {

            final f a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                a.a();
                return true;
            }

            
            {
                a = f.this;
                super();
            }
        });
        ((TextView)activity.findViewById(0x7f0c05ce)).setText(charsequence);
        f1.c = activity;
        f1.b.setContentView(activity);
        return f1;
    }

    static Runnable a(f f1)
    {
        return f1.e;
    }

    static Runnable a(f f1, Runnable runnable)
    {
        f1.e = runnable;
        return runnable;
    }

    public static boolean a(Window window)
    {
        return (window.getAttributes().flags & 0x400) > 0;
    }

    static Handler b(f f1)
    {
        return f1.a;
    }

    static Dialog c(f f1)
    {
        return f1.b;
    }

    static View d(f f1)
    {
        return f1.c;
    }

    static int e(f f1)
    {
        return f1.d;
    }

    public void a()
    {
        a.post(new Runnable() {

            final f a;

            public void run()
            {
                if (f.a(a) != null)
                {
                    f.b(a).removeCallbacks(f.a(a));
                    f.a(a, null);
                    if (f.c(a).isShowing())
                    {
                        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
                        alphaanimation.setDuration(300L);
                        f.d(a).setAnimation(alphaanimation);
                        f.d(a).startAnimation(alphaanimation);
                        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(this) {

                            final _cls1 a;

                            public void onAnimationEnd(Animation animation)
                            {
                                f.c(a.a).dismiss();
                                f.a(a.a, null);
                            }

                            public void onAnimationRepeat(Animation animation)
                            {
                            }

                            public void onAnimationStart(Animation animation)
                            {
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

    public void b()
    {
        a.post(new Runnable() {

            final f a;

            public void run()
            {
                f.c(a).show();
                f.a(a, new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        a.a.a();
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
                f.b(a).postDelayed(f.a(a), f.e(a));
            }

            
            {
                a = f.this;
                super();
            }
        });
    }
}

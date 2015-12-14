// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.facebook.ads:
//            NativeAd

public class AdChoicesView extends RelativeLayout
{

    private final Context a;
    private final NativeAd b;
    private final DisplayMetrics c;
    private boolean d;
    private TextView e;

    public AdChoicesView(Context context, NativeAd nativead)
    {
        this(context, nativead, false);
    }

    public AdChoicesView(Context context, NativeAd nativead, boolean flag)
    {
        super(context);
        d = false;
        a = context;
        b = nativead;
        c = a.getResources().getDisplayMetrics();
        context = b.getAdChoicesIcon();
        nativead = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        setOnTouchListener(new _cls1());
        e = new TextView(a);
        addView(e);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        if (flag)
        {
            layoutparams.addRule(11, a(context).getId());
            layoutparams.width = 0;
            nativead.width = Math.round((float)(context.getWidth() + 4) * c.density);
            nativead.height = Math.round((float)(context.getHeight() + 2) * c.density);
            d = false;
        } else
        {
            d = true;
        }
        setLayoutParams(nativead);
        layoutparams.addRule(15, -1);
        e.setLayoutParams(layoutparams);
        e.setSingleLine();
        e.setText("AdChoices");
        e.setTextSize(10F);
        e.setTextColor(0xffbdc1c9);
    }

    private ImageView a(NativeAd.Image image)
    {
        ImageView imageview = new ImageView(a);
        addView(imageview);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(Math.round((float)image.getWidth() * c.density), Math.round((float)image.getHeight() * c.density));
        layoutparams.addRule(9);
        layoutparams.addRule(15, -1);
        layoutparams.setMargins(Math.round(4F * c.density), Math.round(c.density * 2.0F), Math.round(c.density * 2.0F), Math.round(c.density * 2.0F));
        imageview.setLayoutParams(layoutparams);
        NativeAd.downloadAndDisplayImage(image, imageview);
        return imageview;
    }

    private void a()
    {
        Object obj = new Paint();
        ((Paint) (obj)).setTextSize(e.getTextSize());
        int j = Math.round(((Paint) (obj)).measureText("AdChoices") + 4F * c.density);
        int i = getWidth();
        j += i;
        d = true;
        obj = new _cls2(i, j);
        ((Animation) (obj)).setAnimationListener(new _cls3(j, i));
        ((Animation) (obj)).setDuration(300L);
        ((Animation) (obj)).setFillAfter(true);
        startAnimation(((Animation) (obj)));
    }

    static boolean a(AdChoicesView adchoicesview)
    {
        return adchoicesview.d;
    }

    static boolean a(AdChoicesView adchoicesview, boolean flag)
    {
        adchoicesview.d = flag;
        return flag;
    }

    static Context b(AdChoicesView adchoicesview)
    {
        return adchoicesview.a;
    }

    static NativeAd c(AdChoicesView adchoicesview)
    {
        return adchoicesview.b;
    }

    static void d(AdChoicesView adchoicesview)
    {
        adchoicesview.a();
    }

    static TextView e(AdChoicesView adchoicesview)
    {
        return adchoicesview.e;
    }

    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final AdChoicesView a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0)
            {
                if (AdChoicesView.a(a))
                {
                    g.a(AdChoicesView.b(a), Uri.parse(AdChoicesView.c(a).getAdChoicesLinkUrl()));
                } else
                {
                    AdChoicesView.d(a);
                }
                return true;
            } else
            {
                return false;
            }
        }

        _cls1()
        {
            a = AdChoicesView.this;
            super();
        }
    }


    private class _cls2 extends Animation
    {

        final int a;
        final int b;
        final AdChoicesView c;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i = (int)((float)a + (float)(b - a) * f);
            c.getLayoutParams().width = i;
            c.requestLayout();
            AdChoicesView.e(c).getLayoutParams().width = i - a;
            AdChoicesView.e(c).requestLayout();
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        _cls2(int i, int j)
        {
            c = AdChoicesView.this;
            a = i;
            b = j;
            super();
        }
    }


    private class _cls3
        implements android.view.animation.Animation.AnimationListener
    {

        final int a;
        final int b;
        final AdChoicesView c;

        public void onAnimationEnd(Animation animation)
        {
            class _cls1
                implements Runnable
            {

                final _cls3 a;

                public void run()
                {
                    if (!AdChoicesView.a(a.c))
                    {
                        return;
                    } else
                    {
                        AdChoicesView.a(a.c, false);
                        class _cls1 extends Animation
                        {

                            final _cls1 a;

                            protected void applyTransformation(float f, Transformation transformation)
                            {
                                int i = (int)((float)a.a.a + (float)(a.a.b - a.a.a) * f);
                                a.a.c.getLayoutParams().width = i;
                                a.a.c.requestLayout();
                                AdChoicesView.e(a.a.c).getLayoutParams().width = i - a.a.b;
                                AdChoicesView.e(a.a.c).requestLayout();
                            }

                            public boolean willChangeBounds()
                            {
                                return true;
                            }

                            _cls1()
                            {
                                a = _cls1.this;
                                super();
                            }
                        }

                        _cls1 _lcls1 = new _cls1();
                        _lcls1.setDuration(300L);
                        _lcls1.setFillAfter(true);
                        a.c.startAnimation(_lcls1);
                        return;
                    }
                }

                _cls1()
                {
                    a = _cls3.this;
                    super();
                }
            }

            (new Handler()).postDelayed(new _cls1(), 3000L);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        _cls3(int i, int j)
        {
            c = AdChoicesView.this;
            a = i;
            b = j;
            super();
        }
    }

}

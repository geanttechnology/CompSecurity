// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.smule.android.f.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ao

public class an extends Dialog
{

    private static final String a = com/smule/pianoandroid/magicpiano/an.getName();
    private int b;
    private boolean c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private Button j;
    private Button k;
    private ao l;

    public an(Activity activity, String s)
    {
        super(activity, 0x7f0d007f);
        b = 0;
        c = false;
        requestWindowFeature(1);
        activity = activity.getLayoutInflater().inflate(0x7f03001f, null, false);
        setContentView(activity);
        setCanceledOnTouchOutside(false);
        e = (ImageView)activity.findViewById(0x7f0a0081);
        f = (ImageView)activity.findViewById(0x7f0a0082);
        g = (ImageView)activity.findViewById(0x7f0a0083);
        c();
        d = (ImageView)activity.findViewById(0x7f0a0080);
        h = (ImageView)activity.findViewById(0x7f0a0084);
        i = (TextView)activity.findViewById(0x7f0a006d);
        i.setText(s);
        k = (Button)activity.findViewById(0x7f0a0086);
        k.setVisibility(4);
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final an a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = an.this;
                super();
            }
        });
        j = (Button)activity.findViewById(0x7f0a0087);
        activity = j;
        int i1;
        if (l != null)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        activity.setVisibility(i1);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final an a;

            public void onClick(View view)
            {
                an.a(a);
            }

            
            {
                a = an.this;
                super();
            }
        });
        setCancelable(false);
    }

    private AlphaAnimation a(ImageView imageview, float f1, float f2, int i1)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f1, f2);
        alphaanimation.setStartOffset(i1);
        alphaanimation.setDuration(400L);
        alphaanimation.setFillAfter(true);
        imageview.setAnimation(alphaanimation);
        return alphaanimation;
    }

    private AlphaAnimation a(ImageView imageview, int i1)
    {
        return a(imageview, 1.0F, 0.0F, i1);
    }

    private void a()
    {
        if (l != null)
        {
            l.c_();
        }
        dismiss();
    }

    static void a(an an1)
    {
        an1.a();
    }

    private AlphaAnimation b(ImageView imageview, int i1)
    {
        return a(imageview, 0.0F, 1.0F, i1);
    }

    private void b()
    {
        if (c)
        {
            return;
        } else
        {
            a(g, 0);
            a(f, 400);
            a(e, 800).setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final an a;

                public void onAnimationEnd(Animation animation)
                {
                    an.b(a);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                a = an.this;
                super();
            }
            });
            return;
        }
    }

    static void b(an an1)
    {
        an1.c();
    }

    private void b(boolean flag)
    {
        boolean flag1 = false;
        ImageView imageview = e;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        imageview.setVisibility(i1);
        imageview = f;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        imageview.setVisibility(i1);
        imageview = g;
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 4;
        }
        imageview.setVisibility(i1);
    }

    private void c()
    {
        if (c)
        {
            return;
        } else
        {
            b(e, 0);
            b(f, 400);
            b(g, 800).setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final an a;

                public void onAnimationEnd(Animation animation)
                {
                    com.smule.pianoandroid.magicpiano.an.c(a);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                a = an.this;
                super();
            }
            });
            return;
        }
    }

    static void c(an an1)
    {
        an1.b();
    }

    public void a(int i1, String s, boolean flag)
    {
        a(i1, s, flag, ((Drawable) (null)));
    }

    public void a(int i1, String s, boolean flag, Drawable drawable)
    {
        boolean flag1 = false;
        b = i1;
        i.setText(s);
        if (b == 1)
        {
            b(true);
            c = true;
            e.clearAnimation();
            f.clearAnimation();
            g.clearAnimation();
            (new Handler()).postDelayed(new Runnable() {

                final an a;

                public void run()
                {
                    a.dismiss();
                }

            
            {
                a = an.this;
                super();
            }
            }, 2000L);
            k.setVisibility(0);
            j.setVisibility(4);
        } else
        if (b == 2)
        {
            b(false);
            c = true;
            e.clearAnimation();
            f.clearAnimation();
            g.clearAnimation();
            if (drawable != null)
            {
                com.smule.android.f.c.a(j, drawable);
            }
            k.setVisibility(0);
            j.setVisibility(4);
        } else
        if (b == 0)
        {
            s = j;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            s.setVisibility(i1);
            b(true);
            c = false;
            e.clearAnimation();
            f.clearAnimation();
            g.clearAnimation();
            c();
        }
        s = d;
        if (b == 1)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        s.setVisibility(i1);
        s = h;
        if (b == 2)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 4;
        }
        s.setVisibility(i1);
    }

    public void a(ao ao1)
    {
        l = ao1;
        if (j != null)
        {
            ao1 = j;
            int i1;
            if (l != null)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ao1.setVisibility(i1);
        }
    }

    public void a(boolean flag)
    {
        if (flag && l != null)
        {
            j.setVisibility(0);
        } else
        {
            j.setVisibility(4);
        }
        super.show();
    }

    public void onBackPressed()
    {
    }

}

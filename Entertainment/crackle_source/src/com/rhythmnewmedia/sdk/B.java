// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            C

final class B extends FrameLayout
    implements android.widget.SeekBar.OnSeekBarChangeListener
{
    static abstract class a extends Button
    {

        private final ShapeDrawable a = new ShapeDrawable(new PathShape(a(), 100F, 100F));

        protected abstract Path a();

        protected void onDraw(Canvas canvas)
        {
            if (isEnabled())
            {
                a.getPaint().setColor(-1);
            } else
            {
                a.getPaint().setColor(0xff888888);
            }
            a.draw(canvas);
        }

        protected void onLayout(boolean flag, int i, int j, int k, int l)
        {
            super.onLayout(flag, i, j, k, l);
            a.setBounds(0, 0, getWidth(), getHeight());
        }

        public a(Context context)
        {
            super(context);
            a.getPaint().setColor(-1);
            setBackgroundColor(0);
        }
    }

    static final class b extends a
    {

        protected final Path a()
        {
            Path path = new Path();
            path.moveTo(20F, 0.0F);
            path.lineTo(40F, 0.0F);
            path.lineTo(40F, 100F);
            path.lineTo(20F, 100F);
            path.lineTo(20F, 0.0F);
            path.moveTo(60F, 0.0F);
            path.lineTo(80F, 0.0F);
            path.lineTo(80F, 100F);
            path.lineTo(60F, 100F);
            path.lineTo(60F, 0.0F);
            return path;
        }

        public b(Context context)
        {
            super(context);
        }
    }

    static final class c extends a
    {

        protected final Path a()
        {
            Path path = new Path();
            path.moveTo(10F, 0.0F);
            path.lineTo(90F, 50F);
            path.lineTo(10F, 100F);
            path.lineTo(10F, 0.0F);
            return path;
        }

        public c(Context context)
        {
            super(context);
        }
    }

    public static interface d
    {

        public abstract void a(int j);

        public abstract void a(B b1);

        public abstract void f();

        public abstract void g();

        public abstract void h();

        public abstract void i();
    }


    d a;
    private Runnable b;

    public B(Context context)
    {
        super(context);
        b = new C(this);
        Object obj = new android.view.ViewGroup.LayoutParams(-1, -1);
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        setBackgroundColor(0);
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, 45));
        linearlayout.setOrientation(0);
        linearlayout.setBackgroundColor(0x88000000);
        addView(linearlayout);
        Object obj1 = new FrameLayout(context);
        ((FrameLayout) (obj1)).setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, 45));
        ((FrameLayout) (obj1)).setId(417);
        linearlayout.addView(((View) (obj1)));
        Object obj2 = new LinearLayout(context);
        ((LinearLayout) (obj2)).setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, 45));
        ((LinearLayout) (obj2)).setOrientation(0);
        ((LinearLayout) (obj2)).setId(418);
        ((FrameLayout) (obj1)).addView(((View) (obj2)));
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(35, 35);
        layoutparams.setMargins(5, 0, 5, 0);
        layoutparams.gravity = 17;
        obj1 = new FrameLayout(context);
        ((FrameLayout) (obj1)).setLayoutParams(layoutparams);
        ((LinearLayout) (obj2)).addView(((View) (obj1)));
        obj2 = new c(context);
        ((c) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((c) (obj2)).setId(421);
        ((FrameLayout) (obj1)).addView(((View) (obj2)));
        ((c) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

            final B a;

            public final void onClick(View view)
            {
                if (a.a != null)
                {
                    a.a.f();
                }
                a.a(false);
            }

            
            {
                a = B.this;
                super();
            }
        });
        obj2 = new b(context);
        ((b) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((b) (obj2)).setId(422);
        ((FrameLayout) (obj1)).addView(((View) (obj2)));
        ((b) (obj2)).setVisibility(8);
        ((b) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

            final B a;

            public final void onClick(View view)
            {
                if (a.a != null)
                {
                    a.a.g();
                }
                a.b();
            }

            
            {
                a = B.this;
                super();
            }
        });
        obj = new TextView(context);
        ((TextView) (obj)).setTextColor(-1);
        ((TextView) (obj)).setTextSize(16F);
        ((TextView) (obj)).setPadding(5, 0, 5, 0);
        ((TextView) (obj)).setGravity(16);
        ((TextView) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, 45));
        ((TextView) (obj)).setId(430);
        ((TextView) (obj)).setText("00:00");
        linearlayout.addView(((View) (obj)));
        obj = new SeekBar(context);
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1.weight = 1.0F;
        obj1.gravity = 16;
        ((SeekBar) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((SeekBar) (obj)).setId(450);
        linearlayout.addView(((View) (obj)));
        ((SeekBar) (obj)).setOnSeekBarChangeListener(this);
        context = new TextView(context);
        context.setTextColor(-1);
        context.setTextSize(16F);
        context.setPadding(5, 0, 5, 0);
        context.setGravity(16);
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, 45));
        context.setId(440);
        context.setText("00:00");
        linearlayout.addView(context);
    }

    private static String a(int i, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (flag)
        {
            stringbuilder.append("-");
        }
        int j;
        int k;
        if (i < 0)
        {
            j = 0;
        } else
        {
            j = i;
        }
        k = j / 3600;
        if (k > 0)
        {
            j = i % (k * 60 * 60);
            stringbuilder.append(k);
            stringbuilder.append(":");
        }
        k = j / 60;
        if (k < 10)
        {
            stringbuilder.append("0");
        }
        stringbuilder.append(k);
        i = j;
        if (k > 0)
        {
            i = j % 60;
        }
        stringbuilder.append(":");
        if (i < 10)
        {
            stringbuilder.append("0");
        }
        stringbuilder.append(i);
        return stringbuilder.toString();
    }

    final void a()
    {
        if (getHandler() != null)
        {
            getHandler().postDelayed(b, 10000L);
        }
    }

    public final void a(int i, int j)
    {
        TextView textview = (TextView)findViewById(430);
        TextView textview1 = (TextView)findViewById(440);
        SeekBar seekbar = (SeekBar)findViewById(450);
        int k = i / 1000;
        int l = seekbar.getMax() / 1000;
        j = (seekbar.getMax() * j) / 100;
        textview.setText(a(k, false));
        textview1.setText(a(l - k, true));
        seekbar.setProgress(i);
        seekbar.setSecondaryProgress(j);
    }

    public final void a(boolean flag)
    {
label0:
        {
            b();
            if (getVisibility() == 0)
            {
                AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
                alphaanimation.setDuration(200L);
                startAnimation(alphaanimation);
                if (!flag)
                {
                    break label0;
                }
                setVisibility(8);
            }
            return;
        }
        setVisibility(4);
    }

    public final void b()
    {
        if (getHandler() != null)
        {
            getHandler().removeCallbacks(b);
        }
    }

    public final void b(boolean flag)
    {
        if (flag)
        {
            findViewById(421).setVisibility(8);
            findViewById(422).setVisibility(0);
            return;
        } else
        {
            findViewById(421).setVisibility(0);
            findViewById(422).setVisibility(8);
            return;
        }
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        findViewById(417).layout(0, 0, findViewById(418).getWidth(), findViewById(418).getHeight());
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag && a != null)
        {
            a.a(i);
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
        if (a != null)
        {
            a.h();
        }
        b();
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        if (a != null)
        {
            a.i();
        }
        a();
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/C
    final class C
        implements Runnable
    {

        final B a;

        public final void run()
        {
            a.a(false);
        }

            C()
            {
                a = B.this;
                super();
            }
    }

}

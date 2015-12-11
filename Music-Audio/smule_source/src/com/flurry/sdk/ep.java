// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.flurry.sdk:
//            hn, fp

public class ep
{

    private static int a;
    private static int b;
    private Path c;
    private PathShape d;
    private ShapeDrawable e;
    private TextView f;
    private int g;
    private float h;
    private RectF i;
    private final float j;

    public ep()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        h = 0.0F;
        i = null;
        j = -90F;
        a = 3;
        b = 1;
    }

    public ep(Context context, int k, int l)
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        h = 0.0F;
        i = null;
        j = -90F;
        a = hn.b(2);
        b = hn.b(1);
        g = a(k, l);
        a(context);
    }

    private int a(int k, int l)
    {
        if (k < l)
        {
            return k / 2;
        } else
        {
            return l / 2;
        }
    }

    static TextView a(ep ep1)
    {
        return ep1.f;
    }

    private void a(Context context)
    {
        f = new TextView(context);
        f.setTextColor(-1);
        f.setTypeface(Typeface.MONOSPACE);
        f.setTextSize(1, 12F);
        f.setGravity(17);
    }

    static void a(ep ep1, int k)
    {
        ep1.d(k);
    }

    private void d(int k)
    {
        Drawable drawable = c(k);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            f.setBackground(drawable);
            return;
        } else
        {
            f.setBackgroundDrawable(drawable);
            return;
        }
    }

    private void e(int k)
    {
        fp.a().a(new Runnable(k) {

            final int a;
            final ep b;

            public void run()
            {
                ep.a(b, a);
            }

            
            {
                b = ep.this;
                a = k;
                super();
            }
        });
    }

    private void f(int k)
    {
        fp.a().a(new Runnable(k) {

            final int a;
            final ep b;

            public void run()
            {
                ep.a(b).setText(Integer.toString(a));
            }

            
            {
                b = ep.this;
                a = k;
                super();
            }
        });
    }

    public View a()
    {
        return f;
    }

    public void a(int k)
    {
        if (f != null)
        {
            e(k);
            f(k);
        }
    }

    public void b(int k)
    {
        h = 360F / (float)(k / 1000);
        fp.a().a(new Runnable(k) {

            final int a;
            final ep b;

            public void run()
            {
                ep.a(b, a);
            }

            
            {
                b = ep.this;
                a = k;
                super();
            }
        });
    }

    public Drawable c(int k)
    {
        Object obj = null;
        if (true)
        {
            i = new RectF();
            i.set(a, a, g - a, g - a);
            c = new Path();
            c.arcTo(i, -90F, (float)(-k) * h + 1.0F, false);
            d = new PathShape(c, g, g);
            e = new ShapeDrawable(d);
            e.setIntrinsicHeight(g * 2);
            e.setIntrinsicWidth(g * 2);
            e.getPaint().setStyle(android.graphics.Paint.Style.STROKE);
            e.getPaint().setColor(-1);
            e.getPaint().setStrokeWidth(b);
            e.getPaint().setAntiAlias(true);
            obj = new GradientDrawable();
            ((GradientDrawable) (obj)).setColor(0xff000000);
            ((GradientDrawable) (obj)).setShape(1);
            ((GradientDrawable) (obj)).setAlpha(178);
            obj = new LayerDrawable(new Drawable[] {
                obj, e
            });
        }
        return ((Drawable) (obj));
    }
}

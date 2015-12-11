// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.LinearLayout;

public final class c extends LinearLayout
{

    private Bitmap a;
    private Bitmap b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private Bitmap f;
    private int g;
    private int h;

    public c(Context context)
    {
        super(context);
        getContext().getResources().getDisplayMetrics();
        setOrientation(1);
        c = new ImageView(getContext());
        c.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        addView(c);
        d = new ImageView(getContext());
        d.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        d.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        addView(d);
        e = new ImageView(getContext());
        e.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        addView(e);
    }

    private void a()
    {
        if (getHeight() > 0)
        {
            h = b();
            g = (int)Math.ceil((float)(getHeight() - h) / 2.0F);
            Object obj = new Matrix();
            ((Matrix) (obj)).preScale(1.0F, -1F);
            int i = (int)Math.floor((float)(getHeight() - h) / 2.0F);
            float f1 = (float)a.getHeight() / (float)h;
            int j = Math.round((float)g * f1);
            if (j > 0)
            {
                f = Bitmap.createBitmap(b, 0, 0, b.getWidth(), j, ((Matrix) (obj)), true);
                c.setImageBitmap(f);
            }
            i = Math.round((float)i * f1);
            if (i > 0)
            {
                obj = Bitmap.createBitmap(b, 0, b.getHeight() - i, b.getWidth(), i, ((Matrix) (obj)), true);
                e.setImageBitmap(((Bitmap) (obj)));
            }
        }
    }

    private int b()
    {
        return (int)Math.round((double)getWidth() / 1.9099999999999999D);
    }

    public final void a(Bitmap bitmap, Bitmap bitmap1)
    {
        if (bitmap == null)
        {
            d.setImageDrawable(null);
            return;
        } else
        {
            d.setImageBitmap(Bitmap.createBitmap(bitmap));
            a = bitmap;
            b = bitmap1;
            bitmap.getHeight();
            bitmap.getWidth();
            a();
            return;
        }
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (a == null || b == null)
        {
            super.onLayout(flag, i, j, k, l);
            return;
        }
        int i1 = b();
        if (f == null || h != i1)
        {
            a();
        }
        c.layout(i, j, k, g);
        d.layout(i, g + j, k, g + h);
        e.layout(i, g + j + h, k, l);
    }
}

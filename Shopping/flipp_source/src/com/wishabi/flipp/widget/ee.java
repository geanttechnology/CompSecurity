// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.wishabi.flipp.widget:
//            ef, ed

final class ee extends LinearLayout
{

    int a;
    float b;
    ed c;
    final ef d;
    private final int e;
    private final Paint f;
    private final int g;
    private final Paint h;
    private final int i;
    private final Paint j;
    private final float k;

    ee(Context context)
    {
        this(context, (byte)0);
    }

    private ee(Context context, byte byte0)
    {
        super(context, null);
        setWillNotDraw(false);
        float f1 = getResources().getDisplayMetrics().density;
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(0x1010030, typedvalue, true);
        byte0 = typedvalue.data;
        i = a(byte0, (byte)38);
        d = new ef((byte)0);
        d.a = (new int[] {
            0xff33b5e5
        });
        d.b = (new int[] {
            a(byte0, (byte)32)
        });
        e = (int)(2.0F * f1);
        f = new Paint();
        f.setColor(i);
        g = (int)(8F * f1);
        h = new Paint();
        k = 0.5F;
        j = new Paint();
        j.setStrokeWidth((int)(f1 * 1.0F));
    }

    private static int a(int l, byte byte0)
    {
        return Color.argb(byte0, Color.red(l), Color.green(l), Color.blue(l));
    }

    protected final void onDraw(Canvas canvas)
    {
        int i3 = getHeight();
        int k2 = getChildCount();
        int l2 = (int)(Math.min(Math.max(0.0F, k), 1.0F) * (float)i3);
        Object obj;
        if (c != null)
        {
            obj = c;
        } else
        {
            obj = d;
        }
        if (k2 > 0)
        {
            View view = getChildAt(a);
            int i2 = view.getLeft();
            int l1 = view.getRight();
            int k1 = ((ed) (obj)).a(a);
            int i1;
            int j2;
            if (b > 0.0F && a < getChildCount() - 1)
            {
                j2 = ((ed) (obj)).a(a + 1);
                int l = k1;
                if (k1 != j2)
                {
                    float f1 = b;
                    float f3 = 1.0F - f1;
                    float f5 = Color.red(j2);
                    float f7 = Color.red(k1);
                    float f8 = Color.green(j2);
                    float f9 = Color.green(k1);
                    float f10 = Color.blue(j2);
                    float f11 = Color.blue(k1);
                    l = Color.rgb((int)(f5 * f1 + f7 * f3), (int)(f8 * f1 + f9 * f3), (int)(f11 * f3 + f10 * f1));
                }
                view = getChildAt(a + 1);
                float f2 = b;
                float f4 = view.getLeft();
                float f6 = b;
                k1 = (int)((float)i2 * (1.0F - f6) + f2 * f4);
                f2 = b;
                f4 = view.getRight();
                f6 = b;
                l1 = (int)((float)l1 * (1.0F - f6) + f4 * f2);
                j2 = l;
                l = l1;
                i2 = k1;
                l1 = l;
            } else
            {
                int j1 = i2;
                i2 = j1;
                j2 = k1;
            }
            h.setColor(j2);
            canvas.drawRect(i2, i3 - g, l1, i3, h);
        }
        canvas.drawRect(0.0F, i3 - e, getWidth(), i3, f);
        k1 = (i3 - l2) / 2;
        for (i1 = 0; i1 < k2 - 1; i1++)
        {
            view = getChildAt(i1);
            j.setColor(((ed) (obj)).b(i1));
            canvas.drawLine(view.getRight(), k1, view.getRight(), k1 + l2, j);
        }

    }
}

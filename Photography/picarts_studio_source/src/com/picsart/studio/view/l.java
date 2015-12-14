// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Interpolator;

// Referenced classes of package com.picsart.studio.view:
//            a

final class l
{

    static final Interpolator a = com.picsart.studio.view.a.a();
    final RectF b = new RectF();
    float c;
    long d;
    long e;
    boolean f;
    int g;
    int h;
    int i;
    int j;
    View k;
    Rect l;
    private final Paint m = new Paint();

    public l(View view)
    {
        l = new Rect();
        k = view;
        g = 0xb3000000;
        h = 0x80000000;
        i = 0x4d000000;
        j = 0x1a000000;
    }

    final void a(float f1)
    {
        c = f1;
        d = 0L;
        ViewCompat.postInvalidateOnAnimation(k);
    }

    final void a(Canvas canvas, float f1, float f2, int i1, float f3)
    {
        m.setColor(i1);
        canvas.save();
        canvas.translate(f1, f2);
        f2 = a.getInterpolation(f3);
        canvas.scale(f2, f2);
        canvas.drawCircle(0.0F, 0.0F, f1, m);
        canvas.restore();
    }

    final void a(Canvas canvas, int i1, int j1)
    {
        m.setColor(g);
        canvas.drawCircle(i1, j1, (float)i1 * c, m);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.socialin.android.photo.draw.shape:
//            a

public class ShapeItemView extends View
{

    private a a;

    public ShapeItemView(Context context)
    {
        super(context);
        a = null;
    }

    public ShapeItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = (int)((80F - (float)a.c * 1.8F) / 2.0F);
        int j = (int)((80F - (float)a.d * 1.8F) / 2.0F);
        canvas.translate(i, j);
        a.a.setStrokeWidth(1.0F);
        a a1 = a;
        a1.k = (int)(((float)a1.k - 0.0F) * 1.8F);
        a1.l = (int)(((float)a1.l - 0.0F) * 1.8F);
        a1.m = (float)a1.k + ((float)a1.e * 1.8F) / 2.0F;
        a1.n = (float)a1.l + ((float)a1.f * 1.8F) / 2.0F;
        a1.i.set(a1.k, a1.l, a1.k + a1.e, a1.l + a1.f);
        a1.j.set(a1.k, a1.l, a1.k + a1.c, a1.l + a1.d);
        a1.b.setBounds(a1.j);
        a1.b.getPaint().set(a1.a);
        canvas.save();
        canvas.rotate(0.0F, a1.m, a1.n);
        canvas.scale(a1.g * 1.8F, a1.h * 1.8F, a1.k, a1.l);
        canvas.restore();
    }

    public void setShapeData(int i, int j)
    {
        a = new a(getContext(), i, android.graphics.Paint.Style.STROKE);
        a a1 = a;
        i = a1.a.getAlpha();
        a1.a.setColor(-1);
        a1.a.setAlpha(i);
    }

    public void setShapeObj(a a1)
    {
        a = a1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.impl.adview:
//            u

public class al extends u
{

    private float c;
    private float d;
    private float e;
    private float f;
    private float g;

    public al(AppLovinSdk applovinsdk, Context context)
    {
        super(applovinsdk, context);
        c = 30F;
        d = 2.0F;
        e = 8F;
        f = 2.0F;
        g = 1.0F;
    }

    protected float a()
    {
        return c * g;
    }

    public void a(float f1)
    {
        g = f1;
    }

    public void a(int i)
    {
        a((float)i / c);
    }

    protected float b()
    {
        return e * g;
    }

    protected float c()
    {
        return f * g;
    }

    protected float d()
    {
        return a() / 2.0F;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f1 = d();
        Paint paint = new Paint(1);
        paint.setARGB(80, 0, 0, 0);
        canvas.drawCircle(f1, f1, f1, paint);
        paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(c());
        f1 = b();
        float f2 = a() - f1;
        canvas.drawLine(f1, f1, f2, f2, paint);
        canvas.drawLine(f1, f2, f2, f1, paint);
    }
}

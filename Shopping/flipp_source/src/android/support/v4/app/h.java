// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.view.ap;
import android.view.Window;

// Referenced classes of package android.support.v4.app:
//            a

final class h extends InsetDrawable
    implements android.graphics.drawable.Drawable.Callback
{

    float a;
    float b;
    final a c;
    private final boolean d;
    private final Rect e;

    private h(a a1, Drawable drawable)
    {
        boolean flag = false;
        c = a1;
        super(drawable, 0);
        if (android.os.Build.VERSION.SDK_INT > 18)
        {
            flag = true;
        }
        d = flag;
        e = new Rect();
    }

    h(a a1, Drawable drawable, byte byte0)
    {
        this(a1, drawable);
    }

    public final void a(float f)
    {
        a = f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas)
    {
        int i = 1;
        copyBounds(e);
        canvas.save();
        float f;
        float f1;
        float f2;
        boolean flag;
        int j;
        if (ap.h(android.support.v4.app.a.a(c).getWindow().getDecorView()) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i = -1;
        }
        j = e.width();
        f = -b;
        f1 = j;
        f2 = a;
        canvas.translate((float)i * (f * f1 * f2), 0.0F);
        if (flag && !d)
        {
            canvas.translate(j, 0.0F);
            canvas.scale(-1F, 1.0F);
        }
        super.draw(canvas);
        canvas.restore();
    }
}

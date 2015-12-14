// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;

// Referenced classes of package myobfuscated.ay:
//            c

public class b
{

    public static float m;
    public static float n;
    private static final String q = (new StringBuilder()).append(myobfuscated/ay/b.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    public myobfuscated.ay.c a;
    public float b;
    public float c;
    public boolean d;
    public boolean e;
    public Bitmap f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float o;
    public RectF p;
    private Rect r;
    private Paint s;
    private RectF t;

    public b(Context context, RectF rectf, float f1, float f2, boolean flag)
    {
        b = -1F;
        c = -1F;
        d = false;
        e = false;
        g = -1F;
        h = -1F;
        i = -1F;
        j = -1F;
        k = -1F;
        l = -1F;
        t = new RectF();
        p = new RectF();
        i = f1 / 2.0F;
        j = f2 / 2.0F;
        e = flag;
        k = f1;
        l = f2;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        f = com.socialin.android.util.c.a(context.getResources(), 0x7f0201da, options, q);
        r = new Rect(0, 0, f.getWidth(), f.getHeight());
        s = new Paint();
        s.setAntiAlias(true);
        s.setFilterBitmap(true);
        m = Utils.a(45F, context);
        n = Utils.a(30F, context);
        o = n;
        p = rectf;
        c(rectf);
    }

    public final void a(Canvas canvas)
    {
        if (e && f != null && !f.isRecycled())
        {
            t.set(g - o, h - o, g + o, h + o);
            canvas.drawBitmap(f, r, t, s);
        }
    }

    public final boolean a(RectF rectf)
    {
        boolean flag = d;
        if (d && a != null && a.a())
        {
            b(rectf);
            float f1 = i / k;
            float f2 = j / l;
            a.a((int)(f1 * 100F), (int)(f2 * 100F));
            d = false;
        }
        return flag;
    }

    public final void b(RectF rectf)
    {
        float f1 = k / rectf.width();
        i = (g - rectf.left) * f1;
        j = f1 * (h - rectf.top);
    }

    public final void c(RectF rectf)
    {
        float f1 = rectf.width() / k;
        g = i * f1 + rectf.left;
        h = f1 * j + rectf.top;
    }

}

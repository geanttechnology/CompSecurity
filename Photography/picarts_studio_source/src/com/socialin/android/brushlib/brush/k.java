// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.Log;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.util.h;
import com.socialin.android.util.l;
import java.util.Random;
import junit.framework.Assert;
import myobfuscated.b.a;
import myobfuscated.bs.c;
import myobfuscated.bs.d;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush

public final class k extends Brush
{

    public static final float c = (float)Math.sqrt(2D);
    private static final String e = com/socialin/android/brushlib/brush/Brush.getSimpleName();
    public final int d;
    private final Paint f;
    private Brush.Params g;
    private c h;
    private h i;
    private h j;
    private h k;
    private h l;
    private h m;
    private String n;
    private Matrix o;
    private float p[];
    private float q[];

    private k(Context context, String s, int i1)
    {
        g = (new Brush.Params()).setColor(0xff000000).setThickness(30F).setAngle(0.0F).setSquish(1.0F).setSpacing(0.05F).setHueJitter(0.0F).setSizeJitter(0.0F).setAngleJitter(0.0F).setScattering(0.0F);
        i = new h();
        j = new h();
        k = new h(0.0F, 360F);
        l = new h();
        m = new h();
        new Random();
        o = new Matrix();
        p = new float[2];
        q = new float[2];
        f = new Paint(2);
        h = myobfuscated.bs.d.a(context.getAssets(), s);
        n = s;
        d = i1;
    }

    private k(k k1)
    {
        g = (new Brush.Params()).setColor(0xff000000).setThickness(30F).setAngle(0.0F).setSquish(1.0F).setSpacing(0.05F).setHueJitter(0.0F).setSizeJitter(0.0F).setAngleJitter(0.0F).setScattering(0.0F);
        i = new h();
        j = new h();
        k = new h(0.0F, 360F);
        l = new h();
        m = new h();
        new Random();
        o = new Matrix();
        p = new float[2];
        q = new float[2];
        f = new Paint(k1.f);
        h = k1.h;
        a(k1.g);
        d = k1.d;
    }

    public static k a(Context context, String s, int i1)
    {
        return new k(context, s, i1);
    }

    public static Brush.Params b(int i1)
    {
        switch (i1)
        {
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        default:
            return (new Brush.Params()).setColor(0xff000000).setThickness(30F).setAngle(0.0F).setSquish(1.0F).setSpacing(0.05F).setHueJitter(0.0F).setSizeJitter(0.0F).setAngleJitter(0.0F).setScattering(0.0F);

        case 10: // '\n'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(50).setThickness(40F).setSpacing(0.0396F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(0.0F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 11: // '\013'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(40).setThickness(60F).setSpacing(0.0594F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(90F).setAngleJitter(0.0F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(true).setVaryThickness(false).setVaryOpacity(true);

        case 12: // '\f'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(30F).setSpacing(0.099F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(false);

        case 13: // '\r'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(60F).setSpacing(0.0594F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(5F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 14: // '\016'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(50).setThickness(30F).setSpacing(0.0594F).setScattering(50F).setSizeJitter(0.3F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(10F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(false);

        case 15: // '\017'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(10F).setSpacing(0.0594F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(0.0F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(false);

        case 16: // '\020'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(40F).setSpacing(0.099F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 17: // '\021'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(30).setThickness(40F).setSpacing(0.0396F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(0.0F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 18: // '\022'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(150).setThickness(40F).setSpacing(0.099F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(10F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 19: // '\023'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(150).setThickness(40F).setSpacing(0.0594F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(15F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 20: // '\024'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(200).setThickness(50F).setSpacing(0.099F).setScattering(5F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(25F).setSquish(1.0F).setHueJitter(10F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(false);

        case 29: // '\035'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(148).setThickness(83F).setSpacing(0.0398F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(180F).setAngleJitter(0.0F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(true).setVaryThickness(false).setVaryOpacity(false);

        case 30: // '\036'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(128F).setSpacing(0.1388F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(64F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(true).setVaryThickness(true).setVaryOpacity(true);

        case 31: // '\037'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(153).setThickness(128F).setSpacing(0.0398F).setScattering(9F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(140F).setSquish(1.0F).setHueJitter(20F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 32: // ' '
            return (new Brush.Params()).setColor(0xff000000).setAlpha(56).setThickness(50F).setSpacing(0.0992F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(0.0F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(false).setVaryOpacity(true);

        case 33: // '!'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(12F).setSpacing(0.0596F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(113F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(true).setVaryThickness(true).setVaryOpacity(false);

        case 34: // '"'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(51).setThickness(128F).setSpacing(0.0992F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(152F).setSquish(1.0F).setHueJitter(11F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 35: // '#'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(204).setThickness(50F).setSpacing(0.119F).setScattering(10F).setSizeJitter(0.5F).setAngle(135F).setAngleJitter(143F).setSquish(1.0F).setHueJitter(35F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 36: // '$'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(51).setThickness(100F).setSpacing(0.0398F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(0.0F).setSquish(0.64F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 37: // '%'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(60F).setSpacing(0.119F).setScattering(0.0F).setSizeJitter(0.0F).setAngle(0.0F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 38: // '&'
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(128F).setSpacing(0.1784F).setScattering(12F).setSizeJitter(0.6F).setAngle(95F).setAngleJitter(180F).setSquish(1.0F).setHueJitter(10F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 39: // '\''
            return (new Brush.Params()).setColor(0xff000000).setAlpha(84).setThickness(75F).setSpacing(0.0992F).setScattering(0.0F).setSizeJitter(0.38F).setAngle(0.0F).setAngleJitter(151F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);

        case 40: // '('
            return (new Brush.Params()).setColor(0xff000000).setAlpha(255).setThickness(119F).setSpacing(0.1784F).setScattering(12F).setSizeJitter(0.22F).setAngle(0.0F).setAngleJitter(142F).setSquish(1.0F).setHueJitter(0.0F).setAutoOrient(false).setVaryThickness(true).setVaryOpacity(true);
        }
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
    }

    public final void a(Xfermode xfermode)
    {
        f.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        g.set(params);
        i.a(-params.getHueJitter(), params.getHueJitter());
        j.a(1.0F - params.getSizeJitter(), 1.0F);
        l.a(0.0F, params.getScattering());
        m.a(-params.getAngleJitter(), params.getAngleJitter());
    }

    public final void a(Stroke stroke, float f1, float f2, Canvas canvas, RectF rectf)
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        Log.w(e, "Brush.texture == null");
_L4:
        return;
_L2:
        Assert.assertNotNull(stroke);
        Assert.assertNotNull(canvas);
        float f4 = Math.max(a * g.getThickness() * g.getSpacing(), 0.5F);
        int j1 = (int)(f1 / f4);
        int i1 = j1;
        if ((float)j1 * f4 < f1)
        {
            i1 = j1 + 1;
        }
        if (rectf != null)
        {
            stroke.getPosTan(f1, p, null);
            rectf.set(p[0], p[1], p[0], p[1]);
        }
        do
        {
            float f5 = (float)i1 * f4;
            if (f5 >= f2)
            {
                continue;
            }
            stroke.getPosTan(f5, p, q);
            f.setColor(com.socialin.android.util.l.a(g.getColor(), i.b(i1)));
            f1 = (float)g.getAlpha() / 255F;
            float f3;
            float f6;
            float af[];
            if (g.isVaryOpacity())
            {
                f1 *= myobfuscated.b.a.generate(f5, stroke);
            } else
            {
                f1 *= 255F;
            }
            f.setAlpha((int)f1);
            o.setTranslate(-48F, -48F);
            o.postScale(g.getSquish(), 1.0F);
            f3 = g.getAngle() + m.b(i1);
            f1 = f3;
            if (g.isAutoOrient())
            {
                f1 = f3 + (float)Math.toDegrees(Math.atan2(q[1], q[0]));
            }
            o.postRotate(f1);
            f3 = (a * g.getThickness()) / 96F;
            f1 = f3;
            if (g.isVaryThickness())
            {
                f1 = f3 * myobfuscated.b.a.generate(f5, stroke);
            }
            f1 *= j.b(i1);
            o.postScale(f1, f1);
            f6 = k.b(i1);
            f3 = l.b(i1);
            f5 = (float)Math.cos(f6);
            f6 = (float)Math.sin(f6);
            af = p;
            af[0] = f5 * f3 + af[0];
            af = p;
            af[1] = f6 * f3 + af[1];
            o.postTranslate(p[0], p[1]);
            h.a(canvas, o, f);
            if (rectf != null)
            {
                rectf.union(p[0], p[1]);
            }
            f1 = (f1 * (c * 96F)) / 2.0F;
            if (rectf != null)
            {
                rectf.union(p[0] - f1, p[1] - f1, p[0] + f1, f1 + p[1]);
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        a(stroke, 0.0F, stroke.getLength(), canvas, null);
    }

    public final void b(Brush.Params params)
    {
        params.set(g);
    }

    public final int c()
    {
        return 28;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        k k1 = new k(this);
        k1.a(b);
        return k1;
    }

    public final String e()
    {
        return n.substring(n.indexOf("/") + 1, n.indexOf("."));
    }

    public final String toString()
    {
        return "Texture brush";
    }

}

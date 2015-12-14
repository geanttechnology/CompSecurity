// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.util.Utils;

public final class c
{

    private static int o = 7;
    public float a;
    public boolean b;
    public float c;
    public float d;
    public Paint e;
    public Paint f;
    public Paint g;
    public Bitmap h;
    public Rect i;
    public RectF j;
    public float k;
    public float l;
    public boolean m;
    public boolean n;
    private int p;
    private float q;
    private Matrix r;
    private int s;
    private float t;
    private float u;
    private Context v;

    public c(Context context, Matrix matrix, int i1)
    {
        b = false;
        c = 7F;
        d = 7F;
        k = -1F;
        l = -1F;
        t = -1F;
        u = -1F;
        m = false;
        n = true;
        v = context;
        o = (int)Utils.a(7F, context);
        Utils.a(30F, context);
        Utils.a(2.0F, context);
        r = matrix;
        e = new Paint();
        f = new Paint();
        f.setColor(0xff000000);
        g = new Paint();
        g.setAntiAlias(true);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeWidth(2.0F);
        g.setColor(-1);
        i = new Rect();
        j = new RectF();
        p = i1;
        q = i1;
        context = new float[9];
        r.getValues(context);
        d = o;
        c = d / context[0];
        s = (int)c + 5;
    }

    public final void a()
    {
        float af[] = new float[9];
        r.getValues(af);
        k = (int)(t * af[0] + af[2]);
        l = (int)(u * af[4] + af[5]);
        c = d / af[0];
        s = (int)c + 5;
    }

    public final void a(float f1, float f2)
    {
        float f3;
        float f4;
        float f5;
        float f6;
        b = true;
        float af[] = new float[9];
        r.getValues(af);
        int i1 = (int)((f1 - af[2]) / af[0]);
        int j1 = (int)((f2 - af[5]) / af[4]);
        if (h == null || h.isRecycled())
        {
            m = false;
            return;
        }
        if (i1 < 0 || j1 < 0 || i1 > h.getWidth() || j1 > h.getHeight())
        {
            m = false;
            return;
        }
        t = i1;
        u = j1;
        k = f1;
        l = f2;
        i.set(i1 - s, j1 - s, i1 + s, j1 + s);
        f1 -= p;
        f4 = f2 - (float)(p * 2) - q;
        f3 = (float)(p * 2) + f1;
        f6 = (float)(p * 2) + f4;
        f5 = f4;
        if (f4 < 0.0F)
        {
            f6 = p * 2;
            f5 = 0.0F;
        }
        f4 = f1;
        if (f1 < 0.0F)
        {
            f3 = p * 2;
            f4 = 0.0F;
        }
        if (f6 <= f2 - q) goto _L2; else goto _L1
_L1:
        if (f4 - q * 2.0F < 0.0F) goto _L4; else goto _L3
_L3:
        f2 = f4 - q * 2.0F;
        f1 = (float)(p * 2) + f2;
_L6:
        j.set(f2, f5, f1, f6);
        m = true;
        return;
_L4:
        f1 = f3;
        f2 = f4;
        if (q * 2.0F + f3 <= a)
        {
            f1 = f3 + q * 2.0F;
            f2 = f1 - (float)(p * 2);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        f1 = f3;
        f2 = f4;
        if (f3 >= a)
        {
            f1 = a;
            f2 = f1 - (float)(p * 2);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(int i1)
    {
        d = (int)Utils.a(i1, v);
        float af[] = new float[9];
        r.getValues(af);
        c = d / af[0];
        s = (int)c + 5;
        a();
    }

}

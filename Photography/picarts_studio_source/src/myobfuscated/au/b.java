// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.au;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;

public abstract class b
{

    protected int a;
    protected int b;
    protected float c[];
    protected float d[];
    protected ArrayList e;
    public boolean f;
    private Paint g;

    public b(ArrayList arraylist)
    {
        f = false;
        e = arraylist;
        g = new Paint();
        g.setFilterBitmap(true);
        g.setAntiAlias(true);
    }

    protected static void a(float af[], int i, float f1, float f2)
    {
        af[i * 2 + 0] = f1;
        af[i * 2 + 1] = f2;
    }

    public abstract void a(float f1, float f2);

    public final void a(int i, int j)
    {
        float f1 = i;
        float f2 = j;
        float f3 = Math.min(f1, f2) * 0.03F;
        a = (int)(f1 / f3);
        b = (int)(f2 / f3);
        i = (a + 1) * (b + 1);
        c = new float[i * 2];
        d = new float[i * 2];
        i = 0;
        j = 0;
        for (; i <= b; i++)
        {
            float f4 = ((float)i * f2) / (float)b;
            for (int k = 0; k <= a;)
            {
                float f5 = ((float)k * f1) / (float)a;
                a(c, j, f5, f4);
                k++;
                j++;
            }

        }

        a(f1, f2);
    }

    public final void a(Canvas canvas, Bitmap bitmap, RectF rectf, int i)
    {
        canvas.save();
        canvas.translate(rectf.left, rectf.top);
        float f1 = rectf.width() / (float)i;
        canvas.scale(f1, f1);
        if (g != null)
        {
            canvas.drawBitmapMesh(bitmap, a, b, d, 0, null, 0, g);
        }
        canvas.restore();
    }

    public final void a(ArrayList arraylist)
    {
        e = arraylist;
        Log.e("ex1", "EffectDrawer **************************");
        for (int i = 0; i < arraylist.size(); i++)
        {
            EffectParameter effectparameter = (EffectParameter)arraylist.get(i);
            Log.e("ex1", (new StringBuilder("parameter name = ")).append(effectparameter.a).toString());
            if (effectparameter.b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt)
            {
                Log.e("ex1", (new StringBuilder("value = ")).append(effectparameter.c).toString());
            }
        }

    }

    public final void b(int i, int j)
    {
        EffectParameter.a(e, i, j);
    }
}

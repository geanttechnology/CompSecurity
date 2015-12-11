// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;
import java.util.concurrent.atomic.AtomicInteger;

public final class bmd
{

    private static bma a;

    public static Bitmap a(Context context, Bitmap bitmap, float f)
    {
        if (a == null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                a = new bmb();
            } else
            {
                a = new bma();
            }
        }
        return a.a(context, bitmap, f);
    }

    public static Bitmap a(Bitmap bitmap, int i, int j)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        float f = (float)i / (float)bitmap.getWidth();
        float f1 = (float)j / (float)bitmap.getHeight();
        float f2 = (float)i / 2.0F;
        float f3 = (float)j / 2.0F;
        Matrix matrix = new Matrix();
        matrix.setScale(f, f1, f2, f3);
        Canvas canvas = new Canvas(bitmap1);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, f2 - (float)(bitmap.getWidth() / 2), f3 - (float)(bitmap.getHeight() / 2), new Paint(2));
        return bitmap1;
    }

    public static void a(Context context, int i, int j)
    {
        Toast.makeText(context.getApplicationContext(), i, 0).show();
    }

    public static void a(Context context, CharSequence charsequence, int i)
    {
        Toast.makeText(context.getApplicationContext(), charsequence, 1).show();
    }

    public static void a(ColorMatrix colormatrix, float f)
    {
        float af[] = colormatrix.getArray();
        af[0] = af[0] * 0.7F;
        af[1] = af[1] * 0.7F;
        af[2] = af[2] * 0.7F;
        af[5] = af[5] * 0.7F;
        af[6] = af[6] * 0.7F;
        af[7] = af[7] * 0.7F;
        af[10] = af[10] * 0.7F;
        af[11] = af[11] * 0.7F;
        af[12] = af[12] * 0.7F;
        colormatrix.set(af);
    }

    public static void a(View view, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    static 
    {
        new AtomicInteger(1);
    }
}

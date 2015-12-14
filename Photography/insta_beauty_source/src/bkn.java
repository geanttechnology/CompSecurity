// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

public class bkn extends bks
    implements Cloneable
{

    private bkd e;
    private bkc f;

    public bkn(bkd bkd1)
    {
        e = bkd1;
        a = bkd1.g;
        b = bkd1.h;
        c();
    }

    public bkd a()
    {
        return e;
    }

    public void a(Canvas canvas)
    {
        if (!d)
        {
            return;
        } else
        {
            e.j = j();
            e.a(canvas);
            return;
        }
    }

    public void a(Matrix matrix)
    {
        f.a = matrix;
    }

    public void a(bkd bkd1)
    {
        e = bkd1;
        a = bkd1.g;
        b = bkd1.h;
    }

    public boolean a(float f1, float f2)
    {
        boolean flag = false;
        Matrix matrix = new Matrix();
        if (j().invert(matrix))
        {
            float af[] = new float[2];
            af[0] = f1;
            af[1] = f2;
            matrix.mapPoints(af);
            flag = (new RectF(0.0F, 0.0F, a, b)).contains(af[0], af[1]);
        }
        return flag;
    }

    public bkn b()
    {
        bkn bkn1 = (bkn)super.clone();
        bkn1.f = new bkc();
        return bkn1;
    }

    public void b(Matrix matrix)
    {
        f.b.postConcat(matrix);
    }

    protected void c()
    {
        if (e != null)
        {
            f = new bkc();
        }
    }

    public void c(Matrix matrix)
    {
        f.c = matrix;
    }

    public Object clone()
    {
        return b();
    }

    public Matrix d()
    {
        return f.a;
    }

    public void d(Matrix matrix)
    {
        f.d.postConcat(matrix);
    }

    public Matrix e()
    {
        return f.b;
    }

    public void e(Matrix matrix)
    {
        f.e = matrix;
    }

    public Matrix f()
    {
        return f.c;
    }

    public void f(Matrix matrix)
    {
        f.f.postConcat(matrix);
    }

    public Matrix g()
    {
        return f.d;
    }

    public Matrix h()
    {
        return f.e;
    }

    public Matrix i()
    {
        return f.f;
    }

    public Matrix j()
    {
        Matrix matrix = new Matrix();
        matrix.setTranslate(a / 2.0F, b / 2.0F);
        matrix.preConcat(e());
        matrix.preConcat(d());
        matrix.preConcat(i());
        matrix.preConcat(h());
        matrix.preTranslate(-a / 2.0F, -b / 2.0F);
        matrix.postConcat(g());
        matrix.postConcat(f());
        return matrix;
    }
}

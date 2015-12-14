// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.wantu.imagelib.decorator.TGifEleDecorator;

public class bki extends bks
    implements Cloneable
{

    private TGifEleDecorator e;
    private bkc f[];
    private int g;
    private int h;
    private int i;
    private Boolean j;

    public bki(TGifEleDecorator tgifeledecorator)
    {
        e = tgifeledecorator;
        a = tgifeledecorator.e;
        b = tgifeledecorator.f;
        b();
    }

    public bki a()
    {
        bki bki1 = (bki)super.clone();
        bkc abkc[] = new bkc[f.length];
        for (int k = 0; k < f.length; k++)
        {
            abkc[k] = f[k].a();
        }

        bki1.a(abkc);
        return bki1;
    }

    public void a(int k)
    {
        h = k;
    }

    public void a(Canvas canvas)
    {
        if (!d)
        {
            return;
        } else
        {
            e.b = i();
            e.a(canvas, g);
            return;
        }
    }

    public void a(Matrix matrix)
    {
        bkc bkc1;
        if (j.booleanValue())
        {
            for (int k = 0; k < f.length; k++)
            {
                f[k].a = matrix;
            }

            break MISSING_BLOCK_LABEL_82;
        }
        bkc1 = f[g];
        bkc1.a = matrix;
        if (g >= f.length - 1)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        f[g + 1] = bkc1.a();
        return;
        matrix;
        matrix.printStackTrace();
        return;
    }

    public void a(Boolean boolean1)
    {
        j = boolean1;
    }

    public void a(bkc abkc[])
    {
        f = abkc;
    }

    public boolean a(float f1, float f2)
    {
        boolean flag = false;
        Matrix matrix = new Matrix();
        if (i().invert(matrix))
        {
            float af[] = new float[2];
            af[0] = f1;
            af[1] = f2;
            matrix.mapPoints(af);
            flag = (new RectF(0.0F, 0.0F, a, b)).contains(af[0], af[1]);
        }
        return flag;
    }

    protected void b()
    {
        i = 30;
        if (e != null)
        {
            int k;
            if (e.c.booleanValue())
            {
                f = new bkc[i];
            } else
            {
                f = new bkc[e.a()];
            }
            for (k = 0; k < f.length; k++)
            {
                f[k] = new bkc();
            }

            j = Boolean.valueOf(true);
        }
    }

    public void b(int k)
    {
        if (e.c.booleanValue())
        {
            if (k >= h && k <= i)
            {
                g = k - h;
                c = i();
                d = true;
                return;
            } else
            {
                d = false;
                return;
            }
        }
        int l = e.a();
        if (k < h || k >= l + h || k > i)
        {
            d = false;
            return;
        } else
        {
            g = k - h;
            c = i();
            d = true;
            return;
        }
    }

    public void b(Matrix matrix)
    {
        bkc bkc1;
        if (j.booleanValue())
        {
            for (int k = 0; k < f.length; k++)
            {
                f[k].b.postConcat(f[k].a);
            }

            break MISSING_BLOCK_LABEL_98;
        }
        bkc1 = f[g];
        bkc1.b.postConcat(matrix);
        if (g >= f.length - 1)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        f[g + 1] = bkc1.a();
        return;
        matrix;
        matrix.printStackTrace();
        return;
    }

    public Matrix c()
    {
        return f[g].a;
    }

    public void c(int k)
    {
        i = k - 1;
        b(k);
    }

    public void c(Matrix matrix)
    {
        bkc bkc1;
        if (j.booleanValue())
        {
            for (int k = 0; k < f.length; k++)
            {
                f[k].c = matrix;
            }

            break MISSING_BLOCK_LABEL_82;
        }
        bkc1 = f[g];
        bkc1.c = matrix;
        if (g >= f.length - 1)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        f[g + 1] = bkc1.a();
        return;
        matrix;
        matrix.printStackTrace();
        return;
    }

    public Object clone()
    {
        return a();
    }

    public Matrix d()
    {
        return f[g].b;
    }

    public void d(Matrix matrix)
    {
        bkc bkc1;
        if (j.booleanValue())
        {
            matrix = f;
            int l = matrix.length;
            for (int k = 0; k < l; k++)
            {
                Object obj = matrix[k];
                ((bkc) (obj)).d.postConcat(((bkc) (obj)).c);
            }

            break MISSING_BLOCK_LABEL_98;
        }
        bkc1 = f[g];
        bkc1.d.postConcat(matrix);
        if (g >= f.length - 1)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        f[g + 1] = bkc1.a();
        return;
        matrix;
        matrix.printStackTrace();
        return;
    }

    public Matrix e()
    {
        return f[g].c;
    }

    public void e(Matrix matrix)
    {
        bkc bkc1;
        if (j.booleanValue())
        {
            for (int k = 0; k < f.length; k++)
            {
                f[k].e = matrix;
            }

            break MISSING_BLOCK_LABEL_82;
        }
        bkc1 = f[g];
        bkc1.e = matrix;
        if (g >= f.length - 1)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        f[g + 1] = bkc1.a();
        return;
        matrix;
        matrix.printStackTrace();
        return;
    }

    public Matrix f()
    {
        return f[g].d;
    }

    public void f(Matrix matrix)
    {
        bkc bkc1;
        if (j.booleanValue())
        {
            for (int k = 0; k < f.length; k++)
            {
                f[k].f.postConcat(f[k].e);
            }

            break MISSING_BLOCK_LABEL_98;
        }
        bkc1 = f[g];
        bkc1.f.postConcat(matrix);
        if (g >= f.length - 1)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        f[g + 1] = bkc1.a();
        return;
        matrix;
        matrix.printStackTrace();
        return;
    }

    public Matrix g()
    {
        return f[g].e;
    }

    public Matrix h()
    {
        return f[g].f;
    }

    public Matrix i()
    {
        Matrix matrix = new Matrix();
        matrix.postConcat(h());
        matrix.postConcat(g());
        matrix.postConcat(d());
        matrix.postConcat(c());
        matrix.postConcat(f());
        matrix.postConcat(e());
        return matrix;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;

public class bfg
    implements Cloneable
{

    public boolean A;
    public boolean B;
    public float C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public int I;
    public Bitmap a;
    public Bitmap b;
    public int c;
    public int d;
    public float e;
    public float f;
    public RectF g;
    public RectF h;
    public Matrix i;
    public Matrix j;
    public Matrix k;
    public Matrix l;
    public Matrix m;
    public Matrix n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public String v;
    public int w;
    public String x;
    public int y;
    public boolean z;

    public bfg()
    {
        i = new Matrix();
        j = new Matrix();
        k = new Matrix();
        l = new Matrix();
        m = new Matrix();
        n = new Matrix();
    }

    public boolean a()
    {
        return q == 5 || q == 10 || q == 9 || q == 14;
    }

    public boolean b()
    {
        return q == 12 || q == 6 || q == 11 || q == 4 || q == 8 || q == 13;
    }

    public boolean c()
    {
        return q == 7 || q == 15 || q == 16 || q == 17;
    }

    protected Object clone()
    {
        bfg bfg1 = (bfg)super.clone();
        bfg1.i = new Matrix(i);
        bfg1.j = new Matrix(j);
        bfg1.k = new Matrix(k);
        bfg1.l = new Matrix(l);
        bfg1.m = new Matrix(m);
        bfg1.n = new Matrix(n);
        return super.clone();
    }

    public Matrix d()
    {
        Matrix matrix = new Matrix();
        matrix.postConcat(n);
        matrix.postConcat(m);
        matrix.postConcat(j);
        matrix.postConcat(i);
        matrix.postConcat(l);
        matrix.postConcat(k);
        return matrix;
    }
}

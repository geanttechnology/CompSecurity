// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;

public class bkc
    implements Cloneable
{

    public Matrix a;
    public Matrix b;
    public Matrix c;
    public Matrix d;
    public Matrix e;
    public Matrix f;

    public bkc()
    {
        a = new Matrix();
        b = new Matrix();
        c = new Matrix();
        d = new Matrix();
        e = new Matrix();
        f = new Matrix();
    }

    public bkc a()
    {
        bkc bkc1 = (bkc)super.clone();
        bkc1.a = new Matrix(a);
        bkc1.b = new Matrix(b);
        bkc1.c = new Matrix(c);
        bkc1.d = new Matrix(d);
        bkc1.e = new Matrix(e);
        bkc1.f = new Matrix(f);
        return bkc1;
    }

    public Object clone()
    {
        return a();
    }
}

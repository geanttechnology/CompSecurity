// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.socialin.android.util.Geom;

final class i
    implements TypeEvaluator
{

    private Matrix a;
    private float b[];
    private float c[];
    private float d[];

    public i()
    {
        b = new float[9];
        c = new float[9];
        d = new float[9];
        a = new Matrix();
    }

    public final Object evaluate(float f, Object obj, Object obj1)
    {
        obj = (Matrix)obj;
        obj1 = (Matrix)obj1;
        ((Matrix) (obj)).getValues(c);
        ((Matrix) (obj1)).getValues(d);
        for (int j = 0; j < 9; j++)
        {
            b[j] = Geom.b(c[j], d[j], f);
        }

        a.setValues(b);
        return a;
    }
}

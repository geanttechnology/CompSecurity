// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class am extends Animation
{

    private final boolean a;
    private final float b;
    private final float c;
    private final int d;
    private final float e;
    private final int f;
    private final float g;
    private float h;
    private float i;
    private Camera j;

    public am(boolean flag, float f1, float f2, int k, float f3, int l, float f4)
    {
        a = flag;
        b = f1;
        c = f2;
        d = k;
        e = f3;
        f = l;
        g = f4;
    }

    protected final void applyTransformation(float f1, Transformation transformation)
    {
        float f2 = b;
        f1 = f2 + (c - f2) * f1;
        transformation = transformation.getMatrix();
        Camera camera = j;
        camera.save();
        if (a)
        {
            camera.rotateX(f1);
        } else
        {
            camera.rotateY(f1);
        }
        camera.getMatrix(transformation);
        camera.restore();
        f1 = h;
        f2 = i;
        transformation.preTranslate(-f1, -f2);
        transformation.postTranslate(f1, f2);
    }

    public final void initialize(int k, int l, int i1, int j1)
    {
        super.initialize(k, l, i1, j1);
        h = resolveSize(d, e, k, i1);
        i = resolveSize(f, g, l, j1);
        j = new Camera();
    }
}

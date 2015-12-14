// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class k extends Animation
{

    private final float a;
    private final float b;
    private float c;
    private float d;
    private final float e;
    private final boolean f;
    private final boolean g;
    private Camera h;

    public k(float f1, float f2, float f3, boolean flag, boolean flag1)
    {
        a = f1;
        b = f2;
        e = f3;
        f = flag;
        g = flag1;
    }

    protected void applyTransformation(float f1, Transformation transformation)
    {
        float f2 = a;
        f2 += (b - f2) * f1;
        float f3 = c;
        float f4 = d;
        Camera camera = h;
        transformation = transformation.getMatrix();
        camera.save();
        if (f)
        {
            camera.translate(0.0F, 0.0F, e * f1);
        } else
        {
            camera.translate(0.0F, 0.0F, e * (1.0F - f1));
        }
        if (g)
        {
            camera.rotateX(f2);
        } else
        {
            camera.rotateY(f2);
        }
        camera.getMatrix(transformation);
        camera.restore();
        transformation.preTranslate(-f3, -f4);
        transformation.postTranslate(f3, f4);
    }

    public void initialize(int i, int j, int l, int i1)
    {
        super.initialize(i, j, l, i1);
        h = new Camera();
        c = i / 2;
        d = j / 2;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3DAnimation extends Animation
{

    private Camera camera;
    private final float centerX;
    private final float centerY;
    private final float fromDegrees;
    private final boolean reverse;
    private final float toDegrees;
    private final boolean xAxis;

    public Rotate3DAnimation(float f, float f1, float f2, float f3, boolean flag, boolean flag1)
    {
        fromDegrees = f;
        toDegrees = f1;
        centerX = f2;
        centerY = f3;
        reverse = flag;
        xAxis = flag1;
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        float f1;
        float f2;
        if (reverse)
        {
            f1 = toDegrees;
        } else
        {
            f1 = fromDegrees;
        }
        if (reverse)
        {
            f2 = fromDegrees;
        } else
        {
            f2 = toDegrees;
        }
        f = f1 + (f2 - f1) * f;
        transformation = transformation.getMatrix();
        camera.save();
        if (xAxis)
        {
            camera.rotateX(f);
        } else
        {
            camera.rotateY(f);
        }
        camera.getMatrix(transformation);
        camera.restore();
        transformation.preTranslate(-centerX, -centerY);
        transformation.postTranslate(centerX, centerY);
    }

    public void initialize(int i, int j, int k, int l)
    {
        super.initialize(i, j, k, l);
        camera = new Camera();
    }
}

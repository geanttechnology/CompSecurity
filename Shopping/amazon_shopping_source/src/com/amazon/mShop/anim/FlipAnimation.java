// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class FlipAnimation extends Animation
{

    public static float MAX_ROTATION_DEGREES = 180F;
    public static int X_AXIS = 1;
    public static int Y_AXIS = 2;
    private Camera mCamera;
    private int mCenterX;
    private int mCenterY;
    private boolean mIsReversed;
    private int mRotationAxis;

    public FlipAnimation(View view, int i, boolean flag, long l)
    {
        mIsReversed = flag;
        mCamera = new Camera();
        mRotationAxis = i;
        mCenterX = view.getLeft() + view.getWidth() / 2;
        mCenterY = view.getBottom() - view.getHeight() / 2;
        setDuration(l);
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        transformation = transformation.getMatrix();
        if (f <= 1.0F)
        {
            f *= MAX_ROTATION_DEGREES;
            mCamera.save();
            if ((mRotationAxis & X_AXIS) == X_AXIS)
            {
                Camera camera = mCamera;
                float f1;
                if (mIsReversed)
                {
                    f1 = MAX_ROTATION_DEGREES - f;
                } else
                {
                    f1 = f;
                }
                camera.rotateX(f1);
            }
            if ((mRotationAxis & Y_AXIS) == Y_AXIS)
            {
                camera = mCamera;
                f1 = f;
                if (mIsReversed)
                {
                    f1 = MAX_ROTATION_DEGREES - f;
                }
                camera.rotateY(f1);
            }
            mCamera.getMatrix(transformation);
            mCamera.restore();
            transformation.preTranslate(-mCenterX, -mCenterY);
            transformation.postTranslate(mCenterX, mCenterY);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

class j
{
    static class a extends Animation
    {

        private final float a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;
        private final boolean f;
        private Camera g;

        protected void applyTransformation(float f1, Transformation transformation)
        {
            float f2 = a;
            float f3 = b;
            float f4 = c;
            float f5 = d;
            Camera camera = g;
            transformation = transformation.getMatrix();
            camera.save();
            if (f)
            {
                camera.translate(0.0F, 0.0F, e * f1);
            } else
            {
                camera.translate(0.0F, 0.0F, e * (1.0F - f1));
            }
            camera.rotateX(f2 + (f3 - f2) * f1);
            camera.getMatrix(transformation);
            camera.restore();
            transformation.preTranslate(-f4, -f5);
            transformation.postTranslate(f4, f5);
        }

        public void initialize(int i, int k, int l, int i1)
        {
            super.initialize(i, k, l, i1);
            g = new Camera();
        }

        public a(float f1, float f2, float f3, float f4, float f5, boolean flag)
        {
            a = f1;
            b = f2;
            c = f3;
            d = f4;
            e = f5;
            f = flag;
        }
    }

    static class b extends Animation
    {

        private final float a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;
        private final boolean f;
        private Camera g;

        protected void applyTransformation(float f1, Transformation transformation)
        {
            float f2 = a;
            float f3 = b;
            float f4 = c;
            float f5 = d;
            Camera camera = g;
            transformation = transformation.getMatrix();
            camera.save();
            if (f)
            {
                camera.translate(0.0F, 0.0F, e * f1);
            } else
            {
                camera.translate(0.0F, 0.0F, e * (1.0F - f1));
            }
            camera.rotateY(f2 + (f3 - f2) * f1);
            camera.getMatrix(transformation);
            camera.restore();
            transformation.preTranslate(-f4, -f5);
            transformation.postTranslate(f4, f5);
        }

        public void initialize(int i, int k, int l, int i1)
        {
            super.initialize(i, k, l, i1);
            g = new Camera();
        }

        public b(float f1, float f2, float f3, float f4, float f5, boolean flag)
        {
            a = f1;
            b = f2;
            c = f3;
            d = f4;
            e = f5;
            f = flag;
        }
    }


    static Animation a(InMobiBanner.AnimationType animationtype, float f, float f1)
    {
        AlphaAnimation alphaanimation = null;
        if (animationtype == InMobiBanner.AnimationType.ANIMATION_ALPHA)
        {
            alphaanimation = new AlphaAnimation(0.0F, 0.5F);
            alphaanimation.setDuration(1000L);
            alphaanimation.setFillAfter(false);
            alphaanimation.setInterpolator(new DecelerateInterpolator());
        } else
        {
            if (animationtype == InMobiBanner.AnimationType.ROTATE_HORIZONTAL_AXIS)
            {
                animationtype = new a(0.0F, 90F, f / 2.0F, f1 / 2.0F, 0.0F, true);
                animationtype.setDuration(500L);
                animationtype.setFillAfter(false);
                animationtype.setInterpolator(new AccelerateInterpolator());
                return animationtype;
            }
            if (animationtype == InMobiBanner.AnimationType.ROTATE_VERTICAL_AXIS)
            {
                animationtype = new b(0.0F, 90F, f / 2.0F, f1 / 2.0F, 0.0F, true);
                animationtype.setDuration(500L);
                animationtype.setFillAfter(false);
                animationtype.setInterpolator(new AccelerateInterpolator());
                return animationtype;
            }
        }
        return alphaanimation;
    }
}

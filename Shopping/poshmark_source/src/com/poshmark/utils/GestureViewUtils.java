// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import com.poshmark.ui.customviews.GestureView;

public class GestureViewUtils
{

    private static final String TAG = "GESTURE VIEW UTIL";

    public GestureViewUtils()
    {
    }

    public Bitmap getInitialScaledBitmap(Rect rect, Bitmap bitmap)
    {
        Log.d("GESTURE VIEW UTIL", String.format("Initial Scalling fo bitmap", new Object[0]));
        float f1 = bitmap.getWidth();
        float f2 = bitmap.getHeight();
        float f = rect.width();
        float f3 = rect.height();
        if (f1 > f2)
        {
            f = f3 / f2;
        } else
        if (f2 > f1)
        {
            f /= f1;
        } else
        {
            f = f3 / f2;
        }
        Log.d("GESTURE VIEW UTIL", String.format("Scale Value : %s", new Object[] {
            Float.valueOf(f)
        }));
        return Bitmap.createScaledBitmap(bitmap, (int)(f1 * f), (int)(f2 * f), false);
    }

    public void startScaleAnimation(float f, float f1, final GestureView v)
    {
        Log.d("GESTURE VIEW UTIL", String.format("Starting Scale animation", new Object[0]));
        AnimatorSet animatorset = new AnimatorSet();
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            f, f1
        });
        valueanimator.setDuration(150L);
        valueanimator.setInterpolator(new AccelerateInterpolator());
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final GestureViewUtils this$0;
            final GestureView val$v;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                valueanimator1 = (Float)valueanimator1.getAnimatedValue();
                v.updateScaleFactor(valueanimator1.floatValue());
            }

            
            {
                this$0 = GestureViewUtils.this;
                v = gestureview;
                super();
            }
        });
        Log.d("GESTURE VIEW UTIL", String.format("Performing Scale animation", new Object[0]));
        animatorset.play(valueanimator);
        animatorset.start();
    }

    public void startTranslationAnimation(Point point, Point point1, final GestureView v)
    {
        float af[] = new float[2];
        float af1[] = new float[2];
        AnimatorSet animatorset = new AnimatorSet();
        ValueAnimator valueanimator = new ValueAnimator();
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.cubicTo(point.x, point.y, point1.x, point1.y, point1.x, point1.y);
        point = new PathMeasure(path, false);
        point1 = new Point[(int)point.getLength()];
        int j = (int)point.getLength();
        Log.d("GESTURE VIEW UTIL", String.format("Points Length: %s", new Object[] {
            Float.valueOf(point.getLength())
        }));
        for (int i = 0; i < j; i++)
        {
            point.getPosTan(i, af, af1);
            point1[i] = new Point();
            point1[i].x = (int)af[0];
            point1[i].y = (int)af[1];
        }

        Log.d("GESTURE VIEW UTIL", String.format("Starting translation animation", new Object[0]));
        valueanimator.setObjectValues(point1);
        valueanimator.setDuration(150L);
        valueanimator.setInterpolator(new AccelerateInterpolator());
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final GestureViewUtils this$0;
            final GestureView val$v;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                valueanimator1 = (Point)valueanimator1.getAnimatedValue();
                v.updateTranslation(valueanimator1);
            }

            
            {
                this$0 = GestureViewUtils.this;
                v = gestureview;
                super();
            }
        });
        valueanimator.setEvaluator(new TypeEvaluator() {

            final GestureViewUtils this$0;

            public Point evaluate(float f, Point point2, Point point3)
            {
                return point3;
            }

            public volatile Object evaluate(float f, Object obj, Object obj1)
            {
                return evaluate(f, (Point)obj, (Point)obj1);
            }

            
            {
                this$0 = GestureViewUtils.this;
                super();
            }
        });
        Log.d("GESTURE VIEW UTIL", String.format("Points Length : %s", new Object[] {
            Integer.valueOf(point1.length)
        }));
        if (point1.length > 0)
        {
            animatorset.play(valueanimator);
            animatorset.start();
        }
    }
}

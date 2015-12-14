// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class PointCloud
{
    static class Point
    {

        float radius;
        float x;
        float y;

        public Point(float f, float f1, float f2)
        {
            x = f;
            y = f1;
            radius = f2;
        }
    }

    public static class WaveManager
    {

        public static final float DEFAULT_WIDTH = 200F;
        private float alpha;
        private float radius;
        private WaveType type;
        private float width;

        public float getAlpha()
        {
            return alpha;
        }

        public float getRadius()
        {
            return radius;
        }

        public WaveType getType()
        {
            return type;
        }

        public void setAlpha(float f)
        {
            alpha = f;
        }

        public void setRadius(float f)
        {
            radius = f;
        }

        public void setType(WaveType wavetype)
        {
            type = wavetype;
        }




        public WaveManager()
        {
            radius = 50F;
            width = 200F;
            alpha = 0.0F;
            type = WaveType.Circle;
        }
    }

    static final class WaveType extends Enum
    {

        private static final WaveType $VALUES[];
        public static final WaveType Circle;
        public static final WaveType Ellipse;
        public static final WaveType Line;

        public static WaveType valueOf(String s)
        {
            return (WaveType)Enum.valueOf(com/aviary/android/feather/sdk/widget/PointCloud$WaveType, s);
        }

        public static WaveType[] values()
        {
            return (WaveType[])$VALUES.clone();
        }

        static 
        {
            Circle = new WaveType("Circle", 0);
            Line = new WaveType("Line", 1);
            Ellipse = new WaveType("Ellipse", 2);
            $VALUES = (new WaveType[] {
                Circle, Line, Ellipse
            });
        }

        private WaveType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int INNER_POINTS = 8;
    private static final int INNER_POINTS_ELLIPSE = 60;
    private static final float MAX_POINT_SIZE = 4F;
    private static final float MIN_POINT_SIZE = 2F;
    private static final float PI = 3.141593F;
    private static final String TAG = "PointCloud";
    private static float mEllipseOffsetX;
    private static float mEllipseOffsetY;
    float mAxisRatio;
    private float mCenterX;
    private float mCenterY;
    private Drawable mDrawable;
    float mInnerMajor;
    float mInnerMinor;
    boolean mIsHorizontalEllipse;
    private float mOuterRadius;
    private Paint mPaint;
    private ArrayList mPointCloud1;
    private ArrayList mPointCloud2;
    private ArrayList mPointCloud3;
    private float mRotation;
    private float mScale;
    public WaveManager waveManager;

    public PointCloud(Drawable drawable)
    {
        waveManager = new WaveManager();
        mPointCloud1 = new ArrayList();
        mPointCloud2 = new ArrayList();
        mPointCloud3 = new ArrayList();
        mRotation = 0.0F;
        mScale = 1.0F;
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
        mPaint.setColor(Color.rgb(255, 255, 255));
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mDrawable = drawable;
        if (mDrawable != null)
        {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public static double ellipseCircumference(double d, double d1)
    {
        return 3.1415926535897931D * ((d + d1) * 3D - Math.sqrt((3D * d + d1) * (3D * d1 + d)));
    }

    private static float hypot(float f, float f1)
    {
        return FloatMath.sqrt(f * f + f1 * f1);
    }

    private float interp(float f, float f1, float f2)
    {
        return (f1 - f) * f2 + f;
    }

    private static float max(float f, float f1)
    {
        if (f > f1)
        {
            return f;
        } else
        {
            return f1;
        }
    }

    public void draw(Canvas canvas)
    {
        if (waveManager.getAlpha() <= 0.0F)
        {
            return;
        }
        Object obj = waveManager.getType();
        int l = canvas.save(1);
        canvas.scale(mScale, mScale, mCenterX, mCenterY);
        if (obj == WaveType.Line)
        {
            canvas.rotate(mRotation, mCenterX, mCenterY);
            obj = mPointCloud2;
            int i = 0;
            while (i < ((ArrayList) (obj)).size()) 
            {
                Point point = (Point)((ArrayList) (obj)).get(i);
                float f12 = interp(4F, 2.0F, point.radius / mOuterRadius);
                float f = point.x + mCenterX;
                float f3 = point.y + mCenterY;
                int i1 = getAlphaForPoint(point.radius);
                if (i1 != 0)
                {
                    if (mDrawable != null)
                    {
                        int l1 = canvas.save(1);
                        float f6 = mDrawable.getIntrinsicWidth();
                        float f9 = mDrawable.getIntrinsicHeight();
                        f12 /= 4F;
                        canvas.scale(f12, f12, f, f3);
                        canvas.translate(f - f6 * 0.5F, f3 - f9 * 0.5F);
                        mDrawable.setAlpha(i1);
                        mDrawable.draw(canvas);
                        canvas.restoreToCount(l1);
                    } else
                    {
                        mPaint.setAlpha(i1);
                        canvas.drawCircle(f, f3, f12, mPaint);
                    }
                }
                i++;
            }
        } else
        if (obj == WaveType.Ellipse)
        {
            Iterator iterator = mPointCloud3.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Point point1 = (Point)iterator.next();
                if (mDrawable != null)
                {
                    int j = canvas.save(1);
                    float f7 = interp(4F, 2.0F, point1.radius / mOuterRadius);
                    float f1 = mDrawable.getIntrinsicWidth();
                    float f4 = mDrawable.getIntrinsicHeight();
                    f7 /= 4F;
                    float f10 = point1.x;
                    float f13 = point1.y;
                    canvas.scale(f7, f7, mEllipseOffsetX + f10, mEllipseOffsetY + f13);
                    canvas.translate((f10 - f1 * 0.5F) + mEllipseOffsetX, (f13 - f4 * 0.5F) + mEllipseOffsetY);
                    int j1 = getAlphaForPoint(point1.radius);
                    mDrawable.setAlpha(j1);
                    mDrawable.draw(canvas);
                    canvas.restoreToCount(j);
                }
            } while (true);
        } else
        {
            ArrayList arraylist = mPointCloud1;
            int k = 0;
            while (k < arraylist.size()) 
            {
                Point point2 = (Point)arraylist.get(k);
                float f14 = interp(4F, 2.0F, point2.radius / mOuterRadius);
                float f2 = point2.x + mCenterX;
                float f5 = point2.y + mCenterY;
                int k1 = getAlphaForPoint(hypot(point2.x, point2.y));
                if (k1 != 0)
                {
                    if (mDrawable != null)
                    {
                        int i2 = canvas.save(1);
                        float f8 = mDrawable.getIntrinsicWidth();
                        float f11 = mDrawable.getIntrinsicHeight();
                        f14 /= 4F;
                        canvas.scale(f14, f14, f2, f5);
                        canvas.translate(f2 - f8 * 0.5F, f5 - f11 * 0.5F);
                        mDrawable.setAlpha(k1);
                        mDrawable.draw(canvas);
                        canvas.restoreToCount(i2);
                    } else
                    {
                        mPaint.setAlpha(k1);
                        canvas.drawCircle(f2, f5, f14, mPaint);
                    }
                }
                k++;
            }
        }
        canvas.restoreToCount(l);
    }

    public int getAlphaForPoint(float f)
    {
        float f1;
        f1 = f - waveManager.radius;
        f = 0.0F;
        if (f1 <= 0.0F) goto _L2; else goto _L1
_L1:
        if (f1 < waveManager.width * 0.5F)
        {
            f = FloatMath.cos((0.7853982F * f1) / (waveManager.width * 0.5F));
            f = waveManager.alpha * max(0.0F, (float)Math.pow(f, 20D));
        }
_L4:
        return (int)(255F * f);
_L2:
        if (f1 > -(waveManager.width * 0.5F))
        {
            f = FloatMath.cos((0.7853982F * f1) / (waveManager.width * 0.5F));
            f = waveManager.alpha * max(0.0F, (float)Math.pow(f, 20D));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public float getScale()
    {
        return mScale;
    }

    public void makeEllipseCloud(RectF rectf, RectF rectf1)
    {
        float f1 = rectf.width() / 2.0F;
        float f2 = rectf.height() / 2.0F;
        double d = ellipseCircumference(f1, f2);
        float f3;
        int k;
        if (f1 > f2)
        {
            mInnerMinor = f2;
            mInnerMajor = f1;
            mIsHorizontalEllipse = true;
        } else
        {
            mInnerMinor = f1;
            mInnerMajor = f2;
            mIsHorizontalEllipse = false;
        }
        mAxisRatio = mInnerMinor / mInnerMajor;
        mOuterRadius = Math.max(rectf1.width() / 2.0F, rectf1.height() / 2.0F);
        mPointCloud3.clear();
        f3 = (float)d / 60F;
        k = Math.round((rectf1.height() - rectf.height()) / f3);
        for (int i = 0; i < k; i++)
        {
            float f = (float)i * f3;
            float f4 = f1 + f;
            float f5 = f2 + f;
            int l = (int)(ellipseCircumference(f4, f5) / (double)f3);
            f = 1.570796F;
            float f6 = (float)(6.2831853071795862D / (double)l);
            for (int j = 0; j < l; j++)
            {
                float f7 = FloatMath.cos(f);
                float f8 = FloatMath.sin(f);
                mPointCloud3.add(new Point(f7 * f4 + f1, f8 * f5 + f2, Math.max(f4, f5)));
                f += f6;
            }

        }

    }

    public void makePointCloud(float f, float f1, RectF rectf)
    {
        if (f == 0.0F)
        {
            Log.w("PointCloud", "Must specify an inner radius");
        } else
        {
            mOuterRadius = f1;
            mPointCloud1.clear();
            f1 -= f;
            float f4 = (6.283185F * f) / 8F;
            int i1 = Math.round(f1 / f4);
            float f5 = f1 / (float)i1;
            f1 = f;
            for (int i = 0; i <= i1;)
            {
                int j1 = (int)((6.283185F * f1) / f4);
                float f2 = 1.570796F;
                float f6 = 6.283185F / (float)j1;
                for (int k = 0; k < j1; k++)
                {
                    float f7 = FloatMath.cos(f2);
                    float f8 = FloatMath.sin(f2);
                    f2 += f6;
                    mPointCloud1.add(new Point(f1 * f7, f1 * f8, f1));
                }

                i++;
                f1 += f5;
            }

            mPointCloud2.clear();
            f1 = Math.max(rectf.width(), rectf.height());
            int j = 0;
            while (j <= i1) 
            {
                int k1 = (int)(f1 / ((interp(4F, 2.0F, f / mOuterRadius) / 2.0F) * f4));
                for (int l = 0; l <= k1; l++)
                {
                    float f3 = -f1 / 2.0F + (f1 / (float)k1) * (float)l;
                    mPointCloud2.add(new Point(f, f3, f));
                    mPointCloud2.add(new Point(-f, f3, f));
                }

                j++;
                f += f5;
            }
        }
    }

    public void setCenter(float f, float f1)
    {
        mCenterX = f;
        mCenterY = f1;
    }

    public void setEllipseOffset(float f, float f1)
    {
        mEllipseOffsetX = f;
        mEllipseOffsetY = f1;
    }

    public void setRotation(float f)
    {
        mRotation = f;
    }

    public void setScale(float f)
    {
        mScale = f;
    }
}

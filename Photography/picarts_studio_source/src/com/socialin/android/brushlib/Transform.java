// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.NoProGuard;
import com.socialin.android.brushlib.view.Camera;
import java.io.Serializable;

// Referenced classes of package com.socialin.android.brushlib:
//            SimpleTransform, MappedTransform

public abstract class Transform
    implements NoProGuard, Serializable, Cloneable
{

    public static final float DEFAULT_CX = 0F;
    public static final float DEFAULT_CY = 0F;
    public static final float DEFAULT_ROTATION = 0F;
    public static final float DEFAULT_SX = 1F;
    public static final float DEFAULT_SY = 1F;
    private static final PointF leftBottomPoint = new PointF();
    private static final PointF leftTopPoint = new PointF();
    private static final PointF rightBottomPoint = new PointF();
    private static final PointF rightTopPoint = new PointF();
    private static final long serialVersionUID = 0x469725652f8e268fL;

    public Transform()
    {
    }

    public static SimpleTransform copy(Transform transform)
    {
        return new SimpleTransform(transform.getCx(), transform.getCy(), transform.getSx(), transform.getSy(), transform.getRotation());
    }

    public static SimpleTransform create(float f, float f1, float f2, float f3, float f4)
    {
        return new SimpleTransform(f, f1, f2, f3, f4);
    }

    public static SimpleTransform createDefault()
    {
        return new SimpleTransform(0.0F, 0.0F, 1.0F, 1.0F, 0.0F);
    }

    public static Transform createMapped(Transform transform, Camera camera)
    {
        return new MappedTransform(transform, camera);
    }

    public static void reverseRotatePointF(PointF pointf, float f, float f1, float f2)
    {
        pointf.x = pointf.x - f1;
        pointf.y = pointf.y - f2;
        f = (float)(Math.atan2(pointf.y, pointf.x) - ((double)f * 3.1415926535897931D) / 180D);
        float f3 = (float)Math.sqrt(pointf.x * pointf.x + pointf.y * pointf.y);
        pointf.x = (float)((double)f3 * Math.cos(f)) + f1;
        double d = f3;
        pointf.y = (float)(Math.sin(f) * d) + f2;
    }

    public static void rotatePointF(PointF pointf, PointF pointf1, float f)
    {
        pointf1.x = pointf.x;
        pointf1.y = pointf.y;
        f = (float)(Math.atan2(pointf1.y, pointf1.x) + ((double)f * 3.1415926535897931D) / 180D);
        float f1 = (float)Math.sqrt(pointf1.x * pointf1.x + pointf1.y * pointf1.y);
        pointf1.x = (float)((double)f1 * Math.cos(f));
        double d = f1;
        pointf1.y = (float)(Math.sin(f) * d);
    }

    public static void rotateRectF(RectF rectf, RectF rectf1, float f)
    {
        leftTopPoint.set(rectf.left, rectf.top);
        rightTopPoint.set(rectf.right, rectf.top);
        leftBottomPoint.set(rectf.left, rectf.bottom);
        rightBottomPoint.set(rectf.right, rectf.bottom);
        rotatePointF(leftTopPoint, leftTopPoint, f);
        rotatePointF(rightTopPoint, rightTopPoint, f);
        rotatePointF(leftBottomPoint, leftBottomPoint, f);
        rotatePointF(rightBottomPoint, rightBottomPoint, f);
        rectf1.left = Math.min(Math.min(leftTopPoint.x, leftBottomPoint.x), Math.min(rightTopPoint.x, rightBottomPoint.x));
        rectf1.right = Math.max(Math.max(leftTopPoint.x, leftBottomPoint.x), Math.max(rightTopPoint.x, rightBottomPoint.x));
        rectf1.top = Math.min(Math.min(leftTopPoint.y, leftBottomPoint.y), Math.min(rightTopPoint.y, rightBottomPoint.y));
        rectf1.bottom = Math.max(Math.max(leftTopPoint.y, leftBottomPoint.y), Math.max(rightTopPoint.y, rightBottomPoint.y));
    }

    public final void apply(Canvas canvas)
    {
        canvas.translate(getCx(), getCy());
        canvas.rotate(getRotation());
        canvas.scale(getSx(), getSy());
    }

    public abstract Transform clone();

    public volatile Object clone()
    {
        return clone();
    }

    public abstract float getCx();

    public abstract float getCy();

    public abstract float getRotation();

    public abstract float getSx();

    public abstract float getSy();

    public final void mapPoint(PointF pointf)
    {
        mapPoint(pointf, pointf);
    }

    public final void mapPoint(PointF pointf, PointF pointf1)
    {
        pointf1.x = pointf.x * getSx();
        pointf1.y = pointf.y * getSy();
        float f = (float)(Math.atan2(pointf1.y, pointf1.x) + ((double)getRotation() * 3.1415926535897931D) / 180D);
        float f1 = (float)Math.sqrt(pointf1.x * pointf1.x + pointf1.y * pointf1.y);
        pointf1.x = (float)((double)f1 * Math.cos(f) + (double)getCx());
        double d = f1;
        pointf1.y = (float)(Math.sin(f) * d + (double)getCy());
    }

    public final void mapRect(RectF rectf)
    {
        mapRect(rectf, rectf);
    }

    public final void mapRect(RectF rectf, RectF rectf1)
    {
        leftTopPoint.set(rectf.left, rectf.top);
        rightTopPoint.set(rectf.right, rectf.top);
        leftBottomPoint.set(rectf.left, rectf.bottom);
        rightBottomPoint.set(rectf.right, rectf.bottom);
        mapPoint(leftTopPoint);
        mapPoint(rightTopPoint);
        mapPoint(leftBottomPoint);
        mapPoint(rightBottomPoint);
        rectf1.left = Math.min(Math.min(leftTopPoint.x, leftBottomPoint.x), Math.min(rightTopPoint.x, rightBottomPoint.x));
        rectf1.right = Math.max(Math.max(leftTopPoint.x, leftBottomPoint.x), Math.max(rightTopPoint.x, rightBottomPoint.x));
        rectf1.top = Math.min(Math.min(leftTopPoint.y, leftBottomPoint.y), Math.min(rightTopPoint.y, rightBottomPoint.y));
        rectf1.bottom = Math.max(Math.max(leftTopPoint.y, leftBottomPoint.y), Math.max(rightTopPoint.y, rightBottomPoint.y));
    }

    public final void reverseApply(Canvas canvas)
    {
        canvas.scale(1.0F / getSx(), 1.0F / getSy());
        canvas.rotate(-getRotation());
        canvas.translate(-getCx(), -getCy());
    }

    public final void reverseMapPoint(PointF pointf)
    {
        reverseMapPoint(pointf, pointf);
    }

    public final void reverseMapPoint(PointF pointf, PointF pointf1)
    {
        pointf1.x = pointf.x - getCx();
        pointf1.y = pointf.y - getCy();
        float f = (float)(Math.atan2(pointf1.y, pointf1.x) - ((double)getRotation() * 3.1415926535897931D) / 180D);
        float f1 = (float)Math.sqrt(pointf1.x * pointf1.x + pointf1.y * pointf1.y);
        pointf1.x = (float)(((double)f1 * Math.cos(f)) / (double)getSx());
        double d = f1;
        pointf1.y = (float)((Math.sin(f) * d) / (double)getSy());
    }

    public final void reverseMapRect(RectF rectf, RectF rectf1)
    {
        rectf1.left = rectf.left - getCx();
        rectf1.top = rectf.top - getCy();
        float f = (float)(Math.atan2(rectf1.top, rectf1.left) - ((double)getRotation() * 3.1415926535897931D) / 180D);
        float f1 = (float)Math.sqrt(rectf1.left * rectf1.left + rectf1.top * rectf1.top);
        rectf1.left = (float)(((double)f1 * Math.cos(f)) / (double)getSx());
        double d = f1;
        rectf1.top = (float)((Math.sin(f) * d) / (double)getSy());
        rectf1.right = rectf.right - getCx();
        rectf1.bottom = rectf.bottom - getCy();
        f = (float)(Math.atan2(rectf1.bottom, rectf1.right) - ((double)getRotation() * 3.1415926535897931D) / 180D);
        f1 = (float)Math.sqrt(rectf1.right * rectf1.right + rectf1.bottom * rectf1.bottom);
        rectf1.right = (float)(((double)f1 * Math.cos(f)) / (double)getSx());
        d = f1;
        rectf1.bottom = (float)((Math.sin(f) * d) / (double)getSy());
    }

    public final int saveAndApply(Canvas canvas)
    {
        int i = canvas.save();
        apply(canvas);
        return i;
    }

    public final int saveAndReverseApply(Canvas canvas)
    {
        int i = canvas.save();
        reverseApply(canvas);
        return i;
    }

    public void set(Transform transform)
    {
        setPosition(transform.getCx(), transform.getCy());
        setScale(transform.getSx(), transform.getSy());
        setRotation(transform.getRotation());
    }

    public abstract Transform setCx(float f);

    public abstract Transform setCy(float f);

    public final Transform setPosition(float f, float f1)
    {
        return setCx(f).setCy(f1);
    }

    public final Transform setPosition(PointF pointf)
    {
        return setCx(pointf.x).setCy(pointf.y);
    }

    public abstract Transform setRotation(float f);

    public final Transform setScale(float f)
    {
        return setScale(f, f);
    }

    public final Transform setScale(float f, float f1)
    {
        return setSx(f).setSy(f1);
    }

    public abstract Transform setSx(float f);

    public abstract Transform setSy(float f);

    public String toString()
    {
        return (new StringBuilder("Translate [")).append(getCx()).append(", ").append(getCy()).append("], Scale [").append(getSx()).append(", ").append(getSy()).append("]").toString();
    }

}

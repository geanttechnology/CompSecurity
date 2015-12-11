// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.gui.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.View;
import jumiomobile.cs;
import jumiomobile.nq;
import jumiomobile.nr;

public class TemplateMatcherDrawView extends View
{

    private static final int ANIMATION_DURATION = 150;
    private static final float OUTLINE_MARGIN_PERCENTAGE = 0.02F;
    private static final int OVERLAY_GREEN_FILLING = Color.parseColor("#4D97BE0D");
    private static final int OVERLAY_GREEN_OUTLINE = Color.parseColor("#B397BE0D");
    private static final int OVERLAY_RED_FILLING = Color.parseColor("#4DBE0D0D");
    private static final int OVERLAY_RED_OUTLINE = Color.parseColor("#B3BE0D0D");
    private MyPointF curBL;
    private MyPointF curBR;
    private MyPointF curTL;
    private MyPointF curTR;
    private MyPointF endBL;
    private MyPointF endBR;
    private MyPointF endTL;
    private MyPointF endTR;
    public boolean mAnimationRunning;
    private PointF mTemplateCenter;
    private Paint paint;
    private Paint paintOutline;
    private Path targetPolygon;

    public TemplateMatcherDrawView(Context context)
    {
        super(context);
        targetPolygon = null;
        paintOutline = null;
        paint = new Paint();
        paint.setColor(OVERLAY_GREEN_FILLING);
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setDither(true);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setPathEffect(new CornerPathEffect(10F));
        paint.setAntiAlias(true);
        paintOutline = new Paint();
        paintOutline.setColor(OVERLAY_GREEN_OUTLINE);
        paintOutline.setStyle(android.graphics.Paint.Style.STROKE);
        paintOutline.setStrokeWidth(10F);
        paintOutline.setDither(true);
        paintOutline.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paintOutline.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paintOutline.setPathEffect(new CornerPathEffect(10F));
        paintOutline.setAntiAlias(true);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

    private void startAnimation()
    {
        AnimatorSet animatorset = new AnimatorSet();
        Object obj = PropertyValuesHolder.ofFloat("x", new float[] {
            curTL.x, endTL.x
        });
        Object obj1 = PropertyValuesHolder.ofFloat("y", new float[] {
            curTL.y, endTL.y
        });
        obj = ObjectAnimator.ofPropertyValuesHolder(curTL, new PropertyValuesHolder[] {
            obj, obj1
        });
        obj1 = PropertyValuesHolder.ofFloat("x", new float[] {
            curTR.x, endTR.x
        });
        Object obj2 = PropertyValuesHolder.ofFloat("y", new float[] {
            curTR.y, endTR.y
        });
        obj1 = ObjectAnimator.ofPropertyValuesHolder(curTR, new PropertyValuesHolder[] {
            obj1, obj2
        });
        obj2 = PropertyValuesHolder.ofFloat("x", new float[] {
            curBR.x, endBR.x
        });
        Object obj3 = PropertyValuesHolder.ofFloat("y", new float[] {
            curBR.y, endBR.y
        });
        obj2 = ObjectAnimator.ofPropertyValuesHolder(curBR, new PropertyValuesHolder[] {
            obj2, obj3
        });
        obj3 = PropertyValuesHolder.ofFloat("x", new float[] {
            curBL.x, endBL.x
        });
        PropertyValuesHolder propertyvaluesholder = PropertyValuesHolder.ofFloat("y", new float[] {
            curBL.y, endBL.y
        });
        obj3 = ObjectAnimator.ofPropertyValuesHolder(curBL, new PropertyValuesHolder[] {
            obj3, propertyvaluesholder
        });
        ((ObjectAnimator) (obj3)).addUpdateListener(new nq(this));
        animatorset.playTogether(new Animator[] {
            obj, obj1, obj2, obj3
        });
        animatorset.setDuration(150L);
        animatorset.addListener(new nr(this));
        animatorset.start();
    }

    private boolean startValuesSet()
    {
        return curTL != null && curTR != null && curBR != null && curBL != null;
    }

    public void doDraw(Canvas canvas)
    {
        if (startValuesSet())
        {
            targetPolygon = new Path();
            targetPolygon.moveTo(curTL.x * 0.98F, curTL.y * 0.98F);
            targetPolygon.lineTo(curTR.x * 1.02F, curTR.y * 0.98F);
            targetPolygon.lineTo(curBR.x * 1.02F, curBR.y * 1.02F);
            targetPolygon.lineTo(curBL.x * 0.98F, curBL.y * 1.02F);
            targetPolygon.lineTo(curTL.x * 0.98F, curTL.y * 0.98F);
            targetPolygon.lineTo(curTR.x * 1.02F, curTR.y * 0.98F);
            canvas.drawPath(targetPolygon, paint);
            canvas.drawPath(targetPolygon, paintOutline);
        }
        if (cs.a() && mTemplateCenter != null)
        {
            Paint paint1 = new Paint();
            paint1.setColor(0xff0000ff);
            paint1.setAntiAlias(true);
            paint1.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(mTemplateCenter.x, mTemplateCenter.y, 10F, paint1);
        }
    }

    public void onDraw(Canvas canvas)
    {
        doDraw(canvas);
        super.onDraw(canvas);
    }

    public void setBorderColor(int i)
    {
        if (i == 0xff00ff00)
        {
            paint.setColor(OVERLAY_GREEN_FILLING);
            paintOutline.setColor(OVERLAY_GREEN_OUTLINE);
            return;
        } else
        {
            paint.setColor(OVERLAY_RED_FILLING);
            paintOutline.setColor(OVERLAY_RED_OUTLINE);
            return;
        }
    }

    public void setPolygon(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4)
    {
        mTemplateCenter = pointf4;
        if (pointf == null || pointf1 == null || pointf2 == null || pointf3 == null)
        {
            curTR = null;
            curTL = null;
            curBR = null;
            curBL = null;
            postInvalidate();
            return;
        }
        endTL = new MyPointF(pointf);
        endTR = new MyPointF(pointf1);
        endBR = new MyPointF(pointf3);
        endBL = new MyPointF(pointf2);
        if (!startValuesSet())
        {
            curTR = new MyPointF(pointf1);
            curTL = new MyPointF(pointf);
            curBR = new MyPointF(pointf3);
            curBL = new MyPointF(pointf2);
        }
        if (!mAnimationRunning)
        {
            startAnimation();
        }
        postInvalidate();
    }


    private class MyPointF extends PointF
    {

        final TemplateMatcherDrawView this$0;

        public void setX(float f)
        {
            set(f, y);
        }

        public void setY(float f)
        {
            set(x, f);
        }

        public MyPointF(PointF pointf)
        {
            this$0 = TemplateMatcherDrawView.this;
            super(pointf.x, pointf.y);
        }
    }

}

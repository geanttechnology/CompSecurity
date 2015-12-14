// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.util.l;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            LineOverlay

public class ArrowOverlay extends LineOverlay
{

    private static final long serialVersionUID = 1L;
    private transient Path arrowPath;
    private transient RectF bounds;
    private transient PointF point1;
    private transient PointF point2;
    private transient PointF point3;

    public ArrowOverlay()
    {
        arrowPath = new Path();
        point1 = new PointF();
        point2 = new PointF();
        point3 = new PointF();
        bounds = new RectF();
    }

    private float getStrokeWidth(float f, float f1)
    {
        return (3F + (12F * f) / 20F) * f1;
    }

    protected void drawWithoutTransform(Canvas canvas)
    {
        if (arrowPath == null)
        {
            arrowPath = new Path();
        }
        if (point1 == null)
        {
            point1 = new PointF();
        }
        if (point2 == null)
        {
            point2 = new PointF();
        }
        if (point3 == null)
        {
            point3 = new PointF();
        }
        paint.setStrokeWidth(((12F * params.getSize()) / 20F + 3F) * scale);
        float f1 = l.a(endPoint, startPoint);
        float f = scale * (params.getSize() * 2.0F + 10F);
        float f2 = f / 3F;
        l.a(startPoint.x, startPoint.y, endPoint.x, endPoint.y, f1 - f2, point1);
        f1 = (float)Math.toDegrees(Math.atan2(startPoint.y - endPoint.y, startPoint.x - endPoint.x));
        f2 = f1 + 30F;
        point2.x = (float)((double)endPoint.x + (double)f * Math.cos((float)Math.toRadians(f2)));
        point2.y = (float)((double)endPoint.y + (double)f * Math.sin((float)Math.toRadians(f2)));
        l.b(point1.x, point1.y, point2.x, point2.y, 0.2F, point3);
        arrowPath.rewind();
        arrowPath.moveTo(startPoint.x, startPoint.y);
        arrowPath.lineTo(point3.x, point3.y);
        arrowPath.lineTo(point2.x, point2.y);
        arrowPath.lineTo(endPoint.x, endPoint.y);
        f1 -= 30F;
        point2.x = (float)((double)endPoint.x + (double)f * Math.cos((float)Math.toRadians(f1)));
        point2.y = (float)((double)endPoint.y + (double)f * Math.sin((float)Math.toRadians(f1)));
        l.b(point2.x, point2.y, point1.x, point1.y, 0.8F, point3);
        arrowPath.lineTo(point2.x, point2.y);
        arrowPath.lineTo(point3.x, point3.y);
        arrowPath.lineTo(startPoint.x, startPoint.y);
        canvas.drawPath(arrowPath, paint);
    }

    public float getOrigHeight()
    {
        return 0.0F;
    }

    public float getOrigWidth()
    {
        return 0.0F;
    }

    public RectF getTransformedBounds(boolean flag)
    {
        if (bounds == null)
        {
            bounds = new RectF();
        }
        float f1 = l.a(endPoint, startPoint);
        float f = params.getSize() * 2.0F + 10F;
        float f2 = f / 3F;
        l.a(startPoint.x, startPoint.y, endPoint.x, endPoint.y, f1 - f2, point1);
        float f5 = (float)Math.toDegrees(Math.atan2(startPoint.y - endPoint.y, startPoint.x - endPoint.x));
        float f4 = f5 + 30F;
        f1 = endPoint.x;
        f2 = (float)Math.cos((float)Math.toRadians(f4));
        float f3 = endPoint.y;
        f4 = (float)Math.sin((float)Math.toRadians(f4));
        float f8 = f5 - 30F;
        f5 = endPoint.x;
        float f6 = (float)Math.cos((float)Math.toRadians(f8));
        float f7 = endPoint.y;
        f8 = (float)Math.sin((float)Math.toRadians(f8));
        bounds.set(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        bounds.sort();
        bounds.union(f1 + f2 * f, f4 * f + f3);
        bounds.union(f5 + f6 * f, f8 * f + f7);
        f = getStrokeWidth(params.getSize(), scale);
        bounds.inset(-f / 2.0F, -f / 2.0F);
        return bounds;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            Overlay

public class LineOverlay extends Overlay
{

    protected static final float ARROW_APLHA = 30F;
    protected static final float DEFAULT_SIZE = 6F;
    private static final String TAG = com/socialin/android/brushlib/overlay/LineOverlay.getSimpleName();
    private static final long serialVersionUID = 0xed1eefb966aeb75dL;
    private RectF bounds;
    protected transient PointF endPoint;
    protected transient Paint paint;
    protected ShapeParams params;
    protected float scale;
    protected transient PointF startPoint;

    public LineOverlay()
    {
        init();
    }

    private float getStrokeWidth(float f, float f1)
    {
        return f * f1 * 2.0F;
    }

    private void init()
    {
        paint = new Paint(1);
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        bounds = new RectF();
        startPoint = new PointF();
        endPoint = new PointF();
        setScale(1.0F);
    }

    private void initFromParams(ShapeParams shapeparams)
    {
        paint.setXfermode(shapeparams.getXfermode());
        paint.setColor(shapeparams.getColor());
        paint.setStrokeWidth(shapeparams.getSize() * scale * 2.0F);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        init();
        setScale(objectinputstream.readFloat());
        startPoint.set(objectinputstream.readFloat(), objectinputstream.readFloat());
        endPoint.set(objectinputstream.readFloat(), objectinputstream.readFloat());
        try
        {
            params = (ShapeParams)objectinputstream.readObject();
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            try
            {
                d.b(TAG, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(objectinputstream.getMessage()).toString()
                });
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                d.b(TAG, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(objectinputstream.getMessage()).toString()
                });
                return;
            }
        }
        initFromParams(params);
        return;
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.writeFloat(scale);
            objectoutputstream.writeFloat(startPoint.x);
            objectoutputstream.writeFloat(startPoint.y);
            objectoutputstream.writeFloat(endPoint.x);
            objectoutputstream.writeFloat(endPoint.y);
            objectoutputstream.writeObject(params);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(objectoutputstream.getMessage()).toString()
            });
        }
    }

    protected void drawWithoutTransform(Canvas canvas)
    {
        canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y, paint);
    }

    public a getController$442001be()
    {
        return null;
    }

    public float getOrigHeight()
    {
        return 0.0F;
    }

    public float getOrigWidth()
    {
        return 0.0F;
    }

    public ShapeParams getParams()
    {
        return params;
    }

    public RectF getTransformedBounds(boolean flag)
    {
        bounds.set(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        bounds.sort();
        bounds.inset((-getStrokeWidth(params.getSize(), scale) * 2.0F) / 2.0F, (-getStrokeWidth(params.getSize(), scale) * 2.0F) / 2.0F);
        return bounds;
    }

    public void setEndPoint(float f, float f1)
    {
        endPoint.set(f, f1);
    }

    public void setParams(ShapeParams shapeparams)
    {
        params = new ShapeParams(shapeparams);
        initFromParams(shapeparams);
    }

    public void setScale(float f)
    {
        scale = f;
    }

    public void setStartPoint(float f, float f1)
    {
        startPoint.set(f, f1);
    }

}

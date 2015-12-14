// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.controller.c;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.svg.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            Overlay

public class ShapeOverlay extends Overlay
{

    private static final String TAG = com/socialin/android/brushlib/overlay/ShapeOverlay.getSimpleName();
    private static final long serialVersionUID = 0xb21b6ca00fd629f2L;
    private transient RectF bounds;
    private int origHeight;
    private int origWidth;
    private ShapeParams params;
    private String shapeName;
    private transient Matrix transformMatrix;

    public ShapeOverlay(String s)
    {
        shapeName = s;
        init();
    }

    private void init()
    {
        origWidth = d.a(shapeName);
        origHeight = d.b(shapeName);
        transformMatrix = new Matrix();
        bounds = new RectF();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            params = (ShapeParams)objectinputstream.readObject();
            shapeName = (String)objectinputstream.readObject();
            init();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        com.socialin.android.d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(objectinputstream.getMessage()).toString()
        });
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.writeObject(params);
            objectoutputstream.writeObject(shapeName);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            objectoutputstream.printStackTrace();
        }
    }

    public void draw(Canvas canvas)
    {
        Transform transform = getTransform();
        RectF rectf = getTransformedBounds(false);
        transformMatrix.setScale(transform.getSx(), transform.getSy());
        float f;
        float f1;
        if (transform.getSx() > 0.0F)
        {
            f = rectf.width() / 2.0F;
        } else
        {
            f = -rectf.width() / 2.0F;
        }
        if (transform.getSy() > 0.0F)
        {
            f1 = rectf.height() / 2.0F;
        } else
        {
            f1 = -rectf.height() / 2.0F;
        }
        canvas.save();
        canvas.translate(transform.getCx(), transform.getCy());
        canvas.rotate(transform.getRotation());
        canvas.translate(-f, -f1);
        d.a(shapeName, canvas, params, transformMatrix);
        canvas.restore();
    }

    public void drawWithoutTransform(Canvas canvas)
    {
        d.a(shapeName, canvas, params);
    }

    public a getController$442001be()
    {
        return new c();
    }

    public float getOrigHeight()
    {
        return (float)origHeight;
    }

    public float getOrigWidth()
    {
        return (float)origWidth;
    }

    public ShapeParams getParams()
    {
        return params;
    }

    public String getShapeName()
    {
        return shapeName;
    }

    public RectF getTransformedBounds(boolean flag)
    {
        bounds.set(0.0F, 0.0F, d.a(shapeName), d.b(shapeName));
        RectF rectf = bounds;
        rectf.right = rectf.right * Math.abs(getTransform().getSx());
        rectf = bounds;
        rectf.left = rectf.left * Math.abs(getTransform().getSx());
        rectf = bounds;
        rectf.top = rectf.top * Math.abs(getTransform().getSy());
        rectf = bounds;
        rectf.bottom = rectf.bottom * Math.abs(getTransform().getSy());
        bounds.sort();
        if (flag)
        {
            Transform.rotateRectF(bounds, bounds, getTransform().getRotation());
        }
        return bounds;
    }

    public float getTransformedHeight()
    {
        float f1 = Math.abs(getTransform().getSy() * (float)origHeight);
        float f = f1;
        if (params != null)
        {
            f = f1 + params.getSize();
        }
        return f;
    }

    public float getTransformedWidth()
    {
        float f1 = Math.abs(getTransform().getSx() * (float)origWidth);
        float f = f1;
        if (params != null)
        {
            f = f1 + params.getSize();
        }
        return f;
    }

    public void setParams(ShapeParams shapeparams)
    {
        params = new ShapeParams(shapeparams);
    }

}

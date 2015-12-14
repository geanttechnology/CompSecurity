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
import com.socialin.android.brushlib.svg.ClipArtSvg;
import com.socialin.android.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            Overlay

public class SvgClipArtOverlay extends Overlay
{

    private static final String TAG = com/socialin/android/brushlib/overlay/SvgClipArtOverlay.getSimpleName();
    private static final long serialVersionUID = 1L;
    private RectF bounds;
    private byte data[];
    private ClipArtSvg svg;
    private Matrix transformMatrix;

    public SvgClipArtOverlay(byte abyte0[])
    {
        data = abyte0;
        init();
    }

    private void init()
    {
        transformMatrix = new Matrix();
        bounds = new RectF();
        svg = new ClipArtSvg(data);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            data = (byte[])objectinputstream.readObject();
            init();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(objectinputstream.getMessage()).toString()
        });
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.writeObject(data);
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

    public void draw(Canvas canvas)
    {
        Transform transform = getTransform();
        bounds = getTransformedBounds(false);
        transformMatrix.setScale(transform.getSx(), transform.getSy());
        float f;
        float f1;
        if (transform.getSx() > 0.0F)
        {
            f = bounds.width() / 2.0F;
        } else
        {
            f = -bounds.width() / 2.0F;
        }
        if (transform.getSy() > 0.0F)
        {
            f1 = bounds.height() / 2.0F;
        } else
        {
            f1 = -bounds.height() / 2.0F;
        }
        canvas.save();
        canvas.translate(transform.getCx(), transform.getCy());
        canvas.rotate(transform.getRotation());
        canvas.translate(-f, -f1);
        canvas.concat(transformMatrix);
        svg.drawSvg(canvas, 255, -256, true, null);
        canvas.restore();
    }

    protected void drawWithoutTransform(Canvas canvas)
    {
        svg.drawSvg(canvas, 255, -256, true, null);
    }

    public a getController$442001be()
    {
        return new c();
    }

    public float getOrigHeight()
    {
        return (float)svg.getOrigHeight();
    }

    public float getOrigWidth()
    {
        return (float)svg.getOrigWidth();
    }

    public RectF getTransformedBounds(boolean flag)
    {
        bounds.set(0.0F, 0.0F, svg.getOrigWidth(), svg.getOrigHeight());
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

}

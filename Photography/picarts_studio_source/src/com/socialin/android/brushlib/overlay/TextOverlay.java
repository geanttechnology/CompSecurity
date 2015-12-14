// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.svg.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            Overlay

public class TextOverlay extends Overlay
{

    private static final String TAG = com/socialin/android/brushlib/overlay/TextOverlay.getSimpleName();
    private static final long serialVersionUID = 0x95d6348188605bebL;
    private Paint borderPaint;
    private RectF bounds;
    private int fillColor;
    private Rect gradientBounds;
    private int gradientColor;
    private boolean hasBorder;
    private boolean hasGradient;
    private com.socialin.android.brushlib.view.DrawingView.DrawingMode mode;
    private float points[];
    private Stroke stroke;
    private Object styleData;
    private String text;
    private Paint textPaint;

    public TextOverlay(TextOverlay textoverlay)
    {
        stroke = textoverlay.stroke;
        borderPaint = textoverlay.borderPaint;
        textPaint = textoverlay.textPaint;
        text = textoverlay.text;
        hasBorder = textoverlay.hasBorder;
        styleData = textoverlay.styleData;
        hasGradient = textoverlay.hasGradient;
        fillColor = textoverlay.fillColor;
        gradientColor = textoverlay.gradientColor;
        init();
    }

    public TextOverlay(String s, Paint paint, Paint paint1, boolean flag, Object obj, boolean flag1, int i, 
            int j)
    {
        borderPaint = paint1;
        textPaint = paint;
        text = s;
        hasBorder = flag;
        styleData = obj;
        hasGradient = flag1;
        fillColor = i;
        gradientColor = j;
        init();
    }

    private void init()
    {
        gradientBounds = new Rect();
        bounds = new RectF();
        points = new float[2];
    }

    private void invokeSecureMethod(Object obj)
    {
        borderPaint = new Paint();
        textPaint = new Paint();
        Class class1 = Class.forName("com.socialin.android.photo.textart.TextArtStyle");
        try
        {
            class1.getMethod("setFillColor", new Class[] {
                Integer.TYPE
            }).invoke(class1.cast(obj), new Object[] {
                Integer.valueOf(fillColor)
            });
            Class.forName("com.socialin.android.photo.textart.TextArt").getMethod("initTextArtForDrawing", new Class[] {
                android/content/Context, class1, android/graphics/Paint, android/graphics/Paint
            }).invoke(null, new Object[] {
                d.a(), class1.cast(obj), textPaint, borderPaint
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            com.socialin.android.d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        com.socialin.android.d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((ReflectiveOperationException) (obj)).getMessage()).toString()
        });
        return;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            stroke = (Stroke)objectinputstream.readObject();
            text = (String)objectinputstream.readObject();
            hasBorder = objectinputstream.readBoolean();
            hasGradient = objectinputstream.readBoolean();
            fillColor = objectinputstream.readInt();
            gradientColor = objectinputstream.readInt();
            mode = (com.socialin.android.brushlib.view.DrawingView.DrawingMode)objectinputstream.readObject();
            styleData = objectinputstream.readObject();
            invokeSecureMethod(styleData);
            init();
            stroke.computeBounds(bounds, true);
            if (hasGradient)
            {
                setGradients(fillColor, gradientColor);
            }
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
            objectoutputstream.writeObject(stroke);
            objectoutputstream.writeObject(text);
            objectoutputstream.writeBoolean(hasBorder);
            objectoutputstream.writeBoolean(hasGradient);
            objectoutputstream.writeInt(fillColor);
            objectoutputstream.writeInt(gradientColor);
            objectoutputstream.writeObject(mode);
            objectoutputstream.writeObject(styleData);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            com.socialin.android.d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(objectoutputstream.getMessage()).toString()
            });
        }
    }

    public void drawWithoutTransform(Canvas canvas)
    {
        if (mode != null)
        {
            textPaint.setXfermode(mode.xfermode);
            borderPaint.setXfermode(mode.xfermode);
        }
        if (stroke != null)
        {
            canvas.drawTextOnPath(text, stroke.getPath(), 0.0F, 0.0F, textPaint);
            if (hasBorder)
            {
                canvas.drawTextOnPath(text, stroke.getPath(), 0.0F, 0.0F, borderPaint);
            }
        }
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

    public RectF getTransformedBounds(boolean flag)
    {
        return null;
    }

    public void setBorderPaint(Paint paint)
    {
        borderPaint = paint;
    }

    public void setGradients(int i, int j)
    {
        textPaint.getTextBounds(text, 0, text.length(), gradientBounds);
        gradientBounds.sort();
        stroke.getPosTan(0.0F, points, null);
        textPaint.setShader(new LinearGradient(points[0], points[1] - bounds.height(), points[0], points[1], i, j, android.graphics.Shader.TileMode.CLAMP));
    }

    public void setHasBorder(boolean flag)
    {
        hasBorder = flag;
    }

    public void setMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        mode = drawingmode;
    }

    public void setStroke(Stroke stroke1)
    {
        stroke = stroke1;
        stroke1.computeBounds(bounds, true);
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setTextPaint(Paint paint)
    {
        textPaint = paint;
    }

}

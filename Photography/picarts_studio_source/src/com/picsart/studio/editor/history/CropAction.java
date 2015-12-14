// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class CropAction extends EditorAction
{

    private final RectF imageRect;
    private final float imageRotation;
    private final int outputHeight;
    private final int outputWidth;
    private final RectF selectionRect;

    private CropAction(RectF rectf, RectF rectf1, float f, int i, int j)
    {
        selectionRect = rectf;
        imageRect = rectf1;
        imageRotation = f;
        outputWidth = i;
        outputHeight = j;
    }

    public static CropAction create(RectF rectf, RectF rectf1, float f, int i, int j)
    {
        return new CropAction(rectf, rectf1, f, i, j);
    }

    public static CropAction createFromJSON(JSONObject jsonobject)
    {
        RectF rectf = new RectF();
        RectF rectf1 = new RectF();
        try
        {
            rectf.left = (float)jsonobject.getDouble("sr.l");
            rectf.top = (float)jsonobject.getDouble("sr.t");
            rectf.right = (float)jsonobject.getDouble("sr.r");
            rectf.bottom = (float)jsonobject.getDouble("sr.b");
            rectf1.left = (float)jsonobject.getDouble("ir.l");
            rectf1.top = (float)jsonobject.getDouble("ir.t");
            rectf1.right = (float)jsonobject.getDouble("ir.r");
            rectf1.bottom = (float)jsonobject.getDouble("ir.b");
            jsonobject = create(rectf, rectf1, (float)jsonobject.getDouble("rot"), jsonobject.optInt("ow", -1), jsonobject.optInt("oh", -1));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    public Bitmap apply(Bitmap bitmap)
    {
        float f3 = 30F;
        float f = 1.0F;
        float f1 = imageRect.width() / (float)bitmap.getWidth();
        Bitmap bitmap1;
        Matrix matrix;
        Paint paint;
        Canvas canvas;
        int i;
        int j;
        if (outputWidth > 0 && outputHeight > 0)
        {
            j = outputWidth;
            i = outputHeight;
        } else
        {
            f = (int)Math.floor(selectionRect.width() / f1 + 0.5F);
            float f2 = (int)Math.floor(selectionRect.height() / f1 + 0.5F);
            if (f < 30F)
            {
                f1 = 30F / f;
                f2 = (int)(f2 * f1);
                f = 30F;
            } else
            {
                f1 = 1.0F;
            }
            if (f2 < 30F)
            {
                f1 = 30F / f2;
                f2 = (int)(f1 * f);
                f = f1;
                f1 = f3;
            } else
            {
                float f4 = f1;
                f1 = f2;
                f2 = f;
                f = f4;
            }
            j = (int)Math.ceil(f2);
            i = (int)Math.ceil(f1);
        }
        bitmap1 = Bitmap.createBitmap(j, i, android.graphics.Bitmap.Config.ARGB_8888);
        matrix = new Matrix();
        matrix.setRectToRect(selectionRect, new RectF(0.0F, 0.0F, j, i), android.graphics.Matrix.ScaleToFit.CENTER);
        matrix.postScale(f, f);
        paint = new Paint(2);
        canvas = new Canvas(bitmap1);
        canvas.concat(matrix);
        canvas.rotate(imageRotation, imageRect.centerX(), imageRect.centerY());
        canvas.drawBitmap(bitmap, null, imageRect, paint);
        return bitmap1;
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("sr.l", selectionRect.left);
            jsonobject.put("sr.t", selectionRect.top);
            jsonobject.put("sr.r", selectionRect.right);
            jsonobject.put("sr.b", selectionRect.bottom);
            jsonobject.put("ir.l", imageRect.left);
            jsonobject.put("ir.t", imageRect.top);
            jsonobject.put("ir.r", imageRect.right);
            jsonobject.put("ir.b", imageRect.bottom);
            jsonobject.put("rot", imageRotation);
            jsonobject.put("ow", outputWidth);
            jsonobject.put("oh", outputHeight);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public Point getOutSize(Point point)
    {
        float f2 = 30F;
        float f = imageRect.width() / (float)point.x;
        int i;
        int j;
        if (outputWidth > 0 && outputHeight > 0)
        {
            j = outputWidth;
            i = outputHeight;
        } else
        {
            float f4 = (int)Math.floor(selectionRect.width() / f + 0.5F);
            float f5 = (int)Math.floor(selectionRect.height() / f + 0.5F);
            float f1 = f5;
            f = f4;
            if (f4 < 30F)
            {
                f1 = (int)(f5 * (30F / f4));
                f = 30F;
            }
            if (f1 < 30F)
            {
                f1 = (int)((30F / f1) * f);
                f = f2;
            } else
            {
                float f3 = f;
                f = f1;
                f1 = f3;
            }
            j = (int)Math.ceil(f1);
            i = (int)Math.ceil(f);
        }
        point.set(j, i);
        return point;
    }

    public boolean isReversible()
    {
        return false;
    }

    public boolean isSourceDependent()
    {
        return true;
    }

    public Bitmap reverseApply(Bitmap bitmap)
    {
        throw new UnsupportedOperationException("Reverse applying is not supported");
    }
}

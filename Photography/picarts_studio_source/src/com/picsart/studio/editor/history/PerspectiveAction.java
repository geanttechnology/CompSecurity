// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import com.socialin.android.util.Geom;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class PerspectiveAction extends EditorAction
{

    private Camera perspectiveCamera;
    private Matrix perspectiveMatrix;
    private final float rotX;
    private final float rotY;
    private float srcQuad[];
    private Matrix tmpMatrix;
    private float tmpQuad[];
    private RectF tmpRect;

    private PerspectiveAction(float f, float f1)
    {
        perspectiveMatrix = new Matrix();
        tmpMatrix = new Matrix();
        tmpQuad = new float[8];
        srcQuad = new float[8];
        tmpRect = new RectF();
        rotX = f;
        rotY = f1;
        perspectiveCamera = new Camera();
    }

    private void correctInvalidValues(float af[])
    {
        if (af[0] > 0.0F)
        {
            af[0] = -af[0];
        }
        if (af[1] > 0.0F)
        {
            af[1] = -af[1];
        }
        if (af[2] < 0.0F)
        {
            af[2] = -af[2];
        }
        if (af[3] > 0.0F)
        {
            af[3] = -af[3];
        }
        if (af[4] < 0.0F)
        {
            af[4] = -af[4];
        }
        if (af[5] < 0.0F)
        {
            af[5] = -af[5];
        }
        if (af[6] > 0.0F)
        {
            af[6] = -af[6];
        }
        if (af[7] < 0.0F)
        {
            af[7] = -af[7];
        }
    }

    public static PerspectiveAction create(float f, float f1)
    {
        return new PerspectiveAction(f, f1);
    }

    public static PerspectiveAction createFromJSON(JSONObject jsonobject)
    {
        float f1 = 0.0F;
        double d = jsonobject.getDouble("rotX");
        float f = (float)d;
        d = jsonobject.getDouble("rotY");
        f1 = (float)d;
_L2:
        return create(f, f1);
        jsonobject;
        f = 0.0F;
_L3:
        jsonobject.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject;
          goto _L3
    }

    public Bitmap apply(Bitmap bitmap)
    {
        Object obj = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        RectF rectf = new RectF();
        float f;
        float f1;
        Paint paint;
        Canvas canvas;
        if (bitmap.getWidth() < bitmap.getHeight())
        {
            rectf.set(0.0F, 0.0F, ((float)bitmap.getWidth() * 2048F) / (float)bitmap.getHeight(), 2048F);
        } else
        {
            rectf.set(0.0F, 0.0F, 2048F, ((float)bitmap.getHeight() * 2048F) / (float)bitmap.getWidth());
        }
        f = rectf.width() / 2.0F;
        f1 = rectf.height() / 2.0F;
        srcQuad[0] = -f;
        srcQuad[1] = -f1;
        srcQuad[2] = f;
        srcQuad[3] = -f1;
        srcQuad[4] = f;
        srcQuad[5] = f1;
        srcQuad[6] = -f;
        srcQuad[7] = f1;
        perspectiveCamera.save();
        perspectiveCamera.setLocation(0.0F, 0.0F, -8F);
        perspectiveCamera.rotate(-rotX, -rotY, 0.0F);
        perspectiveCamera.getMatrix(perspectiveMatrix);
        perspectiveCamera.restore();
        f = (float)bitmap.getWidth() / (float)bitmap.getHeight();
        perspectiveMatrix.mapPoints(tmpQuad, srcQuad);
        correctInvalidValues(tmpQuad);
        Geom.a(tmpRect, tmpQuad, f);
        tmpMatrix.setRectToRect(tmpRect, ((RectF) (obj)), android.graphics.Matrix.ScaleToFit.CENTER);
        perspectiveMatrix.postConcat(tmpMatrix);
        obj = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        paint = new Paint(2);
        canvas = new Canvas(((Bitmap) (obj)));
        canvas.concat(perspectiveMatrix);
        canvas.translate(-rectf.width() / 2.0F, -rectf.height() / 2.0F);
        canvas.scale(rectf.width() / (float)bitmap.getWidth(), rectf.height() / (float)bitmap.getHeight());
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return ((Bitmap) (obj));
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("rotX", rotX);
            jsonobject.put("rotY", rotY);
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

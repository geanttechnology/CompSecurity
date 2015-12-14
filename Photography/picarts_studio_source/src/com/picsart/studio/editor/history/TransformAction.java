// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class TransformAction extends EditorAction
{

    private final Matrix transformMatrix;

    private TransformAction(Matrix matrix)
    {
        transformMatrix = matrix;
    }

    public static TransformAction create(Matrix matrix)
    {
        return new TransformAction(matrix);
    }

    public static TransformAction createFromJSON(JSONObject jsonobject)
    {
        TransformAction transformaction = new TransformAction(new Matrix());
        transformaction.loadFromJSON(jsonobject);
        return transformaction;
    }

    private void loadFromJSON(JSONObject jsonobject)
    {
        float af[];
        af = new float[9];
        jsonobject = jsonobject.getJSONArray("values");
        int i = 0;
_L2:
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        af[i] = (float)jsonobject.getDouble(i);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            transformMatrix.setValues(af);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        return;
    }

    public Bitmap apply(Bitmap bitmap)
    {
        Bitmap bitmap1 = bitmap;
        if (!transformMatrix.isIdentity())
        {
            bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), transformMatrix, false);
        }
        return bitmap1;
    }

    public JSONObject getJSONRepresentation()
    {
        float af[] = new float[9];
        transformMatrix.getValues(af);
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        int i = 0;
        do
        {
            if (i >= 9)
            {
                break;
            }
            try
            {
                jsonarray.put(af[i]);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                return jsonobject;
            }
            i++;
        } while (true);
        jsonobject.put("values", jsonarray);
        return jsonobject;
    }

    public Point getOutSize(Point point)
    {
        RectF rectf = new RectF(0.0F, 0.0F, point.x, point.y);
        transformMatrix.mapRect(rectf);
        point.set((int)rectf.width(), (int)rectf.height());
        return point;
    }

    public boolean isReversible()
    {
        return true;
    }

    public boolean isSourceDependent()
    {
        return true;
    }

    public Bitmap reverseApply(Bitmap bitmap)
    {
        Object obj = bitmap;
        if (!transformMatrix.isIdentity())
        {
            obj = new Matrix();
            transformMatrix.invert(((Matrix) (obj)));
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), false);
        }
        return ((Bitmap) (obj));
    }
}

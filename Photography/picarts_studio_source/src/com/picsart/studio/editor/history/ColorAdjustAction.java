// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import com.socialin.android.photo.imgop.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class ColorAdjustAction extends EditorAction
{

    private final int brightness;
    private final int contrast;
    private final int hue;
    private final int saturation;

    private ColorAdjustAction(int i, int j, int k, int l)
    {
        brightness = i;
        contrast = j;
        saturation = k;
        hue = l;
    }

    public static ColorAdjustAction create(int i, int j, int k, int l)
    {
        return new ColorAdjustAction(i, j, k, l);
    }

    public static ColorAdjustAction createFromJSON(JSONObject jsonobject)
    {
        try
        {
            jsonobject = create(jsonobject.getInt("br"), jsonobject.getInt("cont"), jsonobject.getInt("sat"), jsonobject.getInt("hue"));
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
        Object obj1 = new ColorMatrix();
        ColorMatrix colormatrix = new ColorMatrix();
        ColorMatrix colormatrix1 = new ColorMatrix();
        ColorMatrix colormatrix2 = new ColorMatrix();
        a.a(1, brightness + 100, ((ColorMatrix) (obj1)));
        a.a(2, (contrast + 100) / 2, colormatrix);
        a.a(0, (saturation + 100) / 2, colormatrix1);
        a.a(7, hue, colormatrix2);
        Object obj = new ColorMatrix();
        ((ColorMatrix) (obj)).set(colormatrix2);
        ((ColorMatrix) (obj)).postConcat(((ColorMatrix) (obj1)));
        ((ColorMatrix) (obj)).postConcat(colormatrix);
        ((ColorMatrix) (obj)).postConcat(colormatrix1);
        obj1 = new Paint(2);
        ((Paint) (obj1)).setColorFilter(new ColorMatrixColorFilter(((ColorMatrix) (obj))));
        obj = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(((Bitmap) (obj)))).drawBitmap(bitmap, 0.0F, 0.0F, ((Paint) (obj1)));
        return ((Bitmap) (obj));
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("br", brightness);
            jsonobject.put("cont", contrast);
            jsonobject.put("sat", saturation);
            jsonobject.put("hue", hue);
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

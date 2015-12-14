// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.SparseArray;
import com.picsart.studio.editor.helper.b;
import com.picsart.studio.editor.view.RGBConvertView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class CurveAction extends EditorAction
{

    private final int bValues[] = new int[256];
    private SparseArray curvePoints;
    private final int gValues[] = new int[256];
    private final int rValues[] = new int[256];
    private final int rgbValues[] = new int[256];

    private CurveAction(SparseArray sparsearray)
    {
        curvePoints = sparsearray;
    }

    public static CurveAction create(SparseArray sparsearray)
    {
        return new CurveAction(sparsearray);
    }

    public static CurveAction createFromJSON(JSONObject jsonobject)
    {
        try
        {
            SparseArray sparsearray = new SparseArray(4);
            sparsearray.put(0, extractPointsFromJSONArray(jsonobject.getJSONArray("r")));
            sparsearray.put(1, extractPointsFromJSONArray(jsonobject.getJSONArray("g")));
            sparsearray.put(2, extractPointsFromJSONArray(jsonobject.getJSONArray("b")));
            sparsearray.put(3, extractPointsFromJSONArray(jsonobject.getJSONArray("rgb")));
            jsonobject = create(sparsearray);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    private static ArrayList extractPointsFromJSONArray(JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        if (jsonarray.length() % 2 != 0)
        {
            throw new IllegalArgumentException("Provided jsonArray must have even entries");
        }
        arraylist = new ArrayList(jsonarray.length() / 2);
        i = 0;
        int j = jsonarray.length();
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new Point(jsonarray.getInt(i), jsonarray.getInt(i + 1)));
        i += 2;
        if (true) goto _L2; else goto _L1
        jsonarray;
        jsonarray.printStackTrace();
_L1:
        return arraylist;
    }

    private void generateValues()
    {
        RGBConvertView.a((ArrayList)curvePoints.get(0), rValues);
        RGBConvertView.a((ArrayList)curvePoints.get(1), gValues);
        RGBConvertView.a((ArrayList)curvePoints.get(2), bValues);
        RGBConvertView.a((ArrayList)curvePoints.get(3), rgbValues);
    }

    private static JSONArray packPointIntoJSONArray(ArrayList arraylist)
    {
        JSONArray jsonarray = new JSONArray();
        Point point;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); jsonarray.put(point.y))
        {
            point = (Point)arraylist.next();
            jsonarray.put(point.x);
        }

        return jsonarray;
    }

    public Bitmap apply(Bitmap bitmap)
    {
        generateValues();
        b b1 = new b(bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true), bitmap);
        b1.a(rgbValues, rValues, gValues, bValues);
        b1.a();
        return bitmap;
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("r", packPointIntoJSONArray((ArrayList)curvePoints.get(0)));
            jsonobject.put("g", packPointIntoJSONArray((ArrayList)curvePoints.get(1)));
            jsonobject.put("b", packPointIntoJSONArray((ArrayList)curvePoints.get(2)));
            jsonobject.put("rgb", packPointIntoJSONArray((ArrayList)curvePoints.get(3)));
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
}

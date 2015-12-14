// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.picsart.studio.editor.helper.e;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class RasterAction extends EditorAction
{

    private final e purgeableBitmap;

    private RasterAction(Bitmap bitmap, String s)
    {
        purgeableBitmap = new e(bitmap, (new StringBuilder()).append(s).append("/").append(UUID.randomUUID()).append(".raw").toString());
    }

    private RasterAction(String s)
    {
        purgeableBitmap = new e(s);
    }

    public static RasterAction create(Bitmap bitmap, String s)
    {
        return new RasterAction(bitmap, s);
    }

    public static RasterAction createFromJSON(JSONObject jsonobject)
    {
        try
        {
            jsonobject = new RasterAction(jsonobject.getString("filePath"));
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
        return purgeableBitmap.a();
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("filePath", purgeableBitmap.b);
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
        Point point1 = purgeableBitmap.b();
        point.set(point1.x, point1.y);
        return point;
    }

    public String getUsingFilePath()
    {
        return purgeableBitmap.b;
    }

    public boolean isReversible()
    {
        return false;
    }

    public boolean isSourceDependent()
    {
        return false;
    }

    public Bitmap reverseApply(Bitmap bitmap)
    {
        throw new UnsupportedOperationException("Reverse applying is not supported");
    }
}

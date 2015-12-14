// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.socialin.android.util.w;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class ResizeAction extends EditorAction
{

    private final int newHeight;
    private final int newWidth;

    private ResizeAction(int i, int j)
    {
        newWidth = i;
        newHeight = j;
    }

    public static ResizeAction create(int i, int j)
    {
        return new ResizeAction(i, j);
    }

    public static ResizeAction createFromJSON(JSONObject jsonobject)
    {
        try
        {
            jsonobject = new ResizeAction(jsonobject.getInt("width"), jsonobject.getInt("height"));
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
        return w.a(bitmap, newWidth, newHeight);
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", newWidth);
            jsonobject.put("height", newHeight);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    public Point getOutSize(Point point)
    {
        point.set(newWidth, newHeight);
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.picsart.studio.editor.helper.c;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class EnhanceAction extends EditorAction
{

    private final int fade;
    private final int normalization;
    private final int saturation;

    private EnhanceAction(int i, int j, int k)
    {
        normalization = i;
        saturation = j;
        fade = k;
    }

    public static EnhanceAction create(int i, int j, int k)
    {
        return new EnhanceAction(i, j, k);
    }

    public static EnhanceAction createFromJSON(JSONObject jsonobject)
    {
        try
        {
            jsonobject = create(jsonobject.getInt("norm"), jsonobject.getInt("sat"), jsonobject.getInt("fade"));
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
        c c1 = new c(bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true), bitmap);
        c1.a(normalization, saturation, fade);
        c1.a();
        return bitmap;
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("norm", normalization);
            jsonobject.put("sat", saturation);
            jsonobject.put("fade", fade);
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

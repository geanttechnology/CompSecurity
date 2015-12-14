// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Point;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class GifExportAction extends EditorAction
{

    public GifExportAction()
    {
    }

    public JSONObject getJSONRepresentation()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = (new JSONObject()).put("gif", true);
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
        return null;
    }

    public boolean isReversible()
    {
        return false;
    }

    public boolean isSourceDependent()
    {
        return false;
    }
}

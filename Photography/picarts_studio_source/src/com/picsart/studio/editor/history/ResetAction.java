// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.picsart.studio.editor.e;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction

public class ResetAction extends EditorAction
{

    public ResetAction()
    {
    }

    public Bitmap apply(Bitmap bitmap)
    {
        return e.a().a.a();
    }

    public JSONObject getJSONRepresentation()
    {
        return new JSONObject();
    }

    public Point getOutSize(Point point)
    {
        Point point1 = e.a().a.b();
        point.set(point1.x, point1.y);
        return point;
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

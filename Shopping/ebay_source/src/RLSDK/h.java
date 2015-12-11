// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import android.app.Application;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package RLSDK:
//            g, d

public class h extends g
{

    protected h(Application application)
    {
        super(application);
    }

    public void onTapEvent(int i, int j)
    {
        Object obj;
        if (camera != null)
        {
            if (((android.hardware.Camera.Parameters) (obj = camera.getParameters())).getMaxNumFocusAreas() > 0)
            {
                Object obj2 = new Matrix();
                cameraToPreviewMatrix.invert(((Matrix) (obj2)));
                Object obj1 = new RectF(i, j, i + 1, j + 1);
                ((Matrix) (obj2)).mapRect(((RectF) (obj1)));
                obj2 = configManager.a();
                i = (int)((((RectF) (obj1)).left * 2000F) / (float)((Point) (obj2)).x) - 1000;
                j = (int)((((RectF) (obj1)).top * 2000F) / (float)((Point) (obj2)).y) - 1000;
                obj1 = new Rect(i - 50, j - 50, i + 50, j + 50);
                if (((Rect) (obj1)).intersect(-1000, -1000, 1000, 1000))
                {
                    obj1 = new android.hardware.Camera.Area(((Rect) (obj1)), 1000);
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(obj1);
                    ((android.hardware.Camera.Parameters) (obj)).setFocusAreas(arraylist);
                    try
                    {
                        camera.setParameters(((android.hardware.Camera.Parameters) (obj)));
                    }
                    catch (RuntimeException runtimeexception) { }
                }
                obj = TAG;
                (new StringBuilder("Focusing on point ")).append(i).append(",").append(j).append(" in camera.area coords.").toString();
                return;
            }
        }
    }
}

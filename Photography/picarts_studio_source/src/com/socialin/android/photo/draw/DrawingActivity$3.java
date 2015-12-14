// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.Paint;
import android.os.Bundle;
import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.controller.a;
import com.socialin.android.brushlib.controller.e;
import com.socialin.android.brushlib.controller.g;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.svg.ClipArtSvg;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.textart.DrawTextStyle;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.photo.textart.TextArt;
import com.socialin.android.photo.textart.TextArtStyle;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b
    implements Runnable
{

    final DrawingActivity a;
    private Bundle b;

    public final void run()
    {
        if (b == null) goto _L2; else goto _L1
_L1:
        com.socialin.android.brushlib.view.gMode gmode1 = (com.socialin.android.brushlib.view.gMode)b.getSerializable("editMode");
        com.socialin.android.brushlib.view.gMode gmode2 = (com.socialin.android.brushlib.view.gMode)b.getSerializable("drawMode");
        com.socialin.android.brushlib.view.gMode gmode = gmode1;
        if (gmode1 == null)
        {
            gmode = com.socialin.android.brushlib.view.gMode.BRUSH;
        }
        DrawingActivity.b(a).setEditingMode(gmode);
        DrawingActivity.b(a).setDrawingMode(gmode2);
        com.socialin.android.photo.draw..a[DrawingActivity.b(a).e().ordinal()];
        JVM INSTR tableswitch 1 4: default 112
    //                   1 112
    //                   2 213
    //                   3 250
    //                   4 360;
           goto _L3 _L3 _L4 _L5 _L6
_L3:
        a a1 = DrawingActivity.b(a).g;
        HashMap hashmap = (HashMap)b.getSerializable("eraserTime");
        if (hashmap != null)
        {
            a1.g = hashmap;
        }
        a1 = DrawingActivity.b(a).g;
        hashmap = (HashMap)b.getSerializable("brushTime");
        if (hashmap != null)
        {
            a1.f = hashmap;
        }
        com.socialin.android.photo.draw.DrawingActivity.a(a, b.getString("drawingSessionId"));
        com.socialin.android.photo.draw.DrawingActivity.a(a, b.getLong("drawingSessionStart"));
        return;
_L4:
        Bundle bundle = b.getBundle("imageOverlayControllerData");
        if (bundle != null)
        {
            DrawingActivity.b(a).post(new Runnable(bundle) {

                private Bundle a;
                private DrawingActivity._cls3 b;

                public final void run()
                {
                    DrawingActivity.b(b.a).h.a(a);
                }

            
            {
                b = DrawingActivity._cls3.this;
                a = bundle;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
_L5:
        g g1 = DrawingActivity.b(a).j;
        Object obj = b.getBundle("textOverlayControllerData");
        g1.c = (DrawTextStyle)((Bundle) (obj)).getSerializable("style");
        g1.d = (String)((Bundle) (obj)).getSerializable("text");
        g1.b = ((Bundle) (obj)).getParcelable("styleData");
        obj = new Paint();
        Paint paint = new Paint();
        TextArt.initTextArtForDrawing(a, (TextArtStyle)g1.b, paint, ((Paint) (obj)));
        g1.a(g1.d, paint, ((Paint) (obj)), g1.c, g1.b);
        continue; /* Loop/switch isn't completed */
_L6:
        Object obj1 = b.getBundle("shapeOverlayControllerData");
        ShapeOverlayController shapeoverlaycontroller = DrawingActivity.b(a).i;
        shapeoverlaycontroller.d = ((Bundle) (obj1)).getString("shapeName");
        shapeoverlaycontroller.e = (ClipArtSvg)((Bundle) (obj1)).getSerializable("svg");
        shapeoverlaycontroller.f = (com.socialin.android.brushlib.controller.ller.ShapeType)((Bundle) (obj1)).getSerializable("shapeType");
        shapeoverlaycontroller.h = (com.socialin.android.brushlib.controller.ller.ShapeEditingMode)((Bundle) (obj1)).getSerializable("editMode");
        shapeoverlaycontroller.g = (ShapeParams)((Bundle) (obj1)).getSerializable("currentParams");
        obj1 = (Overlay)((Bundle) (obj1)).getSerializable("overlay");
        if (obj1 != null)
        {
            shapeoverlaycontroller.a(((Overlay) (obj1)));
        }
        if (shapeoverlaycontroller.h == com.socialin.android.brushlib.controller.ller.ShapeEditingMode.EDIT)
        {
            shapeoverlaycontroller.a();
        }
        if (true) goto _L3; else goto _L2
_L2:
        DrawingActivity.b(a).setEditingMode(com.socialin.android.brushlib.view.gMode.BRUSH);
        DrawingActivity.b(a).setDrawingMode(com.socialin.android.brushlib.view.gMode.DRAW);
        return;
    }

    _cls1.a(DrawingActivity drawingactivity, Bundle bundle)
    {
        a = drawingactivity;
        b = bundle;
        super();
    }
}

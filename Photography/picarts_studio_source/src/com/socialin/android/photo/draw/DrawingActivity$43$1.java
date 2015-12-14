// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.camera.CameraPreviewContainer;
import com.socialin.android.brushlib.camera.a;
import com.socialin.android.brushlib.camera.b;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        AnalyticUtils.getInstance(a.a).track(new com.socialin.android.apiv3.events.erAddedEvent("camera"));
        com.socialin.android.photo.draw.DrawingActivity.a(a.a, true);
        DrawingActivity.af(a.a);
        a.a.b();
    }

    tainer(tainer tainer)
    {
        a = tainer;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$43

/* anonymous class */
    final class DrawingActivity._cls43
        implements a
    {

        final DrawingActivity a;
        private Runnable b;

        public final void a(Bitmap bitmap)
        {
            if (DrawingActivity.L(a) && bitmap != null)
            {
                DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
                CameraPreviewContainer camerapreviewcontainer = DrawingActivity.B(a);
                android.hardware.Camera.Size size = camerapreviewcontainer.a(camerapreviewcontainer.c.a);
                float f = Math.max((float)camerapreviewcontainer.d.width() / (float)size.width, (float)camerapreviewcontainer.d.height() / (float)size.height);
                int i = (int)((float)size.width * f);
                int j = (int)((float)size.height * f);
                int k = i - camerapreviewcontainer.d.width();
                int l = j - camerapreviewcontainer.d.height();
                drawingview.setCapturedPicture(bitmap, new Rect(-k, -l, -k + i, -l + j), DrawingActivity.B(a).d, new DrawingActivity._cls43._cls1(this));
                if (b != null)
                {
                    a.runOnUiThread(b);
                }
            }
        }

            
            {
                a = drawingactivity;
                b = runnable;
                super();
            }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.graphics.Bitmap;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.overlay.ImageOverlay;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.OverlayAdditionAction;
import java.util.UUID;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        a.a.recycle();
        a.a.run();
    }

    dditionAction(dditionAction dditionaction)
    {
        a = dditionaction;
        super();
    }

    // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$12

/* anonymous class */
    final class DrawingView._cls12
        implements Runnable
    {

        final Bitmap a;
        final Runnable b;
        private Bitmap c;
        private DrawingView d;

        public final void run()
        {
            Object obj = com.socialin.android.brushlib.view.DrawingView.a(d).j.d;
            Object obj1 = new ImageOverlay(c, d.c.k.getImageDataFolder());
            ((ImageOverlay) (obj1)).getTransform().setPosition((float)com.socialin.android.brushlib.view.DrawingView.a(d).d / 2.0F, (float)com.socialin.android.brushlib.view.DrawingView.a(d).e / 2.0F);
            ((ImageOverlay) (obj1)).draw(((b) (obj)).j);
            ActionCollector.a().a(new OverlayAdditionAction(((com.socialin.android.brushlib.overlay.Overlay) (obj1)), UUID.fromString(((b) (obj)).c), d.c.f.d().key));
            obj = com.socialin.android.brushlib.view.DrawingView.a(d);
            obj1 = com.socialin.android.brushlib.view.DrawingView.a(d).j.d;
            DrawingView._cls12._cls1 _lcls1 = new DrawingView._cls12._cls1(this);
            ((a) (obj)).f.b(((com.socialin.android.brushlib.layer.a) (obj1)), _lcls1);
        }

            
            {
                d = drawingview;
                c = bitmap;
                a = bitmap1;
                b = runnable;
                super();
            }
    }

}

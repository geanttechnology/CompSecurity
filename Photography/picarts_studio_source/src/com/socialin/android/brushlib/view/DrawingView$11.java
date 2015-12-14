// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.LayerAdditionAction;
import java.io.File;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView, Camera

final class e extends AsyncTask
{

    final DrawingView a;
    private int b;
    private int c;
    private Bitmap d;
    private com.socialin.android.brushlib.b e;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = DrawingView.n();
        aobj = new Project(new File(a.d, ((String) (aobj))), true);
        com.socialin.android.brushlib.view.DrawingView.a(a, new com.socialin.android.brushlib.state.a(a, ((Project) (aobj)), b, c));
        com.socialin.android.brushlib.view.DrawingView.a(a).f.a(DrawingView.d(a));
        com.socialin.android.brushlib.view.DrawingView.a(a).a(DrawingView.e(a));
        b b1;
        if (d != null)
        {
            aobj = com.socialin.android.brushlib.layer.b.a(d, b, c, e);
        } else
        {
            aobj = com.socialin.android.brushlib.layer.b.a(com.socialin.android.brushlib.view.DrawingView.a(a).d, com.socialin.android.brushlib.view.DrawingView.a(a).e, -1);
        }
        b1 = com.socialin.android.brushlib.layer.b.a(com.socialin.android.brushlib.view.DrawingView.a(a).d, com.socialin.android.brushlib.view.DrawingView.a(a).e);
        com.socialin.android.brushlib.view.DrawingView.a(a, com.socialin.android.brushlib.view.Camera.a());
        if (a.getWidth() != 0 && a.getHeight() != 0)
        {
            DrawingView.h(a).a(a.getWidth(), a.getHeight());
            a.post(new Runnable() {

                private DrawingView._cls11 a;

                public final void run()
                {
                    a.a.a();
                }

            
            {
                a = DrawingView._cls11.this;
                super();
            }
            });
        }
        DrawingView.f(a);
        ((Activity)a.getContext()).runOnUiThread(new Runnable(((b) (aobj)), b1) {

            private b a;
            private b b;
            private DrawingView._cls11 c;

            public final void run()
            {
                int i = 0;
                com.socialin.android.brushlib.view.DrawingView.a(c.a, DrawingView.State.INITIALIZED);
                DrawingView.g(c.a);
                if (c.a.getWidth() != 0 && c.a.getHeight() != 0)
                {
                    DrawingView.h(c.a).a(c.a.getWidth(), c.a.getHeight());
                    c.a.a();
                }
                com.socialin.android.brushlib.state.a a1 = com.socialin.android.brushlib.view.DrawingView.a(c.a);
                b b2 = a;
                b b3 = b;
                for (; i < 2; i++)
                {
                    b b4 = (new b[] {
                        b2, b3
                    })[i];
                    a1.a.add(b4);
                    a1.f(b4);
                    LayerAdditionAction layeradditionaction = new LayerAdditionAction(UUID.fromString(b4.c), null, null);
                    ActionCollector.a().a(layeradditionaction);
                    a1.f.a(b4, new com.socialin.android.brushlib.state.a._cls2(layeradditionaction, b4));
                }

                a1.f.a(a1.a(null));
                com.socialin.android.brushlib.view.DrawingView.a(c.a).a(b);
                c.a.invalidate();
            }

            
            {
                c = DrawingView._cls11.this;
                a = b1;
                b = b2;
                super();
            }
        });
        return null;
    }

    _cls2.b(DrawingView drawingview, int i, int j, Bitmap bitmap, com.socialin.android.brushlib.b b1)
    {
        a = drawingview;
        b = i;
        c = j;
        d = bitmap;
        e = b1;
        super();
    }
}

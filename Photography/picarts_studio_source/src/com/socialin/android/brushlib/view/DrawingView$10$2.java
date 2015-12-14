// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Toast;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.LayerMetaInfo;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.ModernAsyncTask;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myobfuscated.br.d;
import myobfuscated.br.e;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView, Camera

final class a
    implements Runnable
{

    private Snapshot a;
    private idate b;

    public final void run()
    {
        com.socialin.android.brushlib.view.DrawingView.a(b.b, .INITIALIZED);
        DrawingView.g(b.b);
        if (b.b.getWidth() != 0 && b.b.getHeight() != 0)
        {
            DrawingView.h(b.b).a(b.b.getWidth(), b.b.getHeight());
            b.b.a();
        }
        b b1;
        for (Iterator iterator = Collections.unmodifiableList(com.socialin.android.brushlib.view.DrawingView.a(b.b).a).iterator(); iterator.hasNext(); com.socialin.android.brushlib.view.DrawingView.a(b.b).f(b1))
        {
            b1 = (b)iterator.next();
        }

        com.socialin.android.brushlib.view.DrawingView.a(b.b).a((b)Collections.unmodifiableList(com.socialin.android.brushlib.view.DrawingView.a(b.b).a).get(a.selectedLayerIndex));
        b.b.invalidate();
    }

    a(a a1, Snapshot snapshot)
    {
        b = a1;
        a = snapshot;
        super();
    }

    // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$10

/* anonymous class */
    public final class DrawingView._cls10 extends ModernAsyncTask
    {

        final Project a;
        final DrawingView b;

        private transient Void a()
        {
            Object obj;
            try
            {
                obj = d.a(a);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(DrawingView.m(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((InvalidIndexFileException) (obj)).getMessage()).toString()
                });
                obj = null;
            }
            if (obj == null || ((e) (obj)).e() || ((e) (obj)).c() == null || ((Snapshot)((e) (obj)).c()).layerInfoList == null)
            {
                b.post(new DrawingView._cls10._cls1());
                b.b(true);
                ((Activity)b.getContext()).finish();
                return null;
            } else
            {
                Snapshot snapshot = (Snapshot)((e) (obj)).c();
                LayerMetaInfo layermetainfo = (LayerMetaInfo)snapshot.layerInfoList.get(0);
                com.socialin.android.brushlib.view.DrawingView.a(b, new a(b, a, layermetainfo.width, layermetainfo.height, ((e) (obj))));
                com.socialin.android.brushlib.view.DrawingView.a(b).f.a(com.socialin.android.brushlib.view.DrawingView.d(b));
                com.socialin.android.brushlib.view.DrawingView.a(b).a(com.socialin.android.brushlib.view.DrawingView.e(b));
                com.socialin.android.brushlib.view.DrawingView.a(b).f.b(snapshot);
                com.socialin.android.brushlib.view.DrawingView.a(b, com.socialin.android.brushlib.view.Camera.a());
                DrawingView.f(b);
                ((Activity)b.getContext()).runOnUiThread(new DrawingView._cls10._cls2(this, snapshot));
                return null;
            }
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

            public 
            {
                b = drawingview;
                a = project;
                super();
            }

        // Unreferenced inner class com/socialin/android/brushlib/view/DrawingView$10$1

/* anonymous class */
        final class DrawingView._cls10._cls1
            implements Runnable
        {

            private DrawingView._cls10 a;

            public final void run()
            {
                Toast.makeText(a.b.getContext(), a.b.getResources().getString(0x7f08009c, new Object[] {
                    a.a.getDisplayName()
                }), 0).show();
            }

                    
                    {
                        a = DrawingView._cls10.this;
                        super();
                    }
        }

    }

}

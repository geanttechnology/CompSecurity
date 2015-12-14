// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.mobeta.android.dslv.DragSortListView;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import com.socialin.android.brushlib.brush.f;
import com.socialin.android.brushlib.brush.j;
import com.socialin.android.brushlib.camera.CameraPreviewContainer;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.state.b;
import com.socialin.android.brushlib.util.c;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.d;
import com.socialin.android.util.ak;
import com.socialin.android.util.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity, b

final class a
    implements b
{

    final a a;

    public final void a()
    {
        DrawingActivity.r(a.a).notifyDataSetChanged();
        DrawingActivity drawingactivity = a.a;
        com.socialin.android.brushlib.layer.b b1 = com.socialin.android.photo.draw.DrawingActivity.b(a.a).c.b;
        DrawingActivity.y(drawingactivity);
    }

    public final void a(com.socialin.android.brushlib.layer.b b1)
    {
        DrawingActivity.z(a.a).a(b1, new com.socialin.android.brushlib.util.d() {

            private DrawingActivity._cls8._cls2 a;

            public final void a(com.socialin.android.brushlib.layer.b b2)
            {
                if (DrawingActivity.r(a.a.a) != null && com.socialin.android.photo.draw.b.a(DrawingActivity.r(a.a.a)).contains(b2) && DrawingActivity.A(a.a.a) != null)
                {
                    int i = com.socialin.android.photo.draw.b.a(DrawingActivity.r(a.a.a)).indexOf(b2) - DrawingActivity.A(a.a.a).getFirstVisiblePosition();
                    if (i >= 0)
                    {
                        b2 = DrawingActivity.A(a.a.a).getChildAt(i);
                        if (b2 != null)
                        {
                            b2.invalidate();
                        }
                    }
                }
            }

            
            {
                a = DrawingActivity._cls8._cls2.this;
                super();
            }
        });
    }

    public final void b()
    {
        com.socialin.android.photo.draw.DrawingActivity.a(a.a, false);
        DrawingActivity.r(a.a).notifyDataSetChanged();
    }

    public final void b(com.socialin.android.brushlib.layer.b b1)
    {
        if (b1 == com.socialin.android.photo.draw.DrawingActivity.b(a.a).c.b)
        {
            com.socialin.android.photo.draw.DrawingActivity.a(a.a, b1);
        }
    }

    public final void c()
    {
        DrawingActivity.r(a.a).notifyDataSetChanged();
    }

    public final void c(com.socialin.android.brushlib.layer.b b1)
    {
        DrawingActivity.y(a.a);
        c c1 = DrawingActivity.z(a.a);
        c1.b.remove(c1.a.remove(b1));
        DrawingActivity.r(a.a).notifyDataSetChanged();
    }

    public final void d(com.socialin.android.brushlib.layer.b b1)
    {
        DrawingActivity.r(a.a).notifyDataSetChanged();
        DrawingActivity.y(a.a);
        DrawingActivity.z(a.a).a(b1, new com.socialin.android.brushlib.util.d() {

            private DrawingActivity._cls8._cls2 a;

            public final void a(com.socialin.android.brushlib.layer.b b2)
            {
                if (DrawingActivity.A(a.a.a) != null)
                {
                    b2 = DrawingActivity.A(a.a.a).getChildAt(com.socialin.android.photo.draw.b.a(DrawingActivity.r(a.a.a)).indexOf(b2));
                    if (b2 != null)
                    {
                        b2.invalidate();
                    }
                }
            }

            
            {
                a = DrawingActivity._cls8._cls2.this;
                super();
            }
        });
    }

    public final void e(com.socialin.android.brushlib.layer.b b1)
    {
        DrawingActivity.y(a.a);
        com.socialin.android.photo.draw.DrawingActivity.a(a.a, b1);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$8

/* anonymous class */
    final class DrawingActivity._cls8
        implements d
    {

        final DrawingActivity a;

        public final void a()
        {
            a.b();
            Object obj = a;
            Object obj1 = a.getResources();
            DrawingView drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
            RectF rectf = DrawingActivity.u(a);
            drawingview.b.set(0.0F, 0.0F, drawingview.c.d, drawingview.c.e);
            l.a(drawingview.b, rectf);
            int i = Math.max(1, Math.round(drawingview.b.width()));
            drawingview = com.socialin.android.photo.draw.DrawingActivity.b(a);
            rectf = DrawingActivity.u(a);
            drawingview.b.set(0.0F, 0.0F, drawingview.c.d, drawingview.c.e);
            l.a(drawingview.b, rectf);
            com.socialin.android.photo.draw.DrawingActivity.a(((DrawingActivity) (obj)), new c(((android.content.res.Resources) (obj1)), i, Math.max(1, Math.round(drawingview.b.height()))));
            DrawingActivity.v(a);
            DrawingActivity.w(a).run();
            obj1 = com.socialin.android.photo.draw.DrawingActivity.b(a).m;
            obj = Brush.a(a, ((BrushHistory) (obj1)).getSelectedBrushId(false));
            com.socialin.android.photo.draw.DrawingActivity.b(a).setBrush(((Brush) (obj)));
            com.socialin.android.photo.draw.DrawingActivity.b(a).setBrushParams(((BrushHistory) (obj1)).getBrushSelectedParams(((BrushHistory) (obj1)).getSelectedBrushId(false), false));
            if (obj instanceof j)
            {
                i = ((BrushHistory) (obj1)).getSelectedStickerIndex();
                obj1 = ak.a(a, "drawing");
                ((j)obj).a(((ak) (obj1)).b(i));
                ((Brush) (obj)).a(com.socialin.android.util.d.a(((ak) (obj1)).c(i)));
                ((j)obj).c = i;
            } else
            if (obj instanceof f)
            {
                ((f)obj).c = ((BrushHistory) (obj1)).getSelectedShapeName();
            }
            obj = com.socialin.android.photo.draw.DrawingActivity.b(a);
            if (DrawingActivity.x(a) != null)
            {
                i = DrawingActivity.x(a).intValue();
            } else
            {
                i = 0xff000000;
            }
            ((DrawingView) (obj)).setCurrentColor(i);
            com.socialin.android.photo.draw.DrawingActivity.a(a, Integer.valueOf(0xff000000));
            com.socialin.android.photo.draw.DrawingActivity.a(a, false, false);
            obj = com.socialin.android.photo.draw.DrawingActivity.b(a).c.f;
            DrawingActivity.k(a).findViewById(0x7f1003a3).setEnabled(((myobfuscated.br.a) (obj)).e());
            DrawingActivity.k(a).findViewById(0x7f1003a4).setEnabled(((myobfuscated.br.a) (obj)).f());
            com.socialin.android.photo.draw.DrawingActivity.b(a).c.f.a(new DrawingActivity._cls8._cls1());
            com.socialin.android.photo.draw.DrawingActivity.b(a).c.a(new DrawingActivity._cls8._cls2(this));
            com.socialin.android.photo.draw.DrawingActivity.a(a, (CameraPreviewContainer)a.findViewById(0x7f10039b));
            DrawingActivity.B(a).setPictureSize(com.socialin.android.photo.draw.DrawingActivity.b(a).f(), com.socialin.android.photo.draw.DrawingActivity.b(a).g());
            com.socialin.android.photo.draw.DrawingActivity.b(a).post(new DrawingActivity._cls8._cls3());
        }

            
            {
                a = drawingactivity;
                super();
            }

        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$8$1

/* anonymous class */
        final class DrawingActivity._cls8._cls1
            implements myobfuscated.br.b
        {

            private DrawingActivity._cls8 a;

            public final void a(myobfuscated.br.a a1)
            {
                DrawingActivity.k(a.a).findViewById(0x7f1003a3).setEnabled(a1.e());
                DrawingActivity.k(a.a).findViewById(0x7f1003a4).setEnabled(a1.f());
            }

                    
                    {
                        a = DrawingActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$8$3

/* anonymous class */
        final class DrawingActivity._cls8._cls3
            implements Runnable
        {

            private DrawingActivity._cls8 a;

            public final void run()
            {
                for (Iterator iterator = DrawingActivity.C(a.a).iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
                DrawingActivity.C(a.a).clear();
            }

                    
                    {
                        a = DrawingActivity._cls8.this;
                        super();
                    }
        }

    }

}

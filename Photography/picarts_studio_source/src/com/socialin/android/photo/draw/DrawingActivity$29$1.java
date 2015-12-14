// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.controller.e;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.util.Utils;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.LayerClearAction;
import com.socialin.android.videogenerator.actions.LayersMergeAction;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import myobfuscated.br.d;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.widget.ckListener
{

    private boolean a;
    private rOrigBuffersFolder b;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 33
    //                   1 108
    //                   2 172
    //                   3 525;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (com.socialin.android.photo.draw.DrawingActivity.b(b.b).i != null)
        {
            com.socialin.android.photo.draw.DrawingActivity.b(b.b).i.b();
        }
        if (com.socialin.android.photo.draw.DrawingActivity.b(b.b).h != null)
        {
            com.socialin.android.photo.draw.DrawingActivity.b(b.b).h.d();
        }
        DrawingActivity.U(b.b);
        return;
_L3:
        if (a)
        {
            adapterview = com.socialin.android.photo.draw.DrawingActivity.b(b.b);
            view = ((DrawingView) (adapterview)).c.b.k();
            ((DrawingView) (adapterview)).c.b(view);
            ((DrawingView) (adapterview)).c.c();
            adapterview.setSelectedLayer(view);
            return;
        } else
        {
            Utils.a(b.b, 0x7f080240);
            return;
        }
_L4:
        adapterview = com.socialin.android.photo.draw.DrawingActivity.b(b.b);
        view = Collections.unmodifiableList(((DrawingView) (adapterview)).c.a);
        i = view.indexOf(((DrawingView) (adapterview)).c.b);
        if (i < view.size() && i > 0)
        {
            Object obj = (b)view.get(i - 1);
            Object obj1 = ((DrawingView) (adapterview)).c.b;
            adapterview = ((DrawingView) (adapterview)).c;
            view = new b[2];
            view[0] = obj;
            view[1] = obj1;
            obj = ActionCollector.a();
            obj1 = ((a) (adapterview)).f.d().key;
            if (((ActionCollector) (obj)).c)
            {
                obj1 = new LayersMergeAction(((String) (obj1)));
                ((ActionCollector) (obj)).b.add(obj1);
            }
            obj = com.socialin.android.brushlib.layer.b.a(((a) (adapterview)).d, ((a) (adapterview)).e);
            if (obj != null)
            {
                obj.d = false;
                b b1 = view[0];
                int k = ((a) (adapterview)).a.indexOf(b1);
                int j;
                if (((a) (adapterview)).b == b1)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                for (j = 0; j < 2; j++)
                {
                    b b2 = view[j];
                    if (((a) (adapterview)).b == b2)
                    {
                        i = 1;
                    }
                    b2.a(((b) (obj)).j);
                    adapterview.a(b2, false);
                }

                adapterview.b(((b) (obj)));
                if (i != 0)
                {
                    adapterview.a(((b) (obj)));
                    if (k >= ((a) (adapterview)).a.size())
                    {
                        i = ((a) (adapterview)).a.size() - 1;
                    } else
                    {
                        i = k;
                    }
                    adapterview.a(((a) (adapterview)).a.indexOf(obj), i);
                }
                adapterview.c();
                adapterview = ActionCollector.a();
                view = UUID.fromString(((b) (obj)).c);
                if (((ActionCollector) (adapterview)).c)
                {
                    adapterview.a(view).setComplete(true);
                    return;
                }
            } else
            {
                ((a) (adapterview)).g.l();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        view = com.socialin.android.photo.draw.DrawingActivity.b(b.b);
        if (((DrawingView) (view)).c.j != null && ((DrawingView) (view)).r)
        {
            adapterview = ((DrawingView) (view)).c.j;
        } else
        {
            adapterview = ((DrawingView) (view)).c.b;
            ActionCollector.a().a(new LayerClearAction(UUID.fromString(adapterview.f()), ((DrawingView) (view)).c.f.d().key));
        }
        obj = ((DrawingView) (view)).c.f;
        view = new com.socialin.android.brushlib.view.tion(view);
        if (adapterview.e() != null)
        {
            ((myobfuscated.br.a) (obj)).c();
            adapterview.b(adapterview.e());
            ((myobfuscated.br.a) (obj)).d.a(adapterview, new File(((myobfuscated.br.a) (obj)).c.c.k.getLayerOrigBuffersFolder(), adapterview.d()), new myobfuscated.br..d(((myobfuscated.br.a) (obj)), adapterview, view));
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    rAction(rAction raction, boolean flag)
    {
        b = raction;
        a = flag;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$29

/* anonymous class */
    final class DrawingActivity._cls29
        implements android.view.View.OnClickListener
    {

        final DrawingActivity a;
        private ImageButton b;

        public final void onClick(View view)
        {
            view = com.socialin.android.photo.draw.DrawingActivity.b(a);
            Object obj = Collections.unmodifiableList(((DrawingView) (view)).c.a);
            int i = ((List) (obj)).indexOf(((DrawingView) (view)).c.b);
            p p1;
            boolean flag;
            boolean flag1;
            if (i < ((List) (obj)).size() && i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = com.socialin.android.photo.draw.DrawingActivity.b(a).h();
            com.socialin.android.photo.draw.DrawingActivity.b(a);
            if (i < DrawingView.k())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            view = new myobfuscated.ce.a(a);
            view.add(new myobfuscated.ce.b(0x7f02039b, a.getString(0x7f08035a), null, true, 0x7f100058));
            view.add(new myobfuscated.ce.b(0x7f0201cd, a.getString(0x7f0802ab), null, flag1, 0x7f100056));
            if (flag)
            {
                i = 0x7f020576;
            } else
            {
                i = 0x7f020577;
            }
            view.add(new myobfuscated.ce.b(i, a.getString(0x7f080300), null, flag, 0x7f100057));
            view.add(new myobfuscated.ce.b(0x7f02031d, a.getString(0x7f08029f), null, true, 0x7f100055));
            obj = a;
            p1 = WrappingListPopupWindow.a(a);
            p1.a = b;
            p1.b = view;
            p1.c = new DrawingActivity._cls29._cls1(this, flag1);
            com.socialin.android.photo.draw.DrawingActivity.d(((DrawingActivity) (obj)), p1.b());
        }

            
            {
                a = drawingactivity;
                b = imagebutton;
                super();
            }
    }

}

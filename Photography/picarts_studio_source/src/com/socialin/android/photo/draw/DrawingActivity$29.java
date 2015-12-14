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
import myobfuscated.ce.b;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b
    implements android.view.r
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
        view.add(new b(0x7f02039b, a.getString(0x7f08035a), null, true, 0x7f100058));
        view.add(new b(0x7f0201cd, a.getString(0x7f0802ab), null, flag1, 0x7f100056));
        if (flag)
        {
            i = 0x7f020576;
        } else
        {
            i = 0x7f020577;
        }
        view.add(new b(i, a.getString(0x7f080300), null, flag, 0x7f100057));
        view.add(new b(0x7f02031d, a.getString(0x7f08029f), null, true, 0x7f100055));
        obj = a;
        p1 = WrappingListPopupWindow.a(a);
        p1.a = b;
        p1.b = view;
        p1.c = new android.widget.AdapterView.OnItemClickListener(flag1) {

            private boolean a;
            private DrawingActivity._cls29 b;

            public final void onItemClick(AdapterView adapterview, View view1, int j, long l)
            {
                j;
                JVM INSTR tableswitch 0 3: default 32
            //                           0 33
            //                           1 108
            //                           2 172
            //                           3 525;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                if (com.socialin.android.photo.draw.DrawingActivity.b(b.a).i != null)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(b.a).i.b();
                }
                if (com.socialin.android.photo.draw.DrawingActivity.b(b.a).h != null)
                {
                    com.socialin.android.photo.draw.DrawingActivity.b(b.a).h.d();
                }
                DrawingActivity.U(b.a);
                return;
_L3:
                if (a)
                {
                    adapterview = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
                    view1 = ((DrawingView) (adapterview)).c.b.k();
                    ((DrawingView) (adapterview)).c.b(view1);
                    ((DrawingView) (adapterview)).c.c();
                    adapterview.setSelectedLayer(view1);
                    return;
                } else
                {
                    Utils.a(b.a, 0x7f080240);
                    return;
                }
_L4:
                adapterview = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
                view1 = Collections.unmodifiableList(((DrawingView) (adapterview)).c.a);
                j = view1.indexOf(((DrawingView) (adapterview)).c.b);
                if (j < view1.size() && j > 0)
                {
                    Object obj1 = (com.socialin.android.brushlib.layer.b)view1.get(j - 1);
                    Object obj2 = ((DrawingView) (adapterview)).c.b;
                    adapterview = ((DrawingView) (adapterview)).c;
                    view1 = new com.socialin.android.brushlib.layer.b[2];
                    view1[0] = obj1;
                    view1[1] = obj2;
                    obj1 = ActionCollector.a();
                    obj2 = ((a) (adapterview)).f.d().key;
                    if (((ActionCollector) (obj1)).c)
                    {
                        obj2 = new LayersMergeAction(((String) (obj2)));
                        ((ActionCollector) (obj1)).b.add(obj2);
                    }
                    obj1 = com.socialin.android.brushlib.layer.b.a(((a) (adapterview)).d, ((a) (adapterview)).e);
                    if (obj1 != null)
                    {
                        obj1.d = false;
                        com.socialin.android.brushlib.layer.b b1 = view1[0];
                        int i1 = ((a) (adapterview)).a.indexOf(b1);
                        int k;
                        if (((a) (adapterview)).b == b1)
                        {
                            j = 1;
                        } else
                        {
                            j = 0;
                        }
                        for (k = 0; k < 2; k++)
                        {
                            com.socialin.android.brushlib.layer.b b2 = view1[k];
                            if (((a) (adapterview)).b == b2)
                            {
                                j = 1;
                            }
                            b2.a(((com.socialin.android.brushlib.layer.b) (obj1)).j);
                            adapterview.a(b2, false);
                        }

                        adapterview.b(((com.socialin.android.brushlib.layer.b) (obj1)));
                        if (j != 0)
                        {
                            adapterview.a(((com.socialin.android.brushlib.layer.b) (obj1)));
                            if (i1 >= ((a) (adapterview)).a.size())
                            {
                                j = ((a) (adapterview)).a.size() - 1;
                            } else
                            {
                                j = i1;
                            }
                            adapterview.a(((a) (adapterview)).a.indexOf(obj1), j);
                        }
                        adapterview.c();
                        adapterview = ActionCollector.a();
                        view1 = UUID.fromString(((com.socialin.android.brushlib.layer.b) (obj1)).c);
                        if (((ActionCollector) (adapterview)).c)
                        {
                            adapterview.a(view1).setComplete(true);
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
                view1 = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
                if (((DrawingView) (view1)).c.j != null && ((DrawingView) (view1)).r)
                {
                    adapterview = ((DrawingView) (view1)).c.j;
                } else
                {
                    adapterview = ((DrawingView) (view1)).c.b;
                    ActionCollector.a().a(new LayerClearAction(UUID.fromString(adapterview.f()), ((DrawingView) (view1)).c.f.d().key));
                }
                obj1 = ((DrawingView) (view1)).c.f;
                view1 = new com.socialin.android.brushlib.view.DrawingView._cls8(view1);
                if (adapterview.e() != null)
                {
                    ((myobfuscated.br.a) (obj1)).c();
                    adapterview.b(adapterview.e());
                    ((myobfuscated.br.a) (obj1)).d.a(adapterview, new File(((myobfuscated.br.a) (obj1)).c.c.k.getLayerOrigBuffersFolder(), adapterview.d()), new myobfuscated.br.a._cls2(((myobfuscated.br.a) (obj1)), adapterview, view1));
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                b = DrawingActivity._cls29.this;
                a = flag;
                super();
            }
        };
        com.socialin.android.photo.draw.DrawingActivity.d(((DrawingActivity) (obj)), p1.b());
    }

    _cls1.a(DrawingActivity drawingactivity, ImageButton imagebutton)
    {
        a = drawingactivity;
        b = imagebutton;
        super();
    }
}

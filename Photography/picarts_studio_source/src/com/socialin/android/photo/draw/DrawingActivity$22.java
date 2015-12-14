// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.os.AsyncTask;
import android.view.View;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.controller.e;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.UndoAction;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private DrawingActivity a;

    public final void onClick(View view)
    {
        boolean flag1 = false;
        view = DrawingActivity.b(a);
        boolean flag;
        if (((a) (((DrawingView) (view)).i)).a != null)
        {
            ((DrawingView) (view)).i.c();
            view.a(true);
            flag = true;
        } else
        {
            flag = false;
        }
        if (((a) (((DrawingView) (view)).h)).a != null)
        {
            ((DrawingView) (view)).h.a();
            view.setEditingMode(com.socialin.android.brushlib.view.Mode.BRUSH);
            view.a(true);
            flag = true;
        }
        if (!flag && ((DrawingView) (view)).c.f.e() && !((DrawingView) (view)).c.f.b())
        {
            myobfuscated.br.a a1 = ((DrawingView) (view)).c.f;
            if (a1.e != null && a1.e.getStatus() != android.os.NISHED)
            {
                flag = flag1;
            } else
            {
                a1.b.a();
                a1.a((Snapshot)a1.b.c(), a1.c.c.a(null));
                flag = true;
            }
            if (flag)
            {
                ((DrawingView) (view)).g.a();
                ActionCollector.a().a(new UndoAction(((DrawingView) (view)).c.f.d().previousSnapshotKey));
            }
        }
    }

    ion(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}

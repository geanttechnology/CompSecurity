// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.os.AsyncTask;
import android.view.View;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.RedoAction;
import myobfuscated.br.e;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private DrawingActivity a;

    public final void onClick(View view)
    {
        view = DrawingActivity.b(a);
        if (((DrawingView) (view)).c.f.f() && !((DrawingView) (view)).c.f.b())
        {
            myobfuscated.br.a a1 = ((DrawingView) (view)).c.f;
            boolean flag;
            if (a1.e != null && a1.e.getStatus() != android.os.NISHED)
            {
                flag = false;
            } else
            {
                a1.b.b();
                a1.a((Snapshot)a1.b.c(), a1.c.c.a(null));
                flag = true;
            }
            if (flag)
            {
                ((DrawingView) (view)).g.a();
                ActionCollector.a().a(new RedoAction(((DrawingView) (view)).c.f.d().previousSnapshotKey));
            }
        }
    }

    ion(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}

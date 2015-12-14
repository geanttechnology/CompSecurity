// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.support.v7.app.AppCompatDialog;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.camera.CameraPreviewContainer;
import com.socialin.android.brushlib.controller.a;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.util.FileUtils;
import java.io.File;
import myobfuscated.bj.b;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements b
{

    private DrawingActivity a;

    public final void a(int i, int j)
    {
        DrawingActivity.t(a).show();
        if (DrawingActivity.L(a))
        {
            DrawingActivity.B(a).b();
            DrawingActivity.d(a, false);
            DrawingActivity.ab(a);
            com.socialin.android.photo.draw.DrawingActivity.b(a).d();
        }
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.oneEvent(DrawingActivity.Z(a).a, DrawingActivity.ac(a), com.socialin.android.photo.draw.DrawingActivity.b(a).g.b(), com.socialin.android.photo.draw.DrawingActivity.b(a).g.c(), "new", (System.nanoTime() - DrawingActivity.ad(a)) / 0x3b9aca00L));
        DrawingActivity.ae(a);
        if (com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.isDraft())
        {
            FileUtils.b(com.socialin.android.photo.draw.DrawingActivity.b(a).c.k.getRootFolder().getAbsolutePath());
        }
        com.socialin.android.photo.draw.DrawingActivity.b(a).b(false);
        com.socialin.android.photo.draw.DrawingActivity.b(a).a(i, j);
    }

    wDoneEvent(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}

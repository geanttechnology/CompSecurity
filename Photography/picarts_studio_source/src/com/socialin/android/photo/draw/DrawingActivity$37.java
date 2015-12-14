// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.Toast;
import com.picsart.studio.EditingData;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.dialog.a;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b
    implements android.view.r
{

    private StringBuilder a;
    private com.socialin.android.videogenerator.or.VideoOptions b;
    private DrawingActivity c;

    public final void onClick(View view)
    {
        view = new StringBuilder();
        if (!com.socialin.android.photo.draw.DrawingActivity.a(c, a.toString(), view, false))
        {
            Toast.makeText(c, view.toString(), 1).show();
        } else
        {
            DrawingActivity.aa(c).dismiss();
            b.setmUid(DrawingActivity.Z(c).a);
            view = DrawingActivity.b(c);
            com.socialin.android.videogenerator.or.VideoOptions videooptions = b;
            if (((DrawingView) (view)).c.k.containsActions())
            {
                view.a(new com.socialin.android.brushlib.view.>(view, videooptions));
                return;
            }
        }
    }

    (DrawingActivity drawingactivity, StringBuilder stringbuilder, com.socialin.android.videogenerator.or.VideoOptions videooptions)
    {
        c = drawingactivity;
        a = stringbuilder;
        b = videooptions;
        super();
    }
}

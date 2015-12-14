// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.util.FileUtils;
import java.io.File;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private DrawingActivity a;

    public final void run()
    {
        if (DrawingActivity.b(a).c.k.isDraft())
        {
            FileUtils.b(DrawingActivity.b(a).c.k.getRootFolder().getAbsolutePath());
        }
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}

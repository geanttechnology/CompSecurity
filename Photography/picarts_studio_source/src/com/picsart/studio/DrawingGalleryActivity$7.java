// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.view.View;
import com.socialin.android.brushlib.project.Project;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity

final class a
    implements android.view.ity._cls7
{

    private Project a;
    private DrawingGalleryActivity b;

    public final void onClick(View view)
    {
        DrawingGalleryActivity.a(b, a);
    }

    t(DrawingGalleryActivity drawinggalleryactivity, Project project)
    {
        b = drawinggalleryactivity;
        a = project;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import com.socialin.android.brushlib.project.Project;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity

final class nit> extends ModernAsyncTask
{

    private Project a;

    protected final Object doInBackground(Object aobj[])
    {
        FileUtils.b(a.getRootFolder().getAbsolutePath());
        return null;
    }

    t(Project project)
    {
        a = project;
        super();
    }
}

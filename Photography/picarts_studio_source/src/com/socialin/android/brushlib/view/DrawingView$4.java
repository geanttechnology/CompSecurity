// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.view.View;
import com.socialin.android.videogenerator.ProjectVideoGenerator;
import com.socialin.android.videogenerator.a;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

final class b
    implements android.view.stener
{

    private a a;
    private ProjectVideoGenerator b;

    public final void onClick(View view)
    {
        if (a != null && b != null)
        {
            b.b();
            a.dismiss();
        }
    }

    enerator(a a1, ProjectVideoGenerator projectvideogenerator)
    {
        a = a1;
        b = projectvideogenerator;
        super();
    }
}

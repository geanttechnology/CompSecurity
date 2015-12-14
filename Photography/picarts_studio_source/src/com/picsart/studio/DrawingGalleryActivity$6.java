// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Context;
import android.widget.Toast;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.dialog.i;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity, c

final class a extends i
{

    private Project a;
    private DrawingGalleryActivity b;

    public final String a()
    {
        if (a.isDraft())
        {
            return "";
        } else
        {
            return a.getDisplayName();
        }
    }

    public final void a(String s)
    {
        if (a.rename(s))
        {
            Toast.makeText(b, 0x7f08054b, 0).show();
            DrawingGalleryActivity.d(b).notifyDataSetChanged();
            return;
        } else
        {
            Toast.makeText(b, 0x7f08009d, 0).show();
            return;
        }
    }

    t(DrawingGalleryActivity drawinggalleryactivity, Context context, Project project)
    {
        b = drawinggalleryactivity;
        a = project;
        super(context);
    }
}

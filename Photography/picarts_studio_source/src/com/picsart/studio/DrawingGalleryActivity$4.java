// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.View;
import android.widget.GridView;
import com.socialin.android.brushlib.project.Project;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity, c

final class a
    implements android.view.ity._cls4
{

    private DrawingGalleryActivity a;

    public final void onClick(View view)
    {
        view = DrawingGalleryActivity.g(a).getCheckedItemPositions();
        Object obj = new ArrayList();
        int i = 0;
        for (int j = DrawingGalleryActivity.g(a).getCount(); i < j; i++)
        {
            if (view.get(i))
            {
                ((List) (obj)).add(DrawingGalleryActivity.h(a).get(i));
            }
        }

        for (view = ((List) (obj)).iterator(); view.hasNext(); DrawingGalleryActivity.a(a, ((Project) (obj))))
        {
            obj = (Project)view.next();
        }

        if (DrawingGalleryActivity.i(a) != null)
        {
            DrawingGalleryActivity.i(a).finish();
        }
        DrawingGalleryActivity.d(a).notifyDataSetChanged();
    }

    t(DrawingGalleryActivity drawinggalleryactivity)
    {
        a = drawinggalleryactivity;
        super();
    }
}

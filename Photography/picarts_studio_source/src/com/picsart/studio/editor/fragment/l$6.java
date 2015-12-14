// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.view.FrameEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            l

final class a
    implements android.view..OnClickListener
{

    private l a;

    public final void onClick(View view)
    {
        e.a().e.d("frame");
        FrameEditorView frameeditorview = l.a(a);
        if (frameeditorview.j != null && frameeditorview.i != null)
        {
            Canvas canvas;
            int i;
            int j;
            if (frameeditorview.i instanceof SvgItem)
            {
                float f = frameeditorview.j.r().c();
                j = (int)(frameeditorview.j.i() / f);
                i = (int)(frameeditorview.j.j() / f);
            } else
            {
                j = (int)frameeditorview.i.i();
                i = (int)frameeditorview.i.j();
            }
            view = Bitmap.createBitmap(j, i, android.graphics.ap.Config.ARGB_8888);
            canvas = new Canvas(view);
            Camera.a(j, i, 0.0F, 0.0F, (float)j / frameeditorview.i.s()).a(canvas);
            frameeditorview.b(canvas);
        } else
        {
            view = null;
        }
        a.g.a(a, view, RasterAction.create(view, e.a().d.getHistoryDataDirectory()));
    }

    rAction(l l1)
    {
        a = l1;
        super();
    }
}

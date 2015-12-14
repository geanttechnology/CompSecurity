// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.PerspectiveView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            t

final class a
    implements android.view..OnClickListener
{

    private t a;

    public final void onClick(View view)
    {
        e.a().e.c("perspective");
        PerspectiveView perspectiveview = t.b(a);
        if (perspectiveview.a != null)
        {
            view = Bitmap.createBitmap(perspectiveview.a.getWidth(), perspectiveview.a.getHeight(), android.graphics.ap.Config.ARGB_8888);
            perspectiveview.a(new RectF(0.0F, 0.0F, perspectiveview.a.getWidth(), perspectiveview.a.getHeight()));
            Canvas canvas = new Canvas(view);
            canvas.concat(perspectiveview.f);
            canvas.scale(perspectiveview.e.width() / (float)perspectiveview.a.getWidth(), perspectiveview.e.height() / (float)perspectiveview.a.getHeight());
            canvas.drawBitmap(perspectiveview.a, (float)(-perspectiveview.a.getWidth()) / 2.0F, (float)(-perspectiveview.a.getHeight()) / 2.0F, perspectiveview.b);
        } else
        {
            view = null;
        }
        a.g.a(a, view, RasterAction.create(view, e.a().d.getHistoryDataDirectory()));
        t.b(a, "done");
    }

    rAction(t t1)
    {
        a = t1;
        super();
    }
}

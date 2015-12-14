// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.BorderEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            d

final class a
    implements android.view..OnClickListener
{

    private d a;

    public final void onClick(View view)
    {
        e.a().e.d("border");
        BorderEditorView bordereditorview = d.a(a);
        if (bordereditorview.h == null)
        {
            view = null;
        } else
        {
            float f1 = (float)bordereditorview.a / bordereditorview.f;
            float f2 = (float)bordereditorview.c / bordereditorview.f;
            float f = f1;
            if (bordereditorview.e == com.picsart.studio.editor.view.erEditorView.Mode.OUTER)
            {
                f = f1 + f2;
            }
            int i = (int)f;
            view = Bitmap.createBitmap(bordereditorview.h.getWidth() + i * 2, bordereditorview.h.getHeight() + i * 2, android.graphics.ap.Config.ARGB_8888);
            Canvas canvas = new Canvas(view);
            canvas.translate(i, i);
            if (bordereditorview.e == com.picsart.studio.editor.view.erEditorView.Mode.OUTER)
            {
                bordereditorview.b(canvas);
            } else
            {
                bordereditorview.a(canvas);
            }
        }
        a.g.a(a, view, RasterAction.create(view, e.a().d.getHistoryDataDirectory()));
    }

    itorView.Mode(d d1)
    {
        a = d1;
        super();
    }
}

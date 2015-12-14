// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.collage.ShapeCropHelper;
import com.socialin.android.photo.collage.ShapeCropView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            v

final class a
    implements android.view..OnClickListener
{

    private v a;

    public final void onClick(View view)
    {
        ShapeCropView shapecropview;
        if (v.a(a) == com.socialin.android.photo.collage.eCropHelper.EditMode.MASK)
        {
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.EditShapeMaskEvent(true));
            e.a().e.d("shape_mask");
        } else
        {
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.EditToolsApplyEvent("tool_shape_crop"));
            e.a().e.c("shape_crop");
        }
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolShapeCropCloseEvent(e.a().e.a, "done", (int)v.f(a).d()));
        shapecropview = v.b(a);
        if (v.a(a) == com.socialin.android.photo.collage.eCropHelper.EditMode.CROP)
        {
            view = shapecropview.b();
        } else
        {
            Matrix matrix = new Matrix();
            matrix.setRectToRect(shapecropview.e, shapecropview.c, android.graphics.ix.ScaleToFit.CENTER);
            view = shapecropview.d.copy(android.graphics.ap.Config.ARGB_8888, true);
            if (view == null)
            {
                view = null;
            } else
            {
                Canvas canvas = new Canvas(view);
                canvas.concat(matrix);
                shapecropview.f.a(canvas, false);
            }
        }
        a.g.a(a, view, RasterAction.create(view, e.a().d.getHistoryDataDirectory()));
    }

    eCropHelper(v v1)
    {
        a = v1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.SvgCropView;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.c;
import com.socialin.android.util.l;
import myobfuscated.bk.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            z

final class a
    implements android.view..OnClickListener
{

    private z a;

    public final void onClick(View view)
    {
        e.a().e.d("svg_crop");
        view = com.picsart.studio.editor.fragment.z.a(a);
        Object obj = new RectF(0.0F, 0.0F, ((SvgCropView) (view)).e.a, ((SvgCropView) (view)).e.b);
        Object obj1 = new RectF();
        ((SvgCropView) (view)).h.mapRect(((RectF) (obj1)), ((RectF) (obj)));
        int i = (int)Math.max(((SvgCropView) (view)).d.getWidth(), ((RectF) (obj1)).width());
        int j = (int)Math.max(((SvgCropView) (view)).d.getHeight(), ((RectF) (obj1)).height());
        int k = (int)Math.min(((SvgCropView) (view)).d.getWidth(), ((RectF) (obj1)).width());
        int i1 = (int)Math.min(((SvgCropView) (view)).d.getHeight(), ((RectF) (obj1)).height());
        Matrix matrix = new Matrix(((SvgCropView) (view)).i.f);
        float f = 1.0F / l.a(matrix);
        matrix.postScale(f, f);
        ((SvgCropView) (view)).h.postScale(f, f);
        ((SvgCropView) (view)).h.mapRect(((RectF) (obj1)), ((RectF) (obj)));
        f = ((RectF) (obj1)).width();
        float f1 = ((RectF) (obj1)).height();
        float f3;
        float f4;
        Canvas canvas;
        if (f > (float)i)
        {
            float f2 = (float)i / f;
            f = f2;
            f1 *= f2;
        } else
        if (f < (float)k)
        {
            f3 = (float)k / f;
            f = f3;
            f1 *= f3;
        } else
        {
            f = 1.0F;
        }
        if (f1 <= (float)j) goto _L2; else goto _L1
_L1:
        f3 = f * ((float)j / f1);
_L4:
        matrix.postScale(f3, f3);
        ((SvgCropView) (view)).h.postScale(f3, f3);
        ((SvgCropView) (view)).h.mapRect(((RectF) (obj1)), ((RectF) (obj)));
        i = (int)((RectF) (obj1)).width();
        j = (int)((RectF) (obj1)).height();
        f = ((SvgCropView) (view)).f.left;
        f1 = ((RectF) (obj1)).left;
        f3 = ((SvgCropView) (view)).f.top;
        f4 = ((RectF) (obj1)).top;
        obj = new Path();
        ((Path) (obj)).addPath(view.a(), ((SvgCropView) (view)).h);
        obj1 = c.a(i, j, android.graphics.ap.Config.ARGB_8888, SvgCropView.a);
        canvas = new Canvas(((Bitmap) (obj1)));
        canvas.translate(f - f1, f3 - f4);
        canvas.save();
        canvas.clipPath(((Path) (obj)));
        canvas.drawBitmap(((SvgCropView) (view)).d, matrix, SvgCropView.b);
        canvas.restore();
        ((SvgCropView) (view)).e.a(canvas, ((SvgCropView) (view)).h);
        view.c = false;
        a.g.a(a, ((Bitmap) (obj1)), RasterAction.create(((Bitmap) (obj1)), e.a().d.getHistoryDataDirectory()));
        return;
_L2:
        f3 = f;
        if (f1 < (float)i1)
        {
            f3 = f * ((float)i1 / f1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    rAction(z z1)
    {
        a = z1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a extends ModernAsyncTask
{

    private SquareFitFragment a;

    protected final Object doInBackground(Object aobj[])
    {
        if (com.picsart.studio.editor.fragment.SquareFitFragment.c(a) == null)
        {
            return null;
        }
        aobj = com.picsart.studio.editor.fragment.SquareFitFragment.c(a);
        ((SquareFitEditorView) (aobj)).a();
        Object obj = ((SquareFitEditorView) (aobj)).b;
        Canvas canvas;
        boolean flag;
        if (((SquareFitEditorView) (aobj)).d % 90F != 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Paint) (obj)).setAntiAlias(flag);
        obj = Bitmap.createBitmap(((SquareFitEditorView) (aobj)).c, ((SquareFitEditorView) (aobj)).c, android.graphics._fld888);
        canvas = new Canvas(((Bitmap) (obj)));
        canvas.translate(-((SquareFitEditorView) (aobj)).k.left, -((SquareFitEditorView) (aobj)).k.top);
        ((SquareFitEditorView) (aobj)).a(canvas);
        canvas.save();
        canvas.rotate(((SquareFitEditorView) (aobj)).d, ((SquareFitEditorView) (aobj)).i.centerX(), ((SquareFitEditorView) (aobj)).i.centerY());
        canvas.drawBitmap(((SquareFitEditorView) (aobj)).a, null, ((SquareFitEditorView) (aobj)).i, ((SquareFitEditorView) (aobj)).b);
        canvas.restore();
        return obj;
    }

    protected final void onCancelled(Object obj)
    {
        obj = (Bitmap)obj;
        SquareFitFragment.x(a);
        if (obj != null && !((Bitmap) (obj)).isRecycled())
        {
            SquareFitFragment.b(((Bitmap) (obj)));
        }
    }

    protected final void onPostExecute(Object obj)
    {
        Bitmap bitmap;
label0:
        {
            bitmap = (Bitmap)obj;
            if (bitmap != null)
            {
                SquareFitFragment.b(a, bitmap);
                SquareFitFragment.G(a);
                SquareFitFragment.x(a);
                if (a.getActivity() == null || a.getActivity().isFinishing() || !a.isAdded())
                {
                    break label0;
                }
                if (!SquareFitFragment.w(a))
                {
                    e.a().e.d(Tool.SQUARE_FIT.toString().toLowerCase());
                }
                if (SquareFitFragment.g(a) != null)
                {
                    if (SquareFitFragment.w(a))
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.FitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "instagram_share_next", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, SquareFitFragment.g(a).getHeight(), SquareFitFragment.g(a).getWidth()));
                    } else
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.FitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "done", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, SquareFitFragment.g(a).getHeight(), SquareFitFragment.g(a).getWidth()));
                    }
                }
                if (!SquareFitFragment.H(a))
                {
                    c c1 = a.g;
                    SquareFitFragment squarefitfragment = a;
                    if (SquareFitFragment.w(a))
                    {
                        obj = null;
                    } else
                    {
                        obj = RasterAction.create(bitmap, e.a().d.getHistoryDataDirectory());
                    }
                    c1.a(squarefitfragment, bitmap, ((com.picsart.studio.editor.history.EditorAction) (obj)));
                }
            }
            return;
        }
        SquareFitFragment.b(bitmap);
    }

    itCloseEvent(SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}

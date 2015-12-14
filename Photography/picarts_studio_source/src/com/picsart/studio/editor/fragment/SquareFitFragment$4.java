// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.ValueAnimator;
import android.view.View;
import com.picsart.studio.editor.helper.f;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.socialin.android.util.Geom;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements android.view.
{

    private SquareFitFragment a;

    public final void onClick(View view)
    {
        view = SquareFitFragment.c(a);
        float f1 = Geom.b(((SquareFitEditorView) (view)).i, ((SquareFitEditorView) (view)).j);
        long l = (long)Math.max(200F, Math.min(4F * Math.abs(((SquareFitEditorView) (view)).d % 360F), f1 / 2.0F));
        if (((SquareFitEditorView) (view)).g == null && !((SquareFitEditorView) (view)).e)
        {
            view.g = ValueAnimator.ofFloat(new float[] {
                ((SquareFitEditorView) (view)).d, 0.0F
            });
            ((SquareFitEditorView) (view)).g.addUpdateListener(new com.picsart.studio.editor.view._cls1(view));
            ((SquareFitEditorView) (view)).g.addListener(new com.picsart.studio.editor.view._cls2(view));
            ((SquareFitEditorView) (view)).g.setDuration(l);
            ((SquareFitEditorView) (view)).g.start();
        }
        if (((SquareFitEditorView) (view)).h == null && !((SquareFitEditorView) (view)).f)
        {
            view.h = ValueAnimator.ofObject(new f(), new Object[] {
                ((SquareFitEditorView) (view)).i, ((SquareFitEditorView) (view)).j
            });
            ((SquareFitEditorView) (view)).h.addUpdateListener(new com.picsart.studio.editor.view._cls3(view));
            ((SquareFitEditorView) (view)).h.addListener(new com.picsart.studio.editor.view._cls4(view));
            ((SquareFitEditorView) (view)).h.setDuration(l);
            ((SquareFitEditorView) (view)).h.start();
        }
        SquareFitFragment.c(a).invalidate();
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}

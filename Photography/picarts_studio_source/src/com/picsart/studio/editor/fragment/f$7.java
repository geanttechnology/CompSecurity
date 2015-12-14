// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.CropAction;
import com.picsart.studio.editor.view.CropEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            f

final class a
    implements android.view..OnClickListener
{

    private f a;

    public final void onClick(View view)
    {
        view = com.picsart.studio.editor.fragment.f.e(a);
        if (!((CropEditorView) (view)).a)
        {
            view = CropAction.create(((CropEditorView) (view)).i, ((CropEditorView) (view)).e, ((CropEditorView) (view)).h, ((CropEditorView) (view)).o, ((CropEditorView) (view)).p);
        } else
        {
            view = null;
        }
        if (view != null)
        {
            Bitmap bitmap = view.apply(a.h);
            long l = (System.nanoTime() - f.j(a)) / 0x3b9aca00L;
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolCropCloseEvent(f.f(a), 0, com.picsart.studio.editor.fragment.f.e(a).getRotation(), f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), bitmap.getHeight(), bitmap.getWidth(), l, "done"));
            a.g.a(a, bitmap, view);
            if (a.getActivity() instanceof EditorActivity)
            {
                e.a().e.c("crop");
            }
        }
    }

    orActivity(f f1)
    {
        a = f1;
        super();
    }
}

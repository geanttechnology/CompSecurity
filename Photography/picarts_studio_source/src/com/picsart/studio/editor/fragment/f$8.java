// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
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
        if (!f.e(a).a())
        {
            view = AnalyticUtils.getInstance(a.getActivity());
            String s = f.f(a);
            CropEditorView cropeditorview = f.e(a);
            int i = cropeditorview.s + 1;
            cropeditorview.s = i;
            view.track(new com.socialin.android.apiv3.events.tsFactory.ToolCropTryEvent(s, i, f.e(a).getRotation(), f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), "reset_crop"));
            if (!f.h(a))
            {
                f.k(a).setActivated(false);
                f.i(a);
            }
            view = f.e(a);
            if (((CropEditorView) (view)).b == null && !((CropEditorView) (view)).a)
            {
                view.a(new com.picsart.studio.editor.view.EditorView._cls10(view));
            }
            f.a(a, false);
            f.a(a, 0);
            f.b(a, false);
        }
    }

    orView._cls10(f f1)
    {
        a = f1;
        super();
    }
}

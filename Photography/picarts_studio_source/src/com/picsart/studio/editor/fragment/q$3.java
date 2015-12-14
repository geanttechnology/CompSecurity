// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.SeekBar;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view..OnClickListener
{

    private q a;

    public final void onClick(View view)
    {
        if (q.a(a).h() instanceof LensFlareItem)
        {
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolLensFlareTryEvent(q.c, "lens_delete", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
        }
        q.a(a, q.a(a).h(), com.picsart.studio.editor.gizmo.o.Action.DELETE);
        q.a(a).i();
    }

    ction(q q1)
    {
        a = q1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.TransformAction;
import com.picsart.studio.editor.view.FlipRotateEditorView;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            aa

final class a
    implements android.view.OnClickListener
{

    private aa a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.sFactory.EditToolsApplyEvent("tool_flip_rotate"));
        e.a().e.c("flip_rotate");
        view = aa.b(a).g();
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.sFactory.ToolFlipRotateCloseEvent(e.a().e.a, "done", (int)aa.a(a).d()));
        a.g.a(a, view, TransformAction.create(aa.b(a).i));
    }

    ormAction(aa aa1)
    {
        a = aa1;
        super();
    }
}

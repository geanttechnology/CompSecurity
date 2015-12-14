// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.helper.c;
import com.picsart.studio.editor.history.EnhanceAction;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            k

final class a
    implements android.view..OnClickListener
{

    private k a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.EditToolsApplyEvent("tool_enhance"));
        e.a().e.c("enhance");
        view = a.h.copy(android.graphics.ap.Config.ARGB_8888, true);
        c c1 = new c(a.h, view);
        c1.a(com.picsart.studio.editor.fragment.k.c(a)[0], com.picsart.studio.editor.fragment.k.c(a)[1], com.picsart.studio.editor.fragment.k.c(a)[2]);
        c1.a();
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolEnhanceCloseEvent(e.a().e.a, "done", (int)k.f(a).d()));
        a.g.a(a, view, EnhanceAction.create(com.picsart.studio.editor.fragment.k.c(a)[0], com.picsart.studio.editor.fragment.k.c(a)[1], com.picsart.studio.editor.fragment.k.c(a)[2]));
    }

    ceAction(k k1)
    {
        a = k1;
        super();
    }
}

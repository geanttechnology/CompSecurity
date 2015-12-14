// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            g

final class a
    implements android.view..OnClickListener
{

    private g a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolCurvesCloseEvent(e.a().e.a, "cancel", (int)com.picsart.studio.editor.fragment.g.c(a).d()));
        a.g.a(a);
    }

    (g g1)
    {
        a = g1;
        super();
    }
}

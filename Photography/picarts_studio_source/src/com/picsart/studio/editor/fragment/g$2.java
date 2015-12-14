// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.view.RGBConvertView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            g

final class a
    implements android.view..OnClickListener
{

    private g a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.tsFactory.ToolCurvesTryEvent(e.a().e.a, "original"));
        view = g.b(a);
        view.a(((RGBConvertView) (view)).b);
        view.setTouchPointIndex(-1);
        g.b(a).a(g.b(a).b, false);
        g.b(a).invalidate();
    }

    rtView(g g1)
    {
        a = g1;
        super();
    }
}
